package com.bytedance.msdk.api.v2.ad.interstitial;

import androidx.annotation.NonNull;
import com.bytedance.msdk.api.AdError;

/* JADX INFO: loaded from: classes2.dex */
public interface GMInterstitialAdLoadCallback {
    void onInterstitialLoad();

    void onInterstitialLoadFail(@NonNull AdError adError);
}
