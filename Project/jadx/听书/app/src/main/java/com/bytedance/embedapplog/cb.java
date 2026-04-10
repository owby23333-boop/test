package com.bytedance.embedapplog;

/* JADX INFO: loaded from: classes2.dex */
public class cb {
    public static boolean g;
    public static boolean z;

    public static void z(String str) {
    }

    public static void z(String str, Throwable th) {
    }

    public static void g(String str) {
        g(str, null);
    }

    public static void g(String str, Throwable th) {
        com.bytedance.sdk.component.utils.wp.g("TeaLog", str, th);
    }

    public static void dl(String str, Throwable th) {
        com.bytedance.sdk.component.utils.wp.dl("TeaLog", str, th);
    }

    public static void z(Throwable th) {
        com.bytedance.sdk.component.utils.wp.dl("TeaLog", "", th);
    }

    public static void a(String str, Throwable th) {
        com.bytedance.sdk.component.utils.wp.z("TeaLog", str, th);
    }

    public static void g(Throwable th) {
        if (th != null) {
            com.bytedance.sdk.component.utils.wp.z("TeaLog", th.getMessage());
        }
    }
}
