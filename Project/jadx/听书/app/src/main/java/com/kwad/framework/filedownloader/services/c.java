package com.kwad.framework.filedownloader.services;

import com.kwad.framework.filedownloader.a.c;
import com.kwad.framework.filedownloader.e.b;
import com.kwad.framework.filedownloader.f.c;

/* JADX INFO: loaded from: classes4.dex */
public final class c {
    private final b aph;

    public interface a {
        c.b yi();
    }

    public c() {
        this.aph = null;
    }

    public c(b bVar) {
        this.aph = bVar;
    }

    public final int yf() {
        b bVar = this.aph;
        if (bVar == null) {
            return zl();
        }
        Integer num = bVar.apj;
        if (num != null) {
            if (com.kwad.framework.filedownloader.f.d.apD) {
                com.kwad.framework.filedownloader.f.d.c(this, "initial FileDownloader manager with the customize maxNetworkThreadCount: %d", num);
            }
            return com.kwad.framework.filedownloader.f.e.ce(num.intValue());
        }
        return zl();
    }

    public final com.kwad.framework.filedownloader.b.a zf() {
        b bVar = this.aph;
        if (bVar == null || bVar.api == null) {
            return new com.kwad.framework.filedownloader.b.c();
        }
        com.kwad.framework.filedownloader.b.a aVarZA = this.aph.api.zA();
        return aVarZA != null ? aVarZA : new com.kwad.framework.filedownloader.b.c();
    }

    public final c.e zg() {
        b bVar = this.aph;
        if (bVar == null) {
            return zm();
        }
        c.e eVar = bVar.apk;
        if (eVar != null) {
            if (com.kwad.framework.filedownloader.f.d.apD) {
                com.kwad.framework.filedownloader.f.d.c(this, "initial FileDownloader manager with the customize output stream: %s", eVar);
            }
            return eVar;
        }
        return zm();
    }

    public final c.b zh() {
        c.b bVarYi;
        b bVar = this.aph;
        if (bVar == null) {
            return zn();
        }
        a aVar = bVar.apm;
        return (aVar == null || (bVarYi = aVar.yi()) == null) ? zn() : bVarYi;
    }

    public final c.a zi() {
        b bVar = this.aph;
        if (bVar == null) {
            return zo();
        }
        c.a aVar = bVar.apn;
        if (aVar != null) {
            if (com.kwad.framework.filedownloader.f.d.apD) {
                com.kwad.framework.filedownloader.f.d.c(this, "initial FileDownloader manager with the customize connection count adapter: %s", aVar);
            }
            return aVar;
        }
        return zo();
    }

    public final c.d zj() {
        b bVar = this.aph;
        if (bVar == null) {
            return zk();
        }
        c.d dVar = bVar.apo;
        if (dVar != null) {
            if (com.kwad.framework.filedownloader.f.d.apD) {
                com.kwad.framework.filedownloader.f.d.c(this, "initial FileDownloader manager with the customize id generator: %s", dVar);
            }
            return dVar;
        }
        return zk();
    }

    private static c.d zk() {
        return new com.kwad.framework.filedownloader.services.b();
    }

    private static int zl() {
        return com.kwad.framework.filedownloader.f.e.zB().apI;
    }

    private static c.e zm() {
        return new b.a();
    }

    private static c.b zn() {
        return new c.b();
    }

    private static c.a zo() {
        return new com.kwad.framework.filedownloader.a.a();
    }

    public static class b {
        c.InterfaceC0376c api;
        Integer apj;
        c.e apk;
        c.b apl;
        a apm;
        c.a apn;
        c.d apo;

        public final b ca(int i) {
            this.apj = Integer.MAX_VALUE;
            return this;
        }

        public final b a(c.b bVar) {
            this.apl = bVar;
            return this;
        }

        public final b a(a aVar) {
            this.apm = aVar;
            return this;
        }

        public final String toString() {
            return com.kwad.framework.filedownloader.f.f.c("component: database[%s], maxNetworkCount[%s], outputStream[%s], connection[%s], connectionCountAdapter[%s]", this.api, this.apj, this.apk, this.apl, this.apn);
        }
    }
}
