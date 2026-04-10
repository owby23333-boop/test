package com.kwad.components.ad.reward.presenter.platdetail.actionbar;

import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.kwad.components.ad.reward.k.m;
import com.kwad.components.ad.reward.k.v;
import com.kwad.components.ad.reward.presenter.platdetail.actionbar.RewardActionBarControl;
import com.kwad.components.core.r.j;
import com.kwad.components.core.widget.KsLogoView;
import com.kwad.sdk.R;
import com.kwad.sdk.core.response.model.AdInfo;

/* JADX INFO: loaded from: classes3.dex */
public final class e extends com.kwad.components.ad.reward.presenter.a implements RewardActionBarControl.c {
    private ViewGroup gu;
    private KsLogoView sH;
    private m uW;
    private int uX;
    private FrameLayout.LayoutParams uY;
    private m.a uZ;

    public e(ViewGroup viewGroup, m.a aVar) {
        this.gu = viewGroup;
        this.uZ = aVar;
    }

    @Override // com.kwad.components.ad.reward.presenter.a, com.kwad.sdk.mvp.Presenter
    public final void ar() {
        super.ar();
        this.qS.pz.a(this);
        AdInfo adInfoCb = com.kwad.sdk.core.response.a.d.cb(this.qS.mAdTemplate);
        this.uX = this.sH.getVisibility();
        this.uY = d.a(getContext(), adInfoCb, this.sH, R.dimen.ksad_reward_order_logo_margin_bottom, !this.qS.pw.jY());
        this.uW = new m(this.gu, new com.kwad.components.ad.reward.k.a(getContext(), this.qS) { // from class: com.kwad.components.ad.reward.presenter.platdetail.actionbar.e.1
            @Override // com.kwad.components.ad.reward.k.a, com.kwad.components.ad.reward.k.b
            public final void iy() {
                e.this.qS.a(1, e.this.getContext(), 10, 2);
            }

            @Override // com.kwad.components.ad.reward.k.a, com.kwad.components.ad.reward.k.b
            public final void iz() {
                e.this.qS.a(1, e.this.getContext(), 10, 2);
            }
        });
        this.uW.a(this.uZ);
        this.uW.b(v.C(this.qS.mAdTemplate));
        j.a(new com.kwad.components.core.widget.e(), this.uW.hc());
    }

    @Override // com.kwad.components.ad.reward.presenter.platdetail.actionbar.RewardActionBarControl.c
    public final void e(a aVar) {
        this.gu.setVisibility(0);
        RewardActionBarControl.a(aVar, this.gu, RewardActionBarControl.ShowActionBarResult.SHOW_NATIVE_ORDER);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        super.onCreate();
        this.sH = (KsLogoView) findViewById(R.id.ksad_ad_label_play_bar);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
        this.sH.setVisibility(this.uX);
        FrameLayout.LayoutParams layoutParams = this.uY;
        if (layoutParams != null) {
            this.sH.setLayoutParams(layoutParams);
        }
    }
}
