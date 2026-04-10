package com.bytedance.sdk.openadsdk.core.fv.z;

import com.bytedance.sdk.component.z.a;
import com.bytedance.sdk.openadsdk.core.iq.na;
import java.lang.ref.WeakReference;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class gk extends com.bytedance.sdk.component.z.a<JSONObject, JSONObject> {
    private WeakReference<com.bytedance.sdk.openadsdk.core.mc> z;

    @Override // com.bytedance.sdk.component.z.a
    protected void a() {
    }

    public static void z(com.bytedance.sdk.component.z.p pVar, final com.bytedance.sdk.openadsdk.core.mc mcVar) {
        pVar.z("commonConvert", new a.g() { // from class: com.bytedance.sdk.openadsdk.core.fv.z.gk.1
            @Override // com.bytedance.sdk.component.z.a.g
            public com.bytedance.sdk.component.z.a z() {
                return new gk(mcVar);
            }
        });
    }

    public gk(com.bytedance.sdk.openadsdk.core.mc mcVar) {
        this.z = new WeakReference<>(mcVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.bytedance.sdk.component.z.a
    public void z(JSONObject jSONObject, com.bytedance.sdk.component.z.m mVar) throws Exception {
        com.bytedance.sdk.openadsdk.core.ugeno.fo.z zVarL;
        JSONObject jSONObjectG;
        com.bytedance.sdk.openadsdk.core.uy.ls().t();
        JSONObject jSONObject2 = new JSONObject();
        try {
            WeakReference<com.bytedance.sdk.openadsdk.core.mc> weakReference = this.z;
            if (weakReference == null) {
                com.bytedance.sdk.openadsdk.core.q.v.z().z("commonConvert", "js", 1, jSONObject2);
                com.bytedance.sdk.openadsdk.core.live.g.z().a(null);
                return;
            }
            com.bytedance.sdk.openadsdk.core.mc mcVar = weakReference.get();
            if (mcVar == null) {
                dl();
                com.bytedance.sdk.openadsdk.core.q.v.z().z("commonConvert", "js", 2, jSONObject2);
                com.bytedance.sdk.openadsdk.core.live.g.z().a(null);
                return;
            }
            if (jSONObject == null) {
                com.bytedance.sdk.openadsdk.core.q.v.z().z("commonConvert", "js", 3, jSONObject2);
                com.bytedance.sdk.openadsdk.core.live.g.z().a(null);
                return;
            }
            na naVarZ = com.bytedance.sdk.openadsdk.core.z.z(jSONObject);
            int iOptInt = jSONObject.optInt("j_live_saas_param_interaction_type", -1);
            if (naVarZ == null) {
                com.bytedance.sdk.openadsdk.core.q.v.z().z("commonConvert", "js", 4, jSONObject2);
                com.bytedance.sdk.openadsdk.core.live.g.z().a(naVarZ);
                return;
            }
            naVarZ.z(true);
            jSONObject2.putOpt("live_interaction_type", Integer.valueOf(naVarZ.wm()));
            jSONObject2.putOpt("ext", naVarZ.vk());
            if (naVarZ.fb() == null && (zVarL = naVarZ.l()) != null && (jSONObjectG = zVarL.g()) != null) {
                naVarZ.z(com.bytedance.sdk.openadsdk.core.iq.i.z(jSONObjectG));
            }
            mcVar.z(naVarZ, iOptInt);
            com.bytedance.sdk.openadsdk.core.q.v.z().z("commonConvert", "js", 0, jSONObject2);
            com.bytedance.sdk.openadsdk.core.live.g.z().a(naVarZ);
            try {
                JSONObject jSONObject3 = new JSONObject();
                jSONObject3.put("code", 200);
                z(jSONObject3);
            } catch (Exception e) {
                com.bytedance.sdk.component.utils.wp.z("xeasy", e.getMessage());
            }
        } catch (Throwable th) {
            com.bytedance.sdk.openadsdk.core.q.v.z().z("commonConvert", "js", 0, jSONObject2);
            com.bytedance.sdk.openadsdk.core.live.g.z().a(null);
            throw th;
        }
    }
}
