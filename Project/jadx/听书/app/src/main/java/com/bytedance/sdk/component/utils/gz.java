package com.bytedance.sdk.component.utils;

import android.os.Handler;
import android.os.Looper;

/* JADX INFO: loaded from: classes2.dex */
public class gz {
    private static volatile Handler z;

    public static Handler z() {
        return com.bytedance.sdk.component.uy.g.z.z().g();
    }

    public static Handler g() {
        if (z == null) {
            synchronized (gz.class) {
                if (z == null) {
                    z = new Handler(Looper.getMainLooper());
                }
            }
        }
        return z;
    }

    public static Handler dl() {
        return com.bytedance.sdk.component.uy.g.z.z().dl();
    }
}
