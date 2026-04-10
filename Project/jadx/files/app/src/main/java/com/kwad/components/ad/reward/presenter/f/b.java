package com.kwad.components.ad.reward.presenter.f;

import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import androidx.annotation.Nullable;
import com.kwad.components.ad.reward.d.j;
import com.kwad.components.ad.reward.k.c;
import com.kwad.components.ad.reward.k.e;
import com.kwad.components.ad.reward.k.u;
import com.kwad.components.core.r.f;
import com.kwad.sdk.R;
import com.kwad.sdk.core.b.d;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.view.AdBaseFrameLayout;
import com.kwad.sdk.core.webview.KsAdWebView;
import com.kwad.sdk.utils.ah;
import com.kwad.sdk.widget.KSFrameLayout;
import com.tencent.smtt.sdk.TbsListener;

/* JADX INFO: loaded from: classes3.dex */
public final class b extends com.kwad.components.ad.reward.presenter.a implements c.a, f.a, com.kwad.sdk.core.webview.c.kwai.a, com.kwad.sdk.widget.c {
    private static float xa = 0.4548105f;
    private com.kwad.components.ad.reward.i.a.a qc;
    private f sz;

    @Nullable
    private ViewGroup wU;
    private ViewGroup wV;
    private e wW;
    private c wX;

    @Nullable
    private c wY;

    @Nullable
    private u wc;
    private int xb = 15;
    private long xc = -1;
    private boolean xd = false;
    private final j mRewardVerifyListener = new j() { // from class: com.kwad.components.ad.reward.presenter.f.b.3
        @Override // com.kwad.components.ad.reward.d.j
        public final void onRewardVerify() {
            if (b.this.wX != null && com.kwad.components.ad.reward.j.r(b.this.qS.mAdTemplate)) {
                b.this.wX.kc();
            }
            if (b.this.wY != null) {
                b.this.wY.kc();
            }
        }
    };
    private com.kwad.sdk.core.b.c xe = new d() { // from class: com.kwad.components.ad.reward.presenter.f.b.4
        @Override // com.kwad.sdk.core.b.d, com.kwad.sdk.core.b.c
        public final void onBackToBackground() {
            super.onBackToBackground();
            b.this.aa(false);
        }

        @Override // com.kwad.sdk.core.b.d, com.kwad.sdk.core.b.c
        public final void onBackToForeground() {
            super.onBackToForeground();
            b.this.aa(true);
        }
    };

    private void a(AdBaseFrameLayout adBaseFrameLayout) {
        if (!ah.cu(getContext())) {
            com.kwad.sdk.core.d.b.d("LaunchAppTaskPresenter", "initBottomActionBar screen is horizontal");
            return;
        }
        ((ViewStub) findViewById(R.id.ksad_reward_apk_info_stub)).inflate();
        this.wV = (ViewGroup) findViewById(R.id.ksad_reward_apk_info_card_native_container);
        this.wV.setClickable(true);
        new com.kwad.sdk.widget.f(this.wV, this);
        final KSFrameLayout kSFrameLayout = (KSFrameLayout) findViewById(R.id.ksad_reward_apk_info_card_root);
        kSFrameLayout.setRadius(getContext().getResources().getDimension(R.dimen.ksad_reward_apk_info_card_step_icon_radius));
        final float dimension = getContext().getResources().getDimension(R.dimen.ksad_reward_apk_info_card_height);
        kSFrameLayout.post(new Runnable() { // from class: com.kwad.components.ad.reward.presenter.f.b.1
            @Override // java.lang.Runnable
            public final void run() {
                kSFrameLayout.getHeight();
            }
        });
        this.wV = (ViewGroup) findViewById(R.id.ksad_reward_apk_info_card_native_container);
        this.wX = new c(this.wV);
        this.wX.a(this.qS.mApkDownloadHelper);
        this.wX.a(this);
        this.wX.c(this.qS.mAdTemplate, false);
        this.wW = new e((KsAdWebView) findViewById(R.id.ksad_reward_apk_info_card_h5), this.wV, this.qS.mApkDownloadHelper, this);
        this.wW.a(new com.kwad.components.ad.reward.k.f() { // from class: com.kwad.components.ad.reward.presenter.f.b.2
            @Override // com.kwad.components.ad.reward.k.f
            public final void i(String str, int i2) {
                com.kwad.sdk.core.d.b.d("LaunchAppTaskPresenter", "onUpdateDownloadProgress downloadStatus: " + com.kwad.sdk.core.response.a.d.cb(b.this.qS.mAdTemplate).status);
                b.this.wX.j(str, i2);
            }
        });
        this.wW.a(this.qS.mAdTemplate, adBaseFrameLayout);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aa(boolean z2) {
        com.kwad.components.ad.reward.i.a.a aVar;
        com.kwad.components.ad.reward.i.a.a.a(this.qc, getContext(), this.qS.mAdTemplate);
        if (!this.qc.jT()) {
            if (z2) {
                ab(false);
            }
        } else {
            if (!z2) {
                this.xc = System.currentTimeMillis();
                return;
            }
            boolean zJs = js();
            if (zJs && (aVar = this.qc) != null) {
                aVar.jS();
                com.kwad.components.ad.reward.c.fD().notifyRewardVerify();
                this.qS.mAdOpenInteractionListener.onRewardVerify();
            }
            ab(zJs);
        }
    }

    private void ab(boolean z2) {
        com.kwad.sdk.core.d.b.d("LaunchAppTaskPresenter", "showTaskToast hasShowCompletedToast: " + this.xd + " completed: " + z2);
        if (this.xd) {
            return;
        }
        com.kwad.sdk.utils.u.d(getContext(), z2 ? "恭喜！任务达标啦，成功获取奖励~" : "哎呀，差一点就达标啦，再试一次~", 0);
        if (z2) {
            this.xd = true;
        }
    }

    private void ac(boolean z2) {
        this.qS.a(1, getContext(), z2 ? 1 : TbsListener.ErrorCode.STARTDOWNLOAD_LOCKED_IO_FAILED, 1);
    }

    private boolean js() {
        com.kwad.sdk.core.d.b.d("LaunchAppTaskPresenter", "checkUseAppTime appBackgroundTimestamp: " + this.xc);
        return this.xc >= 0 && System.currentTimeMillis() - this.xc > ((long) (this.xb * 1000));
    }

    @Override // com.kwad.sdk.widget.c
    public final void a(View view) {
        ac(true);
    }

    @Override // com.kwad.components.ad.reward.presenter.a, com.kwad.sdk.mvp.Presenter
    public final void ar() {
        super.ar();
        com.kwad.sdk.core.d.b.d("LaunchAppTaskPresenter", "onBind");
        if (com.kwad.components.ad.reward.j.p(this.qS.mAdTemplate)) {
            this.xb = com.kwad.components.ad.reward.kwai.b.gQ();
            com.kwad.sdk.core.b.b.we();
            com.kwad.sdk.core.b.b.a(this.xe);
            com.kwad.components.ad.reward.c.fD().a(this.mRewardVerifyListener);
            this.qc = com.kwad.components.ad.reward.i.d.jL();
            com.kwad.components.ad.reward.j jVar = this.qS;
            com.kwad.components.ad.reward.i.a.a aVar = this.qc;
            jVar.qc = aVar;
            com.kwad.components.ad.reward.i.a.a.a(aVar, getContext(), this.qS.mAdTemplate);
            AdBaseFrameLayout adBaseFrameLayout = (AdBaseFrameLayout) findViewById(R.id.ksad_root_container);
            this.wU = (ViewGroup) findViewById(R.id.ksad_activity_apk_info_area_native);
            ViewGroup viewGroup = this.wU;
            if (viewGroup != null) {
                viewGroup.setVisibility(8);
                this.wY = new c(this.wU);
                this.wY.a(this.qS.mApkDownloadHelper);
                this.wY.a(this);
                this.wY.c(this.qS.mAdTemplate, false);
                ((KSFrameLayout) findViewById(R.id.ksad_right_area_webview_container)).setWidthBasedRatio(false);
                this.wc = new u((KsAdWebView) findViewById(R.id.ksad_right_area_webview), this.wU, this.qS.mApkDownloadHelper, this);
                this.wc.a(this.qS.mAdTemplate, adBaseFrameLayout);
            }
            AdInfo adInfoCb = com.kwad.sdk.core.response.a.d.cb(this.qS.mAdTemplate);
            f fVar = this.sz;
            if (fVar == null) {
                this.sz = new f(com.kwad.sdk.core.response.a.a.ar(adInfoCb));
            } else {
                fVar.ay(com.kwad.sdk.core.response.a.a.ar(adInfoCb));
            }
            this.sz.a(getContext(), this);
            a(adBaseFrameLayout);
        }
    }

    @Override // com.kwad.sdk.widget.c
    public final void b(View view) {
        if (com.kwad.sdk.core.response.a.c.bQ(this.qS.mAdTemplate)) {
            ac(false);
        }
    }

    @Override // com.kwad.components.ad.reward.k.c.a
    public final void c(boolean z2, int i2) {
        this.qS.b(1, getContext(), z2 ? 1 : TbsListener.ErrorCode.STARTDOWNLOAD_LOCKED_IO_FAILED, 1);
    }

    @Override // com.kwad.components.core.r.f.a
    public final void hM() {
        com.kwad.components.ad.reward.j jVar = this.qS;
        if (jVar.qc == null || !com.kwad.components.ad.reward.j.p(jVar.mAdTemplate)) {
            return;
        }
        this.qS.qc.jQ();
        com.kwad.sdk.core.b.b.we();
        if (com.kwad.sdk.core.b.b.isAppOnForeground()) {
            return;
        }
        this.xc = System.currentTimeMillis();
    }

    @Override // com.kwad.sdk.core.webview.c.kwai.a
    public final void onAdClicked(@Nullable com.kwad.sdk.core.webview.c.a.a aVar) {
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
        com.kwad.sdk.core.d.b.d("LaunchAppTaskPresenter", "onUnbind");
        com.kwad.sdk.core.b.b.we();
        com.kwad.sdk.core.b.b.b(this.xe);
        com.kwad.components.ad.reward.c.fD().b(this.mRewardVerifyListener);
        f fVar = this.sz;
        if (fVar != null) {
            fVar.as(getContext());
        }
        e eVar = this.wW;
        if (eVar != null) {
            eVar.ke();
            this.wW = null;
        }
        c cVar = this.wY;
        if (cVar != null) {
            cVar.kb();
        }
        this.qS.qc = null;
    }
}
