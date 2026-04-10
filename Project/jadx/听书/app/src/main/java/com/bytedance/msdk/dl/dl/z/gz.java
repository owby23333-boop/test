package com.bytedance.msdk.dl.dl.z;

import com.bytedance.msdk.core.gc.g.a;
import com.bytedance.msdk.dl.dl.z.z;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public class gz implements z {
    private int z = 0;

    @Override // com.bytedance.msdk.dl.dl.z.z
    public void z(z.InterfaceC0102z interfaceC0102z) {
        String strUn = interfaceC0102z.z().wp().un();
        com.bytedance.msdk.api.z.g gVarJs = interfaceC0102z.z().js();
        boolean zZw = interfaceC0102z.z().zw();
        if (com.bytedance.msdk.core.gc.g.a.z().dl(strUn, gVarJs.gc())) {
            boolean z = com.bytedance.msdk.core.gc.g.a.z().z(strUn) == null;
            if (!zZw && !z && z(strUn, gVarJs, interfaceC0102z.z())) {
                interfaceC0102z.z().dl(true);
                z(gVarJs, strUn, interfaceC0102z.z().wp(), interfaceC0102z.z());
                return;
            }
            com.bytedance.msdk.core.gc.g.a.z().z(strUn, gVarJs);
        }
        interfaceC0102z.z(interfaceC0102z.z());
    }

    private boolean z(String str, com.bytedance.msdk.api.z.g gVar, com.bytedance.msdk.dl.m.z.g gVar2) {
        List<com.bytedance.msdk.core.gc.g.e> listA;
        com.bytedance.msdk.core.uy.g gVarWp = gVar2.wp();
        if (com.bytedance.msdk.core.gc.g.a.z().z(str, gVar, gVarWp != null ? gVarWp.vm() : null) && (listA = com.bytedance.msdk.core.gc.g.a.z().a(str)) != null && listA.size() > 0) {
            for (com.bytedance.msdk.core.gc.g.e eVar : listA) {
                ArrayList arrayList = new ArrayList();
                arrayList.add(eVar.z);
                gVar2.z(arrayList);
            }
            if (gVar2.e().size() > 0 || gVar2.uy().size() > 0 || gVar2.gz().size() > 0) {
                com.bytedance.msdk.z.gc.dl.g("TTMediationSDK", com.bytedance.msdk.z.gc.gc.z(str) + "--==-- hit cache!!! -----");
                return true;
            }
        }
        com.bytedance.msdk.z.gc.dl.g("TTMediationSDK", com.bytedance.msdk.z.gc.gc.z(str) + "--==-- not hit cache!!! -----");
        return false;
    }

    private void z(com.bytedance.msdk.api.z.g gVar, String str, com.bytedance.msdk.core.uy.g gVar2, final com.bytedance.msdk.dl.m.z.g gVar3) {
        com.bytedance.msdk.api.z.g gVarG = com.bytedance.msdk.core.gc.g.a.z().g(str);
        if (gVarG != null) {
            gVar.z(gVarG.z());
            gVar.g(gVarG.dl());
        }
        com.bytedance.msdk.core.gc.g.a.z().z(str, gVar);
        com.bytedance.msdk.gc.m.z(gVar3.js(), gVar2.vm(), !gVar3.zw(), gVar3.un().z, 0, (Map<String, Object>) null);
        com.bytedance.msdk.g.dl dlVar = null;
        com.bytedance.msdk.dl.gz.z.z(gVar3, null, false);
        com.bytedance.msdk.core.gc.g.g gVarDl = com.bytedance.msdk.core.gc.g.a.z().dl(str);
        if (gVarDl != null) {
            gVar3.z(gVarDl.a() != null ? gVarDl.a().un() : null);
            gVar3.z(gVarDl.dl());
        }
        final int iG = com.bytedance.msdk.core.gc.g.a.z().g(str, gVar.gc());
        if (iG == 2) {
            this.z = 1;
            gVar3.z(1);
            gVar3.a();
            return;
        }
        if (iG == 3 || iG == 4) {
            if (gVar.gz() == 1) {
                com.bytedance.msdk.z.gc.dl.g("TTMediationSDK", "--==-- 激励再得情况，不进行预缓存补充，直接对外给出回调");
                this.z = 2;
                gVar3.z(2);
                gVar3.a();
                return;
            }
            long jGc = com.bytedance.msdk.core.gc.g.a.gc(str);
            long jCurrentTimeMillis = System.currentTimeMillis() - jGc;
            if (jGc != -1 && jCurrentTimeMillis < gVar2.gc()) {
                com.bytedance.msdk.z.gc.dl.g("TTMediationSDK", "--==-- 预缓存补充请求无需发起，时间间隔不够，interval：" + jCurrentTimeMillis + ", config interval: " + gVar2.gc());
                this.z = 3;
                gVar3.z(3);
                gVar3.a();
                return;
            }
            List<com.bytedance.msdk.g.dl> listTb = gVar3.tb();
            if (listTb != null && listTb.size() > 0) {
                dlVar = listTb.get(0);
            }
            com.bytedance.msdk.g.dl dlVar2 = dlVar;
            final double dZ = z(str, gVar.iq());
            if (dlVar2 != null && !dlVar2.o() && dlVar2.u() < dZ) {
                com.bytedance.msdk.core.gc.g.a.z().z(gVar3.getContext(), str, iG, gVar, dlVar2, new a.dl() { // from class: com.bytedance.msdk.dl.dl.z.gz.1
                    @Override // com.bytedance.msdk.core.gc.g.a.dl
                    public void z(String str2, boolean z, int i, List<com.bytedance.msdk.g.dl> list) {
                        gz.this.z(str2, z, i, list, iG, dZ, gVar3);
                    }
                });
                return;
            }
            com.bytedance.msdk.z.gc.dl.g("TTMediationSDK", "--==-- 预缓存补充请求无需发起，已经命中最优");
            this.z = 4;
            gVar3.z(4);
            gVar3.a();
            return;
        }
        com.bytedance.msdk.z.gc.dl.g("TTMediationSDK", "--==-- 预缓存reqType错误：reqType = ".concat(String.valueOf(iG)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void z(String str, boolean z, int i, List<com.bytedance.msdk.g.dl> list, int i2, double d, com.bytedance.msdk.dl.m.z.g gVar) {
        if (z) {
            if (i2 == 4) {
                com.bytedance.msdk.g.dl dlVar = (list == null || list.size() <= 0) ? null : list.get(0);
                if (dlVar != null && dlVar.u() >= d) {
                    this.z = 6;
                } else {
                    this.z = 7;
                }
            } else if (i2 == 3) {
                this.z = 5;
            }
        } else if (i == 10003) {
            this.z = 9;
        } else if (i == 10086) {
            this.z = 8;
        }
        gVar.z(this.z);
        gVar.z(list);
        com.bytedance.msdk.z.gc.dl.g("TTMediationSDK", "--==-- 预缓存补充请求结束，对外给出回调");
        gVar.a();
    }

    private double z(String str, int i) {
        com.bytedance.msdk.core.uy.g gVarZ = com.bytedance.msdk.e.z.dl.z().z(str, i, 102);
        double dZw = 0.0d;
        if (gVarZ == null) {
            return 0.0d;
        }
        for (com.bytedance.msdk.core.uy.uy uyVar : gVarZ.t()) {
            if (uyVar.ti() && uyVar.zw() > dZw) {
                dZw = uyVar.zw();
            }
        }
        return dZw;
    }

    @Override // com.bytedance.msdk.dl.dl.z.z
    public void g(z.InterfaceC0102z interfaceC0102z) {
        interfaceC0102z.z((String) null);
    }
}
