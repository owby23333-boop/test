package com.bytedance.sdk.openadsdk.core.tb;

import com.bytedance.sdk.openadsdk.core.mc;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class gc implements com.bytedance.sdk.openadsdk.v.dl {
    mc z;

    public gc(mc mcVar) {
        this.z = mcVar;
    }

    @Override // com.bytedance.sdk.openadsdk.v.dl
    public void z(String str, JSONObject jSONObject) {
        mc mcVar = this.z;
        if (mcVar != null) {
            mcVar.z(str, jSONObject);
        }
    }
}
