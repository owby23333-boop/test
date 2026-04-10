package com.bytedance.msdk.api.v2.ad.custom.fullvideo;

import com.bytedance.msdk.api.reward.RewardItem;

/* JADX INFO: loaded from: classes2.dex */
public interface IGMCustomFullVideoEvent {
    void callFullVideoAdClick();

    void callFullVideoAdClosed();

    void callFullVideoAdShow();

    void callFullVideoComplete();

    void callFullVideoError();

    void callFullVideoRewardVerify(RewardItem rewardItem);

    void callFullVideoSkippedVideo();
}
