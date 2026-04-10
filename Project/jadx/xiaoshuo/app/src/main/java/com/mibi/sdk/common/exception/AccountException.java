package com.mibi.sdk.common.exception;

import com.mibi.sdk.common.R;

/* JADX INFO: loaded from: classes13.dex */
public class AccountException extends PaymentException {
    public AccountException() {
    }

    @Override // com.mibi.sdk.common.exception.PaymentException
    public int getErrorCode() {
        return 5;
    }

    @Override // com.mibi.sdk.common.exception.PaymentException
    public int getErrorSummaryRes() {
        return R.string.mibi_error_auth_summary;
    }

    @Override // com.mibi.sdk.common.exception.PaymentException
    public String getIdentifier() {
        return "AT";
    }

    public AccountException(Throwable th) {
        super(th);
    }

    public AccountException(String str) {
        super(str);
    }
}
