package com.mibi.sdk.common.exception;

import com.mibi.sdk.common.R;

/* JADX INFO: loaded from: classes13.dex */
public class NetworkException extends PaymentException {
    public NetworkException() {
    }

    @Override // com.mibi.sdk.common.exception.PaymentException
    public int getErrorCode() {
        return 3;
    }

    @Override // com.mibi.sdk.common.exception.PaymentException
    public int getErrorSummaryRes() {
        return R.string.mibi_error_network_summary;
    }

    @Override // com.mibi.sdk.common.exception.PaymentException
    public String getIdentifier() {
        return "NT";
    }

    public NetworkException(Throwable th) {
        super(th);
    }

    public NetworkException(String str) {
        super(str);
    }

    public NetworkException(String str, Throwable th) {
        super(str, th);
    }
}
