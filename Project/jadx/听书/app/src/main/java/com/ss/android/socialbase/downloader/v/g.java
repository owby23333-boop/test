package com.ss.android.socialbase.downloader.v;

import com.ss.android.socialbase.downloader.downloader.wp;
import com.ss.android.socialbase.downloader.fo.fo;

/* JADX INFO: loaded from: classes4.dex */
public class g implements Runnable {
    private static final String z = "g";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private com.ss.android.socialbase.downloader.downloader.gc f2114a;
    private com.ss.android.socialbase.downloader.e.g dl;
    private final m e;
    private wp fo;
    private com.ss.android.socialbase.downloader.e.g g;
    private final com.ss.android.socialbase.downloader.e.a gc;
    private fo gz;
    private volatile boolean kb;
    private com.ss.android.socialbase.downloader.e.dl m;
    private volatile boolean uy;
    private boolean wp;

    public g(com.ss.android.socialbase.downloader.e.g gVar, com.ss.android.socialbase.downloader.e.a aVar, m mVar) {
        this.wp = false;
        this.dl = gVar;
        this.gc = aVar;
        if (aVar != null) {
            this.m = aVar.z();
        }
        this.e = mVar;
        this.fo = com.ss.android.socialbase.downloader.downloader.dl.io();
        this.dl.z(this);
    }

    public g(com.ss.android.socialbase.downloader.e.g gVar, com.ss.android.socialbase.downloader.e.a aVar, fo foVar, m mVar) {
        this(gVar, aVar, mVar);
        this.gz = foVar;
    }

    private String dl() {
        return this.m.gp();
    }

    /* JADX WARN: Code restructure failed: missing block: B:6:0x0017, code lost:
    
        r3.g.z(false);
     */
    @Override // java.lang.Runnable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void run() {
        /*
            r3 = this;
            r0 = 10
            android.os.Process.setThreadPriority(r0)
            com.ss.android.socialbase.downloader.e.g r0 = r3.dl
            r3.g = r0
        L9:
            r0 = 0
            com.ss.android.socialbase.downloader.e.g r1 = r3.g     // Catch: java.lang.Throwable -> L5b
            r1.z(r3)     // Catch: java.lang.Throwable -> L5b
            com.ss.android.socialbase.downloader.e.g r1 = r3.g     // Catch: java.lang.Throwable -> L5b
            boolean r1 = r3.z(r1)     // Catch: java.lang.Throwable -> L5b
            if (r1 != 0) goto L1d
            com.ss.android.socialbase.downloader.e.g r1 = r3.g     // Catch: java.lang.Throwable -> L5b
            r1.z(r0)     // Catch: java.lang.Throwable -> L5b
            goto L4b
        L1d:
            com.ss.android.socialbase.downloader.e.g r1 = r3.g     // Catch: java.lang.Throwable -> L5b
            r1.z(r0)     // Catch: java.lang.Throwable -> L5b
            boolean r1 = r3.gc()     // Catch: java.lang.Throwable -> L5b
            if (r1 != 0) goto L4b
            com.ss.android.socialbase.downloader.v.m r1 = r3.e     // Catch: java.lang.Throwable -> L5b
            com.ss.android.socialbase.downloader.e.g r2 = r3.g     // Catch: java.lang.Throwable -> L5b
            int r2 = r2.js()     // Catch: java.lang.Throwable -> L5b
            com.ss.android.socialbase.downloader.e.g r1 = r1.z(r2)     // Catch: java.lang.Throwable -> L5b
            r3.g = r1     // Catch: java.lang.Throwable -> L5b
            boolean r1 = r3.gc()     // Catch: java.lang.Throwable -> L5b
            if (r1 != 0) goto L4b
            com.ss.android.socialbase.downloader.e.g r1 = r3.g     // Catch: java.lang.Throwable -> L5b
            if (r1 == 0) goto L4b
            r1 = 50
            java.lang.Thread.sleep(r1)     // Catch: java.lang.Throwable -> L46
            goto L9
        L46:
            r1 = move-exception
            com.bytedance.sdk.component.utils.wp.z(r1)     // Catch: java.lang.Throwable -> L5b
            goto L9
        L4b:
            com.ss.android.socialbase.downloader.e.g r1 = r3.g
            if (r1 == 0) goto L52
            r1.z(r0)
        L52:
            r3.a()
            com.ss.android.socialbase.downloader.v.m r0 = r3.e
            r0.z(r3)
            return
        L5b:
            r1 = move-exception
            com.ss.android.socialbase.downloader.e.g r2 = r3.g
            if (r2 == 0) goto L63
            r2.z(r0)
        L63:
            r3.a()
            com.ss.android.socialbase.downloader.v.m r0 = r3.e
            r0.z(r3)
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ss.android.socialbase.downloader.v.g.run():void");
    }

    public void z(long j, long j2) {
        com.ss.android.socialbase.downloader.downloader.gc gcVar = this.f2114a;
        if (gcVar == null) {
            return;
        }
        gcVar.z(j, j2);
    }

    /* JADX WARN: Removed duplicated region for block: B:136:0x01d7 A[Catch: all -> 0x029a, TRY_ENTER, TryCatch #15 {all -> 0x029a, blocks: (B:132:0x01cd, B:136:0x01d7, B:138:0x01dd, B:141:0x01e6, B:143:0x01ee, B:145:0x01f4, B:149:0x01ff, B:151:0x0203, B:153:0x020b, B:155:0x021c, B:164:0x0242, B:166:0x0248, B:168:0x0255, B:172:0x025d, B:167:0x024f, B:158:0x0229, B:159:0x0235, B:174:0x0268, B:176:0x0270, B:178:0x0278, B:180:0x0280, B:182:0x0288, B:185:0x0291, B:120:0x01b0, B:124:0x01ba, B:127:0x01c1), top: B:206:0x01cd, inners: #9 }] */
    /* JADX WARN: Removed duplicated region for block: B:215:0x00f5 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:220:0x01d3 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:64:0x00f9 A[Catch: all -> 0x01ae, z -> 0x01ca, TRY_ENTER, TryCatch #16 {z -> 0x01ca, all -> 0x01ae, blocks: (B:22:0x004e, B:26:0x0058, B:30:0x0063, B:35:0x00b2, B:37:0x00b6, B:45:0x00cb, B:60:0x00ef, B:64:0x00f9, B:66:0x00fd, B:77:0x012b, B:74:0x0123, B:76:0x012a, B:49:0x00d5, B:51:0x00d9), top: B:207:0x004e }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private boolean z(com.ss.android.socialbase.downloader.e.g r31) {
        /*
            Method dump skipped, instruction units count: 671
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ss.android.socialbase.downloader.v.g.z(com.ss.android.socialbase.downloader.e.g):boolean");
    }

    private void z(com.ss.android.socialbase.downloader.e.g gVar, long j) {
        com.ss.android.socialbase.downloader.e.g gVarGc = gVar.a() ? gVar.gc() : gVar;
        if (gVarGc != null) {
            if (gVarGc.gz()) {
                this.fo.z(gVarGc.kb(), gVarGc.g(), j);
            }
            gVarGc.g(j);
            this.fo.z(gVarGc.kb(), gVarGc.js(), gVarGc.g(), j);
            return;
        }
        if (gVar.a()) {
            this.fo.z(gVar.kb(), gVar.js(), j);
        }
    }

    private void a() {
        fo foVar = this.gz;
        if (foVar != null) {
            foVar.a();
            this.gz = null;
        }
    }

    private boolean gc() {
        return this.uy || this.kb;
    }

    public void z() {
        this.uy = true;
        com.ss.android.socialbase.downloader.downloader.gc gcVar = this.f2114a;
        if (gcVar != null) {
            gcVar.g();
        }
    }

    public void g() {
        this.kb = true;
        com.ss.android.socialbase.downloader.downloader.gc gcVar = this.f2114a;
        if (gcVar != null) {
            gcVar.dl();
        }
    }
}
