package com.kwad.sdk.api.core;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.View;
import androidx.annotation.Keep;
import androidx.annotation.Nullable;
import com.kwad.sdk.api.KsAdVideoPlayConfig;
import com.kwad.sdk.api.KsNativeAd;
import com.kwad.sdk.api.loader.Wrapper;

/* JADX INFO: loaded from: classes3.dex */
@KsAdSdkDynamicApi
@Keep
public abstract class AbstractKsNativeAd implements KsNativeAd {
    @KsAdSdkDynamicApi
    @Keep
    public abstract Bitmap getSdkLogo();

    @Override // com.kwad.sdk.api.KsNativeAd
    @Nullable
    @KsAdSdkDynamicApi
    @Keep
    public final View getVideoView(Context context, @Nullable KsAdVideoPlayConfig ksAdVideoPlayConfig) {
        return getVideoView2(Wrapper.wrapContextIfNeed(context), ksAdVideoPlayConfig);
    }

    @Override // com.kwad.sdk.api.KsNativeAd
    @Nullable
    @KsAdSdkDynamicApi
    @Keep
    public final View getVideoView(Context context, boolean z2) {
        return getVideoView2(Wrapper.wrapContextIfNeed(context), z2);
    }

    @KsAdSdkDynamicApi
    @Keep
    protected abstract View getVideoView2(Context context, @Nullable KsAdVideoPlayConfig ksAdVideoPlayConfig);

    @KsAdSdkDynamicApi
    @Keep
    protected abstract View getVideoView2(Context context, boolean z2);
}
