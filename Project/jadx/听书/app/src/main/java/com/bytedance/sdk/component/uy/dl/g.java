package com.bytedance.sdk.component.uy.dl;

import com.bytedance.sdk.component.utils.wp;
import com.bytedance.sdk.component.uy.kb;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes2.dex */
public class g extends z {
    private AtomicInteger z;

    @Override // com.bytedance.sdk.component.uy.dl.z
    protected int g() {
        return 1;
    }

    public g(int i, int i2, long j, TimeUnit timeUnit, ThreadFactory threadFactory) {
        super(i, i2, j, timeUnit, new SynchronousQueue(), threadFactory);
        this.z = new AtomicInteger(0);
    }

    @Override // java.util.concurrent.ThreadPoolExecutor
    protected void afterExecute(Runnable runnable, Throwable th) {
        Runnable runnablePoll;
        super.afterExecute(runnable, th);
        BlockingQueue<Runnable> queue = kb.g.fo().getQueue();
        if (queue.size() == 0) {
            return;
        }
        int maximumPoolSize = getMaximumPoolSize();
        if (this.z.get() >= Math.max(getCorePoolSize(), maximumPoolSize / 4)) {
            return;
        }
        try {
            this.z.getAndIncrement();
            int activeCount = getActiveCount();
            while (activeCount < maximumPoolSize / 2 && !isShutdown() && !isTerminated() && !isTerminating() && (runnablePoll = queue.poll()) != null) {
                if (runnablePoll instanceof com.bytedance.sdk.component.uy.z.dl) {
                    com.bytedance.sdk.component.uy.z.dl dlVar = (com.bytedance.sdk.component.uy.z.dl) runnablePoll;
                    dlVar.z(g());
                    dlVar.g();
                }
                runnablePoll.run();
                activeCount = getActiveCount();
            }
        } finally {
            this.z.getAndDecrement();
        }
    }

    @Override // com.bytedance.sdk.component.uy.dl.z
    protected void z(Runnable runnable, OutOfMemoryError outOfMemoryError) {
        super.z(runnable, outOfMemoryError);
        if (runnable != null) {
            if (runnable instanceof com.bytedance.sdk.component.uy.z.dl) {
                ((com.bytedance.sdk.component.uy.z.dl) runnable).z(false);
            } else {
                runnable = new dl(runnable);
            }
            kb.g.fo().execute(runnable);
        }
        try {
            allowCoreThreadTimeOut(false);
        } catch (Exception e) {
            wp.dl("BigThreadPool", e);
        }
    }

    @Override // com.bytedance.sdk.component.uy.dl.z
    public boolean z() {
        return getActiveCount() >= getMaximumPoolSize();
    }

    @Override // com.bytedance.sdk.component.uy.dl.z, java.util.concurrent.ThreadPoolExecutor, java.util.concurrent.Executor
    public void execute(Runnable runnable) {
        if (runnable instanceof dl) {
            super.execute(runnable);
            return;
        }
        if (z(runnable)) {
            return;
        }
        if (z()) {
            if (runnable instanceof com.bytedance.sdk.component.uy.z.dl) {
                ((com.bytedance.sdk.component.uy.z.dl) runnable).z(false);
            } else {
                runnable = new dl(runnable);
            }
            kb.g.fo().execute(runnable);
            return;
        }
        super.execute(runnable);
    }

    private boolean z(Runnable runnable) {
        com.bytedance.sdk.component.uy.z.dl dlVar;
        if (!a.a()) {
            return false;
        }
        if (runnable instanceof com.bytedance.sdk.component.uy.z.dl) {
            dlVar = (com.bytedance.sdk.component.uy.z.dl) runnable;
            if (!dlVar.dl()) {
                return false;
            }
        } else {
            dlVar = new dl(runnable);
        }
        com.bytedance.sdk.component.uy.z.dl.z.incrementAndGet();
        dlVar.z(false);
        kb.g.fo().execute(dlVar);
        return true;
    }
}
