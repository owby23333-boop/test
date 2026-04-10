package com.bytedance.sdk.component.dl.g.z.g;

import com.bytedance.android.live.base.api.push.ILivePush;
import com.bytedance.sdk.component.dl.g.fo;
import com.bytedance.sdk.component.dl.g.h;
import com.bytedance.sdk.component.dl.g.io;
import com.bytedance.sdk.component.dl.g.js;
import com.bytedance.sdk.component.dl.g.kb;
import com.bytedance.sdk.component.dl.g.ls;
import com.bytedance.sdk.component.dl.g.p;
import com.bytedance.sdk.component.dl.g.sy;
import com.bytedance.sdk.component.dl.g.tb;
import com.bytedance.sdk.component.dl.g.uy;
import com.bytedance.sdk.component.dl.g.x;
import com.bytedance.sdk.component.dl.g.z.gc.e;
import com.bytedance.sdk.component.dl.g.zw;
import com.bytedance.sdk.component.dl.z.wp;
import com.google.common.net.HttpHeaders;
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

/* JADX INFO: loaded from: classes2.dex */
public final class dl extends e.g implements fo {
    private final uy e;
    private Socket fo;
    public int g;
    private final x gz;
    private com.bytedance.sdk.component.dl.g.z.gc.e i;
    private p kb;
    private com.bytedance.sdk.component.dl.z.a pf;
    private Socket uy;
    private com.bytedance.sdk.component.dl.z.gc v;
    private io wp;
    public boolean z;
    public int dl = 1;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<Reference<e>> f659a = new ArrayList();
    public long gc = Long.MAX_VALUE;

    public dl(uy uyVar, x xVar) {
        this.e = uyVar;
        this.gz = xVar;
    }

    /* JADX WARN: Removed duplicated region for block: B:34:0x00bc  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x00cc A[RETURN] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void z(int r16, int r17, int r18, boolean r19, com.bytedance.sdk.component.dl.g.gc r20, com.bytedance.sdk.component.dl.g.ls r21) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 287
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.component.dl.g.z.g.dl.z(int, int, int, boolean, com.bytedance.sdk.component.dl.g.gc, com.bytedance.sdk.component.dl.g.ls):void");
    }

    private void z(int i, int i2, int i3, com.bytedance.sdk.component.dl.g.gc gcVar, ls lsVar) throws IOException {
        sy syVarM = m();
        js jsVarZ = syVarM.z();
        for (int i4 = 0; i4 < 21; i4++) {
            z(i, i2, gcVar, lsVar);
            syVarM = z(i2, i3, syVarM, jsVarZ);
            if (syVarM == null) {
                return;
            }
            com.bytedance.sdk.component.dl.g.z.dl.z(this.fo);
            this.fo = null;
            this.pf = null;
            this.v = null;
        }
    }

    private void z(int i, int i2, com.bytedance.sdk.component.dl.g.gc gcVar, ls lsVar) throws IOException {
        Proxy proxyG = this.gz.g();
        Socket socketCreateSocket = (proxyG.type() == Proxy.Type.DIRECT || proxyG.type() == Proxy.Type.HTTP) ? this.gz.z().dl().createSocket() : new Socket(proxyG);
        this.fo = socketCreateSocket;
        socketCreateSocket.setSoTimeout(i2);
        try {
            com.bytedance.sdk.component.dl.g.z.e.gc.g().z(this.fo, this.gz.dl(), i);
            try {
                this.v = wp.z(wp.g(this.fo));
                this.pf = wp.z(wp.z(this.fo));
            } catch (NullPointerException e) {
                if ("throw with null exception".equals(e.getMessage())) {
                    throw new IOException(e);
                }
            }
        } catch (ConnectException e2) {
            ConnectException connectException = new ConnectException("Failed to connect to " + this.gz.dl());
            connectException.initCause(e2);
            throw connectException;
        }
    }

    private void z(g gVar, com.bytedance.sdk.component.dl.g.gc gcVar, ls lsVar) throws Throwable {
        if (this.gz.z().fo() == null) {
            this.wp = io.HTTP_1_1;
            this.uy = this.fo;
            return;
        }
        z(gVar);
        try {
            if (this.wp == io.HTTP_2) {
                this.uy.setSoTimeout(0);
                com.bytedance.sdk.component.dl.g.z.gc.e eVarZ = new e.z(true).z(this.uy, this.gz.z().z().e(), this.v, this.pf).z(this).z();
                this.i = eVarZ;
                eVarZ.dl();
            }
        } catch (Throwable unused) {
        }
    }

    private void z(g gVar) throws Throwable {
        com.bytedance.sdk.component.dl.g.z zVarZ = this.gz.z();
        SSLSocket sSLSocket = null;
        try {
            try {
                SSLSocket sSLSocket2 = (SSLSocket) zVarZ.fo().createSocket(this.fo, zVarZ.z().e(), zVarZ.z().gz(), true);
                try {
                    kb kbVarZ = gVar.z(sSLSocket2);
                    if (kbVarZ.a()) {
                        com.bytedance.sdk.component.dl.g.z.e.gc.g().z(sSLSocket2, zVarZ.z().e(), zVarZ.gc());
                    }
                    try {
                        sSLSocket2.startHandshake();
                    } catch (Throwable unused) {
                    }
                    p pVarZ = p.z(sSLSocket2.getSession());
                    if (!zVarZ.uy().verify(zVarZ.z().e(), sSLSocket2.getSession())) {
                        X509Certificate x509Certificate = (X509Certificate) pVarZ.dl().get(0);
                        throw new SSLPeerUnverifiedException("Hostname " + zVarZ.z().e() + " not verified:\n    certificate: " + com.bytedance.sdk.component.dl.g.e.z((Certificate) x509Certificate) + "\n    DN: " + x509Certificate.getSubjectDN().getName() + "\n    subjectAltNames: " + com.bytedance.sdk.component.dl.g.z.fo.gc.z(x509Certificate));
                    }
                    zVarZ.kb().z(zVarZ.z().e(), pVarZ.dl());
                    String strZ = kbVarZ.a() ? com.bytedance.sdk.component.dl.g.z.e.gc.g().z(sSLSocket2) : null;
                    this.uy = sSLSocket2;
                    this.v = wp.z(wp.g(sSLSocket2));
                    this.pf = wp.z(wp.z(this.uy));
                    this.kb = pVarZ;
                    this.wp = strZ != null ? io.z(strZ) : io.HTTP_1_1;
                    if (sSLSocket2 != null) {
                        com.bytedance.sdk.component.dl.g.z.e.gc.g().g(sSLSocket2);
                    }
                } catch (AssertionError e) {
                    e = e;
                    if (!com.bytedance.sdk.component.dl.g.z.dl.z(e)) {
                        throw e;
                    }
                    throw new IOException(e);
                } catch (Throwable th) {
                    th = th;
                    sSLSocket = sSLSocket2;
                    if (sSLSocket != null) {
                        com.bytedance.sdk.component.dl.g.z.e.gc.g().g(sSLSocket);
                    }
                    com.bytedance.sdk.component.dl.g.z.dl.z((Socket) sSLSocket);
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
            }
        } catch (AssertionError e2) {
            e = e2;
        }
    }

    private sy z(int i, int i2, sy syVar, js jsVar) throws IOException {
        String str = "CONNECT " + com.bytedance.sdk.component.dl.g.z.dl.z(jsVar, true) + " HTTP/1.1";
        while (true) {
            com.bytedance.sdk.component.dl.g.z.a.z zVar = new com.bytedance.sdk.component.dl.g.z.a.z(null, null, this.v, this.pf);
            this.v.z().z(i, TimeUnit.MILLISECONDS);
            this.pf.z().z(i2, TimeUnit.MILLISECONDS);
            zVar.z(syVar.dl(), str);
            zVar.g();
            h hVarZ = zVar.z(false).z(syVar).z();
            long jZ = com.bytedance.sdk.component.dl.g.z.dl.gc.z(hVarZ);
            if (jZ == -1) {
                jZ = 0;
            }
            com.bytedance.sdk.component.dl.z.js jsVarG = zVar.g(jZ);
            com.bytedance.sdk.component.dl.g.z.dl.g(jsVarG, Integer.MAX_VALUE, TimeUnit.MILLISECONDS);
            jsVarG.close();
            int iDl = hVarZ.dl();
            if (iDl == 200) {
                if (this.v.dl().gc() && this.pf.dl().gc()) {
                    return null;
                }
                throw new IOException("TLS tunnel buffered too many bytes!");
            }
            if (iDl == 407) {
                sy syVarZ = this.gz.z().a().z(this.gz, hVarZ);
                if (syVarZ == null) {
                    throw new IOException("Failed to authenticate with proxy");
                }
                if (ILivePush.ClickType.CLOSE.equalsIgnoreCase(hVarZ.z(HttpHeaders.CONNECTION))) {
                    return syVarZ;
                }
                syVar = syVarZ;
            } else {
                throw new IOException("Unexpected response code for CONNECT: " + hVarZ.dl());
            }
        }
    }

    private sy m() {
        return new sy.z().z(this.gz.z().z()).z(HttpHeaders.HOST, com.bytedance.sdk.component.dl.g.z.dl.z(this.gz.z().z(), true)).z("Proxy-Connection", HttpHeaders.KEEP_ALIVE).z("User-Agent", com.bytedance.sdk.component.dl.g.z.a.z()).z();
    }

    public boolean z(com.bytedance.sdk.component.dl.g.z zVar, x xVar) {
        if (this.f659a.size() >= this.dl || this.z || !com.bytedance.sdk.component.dl.g.z.z.z.z(this.gz.z(), zVar)) {
            return false;
        }
        if (zVar.z().e().equals(z().z().z().e())) {
            return true;
        }
        if (this.i == null || xVar == null || xVar.g().type() != Proxy.Type.DIRECT || this.gz.g().type() != Proxy.Type.DIRECT || !this.gz.dl().equals(xVar.dl()) || xVar.z().uy() != com.bytedance.sdk.component.dl.g.z.fo.gc.z || !z(zVar.z())) {
            return false;
        }
        try {
            zVar.kb().z(zVar.z().e(), a().dl());
            return true;
        } catch (SSLPeerUnverifiedException unused) {
            return false;
        }
    }

    public boolean z(js jsVar) {
        if (jsVar.gz() != this.gz.z().z().gz()) {
            return false;
        }
        if (jsVar.e().equals(this.gz.z().z().e())) {
            return true;
        }
        return this.kb != null && com.bytedance.sdk.component.dl.g.z.fo.gc.z.z(jsVar.e(), (X509Certificate) this.kb.dl().get(0));
    }

    public com.bytedance.sdk.component.dl.g.z.dl.dl z(zw zwVar, tb.z zVar, e eVar) throws SocketException {
        if (this.i != null) {
            return new com.bytedance.sdk.component.dl.g.z.gc.m(zwVar, zVar, eVar, this.i);
        }
        this.uy.setSoTimeout(zVar.dl());
        this.v.z().z(zVar.dl(), TimeUnit.MILLISECONDS);
        this.pf.z().z(zVar.a(), TimeUnit.MILLISECONDS);
        return new com.bytedance.sdk.component.dl.g.z.a.z(zwVar, eVar, this.v, this.pf);
    }

    @Override // com.bytedance.sdk.component.dl.g.fo
    public x z() {
        return this.gz;
    }

    public void g() {
        com.bytedance.sdk.component.dl.g.z.dl.z(this.fo);
    }

    public Socket dl() {
        return this.uy;
    }

    public boolean z(boolean z) {
        if (this.uy.isClosed() || this.uy.isInputShutdown() || this.uy.isOutputShutdown()) {
            return false;
        }
        com.bytedance.sdk.component.dl.g.z.gc.e eVar = this.i;
        if (eVar != null) {
            return !eVar.a();
        }
        if (z) {
            try {
                int soTimeout = this.uy.getSoTimeout();
                try {
                    this.uy.setSoTimeout(1);
                    return !this.v.gc();
                } finally {
                    this.uy.setSoTimeout(soTimeout);
                }
            } catch (SocketTimeoutException unused) {
            } catch (IOException unused2) {
                return false;
            }
        }
        return true;
    }

    @Override // com.bytedance.sdk.component.dl.g.z.gc.e.g
    public void z(com.bytedance.sdk.component.dl.g.z.gc.fo foVar) throws IOException {
        foVar.z(com.bytedance.sdk.component.dl.g.z.gc.g.REFUSED_STREAM);
    }

    @Override // com.bytedance.sdk.component.dl.g.z.gc.e.g
    public void z(com.bytedance.sdk.component.dl.g.z.gc.e eVar) {
        synchronized (this.e) {
            this.dl = eVar.z();
        }
    }

    public p a() {
        return this.kb;
    }

    public boolean gc() {
        return this.i != null;
    }

    public String toString() {
        StringBuilder sbAppend = new StringBuilder("Connection{").append(this.gz.z().z().e()).append(":").append(this.gz.z().z().gz()).append(", proxy=").append(this.gz.g()).append(" hostAddress=").append(this.gz.dl()).append(" cipherSuite=");
        p pVar = this.kb;
        return sbAppend.append(pVar != null ? pVar.g() : "none").append(" protocol=").append(this.wp).append('}').toString();
    }
}
