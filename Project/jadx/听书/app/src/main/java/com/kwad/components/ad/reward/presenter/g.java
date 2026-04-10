package com.kwad.components.ad.reward.presenter;

import com.kwad.components.core.j.a;
import com.kwad.sdk.core.response.model.AdTemplate;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public final class g extends b implements a.InterfaceC0338a {
    @Override // com.kwad.components.ad.reward.presenter.b, com.kwad.sdk.mvp.Presenter
    public final void at() {
        super.at();
        boolean zHr = com.kwad.sdk.core.local.a.Hr();
        com.kwad.sdk.core.d.c.d("RewardInnerAdLoadPresenter", "onBind localCheckResult: " + zHr);
        if (this.mAdTemplate.mAdScene == null || !zHr) {
            return;
        }
        com.kwad.components.core.j.a.a(this.mAdTemplate.mAdScene, this);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
    }

    @Override // com.kwad.components.core.j.a.InterfaceC0338a
    public final void onError(int i, String str) {
        List<a.InterfaceC0338a> listGR = this.tm.gR();
        if (listGR != null) {
            Iterator<a.InterfaceC0338a> it = listGR.iterator();
            while (it.hasNext()) {
                it.next().onError(i, str);
            }
        }
    }

    @Override // com.kwad.components.core.j.a.InterfaceC0338a
    public final void onRequestResult(int i) {
        List<a.InterfaceC0338a> listGR = this.tm.gR();
        if (listGR != null) {
            Iterator<a.InterfaceC0338a> it = listGR.iterator();
            while (it.hasNext()) {
                it.next().onRequestResult(i);
            }
        }
    }

    @Override // com.kwad.components.core.j.a.InterfaceC0338a
    public final void e(List<com.kwad.components.core.j.c> list) {
        if (list == null || list.size() == 0) {
            return;
        }
        com.kwad.sdk.core.d.c.d("RewardInnerAdLoadPresenter", "onInnerAdLoad: " + list.size());
        AdTemplate adTemplate = list.get(0).getAdTemplate();
        boolean zCG = com.kwad.sdk.core.response.b.b.cG(adTemplate);
        List<a.InterfaceC0338a> listGR = this.tm.gR();
        if (zCG) {
            com.kwad.sdk.core.local.a.e(com.kwad.sdk.core.response.b.b.cD(adTemplate), com.kwad.sdk.core.response.b.b.cE(adTemplate));
            if (listGR != null) {
                Iterator<a.InterfaceC0338a> it = listGR.iterator();
                while (it.hasNext()) {
                    it.next().e(list);
                }
            }
        }
    }
}
