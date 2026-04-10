package com.kwad.components.ad.reward.presenter.platdetail.a;

import android.view.View;
import android.widget.ImageView;
import com.kwad.components.ad.reward.e.g;
import com.kwad.components.ad.reward.e.j;
import com.kwad.components.ad.reward.e.n;
import com.kwad.components.core.playable.PlayableSource;
import com.kwad.sdk.R;
import com.kwad.sdk.utils.aq;

/* JADX INFO: loaded from: classes3.dex */
public final class e extends com.kwad.components.ad.reward.presenter.b implements j {
    private g mPlayEndPageListener = new com.kwad.components.ad.reward.e.a() { // from class: com.kwad.components.ad.reward.presenter.platdetail.a.e.1
        @Override // com.kwad.components.ad.reward.e.g
        public final void cX() {
            e.this.jD();
        }
    };
    private View yQ;
    private View yR;
    private ImageView yS;

    @Override // com.kwad.components.ad.reward.e.j
    public final void a(PlayableSource playableSource, n nVar) {
    }

    public e() {
        a(new com.kwad.components.ad.reward.presenter.platdetail.a());
        a(new com.kwad.components.ad.reward.presenter.d.a());
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        super.onCreate();
        this.yQ = findViewById(R.id.ksad_play_detail_top_toolbar);
        this.yR = findViewById(R.id.ksad_play_end_top_toolbar);
        this.yS = (ImageView) findViewById(R.id.ksad_blur_end_cover);
    }

    @Override // com.kwad.components.ad.reward.presenter.b, com.kwad.sdk.mvp.Presenter
    public final void at() {
        super.at();
        this.yQ.setVisibility(0);
        this.yR.setVisibility(8);
        this.tm.b(this.mPlayEndPageListener);
        com.kwad.components.ad.reward.a.gg().a(this);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
        jC();
        this.tm.c(this.mPlayEndPageListener);
        com.kwad.components.ad.reward.a.gg().b(this);
        this.yR.setVisibility(8);
    }

    private void jC() {
        if (!this.tm.rU) {
            this.yR.setVisibility(8);
        }
        this.yQ.setVisibility(0);
        getContext();
        if (com.kwad.components.ad.reward.g.O(this.tm.mAdTemplate) && aq.QW()) {
            this.yS.setVisibility(8);
        }
    }

    public final void jD() {
        if (this.tm.rU) {
            this.yQ.setVisibility(8);
        } else {
            this.yQ.setVisibility(8);
            this.yR.setVisibility(0);
        }
        getContext();
        if (com.kwad.components.ad.reward.g.O(this.tm.mAdTemplate) && aq.QW()) {
            this.yS.setVisibility(0);
        }
    }

    @Override // com.kwad.components.ad.reward.e.j
    public final void dk() {
        jC();
    }

    @Override // com.kwad.components.ad.reward.e.j
    public final void dl() {
        jD();
    }
}
