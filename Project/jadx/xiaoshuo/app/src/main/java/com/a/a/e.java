package com.a.a;

import java.security.cert.X509Certificate;

/* JADX INFO: loaded from: classes.dex */
final class e extends f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private byte[] f1616a;

    public e(X509Certificate x509Certificate, byte[] bArr) {
        super(x509Certificate);
        this.f1616a = bArr;
    }

    @Override // com.a.a.f, java.security.cert.Certificate
    public final byte[] getEncoded() {
        return this.f1616a;
    }
}
