package com.bytedance.sdk.component.utils;

import android.content.Context;
import android.text.TextUtils;
import com.yuewen.g72;

/* JADX INFO: loaded from: classes.dex */
public class t {
    public static int bf(Context context) {
        int iD = d(context);
        if (iD == 1) {
            return 0;
        }
        if (iD == 4) {
            return 1;
        }
        if (iD == 5) {
            return 4;
        }
        if (iD != 6) {
            return iD;
        }
        return 6;
    }

    public static int d(Context context) {
        return cv.e(context, 60000L);
    }

    public static void e(s sVar) {
        cv.e(sVar);
    }

    public static boolean ga(Context context) {
        return d(context) == 5;
    }

    public static String p(Context context) {
        int iD = d(context);
        return iD != 2 ? iD != 3 ? iD != 4 ? iD != 5 ? iD != 6 ? "mobile" : g72.k : g72.j : g72.g : g72.i : g72.h;
    }

    public static boolean tg(Context context) {
        return d(context) == 4;
    }

    public static boolean vn(Context context) {
        return d(context) == 6;
    }

    public static boolean e(Context context) {
        return d(context) != 0;
    }

    public static boolean e(String str) {
        return !TextUtils.isEmpty(str) && (str.startsWith("http://") || str.startsWith("https://"));
    }
}
