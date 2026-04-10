package com.bytedance.msdk.core.gc.g;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import com.bytedance.msdk.api.a.i;
import com.bytedance.msdk.core.uy.uy;
import com.bytedance.msdk.gz.l;
import com.bytedance.sdk.component.utils.wp;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class a extends com.bytedance.msdk.core.gc.z {
    private static volatile a z;
    private int i;
    private List<String> kb;
    private int wp;
    private final Map<String, Integer> g = new HashMap();
    private final Map<String, Long> dl = new HashMap();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Map<String, com.bytedance.msdk.api.z.g> f388a = new HashMap();
    private final Map<String, ConcurrentHashMap<String, List<e>>> gc = new HashMap();
    private final Map<String, Map<String, com.bytedance.msdk.api.z>> m = new HashMap();
    private final Map<String, Boolean> e = new HashMap();
    private final Map<String, com.bytedance.msdk.core.gc.g.g> gz = new HashMap();
    private boolean fo = false;
    private int uy = 20;

    public interface dl {
        void z(String str, boolean z, int i, List<com.bytedance.msdk.g.dl> list);
    }

    public interface g {
        void z(boolean z);
    }

    private a() {
    }

    public static a z() {
        if (z == null) {
            synchronized (a.class) {
                if (z == null) {
                    z = new a();
                }
            }
        }
        return z;
    }

    public void z(String str, int i) {
        this.g.put(str, Integer.valueOf(i));
    }

    public int g(String str, int i) {
        Integer num;
        if (i == 2 || (num = this.g.get(str)) == null) {
            return 0;
        }
        return num.intValue();
    }

    public boolean dl(String str, int i) {
        int iG = g(str, i);
        return iG == 2 || iG == 3 || iG == 4;
    }

    public void z(String str, long j) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.dl.put(str, Long.valueOf(j));
    }

    public Long z(String str) {
        return this.dl.get(str);
    }

    public void z(String str, com.bytedance.msdk.api.z.g gVar) {
        if (gVar == null || TextUtils.isEmpty(str)) {
            return;
        }
        this.f388a.put(str, gVar);
    }

    public com.bytedance.msdk.api.z.g g(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return this.f388a.get(str);
    }

    public com.bytedance.msdk.core.gc.g.g dl(String str) {
        return this.gz.get(str);
    }

    public void z(String str, e eVar) {
        if (z(str) == null || z(str).longValue() == eVar.z()) {
            ConcurrentHashMap<String, List<e>> concurrentHashMap = this.gc.get(str);
            String strYz = eVar.z.yz();
            if (TextUtils.isEmpty(strYz)) {
                return;
            }
            if (concurrentHashMap == null) {
                CopyOnWriteArrayList copyOnWriteArrayList = new CopyOnWriteArrayList();
                copyOnWriteArrayList.add(eVar);
                ConcurrentHashMap<String, List<e>> concurrentHashMap2 = new ConcurrentHashMap<>();
                concurrentHashMap2.put(strYz, copyOnWriteArrayList);
                this.gc.put(str, concurrentHashMap2);
                return;
            }
            List<e> list = concurrentHashMap.get(strYz);
            if (list == null) {
                CopyOnWriteArrayList copyOnWriteArrayList2 = new CopyOnWriteArrayList();
                copyOnWriteArrayList2.add(eVar);
                concurrentHashMap.put(strYz, copyOnWriteArrayList2);
                return;
            }
            list.add(eVar);
        }
    }

    public double g(String str, com.bytedance.msdk.api.z.g gVar) {
        String key;
        List<e> list;
        ConcurrentHashMap<String, List<e>> concurrentHashMap = this.gc.get(str);
        double dU = -1.0d;
        if (concurrentHashMap != null && concurrentHashMap.size() > 0) {
            for (Map.Entry<String, List<e>> entry : concurrentHashMap.entrySet()) {
                if (entry != null && (key = entry.getKey()) != null && (list = concurrentHashMap.get(key)) != null && list.size() > 0) {
                    for (e eVar : list) {
                        if (eVar != null && z(eVar, eVar.a(), gVar, "聚合预缓存-ra") == -1 && eVar.z.u() > dU) {
                            dU = eVar.z.u();
                        }
                    }
                }
            }
        }
        return dU;
    }

    public boolean z(String str, com.bytedance.msdk.api.z.g gVar, String str2) {
        boolean z2;
        this.e.put(str, Boolean.FALSE);
        com.bytedance.msdk.core.gc.g.g gVar2 = this.gz.get(str);
        if (gVar2 == null) {
            return false;
        }
        List<uy> listG = gVar2.g();
        if (com.bytedance.msdk.z.gc.dl.g()) {
            for (uy uyVar : listG) {
                com.bytedance.msdk.z.gc.dl.z("TTMediationSDK", com.bytedance.msdk.z.gc.gc.z(str) + "waterfall: " + uyVar.pf() + ", loadSort: " + uyVar.io() + ", showSort: " + uyVar.uf() + ", eCpm: " + uyVar.zw());
            }
        }
        boolean[] zArr = {true};
        String strZ = z(listG, str, gVar, gVar2, zArr);
        dl(str, gVar);
        ConcurrentHashMap<String, List<e>> concurrentHashMap = this.gc.get(str);
        if (concurrentHashMap != null) {
            for (int i = 0; i < listG.size(); i++) {
                List<e> list = concurrentHashMap.get(listG.get(i).fv());
                if (list != null && list.size() > 0) {
                    z2 = true;
                    break;
                }
            }
            z2 = false;
        } else {
            z2 = false;
        }
        if (strZ != null) {
            if (z2) {
                com.bytedance.msdk.gc.m.z(this.f388a.get(str), strZ);
            } else {
                gVar.g(3);
                if (zArr[0]) {
                    gVar.g(1);
                }
                com.bytedance.msdk.gc.m.z(gVar, strZ);
            }
        }
        return z2;
    }

    private String z(List<uy> list, String str, com.bytedance.msdk.api.z.g gVar, com.bytedance.msdk.core.gc.g.g gVar2, boolean[] zArr) {
        List<e> list2;
        if (list.size() <= 0) {
            return null;
        }
        ConcurrentHashMap<String, List<e>> concurrentHashMap = this.gc.get(str);
        if (concurrentHashMap != null && (list2 = concurrentHashMap.get(list.get(0).fv())) != null && list2.size() > 0 && list2.get(0) != null) {
            e eVar = list2.get(0);
            if (z(eVar, eVar.a(), gVar, "聚合预请求") == -1) {
                com.bytedance.msdk.z.gc.dl.z("TTMediationSDK", com.bytedance.msdk.z.gc.gc.z(str) + "--==-- 命中最优广告： " + eVar.z.zx() + ", loadSort: " + eVar.z.xo() + ", showSort: " + eVar.z.dt());
                return null;
            }
        }
        List<com.bytedance.msdk.core.gc.g.z> listZ = z(list, str, concurrentHashMap, gVar, gVar2, zArr);
        if (listZ.size() > 0) {
            StringBuilder sb = new StringBuilder("[");
            for (int i = 0; i < listZ.size(); i++) {
                sb.append(listZ.get(i).z());
                if (i == listZ.size() - 1) {
                    sb.append("]");
                } else {
                    sb.append(",");
                }
            }
            try {
                String string = new JSONArray(sb.toString()).toString();
                com.bytedance.msdk.z.gc.dl.z("TTMediationSDK", com.bytedance.msdk.z.gc.gc.z(str) + "adCannotUseInfo: " + string);
                return string;
            } catch (JSONException e) {
                com.bytedance.msdk.z.gc.dl.z("TTMediationSDK", com.bytedance.msdk.z.gc.gc.z(str) + "adCannotUseInfo json err: " + e.getMessage());
            }
        }
        return null;
    }

    private void dl(String str, com.bytedance.msdk.api.z.g gVar) {
        ConcurrentHashMap<String, List<e>> concurrentHashMap = this.gc.get(str);
        if (concurrentHashMap != null) {
            for (String str2 : concurrentHashMap.keySet()) {
                List<e> list = concurrentHashMap.get(str2);
                if (list != null && list.size() > 0 && list.get(0) != null) {
                    e eVar = list.get(0);
                    if (z(eVar, eVar.a(), gVar, "聚合预缓存") != -1) {
                        concurrentHashMap.remove(str2);
                    }
                }
            }
        }
    }

    private List<com.bytedance.msdk.core.gc.g.z> z(List<uy> list, String str, Map<String, List<e>> map, com.bytedance.msdk.api.z.g gVar, com.bytedance.msdk.core.gc.g.g gVar2, boolean[] zArr) {
        List<e> list2;
        ArrayList arrayList = new ArrayList();
        int iE_ = gVar2.e_();
        for (int i = 0; i < list.size() && i < iE_; i++) {
            String strFv = list.get(i).fv();
            com.bytedance.msdk.core.gc.g.z zVar = new com.bytedance.msdk.core.gc.g.z();
            zVar.g(strFv);
            zVar.gc(list.get(i).uf());
            zVar.a(list.get(i).io());
            e eVar = (map == null || (list2 = map.get(strFv)) == null || list2.size() <= 0) ? null : list2.get(0);
            if (eVar == null || eVar.z == null) {
                Map<String, com.bytedance.msdk.api.z> map2 = this.m.get(str);
                com.bytedance.msdk.api.z zVar2 = map2 != null ? map2.get(strFv) : null;
                if (zVar2 != null) {
                    zVar.g(3);
                    zVar.dl(zVar2.dl);
                    zVar.z(zVar2.f366a);
                } else {
                    zVar.g(4);
                }
                arrayList.add(zVar);
            } else {
                zVar.z(eVar.z.jq() ? 1 : 0);
                zArr[0] = false;
                int iZ = z(eVar, this.f388a.get(str), gVar, "预缓存");
                if (iZ != -1) {
                    zVar.g(iZ);
                    arrayList.add(zVar);
                }
            }
        }
        return arrayList;
    }

    public List<e> a(String str) {
        ArrayList arrayList = new ArrayList();
        ConcurrentHashMap<String, List<e>> concurrentHashMap = this.gc.get(str);
        if (concurrentHashMap != null) {
            Iterator<String> it = concurrentHashMap.keySet().iterator();
            while (it.hasNext()) {
                List<e> list = concurrentHashMap.get(it.next());
                if (list != null && list.size() > 0) {
                    arrayList.addAll(list);
                }
            }
        }
        if (concurrentHashMap != null) {
            concurrentHashMap.clear();
        }
        Map<String, com.bytedance.msdk.api.z> map = this.m.get(str);
        if (map != null) {
            map.clear();
        }
        return arrayList;
    }

    public void z(final Context context, final String str, final int i) {
        com.bytedance.msdk.z.gc.m.z(new Runnable() { // from class: com.bytedance.msdk.core.gc.g.a.1
            @Override // java.lang.Runnable
            public void run() {
                a.this.z(context, str, 2, i, (dl) null);
            }
        });
    }

    public void g(final Context context, final String str, final int i) {
        com.bytedance.msdk.z.gc.m.z(new Runnable() { // from class: com.bytedance.msdk.core.gc.g.a.2
            @Override // java.lang.Runnable
            public void run() {
                a.this.z(context, str, 4, i, (dl) null);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void z(Context context, String str, int i, int i2, dl dlVar) {
        int iG = g(str, i2);
        if (!dl(str, i2)) {
            com.bytedance.msdk.z.gc.dl.z("TTMediationSDK", com.bytedance.msdk.z.gc.gc.z(str) + "--==-- 配置未开启预加载缓存，req_type: " + iG);
            if (dlVar != null) {
                dlVar.z(str, false, 0, null);
                return;
            }
            return;
        }
        Boolean bool = this.e.get(str);
        if (bool != null && bool.booleanValue()) {
            com.bytedance.msdk.z.gc.dl.z("TTMediationSDK", com.bytedance.msdk.z.gc.gc.z(str) + "--==-- 已发起过预缓存，还未使用掉，此次不发起");
            if (dlVar != null) {
                dlVar.z(str, true, 0, null);
                return;
            }
            return;
        }
        com.bytedance.msdk.api.z.g gVar = this.f388a.get(str);
        if (gVar == null) {
            com.bytedance.msdk.z.gc.dl.z("TTMediationSDK", com.bytedance.msdk.z.gc.gc.z(str) + "--==-- 预缓存取消，adslot为null，rit：" + str);
            return;
        }
        com.bytedance.msdk.api.z.g gVar2 = new com.bytedance.msdk.api.z.g(gVar);
        com.bytedance.msdk.z.gc.dl.z("TTMediationSDK", com.bytedance.msdk.z.gc.gc.z(str) + "--==-- 预缓存开始请求, req_type: " + iG);
        com.bytedance.msdk.core.gc.g.g gVarZ = gc.z(context, str, gVar2.iq());
        this.gz.put(str, gVarZ);
        this.e.put(str, Boolean.TRUE);
        gVar2.a(str);
        gVar2.g(i);
        gVar2.m(3);
        gVarZ.z(context, gVar2, dlVar);
        m(str);
    }

    private static void m(String str) {
        JSONObject jSONObject;
        l lVarZ = l.z((String) null, com.bytedance.msdk.core.g.getContext());
        String strG = lVarZ.g("preload_rit_ts");
        try {
            if (TextUtils.isEmpty(strG)) {
                jSONObject = new JSONObject();
            } else {
                jSONObject = new JSONObject(strG);
            }
            jSONObject.put(str, System.currentTimeMillis());
            lVarZ.z("preload_rit_ts", jSONObject.toString());
        } catch (Throwable th) {
            wp.z(th);
        }
    }

    public static long gc(String str) {
        String strG = l.z((String) null, com.bytedance.msdk.core.g.getContext()).g("preload_rit_ts");
        try {
            if (!TextUtils.isEmpty(strG)) {
                return new JSONObject(strG).optLong(str, -1L);
            }
        } catch (Throwable th) {
            wp.z(th);
        }
        return -1L;
    }

    public List<String> g() {
        return this.kb;
    }

    public int dl() {
        return this.wp;
    }

    public int a() {
        return this.i;
    }

    public void z(int i) {
        this.uy = i;
    }

    public void z(final Activity activity, final List<i> list, final int i, final int i2) {
        com.bytedance.msdk.z.gc.m.z(new Runnable() { // from class: com.bytedance.msdk.core.gc.g.a.3
            @Override // java.lang.Runnable
            public void run() {
                if (a.this.fo) {
                    com.bytedance.msdk.z.gc.dl.z("TTMediationSDK", "注意：预加载preload只能调用一次");
                    return;
                }
                if (activity == null) {
                    com.bytedance.msdk.z.gc.dl.z("TTMediationSDK", "预加载preload传入的activity不能是null");
                    return;
                }
                List list2 = list;
                if (list2 != null && list2.size() > 0) {
                    a.this.fo = true;
                    a.this.wp = i;
                    a.this.i = i2;
                    a.this.kb = new ArrayList();
                    for (i iVar : list) {
                        if (iVar != null && iVar.g() != null) {
                            a.this.kb.addAll(iVar.g());
                        }
                    }
                    int i3 = i;
                    int i4 = (i3 <= 0 || i3 > 20) ? 2 : i3;
                    int i5 = i2;
                    int i6 = (i5 <= 0 || i5 > 10) ? 2 : i5;
                    List listZ = a.this.z((List<i>) list);
                    if (listZ.isEmpty()) {
                        return;
                    }
                    a.this.new z(activity, listZ, i4, i6, new g() { // from class: com.bytedance.msdk.core.gc.g.a.3.1
                        @Override // com.bytedance.msdk.core.gc.g.a.g
                        public void z(boolean z2) {
                            if (z2) {
                                return;
                            }
                            com.bytedance.msdk.core.fo.gc.a().z(a.this.gc);
                        }
                    }).z();
                    return;
                }
                com.bytedance.msdk.z.gc.dl.z("TTMediationSDK", "预加载preload传入的requestInfos不能是null或者size为0");
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public List<i> z(List<i> list) {
        ArrayList arrayList = new ArrayList();
        int i = this.uy;
        HashSet hashSet = new HashSet();
        for (i iVar : list) {
            if (arrayList.size() >= i) {
                break;
            }
            if (iVar != null && iVar.g() != null) {
                for (String str : iVar.g()) {
                    if (arrayList.size() < i) {
                        if (!TextUtils.isEmpty(str) && !hashSet.contains(str)) {
                            hashSet.add(str);
                            ArrayList arrayList2 = new ArrayList(1);
                            arrayList2.add(str);
                            arrayList.add(new i(iVar.z(), arrayList2));
                        }
                    }
                }
            }
        }
        return arrayList;
    }

    private class z {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final int f392a;
        private final int dl;
        private int e;
        private final Activity g;
        private final List<i> gc;
        private int gz;
        private final g m;

        static /* synthetic */ int dl(z zVar) {
            int i = zVar.gz;
            zVar.gz = i - 1;
            return i;
        }

        static /* synthetic */ int g(z zVar) {
            int i = zVar.e;
            zVar.e = i - 1;
            return i;
        }

        z(Activity activity, List<i> list, int i, int i2, g gVar) {
            this.g = activity;
            this.gc = list;
            this.dl = i;
            this.f392a = i2;
            this.m = gVar;
            this.e = list.size();
            this.gz = list.size();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void z() {
            i iVarRemove;
            for (int i = 0; i < this.dl; i++) {
                if (this.gc.size() > 0 && (iVarRemove = this.gc.remove(0)) != null) {
                    com.bytedance.msdk.api.z.g gVarZ = iVarRemove.z();
                    String str = iVarRemove.g().get(0);
                    if (gVarZ != null) {
                        if (gVarZ.iq() == 1) {
                            com.bytedance.msdk.z.gc.dl.z("TTMediationSDK", "预加载preload传入的GMAdSlotBase为banner类型，不支持该类型预加载，广告位: ".concat(String.valueOf(str)));
                        } else if (gVarZ.iq() == 2) {
                            com.bytedance.msdk.z.gc.dl.z("TTMediationSDK", "预加载preload传入的GMAdSlotBase为插屏类型，不支持该类型预加载，广告位: ".concat(String.valueOf(str)));
                        } else if (gVarZ.iq() == 9) {
                            com.bytedance.msdk.z.gc.dl.z("TTMediationSDK", "预加载preload传入的GMAdSlotBase为Draw类型，不支持该类型预加载，广告位: ".concat(String.valueOf(str)));
                        } else {
                            a.this.z(str, gVarZ);
                            gVarZ.a(str);
                            com.bytedance.msdk.core.uy.g gVarZ2 = com.bytedance.msdk.e.z.dl.z().z(str, 0, 101);
                            if (gVarZ2 != null) {
                                gVarZ.fo(gVarZ2.ti());
                            } else if (gVarZ.iq() == 8) {
                                gVarZ.fo(10);
                            }
                            a.this.z(this.g, str, 5, 0, new dl() { // from class: com.bytedance.msdk.core.gc.g.a.z.1
                                @Override // com.bytedance.msdk.core.gc.g.a.dl
                                public void z(String str2, boolean z, int i2, List<com.bytedance.msdk.g.dl> list) {
                                    z.g(z.this);
                                    if (!z) {
                                        z.dl(z.this);
                                    }
                                    com.bytedance.msdk.z.gc.dl.z("TTMediationSDK", "--==-- pendingLoadNum: " + z.this.e);
                                    if (z.this.e > 0 || z.this.m == null) {
                                        return;
                                    }
                                    z.this.m.z(z.this.gz <= 0);
                                }
                            });
                        }
                    } else {
                        com.bytedance.msdk.z.gc.dl.z("TTMediationSDK", "预加载preload传入的GMAdSlotBase为空，广告位：".concat(String.valueOf(str)));
                    }
                }
            }
            if (this.gc.size() > 0) {
                com.bytedance.msdk.z.gc.m.z(new Runnable() { // from class: com.bytedance.msdk.core.gc.g.a.z.2
                    @Override // java.lang.Runnable
                    public void run() {
                        z.this.z();
                    }
                }, ((long) this.f392a) * 1000);
            }
        }
    }

    public void z(Context context, String str, int i, com.bytedance.msdk.api.z.g gVar, com.bytedance.msdk.g.dl dlVar, dl dlVar2) {
        com.bytedance.msdk.core.gc.g.dl dlVarZ = m.z(i, context, str, gVar == null ? 0 : gVar.iq());
        if (dlVarZ != null) {
            com.bytedance.msdk.z.gc.dl.z("TTMediationSDK", "--==-- 预缓存补充请求发起 reqType: " + i);
            dlVarZ.z(gVar, dlVar, dlVar2);
        }
    }
}
