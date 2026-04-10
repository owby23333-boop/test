package com.xiaomi.ad.mediation.banner;

import android.content.Context;
import com.xiaomi.ad.mediation.MMAdSdk;
import com.xiaomi.ad.mediation.MMFilterable;
import com.xiaomi.ad.mediation.internal.loader.AdInternalConfig;
import com.xiaomi.ad.p;

/* JADX INFO: loaded from: classes5.dex */
public abstract class MMBannerAd extends p implements MMFilterable {
    public AdBannerActionListener mAdBannerActionListener;

    public interface AdBannerActionListener {
        void onAdClicked();

        void onAdDismissed();

        void onAdRenderFail(int i, String str);

        void onAdShow();
    }

    public MMBannerAd(Context context, AdInternalConfig adInternalConfig) {
        super(context, adInternalConfig);
    }

    public abstract void destroy();

    @Override // com.xiaomi.ad.p
    public String getAdType() {
        return MMAdSdk.AD_TYPE_BANNER;
    }

    @Override // com.xiaomi.ad.mediation.MMFilterable
    public boolean matched(String str) {
        return true;
    }

    public void notifyAdClicked() {
        AdBannerActionListener adBannerActionListener = this.mAdBannerActionListener;
        if (adBannerActionListener != null) {
            adBannerActionListener.onAdClicked();
        }
    }

    public void notifyAdDismissed() {
        AdBannerActionListener adBannerActionListener = this.mAdBannerActionListener;
        if (adBannerActionListener != null) {
            adBannerActionListener.onAdDismissed();
        }
    }

    public void notifyAdShow() {
        AdBannerActionListener adBannerActionListener = this.mAdBannerActionListener;
        if (adBannerActionListener != null) {
            adBannerActionListener.onAdShow();
        }
    }

    public void notifyAdShowFailed(int i, String str) {
        AdBannerActionListener adBannerActionListener = this.mAdBannerActionListener;
        if (adBannerActionListener != null) {
            adBannerActionListener.onAdRenderFail(i, str);
        }
    }

    public void show(AdBannerActionListener adBannerActionListener) {
        this.mAdBannerActionListener = adBannerActionListener;
    }
}
