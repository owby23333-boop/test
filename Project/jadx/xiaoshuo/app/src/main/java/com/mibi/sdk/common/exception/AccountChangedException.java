package com.mibi.sdk.common.exception;

import com.mibi.sdk.common.R;

/* JADX INFO: loaded from: classes13.dex */
public class AccountChangedException extends AccountException {
    private int mErrorCode;
    private String mErrorSummary;

    public AccountChangedException(int i, String str) {
        this.mErrorCode = i;
        this.mErrorSummary = str;
    }

    @Override // com.mibi.sdk.common.exception.AccountException, com.mibi.sdk.common.exception.PaymentException
    public int getErrorCode() {
        return this.mErrorCode;
    }

    public String getErrorSummary() {
        return this.mErrorSummary;
    }

    @Override // com.mibi.sdk.common.exception.AccountException, com.mibi.sdk.common.exception.PaymentException
    public int getErrorSummaryRes() {
        return R.string.mibi_error_account_changed_summary;
    }

    @Override // com.mibi.sdk.common.exception.AccountException, com.mibi.sdk.common.exception.PaymentException
    public String getIdentifier() {
        return "AC";
    }
}
