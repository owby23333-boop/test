package com.kwad.sdk.api;

import androidx.annotation.Keep;
import com.kwad.sdk.api.core.KsAdSdkApi;

/* JADX INFO: loaded from: classes3.dex */
@KsAdSdkApi
@Keep
public interface KsApkDownloadListener extends KsAppDownloadListener {
    @KsAdSdkApi
    @Keep
    void onPaused(int i2);
}
