package com.kwad.sdk.i;

import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import java.io.Closeable;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.net.HttpURLConnection;
import java.net.URLConnection;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes4.dex */
final class j {
    private static final AtomicInteger aTb = new AtomicInteger(1);
    private static final ExecutorService aTc = new ThreadPoolExecutor(1, 1, 0, TimeUnit.MILLISECONDS, new LinkedBlockingQueue(), new ThreadFactory() { // from class: com.kwad.sdk.i.j.1
        @Override // java.util.concurrent.ThreadFactory
        public final Thread newThread(Runnable runnable) {
            Thread thread = new Thread(Thread.currentThread().getThreadGroup(), runnable, "ksad-lm-thread-" + j.aTb.getAndIncrement(), 0L);
            if (thread.isDaemon()) {
                thread.setDaemon(false);
            }
            return thread;
        }
    });
    private static final Handler aRF = new Handler(Looper.getMainLooper());

    static void Nn() {
    }

    public static void No() {
    }

    private static String zJ() {
        return "";
    }

    static void a(n nVar) {
        aTc.execute(nVar);
    }

    static double o(double d) {
        return new BigDecimal(Double.toString(1.0d)).divide(new BigDecimal(Double.toString(d)), 0, RoundingMode.HALF_UP).doubleValue();
    }

    static boolean L(List<?> list) {
        return list == null || list.isEmpty();
    }

    static void closeQuietly(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (Throwable unused) {
            }
        }
    }

    static void closeQuietly(URLConnection uRLConnection) {
        try {
            if (uRLConnection instanceof HttpURLConnection) {
                ((HttpURLConnection) uRLConnection).disconnect();
            }
        } catch (Throwable unused) {
        }
    }

    public static void ak(String str, String str2) {
        Log.d(gm(str), dY(str2));
    }

    private static String gm(String str) {
        return "KSAd_LM_" + str;
    }

    private static String dY(String str) {
        return str + " " + zJ();
    }
}
