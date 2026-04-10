package com.mibi.sdk.common.exception;

import com.mibi.sdk.common.R;

/* JADX INFO: loaded from: classes13.dex */
public class ServerErrorCodeException extends PaymentException {
    private Object mResult;
    private int mServerErrorCode;
    private String mServerErrorDesc;

    public ServerErrorCodeException(int i, String str, Object obj) {
        this.mServerErrorCode = i;
        this.mServerErrorDesc = str;
        this.mResult = obj;
    }

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
        return "SC";
    }

    public Object getResult() {
        return this.mResult;
    }

    public int getServerErrorCode() {
        return this.mServerErrorCode;
    }

    public String getServerErrorDesc() {
        return this.mServerErrorDesc;
    }
}
