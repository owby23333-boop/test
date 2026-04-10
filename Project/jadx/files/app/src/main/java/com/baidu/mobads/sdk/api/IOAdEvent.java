package com.baidu.mobads.sdk.api;

import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public interface IOAdEvent {
    int getCode();

    Map<String, Object> getData();

    String getMessage();

    Object getTarget();

    String getType();

    void setTarget(Object obj);
}
