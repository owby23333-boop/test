package com.kwad.components.ad.reward.presenter;

import androidx.annotation.Nullable;
import com.kwad.components.core.g.a;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.internal.api.SceneImpl;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public final class f extends a implements a.InterfaceC0399a {
    private AdTemplate mAdTemplate;

    @Override // com.kwad.components.ad.reward.presenter.a, com.kwad.sdk.mvp.Presenter
    public final void ar() {
        super.ar();
        this.mAdTemplate = this.qS.mAdTemplate;
        boolean zWh = com.kwad.sdk.core.c.a.wh();
        com.kwad.sdk.core.d.b.d("RewardInnerAdLoadPresenter", "onBind localCheckResult: " + zWh);
        SceneImpl sceneImpl = this.mAdTemplate.mAdScene;
        if (sceneImpl == null || !zWh) {
            return;
        }
        com.kwad.components.core.g.a.b(sceneImpl, this);
    }

    @Override // com.kwad.components.core.g.a.InterfaceC0399a
    public final void onError(int i2, String str) {
        List<a.InterfaceC0399a> listGj = this.qS.gj();
        if (listGj != null) {
            Iterator<a.InterfaceC0399a> it = listGj.iterator();
            while (it.hasNext()) {
                it.next().onError(i2, str);
            }
        }
    }

    @Override // com.kwad.components.core.g.a.InterfaceC0399a
    public final void onInnerAdLoad(@Nullable List<com.kwad.components.core.g.c> list) {
        if (list == null || list.size() == 0) {
            return;
        }
        com.kwad.sdk.core.d.b.d("RewardInnerAdLoadPresenter", "onInnerAdLoad: " + list.size());
        AdTemplate adTemplate = list.get(0).getAdTemplate();
        boolean zBa = com.kwad.sdk.core.response.a.b.ba(adTemplate);
        List<a.InterfaceC0399a> listGj = this.qS.gj();
        if (zBa) {
            com.kwad.sdk.core.c.a.b(com.kwad.sdk.core.response.a.b.aX(adTemplate), com.kwad.sdk.core.response.a.b.aY(adTemplate));
            if (listGj != null) {
                Iterator<a.InterfaceC0399a> it = listGj.iterator();
                while (it.hasNext()) {
                    it.next().onInnerAdLoad(list);
                }
            }
        }
    }

    @Override // com.kwad.components.core.g.a.InterfaceC0399a
    public final void onRequestResult(int i2) {
        List<a.InterfaceC0399a> listGj = this.qS.gj();
        if (listGj != null) {
            Iterator<a.InterfaceC0399a> it = listGj.iterator();
            while (it.hasNext()) {
                it.next().onRequestResult(i2);
            }
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
    }
}
