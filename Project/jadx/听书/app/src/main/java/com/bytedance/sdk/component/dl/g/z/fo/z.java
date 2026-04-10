package com.bytedance.sdk.component.dl.g.z.fo;

import java.security.GeneralSecurityException;
import java.security.cert.Certificate;
import java.security.cert.X509Certificate;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.net.ssl.SSLPeerUnverifiedException;

/* JADX INFO: loaded from: classes2.dex */
public final class z extends dl {
    private final m z;

    public z(m mVar) {
        this.z = mVar;
    }

    @Override // com.bytedance.sdk.component.dl.g.z.fo.dl
    public List<Certificate> z(List<Certificate> list, String str) throws SSLPeerUnverifiedException {
        ArrayDeque arrayDeque = new ArrayDeque(list);
        ArrayList arrayList = new ArrayList();
        arrayList.add(arrayDeque.removeFirst());
        boolean z = false;
        for (int i = 0; i < 9; i++) {
            X509Certificate x509Certificate = (X509Certificate) arrayList.get(arrayList.size() - 1);
            X509Certificate x509CertificateZ = this.z.z(x509Certificate);
            if (x509CertificateZ != null) {
                if (arrayList.size() > 1 || !x509Certificate.equals(x509CertificateZ)) {
                    arrayList.add(x509CertificateZ);
                }
                if (z(x509CertificateZ, x509CertificateZ)) {
                    return arrayList;
                }
                z = true;
            } else {
                Iterator it = arrayDeque.iterator();
                while (it.hasNext()) {
                    X509Certificate x509Certificate2 = (X509Certificate) it.next();
                    if (z(x509Certificate, x509Certificate2)) {
                        it.remove();
                        arrayList.add(x509Certificate2);
                    }
                }
                if (z) {
                    return arrayList;
                }
                throw new SSLPeerUnverifiedException("Failed to find a trusted cert that signed ".concat(String.valueOf(x509Certificate)));
            }
        }
        throw new SSLPeerUnverifiedException("Certificate chain too long: ".concat(String.valueOf(arrayList)));
    }

    private boolean z(X509Certificate x509Certificate, X509Certificate x509Certificate2) {
        if (!x509Certificate.getIssuerDN().equals(x509Certificate2.getSubjectDN())) {
            return false;
        }
        try {
            x509Certificate.verify(x509Certificate2.getPublicKey());
            return true;
        } catch (GeneralSecurityException unused) {
            return false;
        }
    }

    public int hashCode() {
        return this.z.hashCode();
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        return (obj instanceof z) && ((z) obj).z.equals(this.z);
    }
}
