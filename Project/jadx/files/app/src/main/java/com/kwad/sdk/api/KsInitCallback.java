package com.kwad.sdk.api;

import androidx.annotation.Keep;
import com.kwad.sdk.api.core.KsAdSdkApi;

/* JADX INFO: loaded from: classes3.dex */
@KsAdSdkApi
@Keep
public interface KsInitCallback {
    void onFail(int i2, String str);

    void onSuccess();
}
