package com.alibaba.sdk.android.httpdns;

/* JADX INFO: loaded from: classes.dex */
public class h extends Exception {
    private int b;

    public h(int i2, String str) {
        super(str);
        this.b = i2;
    }

    public int getErrorCode() {
        return this.b;
    }
}
