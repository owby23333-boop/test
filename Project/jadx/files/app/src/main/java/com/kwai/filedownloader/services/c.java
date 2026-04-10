package com.kwai.filedownloader.services;

import com.kwai.filedownloader.d.b;
import com.kwai.filedownloader.e.c;
import com.kwai.filedownloader.kwai.c;

/* JADX INFO: loaded from: classes3.dex */
public final class c {
    private final b aHw;

    public interface a {
        c.b T();
    }

    public static class b {
        c.b aHA;
        a aHB;
        c.a aHC;
        c.d aHD;
        c.InterfaceC0467c aHx;
        Integer aHy;
        c.e aHz;

        public final b a(c.b bVar) {
            this.aHA = bVar;
            return this;
        }

        public final b a(a aVar) {
            this.aHB = aVar;
            return this;
        }

        public final b da(int i2) {
            this.aHy = Integer.MAX_VALUE;
            return this;
        }

        public final String toString() {
            return com.kwai.filedownloader.e.f.j("component: database[%s], maxNetworkCount[%s], outputStream[%s], connection[%s], connectionCountAdapter[%s]", this.aHx, this.aHy, this.aHz, this.aHA, this.aHC);
        }
    }

    public c() {
        this.aHw = null;
    }

    public c(b bVar) {
        this.aHw = bVar;
    }

    private static int IA() {
        return com.kwai.filedownloader.e.e.IP().aHY;
    }

    private static com.kwai.filedownloader.a.a IB() {
        return new com.kwai.filedownloader.a.c();
    }

    private static c.e IC() {
        return new b.a();
    }

    private static c.b ID() {
        return new c.b();
    }

    private static c.a IE() {
        return new com.kwai.filedownloader.kwai.a();
    }

    private static c.d Iz() {
        return new com.kwai.filedownloader.services.b();
    }

    public final int Hw() {
        Integer num;
        b bVar = this.aHw;
        if (bVar != null && (num = bVar.aHy) != null) {
            if (com.kwai.filedownloader.e.d.aHT) {
                com.kwai.filedownloader.e.d.g(this, "initial FileDownloader manager with the customize maxNetworkThreadCount: %d", num);
            }
            return com.kwai.filedownloader.e.e.de(num.intValue());
        }
        return IA();
    }

    public final com.kwai.filedownloader.a.a Iu() {
        c.InterfaceC0467c interfaceC0467c;
        b bVar = this.aHw;
        if (bVar == null || (interfaceC0467c = bVar.aHx) == null) {
            return IB();
        }
        com.kwai.filedownloader.a.a aVarIO = interfaceC0467c.IO();
        if (aVarIO == null) {
            return IB();
        }
        if (com.kwai.filedownloader.e.d.aHT) {
            com.kwai.filedownloader.e.d.g(this, "initial FileDownloader manager with the customize database: %s", aVarIO);
        }
        return aVarIO;
    }

    public final c.e Iv() {
        c.e eVar;
        b bVar = this.aHw;
        if (bVar != null && (eVar = bVar.aHz) != null) {
            if (com.kwai.filedownloader.e.d.aHT) {
                com.kwai.filedownloader.e.d.g(this, "initial FileDownloader manager with the customize output stream: %s", eVar);
            }
            return eVar;
        }
        return IC();
    }

    public final c.b Iw() {
        c.b bVarT;
        b bVar = this.aHw;
        if (bVar == null) {
            return ID();
        }
        a aVar = bVar.aHB;
        return (aVar == null || (bVarT = aVar.T()) == null) ? ID() : bVarT;
    }

    public final c.a Ix() {
        c.a aVar;
        b bVar = this.aHw;
        if (bVar != null && (aVar = bVar.aHC) != null) {
            if (com.kwai.filedownloader.e.d.aHT) {
                com.kwai.filedownloader.e.d.g(this, "initial FileDownloader manager with the customize connection count adapter: %s", aVar);
            }
            return aVar;
        }
        return IE();
    }

    public final c.d Iy() {
        c.d dVar;
        b bVar = this.aHw;
        if (bVar != null && (dVar = bVar.aHD) != null) {
            if (com.kwai.filedownloader.e.d.aHT) {
                com.kwai.filedownloader.e.d.g(this, "initial FileDownloader manager with the customize id generator: %s", dVar);
            }
            return dVar;
        }
        return Iz();
    }
}
