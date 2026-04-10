package com.bytedance.sdk.openadsdk.core.dt;

import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes10.dex */
public class a {
    private boolean bf;
    private boolean d;
    private String e;
    private String ga;
    private String tg;
    private String vn;

    public static a e(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        a aVar = new a();
        aVar.e = jSONObject.optString("promotion_id");
        aVar.bf = jSONObject.optBoolean("is_silent_auth", false);
        aVar.d = jSONObject.optBoolean("enable_playable_auth", false);
        aVar.tg = jSONObject.optString("aweme_agreements");
        aVar.ga = jSONObject.optString("aweme_privacy");
        aVar.vn = jSONObject.optString("live_csj_libra_param");
        return aVar;
    }

    public String bf() {
        return this.e;
    }

    public boolean d() {
        return this.bf;
    }

    public String ga() {
        return this.tg;
    }

    public String p() {
        return this.vn;
    }

    public boolean tg() {
        return this.d;
    }

    public String vn() {
        return this.ga;
    }

    public JSONObject e() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("promotion_id", this.e);
            jSONObject.put("is_silent_auth", this.bf);
            jSONObject.put("enable_playable_auth", this.d);
            jSONObject.put("aweme_agreements", this.tg);
            jSONObject.put("aweme_privacy", this.ga);
            jSONObject.put("live_csj_libra_param", this.vn);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jSONObject;
    }
}
