package com.sntech.ads.impl;

import com.anythink.core.api.ATAdInfo;
import com.sntech.ads.SNMediationManager;
import com.sntech.ads.api.event.SNEvent;
import com.sntech.ads.impl.utils.EventConverter;

/* JADX INFO: loaded from: classes.dex */
public class SNMediationManagerImpl implements SNMediationManager {

    /* JADX INFO: loaded from: classes3.dex */
    public static class Holder {
        private static final SNMediationManager sInstance = new SNMediationManagerImpl();

        private Holder() {
        }
    }

    public static SNMediationManager get() {
        return Holder.sInstance;
    }

    @Override // com.sntech.ads.SNMediationManager
    public double getAdEcpm(SNEvent.AdPlatform adPlatform, SNEvent.AdType adType, String str, double d2) {
        return SNADS.getAdEcpm(EventConverter.convertPlatform(adPlatform), EventConverter.convertAdType(adType), str, d2);
    }

    @Override // com.sntech.ads.SNMediationManager
    public String getBannerPlacementId(int i2) {
        return SNADS.getBannerPlacementId(i2);
    }

    @Override // com.sntech.ads.SNMediationManager
    public String getInterstitialPlacementId(int i2) {
        return SNADS.getInterstitialPlacementId(i2);
    }

    @Override // com.sntech.ads.SNMediationManager
    public String getNativePlacementId(int i2) {
        return SNADS.getNativePlacementId(i2);
    }

    @Override // com.sntech.ads.SNMediationManager
    public String getRewardVideoPlacementId(int i2) {
        return SNADS.getRewardVideoPlacementId(i2);
    }

    @Override // com.sntech.ads.SNMediationManager
    public String getSplashPlacementId(int i2) {
        return SNADS.getSplashPlacementId(i2);
    }

    @Override // com.sntech.ads.SNMediationManager
    public boolean isAdTypeAvailable(SNEvent.AdPlatform adPlatform, SNEvent.AdType adType) {
        return SNADS.isAdTypeAvailable(EventConverter.convertPlatform(adPlatform), EventConverter.convertAdType(adType));
    }

    @Override // com.sntech.ads.SNMediationManager
    public void onAdShow(SNEvent.AdPlatform adPlatform, SNEvent.AdType adType, String str, double d2) {
        onTopOnAdShow(adPlatform, adType, null, str, d2);
    }

    @Override // com.sntech.ads.SNMediationManager
    public void onTopOnAdShow(SNEvent.AdType adType, ATAdInfo aTAdInfo) {
        onTopOnAdShow(SNEvent.getTopOnRealAdPlatform(aTAdInfo), adType, aTAdInfo.getTopOnPlacementId(), SNEvent.getTopOnRealAdId(aTAdInfo), aTAdInfo.getEcpm());
    }

    @Override // com.sntech.ads.SNMediationManager
    public String getBannerPlacementId(int i2, String str) {
        return SNADS.getBannerPlacementId(i2, str);
    }

    @Override // com.sntech.ads.SNMediationManager
    public String getInterstitialPlacementId(int i2, String str) {
        return SNADS.getInterstitialPlacementId(i2, str);
    }

    @Override // com.sntech.ads.SNMediationManager
    public String getNativePlacementId(int i2, String str) {
        return SNADS.getNativePlacementId(i2, str);
    }

    @Override // com.sntech.ads.SNMediationManager
    public String getRewardVideoPlacementId(int i2, String str) {
        return SNADS.getRewardVideoPlacementId(i2, str);
    }

    @Override // com.sntech.ads.SNMediationManager
    public String getSplashPlacementId(int i2, String str) {
        return SNADS.getSplashPlacementId(i2, str);
    }

    @Override // com.sntech.ads.SNMediationManager
    public void onTopOnAdShow(SNEvent.AdPlatform adPlatform, SNEvent.AdType adType, String str, String str2, double d2) {
        SNADS.onTopOnAdShow(EventConverter.convertPlatform(adPlatform), EventConverter.convertAdType(adType), str, str2, d2);
    }
}
