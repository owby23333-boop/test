package com.mibi.sdk.model;

import android.os.Bundle;

/* JADX INFO: loaded from: classes14.dex */
public interface IBaseModel<Result> {

    public interface IResultCallback<Result> {
        void onFailed(int i, String str, Throwable th);

        void onSuccess(Result result);
    }

    void request(Bundle bundle, IResultCallback<Result> iResultCallback);
}
