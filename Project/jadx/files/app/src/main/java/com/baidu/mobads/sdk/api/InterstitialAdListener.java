package com.baidu.mobads.sdk.api;

/* JADX INFO: loaded from: classes2.dex */
public interface InterstitialAdListener {
    void onAdClick(InterstitialAd interstitialAd);

    void onAdDismissed();

    void onAdFailed(String str);

    void onAdPresent();

    void onAdReady();
}
