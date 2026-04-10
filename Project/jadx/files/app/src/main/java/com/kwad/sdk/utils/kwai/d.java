package com.kwad.sdk.utils.kwai;

import com.kwad.sdk.utils.kwai.c;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes3.dex */
public final class d {
    static c.d aBr;
    static volatile Executor aBs;
    static ExecutorService aBt = Executors.newSingleThreadExecutor();

    private d() {
    }

    public static void a(c.d dVar) {
        aBr = dVar;
    }

    static Executor getExecutor() {
        if (aBs == null) {
            synchronized (d.class) {
                if (aBs == null) {
                    ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(4, 4, 10L, TimeUnit.SECONDS, new LinkedBlockingQueue());
                    threadPoolExecutor.allowCoreThreadTimeOut(true);
                    aBs = threadPoolExecutor;
                }
            }
        }
        return aBs;
    }

    public static void setExecutor(Executor executor) {
        if (executor != null) {
            aBs = executor;
        }
    }
}
