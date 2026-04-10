package com.kwad.components.ad.reward;

import android.app.Activity;
import androidx.annotation.NonNull;
import com.bytedance.msdk.adapter.util.TTLogUtil;
import com.kuaishou.pushad.KsAdGlobalWatcher;
import com.kwad.components.ad.reward.page.AdRewardPreviewActivityProxy;
import com.kwad.sdk.api.KsInnerAd;
import com.kwad.sdk.api.KsRewardVideoAd;
import com.kwad.sdk.api.KsVideoPlayConfig;
import com.kwad.sdk.api.model.AdExposureFailedReason;
import com.kwad.sdk.components.DevelopMangerComponents;
import com.kwad.sdk.core.report.KSLoggerReporter;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwai.adclient.logger.model.BusinessType;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes3.dex */
public final class f implements com.kwad.components.core.internal.api.a, KsRewardVideoAd {
    private final AdInfo mAdInfo;

    @NonNull
    private final AdTemplate mAdTemplate;
    private com.kwad.components.core.g.d oc;
    private com.kwad.components.ad.reward.d.g pl;
    private KsRewardVideoAd.RewardAdInteractionListener pm;
    private com.kwad.components.core.internal.api.c ch = new com.kwad.components.core.internal.api.c();
    public int rewardType = 1;

    public f(@NonNull AdTemplate adTemplate) {
        this.mAdTemplate = adTemplate;
        this.mAdInfo = com.kwad.sdk.core.response.a.d.cb(adTemplate);
        KsAdGlobalWatcher.getInstance().watch(this);
    }

    private void a(Activity activity, @NonNull KsVideoPlayConfig ksVideoPlayConfig) {
        com.kwad.sdk.components.c.f(DevelopMangerComponents.class);
        com.kwad.sdk.components.c.f(DevelopMangerComponents.class);
        fJ();
        if (com.kwad.sdk.core.response.a.a.bI(this.mAdInfo)) {
            AdRewardPreviewActivityProxy.launch(activity, this.mAdTemplate, com.kwad.sdk.core.response.a.a.aL(this.mAdInfo), this.pl);
        } else {
            KSRewardVideoActivityProxy.launch(activity, this.mAdTemplate, ksVideoPlayConfig, this.pl, this.pm, this.oc, this.rewardType);
        }
    }

    private void fJ() {
        AdInfo adInfo;
        if (com.kwad.components.ad.reward.b.c.a(this.pl) || (adInfo = this.mAdInfo) == null) {
            return;
        }
        adInfo.adBaseInfo.extraClickReward = false;
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

    @Override // com.kwad.sdk.api.KsRewardVideoAd
    public final int getECPM() {
        return com.kwad.sdk.core.response.a.a.aK(this.mAdInfo);
    }

    @Override // com.kwad.sdk.api.KsRewardVideoAd
    public final int getInteractionType() {
        return com.kwad.sdk.core.response.a.a.aJ(this.mAdInfo);
    }

    @Override // com.kwad.sdk.api.KsRewardVideoAd
    public final int getMaterialType() {
        return com.kwad.sdk.core.response.a.a.aX(this.mAdInfo);
    }

    @Override // com.kwad.sdk.api.BaseKSAd
    public final Map<String, Object> getMediaExtraInfo() {
        HashMap map = new HashMap();
        if (com.kwad.sdk.core.config.d.uD()) {
            map.put("llsid", Long.valueOf(this.mAdTemplate.llsid));
        }
        return map;
    }

    @Override // com.kwad.sdk.api.KsRewardVideoAd
    public final boolean isAdEnable() {
        if (com.kwad.sdk.core.config.d.uJ() >= 0) {
            return true;
        }
        return com.kwad.components.core.video.h.i(this.mAdTemplate);
    }

    @Override // com.kwad.sdk.api.KsRewardVideoAd
    public final void reportAdExposureFailed(int i2, AdExposureFailedReason adExposureFailedReason) {
        com.kwad.sdk.core.report.a.a(this.mAdTemplate, i2, adExposureFailedReason);
    }

    @Override // com.kwad.sdk.api.KsRewardVideoAd
    public final void setBidEcpm(int i2) {
        setBidEcpm(i2, -1L);
    }

    @Override // com.kwad.sdk.api.KsRewardVideoAd
    public final void setBidEcpm(long j2, long j3) {
        AdTemplate adTemplate = this.mAdTemplate;
        adTemplate.mBidEcpm = j2;
        com.kwad.sdk.core.report.a.j(adTemplate, j3);
    }

    @Override // com.kwad.sdk.api.KsRewardVideoAd
    public final void setInnerAdInteractionListener(KsInnerAd.KsInnerAdInteractionListener ksInnerAdInteractionListener) {
        this.oc = new com.kwad.components.core.g.d(ksInnerAdInteractionListener);
    }

    @Override // com.kwad.sdk.api.KsRewardVideoAd
    public final void setRewardAdInteractionListener(KsRewardVideoAd.RewardAdInteractionListener rewardAdInteractionListener) {
        if (this.pl == null) {
            this.pl = new com.kwad.components.ad.reward.d.g() { // from class: com.kwad.components.ad.reward.f.1
                @Override // com.kwad.components.ad.reward.d.g, com.kwad.sdk.api.KsRewardVideoAd.RewardAdInteractionListener
                public final void onPageDismiss() {
                    super.onPageDismiss();
                    f.this.ch.b(f.this);
                }

                @Override // com.kwad.components.ad.reward.d.g, com.kwad.sdk.api.KsRewardVideoAd.RewardAdInteractionListener
                public final void onVideoPlayStart() {
                    super.onVideoPlayStart();
                    f.this.ch.a(f.this);
                }
            };
        }
        this.pl.b(rewardAdInteractionListener);
    }

    @Override // com.kwad.sdk.api.KsRewardVideoAd
    public final void setRewardPlayAgainInteractionListener(KsRewardVideoAd.RewardAdInteractionListener rewardAdInteractionListener) {
        this.pm = rewardAdInteractionListener;
    }

    @Override // com.kwad.sdk.api.KsRewardVideoAd
    public final void showRewardVideoAd(Activity activity, KsVideoPlayConfig ksVideoPlayConfig) {
        if (activity == null || activity.isFinishing()) {
            com.kwad.sdk.core.d.b.e("KsRewardVideoAdControl", "showRewardVideoAd error, activity is null or finished");
            return;
        }
        com.kwad.sdk.f.a.T("reward", TTLogUtil.TAG_EVENT_SHOW);
        com.kwad.components.ad.reward.monitor.a.a(true, this.mAdTemplate);
        KSLoggerReporter.ReportClient.CORE_CONVERT.buildMethodCheck(BusinessType.AD_REWARD, "callShow").report();
        if (!isAdEnable()) {
            com.kwad.sdk.core.d.b.i("KsRewardVideoAdControl", "isAdEnable is false");
            com.kwad.sdk.f.a.U("reward", TTLogUtil.TAG_EVENT_SHOW);
        } else {
            if (ksVideoPlayConfig == null) {
                ksVideoPlayConfig = new KsVideoPlayConfig.Builder().build();
            }
            a(activity, ksVideoPlayConfig);
        }
    }
}
