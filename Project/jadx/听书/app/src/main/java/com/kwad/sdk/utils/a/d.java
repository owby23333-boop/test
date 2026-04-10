package com.kwad.sdk.utils.a;

import com.kwad.sdk.utils.a.c;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes4.dex */
public final class d {
    static c.d bcG;
    static volatile Executor bcH;
    static ExecutorService bcI = Executors.newSingleThreadExecutor();

    private d() {
    }

    public static void a(c.d dVar) {
        bcG = dVar;
    }

    public static void setExecutor(Executor executor) {
        if (executor != null) {
            bcH = executor;
        }
    }

    static Executor getExecutor() {
        if (bcH == null) {
            synchronized (d.class) {
                if (bcH == null) {
                    ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(4, 4, 10L, TimeUnit.SECONDS, new LinkedBlockingQueue());
                    threadPoolExecutor.allowCoreThreadTimeOut(true);
                    bcH = threadPoolExecutor;
                }
            }
        }
        return bcH;
    }
}
