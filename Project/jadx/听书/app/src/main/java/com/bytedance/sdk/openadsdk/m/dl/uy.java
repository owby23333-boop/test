package com.bytedance.sdk.openadsdk.m.dl;

import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class uy extends z {
    private long g;
    private String z;

    public uy(String str, long j) {
        this.z = str;
        this.g = j;
    }

    @Override // com.bytedance.sdk.openadsdk.m.dl.a
    public void a_(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        try {
            jSONObject.put("preload_url", this.z);
            jSONObject.put("preload_size", this.g);
            z(jSONObject);
        } catch (Throwable th) {
            com.bytedance.sdk.component.utils.wp.z(th);
        }
    }
}
