package com.bytedance.embedapplog;

import android.content.Context;
import android.telephony.TelephonyManager;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
class me extends gp {
    private final Context gc;

    me(Context context) {
        super(true, false);
        this.gc = context;
    }

    @Override // com.bytedance.embedapplog.gp
    protected boolean z(JSONObject jSONObject) throws JSONException {
        gb.z(jSONObject, "sim_region", ((TelephonyManager) this.gc.getSystemService("phone")).getSimCountryIso());
        return true;
    }
}
