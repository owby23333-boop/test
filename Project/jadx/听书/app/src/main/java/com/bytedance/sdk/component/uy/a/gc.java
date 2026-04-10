package com.bytedance.sdk.component.uy.a;

import com.bytedance.sdk.component.uy.kb;
import java.util.concurrent.Callable;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.RunnableScheduledFuture;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes2.dex */
public class gc extends ScheduledThreadPoolExecutor {
    private final ConcurrentHashMap z;

    @Override // java.util.concurrent.ThreadPoolExecutor
    public void allowCoreThreadTimeOut(boolean z) {
    }

    @Override // java.util.concurrent.ThreadPoolExecutor
    public void setKeepAliveTime(long j, TimeUnit timeUnit) {
    }

    public gc(int i, ThreadFactory threadFactory) {
        super(i, new com.bytedance.sdk.component.uy.z.a(threadFactory, 8));
        this.z = new ConcurrentHashMap();
        z();
    }

    @Override // java.util.concurrent.ThreadPoolExecutor
    public void setThreadFactory(ThreadFactory threadFactory) {
        super.setThreadFactory(new com.bytedance.sdk.component.uy.z.a(threadFactory, 8));
    }

    private void z() {
        if (!kb.g.gc() || allowsCoreThreadTimeOut()) {
            return;
        }
        super.setKeepAliveTime(Math.max(10L, getKeepAliveTime(TimeUnit.SECONDS)), TimeUnit.SECONDS);
        super.allowCoreThreadTimeOut(true);
    }

    @Override // java.util.concurrent.ScheduledThreadPoolExecutor, java.util.concurrent.ScheduledExecutorService
    public ScheduledFuture schedule(final Runnable runnable, final long j, final TimeUnit timeUnit) {
        if (kb.g.gc()) {
            try {
                ScheduledFuture<?> scheduledFutureSchedule = super.schedule(runnable, j, timeUnit);
                this.z.remove(runnable);
                return scheduledFutureSchedule;
            } catch (OutOfMemoryError unused) {
                com.bytedance.sdk.component.uy.a.z.z("PThreadScheduledThreadPoolExecutor");
                kb.g.wp().schedule(new Runnable() { // from class: com.bytedance.sdk.component.uy.a.gc.1
                    @Override // java.lang.Runnable
                    public void run() {
                        gc.super.schedule(runnable, j, timeUnit);
                        gc.this.z.remove(runnable);
                    }
                }, kb.g.a(), TimeUnit.MILLISECONDS);
                return (ScheduledFuture) this.z.get(runnable);
            }
        }
        return super.schedule(runnable, j, timeUnit);
    }

    @Override // java.util.concurrent.ScheduledThreadPoolExecutor, java.util.concurrent.ScheduledExecutorService
    public ScheduledFuture scheduleAtFixedRate(final Runnable runnable, final long j, final long j2, final TimeUnit timeUnit) {
        if (kb.g.gc()) {
            try {
                ScheduledFuture<?> scheduledFutureScheduleAtFixedRate = super.scheduleAtFixedRate(runnable, j, j2, timeUnit);
                this.z.remove(runnable);
                return scheduledFutureScheduleAtFixedRate;
            } catch (OutOfMemoryError unused) {
                com.bytedance.sdk.component.uy.a.z.z("PThreadScheduledThreadPoolExecutor");
                kb.g.wp().schedule(new Runnable() { // from class: com.bytedance.sdk.component.uy.a.gc.2
                    @Override // java.lang.Runnable
                    public void run() {
                        gc.super.scheduleAtFixedRate(runnable, j, j2, timeUnit);
                        gc.this.z.remove(runnable);
                    }
                }, kb.g.a(), TimeUnit.MILLISECONDS);
                return (ScheduledFuture) this.z.get(runnable);
            }
        }
        return super.scheduleAtFixedRate(runnable, j, j2, timeUnit);
    }

    @Override // java.util.concurrent.ScheduledThreadPoolExecutor, java.util.concurrent.ScheduledExecutorService
    public ScheduledFuture scheduleWithFixedDelay(final Runnable runnable, final long j, final long j2, final TimeUnit timeUnit) {
        if (kb.g.gc()) {
            try {
                ScheduledFuture<?> scheduledFutureScheduleWithFixedDelay = super.scheduleWithFixedDelay(runnable, j, j2, timeUnit);
                this.z.remove(runnable);
                return scheduledFutureScheduleWithFixedDelay;
            } catch (OutOfMemoryError unused) {
                com.bytedance.sdk.component.uy.a.z.z("PThreadScheduledThreadPoolExecutor");
                kb.g.wp().schedule(new Runnable() { // from class: com.bytedance.sdk.component.uy.a.gc.3
                    @Override // java.lang.Runnable
                    public void run() {
                        gc.super.scheduleWithFixedDelay(runnable, j, j2, timeUnit);
                        gc.this.z.remove(runnable);
                    }
                }, kb.g.a(), TimeUnit.MILLISECONDS);
                return (ScheduledFuture) this.z.get(runnable);
            }
        }
        return super.scheduleWithFixedDelay(runnable, j, j2, timeUnit);
    }

    @Override // java.util.concurrent.ScheduledThreadPoolExecutor, java.util.concurrent.ScheduledExecutorService
    public ScheduledFuture schedule(final Callable callable, final long j, final TimeUnit timeUnit) {
        if (kb.g.gc()) {
            try {
                ScheduledFuture scheduledFutureSchedule = super.schedule(callable, j, timeUnit);
                this.z.remove(callable);
                return scheduledFutureSchedule;
            } catch (OutOfMemoryError unused) {
                com.bytedance.sdk.component.uy.a.z.z("PThreadScheduledThreadPoolExecutor");
                kb.g.wp().schedule(new Runnable() { // from class: com.bytedance.sdk.component.uy.a.gc.4
                    @Override // java.lang.Runnable
                    public void run() {
                        gc.super.schedule(callable, j, timeUnit);
                        gc.this.z.remove(callable);
                    }
                }, kb.g.a(), TimeUnit.MILLISECONDS);
                return (ScheduledFuture) this.z.get(callable);
            }
        }
        return super.schedule(callable, j, timeUnit);
    }

    @Override // java.util.concurrent.ScheduledThreadPoolExecutor
    protected RunnableScheduledFuture decorateTask(Runnable runnable, RunnableScheduledFuture runnableScheduledFuture) {
        if (kb.g.gc()) {
            RunnableScheduledFuture runnableScheduledFuture2 = (RunnableScheduledFuture) this.z.get(runnable);
            if (runnableScheduledFuture2 != null) {
                return runnableScheduledFuture2;
            }
            RunnableScheduledFuture runnableScheduledFutureDecorateTask = super.decorateTask(runnable, runnableScheduledFuture);
            this.z.put(runnable, runnableScheduledFutureDecorateTask);
            return runnableScheduledFutureDecorateTask;
        }
        return super.decorateTask(runnable, runnableScheduledFuture);
    }

    @Override // java.util.concurrent.ScheduledThreadPoolExecutor
    protected RunnableScheduledFuture decorateTask(Callable callable, RunnableScheduledFuture runnableScheduledFuture) {
        if (kb.g.gc()) {
            RunnableScheduledFuture runnableScheduledFuture2 = (RunnableScheduledFuture) this.z.get(callable);
            if (runnableScheduledFuture2 != null) {
                return runnableScheduledFuture2;
            }
            RunnableScheduledFuture runnableScheduledFutureDecorateTask = super.decorateTask(callable, runnableScheduledFuture);
            this.z.put(callable, runnableScheduledFutureDecorateTask);
            return runnableScheduledFutureDecorateTask;
        }
        return super.decorateTask(callable, runnableScheduledFuture);
    }
}
