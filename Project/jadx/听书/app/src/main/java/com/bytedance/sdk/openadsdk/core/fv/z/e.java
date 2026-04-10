package com.bytedance.sdk.openadsdk.core.fv.z;

import com.bytedance.sdk.component.z.a;
import java.lang.ref.WeakReference;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class e extends com.bytedance.sdk.component.z.a<JSONObject, JSONObject> {
    private WeakReference<com.bytedance.sdk.openadsdk.core.mc> z;

    @Override // com.bytedance.sdk.component.z.a
    protected void a() {
    }

    public static void z(com.bytedance.sdk.component.z.p pVar, final com.bytedance.sdk.openadsdk.core.mc mcVar) {
        pVar.z("newClickEvent", new a.g() { // from class: com.bytedance.sdk.openadsdk.core.fv.z.e.1
            @Override // com.bytedance.sdk.component.z.a.g
            public com.bytedance.sdk.component.z.a z() {
                return new e(mcVar);
            }
        });
    }

    public e(com.bytedance.sdk.openadsdk.core.mc mcVar) {
        this.z = new WeakReference<>(mcVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.bytedance.sdk.component.z.a
    public void z(JSONObject jSONObject, com.bytedance.sdk.component.z.m mVar) throws Exception {
        com.bytedance.sdk.openadsdk.core.mc mcVar = this.z.get();
        if (mcVar == null) {
            dl();
        } else {
            mcVar.fo(jSONObject);
        }
    }
}
