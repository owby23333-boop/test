package com.kwad.components.ad.reward.presenter.c;

import com.kwad.components.ad.reward.j;
import com.kwad.components.ad.reward.presenter.c.kwai.c;
import com.kwad.components.ad.reward.presenter.r;
import com.kwad.sdk.R;
import com.kwad.sdk.core.response.a.d;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;

/* JADX INFO: loaded from: classes3.dex */
public final class b extends com.kwad.components.ad.reward.presenter.a {
    private AdInfo mAdInfo;
    private AdTemplate mAdTemplate;

    static class a extends com.kwad.components.ad.reward.presenter.b {
        public a(AdInfo adInfo) {
            super(adInfo);
        }

        @Override // com.kwad.components.ad.reward.presenter.b
        public final int hI() {
            return R.id.ksad_blur_end_cover;
        }

        @Override // com.kwad.components.ad.reward.presenter.b
        public final int hJ() {
            return 8;
        }
    }

    public b(AdTemplate adTemplate, boolean z2) {
        this.mAdTemplate = adTemplate;
        this.mAdInfo = d.cb(this.mAdTemplate);
        if (z2) {
            iI();
        } else {
            iJ();
        }
    }

    private void iI() {
        if (j.h(this.mAdInfo)) {
            a(new r());
        }
        a(new com.kwad.components.ad.reward.presenter.c.kwai.b());
        if (com.kwad.sdk.core.response.a.b.bf(this.mAdTemplate)) {
            a(new c());
        }
        a(new a(this.mAdInfo));
        if (com.kwad.components.ad.reward.kwai.b.l(this.mAdInfo) || !com.kwad.sdk.core.response.a.a.ak(this.mAdInfo)) {
            return;
        }
        a(new com.kwad.components.ad.reward.presenter.c.kwai.a());
    }

    private void iJ() {
        a(new com.kwad.components.ad.reward.presenter.c.kwai.b());
        if (com.kwad.sdk.core.response.a.b.bf(this.mAdTemplate)) {
            a(new c());
        }
        if (com.kwad.sdk.core.response.a.a.am(this.mAdInfo)) {
            a(new com.kwad.components.ad.reward.presenter.c.kwai.a());
        }
    }
}
