package com.kwad.components.core.page.splitLandingPage;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Interpolator;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.kwad.components.core.e.d.c;
import com.kwad.components.core.page.c.b;
import com.kwad.components.core.page.splitLandingPage.view.SplitScrollWebView;
import com.kwad.components.core.page.splitLandingPage.view.a;
import com.kwad.components.core.proxy.h;
import com.kwad.components.core.t.o;
import com.kwad.components.core.widget.FeedVideoView;
import com.kwad.sdk.R;
import com.kwad.sdk.core.response.b.e;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.mvp.Presenter;
import com.kwad.sdk.utils.bg;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
public final class a extends h {
    private FeedVideoView Tb;
    private LinearLayout Tc;
    private SplitScrollWebView Ve;
    private Presenter Vf;
    private com.kwad.components.core.page.splitLandingPage.view.a Vg;
    private com.kwad.components.core.page.c.a Vh;
    private boolean Vi;
    private AdTemplate mAdTemplate;
    private c mApkDownloadHelper;

    static /* synthetic */ boolean a(a aVar, boolean z) {
        aVar.Vi = false;
        return false;
    }

    public static a aE(AdTemplate adTemplate) {
        a aVar = new a();
        Bundle bundle = new Bundle();
        bundle.putString("key_photo", adTemplate.toJson().toString());
        bundle.putBoolean("key_report", adTemplate.mPvReported);
        aVar.setArguments(bundle);
        return aVar;
    }

    @Override // com.kwad.components.core.proxy.h, com.kwad.sdk.api.core.fragment.KsFragment, com.kwad.sdk.api.core.fragment.AbstractIFragmentLifecycle, com.kwad.sdk.api.core.fragment.IFragmentLifecycle
    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        String string = getArguments().getString("key_photo");
        AdTemplate adTemplate = new AdTemplate();
        if (string != null) {
            try {
                adTemplate.parseJson(new JSONObject(string));
            } catch (JSONException e) {
                com.kwad.sdk.core.d.c.printStackTrace(e);
            }
        }
        this.mAdTemplate = adTemplate;
        adTemplate.mPvReported = getArguments().getBoolean("key_report", false);
        this.mAdTemplate.mAdWebVideoPageShowing = true;
    }

    @Override // com.kwad.components.core.proxy.h, com.kwad.sdk.api.core.fragment.KsFragment, com.kwad.sdk.api.core.fragment.AbstractIFragmentLifecycle, com.kwad.sdk.api.core.fragment.IFragmentLifecycle
    public final void onDestroy() {
        super.onDestroy();
        AdTemplate adTemplate = this.mAdTemplate;
        if (adTemplate != null) {
            adTemplate.mAdWebVideoPageShowing = false;
        }
    }

    private void z(View view) {
        this.Tc = (LinearLayout) view.findViewById(R.id.ksad_web_tip_bar);
        TextView textView = (TextView) view.findViewById(R.id.ksad_web_tip_bar_textview);
        ((ImageView) view.findViewById(R.id.ksad_web_tip_close_btn)).setOnClickListener(new View.OnClickListener() { // from class: com.kwad.components.core.page.splitLandingPage.a.1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                a.this.Tc.setVisibility(8);
            }
        });
        AdInfo adInfoEl = e.el(this.mAdTemplate);
        boolean zBz = com.kwad.sdk.core.response.b.a.bz(adInfoEl);
        String strBv = com.kwad.sdk.core.response.b.a.bv(adInfoEl);
        if (zBz) {
            this.Tc.setVisibility(0);
            textView.setText(strBv);
            textView.setSelected(true);
            return;
        }
        this.Tc.setVisibility(8);
    }

    public final void setApkDownloadHelper(c cVar) {
        this.mApkDownloadHelper = cVar;
    }

    @Override // com.kwad.components.core.proxy.h, com.kwad.sdk.m.a.b
    public final boolean onBackPressed() {
        SplitScrollWebView splitScrollWebView = this.Ve;
        if (splitScrollWebView != null && splitScrollWebView.canGoBack()) {
            this.Ve.goBack();
            return true;
        }
        if (rH()) {
            return true;
        }
        FeedVideoView feedVideoView = this.Tb;
        if (feedVideoView != null) {
            return feedVideoView.wc();
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean rH() {
        SplitScrollWebView splitScrollWebView = this.Ve;
        if (splitScrollWebView == null || splitScrollWebView.getTranslationY() != 0.0f || this.Vi) {
            return false;
        }
        this.Ve.setDisableAnimation(false);
        this.Vi = true;
        SplitScrollWebView splitScrollWebView2 = this.Ve;
        Animator animatorA = o.a((View) splitScrollWebView2, (Interpolator) null, 0.0f, splitScrollWebView2.getTranslationY() + this.Tb.getHeight());
        AnimatorSet animatorSet = new AnimatorSet();
        if (com.kwad.sdk.core.config.e.EP() == 2 && this.Vg.isVisible()) {
            this.Vg.rJ();
            animatorSet.playSequentially(this.Vg.aK(false), animatorA);
        } else {
            animatorSet.play(animatorA);
        }
        animatorSet.addListener(new AnimatorListenerAdapter() { // from class: com.kwad.components.core.page.splitLandingPage.a.2
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public final void onAnimationEnd(Animator animator) {
                super.onAnimationEnd(animator);
                a.this.rI();
                a.this.Tb.rN();
                a.a(a.this, false);
            }
        });
        animatorSet.start();
        return true;
    }

    private void j(ViewGroup viewGroup) {
        Presenter presenter = new Presenter();
        this.Vf = presenter;
        presenter.K(viewGroup);
        b bVar = new b();
        bVar.K(this.Ve);
        com.kwad.components.core.page.c.a aVar = new com.kwad.components.core.page.c.a();
        this.Vh = aVar;
        aVar.K(this.Tb);
        this.Vf.a(bVar);
        this.Vf.a(this.Vh);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void rI() {
        this.Vh.ny();
        this.Vh.K(this.Tb);
        this.Vh.n(new com.kwad.components.core.page.recycle.e(this.mAdTemplate, this.mApkDownloadHelper, null));
    }

    public final void rJ() {
        this.Tb.rJ();
    }

    @Override // com.kwad.components.core.proxy.h
    public final int qN() {
        return R.layout.ksad_split_land_page;
    }

    @Override // com.kwad.sdk.api.core.fragment.KsFragment, com.kwad.sdk.api.core.fragment.AbstractIFragmentLifecycle, com.kwad.sdk.api.core.fragment.IFragmentLifecycle
    public final void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        this.Tb = (FeedVideoView) findViewById(R.id.ksad_split_land_ad_feed_video);
        this.Ve = (SplitScrollWebView) findViewById(R.id.ksad_video_webView);
        z(view);
        j(this.nY);
        initView();
    }

    private void initView() {
        com.kwad.components.core.page.recycle.e eVar = new com.kwad.components.core.page.recycle.e(this.mAdTemplate, this.mApkDownloadHelper, null);
        this.Vf.n(eVar);
        com.kwad.components.core.page.splitLandingPage.view.a aVar = new com.kwad.components.core.page.splitLandingPage.view.a(this.mContext, new com.kwad.components.core.page.splitLandingPage.a.a(eVar.adTemplate, eVar.Pc));
        this.Vg = aVar;
        aVar.a(new a.InterfaceC0347a() { // from class: com.kwad.components.core.page.splitLandingPage.a.3
            @Override // com.kwad.components.core.page.splitLandingPage.view.a.InterfaceC0347a
            public final boolean rK() {
                return a.this.rH();
            }
        });
        this.Tb.post(new bg() { // from class: com.kwad.components.core.page.splitLandingPage.a.4
            @Override // com.kwad.sdk.utils.bg
            public final void doTask() {
                a.this.Ve.setTranslationY(a.this.Ve.getTranslationY() + a.this.Tb.getHeight());
            }
        });
        this.Ve.setSplitScrollWebViewListener(new SplitScrollWebView.a() { // from class: com.kwad.components.core.page.splitLandingPage.a.5
            @Override // com.kwad.components.core.page.splitLandingPage.view.SplitScrollWebView.a
            public final boolean rL() {
                if (!a.this.Vg.rM() && com.kwad.sdk.core.config.e.EP() == 2) {
                    return false;
                }
                AnimatorSet animatorSet = new AnimatorSet();
                Animator animatorA = o.a(a.this.Ve, (Interpolator) null, a.this.Ve.getTranslationY(), 0.0f);
                if (com.kwad.sdk.core.config.e.EP() == 2) {
                    if (!a.this.Tb.isComplete()) {
                        animatorSet.playSequentially(animatorA, a.this.Vg.aK(true));
                    } else {
                        animatorSet.playTogether(animatorA);
                    }
                } else if (com.kwad.sdk.core.config.e.EP() == 1) {
                    animatorSet.playTogether(animatorA);
                }
                animatorSet.addListener(new AnimatorListenerAdapter() { // from class: com.kwad.components.core.page.splitLandingPage.a.5.1
                    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                    public final void onAnimationEnd(Animator animator) {
                        super.onAnimationEnd(animator);
                        a.this.Tb.rJ();
                        if (com.kwad.sdk.core.config.e.EP() != 2 || a.this.Tb.isComplete()) {
                            return;
                        }
                        a.this.Vg.rN();
                    }
                });
                animatorSet.start();
                return true;
            }

            @Override // com.kwad.components.core.page.splitLandingPage.view.SplitScrollWebView.a
            public final void f(float f) {
                a.this.Ve.setTranslationY(a.this.Ve.getTranslationY() - f);
            }
        });
    }
}
