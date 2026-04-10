package com.bytedance.sdk.component.vn;

import android.content.Context;

/* JADX INFO: loaded from: classes.dex */
public class d {
    private static volatile Context e;

    public static void e(Context context) {
        if (e == null && context != null) {
            e = context.getApplicationContext();
        }
    }

    public static Context getContext() {
        return e;
    }
}
