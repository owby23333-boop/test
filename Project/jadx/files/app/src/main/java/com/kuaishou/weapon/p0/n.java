package com.kuaishou.weapon.p0;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes2.dex */
public class n {
    private static volatile n a = null;
    private static int b = 3;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static int f16746c = 6;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static ThreadPoolExecutor f16747d;

    private n() {
    }

    public static n a() {
        if (a == null) {
            synchronized (n.class) {
                if (a == null) {
                    a = new n();
                }
                if (f16747d == null) {
                    ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(b, f16746c, 60L, TimeUnit.SECONDS, new LinkedBlockingQueue(10), new RejectedExecutionHandler() { // from class: com.kuaishou.weapon.p0.n.1
                        @Override // java.util.concurrent.RejectedExecutionHandler
                        public final void rejectedExecution(Runnable runnable, ThreadPoolExecutor threadPoolExecutor2) {
                        }
                    });
                    f16747d = threadPoolExecutor;
                    threadPoolExecutor.allowCoreThreadTimeOut(true);
                }
            }
        }
        return a;
    }

    public static n a(int i2, int i3) {
        if (a == null) {
            synchronized (n.class) {
                if (a == null) {
                    b = i2;
                    f16746c = i3;
                    a = new n();
                    if (f16747d == null) {
                        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(b, f16746c, 60L, TimeUnit.SECONDS, new LinkedBlockingQueue(10), new RejectedExecutionHandler() { // from class: com.kuaishou.weapon.p0.n.2
                            @Override // java.util.concurrent.RejectedExecutionHandler
                            public final void rejectedExecution(Runnable runnable, ThreadPoolExecutor threadPoolExecutor2) {
                            }
                        });
                        f16747d = threadPoolExecutor;
                        threadPoolExecutor.allowCoreThreadTimeOut(true);
                    }
                }
            }
        }
        return a;
    }

    public void a(Runnable runnable) {
        if (runnable != null) {
            try {
                f16747d.execute(runnable);
            } catch (Exception unused) {
            }
        }
    }
}
