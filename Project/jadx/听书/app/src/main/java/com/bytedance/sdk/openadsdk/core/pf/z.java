package com.bytedance.sdk.openadsdk.core.pf;

/* JADX INFO: loaded from: classes2.dex */
public class z extends g {
    private static volatile z z;

    private z() {
    }

    public static g z() {
        if (z == null) {
            synchronized (g.class) {
                if (z == null) {
                    z = new z();
                }
            }
        }
        return z;
    }

    @Override // com.bytedance.sdk.openadsdk.core.pf.g
    protected synchronized int g() {
        int iDl = com.bytedance.sdk.openadsdk.core.dl.gc.z().dl();
        if (com.bytedance.sdk.openadsdk.core.dl.gc.z().a() <= 0.0f) {
            return iDl;
        }
        return (int) Math.ceil(r1 * iDl);
    }

    @Override // com.bytedance.sdk.openadsdk.core.pf.g
    protected synchronized long dl() {
        return com.bytedance.sdk.openadsdk.core.dl.gc.z().g();
    }
}
