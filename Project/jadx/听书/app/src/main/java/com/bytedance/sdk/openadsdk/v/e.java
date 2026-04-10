package com.bytedance.sdk.openadsdk.v;

/* JADX INFO: loaded from: classes2.dex */
public class e {
    private static z z;

    public interface z {
        void z(String str, String str2, Throwable th);
    }

    public static void z(z zVar) {
        z = zVar;
    }

    public static boolean z() {
        return z != null;
    }

    public static void z(String str, String str2, Throwable th) {
        if (z == null) {
            return;
        }
        if (th == null) {
            th = new Throwable();
        }
        z.z(str, str2, th);
    }
}
