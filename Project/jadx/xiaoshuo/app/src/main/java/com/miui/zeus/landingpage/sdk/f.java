package com.miui.zeus.landingpage.sdk;

import android.app.Activity;
import android.content.Context;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: classes3.dex */
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static Context f7197a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static WeakReference<Activity> f7198b;
    public static Handler c = new Handler(Looper.getMainLooper());
    public static Handler d;
    public static boolean e;
    public static String f;

    public static Context a() {
        Context context = f7197a;
        if (context != null) {
            return context;
        }
        throw new IllegalStateException("GlobalHolder should be init before using");
    }

    public static Handler b() {
        if (f7197a == null) {
            throw new IllegalStateException("GlobalHolder should be init before using");
        }
        if (d == null) {
            synchronized (f.class) {
                if (d == null) {
                    HandlerThread handlerThread = new HandlerThread("zeus-bg-task-" + f7197a.getPackageName());
                    if (!handlerThread.isAlive()) {
                        handlerThread.start();
                    }
                    d = new Handler(handlerThread.getLooper());
                }
            }
        }
        return d;
    }
}
