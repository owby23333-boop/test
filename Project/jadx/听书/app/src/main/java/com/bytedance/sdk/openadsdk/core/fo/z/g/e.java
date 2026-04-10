package com.bytedance.sdk.openadsdk.core.fo.z.g;

import android.content.Context;
import android.text.TextUtils;
import com.bytedance.sdk.openadsdk.core.iq.na;
import com.bytedance.sdk.openadsdk.core.iq.tb;
import com.umeng.analytics.pro.d;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@com.bytedance.sdk.component.kb.g.g
public class e implements com.bytedance.sdk.component.kb.z.z.dl {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @com.bytedance.sdk.component.kb.g.z(z = "event_tag")
    protected String f1044a;

    @com.bytedance.sdk.component.kb.g.z(z = "convert_from_landing_page")
    protected volatile boolean dl = false;

    @com.bytedance.sdk.component.kb.g.z(z = "need_check_compliance")
    private int e = 0;

    @com.bytedance.sdk.component.kb.g.z(z = "is_click_button")
    private volatile boolean fo;

    @com.bytedance.sdk.component.kb.g.z(z = d.R)
    protected Context g;

    @com.bytedance.sdk.component.kb.g.z(z = "download_status_listener")
    protected com.ss.android.z.z.dl.a gc;

    @com.bytedance.sdk.component.kb.g.z(z = "is_open_oppo_market_auto_download")
    private volatile boolean gz;

    @com.bytedance.sdk.component.kb.g.z(z = "dialog_to_landing_page_convert")
    private com.bytedance.sdk.openadsdk.core.fo.z.z.z i;

    @com.bytedance.sdk.component.kb.g.z(z = "download_conf")
    private JSONObject kb;

    @com.bytedance.sdk.component.kb.g.z(z = "download_popup_manager")
    protected com.bytedance.sdk.openadsdk.core.kb.dl.dl.dl m;

    @com.bytedance.sdk.component.kb.g.z(z = "download_url")
    private String uy;

    @com.bytedance.sdk.component.kb.g.z(z = "pip_controller")
    private com.bytedance.sdk.openadsdk.core.video.g.g v;

    @com.bytedance.sdk.component.kb.g.z(z = "app_info")
    private JSONObject wp;

    @com.bytedance.sdk.component.kb.g.z(z = "material_meta")
    protected na z;

    @Override // com.bytedance.sdk.component.kb.z.z.dl
    public boolean z(Map<String, Object> map, Map<String, Object> map2, com.bytedance.sdk.component.kb.z.z zVar) {
        if (!z()) {
            zVar.g(map2);
            return true;
        }
        int iDl = com.bytedance.sdk.openadsdk.core.fo.z.z.z.z.dl(map2);
        com.bytedance.sdk.openadsdk.core.fo.z.z.z.a aVar = new com.bytedance.sdk.openadsdk.core.fo.z.z.z.a(this.z, this.g, this.f1044a, this.m, this.uy);
        aVar.g(this.fo);
        aVar.z(this.gz, iDl);
        aVar.z(this.gc);
        aVar.z(this.dl);
        aVar.z(this.e);
        aVar.z(this.i);
        aVar.z(new tb(this.kb));
        if (new com.bytedance.sdk.openadsdk.core.fo.z.z.g.g(aVar, this.v).z(map2)) {
            zVar.z(map2);
        } else {
            zVar.g(map2);
        }
        return true;
    }

    private boolean z() {
        if (this.z == null || this.g == null) {
            return false;
        }
        if (!TextUtils.isEmpty(this.uy)) {
            return (TextUtils.isEmpty(this.f1044a) || this.m == null) ? false : true;
        }
        com.bytedance.sdk.openadsdk.core.iq.gc gcVarG = com.bytedance.sdk.openadsdk.core.z.g(this.wp);
        if (gcVarG != null) {
            this.uy = gcVarG.g();
        }
        return false;
    }
}
