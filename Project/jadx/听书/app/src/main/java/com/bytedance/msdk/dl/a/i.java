package com.bytedance.msdk.dl.a;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.bytedance.msdk.api.a.ls;
import com.bytedance.msdk.gz.js;
import com.bytedance.msdk.gz.v;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class i extends g implements com.bytedance.msdk.z.g.gc {
    private com.bytedance.msdk.api.a.z.fo.g fv;
    private boolean g;
    private com.bytedance.msdk.api.a.z.fo.a js;
    private View ls;
    private com.bytedance.msdk.api.a.z.fo.dl p;
    private boolean z;

    public View m() {
        return null;
    }

    public i(Context context) {
        super(context);
        this.z = false;
        this.g = false;
    }

    public void z(com.bytedance.msdk.api.z.g gVar, com.bytedance.msdk.api.a.kb kbVar, com.bytedance.msdk.api.a.z.fo.dl dlVar) {
        z(gVar);
        this.dl.z(kbVar);
        this.p = dlVar;
        this.fo = this;
        this.dl.h().put("ad_load_timeout", Integer.valueOf(gVar.p()));
        if (com.bytedance.msdk.core.g.g().l()) {
            com.bytedance.msdk.api.a.uy.z(new ls() { // from class: com.bytedance.msdk.dl.a.i.1
                @Override // com.bytedance.msdk.api.a.ls
                public void z() {
                    i.this.fo();
                }
            });
        } else {
            fo();
        }
    }

    public void z(com.bytedance.msdk.api.a.z.fo.g gVar) {
        this.fv = gVar;
    }

    public void z(com.bytedance.msdk.api.a.z.fo.a aVar) {
        this.js = aVar;
    }

    public boolean q() {
        List<com.bytedance.msdk.core.uy.uy> listG;
        try {
            listG = g();
        } catch (Throwable th) {
            com.bytedance.sdk.component.utils.wp.z(th);
            listG = null;
        }
        return v.z(this.dl.e(), this.dl.uy(), this.dl.gz(), this.m, this.wp, this.gc, this.m.gc(), listG);
    }

    public View iq() {
        Context context = this.gz != null ? this.gz.get() : null;
        if (this.ls == null && context != null) {
            FrameLayout frameLayout = new FrameLayout(context);
            frameLayout.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
            g(frameLayout);
            this.ls = frameLayout;
            z(this.f428a);
        }
        return this.ls;
    }

    public void z(final ViewGroup viewGroup) {
        final String[] strArr = new String[1];
        final boolean zX = com.bytedance.msdk.core.g.g().x();
        if (zX) {
            strArr[0] = js.z();
        }
        com.bytedance.msdk.z.gc.m.dl(new Runnable() { // from class: com.bytedance.msdk.dl.a.i.2
            @Override // java.lang.Runnable
            public void run() {
                i.this.g(viewGroup);
                if (zX) {
                    com.bytedance.msdk.gc.m.z(i.this.f428a, i.this.m, strArr[0], 2);
                }
            }
        });
    }

    protected void zw() {
        if (this.f428a.wo() && com.bytedance.msdk.core.gc.z.z.z().a(this.gc, this.f428a.yz(), js())) {
            com.bytedance.msdk.core.gc.z.z.z().z(this.f428a.yz(), this.m, this.dl.h(), true, this.dl.gk(), this.dl.un(), this.gz.get());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g(ViewGroup viewGroup) {
        boolean z;
        List<com.bytedance.msdk.core.gc.g.e> listZ;
        com.bytedance.msdk.g.dl dlVar;
        com.bytedance.msdk.gc.m.z(this.m);
        List<com.bytedance.msdk.core.uy.uy> listG = null;
        if (this.wp) {
            com.bytedance.msdk.gc.m.z((List<com.bytedance.msdk.g.dl>) null, this.m, 0);
            dl(new com.bytedance.msdk.api.z(40052, com.bytedance.msdk.api.z.z(40052)));
            return;
        }
        int iG = g(this.gc);
        if (iG != 0) {
            com.bytedance.msdk.gc.m.z((List<com.bytedance.msdk.g.dl>) null, this.m, iG);
            dl(new com.bytedance.msdk.api.z(iG, com.bytedance.msdk.api.z.z(iG)));
            return;
        }
        List<com.bytedance.msdk.g.dl> listTb = this.dl.tb();
        if (viewGroup != null) {
            try {
                listG = g();
            } catch (Throwable th) {
                com.bytedance.sdk.component.utils.wp.z(th);
            }
            if (listG == null || listG.size() <= 0) {
                z = false;
            } else {
                HashMap<String, com.bytedance.msdk.g.dl> mapG = g(listTb);
                for (com.bytedance.msdk.core.uy.uy uyVar : listG) {
                    if (uyVar != null) {
                        String strFv = uyVar.fv();
                        com.bytedance.msdk.g.dl dlVar2 = mapG.get(strFv);
                        if (dlVar2 != null && dlVar2.un(this.gc) && !dlVar2.jq()) {
                            z(dlVar2, viewGroup);
                        } else if (uyVar.tb() && com.bytedance.msdk.core.gc.z.z.z().a(this.gc, strFv, js()) && com.bytedance.msdk.core.gc.z.z.z().z(strFv, this.m, false) == 3 && (listZ = com.bytedance.msdk.core.gc.z.z.z().z(strFv, this.m, js())) != null && listZ.size() > 0 && (dlVar = listZ.get(0).z) != null && dlVar.un(this.gc) && !dlVar.jq()) {
                            com.bytedance.msdk.z.gc.dl.z("TTMediationSDK", com.bytedance.msdk.z.gc.gc.z(this.gc, "show") + "adSlotId：" + dlVar.yz() + "，广告类型：" + com.bytedance.msdk.g.z.z(dlVar.r()) + ",isReady()：" + dlVar.un(this.gc));
                            g(dlVar);
                            z(dlVar, viewGroup);
                        }
                        z = true;
                        break;
                    }
                }
                z = false;
            }
            boolean z2 = z;
            if (!z && listTb != null && listTb.size() > 0) {
                Iterator<com.bytedance.msdk.g.dl> it = listTb.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    com.bytedance.msdk.g.dl next = it.next();
                    if (next != null && next.un(this.gc) && !next.jq()) {
                        z(next, viewGroup);
                        z2 = true;
                        break;
                    }
                }
            }
            if (z2) {
                this.wp = true;
                if (this.f428a != null) {
                    ArrayList arrayList = new ArrayList();
                    arrayList.add(this.f428a);
                    z(arrayList);
                }
                com.bytedance.msdk.gc.m.z(this.f428a, this.m, false, 0);
                return;
            }
            com.bytedance.msdk.gc.m.z(listTb, this.m, 0);
            dl(new com.bytedance.msdk.api.z(40052, com.bytedance.msdk.api.z.z(40052)));
            return;
        }
        com.bytedance.msdk.gc.m.z(listTb, this.m, 0);
        dl(new com.bytedance.msdk.api.z(40052, com.bytedance.msdk.api.z.z(40052)));
    }

    private void z(com.bytedance.msdk.g.dl dlVar, ViewGroup viewGroup) {
        this.f428a = dlVar;
        if (this.g) {
            this.f428a.gw();
        }
        if (this.i != null) {
            this.f428a.z(this.i);
        }
        if (this.v != null) {
            this.f428a.z(this.v);
        }
        this.dl.z(this.f428a);
        this.f428a.gc(true);
        this.f428a.z(this.fo);
        if (this.f428a.wo() && com.bytedance.msdk.core.gc.z.z.z().a(this.gc, this.f428a.yz(), js())) {
            com.bytedance.msdk.dl.gz.m.z(this.f428a, this.gc, this.f428a.yz());
        }
        com.bytedance.msdk.core.gc.z.z.z().z(this.dl.tb(), this.gc, this.m, js(), this.f428a);
        com.bytedance.msdk.z.gc.dl.z("TTMediationSDK", com.bytedance.msdk.z.gc.gc.z(this.gc, "show") + "展示的广告类型：" + com.bytedance.msdk.g.z.z(this.f428a.r()) + ",slotId：" + this.f428a.yz() + ",slotType:" + this.f428a.yt());
        com.bytedance.msdk.core.gz.i.z().g(this.gc);
        com.bytedance.msdk.core.gz.wp.z().g(this.gc, this.f428a.yz());
        this.f428a.z(viewGroup);
    }

    @Override // com.bytedance.msdk.dl.a.g
    public void z() {
        if (this.f428a == null) {
            com.bytedance.msdk.core.gc.z.z.z().z(this.dl.tb(), this.gc, this.m, this.m.gc(), this.f428a);
        }
        super.z();
    }

    @Override // com.bytedance.msdk.dl.a.g, com.bytedance.msdk.dl.g.z.z
    public void g(com.bytedance.msdk.api.z zVar) {
        com.bytedance.msdk.api.a.z.fo.dl dlVar = this.p;
        if (dlVar != null) {
            dlVar.z(zVar);
        }
    }

    @Override // com.bytedance.msdk.dl.a.g, com.bytedance.msdk.dl.g.z.z
    public void e() {
        com.bytedance.msdk.api.a.z.fo.dl dlVar = this.p;
        if (dlVar != null) {
            dlVar.z();
        }
    }

    @Override // com.bytedance.msdk.z.g.gc
    public void k_() {
        com.bytedance.msdk.api.a.z.fo.a aVar = this.js;
        if (aVar != null) {
            aVar.z();
        }
    }

    @Override // com.bytedance.msdk.z.g.gc
    public void l_() {
        com.bytedance.msdk.api.a.z.fo.a aVar = this.js;
        if (aVar != null) {
            aVar.g();
        }
    }

    @Override // com.bytedance.msdk.z.g.gc
    public Activity getActivity() {
        com.bytedance.msdk.api.a.z.fo.a aVar = this.js;
        if (aVar != null) {
            return aVar.getActivity();
        }
        return null;
    }

    @Override // com.bytedance.msdk.z.g.gc
    public void dl() {
        com.bytedance.msdk.api.a.z.fo.a aVar = this.js;
        if (aVar != null) {
            aVar.dl();
        }
    }

    @Override // com.bytedance.msdk.api.a.z.fo.g
    public void a() {
        String strG;
        long jCurrentTimeMillis;
        com.bytedance.msdk.api.a.z.fo.g gVar = this.fv;
        if (gVar != null) {
            gVar.a();
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

    @Override // com.bytedance.msdk.api.a.z.fo.g
    public void gc() {
        String strG;
        long jCurrentTimeMillis;
        com.bytedance.msdk.api.a.z.fo.g gVar = this.fv;
        if (gVar != null) {
            gVar.gc();
        }
        com.bytedance.msdk.core.gz.i.z().e(this.gc);
        if (this.f428a != null) {
            com.bytedance.msdk.z.gc.dl.z("TTMediationSDK", com.bytedance.msdk.z.gc.gc.z(this.gc, "show_listen") + "adSlotId：" + this.f428a.yz() + "，广告类型：" + com.bytedance.msdk.g.z.z(this.f428a.r()));
            com.bytedance.msdk.core.gz.kb.z().g(this.gc, this.f428a.yz());
        }
        if (this.f428a != null) {
            com.bytedance.msdk.core.dl.dl.z(this.f428a.lw(), this.gc, this.f428a.yz());
        }
        zw();
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

    @Override // com.bytedance.msdk.api.a.z.fo.g
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

    @Override // com.bytedance.msdk.api.a.z.fo.g
    public void z(int i) {
        com.bytedance.msdk.api.a.z.fo.g gVar = this.fv;
        if (gVar != null) {
            gVar.z(1);
        }
        com.bytedance.msdk.core.gc.g.a.z().z(this.gz.get(), this.gc, js());
    }

    @Override // com.bytedance.msdk.api.a.z.fo.g
    public void g(int i) {
        com.bytedance.msdk.api.a.z.fo.g gVar = this.fv;
        if (gVar != null) {
            gVar.g(i);
        }
        com.bytedance.msdk.core.gc.g.a.z().z(this.gz.get(), this.gc, js());
    }

    public void z(ViewGroup viewGroup, Activity activity) {
        if (this.f428a != null) {
            this.f428a.z(viewGroup, activity);
        }
    }

    private void dl(final com.bytedance.msdk.api.z zVar) {
        com.bytedance.msdk.z.gc.m.dl(new Runnable() { // from class: com.bytedance.msdk.dl.a.i.3
            @Override // java.lang.Runnable
            public void run() {
                if (i.this.fv != null) {
                    i.this.fv.z(zVar);
                }
            }
        });
    }

    public void io() {
        this.g = true;
    }
}
