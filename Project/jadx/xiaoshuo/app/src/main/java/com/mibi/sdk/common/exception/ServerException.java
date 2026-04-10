package com.mibi.sdk.common.exception;

import com.mibi.sdk.common.R;
import java.net.URL;

/* JADX INFO: loaded from: classes13.dex */
public class ServerException extends PaymentException {
    private int mResponseCode;
    private URL mUrl;

    public ServerException(Throwable th) {
        super(th);
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
        return "SR";
    }

    public int getResponseCode() {
        return this.mResponseCode;
    }

    public URL getUrl() {
        return this.mUrl;
    }

    public ServerException(int i, URL url) {
        super(Integer.toString(i));
        this.mResponseCode = i;
        this.mUrl = url;
    }
}
