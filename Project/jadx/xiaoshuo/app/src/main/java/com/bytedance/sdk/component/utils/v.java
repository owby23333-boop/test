package com.bytedance.sdk.component.utils;

import android.os.Handler;
import android.os.Looper;

/* JADX INFO: loaded from: classes.dex */
public class v {
    private static volatile Handler e;

    public static Handler bf() {
        if (e == null) {
            synchronized (v.class) {
                if (e == null) {
                    e = new Handler(Looper.getMainLooper());
                }
            }
        }
        return e;
    }

    public static Handler e() {
        return com.bytedance.sdk.component.zk.e.e.e().bf();
    }
}
