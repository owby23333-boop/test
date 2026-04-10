package com.bytedance.sdk.openadsdk.core.g.z.dl;

import android.content.Context;
import android.view.View;
import com.bytedance.sdk.openadsdk.core.iq.fo;
import com.bytedance.sdk.openadsdk.core.iq.hh;
import com.bytedance.sdk.openadsdk.core.iq.na;
import com.bytedance.sdk.openadsdk.core.iq.uy;
import com.bytedance.sdk.openadsdk.core.pf.a;
import com.bytedance.sdk.openadsdk.core.un.eo;
import com.bytedance.sdk.openadsdk.core.un.oq;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public class z extends g {
    protected String e;
    protected fo gc;
    protected boolean gz;
    private String kb;
    protected Map<String, Object> m;
    private com.bytedance.sdk.openadsdk.core.video.g.g wp;
    private int fo = -1;
    private int uy = -1;
    private boolean i = false;

    public void z(boolean z) {
        this.i = z;
    }

    public void z(String str) {
        this.e = str;
    }

    public void g(boolean z) {
        this.gz = z;
    }

    public void z() {
        this.fo = 1;
    }

    public void g() {
        this.uy = 1;
    }

    public void g(String str) {
        this.kb = str;
    }

    public String dl() {
        return this.kb;
    }

    public void z(fo foVar) {
        this.gc = foVar;
    }

    public z() {
    }

    public z(na naVar, Context context) {
        this.z = naVar;
        this.g = context;
        this.m = new HashMap();
    }

    @Override // com.bytedance.sdk.openadsdk.core.g.z.dl.g, com.bytedance.sdk.openadsdk.core.g.z.z
    public int z(Map<String, Object> map, com.bytedance.sdk.openadsdk.core.g.z.dl dlVar) {
        if (this.i) {
            return 0;
        }
        com.bytedance.sdk.openadsdk.core.video.g.g gVar = this.wp;
        if (gVar != null && gVar.kb() == 1) {
            return 0;
        }
        if (this.dl == null) {
            this.dl = new uy();
        }
        if ("splash_ad".equals(this.e) || "cache_splash_ad".equals(this.e) || "splash_ad_landingpage".equals(this.e)) {
            this.fo = this.fo == 1 ? 1 : 0;
        }
        Object obj = map.get("convert_res");
        boolean zBooleanValue = obj instanceof Boolean ? ((Boolean) obj).booleanValue() : false;
        if (this.gc == null) {
            this.gc = a();
        }
        Object obj2 = map.get("is_reward_live");
        if (obj2 instanceof Boolean ? ((Boolean) obj2).booleanValue() : false) {
            m();
        }
        if (map.containsKey("reward_browse_banner_from")) {
            this.m.put("refer", MediationConstant.RIT_TYPE_BANNER);
        }
        if (hh.z(this.z) && !a.z(String.valueOf(eo.fo(this.z))) && this.z.dp() != null) {
            this.m.put("refresh_num", Integer.valueOf(this.z.dp().dl()));
        }
        Object obj3 = map.get("click_saas_action");
        if (obj3 != null && (obj3 instanceof Integer)) {
            this.m.put("click_saas_action", obj3);
        }
        Object obj4 = map.get("click_saas_area");
        if (obj3 != null && (obj3 instanceof Integer)) {
            this.m.put("click_saas_area", obj4);
        }
        z(true);
        com.bytedance.sdk.openadsdk.core.i.a.z("click", this.z, this.gc, this.e, zBooleanValue, this.m, this.dl.gc() ? 1 : 2, this.gz);
        return 0;
    }

    protected fo a() {
        int i = this.fo;
        if (i != -1) {
            this.fo = -1;
        } else {
            i = -1;
        }
        float fM = oq.m(this.g);
        int iGz = oq.gz(this.g);
        float fE = oq.e(this.g);
        View viewE = this.dl.e();
        View viewM = this.dl.m();
        return new fo.z().m(this.dl.v()).gc(this.dl.pf()).a(this.dl.ls()).dl(this.dl.p()).g(this.dl.wp()).z(this.dl.i()).g(oq.z(viewE)).z(oq.z(viewM)).dl(oq.dl(viewE)).a(oq.dl(viewM)).dl(this.dl.g()).a(this.dl.dl()).gc(this.dl.a()).z(this.dl.uy()).g(com.bytedance.sdk.openadsdk.core.uy.ls().dl() ? 1 : 2).z(this.kb).z(fM).z(iGz).g(fE).m(i).e(this.uy).gz(this.dl.js()).gc(this.dl.fv()).z(this.dl.z()).z();
    }

    public void z(Map<String, Object> map) {
        Map<String, Object> map2 = this.m;
        if (map2 == null) {
            this.m = map;
        } else {
            map2.putAll(map);
        }
    }

    public Map<String, Object> gc() {
        return this.m;
    }

    private void m() {
        com.bytedance.sdk.component.a.g.dl dlVarZ = com.bytedance.sdk.openadsdk.core.g.z();
        long j = dlVarZ.get("click_to_live_duration", 0L);
        if (j == 0) {
            Map<String, Object> map = this.m;
            if (map != null) {
                map.remove("click_livead_duration");
                return;
            }
            return;
        }
        long jCurrentTimeMillis = System.currentTimeMillis() - j;
        HashMap map2 = new HashMap();
        map2.put("click_livead_duration", Long.valueOf(jCurrentTimeMillis));
        z(map2);
        dlVarZ.get("click_to_live_duration", 0L);
    }

    public void z(com.bytedance.sdk.openadsdk.core.video.g.g gVar) {
        this.wp = gVar;
    }
}
