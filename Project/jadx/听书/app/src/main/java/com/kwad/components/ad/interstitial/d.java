package com.kwad.components.ad.interstitial;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import com.kwad.components.core.e.a.h;
import com.kwad.components.core.proxy.g;
import com.kwad.sdk.api.KsAdVideoPlayConfig;
import com.kwad.sdk.api.KsInterstitialAd;
import com.kwad.sdk.api.KsVideoPlayConfig;
import com.kwad.sdk.core.response.model.AdResultData;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.utils.bv;

/* JADX INFO: loaded from: classes3.dex */
public final class d extends g {
    private com.kwad.components.ad.interstitial.h.a kM;
    private boolean kN;
    private com.kwad.components.ad.interstitial.g.b kO;
    private final KsAdVideoPlayConfig kP;
    private KsInterstitialAd.AdInteractionListener kQ;
    private final com.kwad.components.core.widget.g kR;
    private final AdResultData mAdResultData;
    private final AdTemplate mAdTemplate;
    private bv mTimerHelper;

    @Override // com.kwad.components.core.proxy.g
    public final float dv() {
        return 0.0f;
    }

    @Override // com.kwad.components.core.proxy.g
    public final int getLayoutId() {
        return 0;
    }

    public final void setAdInteractionListener(KsInterstitialAd.AdInteractionListener adInteractionListener) {
        this.kQ = adInteractionListener;
        com.kwad.components.ad.interstitial.h.a aVar = this.kM;
        if (aVar != null) {
            aVar.setAdInteractionListener(adInteractionListener);
        }
    }

    public final bv getTimerHelper() {
        if (this.mTimerHelper == null) {
            this.mTimerHelper = new bv();
        }
        return this.mTimerHelper;
    }

    public d(Activity activity, AdResultData adResultData, KsVideoPlayConfig ksVideoPlayConfig, KsInterstitialAd.AdInteractionListener adInteractionListener) {
        super(activity);
        this.kR = new com.kwad.components.core.widget.g() { // from class: com.kwad.components.ad.interstitial.d.1
            @Override // com.kwad.components.core.widget.g
            public final void k(boolean z) {
                if (d.this.kN) {
                    Activity activity2 = d.this.mActivity;
                    com.kwad.sdk.core.c.b.Ho();
                    if (activity2 == com.kwad.sdk.core.c.b.getCurrentActivity()) {
                        com.kwad.sdk.core.adlog.c.i(d.this.mAdTemplate, z ? 2 : 1);
                        d.this.dx();
                    }
                }
            }
        };
        this.kQ = adInteractionListener;
        this.kP = new KsAdVideoPlayConfig.Builder().videoSoundEnable(ksVideoPlayConfig != null && ksVideoPlayConfig.isVideoSoundEnable()).dataFlowAutoStart(com.kwad.components.ad.interstitial.b.b.dH()).build();
        this.mAdResultData = adResultData;
        this.mAdTemplate = com.kwad.sdk.core.response.b.c.r(adResultData);
    }

    @Override // com.kwad.components.core.proxy.g
    public final ViewGroup dw() {
        com.kwad.components.core.widget.f fVar = new com.kwad.components.core.widget.f(this.mContext);
        fVar.setOrientationChangeListener(this.kR);
        return fVar;
    }

    @Override // com.kwad.components.core.proxy.g
    public final void h(View view) {
        h.a(getWindow());
        dx();
        com.kwad.components.ad.interstitial.report.c.eS().A(this.mAdTemplate);
        com.kwad.sdk.commercial.d.c.bL(this.mAdTemplate);
    }

    private static boolean e(AdResultData adResultData) {
        return com.kwad.sdk.core.response.b.c.u(adResultData);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dx() {
        com.kwad.components.ad.interstitial.h.a cVar;
        if (e(this.mAdResultData)) {
            cVar = new com.kwad.components.ad.interstitial.aggregate.b(this.mContext);
        } else {
            cVar = new com.kwad.components.ad.interstitial.h.c(this.mContext);
        }
        com.kwad.components.ad.interstitial.h.a aVar = cVar;
        this.kM = aVar;
        aVar.a(this.mAdResultData, this, this.kP, this.kQ, 0);
        this.CC.removeAllViews();
        this.CC.addView(this.kM);
        dy();
    }

    private void dy() {
        com.kwad.components.ad.interstitial.g.b bVar = new com.kwad.components.ad.interstitial.g.b(this.kM, 100);
        this.kO = bVar;
        bVar.a(new com.kwad.sdk.core.j.c() { // from class: com.kwad.components.ad.interstitial.d.2
            @Override // com.kwad.sdk.core.j.c
            public final void bt() {
                d.this.getTimerHelper().Sl();
            }

            @Override // com.kwad.sdk.core.j.c
            public final void bu() {
                d.this.getTimerHelper().Sm();
            }
        });
        this.kO.wi();
    }

    @Override // android.app.Dialog, android.view.Window.Callback
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        com.kwad.components.ad.interstitial.g.b bVar = this.kO;
        if (bVar != null) {
            bVar.release();
        }
    }

    @Override // android.app.Dialog, android.view.Window.Callback
    public final void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        this.kN = z;
        com.kwad.components.ad.interstitial.h.a aVar = this.kM;
        if (aVar != null) {
            if (z) {
                aVar.dA();
            } else {
                aVar.dB();
            }
        }
    }

    @Override // com.kwad.components.core.proxy.g, android.app.Dialog, android.content.DialogInterface
    public final void dismiss() {
        try {
            super.dismiss();
            com.kwad.sdk.a.a.c.CU().CX();
            KsInterstitialAd.AdInteractionListener adInteractionListener = this.kQ;
            if (adInteractionListener != null) {
                adInteractionListener.onPageDismiss();
            }
            com.kwad.components.ad.interstitial.h.a aVar = this.kM;
            if ((aVar instanceof com.kwad.components.ad.interstitial.h.c) && !((com.kwad.components.ad.interstitial.h.c) aVar).fd() && com.kwad.sdk.core.response.b.a.cS(com.kwad.sdk.core.response.b.e.el(this.mAdTemplate))) {
                com.kwad.sdk.core.adlog.c.m(this.mAdTemplate, (int) Math.ceil(getTimerHelper().getTime() / 1000.0f));
            }
            h.oR();
            com.kwad.components.core.g.a.a(com.kwad.sdk.commercial.d.be(this.mAdTemplate));
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }

    @Override // android.app.Dialog
    public final void onBackPressed() {
        if (com.kwad.components.ad.interstitial.b.b.dL()) {
            super.onBackPressed();
        }
    }
}
