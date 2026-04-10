package com.kwad.components.ad.b;

import com.kwad.sdk.api.KsLoadManager;
import com.kwad.sdk.api.KsScene;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public interface i extends com.kwad.sdk.components.b {
    List<String> S();

    void loadSplashScreenAd(KsScene ksScene, KsLoadManager.SplashScreenAdListener splashScreenAdListener);
}
