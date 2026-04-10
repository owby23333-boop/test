package com.bytedance.sdk.openadsdk.core.fv.z;

import androidx.media3.extractor.text.ttml.TtmlNode;
import com.bytedance.sdk.openadsdk.core.iq.na;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class fo extends com.bytedance.sdk.component.z.gc<JSONObject, JSONObject> {
    private com.bytedance.sdk.openadsdk.core.mc g;
    private na z;

    public static void z(com.bytedance.sdk.component.z.p pVar, na naVar, com.bytedance.sdk.openadsdk.core.mc mcVar) {
        pVar.z("adViewInfo", (com.bytedance.sdk.component.z.gc<?, ?>) new fo(naVar, mcVar));
    }

    public fo(na naVar, com.bytedance.sdk.openadsdk.core.mc mcVar) {
        this.z = naVar;
        this.g = mcVar;
    }

    @Override // com.bytedance.sdk.component.z.gc
    public JSONObject z(JSONObject jSONObject, com.bytedance.sdk.component.z.m mVar) throws Exception {
        JSONObject jSONObject2 = new JSONObject();
        jSONObject2.put(TtmlNode.RUBY_CONTAINER, this.g.z());
        jSONObject2.put("creative", this.g.g());
        return jSONObject2;
    }
}
