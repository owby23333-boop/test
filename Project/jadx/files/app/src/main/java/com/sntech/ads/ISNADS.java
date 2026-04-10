package com.sntech.ads;

import android.app.Activity;
import android.view.View;
import androidx.annotation.Keep;
import com.sntech.a4.A4AdListener;
import com.sntech.ads.callback.RiskUserCallback;
import com.sntech.event.SNEvent;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
@Keep
public interface ISNADS {
    @Keep
    void clickAd(SNEvent.AdPlatform adPlatform, String str, String str2);

    @Keep
    String did();

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
    @Deprecated
    List<ClassLoader> getPluginClassloaders();

    @Keep
    String getRewardVideoPlacementId(int i2);

    @Keep
    String getRewardVideoPlacementId(int i2, String str);

    @Keep
    String getSplashPlacementId(int i2);

    @Keep
    String getSplashPlacementId(int i2, String str);

    @Keep
    int getVersion();

    @Keep
    void initSDK(String str, String str2);

    @Keep
    boolean isAdTypeAvailable(SNEvent.AdPlatform adPlatform, SNEvent.AdType adType);

    @Keep
    void isRiskUser(RiskUserCallback riskUserCallback);

    @Keep
    void onNewVersion(int i2);

    @Keep
    void onRequestPermissionResult(Activity activity, int i2, String[] strArr, int[] iArr);

    @Keep
    void onTopOnAdShow(SNEvent.AdPlatform adPlatform, SNEvent.AdType adType, String str, String str2, double d2);

    @Keep
    void onUserEvent(SNEvent.UserEvent userEvent);

    @Keep
    void onWithdraw(String str, float f2, SNEvent.WithdrawChannel withdrawChannel, String str2);

    @Keep
    void requestPermissionsIfNeed(Activity activity, String... strArr);

    @Keep
    void setUserId(String str);

    @Keep
    @Deprecated
    void setupPlugins();

    @Keep
    void showA4InterstitialAd(Activity activity, String str, A4AdListener a4AdListener);

    @Keep
    void showAd(View view, SNEvent.AdPlatform adPlatform, String str, double d2, String str2);
}
