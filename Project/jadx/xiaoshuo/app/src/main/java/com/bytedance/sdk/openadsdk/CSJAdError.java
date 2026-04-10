package com.bytedance.sdk.openadsdk;

/* JADX INFO: loaded from: classes10.dex */
public class CSJAdError {
    private String bf;
    private int e;

    public CSJAdError(int i, String str) {
        this.e = i;
        this.bf = str == null ? "" : str;
    }

    public int getCode() {
        return this.e;
    }

    public String getMsg() {
        return this.bf;
    }
}
