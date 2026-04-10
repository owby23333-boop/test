package bykvm_19do.bykvm_19do.bykvm_19do;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.Signature;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
class p extends e2 {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final Context f737e;

    p(Context context) {
        super(true, false);
        this.f737e = context;
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_19do.e2
    protected boolean a(JSONObject jSONObject) throws JSONException {
        PackageInfo packageInfo;
        Signature[] signatureArr;
        Signature signature;
        String strB = null;
        try {
            packageInfo = this.f737e.getPackageManager().getPackageInfo(this.f737e.getPackageName(), 64);
        } catch (Throwable th) {
            l0.a(th);
            packageInfo = null;
        }
        if (packageInfo != null && (signatureArr = packageInfo.signatures) != null && signatureArr.length > 0 && (signature = signatureArr[0]) != null) {
            strB = f0.b(signature.toByteArray());
        }
        if (strB == null) {
            return true;
        }
        jSONObject.put("sig_hash", strB);
        return true;
    }
}
