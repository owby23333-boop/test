package com.kwad.components.core.j;

import com.kwad.sdk.api.KsInnerAd;
import com.kwad.sdk.core.response.model.AdTemplate;

/* JADX INFO: loaded from: classes3.dex */
final class b implements KsInnerAd {
    private final int Re;
    private final AdTemplate mAdTemplate;

    public b(AdTemplate adTemplate, int i) {
        this.mAdTemplate = adTemplate;
        this.Re = i;
    }

    public final AdTemplate getAdTemplate() {
        return this.mAdTemplate;
    }

    @Override // com.kwad.sdk.api.KsInnerAd
    public final int getType() {
        return this.Re;
    }
}
