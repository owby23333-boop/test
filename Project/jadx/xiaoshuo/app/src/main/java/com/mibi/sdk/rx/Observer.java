package com.mibi.sdk.rx;

/* JADX INFO: loaded from: classes15.dex */
public interface Observer<Result> {
    void onError(Throwable th);

    void onSuccess(Result result);
}
