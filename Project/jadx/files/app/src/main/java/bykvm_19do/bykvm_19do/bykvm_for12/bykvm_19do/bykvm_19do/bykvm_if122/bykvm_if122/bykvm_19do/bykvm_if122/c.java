package bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_if122;

import anet.channel.util.HttpConstant;
import bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.l;
import bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.a0;
import bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_new1.g;
import bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.c0;
import bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.i;
import bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.j;
import bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.k;
import bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.p;
import bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.q;
import bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.s;
import bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.t;
import bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.v;
import bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.w;
import bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.y;
import java.io.IOException;
import java.lang.ref.Reference;
import java.net.ConnectException;
import java.net.Proxy;
import java.net.Socket;
import java.net.SocketException;
import java.net.SocketTimeoutException;
import java.security.cert.Certificate;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.SSLSocket;

/* JADX INFO: loaded from: classes.dex */
public final class c extends g.i implements i {
    private final j b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final c0 f958c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private Socket f959d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private Socket f960e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private q f961f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private w f962g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_new1.g f963h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.e f964i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.d f965j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public boolean f966k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public int f967l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public int f968m = 1;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final List<Reference<g>> f969n = new ArrayList();

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public long f970o = Long.MAX_VALUE;

    public c(j jVar, c0 c0Var) {
        this.b = jVar;
        this.f958c = c0Var;
    }

    private y a(int i2, int i3, y yVar, s sVar) throws IOException {
        String str = "CONNECT " + bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.c.a(sVar, true) + " HTTP/1.1";
        while (true) {
            bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_int108.a aVar = new bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_int108.a(null, null, this.f964i, this.f965j);
            this.f964i.b().a(i2, TimeUnit.MILLISECONDS);
            this.f965j.b().a(i3, TimeUnit.MILLISECONDS);
            aVar.a(yVar.c(), str);
            aVar.a();
            a0 a0VarA = aVar.a(false).a(yVar).a();
            long jA = bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_for12.e.a(a0VarA);
            if (jA == -1) {
                jA = 0;
            }
            bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.s sVarB = aVar.b(jA);
            bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.c.b(sVarB, Integer.MAX_VALUE, TimeUnit.MILLISECONDS);
            sVarB.close();
            int iK = a0VarA.k();
            if (iK == 200) {
                if (this.f964i.a().f() && this.f965j.a().f()) {
                    return null;
                }
                throw new IOException("TLS tunnel buffered too many bytes!");
            }
            if (iK != 407) {
                throw new IOException("Unexpected response code for CONNECT: " + a0VarA.k());
            }
            y yVarA = this.f958c.a().g().a(this.f958c, a0VarA);
            if (yVarA == null) {
                throw new IOException("Failed to authenticate with proxy");
            }
            if (com.anythink.expressad.foundation.d.c.cf.equalsIgnoreCase(a0VarA.b("Connection"))) {
                return yVarA;
            }
            yVar = yVarA;
        }
    }

    private void a(int i2, int i3, int i4, bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.e eVar, p pVar) throws IOException {
        y yVarF = f();
        s sVarG = yVarF.g();
        for (int i5 = 0; i5 < 21; i5++) {
            a(i2, i3, eVar, pVar);
            yVarF = a(i3, i4, yVarF, sVarG);
            if (yVarF == null) {
                return;
            }
            bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.c.a(this.f959d);
            this.f959d = null;
            this.f965j = null;
            this.f964i = null;
            pVar.a(eVar, this.f958c.d(), this.f958c.b(), null);
        }
    }

    private void a(int i2, int i3, bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.e eVar, p pVar) throws IOException {
        Proxy proxyB = this.f958c.b();
        this.f959d = (proxyB.type() == Proxy.Type.DIRECT || proxyB.type() == Proxy.Type.HTTP) ? this.f958c.a().i().createSocket() : new Socket(proxyB);
        pVar.a(eVar, this.f958c.d(), proxyB);
        this.f959d.setSoTimeout(i3);
        try {
            bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_try19.e.b().a(this.f959d, this.f958c.d(), i2);
            try {
                this.f964i = l.a(l.b(this.f959d));
                this.f965j = l.a(l.a(this.f959d));
            } catch (NullPointerException e2) {
                if ("throw with null exception".equals(e2.getMessage())) {
                    throw new IOException(e2);
                }
            }
        } catch (ConnectException e3) {
            ConnectException connectException = new ConnectException("Failed to connect to " + this.f958c.d());
            connectException.initCause(e3);
            throw connectException;
        }
    }

    private void a(b bVar) throws Throwable {
        SSLSocket sSLSocket;
        bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.a aVarA = this.f958c.a();
        try {
            try {
                sSLSocket = (SSLSocket) aVarA.j().createSocket(this.f959d, aVarA.k().g(), aVarA.k().j(), true);
                try {
                    k kVarA = bVar.a(sSLSocket);
                    if (kVarA.c()) {
                        bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_try19.e.b().a(sSLSocket, aVarA.k().g(), aVarA.e());
                    }
                    sSLSocket.startHandshake();
                    q qVarA = q.a(sSLSocket.getSession());
                    if (aVarA.d().verify(aVarA.k().g(), sSLSocket.getSession())) {
                        aVarA.a().a(aVarA.k().g(), qVarA.b());
                        String strB = kVarA.c() ? bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_try19.e.b().b(sSLSocket) : null;
                        this.f960e = sSLSocket;
                        this.f964i = l.a(l.b(this.f960e));
                        this.f965j = l.a(l.a(this.f960e));
                        this.f961f = qVarA;
                        this.f962g = strB != null ? w.a(strB) : w.HTTP_1_1;
                        if (sSLSocket != null) {
                            bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_try19.e.b().a(sSLSocket);
                            return;
                        }
                        return;
                    }
                    X509Certificate x509Certificate = (X509Certificate) qVarA.b().get(0);
                    throw new SSLPeerUnverifiedException("Hostname " + aVarA.k().g() + " not verified:\n    certificate: " + bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.g.a((Certificate) x509Certificate) + "\n    DN: " + x509Certificate.getSubjectDN().getName() + "\n    subjectAltNames: " + bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_case1.e.a(x509Certificate));
                } catch (AssertionError e2) {
                    e = e2;
                    if (!bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.c.a(e)) {
                        throw e;
                    }
                    throw new IOException(e);
                } catch (Throwable th) {
                    th = th;
                    if (sSLSocket != null) {
                        bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_try19.e.b().a(sSLSocket);
                    }
                    bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.c.a((Socket) sSLSocket);
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
                sSLSocket = null;
            }
        } catch (AssertionError e3) {
            e = e3;
        }
    }

    private void a(b bVar, bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.e eVar, p pVar) throws Throwable {
        if (this.f958c.a().j() == null) {
            this.f962g = w.HTTP_1_1;
            this.f960e = this.f959d;
            return;
        }
        pVar.g(eVar);
        a(bVar);
        pVar.a(eVar, this.f961f);
        if (this.f962g == w.HTTP_2) {
            this.f960e.setSoTimeout(0);
            this.f963h = new g.h(true).a(this.f960e, this.f958c.a().k().g(), this.f964i, this.f965j).a(this).a();
            this.f963h.k();
        }
    }

    private y f() {
        return new y.a().a(this.f958c.a().k()).b(HttpConstant.HOST, bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.c.a(this.f958c.a().k(), true)).b("Proxy-Connection", com.anythink.expressad.foundation.g.f.g.c.f10570c).b("User-Agent", bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.d.a()).a();
    }

    public bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_for12.c a(v vVar, t.a aVar, g gVar) throws SocketException {
        bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_new1.g gVar2 = this.f963h;
        if (gVar2 != null) {
            return new bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_new1.f(vVar, aVar, gVar, gVar2);
        }
        this.f960e.setSoTimeout(aVar.d());
        this.f964i.b().a(aVar.d(), TimeUnit.MILLISECONDS);
        this.f965j.b().a(aVar.a(), TimeUnit.MILLISECONDS);
        return new bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_int108.a(vVar, gVar, this.f964i, this.f965j);
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.i
    public c0 a() {
        return this.f958c;
    }

    /* JADX WARN: Removed duplicated region for block: B:34:0x00ce  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x00de A[ORIG_RETURN, RETURN] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void a(int r16, int r17, int r18, boolean r19, bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.e r20, bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.p r21) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 308
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_if122.c.a(int, int, int, boolean, bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.e, bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.p):void");
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_new1.g.i
    public void a(bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_new1.g gVar) {
        synchronized (this.b) {
            this.f968m = gVar.j();
        }
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_new1.g.i
    public void a(bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_new1.i iVar) throws IOException {
        iVar.a(bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_new1.b.REFUSED_STREAM);
    }

    public boolean a(bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.a aVar, c0 c0Var) {
        if (this.f969n.size() < this.f968m && !this.f966k && bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.a.a.a(this.f958c.a(), aVar)) {
            if (aVar.k().g().equals(a().a().k().g())) {
                return true;
            }
            if (this.f963h != null && c0Var != null && c0Var.b().type() == Proxy.Type.DIRECT && this.f958c.b().type() == Proxy.Type.DIRECT && this.f958c.d().equals(c0Var.d()) && c0Var.a().d() == bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_case1.e.a && a(aVar.k())) {
                try {
                    aVar.a().a(aVar.k().g(), b().b());
                    return true;
                } catch (SSLPeerUnverifiedException unused) {
                }
            }
        }
        return false;
    }

    public boolean a(s sVar) {
        if (sVar.j() == this.f958c.a().k().j()) {
            if (sVar.g().equals(this.f958c.a().k().g())) {
                return true;
            }
            if (this.f961f != null && bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_case1.e.a.a(sVar.g(), (X509Certificate) this.f961f.b().get(0))) {
                return true;
            }
        }
        return false;
    }

    public boolean a(boolean z2) {
        if (!this.f960e.isClosed() && !this.f960e.isInputShutdown() && !this.f960e.isOutputShutdown()) {
            bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_new1.g gVar = this.f963h;
            if (gVar != null) {
                return true ^ gVar.i();
            }
            if (!z2) {
                return true;
            }
            try {
                int soTimeout = this.f960e.getSoTimeout();
                try {
                    this.f960e.setSoTimeout(1);
                    if (!this.f964i.f()) {
                        this.f960e.setSoTimeout(soTimeout);
                        return true;
                    }
                    this.f960e.setSoTimeout(soTimeout);
                } catch (Throwable th) {
                    this.f960e.setSoTimeout(soTimeout);
                    throw th;
                }
            } catch (SocketTimeoutException unused) {
                return true;
            } catch (IOException unused2) {
            }
        }
        return false;
    }

    public q b() {
        return this.f961f;
    }

    public boolean c() {
        return this.f963h != null;
    }

    public w d() {
        return this.f962g;
    }

    public Socket e() {
        return this.f960e;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Connection{");
        sb.append(this.f958c.a().k().g());
        sb.append(":");
        sb.append(this.f958c.a().k().j());
        sb.append(", proxy=");
        sb.append(this.f958c.b());
        sb.append(" hostAddress=");
        sb.append(this.f958c.d());
        sb.append(" cipherSuite=");
        q qVar = this.f961f;
        sb.append(qVar != null ? qVar.a() : "none");
        sb.append(" protocol=");
        sb.append(this.f962g);
        sb.append('}');
        return sb.toString();
    }
}
