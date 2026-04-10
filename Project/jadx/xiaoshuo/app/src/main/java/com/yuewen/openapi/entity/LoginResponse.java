package com.yuewen.openapi.entity;

/* JADX INFO: loaded from: classes8.dex */
public class LoginResponse {
    public String guid;
    public String token;

    public String getGuid() {
        return this.guid;
    }

    public String getToken() {
        return this.token;
    }

    public void setGuid(String str) {
        this.guid = str;
    }

    public void setToken(String str) {
        this.token = str;
    }

    public String toString() {
        return "LoginResponse{guid=" + this.guid + ", token='" + this.token + "'}";
    }
}
