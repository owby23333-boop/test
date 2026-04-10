package io.reactivex;

import io.reactivex.annotations.NonNull;
import io.reactivex.annotations.Nullable;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Function;
import io.reactivex.internal.disposables.EmptyDisposable;
import io.reactivex.internal.disposables.SequentialDisposable;
import io.reactivex.internal.schedulers.NewThreadWorker;
import io.reactivex.internal.schedulers.SchedulerWhen;
import io.reactivex.internal.util.ExceptionHelper;
import io.reactivex.plugins.RxJavaPlugins;
import io.reactivex.schedulers.SchedulerRunnableIntrospection;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes3.dex */
public abstract class Scheduler {
    static final long CLOCK_DRIFT_TOLERANCE_NANOSECONDS = TimeUnit.MINUTES.toNanos(Long.getLong("rx2.scheduler.drift-tolerance", 15).longValue());

    static final class DisposeTask implements Disposable, Runnable, SchedulerRunnableIntrospection {

        @NonNull
        final Runnable decoratedRun;

        @Nullable
        Thread runner;

        /* JADX INFO: renamed from: w, reason: collision with root package name */
        @NonNull
        final Worker f20870w;

        DisposeTask(@NonNull Runnable runnable, @NonNull Worker worker) {
            this.decoratedRun = runnable;
            this.f20870w = worker;
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            if (this.runner == Thread.currentThread()) {
                Worker worker = this.f20870w;
                if (worker instanceof NewThreadWorker) {
                    ((NewThreadWorker) worker).shutdown();
                    return;
                }
            }
            this.f20870w.dispose();
        }

        @Override // io.reactivex.schedulers.SchedulerRunnableIntrospection
        public Runnable getWrappedRunnable() {
            return this.decoratedRun;
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean isDisposed() {
            return this.f20870w.isDisposed();
        }

        @Override // java.lang.Runnable
        public void run() {
            this.runner = Thread.currentThread();
            try {
                this.decoratedRun.run();
            } finally {
                dispose();
                this.runner = null;
            }
        }
    }

    static final class PeriodicDirectTask implements Disposable, Runnable, SchedulerRunnableIntrospection {
        volatile boolean disposed;

        @NonNull
        final Runnable run;

        @NonNull
        final Worker worker;

        PeriodicDirectTask(@NonNull Runnable runnable, @NonNull Worker worker) {
            this.run = runnable;
            this.worker = worker;
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            this.disposed = true;
            this.worker.dispose();
        }

        @Override // io.reactivex.schedulers.SchedulerRunnableIntrospection
        public Runnable getWrappedRunnable() {
            return this.run;
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean isDisposed() {
            return this.disposed;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.disposed) {
                return;
            }
            try {
                this.run.run();
            } catch (Throwable th) {
                Exceptions.throwIfFatal(th);
                this.worker.dispose();
                throw ExceptionHelper.wrapOrThrow(th);
            }
        }
    }

    public static abstract class Worker implements Disposable {

        final class PeriodicTask implements Runnable, SchedulerRunnableIntrospection {
            long count;

            @NonNull
            final Runnable decoratedRun;
            long lastNowNanoseconds;
            final long periodInNanoseconds;

            @NonNull
            final SequentialDisposable sd;
            long startInNanoseconds;

            PeriodicTask(long j2, @NonNull Runnable runnable, long j3, @NonNull SequentialDisposable sequentialDisposable, long j4) {
                this.decoratedRun = runnable;
                this.sd = sequentialDisposable;
                this.periodInNanoseconds = j4;
                this.lastNowNanoseconds = j3;
                this.startInNanoseconds = j2;
            }

            @Override // io.reactivex.schedulers.SchedulerRunnableIntrospection
            public Runnable getWrappedRunnable() {
                return this.decoratedRun;
            }

            /* JADX WARN: Removed duplicated region for block: B:10:0x0035  */
            @Override // java.lang.Runnable
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct code enable 'Show inconsistent code' option in preferences
            */
            public void run() {
                /*
                    r11 = this;
                    java.lang.Runnable r0 = r11.decoratedRun
                    r0.run()
                    io.reactivex.internal.disposables.SequentialDisposable r0 = r11.sd
                    boolean r0 = r0.isDisposed()
                    if (r0 != 0) goto L55
                    io.reactivex.Scheduler$Worker r0 = io.reactivex.Scheduler.Worker.this
                    java.util.concurrent.TimeUnit r1 = java.util.concurrent.TimeUnit.NANOSECONDS
                    long r0 = r0.now(r1)
                    long r2 = io.reactivex.Scheduler.CLOCK_DRIFT_TOLERANCE_NANOSECONDS
                    long r4 = r0 + r2
                    long r6 = r11.lastNowNanoseconds
                    r8 = 1
                    int r10 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
                    if (r10 < 0) goto L35
                    long r4 = r11.periodInNanoseconds
                    long r6 = r6 + r4
                    long r6 = r6 + r2
                    int r2 = (r0 > r6 ? 1 : (r0 == r6 ? 0 : -1))
                    if (r2 < 0) goto L2a
                    goto L35
                L2a:
                    long r2 = r11.startInNanoseconds
                    long r6 = r11.count
                    long r6 = r6 + r8
                    r11.count = r6
                    long r6 = r6 * r4
                    long r2 = r2 + r6
                    goto L45
                L35:
                    long r2 = r11.periodInNanoseconds
                    long r4 = r0 + r2
                    long r6 = r11.count
                    long r6 = r6 + r8
                    r11.count = r6
                    long r2 = r2 * r6
                    long r2 = r4 - r2
                    r11.startInNanoseconds = r2
                    r2 = r4
                L45:
                    r11.lastNowNanoseconds = r0
                    long r2 = r2 - r0
                    io.reactivex.internal.disposables.SequentialDisposable r0 = r11.sd
                    io.reactivex.Scheduler$Worker r1 = io.reactivex.Scheduler.Worker.this
                    java.util.concurrent.TimeUnit r4 = java.util.concurrent.TimeUnit.NANOSECONDS
                    io.reactivex.disposables.Disposable r1 = r1.schedule(r11, r2, r4)
                    r0.replace(r1)
                L55:
                    return
                */
                throw new UnsupportedOperationException("Method not decompiled: io.reactivex.Scheduler.Worker.PeriodicTask.run():void");
            }
        }

        public long now(@NonNull TimeUnit timeUnit) {
            return timeUnit.convert(System.currentTimeMillis(), TimeUnit.MILLISECONDS);
        }

        @NonNull
        public Disposable schedule(@NonNull Runnable runnable) {
            return schedule(runnable, 0L, TimeUnit.NANOSECONDS);
        }

        @NonNull
        public abstract Disposable schedule(@NonNull Runnable runnable, long j2, @NonNull TimeUnit timeUnit);

        @NonNull
        public Disposable schedulePeriodically(@NonNull Runnable runnable, long j2, long j3, @NonNull TimeUnit timeUnit) {
            SequentialDisposable sequentialDisposable = new SequentialDisposable();
            SequentialDisposable sequentialDisposable2 = new SequentialDisposable(sequentialDisposable);
            Runnable runnableOnSchedule = RxJavaPlugins.onSchedule(runnable);
            long nanos = timeUnit.toNanos(j3);
            long jNow = now(TimeUnit.NANOSECONDS);
            Disposable disposableSchedule = schedule(new PeriodicTask(jNow + timeUnit.toNanos(j2), runnableOnSchedule, jNow, sequentialDisposable2, nanos), j2, timeUnit);
            if (disposableSchedule == EmptyDisposable.INSTANCE) {
                return disposableSchedule;
            }
            sequentialDisposable.replace(disposableSchedule);
            return sequentialDisposable2;
        }
    }

    public static long clockDriftTolerance() {
        return CLOCK_DRIFT_TOLERANCE_NANOSECONDS;
    }

    @NonNull
    public abstract Worker createWorker();

    public long now(@NonNull TimeUnit timeUnit) {
        return timeUnit.convert(System.currentTimeMillis(), TimeUnit.MILLISECONDS);
    }

    @NonNull
    public Disposable scheduleDirect(@NonNull Runnable runnable) {
        return scheduleDirect(runnable, 0L, TimeUnit.NANOSECONDS);
    }

    @NonNull
    public Disposable schedulePeriodicallyDirect(@NonNull Runnable runnable, long j2, long j3, @NonNull TimeUnit timeUnit) {
        Worker workerCreateWorker = createWorker();
        PeriodicDirectTask periodicDirectTask = new PeriodicDirectTask(RxJavaPlugins.onSchedule(runnable), workerCreateWorker);
        Disposable disposableSchedulePeriodically = workerCreateWorker.schedulePeriodically(periodicDirectTask, j2, j3, timeUnit);
        return disposableSchedulePeriodically == EmptyDisposable.INSTANCE ? disposableSchedulePeriodically : periodicDirectTask;
    }

    public void shutdown() {
    }

    public void start() {
    }

    @NonNull
    public <S extends Scheduler & Disposable> S when(@NonNull Function<Flowable<Flowable<Completable>>, Completable> function) {
        return new SchedulerWhen(function, this);
    }

    @NonNull
    public Disposable scheduleDirect(@NonNull Runnable runnable, long j2, @NonNull TimeUnit timeUnit) {
        Worker workerCreateWorker = createWorker();
        DisposeTask disposeTask = new DisposeTask(RxJavaPlugins.onSchedule(runnable), workerCreateWorker);
        workerCreateWorker.schedule(disposeTask, j2, timeUnit);
        return disposeTask;
    }
}
