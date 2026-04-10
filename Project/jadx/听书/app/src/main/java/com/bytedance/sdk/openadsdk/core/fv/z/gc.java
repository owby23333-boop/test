package com.bytedance.sdk.openadsdk.core.fv.z;

import java.lang.ref.WeakReference;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class gc extends com.bytedance.sdk.component.z.gc<JSONObject, JSONObject> {
    private WeakReference<com.bytedance.sdk.openadsdk.core.mc> z;

    public static void z(com.bytedance.sdk.component.z.p pVar, com.bytedance.sdk.openadsdk.core.mc mcVar) {
        pVar.z("changePlaySpeedRatio", (com.bytedance.sdk.component.z.gc<?, ?>) new gc(mcVar));
    }

    public gc(com.bytedance.sdk.openadsdk.core.mc mcVar) {
        this.z = new WeakReference<>(mcVar);
    }

    @Override // com.bytedance.sdk.component.z.gc
    public JSONObject z(JSONObject jSONObject, com.bytedance.sdk.component.z.m mVar) throws Exception {
        WeakReference<com.bytedance.sdk.openadsdk.core.mc> weakReference = this.z;
        if (weakReference == null || weakReference.get() == null) {
            return new JSONObject();
        }
        float fOptDouble = (float) jSONObject.optDouble("ratio");
        if (fOptDouble > 0.0f && fOptDouble <= 3.0f) {
            this.z.get().z(fOptDouble);
        }
        return new JSONObject();
    }
}
