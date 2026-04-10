package com.bytedance.sdk.openadsdk.core.live.gc;

import android.text.TextUtils;
import com.bytedance.sdk.openadsdk.core.iq.na;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class a {
    public static boolean z(String str) {
        if (TextUtils.isEmpty(str)) {
            return true;
        }
        try {
            JSONArray jSONArray = new JSONArray(str);
            int length = jSONArray.length();
            for (int i = 0; i < length; i++) {
                JSONObject jSONObject = jSONArray.getJSONObject(i);
                if (jSONObject != null) {
                    String strOptString = jSONObject.optString("name", null);
                    if (TextUtils.equals(strOptString, "ec_reward_gold") || TextUtils.equals(strOptString, "reward_gold") || TextUtils.equals(strOptString, "auth_reward_gold")) {
                        return false;
                    }
                }
            }
            return true;
        } catch (Throwable unused) {
            return true;
        }
    }

    public static boolean z(na naVar) {
        JSONObject jSONObjectGc;
        com.bytedance.sdk.openadsdk.core.ugeno.fo.z zVarL = naVar.l();
        return (zVarL == null || (jSONObjectGc = zVarL.gc()) == null || jSONObjectGc.optBoolean("landing_type", false)) ? false : true;
    }
}
