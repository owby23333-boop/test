package com.bytedance.msdk.dl.e;

import android.text.TextUtils;
import com.bytedance.msdk.core.uy.g;
import com.bytedance.msdk.core.uy.uy;
import com.bytedance.msdk.g.dl;
import com.bytedance.msdk.z.gc.gc;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class z {
    public static void z(g gVar, com.bytedance.msdk.dl.m.z.g gVar2, List<uy> list) {
        boolean z;
        if (gVar == null || gVar2 == null || list == null || list.size() == 0) {
            return;
        }
        for (dl dlVar : gVar2.gz()) {
            Iterator<uy> it = list.iterator();
            while (true) {
                if (!it.hasNext()) {
                    z = true;
                    break;
                }
                uy next = it.next();
                if (dlVar != null && next != null && dlVar.yz().equals(next.fv())) {
                    z = false;
                    break;
                }
            }
            if (z) {
                com.bytedance.msdk.z.gc.dl.a("TTMediationSDK", gc.z(gVar) + "已经响应的广告: " + dlVar.yz() + "  没有在severBidding的waterFall列表中，需要被移除掉");
                gVar2.gz().remove(dlVar);
                gVar2.fo().add(dlVar);
            }
        }
        com.bytedance.msdk.z.gc.dl.a("TTMediationSDK", gc.z(gVar) + "已经响应的广告被serverBidding过滤完还剩: " + gVar2.gz().size());
    }

    public static boolean z(com.bytedance.msdk.dl.m.z.z zVar, List<uy> list, String str) {
        if (list == null || zVar == null || TextUtils.isEmpty(str) || zVar.g() != 1) {
            return false;
        }
        Iterator<uy> it = list.iterator();
        while (it.hasNext()) {
            if (str.equals(it.next().fv())) {
                return false;
            }
        }
        return true;
    }
}
