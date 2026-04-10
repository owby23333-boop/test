package com.baidu.mobads.sdk.api;

/* JADX INFO: loaded from: classes2.dex */
public interface ExpressInterstitialListener {
    void onADExposed();

    void onADExposureFailed();

    void onADLoaded();

    void onAdCacheFailed();

    void onAdCacheSuccess();

    void onAdClick();

    void onAdClose();

    void onAdFailed(int i2, String str);

    void onLpClosed();

    void onNoAd(int i2, String str);

    @Deprecated
    void onVideoDownloadFailed();

    @Deprecated
    void onVideoDownloadSuccess();
}
