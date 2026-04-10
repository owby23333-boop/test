package com.bytedance.sdk.openadsdk.core.fv.z;

import com.bytedance.sdk.openadsdk.core.iq.na;
import com.bytedance.sdk.openadsdk.core.iq.oq;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class pf extends com.bytedance.sdk.component.z.gc<JSONObject, JSONObject> {
    private na z;

    public pf(na naVar) {
        this.z = naVar;
    }

    public static void z(com.bytedance.sdk.component.z.p pVar, na naVar) {
        pVar.z("getLiveSaasAuthStatus", (com.bytedance.sdk.component.z.gc<?, ?>) new pf(naVar));
    }

    @Override // com.bytedance.sdk.component.z.gc
    public JSONObject z(JSONObject jSONObject, com.bytedance.sdk.component.z.m mVar) throws Exception {
        oq oqVarZ;
        na naVar;
        JSONObject jSONObject2 = new JSONObject();
        com.bytedance.sdk.openadsdk.core.iq.ls lsVar = null;
        if (jSONObject != null) {
            try {
                oqVarZ = oq.z(jSONObject.optJSONObject("live_info"));
                JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("deep_link");
                if (jSONObjectOptJSONObject != null) {
                    lsVar = new com.bytedance.sdk.openadsdk.core.iq.ls(jSONObjectOptJSONObject);
                }
            } catch (Throwable th) {
                com.bytedance.sdk.component.utils.wp.a("glsas", "method:" + th.getMessage());
            }
        } else {
            oqVarZ = null;
        }
        if (lsVar == null && (naVar = this.z) != null) {
            lsVar = naVar.vy();
        }
        if (oqVarZ == null) {
            oqVarZ = this.z.mg();
        }
        boolean z = true;
        jSONObject2.put("has_live_silent_auth", oqVarZ != null && oqVarZ.dl());
        jSONObject2.put("has_install_douyin", com.bytedance.sdk.openadsdk.core.live.gc.z.z(lsVar));
        jSONObject2.put("has_live_authed", com.bytedance.sdk.openadsdk.core.live.g.z().gc() == 2);
        boolean z2 = oqVarZ != null && oqVarZ.a();
        if (z2) {
            if (com.bytedance.sdk.openadsdk.core.live.g.z().dl() != 2) {
                z = false;
            }
            z2 = z;
        }
        jSONObject2.put("has_playable_auth_switch", z2);
        JSONObject jSONObject3 = new JSONObject();
        if (oqVarZ != null) {
            jSONObject3.put("aweme_agreements", oqVarZ.gc());
            jSONObject3.put("aweme_privacy", oqVarZ.m());
        }
        jSONObject2.put("aweme_auth_protocol", jSONObject3);
        return jSONObject2;
    }
}
