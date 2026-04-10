package com.bytedance.msdk.core.gc.z;

import android.content.Context;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Pair;
import com.bytedance.msdk.api.a.kb;
import com.bytedance.msdk.api.z.g;
import com.bytedance.msdk.core.gc.g.e;
import com.bytedance.msdk.core.uy.fo;
import com.bytedance.msdk.core.uy.uy;
import com.bytedance.msdk.gz.l;
import com.bytedance.msdk.gz.x;
import com.bytedance.msdk.z.gc.dl;
import com.bytedance.msdk.z.gc.m;
import com.bytedance.sdk.component.utils.wp;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import okhttp3.HttpUrl;
import org.json.JSONArray;
import org.json.JSONException;

/* JADX INFO: loaded from: classes2.dex */
public class z extends com.bytedance.msdk.core.gc.z {
    private static volatile z gz;
    private final String[] z = {MediationConstant.ADN_UNITY, MediationConstant.ADN_KS};
    private final Map<String, Integer> g = new HashMap();
    private final Map<String, Integer> dl = new HashMap();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Map<String, CopyOnWriteArrayList<e>> f395a = new ConcurrentHashMap();
    private final Map<String, uy> gc = new HashMap();
    private final Map<String, String> m = new HashMap();
    private final Map<String, Integer> e = new HashMap();
    private final Comparator<e> fo = new Comparator<e>() { // from class: com.bytedance.msdk.core.gc.z.z.4
        @Override // java.util.Comparator
        /* JADX INFO: renamed from: z, reason: merged with bridge method [inline-methods] */
        public int compare(e eVar, e eVar2) {
            if (eVar == null || eVar2 == null || eVar.z == null || eVar2.z == null) {
                return 0;
            }
            return ((int) eVar.z.f()) - ((int) eVar2.z.f());
        }
    };

    private z() {
    }

    public static z z() {
        if (gz == null) {
            synchronized (z.class) {
                if (gz == null) {
                    gz = new z();
                }
            }
        }
        return gz;
    }

    public void dl(String str, String str2, int i) {
        this.g.put(str + "_" + str2, Integer.valueOf(i));
    }

    public boolean a(String str, String str2, int i) {
        Integer num;
        return (i == 2 || (num = this.g.get(new StringBuilder().append(str).append("_").append(str2).toString())) == null || (num.intValue() != 1 && num.intValue() != 2)) ? false : true;
    }

    public int gc(String str, String str2, int i) {
        Integer num;
        if (i == 2 || (num = this.g.get(str + "_" + str2)) == null) {
            return 0;
        }
        return num.intValue();
    }

    public void m(String str, String str2, int i) {
        this.dl.put(str + "_" + str2, Integer.valueOf(i));
    }

    public boolean dl(String str, String str2) {
        Integer num = this.dl.get(str + "_" + str2);
        return num != null && num.intValue() == 1;
    }

    public void z(String str, String str2, uy uyVar, int i) {
        if (uyVar != null) {
            this.gc.put(str + "_" + str2, uyVar);
        }
        this.e.put(str2, Integer.valueOf(i));
    }

    public void a(String str, String str2) {
        this.m.put(str, str2);
    }

    public uy gc(String str, String str2) {
        return this.gc.get(str + "_" + str2);
    }

    public String z(String str) {
        return this.m.get(str);
    }

    public void g() {
        m.z(new Runnable() { // from class: com.bytedance.msdk.core.gc.z.z.1
            @Override // java.lang.Runnable
            public void run() {
                int i;
                int iHh;
                String strZw;
                dl.z("TTMediationSDK", "--==-- 广告复用lowMemory，start clean");
                int i2 = 0;
                int i3 = 0;
                for (Map.Entry entry : z.this.f395a.entrySet()) {
                    List<e> list = (List) entry.getValue();
                    if (list != null && list.size() > 0) {
                        dl.z("TTMediationSDK", "--==-- 广告复用lowMemory，adnSlotId: " + ((String) entry.getKey()) + ", 清理前, 缓存总数: " + list.size());
                        int i4 = 1;
                        int i5 = 0;
                        for (e eVar : list) {
                            if (eVar != null && eVar.z != null) {
                                if (eVar.a() != null) {
                                    strZw = eVar.a().zw();
                                    iHh = eVar.a().hh();
                                } else {
                                    iHh = i4;
                                    strZw = "";
                                }
                                if (eVar.z.jq() || !eVar.z.un(strZw)) {
                                    list.remove(eVar);
                                    i5++;
                                }
                                i4 = iHh;
                            }
                        }
                        if (list.size() > i4) {
                            dl.z("TTMediationSDK", "--==-- 广告复用lowMemory，adnSlotId: " + ((String) entry.getKey()) + ", 清理无效广告后仍需清理，缓存总数: " + list.size() + "，adCount: " + i4 + ", invalidCnt: " + i5);
                            i = 0;
                            for (e eVar2 : list) {
                                if (list.size() <= i4) {
                                    break;
                                }
                                list.remove(eVar2);
                                i++;
                            }
                        } else {
                            i = 0;
                        }
                        dl.z("TTMediationSDK", "--==-- 广告复用lowMemory，adnSlotId: " + ((String) entry.getKey()) + ", 清理后，缓存总数: " + list.size() + ", adCount: " + i4 + ", invalidCnt: " + i5 + ", foceCleanCnt：" + i);
                        i2 += i5;
                        i3 += i;
                    }
                    l.z(i2, i3);
                }
            }
        });
    }

    public void z(final String str, final g gVar, final Map<String, Object> map, final boolean z, final kb kbVar, final fo foVar, final Context context) {
        m.z(new Runnable() { // from class: com.bytedance.msdk.core.gc.z.z.2
            @Override // java.lang.Runnable
            public void run() {
                String strZx;
                String strZ;
                e eVar;
                List<e> list = (List) z.this.f395a.get(str);
                ArrayList arrayList = new ArrayList();
                if (list != null && list.size() > 0) {
                    for (e eVar2 : list) {
                        if (eVar2 != null && eVar2.z.jq()) {
                            list.remove(eVar2);
                            arrayList.add(eVar2);
                        }
                    }
                }
                boolean z2 = false;
                if (dl.g()) {
                    if (arrayList.size() <= 0 || (eVar = (e) arrayList.get(0)) == null) {
                        strZx = "";
                        strZ = strZx;
                    } else {
                        strZ = com.bytedance.msdk.g.z.z(eVar.z.hy(), eVar.z.j());
                        strZx = eVar.z.zx();
                    }
                    dl.z("TTMediationSDK", "--==-- 广告复用:show时缓存移除 -----：" + strZx + ", " + strZ + ", " + str + (arrayList.size() > 0 ? ", size: " + arrayList.size() : "移除广告数为0"));
                }
                g gVar2 = gVar;
                String strZw = gVar2 != null ? gVar2.zw() : "";
                g gVar3 = gVar;
                int iIq = gVar3 != null ? gVar3.iq() : 0;
                g gVar4 = gVar;
                boolean z3 = gVar4 == null || gVar4.iq() == 1;
                if (!com.bytedance.msdk.core.g.g().z(strZw, str, iIq) && z) {
                    z2 = true;
                }
                if (!gVar.f() && z2 && !z3 && z.this.dl(strZw, str)) {
                    z.this.z(str, gVar, (Map<String, Object>) map, context, kbVar, foVar);
                } else {
                    dl.z("TTMediationSDK", "--==-- 广告复用:show时预请求取消，因为：已发起waterfall预加载，或feed多广告，或未开启adn预加载，或是banner轮播 --: " + str);
                }
            }
        });
    }

    public void z(final List<com.bytedance.msdk.g.dl> list, final String str, final g gVar, final int i, final com.bytedance.msdk.g.dl dlVar) {
        if (list == null || list.isEmpty() || gVar == null || TextUtils.isEmpty(str)) {
            return;
        }
        m.z(new Runnable() { // from class: com.bytedance.msdk.core.gc.z.z.3
            @Override // java.lang.Runnable
            public void run() {
                for (Map.Entry entry : z.this.g(list, str, gVar, i, dlVar).entrySet()) {
                    String str2 = (String) entry.getKey();
                    List<e> list2 = (List) entry.getValue();
                    if (!TextUtils.isEmpty(str2) && list2 != null && list2.size() > 0) {
                        z.this.z(str2, list2, true);
                        dl.z("TTMediationSDK", "--==-- 广告复用，show后放回复用池：adnSlotId:" + str2 + ", 个数：" + list2.size());
                    }
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Map<String, List<e>> g(List<com.bytedance.msdk.g.dl> list, String str, g gVar, int i, com.bytedance.msdk.g.dl dlVar) {
        HashMap map = new HashMap();
        for (com.bytedance.msdk.g.dl dlVar2 : list) {
            if (dlVar2 != null && dlVar2 != dlVar) {
                dlVar2.z(false);
            }
            if (dlVar2 != null && dlVar2 != dlVar && gc(str, dlVar2.yz(), i) == 2 && dlVar2.un(str) && !dlVar2.jq()) {
                List list2 = (List) map.get(dlVar2.yz());
                if (list2 == null) {
                    ArrayList arrayList = new ArrayList();
                    arrayList.add(new e(dlVar2, 0L, gVar));
                    map.put(dlVar2.yz(), arrayList);
                } else {
                    list2.add(new e(dlVar2, 0L, gVar));
                }
            }
        }
        return map;
    }

    public void z(String str, List<e> list, boolean z) {
        if (list == null || list.size() <= 0) {
            return;
        }
        CopyOnWriteArrayList<e> copyOnWriteArrayList = this.f395a.get(str);
        if (copyOnWriteArrayList != null) {
            for (e eVar : list) {
                if (!z(copyOnWriteArrayList, eVar)) {
                    copyOnWriteArrayList.add(eVar);
                }
            }
        } else {
            this.f395a.put(str, new CopyOnWriteArrayList<>(list));
        }
        if (z) {
            x.z(this.f395a.get(str), this.fo);
        }
    }

    private boolean z(List<e> list, e eVar) {
        for (e eVar2 : list) {
            if (eVar2 != null && eVar != null && eVar2.z == eVar.z) {
                return true;
            }
        }
        return false;
    }

    public synchronized List<e> z(String str, g gVar, int i) {
        CopyOnWriteArrayList<e> copyOnWriteArrayList = this.f395a.get(str);
        if (copyOnWriteArrayList == null) {
            return null;
        }
        int iHh = gVar != null ? gVar.hh() : 1;
        ArrayList arrayList = new ArrayList();
        int iGc = gc(gVar != null ? gVar.zw() : "", str, i);
        if (iGc == 1) {
            for (int i2 = 0; arrayList.size() < iHh && i2 < copyOnWriteArrayList.size(); i2++) {
                if (!copyOnWriteArrayList.get(i2).dl() && z(copyOnWriteArrayList.get(i2).a(), gVar, copyOnWriteArrayList.get(i2).z)) {
                    arrayList.add(copyOnWriteArrayList.get(i2));
                }
            }
            for (int i3 = 0; arrayList.size() < iHh && i3 < copyOnWriteArrayList.size(); i3++) {
                if (copyOnWriteArrayList.get(i3).dl() && z(copyOnWriteArrayList.get(i3).a(), gVar, copyOnWriteArrayList.get(i3).z)) {
                    arrayList.add(copyOnWriteArrayList.get(i3));
                }
            }
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                ((e) it.next()).z(true);
            }
            dl.z("TTMediationSDK", "--==-- 复用模式1，不从复用池移除，获取缓存: " + str + ", " + arrayList.size());
        } else if (iGc == 2) {
            for (e eVar : copyOnWriteArrayList) {
                if (arrayList.size() >= iHh) {
                    break;
                }
                if (eVar.e() && eVar.z != null) {
                    dl.g("TTMediationSDK", "--==-- 复用模式2，广告：" + eVar.g() + "  adnName:" + eVar.z.lw() + " showSort:" + eVar.z.dt() + " 暂不可用， 已经被使用中...");
                }
                if (eVar != null && z(eVar.a(), gVar, eVar.z) && !eVar.e()) {
                    copyOnWriteArrayList.remove(eVar);
                    arrayList.add(eVar);
                }
            }
            dl.z("TTMediationSDK", "--==-- 复用模式2，从复用池移除，获取缓存: " + str + ", " + arrayList.size());
        }
        Iterator it2 = arrayList.iterator();
        while (it2.hasNext()) {
            ((e) it2.next()).g(true);
        }
        return arrayList;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private int g(String str, g gVar, boolean z) {
        boolean z2;
        int i;
        CopyOnWriteArrayList<e> copyOnWriteArrayList = this.f395a.get(str);
        if (copyOnWriteArrayList != null && copyOnWriteArrayList.size() > 0) {
            String strZw = gVar != null ? gVar.zw() : "";
            ArrayList arrayList = new ArrayList();
            e eVar = null;
            byte b = false;
            for (e eVar2 : copyOnWriteArrayList) {
                Integer numM = eVar2.z.m();
                int iIntValue = numM != null ? numM.intValue() : 0;
                if (iIntValue == 4) {
                    z2 = z(strZw, eVar2.z);
                } else {
                    z2 = iIntValue != 2;
                }
                if (!z2) {
                    if (z(eVar2.a(), gVar, eVar2.z)) {
                        dl.z("TTMediationSDK", "--==-- 广告复用:复用成功：--------" + eVar2.z.zx() + ", adSlotId: " + str);
                        b = true;
                    } else {
                        dl.z("TTMediationSDK", "--==-- 广告复用:AdSlot不符合 -------: " + eVar2.z.zx() + ", adSlotId: " + str);
                        i = 6;
                    }
                } else {
                    copyOnWriteArrayList.remove(eVar2);
                    dl.z("TTMediationSDK", "--==-- 广告复用:广告过期了 -------: " + eVar2.z.zx() + ", adSlotId: " + str);
                    i = 5;
                }
                if (eVar == null) {
                    eVar = eVar2;
                }
                com.bytedance.msdk.core.gc.g.z zVar = new com.bytedance.msdk.core.gc.g.z();
                zVar.a(eVar2.z.xo());
                zVar.gc(eVar2.z.dt());
                zVar.g(eVar2.z.yz());
                zVar.g(i);
                zVar.z(eVar2.z.jq() ? 1 : 0);
                arrayList.add(zVar);
            }
            if (b == true) {
                return 3;
            }
            if (z && eVar != null) {
                com.bytedance.msdk.gc.m.z(gVar, eVar.z, z(arrayList));
            }
            return 2;
        }
        dl.z("TTMediationSDK", "--==-- 广告复用:当前没有广告缓存 -------adnSlotId: " + str);
        return 1;
    }

    public synchronized int z(String str, g gVar, boolean z) {
        if (g(gVar != null ? gVar.zw() : "", str) == 0) {
            return g(str, gVar, z);
        }
        CopyOnWriteArrayList<e> copyOnWriteArrayList = this.f395a.get(str);
        if (copyOnWriteArrayList != null && copyOnWriteArrayList.size() > 0) {
            e eVar = null;
            ArrayList arrayList = z ? new ArrayList() : null;
            boolean z2 = false;
            for (e eVar2 : copyOnWriteArrayList) {
                int iZ = z(eVar2, eVar2.a(), gVar, "广告复用");
                if (iZ == -1) {
                    z2 = true;
                } else {
                    if (iZ != 6) {
                        copyOnWriteArrayList.remove(eVar2);
                    }
                    if (z) {
                        if (eVar == null) {
                            eVar = eVar2;
                        }
                        com.bytedance.msdk.core.gc.g.z zVar = new com.bytedance.msdk.core.gc.g.z();
                        zVar.a(eVar2.z.xo());
                        zVar.gc(eVar2.z.dt());
                        zVar.g(eVar2.z.yz());
                        zVar.g(iZ);
                        zVar.z(eVar2.z.jq() ? 1 : 0);
                        arrayList.add(zVar);
                    }
                }
            }
            if (z2) {
                return 3;
            }
            if (z && eVar != null) {
                com.bytedance.msdk.gc.m.z(gVar, eVar.z, z(arrayList));
            }
            return 2;
        }
        dl.z("TTMediationSDK", "--==-- 广告复用:当前没有广告缓存 -------adnSlotId: " + str);
        return 1;
    }

    private String z(List<com.bytedance.msdk.core.gc.g.z> list) {
        if (list.size() > 0) {
            StringBuilder sb = new StringBuilder("[");
            for (int i = 0; i < list.size(); i++) {
                sb.append(list.get(i).z());
                if (i == list.size() - 1) {
                    sb.append("]");
                } else {
                    sb.append(",");
                }
            }
            try {
                return new JSONArray(sb.toString()).toString();
            } catch (JSONException e) {
                dl.z("TTMediationSDK", "--==-- 广告复用：adCannotUseInfo json err: " + e.getMessage());
            }
        }
        return list.size() > 0 ? "json error" : HttpUrl.PATH_SEGMENT_ENCODE_SET_URI;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void z(String str, g gVar, Map<String, Object> map, Context context, kb kbVar, fo foVar) {
        String strZ;
        if (gVar == null) {
            dl.z("TTMediationSDK", "--==-- 广告复用:show时预请求取消，adSlot为空 -------: " + str);
            return;
        }
        if (context == null) {
            dl.z("TTMediationSDK", "--==-- 广告复用:show时预请求取消，context为null -------: " + str);
            return;
        }
        uy uyVarGc = gc(gVar.zw(), str);
        if (uyVarGc != null) {
            try {
                strZ = com.bytedance.msdk.core.e.dl.z(uyVarGc.e(), com.bytedance.msdk.core.e.dl.z(uyVarGc.pf()), com.bytedance.msdk.g.z.z(uyVarGc.i(), uyVarGc.m()));
            } catch (Throwable th) {
                wp.z(th);
                strZ = null;
            }
        } else {
            strZ = null;
        }
        if (TextUtils.isEmpty(strZ) || !com.bytedance.msdk.core.e.dl.g(strZ) || uyVarGc == null) {
            dl.z("TTMediationSDK", "--==-- 广告复用:show时预请求取消，className或wfcBean为空, className: " + strZ + ", wfcBean: " + uyVarGc + ", adnSlotId: " + str);
            return;
        }
        for (String str2 : this.z) {
            if (TextUtils.equals(str2, uyVarGc.pf())) {
                dl.z("TTMediationSDK", "--==-- 广告复用:show时预请求取消，" + str2 + "为单例模式 -------: " + str);
                return;
            }
        }
        int iIntValue = this.e.get(str) != null ? this.e.get(str).intValue() : -1;
        dl.z("TTMediationSDK", "--==-- 广告复用:show时预请求开始 -------: " + str);
        com.bytedance.msdk.dl.m.g.g gVarZ = com.bytedance.msdk.dl.m.g.g.z(uyVarGc, (com.bytedance.msdk.dl.g.g.z) null);
        gVarZ.dl(4);
        gVarZ.g(1);
        com.bytedance.msdk.dl.z.z zVarZ = com.bytedance.msdk.dl.gz.dl.z(gVarZ, gVar, new C0073z(gVar, uyVarGc, gVarZ, foVar, iIntValue));
        if (zVarZ != null) {
            if (!com.bytedance.msdk.core.gz.kb.z().dl(gVar.zw(), uyVarGc.fv())) {
                dl.z("TMe", "adn 代码位预请求触发次数拦截............");
                Pair<String, String> pairZ = com.bytedance.msdk.core.gz.kb.z().z(gVar.zw(), uyVarGc.fv());
                if (pairZ != null) {
                    com.bytedance.msdk.api.g.g gVar2 = new com.bytedance.msdk.api.g.g(41041, com.bytedance.msdk.api.z.z(41041), (String) pairZ.second, (String) pairZ.first);
                    com.bytedance.msdk.gc.m.z(uyVarGc, gVar, z().z(uyVarGc.fv()), true, 2, iIntValue, 4, 1, (com.bytedance.msdk.api.z) gVar2, -1L, false, false);
                    com.bytedance.msdk.gc.m.z(gVar2, gVar, uyVarGc, iIntValue, 4, 1, z().z(uyVarGc.fv()), 0L, (String) null, (String) null, (String) null, 0L);
                    return;
                }
                return;
            }
            com.bytedance.msdk.gc.m.z(uyVarGc, gVar, z().z(uyVarGc.fv()), gVarZ.gc(), 3, gVarZ.dl(), 4, 1, (com.bytedance.msdk.api.z) null, gVarZ.a(), false, false);
            zVarZ.z(context, gVarZ, gVar, com.bytedance.msdk.dl.gz.dl.z(gVarZ, gVar, map));
            dl.z("TTMediationSDK", "--==-- 广告复用:show时预请求已发完 -------: " + str);
            return;
        }
        com.bytedance.msdk.gc.m.z(uyVarGc, gVar, 4, 1);
    }

    /* JADX INFO: renamed from: com.bytedance.msdk.core.gc.z.z$z, reason: collision with other inner class name */
    private class C0073z implements com.bytedance.msdk.dl.z.g {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private uy f398a;
        private final g dl;
        private long e = System.currentTimeMillis();
        private com.bytedance.msdk.dl.m.g.g gc;
        private fo m;
        int z;

        @Override // com.bytedance.msdk.dl.z.g
        public void z(com.bytedance.msdk.g.dl dlVar, String str) {
        }

        C0073z(g gVar, uy uyVar, com.bytedance.msdk.dl.m.g.g gVar2, fo foVar, int i) {
            this.dl = gVar;
            this.f398a = uyVar;
            this.gc = gVar2;
            this.z = i;
            this.m = foVar;
        }

        @Override // com.bytedance.msdk.dl.z.g
        public void z(List<com.bytedance.msdk.g.dl> list) {
            if (list == null || list.size() <= 0) {
                return;
            }
            ArrayList arrayList = new ArrayList();
            for (com.bytedance.msdk.g.dl dlVar : list) {
                if (dlVar != null) {
                    uy uyVar = this.f398a;
                    com.bytedance.msdk.dl.gz.dl.z(dlVar, this.dl, this.gc, this.m, uyVar != null ? z.this.z(uyVar.fv()) : "");
                    dlVar.z(SystemClock.elapsedRealtime());
                    arrayList.add(new e(dlVar, 0L, this.dl));
                }
            }
            if (arrayList.size() > 0) {
                com.bytedance.msdk.g.dl dlVar2 = ((e) arrayList.get(0)).z;
                dl.z("TTMediationSDK", "--==-- 广告复用:show时预请求广告load成功 --- " + dlVar2.zx() + ", adType: " + com.bytedance.msdk.g.z.z(dlVar2.hy(), dlVar2.j()) + ", adnSlotId: " + dlVar2.yz() + ", ad个数: " + arrayList.size());
                z.this.z(dlVar2.yz(), (List<e>) arrayList, false);
            }
            com.bytedance.msdk.gc.m.z(list.get(0), 20000, "load success", System.currentTimeMillis() - this.e, this.dl, this.z, list.size(), 0, (String) null, -1L, -1L);
        }

        @Override // com.bytedance.msdk.dl.z.g
        public void z(com.bytedance.msdk.api.z zVar) {
            if (zVar != null && this.f398a != null) {
                dl.z("TTMediationSDK", "--==-- 广告复用:show时预请求广告load失败 --- " + this.f398a.p() + ", " + this.f398a.fv() + ", " + com.bytedance.msdk.g.z.z(this.f398a.i(), this.f398a.m()) + ", errCode: " + zVar.dl + ",msg=" + zVar.f366a);
            }
            com.bytedance.msdk.gc.m.z(zVar, this.dl, this.f398a, this.z, 4, 1, z.z().z(this.f398a.fv()), System.currentTimeMillis() - this.e, (String) null, (String) null, (String) null, 0L);
        }

        @Override // com.bytedance.msdk.dl.z.g
        public void z(List<com.bytedance.msdk.g.dl> list, com.bytedance.msdk.api.z zVar) {
            if (list == null || list.size() <= 0) {
                return;
            }
            for (com.bytedance.msdk.g.dl dlVar : list) {
                uy uyVar = this.f398a;
                com.bytedance.msdk.dl.gz.dl.z(dlVar, this.dl, this.gc, this.m, uyVar != null ? z.this.z(uyVar.fv()) : "");
                dlVar.fo(true);
            }
            com.bytedance.msdk.g.dl dlVar2 = list.get(0);
            if (dlVar2 != null) {
                dl.z("TTMediationSDK", "--==-- 广告复用:show时预请求广告cache成功 --- " + dlVar2.zx() + ", adType: " + com.bytedance.msdk.g.z.z(dlVar2.hy(), dlVar2.j()) + ", adnSlotId: " + dlVar2.yz() + ", ad个数: " + list.size());
            }
            com.bytedance.msdk.gc.m.z(this.dl, dlVar2, this.f398a);
        }
    }
}
