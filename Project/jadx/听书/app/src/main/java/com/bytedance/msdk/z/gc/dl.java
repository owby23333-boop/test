package com.bytedance.msdk.z.gc;

import com.bytedance.msdk.gz.wp;

/* JADX INFO: loaded from: classes2.dex */
public class dl {
    private static int dl = 4;
    private static boolean g = false;
    static boolean z = true;

    public static void z(int i) {
        dl = i;
    }

    public static void z() {
        g = true;
        z(3);
    }

    public static boolean g() {
        return wp.z || g;
    }

    public static void z(String str) {
        if (g()) {
            z("Logger", str);
        }
    }

    public static void z(String str, String str2) {
        g();
    }

    public static void z(String str, String str2, Throwable th) {
        g();
    }

    public static void g(String str) {
        if (g()) {
            g("Logger", str);
        }
    }

    public static void g(String str, String str2) {
        if (g() && str2 != null && dl <= 4) {
            com.bytedance.sdk.component.utils.wp.z(str, str2);
        }
    }

    public static void dl(String str, String str2) {
        if (g() && str2 != null && dl <= 5) {
            com.bytedance.sdk.component.utils.wp.g(str, str2);
        }
    }

    public static void dl(String str) {
        if (g()) {
            a("Logger", str);
        }
    }

    public static void a(String str, String str2) {
        if (g() && str2 != null && dl <= 6) {
            com.bytedance.sdk.component.utils.wp.a(str, str2);
        }
    }

    public static void g(String str, String str2, Throwable th) {
        if (g()) {
            if (!(str2 == null && th == null) && dl <= 6) {
                com.bytedance.sdk.component.utils.wp.dl(str, str2, th);
            }
        }
    }
}
