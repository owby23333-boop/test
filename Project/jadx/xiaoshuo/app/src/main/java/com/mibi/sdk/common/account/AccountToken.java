package com.mibi.sdk.common.account;

/* JADX INFO: loaded from: classes13.dex */
public final class AccountToken {
    private final String mAuthToken;
    private final String mSecurity;
    private final String mServiceToken;
    private final String mUserId;

    public AccountToken(String str, String str2, String str3, String str4) {
        this.mUserId = str;
        this.mAuthToken = str2;
        this.mServiceToken = str3;
        this.mSecurity = str4;
    }

    public String getAuthToken() {
        return this.mAuthToken;
    }

    public String getSecurity() {
        return this.mSecurity;
    }

    public String getServiceToken() {
        return this.mServiceToken;
    }

    public String getUserId() {
        return this.mUserId;
    }
}
