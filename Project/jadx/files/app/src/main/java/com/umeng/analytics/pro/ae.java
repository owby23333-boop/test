package com.umeng.analytics.pro;

import android.content.Context;
import i0.a.b.e.b.a;

/* JADX INFO: compiled from: LenovoDeviceIdSupplier.java */
/* JADX INFO: loaded from: classes3.dex */
public class ae implements z {
    private static final int a = 1;
    private i0.a.b.e.b.a b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private boolean f19441c = false;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private boolean f19442d = false;

    @Override // com.umeng.analytics.pro.z
    public String a(Context context) {
        if (context == null) {
            return null;
        }
        if (!this.f19441c) {
            this.b = new i0.a.b.e.b.a();
            this.f19442d = this.b.a(context, (a.b<String>) null) == 1;
            this.f19441c = true;
        }
        al.a("getOAID", "isSupported", Boolean.valueOf(this.f19442d));
        if (this.f19442d && this.b.b()) {
            return this.b.a();
        }
        return null;
    }
}
