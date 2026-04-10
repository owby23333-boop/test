package com.bytedance.embedapplog;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.Signature;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
class r extends k {
    private final Context ga;

    public r(Context context) {
        super(true, false);
        this.ga = context;
    }

    @Override // com.bytedance.embedapplog.k
    public boolean e(JSONObject jSONObject) throws JSONException {
        PackageInfo packageInfo;
        Signature[] signatureArr;
        Signature signature;
        String strBf = null;
        try {
            packageInfo = this.ga.getPackageManager().getPackageInfo(this.ga.getPackageName(), 64);
        } catch (Throwable th) {
            tx.bf(th);
            packageInfo = null;
        }
        if (packageInfo != null && (signatureArr = packageInfo.signatures) != null && signatureArr.length > 0 && (signature = signatureArr[0]) != null) {
            strBf = ue.bf(signature.toByteArray());
        }
        if (strBf == null) {
            return true;
        }
        jSONObject.put("sig_hash", strBf);
        return true;
    }
}
