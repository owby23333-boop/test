package com.bytedance.sdk.openadsdk.core.iq;

import android.text.TextUtils;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class un {
    public JSONObject z;

    public String toString() {
        JSONObject jSONObject = this.z;
        return jSONObject == null ? "" : jSONObject.toString();
    }

    public String z() {
        JSONObject jSONObject = this.z;
        JSONObject jSONObjectOptJSONObject = jSONObject == null ? null : jSONObject.optJSONObject("performance_js");
        return jSONObjectOptJSONObject != null ? jSONObjectOptJSONObject.optString("url") : "";
    }

    public static un z(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            return z(new JSONObject(str));
        } catch (JSONException unused) {
            return null;
        }
    }

    public static un z(JSONObject jSONObject) {
        un unVar = new un();
        unVar.z = jSONObject;
        return unVar;
    }
}
