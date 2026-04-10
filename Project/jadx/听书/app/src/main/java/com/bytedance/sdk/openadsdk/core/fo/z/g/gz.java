package com.bytedance.sdk.openadsdk.core.fo.z.g;

import android.content.Context;
import com.bytedance.sdk.openadsdk.core.iq.na;
import com.umeng.analytics.pro.d;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
@com.bytedance.sdk.component.kb.g.g
public class gz implements com.bytedance.sdk.component.kb.z.z.dl {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @com.bytedance.sdk.component.kb.g.z(z = "is_app_market_convert")
    private boolean f1048a;

    @com.bytedance.sdk.component.kb.g.z(z = "material_meta")
    private na dl;

    @com.bytedance.sdk.component.kb.g.z(z = "download_url")
    private String e;

    @com.bytedance.sdk.component.kb.g.z(z = "is_show_download_dialog")
    private boolean fo = true;

    @com.bytedance.sdk.component.kb.g.z(z = d.R)
    private Context g;

    @com.bytedance.sdk.component.kb.g.z(z = "app_manage_model")
    private com.bytedance.sdk.openadsdk.core.iq.a gc;

    @com.bytedance.sdk.component.kb.g.z(z = "start_download_listener")
    private com.bytedance.sdk.openadsdk.core.kb.dl.z.g gz;

    @com.bytedance.sdk.component.kb.g.z(z = "download_dialog_listener")
    private com.bytedance.sdk.openadsdk.core.kb.dl.z.z i;

    @com.bytedance.sdk.component.kb.g.z(z = "dynamic_download_dialog_type")
    private int kb;

    @com.bytedance.sdk.component.kb.g.z(z = "event_tag")
    private String m;

    @com.bytedance.sdk.component.kb.g.z(z = "is_from_new_click_event")
    private boolean uy;

    @com.bytedance.sdk.component.kb.g.z(z = "is_direct_download")
    private boolean wp;

    @com.bytedance.sdk.component.kb.g.z(z = "convert_from_landing_page")
    protected boolean z;

    @Override // com.bytedance.sdk.component.kb.z.z.dl
    public boolean z(Map<String, Object> map, Map<String, Object> map2, com.bytedance.sdk.component.kb.z.z zVar) {
        com.bytedance.sdk.openadsdk.core.kb.dl.dl.dl dlVar = new com.bytedance.sdk.openadsdk.core.kb.dl.dl.dl(this.g, this.dl);
        dlVar.dl(this.wp);
        dlVar.z(this.fo);
        dlVar.z(this.kb);
        dlVar.g(this.uy);
        dlVar.z(this.i);
        dlVar.z(z());
        if (!dlVar.a(false)) {
            zVar.g(map2);
            return true;
        }
        dlVar.z(this.gc, this.m, this.e, this.gz);
        zVar.z(map2);
        return true;
    }

    private com.bytedance.sdk.openadsdk.core.kb.dl.dl.z z() {
        if (this.f1048a) {
            return new com.bytedance.sdk.openadsdk.core.kb.dl.dl.gc();
        }
        if (this.z) {
            return new com.bytedance.sdk.openadsdk.core.kb.dl.dl.a();
        }
        return new com.bytedance.sdk.openadsdk.core.kb.dl.dl.g();
    }
}
