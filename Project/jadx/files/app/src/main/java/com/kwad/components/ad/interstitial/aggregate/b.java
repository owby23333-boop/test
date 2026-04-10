package com.kwad.components.ad.interstitial.aggregate;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.content.Context;
import android.os.Build;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;
import android.view.animation.AnimationSet;
import android.view.animation.TranslateAnimation;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewpager.widget.ViewPager;
import com.kwad.components.ad.interstitial.aggregate.ViewPagerIndicator;
import com.kwad.components.ad.interstitial.aggregate.a;
import com.kwad.components.ad.interstitial.aggregate.c;
import com.kwad.sdk.R;
import com.kwad.sdk.api.KsAdVideoPlayConfig;
import com.kwad.sdk.api.KsInterstitialAd;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.utils.ah;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public final class b extends com.kwad.components.ad.interstitial.e.a {
    private com.kwad.components.core.widget.kwai.b bY;
    private final com.kwad.sdk.core.g.c dj;
    protected KsInterstitialAd.AdInteractionListener hK;
    private boolean hS;
    private TransViewPager hW;
    private a hX;
    private ViewPagerIndicator hY;
    private SlideTipsView hZ;
    private SlideTipsView ia;
    private ValueAnimator ib;
    private boolean ic;
    private InterstitialAggregateManualTipsView ie;

    /* JADX INFO: renamed from: if, reason: not valid java name */
    private boolean f62if;
    private boolean ig;
    private final ViewPager.OnPageChangeListener ih;
    protected AdInfo mAdInfo;

    @NonNull
    protected AdTemplate mAdTemplate;
    private final List<AdTemplate> mAdTemplateList;
    private final View mRootView;

    public b(@NonNull Context context) {
        this(context, null);
    }

    private b(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, null);
        this.mAdTemplateList = new ArrayList();
        this.dj = new com.kwad.sdk.core.g.d() { // from class: com.kwad.components.ad.interstitial.aggregate.b.2
            @Override // com.kwad.sdk.core.g.d, com.kwad.sdk.core.g.c
            public final void aS() {
                super.aS();
                if (Build.VERSION.SDK_INT >= 19 && b.this.ic) {
                    if (b.this.hY != null) {
                        b.this.hY.cG();
                    }
                    if (b.this.ib != null) {
                        b.this.ib.resume();
                    }
                    b.this.ic = false;
                }
            }

            @Override // com.kwad.sdk.core.g.d, com.kwad.sdk.core.g.c
            public final void aT() {
                super.aT();
                if (Build.VERSION.SDK_INT >= 19 && !b.this.ic) {
                    if (b.this.hY != null) {
                        b.this.hY.cF();
                    }
                    if (b.this.ib != null) {
                        b.this.ib.pause();
                    }
                    b.this.ic = true;
                }
            }
        };
        this.ih = new ViewPager.SimpleOnPageChangeListener() { // from class: com.kwad.components.ad.interstitial.aggregate.b.3
            private int ik = 0;

            @Override // androidx.viewpager.widget.ViewPager.SimpleOnPageChangeListener, androidx.viewpager.widget.ViewPager.OnPageChangeListener
            public final void onPageScrolled(int i2, float f2, int i3) {
                if (f2 != 0.0f) {
                    if (b.this.hZ.getVisibility() == 0) {
                        b.this.hZ.clearAnimation();
                        b.this.hZ.setVisibility(8);
                    }
                    if (b.this.ia.getVisibility() == 0) {
                        b.this.ia.clearAnimation();
                        b.this.ia.setVisibility(8);
                    }
                }
            }

            @Override // androidx.viewpager.widget.ViewPager.SimpleOnPageChangeListener, androidx.viewpager.widget.ViewPager.OnPageChangeListener
            public final void onPageSelected(int i2) {
                com.kwad.components.ad.interstitial.e.c cVarB = b.this.hW.B(i2);
                if (cVarB != null) {
                    cVarB.ew();
                }
                if (this.ik != i2) {
                    com.kwad.sdk.core.report.a.a((AdTemplate) b.this.mAdTemplateList.get(this.ik), -1L, (JSONObject) null);
                    com.kwad.components.ad.interstitial.e.c cVarB2 = b.this.hW.B(this.ik);
                    if (cVarB2 != null) {
                        cVarB2.ex();
                    }
                }
                this.ik = i2;
            }
        };
        this.mContext = context;
        this.mRootView = com.kwad.sdk.i.a.inflate(context, R.layout.ksad_interstitial_multi_ad, this);
        initView();
    }

    static /* synthetic */ AnimationSet a(b bVar, float f2, float f3) {
        return b(f2, f3);
    }

    static /* synthetic */ boolean a(b bVar, boolean z2) {
        bVar.ig = true;
        return true;
    }

    private static AnimationSet b(float f2, float f3) {
        TranslateAnimation translateAnimation = new TranslateAnimation(1, f2, 1, f3, 1, 0.0f, 1, 0.0f);
        AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 0.8f);
        AnimationSet animationSet = new AnimationSet(true);
        animationSet.addAnimation(translateAnimation);
        animationSet.addAnimation(alphaAnimation);
        animationSet.setDuration(800L);
        animationSet.setFillAfter(true);
        return animationSet;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ct() {
        if (this.mAdTemplate.mAdScene != null) {
            c.cA().a(16, com.kwad.components.ad.interstitial.kwai.b.cM(), this.mAdTemplate.mAdScene, new c.b() { // from class: com.kwad.components.ad.interstitial.aggregate.b.6
                @Override // com.kwad.components.ad.interstitial.aggregate.c.b
                public final void onInterstitialAdLoad(@Nullable List<AdTemplate> list) {
                    if (list == null || list.size() <= 0) {
                        return;
                    }
                    b.this.mAdTemplateList.addAll(list);
                    b.this.hX.setAdTemplateList(b.this.mAdTemplateList);
                    b.this.hX.notifyDataSetChanged();
                    b.this.hW.setOffscreenPageLimit(b.this.mAdTemplateList.size() - 1);
                    b.this.hW.addOnPageChangeListener(b.this.ih);
                    b.this.cw();
                    b.this.hY.setViewPager(b.this.hW);
                    b.this.hY.setVisibility(0);
                    b.this.bY.a(b.this.dj);
                    com.kwad.components.ad.interstitial.a.a.J(b.this.mContext);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cw() {
        this.hY.setPlayProgressListener(new ViewPagerIndicator.a() { // from class: com.kwad.components.ad.interstitial.aggregate.b.7
            @Override // com.kwad.components.ad.interstitial.aggregate.ViewPagerIndicator.a
            public final void cz() {
                b.a(b.this, true);
                if (b.this.hS) {
                    b.this.cy();
                } else {
                    b.this.cx();
                }
                b.this.hW.setScrollable(true);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cx() {
        if (this.f62if) {
            this.ie.a(this.mAdTemplate, this.hW);
        }
        this.ib = ValueAnimator.ofInt(0, 120, 0);
        this.ib.setDuration(1200L);
        this.ib.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.kwad.components.ad.interstitial.aggregate.b.8
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                b.this.hW.scrollTo(com.kwad.sdk.b.kwai.a.a(b.this.mContext, ((Integer) valueAnimator.getAnimatedValue()).intValue()), 0);
                b.this.hW.onPageScrolled(0, com.kwad.sdk.b.kwai.a.a(b.this.mContext, r4) / b.this.getWidth(), 0);
            }
        });
        this.ib.addListener(new AnimatorListenerAdapter() { // from class: com.kwad.components.ad.interstitial.aggregate.b.9
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public final void onAnimationEnd(Animator animator) {
                if (b.this.f62if) {
                    AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
                    alphaAnimation.setDuration(200L);
                    alphaAnimation.setFillAfter(true);
                    b.this.ie.startAnimation(alphaAnimation);
                    b.this.ie.setVisibility(0);
                }
                b.this.hZ.setVisibility(0);
                b.this.hZ.startAnimation(b.a(b.this, 0.5f, 0.1f));
            }
        });
        this.ib.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cy() {
        this.ib = ValueAnimator.ofInt(0, getWidth());
        this.ib.setDuration(800L);
        this.ib.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.kwad.components.ad.interstitial.aggregate.b.10
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                int iIntValue = ((Integer) valueAnimator.getAnimatedValue()).intValue();
                b.this.hW.scrollTo(iIntValue, 0);
                b.this.hW.onPageScrolled(0, iIntValue / b.this.getWidth(), 0);
            }
        });
        this.ib.addListener(new AnimatorListenerAdapter() { // from class: com.kwad.components.ad.interstitial.aggregate.b.11
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public final void onAnimationEnd(Animator animator) {
                b.this.hW.setCurrentItem(1);
                b.this.ia.setVisibility(0);
                b.this.ia.startAnimation(b.a(b.this, -0.5f, -0.1f));
            }
        });
        this.ib.start();
    }

    private void initView() {
        this.hW = (TransViewPager) this.mRootView.findViewById(R.id.ksad_multi_ad_container);
        this.hY = (ViewPagerIndicator) this.mRootView.findViewById(R.id.ksad_multi_ad_indicator);
        this.hZ = (SlideTipsView) this.mRootView.findViewById(R.id.ksad_left_slide);
        this.ia = (SlideTipsView) this.mRootView.findViewById(R.id.ksad_right_slide);
        this.ie = (InterstitialAggregateManualTipsView) this.mRootView.findViewById(R.id.ksad_manual_tips_view);
        this.bY = new com.kwad.components.core.widget.kwai.b(this.mRootView, 100);
    }

    @Override // com.kwad.components.ad.interstitial.e.a
    public final void a(@NonNull AdTemplate adTemplate, com.kwad.components.ad.interstitial.d dVar, @NonNull KsAdVideoPlayConfig ksAdVideoPlayConfig, KsInterstitialAd.AdInteractionListener adInteractionListener) {
        float f2;
        this.mAdTemplate = adTemplate;
        this.mAdInfo = com.kwad.sdk.core.response.a.d.cb(this.mAdTemplate);
        this.hS = com.kwad.sdk.core.response.a.a.bX(this.mAdInfo) == 1;
        this.mAdTemplateList.clear();
        this.mAdTemplateList.add(this.mAdTemplate);
        this.hK = adInteractionListener;
        this.hX = new a(adTemplate, dVar, ksAdVideoPlayConfig, adInteractionListener);
        this.hX.a(new a.b() { // from class: com.kwad.components.ad.interstitial.aggregate.b.1
            @Override // com.kwad.components.ad.interstitial.aggregate.a.b
            public final void a(com.kwad.components.ad.interstitial.e.c cVar, int i2) {
                b.this.hW.a(i2, cVar);
            }
        });
        this.hX.a(new a.InterfaceC0354a() { // from class: com.kwad.components.ad.interstitial.aggregate.b.4
            @Override // com.kwad.components.ad.interstitial.aggregate.a.InterfaceC0354a
            public final void cs() {
                if (b.this.ig) {
                    return;
                }
                if (b.this.ib != null) {
                    b.this.ib.cancel();
                }
                b.this.hY.setPlayProgressListener(null);
                b.this.hY.setVisibility(8);
                b.this.hW.setScrollable(false);
            }
        });
        this.hW.setAdapter(this.hX);
        this.hX.setAdTemplateList(this.mAdTemplateList);
        this.hX.notifyDataSetChanged();
        this.bY.rU();
        ViewPagerIndicator viewPagerIndicator = this.hY;
        if (viewPagerIndicator == null) {
            return;
        }
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) viewPagerIndicator.getLayoutParams();
        if (marginLayoutParams != null) {
            this.f62if = ah.cu(this.mContext);
            Context context = this.mContext;
            if (this.f62if) {
                f2 = this.hS ? 12 : 4;
            } else {
                f2 = 6.0f;
            }
            marginLayoutParams.bottomMargin = com.kwad.sdk.b.kwai.a.a(context, f2);
            this.hY.setLayoutParams(marginLayoutParams);
        }
        this.hY.setFirstAdShowTime(com.kwad.sdk.core.response.a.a.bY(this.mAdInfo));
        post(new Runnable() { // from class: com.kwad.components.ad.interstitial.aggregate.b.5
            @Override // java.lang.Runnable
            public final void run() {
                b.this.ct();
            }
        });
    }

    @Override // com.kwad.components.ad.interstitial.e.a
    public final void cu() {
    }

    @Override // com.kwad.components.ad.interstitial.e.a
    public final void cv() {
    }

    @Override // android.view.ViewGroup, android.view.View
    protected final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.bY.b(this.dj);
        this.bY.rV();
        this.mAdTemplateList.clear();
        this.hW.clearOnPageChangeListeners();
        c.cA().release();
    }

    @Override // com.kwad.components.ad.interstitial.e.a
    public final void setAdInteractionListener(KsInterstitialAd.AdInteractionListener adInteractionListener) {
        this.hK = adInteractionListener;
    }
}
