package com.bytedance.embedapplog;

import android.util.Log;

/* JADX INFO: loaded from: classes.dex */
public class tx {
    public static boolean bf = false;
    public static boolean e;

    public static void bf(String str) {
        bf(str, null);
    }

    public static void d(String str, Throwable th) {
        Log.e("TeaLog", str, th);
    }

    public static void e(String str) {
        e(str, null);
    }

    public static void tg(String str, Throwable th) {
        Log.i("TeaLog", str, th);
    }

    public static void bf(String str, Throwable th) {
        Log.w("TeaLog", str, th);
    }

    public static void e(String str, Throwable th) {
        if (bf) {
            Log.d("TeaLog", str, th);
        }
    }

    public static void bf(Throwable th) {
        if (th != null) {
            Log.e("TeaLog", "U SHALL NOT PASS!", th);
        }
    }

    public static void e(Throwable th) {
        Log.e("TeaLog", "", th);
    }
}
