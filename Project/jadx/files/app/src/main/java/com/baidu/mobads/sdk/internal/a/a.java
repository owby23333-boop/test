package com.baidu.mobads.sdk.internal.a;

import androidx.annotation.NonNull;
import com.baidu.mobads.sdk.api.IAdInterListener;
import com.baidu.mobads.sdk.api.IOAdEvent;

/* JADX INFO: loaded from: classes2.dex */
public interface a extends IOAdEvent {
    @NonNull
    IAdInterListener getDelegator();

    Object handleEvent(String str, String str2, Object[] objArr);
}
