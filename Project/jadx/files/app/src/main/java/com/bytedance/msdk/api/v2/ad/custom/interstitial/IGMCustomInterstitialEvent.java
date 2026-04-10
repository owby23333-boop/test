package com.bytedance.msdk.api.v2.ad.custom.interstitial;

/* JADX INFO: loaded from: classes2.dex */
public interface IGMCustomInterstitialEvent {
    void callInterstitialAdClick();

    void callInterstitialAdLeftApplication();

    void callInterstitialAdOpened();

    void callInterstitialClosed();

    void callInterstitialShow();
}
