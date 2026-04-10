package com.bytedance.sdk.component.e;

import android.text.TextUtils;

/* JADX INFO: loaded from: classes.dex */
class za {
    private static boolean e;

    public static String e() {
        return "";
    }

    public static String e(Throwable th) {
        StringBuilder sb = new StringBuilder();
        sb.append("{\"code\":");
        sb.append(th instanceof k ? ((k) th).e : 0);
        sb.append(com.alipay.sdk.m.y.l.d);
        return sb.toString();
    }

    public static String e(String str) {
        if (TextUtils.isEmpty(str)) {
            return "{\"code\":1}";
        }
        String strSubstring = e ? str.substring(1, str.length() - 1) : "";
        String str2 = "{\"code\":1,\"__data\":" + str;
        if (!strSubstring.isEmpty()) {
            return str2 + "," + strSubstring + com.alipay.sdk.m.y.l.d;
        }
        return str2 + com.alipay.sdk.m.y.l.d;
    }

    public static void e(boolean z) {
        e = z;
    }
}
