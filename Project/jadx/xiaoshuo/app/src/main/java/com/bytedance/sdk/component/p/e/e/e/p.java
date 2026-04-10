package com.bytedance.sdk.component.p.e.e.e;

import com.bytedance.sdk.component.p.e.zk;
import com.yuewen.rf4;

/* JADX INFO: loaded from: classes.dex */
public class p {
    public static String e = "com.bytedance.openadsdk";
    public static String bf = rf4.c.f17031a + e + ".TTMultiProvider";

    static {
        e();
    }

    public static void e() {
        if (zk.ga().getContext() != null) {
            e = zk.ga().getContext().getPackageName();
            bf = rf4.c.f17031a + e + ".TTMultiProvider";
        }
    }
}
