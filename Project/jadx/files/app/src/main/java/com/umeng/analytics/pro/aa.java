package com.umeng.analytics.pro;

import android.content.Context;
import android.os.Looper;

/* JADX INFO: compiled from: OpenDeviceId.java */
/* JADX INFO: loaded from: classes3.dex */
public class aa {
    private static z a = null;
    private static boolean b = false;

    public static synchronized String a(Context context) {
        try {
            if (context == null) {
                throw new RuntimeException("Context is null");
            }
            if (Looper.myLooper() == Looper.getMainLooper()) {
                throw new IllegalStateException("Cannot be called from the main thread");
            }
            b(context);
            if (a != null) {
                try {
                    return a.a(context);
                } catch (Exception unused) {
                }
            }
            return null;
        } catch (Throwable th) {
            throw th;
        }
    }

    private static void b(Context context) {
        if (a != null || b) {
            return;
        }
        synchronized (aa.class) {
            if (a == null && !b) {
                a = ac.a(context);
                b = true;
            }
        }
    }
}
