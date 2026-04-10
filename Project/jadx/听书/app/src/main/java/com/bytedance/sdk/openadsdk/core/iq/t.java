package com.bytedance.sdk.openadsdk.core.iq;

import android.text.TextUtils;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class t {
    private int z;

    public t(JSONObject jSONObject) {
        this.z = 0;
        if (jSONObject == null) {
            return;
        }
        this.z = jSONObject.optInt("playable_reward_type", 0);
    }

    public void z(JSONObject jSONObject) {
        try {
            jSONObject.put("playable_reward_type", this.z);
        } catch (JSONException e) {
            com.bytedance.sdk.component.utils.wp.z(e);
        }
    }

    private static t g(na naVar) {
        if (naVar == null) {
            return null;
        }
        return naVar.y();
    }

    public static int z(na naVar) {
        int i;
        t tVarG = g(naVar);
        if (tVarG == null || (i = tVarG.z) < 0 || i > 1) {
            return 0;
        }
        if (!TextUtils.isEmpty(com.bytedance.sdk.openadsdk.core.zw.g().oq()) || js.kb(naVar)) {
            return tVarG.z;
        }
        return 1;
    }

    public static int z(na naVar, int i) {
        com.bykv.vk.openvk.component.video.api.dl.dl dlVarZ = tf.z(naVar, i);
        String strFo = dlVarZ != null ? dlVarZ.fo() : null;
        try {
            if (TextUtils.isEmpty(strFo)) {
                return 0;
            }
            String[] strArrSplit = strFo.split("x");
            if (strArrSplit.length < 2) {
                return 0;
            }
            if (Integer.parseInt(strArrSplit[0]) > Integer.parseInt(strArrSplit[1])) {
                return 1;
            }
        } catch (Exception unused) {
        }
        return 0;
    }
}
