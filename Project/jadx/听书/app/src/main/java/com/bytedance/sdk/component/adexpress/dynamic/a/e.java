package com.bytedance.sdk.component.adexpress.dynamic.a;

import com.bytedance.sdk.component.adexpress.g.i;
import com.bytedance.sdk.component.utils.wp;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class e implements gz {
    private com.bytedance.sdk.component.adexpress.dynamic.gc.g z;

    @Override // com.bytedance.sdk.component.adexpress.dynamic.a.gz
    public void z(com.bytedance.sdk.component.adexpress.dynamic.gc.g gVar) {
        this.z = gVar;
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.a.gz
    public void z(final i iVar) {
        if (iVar.pf() == 1) {
            g(iVar);
        } else {
            com.bytedance.sdk.component.adexpress.a.gc.z(new com.bytedance.sdk.component.uy.fo("dynamicparse") { // from class: com.bytedance.sdk.component.adexpress.dynamic.a.e.1
                @Override // java.lang.Runnable
                public void run() {
                    e.this.g(iVar);
                }
            }, 5);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g(i iVar) {
        try {
            JSONObject jSONObjectGc = iVar.gc();
            JSONObject jSONObject = new JSONObject(jSONObjectGc.optString("template_Plugin"));
            JSONObject jSONObjectOptJSONObject = jSONObjectGc.optJSONObject("creative");
            com.bytedance.sdk.component.adexpress.dynamic.dl.gz gzVarZ = new m(jSONObject, jSONObjectOptJSONObject, jSONObjectGc.optJSONObject("AdSize"), new JSONObject(jSONObjectGc.optString("diff_template_Plugin"))).z(iVar.a(), iVar.i(), jSONObjectOptJSONObject.optDouble("score_exact_i18n"), jSONObjectOptJSONObject.optString("comment_num_i18n"), iVar);
            try {
                JSONObject jSONObject2 = new JSONObject(jSONObjectOptJSONObject.optString("dynamic_creative"));
                gzVarZ.z(jSONObject2.optString("color"));
                gzVarZ.z(jSONObject2.optJSONArray("material_center"));
            } catch (Throwable unused) {
            }
            this.z.z(gzVarZ);
        } catch (Exception e) {
            wp.z(e);
        }
    }
}
