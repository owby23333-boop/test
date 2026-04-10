package com.bytedance.sdk.openadsdk.fo.z;

import com.bytedance.sdk.component.z.p;
import com.bytedance.sdk.openadsdk.core.mc;
import java.lang.ref.WeakReference;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class dl extends com.bytedance.sdk.component.z.gc<JSONObject, JSONObject> {
    private WeakReference<mc> z;

    public static void z(p pVar, mc mcVar) {
        pVar.z("rewardPlayAgain", (com.bytedance.sdk.component.z.gc<?, ?>) new dl(mcVar));
    }

    @Override // com.bytedance.sdk.component.z.gc
    public JSONObject z(JSONObject jSONObject, com.bytedance.sdk.component.z.m mVar) throws Exception {
        mc mcVar;
        JSONObject jSONObject2 = new JSONObject();
        WeakReference<mc> weakReference = this.z;
        if (weakReference == null || weakReference.get() == null || (mcVar = this.z.get()) == null) {
            return jSONObject2;
        }
        mcVar.fv();
        return jSONObject2;
    }

    public dl(mc mcVar) {
        this.z = new WeakReference<>(mcVar);
    }
}
