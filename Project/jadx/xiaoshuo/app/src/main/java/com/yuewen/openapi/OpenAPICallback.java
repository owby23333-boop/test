package com.yuewen.openapi;

/* JADX INFO: loaded from: classes8.dex */
public interface OpenAPICallback<T> {
    void onFail(Exception exc);

    void onResponse(T t);
}
