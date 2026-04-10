package com.market.sdk;

/* JADX INFO: loaded from: classes7.dex */
public enum ServerType {
    PRODUCT("https://api.developer.xiaomi.com/autoupdate/");

    private String baseUrl;

    ServerType(String str) {
        this.baseUrl = str;
    }

    public String getBaseUrl() {
        return this.baseUrl;
    }
}
