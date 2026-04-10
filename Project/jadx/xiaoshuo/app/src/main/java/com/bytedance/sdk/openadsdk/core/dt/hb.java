package com.bytedance.sdk.openadsdk.core.dt;

import org.json.JSONObject;

/* JADX INFO: loaded from: classes10.dex */
public class hb {
    private String bf;
    private String d;
    private String e;

    public String bf() {
        return this.bf;
    }

    public String d() {
        return this.d;
    }

    public String e() {
        return this.e;
    }

    public JSONObject tg() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("group_id", e());
            jSONObject.put("group_tag", bf());
            jSONObject.put("card_tag", d());
        } catch (Exception e) {
            com.bytedance.sdk.component.utils.wu.d(e.toString());
        }
        return jSONObject;
    }

    public void bf(String str) {
        this.bf = str;
    }

    public void d(String str) {
        this.d = str;
    }

    public void e(String str) {
        this.e = str;
    }
}
