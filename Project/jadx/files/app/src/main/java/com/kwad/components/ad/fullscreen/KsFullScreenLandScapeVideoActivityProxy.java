package com.kwad.components.ad.fullscreen;

import androidx.annotation.Keep;
import com.kwad.sdk.api.core.KsAdSdkDynamicImpl;
import com.kwad.sdk.api.proxy.app.KsFullScreenLandScapeVideoActivity;

/* JADX INFO: loaded from: classes2.dex */
@KsAdSdkDynamicImpl(KsFullScreenLandScapeVideoActivity.class)
@Keep
public class KsFullScreenLandScapeVideoActivityProxy extends KsFullScreenVideoActivityProxy {
    public static void register() {
        com.kwad.sdk.service.a.a(KsFullScreenLandScapeVideoActivity.class, KsFullScreenLandScapeVideoActivityProxy.class);
    }
}
