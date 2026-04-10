package com.dangdang.execption;

/* JADX INFO: loaded from: classes10.dex */
public class DDException extends Exception {
    private static final long serialVersionUID = 1;
    private int errorCode;
    private int responseCode;

    public DDException(int i) {
        super("  [errorCode  =  " + i + "]");
        this.errorCode = i;
    }

    public int getErrorCode() {
        return this.errorCode;
    }

    public int getResponseCode() {
        return this.responseCode;
    }

    public void setErrorCode(int i) {
        this.errorCode = i;
    }

    public void setResponseCode(int i) {
        this.responseCode = i;
    }

    public DDException(int i, int i2) {
        super("  [errorCode  =  " + i2 + " , responseCode= " + i + "]");
        this.responseCode = i;
        this.errorCode = i2;
    }

    public DDException() {
    }

    public DDException(String str, Throwable th) {
        super(str, th);
    }

    public DDException(String str) {
        super(str);
    }

    public DDException(Throwable th) {
        super(th);
    }
}
