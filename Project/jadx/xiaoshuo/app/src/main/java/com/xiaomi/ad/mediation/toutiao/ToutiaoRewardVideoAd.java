package com.xiaomi.ad.mediation.toutiao;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import com.bytedance.sdk.openadsdk.TTRewardVideoAd;
import com.xiaomi.ad.mediation.MMAdError;
import com.xiaomi.ad.mediation.internal.loader.AdInternalConfig;
import com.xiaomi.ad.mediation.rewardvideoad.MMAdReward;
import com.xiaomi.ad.mediation.rewardvideoad.MMRewardVideoAd;

/* JADX INFO: loaded from: classes5.dex */
public class ToutiaoRewardVideoAd extends MMRewardVideoAd implements TTRewardVideoAd.RewardAdInteractionListener {
    private TTRewardVideoAd mAd;

    public ToutiaoRewardVideoAd(TTRewardVideoAd tTRewardVideoAd, Context context, AdInternalConfig adInternalConfig) {
        super(context, adInternalConfig);
        this.mAd = tTRewardVideoAd;
        tTRewardVideoAd.setRewardAdInteractionListener(this);
    }

    @Override // com.xiaomi.ad.mediation.rewardvideoad.MMRewardVideoAd
    public void destroy() {
    }

    @Override // com.xiaomi.ad.p
    public String getDspName() {
        return "bytedance";
    }

    @Override // com.xiaomi.ad.mediation.rewardvideoad.MMRewardVideoAd
    public int getInteractionType() {
        int interactionType = this.mAd.getInteractionType();
        int i = 2;
        if (interactionType != 2) {
            i = 3;
            if (interactionType != 3) {
                if (interactionType != 4) {
                    return interactionType != 5 ? 0 : 4;
                }
                return 1;
            }
        }
        return i;
    }

    @Override // com.bytedance.sdk.openadsdk.TTRewardVideoAd.RewardAdInteractionListener
    public void onAdClose() {
        notifyAdClosed();
    }

    @Override // com.bytedance.sdk.openadsdk.TTRewardVideoAd.RewardAdInteractionListener
    public void onAdShow() {
        notifyAdShown();
    }

    @Override // com.bytedance.sdk.openadsdk.TTRewardVideoAd.RewardAdInteractionListener
    public void onAdVideoBarClick() {
        notifyAdClicked();
    }

    @Override // com.bytedance.sdk.openadsdk.TTRewardVideoAd.RewardAdInteractionListener
    public void onRewardArrived(boolean z, int i, Bundle bundle) {
    }

    @Override // com.bytedance.sdk.openadsdk.TTRewardVideoAd.RewardAdInteractionListener
    public void onRewardVerify(boolean z, int i, String str, int i2, String str2) {
        notifyAdReward(new MMAdReward(z, i, str, i2, str2));
    }

    @Override // com.bytedance.sdk.openadsdk.TTRewardVideoAd.RewardAdInteractionListener
    public void onSkippedVideo() {
        notifyAdVideoSkipped();
    }

    @Override // com.bytedance.sdk.openadsdk.TTRewardVideoAd.RewardAdInteractionListener
    public void onVideoComplete() {
        notifyAdVideoComplete();
    }

    @Override // com.bytedance.sdk.openadsdk.TTRewardVideoAd.RewardAdInteractionListener
    public void onVideoError() {
        notifyAdError(new MMAdError(-2000));
    }

    @Override // com.xiaomi.ad.mediation.rewardvideoad.MMRewardVideoAd
    public void showAd(Activity activity) {
        this.mAd.showRewardVideoAd(activity);
    }
}
