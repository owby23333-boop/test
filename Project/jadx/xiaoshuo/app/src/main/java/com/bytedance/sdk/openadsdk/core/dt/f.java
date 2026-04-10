package com.bytedance.sdk.openadsdk.core.dt;

import org.json.JSONObject;

/* JADX INFO: loaded from: classes10.dex */
public class f {
    int e = 1;
    int bf = 1;

    public void bf(int i) {
        this.bf = i;
    }

    public JSONObject d() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("ah", this.e);
            jSONObject.put("am", this.bf);
        } catch (Exception e) {
            com.bytedance.sdk.component.utils.wu.d(e.toString());
        }
        return jSONObject;
    }

    public void e(int i) {
        this.e = i;
    }

    public boolean bf() {
        return this.bf == 1;
    }

    public boolean e() {
        return this.e == 1;
    }
}
