package com.bytedance.msdk.dl.dl.g;

import com.bytedance.msdk.core.uy.uy;
import com.bytedance.msdk.dl.dl.g.z;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class m implements z {
    @Override // com.bytedance.msdk.dl.dl.g.z
    public void z(z.InterfaceC0089z interfaceC0089z) {
        List<com.bytedance.msdk.core.gc.g.e> listZ;
        uy uyVarGz = interfaceC0089z.z().gz();
        com.bytedance.msdk.api.z.g gVarJs = interfaceC0089z.g().js();
        if (uyVarGz != null) {
            String strFv = uyVarGz.fv();
            if (uyVarGz.tb() && com.bytedance.msdk.core.gc.z.z.z().a(gVarJs.zw(), strFv, gVarJs.gc())) {
                com.bytedance.msdk.z.gc.dl.g("TTMediationSDK", "--==-- 广告复用，模式：" + com.bytedance.msdk.core.gc.z.z.z().gc(gVarJs.zw(), strFv, gVarJs.gc()));
                int iZ = com.bytedance.msdk.core.gc.z.z.z().z(strFv, gVarJs, true);
                interfaceC0089z.z().dl(iZ);
                if (iZ == 3) {
                    interfaceC0089z.z().z(2);
                    if (z(interfaceC0089z.g(), interfaceC0089z.z(), gVarJs, strFv, uyVarGz, 2)) {
                        return;
                    }
                } else if (iZ == 2 && (listZ = com.bytedance.msdk.core.gc.z.z.z().z(strFv, gVarJs, gVarJs.gc())) != null && listZ.size() > 0) {
                    interfaceC0089z.z().g(listZ.get(0).z.gz(gVarJs.z()));
                }
            }
        }
        interfaceC0089z.z(this);
    }

    private boolean z(com.bytedance.msdk.dl.m.z.g gVar, com.bytedance.msdk.dl.m.g.g gVar2, com.bytedance.msdk.api.z.g gVar3, String str, uy uyVar, int i) {
        com.bytedance.msdk.core.gc.z.z.z().z(gVar3.zw(), str, uyVar, i);
        List<com.bytedance.msdk.core.gc.g.e> listZ = com.bytedance.msdk.core.gc.z.z.z().z(str, gVar3, gVar3.gc());
        if (listZ == null || listZ.size() <= 0) {
            return false;
        }
        int iGz = listZ.get(0).z.gz(gVar3.z());
        com.bytedance.msdk.gc.m.z(uyVar, gVar3, com.bytedance.msdk.core.gc.z.z.z().z(str), !gVar.zw(), 1, i, 3, iGz, (com.bytedance.msdk.api.z) null, -1L, false, false);
        ArrayList arrayList = new ArrayList();
        for (com.bytedance.msdk.core.gc.g.e eVar : listZ) {
            eVar.z.fo(3);
            eVar.z.uy(iGz);
            eVar.z.dl(false);
            eVar.z.g(false);
            com.bytedance.msdk.dl.gz.m.z(eVar.z, gVar3.zw(), str);
            arrayList.add(eVar.z);
        }
        com.bytedance.msdk.gc.m.z(listZ.get(0).z, 0, "adn cache命中", 0L, gVar3, i, arrayList.size(), 2, (String) null, 0L, -1L);
        gVar2.z(arrayList, uyVar);
        return true;
    }
}
