package com.kwad.components.ad.reward;

import androidx.annotation.Keep;
import com.kwad.sdk.api.core.KsAdSdkDynamicImpl;
import com.kwad.sdk.api.proxy.app.KSRewardLandScapeVideoActivity;

/* JADX INFO: loaded from: classes3.dex */
@KsAdSdkDynamicImpl(KSRewardLandScapeVideoActivity.class)
@Keep
public class KSRewardLandScapeVideoActivityProxy extends KSRewardVideoActivityProxy {
    public static void register() {
        com.kwad.sdk.service.a.a(KSRewardLandScapeVideoActivity.class, KSRewardLandScapeVideoActivityProxy.class);
    }
}
