package com.kwad.components.ad.reward.presenter;

import android.text.TextUtils;
import com.kwad.sdk.core.response.model.AdInfo;

/* JADX INFO: loaded from: classes3.dex */
public final class h extends b implements com.kwad.sdk.app.a {
    private AdInfo mAdInfo;

    @Override // com.kwad.sdk.app.a
    public final void V(String str) {
    }

    @Override // com.kwad.components.ad.reward.presenter.b, com.kwad.sdk.mvp.Presenter
    public final void at() {
        super.at();
        this.mAdInfo = com.kwad.sdk.core.response.b.e.el(this.tm.mAdTemplate);
        com.kwad.sdk.app.b.Dw().a(this);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
        com.kwad.sdk.app.b.Dw().b(this);
    }

    @Override // com.kwad.sdk.app.a
    public final void U(String str) {
        if (TextUtils.equals(com.kwad.sdk.core.response.b.a.ay(this.mAdInfo), str)) {
            AdInfo adInfoEl = com.kwad.sdk.core.response.b.e.el(this.tm.mAdTemplate);
            if (com.kwad.sdk.core.response.b.a.aO(adInfoEl) && com.kwad.sdk.core.response.b.a.aN(adInfoEl) == 1) {
                return;
            }
            if (this.tm.rD != null) {
                this.tm.rD.onRewardVerify();
            }
            this.tm.rE.pause();
            this.tm.gK();
        }
    }
}
