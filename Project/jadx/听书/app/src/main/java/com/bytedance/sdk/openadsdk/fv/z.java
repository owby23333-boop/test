package com.bytedance.sdk.openadsdk.fv;

import android.os.Handler;
import android.os.HandlerThread;
import com.bytedance.sdk.openadsdk.api.m;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes2.dex */
public final class z {
    private static volatile z z;
    private final Handler dl;
    private volatile ThreadPoolExecutor g = null;

    private z() {
        HandlerThread handlerThread = new HandlerThread("csj_api_main");
        handlerThread.start();
        this.dl = new Handler(handlerThread.getLooper());
    }

    public static z z() {
        if (z == null) {
            synchronized (z.class) {
                z = new z();
            }
        }
        return z;
    }

    public Handler g() {
        return this.dl;
    }

    public void z(Runnable runnable) {
        if (runnable != null) {
            try {
                this.dl.post(runnable);
            } catch (Throwable th) {
                m.z(th);
            }
        }
    }

    public void z(ThreadPoolExecutor threadPoolExecutor) {
        if (threadPoolExecutor != null) {
            if (this.g != null) {
                m.g("ApiThread", "setPluginExecutor: 释放掉api层的线程池");
                z(threadPoolExecutor, this.g);
            }
            this.g = threadPoolExecutor;
        }
    }

    public ExecutorService dl() {
        if (this.g == null) {
            ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(3, Integer.MAX_VALUE, 1000L, TimeUnit.MILLISECONDS, new SynchronousQueue());
            threadPoolExecutor.allowCoreThreadTimeOut(true);
            this.g = threadPoolExecutor;
        }
        return this.g;
    }

    private void z(ExecutorService executorService, final ThreadPoolExecutor threadPoolExecutor) {
        executorService.execute(new Runnable() { // from class: com.bytedance.sdk.openadsdk.fv.z.1
            @Override // java.lang.Runnable
            public void run() {
                ThreadPoolExecutor threadPoolExecutor2 = threadPoolExecutor;
                if (threadPoolExecutor2 == null) {
                    return;
                }
                try {
                    threadPoolExecutor2.setKeepAliveTime(1L, TimeUnit.MILLISECONDS);
                    threadPoolExecutor.allowCoreThreadTimeOut(true);
                    while (true) {
                        try {
                            Thread.sleep(100L);
                        } catch (InterruptedException unused) {
                        }
                        if (threadPoolExecutor.getQueue().size() <= 0 && threadPoolExecutor.getActiveCount() == 0) {
                            threadPoolExecutor.shutdown();
                            return;
                        }
                    }
                } catch (Throwable unused2) {
                }
            }
        });
    }
}
