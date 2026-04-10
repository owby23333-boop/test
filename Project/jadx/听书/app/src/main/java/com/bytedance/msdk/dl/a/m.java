package com.bytedance.msdk.dl.a;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.bytedance.msdk.gz.js;
import com.bytedance.msdk.gz.v;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public class m extends g implements com.bytedance.msdk.z.g.z {
    private com.bytedance.msdk.api.a.z.z.g g;
    private boolean ls;
    private com.bytedance.msdk.api.a.z.z.a p;
    private com.bytedance.msdk.api.a.z.z.z z;

    public m(Context context) {
        super(context);
        this.ls = false;
    }

    public void z(com.bytedance.msdk.api.z.g gVar, com.bytedance.msdk.api.a.z.z.g gVar2) {
        z(gVar);
        this.fo = this;
        this.g = gVar2;
        fo();
    }

    public void z(com.bytedance.msdk.api.a.z.z.a aVar) {
        this.p = aVar;
    }

    public void z(com.bytedance.msdk.api.a.z.z.z zVar) {
        this.z = zVar;
    }

    private View z(Context context, com.bytedance.msdk.g.dl dlVar) {
        this.f428a = dlVar;
        this.dl.z(this.f428a);
        this.f428a.gc(true);
        this.f428a.z(this.fo);
        if (this.f428a.wo() && com.bytedance.msdk.core.gc.z.z.z().a(this.gc, this.f428a.yz(), this.m.gc())) {
            com.bytedance.msdk.dl.gz.m.z(this.f428a, this.gc, this.f428a.yz());
        }
        z(false);
        com.bytedance.msdk.z.gc.dl.z("TTMediationSDK", com.bytedance.msdk.z.gc.gc.z(this.gc, "show") + "展示的广告类型：" + com.bytedance.msdk.g.z.z(this.f428a.r()) + ",slotId：" + this.f428a.yz() + ",slotType:" + this.f428a.yt());
        final View viewFo = this.f428a.fo();
        if (!this.f428a.jc() && this.f428a.j() == 4 && this.f428a.gp() == 2 && !this.f428a.tc()) {
            com.bytedance.msdk.api.a.z.z.a aVar = this.p;
            if (aVar != null) {
                try {
                    viewFo = aVar.z(dl(this.f428a));
                    if (viewFo == null) {
                        com.bytedance.msdk.z.gc.dl.z("TTMediationSDK", "--==-- banner混出自渲染信息流，getGMBannerViewFromNativeAd()返回null，将无法展示该广告");
                    }
                } catch (Throwable th) {
                    com.bytedance.msdk.z.gc.dl.z("TTMediationSDK", "--==-- banner混出自渲染信息流，getGMBannerViewFromNativeAd()发生异常，将无法展示该广告，信息如下：");
                    com.bytedance.sdk.component.utils.wp.z(th);
                }
            } else {
                com.bytedance.msdk.z.gc.dl.z("TTMediationSDK", "--==-- banner混出自渲染信息流，但未提供GMNativeToBannerListener，将无法展示该广告");
            }
        }
        if (this.f428a.tb() && context != null) {
            this.f428a.z((Activity) context, new com.bytedance.sdk.openadsdk.js.z.g.z.z(null) { // from class: com.bytedance.msdk.dl.a.m.1
                @Override // com.bytedance.sdk.openadsdk.js.z.g.z.z
                public void z(int i, String str, boolean z) {
                    View view = viewFo;
                    if (view != null) {
                        View view2 = (View) view.getParent();
                        if (view2 instanceof ViewGroup) {
                            ((ViewGroup) view2).removeViewInLayout(viewFo);
                        }
                    }
                }
            });
        }
        return viewFo;
    }

    public synchronized View z(Context context) {
        List<com.bytedance.msdk.core.uy.uy> listG;
        View viewZ;
        com.bytedance.msdk.g.dl next;
        List<com.bytedance.msdk.core.gc.g.e> listZ;
        com.bytedance.msdk.g.dl dlVar;
        com.bytedance.msdk.gc.m.z(this.m);
        if (this.wp) {
            com.bytedance.msdk.gc.m.z((List<com.bytedance.msdk.g.dl>) null, this.m, 0);
            dl(new com.bytedance.msdk.api.z(40052, com.bytedance.msdk.api.z.z(40052)));
            return null;
        }
        int iG = g(this.gc);
        if (iG != 0) {
            com.bytedance.msdk.gc.m.z((List<com.bytedance.msdk.g.dl>) null, this.m, iG);
            dl(new com.bytedance.msdk.api.z(iG, com.bytedance.msdk.api.z.z(iG)));
            return null;
        }
        List<com.bytedance.msdk.g.dl> listTb = this.dl.tb();
        try {
            listG = g();
        } catch (Throwable th) {
            com.bytedance.sdk.component.utils.wp.z(th);
            listG = null;
        }
        if (listG != null && listG.size() > 0) {
            HashMap<String, com.bytedance.msdk.g.dl> mapG = g(listTb);
            viewZ = null;
            for (com.bytedance.msdk.core.uy.uy uyVar : listG) {
                if (uyVar != null) {
                    String strFv = uyVar.fv();
                    com.bytedance.msdk.g.dl dlVar2 = mapG.get(strFv);
                    if (dlVar2 != null && dlVar2.un(this.gc) && !dlVar2.jq() && (viewZ = z(context, dlVar2)) != null) {
                        break;
                    }
                    if (uyVar.tb() && com.bytedance.msdk.core.gc.z.z.z().a(this.gc, strFv, this.m.gc()) && com.bytedance.msdk.core.gc.z.z.z().z(strFv, this.m, false) == 3 && (listZ = com.bytedance.msdk.core.gc.z.z.z().z(strFv, this.m, this.m.gc())) != null && listZ.size() > 0 && (dlVar = listZ.get(0).z) != null && dlVar.un(this.gc) && !dlVar.jq()) {
                        g(dlVar);
                        viewZ = z(context, dlVar);
                        if (viewZ != null) {
                            break;
                        }
                    }
                }
            }
        } else {
            viewZ = null;
        }
        if (viewZ == null && listTb != null && listTb.size() > 0) {
            Iterator<com.bytedance.msdk.g.dl> it = listTb.iterator();
            while (it.hasNext() && ((next = it.next()) == null || !next.un(this.gc) || next.jq() || (viewZ = z(context, next)) == null)) {
            }
        }
        if (viewZ != null) {
            this.wp = true;
            List<com.bytedance.msdk.g.dl> listTb2 = this.dl.tb();
            com.bytedance.msdk.core.gc.z.z.z().z(listTb2, this.gc, this.m, this.m.gc(), this.f428a);
            if (this.f428a != null) {
                ArrayList arrayList = new ArrayList();
                arrayList.add(this.f428a);
                com.bytedance.msdk.dl.gc.z.z().z(this.m, com.bytedance.msdk.dl.gc.z.z(this.m, arrayList, listTb2));
                z(arrayList);
            }
            com.bytedance.msdk.gc.m.z(this.f428a, this.m, false, 0);
            if (this.z != null && this.f428a != null && this.f428a.r() == 2) {
                com.bytedance.msdk.z.gc.dl.z("ADMOB_EVENT", com.bytedance.msdk.z.gc.gc.g(this.gc, this.f428a.yz()) + "mTTAdBannerListener-->Admob--->onAdShow......");
                com.bytedance.msdk.core.gz.i.z().e(this.gc);
                com.bytedance.msdk.core.gz.i.z().g(this.gc);
                this.z.g(null);
                if (this.f428a != null) {
                    com.bytedance.msdk.z.gc.dl.z("TTMediationSDK", com.bytedance.msdk.z.gc.gc.z(this.gc, "show_listen") + "adSlotId：" + this.f428a.yz() + "，广告类型：" + com.bytedance.msdk.g.z.z(this.f428a.r()));
                    com.bytedance.msdk.core.gz.kb.z().g(this.gc, this.f428a.yz());
                    com.bytedance.msdk.core.gz.wp.z().g(this.gc, this.f428a.yz());
                }
                if (this.f428a != null) {
                    com.bytedance.msdk.core.dl.dl.z(this.f428a.lw(), this.gc, this.f428a.yz());
                }
                z(true);
                com.bytedance.msdk.gc.m.z(this.f428a, this.m, 0, (String) null, 0L, false);
                com.bytedance.msdk.core.e.dl.z(this.gc, this.f428a);
            }
            return viewZ;
        }
        com.bytedance.msdk.gc.m.z(listTb, this.m, 0);
        dl(new com.bytedance.msdk.api.z(40052, com.bytedance.msdk.api.z.z(40052)));
        return null;
    }

    private void z(boolean z) {
        if (this.f428a != null && this.f428a.wo() && com.bytedance.msdk.core.gc.z.z.z().a(this.gc, this.f428a.yz(), this.m.gc())) {
            com.bytedance.msdk.core.gc.z.z.z().z(this.f428a.yz(), this.m, this.dl.h(), z, this.dl.gk(), this.dl.un(), this.gz.get());
        }
    }

    public boolean dl() {
        List<com.bytedance.msdk.core.uy.uy> listG;
        try {
            listG = g();
        } catch (Throwable th) {
            com.bytedance.sdk.component.utils.wp.z(th);
            listG = null;
        }
        return v.z(this.dl.e(), this.dl.uy(), this.dl.gz(), this.m, this.wp, this.gc, this.m.gc(), listG);
    }

    public int a() {
        if (this.f428a != null) {
            return this.f428a.nh();
        }
        return 0;
    }

    public void gc() {
        if (this.f428a != null) {
            this.f428a.p();
        }
    }

    public void m() {
        if (this.f428a != null) {
            this.f428a.ls();
        }
    }

    @Override // com.bytedance.msdk.dl.a.g
    public void z() {
        if (!this.wp) {
            com.bytedance.msdk.core.gc.z.z.z().z(this.dl.tb(), this.gc, this.m, this.m.gc(), this.f428a);
        }
        super.z();
        this.z = null;
        this.g = null;
    }

    @Override // com.bytedance.msdk.dl.a.g, com.bytedance.msdk.dl.g.z.z
    public void g(com.bytedance.msdk.api.z zVar) {
        com.bytedance.msdk.api.a.z.z.g gVar = this.g;
        if (gVar != null) {
            gVar.z(zVar);
        }
    }

    @Override // com.bytedance.msdk.dl.a.g, com.bytedance.msdk.dl.g.z.z
    public void e() {
        com.bytedance.msdk.api.a.z.z.g gVar = this.g;
        if (gVar != null) {
            gVar.z();
        }
    }

    @Override // com.bytedance.msdk.api.a.z.z.z
    public void f_() {
        com.bytedance.msdk.api.a.z.z.z zVar = this.z;
        if (zVar != null) {
            zVar.f_();
        }
    }

    @Override // com.bytedance.msdk.api.a.z.z.z
    public void z(View view) {
        String strG;
        long jCurrentTimeMillis;
        com.bytedance.msdk.api.a.z.z.z zVar = this.z;
        if (zVar != null) {
            zVar.z(view);
        }
        long jCurrentTimeMillis2 = System.currentTimeMillis();
        if (js.z(this.f428a)) {
            strG = js.g();
            jCurrentTimeMillis = System.currentTimeMillis() - jCurrentTimeMillis2;
        } else {
            strG = null;
            jCurrentTimeMillis = -1;
        }
        com.bytedance.msdk.core.g.z.gc(this.m.zw());
        com.bytedance.msdk.gc.m.g(this.f428a, this.m, 0, strG, jCurrentTimeMillis, this.f428a.lq());
    }

    @Override // com.bytedance.msdk.api.a.z.z.z
    public void g(View view) {
        String strG;
        long jCurrentTimeMillis;
        this.ls = true;
        if (this.z != null) {
            com.bytedance.msdk.core.gz.i.z().e(this.gc);
            com.bytedance.msdk.core.gz.i.z().g(this.gc);
            this.z.g(view);
        }
        if (this.f428a != null) {
            com.bytedance.msdk.z.gc.dl.z("TTMediationSDK", com.bytedance.msdk.z.gc.gc.z(this.gc, "show_listen") + "adSlotId：" + this.f428a.yz() + "，广告类型：" + com.bytedance.msdk.g.z.z(this.f428a.r()));
            com.bytedance.msdk.core.gz.kb.z().g(this.gc, this.f428a.yz());
            com.bytedance.msdk.core.gz.wp.z().g(this.gc, this.f428a.yz());
        }
        if (this.f428a != null) {
            com.bytedance.msdk.core.dl.dl.z(this.f428a.lw(), this.gc, this.f428a.yz());
        }
        z(true);
        long jCurrentTimeMillis2 = System.currentTimeMillis();
        if (js.z(this.f428a)) {
            strG = js.g();
            jCurrentTimeMillis = System.currentTimeMillis() - jCurrentTimeMillis2;
        } else {
            strG = null;
            jCurrentTimeMillis = -1;
        }
        com.bytedance.msdk.gc.m.z(this.f428a, this.m, 0, strG, jCurrentTimeMillis, false);
        com.bytedance.msdk.core.g.z.e(this.m.zw());
        com.bytedance.msdk.core.g.z.dl(this.m.zw());
        com.bytedance.msdk.core.fo.a.z(1, this.m.zw(), this.f428a.hy(), this.f428a.u());
        com.bytedance.msdk.core.e.dl.z(this.gc, this.f428a);
    }

    @Override // com.bytedance.msdk.api.a.z.z.z
    public void z(com.bytedance.msdk.api.z zVar) {
        String strG;
        long jCurrentTimeMillis;
        long jCurrentTimeMillis2 = System.currentTimeMillis();
        if (js.z(this.f428a)) {
            strG = js.g();
            jCurrentTimeMillis = System.currentTimeMillis() - jCurrentTimeMillis2;
        } else {
            strG = null;
            jCurrentTimeMillis = -1;
        }
        com.bytedance.msdk.gc.m.z(this.f428a, this.m, zVar, 1, 0, strG, jCurrentTimeMillis);
        dl(zVar);
    }

    private void dl(final com.bytedance.msdk.api.z zVar) {
        com.bytedance.msdk.z.gc.m.dl(new Runnable() { // from class: com.bytedance.msdk.dl.a.m.2
            @Override // java.lang.Runnable
            public void run() {
                if (m.this.z != null) {
                    m.this.z.z(zVar);
                }
            }
        });
    }

    @Override // com.bytedance.msdk.dl.a.g
    public com.bytedance.msdk.api.dl pf() {
        if (this.ls) {
            return super.pf();
        }
        return null;
    }

    public void z(Activity activity, com.bytedance.sdk.openadsdk.js.z.g.z.z zVar) {
        if (this.f428a != null) {
            this.f428a.z(activity, zVar);
        }
    }

    public void z(Dialog dialog, Integer[] numArr) {
        if (this.f428a != null) {
            this.f428a.z(dialog, numArr);
        }
    }

    public com.bytedance.sdk.openadsdk.ls.dl.g.e z(Activity activity) {
        if (this.f428a != null) {
            return this.f428a.z(activity);
        }
        return null;
    }

    public com.bytedance.sdk.openadsdk.ls.dl.g.a q() {
        if (this.f428a != null) {
            return this.f428a.he();
        }
        return null;
    }

    private com.bytedance.msdk.api.a.z.z.dl dl(final com.bytedance.msdk.g.dl dlVar) {
        return new com.bytedance.msdk.api.a.z.z.dl() { // from class: com.bytedance.msdk.dl.a.m.3
            @Override // com.bytedance.msdk.api.a.z.z.dl
            public String z() {
                return dlVar.lt();
            }

            @Override // com.bytedance.msdk.api.a.z.z.dl
            public String g() {
                return dlVar.bw();
            }

            @Override // com.bytedance.msdk.api.a.z.z.dl
            public String dl() {
                return dlVar.gy();
            }

            @Override // com.bytedance.msdk.api.a.z.z.dl
            public String a() {
                return dlVar.zd();
            }

            @Override // com.bytedance.msdk.api.a.z.z.dl
            public double gc() {
                return dlVar.fp();
            }

            @Override // com.bytedance.msdk.api.a.z.z.dl
            public List<String> m() {
                return dlVar.xf();
            }

            @Override // com.bytedance.msdk.api.a.z.z.dl
            public String e() {
                return dlVar.vt();
            }

            @Override // com.bytedance.msdk.api.a.z.z.dl
            public int gz() {
                return dlVar.nh();
            }

            @Override // com.bytedance.msdk.api.a.z.z.dl
            public int fo() {
                return dlVar.me();
            }

            @Override // com.bytedance.msdk.api.a.z.z.dl
            public void z(Activity activity, ViewGroup viewGroup, List<View> list, List<View> list2, List<View> list3, com.bytedance.msdk.api.a.z.e.uy uyVar) {
                dlVar.z(activity, viewGroup, list, list2, list3, uyVar, null);
            }

            @Override // com.bytedance.msdk.api.a.z.z.dl
            public com.bytedance.msdk.api.a.z.e.z uy() {
                if (!dlVar.bm()) {
                    return null;
                }
                com.bytedance.msdk.api.a.z.e.z zVar = new com.bytedance.msdk.api.a.z.e.z();
                zVar.a(dlVar.sd());
                zVar.gc(dlVar.tf());
                zVar.z(dlVar.ja());
                zVar.m(dlVar.wn());
                zVar.e(dlVar.nb());
                zVar.gz(dlVar.zz());
                zVar.z(dlVar.vo());
                zVar.g(dlVar.lk());
                zVar.dl(dlVar.y());
                zVar.z(dlVar.t());
                zVar.g(dlVar.vm());
                return zVar;
            }

            @Override // com.bytedance.msdk.api.a.z.z.dl
            public boolean kb() {
                return dlVar.tb();
            }

            @Override // com.bytedance.msdk.api.a.z.z.dl
            public com.bytedance.msdk.api.a.g z(Activity activity) {
                return z(activity, (Map<String, Object>) null);
            }

            @Override // com.bytedance.msdk.api.a.z.z.dl
            public com.bytedance.msdk.api.a.g z(Activity activity, Map<String, Object> map) {
                final com.bytedance.sdk.openadsdk.ls.dl.g.e eVarZ = dlVar.z(activity);
                return new com.bytedance.msdk.api.a.g() { // from class: com.bytedance.msdk.dl.a.m.3.1
                    @Override // com.bytedance.msdk.api.a.g
                    public void z() {
                        com.bytedance.sdk.openadsdk.ls.dl.g.e eVar = eVarZ;
                        if (eVar != null) {
                            eVar.z();
                        }
                    }

                    @Override // com.bytedance.msdk.api.a.g
                    public void z(final com.bytedance.msdk.api.a.e eVar) {
                        com.bytedance.sdk.openadsdk.ls.dl.g.e eVar2 = eVarZ;
                        if (eVar2 != null) {
                            eVar2.z(new com.bytedance.sdk.openadsdk.js.z.g.z.z(null) { // from class: com.bytedance.msdk.dl.a.m.3.1.1
                                @Override // com.bytedance.sdk.openadsdk.js.z.g.z.z
                                public void z() {
                                    com.bytedance.msdk.api.a.e eVar3 = eVar;
                                    if (eVar3 != null) {
                                        eVar3.g();
                                    }
                                }

                                @Override // com.bytedance.sdk.openadsdk.js.z.g.z.z
                                public void z(int i, String str, boolean z) {
                                    com.bytedance.msdk.api.a.e eVar3 = eVar;
                                    if (eVar3 != null) {
                                        eVar3.z(i, str);
                                    }
                                }

                                @Override // com.bytedance.sdk.openadsdk.js.z.g.z.z
                                public void g() {
                                    com.bytedance.msdk.api.a.e eVar3 = eVar;
                                    if (eVar3 != null) {
                                        eVar3.z();
                                    }
                                }
                            });
                        }
                    }
                };
            }

            @Override // com.bytedance.msdk.api.a.z.z.dl
            public void z(Activity activity, com.bytedance.sdk.openadsdk.js.z.g.z.z zVar) {
                com.bytedance.msdk.g.dl dlVar2 = dlVar;
                if (dlVar2 != null) {
                    dlVar2.z(activity, zVar);
                }
            }

            @Override // com.bytedance.msdk.api.a.z.z.dl
            public void z(Dialog dialog, Integer[] numArr) {
                com.bytedance.msdk.g.dl dlVar2 = dlVar;
                if (dlVar2 != null) {
                    dlVar2.z(dialog, numArr);
                }
            }

            @Override // com.bytedance.msdk.api.a.z.z.dl
            public com.bytedance.sdk.openadsdk.ls.dl.g.e g(Activity activity) {
                com.bytedance.msdk.g.dl dlVar2 = dlVar;
                if (dlVar2 != null) {
                    return dlVar2.z(activity);
                }
                return null;
            }

            @Override // com.bytedance.msdk.api.a.z.z.dl
            public com.bytedance.sdk.openadsdk.ls.dl.g.e g(Dialog dialog, Integer[] numArr) {
                com.bytedance.msdk.g.dl dlVar2 = dlVar;
                if (dlVar2 != null) {
                    return dlVar2.g(dialog, numArr);
                }
                return null;
            }

            @Override // com.bytedance.msdk.api.a.z.z.dl
            public com.bytedance.sdk.openadsdk.ls.dl.g.a wp() {
                com.bytedance.msdk.g.dl dlVar2 = dlVar;
                if (dlVar2 != null) {
                    return dlVar2.he();
                }
                return null;
            }
        };
    }

    public void a(String str) {
        if (this.f428a != null) {
            this.f428a.ti(str);
        }
    }

    public void z(com.bytedance.sdk.openadsdk.ls.dl.z.dl dlVar) {
        if (this.f428a != null) {
            this.f428a.z(dlVar);
        }
    }

    public void z(com.bytedance.sdk.openadsdk.uf.z.g.z.dl dlVar) {
        if (this.f428a != null) {
            this.f428a.z(dlVar);
        }
    }

    public void g(com.bytedance.sdk.openadsdk.ls.dl.z.g gVar) {
        if (this.f428a != null) {
            this.f428a.z(gVar);
        }
    }
}
