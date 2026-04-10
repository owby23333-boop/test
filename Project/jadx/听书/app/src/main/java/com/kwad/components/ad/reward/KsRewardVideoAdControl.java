package com.kwad.components.ad.reward;

import android.app.Activity;
import com.kwad.components.ad.reward.page.AdRewardPreviewActivityProxy;
import com.kwad.sdk.api.KsInnerAd;
import com.kwad.sdk.api.KsRewardVideoAd;
import com.kwad.sdk.api.KsVideoPlayConfig;
import com.kwad.sdk.api.model.AdExposureFailedReason;
import com.kwad.sdk.api.model.KSAdInfoData;
import com.kwad.sdk.core.response.model.AdGlobalConfigInfo;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdResultData;
import com.kwad.sdk.core.response.model.AdTemplate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes3.dex */
public class KsRewardVideoAdControl implements com.kwad.components.core.internal.api.a, KsRewardVideoAd {
    private final AdInfo mAdInfo;
    private final AdResultData mAdResultData;
    private final AdTemplate mAdTemplate;
    private final AdGlobalConfigInfo rr;
    private com.kwad.components.ad.reward.e.h rs;
    private com.kwad.components.core.j.d rt;
    private com.kwad.components.core.internal.api.c bz = new com.kwad.components.core.internal.api.c();
    public int rewardType = 1;

    public void setRewardPlayAgainInteractionListener(KsRewardVideoAd.RewardAdInteractionListener rewardAdInteractionListener) {
    }

    @Override // com.kwad.components.core.internal.api.a
    public final boolean supportPushAd() {
        return true;
    }

    public KsRewardVideoAdControl(AdResultData adResultData) {
        this.mAdResultData = adResultData;
        AdTemplate adTemplateR = com.kwad.sdk.core.response.b.c.r(adResultData);
        this.mAdTemplate = adTemplateR;
        this.mAdInfo = com.kwad.sdk.core.response.b.e.el(adTemplateR);
        this.rr = adResultData.adGlobalConfigInfo;
        gq();
    }

    private void gq() {
        com.kwad.components.ad.i.b.fR().a(this);
        AdGlobalConfigInfo adGlobalConfigInfo = this.rr;
        boolean z = adGlobalConfigInfo != null && adGlobalConfigInfo.isNeoScan();
        this.mAdTemplate.isNativeRewardPreview = com.kwad.sdk.core.response.b.a.cf(this.mAdInfo) && !z;
    }

    @Override // com.kwad.components.core.internal.api.a
    public final AdTemplate getAdTemplate() {
        return this.mAdTemplate;
    }

    @Override // com.kwad.components.core.internal.api.a
    public final void a(com.kwad.components.core.internal.api.b bVar) {
        this.bz.a(bVar);
    }

    @Override // com.kwad.components.core.internal.api.a
    public final void b(com.kwad.components.core.internal.api.b bVar) {
        this.bz.b(bVar);
    }

    @Override // com.kwad.sdk.api.KsRewardVideoAd
    public void setRewardAdInteractionListener(KsRewardVideoAd.RewardAdInteractionListener rewardAdInteractionListener) {
        if (this.rs == null) {
            this.rs = new com.kwad.components.ad.reward.e.h() { // from class: com.kwad.components.ad.reward.KsRewardVideoAdControl.1
                @Override // com.kwad.components.ad.reward.e.h, com.kwad.sdk.api.KsRewardVideoAd.RewardAdInteractionListener
                public final void onRewardVerify(Map<String, Object> map) {
                    super.onRewardVerify(map);
                }

                @Override // com.kwad.components.ad.reward.e.h, com.kwad.sdk.api.KsRewardVideoAd.RewardAdInteractionListener
                public final void onVideoPlayStart() {
                    super.onVideoPlayStart();
                    KsRewardVideoAdControl.this.bz.h(KsRewardVideoAdControl.this);
                }

                @Override // com.kwad.components.ad.reward.e.h, com.kwad.sdk.api.KsRewardVideoAd.RewardAdInteractionListener
                public final void onPageDismiss() {
                    super.onPageDismiss();
                    KsRewardVideoAdControl.this.bz.i(KsRewardVideoAdControl.this);
                }
            };
        }
        this.rs.b(rewardAdInteractionListener);
    }

    @Override // com.kwad.sdk.api.KsRewardVideoAd
    public void setInnerAdInteractionListener(KsInnerAd.KsInnerAdInteractionListener ksInnerAdInteractionListener) {
        this.rt = new com.kwad.components.core.j.d(ksInnerAdInteractionListener);
    }

    @Override // com.kwad.sdk.api.KsRewardVideoAd
    public void showRewardVideoAd(Activity activity, KsVideoPlayConfig ksVideoPlayConfig) {
        if (activity == null || activity.isFinishing()) {
            com.kwad.sdk.core.d.c.e("KsRewardVideoAdControl", "showRewardVideoAd error, activity is null or finished");
            com.kwad.components.ad.reward.monitor.c.b(true, this.mAdTemplate, "illegal_activity");
            return;
        }
        com.kwad.components.ad.reward.monitor.c.h(true, this.mAdTemplate);
        com.kwad.sdk.commercial.d.c.bK(this.mAdTemplate);
        if (!com.kwad.sdk.core.config.e.Gf() && !isAdEnable()) {
            com.kwad.sdk.core.d.c.i("KsRewardVideoAdControl", "isAdEnable is false");
            com.kwad.components.ad.reward.monitor.c.b(true, this.mAdTemplate, "cache_not_ready");
        } else {
            if (ksVideoPlayConfig == null) {
                ksVideoPlayConfig = new KsVideoPlayConfig.Builder().build();
            }
            a(activity, ksVideoPlayConfig);
        }
    }

    @Override // com.kwad.sdk.api.KsRewardVideoAd
    public boolean isAdEnable() {
        if (com.kwad.sdk.core.response.b.e.eB(this.mAdTemplate) >= 0) {
            return true;
        }
        return com.kwad.components.core.video.k.aL(this.mAdTemplate);
    }

    @Override // com.kwad.sdk.api.KsRewardVideoAd
    public int getECPM() {
        return com.kwad.sdk.core.response.b.a.aR(this.mAdInfo);
    }

    @Override // com.kwad.sdk.api.KsRewardVideoAd
    public void setBidEcpm(int i) {
        setBidEcpm(i, -1L);
    }

    @Override // com.kwad.sdk.api.KsRewardVideoAd
    public void setBidEcpm(long j, long j2) {
        this.mAdTemplate.mBidEcpm = j;
        com.kwad.sdk.core.adlog.c.m(this.mAdTemplate, j2);
    }

    @Override // com.kwad.sdk.api.BaseKSAd
    public Map<String, Object> getMediaExtraInfo() {
        HashMap map = new HashMap();
        if (com.kwad.sdk.core.config.e.Ft()) {
            map.put("llsid", Long.valueOf(this.mAdTemplate.llsid));
        }
        return map;
    }

    @Override // com.kwad.sdk.api.KsRewardVideoAd
    public void reportAdExposureFailed(int i, AdExposureFailedReason adExposureFailedReason) {
        com.kwad.sdk.core.adlog.c.a(this.mAdTemplate, i, adExposureFailedReason);
    }

    @Override // com.kwad.sdk.api.KsRewardVideoAd
    public int getMaterialType() {
        return com.kwad.sdk.core.response.b.a.be(this.mAdInfo);
    }

    @Override // com.kwad.sdk.api.KsRewardVideoAd
    public int getInteractionType() {
        return com.kwad.sdk.core.response.b.a.aQ(this.mAdInfo);
    }

    @Override // com.kwad.sdk.api.KsRewardVideoAd
    public List<KSAdInfoData> getKSAdInfoDatas() {
        AdResultData adResultData;
        ArrayList arrayList = new ArrayList();
        if (com.kwad.sdk.core.config.e.a(com.kwad.sdk.core.config.c.aBw) && (adResultData = this.mAdResultData) != null && adResultData.getAdTemplateList().size() > 0) {
            Iterator<AdTemplate> it = this.mAdResultData.getAdTemplateList().iterator();
            while (it.hasNext()) {
                arrayList.add(com.kwad.sdk.core.response.b.a.dj(com.kwad.sdk.core.response.b.e.el(it.next())));
            }
        }
        return arrayList;
    }

    private void a(Activity activity, KsVideoPlayConfig ksVideoPlayConfig) {
        gr();
        if (this.mAdTemplate.isNativeRewardPreview) {
            AdRewardPreviewActivityProxy.launch(activity, this.mAdResultData, this.mAdTemplate, com.kwad.sdk.core.response.b.a.aS(this.mAdInfo), this.rs);
        } else {
            KSRewardVideoActivityProxy.launch(activity, this.mAdResultData, ksVideoPlayConfig, this.rs, this.rt, this.rewardType);
        }
    }

    private void gr() {
        AdInfo adInfo;
        if (com.kwad.components.ad.reward.c.c.a(this.rs) || (adInfo = this.mAdInfo) == null) {
            return;
        }
        adInfo.adBaseInfo.extraClickReward = false;
    }
}
