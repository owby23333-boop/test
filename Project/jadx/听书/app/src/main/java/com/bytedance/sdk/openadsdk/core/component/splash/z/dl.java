package com.bytedance.sdk.openadsdk.core.component.splash.z;

import android.text.TextUtils;
import com.bytedance.sdk.openadsdk.core.component.splash.dl.z.e;
import com.bytedance.sdk.openadsdk.core.component.splash.dl.z.fo;
import com.bytedance.sdk.openadsdk.core.component.splash.z.z;
import com.bytedance.sdk.openadsdk.core.gc.a.m;
import com.bytedance.sdk.openadsdk.core.hh;
import com.bytedance.sdk.openadsdk.core.iq.gz;
import com.bytedance.sdk.openadsdk.core.iq.na;
import com.bytedance.sdk.openadsdk.core.iq.yx;
import com.bytedance.sdk.openadsdk.core.un.eo;
import java.lang.ref.PhantomReference;
import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class dl extends z {
    private volatile m kb;
    static ConcurrentHashMap<String, g> e = new ConcurrentHashMap<>();
    static ConcurrentHashMap<String, List<String>> gz = new ConcurrentHashMap<>();
    static ReferenceQueue<Object> fo = new ReferenceQueue<>();
    static Map<Object, g> uy = new ConcurrentHashMap();

    private void a() {
        long jCurrentTimeMillis = System.currentTimeMillis();
        this.kb = new m(3);
        com.bytedance.sdk.openadsdk.core.e.z.z("lqmt", "NewCache 初始化耗时: " + (System.currentTimeMillis() - jCurrentTimeMillis));
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.splash.z.z
    public void g() {
        if (this.kb == null) {
            synchronized (this) {
                if (this.kb == null) {
                    a();
                }
            }
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.splash.z.z
    public void z(final yx yxVar, com.bytedance.sdk.openadsdk.ls.dl.dl.g gVar, boolean z) {
        if (gVar == null || yxVar == null || yxVar.z() == null) {
            return;
        }
        if (this.kb == null) {
            g();
        }
        try {
            final String strA = gVar.a();
            com.bytedance.sdk.openadsdk.core.e.z.z("lqmt", "saveCache start >>  rit: " + strA + "  isUsing: " + z);
            final na naVarZ = yxVar.z();
            String strAq = naVarZ.aq();
            String strG = g(strA, strAq);
            if (e.contains(strG)) {
                return;
            }
            com.bytedance.sdk.openadsdk.core.e.z.z("lqmt", "save-updateMemoryRecord start >>  rit: " + strA + "  reqId: " + strAq);
            z(strG, strA, strAq, z ? 2 : 1);
            z(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.component.splash.z.dl.1
                @Override // java.lang.Runnable
                public void run() {
                    long jCurrentTimeMillis = System.currentTimeMillis();
                    dl.this.kb.z(strA, new m.g(com.bytedance.sdk.component.utils.z.g(yxVar.g().dl().toString()), naVarZ.re(), 1000 * naVarZ.bp(), naVarZ.aq()), false, eo.pf(naVarZ));
                    com.bytedance.sdk.openadsdk.core.e.z.z("lqmt", "saveMeta >>  rit: " + strA + " saveDb cost: " + (System.currentTimeMillis() - jCurrentTimeMillis));
                }
            });
        } catch (Throwable unused) {
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.splash.z.z
    public void z(e eVar, final String str, z.InterfaceC0167z interfaceC0167z, gc gcVar) {
        final m.g gVarZ;
        long jCurrentTimeMillis;
        if (str == null || interfaceC0167z == null) {
            return;
        }
        if (this.kb == null) {
            g();
        }
        this.m = gcVar;
        m.g gVar = null;
        com.bytedance.sdk.openadsdk.core.component.splash.dl.z.m mVar = null;
        try {
            jCurrentTimeMillis = System.currentTimeMillis();
            gc();
            List<String> listZ = z(str);
            com.bytedance.sdk.openadsdk.core.e.z.z("lqmt", "readcache start >>  rit: " + str + "  usedReqIdList: " + (listZ == null ? 0 : listZ.size()));
            gVarZ = this.kb.z(str, this.m == null ? 0L : this.m.z, listZ);
        } catch (Throwable unused) {
        }
        try {
            com.bytedance.sdk.openadsdk.core.e.z.z("lqmt", "readcache-getCacheMeta cost: " + (System.currentTimeMillis() - jCurrentTimeMillis));
        } catch (Throwable unused2) {
            gVar = gVarZ;
            gVarZ = gVar;
        }
        if (gVarZ == null) {
            com.bytedance.sdk.openadsdk.core.e.z.z("lqmt", "readcache-cacheMeta: null ");
            if (eVar != null) {
                eVar.a(0);
                eVar.g(1);
                eVar.z("no cache");
            }
            interfaceC0167z.z();
            return;
        }
        String str2 = gVarZ.gc;
        String strG = g(str, str2);
        com.bytedance.sdk.openadsdk.core.e.z.z("lqmt", "readcache-mapkey: " + strG);
        g gVar2 = e.get(strG);
        if (gVar2 != null && gVar2.g > 1) {
            com.bytedance.sdk.openadsdk.core.e.z.z("lqmt", "readcache-cacheRecord != null && cacheRecord.status > CACHE_STATUS_NOUSE");
            if (eVar != null) {
                eVar.a(0);
                eVar.g(1);
                eVar.z("no cache");
            }
            interfaceC0167z.z();
            return;
        }
        z(strG, str, str2, 2);
        com.bytedance.sdk.openadsdk.core.iq.z zVar = hh.z.z(new JSONObject(com.bytedance.sdk.component.utils.z.dl(gVarZ.dl))).gz;
        com.bytedance.sdk.openadsdk.core.component.splash.dl.z.m mVar2 = new com.bytedance.sdk.openadsdk.core.component.splash.dl.z.m(zVar, true);
        na naVar = (zVar == null || zVar.g() == null || zVar.g().isEmpty()) ? null : zVar.g().get(0);
        if (naVar != null) {
            mVar2.z(naVar);
        }
        com.bytedance.sdk.openadsdk.core.e.z.z("lqmt", "readcache-updateMemoryRecord start >>  rit: " + str + "  reqId: " + str2);
        if (com.bytedance.sdk.openadsdk.core.live.g.z().dl(naVar) != 3) {
            mVar = mVar2;
        } else {
            mVar2.z((na) null);
        }
        interfaceC0167z.z(mVar);
        boolean zUy = com.bytedance.sdk.openadsdk.core.dl.gc.z().uy();
        com.bytedance.sdk.openadsdk.core.e.z.z("lqmt", "isSplashCacheRemoveChange: " + zUy);
        if (zUy) {
            return;
        }
        z(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.component.splash.z.dl.2
            @Override // java.lang.Runnable
            public void run() {
                try {
                    long jCurrentTimeMillis2 = System.currentTimeMillis();
                    dl.this.kb.z(str, gVarZ.gc);
                    com.bytedance.sdk.openadsdk.core.e.z.z("lqmt", "readcache-deleteCacheMeta start >>  rit: " + str + "  reqId: " + gVarZ.gc + "  cost: " + (System.currentTimeMillis() - jCurrentTimeMillis2));
                } catch (Exception unused3) {
                }
            }
        });
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.splash.z.z
    public void z(com.bytedance.sdk.openadsdk.core.component.splash.dl.dl.a<fo, e> aVar, final na naVar, com.bytedance.sdk.openadsdk.ls.dl.dl.g gVar, boolean z) {
        final String strA;
        String strAq;
        String strG;
        if (naVar == null || gVar == null) {
            return;
        }
        if (this.kb == null) {
            g();
        }
        try {
            com.bytedance.sdk.openadsdk.core.e.z.z("lqmt", "removeCache>> start ");
            strA = gVar.a();
            strAq = naVar.aq();
            strG = g(strA, strAq);
        } catch (Throwable unused) {
        }
        if (this.gc.get()) {
            com.bytedance.sdk.openadsdk.core.e.z.z("lqmt", "removeCache-mIsRemoveCacheAd: true");
            return;
        }
        this.gc.set(true);
        z(strG, strA, strAq, 3);
        com.bytedance.sdk.openadsdk.core.e.z.z("lqmt", "removeCache-updateMemoryRecord: 完成");
        z(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.component.splash.z.dl.3
            @Override // java.lang.Runnable
            public void run() {
                try {
                    long jCurrentTimeMillis = System.currentTimeMillis();
                    dl.this.kb.z(strA, naVar.aq());
                    com.bytedance.sdk.openadsdk.core.e.z.z("lqmt", "removeCache-deleteCacheMeta  rit: " + strA + "  cost: " + (System.currentTimeMillis() - jCurrentTimeMillis));
                } catch (Throwable unused2) {
                }
            }
        });
        if (aVar != null) {
            aVar.z();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.splash.z.z
    public void z(String str, na naVar) {
        if (this.kb == null) {
            g();
        }
        if (this.kb != null) {
            this.kb.z(str, naVar.aq());
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.splash.z.z
    public void dl() {
        if (this.kb == null) {
            g();
        }
        if (this.kb != null) {
            this.kb.z();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.splash.z.z
    public void z(String str, String str2, boolean z, boolean z2, Object obj) {
        if (m() != 3 || TextUtils.isEmpty(str2) || TextUtils.isEmpty(str)) {
            return;
        }
        if (z2 || !z) {
            z(str, str2);
        } else {
            z(obj, str, str2);
        }
    }

    private void z(final Runnable runnable) {
        if (com.bytedance.sdk.openadsdk.hh.e.z()) {
            com.bytedance.sdk.component.uy.e.g(new com.bytedance.sdk.component.uy.fo("") { // from class: com.bytedance.sdk.openadsdk.core.component.splash.z.dl.4
                @Override // java.lang.Runnable
                public void run() {
                    runnable.run();
                }
            });
        } else {
            runnable.run();
        }
    }

    private List<String> z(String str) {
        List<String> list = gz.get(str);
        com.bytedance.sdk.openadsdk.core.e.z.z("lqmt", "getUsedReqIdList: list : " + (list == null ? 0 : list.size()));
        return list;
    }

    private void z(String str, String str2, String str3, int i) {
        int iM = m();
        com.bytedance.sdk.openadsdk.core.e.z.z("lqmt", "updateMemoryRecord>> start rit: " + str2 + ", status: " + i + ", cacheStrategyType: " + iM);
        if (iM != 3) {
            return;
        }
        e.put(str, new g(str3, i, str2));
        if (i <= 1) {
            com.bytedance.sdk.openadsdk.core.e.z.z("lqmt", "updateMemoryRecord>> :status <= CACHE_STATUS_NOUSE");
            return;
        }
        List<String> copyOnWriteArrayList = gz.get(str2);
        com.bytedance.sdk.openadsdk.core.e.z.z("lqmt", "updateMemoryRecord>>: list1 : " + (copyOnWriteArrayList == null ? 0 : copyOnWriteArrayList.size()));
        if (copyOnWriteArrayList == null) {
            copyOnWriteArrayList = new CopyOnWriteArrayList<>();
            copyOnWriteArrayList.add(str3);
        } else if (copyOnWriteArrayList.contains(str3)) {
            return;
        } else {
            copyOnWriteArrayList.add(str3);
        }
        com.bytedance.sdk.openadsdk.core.e.z.z("lqmt", "updateMemoryRecord>>: list2 : " + copyOnWriteArrayList.size());
        gz.put(str2, copyOnWriteArrayList);
    }

    private void z(Object obj, String str, String str2) {
        try {
            g gVar = e.get(g(str, str2));
            if (gVar != null && obj != null) {
                PhantomReference phantomReference = new PhantomReference(obj, fo);
                com.bytedance.sdk.openadsdk.core.e.z.z("lqmt", gVar.dl + "，uuid：" + gVar.z + " watching");
                uy.put(phantomReference, gVar);
            }
        } catch (Exception unused) {
        }
    }

    private void gc() {
        if (m() != 3) {
            return;
        }
        try {
            for (Reference<? extends Object> referencePoll = fo.poll(); referencePoll != null; referencePoll = fo.poll()) {
                g gVar = uy.get(referencePoll);
                if (gVar != null) {
                    z(gVar.dl, gVar.z);
                }
                uy.remove(referencePoll);
            }
        } catch (Exception unused) {
        }
    }

    private void z(String str, String str2) {
        e.remove(g(str, str2));
        List<String> list = gz.get(str);
        com.bytedance.sdk.openadsdk.core.e.z.z("lqmt", "checkCaches>>: list1 : " + (list == null ? 0 : list.size()));
        if (list == null) {
            return;
        }
        com.bytedance.sdk.openadsdk.core.e.z.z("lqmt", "checkCaches>>: rmCache : " + str2);
        list.remove(str2);
        gz.put(str, list);
    }

    private static int m() {
        if (gz.z() == null) {
            return 1;
        }
        return gz.z().a();
    }

    private String g(String str, String str2) {
        return str + str2;
    }
}
