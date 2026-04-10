package com.bytedance.sdk.openadsdk.core.dt;

import org.json.JSONObject;

/* JADX INFO: loaded from: classes10.dex */
public class fl {
    private int bf;
    private String d;
    private JSONObject e;
    private boolean ga;
    private String tg;

    public fl(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.e = jSONObject;
            this.bf = jSONObject.optInt("dialog_type");
            this.d = jSONObject.optString("template_url");
            this.tg = jSONObject.optString("template_md5");
        }
        com.bytedance.sdk.openadsdk.core.ugeno.ga.e eVar = new com.bytedance.sdk.openadsdk.core.ugeno.ga.e();
        eVar.bf(ga());
        eVar.d(tg());
    }

    public JSONObject bf() {
        return this.e;
    }

    public int d() {
        return this.bf;
    }

    public JSONObject e() {
        return this.e;
    }

    public String ga() {
        return this.tg;
    }

    public String tg() {
        return this.d;
    }

    public boolean vn() {
        return this.ga;
    }

    public void e(boolean z) {
        this.ga = z;
    }
}
