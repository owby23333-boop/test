package com.xiaomi.ad.mediation.toutiao;

import android.app.Activity;
import android.content.Context;
import com.bytedance.sdk.openadsdk.TTFullScreenVideoAd;
import com.xiaomi.ad.mediation.fullscreeninterstitial.MMFullScreenInterstitialAd;
import com.xiaomi.ad.mediation.internal.loader.AdInternalConfig;

/* JADX INFO: loaded from: classes5.dex */
public class ToutiaoFullScreenInterstitialAd extends MMFullScreenInterstitialAd implements TTFullScreenVideoAd.FullScreenVideoAdInteractionListener {
    private TTFullScreenVideoAd mAd;

    public ToutiaoFullScreenInterstitialAd(TTFullScreenVideoAd tTFullScreenVideoAd, Context context, AdInternalConfig adInternalConfig) {
        super(context, adInternalConfig);
        this.mAd = tTFullScreenVideoAd;
        tTFullScreenVideoAd.setFullScreenVideoAdInteractionListener(this);
    }

    @Override // com.xiaomi.ad.p
    public String getDspName() {
        return "bytedance";
    }

    @Override // com.xiaomi.ad.mediation.fullscreeninterstitial.MMFullScreenInterstitialAd
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

    @Override // com.bytedance.sdk.openadsdk.TTFullScreenVideoAd.FullScreenVideoAdInteractionListener
    public void onAdClose() {
        notifyAdClosed();
    }

    @Override // com.bytedance.sdk.openadsdk.TTFullScreenVideoAd.FullScreenVideoAdInteractionListener
    public void onAdShow() {
        notifyAdShown();
    }

    @Override // com.bytedance.sdk.openadsdk.TTFullScreenVideoAd.FullScreenVideoAdInteractionListener
    public void onAdVideoBarClick() {
        notifyAdClicked();
    }

    @Override // com.xiaomi.ad.mediation.fullscreeninterstitial.MMFullScreenInterstitialAd
    public void onDestroy() {
    }

    @Override // com.bytedance.sdk.openadsdk.TTFullScreenVideoAd.FullScreenVideoAdInteractionListener
    public void onSkippedVideo() {
        notifyAdVideoSkipped();
    }

    @Override // com.bytedance.sdk.openadsdk.TTFullScreenVideoAd.FullScreenVideoAdInteractionListener
    public void onVideoComplete() {
        notifyAdVideoComplete();
    }

    @Override // com.xiaomi.ad.mediation.fullscreeninterstitial.MMFullScreenInterstitialAd
    public void showAd(Activity activity) {
        this.mAd.showFullScreenVideoAd(activity);
    }
}
