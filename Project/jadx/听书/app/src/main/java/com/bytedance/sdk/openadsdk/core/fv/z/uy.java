package com.bytedance.sdk.openadsdk.core.fv.z;

import com.bytedance.sdk.openadsdk.core.iq.na;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class uy extends com.bytedance.sdk.component.z.gc<JSONObject, JSONObject> {
    private List<JSONObject> g;
    private na z;

    public static void z(com.bytedance.sdk.component.z.p pVar, na naVar, List<JSONObject> list) {
        pVar.z("getAdsData", (com.bytedance.sdk.component.z.gc<?, ?>) new uy(naVar, list));
    }

    public uy(na naVar, List<JSONObject> list) {
        this.z = naVar;
        this.g = list;
    }

    @Override // com.bytedance.sdk.component.z.gc
    public JSONObject z(JSONObject jSONObject, com.bytedance.sdk.component.z.m mVar) throws Exception {
        JSONObject jSONObject2 = new JSONObject();
        int iOptInt = jSONObject != null ? jSONObject.optInt("ads_num", 3) : -1;
        if (iOptInt < 0) {
            iOptInt = 3;
        }
        JSONObject jSONObject3 = new JSONObject();
        jSONObject3.put("creatives", new JSONArray().put(this.z.kv()));
        jSONObject2.put("firstRes", jSONObject3);
        JSONArray jSONArray = new JSONArray();
        List<JSONObject> list = this.g;
        if (list != null && list.size() > 0) {
            if (iOptInt > this.g.size()) {
                iOptInt = this.g.size();
            }
            int iMin = Math.min(iOptInt, 3);
            for (int i = 0; i < iMin; i++) {
                jSONArray.put(i, this.g.get(i));
            }
        }
        JSONObject jSONObject4 = new JSONObject();
        jSONObject4.put("creatives", jSONArray);
        jSONObject2.put("secondRes", jSONObject4);
        JSONObject jSONObject5 = new JSONObject();
        jSONObject5.put("data", jSONObject2);
        return jSONObject5;
    }
}
