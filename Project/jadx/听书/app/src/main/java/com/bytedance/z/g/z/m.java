package com.bytedance.z.g.z;

import android.content.Context;

/* JADX INFO: loaded from: classes2.dex */
public class m {
    private static volatile m z;
    private final dl g;

    public static m z(Context context) {
        if (z == null) {
            synchronized (m.class) {
                if (z == null) {
                    z = new m(context);
                }
            }
        }
        return z;
    }

    private m(Context context) {
        this.g = new dl(context);
    }

    public void z() {
        this.g.z();
    }
}
