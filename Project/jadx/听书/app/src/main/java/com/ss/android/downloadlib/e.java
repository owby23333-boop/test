package com.ss.android.downloadlib;

/* JADX INFO: loaded from: classes4.dex */
public class e {
    private static volatile e z;
    private com.ss.android.z.z.g.m g = null;

    private e() {
    }

    public static e z() {
        if (z == null) {
            synchronized (e.class) {
                if (z == null) {
                    z = new e();
                }
            }
        }
        return z;
    }

    public com.ss.android.z.z.g.m g() {
        return this.g;
    }
}
