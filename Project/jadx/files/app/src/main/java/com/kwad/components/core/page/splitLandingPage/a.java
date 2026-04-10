package com.kwad.components.core.page.splitLandingPage;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Interpolator;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.components.core.d.b.c;
import com.kwad.components.core.l.f;
import com.kwad.components.core.page.a.b;
import com.kwad.components.core.page.recycle.e;
import com.kwad.components.core.page.splitLandingPage.view.SplitScrollWebView;
import com.kwad.components.core.page.splitLandingPage.view.a;
import com.kwad.components.core.r.o;
import com.kwad.components.core.widget.FeedVideoView;
import com.kwad.sdk.R;
import com.kwad.sdk.core.config.d;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.mvp.Presenter;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public final class a extends f {
    private FeedVideoView Ll;
    private SplitScrollWebView MY;
    private Presenter MZ;
    private com.kwad.components.core.page.splitLandingPage.view.a Na;
    private com.kwad.components.core.page.a.a Nb;
    private boolean Nc;
    private AdTemplate mAdTemplate;
    private c mApkDownloadHelper;
    private LinearLayout mWebTipBarLayout;

    public static a N(AdTemplate adTemplate) {
        a aVar = new a();
        Bundle bundle = new Bundle();
        bundle.putString("key_photo", adTemplate.toJson().toString());
        bundle.putBoolean("key_report", adTemplate.mPvReported);
        aVar.setArguments(bundle);
        return aVar;
    }

    static /* synthetic */ boolean a(a aVar, boolean z2) {
        aVar.Nc = false;
        return false;
    }

    private void i(ViewGroup viewGroup) {
        this.MZ = new Presenter();
        this.MZ.H(viewGroup);
        b bVar = new b();
        bVar.H(this.MY);
        this.Nb = new com.kwad.components.core.page.a.a();
        this.Nb.H(this.Ll);
        this.MZ.a(bVar);
        this.MZ.a(this.Nb);
    }

    private void initView() {
        e eVar = new e(this.mAdTemplate, this.mApkDownloadHelper, null);
        this.MZ.f(eVar);
        this.Na = new com.kwad.components.core.page.splitLandingPage.view.a(getContext(), new com.kwad.components.core.page.splitLandingPage.kwai.a(eVar.adTemplate, eVar.IZ));
        this.Na.a(new a.InterfaceC0407a() { // from class: com.kwad.components.core.page.splitLandingPage.a.3
            @Override // com.kwad.components.core.page.splitLandingPage.view.a.InterfaceC0407a
            public final boolean ph() {
                return a.this.pe();
            }
        });
        this.Ll.post(new Runnable() { // from class: com.kwad.components.core.page.splitLandingPage.a.4
            @Override // java.lang.Runnable
            public final void run() {
                a.this.MY.setTranslationY(a.this.MY.getTranslationY() + a.this.Ll.getHeight());
            }
        });
        this.MY.setSplitScrollWebViewListener(new SplitScrollWebView.a() { // from class: com.kwad.components.core.page.splitLandingPage.a.5
            @Override // com.kwad.components.core.page.splitLandingPage.view.SplitScrollWebView.a
            public final void d(float f2) {
                a.this.MY.setTranslationY(a.this.MY.getTranslationY() - f2);
            }

            @Override // com.kwad.components.core.page.splitLandingPage.view.SplitScrollWebView.a
            public final boolean pi() {
                if (!a.this.Na.pj() && d.uh() == 2) {
                    return false;
                }
                AnimatorSet animatorSet = new AnimatorSet();
                Animator animatorA = o.a(a.this.MY, (Interpolator) null, a.this.MY.getTranslationY(), 0.0f);
                if (d.uh() == 2) {
                    if (a.this.Ll.isComplete()) {
                        animatorSet.playTogether(animatorA);
                    } else {
                        animatorSet.playSequentially(animatorA, a.this.Na.aB(true));
                    }
                } else if (d.uh() == 1) {
                    animatorSet.playTogether(animatorA);
                }
                animatorSet.addListener(new AnimatorListenerAdapter() { // from class: com.kwad.components.core.page.splitLandingPage.a.5.1
                    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                    public final void onAnimationEnd(Animator animator) {
                        super.onAnimationEnd(animator);
                        a.this.Ll.pg();
                        if (d.uh() != 2 || a.this.Ll.isComplete()) {
                            return;
                        }
                        a.this.Na.pk();
                    }
                });
                animatorSet.start();
                return true;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean pe() {
        SplitScrollWebView splitScrollWebView = this.MY;
        if (splitScrollWebView == null || splitScrollWebView.getTranslationY() != 0.0f || this.Nc) {
            return false;
        }
        this.MY.setDisableAnimation(false);
        this.Nc = true;
        SplitScrollWebView splitScrollWebView2 = this.MY;
        Animator animatorA = o.a((View) splitScrollWebView2, (Interpolator) null, 0.0f, splitScrollWebView2.getTranslationY() + this.Ll.getHeight());
        AnimatorSet animatorSet = new AnimatorSet();
        if (d.uh() == 2 && this.Na.isVisible()) {
            this.Na.pg();
            animatorSet.playSequentially(this.Na.aB(false), animatorA);
        } else {
            animatorSet.play(animatorA);
        }
        animatorSet.addListener(new AnimatorListenerAdapter() { // from class: com.kwad.components.core.page.splitLandingPage.a.2
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public final void onAnimationEnd(Animator animator) {
                super.onAnimationEnd(animator);
                a.this.pf();
                a.this.Ll.pk();
                a.a(a.this, false);
            }
        });
        animatorSet.start();
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void pf() {
        this.Nb.ko();
        this.Nb.H(this.Ll);
        this.Nb.f(new e(this.mAdTemplate, this.mApkDownloadHelper, null));
    }

    private void w(View view) {
        this.mWebTipBarLayout = (LinearLayout) view.findViewById(R.id.ksad_web_tip_bar);
        TextView textView = (TextView) view.findViewById(R.id.ksad_web_tip_bar_textview);
        ((ImageView) view.findViewById(R.id.ksad_web_tip_close_btn)).setOnClickListener(new View.OnClickListener() { // from class: com.kwad.components.core.page.splitLandingPage.a.1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                a.this.mWebTipBarLayout.setVisibility(8);
            }
        });
        AdInfo adInfoCb = com.kwad.sdk.core.response.a.d.cb(this.mAdTemplate);
        boolean zBm = com.kwad.sdk.core.response.a.a.bm(adInfoCb);
        String strBi = com.kwad.sdk.core.response.a.a.bi(adInfoCb);
        if (!zBm) {
            this.mWebTipBarLayout.setVisibility(8);
            return;
        }
        this.mWebTipBarLayout.setVisibility(0);
        textView.setText(strBi);
        textView.setSelected(true);
    }

    @Override // com.kwad.components.core.l.f, com.kwad.sdk.h.kwai.b
    public final boolean bX() {
        SplitScrollWebView splitScrollWebView = this.MY;
        if (splitScrollWebView != null && splitScrollWebView.canGoBack()) {
            this.MY.goBack();
            return true;
        }
        if (pe()) {
            return true;
        }
        FeedVideoView feedVideoView = this.Ll;
        if (feedVideoView != null) {
            return feedVideoView.rP();
        }
        return false;
    }

    @Override // com.kwad.sdk.api.core.fragment.KsFragment, com.kwad.sdk.api.core.fragment.AbstractIFragmentLifecycle, com.kwad.sdk.api.core.fragment.IFragmentLifecycle
    public final void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        String string = getArguments().getString("key_photo");
        AdTemplate adTemplate = new AdTemplate();
        if (string != null) {
            try {
                adTemplate.parseJson(new JSONObject(string));
            } catch (JSONException e2) {
                com.kwad.sdk.core.d.b.printStackTrace(e2);
            }
        }
        this.mAdTemplate = adTemplate;
        this.mAdTemplate.mPvReported = getArguments().getBoolean("key_report", false);
        this.mAdTemplate.mAdWebVideoPageShowing = true;
    }

    @Override // com.kwad.sdk.api.core.fragment.KsFragment, com.kwad.sdk.api.core.fragment.AbstractIFragmentLifecycle, com.kwad.sdk.api.core.fragment.IFragmentLifecycle
    @Nullable
    public final View onCreateView(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        View viewInflate = layoutInflater.inflate(R.layout.ksad_split_land_page, viewGroup, false);
        this.Ll = (FeedVideoView) viewInflate.findViewById(R.id.ksad_split_land_ad_feed_video);
        this.MY = (SplitScrollWebView) viewInflate.findViewById(R.id.ksad_video_webView);
        w(viewInflate);
        i(viewGroup);
        return viewInflate;
    }

    @Override // com.kwad.components.core.l.f, com.kwad.sdk.api.core.fragment.KsFragment, com.kwad.sdk.api.core.fragment.AbstractIFragmentLifecycle, com.kwad.sdk.api.core.fragment.IFragmentLifecycle
    public final void onDestroy() {
        super.onDestroy();
        AdTemplate adTemplate = this.mAdTemplate;
        if (adTemplate != null) {
            adTemplate.mAdWebVideoPageShowing = false;
        }
    }

    @Override // com.kwad.sdk.api.core.fragment.KsFragment, com.kwad.sdk.api.core.fragment.AbstractIFragmentLifecycle, com.kwad.sdk.api.core.fragment.IFragmentLifecycle
    public final void onViewCreated(@NonNull View view, @Nullable Bundle bundle) {
        super.onViewCreated(view, bundle);
        initView();
    }

    public final void pg() {
        this.Ll.pg();
    }

    public final void setApkDownloadHelper(c cVar) {
        this.mApkDownloadHelper = cVar;
    }
}
