package com.kwad.components.ad.reward.presenter.platdetail.actionbar;

import android.content.Context;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.kwad.components.ad.reward.k.h;
import com.kwad.components.ad.reward.k.v;
import com.kwad.components.core.widget.KsLogoView;
import com.kwad.sdk.R;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.utils.ah;

/* JADX INFO: loaded from: classes3.dex */
public final class d extends com.kwad.components.ad.reward.presenter.a implements com.kwad.components.ad.reward.k.b {
    private ViewGroup gu;
    private KsLogoView sH;
    private h uV;

    public d(ViewGroup viewGroup) {
        this.gu = viewGroup;
    }

    public static FrameLayout.LayoutParams a(Context context, AdInfo adInfo, KsLogoView ksLogoView, int i2, boolean z2) {
        FrameLayout.LayoutParams layoutParamsA = null;
        if (ksLogoView != null && context != null) {
            ViewGroup.LayoutParams layoutParams = ksLogoView.getLayoutParams();
            if (!(layoutParams instanceof FrameLayout.LayoutParams)) {
                return null;
            }
            FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) layoutParams;
            layoutParamsA = a(layoutParams2);
            if (z2) {
                ksLogoView.setVisibility(0);
            }
            boolean z3 = (!ah.cu(context) && (com.kwad.components.ad.reward.kwai.b.j(adInfo) || com.kwad.sdk.core.response.a.a.ci(adInfo))) || (ah.cu(context) && com.kwad.sdk.core.response.a.a.ch(adInfo));
            layoutParams2.gravity = 85;
            if (z3) {
                i2 = R.dimen.ksad_reward_follow_card_margin;
            }
            layoutParams2.bottomMargin = context.getResources().getDimensionPixelOffset(i2);
            layoutParams2.rightMargin = context.getResources().getDimensionPixelOffset(R.dimen.ksad_reward_follow_card_margin);
            ksLogoView.setLayoutParams(layoutParams2);
        }
        return layoutParamsA;
    }

    private static FrameLayout.LayoutParams a(FrameLayout.LayoutParams layoutParams) {
        FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams((ViewGroup.MarginLayoutParams) layoutParams);
        layoutParams2.gravity = layoutParams.gravity;
        return layoutParams2;
    }

    @Override // com.kwad.components.ad.reward.presenter.a, com.kwad.sdk.mvp.Presenter
    public final void ar() {
        super.ar();
        this.uV = new h(this.qS, this.gu, this.sH);
        this.uV.b(v.C(this.qS.mAdTemplate));
        a(getContext(), com.kwad.sdk.core.response.a.d.cb(this.qS.mAdTemplate), this.sH, R.dimen.ksad_reward_jinniu_logo_margin_bottom, false);
    }

    @Override // com.kwad.components.ad.reward.k.b
    public final void hg() {
    }

    @Override // com.kwad.components.ad.reward.k.b
    public final void iy() {
    }

    @Override // com.kwad.components.ad.reward.k.b
    public final void iz() {
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        super.onCreate();
        this.sH = (KsLogoView) findViewById(R.id.ksad_ad_label_play_bar);
    }
}
