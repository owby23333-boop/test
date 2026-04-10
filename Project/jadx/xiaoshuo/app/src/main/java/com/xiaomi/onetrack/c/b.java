package com.xiaomi.onetrack.c;

import android.os.Handler;
import android.os.HandlerThread;

/* JADX INFO: loaded from: classes8.dex */
public class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f7620a = "DbExecutor";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static String f7621b = "onetrack_db";
    private static Handler c;

    private static void a() {
        if (c == null) {
            synchronized (b.class) {
                if (c == null) {
                    HandlerThread handlerThread = new HandlerThread(f7621b);
                    handlerThread.start();
                    c = new Handler(handlerThread.getLooper());
                }
            }
        }
    }

    public static void a(Runnable runnable) {
        try {
            a();
            c.post(runnable);
        } catch (Throwable th) {
            com.xiaomi.onetrack.util.p.b(f7620a, th.getMessage());
        }
    }

    public static void a(Runnable runnable, long j) {
        try {
            a();
            c.postDelayed(runnable, j);
        } catch (Throwable th) {
            com.xiaomi.onetrack.util.p.b(f7620a, th.getMessage());
        }
    }
}
