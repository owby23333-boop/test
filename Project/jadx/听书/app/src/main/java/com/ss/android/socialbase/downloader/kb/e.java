package com.ss.android.socialbase.downloader.kb;

import android.support.v4.media.session.PlaybackStateCompat;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes4.dex */
class e {
    private final com.ss.android.socialbase.downloader.e.dl dl;
    private final dl e;
    private final com.ss.android.socialbase.downloader.i.z gc;
    private com.ss.android.socialbase.downloader.gc.z gz;
    private final boolean i;
    private final boolean ls;
    private final com.ss.android.socialbase.downloader.v.m m;
    private long p;
    private final long pf;
    private final long v;
    private final List<wp> z = new LinkedList();
    private final List<wp> g = new ArrayList();
    private volatile boolean fo = false;
    private volatile boolean uy = false;
    private volatile boolean kb = false;
    private volatile long fv = 0;
    private volatile long js = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final com.ss.android.socialbase.downloader.downloader.wp f2097a = com.ss.android.socialbase.downloader.downloader.dl.io();
    private final com.ss.android.socialbase.downloader.z.z wp = com.ss.android.socialbase.downloader.z.z.z();

    private boolean z(long j, long j2) {
        return j > PlaybackStateCompat.ACTION_PREPARE_FROM_SEARCH && j2 > 500;
    }

    e(com.ss.android.socialbase.downloader.e.dl dlVar, com.ss.android.socialbase.downloader.v.m mVar, dl dlVar2) {
        this.dl = dlVar;
        this.m = mVar;
        this.e = dlVar2;
        com.ss.android.socialbase.downloader.i.z zVarZ = com.ss.android.socialbase.downloader.i.z.z(dlVar.e());
        this.gc = zVarZ;
        boolean z = zVarZ.z("sync_strategy", 0) == 1;
        this.i = z;
        if (z) {
            long jZ = zVarZ.z("sync_interval_ms_fg", 5000);
            long jZ2 = zVarZ.z("sync_interval_ms_bg", 1000);
            this.v = Math.max(jZ, 500L);
            this.pf = Math.max(jZ2, 500L);
        } else {
            this.v = 0L;
            this.pf = 0L;
        }
        this.ls = zVarZ.g("monitor_rw") == 1;
    }

    void z(wp wpVar) {
        synchronized (this) {
            this.z.add(wpVar);
        }
    }

    /*  JADX ERROR: Type inference failed with stack overflow
        jadx.core.utils.exceptions.JadxOverflowException
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:77)
        */
    void z(com.ss.android.socialbase.downloader.kb.a r31) throws com.ss.android.socialbase.downloader.gc.z {
        /*
            Method dump skipped, instruction units count: 1078
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ss.android.socialbase.downloader.kb.e.z(com.ss.android.socialbase.downloader.kb.a):void");
    }

    private void z(long j, boolean z) throws IOException {
        long j2 = j - this.js;
        if (this.i) {
            if (j2 <= (this.wp.g() ? this.v : this.pf)) {
                return;
            }
        } else {
            long jSf = this.dl.sf() - this.fv;
            if (!z && !z(jSf, j2)) {
                return;
            }
        }
        dl();
        this.js = j;
    }

    private void z(gc gcVar) {
        synchronized (this) {
            this.g.add((wp) gcVar);
        }
    }

    private void dl() throws IOException {
        boolean z;
        boolean z2 = this.ls;
        long jNanoTime = z2 ? System.nanoTime() : 0L;
        com.ss.android.socialbase.downloader.e.dl dlVar = this.dl;
        com.ss.android.socialbase.downloader.downloader.wp wpVar = this.f2097a;
        List<wp> list = this.z;
        List<wp> list2 = this.g;
        Map<Long, fo> mapWp = wpVar.wp(dlVar.e());
        if (mapWp == null) {
            mapWp = new HashMap<>(4);
        }
        synchronized (this) {
            z(list);
            try {
                g(list);
                z = true;
            } catch (Throwable th) {
                com.bytedance.sdk.component.utils.wp.z(th);
                z = false;
            }
            z(list, mapWp);
            if (list2.size() > 0) {
                dl(list2);
                list.removeAll(list2);
                list2.clear();
            }
        }
        if (z) {
            dlVar.e(true);
            wpVar.z(dlVar.e(), mapWp);
            wpVar.z(dlVar);
            this.fv = dlVar.sf();
        }
        if (z2) {
            this.p += System.nanoTime() - jNanoTime;
        }
    }

    private void z(List<wp> list) throws IOException {
        Iterator<wp> it = list.iterator();
        while (it.hasNext()) {
            it.next().g();
        }
    }

    private void g(List<wp> list) throws IOException {
        Iterator<wp> it = list.iterator();
        while (it.hasNext()) {
            it.next().dl();
        }
    }

    private void dl(List<wp> list) {
        Iterator<wp> it = list.iterator();
        while (it.hasNext()) {
            it.next().a();
        }
    }

    private void z(List<wp> list, Map<Long, fo> map) {
        Iterator<wp> it = list.iterator();
        while (it.hasNext()) {
            fo foVarGc = it.next().gc();
            fo foVar = map.get(Long.valueOf(foVarGc.dl()));
            if (foVar == null) {
                map.put(Long.valueOf(foVarGc.dl()), new fo(foVarGc));
            } else {
                foVar.z(foVarGc.a());
                foVar.dl(foVarGc.m());
            }
        }
    }

    public void z() {
        this.kb = true;
        this.fo = true;
    }

    public void g() {
        this.uy = true;
        this.fo = true;
    }
}
