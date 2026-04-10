package com.jbB1g.jbB1g.jbB1g.jbB1g;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.Future;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes3.dex */
public class n {
    private static volatile ThreadPoolExecutor b;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static Handler f1759a = new Handler(Looper.getMainLooper());
    private static final Random c = new Random();

    public static <T> Future<T> a(Callable<T> callable) {
        if (b == null) {
            a();
        }
        return b.submit(callable);
    }

    private static void a() {
        b = new ThreadPoolExecutor(1, 1, 30L, TimeUnit.SECONDS, new LinkedBlockingQueue());
    }

    public static void a(Runnable runnable) {
        if (b == null) {
            a();
        }
        b.execute(runnable);
    }

    public static void a(String str, Context context) {
        if (context != null && c.nextInt(100) < 5) {
            try {
                context.getSharedPreferences("cb_test", 0).edit().putString(MediationConstant.ADN_GDT, str).apply();
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    public static void b(Runnable runnable) {
        f1759a.post(runnable);
    }
}
