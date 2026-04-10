package com.sntech.ads.impl;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import androidx.annotation.Keep;
import com.anythink.core.api.ATAdInfo;
import com.sntech.ads.BuildConfig;
import com.sntech.ads.ISNADS;
import com.sntech.ads.SNADSImpl;
import com.sntech.ads.SNAdConfig;
import com.sntech.ads.callback.RiskUserCallback;
import com.sntech.event.SNEvent;
import com.sntech.net.Cif;
import com.sntech.net.DomainConfig;
import com.sntech.net.DomainManager;
import com.sntech.stat.Cdo;
import n.b;
import z0.o;

/* JADX INFO: loaded from: classes.dex */
@Keep
public class SNADS {
    private static Context sContext;
    private static ISNADS sSnads;

    @Keep
    public static void clickAd(SNEvent.AdPlatform adPlatform, String str) {
        ISNADS isnads = sSnads;
        if (isnads != null) {
            isnads.clickAd(adPlatform, str, null);
        }
    }

    @Keep
    public static String did() {
        ISNADS isnads = sSnads;
        if (isnads != null) {
            return isnads.did();
        }
        return null;
    }

    @Keep
    public static A4Ads getA4Ads() {
        return new A4Ads(sSnads);
    }

    @Keep
    public static double getAdEcpm(SNEvent.AdPlatform adPlatform, SNEvent.AdType adType, String str, double d2) {
        ISNADS isnads = sSnads;
        return isnads != null ? isnads.getAdEcpm(adPlatform, adType, str, d2) : d2;
    }

    @Keep
    public static String getBannerPlacementId(int i2) {
        ISNADS isnads = sSnads;
        if (isnads != null) {
            return isnads.getBannerPlacementId(i2);
        }
        return null;
    }

    @Keep
    public static String getInterstitialPlacementId(int i2) {
        ISNADS isnads = sSnads;
        if (isnads != null) {
            return isnads.getInterstitialPlacementId(i2);
        }
        return null;
    }

    @Keep
    public static String getNativePlacementId(int i2) {
        ISNADS isnads = sSnads;
        if (isnads != null) {
            return isnads.getNativePlacementId(i2);
        }
        return null;
    }

    @Keep
    public static String getRewardVideoPlacementId(int i2) {
        ISNADS isnads = sSnads;
        if (isnads != null) {
            return isnads.getRewardVideoPlacementId(i2);
        }
        return null;
    }

    @Keep
    public static String getSplashPlacementId(int i2) {
        ISNADS isnads = sSnads;
        if (isnads != null) {
            return isnads.getSplashPlacementId(i2);
        }
        return null;
    }

    @Keep
    public static int getVersion() {
        ISNADS isnads = sSnads;
        return (isnads != null ? Integer.valueOf(isnads.getVersion()) : null).intValue();
    }

    @Keep
    public static void initSDK(Context context, SNAdConfig sNAdConfig) {
        b.a = sNAdConfig.isDebug();
        context.getSharedPreferences("prefs_sn_android", 0).edit().putString("app_channel", sNAdConfig.getChannel()).apply();
        initSDK(context, sNAdConfig.getUserId(), sNAdConfig.getAppId());
    }

    @Keep
    public static boolean isAdTypeAvailable(SNEvent.AdPlatform adPlatform, SNEvent.AdType adType) {
        ISNADS isnads = sSnads;
        if (isnads != null) {
            return isnads.isAdTypeAvailable(adPlatform, adType);
        }
        return true;
    }

    @Keep
    public static void isRiskUser(RiskUserCallback riskUserCallback) {
        ISNADS isnads = sSnads;
        if (isnads != null) {
            isnads.isRiskUser(riskUserCallback);
        }
    }

    @Keep
    public static void onAdShow(SNEvent.AdPlatform adPlatform, SNEvent.AdType adType, String str, double d2) {
        onTopOnAdShow(adPlatform, adType, null, str, d2);
    }

    @Keep
    public static void onRequestPermissionResult(Activity activity, int i2, String[] strArr, int[] iArr) {
        ISNADS isnads = sSnads;
        if (isnads != null) {
            isnads.onRequestPermissionResult(activity, i2, strArr, iArr);
        }
    }

    @Keep
    public static void onTopOnAdShow(SNEvent.AdType adType, ATAdInfo aTAdInfo) {
        onTopOnAdShow(SNEvent.getTopOnRealAdPlatform(aTAdInfo), adType, aTAdInfo.getTopOnPlacementId(), SNEvent.getTopOnRealAdId(aTAdInfo), aTAdInfo.getEcpm());
    }

    @Keep
    public static void onUserEvent(SNEvent.UserEvent userEvent) {
        ISNADS isnads = sSnads;
        if (isnads != null) {
            isnads.onUserEvent(userEvent);
        }
    }

    @Keep
    public static void onWithdraw(String str, float f2, SNEvent.WithdrawChannel withdrawChannel, String str2) {
        ISNADS isnads = sSnads;
        if (isnads != null) {
            isnads.onWithdraw(str, f2, withdrawChannel, str2);
        }
    }

    @Keep
    public static void requestPermissionsIfNeed(Activity activity, String... strArr) {
        ISNADS isnads = sSnads;
        if (isnads != null) {
            isnads.requestPermissionsIfNeed(activity, strArr);
        }
    }

    @Keep
    public static void setABTest(String str, int i2, String... strArr) {
        o.a().a(str, i2, strArr);
    }

    @Keep
    public static void setUserId(String str) {
        ISNADS isnads = sSnads;
        if (isnads != null) {
            isnads.setUserId(str);
        }
    }

    @Keep
    public static void showAd(View view, SNEvent.AdPlatform adPlatform, String str, double d2) {
        ISNADS isnads = sSnads;
        if (isnads != null) {
            isnads.showAd(view, adPlatform, str, d2, null);
        }
    }

    @Keep
    public static String getBannerPlacementId(int i2, String str) {
        ISNADS isnads = sSnads;
        return isnads != null ? isnads.getBannerPlacementId(i2, str) : str;
    }

    @Keep
    public static String getInterstitialPlacementId(int i2, String str) {
        ISNADS isnads = sSnads;
        return isnads != null ? isnads.getInterstitialPlacementId(i2, str) : str;
    }

    @Keep
    public static String getNativePlacementId(int i2, String str) {
        ISNADS isnads = sSnads;
        return isnads != null ? isnads.getNativePlacementId(i2, str) : str;
    }

    @Keep
    public static String getRewardVideoPlacementId(int i2, String str) {
        ISNADS isnads = sSnads;
        return isnads != null ? isnads.getRewardVideoPlacementId(i2, str) : str;
    }

    @Keep
    public static String getSplashPlacementId(int i2, String str) {
        ISNADS isnads = sSnads;
        return isnads != null ? isnads.getSplashPlacementId(i2, str) : str;
    }

    @Keep
    public static void clickAd(SNEvent.AdPlatform adPlatform, String str, String str2) {
        ISNADS isnads = sSnads;
        if (isnads != null) {
            isnads.clickAd(adPlatform, str, str2);
        }
    }

    @Keep
    public static void showAd(View view, SNEvent.AdPlatform adPlatform, String str, double d2, String str2) {
        ISNADS isnads = sSnads;
        if (isnads != null) {
            isnads.showAd(view, adPlatform, str, d2, str2);
        }
    }

    @Keep
    public static void onTopOnAdShow(SNEvent.AdPlatform adPlatform, SNEvent.AdType adType, String str, String str2, double d2) {
        ISNADS isnads = sSnads;
        if (isnads != null) {
            isnads.onTopOnAdShow(adPlatform, adType, str, str2, d2);
        }
    }

    @Keep
    public static void initSDK(Context context, String str, String str2) {
        sContext = context;
        boolean z2 = Cdo.f125do;
        Cif.m101do(context, BuildConfig.VERSION_NAME, q.b.a(context), str2);
        DomainConfig.Cdo cdo = new DomainConfig.Cdo();
        cdo.f81do.put(DomainConfig.TEMPLATE_X1, new String[]{"x1.dongfenbao.cn"});
        cdo.f81do.put(DomainConfig.TEMPLATE_X2, new String[]{"x2.dongfenbao.cn"});
        cdo.f81do.put(DomainConfig.TEMPLATE_DEVICE, new String[]{"device-center.dongfenbao.cn"});
        cdo.f81do.put(DomainConfig.TEMPLATE_A4, new String[]{"new-a4.dongfenbao.cn"});
        DomainManager.get().init(context, new DomainConfig(cdo));
        com.sn.android.Cif cifM84do = com.sn.android.Cif.m84do(context);
        cifM84do.getClass();
        if (Thread.getDefaultUncaughtExceptionHandler() != cifM84do) {
            cifM84do.f69if = Thread.getDefaultUncaughtExceptionHandler();
            Thread.setDefaultUncaughtExceptionHandler(cifM84do);
        }
        if (sSnads == null) {
            SNADSImpl sNADSImpl = SNADSImpl.get(context);
            sSnads = sNADSImpl;
            sNADSImpl.initSDK(str, str2);
        }
    }
}
