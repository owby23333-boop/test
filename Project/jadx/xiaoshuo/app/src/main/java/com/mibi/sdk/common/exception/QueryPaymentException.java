package com.mibi.sdk.common.exception;

import android.os.Bundle;

/* JADX INFO: loaded from: classes13.dex */
public class QueryPaymentException extends PaymentException {
    private Bundle mArguments;

    public QueryPaymentException(Bundle bundle) {
        this.mArguments = bundle;
    }

    public Bundle getArguments() {
        return this.mArguments;
    }

    @Override // com.mibi.sdk.common.exception.PaymentException
    public int getErrorCode() {
        return 0;
    }

    @Override // com.mibi.sdk.common.exception.PaymentException
    public int getErrorSummaryRes() {
        return 0;
    }

    @Override // com.mibi.sdk.common.exception.PaymentException
    public String getIdentifier() {
        return null;
    }

    public void setArguments(Bundle bundle) {
        this.mArguments = bundle;
    }
}
