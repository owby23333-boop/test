package com.kwad.components.ad.interstitial.e;

import android.app.Activity;
import com.kwad.components.ad.fullscreen.g;
import com.kwad.components.ad.interstitial.c;
import com.kwad.sdk.api.KsInterstitialAd;
import com.kwad.sdk.api.KsVideoPlayConfig;
import com.kwad.sdk.core.response.model.AdResultData;

/* JADX INFO: loaded from: classes3.dex */
public final class a extends com.kwad.components.ad.b implements com.kwad.components.core.internal.api.a, KsInterstitialAd {
    private final boolean ma;
    private g mb;
    private com.kwad.components.ad.interstitial.b mc;
    private final c md;

    public a(boolean z, AdResultData adResultData) {
        super(adResultData);
        this.ma = z;
        if (z) {
            this.mb = new g(adResultData);
        } else {
            this.mc = new com.kwad.components.ad.interstitial.b(adResultData);
        }
        this.md = new c();
    }

    @Override // com.kwad.sdk.api.KsInterstitialAd
    public final void showInterstitialAd(Activity activity, KsVideoPlayConfig ksVideoPlayConfig) {
        if (this.ma) {
            this.mb.showFullScreenVideoAd(activity, ksVideoPlayConfig);
        } else {
            this.mc.showInterstitialAd(activity, ksVideoPlayConfig);
        }
    }

    @Override // com.kwad.sdk.api.KsInterstitialAd
    public final void setAdInteractionListener(KsInterstitialAd.AdInteractionListener adInteractionListener) {
        this.md.a(adInteractionListener);
        if (this.ma) {
            this.mb.setFullScreenVideoAdInteractionListener(this.md);
        } else {
            this.mc.setAdInteractionListener(this.md);
        }
    }
}
