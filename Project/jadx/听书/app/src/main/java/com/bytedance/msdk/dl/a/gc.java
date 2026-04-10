package com.bytedance.msdk.dl.a;

import android.content.Context;
import com.bytedance.msdk.core.gc.g.a;
import com.bytedance.msdk.gz.x;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: loaded from: classes2.dex */
public class gc extends g implements com.bytedance.msdk.core.gc.g.dl {
    private a.dl g;
    private List<com.bytedance.msdk.core.uy.uy> ls;
    private final int z;

    public gc(Context context, int i) {
        super(context);
        this.z = i;
    }

    @Override // com.bytedance.msdk.core.gc.g.dl
    public void z(com.bytedance.msdk.api.z.g gVar, com.bytedance.msdk.g.dl dlVar, a.dl dlVar2) {
        this.g = dlVar2;
        z(gVar);
        this.dl.z(true);
        this.dl.a(true);
        this.dl.js().z(gVar.z());
        this.e = z(this.e, dlVar);
        this.dl.z(this.e);
        this.m.m(1);
        com.bytedance.msdk.core.uy.g gVarZ = com.bytedance.msdk.core.dl.dl.z(this.m, this.e);
        if (gVarZ != null) {
            this.e = gVarZ;
            this.dl.z(this.e);
        }
        if (this.e == null) {
            com.bytedance.msdk.z.gc.dl.z("TTMediationSDK", "--==-- 预缓存补充请求未发起，mRitConfig为null");
            a.dl dlVar3 = this.g;
            if (dlVar3 != null) {
                dlVar3.z(this.gc, false, 0, null);
                return;
            }
            return;
        }
        List<com.bytedance.msdk.core.uy.uy> listT = this.e.t();
        if (listT == null || listT.size() <= 0) {
            com.bytedance.msdk.z.gc.dl.z("TTMediationSDK", "--==-- 预缓存补充请求未发起，过滤后的waterfall为空");
            a.dl dlVar4 = this.g;
            if (dlVar4 != null) {
                dlVar4.z(this.gc, false, 0, null);
                return;
            }
            return;
        }
        this.e.m((long) (this.e.wj() * this.e.a()));
        this.e.gc((long) (this.e.oq() * this.e.dl()));
        this.e.g(false);
        this.e.z(false);
        List<com.bytedance.msdk.core.uy.uy> listT2 = this.e.t();
        this.ls = listT2;
        x.z(listT2, this.pf);
        if (com.bytedance.msdk.z.gc.dl.g()) {
            com.bytedance.msdk.z.gc.dl.z("TTMediationSDK", "--==-- 预缓存补充请求，过滤后的waterfall：");
            for (com.bytedance.msdk.core.uy.uy uyVar : this.ls) {
                com.bytedance.msdk.z.gc.dl.z("TTMediationSDK", com.bytedance.msdk.z.gc.gc.z(this.gc) + "waterfall: " + uyVar.pf() + "adnSlotId: " + uyVar.fv() + ", loadSort: " + uyVar.io() + ", showSort: " + uyVar.uf() + ", eCpm: " + uyVar.zw());
            }
        }
        fo();
    }

    @Override // com.bytedance.msdk.dl.a.g
    protected com.bytedance.msdk.dl.dl.z.e fo() {
        ArrayList arrayList = new ArrayList();
        int i = this.z;
        if (i == 3) {
            arrayList.add(new com.bytedance.msdk.dl.dl.z.fo());
        } else if (i == 4) {
            arrayList.add(new com.bytedance.msdk.dl.dl.z.uy(this.dl, this.e, this.ls));
        } else {
            arrayList.add(new com.bytedance.msdk.dl.dl.z.g());
        }
        com.bytedance.msdk.dl.dl.z.e eVar = new com.bytedance.msdk.dl.dl.z.e(arrayList);
        eVar.z(this.dl);
        return eVar;
    }

    private com.bytedance.msdk.core.uy.g z(com.bytedance.msdk.core.uy.g gVar, com.bytedance.msdk.g.dl dlVar) {
        if (gVar == null || dlVar == null) {
            return null;
        }
        double dU = dlVar.u();
        com.bytedance.msdk.z.gc.dl.g("TMe", "筛选预缓存 ecpm ".concat(String.valueOf(dU)));
        com.bytedance.msdk.core.uy.g gVarClone = gVar.clone();
        CopyOnWriteArrayList copyOnWriteArrayList = new CopyOnWriteArrayList();
        for (com.bytedance.msdk.core.uy.uy uyVar : gVarClone.t()) {
            if (uyVar != null && uyVar.ti() && uyVar.zw() > dU) {
                copyOnWriteArrayList.add(uyVar);
            }
        }
        if (gVarClone.wp()) {
            gVarClone.g(copyOnWriteArrayList);
        } else {
            gVarClone.z(copyOnWriteArrayList);
        }
        return gVarClone;
    }

    @Override // com.bytedance.msdk.dl.a.g, com.bytedance.msdk.dl.g.z.z
    public void e() {
        super.e();
        a.dl dlVar = this.g;
        if (dlVar != null) {
            dlVar.z(this.e != null ? this.e.un() : "", true, 0, this.dl.gz());
        }
    }

    @Override // com.bytedance.msdk.dl.a.g, com.bytedance.msdk.dl.g.z.z
    public void g(com.bytedance.msdk.api.z zVar) {
        super.g(zVar);
        if (this.g != null) {
            int i = 20005;
            if (zVar != null) {
                if (zVar.z == 10003) {
                    i = 10003;
                } else {
                    int i2 = zVar.z;
                }
            }
            this.g.z(this.e != null ? this.e.un() : "", false, i, null);
        }
    }
}
