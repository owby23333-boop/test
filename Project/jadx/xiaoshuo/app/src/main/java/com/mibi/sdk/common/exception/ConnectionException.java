package com.mibi.sdk.common.exception;

import com.mibi.sdk.common.exception.CertificateDateNotValidException;
import java.io.IOException;
import java.net.URL;
import java.security.cert.CertificateExpiredException;
import java.security.cert.CertificateNotYetValidException;

/* JADX INFO: loaded from: classes13.dex */
public class ConnectionException extends NetworkException {
    private URL mUrl;

    public ConnectionException(Throwable th) {
        super(parseCause(null, th));
    }

    private static Throwable parseCause(URL url, Throwable th) {
        if (th instanceof IOException) {
            for (Throwable cause = th; cause != null; cause = cause.getCause()) {
                if (cause instanceof CertificateNotYetValidException) {
                    return new CertificateDateNotValidException(CertificateDateNotValidException.Type.NOT_YET_VALID, th);
                }
                if (cause instanceof CertificateExpiredException) {
                    return new CertificateDateNotValidException(CertificateDateNotValidException.Type.EXPIRED, th);
                }
            }
        }
        return th;
    }

    @Override // com.mibi.sdk.common.exception.NetworkException, com.mibi.sdk.common.exception.PaymentException
    public String getIdentifier() {
        return "CN";
    }

    public URL getUrl() {
        return this.mUrl;
    }

    public ConnectionException(URL url, Throwable th) {
        super(parseCause(url, th));
        this.mUrl = url;
    }

    public ConnectionException(URL url, String str, Throwable th) {
        super(str, parseCause(url, th));
        this.mUrl = url;
    }
}
