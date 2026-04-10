package com.xiaomi.ad.mediation.interstitialad;

import android.content.Context;
import com.xiaomi.ad.mediation.MMAdSdk;
import com.xiaomi.ad.mediation.MMFilterable;
import com.xiaomi.ad.mediation.internal.loader.AdInternalConfig;
import com.xiaomi.ad.p;

/* JADX INFO: loaded from: classes5.dex */
public abstract class MMInterstitialAd extends p implements MMFilterable {
    public AdInsertActionListener mAdInsertActionListener;

    public interface AdInsertActionListener {
        void onAdClicked();

        void onAdDismissed();

        void onAdRenderFail(int i, String str);

        void onAdShow();
    }

    public MMInterstitialAd(Context context, AdInternalConfig adInternalConfig) {
        super(context, adInternalConfig);
    }

    @Override // com.xiaomi.ad.p
    public String getAdType() {
        return MMAdSdk.AD_TYPE_INTERSTITIAL;
    }

    @Override // com.xiaomi.ad.mediation.MMFilterable
    public boolean matched(String str) {
        return true;
    }

    public void notifyAdClicked() {
        AdInsertActionListener adInsertActionListener = this.mAdInsertActionListener;
        if (adInsertActionListener != null) {
            adInsertActionListener.onAdClicked();
        }
    }

    public void notifyAdDismissed() {
        AdInsertActionListener adInsertActionListener = this.mAdInsertActionListener;
        if (adInsertActionListener != null) {
            adInsertActionListener.onAdDismissed();
        }
    }

    public void notifyAdShow() {
        AdInsertActionListener adInsertActionListener = this.mAdInsertActionListener;
        if (adInsertActionListener != null) {
            adInsertActionListener.onAdShow();
        }
    }

    public void notifyAdShowFailed(int i, String str) {
        AdInsertActionListener adInsertActionListener = this.mAdInsertActionListener;
        if (adInsertActionListener != null) {
            adInsertActionListener.onAdRenderFail(i, str);
        }
    }

    public abstract void onDestroy();

    public abstract void setInsertAd(Object obj);

    public void show(AdInsertActionListener adInsertActionListener) {
        this.mAdInsertActionListener = adInsertActionListener;
    }
}
