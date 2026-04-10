package com.taobao.aranger.exception;

/* JADX INFO: loaded from: classes3.dex */
public class IPCException extends Exception {
    private final int mErrorCode;

    public IPCException(int i2, String str) {
        super(str);
        this.mErrorCode = i2;
    }

    public int getErrorCode() {
        return this.mErrorCode;
    }

    public IPCException(int i2, Throwable th) {
        super(th.getMessage(), th);
        this.mErrorCode = i2;
    }
}
