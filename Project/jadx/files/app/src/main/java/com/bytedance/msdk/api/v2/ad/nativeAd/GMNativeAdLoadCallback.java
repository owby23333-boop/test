package com.bytedance.msdk.api.v2.ad.nativeAd;

import androidx.annotation.NonNull;
import com.bytedance.msdk.api.AdError;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public interface GMNativeAdLoadCallback {
    void onAdLoaded(@NonNull List<GMNativeAd> list);

    void onAdLoadedFail(@NonNull AdError adError);
}
