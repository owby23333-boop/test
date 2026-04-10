package com.bytedance.sdk.openadsdk.core.dt;

import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes10.dex */
public class uk {
    private int bf;
    private String d;
    private int e;
    private String tg;

    public static uk e(String str) {
        try {
            return e(new JSONObject(str));
        } catch (JSONException e) {
            com.bytedance.sdk.component.utils.wu.tg("LiveSdkConfig", "parse failed:" + e);
            return new uk();
        }
    }

    public int bf() {
        return this.bf;
    }

    public String d() {
        return this.d;
    }

    public boolean ga() {
        return this.e == 1;
    }

    public String tg() {
        return this.tg;
    }

    public String toString() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("ad_live_status", e());
            jSONObject.put("app_id", bf());
            jSONObject.put(com.alipay.sdk.m.m.b.z0, d());
            jSONObject.put("secure_key", tg());
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jSONObject.toString();
    }

    public void bf(int i) {
        this.bf = i;
    }

    public void d(String str) {
        this.tg = str;
    }

    public void bf(String str) {
        this.d = str;
    }

    public static uk e(JSONObject jSONObject) {
        uk ukVar = new uk();
        ukVar.e(jSONObject.optInt("ad_live_status"));
        ukVar.bf(jSONObject.optInt("app_id"));
        ukVar.bf(jSONObject.optString(com.alipay.sdk.m.m.b.z0));
        ukVar.d(jSONObject.optString("secure_key"));
        return ukVar;
    }

    public int e() {
        return this.e;
    }

    public void e(int i) {
        this.e = i;
    }
}
