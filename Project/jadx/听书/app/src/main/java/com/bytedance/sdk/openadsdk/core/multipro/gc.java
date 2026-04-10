package com.bytedance.sdk.openadsdk.core.multipro;

import com.bytedance.sdk.openadsdk.core.zw;

/* JADX INFO: loaded from: classes2.dex */
public class gc {
    public static String z = "com.bytedance.openadsdk";
    public static String g = "content://" + z + ".TTMultiProvider";

    static {
        z();
    }

    public static void z() {
        if (zw.getContext() != null) {
            z = zw.getContext().getPackageName();
            g = "content://" + z + ".TTMultiProvider";
        }
    }
}
