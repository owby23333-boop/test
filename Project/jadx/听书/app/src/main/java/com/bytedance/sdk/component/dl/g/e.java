package com.bytedance.sdk.component.dl.g;

import java.security.cert.Certificate;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import javax.net.ssl.SSLPeerUnverifiedException;

/* JADX INFO: loaded from: classes2.dex */
public final class e {
    public static final e z = new z().z();
    private final com.bytedance.sdk.component.dl.g.z.fo.dl dl;
    private final Set<g> g;

    e(Set<g> set, com.bytedance.sdk.component.dl.g.z.fo.dl dlVar) {
        this.g = set;
        this.dl = dlVar;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof e)) {
            return false;
        }
        e eVar = (e) obj;
        return com.bytedance.sdk.component.dl.g.z.dl.z(this.dl, eVar.dl) && this.g.equals(eVar.g);
    }

    public int hashCode() {
        com.bytedance.sdk.component.dl.g.z.fo.dl dlVar = this.dl;
        return ((dlVar != null ? dlVar.hashCode() : 0) * 31) + this.g.hashCode();
    }

    public void z(String str, List<Certificate> list) throws SSLPeerUnverifiedException {
        List<g> listZ = z(str);
        if (listZ.isEmpty()) {
            return;
        }
        com.bytedance.sdk.component.dl.g.z.fo.dl dlVar = this.dl;
        if (dlVar != null) {
            list = dlVar.z(list, str);
        }
        int size = list.size();
        for (int i = 0; i < size; i++) {
            X509Certificate x509Certificate = (X509Certificate) list.get(i);
            int size2 = listZ.size();
            com.bytedance.sdk.component.dl.z.m mVarG = null;
            com.bytedance.sdk.component.dl.z.m mVarZ = null;
            for (int i2 = 0; i2 < size2; i2++) {
                g gVar = listZ.get(i2);
                if (gVar.dl.equals("sha256/")) {
                    if (mVarG == null) {
                        mVarG = g(x509Certificate);
                    }
                    if (gVar.f627a.equals(mVarG)) {
                        return;
                    }
                } else if (gVar.dl.equals("sha1/")) {
                    if (mVarZ == null) {
                        mVarZ = z(x509Certificate);
                    }
                    if (gVar.f627a.equals(mVarZ)) {
                        return;
                    }
                } else {
                    throw new AssertionError("unsupported hashAlgorithm: " + gVar.dl);
                }
            }
        }
        StringBuilder sb = new StringBuilder("Certificate pinning failure!\n  Peer certificate chain:");
        int size3 = list.size();
        for (int i3 = 0; i3 < size3; i3++) {
            X509Certificate x509Certificate2 = (X509Certificate) list.get(i3);
            sb.append("\n    ").append(z((Certificate) x509Certificate2)).append(": ").append(x509Certificate2.getSubjectDN().getName());
        }
        sb.append("\n  Pinned certificates for ").append(str).append(":");
        int size4 = listZ.size();
        for (int i4 = 0; i4 < size4; i4++) {
            sb.append("\n    ").append(listZ.get(i4));
        }
        throw new SSLPeerUnverifiedException(sb.toString());
    }

    List<g> z(String str) {
        List<g> listEmptyList = Collections.emptyList();
        for (g gVar : this.g) {
            if (gVar.z(str)) {
                if (listEmptyList.isEmpty()) {
                    listEmptyList = new ArrayList<>();
                }
                listEmptyList.add(gVar);
            }
        }
        return listEmptyList;
    }

    e z(com.bytedance.sdk.component.dl.g.z.fo.dl dlVar) {
        return com.bytedance.sdk.component.dl.g.z.dl.z(this.dl, dlVar) ? this : new e(this.g, dlVar);
    }

    public static String z(Certificate certificate) {
        if (!(certificate instanceof X509Certificate)) {
            throw new IllegalArgumentException("Certificate pinning requires X509 certificates");
        }
        return "sha256/" + g((X509Certificate) certificate).g();
    }

    static com.bytedance.sdk.component.dl.z.m z(X509Certificate x509Certificate) {
        return com.bytedance.sdk.component.dl.z.m.z(x509Certificate.getPublicKey().getEncoded()).dl();
    }

    static com.bytedance.sdk.component.dl.z.m g(X509Certificate x509Certificate) {
        return com.bytedance.sdk.component.dl.z.m.z(x509Certificate.getPublicKey().getEncoded()).a();
    }

    static final class g {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final com.bytedance.sdk.component.dl.z.m f627a;
        final String dl;
        final String g;
        final String z;

        boolean z(String str) {
            if (this.z.startsWith("*.")) {
                int iIndexOf = str.indexOf(46);
                if ((str.length() - iIndexOf) - 1 != this.g.length()) {
                    return false;
                }
                String str2 = this.g;
                return str.regionMatches(false, iIndexOf + 1, str2, 0, str2.length());
            }
            return str.equals(this.g);
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof g)) {
                return false;
            }
            g gVar = (g) obj;
            return this.z.equals(gVar.z) && this.dl.equals(gVar.dl) && this.f627a.equals(gVar.f627a);
        }

        public int hashCode() {
            return ((((this.z.hashCode() + 527) * 31) + this.dl.hashCode()) * 31) + this.f627a.hashCode();
        }

        public String toString() {
            return this.dl + this.f627a.g();
        }
    }

    public static final class z {
        private final List<g> z = new ArrayList();

        public e z() {
            return new e(new LinkedHashSet(this.z), null);
        }
    }
}
