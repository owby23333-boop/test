package com.kwad.components.ad.interstitial;

import android.app.Activity;
import android.os.SystemClock;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.anythink.expressad.foundation.g.a.f;
import com.bytedance.msdk.adapter.util.TTLogUtil;
import com.kuaishou.pushad.KsAdGlobalWatcher;
import com.kwad.sdk.KsAdSDKImpl;
import com.kwad.sdk.api.KsInterstitialAd;
import com.kwad.sdk.api.KsScene;
import com.kwad.sdk.api.KsVideoPlayConfig;
import com.kwad.sdk.api.model.AdExposureFailedReason;
import com.kwad.sdk.components.DevelopMangerComponents;
import com.kwad.sdk.core.report.KSLoggerReporter;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwai.adclient.logger.model.BusinessType;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public final class b implements com.kwad.components.core.internal.api.a, KsInterstitialAd {
    private com.kwad.components.core.internal.api.c ch = new com.kwad.components.core.internal.api.c();
    private KsScene hB;
    private c hC;
    private d hD;

    @NonNull
    private final AdTemplate mAdTemplate;

    public b(@NonNull KsScene ksScene, @NonNull AdTemplate adTemplate) {
        this.hB = ksScene;
        this.mAdTemplate = adTemplate;
        KsAdGlobalWatcher.getInstance().watch(this);
    }

    @Override // com.kwad.components.core.internal.api.a
    public final void a(com.kwad.components.core.internal.api.b bVar) {
        this.ch.a(bVar);
    }

    @Override // com.kwad.components.core.internal.api.a
    public final boolean ao() {
        return true;
    }

    @Override // com.kwad.components.core.internal.api.a
    public final void b(com.kwad.components.core.internal.api.b bVar) {
        this.ch.b(bVar);
    }

    @Override // com.kwad.components.core.internal.api.a
    public final AdTemplate getAdTemplate() {
        return this.mAdTemplate;
    }

    @Override // com.kwad.sdk.api.KsInterstitialAd
    public final int getECPM() {
        return com.kwad.sdk.core.response.a.a.aK(com.kwad.sdk.core.response.a.d.cb(this.mAdTemplate));
    }

    @Override // com.kwad.sdk.api.KsInterstitialAd
    public final int getInteractionType() {
        return com.kwad.sdk.core.response.a.a.aJ(com.kwad.sdk.core.response.a.d.cb(this.mAdTemplate));
    }

    @Override // com.kwad.sdk.api.KsInterstitialAd
    public final int getMaterialType() {
        return com.kwad.sdk.core.response.a.a.aX(com.kwad.sdk.core.response.a.d.cb(this.mAdTemplate));
    }

    @Override // com.kwad.sdk.api.BaseKSAd
    public final Map<String, Object> getMediaExtraInfo() {
        HashMap map = new HashMap();
        if (com.kwad.sdk.core.config.d.uD()) {
            map.put("llsid", Long.valueOf(this.mAdTemplate.llsid));
        }
        return map;
    }

    @Override // com.kwad.sdk.api.KsInterstitialAd
    public final boolean isVideo() {
        return com.kwad.sdk.core.response.a.a.aV(com.kwad.sdk.core.response.a.d.cb(this.mAdTemplate));
    }

    @Override // com.kwad.sdk.api.KsInterstitialAd
    public final void reportAdExposureFailed(int i2, AdExposureFailedReason adExposureFailedReason) {
        com.kwad.sdk.core.report.a.a(this.mAdTemplate, i2, adExposureFailedReason);
    }

    @Override // com.kwad.sdk.api.KsInterstitialAd
    public final void setAdInteractionListener(@NonNull KsInterstitialAd.AdInteractionListener adInteractionListener) {
        if (this.hC == null) {
            this.hC = new c() { // from class: com.kwad.components.ad.interstitial.b.1
                @Override // com.kwad.components.ad.interstitial.c, com.kwad.sdk.api.KsInterstitialAd.AdInteractionListener
                public final void onAdShow() {
                    super.onAdShow();
                    b.this.ch.a(b.this);
                }

                @Override // com.kwad.components.ad.interstitial.c, com.kwad.sdk.api.KsInterstitialAd.AdInteractionListener
                public final void onPageDismiss() {
                    super.onPageDismiss();
                    b.this.ch.b(b.this);
                }
            };
        }
        this.hC.a(adInteractionListener);
        d dVar = this.hD;
        if (dVar != null) {
            dVar.setAdInteractionListener(this.hC);
        }
    }

    @Override // com.kwad.sdk.api.KsInterstitialAd
    public final void setBidEcpm(int i2) {
        setBidEcpm(i2, -1L);
    }

    @Override // com.kwad.sdk.api.KsInterstitialAd
    public final void setBidEcpm(long j2, long j3) {
        AdTemplate adTemplate = this.mAdTemplate;
        adTemplate.mBidEcpm = j2;
        com.kwad.sdk.core.report.a.j(adTemplate, j2);
    }

    @Override // com.kwad.sdk.api.KsInterstitialAd
    public final void showInterstitialAd(Activity activity, @Nullable KsVideoPlayConfig ksVideoPlayConfig) {
        if (activity == null || activity.isFinishing()) {
            com.kwad.sdk.core.d.b.e("StayAdHelper", "showInterstitialAd activity must not be null");
            return;
        }
        if (!KsAdSDKImpl.get().hasInitFinish()) {
            com.kwad.sdk.core.d.b.e("StayAdHelper", "showInterstitialAd please init sdk first");
        }
        if (ksVideoPlayConfig == null) {
            ksVideoPlayConfig = new KsVideoPlayConfig.Builder().build();
        }
        com.kwad.sdk.f.a.T(f.f10438d, TTLogUtil.TAG_EVENT_SHOW);
        KSLoggerReporter.ReportClient.CORE_CONVERT.buildMethodCheck(BusinessType.AD_INTERSTITIAL, "callShow").report();
        com.kwad.components.ad.interstitial.monitor.b.cR();
        com.kwad.components.ad.interstitial.monitor.b.h(this.hB.getPosId());
        this.mAdTemplate.adShowStartTimeStamp = SystemClock.elapsedRealtime();
        com.kwad.sdk.components.c.f(DevelopMangerComponents.class);
        if (ksVideoPlayConfig.isVideoSoundEnable()) {
            this.mAdTemplate.mInitVoiceStatus = 2;
        } else {
            this.mAdTemplate.mInitVoiceStatus = 1;
        }
        com.kwad.sdk.kwai.kwai.c.tm().aR(true);
        if (this.hD == null) {
            this.hD = new d(activity, this.mAdTemplate, ksVideoPlayConfig, this.hC);
            this.hD.show();
            com.kwad.components.ad.interstitial.a.b.J(activity);
        }
    }
}
