package bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_for12;

import bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.a0;
import bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.b0;
import bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.c0;
import bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.p;
import bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.s;
import bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.t;
import bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.v;
import bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.y;
import bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.z;
import com.qq.e.comm.adevent.AdEventType;
import com.ss.android.socialbase.downloader.utils.DownloadUtils;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.ProtocolException;
import java.net.Proxy;
import java.net.SocketTimeoutException;
import java.security.cert.CertificateException;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLHandshakeException;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.SSLSocketFactory;

/* JADX INFO: loaded from: classes.dex */
public final class j implements t {
    private final v a;
    private final boolean b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_if122.g f952c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private Object f953d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private volatile boolean f954e;

    public j(v vVar, boolean z2) {
        this.a = vVar;
        this.b = z2;
    }

    private bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.a a(s sVar) {
        SSLSocketFactory sSLSocketFactory;
        HostnameVerifier hostnameVerifierM;
        bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.g gVarB;
        if (sVar.h()) {
            SSLSocketFactory sSLSocketFactoryX = this.a.x();
            hostnameVerifierM = this.a.m();
            sSLSocketFactory = sSLSocketFactoryX;
            gVarB = this.a.b();
        } else {
            sSLSocketFactory = null;
            hostnameVerifierM = null;
            gVarB = null;
        }
        return new bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.a(sVar.g(), sVar.j(), this.a.h(), this.a.w(), sSLSocketFactory, hostnameVerifierM, gVarB, this.a.s(), this.a.r(), this.a.q(), this.a.e(), this.a.t());
    }

    private y a(a0 a0Var) throws IOException {
        String strB;
        s sVarB;
        bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.b bVarA;
        if (a0Var == null) {
            throw new IllegalStateException();
        }
        bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_if122.c cVarB = this.f952c.b();
        c0 c0VarA = cVarB != null ? cVarB.a() : null;
        int iK = a0Var.k();
        String strE = a0Var.s().e();
        if (iK != 307 && iK != 308) {
            if (iK == 401) {
                bVarA = this.a.a();
            } else if (iK == 407) {
                if ((c0VarA != null ? c0VarA.b() : this.a.r()).type() != Proxy.Type.HTTP) {
                    throw new ProtocolException("Received HTTP_PROXY_AUTH (407) code while not using proxy");
                }
                bVarA = this.a.s();
            } else {
                if (iK == 408) {
                    if (!this.a.v()) {
                        return null;
                    }
                    a0Var.s().a();
                    if (a0Var.q() == null || a0Var.q().k() != 408) {
                        return a0Var.s();
                    }
                    return null;
                }
                switch (iK) {
                    case 300:
                    case AdEventType.VIDEO_PAGE_OPEN /* 301 */:
                    case 302:
                    case 303:
                        break;
                    default:
                        return null;
                }
            }
            return bVarA.a(c0VarA, a0Var);
        }
        if (!strE.equals("GET") && !strE.equals("HEAD")) {
            return null;
        }
        if (!this.a.k() || (strB = a0Var.b("Location")) == null || (sVarB = a0Var.s().g().b(strB)) == null) {
            return null;
        }
        if (!sVarB.m().equals(a0Var.s().g().m()) && !this.a.l()) {
            return null;
        }
        y.a aVarF = a0Var.s().f();
        if (f.b(strE)) {
            boolean zD = f.d(strE);
            if (f.c(strE)) {
                aVarF.a("GET", (z) null);
            } else {
                aVarF.a(strE, zD ? a0Var.s().a() : null);
            }
            if (!zD) {
                aVarF.a(DownloadUtils.TRANSFER_ENCODING);
                aVarF.a("Content-Length");
                aVarF.a("Content-Type");
            }
        }
        if (!a(a0Var, sVarB)) {
            aVarF.a("Authorization");
        }
        return aVarF.a(sVarB).a();
    }

    private boolean a(a0 a0Var, s sVar) {
        s sVarG = a0Var.s().g();
        return sVarG.g().equals(sVar.g()) && sVarG.j() == sVar.j() && sVarG.m().equals(sVar.m());
    }

    private boolean a(IOException iOException, boolean z2) {
        if (iOException instanceof ProtocolException) {
            return false;
        }
        if (iOException instanceof InterruptedIOException) {
            if (!(iOException instanceof SocketTimeoutException) || z2) {
                return false;
            }
        } else if (((iOException instanceof SSLHandshakeException) && (iOException.getCause() instanceof CertificateException)) || (iOException instanceof SSLPeerUnverifiedException)) {
            return false;
        }
        return true;
    }

    private boolean a(IOException iOException, boolean z2, y yVar) {
        this.f952c.a(iOException);
        if (this.a.v()) {
            if (z2) {
                yVar.a();
            }
            if (a(iOException, z2) && this.f952c.c()) {
                return true;
            }
        }
        return false;
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.t
    public a0 a(t.a aVar) throws IOException {
        a0 a0VarA;
        y yVarA;
        y yVarB = aVar.b();
        g gVar = (g) aVar;
        bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.e eVarE = gVar.e();
        p pVarG = gVar.g();
        this.f952c = new bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_if122.g(this.a.d(), a(yVarB.g()), eVarE, pVarG, this.f953d);
        a0 a0Var = null;
        int i2 = 0;
        while (!this.f954e) {
            try {
                try {
                    a0VarA = gVar.a(yVarB, this.f952c, null, null);
                    if (a0Var != null) {
                        a0VarA = a0VarA.p().c(a0Var.p().a((b0) null).a()).a();
                    }
                    yVarA = a(a0VarA);
                } catch (bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_if122.e e2) {
                    if (!a(e2.a(), false, yVarB)) {
                        throw e2.a();
                    }
                } catch (IOException e3) {
                    if (!a(e3, !(e3 instanceof bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_new1.a), yVarB)) {
                        throw e3;
                    }
                }
                if (yVarA == null) {
                    if (!this.b) {
                        this.f952c.e();
                    }
                    return a0VarA;
                }
                bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.c.a(a0VarA.i());
                int i3 = i2 + 1;
                if (i3 > 20) {
                    this.f952c.e();
                    throw new ProtocolException("Too many follow-up requests: " + i3);
                }
                yVarA.a();
                if (!a(a0VarA, yVarA.g())) {
                    this.f952c.e();
                    this.f952c = new bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_if122.g(this.a.d(), a(yVarA.g()), eVarE, pVarG, this.f953d);
                } else if (this.f952c.a() != null) {
                    throw new IllegalStateException("Closing the body of " + a0VarA + " didn't close its backing stream. Bad interceptor?");
                }
                a0Var = a0VarA;
                yVarB = yVarA;
                i2 = i3;
            } catch (Throwable th) {
                this.f952c.a((IOException) null);
                this.f952c.e();
                throw th;
            }
        }
        this.f952c.e();
        throw new IOException("Canceled");
    }

    public void a(Object obj) {
        this.f953d = obj;
    }

    public boolean a() {
        return this.f954e;
    }
}
