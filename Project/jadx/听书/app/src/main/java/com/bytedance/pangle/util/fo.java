package com.bytedance.pangle.util;

import android.os.Build;
import android.text.TextUtils;

/* JADX INFO: loaded from: classes2.dex */
public class fo {
    public static boolean dl() {
        return false;
    }

    public static boolean e() {
        return false;
    }

    public static boolean g() {
        return true;
    }

    public static boolean gc() {
        return false;
    }

    public static boolean kb() {
        return true;
    }

    public static boolean m() {
        return false;
    }

    public static boolean uy() {
        return true;
    }

    public static boolean v() {
        return true;
    }

    public static boolean wp() {
        return false;
    }

    public static boolean z() {
        return true;
    }

    public static boolean a() {
        return Build.VERSION.SDK_INT <= 28;
    }

    public static boolean gz() {
        return Build.VERSION.SDK_INT <= 28;
    }

    public static boolean fo() {
        return Build.VERSION.SDK_INT >= 29 && Build.VERSION.SDK_INT <= 30;
    }

    public static boolean i() {
        return Build.VERSION.SDK_INT <= 28;
    }

    public static boolean pf() {
        if (Build.VERSION.SDK_INT < 28) {
            return Build.VERSION.SDK_INT == 27 && Build.VERSION.PREVIEW_SDK_INT > 0;
        }
        return true;
    }

    public static boolean ls() {
        if (Build.VERSION.SDK_INT < 29) {
            return Build.VERSION.SDK_INT == 28 && Build.VERSION.PREVIEW_SDK_INT > 0;
        }
        return true;
    }

    public static boolean p() {
        return Build.VERSION.SDK_INT == 29;
    }

    public static boolean fv() {
        if (Build.VERSION.SDK_INT < 30) {
            return Build.VERSION.SDK_INT == 29 && Build.VERSION.PREVIEW_SDK_INT > 0;
        }
        return true;
    }

    public static boolean js() {
        if (Build.VERSION.SDK_INT < 31) {
            return Build.VERSION.SDK_INT == 30 && Build.VERSION.PREVIEW_SDK_INT > 0;
        }
        return true;
    }

    public static boolean tb() {
        return TextUtils.equals(Build.BRAND.toLowerCase(), "huawei");
    }

    public static boolean q() {
        return TextUtils.equals(Build.BRAND.toLowerCase(), "samsung");
    }
}
