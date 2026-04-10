package com.kwad.sdk.api.loader;

import android.content.Context;
import android.text.TextUtils;

/* JADX INFO: loaded from: classes3.dex */
final class g {
    static String Zp = "autoRevert";

    static String aA(Context context) {
        return getVersion(context, "apiversion");
    }

    public static String ay(Context context) {
        return getVersion(context, "curversion");
    }

    public static String az(Context context) {
        return getVersion(context, "newversion");
    }

    private static void c(Context context, String str, String str2) {
        t.d(context, str, str2);
    }

    private static String getVersion(Context context, String str) {
        return t.e(context, str, "");
    }

    public static void h(Context context, String str) {
        c(context, "curversion", str);
    }

    public static void i(Context context, String str) {
        c(context, "newversion", str);
    }

    static void j(Context context, String str) {
        c(context, "apiversion", str);
    }

    static boolean q(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        if (TextUtils.isEmpty(str) && TextUtils.isEmpty(str2)) {
            return false;
        }
        if (!TextUtils.isEmpty(str) && TextUtils.isEmpty(str2)) {
            return true;
        }
        String[] strArrSplit = str.split("\\.");
        String[] strArrSplit2 = str2.split("\\.");
        for (int i2 = 0; i2 < strArrSplit.length && i2 < strArrSplit2.length; i2++) {
            try {
                int i3 = Integer.parseInt(strArrSplit[i2]) - Integer.parseInt(strArrSplit2[i2]);
                if (i3 > 0) {
                    return true;
                }
                if (i3 < 0) {
                    return false;
                }
            } catch (NumberFormatException unused) {
                return false;
            }
        }
        return strArrSplit.length > strArrSplit2.length;
    }
}
