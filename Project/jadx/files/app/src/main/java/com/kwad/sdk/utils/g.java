package com.kwad.sdk.utils;

import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes3.dex */
public class g {
    private static volatile Executor ayb;
    private static volatile ScheduledExecutorService ayc;

    public static void execute(Runnable runnable) {
        if (ayb == null) {
            synchronized (g.class) {
                if (ayb == null) {
                    ayb = com.kwad.sdk.core.threads.b.yf();
                }
            }
        }
        ayb.execute(runnable);
    }

    public static void schedule(Runnable runnable, long j2, TimeUnit timeUnit) {
        if (ayc == null) {
            synchronized (g.class) {
                if (ayc == null) {
                    ayc = com.kwad.sdk.core.threads.b.yg();
                }
            }
        }
        ayc.schedule(runnable, j2, timeUnit);
    }
}
