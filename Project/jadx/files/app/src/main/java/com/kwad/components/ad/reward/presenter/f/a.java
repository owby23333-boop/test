package com.kwad.components.ad.reward.presenter.f;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import androidx.annotation.Nullable;
import com.kwad.components.ad.reward.d.j;
import com.kwad.components.ad.reward.i.d;
import com.kwad.components.ad.reward.k.c;
import com.kwad.components.ad.reward.k.e;
import com.kwad.components.ad.reward.k.u;
import com.kwad.sdk.R;
import com.kwad.sdk.core.view.AdBaseFrameLayout;
import com.kwad.sdk.core.webview.KsAdWebView;
import com.kwad.sdk.utils.ah;
import com.kwad.sdk.widget.KSFrameLayout;
import com.kwad.sdk.widget.f;
import com.tencent.smtt.sdk.TbsListener;

/* JADX INFO: loaded from: classes3.dex */
public final class a extends com.kwad.components.ad.reward.presenter.a implements c.a, com.kwad.sdk.core.webview.c.kwai.a, com.kwad.sdk.widget.c {
    private final j mRewardVerifyListener = new j() { // from class: com.kwad.components.ad.reward.presenter.f.a.1
        @Override // com.kwad.components.ad.reward.d.j
        public final void onRewardVerify() {
            if (a.this.wX != null) {
                a.this.wX.kc();
            }
            if (a.this.wY != null) {
                a.this.wY.kc();
            }
        }
    };
    private com.kwad.components.ad.reward.i.kwai.a qd;

    @Nullable
    private ViewGroup wU;
    private ViewGroup wV;
    private e wW;
    private c wX;

    @Nullable
    private c wY;

    @Nullable
    private u wc;

    private void a(AdBaseFrameLayout adBaseFrameLayout) {
        Context context;
        float f2;
        if (!ah.cu(getContext())) {
            com.kwad.sdk.core.d.b.d("LandPageOpenTaskPresenter", "initBottomActionBar screen is horizontal");
            return;
        }
        ((ViewStub) findViewById(R.id.ksad_reward_apk_info_stub)).inflate();
        KSFrameLayout kSFrameLayout = (KSFrameLayout) findViewById(R.id.ksad_reward_apk_info_card_root);
        kSFrameLayout.setRadius(getContext().getResources().getDimension(R.dimen.ksad_reward_apk_info_card_step_icon_radius));
        int size = com.kwad.sdk.core.response.a.c.bS(this.qS.mAdTemplate).size();
        kSFrameLayout.setRatio(0.0f);
        if (size == 0) {
            context = getContext();
            f2 = 136.0f;
        } else {
            context = getContext();
            f2 = 155.0f;
        }
        com.kwad.sdk.b.kwai.a.n(kSFrameLayout, com.kwad.sdk.b.kwai.a.a(context, f2));
        this.wV = (ViewGroup) findViewById(R.id.ksad_reward_apk_info_card_native_container);
        this.wV.setClickable(true);
        new f(this.wV, this);
        this.wX = new c(this.wV);
        this.wX.a(this);
        this.wX.c(this.qS.mAdTemplate, true);
        this.wW = new e((KsAdWebView) findViewById(R.id.ksad_reward_apk_info_card_h5), this.wV, null, this);
        this.wW.a(this.qS.mAdTemplate, adBaseFrameLayout);
    }

    private void c(View view, boolean z2) {
        int id = view.getId();
        if (id == R.id.ksad_reward_apk_info_card_native_container || id == R.id.ksad_activity_apk_info_area_native) {
            d(z2, 2);
        }
    }

    private void d(boolean z2, int i2) {
        this.qS.a(1, getContext(), z2 ? 1 : TbsListener.ErrorCode.STARTDOWNLOAD_LOCKED_IO_FAILED, i2);
    }

    @Override // com.kwad.sdk.widget.c
    public final void a(View view) {
        c(view, true);
    }

    @Override // com.kwad.components.ad.reward.presenter.a, com.kwad.sdk.mvp.Presenter
    public final void ar() {
        super.ar();
        com.kwad.sdk.core.d.b.d("LandPageOpenTaskPresenter", "onBind");
        if (com.kwad.components.ad.reward.j.q(this.qS.mAdTemplate)) {
            this.qd = d.jM();
            this.qS.qd = this.qd;
            com.kwad.components.ad.reward.c.fD().a(this.mRewardVerifyListener);
            AdBaseFrameLayout adBaseFrameLayout = (AdBaseFrameLayout) findViewById(R.id.ksad_root_container);
            this.wU = (ViewGroup) findViewById(R.id.ksad_activity_apk_info_area_native);
            ViewGroup viewGroup = this.wU;
            if (viewGroup != null) {
                viewGroup.setClickable(true);
                this.wU.setVisibility(8);
                new f(this.wU, this);
                this.wY = new c(this.wU);
                this.wY.a(this);
                this.wY.c(this.qS.mAdTemplate, false);
                ((KSFrameLayout) findViewById(R.id.ksad_right_area_webview_container)).setWidthBasedRatio(false);
                this.wc = new u((KsAdWebView) findViewById(R.id.ksad_right_area_webview), this.wU, null, this);
                this.wc.a(this.qS.mAdTemplate, adBaseFrameLayout);
            }
            a(adBaseFrameLayout);
        }
    }

    @Override // com.kwad.sdk.widget.c
    public final void b(View view) {
        if (com.kwad.sdk.core.response.a.c.bQ(this.qS.mAdTemplate)) {
            c(view, false);
        }
    }

    @Override // com.kwad.components.ad.reward.k.c.a
    public final void c(boolean z2, int i2) {
        d(z2, 1);
    }

    @Override // com.kwad.sdk.core.webview.c.kwai.a
    public final void onAdClicked(@Nullable com.kwad.sdk.core.webview.c.a.a aVar) {
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
        com.kwad.sdk.core.d.b.d("LandPageOpenTaskPresenter", "onUnbind");
        e eVar = this.wW;
        if (eVar != null) {
            eVar.ke();
            this.wW = null;
        }
        c cVar = this.wY;
        if (cVar != null) {
            cVar.kb();
        }
        com.kwad.components.ad.reward.c.fD().b(this.mRewardVerifyListener);
        this.qS.qd = null;
    }
}
