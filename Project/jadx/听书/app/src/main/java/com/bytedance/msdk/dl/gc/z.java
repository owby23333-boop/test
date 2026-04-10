package com.bytedance.msdk.dl.gc;

import android.text.TextUtils;
import com.bytedance.msdk.api.z.g;
import com.bytedance.msdk.core.gc.g.e;
import com.bytedance.msdk.g.dl;
import com.bytedance.msdk.gz.x;
import com.bytedance.sdk.openadsdk.ls.dl.dl.g;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: loaded from: classes2.dex */
public class z {
    private static volatile z g;
    private final Map<Integer, CopyOnWriteArrayList<e>> z = new ConcurrentHashMap();
    private final Comparator<e> dl = new Comparator<e>() { // from class: com.bytedance.msdk.dl.gc.z.1
        @Override // java.util.Comparator
        /* JADX INFO: renamed from: z, reason: merged with bridge method [inline-methods] */
        public int compare(e eVar, e eVar2) {
            if (eVar != null && eVar2 != null && eVar.z != null && eVar2.z != null) {
                if (eVar.z.u() > eVar2.z.u()) {
                    return -1;
                }
                if (eVar.z.u() < eVar2.z.u()) {
                    return 1;
                }
                if (eVar.z.u() == eVar2.z.u() && eVar.z.r() == 1) {
                    return -1;
                }
            }
            return 0;
        }
    };

    private z() {
    }

    public static z z() {
        if (g == null) {
            synchronized (com.bytedance.msdk.core.gc.z.z.class) {
                if (g == null) {
                    g = new z();
                }
            }
        }
        return g;
    }

    public synchronized void z(g gVar, List<dl> list) {
        if (com.bytedance.msdk.core.g.g().m()) {
            if (gVar == null) {
                return;
            }
            if (gVar.f()) {
                return;
            }
            com.bytedance.msdk.z.gc.dl.a("TTMediationSDK", "广告位：" + gVar.zw() + "  type:" + gVar.iq() + " show后把二价广告放入公共缓存池 数量：" + (list == null ? "没有二价" : Integer.valueOf(list.size())));
            if (gVar != null && list != null && !list.isEmpty()) {
                CopyOnWriteArrayList<e> copyOnWriteArrayList = this.z.get(Integer.valueOf(gVar.iq()));
                if (copyOnWriteArrayList == null) {
                    copyOnWriteArrayList = new CopyOnWriteArrayList<>();
                }
                for (dl dlVar : list) {
                    com.bytedance.msdk.z.gc.dl.a("TTMediationSDK", "广告位：" + gVar.zw() + "  代码位：" + dlVar.yz() + "   adnName:" + dlVar.lw() + "  loadSort:" + dlVar.xo() + "  showSort:" + dlVar.dt() + "  ecpm:" + dlVar.u());
                    if (!z(copyOnWriteArrayList, dlVar)) {
                        copyOnWriteArrayList.add(new e(dlVar, 0L, gVar));
                    }
                }
                for (e eVar : copyOnWriteArrayList) {
                    if (!eVar.gc()) {
                        copyOnWriteArrayList.remove(eVar);
                    }
                }
                x.z(copyOnWriteArrayList, this.dl);
                while (3 < copyOnWriteArrayList.size()) {
                    copyOnWriteArrayList.remove(3);
                }
                com.bytedance.msdk.z.gc.dl.a("TTMediationSDK", "广告位：" + gVar.zw() + "  type:" + gVar.iq() + "  公共缓存池二价广告的数量：" + copyOnWriteArrayList.size());
                this.z.put(Integer.valueOf(gVar.iq()), copyOnWriteArrayList);
            }
        }
    }

    public synchronized List<e> z(g gVar) {
        if (gVar == null) {
            return null;
        }
        CopyOnWriteArrayList<e> copyOnWriteArrayList = this.z.get(Integer.valueOf(gVar.iq()));
        if (copyOnWriteArrayList != null && !copyOnWriteArrayList.isEmpty()) {
            int iHh = gVar.iq() == 5 ? gVar.hh() : 1;
            ArrayList arrayList = new ArrayList();
            for (e eVar : copyOnWriteArrayList) {
                if (arrayList.size() >= iHh) {
                    break;
                }
                if (eVar.e() && eVar.z != null) {
                    com.bytedance.msdk.z.gc.dl.g("TTMediationSDK", "--==-- 公共缓存池，广告：" + eVar.g() + "  adnName:" + eVar.z.lw() + " showSort:" + eVar.z.dt() + " 暂不可用， 已经被使用中...");
                }
                if (z(gVar, eVar.a()) && eVar.gc() && !eVar.e()) {
                    arrayList.add(eVar);
                    copyOnWriteArrayList.remove(eVar);
                }
            }
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                ((e) it.next()).g(true);
            }
            return arrayList;
        }
        return null;
    }

    public static List<dl> z(g gVar, List<dl> list, List<dl> list2) {
        if (!com.bytedance.msdk.core.g.g().m() || gVar == null || list == null || list.isEmpty() || list2 == null || list2.isEmpty()) {
            return null;
        }
        int iHh = gVar.iq() == 5 ? gVar.hh() : 1;
        ArrayList arrayList = new ArrayList();
        for (dl dlVar : list2) {
            if (!g(list, dlVar)) {
                if (arrayList.size() >= iHh) {
                    break;
                }
                if (!dlVar.jc() && !dlVar.hn() && (!dlVar.cb() || dlVar.u() > 0.0d)) {
                    arrayList.add(dlVar);
                }
            }
        }
        return arrayList;
    }

    private boolean z(List<e> list, dl dlVar) {
        for (e eVar : list) {
            if (eVar != null && dlVar != null && eVar.z == dlVar) {
                return true;
            }
        }
        return false;
    }

    private static boolean g(List<dl> list, dl dlVar) {
        for (dl dlVar2 : list) {
            if (dlVar != null && dlVar2 == dlVar) {
                return true;
            }
        }
        return false;
    }

    private boolean z(g gVar, g gVar2) {
        if (gVar == null || gVar2 == null || gVar.iq() != gVar2.iq()) {
            return false;
        }
        if ((gVar.iq() == 7 || gVar.iq() == 10) && gVar.mc() == gVar2.mc()) {
            return true;
        }
        return (gVar.iq() == 1 || gVar.iq() == 5) && gVar.uf() == gVar2.uf() && gVar.sy() == gVar2.sy();
    }

    public static void z(g gVar, String str) {
        if (TextUtils.isEmpty(str) || gVar == null) {
            return;
        }
        if (TextUtils.isEmpty(gVar.wp())) {
            gVar.dl(gVar.zw());
        }
        if (str.equals(gVar.zw())) {
            return;
        }
        g.z zVar = new g.z(new com.bytedance.sdk.openadsdk.ls.dl.dl.g(gVar.wj()));
        zVar.a(str);
        gVar.z(com.bytedance.sdk.openadsdk.mediation.g.g.z.z(zVar.z()));
    }
}
