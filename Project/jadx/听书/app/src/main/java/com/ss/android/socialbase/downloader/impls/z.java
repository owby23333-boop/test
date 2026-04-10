package com.ss.android.socialbase.downloader.impls;

import android.database.sqlite.SQLiteException;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.SparseArray;
import com.ss.android.socialbase.downloader.a.gk;
import com.ss.android.socialbase.downloader.a.hh;
import com.ss.android.socialbase.downloader.a.q;
import com.ss.android.socialbase.downloader.a.un;
import com.ss.android.socialbase.downloader.downloader.js;
import com.ss.android.socialbase.downloader.v.gz;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.LinkedBlockingDeque;

/* JADX INFO: loaded from: classes4.dex */
public abstract class z implements gz.z {
    private final SparseArray<com.ss.android.socialbase.downloader.e.a> g = new SparseArray<>();
    private final SparseArray<com.ss.android.socialbase.downloader.e.a> dl = new SparseArray<>();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final SparseArray<com.ss.android.socialbase.downloader.e.a> f2095a = new SparseArray<>();
    private final SparseArray<com.ss.android.socialbase.downloader.e.a> gc = new SparseArray<>();
    private final SparseArray<com.ss.android.socialbase.downloader.e.a> m = new SparseArray<>();
    private final SparseArray<SparseArray<com.ss.android.socialbase.downloader.e.a>> e = new SparseArray<>();
    private final com.ss.android.socialbase.downloader.pf.gz<Integer, com.ss.android.socialbase.downloader.e.a> gz = new com.ss.android.socialbase.downloader.pf.gz<>();
    private final SparseArray<Long> fo = new SparseArray<>();
    private final LinkedBlockingDeque<com.ss.android.socialbase.downloader.e.a> uy = new LinkedBlockingDeque<>();
    protected final com.ss.android.socialbase.downloader.v.gz z = new com.ss.android.socialbase.downloader.v.gz(Looper.getMainLooper(), this);
    private final com.ss.android.socialbase.downloader.downloader.wp kb = com.ss.android.socialbase.downloader.downloader.dl.io();

    protected abstract com.ss.android.socialbase.downloader.v.dl dl(int i);

    protected abstract void g(int i);

    protected abstract List<Integer> z();

    public abstract void z(int i, long j);

    protected abstract void z(int i, com.ss.android.socialbase.downloader.e.a aVar);

    public abstract void z(com.ss.android.socialbase.downloader.v.dl dlVar);

    public abstract boolean z(int i);

    protected z() {
    }

    private void g(com.ss.android.socialbase.downloader.e.a aVar) {
        int iWp = aVar.wp();
        if (iWp == 0 && aVar.i()) {
            iWp = aVar.js();
        }
        if (iWp == 0) {
            return;
        }
        SparseArray<com.ss.android.socialbase.downloader.e.a> sparseArray = this.e.get(aVar.p());
        if (sparseArray == null) {
            sparseArray = new SparseArray<>();
            this.e.put(aVar.p(), sparseArray);
        }
        com.ss.android.socialbase.downloader.m.z.g("AbsDownloadEngine", "tryCacheSameTaskWithListenerHashCode id:" + aVar.p() + " listener hasCode:" + iWp);
        sparseArray.put(iWp, aVar);
    }

    private void z(com.ss.android.socialbase.downloader.e.a aVar, boolean z) {
        com.ss.android.socialbase.downloader.e.dl dlVarZ;
        int iP;
        com.ss.android.socialbase.downloader.e.dl dlVarZ2;
        com.ss.android.socialbase.downloader.e.a aVar2;
        if (aVar == null || (dlVarZ = aVar.z()) == null) {
            return;
        }
        if (dlVarZ.pc()) {
            com.ss.android.socialbase.downloader.gz.z.z(aVar.gc(), dlVarZ, new com.ss.android.socialbase.downloader.gc.z(1003, "downloadInfo is Invalid, url is " + dlVarZ.uy() + " name is " + dlVarZ.gz() + " savePath is " + dlVarZ.kb()), dlVarZ.p());
            return;
        }
        boolean z2 = false;
        if (com.ss.android.socialbase.downloader.i.z.z(dlVarZ.e()).z("no_net_opt", 0) == 1 && !com.ss.android.socialbase.downloader.pf.m.dl(com.ss.android.socialbase.downloader.downloader.dl.xl()) && !dlVarZ.ey()) {
            new com.ss.android.socialbase.downloader.downloader.m(aVar, this.z).z(new com.ss.android.socialbase.downloader.gc.z(1049, "network_not_available"));
            return;
        }
        int iE = dlVarZ.e();
        if (z) {
            z(dlVarZ);
        }
        if (this.f2095a.get(iE) != null) {
            this.f2095a.remove(iE);
        }
        if (this.dl.get(iE) != null) {
            this.dl.remove(iE);
        }
        if (this.gc.get(iE) != null) {
            this.gc.remove(iE);
        }
        if (this.m.get(iE) != null) {
            this.m.remove(iE);
        }
        if (z(iE) && !dlVarZ.jz()) {
            com.ss.android.socialbase.downloader.m.z.g("AbsDownloadEngine", "another task with same id is downloading when tryDownload");
            aVar.fv();
            com.ss.android.socialbase.downloader.gz.z.z(aVar.gc(), dlVarZ, new com.ss.android.socialbase.downloader.gc.z(1003, "downloadInfo is isDownloading and addListenerToSameTask is false"), dlVarZ.p());
            return;
        }
        com.ss.android.socialbase.downloader.m.z.g("AbsDownloadEngine", "no downloading task :".concat(String.valueOf(iE)));
        if (dlVarZ.jz()) {
            dlVarZ.z(com.ss.android.socialbase.downloader.g.z.ASYNC_HANDLE_RESTART);
        }
        if (com.ss.android.socialbase.downloader.pf.z.z(32768) && (aVar2 = (com.ss.android.socialbase.downloader.e.a) this.gz.remove(Integer.valueOf(iE))) != null) {
            aVar.z(aVar2);
        }
        long jUptimeMillis = SystemClock.uptimeMillis();
        com.ss.android.socialbase.downloader.e.a aVar3 = this.g.get(iE);
        if (aVar3 == null || (dlVarZ2 = aVar3.z()) == null) {
            iP = 0;
        } else {
            iP = dlVarZ2.p();
            if (com.ss.android.socialbase.downloader.g.m.g(iP)) {
                z2 = true;
            }
        }
        com.ss.android.socialbase.downloader.m.z.g("AbsDownloadEngine", "can add listener " + z2 + " , oldTaskStatus is :" + iP);
        if (z2) {
            aVar.fv();
            return;
        }
        g(aVar);
        this.g.put(iE, aVar);
        this.fo.put(iE, Long.valueOf(jUptimeMillis));
        z(iE, aVar);
    }

    public synchronized void z(com.ss.android.socialbase.downloader.e.a aVar) {
        if (aVar == null) {
            return;
        }
        com.ss.android.socialbase.downloader.e.dl dlVarZ = aVar.z();
        if (dlVarZ == null) {
            return;
        }
        dlVarZ.gc(false);
        if (dlVarZ.fv() != com.ss.android.socialbase.downloader.g.e.ENQUEUE_NONE) {
            dl(aVar);
        } else {
            z(aVar, true);
        }
    }

    private void dl(com.ss.android.socialbase.downloader.e.a aVar) {
        com.ss.android.socialbase.downloader.e.dl dlVarZ;
        if (aVar == null || (dlVarZ = aVar.z()) == null) {
            return;
        }
        try {
            if (this.uy.isEmpty()) {
                z(aVar, true);
                this.uy.put(aVar);
                return;
            }
            if (dlVarZ.fv() == com.ss.android.socialbase.downloader.g.e.ENQUEUE_TAIL) {
                if (this.uy.getFirst().p() == aVar.p() && z(aVar.p())) {
                    return;
                }
                Iterator<com.ss.android.socialbase.downloader.e.a> it = this.uy.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    com.ss.android.socialbase.downloader.e.a next = it.next();
                    if (next != null && next.p() == aVar.p()) {
                        it.remove();
                        break;
                    }
                }
                this.uy.put(aVar);
                new com.ss.android.socialbase.downloader.downloader.m(aVar, this.z).z();
                return;
            }
            com.ss.android.socialbase.downloader.e.a first = this.uy.getFirst();
            if (first.p() == aVar.p() && z(aVar.p())) {
                return;
            }
            gc(first.p());
            z(aVar, true);
            if (first.p() != aVar.p()) {
                this.uy.putFirst(aVar);
            }
        } catch (InterruptedException unused) {
        }
    }

    public synchronized com.ss.android.socialbase.downloader.e.dl a(int i) {
        com.ss.android.socialbase.downloader.e.dl dlVarG;
        com.ss.android.socialbase.downloader.e.a aVar;
        dlVarG = this.kb.g(i);
        if (dlVarG == null && (aVar = this.g.get(i)) != null) {
            dlVarG = aVar.z();
        }
        return dlVarG;
    }

    public synchronized List<com.ss.android.socialbase.downloader.e.dl> z(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        List<com.ss.android.socialbase.downloader.e.dl> listZ = this.kb.z(str);
        if (listZ != null && !listZ.isEmpty()) {
            return listZ;
        }
        ArrayList arrayList = new ArrayList();
        int size = this.g.size();
        for (int i = 0; i < size; i++) {
            com.ss.android.socialbase.downloader.e.a aVarValueAt = this.g.valueAt(i);
            if (aVarValueAt != null && aVarValueAt.z() != null && str.equals(aVarValueAt.z().uy())) {
                arrayList.add(aVarValueAt.z());
            }
        }
        return arrayList;
    }

    public synchronized boolean gc(int i) {
        com.ss.android.socialbase.downloader.m.z.g("AbsDownloadEngine", "pause id=".concat(String.valueOf(i)));
        com.ss.android.socialbase.downloader.e.dl dlVarG = this.kb.g(i);
        if (dlVarG != null && dlVarG.p() == 11) {
            return false;
        }
        synchronized (this.g) {
            g(i);
        }
        if (dlVarG == null) {
            com.ss.android.socialbase.downloader.e.a aVar = this.g.get(i);
            if (aVar != null) {
                new com.ss.android.socialbase.downloader.downloader.m(aVar, this.z).a();
                return true;
            }
        } else {
            z(dlVarG);
            if (dlVarG.p() == 1) {
                com.ss.android.socialbase.downloader.e.a aVar2 = this.g.get(i);
                if (aVar2 != null) {
                    new com.ss.android.socialbase.downloader.downloader.m(aVar2, this.z).a();
                    return true;
                }
            } else if (com.ss.android.socialbase.downloader.g.m.g(dlVarG.p())) {
                dlVarG.a(-2);
                return true;
            }
        }
        return false;
    }

    public synchronized boolean z(int i, boolean z) {
        com.ss.android.socialbase.downloader.e.a aVarPf = this.g.get(i);
        if (aVarPf == null && com.ss.android.socialbase.downloader.pf.z.z(65536)) {
            aVarPf = pf(i);
        }
        if (aVarPf != null) {
            if (!com.ss.android.socialbase.downloader.i.z.z(i).g("fix_on_cancel_call_twice", true)) {
                new com.ss.android.socialbase.downloader.downloader.m(aVarPf, this.z).dl();
            }
            final com.ss.android.socialbase.downloader.e.dl dlVarZ = aVarPf.z();
            final SparseArray<hh> sparseArrayZ = aVarPf.z(com.ss.android.socialbase.downloader.g.gz.MAIN);
            final SparseArray<hh> sparseArrayZ2 = aVarPf.z(com.ss.android.socialbase.downloader.g.gz.NOTIFICATION);
            this.z.post(new Runnable() { // from class: com.ss.android.socialbase.downloader.impls.z.1
                @Override // java.lang.Runnable
                public void run() {
                    SparseArray sparseArray;
                    SparseArray sparseArray2 = sparseArrayZ;
                    if (sparseArray2 != null) {
                        synchronized (sparseArray2) {
                            for (int i2 = 0; i2 < sparseArrayZ.size(); i2++) {
                                hh hhVar = (hh) sparseArrayZ.get(sparseArrayZ.keyAt(i2));
                                if (hhVar != null) {
                                    hhVar.m(dlVarZ);
                                }
                            }
                        }
                    }
                    com.ss.android.socialbase.downloader.e.dl dlVar = dlVarZ;
                    if (dlVar == null || !dlVar.k() || (sparseArray = sparseArrayZ2) == null) {
                        return;
                    }
                    synchronized (sparseArray) {
                        for (int i3 = 0; i3 < sparseArrayZ2.size(); i3++) {
                            hh hhVar2 = (hh) sparseArrayZ2.get(sparseArrayZ2.keyAt(i3));
                            if (hhVar2 != null) {
                                hhVar2.m(dlVarZ);
                            }
                        }
                    }
                }
            });
        }
        com.ss.android.socialbase.downloader.e.dl dlVarG = this.kb.g(i);
        if (com.ss.android.socialbase.downloader.pf.z.z(65536)) {
            if (dlVarG != null) {
                dlVarG.a(-4);
            }
        } else if (dlVarG != null && com.ss.android.socialbase.downloader.g.m.g(dlVarG.p())) {
            dlVarG.a(-4);
        }
        g(i, z);
        return true;
    }

    public synchronized boolean m(int i) {
        com.ss.android.socialbase.downloader.e.a aVar = this.g.get(i);
        if (aVar != null) {
            com.ss.android.socialbase.downloader.e.dl dlVarZ = aVar.z();
            if (dlVarZ != null) {
                dlVarZ.gc(false);
            }
            z(aVar);
        } else {
            e(i);
        }
        return true;
    }

    public synchronized boolean e(int i) {
        com.ss.android.socialbase.downloader.e.a aVar = this.f2095a.get(i);
        if (aVar == null) {
            aVar = this.gc.get(i);
        }
        if (aVar == null) {
            return false;
        }
        com.ss.android.socialbase.downloader.e.dl dlVarZ = aVar.z();
        if (dlVarZ != null) {
            dlVarZ.gc(false);
        }
        z(aVar);
        return true;
    }

    private void z(com.ss.android.socialbase.downloader.e.dl dlVar) {
        if (dlVar != null) {
            try {
                if (dlVar.p() == 7 || dlVar.fp() != com.ss.android.socialbase.downloader.g.fo.DELAY_RETRY_NONE) {
                    dlVar.a(5);
                    dlVar.z(com.ss.android.socialbase.downloader.g.fo.DELAY_RETRY_NONE);
                    com.ss.android.socialbase.downloader.m.z.g("AbsDownloadEngine", "cancelAlarm");
                }
            } catch (Throwable th) {
                com.bytedance.sdk.component.utils.wp.z(th);
            }
        }
    }

    public synchronized void z(int i, gk gkVar) {
        com.ss.android.socialbase.downloader.e.a aVar = this.g.get(i);
        if (aVar != null) {
            aVar.g(gkVar);
        }
    }

    public synchronized un gz(int i) {
        com.ss.android.socialbase.downloader.e.a aVar = this.g.get(i);
        if (aVar != null) {
            return aVar.kb();
        }
        com.ss.android.socialbase.downloader.e.a aVar2 = this.dl.get(i);
        if (aVar2 != null) {
            return aVar2.kb();
        }
        com.ss.android.socialbase.downloader.e.a aVar3 = this.f2095a.get(i);
        if (aVar3 != null) {
            return aVar3.kb();
        }
        com.ss.android.socialbase.downloader.e.a aVar4 = this.gc.get(i);
        if (aVar4 != null) {
            return aVar4.kb();
        }
        com.ss.android.socialbase.downloader.e.a aVar5 = this.m.get(i);
        if (aVar5 == null) {
            return null;
        }
        return aVar5.kb();
    }

    public synchronized gk fo(int i) {
        com.ss.android.socialbase.downloader.e.a aVar = this.g.get(i);
        if (aVar != null) {
            return aVar.uy();
        }
        com.ss.android.socialbase.downloader.e.a aVar2 = this.dl.get(i);
        if (aVar2 != null) {
            return aVar2.uy();
        }
        com.ss.android.socialbase.downloader.e.a aVar3 = this.f2095a.get(i);
        if (aVar3 != null) {
            return aVar3.uy();
        }
        com.ss.android.socialbase.downloader.e.a aVar4 = this.gc.get(i);
        if (aVar4 != null) {
            return aVar4.uy();
        }
        com.ss.android.socialbase.downloader.e.a aVar5 = this.m.get(i);
        if (aVar5 == null) {
            return null;
        }
        return aVar5.uy();
    }

    public synchronized q uy(int i) {
        com.ss.android.socialbase.downloader.e.a aVar = this.g.get(i);
        if (aVar != null) {
            return aVar.v();
        }
        com.ss.android.socialbase.downloader.e.a aVar2 = this.dl.get(i);
        if (aVar2 != null) {
            return aVar2.v();
        }
        com.ss.android.socialbase.downloader.e.a aVar3 = this.f2095a.get(i);
        if (aVar3 != null) {
            return aVar3.v();
        }
        com.ss.android.socialbase.downloader.e.a aVar4 = this.gc.get(i);
        if (aVar4 != null) {
            return aVar4.v();
        }
        com.ss.android.socialbase.downloader.e.a aVar5 = this.m.get(i);
        if (aVar5 == null) {
            return null;
        }
        return aVar5.v();
    }

    public synchronized boolean kb(int i) {
        com.ss.android.socialbase.downloader.e.dl dlVarZ;
        com.ss.android.socialbase.downloader.e.a aVar = this.gc.get(i);
        if (aVar != null && (dlVarZ = aVar.z()) != null) {
            if (dlVarZ.mn()) {
                z(aVar, false);
            }
            return true;
        }
        com.ss.android.socialbase.downloader.e.dl dlVarG = this.kb.g(i);
        if (dlVarG != null && dlVarG.mn()) {
            z(new com.ss.android.socialbase.downloader.e.a(dlVarG), false);
        }
        return false;
    }

    public synchronized boolean wp(int i) {
        com.ss.android.socialbase.downloader.e.dl dlVarZ;
        com.ss.android.socialbase.downloader.e.a aVar = this.m.get(i);
        if (aVar == null || (dlVarZ = aVar.z()) == null) {
            return false;
        }
        if (dlVarZ.jz()) {
            z(aVar);
        }
        return true;
    }

    public synchronized void z(List<String> list) {
        com.ss.android.socialbase.downloader.e.dl dlVarZ;
        try {
            boolean zG = com.ss.android.socialbase.downloader.pf.z.z(1048576) ? com.ss.android.socialbase.downloader.pf.m.g(com.ss.android.socialbase.downloader.downloader.dl.xl()) : true;
            for (int i = 0; i < this.f2095a.size(); i++) {
                com.ss.android.socialbase.downloader.e.a aVar = this.f2095a.get(this.f2095a.keyAt(i));
                if (aVar != null && (dlVarZ = aVar.z()) != null && dlVarZ.yt() != null && list.contains(dlVarZ.yt()) && (!dlVarZ.io() || zG)) {
                    dlVarZ.g(true);
                    dlVarZ.dl(true);
                    z(aVar);
                }
            }
        } catch (Exception e) {
            com.bytedance.sdk.component.utils.wp.z(e);
        }
    }

    public synchronized void g(List<String> list) {
        com.ss.android.socialbase.downloader.e.dl dlVarZ;
        try {
            if (com.ss.android.socialbase.downloader.pf.m.g(com.ss.android.socialbase.downloader.downloader.dl.xl())) {
                for (int i = 0; i < this.g.size(); i++) {
                    com.ss.android.socialbase.downloader.e.a aVar = this.g.get(this.g.keyAt(i));
                    if (aVar != null && (dlVarZ = aVar.z()) != null && dlVarZ.yt() != null && list.contains(dlVarZ.yt()) && g(dlVarZ)) {
                        dlVarZ.g(true);
                        dlVarZ.dl(true);
                        z(aVar);
                        dlVarZ.gc(true);
                        js jsVarG = com.ss.android.socialbase.downloader.downloader.e.g(com.ss.android.socialbase.downloader.downloader.dl.xl()).g();
                        if (jsVarG != null) {
                            jsVarG.z(dlVarZ, 5, 2);
                        }
                    }
                }
                return;
            }
            return;
        } catch (Exception e) {
            com.bytedance.sdk.component.utils.wp.z(e);
        }
    }

    private boolean g(com.ss.android.socialbase.downloader.e.dl dlVar) {
        if (dlVar != null && dlVar.f()) {
            return dlVar.jq();
        }
        return false;
    }

    public void g() {
        List<Integer> listZ = z();
        if (listZ == null) {
            return;
        }
        Iterator<Integer> it = listZ.iterator();
        while (it.hasNext()) {
            gc(it.next().intValue());
        }
    }

    public void g(final int i, final boolean z) {
        com.ss.android.socialbase.downloader.e.dl dlVarG = this.kb.g(i);
        if (dlVarG != null) {
            z(dlVarG);
        }
        this.z.post(new Runnable() { // from class: com.ss.android.socialbase.downloader.impls.z.2
            @Override // java.lang.Runnable
            public void run() {
                com.ss.android.socialbase.downloader.notification.g.z().m(i);
            }
        });
        com.ss.android.socialbase.downloader.downloader.dl.z(new Runnable() { // from class: com.ss.android.socialbase.downloader.impls.z.3
            @Override // java.lang.Runnable
            public void run() {
                com.ss.android.socialbase.downloader.e.a aVarPf;
                if (z.this.dl(i) == null && (aVarPf = z.this.pf(i)) != null) {
                    com.ss.android.socialbase.downloader.e.dl dlVarZ = aVarPf.z();
                    SparseArray<hh> sparseArrayZ = aVarPf.z(com.ss.android.socialbase.downloader.g.gz.SUB);
                    if (sparseArrayZ != null) {
                        synchronized (sparseArrayZ) {
                            for (int i2 = 0; i2 < sparseArrayZ.size(); i2++) {
                                hh hhVar = sparseArrayZ.get(sparseArrayZ.keyAt(i2));
                                if (hhVar != null) {
                                    hhVar.m(dlVarZ);
                                }
                            }
                        }
                    }
                }
                z.this.a(i, z);
            }
        }, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void a(int i, boolean z) {
        com.ss.android.socialbase.downloader.m.z.g("AbsDownloadEngine", "clearDownloadDataInSubThread::id=" + i + " deleteTargetFile=" + z);
        try {
            com.ss.android.socialbase.downloader.e.dl dlVarG = this.kb.g(i);
            if (dlVarG != null) {
                if (z) {
                    com.ss.android.socialbase.downloader.pf.m.z(dlVarG);
                } else {
                    com.ss.android.socialbase.downloader.pf.m.dl(dlVarG.wp(), dlVarG.i());
                }
                dlVarG.ou();
            }
            try {
                this.kb.m(i);
            } catch (SQLiteException e) {
                com.bytedance.sdk.component.utils.wp.z(e);
            }
            z(i, 0, -4);
            if (this.f2095a.get(i) != null) {
                this.f2095a.remove(i);
            }
            if (this.dl.get(i) != null) {
                this.dl.remove(i);
            }
            this.gz.remove(Integer.valueOf(i));
            com.ss.android.socialbase.downloader.i.z.g(i);
        } catch (Throwable th) {
            com.bytedance.sdk.component.utils.wp.z(th);
        }
    }

    public void dl(final int i, final boolean z) {
        com.ss.android.socialbase.downloader.e.dl dlVarG = this.kb.g(i);
        if (dlVarG != null) {
            z(dlVarG);
        }
        this.z.post(new Runnable() { // from class: com.ss.android.socialbase.downloader.impls.z.4
            @Override // java.lang.Runnable
            public void run() {
                com.ss.android.socialbase.downloader.notification.g.z().m(i);
            }
        });
        com.ss.android.socialbase.downloader.downloader.dl.z(new Runnable() { // from class: com.ss.android.socialbase.downloader.impls.z.5
            @Override // java.lang.Runnable
            public void run() {
                z.this.dl(i);
                z.this.gc(i, z);
            }
        }, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void gc(int i, boolean z) {
        try {
            com.ss.android.socialbase.downloader.e.dl dlVarG = this.kb.g(i);
            if (dlVarG != null) {
                com.ss.android.socialbase.downloader.pf.m.z(dlVarG, z);
                dlVarG.ou();
            }
            try {
                this.kb.a(i);
                this.kb.z(dlVarG);
            } catch (SQLiteException e) {
                com.bytedance.sdk.component.utils.wp.z(e);
            }
            if (this.f2095a.get(i) != null) {
                this.f2095a.remove(i);
            }
            if (this.dl.get(i) != null) {
                this.dl.remove(i);
            }
            this.gz.remove(Integer.valueOf(i));
            com.ss.android.socialbase.downloader.i.z.g(i);
        } catch (Throwable th) {
            com.bytedance.sdk.component.utils.wp.z(th);
        }
    }

    public synchronized void i(int i) {
        com.ss.android.socialbase.downloader.e.dl dlVarZ;
        com.ss.android.socialbase.downloader.e.a aVar = this.g.get(i);
        if (aVar != null && (dlVarZ = aVar.z()) != null) {
            dlVarZ.wp(true);
            z(aVar);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:7:0x0011, code lost:
    
        if (r1.f2095a.get(r2) != null) goto L8;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public synchronized boolean v(int r2) {
        /*
            r1 = this;
            monitor-enter(r1)
            if (r2 == 0) goto L19
            android.util.SparseArray<com.ss.android.socialbase.downloader.e.a> r0 = r1.g     // Catch: java.lang.Throwable -> L16
            java.lang.Object r0 = r0.get(r2)     // Catch: java.lang.Throwable -> L16
            if (r0 != 0) goto L13
            android.util.SparseArray<com.ss.android.socialbase.downloader.e.a> r0 = r1.f2095a     // Catch: java.lang.Throwable -> L16
            java.lang.Object r2 = r0.get(r2)     // Catch: java.lang.Throwable -> L16
            if (r2 == 0) goto L19
        L13:
            monitor-exit(r1)
            r2 = 1
            return r2
        L16:
            r2 = move-exception
            monitor-exit(r1)
            throw r2
        L19:
            monitor-exit(r1)
            r2 = 0
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ss.android.socialbase.downloader.impls.z.v(int):boolean");
    }

    public synchronized void z(int i, int i2, hh hhVar, com.ss.android.socialbase.downloader.g.gz gzVar, boolean z) {
        com.ss.android.socialbase.downloader.e.a aVarPf = pf(i);
        if (aVarPf == null) {
            aVarPf = this.gz.get(Integer.valueOf(i));
        }
        if (aVarPf != null) {
            aVarPf.z(i2, hhVar, gzVar, z);
        }
    }

    public synchronized void g(int i, int i2, hh hhVar, com.ss.android.socialbase.downloader.g.gz gzVar, boolean z) {
        z(i, i2, hhVar, gzVar, z, true);
    }

    public synchronized void z(int i, int i2, final hh hhVar, com.ss.android.socialbase.downloader.g.gz gzVar, boolean z, boolean z2) {
        com.ss.android.socialbase.downloader.e.dl dlVarG;
        com.ss.android.socialbase.downloader.e.a aVarPf = pf(i);
        if (aVarPf != null) {
            aVarPf.g(i2, hhVar, gzVar, z);
            final com.ss.android.socialbase.downloader.e.dl dlVarZ = aVarPf.z();
            if (z2 && dlVarZ != null && !z(i) && (gzVar == com.ss.android.socialbase.downloader.g.gz.MAIN || gzVar == com.ss.android.socialbase.downloader.g.gz.NOTIFICATION)) {
                if (gzVar != com.ss.android.socialbase.downloader.g.gz.NOTIFICATION || dlVarZ.k()) {
                    this.z.post(new Runnable() { // from class: com.ss.android.socialbase.downloader.impls.z.6
                        @Override // java.lang.Runnable
                        public void run() {
                            if (hhVar != null) {
                                if (dlVarZ.p() == -3) {
                                    hhVar.gc(dlVarZ);
                                } else if (dlVarZ.p() == -1) {
                                    hhVar.z(dlVarZ, new com.ss.android.socialbase.downloader.gc.z(1000, "try add listener for failed task"));
                                }
                            }
                        }
                    });
                }
            }
            return;
        }
        if (com.ss.android.socialbase.downloader.pf.z.z(32768) && (dlVarG = this.kb.g(i)) != null && dlVarG.p() != -3) {
            com.ss.android.socialbase.downloader.e.a aVar = this.gz.get(Integer.valueOf(i));
            if (aVar == null) {
                aVar = new com.ss.android.socialbase.downloader.e.a(dlVarG);
                this.gz.put(Integer.valueOf(i), aVar);
            }
            aVar.g(i2, hhVar, gzVar, z);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public com.ss.android.socialbase.downloader.e.a pf(int i) {
        com.ss.android.socialbase.downloader.e.a aVar = this.g.get(i);
        if (aVar != null) {
            return aVar;
        }
        com.ss.android.socialbase.downloader.e.a aVar2 = this.f2095a.get(i);
        if (aVar2 != null) {
            return aVar2;
        }
        com.ss.android.socialbase.downloader.e.a aVar3 = this.dl.get(i);
        if (aVar3 != null) {
            return aVar3;
        }
        com.ss.android.socialbase.downloader.e.a aVar4 = this.gc.get(i);
        return aVar4 == null ? this.m.get(i) : aVar4;
    }

    public List<com.ss.android.socialbase.downloader.e.dl> g(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        Iterator<Integer> it = z().iterator();
        ArrayList arrayList = new ArrayList();
        while (it.hasNext()) {
            com.ss.android.socialbase.downloader.e.dl dlVarA = a(it.next().intValue());
            if (dlVarA != null && str.equals(dlVarA.yt())) {
                arrayList.add(dlVarA);
            }
        }
        return arrayList;
    }

    private void z(int i, com.ss.android.socialbase.downloader.gc.z zVar, com.ss.android.socialbase.downloader.e.a aVar) {
        if (aVar != null) {
            com.ss.android.socialbase.downloader.e.dl dlVarZ = aVar.z();
            SparseArray<hh> sparseArrayZ = aVar.z(com.ss.android.socialbase.downloader.g.gz.MAIN);
            SparseArray<hh> sparseArrayZ2 = aVar.z(com.ss.android.socialbase.downloader.g.gz.NOTIFICATION);
            boolean z = aVar.pf() || dlVarZ.cb();
            com.ss.android.socialbase.downloader.pf.dl.z(i, sparseArrayZ, true, dlVarZ, zVar);
            com.ss.android.socialbase.downloader.pf.dl.z(i, sparseArrayZ2, z, dlVarZ, zVar);
        }
    }

    private void ls(int i) {
        com.ss.android.socialbase.downloader.e.a first;
        if (this.uy.isEmpty()) {
            return;
        }
        com.ss.android.socialbase.downloader.e.a first2 = this.uy.getFirst();
        if (first2 != null && first2.p() == i) {
            this.uy.poll();
        }
        if (this.uy.isEmpty() || (first = this.uy.getFirst()) == null) {
            return;
        }
        z(first, true);
    }

    private void z(int i, int i2) {
        com.ss.android.socialbase.downloader.m.z.g("AbsDownloadEngine", "removeTask id: " + i + " listener hasCode: " + i2);
        if (i2 == 0) {
            this.g.remove(i);
            this.e.remove(i);
            return;
        }
        SparseArray<com.ss.android.socialbase.downloader.e.a> sparseArray = this.e.get(i);
        if (sparseArray != null) {
            sparseArray.remove(i2);
            com.ss.android.socialbase.downloader.m.z.g("AbsDownloadEngine", "after downloadTaskWithListenerMap removeTask taskArray.size: " + sparseArray.size());
            if (sparseArray.size() == 0) {
                this.g.remove(i);
                this.e.remove(i);
                return;
            }
            return;
        }
        this.g.remove(i);
    }

    public synchronized void z(int i, int i2, int i3) {
        if (i3 != -7) {
            if (i3 == -6) {
                this.dl.put(i, this.g.get(i));
                z(i, i2);
                return;
            }
            if (i3 == -4) {
                z(i, i2);
            } else if (i3 == -3) {
                this.dl.put(i, this.g.get(i));
                z(i, i2);
            } else if (i3 != -1) {
                if (i3 != 7) {
                    if (i3 == 8) {
                        com.ss.android.socialbase.downloader.e.a aVar = this.g.get(i);
                        if (aVar != null && this.m.get(i) == null) {
                            this.m.put(i, aVar);
                        }
                    }
                    return;
                }
                com.ss.android.socialbase.downloader.e.a aVar2 = this.g.get(i);
                if (aVar2 != null) {
                    if (this.gc.get(i) == null) {
                        this.gc.put(i, aVar2);
                    }
                    z(i, i2);
                }
                ls(i);
                return;
            }
            ls(i);
            return;
        }
        com.ss.android.socialbase.downloader.e.a aVar3 = this.g.get(i);
        if (aVar3 != null) {
            if (this.f2095a.get(i) == null) {
                this.f2095a.put(i, aVar3);
            }
            z(i, i2);
        }
        ls(i);
    }

    @Override // com.ss.android.socialbase.downloader.v.gz.z
    public void z(Message message) {
        int i = message.arg1;
        int i2 = message.arg2;
        com.ss.android.socialbase.downloader.m.z.g("AbsDownloadEngine", "handleMsg id: " + i + " listener hasCode: " + i2);
        com.ss.android.socialbase.downloader.e.a aVar = null;
        com.ss.android.socialbase.downloader.gc.z zVar = message.obj instanceof Exception ? (com.ss.android.socialbase.downloader.gc.z) message.obj : null;
        synchronized (this) {
            if (i2 == 0) {
                aVar = this.g.get(i);
            } else {
                SparseArray<com.ss.android.socialbase.downloader.e.a> sparseArray = this.e.get(i);
                if (sparseArray != null) {
                    aVar = sparseArray.get(i2);
                }
            }
            if (aVar == null) {
                return;
            }
            z(message.what, zVar, aVar);
            z(i, i2, message.what);
        }
    }

    public void g(int i, long j) {
        com.ss.android.socialbase.downloader.e.dl dlVarG = this.kb.g(i);
        if (dlVarG != null) {
            dlVarG.kb(j);
        }
        z(i, j);
    }
}
