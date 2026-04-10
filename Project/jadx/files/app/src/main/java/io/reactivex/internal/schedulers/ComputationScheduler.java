package io.reactivex.internal.schedulers;

import io.reactivex.Scheduler;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.EmptyDisposable;
import io.reactivex.internal.disposables.ListCompositeDisposable;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.schedulers.SchedulerMultiWorkerSupport;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes3.dex */
public final class ComputationScheduler extends Scheduler implements SchedulerMultiWorkerSupport {
    private static final String KEY_COMPUTATION_PRIORITY = "rx2.computation-priority";
    static final FixedSchedulerPool NONE;
    static final RxThreadFactory THREAD_FACTORY;
    private static final String THREAD_NAME_PREFIX = "RxComputationThreadPool";
    final AtomicReference<FixedSchedulerPool> pool;
    final ThreadFactory threadFactory;
    static final String KEY_MAX_THREADS = "rx2.computation-threads";
    static final int MAX_THREADS = cap(Runtime.getRuntime().availableProcessors(), Integer.getInteger(KEY_MAX_THREADS, 0).intValue());
    static final PoolWorker SHUTDOWN_WORKER = new PoolWorker(new RxThreadFactory("RxComputationShutdown"));

    static final class FixedSchedulerPool implements SchedulerMultiWorkerSupport {
        final int cores;
        final PoolWorker[] eventLoops;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        long f20911n;

        FixedSchedulerPool(int i2, ThreadFactory threadFactory) {
            this.cores = i2;
            this.eventLoops = new PoolWorker[i2];
            for (int i3 = 0; i3 < i2; i3++) {
                this.eventLoops[i3] = new PoolWorker(threadFactory);
            }
        }

        @Override // io.reactivex.internal.schedulers.SchedulerMultiWorkerSupport
        public void createWorkers(int i2, SchedulerMultiWorkerSupport.WorkerCallback workerCallback) {
            int i3 = this.cores;
            if (i3 == 0) {
                for (int i4 = 0; i4 < i2; i4++) {
                    workerCallback.onWorker(i4, ComputationScheduler.SHUTDOWN_WORKER);
                }
                return;
            }
            int i5 = ((int) this.f20911n) % i3;
            for (int i6 = 0; i6 < i2; i6++) {
                workerCallback.onWorker(i6, new EventLoopWorker(this.eventLoops[i5]));
                i5++;
                if (i5 == i3) {
                    i5 = 0;
                }
            }
            this.f20911n = i5;
        }

        public PoolWorker getEventLoop() {
            int i2 = this.cores;
            if (i2 == 0) {
                return ComputationScheduler.SHUTDOWN_WORKER;
            }
            PoolWorker[] poolWorkerArr = this.eventLoops;
            long j2 = this.f20911n;
            this.f20911n = 1 + j2;
            return poolWorkerArr[(int) (j2 % ((long) i2))];
        }

        public void shutdown() {
            for (PoolWorker poolWorker : this.eventLoops) {
                poolWorker.dispose();
            }
        }
    }

    static final class PoolWorker extends NewThreadWorker {
        PoolWorker(ThreadFactory threadFactory) {
            super(threadFactory);
        }
    }

    static {
        SHUTDOWN_WORKER.dispose();
        THREAD_FACTORY = new RxThreadFactory(THREAD_NAME_PREFIX, Math.max(1, Math.min(10, Integer.getInteger(KEY_COMPUTATION_PRIORITY, 5).intValue())), true);
        NONE = new FixedSchedulerPool(0, THREAD_FACTORY);
        NONE.shutdown();
    }

    public ComputationScheduler() {
        this(THREAD_FACTORY);
    }

    static int cap(int i2, int i3) {
        return (i3 <= 0 || i3 > i2) ? i2 : i3;
    }

    @Override // io.reactivex.Scheduler
    @NonNull
    public Scheduler.Worker createWorker() {
        return new EventLoopWorker(this.pool.get().getEventLoop());
    }

    @Override // io.reactivex.internal.schedulers.SchedulerMultiWorkerSupport
    public void createWorkers(int i2, SchedulerMultiWorkerSupport.WorkerCallback workerCallback) {
        ObjectHelper.verifyPositive(i2, "number > 0 required");
        this.pool.get().createWorkers(i2, workerCallback);
    }

    @Override // io.reactivex.Scheduler
    @NonNull
    public Disposable scheduleDirect(@NonNull Runnable runnable, long j2, TimeUnit timeUnit) {
        return this.pool.get().getEventLoop().scheduleDirect(runnable, j2, timeUnit);
    }

    @Override // io.reactivex.Scheduler
    @NonNull
    public Disposable schedulePeriodicallyDirect(@NonNull Runnable runnable, long j2, long j3, TimeUnit timeUnit) {
        return this.pool.get().getEventLoop().schedulePeriodicallyDirect(runnable, j2, j3, timeUnit);
    }

    @Override // io.reactivex.Scheduler
    public void shutdown() {
        FixedSchedulerPool fixedSchedulerPool;
        FixedSchedulerPool fixedSchedulerPool2;
        do {
            fixedSchedulerPool = this.pool.get();
            fixedSchedulerPool2 = NONE;
            if (fixedSchedulerPool == fixedSchedulerPool2) {
                return;
            }
        } while (!this.pool.compareAndSet(fixedSchedulerPool, fixedSchedulerPool2));
        fixedSchedulerPool.shutdown();
    }

    @Override // io.reactivex.Scheduler
    public void start() {
        FixedSchedulerPool fixedSchedulerPool = new FixedSchedulerPool(MAX_THREADS, this.threadFactory);
        if (this.pool.compareAndSet(NONE, fixedSchedulerPool)) {
            return;
        }
        fixedSchedulerPool.shutdown();
    }

    public ComputationScheduler(ThreadFactory threadFactory) {
        this.threadFactory = threadFactory;
        this.pool = new AtomicReference<>(NONE);
        start();
    }

    static final class EventLoopWorker extends Scheduler.Worker {
        volatile boolean disposed;
        private final PoolWorker poolWorker;
        private final ListCompositeDisposable serial = new ListCompositeDisposable();
        private final CompositeDisposable timed = new CompositeDisposable();
        private final ListCompositeDisposable both = new ListCompositeDisposable();

        EventLoopWorker(PoolWorker poolWorker) {
            this.poolWorker = poolWorker;
            this.both.add(this.serial);
            this.both.add(this.timed);
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            if (this.disposed) {
                return;
            }
            this.disposed = true;
            this.both.dispose();
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean isDisposed() {
            return this.disposed;
        }

        @Override // io.reactivex.Scheduler.Worker
        @NonNull
        public Disposable schedule(@NonNull Runnable runnable) {
            return this.disposed ? EmptyDisposable.INSTANCE : this.poolWorker.scheduleActual(runnable, 0L, TimeUnit.MILLISECONDS, this.serial);
        }

        @Override // io.reactivex.Scheduler.Worker
        @NonNull
        public Disposable schedule(@NonNull Runnable runnable, long j2, @NonNull TimeUnit timeUnit) {
            if (this.disposed) {
                return EmptyDisposable.INSTANCE;
            }
            return this.poolWorker.scheduleActual(runnable, j2, timeUnit, this.timed);
        }
    }
}
