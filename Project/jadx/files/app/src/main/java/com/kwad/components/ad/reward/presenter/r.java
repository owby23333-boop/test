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
import androidx.annotation.Nullable;
import androidx.core.view.animation.PathInterpolatorCompat;
import com.kwad.components.ad.i.b;
import com.kwad.components.core.g.a;
import com.kwad.components.core.video.DetailVideoView;
import com.kwad.components.core.webview.jshandler.f;
import com.kwad.components.core.widget.KsLogoView;
import com.kwad.components.offline.api.core.adlive.listener.AdLivePlayStateListener;
import com.kwad.components.offline.api.core.adlive.listener.AdLivePlayStateListenerAdapter;
import com.kwad.sdk.R;
import com.kwad.sdk.core.response.model.AdTemplate;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public final class r extends a implements com.kwad.components.ad.reward.d.f, a.InterfaceC0399a, f.b {
    private AdTemplate mAdTemplate;
    private KsLogoView oH;

    @Nullable
    private com.kwad.components.ad.reward.g pD;
    private ImageView sq;
    private List<com.kwad.components.core.g.c> tA;
    private boolean tJ;
    private View tr;
    private DetailVideoView ts;
    private int tt;
    private View tu;
    private FrameLayout tv;
    private Animator tw;
    private Animator tx;
    private Animator ty;
    private AdTemplate tz;
    private int tq = 1;
    private long tB = 500;
    private long tC = 50;
    private float tD = 1.2254902f;
    private float tE = 0.80472106f;
    private float tF = 0.0f;
    private boolean tG = false;
    private long tH = -1;
    private long tI = -1;
    private AdLivePlayStateListener mAdLivePlayStateListener = new AdLivePlayStateListenerAdapter() { // from class: com.kwad.components.ad.reward.presenter.r.1
        @Override // com.kwad.components.offline.api.core.adlive.listener.AdLivePlayStateListenerAdapter, com.kwad.components.offline.api.core.adlive.listener.AdLivePlayStateListener
        public final void onLivePlayProgress(long j2) {
            super.onLivePlayProgress(j2);
            r.this.f(j2);
        }
    };
    private com.kwad.components.core.video.i mVideoPlayStateListener = new com.kwad.components.core.video.j() { // from class: com.kwad.components.ad.reward.presenter.r.2
        @Override // com.kwad.components.core.video.j, com.kwad.components.core.video.i
        public final void onVideoPlayProgress(long j2, long j3) {
            r.this.f(j3);
        }
    };
    private com.kwad.sdk.core.webview.c.kwai.a cV = new com.kwad.sdk.core.webview.c.kwai.a() { // from class: com.kwad.components.ad.reward.presenter.r.6
        @Override // com.kwad.sdk.core.webview.c.kwai.a
        public final void onAdClicked(com.kwad.sdk.core.webview.c.a.a aVar) {
            if (aVar == null || com.kwad.sdk.core.response.a.d.b(r.this.mAdTemplate, aVar.creativeId, aVar.adStyle)) {
                r.this.qS.mAdOpenInteractionListener.bN();
                return;
            }
            com.kwad.components.core.g.c cVarA = com.kwad.components.ad.reward.j.a((List<com.kwad.components.core.g.c>) r.this.tA, aVar.creativeId);
            if (cVarA != null) {
                r.this.qS.b(cVarA);
            }
        }
    };

    private boolean N(boolean z2) {
        Q(b(ia()));
        com.kwad.components.ad.reward.g gVar = this.pD;
        boolean zAz = gVar != null ? gVar.az() : false;
        com.kwad.sdk.core.d.b.d("RewardPreEndCardPresenter", "webLoadSuccess: " + zAz);
        if (!zAz) {
            return false;
        }
        int iA = a(ia());
        this.tF = -r0;
        this.tw = a(true, this.tF, iA, true, z2);
        this.tw.start();
        this.ty = hZ();
        this.ty.start();
        this.tq = 2;
        return true;
    }

    private void O(boolean z2) {
        this.tx = a(false, (ia() - ib()) + this.tF, a(ib()), false, z2);
        this.tx.start();
        com.kwad.sdk.core.c.a.wg();
        com.kwad.sdk.core.c.a.ao(this.tz);
        this.tq = 3;
        com.kwad.components.ad.reward.g gVar = this.pD;
        if (gVar != null) {
            gVar.fM();
        }
    }

    private void Q(int i2) {
        ViewGroup.LayoutParams layoutParams = this.tr.getLayoutParams();
        if (layoutParams instanceof FrameLayout.LayoutParams) {
            FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) layoutParams;
            layoutParams2.height = i2;
            layoutParams2.bottomMargin = -i2;
        } else {
            FrameLayout.LayoutParams layoutParams3 = new FrameLayout.LayoutParams(-1, i2);
            layoutParams3.height = i2;
            layoutParams3.bottomMargin = -i2;
            this.tr.setLayoutParams(layoutParams3);
        }
    }

    private int a(float f2) {
        return (int) (com.kwad.sdk.b.kwai.a.d(getActivity()) - f2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // java.lang.Comparable
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public int compareTo(com.kwad.components.ad.reward.d.f fVar) {
        return getPriority() - fVar.getPriority();
    }

    private Animator a(boolean z2, float f2, int i2, boolean z3, boolean z4) {
        ValueAnimator valueAnimatorOfFloat;
        com.kwad.sdk.core.d.b.d("RewardPreEndCardPresenter", "getUpAnimator: translationY0: " + f2 + ", videoTargetHeight: " + i2);
        if (z2) {
            valueAnimatorOfFloat = ObjectAnimator.ofFloat(this.tr, "translationY", f2);
        } else {
            int height = this.tr.getHeight();
            final ViewGroup.LayoutParams layoutParams = this.tr.getLayoutParams();
            valueAnimatorOfFloat = ValueAnimator.ofFloat(height, Math.abs(f2));
            valueAnimatorOfFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.kwad.components.ad.reward.presenter.r.4
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                    layoutParams.height = (int) ((Float) valueAnimator.getAnimatedValue()).floatValue();
                    r.this.tr.setLayoutParams(layoutParams);
                }
            });
        }
        ObjectAnimator objectAnimatorOfFloat = z3 ? ObjectAnimator.ofFloat(this.oH, "alpha", 0.0f, 255.0f) : null;
        final ViewGroup.LayoutParams layoutParams2 = this.sq.getLayoutParams();
        ValueAnimator valueAnimatorA = this.ts.a(this.mAdTemplate, i2, new ValueAnimator.AnimatorUpdateListener() { // from class: com.kwad.components.ad.reward.presenter.r.5
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                int iIntValue = ((Integer) valueAnimator.getAnimatedValue()).intValue();
                ViewGroup.LayoutParams layoutParams3 = layoutParams2;
                if (layoutParams3 != null) {
                    layoutParams3.height = iIntValue;
                    r.this.sq.setLayoutParams(layoutParams2);
                }
            }
        });
        long j2 = z4 ? this.tB : this.tC;
        Interpolator interpolatorCreate = PathInterpolatorCompat.create(0.0f, 0.0f, 0.58f, 1.0f);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.setDuration(j2);
        animatorSet.setInterpolator(interpolatorCreate);
        if (objectAnimatorOfFloat != null) {
            if (z4) {
                animatorSet.playTogether(valueAnimatorOfFloat, objectAnimatorOfFloat, valueAnimatorA);
            } else {
                animatorSet.playTogether(valueAnimatorOfFloat, objectAnimatorOfFloat);
            }
        } else if (z4) {
            animatorSet.playTogether(valueAnimatorOfFloat, valueAnimatorA);
        } else {
            animatorSet.playTogether(valueAnimatorOfFloat);
        }
        return animatorSet;
    }

    private int b(float f2) {
        return (int) (f2 + getContext().getResources().getDimensionPixelSize(R.dimen.ksad_reward_middle_end_card_logo_view_height) + getContext().getResources().getDimensionPixelSize(R.dimen.ksad_reward_middle_end_card_logo_view_margin_bottom));
    }

    private void e(List<AdTemplate> list) {
        this.pD = new com.kwad.components.ad.reward.g(list, this.qS.mReportExtData, this);
        com.kwad.components.ad.reward.j jVar = this.qS;
        com.kwad.components.ad.reward.g gVar = this.pD;
        jVar.pD = gVar;
        gVar.A(com.kwad.sdk.core.response.a.b.aZ(this.mAdTemplate));
        this.pD.a(this.cV);
        com.kwad.components.ad.reward.g gVar2 = this.pD;
        FrameLayout frameLayout = this.tv;
        com.kwad.components.ad.reward.j jVar2 = this.qS;
        gVar2.a(frameLayout, jVar2.mRootContainer, this.mAdTemplate, jVar2.mApkDownloadHelper, jVar2.mScreenOrientation);
        com.kwad.sdk.core.d.b.d("RewardPreEndCardPresenter", "startPreloadWebView");
        this.pD.a(new b.InterfaceC0353b() { // from class: com.kwad.components.ad.reward.presenter.r.3
            @Override // com.kwad.components.ad.i.b.InterfaceC0353b
            public final void ic() {
                com.kwad.sdk.core.d.b.d("RewardPreEndCardPresenter", "onPreloadSuccess");
                r.this.qS.qb = true;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f(long j2) {
        AdTemplate adTemplate = this.tz;
        if (adTemplate == null || this.tJ) {
            return;
        }
        if (this.tH <= 0) {
            this.tH = com.kwad.sdk.core.response.a.b.aW(adTemplate);
            this.tI = com.kwad.sdk.core.response.a.b.aV(this.tz) + this.tH;
        }
        long j3 = this.tH;
        if (j3 > 0 && !this.tG && j2 > j3) {
            this.tJ = !N(true);
            com.kwad.sdk.core.d.b.d("RewardPreEndCardPresenter", "showError: " + this.tJ);
            if (this.tJ) {
                return;
            } else {
                this.tG = true;
            }
        }
        boolean z2 = this.tq == 3;
        long j4 = this.tI;
        if (j4 <= 0 || z2 || j2 <= j4) {
            return;
        }
        O(true);
    }

    private Animator hZ() {
        ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(this.tu, "alpha", 255.0f, 0.0f);
        objectAnimatorOfFloat.setInterpolator(PathInterpolatorCompat.create(0.25f, 0.1f, 0.25f, 1.0f));
        objectAnimatorOfFloat.setDuration(200L);
        return objectAnimatorOfFloat;
    }

    private float ia() {
        return com.kwad.sdk.b.kwai.a.c(getActivity()) / this.tD;
    }

    private float ib() {
        return com.kwad.sdk.b.kwai.a.c(getActivity()) / this.tE;
    }

    @Override // com.kwad.components.ad.reward.presenter.a, com.kwad.sdk.mvp.Presenter
    public final void ar() {
        super.ar();
        this.qS.pw.a(this.mVideoPlayStateListener, this.mAdLivePlayStateListener);
        this.qS.b((com.kwad.components.ad.reward.d.f) this);
        com.kwad.components.ad.reward.j jVar = this.qS;
        this.mAdTemplate = jVar.mAdTemplate;
        jVar.a(this);
        this.tt = com.kwad.sdk.b.kwai.a.G(this.ts);
        com.kwad.sdk.b.kwai.a.o(this.ts, 49);
        this.oH.U(this.mAdTemplate);
    }

    @Override // com.kwad.components.ad.reward.d.f
    public final void bM() {
        int i2;
        if (this.tz == null || (i2 = this.tq) == 3) {
            return;
        }
        if (i2 == 1) {
            N(false);
            O(false);
        } else if (i2 == 2) {
            O(true);
        }
    }

    @Override // com.kwad.components.core.webview.jshandler.f.b
    public final void c(AdTemplate adTemplate, long j2) {
        com.kwad.components.core.g.c cVar = new com.kwad.components.core.g.c(adTemplate, com.kwad.components.core.g.e.AGGREGATION);
        com.kwad.components.ad.reward.j jVar = this.qS;
        if (jVar != null) {
            jVar.c(cVar);
        }
    }

    @Override // com.kwad.components.ad.reward.d.f
    public final int getPriority() {
        return 0;
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        super.onCreate();
        this.tr = findViewById(R.id.ksad_middle_end_card);
        this.ts = (DetailVideoView) findViewById(R.id.ksad_video_player);
        this.oH = (KsLogoView) findViewById(R.id.ksad_splash_logo_container);
        this.sq = (ImageView) findViewById(R.id.ksad_blur_video_cover);
        this.tu = findViewById(R.id.ksad_play_web_card_webView);
        this.tv = (FrameLayout) findViewById(R.id.ksad_middle_end_card_webview_container);
    }

    @Override // com.kwad.components.core.g.a.InterfaceC0399a
    public final void onError(int i2, String str) {
        com.kwad.sdk.core.d.b.w("RewardPreEndCardPresenter", "onError : msg " + str);
    }

    @Override // com.kwad.components.core.g.a.InterfaceC0399a
    public final void onInnerAdLoad(@Nullable List<com.kwad.components.core.g.c> list) {
        com.kwad.sdk.core.d.b.d("RewardPreEndCardPresenter", "onInnerAdLoad: " + list);
        if (list == null || list.size() == 0) {
            return;
        }
        this.tz = list.get(0).getAdTemplate();
        this.tA = list;
        ArrayList arrayList = new ArrayList();
        arrayList.add(this.mAdTemplate);
        arrayList.addAll(com.kwad.components.core.g.c.k(list));
        e(arrayList);
    }

    @Override // com.kwad.components.core.g.a.InterfaceC0399a
    public final void onRequestResult(int i2) {
        com.kwad.sdk.core.d.b.w("RewardPreEndCardPresenter", "onRequestResult : adNumber " + i2);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
        com.kwad.components.ad.reward.j jVar = this.qS;
        jVar.qb = false;
        jVar.pw.b(this.mVideoPlayStateListener, this.mAdLivePlayStateListener);
        this.qS.c(this);
        this.qS.b((a.InterfaceC0399a) this);
        com.kwad.components.ad.reward.g gVar = this.pD;
        if (gVar != null) {
            gVar.ko();
        }
        Animator animator = this.ty;
        if (animator != null) {
            animator.cancel();
        }
        DetailVideoView detailVideoView = this.ts;
        if (detailVideoView != null) {
            com.kwad.sdk.b.kwai.a.o(detailVideoView, this.tt);
        }
        Animator animator2 = this.tw;
        if (animator2 != null) {
            animator2.cancel();
        }
        this.ty = null;
        this.tw = null;
    }
}
