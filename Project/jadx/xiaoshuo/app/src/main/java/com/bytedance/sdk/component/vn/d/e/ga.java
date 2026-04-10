package com.bytedance.sdk.component.vn.d.e;

import android.content.Context;
import com.yuewen.rf4;

/* JADX INFO: loaded from: classes.dex */
public class ga {
    public static String e = "com.bytedance.openadsdk";
    public static String bf = rf4.c.f17031a + e + ".TTMultiProvider";

    static {
        e();
    }

    public static void e() {
        Context context = bf.getContext();
        if (context == null) {
            context = com.bytedance.sdk.component.vn.d.getContext();
        }
        if (context != null) {
            e = context.getPackageName();
            bf = rf4.c.f17031a + e + ".TTMultiProvider";
        }
    }
}
