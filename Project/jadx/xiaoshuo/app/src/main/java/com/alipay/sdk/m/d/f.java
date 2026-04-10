package com.alipay.sdk.m.d;

import android.content.Context;

/* JADX INFO: loaded from: classes.dex */
public class f implements com.alipay.sdk.m.c.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f1801a = false;

    @Override // com.alipay.sdk.m.c.b
    public String a(Context context) {
        if (context == null) {
            return null;
        }
        if (!this.f1801a) {
            com.alipay.sdk.m.m0.a.e(context);
            this.f1801a = true;
        }
        boolean zA = com.alipay.sdk.m.m0.a.a();
        com.alipay.sdk.m.e.a.b("getOAID", "isSupported", Boolean.valueOf(zA));
        if (zA) {
            return com.alipay.sdk.m.m0.a.b(context);
        }
        return null;
    }
}
