package com.bytedance.sdk.openadsdk.core.fv.z;

import java.lang.ref.WeakReference;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class kb extends com.bytedance.sdk.component.z.gc<JSONObject, JSONObject> {
    private WeakReference<com.bytedance.sdk.openadsdk.core.mc> z;

    public static void z(com.bytedance.sdk.component.z.p pVar, com.bytedance.sdk.openadsdk.core.mc mcVar) {
        pVar.z("getAppManage", (com.bytedance.sdk.component.z.gc<?, ?>) new kb(mcVar));
    }

    @Override // com.bytedance.sdk.component.z.gc
    public JSONObject z(JSONObject jSONObject, com.bytedance.sdk.component.z.m mVar) throws Exception {
        return dl();
    }

    public kb(com.bytedance.sdk.openadsdk.core.mc mcVar) {
        this.z = new WeakReference<>(mcVar);
    }

    public JSONObject dl() {
        com.bytedance.sdk.openadsdk.core.mc mcVar;
        JSONObject jSONObject = new JSONObject();
        try {
            WeakReference<com.bytedance.sdk.openadsdk.core.mc> weakReference = this.z;
            return (weakReference == null || (mcVar = weakReference.get()) == null) ? jSONObject : mcVar.uf();
        } catch (Throwable unused) {
            return jSONObject;
        }
    }
}
