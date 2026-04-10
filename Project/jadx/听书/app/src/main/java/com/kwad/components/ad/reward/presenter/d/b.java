package com.kwad.components.ad.reward.presenter.d;

import com.kwad.components.ad.reward.g;
import com.kwad.components.ad.reward.presenter.d.a.c;
import com.kwad.components.ad.reward.presenter.s;
import com.kwad.sdk.R;
import com.kwad.sdk.core.response.b.e;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;

/* JADX INFO: loaded from: classes3.dex */
public final class b extends com.kwad.components.ad.reward.presenter.b {
    private AdInfo mAdInfo;
    private AdTemplate mAdTemplate;

    public b(AdTemplate adTemplate, boolean z) {
        this.mAdTemplate = adTemplate;
        this.mAdInfo = e.el(adTemplate);
        if (z) {
            jE();
        } else {
            jF();
        }
    }

    private void jE() {
        if (g.g(this.mAdInfo)) {
            a(new s());
        }
        a(new com.kwad.components.ad.reward.presenter.d.a.b());
        if (com.kwad.sdk.core.response.b.b.cL(this.mAdTemplate)) {
            a(new c());
        }
        a(new a(this.mAdInfo));
        if (com.kwad.components.ad.reward.a.b.k(this.mAdInfo) || !com.kwad.sdk.core.response.b.a.as(this.mAdInfo)) {
            return;
        }
        a(new com.kwad.components.ad.reward.presenter.d.a.a());
    }

    static class a extends com.kwad.components.ad.reward.presenter.c {
        @Override // com.kwad.components.ad.reward.presenter.c
        public final int iC() {
            return 8;
        }

        public a(AdInfo adInfo) {
            super(adInfo);
        }

        @Override // com.kwad.components.ad.reward.presenter.c
        public final int iB() {
            return R.id.ksad_blur_end_cover;
        }
    }

    private void jF() {
        a(new com.kwad.components.ad.reward.presenter.d.a.b());
        if (com.kwad.sdk.core.response.b.b.cL(this.mAdTemplate)) {
            a(new c());
        }
    }
}
