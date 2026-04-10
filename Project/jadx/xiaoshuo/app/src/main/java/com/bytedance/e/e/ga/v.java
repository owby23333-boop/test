package com.bytedance.e.e.ga;

import android.os.Handler;
import android.os.HandlerThread;

/* JADX INFO: loaded from: classes.dex */
public class v {
    private static volatile Handler bf;
    private static volatile Handler d;
    private static volatile HandlerThread e;

    public static Handler bf() {
        if (bf == null) {
            e();
        }
        return bf;
    }

    public static HandlerThread e() {
        if (e == null) {
            synchronized (v.class) {
                if (e == null) {
                    e = new HandlerThread("default_npth_thread");
                    e.start();
                    bf = new Handler(e.getLooper());
                }
            }
        }
        return e;
    }
}
