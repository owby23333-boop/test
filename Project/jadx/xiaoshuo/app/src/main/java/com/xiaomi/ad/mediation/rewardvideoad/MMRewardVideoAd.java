package com.xiaomi.ad.mediation.rewardvideoad;

import android.app.Activity;
import android.content.Context;
import com.xiaomi.ad.mediation.MMAdError;
import com.xiaomi.ad.mediation.MMAdSdk;
import com.xiaomi.ad.mediation.internal.loader.AdInternalConfig;
import com.xiaomi.ad.p;

/* JADX INFO: loaded from: classes5.dex */
public abstract class MMRewardVideoAd extends p {
    public RewardVideoAdInteractionListener mInteractionListener;

    public interface RewardVideoAdInteractionListener {
        void onAdClicked(MMRewardVideoAd mMRewardVideoAd);

        void onAdClosed(MMRewardVideoAd mMRewardVideoAd);

        void onAdError(MMRewardVideoAd mMRewardVideoAd, MMAdError mMAdError);

        void onAdReward(MMRewardVideoAd mMRewardVideoAd, MMAdReward mMAdReward);

        void onAdShown(MMRewardVideoAd mMRewardVideoAd);

        void onAdVideoComplete(MMRewardVideoAd mMRewardVideoAd);

        void onAdVideoSkipped(MMRewardVideoAd mMRewardVideoAd);
    }

    public MMRewardVideoAd(Context context, AdInternalConfig adInternalConfig) {
        super(context, adInternalConfig);
    }

    public abstract void destroy();

    @Override // com.xiaomi.ad.p
    public String getAdType() {
        return MMAdSdk.AD_TYPE_REWARD_VIDEO;
    }

    public abstract int getInteractionType();

    public void notifyAdClicked() {
        RewardVideoAdInteractionListener rewardVideoAdInteractionListener = this.mInteractionListener;
        if (rewardVideoAdInteractionListener != null) {
            rewardVideoAdInteractionListener.onAdClicked(this);
        }
    }

    public void notifyAdClosed() {
        RewardVideoAdInteractionListener rewardVideoAdInteractionListener = this.mInteractionListener;
        if (rewardVideoAdInteractionListener != null) {
            rewardVideoAdInteractionListener.onAdClosed(this);
        }
    }

    public void notifyAdError(MMAdError mMAdError) {
        RewardVideoAdInteractionListener rewardVideoAdInteractionListener = this.mInteractionListener;
        if (rewardVideoAdInteractionListener != null) {
            rewardVideoAdInteractionListener.onAdError(this, mMAdError);
        }
    }

    public void notifyAdReward(MMAdReward mMAdReward) {
        RewardVideoAdInteractionListener rewardVideoAdInteractionListener = this.mInteractionListener;
        if (rewardVideoAdInteractionListener != null) {
            rewardVideoAdInteractionListener.onAdReward(this, mMAdReward);
        }
    }

    public void notifyAdShown() {
        RewardVideoAdInteractionListener rewardVideoAdInteractionListener = this.mInteractionListener;
        if (rewardVideoAdInteractionListener != null) {
            rewardVideoAdInteractionListener.onAdShown(this);
        }
    }

    public void notifyAdVideoComplete() {
        RewardVideoAdInteractionListener rewardVideoAdInteractionListener = this.mInteractionListener;
        if (rewardVideoAdInteractionListener != null) {
            rewardVideoAdInteractionListener.onAdVideoComplete(this);
        }
    }

    public void notifyAdVideoSkipped() {
        RewardVideoAdInteractionListener rewardVideoAdInteractionListener = this.mInteractionListener;
        if (rewardVideoAdInteractionListener != null) {
            rewardVideoAdInteractionListener.onAdVideoSkipped(this);
        }
    }

    public void setInteractionListener(RewardVideoAdInteractionListener rewardVideoAdInteractionListener) {
        this.mInteractionListener = rewardVideoAdInteractionListener;
    }

    public abstract void showAd(Activity activity);
}
