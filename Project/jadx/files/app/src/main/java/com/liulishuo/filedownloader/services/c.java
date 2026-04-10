package com.liulishuo.filedownloader.services;

import com.liulishuo.filedownloader.d0.c;
import com.liulishuo.filedownloader.g0.b;
import com.liulishuo.filedownloader.h0.c;
import com.liulishuo.filedownloader.services.i;

/* JADX INFO: compiled from: DownloadMgrInitialParams.java */
/* JADX INFO: loaded from: classes3.dex */
public class c {
    private final a a = null;

    /* JADX INFO: compiled from: DownloadMgrInitialParams.java */
    public static class a {
        c.InterfaceC0490c a;
        Integer b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        c.e f17287c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        c.b f17288d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        c.a f17289e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        c.d f17290f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        i f17291g;
    }

    private c.a h() {
        return new com.liulishuo.filedownloader.d0.a();
    }

    private c.b i() {
        return new c.b();
    }

    private com.liulishuo.filedownloader.e0.a j() {
        return new com.liulishuo.filedownloader.e0.c();
    }

    private i k() {
        i.b bVar = new i.b();
        bVar.a(true);
        return bVar.a();
    }

    private c.d l() {
        return new b();
    }

    private c.e m() {
        return new b.a();
    }

    private int n() {
        return com.liulishuo.filedownloader.h0.e.a().f17209e;
    }

    public c.a a() {
        a aVar = this.a;
        if (aVar == null) {
            return h();
        }
        c.a aVar2 = aVar.f17289e;
        if (aVar2 == null) {
            return h();
        }
        if (com.liulishuo.filedownloader.h0.d.a) {
            com.liulishuo.filedownloader.h0.d.a(this, "initial FileDownloader manager with the customize connection count adapter: %s", aVar2);
        }
        return aVar2;
    }

    public c.b b() {
        a aVar = this.a;
        if (aVar == null) {
            return i();
        }
        c.b bVar = aVar.f17288d;
        if (bVar == null) {
            return i();
        }
        if (com.liulishuo.filedownloader.h0.d.a) {
            com.liulishuo.filedownloader.h0.d.a(this, "initial FileDownloader manager with the customize connection creator: %s", bVar);
        }
        return bVar;
    }

    public com.liulishuo.filedownloader.e0.a c() {
        c.InterfaceC0490c interfaceC0490c;
        a aVar = this.a;
        if (aVar == null || (interfaceC0490c = aVar.a) == null) {
            return j();
        }
        com.liulishuo.filedownloader.e0.a aVarA = interfaceC0490c.a();
        if (aVarA == null) {
            return j();
        }
        if (com.liulishuo.filedownloader.h0.d.a) {
            com.liulishuo.filedownloader.h0.d.a(this, "initial FileDownloader manager with the customize database: %s", aVarA);
        }
        return aVarA;
    }

    public i d() {
        a aVar = this.a;
        if (aVar == null) {
            return k();
        }
        i iVar = aVar.f17291g;
        if (iVar == null) {
            return k();
        }
        if (com.liulishuo.filedownloader.h0.d.a) {
            com.liulishuo.filedownloader.h0.d.a(this, "initial FileDownloader manager with the customize foreground service config: %s", iVar);
        }
        return iVar;
    }

    public c.d e() {
        a aVar = this.a;
        if (aVar == null) {
            return l();
        }
        c.d dVar = aVar.f17290f;
        if (dVar == null) {
            return l();
        }
        if (com.liulishuo.filedownloader.h0.d.a) {
            com.liulishuo.filedownloader.h0.d.a(this, "initial FileDownloader manager with the customize id generator: %s", dVar);
        }
        return dVar;
    }

    public c.e f() {
        a aVar = this.a;
        if (aVar == null) {
            return m();
        }
        c.e eVar = aVar.f17287c;
        if (eVar == null) {
            return m();
        }
        if (com.liulishuo.filedownloader.h0.d.a) {
            com.liulishuo.filedownloader.h0.d.a(this, "initial FileDownloader manager with the customize output stream: %s", eVar);
        }
        return eVar;
    }

    public int g() {
        a aVar = this.a;
        if (aVar == null) {
            return n();
        }
        Integer num = aVar.b;
        if (num == null) {
            return n();
        }
        if (com.liulishuo.filedownloader.h0.d.a) {
            com.liulishuo.filedownloader.h0.d.a(this, "initial FileDownloader manager with the customize maxNetworkThreadCount: %d", num);
        }
        return com.liulishuo.filedownloader.h0.e.a(num.intValue());
    }
}
