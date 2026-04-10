package com.bytedance.sdk.openadsdk.core;

import android.text.TextUtils;
import com.xiaomi.httpdns.BuildConfig;

/* JADX INFO: loaded from: classes10.dex */
public final class hb {
    public static String bf = "5.4.3.8";
    public static int d = 999;
    public static int e = 5438;
    public static String ga = "privacy";
    public static boolean tg = false;

    public static boolean bf() {
        return com.bytedance.sdk.component.m.bf.bf.dt();
    }

    public static String d() {
        return ga + "";
    }

    public static boolean e() {
        return false;
    }

    public static boolean tg() {
        return TextUtils.equals(BuildConfig.FLAVOR, ga);
    }
}
