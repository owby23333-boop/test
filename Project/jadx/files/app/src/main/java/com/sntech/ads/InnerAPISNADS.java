package com.sntech.ads;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import androidx.annotation.Keep;
import com.sntech.a4.A4AdListener;
import com.sntech.ads.callback.RiskUserCallback;
import com.sntech.event.SNEvent;
import java.util.List;
import q0.e;

/* JADX INFO: loaded from: classes3.dex */
@Keep
public class InnerAPISNADS extends e {
    @Keep
    public InnerAPISNADS(Context context) {
        super(context);
    }

    @Override // q0.e, com.sntech.ads.ISNADS
    public void clickAd(SNEvent.AdPlatform adPlatform, String str, String str2) {
        super.clickAd(adPlatform, str, str2);
    }

    @Override // q0.e, com.sntech.ads.ISNADS
    public String did() {
        return super.did();
    }

    @Override // q0.e, com.sntech.ads.ISNADS
    public double getAdEcpm(SNEvent.AdPlatform adPlatform, SNEvent.AdType adType, String str, double d2) {
        return super.getAdEcpm(adPlatform, adType, str, d2);
    }

    @Override // q0.e, com.sntech.ads.ISNADS
    public String getBannerPlacementId(int i2) {
        return super.getBannerPlacementId(i2);
    }

    @Override // q0.e, com.sntech.ads.ISNADS
    public String getInterstitialPlacementId(int i2) {
        return super.getInterstitialPlacementId(i2);
    }

    @Override // q0.e, com.sntech.ads.ISNADS
    public String getNativePlacementId(int i2) {
        return super.getNativePlacementId(i2);
    }

    @Override // q0.e, com.sntech.ads.ISNADS
    public List<ClassLoader> getPluginClassloaders() {
        return super.getPluginClassloaders();
    }

    @Override // q0.e, com.sntech.ads.ISNADS
    public String getRewardVideoPlacementId(int i2) {
        return super.getRewardVideoPlacementId(i2);
    }

    @Override // q0.e, com.sntech.ads.ISNADS
    public String getSplashPlacementId(int i2) {
        return super.getSplashPlacementId(i2);
    }

    @Override // q0.e, com.sntech.ads.ISNADS
    public int getVersion() {
        return super.getVersion();
    }

    @Override // q0.e, com.sntech.ads.ISNADS
    public void initSDK(String str, String str2) {
        super.initSDK(str, str2);
    }

    @Override // q0.e, com.sntech.ads.ISNADS
    public boolean isAdTypeAvailable(SNEvent.AdPlatform adPlatform, SNEvent.AdType adType) {
        return super.isAdTypeAvailable(adPlatform, adType);
    }

    @Override // q0.e, com.sntech.ads.ISNADS
    public void isRiskUser(RiskUserCallback riskUserCallback) {
        super.isRiskUser(riskUserCallback);
    }

    @Override // q0.e, com.sntech.ads.ISNADS
    public void onNewVersion(int i2) {
        super.onNewVersion(i2);
    }

    @Override // q0.e, com.sntech.ads.ISNADS
    public void onRequestPermissionResult(Activity activity, int i2, String[] strArr, int[] iArr) {
        super.onRequestPermissionResult(activity, i2, strArr, iArr);
    }

    @Override // q0.e, com.sntech.ads.ISNADS
    public void onTopOnAdShow(SNEvent.AdPlatform adPlatform, SNEvent.AdType adType, String str, String str2, double d2) {
        super.onTopOnAdShow(adPlatform, adType, str, str2, d2);
    }

    @Override // q0.e, com.sntech.ads.ISNADS
    public void onUserEvent(SNEvent.UserEvent userEvent) {
        super.onUserEvent(userEvent);
    }

    @Override // q0.e, com.sntech.ads.ISNADS
    public void onWithdraw(String str, float f2, SNEvent.WithdrawChannel withdrawChannel, String str2) {
        super.onWithdraw(str, f2, withdrawChannel, str2);
    }

    @Override // q0.e, com.sntech.ads.ISNADS
    public void requestPermissionsIfNeed(Activity activity, String... strArr) {
        super.requestPermissionsIfNeed(activity, strArr);
    }

    @Override // q0.e, com.sntech.ads.ISNADS
    public void setUserId(String str) {
        super.setUserId(str);
    }

    @Override // q0.e, com.sntech.ads.ISNADS
    public void setupPlugins() {
        super.setupPlugins();
    }

    @Override // q0.e, com.sntech.ads.ISNADS
    public void showA4InterstitialAd(Activity activity, String str, A4AdListener a4AdListener) {
        super.showA4InterstitialAd(activity, str, a4AdListener);
    }

    @Override // q0.e, com.sntech.ads.ISNADS
    public void showAd(View view, SNEvent.AdPlatform adPlatform, String str, double d2, String str2) {
        super.showAd(view, adPlatform, str, d2, str2);
    }

    @Override // q0.e, com.sntech.ads.ISNADS
    public String getBannerPlacementId(int i2, String str) {
        return super.getBannerPlacementId(i2, str);
    }

    @Override // q0.e, com.sntech.ads.ISNADS
    public String getInterstitialPlacementId(int i2, String str) {
        return super.getInterstitialPlacementId(i2, str);
    }

    @Override // q0.e, com.sntech.ads.ISNADS
    public String getNativePlacementId(int i2, String str) {
        return super.getNativePlacementId(i2, str);
    }

    @Override // q0.e, com.sntech.ads.ISNADS
    public String getRewardVideoPlacementId(int i2, String str) {
        return super.getRewardVideoPlacementId(i2, str);
    }

    @Override // q0.e, com.sntech.ads.ISNADS
    public String getSplashPlacementId(int i2, String str) {
        return super.getSplashPlacementId(i2, str);
    }
}
