package com.bytedance.sdk.openadsdk.core.fo.z.g;

import android.content.Context;
import com.bytedance.sdk.openadsdk.core.iq.ja;
import com.bytedance.sdk.openadsdk.core.iq.na;
import com.umeng.analytics.pro.d;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@com.bytedance.sdk.component.kb.g.g
public class wp implements com.bytedance.sdk.component.kb.z.z.dl {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @com.bytedance.sdk.component.kb.g.z(z = "event_tag")
    private String f1053a;

    @com.bytedance.sdk.component.kb.g.z(z = "convert_from_landing_page")
    private boolean dl;

    @com.bytedance.sdk.component.kb.g.z(z = d.R)
    private Context g;

    @com.bytedance.sdk.component.kb.g.z(z = "wc_miniapp_info")
    private JSONObject gc;

    @com.bytedance.sdk.component.kb.g.z(z = "source")
    private int m;

    @com.bytedance.sdk.component.kb.g.z(z = "material_meta")
    private na z;

    @Override // com.bytedance.sdk.component.kb.z.z.dl
    public boolean z(Map<String, Object> map, Map<String, Object> map2, com.bytedance.sdk.component.kb.z.z zVar) {
        if (!z()) {
            zVar.g(map2);
            return true;
        }
        com.bytedance.sdk.openadsdk.core.fo.z.z.z.gz gzVar = new com.bytedance.sdk.openadsdk.core.fo.z.z.z.gz(ja.z(this.gc), this.g, this.dl, this.f1053a, map2, zVar, this.m);
        gzVar.z(this.z);
        if (gzVar.z(new HashMap())) {
            zVar.z(map2);
        } else {
            zVar.g(map2);
        }
        return true;
    }

    private boolean z() {
        return (this.z == null || this.g == null || this.gc == null) ? false : true;
    }
}
