package com.kwad.components.ad.reward.e;

import com.kwad.components.ad.reward.monitor.RewardInteractionCallbackType;
import com.kwad.components.ad.reward.monitor.RewardMonitorInfo;
import com.kwad.sdk.api.KsRewardVideoAd;
import com.kwad.sdk.core.response.model.AdTemplate;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes3.dex */
public class i extends c {
    private static String ux = "IS_FRAUD";
    private static String uy = "IS_FRAUD_ERROR_CODE";
    private AdTemplate mAdTemplate;
    private com.kwad.components.ad.reward.g tm;
    private String uv;
    private Map<String, Object> uw = new HashMap();

    public final void setCallerContext(com.kwad.components.ad.reward.g gVar) {
        this.tm = gVar;
    }

    public final void R(String str) {
        this.uv = str;
    }

    public final void setAdTemplate(AdTemplate adTemplate) {
        this.mAdTemplate = adTemplate;
    }

    @Override // com.kwad.components.ad.reward.e.c, com.kwad.components.ad.reward.e.b
    public void cW() {
        super.cW();
        KsRewardVideoAd.RewardAdInteractionListener rewardAdInteractionListenerIc = ic();
        if (rewardAdInteractionListenerIc != null) {
            rewardAdInteractionListenerIc.onAdClicked();
        }
        com.kwad.components.ad.reward.monitor.c.a(true, (com.kwad.components.ad.reward.monitor.a) RewardInteractionCallbackType.AD_CLICK, this.mAdTemplate, (com.kwad.sdk.g.a<RewardMonitorInfo>) null);
    }

    @Override // com.kwad.components.ad.reward.e.c, com.kwad.components.ad.reward.e.b
    public final void onVideoPlayStart() {
        super.onVideoPlayStart();
        KsRewardVideoAd.RewardAdInteractionListener rewardAdInteractionListenerIc = ic();
        if (rewardAdInteractionListenerIc != null) {
            rewardAdInteractionListenerIc.onVideoPlayStart();
        }
        com.kwad.components.ad.reward.monitor.c.a(true, (com.kwad.components.ad.reward.monitor.a) RewardInteractionCallbackType.VIDEO_PLAY_START, this.mAdTemplate, (com.kwad.sdk.g.a<RewardMonitorInfo>) null);
    }

    @Override // com.kwad.components.ad.reward.e.c, com.kwad.components.ad.reward.e.b
    public final void onVideoPlayError(int i, int i2) {
        super.onVideoPlayError(i, i2);
        KsRewardVideoAd.RewardAdInteractionListener rewardAdInteractionListenerIc = ic();
        if (rewardAdInteractionListenerIc != null) {
            rewardAdInteractionListenerIc.onVideoPlayError(i, i2);
        }
        com.kwad.components.ad.reward.monitor.c.a(true, (com.kwad.components.ad.reward.monitor.a) RewardInteractionCallbackType.VIDEO_PLAY_ERROR, this.mAdTemplate, (com.kwad.sdk.g.a<RewardMonitorInfo>) null);
    }

    @Override // com.kwad.components.ad.reward.e.c, com.kwad.components.ad.reward.e.b
    public final void onVideoPlayEnd() {
        super.onVideoPlayEnd();
        KsRewardVideoAd.RewardAdInteractionListener rewardAdInteractionListenerIc = ic();
        if (rewardAdInteractionListenerIc != null) {
            rewardAdInteractionListenerIc.onVideoPlayEnd();
        }
        com.kwad.components.ad.reward.monitor.c.a(true, (com.kwad.components.ad.reward.monitor.a) RewardInteractionCallbackType.VIDEO_PLAY_END, this.mAdTemplate, (com.kwad.sdk.g.a<RewardMonitorInfo>) null);
    }

    @Override // com.kwad.components.ad.reward.e.c, com.kwad.components.ad.reward.e.b
    public final void onVideoSkipToEnd(long j) {
        super.onVideoSkipToEnd(j);
        try {
            KsRewardVideoAd.RewardAdInteractionListener rewardAdInteractionListenerIc = ic();
            if (rewardAdInteractionListenerIc != null) {
                rewardAdInteractionListenerIc.onVideoSkipToEnd(j);
            }
            com.kwad.components.ad.reward.monitor.c.a(true, (com.kwad.components.ad.reward.monitor.a) RewardInteractionCallbackType.VIDEO_SKIP_TO_END, this.mAdTemplate, (com.kwad.sdk.g.a<RewardMonitorInfo>) null);
        } catch (Throwable unused) {
        }
    }

    @Override // com.kwad.components.ad.reward.e.c, com.kwad.components.ad.reward.e.b
    public void onRewardVerify() {
        super.onRewardVerify();
    }

    @Override // com.kwad.components.ad.reward.e.c, com.kwad.components.ad.reward.e.b
    public void i(boolean z) {
        super.i(z);
        KsRewardVideoAd.RewardAdInteractionListener rewardAdInteractionListenerIc = ic();
        if (rewardAdInteractionListenerIc != null) {
            rewardAdInteractionListenerIc.onPageDismiss();
        }
        com.kwad.components.ad.reward.monitor.c.a(true, (com.kwad.components.ad.reward.monitor.a) RewardInteractionCallbackType.PAGE_DISMISS, this.mAdTemplate, (com.kwad.sdk.g.a<RewardMonitorInfo>) null);
    }

    public final boolean ib() {
        KsRewardVideoAd.RewardAdInteractionListener rewardAdInteractionListenerIc = ic();
        if (rewardAdInteractionListenerIc != null) {
            if (com.kwad.sdk.core.response.b.a.dh(com.kwad.sdk.core.response.b.e.el(this.tm.mAdTemplate))) {
                this.uw.put(ux, Boolean.valueOf(this.tm.sa == 3));
                this.uw.put(uy, Integer.valueOf(this.tm.sb));
                com.kwad.components.ad.reward.monitor.c.d(this.tm.mAdTemplate, this.tm.sa, this.tm.sb);
            }
            try {
                rewardAdInteractionListenerIc.onRewardVerify(this.uw);
            } catch (Throwable unused) {
            }
            rewardAdInteractionListenerIc.onRewardVerify();
        }
        com.kwad.components.ad.reward.monitor.c.a(true, (com.kwad.components.ad.reward.monitor.a) RewardInteractionCallbackType.REWARD_VERIFY, this.mAdTemplate, (com.kwad.sdk.g.a<RewardMonitorInfo>) null);
        return rewardAdInteractionListenerIc != null;
    }

    public final boolean i(final int i, final int i2) {
        KsRewardVideoAd.RewardAdInteractionListener rewardAdInteractionListenerIc = ic();
        if (rewardAdInteractionListenerIc != null) {
            rewardAdInteractionListenerIc.onRewardStepVerify(i, i2);
        }
        com.kwad.components.ad.reward.monitor.c.a(true, (com.kwad.components.ad.reward.monitor.a) RewardInteractionCallbackType.REWARD_STEP_VERIFY, this.mAdTemplate, new com.kwad.sdk.g.a<RewardMonitorInfo>() { // from class: com.kwad.components.ad.reward.e.i.1
            /* JADX INFO: Access modifiers changed from: private */
            @Override // com.kwad.sdk.g.a
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public void accept(RewardMonitorInfo rewardMonitorInfo) {
                rewardMonitorInfo.setTaskType(i).setTaskStep(i2);
            }
        });
        return rewardAdInteractionListenerIc != null;
    }

    private KsRewardVideoAd.RewardAdInteractionListener ic() {
        return f.N(getUniqueId());
    }

    private String getUniqueId() {
        return this.uv;
    }
}
