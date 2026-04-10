package com.bytedance.sdk.openadsdk.core.multipro.aidl.bf;

import android.os.Bundle;
import com.bytedance.sdk.openadsdk.TTRewardVideoAd;
import com.bytedance.sdk.openadsdk.core.k;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes10.dex */
public class tg extends k.e {
    private final TTRewardVideoAd.RewardAdPlayAgainController e;

    public tg(TTRewardVideoAd.RewardAdPlayAgainController rewardAdPlayAgainController) {
        this.e = rewardAdPlayAgainController;
    }

    @Override // com.bytedance.sdk.openadsdk.core.k
    public Bundle e(int i) {
        TTRewardVideoAd.RewardAdPlayAgainController rewardAdPlayAgainController = this.e;
        final Bundle bundle = new Bundle();
        final CountDownLatch countDownLatch = new CountDownLatch(1);
        if (rewardAdPlayAgainController != null) {
            rewardAdPlayAgainController.getPlayAgainCondition(i, new TTRewardVideoAd.RewardAdPlayAgainController.Callback() { // from class: com.bytedance.sdk.openadsdk.core.multipro.aidl.bf.tg.1
                @Override // com.bytedance.sdk.openadsdk.TTRewardVideoAd.RewardAdPlayAgainController.Callback
                public void onConditionReturn(Bundle bundle2) {
                    bundle.putAll(bundle2);
                    countDownLatch.countDown();
                }
            });
        }
        try {
            countDownLatch.await(10L, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return bundle;
    }
}
