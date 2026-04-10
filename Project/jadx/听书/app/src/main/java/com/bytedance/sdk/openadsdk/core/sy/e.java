package com.bytedance.sdk.openadsdk.core.sy;

import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class e {
    private JSONObject z;

    public e(JSONObject jSONObject) {
        this.z = jSONObject;
    }

    public String toString() {
        JSONObject jSONObject = this.z;
        return jSONObject != null ? jSONObject.toString() : "pitaya error is null";
    }

    public int z() {
        JSONObject jSONObject = this.z;
        if (jSONObject != null) {
            return jSONObject.optInt("code", -1);
        }
        return -1;
    }
}
