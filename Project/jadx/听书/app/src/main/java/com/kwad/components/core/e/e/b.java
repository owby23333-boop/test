package com.kwad.components.core.e.e;

import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.mvp.Presenter;

/* JADX INFO: loaded from: classes3.dex */
public class b extends Presenter {
    protected c PU;
    protected AdInfo mAdInfo;

    @Override // com.kwad.sdk.mvp.Presenter
    public void at() {
        super.at();
        c cVar = (c) NN();
        this.PU = cVar;
        this.mAdInfo = com.kwad.sdk.core.response.b.e.el(cVar.PT.getAdTemplate());
    }
}
