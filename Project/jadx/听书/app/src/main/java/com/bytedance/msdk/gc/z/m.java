package com.bytedance.msdk.gc.z;

import android.content.Context;

/* JADX INFO: loaded from: classes2.dex */
public class m extends e {
    private static volatile m z;

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
        super(context);
    }
}
