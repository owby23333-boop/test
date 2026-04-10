package com.bytedance.msdk.api.v2.ad.banner;

import androidx.annotation.NonNull;
import com.bytedance.msdk.api.AdError;

/* JADX INFO: loaded from: classes2.dex */
public interface GMBannerAdLoadCallback {
    void onAdFailedToLoad(@NonNull AdError adError);

    void onAdLoaded();
}
