package bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122;

import java.security.cert.Certificate;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import javax.net.ssl.SSLPeerUnverifiedException;

/* JADX INFO: loaded from: classes.dex */
public final class g {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final g f1180c = new a().a();
    private final Set<b> a;
    private final bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_case1.c b;

    public static final class a {
        private final List<b> a = new ArrayList();

        public g a() {
            return new g(new LinkedHashSet(this.a), null);
        }
    }

    static final class b {
        final String a;
        final String b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final String f1181c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.f f1182d;

        boolean a(String str) {
            if (!this.a.startsWith("*.")) {
                return str.equals(this.b);
            }
            int iIndexOf = str.indexOf(46);
            if ((str.length() - iIndexOf) - 1 == this.b.length()) {
                String str2 = this.b;
                if (str.regionMatches(false, iIndexOf + 1, str2, 0, str2.length())) {
                    return true;
                }
            }
            return false;
        }

        public boolean equals(Object obj) {
            if (obj instanceof b) {
                b bVar = (b) obj;
                if (this.a.equals(bVar.a) && this.f1181c.equals(bVar.f1181c) && this.f1182d.equals(bVar.f1182d)) {
                    return true;
                }
            }
            return false;
        }

        public int hashCode() {
            return ((((this.a.hashCode() + 527) * 31) + this.f1181c.hashCode()) * 31) + this.f1182d.hashCode();
        }

        public String toString() {
            return this.f1181c + this.f1182d.a();
        }
    }

    g(Set<b> set, bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_case1.c cVar) {
        this.a = set;
        this.b = cVar;
    }

    static bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.f a(X509Certificate x509Certificate) {
        return bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.f.a(x509Certificate.getPublicKey().getEncoded()).c();
    }

    public static String a(Certificate certificate) {
        if (!(certificate instanceof X509Certificate)) {
            throw new IllegalArgumentException("Certificate pinning requires X509 certificates");
        }
        return "sha256/" + b((X509Certificate) certificate).a();
    }

    static bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.f b(X509Certificate x509Certificate) {
        return bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.f.a(x509Certificate.getPublicKey().getEncoded()).d();
    }

    g a(bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_case1.c cVar) {
        return bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.c.a(this.b, cVar) ? this : new g(this.a, cVar);
    }

    List<b> a(String str) {
        List<b> listEmptyList = Collections.emptyList();
        for (b bVar : this.a) {
            if (bVar.a(str)) {
                if (listEmptyList.isEmpty()) {
                    listEmptyList = new ArrayList<>();
                }
                listEmptyList.add(bVar);
            }
        }
        return listEmptyList;
    }

    public void a(String str, List<Certificate> list) throws SSLPeerUnverifiedException {
        List<b> listA = a(str);
        if (listA.isEmpty()) {
            return;
        }
        bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_case1.c cVar = this.b;
        if (cVar != null) {
            list = cVar.a(list, str);
        }
        int size = list.size();
        for (int i2 = 0; i2 < size; i2++) {
            X509Certificate x509Certificate = (X509Certificate) list.get(i2);
            int size2 = listA.size();
            bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.f fVarB = null;
            bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.f fVarA = null;
            for (int i3 = 0; i3 < size2; i3++) {
                b bVar = listA.get(i3);
                if (bVar.f1181c.equals("sha256/")) {
                    if (fVarB == null) {
                        fVarB = b(x509Certificate);
                    }
                    if (bVar.f1182d.equals(fVarB)) {
                        return;
                    }
                } else {
                    if (!bVar.f1181c.equals("sha1/")) {
                        throw new AssertionError("unsupported hashAlgorithm: " + bVar.f1181c);
                    }
                    if (fVarA == null) {
                        fVarA = a(x509Certificate);
                    }
                    if (bVar.f1182d.equals(fVarA)) {
                        return;
                    }
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        sb.append("Certificate pinning failure!");
        sb.append("\n  Peer certificate chain:");
        int size3 = list.size();
        for (int i4 = 0; i4 < size3; i4++) {
            X509Certificate x509Certificate2 = (X509Certificate) list.get(i4);
            sb.append("\n    ");
            sb.append(a((Certificate) x509Certificate2));
            sb.append(": ");
            sb.append(x509Certificate2.getSubjectDN().getName());
        }
        sb.append("\n  Pinned certificates for ");
        sb.append(str);
        sb.append(":");
        int size4 = listA.size();
        for (int i5 = 0; i5 < size4; i5++) {
            b bVar2 = listA.get(i5);
            sb.append("\n    ");
            sb.append(bVar2);
        }
        throw new SSLPeerUnverifiedException(sb.toString());
    }

    public boolean equals(Object obj) {
        if (obj != this) {
            if (obj instanceof g) {
                g gVar = (g) obj;
                if (!bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.c.a(this.b, gVar.b) || !this.a.equals(gVar.a)) {
                }
            }
            return false;
        }
        return true;
    }

    public int hashCode() {
        bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_case1.c cVar = this.b;
        return ((cVar != null ? cVar.hashCode() : 0) * 31) + this.a.hashCode();
    }
}
