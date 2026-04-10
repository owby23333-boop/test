package com.bytedance.sdk.openadsdk.m.dl;

import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public abstract class z implements a {
    private com.bykv.vk.openvk.component.video.api.dl.a z;

    public void z(com.bykv.vk.openvk.component.video.api.dl.a aVar) {
        this.z = aVar;
    }

    public com.bykv.vk.openvk.component.video.api.dl.a z() {
        return this.z;
    }

    protected void z(JSONObject jSONObject) {
        try {
            com.bykv.vk.openvk.component.video.api.dl.a aVar = this.z;
            if (aVar == null || jSONObject == null) {
                return;
            }
            JSONObject jSONObjectZ = aVar.z();
            jSONObject.put("pitaya_cache_size", this.z.g());
            jSONObject.put("pitaya_code", this.z.dl());
            jSONObject.put("pitaya_msg", this.z.a());
            jSONObject.put("ext_plugin_code", jSONObjectZ.optInt("ext_plugin_code"));
            jSONObject.put("package", jSONObjectZ.optJSONObject("package"));
        } catch (Exception unused) {
        }
    }
}
