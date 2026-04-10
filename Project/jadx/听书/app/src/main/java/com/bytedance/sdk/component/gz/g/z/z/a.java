package com.bytedance.sdk.component.gz.g.z.z;

import com.bytedance.sdk.component.gz.z.gc;

/* JADX INFO: loaded from: classes2.dex */
public class a {
    private static String z = "com.bytedance.openadsdk";
    private static String g = "content://" + z + ".TTMultiProvider";

    public static String z(gc gcVar) {
        if (gcVar.getContext() != null) {
            z = gcVar.getContext().getPackageName();
            g = "content://" + z + ".TTMultiProvider";
        }
        return g;
    }
}
