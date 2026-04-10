package com.kwad.components.ad.reward.d;

import androidx.annotation.Nullable;
import com.kwad.sdk.api.KsRewardVideoAd;

/* JADX INFO: loaded from: classes3.dex */
public class g implements KsRewardVideoAd.RewardAdInteractionListener {

    @Nullable
    private KsRewardVideoAd.RewardAdInteractionListener rX;

    public final void b(@Nullable KsRewardVideoAd.RewardAdInteractionListener rewardAdInteractionListener) {
        this.rX = rewardAdInteractionListener;
    }

    @Override // com.kwad.sdk.api.KsRewardVideoAd.RewardAdInteractionListener
    public void onAdClicked() {
        KsRewardVideoAd.RewardAdInteractionListener rewardAdInteractionListener = this.rX;
        if (rewardAdInteractionListener != null) {
            rewardAdInteractionListener.onAdClicked();
        }
    }

    @Override // com.kwad.sdk.api.KsRewardVideoAd.RewardAdInteractionListener
    public void onExtraRewardVerify(int i2) {
        KsRewardVideoAd.RewardAdInteractionListener rewardAdInteractionListener = this.rX;
        if (rewardAdInteractionListener != null) {
            rewardAdInteractionListener.onExtraRewardVerify(i2);
        }
    }

    @Override // com.kwad.sdk.api.KsRewardVideoAd.RewardAdInteractionListener
    public void onPageDismiss() {
        KsRewardVideoAd.RewardAdInteractionListener rewardAdInteractionListener = this.rX;
        if (rewardAdInteractionListener != null) {
            rewardAdInteractionListener.onPageDismiss();
        }
    }

    @Override // com.kwad.sdk.api.KsRewardVideoAd.RewardAdInteractionListener
    public void onRewardStepVerify(int i2, int i3) {
        KsRewardVideoAd.RewardAdInteractionListener rewardAdInteractionListener = this.rX;
        if (rewardAdInteractionListener != null) {
            rewardAdInteractionListener.onRewardStepVerify(i2, i3);
        }
    }

    @Override // com.kwad.sdk.api.KsRewardVideoAd.RewardAdInteractionListener
    public void onRewardVerify() {
        KsRewardVideoAd.RewardAdInteractionListener rewardAdInteractionListener = this.rX;
        if (rewardAdInteractionListener != null) {
            rewardAdInteractionListener.onRewardVerify();
        }
    }

    @Override // com.kwad.sdk.api.KsRewardVideoAd.RewardAdInteractionListener
    public void onVideoPlayEnd() {
        KsRewardVideoAd.RewardAdInteractionListener rewardAdInteractionListener = this.rX;
        if (rewardAdInteractionListener != null) {
            rewardAdInteractionListener.onVideoPlayEnd();
        }
    }

    @Override // com.kwad.sdk.api.KsRewardVideoAd.RewardAdInteractionListener
    public void onVideoPlayError(int i2, int i3) {
        KsRewardVideoAd.RewardAdInteractionListener rewardAdInteractionListener = this.rX;
        if (rewardAdInteractionListener != null) {
            rewardAdInteractionListener.onVideoPlayError(i2, i3);
        }
    }

    @Override // com.kwad.sdk.api.KsRewardVideoAd.RewardAdInteractionListener
    public void onVideoPlayStart() {
        try {
            if (this.rX != null) {
                this.rX.onVideoPlayStart();
            }
        } catch (Throwable th) {
            com.kwad.components.core.c.a.b(th);
        }
    }

    @Override // com.kwad.sdk.api.KsRewardVideoAd.RewardAdInteractionListener
    public void onVideoSkipToEnd(long j2) {
        KsRewardVideoAd.RewardAdInteractionListener rewardAdInteractionListener = this.rX;
        if (rewardAdInteractionListener != null) {
            rewardAdInteractionListener.onVideoSkipToEnd(j2);
        }
    }
}
