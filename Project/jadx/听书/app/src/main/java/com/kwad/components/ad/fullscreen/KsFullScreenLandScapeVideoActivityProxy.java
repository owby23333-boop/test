package com.kwad.components.ad.fullscreen;

import com.kwad.sdk.api.core.KsAdSdkDynamicImpl;
import com.kwad.sdk.api.proxy.app.KsFullScreenLandScapeVideoActivity;

/* JADX INFO: loaded from: classes3.dex */
@KsAdSdkDynamicImpl(KsFullScreenLandScapeVideoActivity.class)
public class KsFullScreenLandScapeVideoActivityProxy extends KsFullScreenVideoActivityProxy {
    public static void register() {
        com.kwad.sdk.service.c.a(KsFullScreenLandScapeVideoActivity.class, KsFullScreenLandScapeVideoActivityProxy.class);
    }
}
