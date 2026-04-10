package com.umeng.analytics.pro;

import android.content.Context;
import android.os.Looper;

/* JADX INFO: compiled from: OpenDeviceId.java */
/* JADX INFO: loaded from: classes4.dex */
public class ab {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static aa f2162a;
    private static boolean b;

    public static synchronized String a(Context context) {
        try {
            if (context == null) {
                throw new RuntimeException("Context is null");
            }
            if (Looper.myLooper() == Looper.getMainLooper()) {
                throw new IllegalStateException("Cannot be called from the main thread");
            }
            b(context);
            aa aaVar = f2162a;
            if (aaVar != null) {
                try {
                    return aaVar.a(context);
                } catch (Exception unused) {
                }
            }
            return null;
        } catch (Throwable th) {
            throw th;
        }
    }

    private static void b(Context context) {
        if (f2162a != null || b) {
            return;
        }
        synchronized (ab.class) {
            if (f2162a == null && !b) {
                f2162a = ad.a(context);
                b = true;
            }
        }
    }
}
