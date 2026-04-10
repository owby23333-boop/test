package com.mibi.sdk.common.exception;

import com.mibi.sdk.common.R;

/* JADX INFO: loaded from: classes13.dex */
public class CertificateDateNotValidException extends NetworkException {
    private Type mType;

    public enum Type {
        NOT_YET_VALID,
        EXPIRED
    }

    public CertificateDateNotValidException(Type type, Throwable th) {
        super(th);
        this.mType = type;
    }

    @Override // com.mibi.sdk.common.exception.NetworkException, com.mibi.sdk.common.exception.PaymentException
    public int getErrorCode() {
        return 3;
    }

    @Override // com.mibi.sdk.common.exception.NetworkException, com.mibi.sdk.common.exception.PaymentException
    public int getErrorSummaryRes() {
        return R.string.mibi_error_cert_date_summary;
    }

    @Override // com.mibi.sdk.common.exception.NetworkException, com.mibi.sdk.common.exception.PaymentException
    public String getIdentifier() {
        return "CT";
    }

    public Type getType() {
        return this.mType;
    }
}
