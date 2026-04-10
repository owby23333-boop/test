package com.bytedance.sdk.component.m;

import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public interface ls<T> {
    String getCacheKey();

    int getFileSize();

    Map<String, String> getHeaders();

    int getHeight();

    gz getHttpTime();

    T getOriginResult();

    T getResult();

    String getUrl();

    int getWidth();

    boolean isGif();

    boolean isLocal();

    void setResult(T t);
}
