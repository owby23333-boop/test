package com.bytedance.sdk.component.d.bf;

import java.security.cert.Certificate;
import java.util.Collections;
import java.util.List;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.SSLSession;

/* JADX INFO: loaded from: classes.dex */
public final class l {
    private final v bf;
    private final List<Certificate> d;
    private final x e;
    private final List<Certificate> tg;

    private l(x xVar, v vVar, List<Certificate> list, List<Certificate> list2) {
        this.e = xVar;
        this.bf = vVar;
        this.d = list;
        this.tg = list2;
    }

    public static l e(SSLSession sSLSession) {
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
        v vVarE = v.e(cipherSuite);
        String protocol = sSLSession.getProtocol();
        if (protocol == null) {
            throw new IllegalStateException("tlsVersion == null");
        }
        x xVarE = x.e(protocol);
        try {
            peerCertificates = sSLSession.getPeerCertificates();
        } catch (SSLPeerUnverifiedException unused2) {
        }
        List listE = peerCertificates != null ? com.bytedance.sdk.component.d.bf.e.d.e(peerCertificates) : Collections.emptyList();
        Certificate[] localCertificates = sSLSession.getLocalCertificates();
        return new l(xVarE, vVarE, listE, localCertificates != null ? com.bytedance.sdk.component.d.bf.e.d.e(localCertificates) : Collections.emptyList());
    }

    public v bf() {
        return this.bf;
    }

    public List<Certificate> d() {
        return this.d;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof l)) {
            return false;
        }
        l lVar = (l) obj;
        return this.e.equals(lVar.e) && this.bf.equals(lVar.bf) && this.d.equals(lVar.d) && this.tg.equals(lVar.tg);
    }

    public int hashCode() {
        return ((((((527 + this.e.hashCode()) * 31) + this.bf.hashCode()) * 31) + this.d.hashCode()) * 31) + this.tg.hashCode();
    }

    public List<Certificate> tg() {
        return this.tg;
    }

    public x e() {
        return this.e;
    }
}
