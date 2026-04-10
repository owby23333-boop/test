package com.bytedance.sdk.openadsdk.core.iq;

import com.bytedance.sdk.openadsdk.api.plugin.PluginConstants;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class wj {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f1203a;
    private String dl;
    private int g;
    private int z;

    public static wj z(String str) {
        try {
            return z(new JSONObject(str));
        } catch (JSONException e) {
            com.bytedance.sdk.component.utils.wp.g("LiveSdkConfig", "parse failed:".concat(String.valueOf(e)));
            return new wj();
        }
    }

    public static wj z(JSONObject jSONObject) {
        wj wjVar = new wj();
        wjVar.z(jSONObject.optInt("ad_live_status"));
        wjVar.g(jSONObject.optInt(PluginConstants.KEY_APP_ID));
        wjVar.g(jSONObject.optString("partner"));
        wjVar.dl(jSONObject.optString("secure_key"));
        return wjVar;
    }

    public String toString() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("ad_live_status", z());
            jSONObject.put(PluginConstants.KEY_APP_ID, g());
            jSONObject.put("partner", dl());
            jSONObject.put("secure_key", a());
        } catch (JSONException e) {
            com.bytedance.sdk.component.utils.wp.z(e);
        }
        return jSONObject.toString();
    }

    public int z() {
        return this.z;
    }

    public int g() {
        return this.g;
    }

    public String dl() {
        return this.dl;
    }

    public String a() {
        return this.f1203a;
    }

    public void z(int i) {
        this.z = i;
    }

    public void g(int i) {
        this.g = i;
    }

    public void g(String str) {
        this.dl = str;
    }

    public void dl(String str) {
        this.f1203a = str;
    }

    public boolean gc() {
        return this.z == 1;
    }
}
