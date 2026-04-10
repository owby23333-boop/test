package com.kwad.components.ad.interstitial.c;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.os.Message;
import android.view.View;
import androidx.annotation.NonNull;
import com.kwad.components.ad.interstitial.c.c;
import com.kwad.components.core.page.AdWebViewActivityProxy;
import com.kwad.sdk.R;
import com.kwad.sdk.commercial.model.WebCloseStatus;
import com.kwad.sdk.core.report.y;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.utils.ab;
import com.kwad.sdk.utils.bh;
import com.kwad.sdk.utils.bk;
import com.kwad.sdk.widget.KSFrameLayout;
import com.kwad.sdk.widget.swipe.VerticalSwipeLayout;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public final class j extends b implements bk.a {
    private bk gH;
    private KSFrameLayout jA;
    private View kA;
    private View kB;
    private View kC;
    private View kD;
    private View kE;
    private View kF;
    private View kG;
    private AnimatorSet kI;
    private ObjectAnimator kJ;
    private ObjectAnimator kK;
    private ObjectAnimator kL;
    private ObjectAnimator kM;
    private ObjectAnimator kN;
    private ObjectAnimator kO;
    private int kP;
    private VerticalSwipeLayout li;
    protected AdInfo mAdInfo;
    private AdTemplate mAdTemplate;

    @NonNull
    protected Context mContext;
    private com.kwad.components.core.page.c mLandingPageView;
    private String mPageUrl;
    private c.a jw = new c.a() { // from class: com.kwad.components.ad.interstitial.c.j.1
        @Override // com.kwad.components.ad.interstitial.c.c.a
        public final void cr() {
            j.this.jA.removeAllViews();
            j.this.dD();
            j.this.jA.setVisibility(8);
            j.this.li.b(j.this.lj);
        }
    };
    private Runnable kQ = new AnonymousClass3();
    private VerticalSwipeLayout.a lj = new VerticalSwipeLayout.a() { // from class: com.kwad.components.ad.interstitial.c.j.4
        @Override // com.kwad.sdk.widget.swipe.VerticalSwipeLayout.a
        public final void ee() {
            com.kwad.sdk.core.d.b.d("InterstitialVerticalSwipe", "onDownSwiped: ");
            j.this.jA.setTranslationY(com.kwad.sdk.b.kwai.a.aF(j.this.mContext));
            j.this.jq.cY();
            j.this.li.b(j.this.lj);
        }

        @Override // com.kwad.sdk.widget.swipe.VerticalSwipeLayout.a
        public final void ef() {
            com.kwad.sdk.core.d.b.d("InterstitialVerticalSwipe", "onTopSwiped: ");
            j.this.dD();
            j.this.jA.setAllCorner(false);
            j.this.mLandingPageView.requestLayout();
            j.this.jA.requestLayout();
            com.kwad.sdk.core.report.a.a(j.this.mAdTemplate, 70, (ab.a) null);
            j.this.jq.cZ();
        }
    };
    private com.kwad.sdk.core.webview.c.kwai.b mWebCardCloseListener = new com.kwad.sdk.core.webview.c.kwai.b() { // from class: com.kwad.components.ad.interstitial.c.j.5
        @Override // com.kwad.sdk.core.webview.c.kwai.b
        public final void a(WebCloseStatus webCloseStatus) {
            j.this.jq.hR.dismiss();
        }
    };
    private com.kwad.components.core.page.kwai.a mLandPageViewListener = new com.kwad.components.core.page.kwai.a() { // from class: com.kwad.components.ad.interstitial.c.j.6
        @Override // com.kwad.components.core.page.kwai.a
        public final void dK() {
            j.this.jA.setTranslationY(com.kwad.sdk.b.kwai.a.aF(j.this.mContext));
            j.this.jq.cY();
            j.this.li.b(j.this.lj);
        }

        @Override // com.kwad.components.core.page.kwai.a
        public final void dL() {
            j.this.jq.hR.dismiss();
        }
    };

    /* JADX INFO: renamed from: com.kwad.components.ad.interstitial.c.j$3, reason: invalid class name */
    final class AnonymousClass3 implements Runnable {
        AnonymousClass3() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            j.this.b(new AnimatorListenerAdapter() { // from class: com.kwad.components.ad.interstitial.c.j.3.1
                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public final void onAnimationCancel(Animator animator) {
                    super.onAnimationCancel(animator);
                    j.this.jA.setTranslationY(com.kwad.sdk.b.kwai.a.aF(j.this.mContext));
                    j.this.kA.setTranslationY(com.kwad.sdk.b.kwai.a.a(j.this.mContext, 500.0f));
                    j.this.kB.setTranslationY(com.kwad.sdk.b.kwai.a.a(j.this.mContext, 140.0f));
                    j.this.kA.setAlpha(1.0f);
                    j.this.kB.setAlpha(1.0f);
                    j.this.kC.setVisibility(8);
                }

                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public final void onAnimationEnd(Animator animator) {
                    super.onAnimationEnd(animator);
                    j.this.a(new AnimatorListenerAdapter() { // from class: com.kwad.components.ad.interstitial.c.j.3.1.1
                        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                        public final void onAnimationCancel(Animator animator2) {
                            super.onAnimationCancel(animator2);
                            j.this.jA.setTranslationY(com.kwad.sdk.b.kwai.a.aF(j.this.mContext));
                            j.this.kA.setAlpha(1.0f);
                            j.this.kB.setAlpha(1.0f);
                            j.this.kC.setVisibility(8);
                        }

                        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                        public final void onAnimationStart(Animator animator2) {
                            super.onAnimationStart(animator2);
                            j.this.dH();
                        }
                    });
                }

                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public final void onAnimationStart(Animator animator) {
                    super.onAnimationStart(animator);
                    j.this.jA.setTranslationY(com.kwad.sdk.b.kwai.a.aF(j.this.mContext));
                    j.this.kA.setTranslationY(com.kwad.sdk.b.kwai.a.a(j.this.mContext, 500.0f));
                    j.this.kB.setTranslationY(com.kwad.sdk.b.kwai.a.a(j.this.mContext, 140.0f));
                    j.this.kA.setAlpha(1.0f);
                    j.this.kB.setAlpha(1.0f);
                    j.this.kC.setVisibility(8);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(Animator.AnimatorListener animatorListener) {
        ObjectAnimator objectAnimator = this.kM;
        if (objectAnimator != null && objectAnimator.isRunning()) {
            this.kM.cancel();
            this.kM.removeAllListeners();
        }
        ObjectAnimator objectAnimator2 = this.kN;
        if (objectAnimator2 != null && objectAnimator2.isRunning()) {
            this.kN.cancel();
        }
        ObjectAnimator objectAnimator3 = this.kO;
        if (objectAnimator3 != null && objectAnimator3.isRunning()) {
            this.kO.cancel();
        }
        this.kM = ObjectAnimator.ofFloat(this.jA, View.TRANSLATION_Y.getName(), com.kwad.sdk.b.kwai.a.aF(this.mContext) - com.kwad.sdk.b.kwai.a.a(this.mContext, 90.0f), com.kwad.sdk.b.kwai.a.aF(this.mContext) - com.kwad.sdk.b.kwai.a.a(this.mContext, 60.0f), com.kwad.sdk.b.kwai.a.aF(this.mContext) - com.kwad.sdk.b.kwai.a.a(this.mContext, 90.0f));
        this.kM.setDuration(1200L);
        this.kM.setRepeatMode(1);
        this.kM.setRepeatCount(-1);
        this.kM.addListener(animatorListener);
        this.kM.start();
        this.kN = ObjectAnimator.ofFloat(this.kA, View.TRANSLATION_Y.getName(), com.kwad.sdk.b.kwai.a.a(this.mContext, 322.0f), com.kwad.sdk.b.kwai.a.a(this.mContext, 500.0f), com.kwad.sdk.b.kwai.a.a(this.mContext, 322.0f));
        this.kN.setDuration(1200L);
        this.kN.setRepeatMode(1);
        this.kN.setRepeatCount(-1);
        this.kN.start();
        this.kO = ObjectAnimator.ofFloat(this.kA, View.ALPHA.getName(), 0.0f, 1.0f, 0.0f);
        this.kO.setDuration(1200L);
        this.kO.setRepeatMode(1);
        this.kO.setRepeatCount(-1);
        this.kO.start();
        this.kA.setVisibility(4);
        this.gH.sendEmptyMessageDelayed(6666, 600L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(Animator.AnimatorListener animatorListener) {
        AnimatorSet animatorSet = this.kI;
        if (animatorSet != null && animatorSet.isRunning()) {
            this.kI.removeAllListeners();
            this.kI.cancel();
        }
        y.a aVar = new y.a();
        aVar.ajF = 7;
        com.kwad.sdk.core.report.a.d(this.mAdTemplate, (JSONObject) null, new com.kwad.sdk.core.report.i().a(aVar).bh(206));
        this.kI = new AnimatorSet();
        ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(this.jA, View.TRANSLATION_Y.getName(), com.kwad.sdk.b.kwai.a.aF(this.mContext), com.kwad.sdk.b.kwai.a.aF(this.mContext) - com.kwad.sdk.b.kwai.a.a(this.mContext, 90.0f));
        objectAnimatorOfFloat.setDuration(300L);
        ObjectAnimator objectAnimatorOfFloat2 = ObjectAnimator.ofFloat(this.kA, View.TRANSLATION_Y.getName(), com.kwad.sdk.b.kwai.a.a(this.mContext, 500.0f), com.kwad.sdk.b.kwai.a.a(this.mContext, 322.0f));
        objectAnimatorOfFloat2.setDuration(300L);
        ObjectAnimator objectAnimatorOfFloat3 = ObjectAnimator.ofFloat(this.kA, View.ALPHA.getName(), 1.0f, 0.0f);
        objectAnimatorOfFloat3.setDuration(300L);
        ObjectAnimator objectAnimatorOfFloat4 = ObjectAnimator.ofFloat(this.kB, View.TRANSLATION_Y.getName(), com.kwad.sdk.b.kwai.a.a(this.mContext, 140.0f), com.kwad.sdk.b.kwai.a.a(this.mContext, 0.0f));
        objectAnimatorOfFloat4.setDuration(300L);
        ObjectAnimator objectAnimatorOfFloat5 = ObjectAnimator.ofFloat(this.kB, View.ALPHA.getName(), 1.0f, 0.99f);
        objectAnimatorOfFloat5.setDuration(300L);
        this.kI.playTogether(objectAnimatorOfFloat, objectAnimatorOfFloat2, objectAnimatorOfFloat3, objectAnimatorOfFloat4, objectAnimatorOfFloat5);
        this.kI.removeAllListeners();
        this.kI.addListener(animatorListener);
        this.kI.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dD() {
        this.kA.removeCallbacks(this.kQ);
        dF();
        dG();
        dE();
        this.jA.setTranslationY(0.0f);
        this.jA.setOnClickListener(null);
    }

    private void dE() {
        ObjectAnimator objectAnimator = this.kM;
        if (objectAnimator != null && objectAnimator.isRunning()) {
            this.kM.cancel();
            this.kM.removeAllListeners();
        }
        ObjectAnimator objectAnimator2 = this.kN;
        if (objectAnimator2 != null && objectAnimator2.isRunning()) {
            this.kN.cancel();
        }
        ObjectAnimator objectAnimator3 = this.kO;
        if (objectAnimator3 != null && objectAnimator3.isRunning()) {
            this.kO.cancel();
        }
        this.kA.setTranslationY(com.kwad.sdk.b.kwai.a.a(this.mContext, 500.0f));
        this.kB.setTranslationY(com.kwad.sdk.b.kwai.a.a(this.mContext, 140.0f));
        this.kA.setAlpha(1.0f);
        this.kB.setAlpha(1.0f);
        this.gH.removeCallbacksAndMessages(null);
    }

    private void dF() {
        AnimatorSet animatorSet = this.kI;
        if (animatorSet == null || !animatorSet.isRunning()) {
            return;
        }
        this.kI.removeAllListeners();
        this.kI.cancel();
    }

    private void dG() {
        ObjectAnimator objectAnimator = this.kJ;
        if (objectAnimator != null && objectAnimator.isRunning()) {
            this.kJ.cancel();
        }
        ObjectAnimator objectAnimator2 = this.kK;
        if (objectAnimator2 != null && objectAnimator2.isRunning()) {
            this.kK.cancel();
        }
        ObjectAnimator objectAnimator3 = this.kL;
        if (objectAnimator3 == null || !objectAnimator3.isRunning()) {
            return;
        }
        this.kL.cancel();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dH() {
        com.kwad.sdk.core.d.b.d("InterstitialVerticalSwipe", "showGuideButton: ");
        this.kC.setVisibility(0);
        ObjectAnimator objectAnimator = this.kJ;
        if (objectAnimator != null && objectAnimator.isRunning()) {
            this.kJ.cancel();
        }
        ObjectAnimator objectAnimator2 = this.kK;
        if (objectAnimator2 != null && objectAnimator2.isRunning()) {
            this.kK.cancel();
        }
        ObjectAnimator objectAnimator3 = this.kL;
        if (objectAnimator3 != null && objectAnimator3.isRunning()) {
            this.kL.cancel();
        }
        this.kJ = ObjectAnimator.ofFloat(this.kG, View.ALPHA.getName(), 0.0f, 1.0f, 0.6f, 0.3f, 0.0f, 0.01f, 0.0f);
        this.kJ.setDuration(600L);
        this.kJ.setRepeatMode(1);
        this.kJ.setRepeatCount(-1);
        this.kJ.start();
        this.kK = ObjectAnimator.ofFloat(this.kF, View.ALPHA.getName(), 0.0f, 0.01f, 1.0f, 0.6f, 0.3f, 0.01f, 0.0f);
        this.kK.setDuration(600L);
        this.kK.setRepeatMode(1);
        this.kK.setRepeatCount(-1);
        this.kK.start();
        this.kL = ObjectAnimator.ofFloat(this.kE, View.ALPHA.getName(), 0.0f, 0.01f, 0.0f, 1.0f, 0.6f, 0.3f, 0.0f);
        this.kL.setDuration(600L);
        this.kL.setRepeatMode(1);
        this.kL.setRepeatCount(-1);
        this.kL.start();
    }

    private void initContentView() {
        this.mPageUrl = com.kwad.sdk.core.response.a.b.bh(this.mAdTemplate);
        this.mLandingPageView = com.kwad.components.core.page.c.b(this.mContext, new AdWebViewActivityProxy.a.C0405a().as(this.mPageUrl).M(this.mAdTemplate).ow());
        this.li.a(this.lj);
        this.mLandingPageView.setLandPageViewListener(this.mLandPageViewListener);
        this.mLandingPageView.setWebCardCloseListener(this.mWebCardCloseListener);
        this.jA.addView(this.mLandingPageView);
        this.jA.setRadius(com.kwad.sdk.b.kwai.a.a(this.mContext, 20.0f));
        this.jA.setTranslationY(com.kwad.sdk.b.kwai.a.aF(this.mContext));
        this.kA.setTranslationY(com.kwad.sdk.b.kwai.a.a(this.mContext, 500.0f));
        this.kB.setTranslationY(com.kwad.sdk.b.kwai.a.a(this.mContext, 140.0f));
        this.kC.setVisibility(8);
        this.jA.setOnClickListener(new View.OnClickListener() { // from class: com.kwad.components.ad.interstitial.c.j.2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                com.kwad.sdk.core.d.b.d("InterstitialVerticalSwipe", "mGuideButtonLayout click: ");
                j.this.dD();
                j.this.jA.setAllCorner(false);
                j.this.mLandingPageView.requestLayout();
                j.this.jA.requestLayout();
                j.this.jq.cZ();
                j.this.li.b(j.this.lj);
                com.kwad.sdk.core.report.a.a(j.this.mAdTemplate, 110, (ab.a) null);
            }
        });
        this.kA.postDelayed(this.kQ, this.kP * 1000);
    }

    @Override // com.kwad.sdk.utils.bk.a
    public final void a(Message message) {
        Runnable runnable;
        if (message.what == 6666) {
            View view = this.kA;
            if (view != null) {
                if (view.getVisibility() == 0) {
                    runnable = new Runnable() { // from class: com.kwad.components.ad.interstitial.c.j.7
                        @Override // java.lang.Runnable
                        public final void run() {
                            j.this.kA.setVisibility(4);
                            j.this.kD.setVisibility(4);
                        }
                    };
                } else if (this.kA.getVisibility() == 4) {
                    runnable = new Runnable() { // from class: com.kwad.components.ad.interstitial.c.j.8
                        @Override // java.lang.Runnable
                        public final void run() {
                            j.this.kA.setVisibility(0);
                            j.this.kD.setVisibility(0);
                        }
                    };
                }
                bh.runOnUiThread(runnable);
            }
            this.gH.sendEmptyMessageDelayed(6666, 600L);
        }
    }

    @Override // com.kwad.components.ad.interstitial.c.b, com.kwad.sdk.mvp.Presenter
    public final void ar() {
        super.ar();
        this.jq = (c) Bs();
        this.mAdTemplate = this.jq.mAdTemplate;
        this.mAdInfo = com.kwad.sdk.core.response.a.d.cb(this.mAdTemplate);
        this.mContext = getContext();
        this.jq.a(this.jw);
        this.kP = com.kwad.sdk.core.response.a.a.bU(this.mAdInfo);
        this.gH = com.kwad.sdk.core.threads.a.a(this);
        initContentView();
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        super.onCreate();
        this.jA = (KSFrameLayout) findViewById(R.id.ksad_land_page_root);
        this.li = (VerticalSwipeLayout) findViewById(R.id.ksad_swipe);
        this.kA = findViewById(R.id.ksad_interstitial_guide_bg);
        this.kB = findViewById(R.id.ksad_interstitial_guide_bg_bg);
        this.kC = findViewById(R.id.ksad_interstitial_guide_button_layout);
        this.kD = findViewById(R.id.ksad_interstitial_guide_button);
        this.kE = findViewById(R.id.ksad_interstitial_guide_button_img_1);
        this.kF = findViewById(R.id.ksad_interstitial_guide_button_img_2);
        this.kG = findViewById(R.id.ksad_interstitial_guide_button_img_3);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
        this.jA.removeAllViews();
        this.jq.b(this.jw);
        dD();
        this.gH.removeCallbacksAndMessages(null);
        this.li.b(this.lj);
    }
}
