package org.android.spdy;

/* JADX INFO: loaded from: classes3.dex */
public interface SslCertcb {
    void getPerformance(SpdySession spdySession, SslPermData sslPermData);

    SslPublickey getPublicKey(SpdySession spdySession);

    int putCertificate(SpdySession spdySession, byte[] bArr, int i2);
}
