package com.bytedance.sdk.gromore.z.z.e.a;

import android.app.Activity;
import android.app.Dialog;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import com.bytedance.msdk.api.a.z.e.gz;
import com.bytedance.msdk.api.a.z.e.uy;
import com.bytedance.msdk.core.gz.i;
import com.bytedance.msdk.core.gz.kb;
import com.bytedance.msdk.dl.a.fo;
import com.bytedance.msdk.gz.js;
import com.bytedance.msdk.gz.p;
import com.bytedance.sdk.component.utils.wp;
import com.bytedance.sdk.openadsdk.ls.dl.g.e;
import com.bytedance.sdk.openadsdk.ls.dl.g.v;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class a extends v {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private View f873a;
    private com.bytedance.msdk.api.z.g dl;
    private com.bytedance.sdk.openadsdk.ls.dl.z.dl e;
    private com.bytedance.sdk.openadsdk.ls.dl.z.g fo;
    private com.bytedance.msdk.g.dl g;
    private com.bytedance.sdk.openadsdk.uf.z.g.z.dl gc;
    private com.bytedance.sdk.openadsdk.mediation.ad.z.g.z.g gz;
    private com.bytedance.sdk.openadsdk.uf.z.g.z.g m;
    private fo z;

    @Override // com.bytedance.sdk.openadsdk.ls.dl.g.v
    public void e() {
    }

    @Override // com.bytedance.sdk.openadsdk.ls.dl.g.gz
    public void g(Double d) {
    }

    @Override // com.bytedance.sdk.openadsdk.ls.dl.g.gz
    public void z(Double d) {
    }

    @Override // com.bytedance.sdk.openadsdk.ls.dl.g.gz
    public void z(Double d, String str, String str2) {
    }

    @Override // com.bytedance.sdk.openadsdk.ls.dl.g.v
    public void z(JSONObject jSONObject) {
    }

    public a(fo foVar, com.bytedance.msdk.g.dl dlVar, com.bytedance.msdk.api.z.g gVar, com.bytedance.sdk.openadsdk.mediation.ad.z.g.z.g gVar2) {
        this.z = foVar;
        this.gz = gVar2;
        this.g = dlVar;
        if (dlVar != null && dlVar.j() == 3) {
            this.g.e(true);
        }
        this.dl = gVar;
        uy();
    }

    private void uy() {
        com.bytedance.msdk.g.dl dlVar = this.g;
        if (dlVar == null) {
            return;
        }
        dlVar.z(new gz() { // from class: com.bytedance.sdk.gromore.z.z.e.a.a.1
            @Override // com.bytedance.msdk.api.a.z.e.gz
            public void z() {
                if (a.this.gc != null) {
                    a.this.gc.z();
                }
            }

            @Override // com.bytedance.msdk.api.a.z.e.gz
            public void g() {
                if (a.this.gc != null) {
                    a.this.gc.g();
                }
            }

            @Override // com.bytedance.msdk.api.a.z.e.gz
            public void dl() {
                if (a.this.gc != null) {
                    a.this.gc.dl();
                }
            }

            @Override // com.bytedance.msdk.api.a.z.e.gz
            public void a() {
                if (a.this.gc != null) {
                    a.this.gc.a();
                }
            }

            @Override // com.bytedance.msdk.api.a.z.e.gz
            public void gc() {
                if (a.this.gc != null) {
                    a.this.gc.gc();
                }
            }

            @Override // com.bytedance.msdk.api.a.z.e.gz
            public void z(com.bytedance.msdk.api.z zVar) {
                String strG;
                long jCurrentTimeMillis;
                long jCurrentTimeMillis2 = System.currentTimeMillis();
                if (js.z(a.this.g)) {
                    strG = js.g();
                    jCurrentTimeMillis = System.currentTimeMillis() - jCurrentTimeMillis2;
                } else {
                    strG = null;
                    jCurrentTimeMillis = -1;
                }
                com.bytedance.msdk.gc.m.z(a.this.g, a.this.dl, (com.bytedance.msdk.api.z) null, 2, 0, strG, jCurrentTimeMillis);
                if (zVar == null || a.this.gc == null) {
                    return;
                }
                a.this.gc.z(zVar.z, -1);
            }

            @Override // com.bytedance.msdk.api.a.z.e.gz
            public void z(long j, long j2) {
                if (a.this.gc != null) {
                    a.this.gc.z(j, j2);
                }
            }
        });
        this.g.z(new com.bytedance.msdk.api.a.z.g() { // from class: com.bytedance.sdk.gromore.z.z.e.a.a.2
            @Override // com.bytedance.msdk.api.a.z.g
            public void g() {
            }

            @Override // com.bytedance.msdk.api.a.z.g
            public void z() {
                if (a.this.e != null) {
                    a.this.e.z();
                }
            }

            @Override // com.bytedance.msdk.api.a.z.g
            public void z(long j, long j2, int i, int i2, String str, String str2) {
                if (a.this.e != null) {
                    a.this.e.z(j, j2, str, str2);
                }
            }

            @Override // com.bytedance.msdk.api.a.z.g
            public void z(long j, long j2, String str, String str2) {
                if (a.this.e != null) {
                    a.this.e.g(j, j2, str, str2);
                }
            }

            @Override // com.bytedance.msdk.api.a.z.g
            public void g(long j, long j2, String str, String str2) {
                if (a.this.e != null) {
                    a.this.e.dl(j, j2, str, str2);
                }
            }

            @Override // com.bytedance.msdk.api.a.z.g
            public void z(long j, String str, String str2) {
                if (a.this.e != null) {
                    a.this.e.z(j, str, str2);
                }
            }

            @Override // com.bytedance.msdk.api.a.z.g
            public void z(String str, String str2) {
                if (a.this.e != null) {
                    a.this.e.z(str, str2);
                }
            }
        });
    }

    @Override // com.bytedance.sdk.openadsdk.ls.dl.g.v
    public int dl() {
        com.bytedance.msdk.g.dl dlVar = this.g;
        if (dlVar != null) {
            return dlVar.me();
        }
        return -1;
    }

    @Override // com.bytedance.sdk.openadsdk.ls.dl.g.v
    public View z() {
        com.bytedance.msdk.g.dl dlVar = this.g;
        if (dlVar != null) {
            if (dlVar.tc()) {
                com.bytedance.msdk.gc.m.z(this.dl);
                if (this.g.pc() != null) {
                    this.g.pc().z();
                }
                com.bytedance.msdk.g.dl dlVar2 = this.g;
                com.bytedance.msdk.gc.m.z(dlVar2, this.dl, dlVar2.gk(), 0);
                View viewFo = this.g.fo();
                this.f873a = viewFo;
                return viewFo;
            }
            ArrayList arrayList = new ArrayList(1);
            arrayList.add(this.g);
            com.bytedance.msdk.gc.m.z(arrayList, this.dl, 0);
        }
        return null;
    }

    @Override // com.bytedance.sdk.openadsdk.ls.dl.g.v
    public int g() {
        com.bytedance.msdk.g.dl dlVar = this.g;
        if (dlVar != null) {
            return dlVar.nh();
        }
        return -1;
    }

    @Override // com.bytedance.sdk.openadsdk.ls.dl.g.v
    public void z(com.bytedance.sdk.openadsdk.uf.z.g.z.g gVar) {
        this.m = gVar;
    }

    @Override // com.bytedance.sdk.openadsdk.ls.dl.g.v
    public void z(com.bytedance.sdk.openadsdk.uf.z.g.z.z zVar) {
        this.m = zVar;
    }

    @Override // com.bytedance.sdk.openadsdk.ls.dl.g.v
    public Map<String, Object> gz() {
        com.bytedance.msdk.g.dl dlVar = this.g;
        if (dlVar == null) {
            return null;
        }
        Map<String, Object> mapH = dlVar.h();
        if (mapH == null) {
            com.bytedance.msdk.api.z.g gVar = this.dl;
            mapH = com.bytedance.msdk.dl.a.g.dl(gVar != null ? gVar.zw() : "");
        }
        if (this.g.sv() && p.z()) {
            String strZ = p.z(com.bytedance.msdk.gz.v.z(this.dl, this.g, true));
            if (!TextUtils.isEmpty(strZ)) {
                mapH.put("get_show_ecpm_info", strZ);
            }
        }
        return com.bytedance.sdk.gromore.z.g.g.z(mapH, this.g.ec());
    }

    @Override // com.bytedance.sdk.openadsdk.ls.dl.g.v
    public void z(com.bytedance.sdk.openadsdk.ls.dl.z.dl dlVar) {
        this.e = dlVar;
    }

    @Override // com.bytedance.sdk.openadsdk.ls.dl.g.v
    public void a() {
        com.bytedance.sdk.openadsdk.uf.z.g.z.g gVar;
        com.bytedance.msdk.g.dl dlVar = this.g;
        if (dlVar != null) {
            if (dlVar.tc()) {
                ls();
                this.g.kb();
                z(this.g);
                if (this.g.j() != 3 || (gVar = this.m) == null) {
                    return;
                }
                gVar.z((View) null, -1.0f, -2.0f);
                return;
            }
            com.bytedance.sdk.openadsdk.mediation.ad.z.g.z.g gVar2 = this.gz;
            if (gVar2 != null) {
                try {
                    View viewZ = gVar2.z(new com.bytedance.sdk.gromore.z.z.a.fo(this.g) { // from class: com.bytedance.sdk.gromore.z.z.e.a.a.3
                        @Override // com.bytedance.sdk.gromore.z.z.a.fo, com.bytedance.sdk.openadsdk.mediation.ad.z.g.g.z
                        public void z(final Activity activity, final ViewGroup viewGroup, final List<View> list, final List<View> list2, final List<View> list3, final com.bytedance.sdk.openadsdk.mediation.ad.z.g.z.a aVar) {
                            a.this.z(true, new Handler.Callback() { // from class: com.bytedance.sdk.gromore.z.z.e.a.a.3.1
                                @Override // android.os.Handler.Callback
                                public boolean handleMessage(Message message) {
                                    if (a.this.g == null) {
                                        return false;
                                    }
                                    a.this.g.z(activity, viewGroup, list, list2, list3, uy.z(aVar), null);
                                    return false;
                                }
                            });
                        }
                    });
                    this.f873a = viewZ;
                    if (viewZ == null) {
                        com.bytedance.msdk.z.gc.dl.z("TTMediationSDK", "--==-- 自渲染信息流转模板，getMediationBannerViewFromNativeAd()返回null，将无法展示该广告");
                        com.bytedance.sdk.openadsdk.uf.z.g.z.g gVar3 = this.m;
                        if (gVar3 != null) {
                            gVar3.z((View) null, "渲染失败", -99999);
                            return;
                        }
                        return;
                    }
                    com.bytedance.sdk.openadsdk.uf.z.g.z.g gVar4 = this.m;
                    if (gVar4 != null) {
                        gVar4.z(viewZ, 0.0f, 0.0f);
                        return;
                    }
                    return;
                } catch (Throwable th) {
                    com.bytedance.msdk.z.gc.dl.z("TTMediationSDK", "--==-- 自渲染信息流转模板，getMediationBannerViewFromNativeAd()发生异常，将无法展示该广告，信息如下：");
                    wp.z(th);
                    return;
                }
            }
            com.bytedance.msdk.z.gc.dl.z("TTMediationSDK", "--==-- 自渲染信息流转模板，开发者未提供MediationNativeToBannerListener，将无法展示该广告");
        }
    }

    @Override // com.bytedance.sdk.openadsdk.ls.dl.g.v
    public com.bytedance.sdk.openadsdk.ls.dl.g.a m() {
        com.bytedance.msdk.g.dl dlVar = this.g;
        if (dlVar != null) {
            return dlVar.he();
        }
        return null;
    }

    @Override // com.bytedance.sdk.openadsdk.ls.dl.g.v
    public e z(Activity activity) {
        com.bytedance.msdk.g.dl dlVar = this.g;
        if (dlVar != null) {
            return dlVar.z(activity);
        }
        return null;
    }

    @Override // com.bytedance.sdk.openadsdk.ls.dl.g.v
    public void z(Activity activity, com.bytedance.sdk.openadsdk.js.z.g.z.z zVar) {
        com.bytedance.msdk.g.dl dlVar = this.g;
        if (dlVar == null || activity == null) {
            return;
        }
        dlVar.z(activity, zVar);
    }

    @Override // com.bytedance.sdk.openadsdk.ls.dl.g.v
    public void z(Dialog dialog, Integer[] numArr) {
        com.bytedance.msdk.g.dl dlVar = this.g;
        if (dlVar != null) {
            dlVar.z(dialog, numArr);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.ls.dl.g.v
    public void z(String str) {
        com.bytedance.msdk.g.dl dlVar = this.g;
        if (dlVar != null) {
            dlVar.ti(str);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.ls.dl.g.v
    public void z(int i) {
        com.bytedance.msdk.g.dl dlVar = this.g;
        if (dlVar != null) {
            dlVar.zw(i);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.ls.dl.g.v
    public void z(com.bytedance.sdk.openadsdk.uf.z.g.z.dl dlVar) {
        this.gc = dlVar;
    }

    @Override // com.bytedance.sdk.openadsdk.ls.dl.g.v
    public void z(boolean z) {
        com.bytedance.msdk.g.dl dlVar = this.g;
        if (dlVar != null) {
            dlVar.uy(z);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.ls.dl.g.v
    public void gc() {
        com.bytedance.msdk.g.dl dlVar = this.g;
        if (dlVar != null) {
            try {
                dlVar.fv();
            } catch (Throwable th) {
                wp.z(th);
            }
        }
    }

    @Override // com.bytedance.sdk.openadsdk.ls.dl.g.v
    public com.bytedance.sdk.openadsdk.mediation.manager.z.g.z.gc fo() {
        return new com.bytedance.sdk.gromore.z.z.a.uy(new dl(this.z, this.g, this.dl));
    }

    @Override // com.bytedance.sdk.openadsdk.ls.dl.g.gz
    public void z(com.bytedance.sdk.openadsdk.ls.dl.z.g gVar) {
        this.fo = gVar;
        com.bytedance.msdk.g.dl dlVar = this.g;
        if (dlVar != null) {
            dlVar.z(gVar);
        }
    }

    private void kb() {
        com.bytedance.msdk.g.dl dlVar = this.g;
        if (dlVar == null) {
            return;
        }
        dlVar.z((com.bytedance.msdk.z.g.m) new com.bytedance.msdk.z.g.z() { // from class: com.bytedance.sdk.gromore.z.z.e.a.a.4
            @Override // com.bytedance.msdk.api.a.z.z.z
            public void z(com.bytedance.msdk.api.z zVar) {
            }

            @Override // com.bytedance.msdk.api.a.z.z.z
            public void f_() {
                if (a.this.g.js() != null) {
                    a.this.g.js().z(0, "banner ad closed", false);
                }
            }

            @Override // com.bytedance.msdk.api.a.z.z.z
            public void z(View view) {
                if (a.this.m != null) {
                    a.this.m.z(view, 0);
                }
                a.this.pf();
            }

            @Override // com.bytedance.msdk.api.a.z.z.z
            public void g(View view) {
                a.this.z(view);
            }
        });
    }

    private void i() {
        com.bytedance.msdk.g.dl dlVar = this.g;
        if (dlVar == null) {
            return;
        }
        if (dlVar.tc()) {
            this.g.z((com.bytedance.msdk.api.a.z.dl.z) new com.bytedance.msdk.api.a.z.dl.a() { // from class: com.bytedance.sdk.gromore.z.z.e.a.a.5
                @Override // com.bytedance.msdk.api.a.z.dl.a
                public void z(View view, String str, int i) {
                    if (a.this.m != null) {
                        a.this.m.z(view, str, i);
                    }
                }

                @Override // com.bytedance.msdk.api.a.z.dl.a
                public void z(float f, float f2) {
                    if (a.this.m != null) {
                        a.this.m.z((View) null, f, f2);
                    }
                }

                @Override // com.bytedance.msdk.api.a.z.dl.z
                public void z(View view) {
                    if (a.this.m != null) {
                        a.this.m.z(view, 0);
                    }
                    a.this.pf();
                }

                @Override // com.bytedance.msdk.api.a.z.dl.z
                public void z() {
                    a.this.z((View) null);
                }
            });
        } else {
            this.g.z(new com.bytedance.msdk.api.a.z.dl.z() { // from class: com.bytedance.sdk.gromore.z.z.e.a.a.6
                @Override // com.bytedance.msdk.api.a.z.dl.z
                public void z(View view) {
                    if (a.this.m != null) {
                        a.this.m.z(view, 0);
                    }
                    a.this.pf();
                }

                @Override // com.bytedance.msdk.api.a.z.dl.z
                public void z() {
                    a.this.z((View) null);
                }
            });
        }
    }

    private void v() {
        com.bytedance.msdk.g.dl dlVar = this.g;
        if (dlVar == null) {
            return;
        }
        if (dlVar.tc()) {
            this.g.z((com.bytedance.msdk.api.a.z.e.g) new com.bytedance.msdk.api.a.z.e.m() { // from class: com.bytedance.sdk.gromore.z.z.e.a.a.7
                @Override // com.bytedance.msdk.api.a.z.e.m
                public void z(View view, String str, int i) {
                    if (a.this.m != null) {
                        a.this.m.z(view, str, i);
                    }
                }

                @Override // com.bytedance.msdk.api.a.z.e.m
                public void z(float f, float f2) {
                    if (a.this.m != null) {
                        a.this.m.z((View) null, f, f2);
                    }
                }

                @Override // com.bytedance.msdk.api.a.z.e.g
                public void z(View view) {
                    if (a.this.m != null) {
                        a.this.m.z(view, 0);
                    }
                    a.this.pf();
                }

                @Override // com.bytedance.msdk.api.a.z.e.g
                public void z() {
                    a.this.z((View) null);
                }
            });
        } else {
            this.g.z((com.bytedance.msdk.api.a.z.e.g) new com.bytedance.msdk.api.a.z.e.dl() { // from class: com.bytedance.sdk.gromore.z.z.e.a.a.8
                @Override // com.bytedance.msdk.api.a.z.e.g
                public void z(View view) {
                    if (a.this.m != null) {
                        a.this.m.z(view, 0);
                    }
                    a.this.pf();
                }

                @Override // com.bytedance.msdk.api.a.z.e.g
                public void z() {
                    a.this.z((View) null);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void pf() {
        String strG;
        long jCurrentTimeMillis;
        if (this.g == null || this.dl == null) {
            return;
        }
        long jCurrentTimeMillis2 = System.currentTimeMillis();
        if (js.z(this.g)) {
            strG = js.g();
            jCurrentTimeMillis = System.currentTimeMillis() - jCurrentTimeMillis2;
        } else {
            strG = null;
            jCurrentTimeMillis = -1;
        }
        com.bytedance.msdk.core.g.z.gc(this.dl.zw());
        com.bytedance.msdk.g.dl dlVar = this.g;
        com.bytedance.msdk.gc.m.g(dlVar, this.dl, 0, strG, jCurrentTimeMillis, dlVar.lq());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void z(View view) {
        com.bytedance.msdk.g.dl dlVar;
        String strG;
        long jCurrentTimeMillis;
        if (this.dl == null || (dlVar = this.g) == null) {
            return;
        }
        dlVar.m(true);
        com.bytedance.sdk.openadsdk.uf.z.g.z.g gVar = this.m;
        if (gVar != null) {
            gVar.g(view, 0);
        }
        com.bytedance.msdk.z.gc.dl.z("TTMediationSDK", com.bytedance.msdk.z.gc.gc.z(this.dl.zw(), "show_listen") + "adSlotId：" + this.g.yz() + "，广告类型：" + com.bytedance.msdk.g.z.z(this.g.r()));
        i.z().e(this.dl.zw());
        i.z().g(this.dl.zw());
        kb.z().g(this.dl.zw(), this.g.yz());
        com.bytedance.msdk.core.gz.wp.z().g(this.dl.zw(), this.g.yz());
        com.bytedance.msdk.core.dl.dl.z(this.g.lw(), this.dl.zw(), this.g.yz());
        if (this.g.pc() != null) {
            this.g.pc().z(this.g);
        }
        long jCurrentTimeMillis2 = System.currentTimeMillis();
        if (js.z(this.g)) {
            strG = js.g();
            jCurrentTimeMillis = System.currentTimeMillis() - jCurrentTimeMillis2;
        } else {
            strG = null;
            jCurrentTimeMillis = -1;
        }
        String str = strG;
        long j = jCurrentTimeMillis;
        boolean zX = this.g.x();
        if (!zX) {
            com.bytedance.msdk.core.g.z.e(this.dl.zw());
            com.bytedance.msdk.core.g.z.dl(this.dl.zw());
            com.bytedance.msdk.core.fo.a.z(1, this.dl.zw(), this.g.hy(), this.g.u());
        }
        com.bytedance.msdk.gc.m.z(this.g, this.dl, 0, str, j, zX);
        com.bytedance.msdk.core.e.dl.z(this.dl.zw(), this.g);
    }

    private void z(com.bytedance.msdk.g.dl dlVar) {
        if (com.bytedance.msdk.core.g.g().x()) {
            com.bytedance.msdk.gc.m.z(dlVar, this.dl, js.z(), 2);
        }
    }

    private void ls() {
        com.bytedance.msdk.g.dl dlVar = this.g;
        if (dlVar == null) {
            return;
        }
        int iJ = dlVar.j();
        if (iJ != 4) {
            if (iJ == 5) {
                i();
                return;
            } else if (iJ == 3) {
                kb();
                return;
            }
        }
        v();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void z(boolean z, Handler.Callback callback) {
        com.bytedance.msdk.gc.m.z(this.dl);
        if (this.g != null) {
            ls();
            if (callback != null) {
                callback.handleMessage(null);
            }
            if (this.g.pc() != null) {
                this.g.pc().z();
            }
            z(this.g);
            HashMap map = new HashMap();
            map.put("has_view_binder", Boolean.valueOf(z));
            com.bytedance.msdk.g.dl dlVar = this.g;
            com.bytedance.msdk.gc.m.z(dlVar, this.dl, dlVar.gk(), 0, map);
            return;
        }
        com.bytedance.msdk.gc.m.z((List<com.bytedance.msdk.g.dl>) null, this.dl, 0);
    }
}
