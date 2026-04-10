package com.bytedance.msdk.api.v2.ad.interstitial;

import androidx.annotation.NonNull;
import com.bytedance.msdk.adapter.listener.ITTAdatperCallback;
import com.bytedance.msdk.api.AdError;

/* JADX INFO: loaded from: classes2.dex */
public interface GMInterstitialAdListener extends ITTAdatperCallback {
    void onAdLeftApplication();

    void onAdOpened();

    void onInterstitialAdClick();

    void onInterstitialClosed();

    void onInterstitialShow();

    void onInterstitialShowFail(@NonNull AdError adError);
}
