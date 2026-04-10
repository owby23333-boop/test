package com.dangdang.zframework.network.command;

import com.dangdang.zframework.network.command.OnCommandListener;

/* JADX INFO: loaded from: classes10.dex */
public class Response<T> {
    private boolean mIsSuccess;
    private T mObj;
    private OnCommandListener.NetResult mResult;

    public Response() {
        this.mIsSuccess = false;
    }

    public T getData() {
        return this.mObj;
    }

    public OnCommandListener.NetResult getResult() {
        return this.mResult;
    }

    public boolean isSuccess() {
        return this.mIsSuccess;
    }

    public void setData(T t) {
        this.mObj = t;
    }

    public void setResult(OnCommandListener.NetResult netResult) {
        this.mResult = netResult;
    }

    public void setSuccess(boolean z) {
        this.mIsSuccess = z;
    }

    public Response(boolean z, OnCommandListener.NetResult netResult, T t) {
        this.mIsSuccess = z;
        this.mResult = netResult;
        this.mObj = t;
    }
}
