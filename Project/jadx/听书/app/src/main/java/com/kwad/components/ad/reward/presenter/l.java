package com.kwad.components.ad.reward.presenter;

import android.view.View;
import com.kwad.components.ad.reward.n.g;
import com.kwad.components.ad.reward.presenter.platdetail.actionbar.RewardActionBarControl;
import com.kwad.components.core.widget.KsLogoView;
import com.kwad.sdk.R;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.view.AdBaseFrameLayout;

/* JADX INFO: loaded from: classes3.dex */
public final class l extends b implements com.kwad.components.ad.reward.presenter.platdetail.actionbar.a {
    private RewardActionBarControl rG;
    private com.kwad.components.ad.reward.n.g vL;
    private KsLogoView vN;
    private com.kwad.components.ad.reward.n.l vO;
    private boolean vM = false;
    private com.kwad.components.core.video.m jE = new com.kwad.components.core.video.m() { // from class: com.kwad.components.ad.reward.presenter.l.1
        @Override // com.kwad.components.core.video.m, com.kwad.components.core.video.i
        public final void onMediaPlayProgress(long j, long j2) {
            super.onMediaPlayProgress(j, j2);
            l.this.iF();
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public void iF() {
        if (this.vM) {
            return;
        }
        com.kwad.components.ad.reward.n.g gVar = this.vL;
        if (gVar == null) {
            this.rG.P(false);
        } else {
            gVar.a(new g.a() { // from class: com.kwad.components.ad.reward.presenter.l.2
                @Override // com.kwad.components.ad.reward.n.g.a
                public final void iG() {
                    l.this.rG.P(true);
                }
            }, 500L);
        }
        this.vM = true;
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        super.onCreate();
        this.vN = (KsLogoView) findViewById(R.id.ksad_ad_label_play_bar);
    }

    @Override // com.kwad.components.ad.reward.presenter.b, com.kwad.sdk.mvp.Presenter
    public final void at() {
        super.at();
        this.rG = this.tm.rG;
        this.tm.rE.a(this.jE);
        AdTemplate adTemplate = this.tm.mAdTemplate;
        boolean z = com.kwad.sdk.core.response.b.b.dt(adTemplate).displayWeakCard;
        this.tm.B(z);
        if (z) {
            if (this.vL == null) {
                this.vL = new com.kwad.components.ad.reward.n.g(this.tm);
            }
            this.vL.f((AdBaseFrameLayout) findViewById(R.id.ksad_root_container));
            this.vL.b(com.kwad.components.ad.reward.n.r.aa(adTemplate));
        }
        AdInfo adInfoEl = com.kwad.sdk.core.response.b.e.el(adTemplate);
        if (com.kwad.sdk.core.response.b.a.co(adTemplate)) {
            if (this.vO == null) {
                this.vO = new com.kwad.components.ad.reward.n.l(this.tm);
            }
            this.vO.h(this.tm.mRootContainer);
            this.vO.b(com.kwad.components.ad.reward.n.r.aa(adTemplate));
            com.kwad.components.ad.reward.presenter.platdetail.actionbar.d.a(getContext(), adInfoEl, this.vN, R.dimen.ksad_live_subscribe_card_logo_margin_bottom, false);
        }
        this.tm.rG.a(this);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
        this.tm.rE.b(this.jE);
        this.tm.rG.b(this);
        com.kwad.components.ad.reward.n.l lVar = this.vO;
        if (lVar != null) {
            lVar.onUnbind();
        }
    }

    @Override // com.kwad.components.ad.reward.presenter.platdetail.actionbar.a
    public final void a(RewardActionBarControl.ShowActionBarResult showActionBarResult, View view) {
        com.kwad.components.ad.reward.n.l lVar = this.vO;
        if (lVar != null) {
            lVar.lj();
        }
    }
}
