package com.bytedance.sdk.openadsdk.core;

import android.content.Context;

/* JADX INFO: loaded from: classes2.dex */
public class e extends gz {
    private static volatile e z;

    public static e z(Context context) {
        if (z == null) {
            synchronized (e.class) {
                if (z == null) {
                    z = new e(context);
                }
            }
        }
        return z;
    }

    private e(Context context) {
        super(context);
    }
}
