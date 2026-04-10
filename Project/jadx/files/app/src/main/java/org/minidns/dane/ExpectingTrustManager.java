package org.minidns.dane;

import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import javax.net.ssl.X509TrustManager;

/* JADX INFO: loaded from: classes3.dex */
public class ExpectingTrustManager implements X509TrustManager {
    private CertificateException exception;
    private final X509TrustManager trustManager;

    public ExpectingTrustManager(X509TrustManager x509TrustManager) {
        this.trustManager = x509TrustManager == null ? a.a() : x509TrustManager;
    }

    @Override // javax.net.ssl.X509TrustManager
    public void checkClientTrusted(X509Certificate[] x509CertificateArr, String str) throws CertificateException {
        try {
            this.trustManager.checkClientTrusted(x509CertificateArr, str);
        } catch (CertificateException e2) {
            this.exception = e2;
        }
    }

    @Override // javax.net.ssl.X509TrustManager
    public void checkServerTrusted(X509Certificate[] x509CertificateArr, String str) throws CertificateException {
        try {
            this.trustManager.checkServerTrusted(x509CertificateArr, str);
        } catch (CertificateException e2) {
            this.exception = e2;
        }
    }

    @Override // javax.net.ssl.X509TrustManager
    public X509Certificate[] getAcceptedIssuers() {
        return this.trustManager.getAcceptedIssuers();
    }

    public CertificateException getException() {
        CertificateException certificateException = this.exception;
        this.exception = null;
        return certificateException;
    }

    public boolean hasException() {
        return this.exception != null;
    }
}
