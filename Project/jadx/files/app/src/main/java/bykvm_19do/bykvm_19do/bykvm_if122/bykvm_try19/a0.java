package bykvm_19do.bykvm_19do.bykvm_if122.bykvm_try19;

import android.text.TextUtils;

/* JADX INFO: loaded from: classes.dex */
public class a0 {
    private static volatile String a = "";

    static {
        try {
            if (TextUtils.isEmpty(a)) {
                a = e0.a("tt_device_info", bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.a.d()).a("oaid", "");
            }
        } catch (Throwable unused) {
        }
    }

    public static String a() {
        try {
            if (TextUtils.isEmpty(a)) {
                a = q.d();
                a(a);
            }
        } catch (Throwable unused) {
        }
        return a == null ? "" : a;
    }

    private static void a(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        e0.a("tt_device_info", bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.a.d()).b("oaid", str);
    }
}
