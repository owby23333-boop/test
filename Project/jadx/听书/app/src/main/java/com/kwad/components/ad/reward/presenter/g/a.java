package com.kwad.components.ad.reward.presenter.g;

import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.kwad.components.ad.reward.e.l;
import com.kwad.components.ad.reward.g;
import com.kwad.components.ad.reward.n.c;
import com.kwad.components.ad.reward.n.e;
import com.kwad.components.ad.reward.n.q;
import com.kwad.sdk.R;
import com.kwad.sdk.core.view.AdBaseFrameLayout;
import com.kwad.sdk.core.webview.KsAdWebView;
import com.kwad.sdk.utils.aq;
import com.kwad.sdk.widget.KSFrameLayout;
import com.kwad.sdk.widget.d;
import com.kwad.sdk.widget.h;

/* JADX INFO: loaded from: classes3.dex */
public final class a extends com.kwad.components.ad.reward.presenter.b implements c.a, com.kwad.sdk.core.webview.d.a.a, d {
    private ViewGroup Ac;
    private q Ad;
    private ViewGroup Ae;
    private e Af;
    private c Ag;
    private c Ah;
    private final l mRewardVerifyListener = new l() { // from class: com.kwad.components.ad.reward.presenter.g.a.1
        @Override // com.kwad.components.ad.reward.e.l
        public final void onRewardVerify() {
            if (a.this.Ag != null) {
                a.this.Ag.la();
            }
            if (a.this.Ah != null) {
                a.this.Ah.la();
            }
        }
    };
    private com.kwad.components.ad.reward.l.a.a sn;

    @Override // com.kwad.sdk.core.webview.d.a.a
    public final void a(com.kwad.sdk.core.webview.d.b.a aVar) {
    }

    @Override // com.kwad.components.ad.reward.presenter.b, com.kwad.sdk.mvp.Presenter
    public final void at() {
        super.at();
        com.kwad.sdk.core.d.c.d("LandPageOpenTaskPresenter", "onBind");
        if (g.O(this.tm.mAdTemplate)) {
            this.sn = com.kwad.components.ad.reward.l.d.kJ();
            this.tm.sn = this.sn;
            com.kwad.components.ad.reward.b.gk().a(this.mRewardVerifyListener);
            AdBaseFrameLayout adBaseFrameLayout = (AdBaseFrameLayout) findViewById(R.id.ksad_root_container);
            ViewGroup viewGroup = (ViewGroup) findViewById(R.id.ksad_activity_apk_info_area_native);
            this.Ac = viewGroup;
            if (viewGroup != null) {
                viewGroup.setClickable(true);
                this.Ac.setVisibility(8);
                new h(this.Ac, this);
                c cVar = new c(this.Ac);
                this.Ah = cVar;
                cVar.a(this);
                this.Ah.c(this.tm.mAdTemplate, false);
                ((KSFrameLayout) findViewById(R.id.ksad_right_area_webview_container)).setWidthBasedRatio(false);
                q qVar = new q((KsAdWebView) findViewById(R.id.ksad_right_area_webview), this.Ac, null, this);
                this.Ad = qVar;
                qVar.a(this.tm.mAdTemplate, adBaseFrameLayout);
            }
            a(adBaseFrameLayout);
        }
    }

    private void a(AdBaseFrameLayout adBaseFrameLayout) {
        getContext();
        if (!aq.QW()) {
            com.kwad.sdk.core.d.c.d("LandPageOpenTaskPresenter", "initBottomActionBar screen is horizontal");
            return;
        }
        ((ViewStub) findViewById(R.id.ksad_reward_apk_info_stub)).inflate();
        KSFrameLayout kSFrameLayout = (KSFrameLayout) findViewById(R.id.ksad_reward_apk_info_card_root);
        kSFrameLayout.setRadius(getContext().getResources().getDimension(R.dimen.ksad_reward_apk_info_card_step_icon_radius));
        if (com.kwad.sdk.core.response.b.d.ec(this.tm.mAdTemplate).size() == 0) {
            kSFrameLayout.setRatio(0.0f);
            com.kwad.sdk.c.a.a.m(kSFrameLayout, com.kwad.sdk.c.a.a.a(getContext(), 136.0f));
        } else {
            kSFrameLayout.setRatio(0.0f);
            com.kwad.sdk.c.a.a.m(kSFrameLayout, com.kwad.sdk.c.a.a.a(getContext(), 155.0f));
        }
        ViewGroup viewGroup = (ViewGroup) findViewById(R.id.ksad_reward_apk_info_card_native_container);
        this.Ae = viewGroup;
        viewGroup.setClickable(true);
        new h(this.Ae, this);
        c cVar = new c(this.Ae);
        this.Ag = cVar;
        cVar.a(this);
        this.Ag.c(this.tm.mAdTemplate, true);
        e eVar = new e((KsAdWebView) findViewById(R.id.ksad_reward_apk_info_card_h5), this.Ae, null, this);
        this.Af = eVar;
        eVar.a(this.tm.mAdTemplate, adBaseFrameLayout);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
        com.kwad.sdk.core.d.c.d("LandPageOpenTaskPresenter", "onUnbind");
        e eVar = this.Af;
        if (eVar != null) {
            eVar.lc();
            this.Af = null;
        }
        c cVar = this.Ah;
        if (cVar != null) {
            cVar.kZ();
        }
        com.kwad.components.ad.reward.b.gk().b(this.mRewardVerifyListener);
        this.tm.sn = null;
    }

    @Override // com.kwad.components.ad.reward.n.c.a
    public final void d(boolean z, int i) {
        e(z, 1);
    }

    @Override // com.kwad.sdk.widget.d
    public final void a(View view) {
        e(view, true);
    }

    @Override // com.kwad.sdk.widget.d
    public final void b(View view) {
        if (com.kwad.sdk.core.response.b.d.ea(this.tm.mAdTemplate)) {
            e(view, false);
        }
    }

    private void e(View view, boolean z) {
        int id = view.getId();
        if (id == R.id.ksad_reward_apk_info_card_native_container || id == R.id.ksad_activity_apk_info_area_native) {
            e(z, 2);
        }
    }

    private void e(boolean z, int i) {
        this.tm.a(1, getContext(), z ? 1 : MediaPlayer.MEDIA_PLAYER_OPTION_GET_DROP_COUNT, i);
    }
}
