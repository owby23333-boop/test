package com.bytedance.embedapplog;

import android.content.Context;
import android.telephony.TelephonyManager;
import com.umeng.analytics.pro.an;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
class nh extends gp {
    private final Context gc;
    private final bv m;

    nh(Context context, bv bvVar) {
        super(true, false);
        this.gc = context;
        this.m = bvVar;
    }

    @Override // com.bytedance.embedapplog.gp
    protected boolean z(JSONObject jSONObject) {
        TelephonyManager telephonyManager = (TelephonyManager) this.gc.getSystemService("phone");
        if (telephonyManager != null) {
            try {
                gb.z(jSONObject, an.P, telephonyManager.getNetworkOperatorName());
                gb.z(jSONObject, "mcc_mnc", telephonyManager.getNetworkOperator());
                gb.z(jSONObject, "udid", this.m.j() ? hn.z(telephonyManager) : this.m.na());
                return true;
            } catch (Exception e) {
                cb.g(e);
            }
        }
        return false;
    }
}
