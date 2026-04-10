package com.ss.android.downloadlib.addownload.g;

import android.text.TextUtils;
import com.bytedance.sdk.component.utils.wp;
import com.ss.android.downloadlib.e.i;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
public class m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final ConcurrentHashMap<Long, com.ss.android.z.z.dl.z> f1988a;
    private final ConcurrentHashMap<Long, com.ss.android.z.z.dl.g> dl;
    private final ConcurrentHashMap<Long, com.ss.android.z.z.dl.dl> g;
    private final ConcurrentHashMap<Long, com.ss.android.g.z.g.g> gc;
    private volatile boolean z;

    private static class z {
        private static m z = new m();
    }

    public static m z() {
        return z.z;
    }

    private m() {
        this.z = false;
        this.g = new ConcurrentHashMap<>();
        this.dl = new ConcurrentHashMap<>();
        this.f1988a = new ConcurrentHashMap<>();
        this.gc = new ConcurrentHashMap<>();
    }

    public void g() {
        com.ss.android.downloadlib.gc.z().z(new Runnable() { // from class: com.ss.android.downloadlib.addownload.g.m.1
            @Override // java.lang.Runnable
            public void run() {
                if (m.this.z) {
                    return;
                }
                synchronized (m.class) {
                    if (!m.this.z) {
                        m.this.gc.putAll(fo.z().g());
                        m.this.z = true;
                    }
                }
            }
        }, true);
    }

    public void z(com.ss.android.z.z.dl.dl dlVar) {
        if (dlVar != null) {
            this.g.put(Long.valueOf(dlVar.a()), dlVar);
            if (dlVar.l() != null) {
                dlVar.l().z(dlVar.a());
                dlVar.l().a(dlVar.sy());
            }
        }
    }

    public void z(long j, com.ss.android.z.z.dl.g gVar) {
        if (gVar != null) {
            this.dl.put(Long.valueOf(j), gVar);
        }
    }

    public void z(long j, com.ss.android.z.z.dl.z zVar) {
        if (zVar != null) {
            this.f1988a.put(Long.valueOf(j), zVar);
        }
    }

    public synchronized void z(com.ss.android.g.z.g.g gVar) {
        if (gVar == null) {
            return;
        }
        this.gc.put(Long.valueOf(gVar.g()), gVar);
        fo.z().z(gVar);
    }

    public com.ss.android.z.z.dl.dl z(long j) {
        return this.g.get(Long.valueOf(j));
    }

    public com.ss.android.z.z.dl.g g(long j) {
        return this.dl.get(Long.valueOf(j));
    }

    public com.ss.android.z.z.dl.z dl(long j) {
        return this.f1988a.get(Long.valueOf(j));
    }

    public com.ss.android.g.z.g.g a(long j) {
        return this.gc.get(Long.valueOf(j));
    }

    public ConcurrentHashMap<Long, com.ss.android.g.z.g.g> dl() {
        return this.gc;
    }

    public com.ss.android.g.z.g.g z(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        for (com.ss.android.g.z.g.g gVar : this.gc.values()) {
            if (gVar != null && str.equals(gVar.gc())) {
                return gVar;
            }
        }
        return null;
    }

    public com.ss.android.g.z.g.g g(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        for (com.ss.android.g.z.g.g gVar : this.gc.values()) {
            if (gVar != null && str.equals(gVar.z())) {
                return gVar;
            }
        }
        return null;
    }

    public com.ss.android.g.z.g.g z(com.ss.android.socialbase.downloader.e.dl dlVar) {
        if (dlVar == null) {
            return null;
        }
        for (com.ss.android.g.z.g.g gVar : this.gc.values()) {
            if (gVar != null && gVar.js() == dlVar.e()) {
                return gVar;
            }
        }
        if (!TextUtils.isEmpty(dlVar.gk())) {
            try {
                long jZ = i.z(new JSONObject(dlVar.gk()), "extra");
                if (jZ != 0) {
                    for (com.ss.android.g.z.g.g gVar2 : this.gc.values()) {
                        if (gVar2 != null && gVar2.g() == jZ) {
                            return gVar2;
                        }
                    }
                    com.ss.android.downloadlib.gc.dl.z().z("getNativeModelByInfo");
                }
            } catch (Exception e) {
                wp.z(e);
            }
        }
        for (com.ss.android.g.z.g.g gVar3 : this.gc.values()) {
            if (gVar3 != null && TextUtils.equals(gVar3.z(), dlVar.uy())) {
                return gVar3;
            }
        }
        return null;
    }

    public com.ss.android.g.z.g.g z(int i) {
        for (com.ss.android.g.z.g.g gVar : this.gc.values()) {
            if (gVar != null && gVar.js() == i) {
                return gVar;
            }
        }
        return null;
    }

    public gc gc(long j) {
        gc gcVar = new gc();
        gcVar.z = j;
        gcVar.g = z(j);
        gcVar.dl = g(j);
        if (gcVar.dl == null) {
            gcVar.dl = new com.ss.android.z.z.dl.e();
        }
        gcVar.f1987a = dl(j);
        if (gcVar.f1987a == null) {
            gcVar.f1987a = new com.ss.android.z.z.dl.m();
        }
        return gcVar;
    }

    public void m(long j) {
        this.g.remove(Long.valueOf(j));
        this.dl.remove(Long.valueOf(j));
        this.f1988a.remove(Long.valueOf(j));
    }

    public Map<Long, com.ss.android.g.z.g.g> z(String str, String str2) {
        HashMap map = new HashMap();
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            for (com.ss.android.g.z.g.g gVar : this.gc.values()) {
                if (gVar != null && TextUtils.equals(gVar.z(), str)) {
                    gVar.g(str2);
                    map.put(Long.valueOf(gVar.g()), gVar);
                }
            }
        }
        return map;
    }

    public void g(String str, String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return;
        }
        for (com.ss.android.z.z.dl.dl dlVar : this.g.values()) {
            if ((dlVar instanceof com.ss.android.g.z.z.dl) && TextUtils.equals(dlVar.z(), str)) {
                ((com.ss.android.g.z.z.dl) dlVar).gz(str2);
            }
        }
    }

    public synchronized void z(List<Long> list) {
        ArrayList arrayList = new ArrayList();
        Iterator<Long> it = list.iterator();
        while (it.hasNext()) {
            long jLongValue = it.next().longValue();
            arrayList.add(String.valueOf(jLongValue));
            this.gc.remove(Long.valueOf(jLongValue));
        }
        fo.z().z((List<String>) arrayList);
    }
}
