package com.alipay.apmobilesecuritysdk.e;

import android.content.Context;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static String f1683a = "";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static String f1684b = "";
    private static String c = "";
    private static String d = "";
    private static String e = "";
    private static Map<String, String> f = new HashMap();

    public static synchronized String a(String str) {
        String str2 = "apdidTokenCache" + str;
        if (f.containsKey(str2)) {
            String str3 = f.get(str2);
            if (com.alipay.sdk.m.d0.a.b(str3)) {
                return str3;
            }
        }
        return "";
    }

    public static synchronized String b() {
        return f1683a;
    }

    public static synchronized String c() {
        return f1684b;
    }

    public static synchronized String d() {
        return d;
    }

    public static synchronized String e() {
        return e;
    }

    public static synchronized String f() {
        return c;
    }

    public static synchronized c g() {
        return new c(f1683a, f1684b, c, d, e);
    }

    public static void h() {
        f.clear();
        f1683a = "";
        f1684b = "";
        d = "";
        e = "";
        c = "";
    }

    public static synchronized void a() {
    }

    public static void b(String str) {
        f1683a = str;
    }

    public static void c(String str) {
        f1684b = str;
    }

    public static void d(String str) {
        c = str;
    }

    public static void e(String str) {
        d = str;
    }

    public static void f(String str) {
        e = str;
    }

    public static synchronized void a(b bVar) {
        if (bVar != null) {
            b(bVar.f1676a);
            c(bVar.f1677b);
            d(bVar.c);
        }
    }

    public static synchronized void a(c cVar) {
        if (cVar != null) {
            b(cVar.f1678a);
            c(cVar.f1679b);
            e(cVar.d);
            f(cVar.e);
            d(cVar.c);
        }
    }

    public static synchronized void a(String str, String str2) {
        String str3 = "apdidTokenCache" + str;
        if (f.containsKey(str3)) {
            f.remove(str3);
        }
        f.put(str3, str2);
    }

    public static synchronized boolean a(Context context, String str) {
        long jA;
        try {
            jA = h.a(context);
        } catch (Throwable unused) {
        }
        if (jA < 0) {
            jA = 86400000;
        }
        try {
            if (Math.abs(System.currentTimeMillis() - h.h(context, str)) < jA) {
                return true;
            }
        } finally {
        }
        return false;
    }
}
