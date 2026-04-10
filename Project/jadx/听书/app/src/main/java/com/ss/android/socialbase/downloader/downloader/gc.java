package com.ss.android.socialbase.downloader.downloader;

import android.os.SystemClock;
import android.support.v4.media.session.PlaybackStateCompat;
import java.io.InputStream;
import java.util.concurrent.ExecutorService;

/* JADX INFO: loaded from: classes4.dex */
public class gc {
    private static String g = "ResponseHandler";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f2060a;
    private final com.ss.android.socialbase.downloader.e.dl dl;
    private wp e;
    private q fo;
    private volatile long fv;
    private final com.ss.android.socialbase.downloader.e.g gc;
    private long gk;
    private com.ss.android.socialbase.downloader.impls.kb gz;
    private long h;
    private long hh;
    private volatile boolean i;
    private final long io;
    private final boolean iq;
    private final boolean js;
    private com.ss.android.socialbase.downloader.gc.z kb;
    private long l;
    private long ls;
    private final com.ss.android.socialbase.downloader.fo.fo m;
    private volatile long p;
    private long pf;
    private final com.ss.android.socialbase.downloader.z.z q;
    private boolean sy;
    private final com.ss.android.socialbase.downloader.i.z tb;
    private final boolean uf;
    private com.ss.android.socialbase.downloader.e.e uy;
    private final com.ss.android.socialbase.downloader.v.m v;
    private volatile boolean wp;
    private final long zw;
    boolean z = false;
    private volatile long x = 0;
    private volatile long lq = 0;

    private boolean g(long j, long j2) {
        return j > PlaybackStateCompat.ACTION_PREPARE_FROM_SEARCH && j2 > 500;
    }

    public gc(com.ss.android.socialbase.downloader.e.dl dlVar, String str, com.ss.android.socialbase.downloader.fo.fo foVar, com.ss.android.socialbase.downloader.e.g gVar, com.ss.android.socialbase.downloader.v.m mVar) {
        this.dl = dlVar;
        this.f2060a = str;
        wp wpVarIo = dl.io();
        this.e = wpVarIo;
        if (wpVarIo instanceof com.ss.android.socialbase.downloader.impls.a) {
            com.ss.android.socialbase.downloader.impls.a aVar = (com.ss.android.socialbase.downloader.impls.a) wpVarIo;
            this.gz = aVar.z();
            this.fo = aVar.m();
        }
        this.m = foVar;
        this.gc = gVar;
        this.v = mVar;
        long jV = gVar.v();
        this.pf = jV;
        this.ls = jV;
        if (gVar.a()) {
            this.fv = gVar.p();
        } else {
            this.fv = gVar.dl(false);
        }
        this.p = gVar.ls();
        this.q = com.ss.android.socialbase.downloader.z.z.z();
        com.ss.android.socialbase.downloader.i.z zVarZ = com.ss.android.socialbase.downloader.i.z.z(dlVar.e());
        this.tb = zVarZ;
        boolean z = zVarZ.z("sync_strategy", 0) == 1;
        this.iq = z;
        if (z) {
            long jZ = zVarZ.z("sync_interval_ms_fg", 5000);
            long jZ2 = zVarZ.z("sync_interval_ms_bg", 1000);
            this.zw = Math.max(jZ, 500L);
            this.io = Math.max(jZ2, 500L);
        } else {
            this.zw = 0L;
            this.io = 0L;
        }
        this.uf = zVarZ.g("monitor_rw") == 1;
        this.js = com.ss.android.socialbase.downloader.pf.z.z(65536);
    }

    public long z() {
        return this.pf;
    }

    private boolean m() {
        return this.wp || this.i;
    }

    public void g() {
        if (this.wp) {
            return;
        }
        this.wp = true;
        e();
    }

    public void dl() {
        if (this.i) {
            return;
        }
        synchronized (this.v) {
            this.i = true;
        }
        e();
    }

    private void e() {
        ExecutorService executorServiceKb;
        if (this.m == null || (executorServiceKb = dl.kb()) == null) {
            return;
        }
        executorServiceKb.execute(new Runnable() { // from class: com.ss.android.socialbase.downloader.downloader.gc.1
            @Override // java.lang.Runnable
            public void run() {
                try {
                    gc.this.m.a();
                } catch (Throwable unused) {
                }
            }
        });
    }

    public void z(long j, long j2, long j3) {
        this.pf = j;
        this.ls = j;
        this.p = j2;
        this.fv = j3;
    }

    public void z(long j, long j2) {
        this.p = j;
        this.fv = j2;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:168:0x02b2  */
    /* JADX WARN: Removed duplicated region for block: B:195:0x0314 A[Catch: all -> 0x047d, TRY_ENTER, TryCatch #12 {all -> 0x047d, blocks: (B:166:0x029d, B:195:0x0314, B:197:0x031a, B:198:0x031d, B:239:0x03fc, B:240:0x03fe, B:244:0x0404, B:246:0x041d, B:274:0x0471, B:276:0x0477, B:277:0x047a, B:278:0x047c), top: B:326:0x0028, inners: #25 }] */
    /* JADX WARN: Removed duplicated region for block: B:324:0x017f A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:69:0x0156 A[Catch: all -> 0x01ff, z -> 0x0202, TryCatch #26 {z -> 0x0202, all -> 0x01ff, blocks: (B:59:0x012a, B:61:0x0134, B:63:0x0141, B:69:0x0156, B:70:0x015c, B:72:0x0166, B:73:0x0171, B:74:0x017e, B:81:0x0196, B:83:0x019e, B:85:0x01a6, B:87:0x01ae, B:89:0x01b6, B:91:0x01c1, B:95:0x01c9, B:99:0x01d5, B:103:0x01db, B:104:0x01de, B:106:0x01f0, B:107:0x01f5, B:108:0x01f6, B:109:0x01fb, B:112:0x01fe, B:75:0x017f, B:77:0x0183, B:80:0x0195, B:79:0x0187), top: B:343:0x012a, inners: #11, #13 }] */
    /* JADX WARN: Removed duplicated region for block: B:72:0x0166 A[Catch: all -> 0x01ff, z -> 0x0202, TryCatch #26 {z -> 0x0202, all -> 0x01ff, blocks: (B:59:0x012a, B:61:0x0134, B:63:0x0141, B:69:0x0156, B:70:0x015c, B:72:0x0166, B:73:0x0171, B:74:0x017e, B:81:0x0196, B:83:0x019e, B:85:0x01a6, B:87:0x01ae, B:89:0x01b6, B:91:0x01c1, B:95:0x01c9, B:99:0x01d5, B:103:0x01db, B:104:0x01de, B:106:0x01f0, B:107:0x01f5, B:108:0x01f6, B:109:0x01fb, B:112:0x01fe, B:75:0x017f, B:77:0x0183, B:80:0x0195, B:79:0x0187), top: B:343:0x012a, inners: #11, #13 }] */
    /* JADX WARN: Type inference failed for: r15v0, types: [boolean] */
    /* JADX WARN: Type inference failed for: r15v14 */
    /* JADX WARN: Type inference failed for: r15v5 */
    /* JADX WARN: Type inference failed for: r15v6 */
    /* JADX WARN: Type inference failed for: r15v7 */
    /* JADX WARN: Type inference failed for: r15v9 */
    /* JADX WARN: Type inference failed for: r21v0, types: [boolean] */
    /* JADX WARN: Type inference failed for: r21v1, types: [boolean] */
    /* JADX WARN: Type inference failed for: r21v2, types: [boolean] */
    /* JADX WARN: Type inference failed for: r4v0 */
    /* JADX WARN: Type inference failed for: r4v1 */
    /* JADX WARN: Type inference failed for: r4v10 */
    /* JADX WARN: Type inference failed for: r4v11 */
    /* JADX WARN: Type inference failed for: r4v12 */
    /* JADX WARN: Type inference failed for: r4v14 */
    /* JADX WARN: Type inference failed for: r4v2 */
    /* JADX WARN: Type inference failed for: r4v22 */
    /* JADX WARN: Type inference failed for: r4v23 */
    /* JADX WARN: Type inference failed for: r4v25 */
    /* JADX WARN: Type inference failed for: r4v26 */
    /* JADX WARN: Type inference failed for: r4v27 */
    /* JADX WARN: Type inference failed for: r4v28 */
    /* JADX WARN: Type inference failed for: r4v29 */
    /* JADX WARN: Type inference failed for: r4v3 */
    /* JADX WARN: Type inference failed for: r4v30 */
    /* JADX WARN: Type inference failed for: r4v31 */
    /* JADX WARN: Type inference failed for: r4v32 */
    /* JADX WARN: Type inference failed for: r4v33 */
    /* JADX WARN: Type inference failed for: r4v4 */
    /* JADX WARN: Type inference failed for: r4v5 */
    /* JADX WARN: Type inference failed for: r4v7 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void a() throws com.ss.android.socialbase.downloader.gc.z {
        /*
            Method dump skipped, instruction units count: 1292
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ss.android.socialbase.downloader.downloader.gc.a():void");
    }

    private com.ss.android.socialbase.downloader.uy.g z(InputStream inputStream) {
        int iUn = dl.un();
        if (this.tb.z("rw_concurrent", 0) == 1 && this.dl.ux() == 1 && this.dl.s() > 20971520) {
            try {
                com.ss.android.socialbase.downloader.uy.z zVar = new com.ss.android.socialbase.downloader.uy.z(inputStream, iUn, this.tb.z("rw_concurrent_max_buffer_count", 4));
                this.sy = true;
                return zVar;
            } catch (Throwable th) {
                com.bytedance.sdk.component.utils.wp.z(th);
            }
        }
        com.ss.android.socialbase.downloader.uy.dl dlVar = new com.ss.android.socialbase.downloader.uy.dl(inputStream, iUn);
        this.sy = false;
        return dlVar;
    }

    private void z(boolean z) {
        long jUptimeMillis = SystemClock.uptimeMillis();
        long j = jUptimeMillis - this.lq;
        if (this.iq) {
            if (j <= (this.q.g() ? this.zw : this.io)) {
                return;
            }
        } else {
            long j2 = this.pf - this.x;
            if (!z && !g(j2, j)) {
                return;
            }
        }
        gz();
        this.lq = jUptimeMillis;
    }

    public long gc() {
        return this.x;
    }

    private void gz() {
        boolean z;
        long jNanoTime = this.uf ? System.nanoTime() : 0L;
        try {
            this.uy.z();
            z = true;
        } catch (Exception unused) {
            z = false;
        }
        if (z) {
            this.dl.e(true);
            boolean z2 = this.dl.ux() > 1;
            pf pfVarZ = com.ss.android.socialbase.downloader.impls.wp.z(com.ss.android.socialbase.downloader.pf.m.g());
            if (z2) {
                z(this.fo);
                if (pfVarZ != null) {
                    pfVarZ.dl(this.dl);
                } else {
                    this.fo.z(this.dl.e(), this.dl.sf());
                }
            } else if (pfVarZ != null) {
                pfVarZ.dl(this.dl);
            } else {
                this.fo.z(this.gc.kb(), this.pf);
            }
            this.x = this.pf;
        }
        if (this.uf) {
            this.h += System.nanoTime() - jNanoTime;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:33:0x0091  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void z(com.ss.android.socialbase.downloader.downloader.wp r17) {
        /*
            Method dump skipped, instruction units count: 228
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ss.android.socialbase.downloader.downloader.gc.z(com.ss.android.socialbase.downloader.downloader.wp):void");
    }
}
