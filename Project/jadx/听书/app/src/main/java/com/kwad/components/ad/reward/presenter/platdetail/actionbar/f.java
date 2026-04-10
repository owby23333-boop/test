package com.kwad.components.ad.reward.presenter.platdetail.actionbar;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.os.SystemClock;
import android.view.animation.DecelerateInterpolator;
import com.kwad.components.ad.reward.e.g;
import com.kwad.components.ad.reward.k.q;
import com.kwad.components.ad.reward.presenter.platdetail.actionbar.RewardActionBarControl;
import com.kwad.components.core.playable.PlayableSource;
import com.kwad.components.core.webview.jshandler.ac;
import com.kwad.components.core.webview.jshandler.ae;
import com.kwad.components.core.webview.jshandler.af;
import com.kwad.components.core.webview.jshandler.ai;
import com.kwad.components.core.webview.jshandler.ak;
import com.kwad.components.core.webview.jshandler.al;
import com.kwad.components.core.webview.jshandler.am;
import com.kwad.components.core.webview.jshandler.as;
import com.kwad.components.core.webview.jshandler.az;
import com.kwad.components.core.webview.jshandler.bc;
import com.kwad.components.core.webview.jshandler.n;
import com.kwad.components.core.webview.jshandler.o;
import com.kwad.components.core.widget.KsLogoView;
import com.kwad.sdk.R;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.webview.KsAdWebView;
import com.kwad.sdk.utils.aq;

/* JADX INFO: loaded from: classes3.dex */
public final class f extends com.kwad.components.ad.reward.presenter.b {
    private KsAdWebView eN;
    private al.a eO;
    private com.kwad.components.core.webview.a eP;
    private com.kwad.sdk.core.webview.b eQ;
    private az eS;
    private ValueAnimator eX;
    private ValueAnimator eY;
    private com.kwad.components.core.e.d.c mApkDownloadHelper;
    private String mUrl;
    private RewardActionBarControl rG;
    private KsLogoView vN;
    private boolean yu;
    private long yv;
    private int eR = -1;
    private RewardActionBarControl.d yc = new RewardActionBarControl.d() { // from class: com.kwad.components.ad.reward.presenter.platdetail.actionbar.f.1
        @Override // com.kwad.components.ad.reward.presenter.platdetail.actionbar.RewardActionBarControl.d
        public final boolean f(a aVar) {
            f fVar = f.this;
            fVar.yu = fVar.f(aVar);
            return f.this.yu;
        }
    };
    private g mPlayEndPageListener = new com.kwad.components.ad.reward.e.a() { // from class: com.kwad.components.ad.reward.presenter.platdetail.actionbar.f.2
        @Override // com.kwad.components.ad.reward.e.g
        public final void cX() {
            f.this.release();
        }
    };
    private com.kwad.sdk.core.webview.d.a.a eT = new com.kwad.sdk.core.webview.d.a.a() { // from class: com.kwad.components.ad.reward.presenter.platdetail.actionbar.f.3
        @Override // com.kwad.sdk.core.webview.d.a.a
        public final void a(com.kwad.sdk.core.webview.d.b.a aVar) {
            f.this.tm.rD.cW();
        }
    };
    private al.b eU = new al.b() { // from class: com.kwad.components.ad.reward.presenter.platdetail.actionbar.f.5
        @Override // com.kwad.components.core.webview.jshandler.al.b
        public final void a(al.a aVar) {
            f.this.eO = aVar;
            f.this.eN.setTranslationY(aVar.height + aVar.bottomMargin);
        }
    };
    private ak.b eV = new ak.b() { // from class: com.kwad.components.ad.reward.presenter.platdetail.actionbar.f.6
        @Override // com.kwad.components.core.webview.jshandler.ak.b
        public final void a(ak.a aVar) {
            f.this.yu = false;
            f.this.bj();
        }
    };
    private as.b eW = new as.b() { // from class: com.kwad.components.ad.reward.presenter.platdetail.actionbar.f.7
        @Override // com.kwad.components.core.webview.jshandler.as.b
        public final void a(as.a aVar) {
            f.this.eR = aVar.status;
            long jElapsedRealtime = SystemClock.elapsedRealtime() - f.this.yv;
            com.kwad.sdk.core.d.c.i("RewardActionBarWeb", "load time:" + jElapsedRealtime + ", pageStatus: " + f.this.eR);
            if (f.this.eR == 1) {
                com.kwad.components.core.p.a.se().i(f.this.tm.mAdTemplate, jElapsedRealtime);
            } else {
                com.kwad.components.ad.reward.monitor.c.a(f.this.tm.mAdTemplate, f.this.tm.rS, "play_card", com.kwad.sdk.core.response.b.b.cw(f.this.tm.mAdTemplate), System.currentTimeMillis() - f.this.eN.getLoadTime(), 3);
            }
            if (f.this.tm.gM()) {
                return;
            }
            f.this.rG.jq();
        }
    };

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        super.onCreate();
        this.eN = (KsAdWebView) findViewById(R.id.ksad_play_web_card_webView);
        this.vN = (KsLogoView) findViewById(R.id.ksad_ad_label_play_bar);
    }

    @Override // com.kwad.components.ad.reward.presenter.b, com.kwad.sdk.mvp.Presenter
    public final void at() {
        super.at();
        com.kwad.components.ad.reward.monitor.c.a(this.tm.rS, "play_card");
        RewardActionBarControl rewardActionBarControl = this.tm.rG;
        this.rG = rewardActionBarControl;
        rewardActionBarControl.a(this.yc);
        dm();
    }

    private void dm() {
        if (this.eN == null || !com.kwad.sdk.core.response.b.b.cy(this.tm.mAdTemplate)) {
            return;
        }
        this.mApkDownloadHelper = this.tm.mApkDownloadHelper;
        bc();
        bd();
        this.tm.b(this.mPlayEndPageListener);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
        RewardActionBarControl rewardActionBarControl = this.rG;
        if (rewardActionBarControl != null) {
            rewardActionBarControl.a((RewardActionBarControl.d) null);
        }
        this.tm.c(this.mPlayEndPageListener);
        bl();
        release();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void release() {
        this.eR = -1;
        KsAdWebView ksAdWebView = this.eN;
        if (ksAdWebView != null) {
            ksAdWebView.setVisibility(8);
        }
        bf();
    }

    private void bc() {
        com.kwad.sdk.core.webview.b bVar = new com.kwad.sdk.core.webview.b();
        this.eQ = bVar;
        bVar.setAdTemplate(this.tm.mAdTemplate);
        this.eQ.mScreenOrientation = this.tm.mScreenOrientation;
        this.eQ.aMN = this.tm.mRootContainer;
        this.eQ.TG = this.tm.mRootContainer;
        this.eQ.Ta = this.eN;
    }

    private void bd() {
        this.eR = -1;
        be();
        this.eN.setBackgroundColor(0);
        this.eN.getBackground().setAlpha(0);
        this.eN.setVisibility(4);
        this.eN.setClientConfig(this.eN.getClientConfig().eJ(this.tm.mAdTemplate).b(ju()));
        this.yv = SystemClock.elapsedRealtime();
        this.mUrl = com.kwad.sdk.core.response.b.b.cw(this.tm.mAdTemplate);
        com.kwad.sdk.core.d.c.d("RewardActionBarWeb", "startPreloadWebView url: " + this.mUrl);
        com.kwad.components.ad.reward.monitor.c.a(this.tm.mAdTemplate, this.tm.rS, "play_card", this.mUrl);
        this.eN.loadUrl(this.mUrl);
    }

    private KsAdWebView.e ju() {
        return new KsAdWebView.e() { // from class: com.kwad.components.ad.reward.presenter.platdetail.actionbar.f.4
            @Override // com.kwad.sdk.core.webview.KsAdWebView.e
            public final void onPageStart() {
            }

            @Override // com.kwad.sdk.core.webview.KsAdWebView.e
            public final void onReceivedHttpError(int i, String str, String str2) {
                com.kwad.components.ad.reward.monitor.c.a(f.this.tm.mAdTemplate, f.this.tm.rS, "play_card", com.kwad.sdk.core.response.b.b.cw(f.this.tm.mAdTemplate), System.currentTimeMillis() - f.this.eN.getLoadTime(), 2);
            }

            @Override // com.kwad.sdk.core.webview.KsAdWebView.e
            public final void onPageFinished() {
                com.kwad.components.ad.reward.monitor.c.a(f.this.tm.rS, "play_card", f.this.mUrl, System.currentTimeMillis() - f.this.eN.getLoadTime());
            }
        };
    }

    private void be() {
        bf();
        com.kwad.components.core.webview.a aVar = new com.kwad.components.core.webview.a(this.eN);
        this.eP = aVar;
        a(aVar);
        this.eN.addJavascriptInterface(this.eP, "KwaiAd");
    }

    private void bf() {
        com.kwad.components.core.webview.a aVar = this.eP;
        if (aVar != null) {
            aVar.destroy();
            this.eP = null;
        }
    }

    private void a(com.kwad.components.core.webview.a aVar) {
        aVar.a(new ac(this.eQ, this.mApkDownloadHelper, this.eT, (byte) 0));
        aVar.a(new com.kwad.components.core.webview.tachikoma.b.f());
        aVar.a(new q(this.eQ, this.mApkDownloadHelper, this.tm, -1L, this.eT, null));
        aVar.a(new af(this.eQ));
        aVar.a(new ai(this.eQ));
        aVar.a(new ae(this.eQ));
        aVar.a(new al(this.eQ, this.eU));
        aVar.a(new as(this.eW, com.kwad.sdk.core.response.b.b.cw(this.tm.mAdTemplate)));
        az azVar = new az();
        this.eS = azVar;
        aVar.a(azVar);
        aVar.a(new bc(this.eQ, this.mApkDownloadHelper));
        aVar.a(new ak(this.eV));
        aVar.a(new am(this.eQ));
        aVar.b(new o(this.eQ));
        aVar.b(new n(this.eQ));
        aVar.a(new com.kwad.components.ad.reward.i.b(getContext(), this.tm.mAdTemplate, PlayableSource.ACTIONBAR_CLICK));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean f(a aVar) {
        KsAdWebView ksAdWebView = this.eN;
        if (ksAdWebView == null) {
            return false;
        }
        if (ksAdWebView.getVisibility() == 0) {
            return true;
        }
        if (this.eR == 1) {
            g(aVar);
            return true;
        }
        bm();
        return false;
    }

    private void g(final a aVar) {
        if (this.eO == null) {
            bi();
            return;
        }
        X(this.tm.mAdTemplate);
        bl();
        this.eN.setVisibility(0);
        ValueAnimator valueAnimatorC = com.kwad.components.core.t.o.c(this.eN, this.eO.height + this.eO.bottomMargin, 0);
        this.eX = valueAnimatorC;
        valueAnimatorC.setInterpolator(new DecelerateInterpolator(2.0f));
        this.eX.setDuration(500L);
        this.eX.addListener(new AnimatorListenerAdapter() { // from class: com.kwad.components.ad.reward.presenter.platdetail.actionbar.f.8
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public final void onAnimationStart(Animator animator) {
                super.onAnimationStart(animator);
                if (f.this.eS != null) {
                    f.this.eS.uF();
                }
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public final void onAnimationEnd(Animator animator) {
                super.onAnimationEnd(animator);
                if (f.this.eS != null) {
                    f.this.eS.uG();
                }
                a aVar2 = aVar;
                if (aVar2 != null) {
                    aVar2.a(RewardActionBarControl.ShowActionBarResult.SHOW_H5_SUCCESS, f.this.eN);
                }
            }
        });
        this.eX.start();
    }

    private void bi() {
        X(this.tm.mAdTemplate);
        az azVar = this.eS;
        if (azVar != null) {
            azVar.uF();
        }
        this.eN.setVisibility(0);
        az azVar2 = this.eS;
        if (azVar2 != null) {
            azVar2.uG();
        }
    }

    private void X(AdTemplate adTemplate) {
        KsLogoView ksLogoView;
        if (!com.kwad.sdk.core.response.b.a.cL(com.kwad.sdk.core.response.b.e.el(adTemplate)) || aq.isOrientationPortrait() || (ksLogoView = this.vN) == null) {
            return;
        }
        ksLogoView.setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bj() {
        if (this.eN.getVisibility() != 0) {
            return;
        }
        if (this.eO == null) {
            bk();
            return;
        }
        bl();
        ValueAnimator valueAnimatorC = com.kwad.components.core.t.o.c(this.eN, 0, this.eO.height + this.eO.bottomMargin);
        this.eY = valueAnimatorC;
        valueAnimatorC.setInterpolator(new DecelerateInterpolator(2.0f));
        this.eY.setDuration(300L);
        this.eY.addListener(new AnimatorListenerAdapter() { // from class: com.kwad.components.ad.reward.presenter.platdetail.actionbar.f.9
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public final void onAnimationStart(Animator animator) {
                super.onAnimationStart(animator);
                if (f.this.eS != null) {
                    f.this.eS.uH();
                }
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public final void onAnimationEnd(Animator animator) {
                super.onAnimationEnd(animator);
                f.this.eN.setVisibility(4);
                if (f.this.eS != null) {
                    f.this.eS.uI();
                }
            }
        });
        this.eY.start();
    }

    private void bk() {
        if (this.eN.getVisibility() != 0) {
            return;
        }
        az azVar = this.eS;
        if (azVar != null) {
            azVar.uH();
        }
        this.eN.setVisibility(4);
        az azVar2 = this.eS;
        if (azVar2 != null) {
            azVar2.uI();
        }
    }

    private void bl() {
        ValueAnimator valueAnimator = this.eX;
        if (valueAnimator != null) {
            valueAnimator.removeAllListeners();
            this.eX.cancel();
        }
        ValueAnimator valueAnimator2 = this.eY;
        if (valueAnimator2 != null) {
            valueAnimator2.removeAllListeners();
            this.eY.cancel();
        }
    }

    private void bm() {
        int i = this.eR;
        com.kwad.sdk.core.d.c.w("RewardActionBarWeb", "show webCard fail, reason: ".concat(i == -1 ? "timeout" : i != 1 ? "h5error" : "others"));
    }
}
