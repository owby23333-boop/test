package com.sntech.ads;

import androidx.annotation.Keep;
import com.anythink.core.api.ATAdInfo;
import com.sntech.ads.api.event.SNEvent;

/* JADX INFO: loaded from: classes.dex */
public interface SNMediationManager {
    @Keep
    double getAdEcpm(SNEvent.AdPlatform adPlatform, SNEvent.AdType adType, String str, double d2);

    @Keep
    String getBannerPlacementId(int i2);

    @Keep
    String getBannerPlacementId(int i2, String str);

    @Keep
    String getInterstitialPlacementId(int i2);

    @Keep
    String getInterstitialPlacementId(int i2, String str);

    @Keep
    String getNativePlacementId(int i2);

    @Keep
    String getNativePlacementId(int i2, String str);

    @Keep
    String getRewardVideoPlacementId(int i2);

    @Keep
    String getRewardVideoPlacementId(int i2, String str);

    @Keep
    String getSplashPlacementId(int i2);

    @Keep
    String getSplashPlacementId(int i2, String str);

    @Keep
    boolean isAdTypeAvailable(SNEvent.AdPlatform adPlatform, SNEvent.AdType adType);

    @Keep
    void onAdShow(SNEvent.AdPlatform adPlatform, SNEvent.AdType adType, String str, double d2);

    @Keep
    void onTopOnAdShow(SNEvent.AdPlatform adPlatform, SNEvent.AdType adType, String str, String str2, double d2);

    @Keep
    void onTopOnAdShow(SNEvent.AdType adType, ATAdInfo aTAdInfo);
}
