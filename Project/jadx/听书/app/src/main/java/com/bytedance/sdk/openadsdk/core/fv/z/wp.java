package com.bytedance.sdk.openadsdk.core.fv.z;

import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class wp extends com.bytedance.sdk.component.z.gc<JSONObject, JSONObject> {
    private JSONObject z;

    public wp(JSONObject jSONObject) {
        this.z = jSONObject;
    }

    public static void z(com.bytedance.sdk.component.z.p pVar, JSONObject jSONObject) {
        pVar.z("getData", (com.bytedance.sdk.component.z.gc<?, ?>) new wp(jSONObject));
    }

    @Override // com.bytedance.sdk.component.z.gc
    public JSONObject z(JSONObject jSONObject, com.bytedance.sdk.component.z.m mVar) throws Exception {
        return com.bytedance.sdk.openadsdk.core.nativeexpress.g.g.z(this.z, jSONObject);
    }
}
