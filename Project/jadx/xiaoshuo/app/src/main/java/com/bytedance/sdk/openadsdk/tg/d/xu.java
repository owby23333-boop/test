package com.bytedance.sdk.openadsdk.tg.d;

import org.json.JSONObject;

/* JADX INFO: loaded from: classes10.dex */
public class xu extends e {
    private String bf;
    private long d;

    public xu(String str, long j) {
        this.bf = str;
        this.d = j;
    }

    @Override // com.bytedance.sdk.openadsdk.tg.d.tg
    public void a_(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        try {
            jSONObject.put("preload_url", this.bf);
            jSONObject.put("preload_size", this.d);
            e(jSONObject);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }
}
