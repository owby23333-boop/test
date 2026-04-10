package com.bytedance.sdk.component.uy.dl;

import com.bytedance.sdk.component.utils.wp;
import com.bytedance.sdk.component.uy.e;
import com.bytedance.sdk.component.uy.kb;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes2.dex */
public class a extends z {
    private ScheduledFuture<?> z;

    @Override // com.bytedance.sdk.component.uy.dl.z
    protected int g() {
        return 2;
    }

    public a(int i, int i2, long j, TimeUnit timeUnit, BlockingQueue blockingQueue, ThreadFactory threadFactory) {
        super(i, i2, j, timeUnit, blockingQueue, threadFactory);
    }

    @Override // java.util.concurrent.ThreadPoolExecutor
    protected void afterExecute(Runnable runnable, Throwable th) {
        super.afterExecute(runnable, th);
        if (e.gc()) {
            gc();
        }
    }

    private void gc() {
        BlockingQueue queue = getQueue();
        int iGz = kb.g.gz();
        if (getCorePoolSize() == iGz || queue == null || queue.size() != 0) {
            return;
        }
        setCorePoolSize(iGz);
    }

    private boolean m() {
        BlockingQueue queue = getQueue();
        int corePoolSize = getCorePoolSize();
        int i = corePoolSize * 2;
        int iMin = Math.min(corePoolSize + 4, e.z);
        if (corePoolSize >= iMin || queue == null || queue.size() < i) {
            return false;
        }
        try {
            setCorePoolSize(iMin);
            return true;
        } catch (Exception e) {
            wp.z("BizCoreThreadPool", e.getMessage());
            return false;
        }
    }

    @Override // com.bytedance.sdk.component.uy.dl.z
    protected void z(Runnable runnable, OutOfMemoryError outOfMemoryError) {
        boolean zOffer;
        super.z(runnable, outOfMemoryError);
        boolean z = false;
        if (runnable != null) {
            try {
                zOffer = getQueue().offer(runnable);
            } catch (Throwable unused) {
                zOffer = z;
            }
        } else {
            zOffer = true;
            try {
                e.z(false);
            } catch (Throwable unused2) {
                z = zOffer;
                zOffer = z;
            }
        }
        allowCoreThreadTimeOut(false);
        if (!zOffer) {
            throw outOfMemoryError;
        }
    }

    @Override // com.bytedance.sdk.component.uy.dl.z
    public boolean z() {
        BlockingQueue queue = getQueue();
        return queue != null && queue.size() > getCorePoolSize() * 2;
    }

    @Override // com.bytedance.sdk.component.uy.dl.z, java.util.concurrent.ThreadPoolExecutor, java.util.concurrent.Executor
    public void execute(Runnable runnable) {
        if (e.gc()) {
            m();
        }
        super.execute(runnable);
    }

    public void dl() {
        ScheduledFuture<?> scheduledFuture = this.z;
        if (scheduledFuture != null) {
            scheduledFuture.cancel(true);
        }
    }

    public static boolean a() {
        ThreadPoolExecutor threadPoolExecutorFo = kb.g.fo();
        if (threadPoolExecutorFo.getQueue().size() != 0 || threadPoolExecutorFo.isShutdown() || threadPoolExecutorFo.isTerminated()) {
            return false;
        }
        int activeCount = threadPoolExecutorFo.getActiveCount();
        int corePoolSize = threadPoolExecutorFo.getCorePoolSize();
        return activeCount < corePoolSize + (-1) && com.bytedance.sdk.component.uy.z.dl.z.get() < corePoolSize / 2;
    }
}
