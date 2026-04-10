package com.bytedance.sdk.openadsdk.api;

import android.util.Log;

/* JADX INFO: loaded from: classes10.dex */
public class bf {
    private static int bf = 4;
    private static boolean e = false;

    public static void bf(String str, String str2) {
        if (e && str2 != null && bf <= 4) {
            Log.i(str, str2);
        }
    }

    public static void d(String str, String str2) {
        if (e && str2 != null && bf <= 5) {
            Log.w(str, str2);
        }
    }

    public static void e(int i) {
        bf = i;
    }

    public static void tg(String str, String str2) {
        if (e && str2 != null && bf <= 6) {
            Log.e(str, str2);
        }
    }

    public static void e() {
        e = true;
        e(3);
    }

    public static void e(String str, String str2) {
        if (e && str2 != null && bf <= 3) {
            Log.d(str, str2);
        }
    }

    public static void e(String str) {
        if (e) {
            d("TTLogger", str);
        }
    }

    public static void e(String str, String str2, Throwable th) {
        if (e) {
            if (!(str2 == null && th == null) && bf <= 6) {
                Log.e(str, str2, th);
            }
        }
    }
}
