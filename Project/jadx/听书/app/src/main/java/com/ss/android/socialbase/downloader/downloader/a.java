package com.ss.android.socialbase.downloader.downloader;

import android.content.Intent;
import android.os.Handler;
import android.os.Looper;
import android.util.SparseArray;
import com.ss.android.socialbase.downloader.a.gk;
import com.ss.android.socialbase.downloader.a.hh;
import com.ss.android.socialbase.downloader.a.un;
import com.ss.android.socialbase.downloader.impls.DownloadHandleService;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
public class a {
    private static volatile a z;
    private volatile SparseArray<Boolean> g = new SparseArray<>();
    private Handler dl = new Handler(Looper.getMainLooper());

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private volatile List<Object> f2058a = new ArrayList();

    public static a z() {
        if (z == null) {
            synchronized (a.class) {
                z = new a();
            }
        }
        return z;
    }

    public void g() {
        synchronized (this.f2058a) {
            Iterator<Object> it = this.f2058a.iterator();
            while (it.hasNext()) {
                it.next();
            }
        }
    }

    public void z(int i, boolean z2) {
        g(i, z2);
        if (dl.y() && !com.ss.android.socialbase.downloader.pf.m.dl() && com.ss.android.socialbase.downloader.impls.wp.z(true).e()) {
            com.ss.android.socialbase.downloader.impls.wp.z(true).dl(i, z2);
        }
        if (dl.g() || com.ss.android.socialbase.downloader.pf.m.dl() || com.ss.android.socialbase.downloader.pf.m.z()) {
            return;
        }
        try {
            Intent intent = new Intent(dl.xl(), (Class<?>) DownloadHandleService.class);
            intent.setAction("com.ss.android.downloader.action.PROCESS_NOTIFY");
            intent.putExtra("extra_download_id", i);
            dl.xl().startService(intent);
        } catch (Throwable th) {
            com.bytedance.sdk.component.utils.wp.z(th);
        }
    }

    public synchronized void g(int i, boolean z2) {
        this.g.put(i, z2 ? Boolean.TRUE : Boolean.FALSE);
    }

    public int z(int i) {
        if (!dl.y()) {
            return -1;
        }
        if (!com.ss.android.socialbase.downloader.pf.m.dl() && com.ss.android.socialbase.downloader.impls.wp.z(true).e()) {
            return com.ss.android.socialbase.downloader.impls.wp.z(true).i(i);
        }
        return g(i);
    }

    public synchronized int g(int i) {
        if (this.g.get(i) == null) {
            return -1;
        }
        return this.g.get(i).booleanValue() ? 1 : 0;
    }

    public pf dl(int i) {
        return com.ss.android.socialbase.downloader.impls.wp.z(z(i) == 1 && !com.ss.android.socialbase.downloader.pf.m.dl());
    }

    private pf g(com.ss.android.socialbase.downloader.e.a aVar) {
        com.ss.android.socialbase.downloader.e.dl dlVarZ;
        List<com.ss.android.socialbase.downloader.e.g> listFo;
        if (aVar == null || (dlVarZ = aVar.z()) == null) {
            return null;
        }
        boolean zTf = dlVarZ.tf();
        if (com.ss.android.socialbase.downloader.pf.m.dl() || !com.ss.android.socialbase.downloader.pf.m.z()) {
            zTf = true;
        }
        int iZ = z(dlVarZ.e());
        if (iZ >= 0 && iZ != zTf) {
            try {
                if (iZ == 1) {
                    if (com.ss.android.socialbase.downloader.pf.m.z()) {
                        com.ss.android.socialbase.downloader.impls.wp.z(true).z(dlVarZ.e());
                        com.ss.android.socialbase.downloader.e.dl dlVarGz = com.ss.android.socialbase.downloader.impls.wp.z(true).gz(dlVarZ.e());
                        if (dlVarGz != null) {
                            com.ss.android.socialbase.downloader.impls.wp.z(false).g(dlVarGz);
                        }
                        if (dlVarGz.ux() > 1 && (listFo = com.ss.android.socialbase.downloader.impls.wp.z(true).fo(dlVarZ.e())) != null) {
                            com.ss.android.socialbase.downloader.impls.wp.z(false).z(dlVarZ.e(), com.ss.android.socialbase.downloader.pf.m.z(listFo));
                        }
                    }
                } else if (com.ss.android.socialbase.downloader.pf.m.z()) {
                    com.ss.android.socialbase.downloader.impls.wp.z(false).z(dlVarZ.e());
                    List<com.ss.android.socialbase.downloader.e.g> listFo2 = com.ss.android.socialbase.downloader.impls.wp.z(false).fo(dlVarZ.e());
                    if (listFo2 != null) {
                        com.ss.android.socialbase.downloader.impls.wp.z(true).z(dlVarZ.e(), com.ss.android.socialbase.downloader.pf.m.z(listFo2));
                    }
                } else {
                    aVar.z(true);
                    com.ss.android.socialbase.downloader.impls.wp.z(true).z(1, dlVarZ.e());
                }
            } catch (Throwable unused) {
            }
        }
        z(dlVarZ.e(), zTf);
        return com.ss.android.socialbase.downloader.impls.wp.z(zTf);
    }

    public void a(int i) {
        pf pfVarDl = dl(i);
        if (pfVarDl == null) {
            return;
        }
        pfVarDl.z(i);
    }

    public void dl(int i, boolean z2) {
        if (com.ss.android.socialbase.downloader.pf.m.z()) {
            if (com.ss.android.socialbase.downloader.pf.z.z(8388608)) {
                pf pfVarZ = com.ss.android.socialbase.downloader.impls.wp.z(true);
                if (pfVarZ != null) {
                    pfVarZ.z(i, z2);
                }
                pf pfVarZ2 = com.ss.android.socialbase.downloader.impls.wp.z(false);
                if (pfVarZ2 != null) {
                    pfVarZ2.z(i, z2);
                    return;
                }
                return;
            }
            pf pfVarZ3 = com.ss.android.socialbase.downloader.impls.wp.z(false);
            if (pfVarZ3 != null) {
                pfVarZ3.z(i, z2);
            }
            pf pfVarZ4 = com.ss.android.socialbase.downloader.impls.wp.z(true);
            if (pfVarZ4 != null) {
                pfVarZ4.z(i, z2);
                return;
            }
            return;
        }
        pf pfVarDl = dl(i);
        if (pfVarDl != null) {
            pfVarDl.z(i, z2);
        }
        com.ss.android.socialbase.downloader.impls.wp.z(true).z(2, i);
    }

    public boolean gc(int i) {
        pf pfVarDl = dl(i);
        if (pfVarDl == null) {
            return false;
        }
        return pfVarDl.g(i);
    }

    public void m(int i) {
        pf pfVarDl = dl(i);
        if (pfVarDl == null) {
            return;
        }
        pfVarDl.dl(i);
    }

    public void e(int i) {
        pf pfVarDl = dl(i);
        if (pfVarDl == null) {
            return;
        }
        pfVarDl.a(i);
    }

    public void dl() {
        pf pfVarZ = com.ss.android.socialbase.downloader.impls.wp.z(false);
        if (pfVarZ != null) {
            pfVarZ.z();
        }
        pf pfVarZ2 = com.ss.android.socialbase.downloader.impls.wp.z(true);
        if (pfVarZ2 != null) {
            pfVarZ2.z();
        }
    }

    public int gz(int i) {
        pf pfVarDl = dl(i);
        if (pfVarDl == null) {
            return 0;
        }
        return pfVarDl.m(i);
    }

    public boolean fo(int i) {
        pf pfVarDl = dl(i);
        if (pfVarDl == null) {
            return false;
        }
        return pfVarDl.e(i);
    }

    public com.ss.android.socialbase.downloader.e.dl uy(int i) {
        pf pfVarDl = dl(i);
        if (pfVarDl == null) {
            return null;
        }
        return pfVarDl.gz(i);
    }

    public int z(String str, String str2) {
        return dl.z(str, str2);
    }

    public com.ss.android.socialbase.downloader.e.dl g(String str, String str2) {
        int iZ = z(str, str2);
        pf pfVarDl = dl(iZ);
        if (pfVarDl == null) {
            return null;
        }
        return pfVarDl.gz(iZ);
    }

    public List<com.ss.android.socialbase.downloader.e.dl> z(String str) {
        List<com.ss.android.socialbase.downloader.e.dl> listZ = com.ss.android.socialbase.downloader.impls.wp.z(false).z(str);
        List<com.ss.android.socialbase.downloader.e.dl> listZ2 = com.ss.android.socialbase.downloader.impls.wp.z(true).z(str);
        if (listZ == null && listZ2 == null) {
            return null;
        }
        if (listZ == null || listZ2 == null) {
            return listZ != null ? listZ : listZ2;
        }
        ArrayList arrayList = new ArrayList(listZ);
        arrayList.addAll(listZ2);
        return arrayList;
    }

    public gk kb(int i) {
        pf pfVarDl = dl(i);
        if (pfVarDl == null) {
            return null;
        }
        return pfVarDl.p(i);
    }

    public un wp(int i) {
        pf pfVarDl = dl(i);
        if (pfVarDl == null) {
            return null;
        }
        return pfVarDl.fv(i);
    }

    private List<com.ss.android.socialbase.downloader.e.dl> z(List<com.ss.android.socialbase.downloader.e.dl> list, List<com.ss.android.socialbase.downloader.e.dl> list2, SparseArray<com.ss.android.socialbase.downloader.e.dl> sparseArray) {
        ArrayList arrayList = new ArrayList();
        if (list != null) {
            for (com.ss.android.socialbase.downloader.e.dl dlVar : list) {
                if (dlVar != null && sparseArray.get(dlVar.e()) == null) {
                    sparseArray.put(dlVar.e(), dlVar);
                }
            }
        }
        if (list2 != null) {
            for (com.ss.android.socialbase.downloader.e.dl dlVar2 : list2) {
                if (dlVar2 != null && sparseArray.get(dlVar2.e()) == null) {
                    sparseArray.put(dlVar2.e(), dlVar2);
                }
            }
        }
        for (int i = 0; i < sparseArray.size(); i++) {
            arrayList.add(sparseArray.get(sparseArray.keyAt(i)));
        }
        return arrayList;
    }

    public List<com.ss.android.socialbase.downloader.e.dl> g(String str) {
        SparseArray<com.ss.android.socialbase.downloader.e.dl> sparseArray = new SparseArray<>();
        pf pfVarZ = com.ss.android.socialbase.downloader.impls.wp.z(false);
        List<com.ss.android.socialbase.downloader.e.dl> listDl = pfVarZ != null ? pfVarZ.dl(str) : null;
        pf pfVarZ2 = com.ss.android.socialbase.downloader.impls.wp.z(true);
        return z(listDl, pfVarZ2 != null ? pfVarZ2.dl(str) : null, sparseArray);
    }

    public void z(List<String> list) {
        pf pfVarZ = com.ss.android.socialbase.downloader.impls.wp.z(false);
        if (pfVarZ != null) {
            pfVarZ.z(list);
        }
        pf pfVarZ2 = com.ss.android.socialbase.downloader.impls.wp.z(true);
        if (pfVarZ2 != null) {
            pfVarZ2.z(list);
        }
    }

    public void g(List<String> list) {
        pf pfVarZ = com.ss.android.socialbase.downloader.impls.wp.z(false);
        if (pfVarZ != null) {
            pfVarZ.g(list);
        }
        pf pfVarZ2 = com.ss.android.socialbase.downloader.impls.wp.z(true);
        if (pfVarZ2 != null) {
            pfVarZ2.g(list);
        }
    }

    public void a(int i, boolean z2) {
        pf pfVarDl = dl(i);
        if (pfVarDl == null) {
            return;
        }
        pfVarDl.g(i, z2);
    }

    public void z(int i, hh hhVar, com.ss.android.socialbase.downloader.g.gz gzVar, boolean z2) {
        pf pfVarDl = dl(i);
        if (pfVarDl == null) {
            return;
        }
        pfVarDl.g(i, hhVar == null ? 0 : hhVar.hashCode(), hhVar, gzVar, z2);
    }

    public void g(int i, hh hhVar, com.ss.android.socialbase.downloader.g.gz gzVar, boolean z2) {
        pf pfVarDl = dl(i);
        if (pfVarDl == null) {
            return;
        }
        pfVarDl.z(i, hhVar.hashCode(), hhVar, gzVar, z2);
    }

    public void z(int i, hh hhVar, com.ss.android.socialbase.downloader.g.gz gzVar, boolean z2, boolean z3) {
        pf pfVarDl = dl(i);
        if (pfVarDl == null) {
            return;
        }
        pfVarDl.z(i, hhVar.hashCode(), hhVar, gzVar, z2, z3);
    }

    public boolean z(com.ss.android.socialbase.downloader.e.dl dlVar) {
        pf pfVarDl;
        if (dlVar == null || (pfVarDl = dl(dlVar.e())) == null) {
            return false;
        }
        return pfVarDl.z(dlVar);
    }

    public List<com.ss.android.socialbase.downloader.e.dl> dl(String str) {
        SparseArray<com.ss.android.socialbase.downloader.e.dl> sparseArray = new SparseArray<>();
        pf pfVarZ = com.ss.android.socialbase.downloader.impls.wp.z(false);
        List<com.ss.android.socialbase.downloader.e.dl> listA = pfVarZ != null ? pfVarZ.a(str) : null;
        pf pfVarZ2 = com.ss.android.socialbase.downloader.impls.wp.z(true);
        return z(listA, pfVarZ2 != null ? pfVarZ2.a(str) : null, sparseArray);
    }

    public List<com.ss.android.socialbase.downloader.e.dl> a(String str) {
        SparseArray<com.ss.android.socialbase.downloader.e.dl> sparseArray = new SparseArray<>();
        pf pfVarZ = com.ss.android.socialbase.downloader.impls.wp.z(false);
        List<com.ss.android.socialbase.downloader.e.dl> listGc = pfVarZ != null ? pfVarZ.gc(str) : null;
        pf pfVarZ2 = com.ss.android.socialbase.downloader.impls.wp.z(true);
        return z(listGc, pfVarZ2 != null ? pfVarZ2.gc(str) : null, sparseArray);
    }

    public void z(final com.ss.android.socialbase.downloader.e.a aVar) {
        final pf pfVarG = g(aVar);
        if (pfVarG == null) {
            if (aVar != null) {
                com.ss.android.socialbase.downloader.gz.z.z(aVar.gc(), aVar.z(), new com.ss.android.socialbase.downloader.gc.z(1003, "tryDownload but getDownloadHandler failed"), aVar.z() != null ? aVar.z().p() : 0);
            }
        } else if (aVar.g()) {
            this.dl.postDelayed(new Runnable() { // from class: com.ss.android.socialbase.downloader.downloader.a.1
                @Override // java.lang.Runnable
                public void run() {
                    pfVarG.z(aVar);
                }
            }, 500L);
        } else {
            pfVarG.z(aVar);
        }
    }

    public boolean i(int i) {
        pf pfVarDl = dl(i);
        if (pfVarDl == null) {
            return false;
        }
        return pfVarDl.wp(i);
    }

    public void v(int i) {
        if (i == 0) {
            return;
        }
        g(i, true);
        pf pfVarZ = com.ss.android.socialbase.downloader.impls.wp.z(true);
        if (pfVarZ == null) {
            return;
        }
        pfVarZ.startService();
    }

    public void z(com.ss.android.socialbase.downloader.a.wp wpVar) {
        dl.z(wpVar);
    }

    public com.ss.android.socialbase.downloader.a.q pf(int i) {
        pf pfVarDl = dl(i);
        if (pfVarDl == null) {
            return null;
        }
        return pfVarDl.js(i);
    }
}
