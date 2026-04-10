package com.bytedance.sdk.component.uy;

import java.util.Collection;
import java.util.List;
import java.util.concurrent.AbstractExecutorService;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/* JADX INFO: loaded from: classes2.dex */
public class dl {
    public static ExecutorService z(ThreadFactory threadFactory) {
        return new C0142dl(new com.bytedance.sdk.component.uy.a.a(1, 1, 0L, TimeUnit.MILLISECONDS, new LinkedBlockingQueue(), threadFactory));
    }

    public static ExecutorService g(ThreadFactory threadFactory) {
        return new com.bytedance.sdk.component.uy.a.a(0, Integer.MAX_VALUE, 60L, TimeUnit.SECONDS, new SynchronousQueue(), threadFactory);
    }

    public static ScheduledExecutorService dl(ThreadFactory threadFactory) {
        return new g(new ScheduledThreadPoolExecutor(1, threadFactory));
    }

    public static ScheduledExecutorService z(int i, ThreadFactory threadFactory) {
        return new com.bytedance.sdk.component.uy.a.gc(i, threadFactory);
    }

    protected static class z extends AbstractExecutorService {
        private final ExecutorService z;

        z(ExecutorService executorService) {
            this.z = executorService;
        }

        @Override // java.util.concurrent.Executor
        public void execute(Runnable runnable) {
            this.z.execute(runnable);
        }

        @Override // java.util.concurrent.ExecutorService
        public void shutdown() {
            this.z.shutdown();
        }

        @Override // java.util.concurrent.ExecutorService
        public List<Runnable> shutdownNow() {
            return this.z.shutdownNow();
        }

        @Override // java.util.concurrent.ExecutorService
        public boolean isShutdown() {
            return this.z.isShutdown();
        }

        @Override // java.util.concurrent.ExecutorService
        public boolean isTerminated() {
            return this.z.isTerminated();
        }

        @Override // java.util.concurrent.ExecutorService
        public boolean awaitTermination(long j, TimeUnit timeUnit) throws InterruptedException {
            return this.z.awaitTermination(j, timeUnit);
        }

        @Override // java.util.concurrent.AbstractExecutorService, java.util.concurrent.ExecutorService
        public Future<?> submit(Runnable runnable) {
            return this.z.submit(runnable);
        }

        @Override // java.util.concurrent.AbstractExecutorService, java.util.concurrent.ExecutorService
        public <T> Future<T> submit(Callable<T> callable) {
            return this.z.submit(callable);
        }

        @Override // java.util.concurrent.AbstractExecutorService, java.util.concurrent.ExecutorService
        public <T> Future<T> submit(Runnable runnable, T t) {
            return this.z.submit(runnable, t);
        }

        @Override // java.util.concurrent.AbstractExecutorService, java.util.concurrent.ExecutorService
        public <T> List<Future<T>> invokeAll(Collection<? extends Callable<T>> collection) throws InterruptedException {
            return this.z.invokeAll(collection);
        }

        @Override // java.util.concurrent.AbstractExecutorService, java.util.concurrent.ExecutorService
        public <T> List<Future<T>> invokeAll(Collection<? extends Callable<T>> collection, long j, TimeUnit timeUnit) throws InterruptedException {
            return this.z.invokeAll(collection, j, timeUnit);
        }

        @Override // java.util.concurrent.AbstractExecutorService, java.util.concurrent.ExecutorService
        public <T> T invokeAny(Collection<? extends Callable<T>> collection) throws ExecutionException, InterruptedException {
            return (T) this.z.invokeAny(collection);
        }

        @Override // java.util.concurrent.AbstractExecutorService, java.util.concurrent.ExecutorService
        public <T> T invokeAny(Collection<? extends Callable<T>> collection, long j, TimeUnit timeUnit) throws ExecutionException, InterruptedException, TimeoutException {
            return (T) this.z.invokeAny(collection, j, timeUnit);
        }
    }

    /* JADX INFO: renamed from: com.bytedance.sdk.component.uy.dl$dl, reason: collision with other inner class name */
    protected static class C0142dl extends z {
        C0142dl(ExecutorService executorService) {
            super(executorService);
        }

        protected void finalize() {
            super.shutdown();
        }
    }

    protected static class g extends z implements ScheduledExecutorService {
        private final ScheduledExecutorService z;

        g(ScheduledExecutorService scheduledExecutorService) {
            super(scheduledExecutorService);
            this.z = scheduledExecutorService;
        }

        @Override // java.util.concurrent.ScheduledExecutorService
        public ScheduledFuture<?> schedule(Runnable runnable, long j, TimeUnit timeUnit) {
            return this.z.schedule(runnable, j, timeUnit);
        }

        @Override // java.util.concurrent.ScheduledExecutorService
        public <V> ScheduledFuture<V> schedule(Callable<V> callable, long j, TimeUnit timeUnit) {
            return this.z.schedule(callable, j, timeUnit);
        }

        @Override // java.util.concurrent.ScheduledExecutorService
        public ScheduledFuture<?> scheduleAtFixedRate(Runnable runnable, long j, long j2, TimeUnit timeUnit) {
            return this.z.scheduleAtFixedRate(runnable, j, j2, timeUnit);
        }

        @Override // java.util.concurrent.ScheduledExecutorService
        public ScheduledFuture<?> scheduleWithFixedDelay(Runnable runnable, long j, long j2, TimeUnit timeUnit) {
            return this.z.scheduleWithFixedDelay(runnable, j, j2, timeUnit);
        }
    }
}
