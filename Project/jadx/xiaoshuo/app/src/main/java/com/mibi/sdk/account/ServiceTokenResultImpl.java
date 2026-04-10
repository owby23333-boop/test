package com.mibi.sdk.account;

import android.content.Intent;
import com.mibi.sdk.common.account.IServiceTokenResult;
import com.xiaomi.passport.servicetoken.ServiceTokenResult;

/* JADX INFO: loaded from: classes10.dex */
public class ServiceTokenResultImpl implements IServiceTokenResult {
    private ServiceTokenResult mServiceTokenResult;

    public ServiceTokenResultImpl(ServiceTokenResult serviceTokenResult) {
        this.mServiceTokenResult = serviceTokenResult;
    }

    @Override // com.mibi.sdk.common.account.IServiceTokenResult
    public String getCUserId() {
        return this.mServiceTokenResult.cUserId;
    }

    @Override // com.mibi.sdk.common.account.IServiceTokenResult
    public String getErrorCodeName() {
        return this.mServiceTokenResult.errorCode.name();
    }

    @Override // com.mibi.sdk.common.account.IServiceTokenResult
    public String getErrorMessage() {
        return this.mServiceTokenResult.errorMessage;
    }

    @Override // com.mibi.sdk.common.account.IServiceTokenResult
    public String getErrorStackTrace() {
        return this.mServiceTokenResult.errorStackTrace;
    }

    @Override // com.mibi.sdk.common.account.IServiceTokenResult
    public Intent getIntent() {
        return this.mServiceTokenResult.intent;
    }

    @Override // com.mibi.sdk.common.account.IServiceTokenResult
    public String getPh() {
        return this.mServiceTokenResult.ph;
    }

    @Override // com.mibi.sdk.common.account.IServiceTokenResult
    public String getSecurity() {
        return this.mServiceTokenResult.security;
    }

    @Override // com.mibi.sdk.common.account.IServiceTokenResult
    public String getServiceToken() {
        return this.mServiceTokenResult.serviceToken;
    }

    @Override // com.mibi.sdk.common.account.IServiceTokenResult
    public String getSid() {
        return this.mServiceTokenResult.sid;
    }

    @Override // com.mibi.sdk.common.account.IServiceTokenResult
    public String getSlh() {
        return this.mServiceTokenResult.slh;
    }

    @Override // com.mibi.sdk.common.account.IServiceTokenResult
    public String getUserId() {
        return this.mServiceTokenResult.userId;
    }

    @Override // com.mibi.sdk.common.account.IServiceTokenResult
    public boolean isPeeked() {
        return this.mServiceTokenResult.peeked;
    }
}
