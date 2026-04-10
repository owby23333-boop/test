package com.bytedance.sdk.openadsdk.core.multipro;

import com.bytedance.sdk.openadsdk.core.lc;
import com.yuewen.rf4;

/* JADX INFO: loaded from: classes10.dex */
public class ga {
    public static String e = "com.bytedance.openadsdk";
    public static String bf = rf4.c.f17031a + e + ".TTMultiProvider";

    static {
        e();
    }

    public static void e() {
        if (lc.getContext() != null) {
            e = lc.getContext().getPackageName();
            bf = rf4.c.f17031a + e + ".TTMultiProvider";
        }
    }
}
