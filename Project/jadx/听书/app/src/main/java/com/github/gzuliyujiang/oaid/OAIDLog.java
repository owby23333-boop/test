package com.github.gzuliyujiang.oaid;

import android.util.Log;

/* JADX INFO: loaded from: classes3.dex */
public final class OAIDLog {
    private static final String TAG = "OAID";
    private static boolean enable;

    private OAIDLog() {
    }

    public static void enable() {
        enable = true;
    }

    public static void print(Object log) {
        if (enable) {
            if (log == null) {
                log = "<null>";
            }
            Log.d(TAG, log.toString());
        }
    }
}
