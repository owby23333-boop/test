package com.bytedance.msdk.dl.a;

import android.app.Activity;
import android.content.Context;
import com.bytedance.msdk.gz.v;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public abstract class uy extends g {
    protected boolean fv;
    protected com.bytedance.msdk.z.g.m js;
    protected boolean p;
    private Object z;

    public interface z {
        void z();
    }

    protected boolean q() {
        return false;
    }

    public uy(Context context) {
        super(context);
        this.p = false;
        this.fv = false;
        this.z = null;
    }

    public boolean uf() {
        return this.p;
    }

    public void z(boolean z2) {
        this.p = z2;
    }

    /* JADX WARN: Removed duplicated region for block: B:9:0x001f A[PHI: r2
  0x001f: PHI (r2v5 boolean) = (r2v2 boolean), (r2v0 boolean) binds: [B:31:0x0070, B:7:0x001c] A[DONT_GENERATE, DONT_INLINE]] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void z(com.bytedance.msdk.dl.m.z.g r14) {
        /*
            r13 = this;
            com.bytedance.msdk.g.dl r0 = r13.f428a
            int r0 = r0.hy()
            r1 = 8
            r2 = 1
            r3 = 10
            if (r0 == r3) goto L21
            com.bytedance.msdk.g.dl r0 = r13.f428a
            int r0 = r0.hy()
            if (r0 == r1) goto L21
            com.bytedance.msdk.g.dl r0 = r13.f428a
            int r0 = r0.hy()
            r4 = 7
            if (r0 != r4) goto L1f
            goto L21
        L1f:
            r9 = r2
            goto L73
        L21:
            com.bytedance.msdk.g.dl r0 = r13.f428a
            boolean r0 = r0.bb()
            r4 = 0
            if (r0 == 0) goto L46
            com.bytedance.msdk.g.dl r0 = r13.f428a
            boolean r0 = r0.by()
            if (r0 == 0) goto L46
            com.bytedance.msdk.core.gc.g.a r0 = com.bytedance.msdk.core.gc.g.a.z()
            java.lang.String r5 = r13.gc
            com.bytedance.msdk.api.z.g r6 = r13.m
            int r6 = r6.gc()
            boolean r0 = r0.dl(r5, r6)
            if (r0 == 0) goto L46
            r0 = r4
            goto L47
        L46:
            r0 = r2
        L47:
            com.bytedance.msdk.api.z.g r5 = r13.m
            if (r5 == 0) goto L68
            com.bytedance.msdk.api.z.g r5 = r13.m
            int r5 = r5.iq()
            if (r5 == r3) goto L5b
            com.bytedance.msdk.api.z.g r3 = r13.m
            int r3 = r3.iq()
            if (r3 != r1) goto L68
        L5b:
            com.bytedance.msdk.core.uy.g r1 = r13.e
            if (r1 == 0) goto L68
            com.bytedance.msdk.core.uy.g r1 = r13.e
            int r1 = r1.v()
            if (r1 == 0) goto L68
            goto L69
        L68:
            r2 = r0
        L69:
            com.bytedance.msdk.g.dl r0 = r13.f428a
            int r0 = r0.r()
            r1 = 4
            if (r0 != r1) goto L1f
            r9 = r4
        L73:
            com.bytedance.msdk.g.dl r0 = r13.f428a
            boolean r0 = r0.wo()
            if (r0 == 0) goto Lbf
            com.bytedance.msdk.core.gc.z.z r0 = com.bytedance.msdk.core.gc.z.z.z()
            java.lang.String r1 = r13.gc
            com.bytedance.msdk.g.dl r2 = r13.f428a
            java.lang.String r2 = r2.yz()
            com.bytedance.msdk.api.z.g r3 = r13.m
            int r3 = r3.gc()
            boolean r0 = r0.a(r1, r2, r3)
            if (r0 == 0) goto Lbf
            com.bytedance.msdk.core.gc.z.z r5 = com.bytedance.msdk.core.gc.z.z.z()
            com.bytedance.msdk.g.dl r0 = r13.f428a
            java.lang.String r6 = r0.yz()
            com.bytedance.msdk.api.z.g r7 = r13.m
            r0 = 0
            if (r14 == 0) goto La8
            java.util.Map r1 = r14.h()
            r8 = r1
            goto La9
        La8:
            r8 = r0
        La9:
            if (r14 == 0) goto Lb1
            com.bytedance.msdk.api.a.kb r14 = r14.gk()
            r10 = r14
            goto Lb2
        Lb1:
            r10 = r0
        Lb2:
            r11 = 0
            java.lang.ref.SoftReference<android.content.Context> r14 = r13.gz
            java.lang.Object r14 = r14.get()
            r12 = r14
            android.content.Context r12 = (android.content.Context) r12
            r5.z(r6, r7, r8, r9, r10, r11, r12)
        Lbf:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.msdk.dl.a.uy.z(com.bytedance.msdk.dl.m.z.g):void");
    }

    public void sy() {
        if (this.m.f() || this.f428a == null || this.f428a.r() == 4) {
            return;
        }
        com.bytedance.msdk.core.gc.g.a.z().z(this.gz.get(), this.gc, this.m.gc());
    }

    public void dl(final com.bytedance.msdk.g.dl dlVar) {
        if (this.m.f()) {
            return;
        }
        com.bytedance.msdk.z.gc.m.dl(new Runnable() { // from class: com.bytedance.msdk.dl.a.uy.1
            @Override // java.lang.Runnable
            public void run() {
                com.bytedance.msdk.g.dl dlVar2 = dlVar;
                if (dlVar2 == null || !dlVar2.bb() || !dlVar.by() || (uy.this.f428a instanceof com.bytedance.msdk.api.a.z.g.g)) {
                    return;
                }
                com.bytedance.msdk.z.gc.dl.z("TTMediationSDK", com.bytedance.msdk.z.gc.gc.g(uy.this.gc, dlVar.yz()) + "在show时触发了预加载【" + dlVar.zx() + "】, loadSort: " + dlVar.xo() + ", showSort: " + dlVar.dt());
                uy.this.fv = true;
                com.bytedance.msdk.core.gc.g.a.z().g(uy.this.gz.get(), uy.this.gc, uy.this.m.gc());
            }
        });
    }

    @Override // com.bytedance.msdk.dl.a.g
    public void z() {
        super.z();
        this.js = null;
    }

    public void z(Activity activity, Object obj, String str, z zVar) {
        List<com.bytedance.msdk.core.uy.uy> listG = null;
        if (!q()) {
            com.bytedance.msdk.gc.m.z(this.m);
            if (this.wp) {
                com.bytedance.msdk.gc.m.z((List<com.bytedance.msdk.g.dl>) null, this.m, 0);
                if (zVar != null) {
                    zVar.z();
                    return;
                }
                return;
            }
        }
        int iG = g(this.gc);
        if (iG != 0) {
            com.bytedance.msdk.gc.m.z((List<com.bytedance.msdk.g.dl>) null, this.m, iG);
            if (zVar != null) {
                zVar.z();
                return;
            }
            return;
        }
        boolean zI = i();
        List<com.bytedance.msdk.g.dl> listTb = this.dl.tb();
        try {
            listG = g();
        } catch (Throwable th) {
            com.bytedance.sdk.component.utils.wp.z(th);
        }
        List<com.bytedance.msdk.core.uy.uy> list = listG;
        if (list == null || list.size() <= 0 || !z(list, listTb, zI, activity, obj, str)) {
            if (listTb != null && listTb.size() > 0) {
                for (com.bytedance.msdk.g.dl dlVar : listTb) {
                    if (dlVar != null && (!zI || dlVar.by())) {
                        if (g(dlVar, activity, obj, str)) {
                            return;
                        }
                    }
                }
                if (zI && this.f428a == null) {
                    for (com.bytedance.msdk.g.dl dlVar2 : listTb) {
                        if (dlVar2 != null && g(dlVar2, activity, obj, str)) {
                            return;
                        }
                    }
                }
            }
            com.bytedance.msdk.gc.m.z(listTb, this.m, 0);
            if (zVar != null) {
                zVar.z();
            }
        }
    }

    private boolean a(com.bytedance.msdk.g.dl dlVar) {
        return !dlVar.jc() || dlVar.io() == 1;
    }

    private boolean g(com.bytedance.msdk.g.dl dlVar, Activity activity, Object obj, String str) {
        if (!dlVar.un(this.gc) || dlVar.jq()) {
            return false;
        }
        if (q()) {
            if (a(dlVar) && !com.bytedance.msdk.core.admanager.z.z(dlVar.zx(), dlVar.hy(), dlVar.j())) {
                com.bytedance.msdk.z.gc.dl.z("TTMediationSDK", com.bytedance.msdk.z.gc.gc.g(this.gc, dlVar.yz()) + "弱网情况下没有缓存好的广告,那么直接根据优先级展示，广告类型：" + com.bytedance.msdk.g.z.z(dlVar.r()) + ",isReady()：" + dlVar.un(this.gc));
                z(dlVar, activity, obj, str);
                return true;
            }
            com.bytedance.msdk.z.gc.dl.g("TTMediationSDK", "--==--- 插全屏轮播中，不能轮播的自定义adn跳过");
            return false;
        }
        com.bytedance.msdk.z.gc.dl.z("TTMediationSDK", com.bytedance.msdk.z.gc.gc.g(this.gc, dlVar.yz()) + "弱网情况下没有缓存好的广告,那么直接根据优先级展示，广告类型：" + com.bytedance.msdk.g.z.z(dlVar.r()) + ",isReady()：" + dlVar.un(this.gc));
        z(dlVar, activity, obj, str);
        return true;
    }

    private boolean dl(com.bytedance.msdk.g.dl dlVar, Activity activity, Object obj, String str) {
        if (!dlVar.un(this.gc) || dlVar.jq()) {
            return false;
        }
        if (q()) {
            if (a(dlVar) && !com.bytedance.msdk.core.admanager.z.z(dlVar.zx(), dlVar.hy(), dlVar.j())) {
                com.bytedance.msdk.z.gc.dl.z("TTMediationSDK", com.bytedance.msdk.z.gc.gc.g(this.gc, dlVar.yz()) + "弱网情况下没有缓存好的广告,那么直接根据优先级展示，广告类型：" + com.bytedance.msdk.g.z.z(dlVar.r()) + ",isReady()：" + dlVar.un(this.gc));
                g(dlVar);
                z(dlVar, activity, obj, str);
                return true;
            }
            com.bytedance.msdk.z.gc.dl.g("TTMediationSDK", "--==--- cache 插全屏轮播中，不能轮播的自定义adn跳过");
            return false;
        }
        com.bytedance.msdk.z.gc.dl.z("TTMediationSDK", com.bytedance.msdk.z.gc.gc.g(this.gc, dlVar.yz()) + "弱网情况下没有缓存好的广告,那么直接根据优先级展示，广告类型：" + com.bytedance.msdk.g.z.z(dlVar.r()) + ",isReady()：" + dlVar.un(this.gc));
        g(dlVar);
        z(dlVar, activity, obj, str);
        return true;
    }

    public void z(com.bytedance.msdk.g.dl dlVar, final Activity activity, final Object obj, final String str) {
        this.f428a = dlVar;
        com.bytedance.msdk.z.gc.m.dl(new Runnable() { // from class: com.bytedance.msdk.dl.a.uy.2
            @Override // java.lang.Runnable
            public void run() {
                if (uy.this.f428a != null) {
                    if (uy.this.z != null) {
                        uy.this.f428a.z(uy.this.z);
                    }
                    if (uy.this.i != null) {
                        uy.this.f428a.z(uy.this.i);
                    }
                    if (uy.this.v != null) {
                        uy.this.f428a.z(uy.this.v);
                    }
                    uy.this.dl.z(uy.this.f428a);
                    uy.this.f428a.gc(true);
                    uy.this.f428a.z(uy.this.fo);
                    uy.this.f428a.g(uy.this.js);
                    if (uy.this.f428a.wo() && com.bytedance.msdk.core.gc.z.z.z().a(uy.this.gc, uy.this.f428a.yz(), uy.this.js())) {
                        com.bytedance.msdk.dl.gz.m.z(uy.this.f428a, uy.this.gc, uy.this.f428a.yz());
                    }
                    List<com.bytedance.msdk.g.dl> listTb = uy.this.dl.tb();
                    com.bytedance.msdk.core.gc.z.z.z().z(listTb, uy.this.gc, uy.this.m, uy.this.m.gc(), uy.this.f428a);
                    com.bytedance.msdk.z.gc.dl.z("TTMediationSDK", com.bytedance.msdk.z.gc.gc.z(uy.this.gc, "show") + "展示的广告类型：" + com.bytedance.msdk.g.z.z(uy.this.f428a.r()) + ",slotId：" + uy.this.f428a.yz() + ",slotType:" + uy.this.f428a.yt() + ",isReady()：" + uy.this.f428a.un(uy.this.gc) + "，是否为缓存广告:" + uy.this.f428a.by());
                    uy.this.f428a.z(activity, obj, str);
                    com.bytedance.msdk.core.gz.i.z().g(uy.this.gc);
                    com.bytedance.msdk.core.gz.wp.z().g(uy.this.gc, uy.this.f428a.yz());
                    uy.this.wp = true;
                    if (uy.this.f428a != null) {
                        ArrayList arrayList = new ArrayList();
                        arrayList.add(uy.this.f428a);
                        if (uy.this.m.iq() == 7 || uy.this.m.iq() == 10) {
                            com.bytedance.msdk.dl.gc.z.z().z(uy.this.m, com.bytedance.msdk.dl.gc.z.z(uy.this.m, arrayList, listTb));
                        }
                        uy.this.z((List<com.bytedance.msdk.g.dl>) arrayList);
                    }
                    com.bytedance.msdk.gc.m.z(uy.this.f428a, uy.this.m, false, uy.this.q() ? 1 : 0);
                }
            }
        });
    }

    private boolean z(List<com.bytedance.msdk.core.uy.uy> list, List<com.bytedance.msdk.g.dl> list2, boolean z2, Activity activity, Object obj, String str) {
        List<com.bytedance.msdk.core.gc.g.e> listZ;
        com.bytedance.msdk.g.dl dlVar;
        List<com.bytedance.msdk.core.gc.g.e> listZ2;
        com.bytedance.msdk.g.dl dlVar2;
        HashMap<String, com.bytedance.msdk.g.dl> mapG = g(list2);
        for (com.bytedance.msdk.core.uy.uy uyVar : list) {
            if (uyVar != null) {
                String strFv = uyVar.fv();
                com.bytedance.msdk.g.dl dlVar3 = mapG.get(strFv);
                if (dlVar3 != null) {
                    if (z2) {
                        if (dlVar3.by() && g(dlVar3, activity, obj, str)) {
                            return true;
                        }
                    } else if (g(dlVar3, activity, obj, str)) {
                        return true;
                    }
                }
                if (uyVar.tb() && com.bytedance.msdk.core.gc.z.z.z().a(this.gc, strFv, this.m.gc()) && com.bytedance.msdk.core.gc.z.z.z().z(strFv, this.m, false) == 3 && (listZ2 = com.bytedance.msdk.core.gc.z.z.z().z(strFv, this.m, this.m.gc())) != null && listZ2.size() > 0 && (dlVar2 = listZ2.get(0).z) != null) {
                    if (z2) {
                        if (dlVar2.by() && dl(dlVar2, activity, obj, str)) {
                            return true;
                        }
                    } else if (dl(dlVar2, activity, obj, str)) {
                        return true;
                    }
                }
            }
        }
        if (z2 && this.f428a == null) {
            for (com.bytedance.msdk.core.uy.uy uyVar2 : list) {
                if (uyVar2 != null) {
                    String strFv2 = uyVar2.fv();
                    com.bytedance.msdk.g.dl dlVar4 = mapG.get(strFv2);
                    if (dlVar4 != null && g(dlVar4, activity, obj, str)) {
                        return true;
                    }
                    if (uyVar2.tb() && com.bytedance.msdk.core.gc.z.z.z().a(this.gc, strFv2, this.m.gc()) && com.bytedance.msdk.core.gc.z.z.z().z(strFv2, this.m, false) == 3 && (listZ = com.bytedance.msdk.core.gc.z.z.z().z(strFv2, this.m, this.m.gc())) != null && listZ.size() > 0 && (dlVar = listZ.get(0).z) != null && dl(dlVar, activity, obj, str)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public boolean hh() {
        List<com.bytedance.msdk.core.uy.uy> listG;
        try {
            listG = g();
        } catch (Throwable th) {
            com.bytedance.sdk.component.utils.wp.z(th);
            listG = null;
        }
        return v.z(this.dl.e(), this.dl.uy(), this.dl.gz(), this.m, this.wp, this.gc, this.m.gc(), listG);
    }

    public void z(Object obj) {
        this.z = obj;
        if (this.f428a != null) {
            this.f428a.z(obj);
        }
    }
}
