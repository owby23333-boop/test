package com.kwad.components.ad.reward.presenter.platdetail.actionbar;

import android.content.Context;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.kwad.components.ad.reward.n.i;
import com.kwad.components.ad.reward.n.r;
import com.kwad.components.core.widget.KsLogoView;
import com.kwad.sdk.R;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.utils.aq;

/* JADX INFO: loaded from: classes3.dex */
public final class d extends com.kwad.components.ad.reward.presenter.b implements com.kwad.components.ad.reward.n.b {
    private ViewGroup jI;
    private KsLogoView vN;
    private i yo;

    @Override // com.kwad.components.ad.reward.n.b
    public final void hT() {
    }

    @Override // com.kwad.components.ad.reward.n.b
    public final void js() {
    }

    @Override // com.kwad.components.ad.reward.n.b
    public final void jt() {
    }

    public d(ViewGroup viewGroup) {
        this.jI = viewGroup;
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        super.onCreate();
        this.vN = (KsLogoView) findViewById(R.id.ksad_ad_label_play_bar);
    }

    @Override // com.kwad.components.ad.reward.presenter.b, com.kwad.sdk.mvp.Presenter
    public final void at() {
        super.at();
        i iVar = new i(this.tm, this.jI, this.vN);
        this.yo = iVar;
        iVar.b(r.aa(this.tm.mAdTemplate));
        a(getContext(), com.kwad.sdk.core.response.b.e.el(this.tm.mAdTemplate), this.vN, R.dimen.ksad_reward_jinniu_logo_margin_bottom, false);
    }

    public static FrameLayout.LayoutParams a(Context context, AdInfo adInfo, KsLogoView ksLogoView, int i, boolean z) {
        FrameLayout.LayoutParams layoutParamsA = null;
        if (ksLogoView != null && context != null) {
            ViewGroup.LayoutParams layoutParams = ksLogoView.getLayoutParams();
            if (!(layoutParams instanceof FrameLayout.LayoutParams)) {
                return null;
            }
            FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) layoutParams;
            layoutParamsA = a(layoutParams2);
            if (z) {
                ksLogoView.setVisibility(0);
            }
            boolean z2 = (!aq.QW() && (com.kwad.components.ad.reward.a.b.i(adInfo) || com.kwad.sdk.core.response.b.a.cL(adInfo))) || (aq.QW() && com.kwad.sdk.core.response.b.a.cK(adInfo));
            layoutParams2.gravity = 85;
            if (z2) {
                i = R.dimen.ksad_reward_follow_card_margin;
            }
            layoutParams2.bottomMargin = context.getResources().getDimensionPixelOffset(i);
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
}
