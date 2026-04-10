package com.bytedance.sdk.openadsdk.core.fv.z;

import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class a extends com.bytedance.sdk.component.z.gc<JSONObject, JSONObject> {
    private com.bytedance.sdk.openadsdk.core.mc z;

    public static void z(com.bytedance.sdk.component.z.p pVar, com.bytedance.sdk.openadsdk.core.mc mcVar) {
        pVar.z("businessStatusNotify", (com.bytedance.sdk.component.z.gc<?, ?>) new a(mcVar));
    }

    public a(com.bytedance.sdk.openadsdk.core.mc mcVar) {
        this.z = mcVar;
    }

    @Override // com.bytedance.sdk.component.z.gc
    public JSONObject z(JSONObject jSONObject, com.bytedance.sdk.component.z.m mVar) throws Exception {
        com.bytedance.sdk.openadsdk.core.mc mcVar;
        JSONObject jSONObject2 = new JSONObject();
        if (jSONObject != null && (mcVar = this.z) != null) {
            mcVar.un();
        }
        return jSONObject2;
    }
}
