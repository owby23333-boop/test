package com.kwad.components.ad.splashscreen;

import android.content.Context;
import com.kwad.components.ad.b.i;
import com.kwad.sdk.api.KsLoadManager;
import com.kwad.sdk.api.KsScene;
import com.kwad.sdk.l;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public final class a extends com.kwad.sdk.components.e implements i {
    @Override // com.kwad.sdk.components.b
    public final void init(Context context) {
    }

    @Override // com.kwad.sdk.components.b
    public final Class<i> getComponentsType() {
        return i.class;
    }

    @Override // com.kwad.components.ad.b.i
    public final void loadSplashScreenAd(KsScene ksScene, KsLoadManager.SplashScreenAdListener splashScreenAdListener) {
        if (!l.Cf().CG()) {
            splashScreenAdListener.onError(com.kwad.sdk.core.network.e.aEz.errorCode, com.kwad.sdk.core.network.e.aEz.msg);
        } else {
            b.loadSplashScreenAd(ksScene, splashScreenAdListener);
        }
    }

    @Override // com.kwad.components.ad.b.i
    public final List<String> S() {
        return SplashPreloadManager.lD().S();
    }
}
