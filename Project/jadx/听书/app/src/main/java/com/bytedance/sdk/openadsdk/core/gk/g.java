package com.bytedance.sdk.openadsdk.core.gk;

import com.bytedance.sdk.component.utils.wp;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public final class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private JSONObject f1109a;
    private String g;
    private boolean z;
    private long dl = 0;
    private boolean gc = a.g;

    public static g z(JSONObject jSONObject) {
        g gVar = new g();
        if (jSONObject != null) {
            gVar.z(jSONObject.optString("ec_mall_back_url"));
            gVar.z = jSONObject.optBoolean("sub_process", false);
            gVar.dl = jSONObject.optLong("init_delay", a.z);
            gVar.f1109a = jSONObject.optJSONObject("live_tob_init_extra");
            gVar.z(jSONObject.optString("ec_mall_back_url"));
            gVar.gc = jSONObject.optBoolean("init_after_click", a.g);
        }
        return gVar;
    }

    public String toString() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("ec_mall_back_url", this.g);
            jSONObject.put("sub_process", this.z);
            jSONObject.put("init_delay", this.dl);
            jSONObject.put("live_tob_init_extra", this.f1109a);
            jSONObject.put("init_after_click", this.gc);
        } catch (Exception e) {
            wp.g("AppLiveConfig", e);
        }
        return jSONObject.toString();
    }

    public boolean z() {
        return this.z;
    }

    public long g() {
        return this.dl;
    }

    public JSONObject dl() {
        return this.f1109a;
    }

    public String a() {
        return this.g;
    }

    public void z(String str) {
        this.g = str;
    }

    public boolean gc() {
        return this.gc;
    }
}
