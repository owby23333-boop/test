package com.bytedance.sdk.component.z;

import android.util.Log;

/* JADX INFO: loaded from: classes2.dex */
class fo {
    private static boolean z;

    static void z(boolean z2) {
        z = z2;
    }

    static void z(String str) {
        if (z) {
            com.bytedance.sdk.component.utils.wp.z("JsBridge2", str);
        }
    }

    static void g(String str) {
        if (z) {
            com.bytedance.sdk.component.utils.wp.g("JsBridge2", str);
        }
    }

    static void z(String str, Throwable th) {
        if (z) {
            com.bytedance.sdk.component.utils.wp.g("JsBridge2", str, th);
            com.bytedance.sdk.component.utils.wp.g("JsBridge2", "Stacktrace: " + Log.getStackTraceString(th));
        }
    }

    static void g(String str, Throwable th) {
        if (z) {
            com.bytedance.sdk.component.utils.wp.dl("JsBridge2", str, th);
            com.bytedance.sdk.component.utils.wp.a("JsBridge2", "Stacktrace: " + Log.getStackTraceString(th));
        }
    }

    static void z(RuntimeException runtimeException) {
        if (z) {
            throw runtimeException;
        }
    }
}
