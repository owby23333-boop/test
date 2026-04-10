package com.alibaba.sdk.android.httpdns;

import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
class g {
    private int b;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private String f2196e;

    g(int i2, String str) {
        this.b = i2;
        this.f2196e = new JSONObject(str).getString("code");
    }

    public String b() {
        return this.f2196e;
    }

    public int getErrorCode() {
        return this.b;
    }
}
