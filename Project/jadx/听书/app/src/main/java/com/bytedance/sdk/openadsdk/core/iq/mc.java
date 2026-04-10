package com.bytedance.sdk.openadsdk.core.iq;

import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class mc {
    private int g;
    private boolean z;

    public mc(JSONObject jSONObject) {
        JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("landing_page_conf");
        if (jSONObjectOptJSONObject != null) {
            this.z = jSONObjectOptJSONObject.optInt("swipe_back_type", 0) == 1;
            this.g = jSONObjectOptJSONObject.optInt("filter_track", 0);
        }
    }

    public void z(JSONObject jSONObject) {
        JSONObject jSONObject2 = new JSONObject();
        try {
            jSONObject2.put("swipe_back_type", this.z ? 1 : 0);
            jSONObject2.put("filter_track", this.g);
        } catch (JSONException e) {
            com.bytedance.sdk.component.utils.wp.z(e);
        }
        try {
            jSONObject.put("landing_page_conf", jSONObject2);
        } catch (JSONException e2) {
            com.bytedance.sdk.component.utils.wp.z(e2);
        }
    }

    private static mc dl(na naVar) {
        if (naVar == null) {
            return null;
        }
        return naVar.cn();
    }

    public static boolean z(na naVar) {
        mc mcVarDl = dl(naVar);
        if (mcVarDl == null) {
            return false;
        }
        return mcVarDl.z;
    }

    public static boolean g(na naVar) {
        mc mcVarDl = dl(naVar);
        return mcVarDl != null && mcVarDl.g == 1;
    }
}
