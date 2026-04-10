package com.bytedance.sdk.openadsdk.ox;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes2.dex */
public class mb {
    private static volatile mb ox;
    private volatile ThreadPoolExecutor mb = new ThreadPoolExecutor(3, 3, 5, TimeUnit.SECONDS, new LinkedBlockingQueue(), new ThreadFactoryC0311mb(), new RejectedExecutionHandler() { // from class: com.bytedance.sdk.openadsdk.ox.mb.1
        @Override // java.util.concurrent.RejectedExecutionHandler
        public void rejectedExecution(Runnable runnable, ThreadPoolExecutor threadPoolExecutor) {
            com.bytedance.sdk.openadsdk.api.mb.hj("TTThreadManager", "TTThreadManager rejectedExecution:  ");
        }
    });

    /* JADX INFO: renamed from: com.bytedance.sdk.openadsdk.ox.mb$mb, reason: collision with other inner class name */
    public static class ThreadFactoryC0311mb implements ThreadFactory {
        private final String b;
        private final ThreadGroup mb;
        private final AtomicInteger ox;

        ThreadFactoryC0311mb() {
            this("csj_g_pl_mgr");
        }

        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(Runnable runnable) {
            Thread thread = new Thread(this.mb, runnable, this.b + this.ox.getAndIncrement(), 0L);
            if (thread.isDaemon()) {
                thread.setDaemon(false);
            }
            if (thread.getPriority() != 5) {
                thread.setPriority(5);
            }
            return thread;
        }

        ThreadFactoryC0311mb(String str) {
            this.ox = new AtomicInteger(1);
            this.mb = new ThreadGroup("csj_g_pl_mgr");
            this.b = str;
        }
    }

    public mb() {
        this.mb.allowCoreThreadTimeOut(true);
    }

    public static mb mb() {
        if (ox == null) {
            synchronized (mb.class) {
                ox = new mb();
            }
        }
        return ox;
    }

    public void mb(Runnable runnable) {
        if (runnable != null) {
            try {
                this.mb.execute(runnable);
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }
}
