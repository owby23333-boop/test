package com.kwad.components.ad.reward.b;

import android.view.ViewGroup;
import com.kwad.components.ad.reward.b.b;
import com.kwad.sdk.R;
import com.kwad.sdk.core.response.b.e;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdProductInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.utils.bg;

/* JADX INFO: loaded from: classes3.dex */
public final class c extends com.kwad.components.ad.reward.presenter.b implements b.a {
    private AdTemplate mAdTemplate;
    private boolean uc = false;

    static /* synthetic */ boolean a(c cVar, boolean z) {
        cVar.uc = true;
        return true;
    }

    @Override // com.kwad.components.ad.reward.presenter.b, com.kwad.sdk.mvp.Presenter
    public final void at() {
        super.at();
        this.mAdTemplate = this.tm.mAdTemplate;
    }

    private static boolean l(AdInfo adInfo) {
        AdProductInfo adProductInfoCV = com.kwad.sdk.core.response.b.a.cV(adInfo);
        return (!com.kwad.components.ad.reward.a.b.i(adInfo) || adProductInfoCV == null || adProductInfoCV.isCouponListEmpty()) ? false : true;
    }

    @Override // com.kwad.components.ad.reward.b.b.a
    public final void hT() {
        this.tm.a(1, getContext(), 29, 1);
    }

    public final void showDialog() {
        com.kwad.sdk.core.d.c.d("RewardCouponDialogPresenter", "onBind hasShown : " + this.uc);
        if (this.uc) {
            return;
        }
        AdInfo adInfoEl = e.el(this.mAdTemplate);
        ViewGroup viewGroup = (ViewGroup) this.tm.mRootContainer.findViewById(R.id.ksad_reward_order_coupon_list);
        if (viewGroup == null) {
            return;
        }
        int childCount = viewGroup.getChildCount();
        ViewGroup childAt = viewGroup;
        if (childCount > 0) {
            childAt = viewGroup.getChildAt(0);
        }
        final int[] iArrI = com.kwad.sdk.c.a.a.I(childAt);
        if (!l(adInfoEl) || iArrI == null) {
            return;
        }
        childAt.post(new bg() { // from class: com.kwad.components.ad.reward.b.c.1
            @Override // com.kwad.sdk.utils.bg
            public final void doTask() {
                com.kwad.sdk.core.d.c.d("RewardCouponDialogPresenter", "targetView x: " + iArrI[0] + ", y: " + iArrI[1]);
                b.a(c.this.getActivity(), c.this.mAdTemplate, c.this, iArrI);
                c.a(c.this, true);
            }
        });
    }
}
