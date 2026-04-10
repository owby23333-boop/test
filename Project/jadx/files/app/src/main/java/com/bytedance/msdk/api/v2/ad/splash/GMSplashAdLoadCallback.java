package com.bytedance.msdk.api.v2.ad.splash;

import androidx.annotation.NonNull;
import com.bytedance.msdk.api.AdError;

/* JADX INFO: loaded from: classes2.dex */
public interface GMSplashAdLoadCallback {
    @Deprecated
    void onAdLoadTimeout();

    void onSplashAdLoadFail(@NonNull AdError adError);

    void onSplashAdLoadSuccess();
}
