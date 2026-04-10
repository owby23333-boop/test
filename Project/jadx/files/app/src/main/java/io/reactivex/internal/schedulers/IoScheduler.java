package io.reactivex.internal.schedulers;

import io.reactivex.Scheduler;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.EmptyDisposable;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes3.dex */
public final class IoScheduler extends Scheduler {
    static final RxThreadFactory EVICTOR_THREAD_FACTORY;
    private static final String EVICTOR_THREAD_NAME_PREFIX = "RxCachedWorkerPoolEvictor";
    public static final long KEEP_ALIVE_TIME_DEFAULT = 60;
    private static final String KEY_IO_PRIORITY = "rx2.io-priority";
    static final CachedWorkerPool NONE;
    static final RxThreadFactory WORKER_THREAD_FACTORY;
    private static final String WORKER_THREAD_NAME_PREFIX = "RxCachedThreadScheduler";
    final AtomicReference<CachedWorkerPool> pool;
    final ThreadFactory threadFactory;
    private static final TimeUnit KEEP_ALIVE_UNIT = TimeUnit.SECONDS;
    private static final String KEY_KEEP_ALIVE_TIME = "rx2.io-keep-alive-time";
    private static final long KEEP_ALIVE_TIME = Long.getLong(KEY_KEEP_ALIVE_TIME, 60).longValue();
    static final ThreadWorker SHUTDOWN_THREAD_WORKER = new ThreadWorker(new RxThreadFactory("RxCachedThreadSchedulerShutdown"));

    static final class CachedWorkerPool implements Runnable {
        final CompositeDisposable allWorkers;
        private final ScheduledExecutorService evictorService;
        private final Future<?> evictorTask;
        private final ConcurrentLinkedQueue<ThreadWorker> expiringWorkerQueue;
        private final long keepAliveTime;
        private final ThreadFactory threadFactory;

        CachedWorkerPool(long j2, TimeUnit timeUnit, ThreadFactory threadFactory) {
            ScheduledFuture<?> scheduledFutureScheduleWithFixedDelay;
            this.keepAliveTime = timeUnit != null ? timeUnit.toNanos(j2) : 0L;
            this.expiringWorkerQueue = new ConcurrentLinkedQueue<>();
            this.allWorkers = new CompositeDisposable();
            this.threadFactory = threadFactory;
            ScheduledExecutorService scheduledExecutorServiceNewScheduledThreadPool = null;
            if (timeUnit != null) {
                scheduledExecutorServiceNewScheduledThreadPool = Executors.newScheduledThreadPool(1, IoScheduler.EVICTOR_THREAD_FACTORY);
                long j3 = this.keepAliveTime;
                scheduledFutureScheduleWithFixedDelay = scheduledExecutorServiceNewScheduledThreadPool.scheduleWithFixedDelay(this, j3, j3, TimeUnit.NANOSECONDS);
            } else {
                scheduledFutureScheduleWithFixedDelay = null;
            }
            this.evictorService = scheduledExecutorServiceNewScheduledThreadPool;
            this.evictorTask = scheduledFutureScheduleWithFixedDelay;
        }

        void evictExpiredWorkers() {
            if (this.expiringWorkerQueue.isEmpty()) {
                return;
            }
            long jNow = now();
            for (ThreadWorker threadWorker : this.expiringWorkerQueue) {
                if (threadWorker.getExpirationTime() > jNow) {
                    return;
                }
                if (this.expiringWorkerQueue.remove(threadWorker)) {
                    this.allWorkers.remove(threadWorker);
                }
            }
        }

        ThreadWorker get() {
            if (this.allWorkers.isDisposed()) {
                return IoScheduler.SHUTDOWN_THREAD_WORKER;
            }
            while (!this.expiringWorkerQueue.isEmpty()) {
                ThreadWorker threadWorkerPoll = this.expiringWorkerQueue.poll();
                if (threadWorkerPoll != null) {
                    return threadWorkerPoll;
                }
            }
            ThreadWorker threadWorker = new ThreadWorker(this.threadFactory);
            this.allWorkers.add(threadWorker);
            return threadWorker;
        }

        long now() {
            return System.nanoTime();
        }

        void release(ThreadWorker threadWorker) {
            threadWorker.setExpirationTime(now() + this.keepAliveTime);
            this.expiringWorkerQueue.offer(threadWorker);
        }

        @Override // java.lang.Runnable
        public void run() {
            evictExpiredWorkers();
        }

        void shutdown() {
            this.allWorkers.dispose();
            Future<?> future = this.evictorTask;
            if (future != null) {
                future.cancel(true);
            }
            ScheduledExecutorService scheduledExecutorService = this.evictorService;
            if (scheduledExecutorService != null) {
                scheduledExecutorService.shutdownNow();
            }
        }
    }

    static final class EventLoopWorker extends Scheduler.Worker {
        private final CachedWorkerPool pool;
        private final ThreadWorker threadWorker;
        final AtomicBoolean once = new AtomicBoolean();
        private final CompositeDisposable tasks = new CompositeDisposable();

        EventLoopWorker(CachedWorkerPool cachedWorkerPool) {
            this.pool = cachedWorkerPool;
            this.threadWorker = cachedWorkerPool.get();
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            if (this.once.compareAndSet(false, true)) {
                this.tasks.dispose();
                this.pool.release(this.threadWorker);
            }
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean isDisposed() {
            return this.once.get();
        }

        @Override // io.reactivex.Scheduler.Worker
        @NonNull
        public Disposable schedule(@NonNull Runnable runnable, long j2, @NonNull TimeUnit timeUnit) {
            return this.tasks.isDisposed() ? EmptyDisposable.INSTANCE : this.threadWorker.scheduleActual(runnable, j2, timeUnit, this.tasks);
        }
    }

    static final class ThreadWorker extends NewThreadWorker {
        private long expirationTime;

        ThreadWorker(ThreadFactory threadFactory) {
            super(threadFactory);
            this.expirationTime = 0L;
        }

        public long getExpirationTime() {
            return this.expirationTime;
        }

        public void setExpirationTime(long j2) {
            this.expirationTime = j2;
        }
    }

    static {
        SHUTDOWN_THREAD_WORKER.dispose();
        int iMax = Math.max(1, Math.min(10, Integer.getInteger(KEY_IO_PRIORITY, 5).intValue()));
        WORKER_THREAD_FACTORY = new RxThreadFactory(WORKER_THREAD_NAME_PREFIX, iMax);
        EVICTOR_THREAD_FACTORY = new RxThreadFactory(EVICTOR_THREAD_NAME_PREFIX, iMax);
        NONE = new CachedWorkerPool(0L, null, WORKER_THREAD_FACTORY);
        NONE.shutdown();
    }

    public IoScheduler() {
        this(WORKER_THREAD_FACTORY);
    }

    @Override // io.reactivex.Scheduler
    @NonNull
    public Scheduler.Worker createWorker() {
        return new EventLoopWorker(this.pool.get());
    }

    @Override // io.reactivex.Scheduler
    public void shutdown() {
        CachedWorkerPool cachedWorkerPool;
        CachedWorkerPool cachedWorkerPool2;
        do {
            cachedWorkerPool = this.pool.get();
            cachedWorkerPool2 = NONE;
            if (cachedWorkerPool == cachedWorkerPool2) {
                return;
            }
        } while (!this.pool.compareAndSet(cachedWorkerPool, cachedWorkerPool2));
        cachedWorkerPool.shutdown();
    }

    public int size() {
        return this.pool.get().allWorkers.size();
    }

    @Override // io.reactivex.Scheduler
    public void start() {
        CachedWorkerPool cachedWorkerPool = new CachedWorkerPool(KEEP_ALIVE_TIME, KEEP_ALIVE_UNIT, this.threadFactory);
        if (this.pool.compareAndSet(NONE, cachedWorkerPool)) {
            return;
        }
        cachedWorkerPool.shutdown();
    }

    public IoScheduler(ThreadFactory threadFactory) {
        this.threadFactory = threadFactory;
        this.pool = new AtomicReference<>(NONE);
        start();
    }
}
