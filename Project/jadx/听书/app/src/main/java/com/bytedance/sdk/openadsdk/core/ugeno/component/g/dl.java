package com.bytedance.sdk.openadsdk.core.ugeno.component.g;

import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class dl {
    private int g;
    private JSONObject z;

    public dl() {
    }

    public dl(JSONObject jSONObject, int i) {
        this.z = jSONObject;
        this.g = i;
    }

    public JSONObject z() {
        return this.z;
    }

    public void z(JSONObject jSONObject) {
        this.z = jSONObject;
    }

    public int g() {
        return this.g;
    }

    public void z(int i) {
        this.g = i;
    }
}
