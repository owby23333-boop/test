package com.kwad.components.ad.fullscreen;

import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;

/* JADX INFO: loaded from: classes2.dex */
public final class b {
    private AdInfo mAdInfo;
    private AdTemplate mAdTemplate;

    public b(AdTemplate adTemplate) {
        this.mAdTemplate = adTemplate;
        this.mAdInfo = com.kwad.sdk.core.response.a.d.cb(adTemplate);
    }

    public final AdInfo bK() {
        return this.mAdInfo;
    }

    public final boolean bL() {
        return com.kwad.sdk.core.response.a.d.cn(this.mAdTemplate);
    }

    public final AdTemplate getAdTemplate() {
        return this.mAdTemplate;
    }
}
