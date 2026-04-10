package com.kwad.components.ad.reward.g;

import com.kwad.components.ad.reward.monitor.RewardLoadCallbackType;
import com.kwad.components.ad.reward.monitor.RewardMonitorInfo;
import com.kwad.components.core.t.f;
import com.kwad.sdk.api.KsLoadManager;
import com.kwad.sdk.api.KsRewardVideoAd;
import com.kwad.sdk.core.response.model.AdTemplate;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public final class c {
    private long jn;
    private KsLoadManager.RewardVideoAdListener uM;

    public c(long j, KsLoadManager.RewardVideoAdListener rewardVideoAdListener) {
        this.jn = j;
        this.uM = rewardVideoAdListener;
    }

    public final void onError(int i, String str) {
        KsLoadManager.RewardVideoAdListener rewardVideoAdListener = this.uM;
        if (rewardVideoAdListener != null) {
            rewardVideoAdListener.onError(i, str);
        }
        com.kwad.components.ad.reward.monitor.c.a(true, (AdTemplate) null, (com.kwad.components.ad.reward.monitor.a) RewardLoadCallbackType.LOAD_ERROR, this.jn, (com.kwad.sdk.g.a<RewardMonitorInfo>) null);
    }

    public final void c(AdTemplate adTemplate, List<KsRewardVideoAd> list) {
        com.kwad.components.ad.reward.monitor.c.a(true, adTemplate, (com.kwad.components.ad.reward.monitor.a) RewardLoadCallbackType.LOAD_SUCCESS_BEFORE, this.jn, (com.kwad.sdk.g.a<RewardMonitorInfo>) null);
        StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
        if (stackTrace != null && stackTrace.length > 3 && adTemplate != null) {
            adTemplate.mDataLoadTraceElement = f.a(stackTrace[2]);
        }
        KsLoadManager.RewardVideoAdListener rewardVideoAdListener = this.uM;
        if (rewardVideoAdListener != null) {
            rewardVideoAdListener.onRewardVideoResult(list);
        }
        com.kwad.components.ad.reward.monitor.c.a(true, adTemplate, (com.kwad.components.ad.reward.monitor.a) RewardLoadCallbackType.LOAD_SUCCESS, this.jn, (com.kwad.sdk.g.a<RewardMonitorInfo>) null);
    }

    public final void d(AdTemplate adTemplate, List<KsRewardVideoAd> list) {
        com.kwad.components.ad.reward.monitor.c.a(true, adTemplate, (com.kwad.components.ad.reward.monitor.a) RewardLoadCallbackType.LOAD_CACHE_SUCCESS_BEFORE, this.jn, (com.kwad.sdk.g.a<RewardMonitorInfo>) null);
        StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
        if (stackTrace != null && stackTrace.length > 3 && adTemplate != null) {
            adTemplate.mDataCacheTraceElement = f.a(stackTrace[2]);
        }
        KsLoadManager.RewardVideoAdListener rewardVideoAdListener = this.uM;
        if (rewardVideoAdListener != null) {
            rewardVideoAdListener.onRewardVideoAdLoad(list);
        }
        com.kwad.components.ad.reward.monitor.c.a(true, adTemplate, (com.kwad.components.ad.reward.monitor.a) RewardLoadCallbackType.LOAD_CACHE_SUCCESS, this.jn, (com.kwad.sdk.g.a<RewardMonitorInfo>) null);
    }
}
