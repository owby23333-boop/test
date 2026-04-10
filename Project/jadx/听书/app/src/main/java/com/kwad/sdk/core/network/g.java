package com.kwad.sdk.core.network;

import com.kwad.sdk.core.network.f;
import com.kwad.sdk.core.response.model.BaseResultData;

/* JADX INFO: loaded from: classes4.dex */
public interface g<R extends f, T extends BaseResultData> {
    void onError(R r, int i, String str);

    void onStartRequest(R r);

    void onSuccess(R r, T t);
}
