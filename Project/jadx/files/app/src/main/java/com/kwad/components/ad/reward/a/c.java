package com.kwad.components.ad.reward.a;

import android.view.ViewGroup;
import com.kwad.components.ad.reward.a.b;
import com.kwad.sdk.R;
import com.kwad.sdk.core.response.a.d;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdProductInfo;
import com.kwad.sdk.core.response.model.AdTemplate;

/* JADX INFO: loaded from: classes3.dex */
public final class c extends com.kwad.components.ad.reward.presenter.a implements b.a {
    private AdTemplate mAdTemplate;
    private boolean rH = false;

    static /* synthetic */ boolean a(c cVar, boolean z2) {
        cVar.rH = true;
        return true;
    }

    private static boolean m(AdInfo adInfo) {
        AdProductInfo adProductInfoCr = com.kwad.sdk.core.response.a.a.cr(adInfo);
        return (!com.kwad.components.ad.reward.kwai.b.j(adInfo) || adProductInfoCr == null || adProductInfoCr.isCouponListEmpty()) ? false : true;
    }

    @Override // com.kwad.components.ad.reward.presenter.a, com.kwad.sdk.mvp.Presenter
    public final void ar() {
        super.ar();
        this.mAdTemplate = this.qS.mAdTemplate;
    }

    @Override // com.kwad.components.ad.reward.a.b.a
    public final void hg() {
        this.qS.a(1, getContext(), 29, 1);
    }

    public final void showDialog() {
        com.kwad.sdk.core.d.b.d("RewardCouponDialogPresenter", "onBind hasShown : " + this.rH);
        if (this.rH) {
            return;
        }
        AdInfo adInfoCb = d.cb(this.mAdTemplate);
        ViewGroup viewGroup = (ViewGroup) this.qS.mRootContainer.findViewById(R.id.ksad_reward_order_coupon_list);
        if (viewGroup == null) {
            return;
        }
        int childCount = viewGroup.getChildCount();
        ViewGroup childAt = viewGroup;
        if (childCount > 0) {
            childAt = viewGroup.getChildAt(0);
        }
        final int[] iArrF = com.kwad.sdk.b.kwai.a.F(childAt);
        if (!m(adInfoCb) || iArrF == null) {
            return;
        }
        childAt.post(new Runnable() { // from class: com.kwad.components.ad.reward.a.c.1
            @Override // java.lang.Runnable
            public final void run() {
                com.kwad.sdk.core.d.b.d("RewardCouponDialogPresenter", "targetView x: " + iArrF[0] + ", y: " + iArrF[1]);
                b.a(c.this.getActivity(), c.this.mAdTemplate, c.this, iArrF);
                c.a(c.this, true);
            }
        });
    }
}
