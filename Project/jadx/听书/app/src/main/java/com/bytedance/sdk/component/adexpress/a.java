package com.bytedance.sdk.component.adexpress;

import android.content.Context;

/* JADX INFO: loaded from: classes2.dex */
public class a {
    public static Context getContext() {
        if (com.bytedance.sdk.component.adexpress.z.z.z.z().dl() == null) {
            return null;
        }
        return com.bytedance.sdk.component.adexpress.z.z.z.z().dl().getContext();
    }

    public static boolean z() {
        com.bytedance.sdk.component.adexpress.z.z.dl dlVarDl = com.bytedance.sdk.component.adexpress.z.z.z.z().dl();
        return dlVarDl != null && dlVarDl.e() == 1;
    }

    public static int g() {
        return com.bytedance.sdk.component.adexpress.z.z.z.z().dl().uy();
    }
}
