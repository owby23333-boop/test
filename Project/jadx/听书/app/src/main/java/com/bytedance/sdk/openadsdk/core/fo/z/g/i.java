package com.bytedance.sdk.openadsdk.core.fo.z.g;

import android.content.Context;
import com.bytedance.sdk.openadsdk.core.iq.na;
import com.umeng.analytics.pro.d;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@com.bytedance.sdk.component.kb.g.g
public class i implements com.bytedance.sdk.component.kb.z.z.dl {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @com.bytedance.sdk.component.kb.g.z(z = "deep_link")
    private JSONObject f1049a;

    @com.bytedance.sdk.component.kb.g.z(z = "event_tag")
    private String dl;

    @com.bytedance.sdk.component.kb.g.z(z = "convert_from_downloader")
    private boolean e;

    @com.bytedance.sdk.component.kb.g.z(z = "download_adapter")
    private com.bytedance.sdk.openadsdk.core.kb.g.dl fo;

    @com.bytedance.sdk.component.kb.g.z(z = d.R)
    private Context g;

    @com.bytedance.sdk.component.kb.g.z(z = "app_info")
    private JSONObject gc;

    @com.bytedance.sdk.component.kb.g.z(z = "is_market_covert")
    private boolean gz;

    @com.bytedance.sdk.component.kb.g.z(z = "pip_controller")
    private com.bytedance.sdk.openadsdk.core.video.g.g kb;

    @com.bytedance.sdk.component.kb.g.z(z = "convert_from_landing_page")
    private boolean m;

    @com.bytedance.sdk.component.kb.g.z(z = "convert_tag")
    private String uy;

    @com.bytedance.sdk.component.kb.g.z(z = "material_meta")
    private na z;

    @Override // com.bytedance.sdk.component.kb.z.z.dl
    public boolean z(Map<String, Object> map, Map<String, Object> map2, com.bytedance.sdk.component.kb.z.z zVar) {
        com.bytedance.sdk.openadsdk.core.fo.z.z.z.e eVar = new com.bytedance.sdk.openadsdk.core.fo.z.z.z.e(com.bytedance.sdk.openadsdk.core.z.g(this.gc), this.g);
        eVar.z(this.z);
        eVar.z(this.dl);
        com.bytedance.sdk.openadsdk.core.fo.z.z.z.dl dlVar = new com.bytedance.sdk.openadsdk.core.fo.z.z.z.dl(eVar, this.z, this.dl, new com.bytedance.sdk.openadsdk.core.iq.ls(this.f1049a), this.g);
        dlVar.g(this.e);
        dlVar.z(this.m);
        dlVar.dl(this.gz);
        dlVar.z(this.fo);
        dlVar.z(this.uy);
        dlVar.z(this.kb);
        if (dlVar.z(map2)) {
            zVar.z(map2);
            return true;
        }
        zVar.g(map2);
        return true;
    }
}
