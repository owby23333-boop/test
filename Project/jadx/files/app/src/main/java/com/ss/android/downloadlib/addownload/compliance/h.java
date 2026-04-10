package com.ss.android.downloadlib.addownload.compliance;

import com.ss.android.downloadlib.addownload.model.u;
import com.ss.android.downloadlib.constants.EventConstants;
import com.ss.android.downloadlib.event.AdEventHandler;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
class h {
    public static void mb(String str, long j2) {
        com.ss.android.downloadlib.addownload.model.h hVarH = u.mb().h(j2);
        if (hVarH.on()) {
            return;
        }
        hVarH.b.setRefer(str);
        AdEventHandler.mb().ox(EventConstants.Label.LP_APP_DIALOG_CLICK, hVarH);
    }

    public static void ox(String str, long j2) {
        mb(str, null, j2);
    }

    public static void mb(String str, JSONObject jSONObject, long j2) {
        AdEventHandler.mb().ox(str, jSONObject, u.mb().h(j2));
    }

    public static void mb(String str, com.ss.android.downloadlib.addownload.model.h hVar) {
        AdEventHandler.mb().ox(str, hVar);
    }

    public static void mb(int i2, com.ss.android.downloadlib.addownload.model.h hVar) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.putOpt("error_code", Integer.valueOf(i2));
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        AdEventHandler.mb().ox(EventConstants.Label.LP_COMPLIANCE_ERROR, jSONObject, hVar);
    }

    public static void mb(int i2, long j2) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.putOpt("error_code", Integer.valueOf(i2));
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        AdEventHandler.mb().ox(EventConstants.Label.LP_COMPLIANCE_ERROR, jSONObject, u.mb().h(j2));
    }
}
