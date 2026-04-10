package com.bytedance.sdk.openadsdk.m.z;

import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class dl implements g {
    g z;

    @Override // com.bytedance.sdk.openadsdk.m.z.g
    public void z(JSONObject jSONObject) throws JSONException {
        g gVar = this.z;
        if (gVar != null) {
            gVar.z(jSONObject);
        }
        jSONObject.put("event_ts", System.currentTimeMillis());
    }
}
