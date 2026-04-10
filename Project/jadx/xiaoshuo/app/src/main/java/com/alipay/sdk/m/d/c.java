package com.alipay.sdk.m.d;

import android.content.Context;
import com.alipay.sdk.m.w0.b;

/* JADX INFO: loaded from: classes.dex */
public class c implements com.alipay.sdk.m.c.b {
    public static final int d = 1;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public com.alipay.sdk.m.w0.b f1798a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f1799b = false;
    public boolean c = false;

    @Override // com.alipay.sdk.m.c.b
    public String a(Context context) {
        if (context == null) {
            return null;
        }
        if (!this.f1799b) {
            com.alipay.sdk.m.w0.b bVar = new com.alipay.sdk.m.w0.b();
            this.f1798a = bVar;
            this.c = bVar.a(context, (b.InterfaceC0044b<String>) null) == 1;
            this.f1799b = true;
        }
        com.alipay.sdk.m.e.a.b("getOAID", "isSupported", Boolean.valueOf(this.c));
        if (this.c && this.f1798a.e()) {
            return this.f1798a.b();
        }
        return null;
    }
}
