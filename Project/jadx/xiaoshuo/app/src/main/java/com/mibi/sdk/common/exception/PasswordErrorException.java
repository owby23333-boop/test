package com.mibi.sdk.common.exception;

import com.mibi.sdk.common.R;

/* JADX INFO: loaded from: classes13.dex */
public class PasswordErrorException extends AccountException {
    public static final int PASS_WORD_ERROR = 3;

    public PasswordErrorException() {
    }

    @Override // com.mibi.sdk.common.exception.AccountException, com.mibi.sdk.common.exception.PaymentException
    public int getErrorCode() {
        return 3;
    }

    @Override // com.mibi.sdk.common.exception.AccountException, com.mibi.sdk.common.exception.PaymentException
    public int getErrorSummaryRes() {
        return R.string.mibi_password_error;
    }

    @Override // com.mibi.sdk.common.exception.AccountException, com.mibi.sdk.common.exception.PaymentException
    public String getIdentifier() {
        return "PW";
    }

    public PasswordErrorException(Throwable th) {
        super(th);
    }

    public PasswordErrorException(String str) {
        super(str);
    }
}
