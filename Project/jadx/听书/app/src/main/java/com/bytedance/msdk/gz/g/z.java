package com.bytedance.msdk.gz.g;

import com.bytedance.msdk.core.gc.g.e;
import com.bytedance.msdk.core.uy.g;
import com.bytedance.msdk.core.uy.uy;
import com.bytedance.msdk.gc.m;
import com.bytedance.msdk.z.gc.dl;
import com.bytedance.msdk.z.gc.gc;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public class z {
    public static boolean z(g gVar) {
        if (gVar == null) {
            return false;
        }
        int iTi = gVar.ti();
        Map<String, Integer> mapGb = com.bytedance.msdk.core.g.g().gb();
        if (mapGb == null) {
            return false;
        }
        Integer num = mapGb.get(String.valueOf(iTi));
        if (num != null) {
            return num.intValue() == 1;
        }
        Integer num2 = mapGb.get("-1");
        return num2 != null && num2.intValue() == 1;
    }

    public static boolean g(g gVar) {
        if (gVar == null) {
            return false;
        }
        int iTi = gVar.ti();
        Map<String, Integer> mapJq = com.bytedance.msdk.core.g.g().jq();
        if (mapJq == null) {
            return false;
        }
        Integer num = mapJq.get(String.valueOf(iTi));
        if (num != null) {
            return num.intValue() == 1;
        }
        Integer num2 = mapJq.get("-1");
        return num2 != null && num2.intValue() == 1;
    }

    /* JADX WARN: Removed duplicated region for block: B:64:0x0137 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:85:0x0054 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static boolean z(com.bytedance.msdk.dl.m.z.g r10, java.util.List<java.lang.Integer> r11, java.util.Map<java.lang.Integer, java.util.List<com.bytedance.msdk.core.uy.uy>> r12) {
        /*
            Method dump skipped, instruction units count: 398
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.msdk.gz.g.z.z(com.bytedance.msdk.dl.m.z.g, java.util.List, java.util.Map):boolean");
    }

    public static void z(com.bytedance.msdk.dl.m.z.g gVar, uy uyVar, int i) {
        if (gVar == null || gVar.js() == null || uyVar == null) {
            return;
        }
        com.bytedance.msdk.api.z.g gVarJs = gVar.js();
        String strZw = gVarJs.zw();
        dl.g("TTMediationSDK", gc.z(strZw) + "----------总超时后尝试从复用池中查找广告：id:" + uyVar.fv() + "   loadSort:" + uyVar.io() + "  showSort:" + uyVar.uf() + "   adnName:" + uyVar.pf());
        String strFv = uyVar.fv();
        if (uyVar.tb() && com.bytedance.msdk.core.gc.z.z.z().a(strZw, strFv, gVarJs.gc()) && com.bytedance.msdk.core.gc.z.z.z().z(strFv, gVarJs, true) == 3) {
            dl.g("TTMediationSDK", gc.z(strZw) + "----------可复用：id:" + uyVar.fv() + "   loadSort:" + uyVar.io() + "  showSort:" + uyVar.uf() + "   adnName:" + uyVar.pf());
            com.bytedance.msdk.core.gc.z.z.z().z(strZw, strFv, uyVar, i);
            List<e> listZ = com.bytedance.msdk.core.gc.z.z.z().z(strFv, gVarJs, gVarJs.gc());
            if (listZ == null || listZ.size() <= 0) {
                return;
            }
            int iGz = listZ.get(0).z.gz(gVarJs != null ? gVarJs.z() : null);
            m.z(uyVar, gVarJs, com.bytedance.msdk.core.gc.z.z.z().z(strFv), !gVar.zw(), 4, i, 3, iGz, (com.bytedance.msdk.api.z) null, -1L, gVar.g(), true);
            ArrayList arrayList = new ArrayList();
            for (e eVar : listZ) {
                eVar.z.fo(3);
                eVar.z.uy(iGz);
                eVar.z.dl(gVar.g());
                eVar.z.g(true);
                z(strZw, eVar.z, strFv);
                arrayList.add(eVar.z);
            }
            m.z(listZ.get(0).z, 0, "adn cache命中", 0L, gVarJs, i, arrayList.size(), 4, (String) null, 0L, -1L);
            com.bytedance.msdk.dl.gz.z.z(gVar, arrayList, true);
            com.bytedance.msdk.g.dl dlVar = arrayList.get(0);
            if (dlVar.o()) {
                gVar.z(arrayList);
                for (com.bytedance.msdk.g.dl dlVar2 : arrayList) {
                    dl.z("TTMediationSDK", gc.z(strZw) + "复用池回溯成功...........回溯到了P层广告_当前P层广告缓存池数量：" + gVar.e().size() + ",slotId：" + dlVar2.yz() + ",广告类型：" + dlVar2.zx() + ",loadSort=" + dlVar2.xo() + ",showSort=" + dlVar2.dt() + ",CPM=" + dlVar2.u());
                }
                return;
            }
            if (dlVar.cb()) {
                gVar.z(arrayList);
                for (com.bytedance.msdk.g.dl dlVar3 : arrayList) {
                    dl.z("TTMediationSDK", gc.z(strZw) + "复用池回溯成功...........回溯到了普通层广告_当前普通广告缓存池数量：" + gVar.gz().size() + ",slotId：" + dlVar3.yz() + ",广告类型：" + dlVar3.zx() + ",loadSort=" + dlVar3.xo() + ",showSort=" + dlVar3.dt() + ",CPM=" + dlVar3.u());
                }
            }
        }
    }

    private static void z(String str, com.bytedance.msdk.g.dl dlVar, String str2) {
        uy uyVarGc = com.bytedance.msdk.core.gc.z.z.z().gc(str, str2);
        if (dlVar == null || uyVarGc == null) {
            return;
        }
        dlVar.p(uyVarGc.io());
        dlVar.ls(uyVarGc.uf());
        dlVar.pf(uyVarGc.v());
        dlVar.pf(uyVarGc.js());
        dlVar.z(uyVarGc.zw());
        dlVar.gc(uyVarGc.m());
    }
}
