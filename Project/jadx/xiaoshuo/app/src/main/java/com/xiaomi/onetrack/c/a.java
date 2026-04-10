package com.xiaomi.onetrack.c;

import android.os.Handler;
import android.os.HandlerThread;
import android.util.Log;

/* JADX INFO: loaded from: classes8.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f7618a = "BroadcastExecutor";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static String f7619b = "onetrack_broadcast";
    private static Handler c;

    public static void a() {
        if (c == null) {
            synchronized (a.class) {
                if (c == null) {
                    Log.d(f7618a, "initIfNeeded : " + Thread.currentThread().getId());
                    HandlerThread handlerThread = new HandlerThread(f7619b);
                    handlerThread.start();
                    c = new Handler(handlerThread.getLooper());
                }
            }
        }
    }

    public static void a(Runnable runnable) {
        Log.d(f7618a, "BroadcastExecutor : " + Thread.currentThread().getId());
        a();
        c.post(runnable);
    }
}
