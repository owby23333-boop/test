package com.alipay.sdk.m.c;

import android.content.Context;
import android.os.Looper;

/* JADX INFO: loaded from: classes.dex */
public class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static b f1757a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static boolean f1758b = false;

    public static synchronized String a(Context context) {
        if (context == null) {
            throw new RuntimeException("Context is null");
        }
        if (Looper.myLooper() == Looper.getMainLooper()) {
            throw new IllegalStateException("Cannot be called from the main thread");
        }
        b(context);
        b bVar = f1757a;
        if (bVar != null) {
            try {
                return bVar.a(context);
            } catch (Exception unused) {
            }
        }
        return null;
    }

    public static void b(Context context) {
        if (f1757a != null || f1758b) {
            return;
        }
        synchronized (c.class) {
            if (f1757a == null && !f1758b) {
                f1757a = com.alipay.sdk.m.d.a.a(context);
                f1758b = true;
            }
        }
    }
}
