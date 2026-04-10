package com.bytedance.embedapplog;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.Signature;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
class tc extends gp {
    private final Context gc;

    tc(Context context) {
        super(true, false);
        this.gc = context;
    }

    @Override // com.bytedance.embedapplog.gp
    protected boolean z(JSONObject jSONObject) throws JSONException {
        PackageInfo packageInfo;
        Signature signature;
        String strG = null;
        try {
            packageInfo = this.gc.getPackageManager().getPackageInfo(this.gc.getPackageName(), 64);
        } catch (Throwable th) {
            cb.g(th);
            packageInfo = null;
        }
        if (packageInfo != null && packageInfo.signatures != null && packageInfo.signatures.length > 0 && (signature = packageInfo.signatures[0]) != null) {
            strG = yw.g(signature.toByteArray());
        }
        if (strG == null) {
            return true;
        }
        jSONObject.put("sig_hash", strG);
        return true;
    }
}
