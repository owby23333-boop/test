package com.mibi.sdk.common.exception;

import com.mibi.sdk.common.R;

/* JADX INFO: loaded from: classes13.dex */
public class ServiceTokenExpiredException extends PaymentException {
    @Override // com.mibi.sdk.common.exception.PaymentException
    public int getErrorCode() {
        return 6;
    }

    @Override // com.mibi.sdk.common.exception.PaymentException
    public int getErrorSummaryRes() {
        return R.string.mibi_error_server_summary;
    }

    @Override // com.mibi.sdk.common.exception.PaymentException
    public String getIdentifier() {
        return "ST";
    }
}
