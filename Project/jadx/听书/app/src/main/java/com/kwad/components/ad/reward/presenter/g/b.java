package com.kwad.components.ad.reward.presenter.g;

import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.kwad.components.ad.reward.e.l;
import com.kwad.components.ad.reward.g;
import com.kwad.components.ad.reward.n.c;
import com.kwad.components.ad.reward.n.e;
import com.kwad.components.ad.reward.n.f;
import com.kwad.components.ad.reward.n.q;
import com.kwad.sdk.R;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.view.AdBaseFrameLayout;
import com.kwad.sdk.core.webview.KsAdWebView;
import com.kwad.sdk.utils.ac;
import com.kwad.sdk.utils.aq;
import com.kwad.sdk.utils.bg;
import com.kwad.sdk.widget.KSFrameLayout;
import com.kwad.sdk.widget.d;
import com.kwad.sdk.widget.h;

/* JADX INFO: loaded from: classes3.dex */
public final class b extends com.kwad.components.ad.reward.presenter.b implements c.a, com.kwad.sdk.app.a, com.kwad.sdk.core.webview.d.a.a, d {
    private static float Aj = 0.4548105f;
    private ViewGroup Ac;
    private q Ad;
    private ViewGroup Ae;
    private e Af;
    private c Ag;
    private c Ah;
    private AdInfo mAdInfo;
    private com.kwad.components.ad.reward.l.b.a sm;
    private int Ak = 15;
    private long Al = -1;
    private boolean Am = false;
    private final l mRewardVerifyListener = new l() { // from class: com.kwad.components.ad.reward.presenter.g.b.3
        @Override // com.kwad.components.ad.reward.e.l
        public final void onRewardVerify() {
            if (b.this.Ag != null && g.P(b.this.tm.mAdTemplate)) {
                b.this.Ag.la();
            }
            if (b.this.Ah != null) {
                b.this.Ah.la();
            }
        }
    };
    private com.kwad.sdk.core.c.c An = new com.kwad.sdk.core.c.d() { // from class: com.kwad.components.ad.reward.presenter.g.b.4
        @Override // com.kwad.sdk.core.c.d, com.kwad.sdk.core.c.c
        public final void onBackToForeground() {
            super.onBackToForeground();
            b.this.X(true);
        }

        @Override // com.kwad.sdk.core.c.d, com.kwad.sdk.core.c.c
        public final void onBackToBackground() {
            super.onBackToBackground();
            b.this.X(false);
        }
    };

    @Override // com.kwad.sdk.app.a
    public final void V(String str) {
    }

    @Override // com.kwad.sdk.core.webview.d.a.a
    public final void a(com.kwad.sdk.core.webview.d.b.a aVar) {
    }

    @Override // com.kwad.components.ad.reward.presenter.b, com.kwad.sdk.mvp.Presenter
    public final void at() {
        super.at();
        com.kwad.sdk.core.d.c.d("LaunchAppTaskPresenter", "onBind");
        if (g.N(this.tm.mAdTemplate)) {
            this.mAdInfo = com.kwad.sdk.core.response.b.e.el(this.tm.mAdTemplate);
            this.Ak = com.kwad.components.ad.reward.a.b.hB();
            com.kwad.sdk.core.c.b.Ho();
            com.kwad.sdk.core.c.b.a(this.An);
            com.kwad.components.ad.reward.b.gk().a(this.mRewardVerifyListener);
            this.sm = com.kwad.components.ad.reward.l.d.kI();
            this.tm.sm = this.sm;
            com.kwad.components.ad.reward.l.b.a.a(this.sm, getContext(), this.tm.mAdTemplate);
            AdBaseFrameLayout adBaseFrameLayout = (AdBaseFrameLayout) findViewById(R.id.ksad_root_container);
            ViewGroup viewGroup = (ViewGroup) findViewById(R.id.ksad_activity_apk_info_area_native);
            this.Ac = viewGroup;
            if (viewGroup != null) {
                viewGroup.setVisibility(8);
                c cVar = new c(this.Ac);
                this.Ah = cVar;
                cVar.a(this.tm.mApkDownloadHelper);
                this.Ah.a(this);
                this.Ah.c(this.tm.mAdTemplate, false);
                ((KSFrameLayout) findViewById(R.id.ksad_right_area_webview_container)).setWidthBasedRatio(false);
                q qVar = new q((KsAdWebView) findViewById(R.id.ksad_right_area_webview), this.Ac, this.tm.mApkDownloadHelper, this);
                this.Ad = qVar;
                qVar.a(this.tm.mAdTemplate, adBaseFrameLayout);
            }
            com.kwad.sdk.app.b.Dw().a(this);
            a(adBaseFrameLayout);
        }
    }

    private void a(AdBaseFrameLayout adBaseFrameLayout) {
        getContext();
        if (!aq.QW()) {
            com.kwad.sdk.core.d.c.d("LaunchAppTaskPresenter", "initBottomActionBar screen is horizontal");
            return;
        }
        ((ViewStub) findViewById(R.id.ksad_reward_apk_info_stub)).inflate();
        ViewGroup viewGroup = (ViewGroup) findViewById(R.id.ksad_reward_apk_info_card_native_container);
        this.Ae = viewGroup;
        viewGroup.setClickable(true);
        new h(this.Ae, this);
        final KSFrameLayout kSFrameLayout = (KSFrameLayout) findViewById(R.id.ksad_reward_apk_info_card_root);
        kSFrameLayout.setRadius(getContext().getResources().getDimension(R.dimen.ksad_reward_apk_info_card_step_icon_radius));
        final float dimension = getContext().getResources().getDimension(R.dimen.ksad_reward_apk_info_card_height);
        kSFrameLayout.post(new bg() { // from class: com.kwad.components.ad.reward.presenter.g.b.1
            @Override // com.kwad.sdk.utils.bg
            public final void doTask() {
                kSFrameLayout.getHeight();
            }
        });
        this.Ae = (ViewGroup) findViewById(R.id.ksad_reward_apk_info_card_native_container);
        c cVar = new c(this.Ae);
        this.Ag = cVar;
        cVar.a(this.tm.mApkDownloadHelper);
        this.Ag.a(this);
        this.Ag.c(this.tm.mAdTemplate, false);
        e eVar = new e((KsAdWebView) findViewById(R.id.ksad_reward_apk_info_card_h5), this.Ae, this.tm.mApkDownloadHelper, this);
        this.Af = eVar;
        eVar.a(new f() { // from class: com.kwad.components.ad.reward.presenter.g.b.2
            @Override // com.kwad.components.ad.reward.n.f
            public final void i(String str, int i) {
                com.kwad.sdk.core.d.c.d("LaunchAppTaskPresenter", "onUpdateDownloadProgress downloadStatus: " + com.kwad.sdk.core.response.b.e.el(b.this.tm.mAdTemplate).status);
                b.this.Ag.j(str, i);
            }
        });
        this.Af.a(this.tm.mAdTemplate, adBaseFrameLayout);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
        com.kwad.sdk.core.d.c.d("LaunchAppTaskPresenter", "onUnbind");
        com.kwad.sdk.core.c.b.Ho();
        com.kwad.sdk.core.c.b.b(this.An);
        com.kwad.components.ad.reward.b.gk().b(this.mRewardVerifyListener);
        com.kwad.sdk.app.b.Dw().b(this);
        e eVar = this.Af;
        if (eVar != null) {
            eVar.lc();
            this.Af = null;
        }
        c cVar = this.Ah;
        if (cVar != null) {
            cVar.kZ();
        }
        this.tm.sm = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void X(boolean z) {
        com.kwad.components.ad.reward.l.b.a aVar;
        com.kwad.components.ad.reward.l.b.a.a(this.sm, getContext(), this.tm.mAdTemplate);
        if (!this.sm.kQ()) {
            if (z) {
                Y(false);
            }
        } else {
            if (z) {
                boolean zKn = kn();
                if (zKn && (aVar = this.sm) != null) {
                    aVar.kP();
                    com.kwad.components.ad.reward.b.gk().notifyRewardVerify();
                    this.tm.rD.onRewardVerify();
                }
                Y(zKn);
                return;
            }
            this.Al = System.currentTimeMillis();
        }
    }

    private void Y(boolean z) {
        com.kwad.sdk.core.d.c.d("LaunchAppTaskPresenter", "showTaskToast hasShowCompletedToast: " + this.Am + " completed: " + z);
        if (this.Am) {
            return;
        }
        ac.c(getContext(), z ? "恭喜！任务达标啦，成功获取奖励~" : "哎呀，差一点就达标啦，再试一次~", 0);
        if (z) {
            this.Am = true;
        }
    }

    private boolean kn() {
        com.kwad.sdk.core.d.c.d("LaunchAppTaskPresenter", "checkUseAppTime appBackgroundTimestamp: " + this.Al);
        return this.Al >= 0 && System.currentTimeMillis() - this.Al > ((long) (this.Ak * 1000));
    }

    @Override // com.kwad.components.ad.reward.n.c.a
    public final void d(boolean z, int i) {
        this.tm.b(1, getContext(), z ? 1 : MediaPlayer.MEDIA_PLAYER_OPTION_GET_DROP_COUNT, 1);
    }

    @Override // com.kwad.sdk.app.a
    public final void U(String str) {
        if (TextUtils.equals(com.kwad.sdk.core.response.b.a.ay(this.mAdInfo), str) && this.tm.sm != null && g.N(this.tm.mAdTemplate)) {
            this.tm.sm.kN();
            com.kwad.sdk.core.c.b.Ho();
            if (com.kwad.sdk.core.c.b.isAppOnForeground()) {
                return;
            }
            this.Al = System.currentTimeMillis();
        }
    }

    @Override // com.kwad.sdk.widget.d
    public final void a(View view) {
        Z(true);
    }

    @Override // com.kwad.sdk.widget.d
    public final void b(View view) {
        if (com.kwad.sdk.core.response.b.d.ea(this.tm.mAdTemplate)) {
            Z(false);
        }
    }

    private void Z(boolean z) {
        this.tm.a(1, getContext(), z ? 1 : MediaPlayer.MEDIA_PLAYER_OPTION_GET_DROP_COUNT, 1);
    }
}
