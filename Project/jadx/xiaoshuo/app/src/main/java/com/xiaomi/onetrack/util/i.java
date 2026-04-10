package com.xiaomi.onetrack.util;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes8.dex */
public class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static ThreadPoolExecutor f7711a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static int f7712b = Runtime.getRuntime().availableProcessors() + 1;

    static {
        int i = f7712b;
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(i, i, 10L, TimeUnit.SECONDS, new LinkedBlockingQueue());
        f7711a = threadPoolExecutor;
        threadPoolExecutor.allowCoreThreadTimeOut(true);
    }

    public static void a(Runnable runnable) {
        try {
            f7711a.execute(runnable);
        } catch (Throwable unused) {
        }
    }
}
