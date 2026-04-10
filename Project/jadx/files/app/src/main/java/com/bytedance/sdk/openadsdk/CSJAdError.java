package com.bytedance.sdk.openadsdk;

/* JADX INFO: loaded from: classes2.dex */
public class CSJAdError {
    private int mb;
    private String ox;

    public CSJAdError(int i2, String str) {
        this.mb = i2;
        this.ox = str;
    }

    public int getCode() {
        return this.mb;
    }

    public String getMsg() {
        return this.ox;
    }
}
