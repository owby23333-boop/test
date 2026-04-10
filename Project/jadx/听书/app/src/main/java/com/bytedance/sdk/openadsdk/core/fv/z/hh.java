package com.bytedance.sdk.openadsdk.core.fv.z;

import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class hh extends com.bytedance.sdk.component.z.gc<JSONObject, JSONObject> {
    private com.bytedance.sdk.openadsdk.core.ugeno.g z;

    public static void z(com.bytedance.sdk.component.z.p pVar, com.bytedance.sdk.openadsdk.core.ugeno.g gVar) {
        pVar.z("RendUgenDownloadDialogState", (com.bytedance.sdk.component.z.gc<?, ?>) new hh(gVar));
    }

    @Override // com.bytedance.sdk.component.z.gc
    public JSONObject z(JSONObject jSONObject, com.bytedance.sdk.component.z.m mVar) throws Exception {
        z(jSONObject);
        return dl();
    }

    private void z(JSONObject jSONObject) {
        if (jSONObject == null || this.z == null) {
            return;
        }
        int iOptInt = jSONObject.optInt("code");
        if (iOptInt == 200) {
            this.z.z();
        } else {
            this.z.z(iOptInt, jSONObject.optString(MediationConstant.KEY_ERROR_MSG));
        }
    }

    public hh(com.bytedance.sdk.openadsdk.core.ugeno.g gVar) {
        this.z = gVar;
    }

    public JSONObject dl() {
        return new JSONObject();
    }
}
