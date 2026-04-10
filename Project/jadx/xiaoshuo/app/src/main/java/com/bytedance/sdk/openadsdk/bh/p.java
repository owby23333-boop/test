package com.bytedance.sdk.openadsdk.bh;

/* JADX INFO: loaded from: classes10.dex */
public class p {
    private static e e;

    public interface e {
        void e(String str, String str2);

        void e(String str, String str2, Throwable th);
    }

    public static void e(e eVar) {
        e = eVar;
    }

    public static boolean e() {
        return e != null;
    }

    public static void e(String str, String str2) {
        e eVar = e;
        if (eVar == null) {
            return;
        }
        eVar.e(str, str2);
    }

    public static void e(String str, String str2, Throwable th) {
        if (e == null) {
            return;
        }
        if (th == null) {
            th = new Throwable();
        }
        e.e(str, str2, th);
    }
}
