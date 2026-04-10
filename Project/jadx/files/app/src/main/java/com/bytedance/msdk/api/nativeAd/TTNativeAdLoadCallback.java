package com.bytedance.msdk.api.nativeAd;

import androidx.annotation.NonNull;
import com.bytedance.msdk.api.AdError;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
@Deprecated
public interface TTNativeAdLoadCallback {
    void onAdLoaded(@NonNull List<TTNativeAd> list);

    void onAdLoadedFial(@NonNull AdError adError);
}
