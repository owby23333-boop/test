package bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122;

import java.security.cert.Certificate;
import java.util.Collections;
import java.util.List;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.SSLSession;

/* JADX INFO: loaded from: classes.dex */
public final class q {
    private final d0 a;
    private final h b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final List<Certificate> f1228c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final List<Certificate> f1229d;

    private q(d0 d0Var, h hVar, List<Certificate> list, List<Certificate> list2) {
        this.a = d0Var;
        this.b = hVar;
        this.f1228c = list;
        this.f1229d = list2;
    }

    public static q a(SSLSession sSLSession) {
        String cipherSuite;
        Certificate[] peerCertificates = null;
        try {
            cipherSuite = sSLSession.getCipherSuite();
        } catch (Exception unused) {
            cipherSuite = null;
        }
        if (cipherSuite == null) {
            throw new IllegalStateException("cipherSuite == null");
        }
        h hVarA = h.a(cipherSuite);
        String protocol = sSLSession.getProtocol();
        if (protocol == null) {
            throw new IllegalStateException("tlsVersion == null");
        }
        d0 d0VarA = d0.a(protocol);
        try {
            peerCertificates = sSLSession.getPeerCertificates();
        } catch (SSLPeerUnverifiedException unused2) {
        }
        List listA = peerCertificates != null ? bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.c.a(peerCertificates) : Collections.emptyList();
        Certificate[] localCertificates = sSLSession.getLocalCertificates();
        return new q(d0VarA, hVarA, listA, localCertificates != null ? bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.c.a(localCertificates) : Collections.emptyList());
    }

    public h a() {
        return this.b;
    }

    public List<Certificate> b() {
        return this.f1228c;
    }

    public boolean equals(Object obj) {
        if (obj instanceof q) {
            q qVar = (q) obj;
            if (this.a.equals(qVar.a) && this.b.equals(qVar.b) && this.f1228c.equals(qVar.f1228c) && this.f1229d.equals(qVar.f1229d)) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        return ((((((this.a.hashCode() + 527) * 31) + this.b.hashCode()) * 31) + this.f1228c.hashCode()) * 31) + this.f1229d.hashCode();
    }
}
