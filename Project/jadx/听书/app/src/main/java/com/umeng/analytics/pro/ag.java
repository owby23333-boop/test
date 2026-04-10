package com.umeng.analytics.pro;

import android.content.Context;
import org.repackage.com.meizu.flyme.openidsdk.OpenIdHelper;

/* JADX INFO: compiled from: MeizuDeviceIdSupplier.java */
/* JADX INFO: loaded from: classes4.dex */
class ag implements aa {
    ag() {
    }

    @Override // com.umeng.analytics.pro.aa
    public String a(Context context) {
        if (context == null) {
            return null;
        }
        boolean zA = OpenIdHelper.a();
        am.a("getOAID", "isSupported", Boolean.valueOf(zA));
        if (zA) {
            return OpenIdHelper.b(context);
        }
        return null;
    }
}
