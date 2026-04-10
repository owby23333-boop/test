package com.kwad.framework.filedownloader.download;

import com.kwad.framework.filedownloader.a.c;
import com.kwad.framework.filedownloader.f.c;
import com.kwad.framework.filedownloader.services.c;
import java.io.File;

/* JADX INFO: loaded from: classes4.dex */
public final class b {
    private com.kwad.framework.filedownloader.services.c ank;
    private c.a anl;
    private c.b anm;
    private c.e ann;
    private volatile com.kwad.framework.filedownloader.b.a ano;
    private c.d anp;

    static final class a {
        private static final b anq = new b();
    }

    public static b yc() {
        return a.anq;
    }

    public final void a(c.b bVar) {
        synchronized (this) {
            this.ank = new com.kwad.framework.filedownloader.services.c(bVar);
            this.anm = null;
            this.ann = null;
            this.ano = null;
            this.anp = null;
        }
    }

    public final void b(c.b bVar) {
        synchronized (this) {
            this.ank = new com.kwad.framework.filedownloader.services.c(bVar);
        }
    }

    public final com.kwad.framework.filedownloader.a.b br(String str) {
        try {
            return yi().bo(str);
        } catch (Throwable unused) {
            c.b bVar = new c.b();
            this.anm = bVar;
            return bVar.bo(str);
        }
    }

    public final com.kwad.framework.filedownloader.e.a b(File file) {
        return yj().c(file);
    }

    public final c.d yd() {
        c.d dVar = this.anp;
        if (dVar != null) {
            return dVar;
        }
        synchronized (this) {
            if (this.anp == null) {
                this.anp = yk().zj();
            }
        }
        return this.anp;
    }

    public final synchronized com.kwad.framework.filedownloader.b.a ye() {
        if (this.ano != null) {
            return this.ano;
        }
        this.ano = yk().zf();
        a(this.ano.xT());
        return this.ano;
    }

    public final int yf() {
        return yk().yf();
    }

    public final boolean yg() {
        yj();
        return true;
    }

    public final int a(int i, String str, String str2, long j) {
        return yh().V(j);
    }

    private c.a yh() {
        c.a aVar = this.anl;
        if (aVar != null) {
            return aVar;
        }
        synchronized (this) {
            if (this.anl == null) {
                this.anl = yk().zi();
            }
        }
        return this.anl;
    }

    private c.b yi() {
        c.b bVar = this.anm;
        if (bVar != null) {
            return bVar;
        }
        synchronized (this) {
            if (this.anm == null) {
                this.anm = yk().zh();
            }
        }
        return this.anm;
    }

    private c.e yj() {
        c.e eVar = this.ann;
        if (eVar != null) {
            return eVar;
        }
        synchronized (this) {
            if (this.ann == null) {
                this.ann = yk().zg();
            }
        }
        return this.ann;
    }

    private com.kwad.framework.filedownloader.services.c yk() {
        com.kwad.framework.filedownloader.services.c cVar = this.ank;
        if (cVar != null) {
            return cVar;
        }
        synchronized (this) {
            if (this.ank == null) {
                this.ank = new com.kwad.framework.filedownloader.services.c();
            }
        }
        return this.ank;
    }

    /* JADX WARN: Removed duplicated region for block: B:73:0x018b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void a(com.kwad.framework.filedownloader.b.a.InterfaceC0371a r24) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 427
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.kwad.framework.filedownloader.download.b.a(com.kwad.framework.filedownloader.b.a$a):void");
    }
}
