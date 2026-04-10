package com.kwad.components.ad.interstitial.c;

import android.annotation.SuppressLint;
import android.text.TextUtils;
import android.view.ViewGroup;
import com.arialyy.aria.core.listener.ISchedulers;
import com.kwad.components.ad.interstitial.c.c;
import com.kwad.components.core.video.a;
import com.kwad.components.core.widget.KsAutoCloseView;
import com.kwad.sdk.R;
import com.kwad.sdk.api.KsInterstitialAd;
import com.kwad.sdk.core.imageloader.KSImageLoader;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.widget.KSFrameLayout;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public final class g extends b {
    private com.kwad.components.core.widget.kwai.b bY;
    private com.kwad.sdk.core.video.videoview.a eM;
    private KsAutoCloseView jn;
    private c jq;
    private boolean kV;
    private KSFrameLayout kW;
    private com.kwad.sdk.core.g.d kX = new com.kwad.sdk.core.g.d() { // from class: com.kwad.components.ad.interstitial.c.g.4
        @Override // com.kwad.sdk.core.g.d, com.kwad.sdk.core.g.c
        public final void aS() {
            if (!g.this.mAdTemplate.mPvReported && !g.this.jq.jv && g.this.jq.hK != null) {
                g.this.jq.hK.onAdShow();
                g.this.jq.hR.getTimerHelper().startTiming();
                com.kwad.components.ad.interstitial.monitor.b.cR();
                com.kwad.components.ad.interstitial.monitor.b.b(g.this.jq.mAdTemplate, 1);
            }
            com.kwad.components.core.r.c.qa().a(g.this.mAdTemplate, null, new com.kwad.sdk.core.report.i().bp(g.this.jq.jG));
            g.this.jn.setCountDownPaused(false);
        }

        @Override // com.kwad.sdk.core.g.d, com.kwad.sdk.core.g.c
        public final void aT() {
            g.this.jn.setCountDownPaused(true);
        }
    };
    private AdInfo mAdInfo;
    private AdTemplate mAdTemplate;

    private static boolean d(AdInfo adInfo) {
        return adInfo.adInsertScreenInfo.autoCloseTime > 0 && !com.kwad.sdk.core.response.a.a.bu(adInfo);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dM() {
        final com.kwad.components.ad.interstitial.e.f fVar = this.jq.jr;
        fVar.setAdTemplate(this.mAdTemplate);
        if (com.kwad.sdk.core.response.a.a.aW(this.mAdInfo)) {
            fVar.a(com.kwad.sdk.core.response.a.a.aN(this.mAdInfo).materialUrl, this.mAdTemplate);
            fVar.b(true, true);
            fVar.t(false);
        } else {
            fVar.t(true);
            String url = com.kwad.sdk.core.response.a.a.bh(this.mAdInfo).getUrl();
            if (TextUtils.isEmpty(url)) {
                fVar.b(false, false);
            } else {
                fVar.a(url, this.mAdTemplate);
                fVar.b(true, false);
            }
            this.eM = this.jq.eM;
            if (this.eM.getParent() != null) {
                ((ViewGroup) this.eM.getParent()).removeView(this.eM);
            }
            if (com.kwad.sdk.core.response.a.a.aV(this.mAdInfo)) {
                fVar.a(com.kwad.sdk.core.response.a.a.aO(this.mAdInfo).height / com.kwad.sdk.core.response.a.a.aO(this.mAdInfo).width, this.eM);
            }
            fVar.u(this.jq.dY.isVideoSoundEnable());
            final int iF = com.kwad.sdk.core.response.a.a.F(this.mAdInfo);
            this.jq.a(new a.c() { // from class: com.kwad.components.ad.interstitial.c.g.5
                @Override // com.kwad.components.core.video.a.c
                public final void bt() {
                    g.this.eM.setVisibility(8);
                    if (g.this.jq.M(g.this.getContext())) {
                        return;
                    }
                    fVar.eC();
                }

                @Override // com.kwad.components.core.video.a.c
                @SuppressLint({"SetTextI18n"})
                public final void d(long j2) {
                    int i2 = iF - ((int) (j2 / 1000));
                    com.kwad.components.ad.interstitial.e.f fVar2 = fVar;
                    if (i2 >= 0) {
                        fVar2.C(String.valueOf(i2));
                    } else {
                        fVar2.eA();
                    }
                }

                @Override // com.kwad.components.core.video.a.c
                public final void onVideoPlayStart() {
                    fVar.t(true);
                }

                @Override // com.kwad.components.core.video.a.c
                public final void onVideoPlaying() {
                    fVar.b(false, false);
                }
            });
            fVar.a(this.mAdTemplate, this.mAdInfo);
            fVar.t(true);
            this.jq.jC.add(new c.InterfaceC0358c() { // from class: com.kwad.components.ad.interstitial.c.g.6
                @Override // com.kwad.components.ad.interstitial.c.c.InterfaceC0358c
                public final void dg() {
                    fVar.eD();
                    g.this.eM.setVisibility(0);
                }
            });
        }
        this.jq.a(getContext(), this.mAdInfo, this.mAdTemplate, fVar.getBlurBgView());
        String strH = com.kwad.sdk.core.response.a.a.H(this.mAdInfo);
        if (TextUtils.isEmpty(strH)) {
            strH = com.kwad.sdk.core.response.a.a.P(this.mAdInfo);
        }
        KSImageLoader.loadImage(fVar.getTailFrameView(), strH, this.mAdTemplate);
        if (!d(this.mAdInfo)) {
            this.jn.aP(false);
        } else {
            this.jn.aP(true);
            dN();
        }
    }

    private void dN() {
        AdInfo adInfo = this.mAdInfo;
        int iMin = adInfo.adInsertScreenInfo.autoCloseTime;
        if (com.kwad.sdk.core.response.a.a.aV(adInfo)) {
            iMin = Math.min(iMin, com.kwad.sdk.core.response.a.a.F(this.mAdInfo));
            this.jq.jr.eA();
            this.jq.jr.eB();
        }
        this.jn.Y(iMin);
        com.kwad.sdk.core.report.a.b(this.mAdTemplate, ISchedulers.SUB_FAIL, (JSONObject) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(int i2, int i3) {
        this.jq.a(new c.b(getContext()).k(this.kV).a(this.kW.getTouchCoords()).C(i2).D(i3));
        if (com.kwad.components.ad.interstitial.kwai.b.cN()) {
            c cVar = this.jq;
            if (cVar.hR != null) {
                cVar.a(false, -1, cVar.eM);
                this.jq.hR.dismiss();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void n(boolean z2) {
        KsInterstitialAd.AdInteractionListener adInteractionListener;
        c cVar = this.jq;
        if (!cVar.jv && !z2 && !cVar.jt && !cVar.ju && com.kwad.components.ad.interstitial.d.a.c(cVar)) {
            this.jq.ju = true;
            com.kwad.components.ad.interstitial.a.b.K(getContext());
            return;
        }
        this.jq.a(z2, -1, this.eM);
        this.jq.hR.dismiss();
        com.kwad.sdk.core.video.videoview.a aVar = this.eM;
        if (aVar != null) {
            aVar.release();
        }
        c cVar2 = this.jq;
        if (cVar2.jv || (adInteractionListener = cVar2.hK) == null) {
            return;
        }
        adInteractionListener.onAdClosed();
    }

    @Override // com.kwad.components.ad.interstitial.c.b, com.kwad.sdk.mvp.Presenter
    public final void ar() {
        super.ar();
        this.jq = (c) Bs();
        AdTemplate adTemplate = this.jq.mAdTemplate;
        this.mAdTemplate = adTemplate;
        this.mAdInfo = com.kwad.sdk.core.response.a.d.cb(adTemplate);
        this.jq.jr.j(this.mAdTemplate);
        this.jq.a(new c.e() { // from class: com.kwad.components.ad.interstitial.c.g.2
            @Override // com.kwad.components.ad.interstitial.c.c.e
            public final void onError() {
                g.this.dM();
            }
        });
        this.jq.jr.setViewListener(new com.kwad.components.ad.interstitial.e.i() { // from class: com.kwad.components.ad.interstitial.c.g.3
            @Override // com.kwad.components.ad.interstitial.e.i
            public final void a(KSFrameLayout kSFrameLayout) {
                g.this.kW = kSFrameLayout;
            }

            @Override // com.kwad.components.ad.interstitial.e.i
            public final void dP() {
                g.this.n(false);
            }

            @Override // com.kwad.components.ad.interstitial.e.i
            public final void dQ() {
                g.this.e(3, g.this.jq.jr.eE() ? 53 : 85);
            }

            @Override // com.kwad.components.ad.interstitial.e.i
            public final void dR() {
                g.this.e(1, 39);
            }

            @Override // com.kwad.components.ad.interstitial.e.i
            public final void dS() {
                g.this.e(1, 29);
            }

            @Override // com.kwad.components.ad.interstitial.e.i
            public final void dT() {
                g.this.e(3, 85);
            }

            @Override // com.kwad.components.ad.interstitial.e.i
            public final void dU() {
                g.this.e(3, 85);
            }

            @Override // com.kwad.components.ad.interstitial.e.i
            public final void dV() {
                g.this.e(2, 53);
            }

            @Override // com.kwad.components.ad.interstitial.e.i
            public final void dW() {
                g.this.e(2, 30);
            }

            @Override // com.kwad.components.ad.interstitial.e.i
            public final void dX() {
                g.this.e(2, 31);
            }

            @Override // com.kwad.components.ad.interstitial.e.i
            public final void dY() {
                g.this.e(2, 32);
            }

            @Override // com.kwad.components.ad.interstitial.e.i
            public final void dZ() {
                g.this.e(2, 15);
            }

            @Override // com.kwad.components.ad.interstitial.e.i
            public final void ea() {
                g.this.e(2, 16);
            }

            @Override // com.kwad.components.ad.interstitial.e.i
            public final void eb() {
                g.this.e(2, 17);
            }

            @Override // com.kwad.components.ad.interstitial.e.i
            public final void ec() {
                g.this.e(2, 35);
            }

            @Override // com.kwad.components.ad.interstitial.e.i
            public final void o(boolean z2) {
                if (g.this.eM != null) {
                    g.this.eM.setVideoSoundEnable(z2);
                }
            }

            @Override // com.kwad.components.ad.interstitial.e.i
            public final void p(boolean z2) {
                g.this.kV = z2;
            }
        });
        this.bY = new com.kwad.components.core.widget.kwai.b(this.jq.jr, 100);
        this.bY.a(this.kX);
        this.bY.rU();
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        super.onCreate();
        this.jn = (KsAutoCloseView) findViewById(R.id.ksad_interstitial_auto_close);
        this.jn.setViewListener(new KsAutoCloseView.a() { // from class: com.kwad.components.ad.interstitial.c.g.1
            @Override // com.kwad.components.core.widget.KsAutoCloseView.a
            public final void dO() {
                g.this.n(true);
            }

            @Override // com.kwad.components.core.widget.KsAutoCloseView.a
            public final void dP() {
                g.this.n(false);
            }
        });
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
        this.bY.b(this.kX);
        this.bY.rV();
    }
}
