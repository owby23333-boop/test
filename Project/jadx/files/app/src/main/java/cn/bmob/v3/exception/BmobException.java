package cn.bmob.v3.exception;

import cn.bmob.v3.helper.ErrorCode;

/* JADX INFO: loaded from: classes.dex */
public class BmobException extends Exception {
    private static final long serialVersionUID = 1;
    private int exceptionCode;

    public BmobException() {
    }

    public int getErrorCode() {
        return this.exceptionCode;
    }

    @Override // java.lang.Throwable
    public String toString() {
        return "errorCode:" + this.exceptionCode + ",errorMsg:" + getMessage();
    }

    public BmobException(String str) {
        super(str);
    }

    public BmobException(String str, Throwable th) {
        super(str, th);
    }

    public BmobException(Throwable th) {
        super(th);
        this.exceptionCode = ErrorCode.E9015;
    }

    public BmobException(int i2) {
        this.exceptionCode = i2;
    }

    public BmobException(int i2, String str) {
        super(str);
        this.exceptionCode = i2;
    }

    public BmobException(int i2, String str, Throwable th) {
        super(str, th);
        this.exceptionCode = i2;
    }

    public BmobException(int i2, Throwable th) {
        super(th);
        this.exceptionCode = i2;
    }
}
