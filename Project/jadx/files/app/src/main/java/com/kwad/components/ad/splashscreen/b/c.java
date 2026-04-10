package com.kwad.components.ad.splashscreen.b;

import android.annotation.SuppressLint;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.kwad.components.ad.splashscreen.local.SplashSkipViewModel;
import com.kwad.components.ad.splashscreen.widget.SkipView;
import com.kwad.components.core.page.AdLandPageActivityProxy;
import com.kwad.sdk.R;
import com.kwad.sdk.core.report.y;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.view.AdBaseFrameLayout;
import com.kwad.sdk.utils.ba;
import com.kwad.sdk.utils.bg;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public final class c extends e implements com.kwad.sdk.core.g.c {
    private TextView Cp;
    private com.kwad.components.ad.splashscreen.widget.a Cq;
    private AdInfo.AdPreloadInfo Cr;
    private boolean Cs = false;
    private View Ct;
    private AdInfo sr;

    private SplashSkipViewModel la() {
        SplashSkipViewModel splashSkipViewModel = new SplashSkipViewModel();
        int i2 = this.sr.adSplashInfo.imageDisplaySecond;
        if (i2 <= 0) {
            i2 = 5;
        }
        AdInfo adInfo = this.sr;
        int iMin = Math.min(adInfo.adSplashInfo.videoDisplaySecond, com.kwad.sdk.core.response.a.a.F(adInfo));
        if (com.kwad.sdk.core.response.a.a.aV(this.sr)) {
            i2 = iMin;
        }
        splashSkipViewModel.skipSecond = i2;
        return splashSkipViewModel;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void lb() {
        this.Cx.kQ();
        JSONObject jSONObject = new JSONObject();
        com.kwad.components.ad.splashscreen.d.a aVar = this.Cx.BY;
        if (aVar != null) {
            try {
                jSONObject.put("duration", aVar.getCurrentPosition());
            } catch (JSONException e2) {
                com.kwad.sdk.core.d.b.printStackTrace(e2);
            }
        }
        y.a aVar2 = new y.a();
        bg bgVar = this.Cx.mTimerHelper;
        if (bgVar != null) {
            aVar2.duration = bgVar.getTime();
        }
        com.kwad.sdk.core.report.a.b(this.Cx.mAdTemplate, new com.kwad.sdk.core.report.i().bg(1).bm(22).a(aVar2), jSONObject);
    }

    private synchronized void ld() {
        if (!this.Cs && this.Cq != null) {
            if (com.kwad.sdk.core.response.a.a.cc(this.sr) && com.kwad.sdk.core.response.a.a.cd(this.sr)) {
                com.kwad.sdk.core.report.a.b(this.Cx.mAdTemplate, 124, (JSONObject) null);
                this.Cs = true;
            }
        }
    }

    private static boolean q(AdInfo adInfo) {
        return !com.kwad.sdk.core.response.a.a.ca(adInfo);
    }

    private void r(AdInfo adInfo) {
        this.Cp = (TextView) this.Cx.mRootContainer.findViewById(R.id.ksad_splash_preload_tips);
        this.Cr = adInfo.adPreloadInfo;
        this.Cp.setVisibility(8);
        AdInfo.AdPreloadInfo adPreloadInfo = this.Cr;
        if (adPreloadInfo == null || ba.isNullString(adPreloadInfo.preloadTips)) {
            this.Cp.setVisibility(8);
        } else {
            this.Cp.setVisibility(0);
            this.Cp.setText(this.Cr.preloadTips);
        }
    }

    private void s(AdInfo adInfo) {
        this.Ct = this.Cx.mRootContainer.findViewById(R.id.ksad_skip_view_area);
        if (!com.kwad.sdk.core.response.a.a.cb(adInfo) || adInfo.adSplashInfo.skipButtonPosition != 0) {
            this.Ct.setVisibility(8);
            return;
        }
        this.Ct.setVisibility(0);
        this.Ct.setOnClickListener(new View.OnClickListener() { // from class: com.kwad.components.ad.splashscreen.b.c.2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                c.this.lb();
            }
        });
        this.Ct.post(new Runnable() { // from class: com.kwad.components.ad.splashscreen.b.c.3
            @Override // java.lang.Runnable
            public final void run() {
                ((View) c.this.Cq).post(new Runnable() { // from class: com.kwad.components.ad.splashscreen.b.c.3.1
                    @Override // java.lang.Runnable
                    public final void run() {
                        int iAf = c.this.Cq.af(35);
                        ViewGroup.LayoutParams layoutParams = c.this.Ct.getLayoutParams();
                        layoutParams.width = iAf + com.kwad.sdk.b.kwai.a.a(c.this.Cx.mRootContainer.getContext(), 66.0f);
                        c.this.Ct.setLayoutParams(layoutParams);
                    }
                });
            }
        });
    }

    @Override // com.kwad.sdk.core.g.c
    public final void aS() {
        com.kwad.sdk.core.d.b.d("SkipAdPresenter", "onPageVisible");
        this.Cq.v(this.sr);
        ld();
    }

    @Override // com.kwad.sdk.core.g.c
    public final void aT() {
        com.kwad.sdk.core.d.b.d("SkipAdPresenter", "onPageInvisible");
        this.Cq.u(this.sr);
    }

    @Override // com.kwad.components.ad.splashscreen.b.e, com.kwad.sdk.mvp.Presenter
    @SuppressLint({"SetTextI18n"})
    public final void ar() {
        AdBaseFrameLayout adBaseFrameLayout;
        int i2;
        super.ar();
        com.kwad.sdk.core.d.b.d("SkipAdPresenter", "onBind");
        this.sr = com.kwad.sdk.core.response.a.d.cb(this.Cx.mAdTemplate);
        r(this.sr);
        if (q(this.sr)) {
            adBaseFrameLayout = this.Cx.mRootContainer;
            i2 = R.id.ksad_splash_skip_view;
        } else {
            adBaseFrameLayout = this.Cx.mRootContainer;
            i2 = R.id.ksad_splash_circle_skip_view;
        }
        this.Cq = (com.kwad.components.ad.splashscreen.widget.a) adBaseFrameLayout.findViewById(i2);
        this.Cq.a(la(), this.sr);
        this.Cq.setOnViewListener(new SkipView.a() { // from class: com.kwad.components.ad.splashscreen.b.c.1
            @Override // com.kwad.components.ad.splashscreen.widget.SkipView.a
            public final void ac(int i3) {
                c.this.Cx.ab(i3);
            }

            @Override // com.kwad.components.ad.splashscreen.widget.SkipView.a
            public final void le() {
                c.this.lb();
            }

            @Override // com.kwad.components.ad.splashscreen.widget.SkipView.a
            public final void lf() {
                c.this.lc();
            }
        });
        s(this.sr);
        this.Cx.BZ.a(this);
    }

    public final void lc() {
        this.Cx.mRootContainer.post(new Runnable() { // from class: com.kwad.components.ad.splashscreen.b.c.4
            @Override // java.lang.Runnable
            public final void run() {
                if (com.kwad.components.core.d.a.b.na() || AdLandPageActivityProxy.isDownloadDialogShowing()) {
                    c.this.Cx.mRootContainer.postDelayed(this, 1000L);
                } else {
                    c.this.Cx.kO();
                }
            }
        });
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
        this.Cx.BZ.b(this);
        this.Cq.bn();
    }
}
