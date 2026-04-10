package com.bytedance.sdk.openadsdk.fo.z;

import com.bytedance.sdk.component.z.a;
import com.bytedance.sdk.component.z.p;
import com.bytedance.sdk.openadsdk.core.iq.na;
import com.bytedance.sdk.openadsdk.core.mc;
import java.lang.ref.WeakReference;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class gc extends com.bytedance.sdk.component.z.a<JSONObject, JSONObject> {
    private WeakReference<mc> z;

    @Override // com.bytedance.sdk.component.z.a
    protected void a() {
    }

    public gc(mc mcVar) {
        this.z = new WeakReference<>(mcVar);
    }

    public static void z(p pVar, final mc mcVar) {
        pVar.z("openPrivacy", new a.g() { // from class: com.bytedance.sdk.openadsdk.fo.z.gc.1
            @Override // com.bytedance.sdk.component.z.a.g
            public com.bytedance.sdk.component.z.a z() {
                return new gc(mcVar);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.bytedance.sdk.component.z.a
    public void z(JSONObject jSONObject, com.bytedance.sdk.component.z.m mVar) throws Exception {
        mc mcVar;
        na naVarGz;
        WeakReference<mc> weakReference = this.z;
        if (weakReference == null || (mcVar = weakReference.get()) == null || (naVarGz = mcVar.gz()) == null) {
            return;
        }
        com.bytedance.sdk.openadsdk.core.un.m.z(mVar.getContext(), naVarGz);
        mcVar.mc();
    }
}
