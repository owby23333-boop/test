package bykvm_19do.bykvm_19do.bykvm_19do;

import android.content.Context;
import android.telephony.TelephonyManager;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
class r extends e2 {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final Context f739e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final j2 f740f;

    r(Context context, j2 j2Var) {
        super(true, false);
        this.f739e = context;
        this.f740f = j2Var;
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_19do.e2
    protected boolean a(JSONObject jSONObject) {
        l0.a("m.1", null);
        TelephonyManager telephonyManager = (TelephonyManager) this.f739e.getSystemService("phone");
        if (telephonyManager == null) {
            return false;
        }
        try {
            if (this.f740f.o()) {
                k2.a(jSONObject, "carrier", telephonyManager.getNetworkOperatorName());
                k2.a(jSONObject, "mcc_mnc", telephonyManager.getNetworkOperator());
            }
            k2.a(jSONObject, "udid", this.f740f.o() ? i0.a(telephonyManager) : this.f740f.m());
            return true;
        } catch (Exception e2) {
            l0.a(e2);
            return false;
        }
    }
}
