package com.bytedance.sdk.component.widget.z;

/* JADX INFO: loaded from: classes2.dex */
public class z {
    private static volatile z g;
    private volatile g z;

    private z() {
    }

    public static z z() {
        if (g == null) {
            synchronized (z.class) {
                if (g == null) {
                    g = new z();
                }
            }
        }
        return g;
    }

    public g g() {
        return this.z;
    }
}
