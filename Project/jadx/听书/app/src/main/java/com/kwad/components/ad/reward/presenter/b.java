package com.kwad.components.ad.reward.presenter;

import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.mvp.Presenter;

/* JADX INFO: loaded from: classes3.dex */
public class b extends Presenter {
    public AdTemplate mAdTemplate;
    public com.kwad.components.ad.reward.g tm;

    @Override // com.kwad.sdk.mvp.Presenter
    public void at() {
        super.at();
        com.kwad.components.ad.reward.g gVar = (com.kwad.components.ad.reward.g) NN();
        this.tm = gVar;
        this.mAdTemplate = gVar.mAdTemplate;
    }

    protected final void iz() {
        this.tm.iz();
    }

    protected final boolean iA() {
        return com.kwad.sdk.core.response.b.a.bd(com.kwad.sdk.core.response.b.e.el(this.tm.mAdTemplate));
    }
}
