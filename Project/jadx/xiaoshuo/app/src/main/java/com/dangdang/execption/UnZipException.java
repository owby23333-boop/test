package com.dangdang.execption;

/* JADX INFO: loaded from: classes10.dex */
public class UnZipException extends DDException {
    private static final long serialVersionUID = 1;

    public UnZipException(String str, Throwable th) {
        super(str, th);
    }

    public UnZipException(String str) {
        super(str);
    }

    public UnZipException(Throwable th) {
        super(th);
    }
}
