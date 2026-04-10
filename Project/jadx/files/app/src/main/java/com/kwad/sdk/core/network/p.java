package com.kwad.sdk.core.network;

import androidx.annotation.NonNull;
import com.kwad.sdk.core.network.BaseResultData;
import com.kwad.sdk.core.network.g;

/* JADX INFO: loaded from: classes3.dex */
public abstract class p<R extends g, T extends BaseResultData> implements h<R, T> {
    @Override // com.kwad.sdk.core.network.h
    public void onError(@NonNull R r2, int i2, String str) {
    }

    @Override // com.kwad.sdk.core.network.h
    public void onStartRequest(@NonNull R r2) {
    }

    @Override // com.kwad.sdk.core.network.h
    public void onSuccess(@NonNull R r2, @NonNull T t2) {
    }
}
