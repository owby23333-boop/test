package com.kwai.filedownloader.download;

import com.kwai.filedownloader.e.c;
import com.kwai.filedownloader.kwai.c;
import com.kwai.filedownloader.services.c;
import java.io.File;

/* JADX INFO: loaded from: classes3.dex */
public final class b {
    private c.a aFA;
    private c.b aFB;
    private c.e aFC;
    private volatile com.kwai.filedownloader.a.a aFD;
    private c.d aFE;
    private com.kwai.filedownloader.services.c aFz;

    static final class a {
        private static final b aFF = new b();
    }

    private com.kwai.filedownloader.services.c HA() {
        com.kwai.filedownloader.services.c cVar = this.aFz;
        if (cVar != null) {
            return cVar;
        }
        synchronized (this) {
            if (this.aFz == null) {
                this.aFz = new com.kwai.filedownloader.services.c();
            }
        }
        return this.aFz;
    }

    public static b Ht() {
        return a.aFF;
    }

    private c.a Hy() {
        c.a aVar = this.aFA;
        if (aVar != null) {
            return aVar;
        }
        synchronized (this) {
            if (this.aFA == null) {
                this.aFA = HA().Ix();
            }
        }
        return this.aFA;
    }

    private c.e Hz() {
        c.e eVar = this.aFC;
        if (eVar != null) {
            return eVar;
        }
        synchronized (this) {
            if (this.aFC == null) {
                this.aFC = HA().Iv();
            }
        }
        return this.aFC;
    }

    private c.b T() {
        c.b bVar = this.aFB;
        if (bVar != null) {
            return bVar;
        }
        synchronized (this) {
            if (this.aFB == null) {
                this.aFB = HA().Iw();
            }
        }
        return this.aFB;
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x0053 A[Catch: all -> 0x0143, TryCatch #1 {all -> 0x0143, blocks: (B:9:0x0034, B:11:0x003b, B:13:0x0042, B:15:0x0049, B:18:0x0056, B:21:0x0065, B:23:0x0070, B:17:0x0053), top: B:84:0x0034 }] */
    /* JADX WARN: Removed duplicated region for block: B:78:0x019d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void a(com.kwai.filedownloader.a.a.InterfaceC0462a r26) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 456
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.kwai.filedownloader.download.b.a(com.kwai.filedownloader.a.a$a):void");
    }

    public final c.d Hu() {
        c.d dVar = this.aFE;
        if (dVar != null) {
            return dVar;
        }
        synchronized (this) {
            if (this.aFE == null) {
                this.aFE = HA().Iy();
            }
        }
        return this.aFE;
    }

    public final synchronized com.kwai.filedownloader.a.a Hv() {
        if (this.aFD != null) {
            return this.aFD;
        }
        this.aFD = HA().Iu();
        a(this.aFD.Hl());
        return this.aFD;
    }

    public final int Hw() {
        return HA().Hw();
    }

    public final boolean Hx() {
        Hz();
        return true;
    }

    public final int a(int i2, String str, String str2, long j2) {
        return Hy().ak(j2);
    }

    public final void a(c.b bVar) {
        synchronized (this) {
            this.aFz = new com.kwai.filedownloader.services.c(bVar);
            this.aFB = null;
            this.aFC = null;
            this.aFD = null;
            this.aFE = null;
        }
    }

    public final com.kwai.filedownloader.d.a ab(File file) {
        return Hz().ac(file);
    }

    public final void b(c.b bVar) {
        synchronized (this) {
            this.aFz = new com.kwai.filedownloader.services.c(bVar);
        }
    }

    public final com.kwai.filedownloader.kwai.b eY(String str) {
        try {
            return T().q(str);
        } catch (Throwable unused) {
            this.aFB = new c.b();
            return this.aFB.q(str);
        }
    }
}
