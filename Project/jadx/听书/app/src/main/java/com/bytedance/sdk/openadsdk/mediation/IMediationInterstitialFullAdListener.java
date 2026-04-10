package com.bytedance.sdk.openadsdk.mediation;

import android.os.Bundle;
import com.bytedance.sdk.openadsdk.TTFullScreenVideoAd;

/* JADX INFO: loaded from: classes2.dex */
public interface IMediationInterstitialFullAdListener extends TTFullScreenVideoAd.FullScreenVideoAdInteractionListener {
    void onAdLeftApplication();

    void onAdOpened();

    void onInterstitialFullShowFail(int i, String str);

    void onRewardVerify(Bundle bundle);

    void onVideoError();
}
