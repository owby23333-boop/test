package com.kwad.framework.filedownloader.download;

import android.os.SystemClock;
import java.io.IOException;

/* JADX INFO: loaded from: classes4.dex */
public final class e {
    private final String aca;
    private final int amZ;
    private final f anW;
    private final int anY;
    private final long anh;
    long ani;
    private final long anj;
    private final com.kwad.framework.filedownloader.b.a ano;
    private final boolean anw;
    private final c aoo;
    private final com.kwad.framework.filedownloader.a.b aop;
    private com.kwad.framework.filedownloader.e.a aoq;
    private volatile long aor;
    private volatile long aos;
    private final long contentLength;
    private volatile boolean nf;

    /* synthetic */ e(com.kwad.framework.filedownloader.a.b bVar, com.kwad.framework.filedownloader.download.a aVar, c cVar, int i, int i2, boolean z, f fVar, String str, byte b) {
        this(bVar, aVar, cVar, i, i2, z, fVar, str);
    }

    public final void pause() {
        this.nf = true;
    }

    private e(com.kwad.framework.filedownloader.a.b bVar, com.kwad.framework.filedownloader.download.a aVar, c cVar, int i, int i2, boolean z, f fVar, String str) {
        this.aor = 0L;
        this.aos = 0L;
        this.anW = fVar;
        this.aca = str;
        this.aop = bVar;
        this.anw = z;
        this.aoo = cVar;
        this.anY = i2;
        this.amZ = i;
        this.ano = b.yc().ye();
        this.anh = aVar.anh;
        this.anj = aVar.anj;
        this.ani = aVar.ani;
        this.contentLength = aVar.contentLength;
    }

    /* JADX WARN: Code restructure failed: missing block: B:46:0x010b, code lost:
    
        if (r6 == null) goto L48;
     */
    /* JADX WARN: Code restructure failed: missing block: B:47:0x010d, code lost:
    
        sync();
     */
    /* JADX WARN: Code restructure failed: missing block: B:48:0x0110, code lost:
    
        com.kwad.sdk.crash.utils.b.closeQuietly(r4);
        com.kwad.sdk.crash.utils.b.closeQuietly(r6);
        r4 = r13.ani - r2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:49:0x011d, code lost:
    
        if (r0 == (-1)) goto L55;
     */
    /* JADX WARN: Code restructure failed: missing block: B:51:0x0121, code lost:
    
        if (r0 != r4) goto L53;
     */
    /* JADX WARN: Code restructure failed: missing block: B:54:0x0151, code lost:
    
        throw new com.kwad.framework.filedownloader.exception.FileDownloadGiveUpRetryException(com.kwad.framework.filedownloader.f.f.c("fetched length[%d] != content length[%d], range[%d, %d) offset[%d] fetch begin offset", java.lang.Long.valueOf(r4), java.lang.Long.valueOf(r0), java.lang.Long.valueOf(r13.anh), java.lang.Long.valueOf(r13.anj), java.lang.Long.valueOf(r13.ani), java.lang.Long.valueOf(r2)));
     */
    /* JADX WARN: Code restructure failed: missing block: B:55:0x0152, code lost:
    
        r13.anW.a(r13.aoo, r13.anh, r13.anj);
     */
    /* JADX WARN: Code restructure failed: missing block: B:56:0x015d, code lost:
    
        return;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void run() throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 390
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.kwad.framework.filedownloader.download.e.run():void");
    }

    private void yF() {
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        if (com.kwad.framework.filedownloader.f.f.i(this.ani - this.aor, jElapsedRealtime - this.aos)) {
            sync();
            this.aor = this.ani;
            this.aos = jElapsedRealtime;
        }
    }

    private void sync() {
        boolean z;
        long jUptimeMillis = SystemClock.uptimeMillis();
        try {
            this.aoq.zw();
            z = true;
        } catch (IOException e) {
            if (com.kwad.framework.filedownloader.f.d.apD) {
                com.kwad.framework.filedownloader.f.d.c(this, "Because of the system cannot guarantee that all the buffers have been synchronized with physical media, or write to filefailed, we just not flushAndSync process to database too %s", e);
            }
            z = false;
        }
        if (z) {
            if (this.aoo != null) {
                this.ano.a(this.amZ, this.anY, this.ani);
            } else {
                this.anW.yo();
            }
            if (com.kwad.framework.filedownloader.f.d.apD) {
                com.kwad.framework.filedownloader.f.d.c(this, "require flushAndSync id[%d] index[%d] offset[%d], consume[%d]", Integer.valueOf(this.amZ), Integer.valueOf(this.anY), Long.valueOf(this.ani), Long.valueOf(SystemClock.uptimeMillis() - jUptimeMillis));
            }
        }
    }

    public static class a {
        String aca;
        Boolean anT;
        f anW;
        Integer anf;
        com.kwad.framework.filedownloader.download.a ang;
        Integer aoa;
        com.kwad.framework.filedownloader.a.b aop;
        c aot;

        public final a d(com.kwad.framework.filedownloader.a.b bVar) {
            this.aop = bVar;
            return this;
        }

        public final a c(com.kwad.framework.filedownloader.download.a aVar) {
            this.ang = aVar;
            return this;
        }

        public final a b(f fVar) {
            this.anW = fVar;
            return this;
        }

        public final a bv(String str) {
            this.aca = str;
            return this;
        }

        public final a bi(boolean z) {
            this.anT = Boolean.valueOf(z);
            return this;
        }

        public final a a(c cVar) {
            this.aot = cVar;
            return this;
        }

        public final a bO(int i) {
            this.aoa = Integer.valueOf(i);
            return this;
        }

        public final a bP(int i) {
            this.anf = Integer.valueOf(i);
            return this;
        }

        public final e yG() {
            if (this.anT == null || this.aop == null || this.ang == null || this.anW == null || this.aca == null || this.anf == null || this.aoa == null) {
                throw new IllegalArgumentException();
            }
            return new e(this.aop, this.ang, this.aot, this.anf.intValue(), this.aoa.intValue(), this.anT.booleanValue(), this.anW, this.aca, (byte) 0);
        }
    }
}
