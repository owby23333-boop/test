package com.bytedance.sdk.openadsdk.core.fv.z;

import com.bytedance.sdk.component.z.a;
import com.bytedance.sdk.openadsdk.core.iq.na;
import java.lang.ref.WeakReference;
import java.util.List;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class m extends com.bytedance.sdk.component.z.a<JSONObject, JSONObject> {
    private com.bytedance.sdk.openadsdk.core.js.dl dl;
    private na g;
    private WeakReference<com.bytedance.sdk.openadsdk.core.mc> z;

    @Override // com.bytedance.sdk.component.z.a
    protected void a() {
    }

    public static void z(com.bytedance.sdk.component.z.p pVar, final com.bytedance.sdk.openadsdk.core.mc mcVar, final na naVar) {
        pVar.z("getNetworkData", new a.g() { // from class: com.bytedance.sdk.openadsdk.core.fv.z.m.1
            @Override // com.bytedance.sdk.component.z.a.g
            public com.bytedance.sdk.component.z.a z() {
                return new m(mcVar, naVar);
            }
        });
    }

    public m(com.bytedance.sdk.openadsdk.core.mc mcVar, na naVar) {
        this.z = new WeakReference<>(mcVar);
        this.g = naVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.bytedance.sdk.component.z.a
    public void z(JSONObject jSONObject, com.bytedance.sdk.component.z.m mVar) throws Exception {
        com.bytedance.sdk.openadsdk.core.mc mcVar = this.z.get();
        if (mcVar == null) {
            dl();
            return;
        }
        final long jCurrentTimeMillis = System.currentTimeMillis();
        this.dl = new com.bytedance.sdk.openadsdk.core.js.dl() { // from class: com.bytedance.sdk.openadsdk.core.fv.z.m.2
            @Override // com.bytedance.sdk.openadsdk.core.js.dl
            public void z(boolean z, List<na> list, boolean z2) {
                try {
                    JSONObject jSONObject2 = new JSONObject();
                    if (!z) {
                        m.this.z(jSONObject2);
                    } else {
                        jSONObject2.put("creatives", com.bytedance.sdk.openadsdk.core.mc.z(list));
                        jSONObject2.put("is_cache", z2);
                        if (z2) {
                            jSONObject2.put("prefetch_opt_time", jCurrentTimeMillis - com.bytedance.sdk.openadsdk.core.playable.g.z().dl(m.this.g));
                        }
                        m.this.z(jSONObject2);
                    }
                    com.bytedance.sdk.openadsdk.core.uy.ls().t();
                } catch (Throwable th) {
                    com.bytedance.sdk.component.utils.wp.dl("DoGetAdsFromNetwork", "onAdLoaded error", th);
                }
            }
        };
        if ((jSONObject != null && jSONObject.optBoolean("is_first_request", false)) && com.bytedance.sdk.openadsdk.core.playable.g.z().z(this.g, this.dl)) {
            return;
        }
        mcVar.z(jSONObject, this.dl);
    }
}
