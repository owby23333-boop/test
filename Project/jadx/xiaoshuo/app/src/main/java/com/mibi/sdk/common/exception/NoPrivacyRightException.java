package com.mibi.sdk.common.exception;

import com.mibi.sdk.common.R;

/* JADX INFO: loaded from: classes13.dex */
public class NoPrivacyRightException extends PaymentException {
    public NoPrivacyRightException(Throwable th) {
        super(th);
    }

    @Override // com.mibi.sdk.common.exception.PaymentException
    public int getErrorCode() {
        return 18;
    }

    @Override // com.mibi.sdk.common.exception.PaymentException
    public int getErrorSummaryRes() {
        return R.string.mibi_error_privacy_summary;
    }

    @Override // com.mibi.sdk.common.exception.PaymentException
    public String getIdentifier() {
        return "NP";
    }

    public NoPrivacyRightException(String str) {
        super(str);
    }

    public NoPrivacyRightException(String str, Throwable th) {
        super(str, th);
    }
}
