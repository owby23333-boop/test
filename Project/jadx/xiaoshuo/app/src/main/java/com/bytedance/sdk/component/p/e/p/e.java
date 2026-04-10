package com.bytedance.sdk.component.p.e.p;

import android.os.Handler;
import android.os.HandlerThread;

/* JADX INFO: loaded from: classes.dex */
public class e {
    private static volatile Handler bf = null;
    private static int d = 2000;
    private static volatile HandlerThread e = new HandlerThread("csj_ad_log", 10);

    static {
        e.start();
    }

    public static int bf() {
        if (d <= 0) {
            d = 2000;
        }
        return d;
    }

    public static Handler e() {
        if (e == null || !e.isAlive()) {
            synchronized (e.class) {
                if (e == null || !e.isAlive()) {
                    e = new HandlerThread("csj_init_handle", -1);
                    e.start();
                    bf = new Handler(e.getLooper());
                }
            }
        } else if (bf == null) {
            synchronized (e.class) {
                if (bf == null) {
                    bf = new Handler(e.getLooper());
                }
            }
        }
        return bf;
    }
}
