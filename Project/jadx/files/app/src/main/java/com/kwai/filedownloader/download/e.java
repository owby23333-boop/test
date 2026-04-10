package com.kwai.filedownloader.download;

import android.os.SystemClock;
import java.io.IOException;

/* JADX INFO: loaded from: classes3.dex */
public final class e {
    private final String RY;
    private final com.kwai.filedownloader.a.a aFD;
    private final boolean aFL;
    private final int aFo;
    private final long aFw;
    long aFx;
    private final long aFy;
    private final c aGD;
    private final com.kwai.filedownloader.kwai.b aGE;
    private com.kwai.filedownloader.d.a aGF;
    private volatile long aGG;
    private volatile long aGH;
    private final f aGl;
    private final int aGn;
    private final long contentLength;
    private volatile boolean lf;

    public static class a {
        String RY;
        Integer aFu;
        com.kwai.filedownloader.download.a aFv;
        com.kwai.filedownloader.kwai.b aGE;
        c aGI;
        Boolean aGi;
        f aGl;
        Integer aGp;

        public final e HW() {
            com.kwai.filedownloader.kwai.b bVar;
            com.kwai.filedownloader.download.a aVar;
            Integer num;
            if (this.aGi == null || (bVar = this.aGE) == null || (aVar = this.aFv) == null || this.aGl == null || this.RY == null || (num = this.aFu) == null || this.aGp == null) {
                throw new IllegalArgumentException();
            }
            return new e(bVar, aVar, this.aGI, num.intValue(), this.aGp.intValue(), this.aGi.booleanValue(), this.aGl, this.RY, (byte) 0);
        }

        public final a a(c cVar) {
            this.aGI = cVar;
            return this;
        }

        public final a b(f fVar) {
            this.aGl = fVar;
            return this;
        }

        public final a bO(boolean z2) {
            this.aGi = Boolean.valueOf(z2);
            return this;
        }

        public final a c(com.kwai.filedownloader.download.a aVar) {
            this.aFv = aVar;
            return this;
        }

        public final a cO(int i2) {
            this.aGp = Integer.valueOf(i2);
            return this;
        }

        public final a cP(int i2) {
            this.aFu = Integer.valueOf(i2);
            return this;
        }

        public final a d(com.kwai.filedownloader.kwai.b bVar) {
            this.aGE = bVar;
            return this;
        }

        public final a fc(String str) {
            this.RY = str;
            return this;
        }
    }

    private e(com.kwai.filedownloader.kwai.b bVar, com.kwai.filedownloader.download.a aVar, c cVar, int i2, int i3, boolean z2, f fVar, String str) {
        this.aGG = 0L;
        this.aGH = 0L;
        this.aGl = fVar;
        this.RY = str;
        this.aGE = bVar;
        this.aFL = z2;
        this.aGD = cVar;
        this.aGn = i3;
        this.aFo = i2;
        this.aFD = b.Ht().Hv();
        this.aFw = aVar.aFw;
        this.aFy = aVar.aFy;
        this.aFx = aVar.aFx;
        this.contentLength = aVar.contentLength;
    }

    /* synthetic */ e(com.kwai.filedownloader.kwai.b bVar, com.kwai.filedownloader.download.a aVar, c cVar, int i2, int i3, boolean z2, f fVar, String str, byte b) {
        this(bVar, aVar, cVar, i2, i3, z2, fVar, str);
    }

    private void HV() {
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        if (com.kwai.filedownloader.e.f.h(this.aFx - this.aGG, jElapsedRealtime - this.aGH)) {
            sync();
            this.aGG = this.aFx;
            this.aGH = jElapsedRealtime;
        }
    }

    private void sync() {
        boolean z2;
        long jUptimeMillis = SystemClock.uptimeMillis();
        try {
            this.aGF.IL();
            z2 = true;
        } catch (IOException e2) {
            if (com.kwai.filedownloader.e.d.aHT) {
                com.kwai.filedownloader.e.d.g(this, "Because of the system cannot guarantee that all the buffers have been synchronized with physical media, or write to filefailed, we just not flushAndSync process to database too %s", e2);
            }
            z2 = false;
        }
        if (z2) {
            if (this.aGD != null) {
                this.aFD.a(this.aFo, this.aGn, this.aFx);
            } else {
                this.aGl.HE();
            }
            if (com.kwai.filedownloader.e.d.aHT) {
                com.kwai.filedownloader.e.d.g(this, "require flushAndSync id[%d] index[%d] offset[%d], consume[%d]", Integer.valueOf(this.aFo), Integer.valueOf(this.aGn), Long.valueOf(this.aFx), Long.valueOf(SystemClock.uptimeMillis() - jUptimeMillis));
            }
        }
    }

    public final void pause() {
        this.lf = true;
    }

    /* JADX WARN: Code restructure failed: missing block: B:47:0x011b, code lost:
    
        if (r13 == null) goto L49;
     */
    /* JADX WARN: Code restructure failed: missing block: B:48:0x011d, code lost:
    
        sync();
     */
    /* JADX WARN: Code restructure failed: missing block: B:49:0x0120, code lost:
    
        com.kwad.sdk.crash.utils.b.closeQuietly(r8);
        com.kwad.sdk.crash.utils.b.closeQuietly(r13);
        r6 = r16.aFx - r4;
     */
    /* JADX WARN: Code restructure failed: missing block: B:50:0x012d, code lost:
    
        if (r2 == (-1)) goto L56;
     */
    /* JADX WARN: Code restructure failed: missing block: B:52:0x0131, code lost:
    
        if (r2 != r6) goto L54;
     */
    /* JADX WARN: Code restructure failed: missing block: B:55:0x0170, code lost:
    
        throw new com.kwai.filedownloader.exception.FileDownloadGiveUpRetryException(com.kwai.filedownloader.e.f.j("fetched length[%d] != content length[%d], range[%d, %d) offset[%d] fetch begin offset", java.lang.Long.valueOf(r6), java.lang.Long.valueOf(r2), java.lang.Long.valueOf(r16.aFw), java.lang.Long.valueOf(r16.aFy), java.lang.Long.valueOf(r16.aFx), java.lang.Long.valueOf(r4)));
     */
    /* JADX WARN: Code restructure failed: missing block: B:56:0x0171, code lost:
    
        r16.aGl.a(r16.aGD, r16.aFw, r16.aFy);
     */
    /* JADX WARN: Code restructure failed: missing block: B:57:0x017c, code lost:
    
        return;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void run() throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 426
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.kwai.filedownloader.download.e.run():void");
    }
}
