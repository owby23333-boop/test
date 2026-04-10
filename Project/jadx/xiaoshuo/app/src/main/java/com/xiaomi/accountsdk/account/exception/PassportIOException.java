package com.xiaomi.accountsdk.account.exception;

import com.xiaomi.ad.common.util.SignatureUtils;
import java.io.IOException;

/* JADX INFO: loaded from: classes5.dex */
public class PassportIOException extends IOException {
    public boolean isStsUrlRequestError;
    public final int responseCode;
    public String serviceId;

    public PassportIOException(IOException iOException) {
        super(iOException);
        this.isStsUrlRequestError = false;
        this.responseCode = -1;
    }

    public void stsUrlRequestError(String str) {
        this.serviceId = str;
        this.isStsUrlRequestError = true;
    }

    @Override // java.lang.Throwable
    public String toString() {
        String str;
        StringBuilder sb = new StringBuilder();
        sb.append("response code: ");
        sb.append(this.responseCode);
        sb.append(SignatureUtils.DELIMITER);
        if (this.isStsUrlRequestError) {
            str = this.serviceId + " sts url request error \n";
        } else {
            str = "";
        }
        sb.append(str);
        return sb.toString() + super.toString();
    }

    public PassportIOException(int i, String str) {
        super(str);
        this.isStsUrlRequestError = false;
        this.responseCode = i;
    }
}
