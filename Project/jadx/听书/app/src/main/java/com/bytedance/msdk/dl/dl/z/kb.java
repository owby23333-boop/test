package com.bytedance.msdk.dl.dl.z;

import com.bytedance.msdk.dl.dl.z.z;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public class kb implements z {
    @Override // com.bytedance.msdk.dl.dl.z.z
    public void z(z.InterfaceC0102z interfaceC0102z) {
        com.bytedance.msdk.dl.m.z.g gVarZ = interfaceC0102z.z();
        com.bytedance.msdk.api.z.g gVarJs = gVarZ.js();
        gVarJs.zw();
        if (gVarJs != null && gVarJs.f()) {
            String str = "TTMediationSDK";
            com.bytedance.msdk.z.gc.dl.g("TTMediationSDK", com.bytedance.msdk.z.gc.gc.z(gVarJs.zw()) + "V2 公共缓存池广告请求......");
            String strVm = gVarZ.wp() != null ? gVarZ.wp().vm() : null;
            boolean z = !gVarZ.zw();
            if (com.bytedance.msdk.core.g.g().m()) {
                List<com.bytedance.msdk.core.gc.g.e> listZ = com.bytedance.msdk.dl.gc.z.z().z(gVarJs);
                if (listZ != null && !listZ.isEmpty()) {
                    com.bytedance.msdk.gc.m.z(listZ.get(0).z, gVarJs, gVarZ.wp(), 0L, gVarZ.un().z, z, listZ != null ? listZ.size() : 0, gVarZ.un().gc, false);
                    int size = listZ.size() - 1;
                    String strM = null;
                    while (size >= 0) {
                        com.bytedance.msdk.core.gc.g.e eVar = listZ.get(size);
                        com.bytedance.msdk.g.dl dlVar = eVar.z;
                        dlVar.z(eVar.m());
                        dlVar.g(eVar.a() != null ? eVar.a().z() : null);
                        if (size == 0) {
                            strM = eVar.m();
                        }
                        String str2 = strM;
                        ArrayList arrayList = new ArrayList();
                        arrayList.add(dlVar);
                        com.bytedance.msdk.dl.gc.z.z(gVarJs, eVar.m());
                        com.bytedance.msdk.gc.m.z(com.bytedance.msdk.core.g.g().z(eVar.m(), gVarJs.iq(), 102).m(dlVar.yz()), gVarJs, com.bytedance.msdk.core.gc.z.z.z().z(dlVar.yz()), true, 1, 0, 3, 3, null, -1L, false, false, eVar.a() != null ? eVar.a().z() : null);
                        gVarZ.z(arrayList);
                        com.bytedance.msdk.gc.m.z(dlVar, 0, "adn cache命中", 0L, gVarJs, 0, arrayList.size(), 2, (String) null, 0L, -1L);
                        size--;
                        strM = str2;
                        listZ = listZ;
                        str = str;
                    }
                    com.bytedance.msdk.dl.gc.z.z(gVarJs, strM);
                    com.bytedance.msdk.z.gc.dl.g(str, com.bytedance.msdk.z.gc.gc.z(gVarJs.zw()) + "V2 resetAdLinkInfo......");
                    com.bytedance.msdk.gc.m.z(gVarJs, strVm, z, gVarZ.un().z, 0, (Map<String, Object>) null);
                    gVarZ.a();
                    return;
                }
                com.bytedance.msdk.dl.gc.z.z(gVarJs, "-1");
                com.bytedance.msdk.api.g.z zVar = new com.bytedance.msdk.api.g.z(41008, com.bytedance.msdk.api.z.z(41008));
                com.bytedance.msdk.gc.m.z(gVarJs, strVm, z, gVarZ.un().z, zVar.z, (Map<String, Object>) null);
                gVarZ.z(zVar);
                return;
            }
            com.bytedance.msdk.dl.gc.z.z(gVarJs, "-2");
            com.bytedance.msdk.api.g.z zVar2 = new com.bytedance.msdk.api.g.z(41007, com.bytedance.msdk.api.z.z(41007));
            com.bytedance.msdk.gc.m.z(gVarJs, strVm, z, gVarZ.un().z, zVar2.z, (Map<String, Object>) null);
            gVarZ.z(zVar2);
            return;
        }
        interfaceC0102z.z(interfaceC0102z.z());
    }

    @Override // com.bytedance.msdk.dl.dl.z.z
    public void g(z.InterfaceC0102z interfaceC0102z) {
        interfaceC0102z.z((String) null);
    }
}
