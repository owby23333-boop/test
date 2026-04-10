package com.kwad.components.ad.reward.presenter;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Interpolator;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.core.view.animation.PathInterpolatorCompat;
import com.kwad.components.ad.l.b;
import com.kwad.components.core.j.a;
import com.kwad.components.core.video.DetailVideoView;
import com.kwad.components.core.webview.jshandler.y;
import com.kwad.components.core.widget.KsLogoView;
import com.kwad.sdk.R;
import com.kwad.sdk.core.response.model.AdTemplate;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public final class s extends b implements com.kwad.components.ad.reward.e.g, a.InterfaceC0338a, y.b {
    private List<com.kwad.components.core.j.c> bK;
    private com.kwad.components.ad.reward.d rJ;
    private ImageView vy;
    private KsLogoView wA;
    private DetailVideoView wB;
    private int wC;
    private View wD;
    private FrameLayout wE;
    private Animator wF;
    private Animator wG;
    private Animator wH;
    private AdTemplate wI;
    private boolean wQ;
    private View wz;
    private int wy = 1;
    private long wJ = 500;
    private long wK = 50;
    private float wL = 1.2254902f;
    private float wM = 0.80472106f;
    private float wN = 0.0f;
    private boolean wO = false;
    private long showTime = -1;
    private long wP = -1;
    private com.kwad.components.core.video.m jE = new com.kwad.components.core.video.m() { // from class: com.kwad.components.ad.reward.presenter.s.1
        @Override // com.kwad.components.core.video.m, com.kwad.components.core.video.i
        public final void onMediaPlayProgress(long j, long j2) {
            s.this.k(j2);
        }
    };
    private com.kwad.sdk.core.webview.d.a.a eT = new com.kwad.sdk.core.webview.d.a.a() { // from class: com.kwad.components.ad.reward.presenter.s.5
        @Override // com.kwad.sdk.core.webview.d.a.a
        public final void a(com.kwad.sdk.core.webview.d.b.a aVar) {
            if (aVar != null && !com.kwad.sdk.core.response.b.e.b(s.this.mAdTemplate, aVar.creativeId, aVar.adStyle)) {
                com.kwad.components.core.j.c cVarA = com.kwad.components.ad.reward.g.a((List<com.kwad.components.core.j.c>) s.this.bK, aVar.creativeId);
                if (cVarA != null) {
                    s.this.tm.a(cVarA);
                    return;
                }
                return;
            }
            s.this.tm.rD.cW();
        }
    };

    @Override // com.kwad.components.ad.reward.e.g
    public final int getPriority() {
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void k(long j) {
        AdTemplate adTemplate = this.wI;
        if (adTemplate == null || this.wQ) {
            return;
        }
        if (this.showTime <= 0) {
            this.showTime = com.kwad.sdk.core.response.b.b.cC(adTemplate);
            this.wP = com.kwad.sdk.core.response.b.b.cB(this.wI) + this.showTime;
        }
        long j2 = this.showTime;
        if (j2 > 0 && !this.wO && j > j2) {
            this.wQ = !J(true);
            com.kwad.sdk.core.d.c.d("RewardPreEndCardPresenter", "showError: " + this.wQ);
            if (this.wQ) {
                return;
            } else {
                this.wO = true;
            }
        }
        boolean z = this.wy == 3;
        long j3 = this.wP;
        if (j3 <= 0 || z || j <= j3) {
            return;
        }
        K(true);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        super.onCreate();
        this.wz = findViewById(R.id.ksad_middle_end_card);
        this.wB = (DetailVideoView) findViewById(R.id.ksad_video_player);
        this.wA = (KsLogoView) findViewById(R.id.ksad_splash_logo_container);
        this.vy = (ImageView) findViewById(R.id.ksad_blur_video_cover);
        this.wD = findViewById(R.id.ksad_play_web_card_webView);
        this.wE = (FrameLayout) findViewById(R.id.ksad_middle_end_card_webview_container);
    }

    @Override // com.kwad.components.ad.reward.presenter.b, com.kwad.sdk.mvp.Presenter
    public final void at() {
        super.at();
        this.tm.rE.a(this.jE);
        this.tm.b((com.kwad.components.ad.reward.e.g) this);
        this.tm.a(this);
        this.wC = com.kwad.sdk.c.a.a.J(this.wB);
        com.kwad.sdk.c.a.a.n(this.wB, 49);
        this.wA.aP(this.mAdTemplate);
    }

    private void f(List<AdTemplate> list) {
        this.rJ = new com.kwad.components.ad.reward.d(list, this.tm.mReportExtData, this);
        this.tm.rJ = this.rJ;
        this.rJ.setShowLandingPage(com.kwad.sdk.core.response.b.b.cF(this.mAdTemplate));
        this.rJ.a(this.eT);
        this.rJ.a(this.wE, this.tm.mRootContainer, this.mAdTemplate, this.tm.mApkDownloadHelper, this.tm.mScreenOrientation);
        com.kwad.sdk.core.d.c.d("RewardPreEndCardPresenter", "startPreloadWebView");
        this.rJ.a(new b.InterfaceC0290b() { // from class: com.kwad.components.ad.reward.presenter.s.2
            @Override // com.kwad.components.ad.l.b.InterfaceC0290b
            public final void iU() {
                com.kwad.sdk.core.d.c.d("RewardPreEndCardPresenter", "onPreloadSuccess");
                s.this.tm.sl = true;
            }
        });
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
        this.tm.sl = false;
        this.tm.rE.b(this.jE);
        this.tm.c(this);
        this.tm.b((a.InterfaceC0338a) this);
        com.kwad.components.ad.reward.d dVar = this.rJ;
        if (dVar != null) {
            dVar.ny();
        }
        Animator animator = this.wH;
        if (animator != null) {
            animator.cancel();
        }
        DetailVideoView detailVideoView = this.wB;
        if (detailVideoView != null) {
            com.kwad.sdk.c.a.a.n(detailVideoView, this.wC);
        }
        Animator animator2 = this.wF;
        if (animator2 != null) {
            animator2.cancel();
        }
        this.wH = null;
        this.wF = null;
    }

    private boolean J(boolean z) {
        int iB = b(iS());
        ab(iB);
        com.kwad.components.ad.reward.d dVar = this.rJ;
        boolean zAW = dVar != null ? dVar.aW() : false;
        com.kwad.sdk.core.d.c.d("RewardPreEndCardPresenter", "webLoadSuccess: " + zAW);
        if (!zAW) {
            return false;
        }
        int iA = a(iS());
        float f = -iB;
        this.wN = f;
        Animator animatorA = a(true, f, iA, true, z);
        this.wF = animatorA;
        animatorA.start();
        Animator animatorIR = iR();
        this.wH = animatorIR;
        animatorIR.start();
        this.wy = 2;
        return true;
    }

    private void ab(int i) {
        ViewGroup.LayoutParams layoutParams = this.wz.getLayoutParams();
        if (layoutParams instanceof FrameLayout.LayoutParams) {
            FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) layoutParams;
            layoutParams2.height = i;
            layoutParams2.bottomMargin = -i;
        } else {
            FrameLayout.LayoutParams layoutParams3 = new FrameLayout.LayoutParams(-1, i);
            layoutParams3.height = i;
            layoutParams3.bottomMargin = -i;
            this.wz.setLayoutParams(layoutParams3);
        }
    }

    private void K(boolean z) {
        Animator animatorA = a(false, (iS() - iT()) + this.wN, a(iT()), false, z);
        this.wG = animatorA;
        animatorA.start();
        com.kwad.sdk.core.local.a.Hq();
        com.kwad.sdk.core.local.a.ch(this.wI);
        this.wy = 3;
        com.kwad.components.ad.reward.d dVar = this.rJ;
        if (dVar != null) {
            dVar.gu();
        }
    }

    private Animator iR() {
        ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(this.wD, "alpha", 255.0f, 0.0f);
        objectAnimatorOfFloat.setInterpolator(PathInterpolatorCompat.create(0.25f, 0.1f, 0.25f, 1.0f));
        objectAnimatorOfFloat.setDuration(200L);
        return objectAnimatorOfFloat;
    }

    private Animator a(boolean z, float f, int i, boolean z2, boolean z3) {
        ValueAnimator valueAnimatorOfFloat;
        com.kwad.sdk.core.d.c.d("RewardPreEndCardPresenter", "getUpAnimator: translationY0: " + f + ", videoTargetHeight: " + i);
        if (z) {
            valueAnimatorOfFloat = ObjectAnimator.ofFloat(this.wz, "translationY", f);
        } else {
            int height = this.wz.getHeight();
            final ViewGroup.LayoutParams layoutParams = this.wz.getLayoutParams();
            valueAnimatorOfFloat = ValueAnimator.ofFloat(height, Math.abs(f));
            valueAnimatorOfFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.kwad.components.ad.reward.presenter.s.3
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                    layoutParams.height = (int) ((Float) valueAnimator.getAnimatedValue()).floatValue();
                    s.this.wz.setLayoutParams(layoutParams);
                }
            });
        }
        ObjectAnimator objectAnimatorOfFloat = z2 ? ObjectAnimator.ofFloat(this.wA, "alpha", 0.0f, 255.0f) : null;
        final ViewGroup.LayoutParams layoutParams2 = this.vy.getLayoutParams();
        ValueAnimator valueAnimatorA = this.wB.a(this.mAdTemplate, i, new ValueAnimator.AnimatorUpdateListener() { // from class: com.kwad.components.ad.reward.presenter.s.4
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                int iIntValue = ((Integer) valueAnimator.getAnimatedValue()).intValue();
                ViewGroup.LayoutParams layoutParams3 = layoutParams2;
                if (layoutParams3 != null) {
                    layoutParams3.height = iIntValue;
                    s.this.vy.setLayoutParams(layoutParams2);
                }
            }
        });
        long j = z3 ? this.wJ : this.wK;
        Interpolator interpolatorCreate = PathInterpolatorCompat.create(0.0f, 0.0f, 0.58f, 1.0f);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.setDuration(j);
        animatorSet.setInterpolator(interpolatorCreate);
        if (objectAnimatorOfFloat != null) {
            if (z3) {
                animatorSet.playTogether(valueAnimatorOfFloat, objectAnimatorOfFloat, valueAnimatorA);
            } else {
                animatorSet.playTogether(valueAnimatorOfFloat, objectAnimatorOfFloat);
            }
        } else if (z3) {
            animatorSet.playTogether(valueAnimatorOfFloat, valueAnimatorA);
        } else {
            animatorSet.playTogether(valueAnimatorOfFloat);
        }
        return animatorSet;
    }

    private int a(float f) {
        return (int) (com.kwad.sdk.c.a.a.g(getActivity()) - f);
    }

    private int b(float f) {
        return (int) (f + getContext().getResources().getDimensionPixelSize(R.dimen.ksad_reward_middle_end_card_logo_view_height) + getContext().getResources().getDimensionPixelSize(R.dimen.ksad_reward_middle_end_card_logo_view_margin_bottom));
    }

    private float iS() {
        return com.kwad.sdk.c.a.a.f(getActivity()) / this.wL;
    }

    private float iT() {
        return com.kwad.sdk.c.a.a.f(getActivity()) / this.wM;
    }

    @Override // com.kwad.components.core.j.a.InterfaceC0338a
    public final void onError(int i, String str) {
        com.kwad.sdk.core.d.c.w("RewardPreEndCardPresenter", "onError : msg " + str);
    }

    @Override // com.kwad.components.core.j.a.InterfaceC0338a
    public final void onRequestResult(int i) {
        com.kwad.sdk.core.d.c.w("RewardPreEndCardPresenter", "onRequestResult : adNumber " + i);
    }

    @Override // com.kwad.components.core.j.a.InterfaceC0338a
    public final void e(List<com.kwad.components.core.j.c> list) {
        com.kwad.sdk.core.d.c.d("RewardPreEndCardPresenter", "onInnerAdLoad: " + list);
        if (list == null || list.size() == 0) {
            return;
        }
        this.wI = list.get(0).getAdTemplate();
        this.bK = list;
        ArrayList arrayList = new ArrayList();
        arrayList.add(this.mAdTemplate);
        arrayList.addAll(com.kwad.components.core.j.c.n(list));
        f(arrayList);
    }

    @Override // com.kwad.components.core.webview.jshandler.y.b
    public final void W(AdTemplate adTemplate) {
        com.kwad.components.core.j.c cVar = new com.kwad.components.core.j.c(adTemplate, com.kwad.components.core.j.e.AGGREGATION);
        if (this.tm != null) {
            this.tm.b(cVar);
        }
    }

    @Override // com.kwad.components.ad.reward.e.g
    public final void cX() {
        int i;
        if (this.wI == null || (i = this.wy) == 3) {
            return;
        }
        if (i == 1) {
            J(false);
            K(false);
        } else if (i == 2) {
            K(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // java.lang.Comparable
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public int compareTo(com.kwad.components.ad.reward.e.g gVar) {
        return getPriority() - gVar.getPriority();
    }
}
