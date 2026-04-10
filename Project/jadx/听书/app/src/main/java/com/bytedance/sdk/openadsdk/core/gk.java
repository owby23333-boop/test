package com.bytedance.sdk.openadsdk.core;

import android.text.TextUtils;
import com.umeng.commonsdk.framework.UMModuleRegister;

/* JADX INFO: loaded from: classes2.dex */
public final class gk {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static String f1105a = "7.1.0.5";
    public static int dl = 7105;
    public static String e = "main";
    public static String fo = "6.6.0.0";
    public static boolean g = false;
    public static int gc = 999;
    public static boolean gz = false;
    public static boolean m = true;
    public static final int z = 7105;

    public static boolean g() {
        return false;
    }

    public static String z(String str, int i) {
        return "";
    }

    public static boolean z() {
        return true;
    }

    public static boolean dl() {
        return com.bytedance.sdk.openadsdk.hh.m.g();
    }

    public static boolean a() {
        return com.bytedance.sdk.component.wp.g.g.tb();
    }

    public static String gc() {
        return e + (z() ? "_plugin" : "") + (gz ? "_open" : "_close");
    }

    public static String m() {
        return z("com.byted.pangle", 7105);
    }

    public static boolean e() {
        return TextUtils.equals(UMModuleRegister.INNER, e);
    }
}
