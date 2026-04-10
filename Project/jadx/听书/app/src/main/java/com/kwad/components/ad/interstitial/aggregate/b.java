package com.kwad.components.ad.interstitial.aggregate;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import androidx.viewpager.widget.ViewPager;
import com.kwad.components.ad.interstitial.aggregate.ViewPagerIndicator;
import com.kwad.components.ad.interstitial.aggregate.a;
import com.kwad.sdk.R;
import com.kwad.sdk.api.KsAdVideoPlayConfig;
import com.kwad.sdk.api.KsInterstitialAd;
import com.kwad.sdk.core.j.c;
import com.kwad.sdk.core.j.d;
import com.kwad.sdk.core.response.model.AdGlobalConfigInfo;
import com.kwad.sdk.core.response.model.AdResultData;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.o.m;
import com.kwad.sdk.utils.aq;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public final class b extends com.kwad.components.ad.interstitial.h.a {
    private com.kwad.components.core.widget.a.b fg;
    private final c fo;
    protected KsInterstitialAd.AdInteractionListener kQ;
    private TransViewPager lc;
    private a ld;
    private ViewPagerIndicator le;
    private ValueAnimator lf;
    private boolean lg;
    private int lh;
    private int li;
    private boolean lj;
    private final ViewPager.OnPageChangeListener lk;
    protected AdResultData mAdResultData;
    private final List<AdTemplate> mAdTemplateList;
    private final View mRootView;

    @Override // com.kwad.components.ad.interstitial.h.a
    public final void dA() {
    }

    @Override // com.kwad.components.ad.interstitial.h.a
    public final void dB() {
    }

    public b(Context context) {
        this(context, null);
    }

    private b(Context context, AttributeSet attributeSet) {
        super(context, null);
        this.mAdTemplateList = new ArrayList();
        this.lh = 10;
        this.li = 0;
        this.fo = new d() { // from class: com.kwad.components.ad.interstitial.aggregate.b.6
            @Override // com.kwad.sdk.core.j.d, com.kwad.sdk.core.j.c
            public final void bt() {
                super.bt();
                if (b.this.lg) {
                    if (b.this.le != null) {
                        b.this.le.dG();
                    }
                    if (b.this.lf != null) {
                        b.this.lf.resume();
                    }
                    b.this.lg = false;
                }
            }

            @Override // com.kwad.sdk.core.j.d, com.kwad.sdk.core.j.c
            public final void bu() {
                super.bu();
                if (b.this.lg) {
                    return;
                }
                if (b.this.le != null) {
                    b.this.le.dF();
                }
                if (b.this.lf != null) {
                    b.this.lf.pause();
                }
                b.this.lg = true;
            }
        };
        this.lk = new ViewPager.SimpleOnPageChangeListener() { // from class: com.kwad.components.ad.interstitial.aggregate.b.7
            private int ln = 0;

            @Override // androidx.viewpager.widget.ViewPager.SimpleOnPageChangeListener, androidx.viewpager.widget.ViewPager.OnPageChangeListener
            public final void onPageScrolled(int i, float f, int i2) {
            }

            @Override // androidx.viewpager.widget.ViewPager.SimpleOnPageChangeListener, androidx.viewpager.widget.ViewPager.OnPageChangeListener
            public final void onPageSelected(int i) {
                com.kwad.components.ad.interstitial.h.c cVarJ = b.this.lc.J(i);
                if (cVarJ != null) {
                    cVarJ.fa();
                }
                if (this.ln != i) {
                    com.kwad.sdk.core.adlog.c.a((AdTemplate) b.this.mAdTemplateList.get(this.ln), -1L, (JSONObject) null);
                    com.kwad.components.ad.interstitial.h.c cVarJ2 = b.this.lc.J(this.ln);
                    if (cVarJ2 != null) {
                        cVarJ2.fb();
                    }
                }
                this.ln = i;
            }
        };
        this.mContext = context;
        this.mRootView = m.inflate(context, R.layout.ksad_interstitial_multi_ad, this);
        initView();
    }

    private void initView() {
        this.lc = (TransViewPager) this.mRootView.findViewById(R.id.ksad_multi_ad_container);
        this.le = (ViewPagerIndicator) this.mRootView.findViewById(R.id.ksad_multi_ad_indicator);
        this.fg = new com.kwad.components.core.widget.a.b(this.mRootView, 100);
    }

    @Override // com.kwad.components.ad.interstitial.h.a
    public final void a(AdResultData adResultData, com.kwad.components.ad.interstitial.d dVar, KsAdVideoPlayConfig ksAdVideoPlayConfig, KsInterstitialAd.AdInteractionListener adInteractionListener, int i) {
        this.mAdResultData = adResultData;
        this.lh = g(adResultData);
        this.mAdTemplateList.clear();
        this.mAdTemplateList.addAll(this.mAdResultData.getAdTemplateList());
        this.li = this.mAdTemplateList.size();
        this.kQ = adInteractionListener;
        a aVar = new a(this.mAdResultData, dVar, ksAdVideoPlayConfig, adInteractionListener);
        this.ld = aVar;
        aVar.a(new a.b() { // from class: com.kwad.components.ad.interstitial.aggregate.b.1
            @Override // com.kwad.components.ad.interstitial.aggregate.a.b
            public final void a(com.kwad.components.ad.interstitial.h.c cVar, int i2) {
                b.this.lc.a(i2, cVar);
            }
        });
        this.ld.a(new a.InterfaceC0280a() { // from class: com.kwad.components.ad.interstitial.aggregate.b.2
            @Override // com.kwad.components.ad.interstitial.aggregate.a.InterfaceC0280a
            public final void dz() {
                if (b.this.lf != null) {
                    b.this.lf.cancel();
                }
                b.this.le.setPlayProgressListener(null);
                b.this.le.setVisibility(8);
            }
        });
        this.lc.setAdapter(this.ld);
        this.lc.setScrollable(false);
        this.lc.setOffscreenPageLimit(this.mAdTemplateList.size() - 1);
        this.lc.addOnPageChangeListener(this.lk);
        this.ld.d(this.mAdTemplateList);
        this.ld.notifyDataSetChanged();
        this.fg.a(this.fo);
        this.fg.wi();
        if (this.le == null) {
            return;
        }
        dC();
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.le.getLayoutParams();
        if (marginLayoutParams != null) {
            this.lj = aq.QW();
            marginLayoutParams.bottomMargin = com.kwad.sdk.c.a.a.a(this.mContext, this.lj ? 12.0f : 6.0f);
            this.le.setLayoutParams(marginLayoutParams);
        }
        this.le.setAdShowTime(this.lh);
        this.le.setVisibility(0);
        this.le.setViewPager(this.lc);
    }

    @Override // com.kwad.components.ad.interstitial.h.a
    public final void setAdInteractionListener(KsInterstitialAd.AdInteractionListener adInteractionListener) {
        this.kQ = adInteractionListener;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.fg.b(this.fo);
        this.fg.wj();
        this.mAdTemplateList.clear();
        this.lc.clearOnPageChangeListeners();
    }

    private void dC() {
        this.le.setPlayProgressListener(new ViewPagerIndicator.a() { // from class: com.kwad.components.ad.interstitial.aggregate.b.3
            @Override // com.kwad.components.ad.interstitial.aggregate.ViewPagerIndicator.a
            public final void I(int i) {
                b.this.H(i);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void H(final int i) {
        final int width = getWidth();
        ValueAnimator valueAnimatorOfInt = ValueAnimator.ofInt(0, width);
        this.lf = valueAnimatorOfInt;
        valueAnimatorOfInt.setDuration(800L);
        this.lf.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.kwad.components.ad.interstitial.aggregate.b.4
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (i < b.this.li - 1) {
                    int iIntValue = ((Integer) valueAnimator.getAnimatedValue()).intValue();
                    b.this.lc.scrollTo((i * width) + iIntValue, 0);
                    b.this.lc.onPageScrolled(i + 1, iIntValue / width, 0);
                }
            }
        });
        this.lf.addListener(new AnimatorListenerAdapter() { // from class: com.kwad.components.ad.interstitial.aggregate.b.5
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public final void onAnimationEnd(Animator animator) {
                if (i < b.this.li - 1) {
                    b.this.lc.setCurrentItem(i + 1);
                }
            }
        });
        this.lf.start();
    }

    private static int g(AdResultData adResultData) {
        AdGlobalConfigInfo.CycleAggregationInfo cycleAggregationInfoT;
        if (adResultData == null || (cycleAggregationInfoT = com.kwad.sdk.core.response.b.c.t(adResultData)) == null) {
            return 10;
        }
        return cycleAggregationInfoT.cycleAggregationInterval;
    }
}
