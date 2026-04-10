package com.kwad.components.ad.reward.presenter;

import android.view.View;
import androidx.annotation.Nullable;
import com.kwad.components.ad.reward.k.g;
import com.kwad.components.ad.reward.presenter.platdetail.actionbar.RewardActionBarControl;
import com.kwad.components.core.widget.KsLogoView;
import com.kwad.components.offline.api.core.adlive.listener.AdLivePlayStateListener;
import com.kwad.components.offline.api.core.adlive.listener.AdLivePlayStateListenerAdapter;
import com.kwad.sdk.R;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.view.AdBaseFrameLayout;

/* JADX INFO: loaded from: classes3.dex */
public final class k extends a implements com.kwad.components.ad.reward.presenter.platdetail.actionbar.a {
    private RewardActionBarControl pz;

    @Nullable
    private com.kwad.components.ad.reward.k.g sF;
    private KsLogoView sH;

    @Nullable
    private com.kwad.components.ad.reward.k.k sI;
    private boolean sG = false;
    private AdLivePlayStateListener mAdLivePlayStateListener = new AdLivePlayStateListenerAdapter() { // from class: com.kwad.components.ad.reward.presenter.k.1
        @Override // com.kwad.components.offline.api.core.adlive.listener.AdLivePlayStateListenerAdapter, com.kwad.components.offline.api.core.adlive.listener.AdLivePlayStateListener
        public final void onLivePlayProgress(long j2) {
            super.onLivePlayProgress(j2);
            k.this.hN();
        }
    };
    private com.kwad.components.core.video.i mVideoPlayStateListener = new com.kwad.components.core.video.j() { // from class: com.kwad.components.ad.reward.presenter.k.2
        @Override // com.kwad.components.core.video.j, com.kwad.components.core.video.i
        public final void onVideoPlayProgress(long j2, long j3) {
            super.onVideoPlayProgress(j2, j3);
            k.this.hN();
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public void hN() {
        if (this.sG) {
            return;
        }
        com.kwad.components.ad.reward.k.g gVar = this.sF;
        if (gVar == null) {
            this.pz.S(false);
        } else {
            gVar.a(new g.a() { // from class: com.kwad.components.ad.reward.presenter.k.3
                @Override // com.kwad.components.ad.reward.k.g.a
                public final void hO() {
                    k.this.pz.S(true);
                }
            }, 500L);
        }
        this.sG = true;
    }

    @Override // com.kwad.components.ad.reward.presenter.platdetail.actionbar.a
    public final void a(RewardActionBarControl.ShowActionBarResult showActionBarResult, View view) {
        com.kwad.components.ad.reward.k.k kVar = this.sI;
        if (kVar != null) {
            kVar.kj();
        }
    }

    @Override // com.kwad.components.ad.reward.presenter.a, com.kwad.sdk.mvp.Presenter
    public final void ar() {
        super.ar();
        com.kwad.components.ad.reward.j jVar = this.qS;
        this.pz = jVar.pz;
        jVar.pw.a(this.mVideoPlayStateListener, this.mAdLivePlayStateListener);
        AdTemplate adTemplate = this.qS.mAdTemplate;
        boolean z2 = com.kwad.sdk.core.response.a.b.bJ(adTemplate).displayWeakCard;
        this.qS.D(z2);
        if (z2) {
            if (this.sF == null) {
                this.sF = new com.kwad.components.ad.reward.k.g(this.qS);
            }
            this.sF.e((AdBaseFrameLayout) findViewById(R.id.ksad_root_container));
            this.sF.b(com.kwad.components.ad.reward.k.v.C(adTemplate));
        }
        AdInfo adInfoCb = com.kwad.sdk.core.response.a.d.cb(adTemplate);
        if (com.kwad.sdk.core.response.a.a.aJ(adTemplate)) {
            if (this.sI == null) {
                this.sI = new com.kwad.components.ad.reward.k.k(this.qS);
            }
            this.sI.f(this.qS.mRootContainer);
            this.sI.b(com.kwad.components.ad.reward.k.v.C(adTemplate));
            com.kwad.components.ad.reward.presenter.platdetail.actionbar.d.a(getContext(), adInfoCb, this.sH, R.dimen.ksad_live_subscribe_card_logo_margin_bottom, false);
        }
        this.qS.pz.a(this);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        super.onCreate();
        this.sH = (KsLogoView) findViewById(R.id.ksad_ad_label_play_bar);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
        this.qS.pw.b(this.mVideoPlayStateListener, this.mAdLivePlayStateListener);
        this.qS.pz.b(this);
        com.kwad.components.ad.reward.k.k kVar = this.sI;
        if (kVar != null) {
            kVar.onUnbind();
        }
    }
}
