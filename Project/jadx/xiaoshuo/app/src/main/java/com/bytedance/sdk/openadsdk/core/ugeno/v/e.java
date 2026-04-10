package com.bytedance.sdk.openadsdk.core.ugeno.v;

import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes10.dex */
public class e {
    private JSONObject bf;
    private JSONObject d;
    private JSONArray e;
    private JSONObject tg;

    public JSONObject bf() {
        return this.bf;
    }

    public JSONObject d() {
        return this.d;
    }

    public JSONArray e() {
        return this.e;
    }

    public JSONObject tg() {
        return this.tg;
    }

    public void bf(JSONObject jSONObject) {
        this.d = jSONObject;
    }

    public void d(JSONObject jSONObject) {
        this.tg = jSONObject;
    }

    public void e(JSONArray jSONArray) {
        this.e = jSONArray;
    }

    public void e(JSONObject jSONObject) {
        this.bf = jSONObject;
    }
}
