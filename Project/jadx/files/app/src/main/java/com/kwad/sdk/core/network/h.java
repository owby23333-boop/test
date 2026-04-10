package com.kwad.sdk.core.network;

import androidx.annotation.NonNull;
import androidx.annotation.WorkerThread;
import com.kwad.sdk.core.network.BaseResultData;
import com.kwad.sdk.core.network.g;

/* JADX INFO: loaded from: classes3.dex */
public interface h<R extends g, T extends BaseResultData> {
    @WorkerThread
    void onError(@NonNull R r2, int i2, String str);

    @WorkerThread
    void onStartRequest(@NonNull R r2);

    @WorkerThread
    void onSuccess(@NonNull R r2, @NonNull T t2);
}
