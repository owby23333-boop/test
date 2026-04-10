package com.bytedance.sdk.component.dl.g.z.fo;

import java.security.cert.X509Certificate;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;
import javax.security.auth.x500.X500Principal;

/* JADX INFO: loaded from: classes2.dex */
public final class g implements m {
    private final Map<X500Principal, Set<X509Certificate>> z = new LinkedHashMap();

    public g(X509Certificate... x509CertificateArr) {
        for (X509Certificate x509Certificate : x509CertificateArr) {
            X500Principal subjectX500Principal = x509Certificate.getSubjectX500Principal();
            Set<X509Certificate> linkedHashSet = this.z.get(subjectX500Principal);
            if (linkedHashSet == null) {
                linkedHashSet = new LinkedHashSet<>(1);
                this.z.put(subjectX500Principal, linkedHashSet);
            }
            linkedHashSet.add(x509Certificate);
        }
    }

    @Override // com.bytedance.sdk.component.dl.g.z.fo.m
    public X509Certificate z(X509Certificate x509Certificate) {
        Set<X509Certificate> set = this.z.get(x509Certificate.getIssuerX500Principal());
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
        return (obj instanceof g) && ((g) obj).z.equals(this.z);
    }

    public int hashCode() {
        return this.z.hashCode();
    }
}
