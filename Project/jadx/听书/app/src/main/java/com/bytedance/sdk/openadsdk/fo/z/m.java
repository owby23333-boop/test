package com.bytedance.sdk.openadsdk.fo.z;

import com.bytedance.sdk.component.z.p;
import com.bytedance.sdk.openadsdk.core.mc;
import java.lang.ref.WeakReference;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class m extends com.bytedance.sdk.component.z.gc<JSONObject, JSONObject> {
    private WeakReference<mc> z;

    public static void z(p pVar, mc mcVar) {
        pVar.z("startVideoTransform", (com.bytedance.sdk.component.z.gc<?, ?>) new m(mcVar));
    }

    @Override // com.bytedance.sdk.component.z.gc
    public JSONObject z(JSONObject jSONObject, com.bytedance.sdk.component.z.m mVar) throws Exception {
        mc mcVar;
        JSONObject jSONObjectOptJSONObject;
        JSONObject jSONObject2 = new JSONObject();
        WeakReference<mc> weakReference = this.z;
        if (weakReference == null || weakReference.get() == null || jSONObject == null || (mcVar = this.z.get()) == null || (jSONObjectOptJSONObject = jSONObject.optJSONObject("videoInfo")) == null) {
            return jSONObject2;
        }
        mcVar.z((float) jSONObjectOptJSONObject.optDouble("toX"), (float) jSONObjectOptJSONObject.optDouble("toY"), (float) jSONObjectOptJSONObject.optDouble("pivotX"), (float) jSONObjectOptJSONObject.optDouble("pivotY"), jSONObject.optInt("duration"));
        return jSONObject2;
    }

    public m(mc mcVar) {
        this.z = new WeakReference<>(mcVar);
    }
}
