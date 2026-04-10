package com.bytedance.z.g.gc;

import android.os.Handler;
import android.os.HandlerThread;

/* JADX INFO: loaded from: classes2.dex */
public class e {
    private static volatile Handler dl;
    private static volatile Handler g;
    private static volatile HandlerThread z;

    public static HandlerThread z() {
        if (z == null) {
            synchronized (e.class) {
                if (z == null) {
                    HandlerThread handlerThread = new HandlerThread("default_npth_thread");
                    z = handlerThread;
                    handlerThread.start();
                    g = new Handler(z.getLooper());
                }
            }
        }
        return z;
    }

    public static Handler g() {
        if (g == null) {
            z();
        }
        return g;
    }
}
