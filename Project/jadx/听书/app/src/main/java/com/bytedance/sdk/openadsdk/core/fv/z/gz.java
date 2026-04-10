package com.bytedance.sdk.openadsdk.core.fv.z;

import com.bytedance.sdk.openadsdk.core.iq.na;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class gz extends com.bytedance.sdk.component.z.gc<JSONObject, JSONObject> {
    private String dl;
    private com.bytedance.sdk.openadsdk.core.mc g;
    private na z;

    public static void z(com.bytedance.sdk.component.z.p pVar, na naVar, com.bytedance.sdk.openadsdk.core.mc mcVar) {
        pVar.z("getEstimatedInteractionAreaInfo", (com.bytedance.sdk.component.z.gc<?, ?>) new gz(naVar, mcVar, "getEstimatedInteractionAreaInfo"));
        pVar.z("interactionAreaInfo", (com.bytedance.sdk.component.z.gc<?, ?>) new gz(naVar, mcVar, "interactionAreaInfo"));
    }

    public gz(na naVar, com.bytedance.sdk.openadsdk.core.mc mcVar, String str) {
        this.z = naVar;
        this.g = mcVar;
        this.dl = str;
    }

    @Override // com.bytedance.sdk.component.z.gc
    public JSONObject z(JSONObject jSONObject, com.bytedance.sdk.component.z.m mVar) throws Exception {
        com.bytedance.sdk.openadsdk.core.iq.pf pfVarZ;
        com.bytedance.sdk.openadsdk.core.iq.pf pfVarZ2;
        JSONObject jSONObject2;
        com.bytedance.sdk.openadsdk.core.ugeno.component.interact.fo foVarDl = this.g.dl();
        String str = this.dl;
        str.hashCode();
        if (str.equals("interactionAreaInfo")) {
            JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("areas");
            if (jSONArrayOptJSONArray == null || jSONArrayOptJSONArray.length() <= 0 || (jSONObject2 = jSONArrayOptJSONArray.getJSONObject(0)) == null) {
                pfVarZ = null;
                pfVarZ2 = null;
            } else {
                pfVarZ = com.bytedance.sdk.openadsdk.core.iq.pf.z(jSONObject2);
                if (foVarDl != null) {
                    foVarDl.setEasyPlayInteractionAreaInfo(pfVarZ);
                    pfVarZ2 = com.bytedance.sdk.openadsdk.core.iq.pf.z(foVarDl.getEstimatedInteractionAreaInfo());
                } else {
                    pfVarZ2 = null;
                }
            }
            if (pfVarZ2 == null) {
                if (foVarDl != null) {
                    foVarDl.z(com.bytedance.sdk.openadsdk.core.iq.pf.g(null, pfVarZ), 1.0d);
                    this.g.z("canMakeVisiable", (JSONObject) null);
                }
            } else if (pfVarZ == null) {
                foVarDl.z(null, -1.0d);
                foVarDl.dl();
                this.g.z("expressWebviewRecycle", (JSONObject) null);
            } else {
                double dZ = com.bytedance.sdk.openadsdk.core.iq.pf.z(pfVarZ2, pfVarZ);
                double d = pfVarZ.dl * pfVarZ.f1189a;
                double d2 = pfVarZ2.dl * pfVarZ2.f1189a;
                if (d2 == 0.0d) {
                    foVarDl.z(com.bytedance.sdk.openadsdk.core.iq.pf.g(pfVarZ2, pfVarZ), 1.0d);
                    this.g.z("canMakeVisiable", (JSONObject) null);
                    return null;
                }
                if (d == 0.0d) {
                    foVarDl.z(null, -1.0d);
                    foVarDl.dl();
                    this.g.z("expressWebviewRecycle", (JSONObject) null);
                    return null;
                }
                double d3 = dZ / d;
                boolean z = d3 >= 0.8d;
                com.bytedance.sdk.component.utils.wp.z("xeasy", "A:" + d2 + " B:" + d + " o:" + dZ + " R:" + d3);
                if (!z) {
                    foVarDl.z(null, -1.0d);
                    foVarDl.dl();
                    this.g.z("expressWebviewRecycle", (JSONObject) null);
                    return null;
                }
                foVarDl.z(com.bytedance.sdk.openadsdk.core.iq.pf.g(pfVarZ2, pfVarZ), (dZ - d2) / d2);
                this.g.z("canMakeVisiable", (JSONObject) null);
                return null;
            }
        } else if (str.equals("getEstimatedInteractionAreaInfo") && foVarDl != null) {
            return foVarDl.getEstimatedInteractionAreaInfo();
        }
        return null;
    }
}
