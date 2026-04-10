package com.bytedance.sdk.component.d.bf.e.zk;

import java.security.cert.X509Certificate;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;
import javax.security.auth.x500.X500Principal;

/* JADX INFO: loaded from: classes.dex */
public final class bf implements vn {
    private final Map<X500Principal, Set<X509Certificate>> e = new LinkedHashMap();

    public bf(X509Certificate... x509CertificateArr) {
        for (X509Certificate x509Certificate : x509CertificateArr) {
            X500Principal subjectX500Principal = x509Certificate.getSubjectX500Principal();
            Set<X509Certificate> linkedHashSet = this.e.get(subjectX500Principal);
            if (linkedHashSet == null) {
                linkedHashSet = new LinkedHashSet<>(1);
                this.e.put(subjectX500Principal, linkedHashSet);
            }
            linkedHashSet.add(x509Certificate);
        }
    }

    @Override // com.bytedance.sdk.component.d.bf.e.zk.vn
    public X509Certificate e(X509Certificate x509Certificate) {
        Set<X509Certificate> set = this.e.get(x509Certificate.getIssuerX500Principal());
        if (set == null) {
            return null;
        }
        for (X509Certificate x509Certificate2 : set) {
            try {
                x509Certificate.verify(x509Certificate2.getPublicKey());
                return x509Certificate2;
            } catch (Exception unused) {
            }
        }
        return null;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        return (obj instanceof bf) && ((bf) obj).e.equals(this.e);
    }

    public int hashCode() {
        return this.e.hashCode();
    }
}
