package com.bytedance.msdk.gz;

import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class e {
    public static JSONObject z() {
        Map<String, com.bytedance.msdk.z.z.a> mapG = com.bytedance.msdk.m.g.g.z().g();
        if (mapG == null) {
            return null;
        }
        JSONObject jSONObject = new JSONObject();
        for (Map.Entry<String, com.bytedance.msdk.z.z.a> entry : mapG.entrySet()) {
            if (entry.getKey() != null) {
                String[] strArrSplit = entry.getKey().split("\\.");
                if (strArrSplit.length >= 5) {
                    try {
                        jSONObject.put(strArrSplit[4] + "Adapter", entry.getValue().z());
                    } catch (JSONException e) {
                        com.bytedance.sdk.component.utils.wp.z(e);
                    }
                }
            }
        }
        return jSONObject;
    }
}
