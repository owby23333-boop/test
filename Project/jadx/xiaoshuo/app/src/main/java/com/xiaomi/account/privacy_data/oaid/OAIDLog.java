package com.xiaomi.account.privacy_data.oaid;

import android.util.Log;

/* JADX INFO: loaded from: classes5.dex */
public final class OAIDLog {
    private static final String TAG = "OAID";
    private static boolean enable = false;

    private OAIDLog() {
    }

    public static void enable() {
        enable = true;
    }

    public static void print(Object obj) {
        if (enable) {
            if (obj == null) {
                obj = "<null>";
            }
            Log.d("OAID", obj.toString());
        }
    }
}
