package com.bytedance.sdk.component.z;

import android.text.TextUtils;

/* JADX INFO: loaded from: classes2.dex */
class io {
    private static boolean z;

    static String z() {
        return "";
    }

    static String z(Throwable th) {
        return "{\"code\":" + (th instanceof fv ? ((fv) th).z : 0) + "}";
    }

    static String z(String str) {
        if (TextUtils.isEmpty(str)) {
            return "{\"code\":1}";
        }
        String strSubstring = z ? str.substring(1, str.length() - 1) : "";
        String str2 = "{\"code\":1,\"__data\":" + str;
        if (!strSubstring.isEmpty()) {
            return str2 + "," + strSubstring + "}";
        }
        return str2 + "}";
    }

    static void z(boolean z2) {
        z = z2;
    }
}
