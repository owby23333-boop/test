package com.bytedance.android.live.base.api.callback;

/* JADX INFO: loaded from: classes2.dex */
public interface CommonCallback<T, D> {
    void onFail(D d);

    void onSuccess(T t);
}
