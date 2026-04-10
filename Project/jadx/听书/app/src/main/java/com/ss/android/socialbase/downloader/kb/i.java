package com.ss.android.socialbase.downloader.kb;

import android.text.TextUtils;
import androidx.media3.common.C;
import androidx.media3.exoplayer.analytics.AnalyticsListener;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Future;

/* JADX INFO: loaded from: classes4.dex */
class i implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    volatile long f2100a;
    final int dl;
    volatile long e;
    private boolean eo;
    String fo;
    private long fv;
    p g;
    volatile long gc;
    private int gk;
    String gz;
    private int h;
    private Thread hh;
    private final com.ss.android.socialbase.downloader.e.dl i;
    private volatile boolean io;
    private volatile long iq;
    private volatile long js;
    private final m kb;
    private volatile boolean l;
    private long lq;
    private com.ss.android.socialbase.downloader.e.m ls;
    volatile long m;
    private int mc;
    private boolean oq;
    private com.ss.android.socialbase.downloader.fo.fo pf;
    private volatile boolean sy;
    private volatile long tb;
    private com.ss.android.socialbase.downloader.gc.z ti;
    private volatile boolean uf;
    private boolean un;
    String uy;
    private final com.ss.android.socialbase.downloader.i.z v;
    private com.ss.android.socialbase.downloader.pf.gc wj;
    private final dl wp;
    private int x;
    volatile fo z;
    private Future zw;
    private final List<fo> p = new ArrayList();
    private volatile long q = -1;

    i(com.ss.android.socialbase.downloader.e.dl dlVar, kb kbVar, dl dlVar2, p pVar, int i) {
        this.i = dlVar;
        this.kb = kbVar;
        this.wp = dlVar2;
        this.v = com.ss.android.socialbase.downloader.i.z.z(dlVar.e());
        this.g = pVar;
        this.dl = i;
    }

    /* JADX WARN: Code restructure failed: missing block: B:18:0x007b, code lost:
    
        r5.z = null;
        r2 = r5.kb;
     */
    @Override // java.lang.Runnable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void run() {
        /*
            Method dump skipped, instruction units count: 253
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ss.android.socialbase.downloader.kb.i.run():void");
    }

    private boolean z(fo foVar) throws com.ss.android.socialbase.downloader.gc.z {
        kb();
        while (true) {
            try {
                try {
                    g(foVar);
                    a(foVar);
                    fo();
                    return true;
                } catch (Throwable th) {
                    try {
                        com.ss.android.socialbase.downloader.m.z.gc("SegmentReader", "download: e = " + th + ", threadIndex = " + this.dl + ", reconnect = " + this.uf + ", closed = " + this.io);
                        if (this.io) {
                            fo();
                            return false;
                        }
                        if (this.uf) {
                            this.uf = false;
                            try {
                                Thread.interrupted();
                            } catch (Throwable th2) {
                                com.bytedance.sdk.component.utils.wp.z(th2);
                            }
                            if (this.sy) {
                                this.sy = false;
                                throw new uy(5, "download");
                            }
                        } else {
                            com.bytedance.sdk.component.utils.wp.z(th);
                            if (th instanceof com.ss.android.socialbase.downloader.gc.z) {
                                e = th;
                            } else {
                                try {
                                    com.ss.android.socialbase.downloader.pf.m.z((Throwable) th, "download");
                                    e = null;
                                } catch (com.ss.android.socialbase.downloader.gc.z e) {
                                    e = e;
                                }
                            }
                            if (e == null || !z(foVar, e)) {
                                fo();
                                return false;
                            }
                        }
                        fo();
                    } catch (Throwable th3) {
                        fo();
                        throw th3;
                    }
                }
            } catch (uy e2) {
                this.ti = e2;
                throw e2;
            }
        }
        fo();
        return false;
    }

    private void fo() {
        this.lq = this.f2100a;
        this.f2100a = -1L;
        this.gc = -1L;
        this.m = -1L;
        this.e = -1L;
        uy();
    }

    private void uy() {
        com.ss.android.socialbase.downloader.fo.fo foVar = this.pf;
        if (foVar != null) {
            try {
                com.ss.android.socialbase.downloader.m.z.dl("SegmentReader", "closeConnection: thread = " + this.dl);
                foVar.a();
                foVar.dl();
            } catch (Throwable unused) {
            }
        }
    }

    private void kb() {
        this.un = false;
        wp();
    }

    private void wp() {
        this.gk = this.g.f2102a ? this.i.oq() : this.i.wj();
        this.x = 0;
    }

    boolean z(p pVar) {
        int i = this.mc;
        if (i >= 30) {
            return false;
        }
        this.mc = i + 1;
        p pVar2 = this.g;
        if (pVar2 != null) {
            pVar2.g(this);
        }
        pVar.z(this);
        this.g = pVar;
        wp();
        return true;
    }

    private boolean z(fo foVar, com.ss.android.socialbase.downloader.gc.z zVar) {
        com.ss.android.socialbase.downloader.m.z.gc("SegmentReader", "handleDownloadFailed:  e = " + zVar + ", curRetryCount = " + this.x + ", retryCount = " + this.gk);
        this.ti = zVar;
        this.g.g();
        this.kb.z(this, this.g, foVar, zVar, this.x, this.gk);
        int i = this.x;
        if (i < this.gk) {
            this.x = i + 1;
            return true;
        }
        if (z(zVar)) {
            return true;
        }
        this.kb.z(this, this.g, foVar, zVar);
        return false;
    }

    private boolean z(com.ss.android.socialbase.downloader.gc.z zVar) {
        if (!com.ss.android.socialbase.downloader.pf.m.dl(zVar)) {
            return false;
        }
        String str = this.g.z;
        if (TextUtils.isEmpty(str) || !str.startsWith("https") || !this.i.dt() || this.un) {
            return false;
        }
        this.un = true;
        wp();
        return true;
    }

    private void g(fo foVar) throws com.ss.android.socialbase.downloader.gc.uy, com.ss.android.socialbase.downloader.gc.z {
        dl(foVar);
        this.kb.z(this, foVar, this.g, this.ls);
        this.g.dl();
    }

    private void dl(fo foVar) throws com.ss.android.socialbase.downloader.gc.z {
        String strReplaceFirst;
        String str;
        com.ss.android.socialbase.downloader.fo.fo foVarZ;
        try {
            try {
                long jCurrentTimeMillis = System.currentTimeMillis();
                this.gc = 0L;
                this.f2100a = jCurrentTimeMillis;
                this.fv = foVar.gc();
                this.tb = foVar.m();
                if (this.tb > 0 && this.fv > this.tb) {
                    throw new uy(6, "createConn, ".concat(String.valueOf(foVar)));
                }
                this.wj = new com.ss.android.socialbase.downloader.pf.gc();
                List<com.ss.android.socialbase.downloader.e.gc> listZ = com.ss.android.socialbase.downloader.pf.m.z(this.i.ti(), this.i.n(), this.fv, this.tb);
                listZ.add(new com.ss.android.socialbase.downloader.e.gc("Segment-Index", String.valueOf(foVar.e())));
                listZ.add(new com.ss.android.socialbase.downloader.e.gc("Thread-Index", String.valueOf(this.dl)));
                com.ss.android.socialbase.downloader.pf.m.z(listZ, this.i);
                com.ss.android.socialbase.downloader.pf.m.g(listZ, this.i);
                strReplaceFirst = this.g.z;
                if (this.un && !TextUtils.isEmpty(strReplaceFirst) && strReplaceFirst.startsWith("https")) {
                    strReplaceFirst = strReplaceFirst.replaceFirst("https", "http");
                }
                str = this.g.g;
                com.ss.android.socialbase.downloader.m.z.dl("SegmentReader", "createConnectionBegin: url = " + strReplaceFirst + ", ip = " + str + ", segment = " + foVar + ", threadIndex = " + this.dl);
                this.gz = strReplaceFirst;
                this.fo = str;
                foVarZ = com.ss.android.socialbase.downloader.downloader.dl.z(this.i.pf(), this.i.eo(), strReplaceFirst, str, listZ, 0, jCurrentTimeMillis - this.lq > C.DEFAULT_MAX_SEEK_TO_PREVIOUS_POSITION_MS && this.v.g("monitor_download_connect") > 0, this.i);
            } catch (com.ss.android.socialbase.downloader.gc.z e) {
                throw e;
            } catch (Throwable th) {
                com.ss.android.socialbase.downloader.pf.m.z(th, "createConn");
            }
            if (foVarZ == null) {
                throw new com.ss.android.socialbase.downloader.gc.z(AnalyticsListener.EVENT_DRM_SESSION_ACQUIRED, new IOException("download can't continue, chunk connection is null"));
            }
            this.pf = foVarZ;
            this.ls = new com.ss.android.socialbase.downloader.e.m(strReplaceFirst, foVarZ);
            if (this.io) {
                throw new ls("createConn");
            }
            if (foVarZ instanceof com.ss.android.socialbase.downloader.fo.z) {
                this.uy = ((com.ss.android.socialbase.downloader.fo.z) foVarZ).gc();
            }
            com.bytedance.sdk.component.utils.wp.z("SegmentReader", "createConnectionSuccess: url = " + strReplaceFirst + ", ip = " + str + ", hostRealIp = " + this.uy + ", threadIndex = " + this.dl);
        } finally {
            this.gc = System.currentTimeMillis();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:200:0x0355  */
    /* JADX WARN: Removed duplicated region for block: B:203:0x0362  */
    /* JADX WARN: Removed duplicated region for block: B:247:0x0177 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:37:0x008f  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x009c  */
    /* JADX WARN: Removed duplicated region for block: B:91:0x017e A[Catch: all -> 0x0271, z -> 0x0273, TryCatch #20 {z -> 0x0273, all -> 0x0271, blocks: (B:27:0x006e, B:28:0x0072, B:50:0x00da, B:88:0x016c, B:90:0x0177, B:91:0x017e, B:93:0x0184, B:95:0x018a, B:98:0x0193, B:99:0x0197, B:132:0x0262), top: B:241:0x005d }] */
    /*  JADX ERROR: JadxRuntimeException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxRuntimeException: Can't find top splitter block for handler:B:79:0x015a
        	at jadx.core.utils.BlockUtils.getTopSplitterForHandler(BlockUtils.java:1182)
        	at jadx.core.dex.visitors.regions.maker.ExcHandlersRegionMaker.collectHandlerRegions(ExcHandlersRegionMaker.java:53)
        	at jadx.core.dex.visitors.regions.maker.ExcHandlersRegionMaker.process(ExcHandlersRegionMaker.java:38)
        	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:27)
        */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void a(com.ss.android.socialbase.downloader.kb.fo r32) throws com.ss.android.socialbase.downloader.gc.z {
        /*
            Method dump skipped, instruction units count: 928
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ss.android.socialbase.downloader.kb.i.a(com.ss.android.socialbase.downloader.kb.fo):void");
    }

    private z z(dl dlVar, InputStream inputStream) throws Throwable {
        int i;
        z zVarG = dlVar.g();
        try {
            i = inputStream.read(zVarG.z);
            try {
                if (i == -1) {
                    throw new com.ss.android.socialbase.downloader.gc.z(1073, com.umeng.analytics.pro.z.s);
                }
                zVarG.dl = i;
                if (i == -1) {
                    dlVar.z(zVarG);
                }
                return zVarG;
            } catch (Throwable th) {
                th = th;
                if (i == -1) {
                    dlVar.z(zVarG);
                }
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
            i = -1;
        }
    }

    private long i() {
        long j = this.js;
        this.js = 0L;
        if (j <= 0) {
            return Long.MAX_VALUE;
        }
        return j;
    }

    public boolean z(long j) {
        long j2 = this.tb;
        if (j <= 0 && j2 > 0) {
            return false;
        }
        if (j > j2 && j2 > 0) {
            return false;
        }
        this.js = j;
        this.l = true;
        return true;
    }

    void z() {
        p pVar = this.g;
        try {
            synchronized (this.kb) {
                long jDl = dl();
                if (jDl > 0) {
                    this.iq += jDl;
                    pVar.z(jDl);
                }
                this.q = -1L;
            }
        } catch (Throwable unused) {
        }
    }

    public long g() {
        long jDl;
        synchronized (this.kb) {
            jDl = this.iq + dl();
        }
        return jDl;
    }

    public long dl() {
        synchronized (this.kb) {
            long j = this.q;
            long j2 = this.fv;
            if (j2 < 0 || j <= j2) {
                return 0L;
            }
            return j - j2;
        }
    }

    public long a() {
        return this.q;
    }

    public void gc() {
        com.ss.android.socialbase.downloader.m.z.dl("SegmentReader", "close: threadIndex = " + this.dl);
        synchronized (this) {
            this.io = true;
            this.l = true;
        }
        uy();
        Future future = this.zw;
        if (future != null) {
            this.zw = null;
            try {
                future.cancel(true);
            } catch (Throwable th) {
                com.bytedance.sdk.component.utils.wp.z(th);
            }
        }
    }

    public void m() {
        z(false);
    }

    public void z(boolean z) {
        com.ss.android.socialbase.downloader.m.z.dl("SegmentReader", "reconnect: threadIndex = " + this.dl);
        synchronized (this) {
            this.sy = z;
            this.uf = true;
            this.l = true;
        }
        uy();
        Thread thread = this.hh;
        if (thread != null) {
            try {
                com.bytedance.sdk.component.utils.wp.z("SegmentReader", "reconnect: t.interrupt threadIndex = " + this.dl);
                thread.interrupt();
            } catch (Throwable unused) {
            }
        }
    }

    void z(Future future) {
        this.zw = future;
    }

    void g(boolean z) {
        this.eo = z;
    }

    boolean e() {
        return this.eo;
    }

    public void dl(boolean z) {
        this.oq = z;
    }

    void g(long j) {
        long j2 = this.q;
        com.ss.android.socialbase.downloader.pf.gc gcVar = this.wj;
        if (j2 < 0 || gcVar == null) {
            return;
        }
        com.bytedance.sdk.component.utils.wp.z("SegmentReader", "markProgress: curSegmentReadOffset = " + j2 + ", threadIndex = " + this.dl);
        gcVar.z(j2, j);
    }

    long z(long j, long j2) {
        com.ss.android.socialbase.downloader.pf.gc gcVar = this.wj;
        if (gcVar == null) {
            return -1L;
        }
        return gcVar.g(j, j2);
    }

    long gz() {
        return this.fv;
    }
}
