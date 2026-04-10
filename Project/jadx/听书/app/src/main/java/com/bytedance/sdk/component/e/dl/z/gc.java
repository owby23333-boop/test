package com.bytedance.sdk.component.e.dl.z;

import android.content.Context;

/* JADX INFO: loaded from: classes2.dex */
public class gc {
    public static String z = "com.bytedance.openadsdk";
    public static String g = "content://" + z + ".TTMultiProvider";

    static {
        z();
    }

    public static void z() {
        Context context = g.getContext();
        if (context != null) {
            z = context.getPackageName();
            g = "content://" + z + ".TTMultiProvider";
        }
    }
}
