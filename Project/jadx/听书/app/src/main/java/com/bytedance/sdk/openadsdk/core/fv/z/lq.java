package com.bytedance.sdk.openadsdk.core.fv.z;

import java.lang.ref.WeakReference;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class lq extends com.bytedance.sdk.component.z.gc<JSONObject, JSONObject> {
    private WeakReference<com.bytedance.sdk.openadsdk.core.mc> z;

    public static void z(com.bytedance.sdk.component.z.p pVar, com.bytedance.sdk.openadsdk.core.mc mcVar) {
        pVar.z("sendPlayableReward", (com.bytedance.sdk.component.z.gc<?, ?>) new lq(mcVar));
    }

    @Override // com.bytedance.sdk.component.z.gc
    public JSONObject z(JSONObject jSONObject, com.bytedance.sdk.component.z.m mVar) throws Exception {
        com.bytedance.sdk.openadsdk.core.mc mcVar;
        JSONObject jSONObject2 = new JSONObject();
        WeakReference<com.bytedance.sdk.openadsdk.core.mc> weakReference = this.z;
        if (weakReference != null && weakReference.get() != null && (mcVar = this.z.get()) != null) {
            mcVar.gk();
        }
        return jSONObject2;
    }

    public lq(com.bytedance.sdk.openadsdk.core.mc mcVar) {
        this.z = new WeakReference<>(mcVar);
    }
}
