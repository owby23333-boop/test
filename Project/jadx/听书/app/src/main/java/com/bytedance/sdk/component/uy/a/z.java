package com.bytedance.sdk.component.uy.a;

import com.bytedance.sdk.component.uy.kb;
import com.bytedance.sdk.component.uy.z.m;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Callable;
import java.util.concurrent.Future;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes2.dex */
public class z extends ThreadPoolExecutor implements com.bytedance.sdk.component.uy.g {
    public static final RejectedExecutionHandler z = new RejectedExecutionHandler() { // from class: com.bytedance.sdk.component.uy.a.z.1
        @Override // java.util.concurrent.RejectedExecutionHandler
        public void rejectedExecution(Runnable runnable, ThreadPoolExecutor threadPoolExecutor) {
            if (threadPoolExecutor != null && (threadPoolExecutor instanceof ScheduledThreadPoolExecutor) && threadPoolExecutor.getCorePoolSize() == 1) {
                ScheduledExecutorService scheduledExecutorServiceWp = kb.g.wp();
                if (scheduledExecutorServiceWp.isShutdown() || scheduledExecutorServiceWp.isTerminated()) {
                    kb.g.fo().execute(runnable);
                } else {
                    scheduledExecutorServiceWp.execute(runnable);
                }
            } else {
                kb.g.fo().execute(runnable);
            }
            kb.g.e();
        }
    };
    private com.bytedance.sdk.component.uy.g g;

    public z(int i, int i2, long j, TimeUnit timeUnit, BlockingQueue<Runnable> blockingQueue, ThreadFactory threadFactory) {
        this(i, i2, j, timeUnit, blockingQueue, threadFactory, z);
    }

    public z(int i, int i2, long j, TimeUnit timeUnit, BlockingQueue<Runnable> blockingQueue, ThreadFactory threadFactory, RejectedExecutionHandler rejectedExecutionHandler) {
        super(i, i2, j, timeUnit, blockingQueue, threadFactory, rejectedExecutionHandler);
        this.g = new m(i, i2, j, timeUnit, blockingQueue, threadFactory, rejectedExecutionHandler, this);
        kb.g.e();
    }

    @Override // java.util.concurrent.ThreadPoolExecutor, java.util.concurrent.Executor, com.bytedance.sdk.component.uy.g
    public void execute(Runnable runnable) {
        this.g.execute(runnable);
    }

    @Override // java.util.concurrent.AbstractExecutorService, java.util.concurrent.ExecutorService, com.bytedance.sdk.component.uy.g
    public Future<?> submit(Runnable runnable) {
        return this.g.submit(runnable);
    }

    @Override // java.util.concurrent.AbstractExecutorService, java.util.concurrent.ExecutorService, com.bytedance.sdk.component.uy.g
    public <T> Future<T> submit(Callable<T> callable) {
        return this.g.submit(callable);
    }

    @Override // java.util.concurrent.AbstractExecutorService, java.util.concurrent.ExecutorService, com.bytedance.sdk.component.uy.g
    public <T> Future<T> submit(Runnable runnable, T t) {
        return this.g.submit(runnable, t);
    }

    @Override // java.util.concurrent.ThreadPoolExecutor, java.util.concurrent.ExecutorService, com.bytedance.sdk.component.uy.g
    public void shutdown() {
        this.g.shutdown();
    }

    @Override // java.util.concurrent.ThreadPoolExecutor, java.util.concurrent.ExecutorService, com.bytedance.sdk.component.uy.g
    public List<Runnable> shutdownNow() {
        return this.g.shutdownNow();
    }

    @Override // java.util.concurrent.ThreadPoolExecutor, java.util.concurrent.ExecutorService, com.bytedance.sdk.component.uy.g
    public boolean isShutdown() {
        return this.g.isShutdown();
    }

    @Override // java.util.concurrent.ThreadPoolExecutor, com.bytedance.sdk.component.uy.g
    public boolean isTerminating() {
        return this.g.isTerminating();
    }

    @Override // java.util.concurrent.ThreadPoolExecutor, java.util.concurrent.ExecutorService, com.bytedance.sdk.component.uy.g
    public boolean isTerminated() {
        return this.g.isTerminated();
    }

    @Override // java.util.concurrent.ThreadPoolExecutor, java.util.concurrent.ExecutorService, com.bytedance.sdk.component.uy.g
    public boolean awaitTermination(long j, TimeUnit timeUnit) throws InterruptedException {
        return this.g.awaitTermination(j, timeUnit);
    }

    @Override // java.util.concurrent.ThreadPoolExecutor, com.bytedance.sdk.component.uy.g
    public void setThreadFactory(ThreadFactory threadFactory) {
        threadFactory.getClass();
        this.g.setThreadFactory(threadFactory);
    }

    @Override // java.util.concurrent.ThreadPoolExecutor, com.bytedance.sdk.component.uy.g
    public ThreadFactory getThreadFactory() {
        return this.g.getThreadFactory();
    }

    @Override // java.util.concurrent.ThreadPoolExecutor, com.bytedance.sdk.component.uy.g
    public void setRejectedExecutionHandler(RejectedExecutionHandler rejectedExecutionHandler) {
        this.g.setRejectedExecutionHandler(rejectedExecutionHandler);
    }

    @Override // java.util.concurrent.ThreadPoolExecutor, com.bytedance.sdk.component.uy.g
    public RejectedExecutionHandler getRejectedExecutionHandler() {
        return this.g.getRejectedExecutionHandler();
    }

    @Override // java.util.concurrent.ThreadPoolExecutor, com.bytedance.sdk.component.uy.g
    public void setCorePoolSize(int i) {
        this.g.setCorePoolSize(i);
    }

    @Override // java.util.concurrent.ThreadPoolExecutor, com.bytedance.sdk.component.uy.g
    public int getCorePoolSize() {
        return this.g.getCorePoolSize();
    }

    @Override // java.util.concurrent.ThreadPoolExecutor, com.bytedance.sdk.component.uy.g
    public boolean prestartCoreThread() {
        return this.g.prestartCoreThread();
    }

    @Override // java.util.concurrent.ThreadPoolExecutor, com.bytedance.sdk.component.uy.g
    public int prestartAllCoreThreads() {
        return this.g.prestartAllCoreThreads();
    }

    @Override // java.util.concurrent.ThreadPoolExecutor, com.bytedance.sdk.component.uy.g
    public boolean allowsCoreThreadTimeOut() {
        return this.g.allowsCoreThreadTimeOut();
    }

    @Override // java.util.concurrent.ThreadPoolExecutor, com.bytedance.sdk.component.uy.g
    public void allowCoreThreadTimeOut(boolean z2) {
        this.g.allowCoreThreadTimeOut(z2);
    }

    @Override // java.util.concurrent.ThreadPoolExecutor, com.bytedance.sdk.component.uy.g
    public void setMaximumPoolSize(int i) {
        this.g.setMaximumPoolSize(i);
    }

    @Override // java.util.concurrent.ThreadPoolExecutor, com.bytedance.sdk.component.uy.g
    public int getMaximumPoolSize() {
        return this.g.getMaximumPoolSize();
    }

    @Override // java.util.concurrent.ThreadPoolExecutor, com.bytedance.sdk.component.uy.g
    public void setKeepAliveTime(long j, TimeUnit timeUnit) {
        this.g.setKeepAliveTime(j, timeUnit);
    }

    @Override // java.util.concurrent.ThreadPoolExecutor, com.bytedance.sdk.component.uy.g
    public long getKeepAliveTime(TimeUnit timeUnit) {
        return this.g.getKeepAliveTime(timeUnit);
    }

    @Override // java.util.concurrent.ThreadPoolExecutor, com.bytedance.sdk.component.uy.g
    public BlockingQueue<Runnable> getQueue() {
        return this.g.getQueue();
    }

    @Override // java.util.concurrent.ThreadPoolExecutor, com.bytedance.sdk.component.uy.g
    public boolean remove(Runnable runnable) {
        return this.g.remove(runnable);
    }

    @Override // java.util.concurrent.ThreadPoolExecutor, com.bytedance.sdk.component.uy.g
    public void purge() {
        this.g.purge();
    }

    @Override // java.util.concurrent.ThreadPoolExecutor, com.bytedance.sdk.component.uy.g
    public int getPoolSize() {
        return this.g.getPoolSize();
    }

    @Override // java.util.concurrent.ThreadPoolExecutor, com.bytedance.sdk.component.uy.g
    public int getActiveCount() {
        return this.g.getActiveCount();
    }

    @Override // java.util.concurrent.ThreadPoolExecutor, com.bytedance.sdk.component.uy.g
    public int getLargestPoolSize() {
        return this.g.getLargestPoolSize();
    }

    @Override // java.util.concurrent.ThreadPoolExecutor, com.bytedance.sdk.component.uy.g
    public long getTaskCount() {
        return this.g.getTaskCount();
    }

    @Override // java.util.concurrent.ThreadPoolExecutor, com.bytedance.sdk.component.uy.g
    public long getCompletedTaskCount() {
        return this.g.getCompletedTaskCount();
    }

    @Override // java.util.concurrent.ThreadPoolExecutor, com.bytedance.sdk.component.uy.g
    public String toString() {
        com.bytedance.sdk.component.uy.g gVar = this.g;
        if (gVar != null) {
            return gVar.toString();
        }
        return super.toString();
    }
}
