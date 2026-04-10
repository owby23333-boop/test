package com.bytedance.sdk.component.gz.g.m;

/* JADX INFO: loaded from: classes2.dex */
public class z {
    private static volatile g z;

    public static g z(com.bytedance.sdk.component.gz.z.gc gcVar) {
        if (z == null) {
            synchronized (g.class) {
                if (z == null) {
                    z = new dl(new m(gcVar), gcVar);
                }
            }
        }
        return z;
    }
}
