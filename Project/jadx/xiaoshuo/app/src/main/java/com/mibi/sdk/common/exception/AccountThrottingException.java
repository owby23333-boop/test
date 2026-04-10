package com.mibi.sdk.common.exception;

import com.mibi.sdk.common.R;

/* JADX INFO: loaded from: classes13.dex */
public class AccountThrottingException extends AccountException {
    @Override // com.mibi.sdk.common.exception.AccountException, com.mibi.sdk.common.exception.PaymentException
    public int getErrorCode() {
        return 15;
    }

    @Override // com.mibi.sdk.common.exception.AccountException, com.mibi.sdk.common.exception.PaymentException
    public int getErrorSummaryRes() {
        return R.string.mibi_error_account_throtting;
    }
}
