package com.bytedance.msdk.dl.a;

import android.content.Context;
import android.text.TextUtils;
import com.bytedance.msdk.dl.dl.z.z;
import com.bytedance.msdk.g.dl;
import com.bytedance.msdk.gz.h;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: loaded from: classes2.dex */
public class fo extends g {
    private com.bytedance.msdk.api.a.z.dl g;
    private z.InterfaceC0102z ls;
    private boolean p;
    private com.bytedance.msdk.api.a.z.e.a z;

    public fo(Context context) {
        super(context);
        this.p = false;
    }

    public void z(com.bytedance.msdk.api.z.g gVar, com.bytedance.msdk.api.a.z.e.a aVar) {
        z(gVar);
        this.z = aVar;
        fo();
    }

    @Override // com.bytedance.msdk.dl.a.g, com.bytedance.msdk.dl.g.z.z
    public void g(com.bytedance.msdk.api.z zVar) {
        com.bytedance.msdk.api.a.z.e.a aVar = this.z;
        if (aVar != null) {
            aVar.z(zVar);
            if (this.kb != 0 || this.g == null) {
                return;
            }
            this.kb = 2;
            this.g.z(zVar);
        }
    }

    @Override // com.bytedance.msdk.dl.a.g, com.bytedance.msdk.dl.g.z.z
    public void e() {
        List<com.bytedance.msdk.g.dl> listTb;
        List<com.bytedance.msdk.g.dl> listZ;
        if (this.z == null || (listZ = z((listTb = this.dl.tb()), this.m.hh())) == null || listZ.size() <= 0) {
            return;
        }
        if (com.bytedance.msdk.z.gc.dl.g()) {
            com.bytedance.msdk.z.gc.dl.a("TTMediationSDK", "返回给外部开发者的广告数量：sumList.size=" + listZ.size());
        }
        CopyOnWriteArrayList<com.bytedance.msdk.g.dl> copyOnWriteArrayList = new CopyOnWriteArrayList<>(listTb);
        for (com.bytedance.msdk.g.dl dlVar : listZ) {
            if (dlVar != null) {
                dlVar.gc(true);
                if (dlVar.wo() && com.bytedance.msdk.core.gc.z.z.z().a(this.gc, dlVar.yz(), this.m.gc())) {
                    com.bytedance.msdk.dl.gz.m.z(dlVar, this.gc, dlVar.yz());
                    z(copyOnWriteArrayList, dlVar);
                }
                z(this.dl.e(), dlVar);
                z(this.dl.gz(), dlVar);
                z(this.dl.fo(), dlVar);
                z(this.dl.uy(), dlVar);
            }
        }
        com.bytedance.msdk.core.gc.z.z.z().z(copyOnWriteArrayList, this.gc, this.m, this.m.gc(), null);
        this.z.z(listZ);
    }

    @Override // com.bytedance.msdk.dl.a.g, com.bytedance.msdk.dl.g.z.z
    public void z(List<com.bytedance.msdk.g.dl> list, com.bytedance.msdk.api.z zVar) {
        super.z(list, zVar);
        if (!(this.z instanceof com.bytedance.msdk.api.a.z.e.e) || h.z(list)) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        for (com.bytedance.msdk.g.dl dlVar : list) {
            dlVar.z(new dl.z() { // from class: com.bytedance.msdk.dl.a.fo.1
                @Override // com.bytedance.msdk.g.dl.z
                public void z() {
                    fo.this.wp = true;
                }

                @Override // com.bytedance.msdk.g.dl.z
                public void z(com.bytedance.msdk.g.dl dlVar2) {
                    fo.this.z(dlVar2, false);
                }
            });
            arrayList.add(dlVar);
        }
    }

    @Override // com.bytedance.msdk.dl.a.g, com.bytedance.msdk.dl.g.z.z
    public void z(String str) {
        if (this.kb != 0 || this.g == null) {
            return;
        }
        this.kb = 1;
        this.g.z(str);
    }

    public void z(String str, com.bytedance.msdk.api.a.z.e.a aVar) {
        if (this.kb != 1) {
            if (aVar != null) {
                aVar.z(new com.bytedance.msdk.api.z(10015, com.bytedance.msdk.api.z.z(10015)));
            }
        } else if (this.uy) {
            if (aVar != null) {
                aVar.z(new com.bytedance.msdk.api.z(40047, com.bytedance.msdk.api.z.z(40047)));
            }
        } else {
            this.uy = true;
            this.z = aVar;
            z.InterfaceC0102z interfaceC0102z = this.ls;
            if (interfaceC0102z != null) {
                interfaceC0102z.z(str);
            }
        }
    }

    public void z(com.bytedance.msdk.api.z.g gVar, com.bytedance.msdk.api.a.z.dl dlVar) {
        z(gVar);
        this.g = dlVar;
        if (this.dl.wp() != null && this.dl.wp().i()) {
            this.ls = fo();
        } else if (dlVar != null) {
            dlVar.z(new com.bytedance.msdk.api.z(10014, com.bytedance.msdk.api.z.z(10014)));
        }
    }

    @Override // com.bytedance.msdk.dl.a.g
    public void z() {
        this.z = null;
    }

    private List<com.bytedance.msdk.g.dl> z(List<com.bytedance.msdk.g.dl> list, int i) {
        if (list == null || list.size() <= 0) {
            return null;
        }
        dl(list);
        dl();
        ArrayList arrayList = new ArrayList();
        Iterator<com.bytedance.msdk.g.dl> it = list.iterator();
        while (it.hasNext() && arrayList.size() < i) {
            com.bytedance.msdk.g.dl next = it.next();
            arrayList.add(next);
            if (com.bytedance.msdk.z.gc.dl.g()) {
                com.bytedance.msdk.z.gc.dl.a("TTMediationSDK", "");
                com.bytedance.msdk.z.gc.dl.a("TTMediationSDK", com.bytedance.msdk.z.gc.gc.z(this.gc, "show") + "返回给开发者最终广告：slotId=" + next.yz() + ",slotType:" + next.yt() + ",cpm=" + next.u() + ",广告类型：" + com.bytedance.msdk.g.z.z(next.r()) + ",ImageMode=" + next.nh() + ",showSort=" + next.dt() + ",isExpressAd=" + next.tc());
            }
            next.z(new dl.z() { // from class: com.bytedance.msdk.dl.a.fo.2
                @Override // com.bytedance.msdk.g.dl.z
                public void z() {
                    fo.this.wp = true;
                }

                @Override // com.bytedance.msdk.g.dl.z
                public void z(com.bytedance.msdk.g.dl dlVar) {
                    boolean z;
                    if (com.bytedance.msdk.core.gc.g.a.z().dl(fo.this.gc, fo.this.m.gc()) || fo.this.p) {
                        z = false;
                    } else {
                        z = true;
                        fo.this.p = true;
                    }
                    fo.this.z(dlVar, z);
                    fo.this.dl(dlVar);
                }
            });
            it.remove();
        }
        com.bytedance.msdk.dl.gc.z.z().z(this.m, com.bytedance.msdk.dl.gc.z.z(this.m, arrayList, list));
        z(arrayList);
        return arrayList;
    }

    public void z(com.bytedance.msdk.g.dl dlVar, boolean z) {
        if (dlVar != null && dlVar.wo() && com.bytedance.msdk.core.gc.z.z.z().a(this.gc, dlVar.yz(), this.m.gc())) {
            com.bytedance.msdk.core.gc.z.z.z().z(dlVar.yz(), this.m, this.dl.h(), z, this.dl.gk(), this.dl.un(), this.gz.get());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dl(com.bytedance.msdk.g.dl dlVar) {
        if (this.m.f() || dlVar == null || dlVar.r() == 7 || (dlVar instanceof com.bytedance.msdk.api.a.z.g.g) || this.e == null || this.e.i()) {
            return;
        }
        com.bytedance.msdk.core.gc.g.a.z().g(this.gz.get(), this.gc, this.m.gc());
    }

    private void z(CopyOnWriteArrayList<com.bytedance.msdk.g.dl> copyOnWriteArrayList, com.bytedance.msdk.g.dl dlVar) {
        for (com.bytedance.msdk.g.dl dlVar2 : copyOnWriteArrayList) {
            if (dlVar2 == dlVar && dlVar2 != null) {
                copyOnWriteArrayList.remove(dlVar2);
            }
        }
    }

    private void dl(List<com.bytedance.msdk.g.dl> list) {
        if (list == null || list.size() <= 0) {
            return;
        }
        ArrayList<com.bytedance.msdk.g.dl> arrayList = new ArrayList(list.size());
        arrayList.addAll(list);
        list.clear();
        for (com.bytedance.msdk.g.dl dlVar : arrayList) {
            if (dlVar != null && !dlVar.jq() && dlVar.un(this.gc)) {
                list.add(dlVar);
            }
        }
    }

    private void dl() {
        try {
            List<com.bytedance.msdk.core.uy.uy> listG = g();
            if (listG == null || listG.size() <= 0) {
                return;
            }
            for (com.bytedance.msdk.core.uy.uy uyVar : listG) {
                if (uyVar != null) {
                    String strFv = uyVar.fv();
                    if (com.bytedance.msdk.core.gc.z.z.z().a(this.gc, strFv, this.m.gc())) {
                        if (uyVar.js() == 100) {
                            z(strFv, this.dl.e());
                        } else if (uyVar.js() == 0) {
                            z(strFv, this.dl.gz());
                        }
                    }
                }
            }
        } catch (Throwable th) {
            com.bytedance.sdk.component.utils.wp.z(th);
        }
    }

    private void z(String str, List<com.bytedance.msdk.g.dl> list) {
        List<com.bytedance.msdk.core.gc.g.e> listZ;
        if (g(str, list) || com.bytedance.msdk.core.gc.z.z.z().z(str, this.m, false) != 3 || (listZ = com.bytedance.msdk.core.gc.z.z.z().z(str, this.m, this.m.gc())) == null || listZ.size() <= 0) {
            return;
        }
        for (com.bytedance.msdk.core.gc.g.e eVar : listZ) {
            if (eVar != null && eVar.z != null && !eVar.z.jq() && eVar.z.un(this.gc)) {
                list.add(eVar.z);
                g(eVar.z);
            }
        }
    }

    private boolean g(String str, List<com.bytedance.msdk.g.dl> list) {
        if (list == null || list.size() <= 0) {
            return false;
        }
        for (com.bytedance.msdk.g.dl dlVar : list) {
            if (dlVar != null && TextUtils.equals(str, dlVar.yz())) {
                return true;
            }
        }
        return false;
    }
}
