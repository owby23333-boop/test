package com.bytedance.sdk.openadsdk.core.fo.z.g;

import android.content.Context;
import android.view.View;
import com.bytedance.sdk.openadsdk.core.iq.na;
import com.umeng.analytics.pro.d;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
@com.bytedance.sdk.component.kb.g.g
public class kb implements com.bytedance.sdk.component.kb.z.z.dl {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @com.bytedance.sdk.component.kb.g.z(z = "dpa_tag")
    private String f1050a;

    @com.bytedance.sdk.component.kb.g.z(z = "event_tag")
    private String dl;

    @com.bytedance.sdk.component.kb.g.z(z = "handle_chain_data")
    private Map<String, Object> e;

    @com.bytedance.sdk.component.kb.g.z(z = d.R)
    private Context g;

    @com.bytedance.sdk.component.kb.g.z(z = "live_saas_interaction_type")
    private int gc = -1;

    @com.bytedance.sdk.component.kb.g.z(z = "view")
    private View m;

    @com.bytedance.sdk.component.kb.g.z(z = "material_meta")
    private na z;

    @Override // com.bytedance.sdk.component.kb.z.z.dl
    public boolean z(Map<String, Object> map, Map<String, Object> map2, com.bytedance.sdk.component.kb.z.z zVar) {
        if (!z()) {
            zVar.g(map2);
            return true;
        }
        com.bytedance.sdk.openadsdk.core.fo.z.z.z.m mVar = new com.bytedance.sdk.openadsdk.core.fo.z.z.z.m(this.z, this.g, this.dl, this.f1050a);
        int i = this.gc;
        if (i != -1) {
            mVar.g(i);
        }
        mVar.z(this.m);
        mVar.g(this.e);
        if (new com.bytedance.sdk.openadsdk.core.fo.z.z.z.g(new com.bytedance.sdk.openadsdk.core.fo.z.z.z.gc(mVar, this.z, zVar, map2, this.dl), this.g, this.z, this.dl, map2, zVar).z(new HashMap())) {
            zVar.z(map2);
            return false;
        }
        zVar.g(map2);
        return false;
    }

    private boolean z() {
        return (this.z == null || this.g == null) ? false : true;
    }
}
