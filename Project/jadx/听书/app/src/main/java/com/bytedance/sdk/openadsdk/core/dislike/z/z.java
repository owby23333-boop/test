package com.bytedance.sdk.openadsdk.core.dislike.z;

/* JADX INFO: loaded from: classes2.dex */
public class z {
    private static a dl;
    private static dl g;
    private static volatile boolean z;

    public static void z(dl dlVar, a aVar) {
        if (z) {
            return;
        }
        z = true;
        g = dlVar;
        dl = aVar;
    }

    public static dl z() {
        return g;
    }

    public static a g() {
        return dl;
    }
}
