package com.bytedance.sdk.openadsdk.core.fv.z;

import java.lang.ref.WeakReference;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class p extends com.bytedance.sdk.component.z.gc<JSONObject, JSONObject> {
    private WeakReference<com.bytedance.sdk.openadsdk.core.mc> z;

    public static void z(com.bytedance.sdk.component.z.p pVar, com.bytedance.sdk.openadsdk.core.mc mcVar) {
        pVar.z("getSendRewardStatus", (com.bytedance.sdk.component.z.gc<?, ?>) new p(mcVar));
    }

    @Override // com.bytedance.sdk.component.z.gc
    public JSONObject z(JSONObject jSONObject, com.bytedance.sdk.component.z.m mVar) throws Exception {
        com.bytedance.sdk.openadsdk.core.mc mcVar;
        JSONObject jSONObject2 = new JSONObject();
        WeakReference<com.bytedance.sdk.openadsdk.core.mc> weakReference = this.z;
        if (weakReference != null && weakReference.get() != null && (mcVar = this.z.get()) != null) {
            jSONObject2.put("isReward", mcVar.e());
        }
        return jSONObject2;
    }

    public p(com.bytedance.sdk.openadsdk.core.mc mcVar) {
        this.z = new WeakReference<>(mcVar);
    }
}
