package com.mibi.sdk.rx;

/* JADX INFO: loaded from: classes15.dex */
public class Emitter<Result> {
    private Result mSuccessResult;
    private Throwable mThrowable = new Throwable();
    private volatile boolean mIsSuccess = false;

    public Result getResult() {
        return this.mSuccessResult;
    }

    public Throwable getThrowable() {
        return this.mThrowable;
    }

    public boolean isSuccess() {
        return this.mIsSuccess;
    }

    public void onError(Throwable th) {
        this.mThrowable = th;
    }

    public void onSuccess(Result result) {
        this.mSuccessResult = result;
        this.mIsSuccess = true;
    }
}
