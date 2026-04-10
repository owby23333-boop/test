package com.bytedance.sdk.component.adexpress;

import android.content.Context;

/* JADX INFO: loaded from: classes.dex */
public class tg {
    public static int bf() {
        return com.bytedance.sdk.component.adexpress.e.e.e.e().d().m();
    }

    public static boolean e() {
        com.bytedance.sdk.component.adexpress.e.e.d dVarD = com.bytedance.sdk.component.adexpress.e.e.e.e().d();
        return dVarD != null && dVarD.v() == 1;
    }

    public static Context getContext() {
        if (com.bytedance.sdk.component.adexpress.e.e.e.e().d() == null) {
            return null;
        }
        return com.bytedance.sdk.component.adexpress.e.e.e.e().d().getContext();
    }
}
