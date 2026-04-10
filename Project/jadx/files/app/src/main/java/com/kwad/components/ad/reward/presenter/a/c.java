package com.kwad.components.ad.reward.presenter.a;

import android.view.View;
import androidx.annotation.Nullable;
import com.kwad.components.ad.reward.j;
import com.kwad.components.ad.reward.k.n;
import com.kwad.components.ad.reward.k.v;
import com.kwad.components.ad.reward.presenter.platdetail.actionbar.RewardActionBarControl;
import com.kwad.components.offline.api.core.adlive.listener.AdLivePlayStateListener;
import com.kwad.components.offline.api.core.adlive.listener.AdLivePlayStateListenerAdapter;
import com.kwad.sdk.R;
import com.kwad.sdk.core.response.a.d;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;

/* JADX INFO: loaded from: classes3.dex */
public final class c extends com.kwad.components.ad.reward.presenter.a implements com.kwad.components.ad.reward.presenter.platdetail.actionbar.a {
    private AdLivePlayStateListener mAdLivePlayStateListener = new AdLivePlayStateListenerAdapter() { // from class: com.kwad.components.ad.reward.presenter.a.c.1
        @Override // com.kwad.components.offline.api.core.adlive.listener.AdLivePlayStateListenerAdapter, com.kwad.components.offline.api.core.adlive.listener.AdLivePlayStateListener
        public final void onLivePlayProgress(long j2) {
            super.onLivePlayProgress(j2);
            c.this.hN();
        }
    };
    private RewardActionBarControl pz;

    @Nullable
    private n un;

    /* JADX INFO: Access modifiers changed from: private */
    public void hN() {
        this.pz.S(false);
    }

    @Override // com.kwad.components.ad.reward.presenter.platdetail.actionbar.a
    public final void a(RewardActionBarControl.ShowActionBarResult showActionBarResult, View view) {
    }

    @Override // com.kwad.components.ad.reward.presenter.a, com.kwad.sdk.mvp.Presenter
    public final void ar() {
        super.ar();
        j jVar = this.qS;
        this.pz = jVar.pz;
        jVar.pw.a(null, this.mAdLivePlayStateListener);
        AdTemplate adTemplate = this.qS.mAdTemplate;
        AdInfo adInfoCb = d.cb(adTemplate);
        if (com.kwad.sdk.core.response.a.a.co(adInfoCb)) {
            if (this.un == null) {
                this.un = new n(this.qS);
            }
            this.un.a(this.qS.mRootContainer, com.kwad.sdk.core.response.a.a.aY(adInfoCb));
            this.un.b(v.C(adTemplate));
            findViewById(R.id.ksad_reward_origin_live_root).setVisibility(8);
        }
        this.qS.pz.a(this);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
        this.qS.pw.b(null, this.mAdLivePlayStateListener);
        this.qS.pz.b(this);
        n nVar = this.un;
        if (nVar != null) {
            nVar.onUnbind();
        }
    }
}
