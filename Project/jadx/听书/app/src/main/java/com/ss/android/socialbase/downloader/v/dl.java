package com.ss.android.socialbase.downloader.v;

import android.os.Handler;
import android.os.Process;
import android.support.v4.media.session.PlaybackStateCompat;
import android.text.TextUtils;
import android.util.Log;
import androidx.media3.exoplayer.analytics.AnalyticsListener;
import com.ss.android.socialbase.downloader.a.js;
import com.ss.android.socialbase.downloader.a.l;
import com.ss.android.socialbase.downloader.a.sy;
import com.ss.android.socialbase.downloader.a.uf;
import com.ss.android.socialbase.downloader.downloader.tb;
import com.ss.android.socialbase.downloader.downloader.uy;
import com.ss.android.socialbase.downloader.downloader.wp;
import com.ss.android.socialbase.downloader.e.g;
import com.ss.android.socialbase.downloader.fo.fo;
import com.ss.android.socialbase.downloader.impls.fv;
import com.ss.android.socialbase.downloader.impls.p;
import com.ss.android.socialbase.downloader.kb.kb;
import com.ss.android.socialbase.downloader.kb.v;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import javax.net.ssl.SSLHandshakeException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
public class dl implements m, Runnable {
    private static final String z = "dl";
    private final com.ss.android.socialbase.downloader.e.a dl;
    private volatile com.ss.android.socialbase.downloader.downloader.gc e;
    private boolean fo;
    private final uy fv;
    private Future g;
    private AtomicInteger gc;
    private boolean gz;
    private js hh;
    private final AtomicBoolean i;
    private fo io;
    private final com.ss.android.socialbase.downloader.downloader.m iq;
    private com.ss.android.socialbase.downloader.downloader.fo js;
    private boolean kb;
    private com.ss.android.socialbase.downloader.e.dl ls;
    private long mc;
    private uy p;
    private final wp pf;
    private tb q;
    private uf sy;
    private final com.ss.android.socialbase.downloader.downloader.fo tb;
    private final com.ss.android.socialbase.downloader.i.z ti;
    private com.ss.android.socialbase.downloader.fo.e uf;
    private long un;
    private boolean uy;
    private boolean wp;
    private String x;
    private volatile com.ss.android.socialbase.downloader.gc.z zw;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private volatile boolean f2112a = false;
    private final ArrayList<g> m = new ArrayList<>();
    private volatile com.ss.android.socialbase.downloader.g.uy v = com.ss.android.socialbase.downloader.g.uy.RUN_STATUS_NONE;
    private volatile int l = 5;
    private boolean h = false;
    private boolean gk = false;
    private boolean lq = false;
    private int eo = 0;
    private volatile kb oq = null;

    private boolean oq() {
        return false;
    }

    public dl(com.ss.android.socialbase.downloader.e.a aVar, Handler handler) {
        this.dl = aVar;
        if (aVar != null) {
            this.ls = aVar.z();
            this.p = aVar.m();
            this.js = aVar.tb();
            this.sy = aVar.gz();
            this.hh = aVar.fo();
            this.q = z(aVar);
            this.ti = com.ss.android.socialbase.downloader.i.z.z(this.ls.e());
        } else {
            this.ti = com.ss.android.socialbase.downloader.i.z.dl();
        }
        gz();
        this.pf = com.ss.android.socialbase.downloader.downloader.dl.io();
        this.fv = com.ss.android.socialbase.downloader.downloader.dl.ti();
        this.tb = com.ss.android.socialbase.downloader.downloader.dl.oq();
        this.iq = new com.ss.android.socialbase.downloader.downloader.m(aVar, handler);
        this.i = new AtomicBoolean(true);
    }

    private void gz() {
        com.ss.android.socialbase.downloader.e.dl dlVar = this.ls;
        if (dlVar == null) {
            return;
        }
        int iOq = dlVar.oq() - this.ls.bw();
        if (iOq < 0) {
            iOq = 0;
        }
        AtomicInteger atomicInteger = this.gc;
        if (atomicInteger == null) {
            this.gc = new AtomicInteger(iOq);
        } else {
            atomicInteger.set(iOq);
        }
    }

    public void z() {
        this.v = com.ss.android.socialbase.downloader.g.uy.RUN_STATUS_PAUSE;
        if (this.oq != null) {
            this.oq.g();
        }
        if (this.e != null) {
            this.e.g();
        }
        if (this.oq == null && this.e == null) {
            js();
            this.v = com.ss.android.socialbase.downloader.g.uy.RUN_STATUS_PAUSE;
            ls();
        }
        try {
            for (g gVar : (ArrayList) this.m.clone()) {
                if (gVar != null) {
                    gVar.z();
                }
            }
        } catch (Throwable th) {
            com.bytedance.sdk.component.utils.wp.z(th);
        }
    }

    public void g() {
        this.v = com.ss.android.socialbase.downloader.g.uy.RUN_STATUS_CANCELED;
        if (this.oq != null) {
            this.oq.z();
        }
        if (this.e != null) {
            this.e.dl();
        }
        if (this.oq == null && this.e == null) {
            js();
            this.v = com.ss.android.socialbase.downloader.g.uy.RUN_STATUS_CANCELED;
            ls();
        }
        ti();
    }

    public com.ss.android.socialbase.downloader.e.a dl() {
        return this.dl;
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x005c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private int z(long r5, java.util.List<com.ss.android.socialbase.downloader.e.g> r7) {
        /*
            r4 = this;
            boolean r0 = r4.h()
            if (r0 == 0) goto L5c
            boolean r0 = r4.fo
            if (r0 == 0) goto L18
            if (r7 == 0) goto L11
            int r7 = r7.size()
            goto L5a
        L11:
            com.ss.android.socialbase.downloader.e.dl r7 = r4.ls
            int r7 = r7.ux()
            goto L5a
        L18:
            com.ss.android.socialbase.downloader.downloader.uy r7 = r4.p
            if (r7 == 0) goto L21
            int r7 = r7.z(r5)
            goto L27
        L21:
            com.ss.android.socialbase.downloader.downloader.uy r7 = r4.fv
            int r7 = r7.z(r5)
        L27:
            com.ss.android.socialbase.downloader.fo.wp r0 = com.ss.android.socialbase.downloader.fo.wp.z()
            com.ss.android.socialbase.downloader.fo.i r0 = r0.g()
            java.lang.String r1 = com.ss.android.socialbase.downloader.v.dl.z
            java.lang.String r2 = r0.name()
            java.lang.Object[] r2 = new java.lang.Object[]{r2}
            java.lang.String r3 = "NetworkQuality is : %s"
            java.lang.String r2 = java.lang.String.format(r3, r2)
            com.ss.android.socialbase.downloader.m.z.g(r1, r2)
            com.ss.android.socialbase.downloader.e.dl r1 = r4.ls
            java.lang.String r2 = r0.name()
            r1.gz(r2)
            com.ss.android.socialbase.downloader.downloader.fo r1 = r4.js
            if (r1 == 0) goto L54
            int r7 = r1.z(r7, r0)
            goto L5a
        L54:
            com.ss.android.socialbase.downloader.downloader.fo r1 = r4.tb
            int r7 = r1.z(r7, r0)
        L5a:
            if (r7 > 0) goto L5d
        L5c:
            r7 = 1
        L5d:
            boolean r0 = com.ss.android.socialbase.downloader.m.z.z()
            if (r0 == 0) goto L80
            java.lang.String r0 = com.ss.android.socialbase.downloader.v.dl.z
            java.lang.String r1 = java.lang.String.valueOf(r7)
            com.ss.android.socialbase.downloader.e.dl r2 = r4.ls
            java.lang.String r2 = r2.gz()
            java.lang.String r5 = java.lang.String.valueOf(r5)
            java.lang.Object[] r5 = new java.lang.Object[]{r1, r2, r5}
            java.lang.String r6 = "chunk count : %s for %s contentLen:%s"
            java.lang.String r5 = java.lang.String.format(r6, r5)
            com.ss.android.socialbase.downloader.m.z.g(r0, r5)
        L80:
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ss.android.socialbase.downloader.v.dl.z(long, java.util.List):int");
    }

    private boolean fo() {
        int iP = this.ls.p();
        if (iP == 1 || this.ls.pd()) {
            return true;
        }
        if (iP == -2 || iP == -4) {
            return false;
        }
        g(new com.ss.android.socialbase.downloader.gc.z(1000, "The download Task can't start, because its status is not prepare:" + iP));
        return false;
    }

    /* JADX WARN: Not initialized variable reg: 4, insn: 0x00ee: IF  (r4 I:??[int, boolean, OBJECT, ARRAY, byte, short, char]) == (0 ??[int, boolean, OBJECT, ARRAY, byte, short, char])  -> B:82:0x00f8, block:B:79:0x00ee */
    /* JADX WARN: Removed duplicated region for block: B:104:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:62:0x00af A[Catch: all -> 0x00eb, TryCatch #5 {all -> 0x00eb, blocks: (B:60:0x00ab, B:62:0x00af, B:64:0x00b3, B:76:0x00ea), top: B:93:0x0003 }] */
    /* JADX WARN: Removed duplicated region for block: B:66:0x00d1  */
    /* JADX WARN: Removed duplicated region for block: B:82:0x00f8 A[Catch: SQLiteException -> 0x0100, TRY_LEAVE, TryCatch #3 {SQLiteException -> 0x0100, blocks: (B:80:0x00f0, B:82:0x00f8), top: B:91:0x00f0 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void uy() throws com.ss.android.socialbase.downloader.gc.g {
        /*
            Method dump skipped, instruction units count: 261
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ss.android.socialbase.downloader.v.dl.uy():void");
    }

    @Override // java.lang.Runnable
    public void run() {
        com.ss.android.socialbase.downloader.downloader.dl.z(this.dl, 3);
        try {
            com.ss.android.socialbase.downloader.fo.g.z().g();
            kb();
            com.ss.android.socialbase.downloader.fo.g.z().dl();
            com.ss.android.socialbase.downloader.downloader.dl.g(this.dl, 3);
        } catch (Throwable th) {
            com.ss.android.socialbase.downloader.fo.g.z().dl();
            throw th;
        }
    }

    private void kb() {
        Process.setThreadPriority(10);
        try {
            com.ss.android.socialbase.downloader.e.dl dlVar = this.ls;
            if (dlVar != null && this.un > 0) {
                dlVar.dl(System.currentTimeMillis() - this.un);
            }
        } catch (Throwable unused) {
        }
        try {
            sy syVarDl = this.dl.dl();
            if (syVarDl != null) {
                if (syVarDl.z()) {
                    this.iq.gc();
                    return;
                }
            }
        } catch (Throwable th) {
            com.bytedance.sdk.component.utils.wp.z(th);
        }
        if (!fo()) {
            l lVarGc = this.dl.gc();
            com.ss.android.socialbase.downloader.e.dl dlVar2 = this.ls;
            com.ss.android.socialbase.downloader.gc.z zVar = new com.ss.android.socialbase.downloader.gc.z(1003, "task status is invalid");
            com.ss.android.socialbase.downloader.e.dl dlVar3 = this.ls;
            com.ss.android.socialbase.downloader.gz.z.z(lVarGc, dlVar2, zVar, dlVar3 != null ? dlVar3.p() : 0);
            return;
        }
        while (true) {
            wp();
            if (!this.h) {
                return;
            }
            if (this.l > 0) {
                this.l--;
            } else if (this.ls.sf() != this.ls.s()) {
                com.ss.android.socialbase.downloader.m.z.g(z, this.ls.a());
                this.iq.z(new com.ss.android.socialbase.downloader.gc.e(AnalyticsListener.EVENT_DRM_SESSION_RELEASED, "current bytes is not equals to total bytes, bytes invalid retry status is : " + this.ls.yw()));
                return;
            } else if (this.ls.sf() <= 0) {
                com.ss.android.socialbase.downloader.m.z.g(z, this.ls.a());
                this.iq.z(new com.ss.android.socialbase.downloader.gc.e(AnalyticsListener.EVENT_DRM_KEYS_REMOVED, "curBytes is 0, bytes invalid retry status is : " + this.ls.yw()));
                return;
            } else if (this.ls.s() <= 0) {
                com.ss.android.socialbase.downloader.m.z.g(z, this.ls.a());
                this.iq.z(new com.ss.android.socialbase.downloader.gc.e(1044, "TotalBytes is 0, bytes invalid retry status is : " + this.ls.yw()));
                return;
            }
        }
    }

    private void wp() {
        boolean z2;
        List<com.ss.android.socialbase.downloader.e.g> listDl;
        try {
            this.v = com.ss.android.socialbase.downloader.g.uy.RUN_STATUS_NONE;
            this.ls.vm();
            this.ls.bm();
            long jCurrentTimeMillis = System.currentTimeMillis();
            this.ls.z(-1L);
            try {
                uy();
                z2 = false;
            } catch (com.ss.android.socialbase.downloader.gc.g e) {
                com.ss.android.socialbase.downloader.m.z.g(z, "file exist " + e.a());
                this.x = e.a();
                z2 = true;
            }
            if (!this.h) {
                this.iq.g();
            }
            this.h = false;
            if (iq()) {
                return;
            }
            if (!TextUtils.isEmpty(this.x) && z2) {
                if (this.ls.lk()) {
                    this.lq = com.ss.android.socialbase.downloader.pf.m.a(this.ls);
                }
                if (!this.lq) {
                    i();
                    return;
                }
            }
            while (!iq()) {
                try {
                    try {
                        try {
                            lq();
                            l();
                            x();
                            listDl = this.pf.dl(this.ls.e());
                            mc();
                        } catch (com.ss.android.socialbase.downloader.gc.uy e2) {
                            try {
                                com.ss.android.socialbase.downloader.m.z.a(z, "downloadInner: retry throwable for " + e2.z());
                                if (this.v != com.ss.android.socialbase.downloader.g.uy.RUN_STATUS_PAUSE) {
                                    AtomicInteger atomicInteger = this.gc;
                                    if (atomicInteger != null && atomicInteger.get() > 0) {
                                        this.ls.fo(this.gc.decrementAndGet());
                                        this.ls.a(5);
                                    } else if (this.gc == null) {
                                        g(new com.ss.android.socialbase.downloader.gc.z(1043, "retry for Throwable, but retain retry time is NULL, last error is" + e2.z()));
                                    } else if (this.ls.aq()) {
                                        this.ls.a(5);
                                        this.gc.set(this.ls.oq());
                                        this.ls.fo(this.gc.get());
                                    } else {
                                        g(new com.ss.android.socialbase.downloader.gc.z(1018, String.format("retry for Throwable, but retry Time %s all used, last error is %s", String.valueOf(this.ls.oq()), e2.z())));
                                    }
                                    js();
                                }
                            } catch (Throwable th) {
                                js();
                                throw th;
                            }
                        } catch (com.ss.android.socialbase.downloader.gc.z e3) {
                            com.ss.android.socialbase.downloader.m.z.a(z, "downloadInner: baseException = " + e3);
                            if (this.v != com.ss.android.socialbase.downloader.g.uy.RUN_STATUS_PAUSE) {
                                if (e3.z() != 1025 && e3.z() != 1009) {
                                    if (z(e3)) {
                                        if (com.ss.android.socialbase.downloader.pf.m.z(e3)) {
                                            un();
                                        }
                                        if (z(e3, 0L) == com.ss.android.socialbase.downloader.gc.fo.RETURN) {
                                            js();
                                            return;
                                        }
                                        js();
                                    } else {
                                        g(e3);
                                    }
                                }
                                this.v = com.ss.android.socialbase.downloader.g.uy.RUN_STATUS_END_RIGHT_NOW;
                                js();
                                return;
                            }
                        }
                    } catch (Throwable th2) {
                        com.ss.android.socialbase.downloader.m.z.a(z, "downloadInner: throwable =  " + th2);
                        if (this.v != com.ss.android.socialbase.downloader.g.uy.RUN_STATUS_PAUSE) {
                            g(new com.ss.android.socialbase.downloader.gc.z(1045, th2));
                        }
                    }
                } catch (com.ss.android.socialbase.downloader.gc.g unused) {
                    i();
                }
                if (v()) {
                    com.ss.android.socialbase.downloader.m.z.dl(z, "downloadSegments return");
                    js();
                    return;
                }
                String strGp = this.ls.gp();
                if (iq()) {
                    js();
                    return;
                }
                long jGc = this.fo ? com.ss.android.socialbase.downloader.pf.m.gc(this.ls) : 0L;
                com.ss.android.socialbase.downloader.e.g gVarZ = z(this.ls, jGc);
                List<com.ss.android.socialbase.downloader.e.gc> listZ = z(gVarZ);
                com.ss.android.socialbase.downloader.pf.m.z(listZ, this.ls);
                com.ss.android.socialbase.downloader.pf.m.g(listZ, this.ls);
                this.ls.pf(0);
                long jCurrentTimeMillis2 = System.currentTimeMillis();
                try {
                    z(strGp, listZ, jGc);
                    this.ls.g(System.currentTimeMillis() - jCurrentTimeMillis2);
                    if (iq()) {
                        js();
                        return;
                    }
                    long jS = this.ls.s();
                    z(jS);
                    int iZ = z(jS, listDl);
                    if (iq()) {
                        js();
                        return;
                    }
                    if (iZ <= 0) {
                        throw new com.ss.android.socialbase.downloader.gc.z(1032, "chunkCount is 0");
                    }
                    boolean z3 = iZ == 1;
                    this.gz = z3;
                    if (z3) {
                        if (this.io == null) {
                            try {
                                jCurrentTimeMillis2 = System.currentTimeMillis();
                                z(strGp, listZ);
                                this.ls.g(System.currentTimeMillis() - jCurrentTimeMillis2);
                            } finally {
                            }
                        }
                        if (iq()) {
                            js();
                            return;
                        } else {
                            this.ls.z(System.currentTimeMillis() - jCurrentTimeMillis);
                            pf();
                            z(gVarZ, strGp, this.io);
                        }
                    } else {
                        if (!this.ls.sd()) {
                            fv();
                        }
                        if (iq()) {
                            js();
                            return;
                        }
                        pf();
                        this.ls.z(System.currentTimeMillis() - jCurrentTimeMillis);
                        if (this.fo) {
                            z(iZ, listDl);
                        } else {
                            z(jS, iZ);
                        }
                    }
                    js();
                    return;
                } finally {
                }
            }
        } finally {
            ls();
        }
    }

    private void i() {
        com.ss.android.socialbase.downloader.m.z.g(z, "finishWithFileExist");
        if (com.ss.android.socialbase.downloader.i.z.dl().g("fix_end_for_file_exist_error", true)) {
            if (this.x.equals(this.ls.gz())) {
                this.v = com.ss.android.socialbase.downloader.g.uy.RUN_STATUS_END_RIGHT_NOW;
                return;
            } else {
                this.v = com.ss.android.socialbase.downloader.g.uy.RUN_STATUS_END_FOR_FILE_EXIST;
                return;
            }
        }
        if (this.x.equals(this.ls.v())) {
            this.v = com.ss.android.socialbase.downloader.g.uy.RUN_STATUS_END_RIGHT_NOW;
        } else {
            this.v = com.ss.android.socialbase.downloader.g.uy.RUN_STATUS_END_FOR_FILE_EXIST;
        }
    }

    private boolean v() throws InterruptedException, com.ss.android.socialbase.downloader.gc.z {
        if (this.ls.lk() || this.ls.ux() != 1 || this.ls.ep() > 0) {
            return false;
        }
        JSONObject jSONObjectA = com.ss.android.socialbase.downloader.i.z.z(this.ls.e()).a("segment_config");
        List<com.ss.android.socialbase.downloader.kb.fo> listV = this.pf.v(this.ls.e());
        if (this.ls.sf() > 0) {
            if (listV == null || listV.isEmpty()) {
                return false;
            }
            if (jSONObjectA == null) {
                jSONObjectA = new JSONObject();
            }
        }
        if (jSONObjectA == null) {
            return false;
        }
        this.oq = new kb(this.ls, v.z(jSONObjectA), this);
        if (iq()) {
            com.ss.android.socialbase.downloader.m.z.dl(z, "downloadSegments: is stopped by user");
            if (this.v == com.ss.android.socialbase.downloader.g.uy.RUN_STATUS_CANCELED) {
                this.oq.z();
            } else {
                this.oq.g();
            }
            return true;
        }
        return this.oq.z(listV);
    }

    private void pf() {
        if (com.ss.android.socialbase.downloader.i.z.z(this.ls.e()).z("reset_retain_retry_times", 0) != 1 || this.eo >= 3) {
            return;
        }
        this.gc.set(this.ls.t() ? this.ls.wj() : this.ls.oq());
        this.eo++;
    }

    private void z(String str, List<com.ss.android.socialbase.downloader.e.gc> list, long j) throws com.ss.android.socialbase.downloader.gc.uy, com.ss.android.socialbase.downloader.gc.z {
        g(str, list, j);
        com.ss.android.socialbase.downloader.fo.e eVar = this.uf;
        if (eVar != null) {
            try {
                z(str, eVar, j);
            } catch (Throwable unused) {
                this.gk = true;
            }
        }
        if (this.uf == null || this.gk) {
            z(str, list);
            z(str, this.io, j);
        }
    }

    private void ls() {
        boolean zZw;
        boolean z2;
        com.ss.android.socialbase.downloader.m.z.g(z, "endDownloadRunnable::runStatus=" + this.v);
        boolean z3 = (this.v == com.ss.android.socialbase.downloader.g.uy.RUN_STATUS_PAUSE || this.v == com.ss.android.socialbase.downloader.g.uy.RUN_STATUS_CANCELED) ? false : true;
        try {
            zZw = zw();
            z2 = false;
        } catch (Exception e) {
            if (e instanceof com.ss.android.socialbase.downloader.gc.z) {
                this.iq.z((com.ss.android.socialbase.downloader.gc.z) e);
            } else {
                this.iq.z(new com.ss.android.socialbase.downloader.gc.z(1046, e));
            }
            zZw = true;
            z2 = true;
        }
        if (zZw || z2) {
            this.i.set(false);
            if (z3) {
                try {
                    com.ss.android.socialbase.downloader.impls.z zVarH = com.ss.android.socialbase.downloader.downloader.dl.h();
                    if (zVarH != null) {
                        zVarH.z(this);
                        return;
                    }
                    return;
                } catch (Throwable th) {
                    com.bytedance.sdk.component.utils.wp.z(th);
                    l lVarGc = this.dl.gc();
                    com.ss.android.socialbase.downloader.e.dl dlVar = this.ls;
                    com.ss.android.socialbase.downloader.gc.z zVar = new com.ss.android.socialbase.downloader.gc.z(1014, com.ss.android.socialbase.downloader.pf.m.g(th, "removeDownloadRunnable"));
                    com.ss.android.socialbase.downloader.e.dl dlVar2 = this.ls;
                    com.ss.android.socialbase.downloader.gz.z.z(lVarGc, dlVar, zVar, dlVar2 != null ? dlVar2.p() : 0);
                    return;
                }
            }
            return;
        }
        this.h = true;
        com.ss.android.socialbase.downloader.m.z.g(z, "jump to restart");
    }

    private void g(String str, List<com.ss.android.socialbase.downloader.e.gc> list, long j) throws com.ss.android.socialbase.downloader.gc.uy, com.ss.android.socialbase.downloader.gc.z {
        com.ss.android.socialbase.downloader.fo.z.dl dlVarZ;
        boolean z2 = true;
        if (this.ls.ux() == 1 && (dlVarZ = com.ss.android.socialbase.downloader.fo.z.z.z().z(str, list)) != null) {
            this.uf = dlVarZ;
            this.ls.pf(1);
        }
        if (this.uf == null && !this.gk && this.ls.wn()) {
            try {
                int iG = this.ti.g("net_lib_strategy");
                if (this.ti.z("monitor_download_connect", 0) <= 0) {
                    z2 = false;
                }
                this.uf = com.ss.android.socialbase.downloader.downloader.dl.z(str, list, iG, z2, this.ls);
            } catch (Throwable th) {
                this.ls.z(com.ss.android.socialbase.downloader.pf.m.uy(th));
            }
        }
    }

    private void z(String str, List<com.ss.android.socialbase.downloader.e.gc> list) throws com.ss.android.socialbase.downloader.gc.uy, com.ss.android.socialbase.downloader.gc.z {
        fo foVarZ;
        if (this.io != null) {
            return;
        }
        com.ss.android.socialbase.downloader.fo.z.a aVarG = this.ls.ux() == 1 ? com.ss.android.socialbase.downloader.fo.z.z.z().g(str, list) : null;
        try {
            if (aVarG != null) {
                z(this.io);
                this.ls.pf(2);
                this.io = aVarG;
            } else {
                try {
                    foVarZ = com.ss.android.socialbase.downloader.downloader.dl.z(this.ls.pf(), this.ls.eo(), str, null, list, this.ti.g("net_lib_strategy"), this.ti.z("monitor_download_connect", 0) > 0, this.ls);
                    this.io = foVarZ;
                } catch (com.ss.android.socialbase.downloader.gc.z e) {
                    throw e;
                } catch (Throwable th) {
                    if (this.ls.lk() && com.ss.android.socialbase.downloader.pf.m.e(th) && com.ss.android.socialbase.downloader.pf.m.dl(list)) {
                        com.ss.android.socialbase.downloader.m.z.g(z, "dcache=execepiton responseCode=304 lastModified not changed, use local file.. old cacheControl=" + this.ls.b());
                        long jFo = com.ss.android.socialbase.downloader.pf.m.fo(this.ls.b());
                        if (jFo <= 0) {
                            jFo = com.ss.android.socialbase.downloader.i.z.z(this.ls.e()).z("default_304_max_age", 300);
                        }
                        this.ls.a(System.currentTimeMillis() + (jFo * 1000));
                        throw new com.ss.android.socialbase.downloader.gc.g(this.x);
                    }
                    if (com.ss.android.socialbase.downloader.pf.m.m(th)) {
                        z("", "http code 416");
                    } else if (com.ss.android.socialbase.downloader.pf.m.gc(th)) {
                        z("", "http code 412");
                    } else {
                        com.ss.android.socialbase.downloader.pf.m.z(th, "CreateFirstConnection");
                    }
                    foVarZ = this.io;
                }
                z(foVarZ);
            }
            if (this.io == null) {
                throw new com.ss.android.socialbase.downloader.gc.z(AnalyticsListener.EVENT_DRM_SESSION_ACQUIRED, new IOException("download can't continue, firstConnection is null"));
            }
        } catch (Throwable th2) {
            z(this.io);
            throw th2;
        }
    }

    private void p() {
        com.ss.android.socialbase.downloader.fo.e eVar = this.uf;
        if (eVar != null) {
            eVar.dl();
            this.uf = null;
        }
    }

    private void fv() {
        fo foVar = this.io;
        if (foVar != null) {
            foVar.a();
            this.io = null;
        }
    }

    private void js() {
        p();
        fv();
    }

    public static com.ss.android.socialbase.downloader.e.g z(com.ss.android.socialbase.downloader.e.dl dlVar, long j) {
        return new g.z(dlVar.e()).z(-1).z(0L).gc(j).g(j).dl(0L).a(dlVar.s() - j).z();
    }

    private List<com.ss.android.socialbase.downloader.e.gc> z(com.ss.android.socialbase.downloader.e.g gVar) {
        List<com.ss.android.socialbase.downloader.e.gc> listZ = com.ss.android.socialbase.downloader.pf.m.z(this.ls.ti(), this.ls.n(), gVar);
        if (this.ls.lk() && this.lq && this.ls.lw() != null) {
            listZ.add(new com.ss.android.socialbase.downloader.e.gc("if-modified-since", this.ls.lw()));
            listZ.add(new com.ss.android.socialbase.downloader.e.gc("download-tc21-1-15", "download-tc21-1-15"));
            com.ss.android.socialbase.downloader.m.z.g(z, "dcache::add head IF_MODIFIED_SINCE=" + this.ls.lw());
        }
        return listZ;
    }

    private void tb() throws com.ss.android.socialbase.downloader.gc.z {
        if (this.e != null) {
            if (this.v == com.ss.android.socialbase.downloader.g.uy.RUN_STATUS_CANCELED) {
                this.ls.a(-4);
                this.e.dl();
            } else if (this.v == com.ss.android.socialbase.downloader.g.uy.RUN_STATUS_PAUSE) {
                this.ls.a(-2);
                this.e.g();
            } else {
                this.e.a();
            }
        }
    }

    private boolean q() {
        return this.v == com.ss.android.socialbase.downloader.g.uy.RUN_STATUS_CANCELED || this.v == com.ss.android.socialbase.downloader.g.uy.RUN_STATUS_PAUSE;
    }

    private boolean iq() {
        if (!q() && this.ls.p() != -2) {
            return false;
        }
        if (q()) {
            return true;
        }
        if (this.ls.p() == -2) {
            this.v = com.ss.android.socialbase.downloader.g.uy.RUN_STATUS_PAUSE;
            return true;
        }
        if (this.ls.p() != -4) {
            return true;
        }
        this.v = com.ss.android.socialbase.downloader.g.uy.RUN_STATUS_CANCELED;
        return true;
    }

    private boolean zw() {
        if (this.v == com.ss.android.socialbase.downloader.g.uy.RUN_STATUS_ERROR) {
            this.iq.z(this.zw);
        } else if (this.v == com.ss.android.socialbase.downloader.g.uy.RUN_STATUS_CANCELED) {
            this.iq.dl();
        } else if (this.v == com.ss.android.socialbase.downloader.g.uy.RUN_STATUS_PAUSE) {
            this.iq.a();
        } else if (this.v == com.ss.android.socialbase.downloader.g.uy.RUN_STATUS_END_RIGHT_NOW) {
            try {
                this.iq.e();
            } catch (com.ss.android.socialbase.downloader.gc.z e) {
                this.iq.z(e);
            }
        } else if (this.v == com.ss.android.socialbase.downloader.g.uy.RUN_STATUS_END_FOR_FILE_EXIST) {
            try {
                this.iq.z(this.x);
            } catch (com.ss.android.socialbase.downloader.gc.z e2) {
                this.iq.z(e2);
            }
        } else {
            if (this.v == com.ss.android.socialbase.downloader.g.uy.RUN_STATUS_ALL_CHUNK_RETRY_WITH_RESET) {
                this.iq.z(this.zw, false);
                return false;
            }
            if (this.v == com.ss.android.socialbase.downloader.g.uy.RUN_STATUS_WAITING_ASYNC_HANDLER) {
                return true;
            }
            if (this.v == com.ss.android.socialbase.downloader.g.uy.RUN_STATUS_RETRY_DELAY && !io()) {
                com.ss.android.socialbase.downloader.m.z.g(z, "doTaskStatusHandle retryDelay");
                sy();
                return this.v == com.ss.android.socialbase.downloader.g.uy.RUN_STATUS_RETRY_DELAY;
            }
            try {
                if (!uf()) {
                    return false;
                }
                this.iq.m();
                fv.z().a();
            } catch (Throwable th) {
                g(new com.ss.android.socialbase.downloader.gc.z(1008, com.ss.android.socialbase.downloader.pf.m.g(th, "doTaskStatusHandle onComplete")));
            }
        }
        return true;
    }

    private boolean io() {
        if (this.ls.ux() <= 1) {
            return this.ls.sf() > 0 && this.ls.sf() == this.ls.s();
        }
        List<com.ss.android.socialbase.downloader.e.g> listDl = this.pf.dl(this.ls.e());
        if (listDl == null || listDl.size() <= 1) {
            return false;
        }
        for (com.ss.android.socialbase.downloader.e.g gVar : listDl) {
            if (gVar == null || !gVar.fo()) {
                return false;
            }
        }
        return true;
    }

    private boolean uf() {
        if (this.ls.c()) {
            com.ss.android.socialbase.downloader.e.dl dlVar = this.ls;
            dlVar.e(dlVar.sf());
        }
        com.ss.android.socialbase.downloader.m.z.dl(z, "checkCompletedByteValid: downloadInfo.getCurBytes() = " + this.ls.sf() + ",  downloadInfo.getTotalBytes() = " + this.ls.s());
        if (this.ls.sf() > 0) {
            if (this.ls.nb()) {
                return true;
            }
            if (this.ls.s() > 0 && this.ls.sf() == this.ls.s()) {
                return true;
            }
        }
        this.ls.z(com.ss.android.socialbase.downloader.g.g.BYTE_INVALID_RETRY_STATUS_RESTART);
        this.ls.oc();
        this.pf.z(this.ls);
        this.pf.a(this.ls.e());
        this.pf.i(this.ls.e());
        com.ss.android.socialbase.downloader.pf.m.z(this.ls);
        return false;
    }

    private void sy() {
        this.v = com.ss.android.socialbase.downloader.g.uy.RUN_STATUS_NONE;
    }

    private long hh() {
        return this.q.z(this.ls.xl(), this.ls.na());
    }

    private void l() throws com.ss.android.socialbase.downloader.gc.uy, com.ss.android.socialbase.downloader.gc.z {
        com.ss.android.socialbase.downloader.impls.z zVarH;
        int iE = this.ls.e();
        int iZ = com.ss.android.socialbase.downloader.downloader.dl.z(this.ls);
        if (this.ls.qz() && !this.ls.lk() && !this.lq) {
            throw new com.ss.android.socialbase.downloader.gc.z(1009, "file has downloaded");
        }
        com.ss.android.socialbase.downloader.e.dl dlVarG = this.pf.g(iZ);
        if (dlVarG == null || (zVarH = com.ss.android.socialbase.downloader.downloader.dl.h()) == null || dlVarG.e() == iE || !dlVarG.g(this.ls)) {
            return;
        }
        if (zVarH.z(dlVarG.e())) {
            this.pf.m(iE);
            throw new com.ss.android.socialbase.downloader.gc.z(1025, "another same task is downloading");
        }
        List<com.ss.android.socialbase.downloader.e.g> listDl = this.pf.dl(iZ);
        com.ss.android.socialbase.downloader.pf.m.z(this.ls);
        this.pf.m(iZ);
        if (dlVarG == null || !dlVarG.um()) {
            return;
        }
        this.ls.z(dlVarG, false);
        this.pf.z(this.ls);
        if (listDl != null) {
            for (com.ss.android.socialbase.downloader.e.g gVar : listDl) {
                gVar.g(iE);
                this.pf.z(gVar);
            }
        }
        throw new com.ss.android.socialbase.downloader.gc.uy("retry task because id generator changed");
    }

    private void z(int i, List<com.ss.android.socialbase.downloader.e.g> list) throws com.ss.android.socialbase.downloader.gc.z {
        if (list.size() != i) {
            throw new com.ss.android.socialbase.downloader.gc.z(1033, new IllegalArgumentException());
        }
        z(list, this.ls.s());
    }

    private void z(long j, int i) throws com.ss.android.socialbase.downloader.gc.z {
        long j2 = j / ((long) i);
        int iE = this.ls.e();
        ArrayList arrayList = new ArrayList();
        int i2 = 0;
        long j3 = 0;
        while (i2 < i) {
            com.ss.android.socialbase.downloader.e.g gVarZ = new g.z(iE).z(i2).z(j3).gc(j3).g(j3).dl(i2 == i + (-1) ? 0L : (j3 + j2) - 1).z();
            arrayList.add(gVarZ);
            this.pf.z(gVarZ);
            j3 += j2;
            i2++;
        }
        this.ls.gc(i);
        this.pf.z(iE, i);
        z(arrayList, j);
    }

    private void z(List<com.ss.android.socialbase.downloader.e.g> list, long j) throws com.ss.android.socialbase.downloader.gc.z {
        long jLs;
        for (com.ss.android.socialbase.downloader.e.g gVar : list) {
            if (gVar != null) {
                if (gVar.ls() == 0) {
                    jLs = j - gVar.v();
                } else {
                    jLs = (gVar.ls() - gVar.v()) + 1;
                }
                if (jLs > 0) {
                    gVar.z(jLs);
                    if (this.ls.sd() && this.io != null && (!this.ls.wn() || this.gk)) {
                        if (gVar.js() == 0) {
                            this.m.add(new g(gVar, this.dl, this.io, this));
                        } else if (gVar.js() > 0) {
                            this.m.add(new g(gVar, this.dl, this));
                        }
                    } else {
                        this.m.add(new g(gVar, this.dl, this));
                    }
                }
            }
        }
        if (com.ss.android.socialbase.downloader.pf.z.z(64)) {
            ArrayList arrayList = new ArrayList(this.m.size());
            for (g gVar2 : this.m) {
                if (this.v == com.ss.android.socialbase.downloader.g.uy.RUN_STATUS_CANCELED) {
                    gVar2.g();
                } else if (this.v == com.ss.android.socialbase.downloader.g.uy.RUN_STATUS_PAUSE) {
                    gVar2.z();
                } else {
                    arrayList.add(gVar2);
                }
            }
            try {
                List<Future> listA = com.ss.android.socialbase.downloader.impls.gc.a(arrayList);
                for (Runnable runnableGc = (Runnable) arrayList.remove(0); runnableGc != null; runnableGc = com.ss.android.socialbase.downloader.impls.gc.gc(listA)) {
                    if (iq()) {
                        return;
                    }
                    try {
                        runnableGc.run();
                    } catch (Throwable th) {
                        com.bytedance.sdk.component.utils.wp.z(th);
                    }
                }
                if (listA == null || listA.isEmpty()) {
                    return;
                }
                for (Future future : listA) {
                    if (future != null && !future.isDone()) {
                        try {
                            future.get();
                        } catch (Throwable unused) {
                        }
                    }
                }
                return;
            } catch (Throwable unused2) {
                return;
            }
        }
        ArrayList arrayList2 = new ArrayList(this.m.size());
        for (g gVar3 : this.m) {
            if (this.v == com.ss.android.socialbase.downloader.g.uy.RUN_STATUS_CANCELED) {
                gVar3.g();
            } else if (this.v == com.ss.android.socialbase.downloader.g.uy.RUN_STATUS_PAUSE) {
                gVar3.z();
            } else {
                arrayList2.add(Executors.callable(gVar3));
            }
        }
        if (iq()) {
            return;
        }
        try {
            com.ss.android.socialbase.downloader.impls.gc.dl(arrayList2);
        } catch (InterruptedException e) {
            throw new com.ss.android.socialbase.downloader.gc.z(1020, e);
        }
    }

    private void z(com.ss.android.socialbase.downloader.e.g gVar, String str, fo foVar) throws com.ss.android.socialbase.downloader.gc.z {
        gVar.z(this.ls.s() - gVar.v());
        this.ls.gc(1);
        this.pf.z(this.ls.e(), 1);
        this.e = new com.ss.android.socialbase.downloader.downloader.gc(this.ls, str, foVar, gVar, this);
        tb();
    }

    private boolean h() {
        com.ss.android.socialbase.downloader.e.dl dlVar = this.ls;
        return (dlVar == null || dlVar.lk() || (this.fo && this.ls.ux() <= 1) || this.ls.kp() || !this.uy || this.wp) ? false : true;
    }

    /* JADX WARN: Can't wrap try/catch for region: R(9:89|(4:9|(1:11)|12|(4:14|15|16|(9:18|(2:20|(1:22)(2:23|24))(1:25)|26|(3:28|(1:30)|54)|87|55|56|77|78)(2:31|(6:33|87|55|56|77|78)(4:34|(1:36)(1:37)|38|39)))(1:40))(2:41|(4:43|(1:45)(1:46)|47|48)(2:51|(2:81|82)))|53|54|87|55|56|77|78) */
    /* JADX WARN: Code restructure failed: missing block: B:57:0x017a, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:59:0x017c, code lost:
    
        com.ss.android.socialbase.downloader.m.z.gc(com.ss.android.socialbase.downloader.v.dl.z, "checkSpaceOverflow: setLength1 e = " + r0 + ", mustSetLength = " + r4);
     */
    /* JADX WARN: Code restructure failed: missing block: B:61:0x019e, code lost:
    
        if (r7 >= r24) goto L75;
     */
    /* JADX WARN: Code restructure failed: missing block: B:66:0x01aa, code lost:
    
        r5.g(r7);
     */
    /* JADX WARN: Code restructure failed: missing block: B:68:0x01ae, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:70:0x01b0, code lost:
    
        com.ss.android.socialbase.downloader.m.z.gc(com.ss.android.socialbase.downloader.v.dl.z, "checkSpaceOverflow: setLength2 ex = " + r0 + ", mustSetLength = " + r4);
     */
    /* JADX WARN: Code restructure failed: missing block: B:71:0x01cc, code lost:
    
        if (r4 == false) goto L72;
     */
    /* JADX WARN: Code restructure failed: missing block: B:74:0x01d4, code lost:
    
        throw new com.ss.android.socialbase.downloader.gc.z(com.bykv.vk.component.ttvideo.mediakit.medialoader.AVMDLDataLoader.KeyIsPreloadWaitListType, r0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:75:0x01d5, code lost:
    
        if (r4 != false) goto L79;
     */
    /* JADX WARN: Code restructure failed: missing block: B:80:0x01e6, code lost:
    
        throw new com.ss.android.socialbase.downloader.gc.z(com.bykv.vk.component.ttvideo.mediakit.medialoader.AVMDLDataLoader.KeyIsPreloadWaitListType, r0);
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v22, types: [java.io.Closeable[]] */
    /* JADX WARN: Type inference failed for: r2v2, types: [java.io.Closeable[]] */
    /* JADX WARN: Type inference failed for: r5v15 */
    /* JADX WARN: Type inference failed for: r5v16 */
    /* JADX WARN: Type inference failed for: r5v2 */
    /* JADX WARN: Type inference failed for: r5v3 */
    /* JADX WARN: Type inference failed for: r5v4, types: [long] */
    /* JADX WARN: Type inference failed for: r5v5 */
    /* JADX WARN: Type inference failed for: r5v8, types: [com.ss.android.socialbase.downloader.e.e] */
    /* JADX WARN: Type inference failed for: r7v16 */
    /* JADX WARN: Type inference failed for: r7v17, types: [long] */
    /* JADX WARN: Type inference failed for: r7v22 */
    @Override // com.ss.android.socialbase.downloader.v.m
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void z(long r24) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 505
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ss.android.socialbase.downloader.v.dl.z(long):void");
    }

    private void gk() throws com.ss.android.socialbase.downloader.gc.z {
        long jA;
        int iZ;
        try {
            jA = com.ss.android.socialbase.downloader.pf.m.a(this.ls.wp());
        } catch (com.ss.android.socialbase.downloader.gc.z unused) {
            jA = 0;
        }
        String str = z;
        com.ss.android.socialbase.downloader.m.z.dl(str, "checkSpaceOverflowInProgress: available = " + com.ss.android.socialbase.downloader.pf.m.z(jA) + "MB");
        if (jA > 0) {
            long jS = this.ls.s() - this.ls.sf();
            if (jA < jS && (iZ = com.ss.android.socialbase.downloader.i.z.z(this.ls.e()).z("space_fill_min_keep_mb", 100)) > 0) {
                long j = jA - (((long) iZ) * PlaybackStateCompat.ACTION_SET_CAPTIONING_ENABLED);
                com.ss.android.socialbase.downloader.m.z.dl(str, "checkSpaceOverflowInProgress: minKeep  = " + iZ + "MB, canDownload = " + com.ss.android.socialbase.downloader.pf.m.z(j) + "MB");
                if (j <= 0) {
                    this.mc = 0L;
                    throw new com.ss.android.socialbase.downloader.gc.gc(jA, jS);
                }
                this.mc = this.ls.sf() + j + PlaybackStateCompat.ACTION_SET_CAPTIONING_ENABLED;
                return;
            }
        }
        this.mc = 0L;
    }

    private void x() throws com.ss.android.socialbase.downloader.gc.e {
        if (this.ls.io() && !com.ss.android.socialbase.downloader.pf.m.z(com.ss.android.socialbase.downloader.downloader.dl.xl(), com.kuaishou.weapon.p0.g.b)) {
            throw new com.ss.android.socialbase.downloader.gc.e(1019, String.format("download task need permission:%s", com.kuaishou.weapon.p0.g.b));
        }
        if (!this.ls.jc()) {
            throw new com.ss.android.socialbase.downloader.gc.a();
        }
        if (!this.ls.he()) {
            throw new com.ss.android.socialbase.downloader.gc.m();
        }
    }

    private void lq() throws com.ss.android.socialbase.downloader.gc.z {
        if (TextUtils.isEmpty(this.ls.kb())) {
            throw new com.ss.android.socialbase.downloader.gc.z(AnalyticsListener.EVENT_PLAYER_RELEASED, "download savePath can not be empty");
        }
        if (TextUtils.isEmpty(this.ls.gz())) {
            throw new com.ss.android.socialbase.downloader.gc.z(AnalyticsListener.EVENT_AUDIO_CODEC_ERROR, "download name can not be empty");
        }
        File file = new File(this.ls.kb());
        if (!file.exists()) {
            boolean zMkdirs = file.mkdirs();
            if (zMkdirs || file.exists()) {
                return;
            }
            int i = 0;
            if (com.ss.android.socialbase.downloader.i.z.z(this.ls.e()).z("opt_mkdir_failed", 0) == 1) {
                while (!zMkdirs) {
                    int i2 = i + 1;
                    if (i >= 3) {
                        break;
                    }
                    try {
                        Thread.sleep(10L);
                        zMkdirs = file.mkdirs();
                        i = i2;
                    } catch (InterruptedException unused) {
                    }
                }
                if (zMkdirs || file.exists()) {
                    return;
                }
                if (com.ss.android.socialbase.downloader.pf.m.a(this.ls.kb()) < 16384) {
                    throw new com.ss.android.socialbase.downloader.gc.z(1006, "download savePath directory can not created:" + this.ls.kb());
                }
                throw new com.ss.android.socialbase.downloader.gc.z(1030, "download savePath directory can not created:" + this.ls.kb());
            }
            throw new com.ss.android.socialbase.downloader.gc.z(1030, "download savePath directory can not created:" + this.ls.kb());
        }
        if (file.isDirectory()) {
            return;
        }
        if (com.ss.android.socialbase.downloader.pf.a.g(this.ls)) {
            file.delete();
            if (!file.mkdirs() && !file.exists()) {
                throw new com.ss.android.socialbase.downloader.gc.z(1031, "download savePath is not directory:path=" + this.ls.kb());
            }
            return;
        }
        throw new com.ss.android.socialbase.downloader.gc.z(1031, "download savePath is not a directory:" + this.ls.kb());
    }

    private boolean z(int i, String str, String str2) {
        if (i == 412) {
            return true;
        }
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2) || str.equals(str2) || !(this.kb || this.uy)) {
            return (i == 201 || i == 416) && this.ls.sf() > 0;
        }
        return true;
    }

    private void z(String str, String str2) throws com.ss.android.socialbase.downloader.gc.uy {
        this.pf.a(this.ls.e());
        this.pf.i(this.ls.e());
        com.ss.android.socialbase.downloader.pf.m.z(this.ls);
        this.fo = false;
        this.ls.wp(str);
        this.pf.z(this.ls);
        throw new com.ss.android.socialbase.downloader.gc.uy(str2);
    }

    /* JADX WARN: Removed duplicated region for block: B:33:0x0146 A[Catch: all -> 0x0354, uy -> 0x035c, z -> 0x035f, TryCatch #2 {uy -> 0x035c, z -> 0x035f, all -> 0x0354, blocks: (B:5:0x000f, B:7:0x0028, B:9:0x002e, B:10:0x0033, B:12:0x00e7, B:14:0x00f4, B:15:0x0107, B:17:0x010f, B:19:0x0113, B:33:0x0146, B:34:0x014c, B:35:0x016d, B:24:0x0121, B:26:0x012e, B:29:0x0137, B:38:0x0174, B:40:0x017c, B:42:0x0188, B:43:0x0192, B:45:0x0198, B:46:0x019d, B:48:0x01a8, B:50:0x01ae, B:52:0x01b4, B:56:0x01bd, B:60:0x01cc, B:62:0x01d2, B:67:0x01db, B:68:0x01e4, B:69:0x01e5, B:70:0x01f9, B:71:0x01fa, B:74:0x0200, B:76:0x0204, B:77:0x020a, B:78:0x0211, B:79:0x0212, B:83:0x0220, B:86:0x0229, B:87:0x022e, B:88:0x022f, B:90:0x023b, B:92:0x0247, B:96:0x0255, B:99:0x025a, B:100:0x025f, B:102:0x0262, B:104:0x0280, B:106:0x028b, B:109:0x02c2, B:111:0x02ce, B:113:0x02da, B:115:0x02e4, B:117:0x02e8, B:118:0x02ee, B:119:0x02f5, B:120:0x02f6, B:123:0x02fd, B:125:0x0309, B:127:0x031c, B:130:0x0327, B:131:0x034d, B:132:0x034e, B:107:0x02a2, B:57:0x01c3, B:58:0x01c8), top: B:143:0x000f }] */
    /* JADX WARN: Removed duplicated region for block: B:34:0x014c A[Catch: all -> 0x0354, uy -> 0x035c, z -> 0x035f, TryCatch #2 {uy -> 0x035c, z -> 0x035f, all -> 0x0354, blocks: (B:5:0x000f, B:7:0x0028, B:9:0x002e, B:10:0x0033, B:12:0x00e7, B:14:0x00f4, B:15:0x0107, B:17:0x010f, B:19:0x0113, B:33:0x0146, B:34:0x014c, B:35:0x016d, B:24:0x0121, B:26:0x012e, B:29:0x0137, B:38:0x0174, B:40:0x017c, B:42:0x0188, B:43:0x0192, B:45:0x0198, B:46:0x019d, B:48:0x01a8, B:50:0x01ae, B:52:0x01b4, B:56:0x01bd, B:60:0x01cc, B:62:0x01d2, B:67:0x01db, B:68:0x01e4, B:69:0x01e5, B:70:0x01f9, B:71:0x01fa, B:74:0x0200, B:76:0x0204, B:77:0x020a, B:78:0x0211, B:79:0x0212, B:83:0x0220, B:86:0x0229, B:87:0x022e, B:88:0x022f, B:90:0x023b, B:92:0x0247, B:96:0x0255, B:99:0x025a, B:100:0x025f, B:102:0x0262, B:104:0x0280, B:106:0x028b, B:109:0x02c2, B:111:0x02ce, B:113:0x02da, B:115:0x02e4, B:117:0x02e8, B:118:0x02ee, B:119:0x02f5, B:120:0x02f6, B:123:0x02fd, B:125:0x0309, B:127:0x031c, B:130:0x0327, B:131:0x034d, B:132:0x034e, B:107:0x02a2, B:57:0x01c3, B:58:0x01c8), top: B:143:0x000f }] */
    @Override // com.ss.android.socialbase.downloader.v.m
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void z(java.lang.String r21, com.ss.android.socialbase.downloader.fo.e r22, long r23) throws com.ss.android.socialbase.downloader.gc.uy, com.ss.android.socialbase.downloader.gc.z {
        /*
            Method dump skipped, instruction units count: 866
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ss.android.socialbase.downloader.v.dl.z(java.lang.String, com.ss.android.socialbase.downloader.fo.e, long):void");
    }

    public boolean a() {
        return this.i.get();
    }

    public int gc() {
        com.ss.android.socialbase.downloader.e.dl dlVar = this.ls;
        if (dlVar != null) {
            return dlVar.e();
        }
        return 0;
    }

    public void m() {
        this.un = System.currentTimeMillis();
        this.iq.z();
    }

    private void mc() {
        long jM = com.ss.android.socialbase.downloader.pf.m.m(this.ls);
        long jSf = this.ls.sf();
        if (jM != jSf) {
            com.ss.android.socialbase.downloader.m.z.a(z, "checkTaskCanResume: offset = " + jM + ", curBytes = " + jSf);
        }
        this.ls.gc(jM);
        boolean z2 = jM > 0;
        this.fo = z2;
        if (z2 || this.lq) {
            return;
        }
        com.ss.android.socialbase.downloader.m.z.dl(z, "checkTaskCanResume: deleteAllDownloadFiles");
        this.pf.a(this.ls.e());
        this.pf.i(this.ls.e());
        com.ss.android.socialbase.downloader.pf.m.z(this.ls);
    }

    @Override // com.ss.android.socialbase.downloader.v.m
    public boolean g(long j) throws com.ss.android.socialbase.downloader.gc.z {
        if (this.mc > 0 && this.ls.sf() > this.mc) {
            gk();
        }
        return this.iq.z(j);
    }

    @Override // com.ss.android.socialbase.downloader.v.m
    public void z(g gVar) {
        if (this.gz) {
            return;
        }
        synchronized (this) {
            this.m.remove(gVar);
        }
    }

    @Override // com.ss.android.socialbase.downloader.v.m
    public boolean z(com.ss.android.socialbase.downloader.gc.z zVar) {
        if (this.oq != null && com.ss.android.socialbase.downloader.pf.m.fo(zVar) && this.gc.get() < this.ls.oq()) {
            return false;
        }
        if (com.ss.android.socialbase.downloader.pf.m.g(zVar)) {
            if (this.gz && !this.f2112a) {
                com.ss.android.socialbase.downloader.pf.m.z(this.ls);
                this.f2112a = true;
            }
            return true;
        }
        AtomicInteger atomicInteger = this.gc;
        return ((atomicInteger != null && atomicInteger.get() > 0) || this.ls.mk() || (zVar != null && ((zVar.z() == 1011 || (zVar.getCause() != null && (zVar.getCause() instanceof SSLHandshakeException))) && this.ls.en()))) && !(zVar instanceof com.ss.android.socialbase.downloader.gc.e);
    }

    @Override // com.ss.android.socialbase.downloader.v.m
    public void g(com.ss.android.socialbase.downloader.gc.z zVar) {
        com.ss.android.socialbase.downloader.m.z.g(z, "onError:" + zVar.getMessage());
        this.v = com.ss.android.socialbase.downloader.g.uy.RUN_STATUS_ERROR;
        this.zw = zVar;
        ti();
    }

    private void un() {
        com.ss.android.socialbase.downloader.m.z.a(z, "clearCurrentDownloadData::" + Log.getStackTraceString(new Throwable()));
        try {
            this.pf.a(this.ls.e());
            this.pf.i(this.ls.e());
            com.ss.android.socialbase.downloader.pf.m.z(this.ls);
            this.fo = false;
            this.ls.wp("");
            this.pf.z(this.ls);
        } catch (Throwable th) {
            com.bytedance.sdk.component.utils.wp.z(th);
        }
    }

    @Override // com.ss.android.socialbase.downloader.v.m
    public void dl(com.ss.android.socialbase.downloader.gc.z zVar) {
        com.ss.android.socialbase.downloader.e.dl dlVar = this.ls;
        if (dlVar != null) {
            dlVar.v(true);
        }
        z(zVar, false);
    }

    @Override // com.ss.android.socialbase.downloader.v.m
    public void z(com.ss.android.socialbase.downloader.gc.z zVar, boolean z2) {
        com.ss.android.socialbase.downloader.m.z.g(z, "onAllChunkRetryWithReset");
        this.v = com.ss.android.socialbase.downloader.g.uy.RUN_STATUS_ALL_CHUNK_RETRY_WITH_RESET;
        this.zw = zVar;
        ti();
        if (z2 ? a(zVar) : false) {
            return;
        }
        un();
    }

    private void ti() {
        try {
            for (g gVar : (ArrayList) this.m.clone()) {
                if (gVar != null) {
                    gVar.g();
                }
            }
        } catch (Throwable th) {
            com.ss.android.socialbase.downloader.m.z.dl(z, "cancelAllChunkRunnable: " + th.toString());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void z(List<String> list) {
        if (list == null || list.isEmpty()) {
            return;
        }
        this.ls.z(list, this.v == com.ss.android.socialbase.downloader.g.uy.RUN_STATUS_WAITING_ASYNC_HANDLER);
        com.ss.android.socialbase.downloader.impls.z zVarH = com.ss.android.socialbase.downloader.downloader.dl.h();
        if (zVarH != null) {
            zVarH.wp(this.ls.e());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void eo() {
        com.ss.android.socialbase.downloader.impls.z zVarH;
        if (iq() || (zVarH = com.ss.android.socialbase.downloader.downloader.dl.h()) == null) {
            return;
        }
        zVarH.wp(this.ls.e());
    }

    @Override // com.ss.android.socialbase.downloader.v.m
    public com.ss.android.socialbase.downloader.gc.fo z(com.ss.android.socialbase.downloader.e.g gVar, com.ss.android.socialbase.downloader.gc.z zVar, long j) {
        if (q()) {
            return com.ss.android.socialbase.downloader.gc.fo.RETURN;
        }
        if (zVar != null && (zVar.z() == 1047 || com.ss.android.socialbase.downloader.pf.m.gz(zVar))) {
            return z(zVar, j);
        }
        this.zw = zVar;
        this.ls.m(-j);
        this.pf.z(this.ls);
        if (a(zVar)) {
            return com.ss.android.socialbase.downloader.gc.fo.RETURN;
        }
        this.iq.z(gVar, zVar, this.v == com.ss.android.socialbase.downloader.g.uy.RUN_STATUS_RETRY_DELAY);
        if (this.v != com.ss.android.socialbase.downloader.g.uy.RUN_STATUS_RETRY_DELAY && this.ls.xo()) {
            long jHh = hh();
            if (jHh > 0) {
                com.ss.android.socialbase.downloader.m.z.dl(z, "onSingleChunkRetry with delay time " + jHh);
                try {
                    Thread.sleep(jHh);
                } catch (Throwable th) {
                    com.ss.android.socialbase.downloader.m.z.a(z, "onSingleChunkRetry:" + th.getMessage());
                }
            }
        }
        return com.ss.android.socialbase.downloader.gc.fo.CONTINUE;
    }

    @Override // com.ss.android.socialbase.downloader.v.m
    public com.ss.android.socialbase.downloader.gc.fo z(com.ss.android.socialbase.downloader.gc.z zVar, long j) {
        long jA;
        long jS;
        boolean z2;
        this.zw = zVar;
        this.ls.m(-j);
        this.pf.z(this.ls);
        if (q()) {
            return com.ss.android.socialbase.downloader.gc.fo.RETURN;
        }
        if (zVar != null && zVar.z() == 1047) {
            if (this.sy == null || this.ls.gy()) {
                if (a(zVar)) {
                    return com.ss.android.socialbase.downloader.gc.fo.RETURN;
                }
            } else {
                com.ss.android.socialbase.downloader.a.g gVar = new com.ss.android.socialbase.downloader.a.g() { // from class: com.ss.android.socialbase.downloader.v.dl.1
                    @Override // com.ss.android.socialbase.downloader.a.g, com.ss.android.socialbase.downloader.a.io
                    public void z(List<String> list) {
                        super.z(list);
                        dl.this.z(list);
                    }
                };
                boolean z3 = this.sy.z(gVar);
                this.ls.dh();
                if (z3) {
                    if (!gVar.z()) {
                        ti();
                        this.iq.gz();
                        this.v = com.ss.android.socialbase.downloader.g.uy.RUN_STATUS_WAITING_ASYNC_HANDLER;
                        return com.ss.android.socialbase.downloader.gc.fo.RETURN;
                    }
                    z2 = true;
                }
            }
            z2 = false;
        } else if (com.ss.android.socialbase.downloader.pf.m.gz(zVar)) {
            if (this.hh == null) {
                g(zVar);
                return com.ss.android.socialbase.downloader.gc.fo.RETURN;
            }
            final AtomicBoolean atomicBoolean = new AtomicBoolean(false);
            com.ss.android.socialbase.downloader.a.fv fvVar = new com.ss.android.socialbase.downloader.a.fv() { // from class: com.ss.android.socialbase.downloader.v.dl.2
                @Override // com.ss.android.socialbase.downloader.a.fv
                public void z() {
                    synchronized (dl.this) {
                        atomicBoolean.set(true);
                        dl.this.eo();
                    }
                }
            };
            if (zVar instanceof com.ss.android.socialbase.downloader.gc.gc) {
                com.ss.android.socialbase.downloader.gc.gc gcVar = (com.ss.android.socialbase.downloader.gc.gc) zVar;
                jA = gcVar.a();
                jS = gcVar.gc();
            } else {
                jA = -1;
                jS = this.ls.s();
            }
            synchronized (this) {
                if (this.hh.z(jA, jS, fvVar)) {
                    if (!com.ss.android.socialbase.downloader.i.z.z(this.ls.e()).g("not_delete_when_clean_space", false)) {
                        uf();
                    }
                    if (!atomicBoolean.get()) {
                        if (this.v != com.ss.android.socialbase.downloader.g.uy.RUN_STATUS_WAITING_ASYNC_HANDLER) {
                            this.v = com.ss.android.socialbase.downloader.g.uy.RUN_STATUS_WAITING_ASYNC_HANDLER;
                            ti();
                            this.iq.gz();
                        }
                        return com.ss.android.socialbase.downloader.gc.fo.RETURN;
                    }
                    if (a(zVar)) {
                        return com.ss.android.socialbase.downloader.gc.fo.RETURN;
                    }
                    z2 = true;
                } else {
                    if (this.v == com.ss.android.socialbase.downloader.g.uy.RUN_STATUS_WAITING_ASYNC_HANDLER) {
                        return com.ss.android.socialbase.downloader.gc.fo.RETURN;
                    }
                    g(zVar);
                    return com.ss.android.socialbase.downloader.gc.fo.RETURN;
                }
            }
        } else {
            if (a(zVar)) {
                return com.ss.android.socialbase.downloader.gc.fo.RETURN;
            }
            z2 = false;
        }
        if (!z2 && oq()) {
            ti();
        }
        this.iq.z(zVar, this.v == com.ss.android.socialbase.downloader.g.uy.RUN_STATUS_RETRY_DELAY);
        return this.v == com.ss.android.socialbase.downloader.g.uy.RUN_STATUS_RETRY_DELAY ? com.ss.android.socialbase.downloader.gc.fo.RETURN : com.ss.android.socialbase.downloader.gc.fo.CONTINUE;
    }

    private boolean a(com.ss.android.socialbase.downloader.gc.z zVar) {
        AtomicInteger atomicInteger = this.gc;
        boolean z2 = true;
        if (atomicInteger != null) {
            if (atomicInteger.get() <= 0 || (zVar != null && zVar.z() == 1070)) {
                if (this.ls.aq()) {
                    this.gc.set(this.ls.wj());
                    this.ls.fo(this.gc.get());
                } else if (zVar != null && ((zVar.z() == 1011 || (zVar.getCause() != null && (zVar.getCause() instanceof SSLHandshakeException))) && this.ls.en())) {
                    this.gc.set(this.ls.oq());
                    this.ls.fo(this.gc.get());
                    this.ls.i(true);
                } else {
                    g(new com.ss.android.socialbase.downloader.gc.z(zVar.z(), String.format("retry for exception, but current retry time : %s , retry Time %s all used, last error is %s", String.valueOf(this.gc), String.valueOf(this.ls.oq()), zVar.g())));
                    return true;
                }
                z2 = false;
            }
            if (this.v != com.ss.android.socialbase.downloader.g.uy.RUN_STATUS_RETRY_DELAY && z2) {
                this.ls.fo(this.gc.decrementAndGet());
            }
            return false;
        }
        g(new com.ss.android.socialbase.downloader.gc.z(1043, "retry for exception, but retain retry time is null, last error is :" + zVar.g()));
        return true;
    }

    @Override // com.ss.android.socialbase.downloader.v.m
    public synchronized com.ss.android.socialbase.downloader.e.g z(int i) {
        com.ss.android.socialbase.downloader.e.g gVarZ;
        if (this.ls.ux() < 2) {
            return null;
        }
        List<com.ss.android.socialbase.downloader.e.g> listDl = this.pf.dl(this.ls.e());
        if (listDl != null && !listDl.isEmpty()) {
            for (int i2 = 0; i2 < listDl.size(); i2++) {
                com.ss.android.socialbase.downloader.e.g gVar = listDl.get(i2);
                if (gVar != null && (gVarZ = z(gVar, i)) != null) {
                    return gVarZ;
                }
            }
            return null;
        }
        return null;
    }

    @Override // com.ss.android.socialbase.downloader.v.m
    public void z(com.ss.android.socialbase.downloader.fo.e eVar) {
        boolean z2;
        if (eVar != null) {
            try {
                int iG = eVar.g();
                this.ls.e(iG);
                this.ls.fo(com.ss.android.socialbase.downloader.pf.g.z(iG));
                z2 = true;
            } catch (Throwable th) {
                com.bytedance.sdk.component.utils.wp.z(th);
                z2 = false;
            }
        } else {
            z2 = false;
        }
        if (z2) {
            return;
        }
        this.ls.e(-1);
        this.ls.fo("");
    }

    /* JADX WARN: Removed duplicated region for block: B:27:0x0083  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x00ea  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private com.ss.android.socialbase.downloader.e.g z(com.ss.android.socialbase.downloader.e.g r9, int r10) {
        /*
            Method dump skipped, instruction units count: 321
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ss.android.socialbase.downloader.v.dl.z(com.ss.android.socialbase.downloader.e.g, int):com.ss.android.socialbase.downloader.e.g");
    }

    private tb z(com.ss.android.socialbase.downloader.e.a aVar) {
        tb tbVarE = aVar.e();
        if (tbVarE != null) {
            return tbVarE;
        }
        com.ss.android.socialbase.downloader.e.dl dlVarZ = aVar.z();
        if (dlVarZ != null) {
            String strXf = dlVarZ.xf();
            if (!TextUtils.isEmpty(strXf)) {
                return new p(strXf);
            }
        }
        return com.ss.android.socialbase.downloader.downloader.dl.wj();
    }

    public Future e() {
        return this.g;
    }

    public void z(Future future) {
        this.g = future;
    }
}
