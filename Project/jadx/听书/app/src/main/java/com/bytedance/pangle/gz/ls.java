package com.bytedance.pangle.gz;

import java.security.cert.CertificateEncodingException;
import java.security.cert.X509Certificate;
import java.util.Arrays;

/* JADX INFO: loaded from: classes2.dex */
class ls extends fv {
    private int g;
    private final byte[] z;

    ls(X509Certificate x509Certificate, byte[] bArr) {
        super(x509Certificate);
        this.g = -1;
        this.z = bArr;
    }

    @Override // com.bytedance.pangle.gz.fv, java.security.cert.Certificate
    public byte[] getEncoded() throws CertificateEncodingException {
        return this.z;
    }

    @Override // java.security.cert.Certificate
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ls)) {
            return false;
        }
        try {
            return Arrays.equals(getEncoded(), ((ls) obj).getEncoded());
        } catch (CertificateEncodingException unused) {
            return false;
        }
    }

    @Override // java.security.cert.Certificate
    public int hashCode() {
        if (this.g == -1) {
            try {
                this.g = Arrays.hashCode(getEncoded());
            } catch (CertificateEncodingException unused) {
                this.g = 0;
            }
        }
        return this.g;
    }
}
