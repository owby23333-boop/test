package com.kwad.sdk.api;

import com.kwad.sdk.api.core.KsAdSdkApi;

/* JADX INFO: loaded from: classes4.dex */
@KsAdSdkApi
public interface KsInitCallback {
    void onFail(int i, String str);

    void onSuccess();
}
