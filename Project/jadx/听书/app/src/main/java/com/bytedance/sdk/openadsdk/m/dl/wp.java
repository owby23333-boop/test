package com.bytedance.sdk.openadsdk.m.dl;

import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class wp extends z {
    private long g;
    private String z;

    public wp(String str, long j) {
        this.z = str;
        this.g = j;
    }

    @Override // com.bytedance.sdk.openadsdk.m.dl.a
    public void a_(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        try {
            jSONObject.put("preload_url", this.z);
            jSONObject.put("preload_size", this.g);
            com.bykv.vk.openvk.component.video.api.dl.a aVarZ = z();
            if (aVarZ != null) {
                jSONObject.put("run_task_mills", aVarZ.z().optLong("run_task_mills"));
            }
            z(jSONObject);
        } catch (Throwable th) {
            com.bytedance.sdk.component.utils.wp.z(th);
        }
    }
}
