package com.xiaomi.accountsdk.account.data;

/* JADX INFO: loaded from: classes5.dex */
public class MiCloudAuthInfo {
    private static final String TAG = "MiCloudAuthInfo";
    private String mAccessToken;
    private String mCode;
    private int mExpires;
    private String mMacAlgorithm;
    private String mMacKey;
    private String mScope;
    private String mTokenType;

    public String getAccessToken() {
        return this.mAccessToken;
    }

    public String getCode() {
        return this.mCode;
    }

    public int getExpires() {
        return this.mExpires;
    }

    public String getMacAlgorithm() {
        return this.mMacAlgorithm;
    }

    public String getMacKey() {
        return this.mMacKey;
    }

    public String getScope() {
        return this.mScope;
    }

    public String getTokenType() {
        return this.mTokenType;
    }

    public void setAccessToken(String str) {
        this.mAccessToken = str;
    }

    public void setCode(String str) {
        this.mCode = str;
    }

    public void setExpires(int i) {
        this.mExpires = i;
    }

    public void setMacAlgorithm(String str) {
        this.mMacAlgorithm = str;
    }

    public void setMacKey(String str) {
        this.mMacKey = str;
    }

    public void setScope(String str) {
        this.mScope = str;
    }

    public void setTokenType(String str) {
        this.mTokenType = str;
    }
}
