package com.bytedance.sdk.component.e;

import android.util.Log;

/* JADX INFO: loaded from: classes.dex */
class zk {
    private static boolean e;

    public static void bf(String str) {
        if (e) {
            Log.w("JsBridge2", str);
        }
    }

    public static void e(boolean z) {
        e = z;
    }

    public static void e(String str) {
        if (e) {
            Log.i("JsBridge2", str);
        }
    }

    public static void bf(String str, Throwable th) {
        if (e) {
            Log.e("JsBridge2", str, th);
            Log.e("JsBridge2", "Stacktrace: " + Log.getStackTraceString(th));
        }
    }

    public static void e(String str, Throwable th) {
        if (e) {
            Log.w("JsBridge2", str, th);
            Log.w("JsBridge2", "Stacktrace: " + Log.getStackTraceString(th));
        }
    }

    public static void e(RuntimeException runtimeException) {
        if (e) {
            throw runtimeException;
        }
    }
}
