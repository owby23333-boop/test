package com.ss.android.socialbase.downloader.kb;

import android.text.TextUtils;
import androidx.media3.exoplayer.ExoPlayer;
import com.ss.android.socialbase.downloader.fo.dl;
import com.ss.android.socialbase.downloader.v.gc;
import java.net.InetAddress;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes4.dex */
public class kb implements dl.z, m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final com.ss.android.socialbase.downloader.v.m f2101a;
    private final g dl;
    private volatile boolean fv;
    private final v g;
    private final e gc;
    private int hh;
    private long i;
    private long io;
    private com.ss.android.socialbase.downloader.e.m kb;
    private final boolean l;
    private int ls;
    private com.ss.android.socialbase.downloader.gc.z p;
    private final com.ss.android.socialbase.downloader.v.gc q;
    private float sy;
    private final com.ss.android.socialbase.downloader.pf.gc tb;
    private long uf;
    private com.ss.android.socialbase.downloader.e.m uy;
    private final com.ss.android.socialbase.downloader.e.dl z;
    private long zw;
    private volatile boolean m = false;
    private volatile boolean e = false;
    private final List<i> gz = new ArrayList();
    private final List<p> fo = new ArrayList();
    private volatile boolean wp = true;
    private final LinkedList<fo> v = new LinkedList<>();
    private final List<fo> pf = new ArrayList();
    private final Object js = new Object();
    private volatile boolean iq = false;
    private final gc.g h = new gc.g() { // from class: com.ss.android.socialbase.downloader.kb.kb.1
        private int g;

        @Override // com.ss.android.socialbase.downloader.v.gc.g
        public long z() {
            if (kb.this.m || kb.this.e) {
                return -1L;
            }
            synchronized (kb.this) {
                if (kb.this.uy == null && kb.this.kb == null) {
                    long j = kb.this.zw;
                    if (j <= 0) {
                        return -1L;
                    }
                    this.g++;
                    i iVarZ = kb.this.z(false, System.currentTimeMillis(), j);
                    if (iVarZ == null) {
                        return j;
                    }
                    com.bytedance.sdk.component.utils.wp.z("SegmentDispatcher", "connectWatcher: switchUrl and reconnect");
                    kb.this.dl(iVarZ);
                    iVarZ.m();
                    return ((long) ((this.g / kb.this.fo.size()) + 1)) * j;
                }
                return -1L;
            }
        }
    };
    private final gc.g gk = new gc.g() { // from class: com.ss.android.socialbase.downloader.kb.kb.2
        @Override // com.ss.android.socialbase.downloader.v.gc.g
        public long z() {
            return kb.this.fv();
        }
    };

    public kb(com.ss.android.socialbase.downloader.e.dl dlVar, v vVar, com.ss.android.socialbase.downloader.v.m mVar) {
        this.z = dlVar;
        this.g = vVar;
        g gVar = new g(vVar.a(), vVar.gc());
        this.dl = gVar;
        this.f2101a = mVar;
        this.gc = new e(dlVar, mVar, gVar);
        this.q = new com.ss.android.socialbase.downloader.v.gc();
        this.tb = new com.ss.android.socialbase.downloader.pf.gc();
        this.l = com.ss.android.socialbase.downloader.i.z.z(dlVar.e()).g("debug") == 1;
    }

    public boolean z(List<fo> list) throws InterruptedException, com.ss.android.socialbase.downloader.gc.z {
        try {
            m();
            g(list);
            gc();
            e();
            fo();
            long jCurrentTimeMillis = System.currentTimeMillis();
            try {
                dl();
                long jCurrentTimeMillis2 = System.currentTimeMillis() - jCurrentTimeMillis;
                this.z.g(jCurrentTimeMillis2);
                this.z.z(jCurrentTimeMillis2);
                if (!this.e && !this.m) {
                    this.f2101a.z(this.i);
                    gz();
                    a();
                    return true;
                }
                if (!this.e && !this.m) {
                    com.ss.android.socialbase.downloader.m.z.dl("SegmentDispatcher", "finally pause");
                    g();
                }
                this.q.g();
                return true;
            } catch (Throwable th) {
                long jCurrentTimeMillis3 = System.currentTimeMillis() - jCurrentTimeMillis;
                this.z.g(jCurrentTimeMillis3);
                this.z.z(jCurrentTimeMillis3);
                throw th;
            }
        } finally {
            if (!this.e && !this.m) {
                com.ss.android.socialbase.downloader.m.z.dl("SegmentDispatcher", "finally pause");
                g();
            }
            this.q.g();
        }
    }

    private void g(List<fo> list) {
        long jS = this.z.s();
        this.i = jS;
        if (jS <= 0) {
            this.i = this.z.un();
            com.ss.android.socialbase.downloader.m.z.dl("SegmentDispatcher", "initSegments: getExpectFileLength = " + this.i);
        }
        synchronized (this) {
            this.v.clear();
            if (list == null || list.isEmpty()) {
                z((List<fo>) this.v, new fo(0L, -1L), false);
            } else {
                Iterator<fo> it = list.iterator();
                while (it.hasNext()) {
                    z((List<fo>) this.v, new fo(it.next()), false);
                }
                a(this.v);
                dl(this.v);
            }
            com.ss.android.socialbase.downloader.m.z.dl("SegmentDispatcher", "initSegments: totalLength = " + this.i);
        }
    }

    private void dl() throws InterruptedException, com.ss.android.socialbase.downloader.gc.z {
        com.ss.android.socialbase.downloader.gc.z zVar;
        synchronized (this.js) {
            if (this.uy == null && this.kb == null) {
                this.js.wait();
            }
        }
        if (this.uy == null && this.kb == null && (zVar = this.p) != null) {
            throw zVar;
        }
    }

    private void a() throws com.ss.android.socialbase.downloader.gc.z {
        try {
            this.gc.z((a) this.dl);
        } catch (ls unused) {
        } catch (com.ss.android.socialbase.downloader.gc.z e) {
            com.ss.android.socialbase.downloader.m.z.gc("SegmentDispatcher", "dispatchSegments: loopAndWrite e = ".concat(String.valueOf(e)));
            z(e);
            throw e;
        }
        if (this.e || this.m) {
            return;
        }
        try {
            synchronized (this) {
                while (!this.v.isEmpty()) {
                    fo foVarPoll = this.v.poll();
                    if (foVarPoll != null) {
                        z(this.pf, foVarPoll, true);
                    }
                }
                dl(this.pf);
            }
        } catch (Throwable th) {
            com.bytedance.sdk.component.utils.wp.z(th);
        }
        if (this.iq && this.p != null) {
            com.ss.android.socialbase.downloader.m.z.gc("SegmentDispatcher", "dispatchSegments: loopAndWrite  failedException = " + this.p);
            throw this.p;
        }
        if (this.z.sf() != this.z.s()) {
            com.ss.android.socialbase.downloader.gz.z.z(this.z, this.pf);
        }
        com.ss.android.socialbase.downloader.m.z.dl("SegmentDispatcher", "dispatchSegments::download finished");
    }

    private void dl(List<fo> list) {
        long jG = pf.g(list);
        com.ss.android.socialbase.downloader.m.z.dl("SegmentDispatcher", "checkDownloadBytes: getCurBytes = " + this.z.sf() + ", totalBytes = " + this.z.s() + ", downloadedBytes = " + jG);
        if (jG > this.z.s() && this.z.s() > 0) {
            jG = this.z.s();
        }
        if (this.z.sf() == this.z.s() || this.z.sf() == jG) {
            return;
        }
        this.z.gc(jG);
    }

    private void gc() {
        int iZ;
        if (this.i <= 0 || this.wp) {
            iZ = 1;
        } else {
            iZ = this.g.z();
            int iGz = (int) (this.i / this.g.gz());
            if (iZ > iGz) {
                iZ = iGz;
            }
        }
        com.ss.android.socialbase.downloader.m.z.dl("SegmentDispatcher", "dispatchReadThread: totalLength = " + this.i + ", threadCount = " + iZ);
        int i = iZ > 0 ? iZ : 1;
        synchronized (this) {
            while (this.gz.size() < i) {
                if (!this.e && !this.m) {
                    z(uy());
                    if (this.g.m()) {
                        break;
                    }
                }
                return;
            }
        }
    }

    private void m() {
        this.fo.add(new p(this.z.uy(), true));
        List<String> listMj = this.z.mj();
        if (listMj != null) {
            for (String str : listMj) {
                if (!TextUtils.isEmpty(str)) {
                    this.fo.add(new p(str, false));
                }
            }
        }
        this.g.z(this.fo.size());
    }

    private void e() {
        v vVar = this.g;
        this.zw = vVar.uy();
        this.io = vVar.kb();
        this.sy = vVar.pf();
        int i = this.hh;
        if (i > 0) {
            this.q.z(this.h, i);
        }
    }

    private void gz() {
        if (this.io > 0) {
            this.uf = System.currentTimeMillis();
            this.q.z(this.gk, 0L);
        }
    }

    private void fo() {
        List<String> listMj;
        int iWp = this.g.wp();
        if (iWp <= 0) {
            this.wp = false;
            gc();
            return;
        }
        com.ss.android.socialbase.downloader.fo.dl dlVarZ = com.ss.android.socialbase.downloader.fo.dl.z();
        dlVarZ.z(this.z.uy(), this, ExoPlayer.DEFAULT_DETACH_SURFACE_TIMEOUT_MS);
        if (iWp <= 2 || (listMj = this.z.mj()) == null) {
            return;
        }
        for (String str : listMj) {
            if (!TextUtils.isEmpty(str)) {
                dlVarZ.z(str, this, ExoPlayer.DEFAULT_DETACH_SURFACE_TIMEOUT_MS);
            }
        }
    }

    @Override // com.ss.android.socialbase.downloader.fo.dl.z
    public void z(String str, List<InetAddress> list) {
        List<p> listDl;
        if (this.e || this.m) {
            return;
        }
        try {
            listDl = dl(str, list);
        } catch (Throwable th) {
            com.bytedance.sdk.component.utils.wp.z(th);
            listDl = null;
        }
        synchronized (this) {
            if (listDl != null) {
                g(str, listDl);
                this.wp = false;
                this.g.z(this.fo.size());
                com.bytedance.sdk.component.utils.wp.z("SegmentDispatcher", "onDnsResolved: dispatchReadThread");
                gc();
            } else {
                this.wp = false;
                this.g.z(this.fo.size());
                com.bytedance.sdk.component.utils.wp.z("SegmentDispatcher", "onDnsResolved: dispatchReadThread");
                gc();
            }
        }
    }

    private void g(String str, List<p> list) {
        int iZ;
        if (this.l) {
            Iterator<p> it = list.iterator();
            while (it.hasNext()) {
                com.bytedance.sdk.component.utils.wp.z("SegmentDispatcher", "addIpListLocked: urlRecord = ".concat(String.valueOf(it.next())));
            }
        }
        int iWp = this.g.wp();
        if ((iWp == 1 || iWp == 3) && (iZ = z(str)) >= 0 && iZ < this.fo.size()) {
            this.fo.addAll(iZ + 1, list);
        } else {
            this.fo.addAll(list);
        }
    }

    private int z(String str) {
        int size = this.fo.size();
        for (int i = 0; i < size; i++) {
            if (TextUtils.equals(this.fo.get(i).z, str)) {
                return i;
            }
        }
        return -1;
    }

    private List<p> dl(String str, List<InetAddress> list) {
        boolean z;
        if (list != null && !list.isEmpty()) {
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            int i = 0;
            for (InetAddress inetAddress : list) {
                if (inetAddress != null) {
                    String hostAddress = inetAddress.getHostAddress();
                    if (!TextUtils.isEmpty(hostAddress)) {
                        if (this.l) {
                            com.bytedance.sdk.component.utils.wp.z("SegmentDispatcher", "onDnsResolved: ip = ".concat(String.valueOf(hostAddress)));
                        }
                        p pVar = new p(str, hostAddress);
                        LinkedList linkedList = (LinkedList) linkedHashMap.get(pVar.dl);
                        if (linkedList == null) {
                            linkedList = new LinkedList();
                            linkedHashMap.put(pVar.dl, linkedList);
                        }
                        linkedList.add(pVar);
                        i++;
                    }
                }
            }
            if (i > 0) {
                ArrayList arrayList = new ArrayList();
                do {
                    Iterator it = linkedHashMap.entrySet().iterator();
                    z = false;
                    while (it.hasNext()) {
                        LinkedList linkedList2 = (LinkedList) ((Map.Entry) it.next()).getValue();
                        if (linkedList2 != null && !linkedList2.isEmpty()) {
                            arrayList.add((p) linkedList2.pollFirst());
                            i--;
                            z = true;
                        }
                    }
                    if (i <= 0) {
                        break;
                    }
                } while (z);
                return arrayList;
            }
        }
        return null;
    }

    private p uy() {
        p pVar;
        synchronized (this) {
            int size = this.ls % this.fo.size();
            if (this.g.g()) {
                this.ls++;
            }
            pVar = this.fo.get(size);
        }
        return pVar;
    }

    private void z(List<fo> list, fo foVar, boolean z) {
        long jDl = foVar.dl();
        int size = list.size();
        int i = 0;
        while (i < size && jDl >= list.get(i).dl()) {
            i++;
        }
        list.add(i, foVar);
        if (z) {
            foVar.z(size);
        }
    }

    private void a(List<fo> list) {
        fo foVar = list.get(0);
        long jDl = foVar.dl();
        if (jDl > 0) {
            fo foVar2 = new fo(0L, jDl - 1);
            com.bytedance.sdk.component.utils.wp.g("SegmentDispatcher", "fixSegmentsLocked: first = " + foVar + ", add new first = " + foVar2);
            z(list, foVar2, true);
        }
        Iterator<fo> it = list.iterator();
        if (it.hasNext()) {
            fo next = it.next();
            while (it.hasNext()) {
                fo next2 = it.next();
                if (next.m() < next2.dl() - 1) {
                    com.ss.android.socialbase.downloader.m.z.a("SegmentDispatcher", "fixSegment: segment = " + next + ", new end = " + (next2.dl() - 1));
                    next.dl(next2.dl() - 1);
                }
                next = next2;
            }
        }
        fo foVar3 = list.get(list.size() - 1);
        long jS = this.z.s();
        if (jS <= 0 || (foVar3.m() != -1 && foVar3.m() < jS - 1)) {
            com.ss.android.socialbase.downloader.m.z.a("SegmentDispatcher", "fixSegment: last segment = " + foVar3 + ", new end=-1");
            foVar3.dl(-1L);
        }
    }

    private void z(p pVar) {
        i iVar = new i(this.z, this, this.dl, pVar, this.gz.size());
        this.gz.add(iVar);
        iVar.z(com.ss.android.socialbase.downloader.downloader.dl.ls().submit(iVar));
    }

    @Override // com.ss.android.socialbase.downloader.kb.m
    public void z(i iVar) {
        if (this.l) {
            com.ss.android.socialbase.downloader.m.z.dl("SegmentDispatcher", "onReaderRun, threadIndex = " + iVar.dl);
        }
    }

    @Override // com.ss.android.socialbase.downloader.kb.m
    public fo z(i iVar, p pVar) {
        if (this.m || this.e) {
            return null;
        }
        synchronized (this) {
            fo foVarG = g(iVar, pVar);
            if (foVarG != null) {
                foVarG.gz();
                if (foVarG.uy() > 1) {
                    return new fo(foVarG);
                }
            }
            return foVarG;
        }
    }

    @Override // com.ss.android.socialbase.downloader.kb.m
    public void z(i iVar, fo foVar) {
        synchronized (this) {
            foVar.fo();
        }
    }

    private fo g(i iVar, p pVar) {
        while (!this.v.isEmpty()) {
            fo foVarPoll = this.v.poll();
            if (foVarPoll != null) {
                z(this.pf, foVarPoll, true);
                if (z(foVarPoll) > 0 || this.i <= 0) {
                    return foVarPoll;
                }
            }
        }
        i();
        fo foVarDl = dl(iVar, pVar);
        if (foVarDl != null && z(foVarDl) > 0) {
            z(this.pf, foVarDl, true);
            return foVarDl;
        }
        fo foVarLs = ls();
        if (foVarLs != null) {
            return foVarLs;
        }
        return null;
    }

    @Override // com.ss.android.socialbase.downloader.kb.m
    public void z(i iVar, fo foVar, p pVar, com.ss.android.socialbase.downloader.e.m mVar) throws com.ss.android.socialbase.downloader.gc.uy, com.ss.android.socialbase.downloader.gc.z {
        synchronized (this) {
            if (this.m || this.e) {
                throw new ls("connected");
            }
            g(iVar, foVar, pVar, mVar);
            iVar.g(false);
            if (this.i <= 0) {
                long jS = this.z.s();
                this.i = jS;
                if (jS <= 0) {
                    this.i = mVar.uy();
                }
                gc();
            } else if (this.g.m()) {
                gc();
            }
        }
    }

    @Override // com.ss.android.socialbase.downloader.kb.m
    public void g(i iVar, fo foVar) throws com.ss.android.socialbase.downloader.gc.z {
        synchronized (this) {
            gc(iVar, foVar);
        }
    }

    @Override // com.ss.android.socialbase.downloader.kb.m
    public void dl(i iVar, fo foVar) {
        synchronized (this) {
            if (foVar.z == iVar) {
                com.ss.android.socialbase.downloader.m.z.dl("SegmentDispatcher", "unApplySegment ".concat(String.valueOf(foVar)));
                foVar.a(iVar.a());
                foVar.z = null;
                iVar.z();
            }
        }
    }

    @Override // com.ss.android.socialbase.downloader.kb.m
    public gc a(i iVar, fo foVar) throws com.ss.android.socialbase.downloader.gc.z {
        gc gcVarZ;
        synchronized (this) {
            wp wpVar = new wp(this.z, this.dl, foVar);
            this.gc.z(wpVar);
            gcVarZ = wpVar.z();
        }
        return gcVarZ;
    }

    @Override // com.ss.android.socialbase.downloader.kb.m
    public void z(i iVar, p pVar, fo foVar, com.ss.android.socialbase.downloader.gc.z zVar, int i, int i2) {
        boolean zG = com.ss.android.socialbase.downloader.pf.m.g(zVar);
        int iZ = zVar.z();
        if (iZ == 1047 || iZ == 1074 || iZ == 1055) {
            zG = true;
        }
        if (zG || i >= i2) {
            dl(iVar);
        }
    }

    @Override // com.ss.android.socialbase.downloader.kb.m
    public void z(i iVar, p pVar, fo foVar, com.ss.android.socialbase.downloader.gc.z zVar) {
        synchronized (this) {
            com.ss.android.socialbase.downloader.m.z.gc("SegmentDispatcher", "onSegmentFailed: segment = " + foVar + ", e = " + zVar);
            iVar.g(true);
            if (iVar.dl == 0) {
                this.p = zVar;
            }
            if (wp()) {
                if (this.p == null) {
                    this.p = zVar;
                }
                this.iq = true;
                z(this.p);
            }
        }
    }

    @Override // com.ss.android.socialbase.downloader.kb.m
    public void g(i iVar) {
        com.ss.android.socialbase.downloader.m.z.dl("SegmentDispatcher", "onReaderExit: threadIndex = " + iVar.dl);
        synchronized (this) {
            iVar.dl(true);
            this.gz.remove(iVar);
            i();
            if (!this.gz.isEmpty()) {
                if (v()) {
                    com.bytedance.sdk.component.utils.wp.z("SegmentDispatcher", "onReaderExit: allContentDownloaded");
                    Iterator<i> it = this.gz.iterator();
                    while (it.hasNext()) {
                        it.next().gc();
                    }
                    kb();
                }
            } else {
                kb();
            }
        }
    }

    private void z(com.ss.android.socialbase.downloader.gc.z zVar) {
        com.ss.android.socialbase.downloader.m.z.gc("SegmentDispatcher", "onError, e = ".concat(String.valueOf(zVar)));
        this.p = zVar;
        this.dl.dl();
        synchronized (this) {
            Iterator<i> it = this.gz.iterator();
            while (it.hasNext()) {
                it.next().gc();
            }
        }
    }

    private void kb() {
        com.ss.android.socialbase.downloader.m.z.dl("SegmentDispatcher", "onComplete");
        this.dl.dl();
        synchronized (this.js) {
            this.js.notify();
        }
    }

    private boolean wp() {
        Iterator<i> it = this.gz.iterator();
        while (it.hasNext()) {
            if (!it.next().e()) {
                return false;
            }
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean dl(i iVar) {
        synchronized (this) {
            p pVarA = a(iVar);
            if (pVarA == null) {
                return false;
            }
            return iVar.z(pVarA);
        }
    }

    private p a(i iVar) {
        p next;
        Iterator<p> it = this.fo.iterator();
        p pVar = null;
        while (true) {
            if (!it.hasNext()) {
                next = null;
                break;
            }
            next = it.next();
            if (next != iVar.g && !next.a()) {
                if (pVar == null) {
                    pVar = next;
                }
                if (next.z() <= 0) {
                    break;
                }
            }
        }
        if (this.g.g()) {
            if (next != null) {
                return next;
            }
            if (this.g.dl()) {
                return null;
            }
        }
        return pVar;
    }

    private void g(i iVar, fo foVar, p pVar, com.ss.android.socialbase.downloader.e.m mVar) throws com.ss.android.socialbase.downloader.gc.uy, com.ss.android.socialbase.downloader.gc.z {
        i iVar2 = foVar.z;
        if (iVar2 != null && iVar2 != iVar) {
            throw new uy(1, "segment already has an owner");
        }
        if (iVar.gz() != foVar.gc()) {
            throw new uy(5, "applySegment");
        }
        if (!mVar.g()) {
            if (foVar.gc() > 0) {
                throw new com.ss.android.socialbase.downloader.gc.dl(1004, mVar.dl, "1: response code error : " + mVar.dl + " segment=" + foVar);
            }
            com.ss.android.socialbase.downloader.m.z.gc("SegmentDispatcher", "parseHttpResponse: segment.getCurrentOffsetRead = " + foVar.gc());
            if (!mVar.z()) {
                throw new com.ss.android.socialbase.downloader.gc.dl(1004, mVar.dl, "2: response code error : " + mVar.dl + " segment=" + foVar);
            }
        }
        if (pVar.f2102a) {
            if (this.uy == null) {
                this.uy = mVar;
                synchronized (this.js) {
                    this.js.notify();
                }
                com.ss.android.socialbase.downloader.v.m mVar2 = this.f2101a;
                if (mVar2 != null) {
                    mVar2.z(pVar.z, mVar.g, foVar.gc());
                }
                long jUy = mVar.uy();
                if (jUy > 0) {
                    for (fo foVar2 : this.pf) {
                        if (foVar2.m() <= 0 || foVar2.m() > jUy - 1) {
                            foVar2.dl(jUy - 1);
                        }
                    }
                    return;
                }
                return;
            }
            return;
        }
        z(mVar);
        if (this.kb == null) {
            this.kb = mVar;
            if (this.z.s() <= 0) {
                long jUy2 = mVar.uy();
                com.ss.android.socialbase.downloader.m.z.dl("SegmentDispatcher", "checkSegmentHttpResponse:len=" + jUy2 + ",url=" + pVar.z);
                this.z.e(jUy2);
            }
            synchronized (this.js) {
                this.js.notify();
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:27:0x009a, code lost:
    
        if ((r10.gc() - r24.gc()) < (r13 / 2)) goto L32;
     */
    /* JADX WARN: Removed duplicated region for block: B:36:0x00e5  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x00eb  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void gc(com.ss.android.socialbase.downloader.kb.i r23, com.ss.android.socialbase.downloader.kb.fo r24) throws com.ss.android.socialbase.downloader.kb.uy {
        /*
            Method dump skipped, instruction units count: 662
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ss.android.socialbase.downloader.kb.kb.gc(com.ss.android.socialbase.downloader.kb.i, com.ss.android.socialbase.downloader.kb.fo):void");
    }

    private void z(com.ss.android.socialbase.downloader.e.m mVar) throws com.ss.android.socialbase.downloader.gc.z {
        com.ss.android.socialbase.downloader.e.m mVar2 = this.uy;
        if (mVar2 == null && (mVar2 = this.kb) == null) {
            return;
        }
        long jUy = mVar.uy();
        long jUy2 = mVar2.uy();
        if (jUy != jUy2) {
            String str = "total len not equals,len=" + jUy + ",sLen=" + jUy2 + ",code=" + mVar.dl + ",sCode=" + mVar2.dl + ",range=" + mVar.gc() + ",sRange = " + mVar2.gc() + ",url = " + mVar.z + ",sUrl=" + mVar2.z;
            com.ss.android.socialbase.downloader.m.z.gc("SegmentDispatcher", str);
            if (jUy > 0 && jUy2 > 0) {
                throw new com.ss.android.socialbase.downloader.gc.z(1074, str);
            }
        }
        String strDl = mVar.dl();
        String strDl2 = mVar2.dl();
        if (TextUtils.equals(strDl, strDl2)) {
            return;
        }
        String str2 = "etag not equals with main url, etag = " + strDl + ", mainEtag = " + strDl2;
        com.ss.android.socialbase.downloader.m.z.gc("SegmentDispatcher", str2);
        if (!TextUtils.isEmpty(strDl) && !TextUtils.isEmpty(strDl2) && !strDl.equalsIgnoreCase(strDl2)) {
            throw new com.ss.android.socialbase.downloader.gc.z(1074, str2);
        }
    }

    public void z() {
        com.ss.android.socialbase.downloader.m.z.dl("SegmentDispatcher", "cancel");
        this.m = true;
        synchronized (this) {
            Iterator<i> it = this.gz.iterator();
            while (it.hasNext()) {
                it.next().gc();
            }
        }
        this.gc.z();
        this.dl.dl();
    }

    public void g() {
        com.ss.android.socialbase.downloader.m.z.dl("SegmentDispatcher", "pause1");
        this.e = true;
        synchronized (this) {
            Iterator<i> it = this.gz.iterator();
            while (it.hasNext()) {
                it.next().gc();
            }
        }
        this.gc.g();
        this.dl.dl();
    }

    private int z(long j) {
        int size = this.pf.size();
        for (int i = 0; i < size; i++) {
            fo foVar = this.pf.get(i);
            if (foVar.dl() == j) {
                return i;
            }
            if (foVar.dl() > j) {
                return -1;
            }
        }
        return -1;
    }

    private void i() {
        int size;
        if (this.i > 0 && (size = this.pf.size()) > 1) {
            ArrayList<fo> arrayList = null;
            int i = 0;
            for (int i2 = 1; i2 < size; i2++) {
                fo foVar = this.pf.get(i);
                fo foVar2 = this.pf.get(i2);
                if (foVar.gc() > foVar2.dl() && foVar2.z() <= 0 && foVar2.z == null) {
                    if (arrayList == null) {
                        arrayList = new ArrayList(1);
                    }
                    arrayList.add(foVar2);
                    if (this.l) {
                        com.bytedance.sdk.component.utils.wp.g("SegmentDispatcher", "clearCovered, covered = " + foVar2 + ", prev = " + foVar);
                    }
                } else if (foVar2.gc() > foVar.gc()) {
                    i++;
                }
            }
            if (arrayList != null) {
                for (fo foVar3 : arrayList) {
                    this.pf.remove(foVar3);
                    for (i iVar : this.gz) {
                        if (iVar.z == foVar3) {
                            if (this.l) {
                                com.bytedance.sdk.component.utils.wp.g("SegmentDispatcher", "clearCoveredSegmentLocked: reconnect, segment = " + foVar3 + ", threadIndex = " + iVar.dl);
                            }
                            iVar.z(true);
                        }
                    }
                }
            }
        }
    }

    private boolean v() {
        long j = this.i;
        if (j <= 0) {
            this.fv = false;
            return false;
        }
        synchronized (this) {
            long jZ = pf.z(this.pf);
            com.ss.android.socialbase.downloader.m.z.dl("SegmentDispatcher", "isAllContentDownloaded: firstOffset = ".concat(String.valueOf(jZ)));
            if (jZ >= j) {
                this.fv = true;
                return true;
            }
            this.fv = false;
            return false;
        }
    }

    private fo dl(i iVar, p pVar) {
        String str;
        int size = this.pf.size();
        long j = -1;
        int i = -1;
        for (int i2 = 0; i2 < size; i2++) {
            long jZ = z(i2, size);
            if (jZ > j) {
                i = i2;
                j = jZ;
            }
        }
        long jE = this.g.e();
        long jFo = this.g.fo();
        if (i < 0 || j <= jE) {
            return null;
        }
        fo foVar = this.pf.get(i);
        int iV = this.pf.size() < this.gz.size() ? 2 : this.g.v();
        if (iV == 1) {
            i iVar2 = foVar.z;
            if (iVar2 != null) {
                long jCurrentTimeMillis = System.currentTimeMillis();
                long j2 = jCurrentTimeMillis - 4000;
                long jZ2 = iVar2.z(j2, jCurrentTimeMillis);
                long jZ3 = iVar.z(j2, jCurrentTimeMillis);
                float f = (jZ2 <= 0 || jZ3 <= 0) ? -1.0f : jZ3 / (jZ2 + jZ3);
                if (f == -1.0f) {
                    long jG = iVar2.g();
                    long jG2 = iVar.g();
                    if (jG > 0 && jG2 > 0) {
                        f = jG2 / (jG + jG2);
                    }
                }
                if (f > 0.0f) {
                    float f2 = f * 0.9f;
                    long j3 = (long) (j * f2);
                    if (j3 < jE) {
                        j3 = jE;
                    }
                    if (jFo <= 0 || j3 <= jFo) {
                        jFo = j3;
                    }
                    long j4 = jE / 2;
                    long j5 = j - j4;
                    if (jFo > j5) {
                        jFo = j5;
                    } else if (jFo < j4) {
                        jFo = j4;
                    }
                    fo foVar2 = new fo(foVar.gc() + (j - jFo), foVar.m());
                    com.ss.android.socialbase.downloader.m.z.dl("SegmentDispatcher", "obtainSegment: parent = " + foVar + ", child = " + foVar2 + ", maxRemainBytes = " + j + ", childLength = " + jFo + ", ratio = " + f2 + ", threadIndex = " + iVar.dl);
                    return foVar2;
                }
            }
            str = "SegmentDispatcher";
        } else {
            if (iV == 2) {
                long jSf = this.i - this.z.sf();
                float fA = a(iVar, pVar);
                long j6 = (long) (jSf * fA);
                if (j6 < jE) {
                    j6 = jE;
                }
                if (jFo <= 0 || j6 <= jFo) {
                    jFo = j6;
                }
                long j7 = jE / 2;
                long j8 = j - j7;
                if (jFo > j8) {
                    jFo = j8;
                } else if (jFo < j7) {
                    jFo = j7;
                }
                fo foVar3 = new fo(foVar.gc() + (j - jFo), foVar.m());
                com.ss.android.socialbase.downloader.m.z.dl("SegmentDispatcher", "obtainSegment: parent = " + foVar + ", child = " + foVar3 + ", maxRemainBytes = " + j + ", childLength = " + jFo + ", ratio = " + fA + ", threadIndex = " + iVar.dl);
                return foVar3;
            }
            str = "SegmentDispatcher";
        }
        fo foVar4 = new fo(foVar.gc() + (j / 2), foVar.m());
        com.ss.android.socialbase.downloader.m.z.dl(str, "obtainSegment: parent = " + foVar + ",child = " + foVar4);
        return foVar4;
    }

    private float a(i iVar, p pVar) {
        long jG = iVar.g();
        int size = this.gz.size();
        if (size <= 1) {
            size = this.g.z();
        }
        float f = 1.0f;
        if (jG <= 0) {
            float fI = this.g.i();
            if (fI <= 0.0f || fI >= 1.0f) {
                fI = 1.0f / size;
            }
            if (iVar.dl == 0) {
                return fI;
            }
            if (size > 1) {
                f = 1.0f - fI;
                size--;
            }
        } else {
            long jPf = pf();
            if (jPf > jG) {
                return jG / jPf;
            }
        }
        return f / size;
    }

    private long pf() {
        Iterator<i> it = this.gz.iterator();
        long jG = 0;
        while (it.hasNext()) {
            jG += it.next().g();
        }
        return jG;
    }

    private fo ls() {
        int i = 0;
        while (true) {
            fo foVarP = p();
            if (foVarP == null) {
                return null;
            }
            i iVar = foVarP.z;
            if (iVar == null) {
                return foVarP;
            }
            if (foVarP.uy() >= 2) {
                return null;
            }
            long jCurrentTimeMillis = System.currentTimeMillis();
            g(jCurrentTimeMillis);
            if (jCurrentTimeMillis - iVar.m > ExoPlayer.DEFAULT_DETACH_SURFACE_TIMEOUT_MS && z(iVar, jCurrentTimeMillis - ExoPlayer.DEFAULT_DETACH_SURFACE_TIMEOUT_MS, jCurrentTimeMillis, 500L, 1.0d)) {
                if (this.l) {
                    com.bytedance.sdk.component.utils.wp.z("SegmentDispatcher", "obtainSegmentWhenNoNewSegment: isDownloadSpeedPoor segment = " + foVarP + ", owner.threadIndex = " + iVar.dl);
                }
                return foVarP;
            }
            int i2 = i + 1;
            if (i > 2) {
                if (this.l) {
                    com.bytedance.sdk.component.utils.wp.z("SegmentDispatcher", "obtainSegmentWhenNoNewSegment: waitCount > 2, return segment = ".concat(String.valueOf(foVarP)));
                }
                return foVarP;
            }
            try {
                synchronized (this) {
                    wait(500L);
                }
                i = i2;
            } catch (InterruptedException unused) {
                return null;
            }
        }
    }

    private fo p() {
        int iUy;
        fo foVar = null;
        int i = Integer.MAX_VALUE;
        for (fo foVar2 : this.pf) {
            if (z(foVar2) > 0 && (iUy = foVar2.uy()) < i) {
                foVar = foVar2;
                i = iUy;
            }
        }
        return foVar;
    }

    private long z(int i, int i2) {
        fo foVar = this.pf.get(i);
        long jZ = z(foVar);
        int i3 = i + 1;
        fo foVar2 = i3 < i2 ? this.pf.get(i3) : null;
        if (foVar2 == null) {
            return jZ;
        }
        long jDl = foVar2.dl() - foVar.gc();
        return jZ == -1 ? jDl : Math.min(jZ, jDl);
    }

    private long z(fo foVar) {
        long jG = foVar.g();
        if (jG != -1) {
            return jG;
        }
        long j = this.i;
        return j > 0 ? j - foVar.gc() : jG;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public i z(boolean z, long j, long j2) {
        i iVar = null;
        for (i iVar2 : this.gz) {
            if (iVar2.dl != 0 || z) {
                if (iVar2.f2100a > 0 && iVar2.gc <= 0 && j - iVar2.f2100a > j2 && (iVar == null || iVar2.f2100a < iVar.f2100a)) {
                    iVar = iVar2;
                }
            }
        }
        return iVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public long fv() {
        if (this.m || this.e) {
            return -1L;
        }
        long jCurrentTimeMillis = System.currentTimeMillis();
        synchronized (this) {
            g(jCurrentTimeMillis);
            long jKb = this.g.kb();
            if (jKb > 0) {
                long j = this.uf;
                if (j > 0 && jCurrentTimeMillis - j > jKb && z(jCurrentTimeMillis, jKb)) {
                    this.uf = jCurrentTimeMillis;
                    this.hh++;
                }
            }
        }
        return ExoPlayer.DEFAULT_DETACH_SURFACE_TIMEOUT_MS;
    }

    private void g(long j) {
        this.tb.z(this.z.sf(), j);
        Iterator<i> it = this.gz.iterator();
        while (it.hasNext()) {
            it.next().g(j);
        }
    }

    private boolean z(i iVar, long j, long j2, long j3, double d) {
        if (iVar.m <= 0) {
            return false;
        }
        long jG = this.tb.g(j, j2);
        int size = this.gz.size();
        long j4 = size > 0 ? jG / ((long) size) : jG;
        long jZ = iVar.z(j, j2);
        if (jZ >= j3 && jZ >= j4 * d) {
            return false;
        }
        com.bytedance.sdk.component.utils.wp.z("SegmentDispatcher", "isDownloadSpeedPoor: totalSpeed = " + jG + ", threadAvgSpeed = " + j4 + ", poorSpeed = " + j3 + ", speed = " + jZ + ",threadIndex = " + iVar.dl);
        return true;
    }

    private boolean z(long j, long j2) {
        long j3 = j - j2;
        long jG = this.tb.g(j3, j);
        int size = this.gz.size();
        if (size > 0) {
            jG /= (long) size;
        }
        i iVarZ = z(j3, j, (long) Math.max(10.0f, jG * this.sy), size / 2);
        if (iVarZ != null) {
            dl(iVarZ);
            com.ss.android.socialbase.downloader.m.z.a("SegmentDispatcher", "handlePoorReadThread: reconnect for poor speed, threadIndex = " + iVarZ.dl);
            iVarZ.m();
            return true;
        }
        i iVarZ2 = z(true, j, j2);
        if (iVarZ2 == null) {
            return false;
        }
        dl(iVarZ2);
        com.ss.android.socialbase.downloader.m.z.a("SegmentDispatcher", "handlePoorReadThread: reconnect for connect timeout, threadIndex = " + iVarZ2.dl);
        iVarZ2.m();
        return true;
    }

    private i z(long j, long j2, long j3, int i) {
        int i2;
        long j4 = Long.MAX_VALUE;
        int i3 = 0;
        i iVar = null;
        for (i iVar2 : this.gz) {
            if (iVar2.m > 0) {
                int i4 = i3 + 1;
                if (iVar2.m < j) {
                    i2 = i4;
                    long jZ = iVar2.z(j, j2);
                    if (this.l) {
                        com.bytedance.sdk.component.utils.wp.z("SegmentDispatcher", "findPoorReadThread: speed = " + jZ + ", threadIndex = " + iVar2.dl);
                    }
                    if (jZ >= 0 && jZ < j4) {
                        j4 = jZ;
                        iVar = iVar2;
                    }
                } else {
                    i2 = i4;
                }
                i3 = i2;
            }
        }
        if (iVar == null || i3 < i || j4 >= j3) {
            return null;
        }
        com.ss.android.socialbase.downloader.m.z.dl("SegmentDispatcher", "findPoorReadThread: ----------- minSpeed = " + j4 + ", threadIndex = " + iVar.dl);
        return iVar;
    }
}
