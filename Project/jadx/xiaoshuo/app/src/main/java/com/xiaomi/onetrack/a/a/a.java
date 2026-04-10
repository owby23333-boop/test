package com.xiaomi.onetrack.a.a;

import android.os.Handler;
import android.os.HandlerThread;
import com.xiaomi.onetrack.util.p;

/* JADX INFO: loaded from: classes8.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f7490a = "AdMonitorDbExecutor";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static String f7491b = "onetrack_ad_monitor_db";
    private static Handler c;

    private static void a() {
        if (c == null) {
            synchronized (a.class) {
                if (c == null) {
                    HandlerThread handlerThread = new HandlerThread(f7491b);
                    handlerThread.start();
                    c = new Handler(handlerThread.getLooper());
                }
            }
        }
    }

    public static void a(Runnable runnable) {
        a();
        c.post(runnable);
    }

    public static void a(Runnable runnable, long j) {
        try {
            a();
            c.postDelayed(runnable, j);
        } catch (Throwable th) {
            p.b(f7490a, th.getMessage());
        }
    }
}
