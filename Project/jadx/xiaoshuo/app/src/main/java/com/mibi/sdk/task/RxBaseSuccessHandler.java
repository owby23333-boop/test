package com.mibi.sdk.task;

import com.mibi.sdk.rx.Action;

/* JADX INFO: loaded from: classes16.dex */
public abstract class RxBaseSuccessHandler<R> implements Action<R> {
    @Override // com.mibi.sdk.rx.Action
    public void call(R r) {
        try {
            handleSuccess(r);
        } catch (Exception e) {
            e.printStackTrace();
            throw new IllegalStateException("exception occurs in onNext", e);
        }
    }

    public abstract void handleSuccess(R r);
}
