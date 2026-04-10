package com.kwad.components.ad.reward.presenter;

import com.kwad.components.core.r.f;
import com.kwad.sdk.core.response.model.AdInfo;

/* JADX INFO: loaded from: classes3.dex */
public final class g extends a implements f.a {
    private AdInfo mAdInfo;
    private com.kwad.components.core.r.f sz;

    @Override // com.kwad.components.ad.reward.presenter.a, com.kwad.sdk.mvp.Presenter
    public final void ar() {
        super.ar();
        this.mAdInfo = com.kwad.sdk.core.response.a.d.cb(this.qS.mAdTemplate);
        com.kwad.components.core.r.f fVar = this.sz;
        if (fVar == null) {
            this.sz = new com.kwad.components.core.r.f(com.kwad.sdk.core.response.a.a.ar(this.mAdInfo));
        } else {
            fVar.ay(com.kwad.sdk.core.response.a.a.ar(this.mAdInfo));
        }
        this.sz.a(this.qS.mContext, this);
    }

    @Override // com.kwad.components.core.r.f.a
    public final void hM() {
        AdInfo adInfoCb = com.kwad.sdk.core.response.a.d.cb(this.qS.mAdTemplate);
        if (com.kwad.sdk.core.response.a.a.aH(adInfoCb) && com.kwad.sdk.core.response.a.a.aG(adInfoCb) == 1) {
            return;
        }
        com.kwad.components.ad.reward.d.b bVar = this.qS.mAdOpenInteractionListener;
        if (bVar != null) {
            bVar.onRewardVerify();
        }
        this.qS.pw.pause();
        this.qS.ga();
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
        this.sz.as(this.qS.mContext);
    }
}
