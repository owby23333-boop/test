package com.bytedance.sdk.openadsdk.core.fv.z;

import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class un extends com.bytedance.sdk.component.z.gc<JSONObject, JSONObject> {
    private com.bytedance.sdk.openadsdk.core.mc z;

    public static void z(com.bytedance.sdk.component.z.p pVar, com.bytedance.sdk.openadsdk.core.mc mcVar) {
        pVar.z("ShowUgenDownloadDialog", (com.bytedance.sdk.component.z.gc<?, ?>) new un(mcVar));
    }

    @Override // com.bytedance.sdk.component.z.gc
    public JSONObject z(JSONObject jSONObject, com.bytedance.sdk.component.z.m mVar) throws Exception {
        return dl();
    }

    public un(com.bytedance.sdk.openadsdk.core.mc mcVar) {
        this.z = mcVar;
    }

    public JSONObject dl() {
        JSONObject jSONObject = new JSONObject();
        com.bytedance.sdk.openadsdk.core.mc mcVar = this.z;
        if (mcVar == null) {
            try {
                jSONObject.put("code", -1);
                jSONObject.put("codeMsg", "JsObject is null");
                return jSONObject;
            } catch (JSONException e) {
                throw new RuntimeException(e);
            }
        }
        return mcVar.kb();
    }
}
