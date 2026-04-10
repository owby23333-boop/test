package com.ss.android.socialbase.downloader.impls;

import android.database.sqlite.SQLiteException;
import android.os.Looper;
import android.os.Message;
import android.util.SparseArray;
import com.ss.android.socialbase.downloader.downloader.dl;
import com.ss.android.socialbase.downloader.downloader.q;
import com.ss.android.socialbase.downloader.v.gz;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: loaded from: classes4.dex */
public class a implements com.ss.android.socialbase.downloader.downloader.wp {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private volatile boolean f2089a;
    private volatile boolean dl;
    private q g;
    private com.ss.android.socialbase.downloader.v.gz m;
    private gz.z gc = new gz.z() { // from class: com.ss.android.socialbase.downloader.impls.a.1
        @Override // com.ss.android.socialbase.downloader.v.gz.z
        public void z(Message message) {
            if (message.what == 1) {
                com.ss.android.socialbase.downloader.downloader.dl.kb().execute(new Runnable() { // from class: com.ss.android.socialbase.downloader.impls.a.1.1
                    @Override // java.lang.Runnable
                    public void run() {
                        try {
                            a.this.fo();
                        } catch (Exception e) {
                            com.bytedance.sdk.component.utils.wp.z(e);
                        }
                    }
                });
            }
        }
    };
    private final kb z = new kb();

    public a() {
        this.m = null;
        if (!com.ss.android.socialbase.downloader.i.z.dl().z("fix_sigbus_downloader_db") || com.ss.android.socialbase.downloader.pf.m.z() || !com.ss.android.socialbase.downloader.downloader.dl.y()) {
            this.g = new com.ss.android.socialbase.downloader.dl.gc();
        } else {
            this.g = com.ss.android.socialbase.downloader.downloader.dl.ec().z(new dl.z.InterfaceC0473z() { // from class: com.ss.android.socialbase.downloader.impls.a.2
                @Override // com.ss.android.socialbase.downloader.downloader.dl.z.InterfaceC0473z
                public void z() {
                    a.this.g = new com.ss.android.socialbase.downloader.dl.gc();
                    com.bytedance.sdk.component.utils.wp.a("DefaultDownloadCache", "rebind error,use backup sqlDownloadCache");
                }
            });
        }
        this.dl = false;
        this.m = new com.ss.android.socialbase.downloader.v.gz(Looper.getMainLooper(), this.gc);
        e();
    }

    public kb z() {
        return this.z;
    }

    public q m() {
        return this.g;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.wp
    public com.ss.android.socialbase.downloader.e.dl e(int i) {
        com.ss.android.socialbase.downloader.e.dl dlVarE = this.z.e(i);
        dl(dlVarE);
        return dlVarE;
    }

    public void e() {
        List<com.ss.android.socialbase.downloader.e.g> list;
        com.ss.android.socialbase.downloader.e.dl dlVar;
        com.ss.android.socialbase.downloader.downloader.dl.z(com.ss.android.socialbase.downloader.g.a.SYNC_START);
        final SparseArray<com.ss.android.socialbase.downloader.e.dl> sparseArray = new SparseArray<>();
        final SparseArray<List<com.ss.android.socialbase.downloader.e.g>> sparseArray2 = new SparseArray<>();
        synchronized (this.z) {
            SparseArray<com.ss.android.socialbase.downloader.e.dl> sparseArrayZ = this.z.z();
            for (int i = 0; i < sparseArrayZ.size(); i++) {
                int iKeyAt = sparseArrayZ.keyAt(i);
                if (iKeyAt != 0 && (dlVar = sparseArrayZ.get(iKeyAt)) != null) {
                    sparseArray.put(iKeyAt, dlVar);
                }
            }
            SparseArray<List<com.ss.android.socialbase.downloader.e.g>> sparseArrayM = this.z.m();
            for (int i2 = 0; i2 < sparseArrayM.size(); i2++) {
                int iKeyAt2 = sparseArrayM.keyAt(i2);
                if (iKeyAt2 != 0 && (list = sparseArrayM.get(iKeyAt2)) != null) {
                    sparseArray2.put(iKeyAt2, new CopyOnWriteArrayList(list));
                }
            }
        }
        this.g.z(sparseArray, sparseArray2, new com.ss.android.socialbase.downloader.dl.a() { // from class: com.ss.android.socialbase.downloader.impls.a.3
            @Override // com.ss.android.socialbase.downloader.dl.a
            public void z() {
                synchronized (a.this.z) {
                    SparseArray<com.ss.android.socialbase.downloader.e.dl> sparseArrayZ2 = a.this.z.z();
                    if (sparseArray != null) {
                        for (int i3 = 0; i3 < sparseArray.size(); i3++) {
                            int iKeyAt3 = sparseArray.keyAt(i3);
                            if (iKeyAt3 != 0) {
                                sparseArrayZ2.put(iKeyAt3, (com.ss.android.socialbase.downloader.e.dl) sparseArray.get(iKeyAt3));
                            }
                        }
                    }
                    SparseArray<List<com.ss.android.socialbase.downloader.e.g>> sparseArrayM2 = a.this.z.m();
                    if (sparseArray2 != null) {
                        for (int i4 = 0; i4 < sparseArray2.size(); i4++) {
                            int iKeyAt4 = sparseArray2.keyAt(i4);
                            if (iKeyAt4 != 0) {
                                sparseArrayM2.put(iKeyAt4, (List) sparseArray2.get(iKeyAt4));
                            }
                        }
                    }
                }
                a.this.uy();
                a.this.gz();
                com.ss.android.socialbase.downloader.downloader.dl.z(com.ss.android.socialbase.downloader.g.a.SYNC_SUCCESS);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void uy() {
        synchronized (this) {
            this.dl = true;
            notifyAll();
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.wp
    public boolean gc() {
        if (this.dl) {
            return true;
        }
        synchronized (this) {
            if (!this.dl) {
                com.ss.android.socialbase.downloader.m.z.a("DefaultDownloadCache", "ensureDownloadCacheSyncSuccess: waiting start!!!!");
                try {
                    wait(5000L);
                } catch (InterruptedException e) {
                    com.bytedance.sdk.component.utils.wp.z(e);
                }
                com.ss.android.socialbase.downloader.m.z.a("DefaultDownloadCache", "ensureDownloadCacheSyncSuccess: waiting end!!!!");
            }
        }
        return this.dl;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.wp
    public boolean a() {
        return this.dl;
    }

    public void gz() {
        this.m.sendMessageDelayed(this.m.obtainMessage(1), com.ss.android.socialbase.downloader.i.z.dl().z("task_resume_delay") ? 4000L : 1000L);
    }

    public void fo() {
        List<String> listZ;
        ArrayList arrayList;
        com.ss.android.socialbase.downloader.e.dl dlVar;
        com.ss.android.socialbase.downloader.e.dl dlVar2;
        if (this.dl) {
            if (this.f2089a) {
                com.ss.android.socialbase.downloader.m.z.g("DefaultDownloadCache", "resumeUnCompleteTask: has resumed, return!!!");
                return;
            }
            this.f2089a = true;
            if (com.ss.android.socialbase.downloader.pf.m.z()) {
                com.ss.android.socialbase.downloader.downloader.v vVarZw = com.ss.android.socialbase.downloader.downloader.dl.zw();
                if (vVarZw != null) {
                    listZ = vVarZw.z();
                    arrayList = (listZ == null || listZ.isEmpty()) ? null : new ArrayList();
                } else {
                    listZ = null;
                    arrayList = null;
                }
                SparseArray sparseArray = new SparseArray();
                synchronized (this) {
                    SparseArray<com.ss.android.socialbase.downloader.e.dl> sparseArrayZ = this.z.z();
                    for (int i = 0; i < sparseArrayZ.size(); i++) {
                        int iKeyAt = sparseArrayZ.keyAt(i);
                        if (iKeyAt != 0 && (dlVar2 = sparseArrayZ.get(iKeyAt)) != null) {
                            sparseArray.put(iKeyAt, dlVar2);
                        }
                    }
                }
                if (sparseArray.size() == 0) {
                    return;
                }
                for (int i2 = 0; i2 < sparseArray.size(); i2++) {
                    int iKeyAt2 = sparseArray.keyAt(i2);
                    if (iKeyAt2 != 0 && (dlVar = (com.ss.android.socialbase.downloader.e.dl) sparseArray.get(iKeyAt2)) != null) {
                        int iZw = dlVar.zw();
                        int iRy = dlVar.ry();
                        if (iRy > 0 && iRy <= 11) {
                            com.ss.android.socialbase.downloader.gz.z.z(com.ss.android.socialbase.downloader.downloader.dl.m(), dlVar, (com.ss.android.socialbase.downloader.gc.z) null, -5);
                        }
                        if (listZ != null && arrayList != null && dlVar.yt() != null && listZ.contains(dlVar.yt()) && (com.ss.android.socialbase.downloader.i.z.z(dlVar.e()).g("enable_notification_ui") >= 2 || iZw != -2 || dlVar.jq())) {
                            dlVar.gc(false);
                            arrayList.add(dlVar);
                        }
                    }
                }
                if (vVarZw == null || arrayList == null || arrayList.isEmpty()) {
                    return;
                }
                vVarZw.z(arrayList, 1);
            }
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.wp
    public com.ss.android.socialbase.downloader.e.dl g(int i) {
        return this.z.g(i);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.wp
    public List<com.ss.android.socialbase.downloader.e.dl> z(String str) {
        return this.z.z(str);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.wp
    public List<com.ss.android.socialbase.downloader.e.dl> g(String str) {
        return this.z.g(str);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.wp
    public List<com.ss.android.socialbase.downloader.e.dl> dl(String str) {
        return this.z.dl(str);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.wp
    public List<com.ss.android.socialbase.downloader.e.dl> a(String str) {
        return this.z.a(str);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.wp
    public List<com.ss.android.socialbase.downloader.e.dl> g() {
        return this.z.g();
    }

    @Override // com.ss.android.socialbase.downloader.downloader.wp
    public List<com.ss.android.socialbase.downloader.e.g> dl(int i) {
        return this.z.dl(i);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.wp
    public void a(int i) {
        this.z.a(i);
        if (com.ss.android.socialbase.downloader.pf.m.g()) {
            com.ss.android.socialbase.downloader.downloader.pf pfVarZ = wp.z(true);
            if (pfVarZ != null) {
                pfVarZ.pf(i);
                return;
            } else {
                this.g.a(i);
                return;
            }
        }
        this.g.a(i);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.wp
    public void z(com.ss.android.socialbase.downloader.e.g gVar) {
        synchronized (this.z) {
            this.z.z(gVar);
        }
        if (com.ss.android.socialbase.downloader.pf.m.g()) {
            com.ss.android.socialbase.downloader.downloader.pf pfVarZ = wp.z(true);
            if (pfVarZ != null) {
                pfVarZ.z(gVar);
                return;
            } else {
                this.g.z(gVar);
                return;
            }
        }
        this.g.z(gVar);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.wp
    public void g(com.ss.android.socialbase.downloader.e.g gVar) {
        if (com.ss.android.socialbase.downloader.pf.m.g()) {
            com.ss.android.socialbase.downloader.downloader.pf pfVarZ = wp.z(true);
            if (pfVarZ != null) {
                pfVarZ.z(gVar);
                return;
            } else {
                this.g.z(gVar);
                return;
            }
        }
        this.g.z(gVar);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.wp
    public void z(int i, int i2, long j) {
        this.z.z(i, i2, j);
        if (com.ss.android.socialbase.downloader.pf.m.g()) {
            com.ss.android.socialbase.downloader.downloader.pf pfVarZ = wp.z(true);
            if (pfVarZ != null) {
                pfVarZ.z(i, i2, j);
                return;
            } else {
                this.g.z(i, i2, j);
                return;
            }
        }
        this.g.z(i, i2, j);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.wp
    public void z(int i, int i2, int i3, long j) {
        if (com.ss.android.socialbase.downloader.pf.m.g()) {
            com.ss.android.socialbase.downloader.downloader.pf pfVarZ = wp.z(true);
            if (pfVarZ != null) {
                pfVarZ.z(i, i2, i3, j);
                return;
            } else {
                this.g.z(i, i2, i3, j);
                return;
            }
        }
        this.g.z(i, i2, i3, j);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.wp
    public void z(int i, int i2, int i3, int i4) {
        if (com.ss.android.socialbase.downloader.pf.m.g()) {
            com.ss.android.socialbase.downloader.downloader.pf pfVarZ = wp.z(true);
            if (pfVarZ != null) {
                pfVarZ.z(i, i2, i3, i4);
                return;
            } else {
                this.g.z(i, i2, i3, i4);
                return;
            }
        }
        this.g.z(i, i2, i3, i4);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.wp
    public com.ss.android.socialbase.downloader.e.dl z(int i, int i2) {
        com.ss.android.socialbase.downloader.e.dl dlVarZ = this.z.z(i, i2);
        dl(dlVarZ);
        return dlVarZ;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.wp
    public boolean z(com.ss.android.socialbase.downloader.e.dl dlVar) {
        if (dlVar == null) {
            return false;
        }
        boolean z = this.z.z(dlVar);
        dl(dlVar);
        return z;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.wp
    public boolean gc(int i) {
        com.ss.android.socialbase.downloader.downloader.pf pfVarZ;
        try {
            if (com.ss.android.socialbase.downloader.pf.m.g() && (pfVarZ = wp.z(true)) != null) {
                pfVarZ.v(i);
            } else {
                this.g.gc(i);
            }
        } catch (SQLiteException e) {
            com.bytedance.sdk.component.utils.wp.z(e);
        }
        return this.z.gc(i);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.wp
    public boolean m(int i) {
        com.ss.android.socialbase.downloader.downloader.pf pfVarZ;
        if (com.ss.android.socialbase.downloader.pf.m.g() && (pfVarZ = wp.z(true)) != null) {
            pfVarZ.ls(i);
        } else {
            this.g.m(i);
        }
        return this.z.m(i);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.wp
    public void dl() {
        try {
            this.z.dl();
        } catch (SQLiteException e) {
            com.bytedance.sdk.component.utils.wp.z(e);
        }
        if (com.ss.android.socialbase.downloader.pf.m.g()) {
            com.ss.android.socialbase.downloader.downloader.pf pfVarZ = wp.z(true);
            if (pfVarZ != null) {
                pfVarZ.m();
                return;
            } else {
                this.g.dl();
                return;
            }
        }
        this.g.dl();
    }

    @Override // com.ss.android.socialbase.downloader.downloader.wp
    public com.ss.android.socialbase.downloader.e.dl z(int i, long j, String str, String str2) {
        com.ss.android.socialbase.downloader.e.dl dlVarZ = this.z.z(i, j, str, str2);
        dl(dlVarZ);
        return dlVarZ;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.wp
    public com.ss.android.socialbase.downloader.e.dl z(int i, long j) {
        com.ss.android.socialbase.downloader.e.dl dlVarZ = this.z.z(i, j);
        z(dlVarZ, false);
        return dlVarZ;
    }

    private void dl(com.ss.android.socialbase.downloader.e.dl dlVar) {
        z(dlVar, true);
    }

    private void z(com.ss.android.socialbase.downloader.e.dl dlVar, boolean z) {
        if (dlVar == null) {
            return;
        }
        if (!com.ss.android.socialbase.downloader.pf.m.g()) {
            this.g.z(dlVar);
            return;
        }
        if (z) {
            com.ss.android.socialbase.downloader.downloader.pf pfVarZ = wp.z(true);
            if (pfVarZ != null) {
                pfVarZ.dl(dlVar);
            } else {
                this.g.z(dlVar);
            }
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.wp
    public com.ss.android.socialbase.downloader.e.dl g(int i, long j) {
        com.ss.android.socialbase.downloader.e.dl dlVarG = this.z.g(i, j);
        g(i, (List<com.ss.android.socialbase.downloader.e.g>) null);
        return dlVarG;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.wp
    public com.ss.android.socialbase.downloader.e.dl gz(int i) {
        com.ss.android.socialbase.downloader.e.dl dlVarGz = this.z.gz(i);
        dl(dlVarGz);
        return dlVarGz;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.wp
    public com.ss.android.socialbase.downloader.e.dl dl(int i, long j) {
        com.ss.android.socialbase.downloader.e.dl dlVarDl = this.z.dl(i, j);
        g(i, (List<com.ss.android.socialbase.downloader.e.g>) null);
        return dlVarDl;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.wp
    public com.ss.android.socialbase.downloader.e.dl a(int i, long j) {
        com.ss.android.socialbase.downloader.e.dl dlVarA = this.z.a(i, j);
        g(i, (List<com.ss.android.socialbase.downloader.e.g>) null);
        return dlVarA;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.wp
    public com.ss.android.socialbase.downloader.e.dl fo(int i) {
        com.ss.android.socialbase.downloader.e.dl dlVarFo = this.z.fo(i);
        dl(dlVarFo);
        return dlVarFo;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.wp
    public com.ss.android.socialbase.downloader.e.dl uy(int i) {
        com.ss.android.socialbase.downloader.e.dl dlVarUy = this.z.uy(i);
        dl(dlVarUy);
        return dlVarUy;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.wp
    public void g(com.ss.android.socialbase.downloader.e.dl dlVar) {
        if (dlVar == null) {
            return;
        }
        this.z.z(dlVar);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.wp
    public void z(int i, List<com.ss.android.socialbase.downloader.e.g> list) {
        if (list == null || list.size() == 0) {
            return;
        }
        this.z.z(i, list);
        if (com.ss.android.socialbase.downloader.pf.m.dl()) {
            this.g.g(i, list);
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.wp
    public void g(int i, List<com.ss.android.socialbase.downloader.e.g> list) {
        try {
            z(this.z.g(i));
            if (list == null) {
                list = this.z.dl(i);
            }
            if (com.ss.android.socialbase.downloader.pf.m.g()) {
                com.ss.android.socialbase.downloader.downloader.pf pfVarZ = wp.z(true);
                if (pfVarZ != null) {
                    pfVarZ.g(i, list);
                    return;
                } else {
                    this.g.g(i, list);
                    return;
                }
            }
            this.g.g(i, list);
        } catch (Exception e) {
            com.bytedance.sdk.component.utils.wp.z(e);
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.wp
    public List<com.ss.android.socialbase.downloader.kb.fo> v(int i) {
        List<com.ss.android.socialbase.downloader.kb.fo> listV = this.z.v(i);
        return (listV == null || listV.size() == 0) ? this.g.v(i) : listV;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.wp
    public Map<Long, com.ss.android.socialbase.downloader.kb.fo> wp(int i) {
        Map<Long, com.ss.android.socialbase.downloader.kb.fo> mapWp = this.z.wp(i);
        if (mapWp != null && !mapWp.isEmpty()) {
            return mapWp;
        }
        Map<Long, com.ss.android.socialbase.downloader.kb.fo> mapWp2 = this.g.wp(i);
        this.z.z(i, mapWp2);
        return mapWp2;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.wp
    public boolean z(int i, Map<Long, com.ss.android.socialbase.downloader.kb.fo> map) {
        this.z.z(i, map);
        this.g.z(i, map);
        return false;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.wp
    public void i(int i) {
        this.z.i(i);
        this.g.i(i);
    }
}
