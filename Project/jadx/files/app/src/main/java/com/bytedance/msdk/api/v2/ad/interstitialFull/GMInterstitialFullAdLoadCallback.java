package com.bytedance.msdk.api.v2.ad.interstitialFull;

import androidx.annotation.NonNull;
import com.bytedance.msdk.api.AdError;

/* JADX INFO: loaded from: classes2.dex */
public interface GMInterstitialFullAdLoadCallback {
    void onInterstitialFullAdLoad();

    void onInterstitialFullCached();

    void onInterstitialFullLoadFail(@NonNull AdError adError);
}
