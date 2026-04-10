package com.kwad.components.ad.fullscreen;

import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;

/* JADX INFO: loaded from: classes3.dex */
public final class b {
    public final boolean jk = com.kwad.components.ad.reward.a.b.hO();
    private AdInfo mAdInfo;
    private AdTemplate mAdTemplate;

    public b(AdTemplate adTemplate) {
        this.mAdTemplate = adTemplate;
        this.mAdInfo = com.kwad.sdk.core.response.b.e.el(adTemplate);
    }

    public final AdTemplate getAdTemplate() {
        return this.mAdTemplate;
    }

    public final AdInfo cU() {
        return this.mAdInfo;
    }

    public final boolean cV() {
        return com.kwad.sdk.core.response.b.e.ex(this.mAdTemplate);
    }
}
