package com.alipay.sdk.m.l;

import com.alipay.sdk.m.y.l;

/* JADX INFO: loaded from: classes.dex */
public class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static volatile boolean f1850a = false;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static volatile String f1851b;

    public static void a(String str) {
        f1851b = str;
    }

    public static String b() {
        c cVarA = c.a(c.DOUBLE_REQUEST.c());
        return a(cVarA.c(), cVarA.b(), "");
    }

    public static boolean c() {
        return f1850a;
    }

    public static String d() {
        return f1851b;
    }

    public static String e() {
        c cVarA = c.a(c.PARAMS_ERROR.c());
        return a(cVarA.c(), cVarA.b(), "");
    }

    public static void a(boolean z) {
        f1850a = z;
    }

    public static String a() {
        c cVarA = c.a(c.CANCELED.c());
        return a(cVarA.c(), cVarA.b(), "");
    }

    public static String a(int i, String str, String str2) {
        return "resultStatus={" + i + "};memo={" + str + "};result={" + str2 + l.d;
    }
}
