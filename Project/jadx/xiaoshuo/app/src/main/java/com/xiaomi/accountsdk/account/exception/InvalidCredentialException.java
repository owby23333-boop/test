package com.xiaomi.accountsdk.account.exception;

import com.xiaomi.accountsdk.account.ServerErrorCode;
import com.xiaomi.accountsdk.account.data.MetaLoginData;

/* JADX INFO: loaded from: classes5.dex */
public class InvalidCredentialException extends AccountException {
    private static final long serialVersionUID = 1;
    public String captchaUrl;
    public final boolean hasPwd;
    public MetaLoginData metaLoginData;

    public InvalidCredentialException(boolean z) {
        super(z ? 70016 : ServerErrorCode.ERROR_NO_PASSWORD, z ? "password error or passToken invalid" : "no password");
        this.hasPwd = z;
    }

    public InvalidCredentialException captchaUrl(String str) {
        this.captchaUrl = str;
        return this;
    }

    public String getCaptchaUrl() {
        return this.captchaUrl;
    }

    public boolean getHasPwd() {
        return this.hasPwd;
    }

    public MetaLoginData getMetaLoginData() {
        return this.metaLoginData;
    }

    public InvalidCredentialException metaLoginData(MetaLoginData metaLoginData) {
        this.metaLoginData = metaLoginData;
        return this;
    }

    public InvalidCredentialException(int i, String str, boolean z) {
        super(i, str);
        this.hasPwd = z;
    }
}
