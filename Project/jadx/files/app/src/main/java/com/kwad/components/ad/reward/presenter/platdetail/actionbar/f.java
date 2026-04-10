package com.kwad.components.ad.reward.presenter.platdetail.actionbar;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.annotation.SuppressLint;
import android.os.SystemClock;
import android.view.animation.DecelerateInterpolator;
import androidx.annotation.Nullable;
import com.kwad.components.ad.reward.h.o;
import com.kwad.components.ad.reward.presenter.platdetail.actionbar.RewardActionBarControl;
import com.kwad.components.core.playable.PlayableSource;
import com.kwad.components.core.webview.a.i;
import com.kwad.components.core.webview.jshandler.ae;
import com.kwad.components.core.webview.jshandler.ah;
import com.kwad.components.core.webview.jshandler.j;
import com.kwad.components.core.webview.jshandler.l;
import com.kwad.components.core.webview.jshandler.m;
import com.kwad.components.core.webview.jshandler.p;
import com.kwad.components.core.webview.jshandler.r;
import com.kwad.components.core.webview.jshandler.s;
import com.kwad.components.core.webview.jshandler.t;
import com.kwad.components.core.webview.jshandler.z;
import com.kwad.components.core.widget.KsLogoView;
import com.kwad.sdk.R;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.view.AdBaseFrameLayout;
import com.kwad.sdk.core.webview.KsAdWebView;

/* JADX INFO: loaded from: classes3.dex */
public final class f extends com.kwad.components.ad.reward.presenter.a implements com.kwad.components.core.webview.a.d.b {

    @Nullable
    private KsAdWebView cS;
    private s.a cT;
    private ValueAnimator cZ;
    private ValueAnimator da;
    private com.kwad.components.core.d.b.c mApkDownloadHelper;
    private ae mCardLifecycleHandler;
    private com.kwad.sdk.core.webview.b mJsBridgeContext;
    private com.kwad.components.core.webview.a mJsInterface;
    private String mUrl;
    private RewardActionBarControl pz;
    private KsLogoView sH;
    private boolean vb;
    private long vc;
    private int cU = -1;
    private RewardActionBarControl.e uI = new RewardActionBarControl.e() { // from class: com.kwad.components.ad.reward.presenter.platdetail.actionbar.f.1
        @Override // com.kwad.components.ad.reward.presenter.platdetail.actionbar.RewardActionBarControl.e
        public final boolean g(a aVar) {
            f fVar = f.this;
            fVar.vb = fVar.g(aVar);
            return f.this.vb;
        }
    };
    private com.kwad.components.ad.reward.d.f mPlayEndPageListener = new com.kwad.components.ad.reward.d.a() { // from class: com.kwad.components.ad.reward.presenter.platdetail.actionbar.f.2
        @Override // com.kwad.components.ad.reward.d.f
        public final void bM() {
            f.this.release();
        }
    };
    private com.kwad.sdk.core.webview.c.kwai.a cV = new com.kwad.sdk.core.webview.c.kwai.a() { // from class: com.kwad.components.ad.reward.presenter.platdetail.actionbar.f.3
        @Override // com.kwad.sdk.core.webview.c.kwai.a
        public final void onAdClicked(com.kwad.sdk.core.webview.c.a.a aVar) {
            f.this.qS.mAdOpenInteractionListener.bN();
        }
    };
    private s.b cW = new s.b() { // from class: com.kwad.components.ad.reward.presenter.platdetail.actionbar.f.5
        @Override // com.kwad.components.core.webview.jshandler.s.b
        public final void a(s.a aVar) {
            f.this.cT = aVar;
            f.this.cS.setTranslationY(aVar.height + aVar.bottomMargin);
        }
    };
    private r.b cX = new r.b() { // from class: com.kwad.components.ad.reward.presenter.platdetail.actionbar.f.6
        @Override // com.kwad.components.core.webview.jshandler.r.b
        public final void a(r.a aVar) {
            f.this.vb = false;
            f.this.aK();
        }
    };
    private z.b cY = new z.b() { // from class: com.kwad.components.ad.reward.presenter.platdetail.actionbar.f.7
        @Override // com.kwad.components.core.webview.jshandler.z.b
        public final void a(z.a aVar) {
            f.this.cU = aVar.status;
            long jElapsedRealtime = SystemClock.elapsedRealtime() - f.this.vc;
            com.kwad.sdk.core.d.b.i("RewardActionBarWeb", "load time:" + jElapsedRealtime + ", pageStatus: " + f.this.cU);
            if (f.this.cU == 1) {
                com.kwad.components.core.m.a.pr().e(f.this.qS.mAdTemplate, jElapsedRealtime);
            } else {
                com.kwad.components.ad.reward.monitor.a.a(f.this.qS.pN, "play_card", com.kwad.sdk.core.response.a.b.aQ(f.this.qS.mAdTemplate), System.currentTimeMillis() - f.this.cS.getLoadTime(), 3);
            }
            if (f.this.qS.gd()) {
                return;
            }
            f.this.pz.iv();
        }
    };

    private void a(com.kwad.components.core.webview.a aVar) {
        aVar.a(new j(this.mJsBridgeContext, this.mApkDownloadHelper, this.cV));
        aVar.a(new com.kwad.components.core.webview.a.kwai.f());
        aVar.a(new o(this.mJsBridgeContext, this.mApkDownloadHelper, this.qS, -1L, this.cV, null));
        aVar.a(new m(this.mJsBridgeContext));
        aVar.a(new p(this.mJsBridgeContext));
        aVar.a(new l(this.mJsBridgeContext));
        aVar.a(new s(this.mJsBridgeContext, this.cW));
        aVar.a(new z(this.cY, com.kwad.sdk.core.response.a.b.aQ(this.qS.mAdTemplate)));
        this.mCardLifecycleHandler = new ae();
        aVar.a(this.mCardLifecycleHandler);
        aVar.a(new ah(this.mJsBridgeContext, this.mApkDownloadHelper));
        aVar.a(new r(this.cX));
        aVar.a(new t(this.mJsBridgeContext));
        aVar.a(new com.kwad.components.ad.reward.f.b(getContext(), this.qS.mAdTemplate, PlayableSource.ACTIONBAR_CLICK));
    }

    private void aF() {
        this.cU = -1;
        aG();
        this.cS.setBackgroundColor(0);
        this.cS.getBackground().setAlpha(0);
        this.cS.setVisibility(4);
        this.cS.setClientConfig(this.cS.getClientConfig().cr(this.qS.mAdTemplate).b(getWebListener()));
        this.vc = SystemClock.elapsedRealtime();
        this.mUrl = com.kwad.sdk.core.response.a.b.aQ(this.qS.mAdTemplate);
        com.kwad.sdk.core.d.b.d("RewardActionBarWeb", "startPreloadWebView url: " + this.mUrl);
        com.kwad.components.ad.reward.monitor.a.a(this.qS.pN, "play_card", this.mUrl);
        this.cS.loadUrl(this.mUrl);
    }

    @SuppressLint({"SetJavaScriptEnabled", "AddJavascriptInterface", "JavascriptInterface"})
    private void aG() {
        clearJsInterfaceRegister();
        this.mJsInterface = new com.kwad.components.core.webview.a(this.cS);
        a(this.mJsInterface);
        this.cS.addJavascriptInterface(this.mJsInterface, "KwaiAd");
    }

    private void aJ() {
        z(this.qS.mAdTemplate);
        ae aeVar = this.mCardLifecycleHandler;
        if (aeVar != null) {
            aeVar.rr();
        }
        this.cS.setVisibility(0);
        ae aeVar2 = this.mCardLifecycleHandler;
        if (aeVar2 != null) {
            aeVar2.rs();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aK() {
        if (this.cS.getVisibility() != 0) {
            return;
        }
        if (this.cT == null) {
            aL();
            return;
        }
        aM();
        KsAdWebView ksAdWebView = this.cS;
        s.a aVar = this.cT;
        this.da = com.kwad.components.core.r.o.c(ksAdWebView, 0, aVar.height + aVar.bottomMargin);
        this.da.setInterpolator(new DecelerateInterpolator(2.0f));
        this.da.setDuration(300L);
        this.da.addListener(new AnimatorListenerAdapter() { // from class: com.kwad.components.ad.reward.presenter.platdetail.actionbar.f.9
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public final void onAnimationEnd(Animator animator) {
                super.onAnimationEnd(animator);
                f.this.cS.setVisibility(4);
                if (f.this.mCardLifecycleHandler != null) {
                    f.this.mCardLifecycleHandler.ru();
                }
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public final void onAnimationStart(Animator animator) {
                super.onAnimationStart(animator);
                if (f.this.mCardLifecycleHandler != null) {
                    f.this.mCardLifecycleHandler.rt();
                }
            }
        });
        this.da.start();
    }

    private void aL() {
        if (this.cS.getVisibility() != 0) {
            return;
        }
        ae aeVar = this.mCardLifecycleHandler;
        if (aeVar != null) {
            aeVar.rt();
        }
        this.cS.setVisibility(4);
        ae aeVar2 = this.mCardLifecycleHandler;
        if (aeVar2 != null) {
            aeVar2.ru();
        }
    }

    private void aM() {
        ValueAnimator valueAnimator = this.cZ;
        if (valueAnimator != null) {
            valueAnimator.removeAllListeners();
            this.cZ.cancel();
        }
        ValueAnimator valueAnimator2 = this.da;
        if (valueAnimator2 != null) {
            valueAnimator2.removeAllListeners();
            this.da.cancel();
        }
    }

    private void aN() {
        int i2 = this.cU;
        com.kwad.sdk.core.d.b.w("RewardActionBarWeb", "show webCard fail, reason: " + (i2 == -1 ? "timeout" : i2 != 1 ? "h5error" : "others"));
    }

    private void cc() {
        if (this.cS == null || !com.kwad.sdk.core.response.a.b.aS(this.qS.mAdTemplate)) {
            return;
        }
        this.mApkDownloadHelper = this.qS.mApkDownloadHelper;
        inflateJsBridgeContext();
        aF();
        this.qS.b(this.mPlayEndPageListener);
    }

    private void clearJsInterfaceRegister() {
        com.kwad.components.core.webview.a aVar = this.mJsInterface;
        if (aVar != null) {
            aVar.destroy();
            this.mJsInterface = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean g(a aVar) {
        KsAdWebView ksAdWebView = this.cS;
        if (ksAdWebView == null) {
            return false;
        }
        if (ksAdWebView.getVisibility() == 0) {
            return true;
        }
        if (this.cU == 1) {
            h(aVar);
            return true;
        }
        aN();
        return false;
    }

    private KsAdWebView.d getWebListener() {
        return new KsAdWebView.d() { // from class: com.kwad.components.ad.reward.presenter.platdetail.actionbar.f.4
            @Override // com.kwad.sdk.core.webview.KsAdWebView.d
            public final void onPageFinished() {
                com.kwad.components.ad.reward.monitor.a.a(f.this.qS.pN, "play_card", f.this.mUrl, System.currentTimeMillis() - f.this.cS.getLoadTime());
            }

            @Override // com.kwad.sdk.core.webview.KsAdWebView.d
            public final void onPageStart() {
            }

            @Override // com.kwad.sdk.core.webview.KsAdWebView.d
            public final void onReceivedHttpError(int i2, String str, String str2) {
                com.kwad.components.ad.reward.monitor.a.a(f.this.qS.pN, "play_card", com.kwad.sdk.core.response.a.b.aQ(f.this.qS.mAdTemplate), System.currentTimeMillis() - f.this.cS.getLoadTime(), 2);
            }
        };
    }

    private void h(final a aVar) {
        if (this.cT == null) {
            aJ();
            return;
        }
        z(this.qS.mAdTemplate);
        aM();
        this.cS.setVisibility(0);
        KsAdWebView ksAdWebView = this.cS;
        s.a aVar2 = this.cT;
        this.cZ = com.kwad.components.core.r.o.c(ksAdWebView, aVar2.height + aVar2.bottomMargin, 0);
        this.cZ.setInterpolator(new DecelerateInterpolator(2.0f));
        this.cZ.setDuration(500L);
        this.cZ.addListener(new AnimatorListenerAdapter() { // from class: com.kwad.components.ad.reward.presenter.platdetail.actionbar.f.8
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public final void onAnimationEnd(Animator animator) {
                super.onAnimationEnd(animator);
                if (f.this.mCardLifecycleHandler != null) {
                    f.this.mCardLifecycleHandler.rs();
                }
                a aVar3 = aVar;
                if (aVar3 != null) {
                    aVar3.a(RewardActionBarControl.ShowActionBarResult.SHOW_H5_SUCCESS, f.this.cS);
                }
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public final void onAnimationStart(Animator animator) {
                super.onAnimationStart(animator);
                if (f.this.mCardLifecycleHandler != null) {
                    f.this.mCardLifecycleHandler.rr();
                }
            }
        });
        this.cZ.start();
    }

    private void inflateJsBridgeContext() {
        this.mJsBridgeContext = new com.kwad.sdk.core.webview.b();
        this.mJsBridgeContext.setAdTemplate(this.qS.mAdTemplate);
        com.kwad.sdk.core.webview.b bVar = this.mJsBridgeContext;
        com.kwad.components.ad.reward.j jVar = this.qS;
        bVar.mScreenOrientation = jVar.mScreenOrientation;
        AdBaseFrameLayout adBaseFrameLayout = jVar.mRootContainer;
        bVar.aoM = adBaseFrameLayout;
        bVar.LI = adBaseFrameLayout;
        bVar.Lk = this.cS;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void release() {
        this.cU = -1;
        KsAdWebView ksAdWebView = this.cS;
        if (ksAdWebView != null) {
            ksAdWebView.setVisibility(8);
        }
        clearJsInterfaceRegister();
    }

    private void z(AdTemplate adTemplate) {
        KsLogoView ksLogoView;
        if (!com.kwad.sdk.core.response.a.a.ci(com.kwad.sdk.core.response.a.d.cb(adTemplate)) || com.kwad.sdk.utils.ah.DI() || (ksLogoView = this.sH) == null) {
            return;
        }
        ksLogoView.setVisibility(0);
    }

    @Override // com.kwad.components.ad.reward.presenter.a, com.kwad.sdk.mvp.Presenter
    public final void ar() {
        super.ar();
        com.kwad.components.ad.reward.monitor.a.a(this.qS.pN, "play_card");
        this.pz = this.qS.pz;
        this.pz.a(this.uI);
        if (com.kwad.components.ad.reward.j.d(this.qS)) {
            com.kwad.components.core.webview.a.c.a.rE().a(this);
        } else {
            cc();
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        super.onCreate();
        this.cS = (KsAdWebView) findViewById(R.id.ksad_play_web_card_webView);
        this.sH = (KsLogoView) findViewById(R.id.ksad_ad_label_play_bar);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
        RewardActionBarControl rewardActionBarControl = this.pz;
        if (rewardActionBarControl != null) {
            rewardActionBarControl.a((RewardActionBarControl.e) null);
        }
        com.kwad.components.core.webview.a.c.a.rE().b(this);
        this.qS.c(this.mPlayEndPageListener);
        aM();
        release();
    }

    @Override // com.kwad.components.core.webview.a.d.b
    public final void u(String str) {
        if (i.b("ksad-video-bottom-card-v2", this.qS.mAdTemplate).equals(str)) {
            cc();
        }
    }
}
