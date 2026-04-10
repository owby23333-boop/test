package com.bytedance.sdk.openadsdk.tg.e;

import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes10.dex */
public class d implements bf {
    bf e;

    @Override // com.bytedance.sdk.openadsdk.tg.e.bf
    public void e(JSONObject jSONObject) throws JSONException {
        bf bfVar = this.e;
        if (bfVar != null) {
            bfVar.e(jSONObject);
        }
        jSONObject.put("event_ts", System.currentTimeMillis());
    }
}
