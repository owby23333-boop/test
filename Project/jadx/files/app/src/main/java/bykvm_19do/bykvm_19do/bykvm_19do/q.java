package bykvm_19do.bykvm_19do.bykvm_19do;

import android.content.Context;
import android.telephony.TelephonyManager;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
class q extends e2 {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final Context f738e;

    q(Context context) {
        super(true, false);
        this.f738e = context;
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_19do.e2
    protected boolean a(JSONObject jSONObject) throws JSONException {
        l0.a("s.1", null);
        h hVarK = a.k();
        if (hVarK == null || !hVarK.B()) {
            return true;
        }
        k2.a(jSONObject, "sim_region", ((TelephonyManager) this.f738e.getSystemService("phone")).getSimCountryIso());
        return true;
    }
}
