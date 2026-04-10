package com.bykv;

/* JADX INFO: loaded from: classes2.dex */
public class z {
    private static volatile z z;
    private int g;

    private z() {
    }

    public static z z() {
        if (z == null) {
            synchronized (z.class) {
                if (z == null) {
                    z = new z();
                }
            }
        }
        return z;
    }

    public int g() {
        return this.g;
    }

    public void z(int i) {
        if (i <= 0) {
            return;
        }
        this.g = i;
    }
}
