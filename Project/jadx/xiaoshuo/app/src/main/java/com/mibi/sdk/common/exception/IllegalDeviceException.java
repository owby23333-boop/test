package com.mibi.sdk.common.exception;

import com.market.sdk.utils.Region;
import com.mibi.sdk.common.R;

/* JADX INFO: loaded from: classes13.dex */
public class IllegalDeviceException extends PaymentException {
    public IllegalDeviceException() {
    }

    @Override // com.mibi.sdk.common.exception.PaymentException
    public int getErrorCode() {
        return 5;
    }

    @Override // com.mibi.sdk.common.exception.PaymentException
    public int getErrorSummaryRes() {
        return R.string.mibi_error_invalid_device;
    }

    @Override // com.mibi.sdk.common.exception.PaymentException
    public String getIdentifier() {
        return Region.ID;
    }

    public IllegalDeviceException(Throwable th) {
        super(th);
    }

    public IllegalDeviceException(String str) {
        super(str);
    }
}
