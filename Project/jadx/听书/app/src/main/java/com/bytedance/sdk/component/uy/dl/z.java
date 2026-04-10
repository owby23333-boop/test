package com.bytedance.sdk.component.uy.dl;

import com.bytedance.sdk.component.utils.wp;
import com.bytedance.sdk.component.uy.e;
import com.bytedance.sdk.component.uy.kb;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes2.dex */
public abstract class z extends ThreadPoolExecutor {
    protected int g() {
        return 0;
    }

    public boolean z() {
        return false;
    }

    public z(int i, int i2, long j, TimeUnit timeUnit, BlockingQueue blockingQueue, ThreadFactory threadFactory) {
        this(i, i2, j, timeUnit, blockingQueue, threadFactory, com.bytedance.sdk.component.uy.a.z.z);
    }

    public z(int i, int i2, long j, TimeUnit timeUnit, BlockingQueue<Runnable> blockingQueue, ThreadFactory threadFactory, RejectedExecutionHandler rejectedExecutionHandler) {
        super(i, i2, j, timeUnit, blockingQueue, threadFactory, rejectedExecutionHandler);
    }

    private void z(Runnable runnable) {
        com.bytedance.sdk.component.uy.z.dl dlVar;
        try {
            if (runnable instanceof com.bytedance.sdk.component.uy.z.dl) {
                dlVar = (com.bytedance.sdk.component.uy.z.dl) runnable;
            } else {
                dlVar = new com.bytedance.sdk.component.uy.z.dl(runnable);
            }
            dlVar.g();
            if (kb.g.v()) {
                if (!(getCorePoolSize() > getActiveCount() && getQueue().size() <= 0)) {
                    wp.g("BaseThreadPool", "crashing drop task :".concat(String.valueOf(runnable)));
                    dlVar.z(3);
                    kb.g.wp().submit(dlVar);
                    return;
                }
            }
            dlVar.z(g());
            super.execute(dlVar);
        } catch (OutOfMemoryError e) {
            if (kb.g.g()) {
                e.z(false);
            }
            z(runnable, e);
            kb kbVar = kb.g;
        }
    }

    protected void z(Runnable runnable, OutOfMemoryError outOfMemoryError) {
        com.bytedance.sdk.component.uy.z.dl.g = true;
    }

    @Override // java.util.concurrent.ThreadPoolExecutor, java.util.concurrent.Executor
    public void execute(Runnable runnable) {
        z(runnable);
    }

    @Override // java.util.concurrent.ThreadPoolExecutor
    public void setCorePoolSize(int i) {
        try {
            super.setCorePoolSize(i);
        } catch (Exception e) {
            wp.z("BaseThreadPool", e.getMessage());
        } catch (OutOfMemoryError e2) {
            z(null, e2);
        }
    }
}
