package com.umeng.message.common;

import android.text.TextUtils;

/* JADX INFO: loaded from: classes3.dex */
public class UPLog {
    private static boolean enable = false;

    private static String buildMsg(Object... objArr) {
        if (objArr == null || objArr.length == 0) {
            return "";
        }
        if (objArr.length == 1) {
            return String.valueOf(objArr[0]);
        }
        StringBuilder sb = new StringBuilder();
        for (Object obj : objArr) {
            if (obj != null) {
                sb.append(obj);
            }
        }
        return sb.toString();
    }

    private static String buildTag(String str) {
        if (TextUtils.isEmpty(str)) {
            return "UPush";
        }
        return "UPush." + str;
    }

    public static void d(String str, Object... objArr) {
        if (enable) {
            buildTag(str);
            buildMsg(objArr);
        }
    }

    public static void e(String str, Object... objArr) {
        if (enable) {
            buildTag(str);
            buildMsg(objArr);
        }
    }

    public static void i(String str, Object... objArr) {
        if (enable) {
            buildTag(str);
            buildMsg(objArr);
        }
    }

    public static void setEnable(boolean z2) {
        enable = z2;
    }

    public static void w(String str, Object... objArr) {
        if (enable) {
            buildTag(str);
            buildMsg(objArr);
        }
    }
}
