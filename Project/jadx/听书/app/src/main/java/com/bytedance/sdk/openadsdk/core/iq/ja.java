package com.bytedance.sdk.openadsdk.core.iq;

import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class ja {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f1173a;
    private String dl;
    private String e;
    private int g;
    private int gc;
    private String gz;
    private int m;
    private String z;

    public String z() {
        return this.z;
    }

    public int g() {
        return this.g;
    }

    public void z(String str) {
        this.z = str;
    }

    public void z(int i) {
        this.g = i;
    }

    public String dl() {
        return this.dl;
    }

    public void g(String str) {
        this.dl = str;
    }

    public String a() {
        return this.f1173a;
    }

    public void dl(String str) {
        this.f1173a = str;
    }

    public int gc() {
        return this.gc;
    }

    public void g(int i) {
        this.gc = i;
    }

    public int m() {
        return this.m;
    }

    public void dl(int i) {
        this.m = i;
    }

    public String e() {
        return this.e;
    }

    public void a(String str) {
        this.e = str;
    }

    public String gz() {
        return this.gz;
    }

    public void gc(String str) {
        this.gz = str;
    }

    public String toString() {
        return fo().toString();
    }

    public JSONObject fo() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("wc_skip_type", g());
            jSONObject.put("wc_miniapp_link", z());
            jSONObject.put("adv_id", dl());
            jSONObject.put("site_id", a());
            jSONObject.put("wc_open_method", m());
            jSONObject.put("wc_miniapp_sdk", e());
            jSONObject.put("wc_appid", gz());
        } catch (Throwable th) {
            com.bytedance.sdk.component.utils.wp.g("toString failed:" + th.getMessage());
        }
        return jSONObject;
    }

    public static ja z(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        ja jaVar = new ja();
        try {
            jaVar.z(jSONObject.optInt("wc_skip_type"));
            jaVar.z(jSONObject.optString("wc_miniapp_link"));
            jaVar.g(jSONObject.optString("adv_id"));
            jaVar.dl(jSONObject.optString("site_id"));
            jaVar.dl(jSONObject.optInt("wc_open_method"));
            jaVar.a(jSONObject.optString("wc_miniapp_sdk"));
            jaVar.gc(jSONObject.optString("wc_appid"));
        } catch (Throwable th) {
            com.bytedance.sdk.component.utils.wp.g("parse WechatData failed:" + th.getMessage());
        }
        return jaVar;
    }
}
