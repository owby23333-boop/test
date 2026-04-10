package com.bytedance.sdk.openadsdk.core.iq;

import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class q {
    int z = 1;
    int g = 1;

    public void z(int i) {
        this.z = i;
    }

    public void g(int i) {
        this.g = i;
    }

    public boolean z() {
        return this.z == 1;
    }

    public boolean g() {
        return this.g == 1;
    }

    public JSONObject dl() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("ah", this.z);
            jSONObject.put("am", this.g);
        } catch (Exception e) {
            com.bytedance.sdk.component.utils.wp.dl(e.toString());
        }
        return jSONObject;
    }
}
