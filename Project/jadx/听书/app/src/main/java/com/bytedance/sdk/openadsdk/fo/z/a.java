package com.bytedance.sdk.openadsdk.fo.z;

import com.bytedance.sdk.component.z.a;
import com.bytedance.sdk.component.z.p;
import com.bytedance.sdk.openadsdk.core.iq.na;
import com.bytedance.sdk.openadsdk.core.mc;
import com.bytedance.sdk.openadsdk.core.uy;
import java.lang.ref.WeakReference;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class a extends com.bytedance.sdk.component.z.a<JSONObject, JSONObject> {
    private WeakReference<mc> z;

    @Override // com.bytedance.sdk.component.z.a
    protected void a() {
    }

    public static void z(p pVar, final mc mcVar) {
        pVar.z("adInfoDialog", new a.g() { // from class: com.bytedance.sdk.openadsdk.fo.z.a.1
            @Override // com.bytedance.sdk.component.z.a.g
            public com.bytedance.sdk.component.z.a z() {
                return new a(mcVar);
            }
        });
    }

    public a(mc mcVar) {
        this.z = new WeakReference<>(mcVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.bytedance.sdk.component.z.a
    public void z(JSONObject jSONObject, com.bytedance.sdk.component.z.m mVar) throws Exception {
        na naVarGz;
        uy.ls().t();
        mc mcVar = this.z.get();
        if (mcVar == null || (naVarGz = mcVar.gz()) == null) {
            return;
        }
        com.bytedance.sdk.openadsdk.core.un.m.z(mVar.getContext(), naVarGz.nv());
    }
}
