package com.mipay.imageloadhelper;

/* JADX INFO: loaded from: classes17.dex */
class DownLoadException extends Exception {
    private String mDescription;
    private int mErrorCode;

    public DownLoadException(int i, String str) {
        super(str);
        this.mErrorCode = i;
        this.mDescription = str;
    }

    public String getDescription() {
        return this.mDescription;
    }

    public int getErrorCode() {
        return this.mErrorCode;
    }
}
