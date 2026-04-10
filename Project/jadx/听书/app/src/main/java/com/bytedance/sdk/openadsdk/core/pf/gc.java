package com.bytedance.sdk.openadsdk.core.pf;

/* JADX INFO: loaded from: classes2.dex */
public class gc extends g {
    private static volatile gc z;

    private gc() {
    }

    public static g z() {
        if (z == null) {
            synchronized (g.class) {
                if (z == null) {
                    z = new gc();
                }
            }
        }
        return z;
    }

    @Override // com.bytedance.sdk.openadsdk.core.pf.g
    protected int g() {
        return com.bytedance.sdk.openadsdk.core.dl.gc.z().dl();
    }

    @Override // com.bytedance.sdk.openadsdk.core.pf.g
    protected long dl() {
        return com.bytedance.sdk.openadsdk.core.dl.gc.z().g();
    }
}
