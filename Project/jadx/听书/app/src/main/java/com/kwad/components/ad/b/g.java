package com.kwad.components.ad.b;

import com.kwad.sdk.api.KsLoadManager;
import com.kwad.sdk.api.KsScene;

/* JADX INFO: loaded from: classes3.dex */
public interface g extends com.kwad.sdk.components.b {
    void loadNativeAd(KsScene ksScene, KsLoadManager.NativeAdListener nativeAdListener);

    void loadNativeAd(String str, KsLoadManager.NativeAdListener nativeAdListener);
}
