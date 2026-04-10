package com.mibi.sdk.common.exception;

/* JADX INFO: loaded from: classes13.dex */
public class NotConnectedException extends NetworkException {
    public NotConnectedException() {
    }

    @Override // com.mibi.sdk.common.exception.NetworkException, com.mibi.sdk.common.exception.PaymentException
    public String getIdentifier() {
        return "NC";
    }

    public NotConnectedException(Throwable th) {
        super(th);
    }

    public NotConnectedException(String str) {
        super(str);
    }

    public NotConnectedException(String str, Throwable th) {
        super(str, th);
    }
}
