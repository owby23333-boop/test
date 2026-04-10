package com.kwad.components.ad.interstitial;

import android.app.Activity;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import com.anythink.expressad.foundation.g.a.f;
import com.bytedance.msdk.adapter.util.TTLogUtil;
import com.kwad.components.ad.interstitial.e.g;
import com.kwad.components.ad.interstitial.e.h;
import com.kwad.sdk.api.KsAdVideoPlayConfig;
import com.kwad.sdk.api.KsInterstitialAd;
import com.kwad.sdk.api.KsVideoPlayConfig;
import com.kwad.sdk.core.report.KSLoggerReporter;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.utils.ah;
import com.kwad.sdk.utils.bg;
import com.kwai.adclient.logger.model.BusinessType;

/* JADX INFO: loaded from: classes2.dex */
public final class d extends com.kwad.components.core.l.e {
    private com.kwad.components.ad.interstitial.e.a hG;
    private boolean hH;
    private com.kwad.components.ad.interstitial.d.b hI;

    @NonNull
    private final KsAdVideoPlayConfig hJ;
    private KsInterstitialAd.AdInteractionListener hK;
    private final h hL;
    private final AdTemplate mAdTemplate;
    private bg mTimerHelper;

    public d(@NonNull Activity activity, @NonNull AdTemplate adTemplate, KsVideoPlayConfig ksVideoPlayConfig, KsInterstitialAd.AdInteractionListener adInteractionListener) {
        super(activity);
        this.hL = new h() { // from class: com.kwad.components.ad.interstitial.d.1
            @Override // com.kwad.components.ad.interstitial.e.h
            public final void j(boolean z2) {
                if (d.this.hH) {
                    Activity activity2 = d.this.mActivity;
                    com.kwad.sdk.core.b.b.we();
                    if (activity2 == com.kwad.sdk.core.b.b.getCurrentActivity()) {
                        com.kwad.sdk.core.report.a.i(d.this.mAdTemplate, z2 ? 2 : 1);
                        d.this.cp();
                    }
                }
            }
        };
        this.hK = adInteractionListener;
        this.hJ = new KsAdVideoPlayConfig.Builder().videoSoundEnable(ksVideoPlayConfig != null && ksVideoPlayConfig.isVideoSoundEnable()).dataFlowAutoStart(com.kwad.components.ad.interstitial.kwai.b.cH()).build();
        this.mAdTemplate = adTemplate;
    }

    private boolean cn() {
        AdInfo adInfoCb = com.kwad.sdk.core.response.a.d.cb(this.mAdTemplate);
        return com.kwad.sdk.core.response.a.a.bW(adInfoCb) && !co() && com.kwad.components.ad.interstitial.a.a.cO() < com.kwad.sdk.core.response.a.a.bZ(adInfoCb);
    }

    private boolean co() {
        return com.kwad.sdk.core.response.a.b.aM(this.mAdTemplate) && com.kwad.components.ad.interstitial.b.a.cQ() < com.kwad.sdk.core.config.d.a(com.kwad.sdk.core.config.c.acl);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cp() {
        int iBT = com.kwad.sdk.core.response.a.a.bT(com.kwad.sdk.core.response.a.d.cb(this.mAdTemplate));
        this.hG = cn() ? new com.kwad.components.ad.interstitial.aggregate.b(this.mContext) : (TextUtils.isEmpty(com.kwad.sdk.core.response.a.b.bh(this.mAdTemplate)) || !ah.cu(this.mContext)) ? new com.kwad.components.ad.interstitial.e.c(this.mContext) : iBT == 2 ? new com.kwad.components.ad.interstitial.e.e(this.mContext) : iBT == 1 ? new com.kwad.components.ad.interstitial.e.d(this.mContext) : new com.kwad.components.ad.interstitial.e.c(this.mContext);
        this.hG.a(this.mAdTemplate, this, this.hJ, this.hK);
        this.yX.removeAllViews();
        this.yX.addView(this.hG);
        cq();
    }

    private void cq() {
        this.hI = new com.kwad.components.ad.interstitial.d.b(this.hG, 100);
        this.hI.a(new com.kwad.sdk.core.g.c() { // from class: com.kwad.components.ad.interstitial.d.2
            @Override // com.kwad.sdk.core.g.c
            public final void aS() {
                d.this.getTimerHelper().ET();
            }

            @Override // com.kwad.sdk.core.g.c
            public final void aT() {
                d.this.getTimerHelper().EU();
            }
        });
        this.hI.rU();
    }

    @Override // com.kwad.components.core.l.e
    public final ViewGroup cm() {
        g gVar = new g(this.mContext);
        gVar.setOrientationChangeListener(this.hL);
        return gVar;
    }

    @Override // com.kwad.components.core.l.e, android.app.Dialog, android.content.DialogInterface
    public final void dismiss() {
        super.dismiss();
        com.kwad.sdk.kwai.kwai.c.tm().tp();
        KsInterstitialAd.AdInteractionListener adInteractionListener = this.hK;
        if (adInteractionListener != null) {
            adInteractionListener.onPageDismiss();
        }
    }

    @Override // com.kwad.components.core.l.e
    public final void g(View view) {
        cp();
        com.kwad.sdk.f.a.U(f.f10438d, TTLogUtil.TAG_EVENT_SHOW);
        KSLoggerReporter.ReportClient.CORE_CONVERT.buildMethodCheck(BusinessType.AD_INTERSTITIAL, "adShowSuccess").report();
    }

    @Override // com.kwad.components.core.l.e
    public final int getLayoutId() {
        return 0;
    }

    public final bg getTimerHelper() {
        if (this.mTimerHelper == null) {
            this.mTimerHelper = new bg();
        }
        return this.mTimerHelper;
    }

    @Override // android.app.Dialog
    public final void onBackPressed() {
        if (com.kwad.components.ad.interstitial.kwai.b.cL()) {
            super.onBackPressed();
        }
    }

    @Override // android.app.Dialog, android.view.Window.Callback
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        com.kwad.components.ad.interstitial.d.b bVar = this.hI;
        if (bVar != null) {
            bVar.release();
        }
    }

    @Override // android.app.Dialog, android.view.Window.Callback
    public final void onWindowFocusChanged(boolean z2) {
        super.onWindowFocusChanged(z2);
        this.hH = z2;
        com.kwad.components.ad.interstitial.e.a aVar = this.hG;
        if (aVar != null) {
            if (z2) {
                aVar.cu();
            } else {
                aVar.cv();
            }
        }
    }

    public final void setAdInteractionListener(KsInterstitialAd.AdInteractionListener adInteractionListener) {
        this.hK = adInteractionListener;
        com.kwad.components.ad.interstitial.e.a aVar = this.hG;
        if (aVar != null) {
            aVar.setAdInteractionListener(adInteractionListener);
        }
    }
}
