package com.kwad.components.ad.draw.a.a;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.annotation.SuppressLint;
import android.view.ViewGroup;
import android.view.animation.DecelerateInterpolator;
import com.kwad.components.ad.draw.a.a.a;
import com.kwad.components.core.r.o;
import com.kwad.components.core.video.i;
import com.kwad.components.core.video.j;
import com.kwad.components.core.webview.jshandler.ae;
import com.kwad.components.core.webview.jshandler.ah;
import com.kwad.components.core.webview.jshandler.g;
import com.kwad.components.core.webview.jshandler.l;
import com.kwad.components.core.webview.jshandler.m;
import com.kwad.components.core.webview.jshandler.p;
import com.kwad.components.core.webview.jshandler.r;
import com.kwad.components.core.webview.jshandler.s;
import com.kwad.components.core.webview.jshandler.t;
import com.kwad.components.core.webview.jshandler.z;
import com.kwad.sdk.R;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.view.AdBaseFrameLayout;
import com.kwad.sdk.core.webview.KsAdWebView;

/* JADX INFO: loaded from: classes2.dex */
public final class c extends com.kwad.components.ad.draw.kwai.a {
    private KsAdWebView cS;
    private s.a cT;
    private ValueAnimator cZ;
    private ViewGroup cv;
    private ValueAnimator da;
    private AdTemplate mAdTemplate;
    private com.kwad.components.core.d.b.c mApkDownloadHelper;
    private ae mCardLifecycleHandler;
    private com.kwad.sdk.core.webview.b mJsBridgeContext;
    private com.kwad.components.core.webview.a mJsInterface;
    private int cU = -1;
    private i mVideoPlayStateListener = new j() { // from class: com.kwad.components.ad.draw.a.a.c.1
        @Override // com.kwad.components.core.video.j, com.kwad.components.core.video.i
        public final void onVideoPlayCompleted() {
            super.onVideoPlayCompleted();
            c.this.release();
        }
    };
    private a.b cN = new a.b() { // from class: com.kwad.components.ad.draw.a.a.c.2
        @Override // com.kwad.components.ad.draw.a.a.a.b
        public final boolean az() {
            return c.this.aH();
        }
    };
    private com.kwad.sdk.core.webview.c.kwai.a cV = new com.kwad.sdk.core.webview.c.kwai.a() { // from class: com.kwad.components.ad.draw.a.a.c.3
        @Override // com.kwad.sdk.core.webview.c.kwai.a
        public final void onAdClicked(com.kwad.sdk.core.webview.c.a.a aVar) {
            if (c.this.bW.bV != null) {
                c.this.bW.bV.onAdClicked();
            }
        }
    };
    private s.b cW = new s.b() { // from class: com.kwad.components.ad.draw.a.a.c.4
        @Override // com.kwad.components.core.webview.jshandler.s.b
        public final void a(s.a aVar) {
            c.this.cT = aVar;
            c.this.cS.setTranslationY(aVar.height + aVar.bottomMargin);
        }
    };
    private r.b cX = new r.b() { // from class: com.kwad.components.ad.draw.a.a.c.5
        @Override // com.kwad.components.core.webview.jshandler.r.b
        public final void a(r.a aVar) {
            c.this.aK();
        }
    };
    private z.b cY = new z.b() { // from class: com.kwad.components.ad.draw.a.a.c.6
        @Override // com.kwad.components.core.webview.jshandler.z.b
        public final void a(z.a aVar) {
            c.this.cU = aVar.status;
            com.kwad.sdk.core.d.b.i("DrawPlayWebCard", "updatePageStatus mPageState: " + aVar);
        }
    };

    private void a(com.kwad.components.core.webview.a aVar) {
        aVar.a(new com.kwad.components.core.webview.jshandler.j(this.mJsBridgeContext, this.mApkDownloadHelper, this.cV));
        aVar.a(new g(this.mJsBridgeContext, this.mApkDownloadHelper, this.cV));
        aVar.a(new m(this.mJsBridgeContext));
        aVar.a(new p(this.mJsBridgeContext));
        aVar.a(new l(this.mJsBridgeContext));
        aVar.a(new s(this.mJsBridgeContext, this.cW));
        aVar.a(new z(this.cY, com.kwad.sdk.core.response.a.b.aQ(this.mAdTemplate)));
        this.mCardLifecycleHandler = new ae();
        aVar.a(this.mCardLifecycleHandler);
        aVar.a(new ah(this.mJsBridgeContext, this.mApkDownloadHelper));
        aVar.a(new r(this.cX));
        aVar.a(new t(this.mJsBridgeContext));
    }

    private void aF() {
        this.cU = -1;
        aG();
        this.cS.setBackgroundColor(0);
        this.cS.getBackground().setAlpha(0);
        this.cS.setVisibility(4);
        this.cS.loadUrl(com.kwad.sdk.core.response.a.b.aQ(this.mAdTemplate));
    }

    @SuppressLint({"SetJavaScriptEnabled", "AddJavascriptInterface", "JavascriptInterface"})
    private void aG() {
        clearJsInterfaceRegister();
        this.mJsInterface = new com.kwad.components.core.webview.a(this.cS);
        a(this.mJsInterface);
        this.cS.addJavascriptInterface(this.mJsInterface, "KwaiAd");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean aH() {
        if (this.cU == 1) {
            aI();
            return true;
        }
        aN();
        return false;
    }

    private void aI() {
        if (this.cT == null) {
            aJ();
            return;
        }
        aM();
        this.cv.setVisibility(8);
        this.cS.setVisibility(0);
        KsAdWebView ksAdWebView = this.cS;
        s.a aVar = this.cT;
        this.cZ = o.c(ksAdWebView, aVar.height + aVar.bottomMargin, 0);
        this.cZ.setInterpolator(new DecelerateInterpolator(2.0f));
        this.cZ.setDuration(300L);
        this.cZ.addListener(new AnimatorListenerAdapter() { // from class: com.kwad.components.ad.draw.a.a.c.7
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public final void onAnimationEnd(Animator animator) {
                super.onAnimationEnd(animator);
                if (c.this.mCardLifecycleHandler != null) {
                    c.this.mCardLifecycleHandler.rs();
                }
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public final void onAnimationStart(Animator animator) {
                super.onAnimationStart(animator);
                if (c.this.mCardLifecycleHandler != null) {
                    c.this.mCardLifecycleHandler.rr();
                }
            }
        });
        this.cZ.start();
    }

    private void aJ() {
        ae aeVar = this.mCardLifecycleHandler;
        if (aeVar != null) {
            aeVar.rr();
        }
        this.cv.setVisibility(8);
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
        this.da = o.c(ksAdWebView, 0, aVar.height + aVar.bottomMargin);
        this.da.setInterpolator(new DecelerateInterpolator(2.0f));
        this.da.setDuration(300L);
        this.da.addListener(new AnimatorListenerAdapter() { // from class: com.kwad.components.ad.draw.a.a.c.8
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public final void onAnimationEnd(Animator animator) {
                super.onAnimationEnd(animator);
                c.this.cS.setVisibility(4);
                c.this.cv.setVisibility(0);
                if (c.this.mCardLifecycleHandler != null) {
                    c.this.mCardLifecycleHandler.ru();
                }
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public final void onAnimationStart(Animator animator) {
                super.onAnimationStart(animator);
                if (c.this.mCardLifecycleHandler != null) {
                    c.this.mCardLifecycleHandler.rt();
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
        this.cv.setVisibility(0);
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
        com.kwad.sdk.core.d.b.w("DrawPlayWebCard", "show webCard fail, reason: " + (i2 == -1 ? "timeout" : i2 != 1 ? "h5error" : "others"));
    }

    private void clearJsInterfaceRegister() {
        com.kwad.components.core.webview.a aVar = this.mJsInterface;
        if (aVar != null) {
            aVar.destroy();
            this.mJsInterface = null;
        }
    }

    private void inflateJsBridgeContext() {
        this.mJsBridgeContext = new com.kwad.sdk.core.webview.b();
        this.mJsBridgeContext.setAdTemplate(this.bW.mAdTemplate);
        com.kwad.sdk.core.webview.b bVar = this.mJsBridgeContext;
        bVar.mScreenOrientation = 0;
        AdBaseFrameLayout adBaseFrameLayout = this.bW.mRootContainer;
        bVar.aoM = adBaseFrameLayout;
        bVar.LI = adBaseFrameLayout;
        bVar.Lk = this.cS;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void release() {
        this.cU = -1;
        this.cS.setVisibility(8);
        clearJsInterfaceRegister();
    }

    @Override // com.kwad.components.ad.draw.kwai.a, com.kwad.sdk.mvp.Presenter
    public final void ar() {
        super.ar();
        com.kwad.components.ad.draw.kwai.b bVar = this.bW;
        this.mAdTemplate = bVar.mAdTemplate;
        bVar.co.a(this.cN);
        com.kwad.components.ad.draw.kwai.b bVar2 = this.bW;
        this.mApkDownloadHelper = bVar2.mApkDownloadHelper;
        bVar2.bX.a(this.mVideoPlayStateListener);
        inflateJsBridgeContext();
        aF();
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        super.onCreate();
        this.cv = (ViewGroup) findViewById(R.id.ksad_ad_normal_container);
        this.cS = (KsAdWebView) findViewById(R.id.ksad_play_web_card_webView);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
        this.bW.co.a((a.b) null);
        this.bW.bX.b(this.mVideoPlayStateListener);
        aM();
        release();
    }
}
