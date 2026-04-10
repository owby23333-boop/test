package com.xiaomi.ad.mediation.fullscreeninterstitial;

import android.app.Activity;
import android.content.Context;
import com.xiaomi.ad.mediation.MMAdSdk;
import com.xiaomi.ad.mediation.internal.loader.AdInternalConfig;
import com.xiaomi.ad.p;

/* JADX INFO: loaded from: classes5.dex */
public abstract class MMFullScreenInterstitialAd extends p {
    public FullScreenInterstitialAdInteractionListener mInteractionListener;

    public interface FullScreenInterstitialAdInteractionListener {
        void onAdClicked(MMFullScreenInterstitialAd mMFullScreenInterstitialAd);

        void onAdClosed(MMFullScreenInterstitialAd mMFullScreenInterstitialAd);

        void onAdRenderFail(MMFullScreenInterstitialAd mMFullScreenInterstitialAd, int i, String str);

        void onAdShown(MMFullScreenInterstitialAd mMFullScreenInterstitialAd);

        void onAdVideoComplete(MMFullScreenInterstitialAd mMFullScreenInterstitialAd);

        void onAdVideoSkipped(MMFullScreenInterstitialAd mMFullScreenInterstitialAd);
    }

    public MMFullScreenInterstitialAd(Context context, AdInternalConfig adInternalConfig) {
        super(context, adInternalConfig);
    }

    @Override // com.xiaomi.ad.p
    public String getAdType() {
        return MMAdSdk.AD_TYPE_FULLSCREEN_INTERSTITIAL;
    }

    public abstract int getInteractionType();

    public void notifyAdClicked() {
        FullScreenInterstitialAdInteractionListener fullScreenInterstitialAdInteractionListener = this.mInteractionListener;
        if (fullScreenInterstitialAdInteractionListener != null) {
            fullScreenInterstitialAdInteractionListener.onAdClicked(this);
        }
    }

    public void notifyAdClosed() {
        FullScreenInterstitialAdInteractionListener fullScreenInterstitialAdInteractionListener = this.mInteractionListener;
        if (fullScreenInterstitialAdInteractionListener != null) {
            fullScreenInterstitialAdInteractionListener.onAdClosed(this);
        }
    }

    public void notifyAdError(int i, String str) {
        FullScreenInterstitialAdInteractionListener fullScreenInterstitialAdInteractionListener = this.mInteractionListener;
        if (fullScreenInterstitialAdInteractionListener != null) {
            fullScreenInterstitialAdInteractionListener.onAdRenderFail(this, i, str);
        }
    }

    public void notifyAdShown() {
        FullScreenInterstitialAdInteractionListener fullScreenInterstitialAdInteractionListener = this.mInteractionListener;
        if (fullScreenInterstitialAdInteractionListener != null) {
            fullScreenInterstitialAdInteractionListener.onAdShown(this);
        }
    }

    public void notifyAdVideoComplete() {
        FullScreenInterstitialAdInteractionListener fullScreenInterstitialAdInteractionListener = this.mInteractionListener;
        if (fullScreenInterstitialAdInteractionListener != null) {
            fullScreenInterstitialAdInteractionListener.onAdVideoComplete(this);
        }
    }

    public void notifyAdVideoSkipped() {
        FullScreenInterstitialAdInteractionListener fullScreenInterstitialAdInteractionListener = this.mInteractionListener;
        if (fullScreenInterstitialAdInteractionListener != null) {
            fullScreenInterstitialAdInteractionListener.onAdVideoSkipped(this);
        }
    }

    public abstract void onDestroy();

    public void setInteractionListener(FullScreenInterstitialAdInteractionListener fullScreenInterstitialAdInteractionListener) {
        this.mInteractionListener = fullScreenInterstitialAdInteractionListener;
    }

    public abstract void showAd(Activity activity);
}
