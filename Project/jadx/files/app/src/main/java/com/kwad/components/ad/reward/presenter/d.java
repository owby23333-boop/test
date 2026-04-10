package com.kwad.components.ad.reward.presenter;

import android.view.ViewGroup;
import android.view.ViewStub;
import com.kwad.components.ad.reward.k.m;
import com.kwad.sdk.R;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;

/* JADX INFO: loaded from: classes3.dex */
public final class d extends a {
    private AdInfo mAdInfo;
    private AdTemplate mAdTemplate;

    public d(AdTemplate adTemplate, AdInfo adInfo, ViewGroup viewGroup) {
        this.mAdInfo = adInfo;
        this.mAdTemplate = adTemplate;
        if (com.kwad.components.ad.reward.kwai.b.j(this.mAdInfo)) {
            final com.kwad.components.ad.reward.a.c cVar = new com.kwad.components.ad.reward.a.c();
            a(cVar);
            ViewStub viewStub = (ViewStub) viewGroup.findViewById(R.id.ksad_reward_order_card);
            a(new com.kwad.components.ad.reward.presenter.platdetail.actionbar.e((ViewGroup) (viewStub != null ? viewStub.inflate() : viewGroup.findViewById(R.id.ksad_reward_order_root)), new m.a() { // from class: com.kwad.components.ad.reward.presenter.d.1
                @Override // com.kwad.components.ad.reward.k.m.a
                public final void hL() {
                    cVar.showDialog();
                }
            }));
            return;
        }
        if (com.kwad.sdk.core.response.a.a.ci(adInfo)) {
            ViewStub viewStub2 = (ViewStub) viewGroup.findViewById(R.id.ksad_reward_jinniu_card);
            a(new com.kwad.components.ad.reward.presenter.platdetail.actionbar.d((ViewGroup) (viewStub2 != null ? viewStub2.inflate() : viewGroup.findViewById(R.id.ksad_reward_jinniu_root))));
        }
    }

    @Override // com.kwad.components.ad.reward.presenter.a, com.kwad.sdk.mvp.Presenter
    public final void ar() {
        super.ar();
        if (!(com.kwad.sdk.core.response.a.a.cg(this.mAdInfo) || com.kwad.sdk.core.response.a.a.cm(this.mAdInfo)) || this.qS.mAdTemplate.mAdScene == null) {
            return;
        }
        this.mAdInfo.adConversionInfo.deeplinkUrl = com.kwad.components.core.d.b.d.a(getContext(), this.mAdInfo, this.qS.mAdTemplate.mAdScene);
    }
}
