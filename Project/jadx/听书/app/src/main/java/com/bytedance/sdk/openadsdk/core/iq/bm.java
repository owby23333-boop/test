package com.bytedance.sdk.openadsdk.core.iq;

import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class bm {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f1152a;
    private String dl;
    private int g;
    private boolean gc;
    private JSONObject z;

    public bm(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.z = jSONObject;
            this.g = jSONObject.optInt("dialog_type");
            this.dl = jSONObject.optString("template_url");
            this.f1152a = jSONObject.optString("template_md5");
        }
        com.bytedance.sdk.openadsdk.core.ugeno.m.z zVar = new com.bytedance.sdk.openadsdk.core.ugeno.m.z();
        zVar.g(gc());
        zVar.dl(a());
    }

    public JSONObject z() {
        return this.z;
    }

    public JSONObject g() {
        return this.z;
    }

    public int dl() {
        return this.g;
    }

    public String a() {
        return this.dl;
    }

    public String gc() {
        return this.f1152a;
    }

    public boolean m() {
        return this.gc;
    }

    public void z(boolean z) {
        this.gc = z;
    }
}
