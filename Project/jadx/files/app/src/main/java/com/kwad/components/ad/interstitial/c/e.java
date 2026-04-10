package com.kwad.components.ad.interstitial.c;

import com.kwad.sdk.core.response.model.AdInfo;

/* JADX INFO: loaded from: classes2.dex */
public final class e extends b {
    private c jq;
    private AdInfo mAdInfo;

    public e(AdInfo adInfo) {
        this.mAdInfo = adInfo;
    }

    @Override // com.kwad.components.ad.interstitial.c.b, com.kwad.sdk.mvp.Presenter
    public final void ar() {
        super.ar();
        this.jq = (c) Bs();
        if (!(com.kwad.sdk.core.response.a.a.cg(this.mAdInfo) || com.kwad.sdk.core.response.a.a.cm(this.mAdInfo)) || this.jq.mAdTemplate.mAdScene == null) {
            return;
        }
        this.mAdInfo.adConversionInfo.deeplinkUrl = com.kwad.components.core.d.b.d.a(getContext(), this.mAdInfo, this.jq.mAdTemplate.mAdScene);
    }
}
