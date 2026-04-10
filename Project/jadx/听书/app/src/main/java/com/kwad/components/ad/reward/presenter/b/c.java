package com.kwad.components.ad.reward.presenter.b;

import android.view.View;
import com.kwad.components.ad.reward.n.o;
import com.kwad.components.ad.reward.n.r;
import com.kwad.components.ad.reward.presenter.platdetail.actionbar.RewardActionBarControl;
import com.kwad.components.core.video.m;
import com.kwad.sdk.R;
import com.kwad.sdk.core.response.b.e;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;

/* JADX INFO: loaded from: classes3.dex */
public final class c extends com.kwad.components.ad.reward.presenter.b implements com.kwad.components.ad.reward.presenter.platdetail.actionbar.a {
    private RewardActionBarControl rG;
    private m vR = new m() { // from class: com.kwad.components.ad.reward.presenter.b.c.1
        @Override // com.kwad.components.core.video.m, com.kwad.components.core.video.i
        public final void onMediaPlayProgress(long j, long j2) {
            super.onMediaPlayProgress(j, j2);
            c.this.iF();
        }
    };
    private o xn;

    @Override // com.kwad.components.ad.reward.presenter.platdetail.actionbar.a
    public final void a(RewardActionBarControl.ShowActionBarResult showActionBarResult, View view) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void iF() {
        this.rG.P(false);
    }

    @Override // com.kwad.components.ad.reward.presenter.b, com.kwad.sdk.mvp.Presenter
    public final void at() {
        super.at();
        this.rG = this.tm.rG;
        this.tm.rE.a(this.vR);
        AdTemplate adTemplate = this.tm.mAdTemplate;
        AdInfo adInfoEl = e.el(adTemplate);
        if (com.kwad.sdk.core.response.b.a.cR(adInfoEl)) {
            if (this.xn == null) {
                this.xn = new o(this.tm);
            }
            this.xn.b(this.tm.mRootContainer, com.kwad.sdk.core.response.b.a.bf(adInfoEl));
            this.xn.b(r.aa(adTemplate));
            findViewById(R.id.ksad_reward_origin_live_root).setVisibility(8);
        }
        this.tm.rG.a(this);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
        this.tm.rE.b(this.vR);
        this.tm.rG.b(this);
        o oVar = this.xn;
        if (oVar != null) {
            oVar.onUnbind();
        }
    }
}
