package com.kwad.sdk.api;

import androidx.annotation.Keep;
import com.kwad.sdk.api.core.KsAdSdkApi;

/* JADX INFO: loaded from: classes3.dex */
@KsAdSdkApi
@Keep
public interface KsImage {
    @KsAdSdkApi
    @Keep
    int getHeight();

    @KsAdSdkApi
    @Keep
    String getImageUrl();

    @KsAdSdkApi
    @Keep
    int getWidth();

    @KsAdSdkApi
    @Keep
    boolean isValid();
}
