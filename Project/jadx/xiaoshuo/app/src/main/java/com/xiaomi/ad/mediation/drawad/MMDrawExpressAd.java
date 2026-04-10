package com.xiaomi.ad.mediation.drawad;

import android.content.Context;
import android.view.View;
import com.xiaomi.ad.mediation.MMAdSdk;
import com.xiaomi.ad.mediation.MMFilterable;
import com.xiaomi.ad.mediation.internal.loader.AdInternalConfig;
import com.xiaomi.ad.p;

/* JADX INFO: loaded from: classes5.dex */
public abstract class MMDrawExpressAd extends p implements MMFilterable {
    public AdDrawExpressActionListener mAdDrawExpressActionListener;

    public interface AdDrawExpressActionListener {
        void onAdClicked();

        void onAdDismissed();

        void onAdRenderFail(int i, String str);

        void onAdShow();
    }

    public interface DrawAdDownLoadListener {
        void onDownLoadFinished(MMDrawExpressAd mMDrawExpressAd);

        void onDownLoadProgress(MMDrawExpressAd mMDrawExpressAd, int i);

        void onDownloadFailed(MMDrawExpressAd mMDrawExpressAd);

        void onIdle(MMDrawExpressAd mMDrawExpressAd);

        void onInstalled(MMDrawExpressAd mMDrawExpressAd);
    }

    public interface DrawVideoAdListener {
        void onProgressUpdate(long j, long j2);

        void onVideoAdComplete();

        void onVideoAdContinuePlay();

        void onVideoAdPaused();

        void onVideoAdStartPlay();

        void onVideoError(int i, int i2);

        void onVideoLoad();
    }

    public MMDrawExpressAd(Context context, AdInternalConfig adInternalConfig) {
        super(context, adInternalConfig);
    }

    @Override // com.xiaomi.ad.p
    public String getAdType() {
        return MMAdSdk.AD_TYPE_DRAW_EXPRESS;
    }

    public abstract View getAdView();

    public abstract int getInteractionType();

    @Override // com.xiaomi.ad.mediation.MMFilterable
    public boolean matched(String str) {
        return true;
    }

    public void notifyAdClicked() {
        AdDrawExpressActionListener adDrawExpressActionListener = this.mAdDrawExpressActionListener;
        if (adDrawExpressActionListener != null) {
            adDrawExpressActionListener.onAdClicked();
        }
    }

    public void notifyAdDismissed() {
        AdDrawExpressActionListener adDrawExpressActionListener = this.mAdDrawExpressActionListener;
        if (adDrawExpressActionListener != null) {
            adDrawExpressActionListener.onAdDismissed();
        }
    }

    public void notifyAdShow() {
        AdDrawExpressActionListener adDrawExpressActionListener = this.mAdDrawExpressActionListener;
        if (adDrawExpressActionListener != null) {
            adDrawExpressActionListener.onAdShow();
        }
    }

    public void notifyAdShowFailed(int i, String str) {
        AdDrawExpressActionListener adDrawExpressActionListener = this.mAdDrawExpressActionListener;
        if (adDrawExpressActionListener != null) {
            adDrawExpressActionListener.onAdRenderFail(i, str);
        }
    }

    public abstract void onDestroy();

    public abstract void setCanInterruptVideoPlay(boolean z);

    public abstract void setDownLoadListener(DrawAdDownLoadListener drawAdDownLoadListener);

    public abstract void setVideoAdListener(DrawVideoAdListener drawVideoAdListener);

    public void show(AdDrawExpressActionListener adDrawExpressActionListener) {
        this.mAdDrawExpressActionListener = adDrawExpressActionListener;
    }
}
