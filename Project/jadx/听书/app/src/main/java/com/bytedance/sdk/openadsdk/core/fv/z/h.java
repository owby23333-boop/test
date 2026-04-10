package com.bytedance.sdk.openadsdk.core.fv.z;

import java.lang.ref.WeakReference;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class h extends com.bytedance.sdk.component.z.gc<JSONObject, JSONObject> {
    private WeakReference<com.bytedance.sdk.openadsdk.core.ugeno.e.g> g;
    private com.bytedance.sdk.openadsdk.core.mc z;

    public static void z(com.bytedance.sdk.component.z.p pVar, com.bytedance.sdk.openadsdk.core.mc mcVar, WeakReference<com.bytedance.sdk.openadsdk.core.ugeno.e.g> weakReference) {
        pVar.z("resumeRewardCountDown", (com.bytedance.sdk.component.z.gc<?, ?>) new h(mcVar, weakReference));
    }

    public h(com.bytedance.sdk.openadsdk.core.mc mcVar, WeakReference<com.bytedance.sdk.openadsdk.core.ugeno.e.g> weakReference) {
        this.z = mcVar;
        this.g = weakReference;
    }

    @Override // com.bytedance.sdk.component.z.gc
    public JSONObject z(JSONObject jSONObject, com.bytedance.sdk.component.z.m mVar) throws Exception {
        JSONObject jSONObject2 = new JSONObject();
        WeakReference<com.bytedance.sdk.openadsdk.core.ugeno.e.g> weakReference = this.g;
        if (weakReference != null && weakReference.get() != null) {
            this.g.get().g();
            jSONObject2.put("success", true);
        } else {
            jSONObject2.put("success", false);
        }
        return jSONObject2;
    }
}
