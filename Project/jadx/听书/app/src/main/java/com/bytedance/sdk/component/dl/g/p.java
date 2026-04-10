package com.bytedance.sdk.component.dl.g;

import java.security.cert.Certificate;
import java.util.Collections;
import java.util.List;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.SSLSession;

/* JADX INFO: loaded from: classes2.dex */
public final class p {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final List<Certificate> f641a;
    private final List<Certificate> dl;
    private final gz g;
    private final lq z;

    private p(lq lqVar, gz gzVar, List<Certificate> list, List<Certificate> list2) {
        this.z = lqVar;
        this.g = gzVar;
        this.dl = list;
        this.f641a = list2;
    }

    public static p z(SSLSession sSLSession) {
        String cipherSuite;
        List listEmptyList;
        List listEmptyList2;
        Certificate[] peerCertificates = null;
        try {
            cipherSuite = sSLSession.getCipherSuite();
        } catch (Exception unused) {
            cipherSuite = null;
        }
        if (cipherSuite == null) {
            throw new IllegalStateException("cipherSuite == null");
        }
        gz gzVarZ = gz.z(cipherSuite);
        String protocol = sSLSession.getProtocol();
        if (protocol == null) {
            throw new IllegalStateException("tlsVersion == null");
        }
        lq lqVarZ = lq.z(protocol);
        try {
            peerCertificates = sSLSession.getPeerCertificates();
        } catch (SSLPeerUnverifiedException unused2) {
        }
        if (peerCertificates != null) {
            listEmptyList = com.bytedance.sdk.component.dl.g.z.dl.z(peerCertificates);
        } else {
            listEmptyList = Collections.emptyList();
        }
        Certificate[] localCertificates = sSLSession.getLocalCertificates();
        if (localCertificates != null) {
            listEmptyList2 = com.bytedance.sdk.component.dl.g.z.dl.z(localCertificates);
        } else {
            listEmptyList2 = Collections.emptyList();
        }
        return new p(lqVarZ, gzVarZ, listEmptyList, listEmptyList2);
    }

    public lq z() {
        return this.z;
    }

    public gz g() {
        return this.g;
    }

    public List<Certificate> dl() {
        return this.dl;
    }

    public List<Certificate> a() {
        return this.f641a;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof p)) {
            return false;
        }
        p pVar = (p) obj;
        return this.z.equals(pVar.z) && this.g.equals(pVar.g) && this.dl.equals(pVar.dl) && this.f641a.equals(pVar.f641a);
    }

    public int hashCode() {
        return ((((((this.z.hashCode() + 527) * 31) + this.g.hashCode()) * 31) + this.dl.hashCode()) * 31) + this.f641a.hashCode();
    }
}
