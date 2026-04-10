package com.github.gzuliyujiang.oaid;

import android.util.Log;
import androidx.annotation.NonNull;

/* JADX INFO: loaded from: classes7.dex */
public final class OAIDLog {
    private static final String TAG = "OAID";
    private static boolean enable = false;

    private OAIDLog() {
    }

    public static void enable() {
        enable = true;
    }

    public static void print(@NonNull Object obj) {
        if (enable) {
            if (obj instanceof Throwable) {
                Log.w("OAID", (Throwable) obj);
            } else {
                Log.d("OAID", obj.toString());
            }
        }
    }
}
