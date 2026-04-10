package com.bytedance.z.g.gz;

/* JADX INFO: loaded from: classes2.dex */
public final class uy {
    public static void z(String str) {
        if (com.bytedance.z.g.gz.gc().m()) {
            com.bytedance.sdk.component.utils.wp.z("npth", str);
        }
    }

    public static void z(Throwable th) {
        if (com.bytedance.z.g.gz.gc().m()) {
            com.bytedance.sdk.component.utils.wp.dl("npth", "NPTH Catch Error", th);
        }
    }

    public static void g(Throwable th) {
        if (com.bytedance.z.g.gz.gc().m()) {
            com.bytedance.sdk.component.utils.wp.g("npth", "NPTH Catch Error", th);
        }
    }
}
