package com.ss.android.downloadlib;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.ss.android.downloadlib.addownload.wp;
import com.ss.android.z.z.g.p;
import com.ss.android.z.z.g.uf;
import java.lang.ref.SoftReference;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: loaded from: classes4.dex */
public class gz {
    private static volatile gz z;
    private long m;
    private final List<com.ss.android.downloadlib.addownload.e> dl = new CopyOnWriteArrayList();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Map<String, com.ss.android.downloadlib.addownload.e> f2011a = new ConcurrentHashMap();
    private final CopyOnWriteArrayList<Object> gc = new CopyOnWriteArrayList<>();
    private final Handler g = new Handler(Looper.getMainLooper());

    private gz() {
    }

    public static gz z() {
        if (z == null) {
            synchronized (gz.class) {
                if (z == null) {
                    z = new gz();
                }
            }
        }
        return z;
    }

    public void z(Context context, int i, com.ss.android.z.z.dl.a aVar, com.ss.android.z.z.dl.dl dlVar) {
        com.ss.android.downloadlib.addownload.e eVar;
        if (dlVar == null || TextUtils.isEmpty(dlVar.z())) {
            return;
        }
        boolean z2 = wp.fo().optInt("filter_download_url_key", 0) == 1;
        String strZ = com.ss.android.downloadlib.addownload.m.z().z(dlVar.z());
        if (z2 && !TextUtils.isEmpty(strZ)) {
            eVar = this.f2011a.get(strZ);
            if (dlVar instanceof com.ss.android.g.z.z.dl) {
                com.ss.android.g.z.z.dl dlVar2 = (com.ss.android.g.z.z.dl) dlVar;
                if (TextUtils.isEmpty(dlVar2.t())) {
                    dlVar2.m(strZ);
                }
            }
        } else {
            eVar = this.f2011a.get(dlVar.z());
        }
        if (eVar != null) {
            eVar.g(context).g(i, aVar).g(dlVar).z();
            return;
        }
        if (this.dl.isEmpty()) {
            if (z2) {
                if (!TextUtils.isEmpty(strZ)) {
                    g(context, i, aVar, dlVar, strZ);
                    return;
                }
                String strZ2 = com.ss.android.downloadlib.addownload.m.z().z(dlVar);
                if (!TextUtils.isEmpty(strZ2)) {
                    g(context, i, aVar, dlVar, strZ2);
                    if (dlVar instanceof com.ss.android.g.z.z.dl) {
                        com.ss.android.g.z.z.dl dlVar3 = (com.ss.android.g.z.z.dl) dlVar;
                        if (TextUtils.isEmpty(dlVar3.t())) {
                            dlVar3.m(strZ2);
                            return;
                        }
                        return;
                    }
                    return;
                }
            }
            dl(context, i, aVar, dlVar);
            return;
        }
        if (z2) {
            if (!TextUtils.isEmpty(strZ)) {
                z(context, i, aVar, dlVar, strZ);
                return;
            }
            String strZ3 = com.ss.android.downloadlib.addownload.m.z().z(dlVar);
            if (TextUtils.isEmpty(strZ3)) {
                g(context, i, aVar, dlVar);
                return;
            }
            z(context, i, aVar, dlVar, strZ3);
            if (dlVar instanceof com.ss.android.g.z.z.dl) {
                com.ss.android.g.z.z.dl dlVar4 = (com.ss.android.g.z.z.dl) dlVar;
                if (TextUtils.isEmpty(dlVar4.t())) {
                    dlVar4.m(strZ3);
                    return;
                }
                return;
            }
            return;
        }
        g(context, i, aVar, dlVar);
    }

    public com.ss.android.downloadlib.addownload.gc z(String str) {
        com.ss.android.downloadlib.addownload.e eVar;
        Map<String, com.ss.android.downloadlib.addownload.e> map = this.f2011a;
        if (map != null && map.size() != 0 && !TextUtils.isEmpty(str)) {
            if (wp.fo().optInt("filter_download_url_key", 0) == 1) {
                eVar = this.f2011a.get(com.ss.android.downloadlib.addownload.m.z().z(str));
            } else {
                eVar = this.f2011a.get(str);
            }
            if (eVar instanceof com.ss.android.downloadlib.addownload.gc) {
                return (com.ss.android.downloadlib.addownload.gc) eVar;
            }
        }
        return null;
    }

    private synchronized void g(Context context, int i, com.ss.android.z.z.dl.a aVar, com.ss.android.z.z.dl.dl dlVar) {
        if (this.dl.size() <= 0) {
            dl(context, i, aVar, dlVar);
            return;
        }
        com.ss.android.downloadlib.addownload.e eVarRemove = this.dl.remove(0);
        eVarRemove.g(context).g(i, aVar).g(dlVar).z();
        this.f2011a.put(dlVar.z(), eVarRemove);
    }

    private synchronized void z(Context context, int i, com.ss.android.z.z.dl.a aVar, com.ss.android.z.z.dl.dl dlVar, String str) {
        if (this.dl.size() <= 0) {
            g(context, i, aVar, dlVar, str);
            return;
        }
        com.ss.android.downloadlib.addownload.e eVarRemove = this.dl.remove(0);
        eVarRemove.g(context).g(i, aVar).g(dlVar).z(str).z();
        this.f2011a.put(str, eVarRemove);
        com.ss.android.downloadlib.addownload.m.z().z(str, dlVar.z());
    }

    private void dl(Context context, int i, com.ss.android.z.z.dl.a aVar, com.ss.android.z.z.dl.dl dlVar) {
        if (dlVar == null) {
            return;
        }
        com.ss.android.downloadlib.addownload.gc gcVar = new com.ss.android.downloadlib.addownload.gc();
        gcVar.g(context).g(i, aVar).g(dlVar).z();
        this.f2011a.put(dlVar.z(), gcVar);
    }

    private void g(Context context, int i, com.ss.android.z.z.dl.a aVar, com.ss.android.z.z.dl.dl dlVar, String str) {
        if (dlVar == null) {
            return;
        }
        com.ss.android.downloadlib.addownload.gc gcVar = new com.ss.android.downloadlib.addownload.gc();
        gcVar.g(context).g(i, aVar).g(dlVar).z(str).z();
        this.f2011a.put(str, gcVar);
        com.ss.android.downloadlib.addownload.m.z().z(str, dlVar.z());
    }

    public void z(String str, int i) {
        com.ss.android.downloadlib.addownload.e eVar;
        if (TextUtils.isEmpty(str)) {
            return;
        }
        boolean z2 = wp.fo().optInt("filter_download_url_key", 0) == 1;
        String strZ = com.ss.android.downloadlib.addownload.m.z().z(str);
        if (z2 && !TextUtils.isEmpty(strZ)) {
            eVar = this.f2011a.get(strZ);
        } else {
            eVar = this.f2011a.get(str);
        }
        if (eVar != null) {
            if (eVar.z(i)) {
                this.dl.add(eVar);
                if (z2 && !TextUtils.isEmpty(strZ)) {
                    this.f2011a.remove(strZ);
                    com.ss.android.downloadlib.addownload.m.z().g(strZ);
                } else {
                    this.f2011a.remove(str);
                }
            }
            dl();
        }
    }

    public void z(String str, boolean z2) {
        com.ss.android.downloadlib.addownload.e eVar;
        if (TextUtils.isEmpty(str)) {
            return;
        }
        boolean z3 = wp.fo().optInt("filter_download_url_key", 0) == 1;
        String strZ = com.ss.android.downloadlib.addownload.m.z().z(str);
        if (z3 && !TextUtils.isEmpty(strZ)) {
            eVar = this.f2011a.get(strZ);
        } else {
            eVar = this.f2011a.get(str);
        }
        if (eVar != null) {
            eVar.z(z2);
        }
    }

    public void z(String str, long j, int i, com.ss.android.z.z.dl.g gVar, com.ss.android.z.z.dl.z zVar) {
        z(str, j, i, gVar, zVar, null, null);
    }

    public void z(String str, long j, int i, com.ss.android.z.z.dl.g gVar, com.ss.android.z.z.dl.z zVar, p pVar) {
        z(str, j, i, gVar, zVar, null, pVar);
    }

    public void z(String str, long j, int i, com.ss.android.z.z.dl.g gVar, com.ss.android.z.z.dl.z zVar, uf ufVar, p pVar) {
        com.ss.android.downloadlib.addownload.e eVar;
        if (TextUtils.isEmpty(str)) {
            return;
        }
        boolean z2 = wp.fo().optInt("filter_download_url_key", 0) == 1;
        String strZ = com.ss.android.downloadlib.addownload.m.z().z(str);
        if (z2 && !TextUtils.isEmpty(strZ)) {
            eVar = this.f2011a.get(strZ);
        } else {
            eVar = this.f2011a.get(str);
        }
        if (eVar != null) {
            eVar.z(j).g(gVar).g(zVar).z(ufVar).z(pVar).g(i);
        }
    }

    public void z(com.ss.android.z.z.dl.z.z zVar) {
        if (zVar != null) {
            if (com.ss.android.socialbase.downloader.i.z.dl().g("fix_listener_oom", false)) {
                this.gc.add(new SoftReference(zVar));
            } else {
                this.gc.add(zVar);
            }
        }
    }

    private void dl() {
        long jCurrentTimeMillis = System.currentTimeMillis();
        if (jCurrentTimeMillis - this.m < 300000) {
            return;
        }
        this.m = jCurrentTimeMillis;
        if (this.dl.isEmpty()) {
            return;
        }
        a();
    }

    private void a() {
        long jCurrentTimeMillis = System.currentTimeMillis();
        ArrayList arrayList = new ArrayList();
        for (com.ss.android.downloadlib.addownload.e eVar : this.dl) {
            if (!eVar.g() && jCurrentTimeMillis - eVar.a() > 300000) {
                eVar.gz();
                arrayList.add(eVar);
            }
        }
        if (arrayList.isEmpty()) {
            return;
        }
        this.dl.removeAll(arrayList);
    }

    public void z(final com.ss.android.z.z.dl.dl dlVar, final com.ss.android.z.z.dl.z zVar, final com.ss.android.z.z.dl.g gVar) {
        this.g.post(new Runnable() { // from class: com.ss.android.downloadlib.gz.1
            @Override // java.lang.Runnable
            public void run() {
                for (Object obj : gz.this.gc) {
                    if (!(obj instanceof com.ss.android.z.z.dl.z.z) && (obj instanceof SoftReference)) {
                        SoftReference softReference = (SoftReference) obj;
                        if (softReference.get() instanceof com.ss.android.z.z.dl.z.z) {
                            softReference.get();
                        }
                    }
                }
            }
        });
    }

    public void z(final com.ss.android.socialbase.downloader.e.dl dlVar, final com.ss.android.socialbase.downloader.gc.z zVar, final String str) {
        this.g.post(new Runnable() { // from class: com.ss.android.downloadlib.gz.2
            @Override // java.lang.Runnable
            public void run() {
                for (Object obj : gz.this.gc) {
                    if (!(obj instanceof com.ss.android.z.z.dl.z.z) && (obj instanceof SoftReference)) {
                        SoftReference softReference = (SoftReference) obj;
                        if (softReference.get() instanceof com.ss.android.z.z.dl.z.z) {
                            softReference.get();
                        }
                    }
                }
            }
        });
    }

    public void z(final com.ss.android.socialbase.downloader.e.dl dlVar, final String str) {
        this.g.post(new Runnable() { // from class: com.ss.android.downloadlib.gz.3
            @Override // java.lang.Runnable
            public void run() {
                for (Object obj : gz.this.gc) {
                    if (!(obj instanceof com.ss.android.z.z.dl.z.z) && (obj instanceof SoftReference)) {
                        SoftReference softReference = (SoftReference) obj;
                        if (softReference.get() instanceof com.ss.android.z.z.dl.z.z) {
                            softReference.get();
                        }
                    }
                }
            }
        });
    }

    public void g(final com.ss.android.socialbase.downloader.e.dl dlVar, final String str) {
        this.g.post(new Runnable() { // from class: com.ss.android.downloadlib.gz.4
            @Override // java.lang.Runnable
            public void run() {
                for (Object obj : gz.this.gc) {
                    if (obj instanceof com.ss.android.z.z.dl.z.z) {
                        ((com.ss.android.z.z.dl.z.z) obj).z(dlVar, str);
                    } else if (obj instanceof SoftReference) {
                        SoftReference softReference = (SoftReference) obj;
                        if (softReference.get() instanceof com.ss.android.z.z.dl.z.z) {
                            ((com.ss.android.z.z.dl.z.z) softReference.get()).z(dlVar, str);
                        }
                    }
                }
            }
        });
    }

    public void z(final com.ss.android.socialbase.downloader.e.dl dlVar) {
        this.g.post(new Runnable() { // from class: com.ss.android.downloadlib.gz.5
            @Override // java.lang.Runnable
            public void run() {
                for (Object obj : gz.this.gc) {
                    if (!(obj instanceof com.ss.android.z.z.dl.z.z) && (obj instanceof SoftReference)) {
                        SoftReference softReference = (SoftReference) obj;
                        if (softReference.get() instanceof com.ss.android.z.z.dl.z.z) {
                            softReference.get();
                        }
                    }
                }
            }
        });
    }

    public Handler g() {
        return this.g;
    }
}
