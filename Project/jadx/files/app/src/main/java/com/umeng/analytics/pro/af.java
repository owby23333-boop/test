package com.umeng.analytics.pro;

import android.content.Context;

/* JADX INFO: compiled from: MeizuDeviceIdSupplier.java */
/* JADX INFO: loaded from: classes3.dex */
class af implements z {
    af() {
    }

    @Override // com.umeng.analytics.pro.z
    public String a(Context context) {
        if (context == null) {
            return null;
        }
        boolean zA = i0.a.b.b.a.a.b.a();
        al.a("getOAID", "isSupported", Boolean.valueOf(zA));
        if (zA) {
            return i0.a.b.b.a.a.b.a(context);
        }
        return null;
    }
}
