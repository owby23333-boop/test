package com.bytedance.sdk.openadsdk.tg.d;

import org.json.JSONObject;

/* JADX INFO: loaded from: classes10.dex */
public abstract class e implements tg {
    protected com.bykv.vk.openvk.component.video.api.d.tg e;

    public void e(com.bykv.vk.openvk.component.video.api.d.tg tgVar) {
        this.e = tgVar;
    }

    public void e(JSONObject jSONObject) {
        try {
            com.bykv.vk.openvk.component.video.api.d.tg tgVar = this.e;
            if (tgVar == null || jSONObject == null) {
                return;
            }
            jSONObject.put("pitaya_cache_size", tgVar.bf());
            jSONObject.put("pitaya_code", this.e.d());
            jSONObject.put("pitaya_msg", this.e.tg());
            jSONObject.put("ext_plugin_code", this.e.e().optInt("ext_plugin_code"));
            jSONObject.put("package", this.e.e().optJSONObject("package"));
        } catch (Exception unused) {
        }
    }
}
