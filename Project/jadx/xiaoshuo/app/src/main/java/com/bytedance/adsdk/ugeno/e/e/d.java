package com.bytedance.adsdk.ugeno.e.e;

import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class d {
    private int bf;
    private JSONObject e;

    public d() {
    }

    public int bf() {
        return this.bf;
    }

    public JSONObject e() {
        return this.e;
    }

    public d(JSONObject jSONObject, int i) {
        this.e = jSONObject;
        this.bf = i;
    }

    public void e(JSONObject jSONObject) {
        this.e = jSONObject;
    }

    public void e(int i) {
        this.bf = i;
    }
}
