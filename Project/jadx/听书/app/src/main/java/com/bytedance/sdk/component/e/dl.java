package com.bytedance.sdk.component.e;

import android.content.Context;

/* JADX INFO: loaded from: classes2.dex */
public class dl {
    private static volatile Context z;

    public static void z(Context context) {
        if (z == null && context != null) {
            z = context.getApplicationContext();
        }
    }

    public static Context getContext() {
        return z;
    }
}
