package com.bytedance.sdk.openadsdk.core.fv.z;

import android.text.TextUtils;
import com.bytedance.sdk.openadsdk.core.p.z;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class v extends com.bytedance.sdk.component.z.gc<JSONObject, JSONObject> {
    public static void z(com.bytedance.sdk.component.z.p pVar) {
        pVar.z("getDownloadStatus", (com.bytedance.sdk.component.z.gc<?, ?>) new v());
    }

    @Override // com.bytedance.sdk.component.z.gc
    public JSONObject z(JSONObject jSONObject, com.bytedance.sdk.component.z.m mVar) throws Exception {
        return z(jSONObject);
    }

    public static JSONObject z(JSONObject jSONObject) {
        JSONObject jSONObject2 = new JSONObject();
        if (jSONObject == null) {
            z(jSONObject2, 1, "params is null", 1, 1);
            return jSONObject2;
        }
        try {
            String strOptString = jSONObject.optString("ad_down_load_id");
            if (TextUtils.isEmpty(strOptString)) {
                z(jSONObject2, 1, "ad_down_load_id is null", 1, 1);
                return jSONObject2;
            }
            return z.C0193z.z(strOptString);
        } catch (Throwable unused) {
            return jSONObject2;
        }
    }

    private static void z(JSONObject jSONObject, int i, String str, int i2, int i3) {
        if (jSONObject == null) {
            return;
        }
        try {
            jSONObject.put("code", i);
            jSONObject.put("codeMsg", str);
            jSONObject.put("downloadStatus", i2);
            jSONObject.put("downloadProcessRate", i3);
        } catch (Exception unused) {
        }
    }
}
