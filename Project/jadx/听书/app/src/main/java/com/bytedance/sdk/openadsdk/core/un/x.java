package com.bytedance.sdk.openadsdk.core.un;

import com.bytedance.sdk.component.e.a;

/* JADX INFO: loaded from: classes2.dex */
public final class x {
    private static volatile boolean z;

    static class z {
        static final a.z z = x.a();
    }

    public static int g() {
        return 3;
    }

    private static String g(String str) {
        return (z || com.bytedance.sdk.component.utils.p.z(com.bytedance.sdk.openadsdk.core.zw.getContext())) ? str : str + com.bytedance.sdk.component.utils.p.g(com.bytedance.sdk.openadsdk.core.zw.getContext());
    }

    public static com.bytedance.sdk.component.a.g.dl z(String str) {
        return z.z.z(g(str)).z();
    }

    public static void z() {
        z = true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static a.z a() {
        com.bytedance.sdk.openadsdk.core.gk.uy uyVarG = com.bytedance.sdk.openadsdk.core.zw.g();
        uyVarG.fs();
        return new a.z().z(com.bytedance.sdk.openadsdk.core.zw.getContext()).z(1).g(uyVarG.ep()).z(z);
    }
}
