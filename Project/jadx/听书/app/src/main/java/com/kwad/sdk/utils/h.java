package com.kwad.sdk.utils;

import com.kwad.sdk.core.threads.GlobalThreadPools;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes4.dex */
public class h {
    private static volatile ExecutorService aYF;
    private static volatile ScheduledExecutorService aYG;

    public static void execute(Runnable runnable) {
        if (aYF == null) {
            synchronized (h.class) {
                if (aYF == null) {
                    aYF = GlobalThreadPools.Jy();
                }
            }
        }
        if (aYF == null || aYF.isShutdown() || aYF.isTerminated()) {
            return;
        }
        aYF.execute(runnable);
    }

    public static void schedule(Runnable runnable, long j, TimeUnit timeUnit) {
        if (aYG == null) {
            synchronized (h.class) {
                if (aYG == null) {
                    aYG = GlobalThreadPools.Jz();
                }
            }
        }
        aYG.schedule(runnable, j, timeUnit);
    }
}
