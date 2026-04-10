package q0;

import android.app.Activity;
import android.view.View;
import com.sntech.a4.A4AdListener;
import com.sntech.ads.ISNADS;
import com.sntech.ads.callback.RiskUserCallback;
import com.sntech.event.SNEvent;
import java.util.List;

/* JADX INFO: compiled from: FallbackSNADS.java */
/* JADX INFO: loaded from: classes4.dex */
public class f implements ISNADS {
    public final ISNADS a;
    public final ISNADS b;

    public f(ISNADS isnads, ISNADS isnads2) {
        this.a = isnads;
        this.b = isnads2;
    }

    @Override // com.sntech.ads.ISNADS
    public void clickAd(SNEvent.AdPlatform adPlatform, String str, String str2) {
        ISNADS isnads = this.b;
        if (isnads == null) {
            this.a.clickAd(adPlatform, str, str2);
            return;
        }
        try {
            isnads.clickAd(adPlatform, str, str2);
        } catch (Throwable th) {
            if (n.b.b()) {
                th.printStackTrace();
            }
            this.a.clickAd(adPlatform, str, str2);
        }
    }

    @Override // com.sntech.ads.ISNADS
    public String did() {
        ISNADS isnads = this.b;
        if (isnads == null) {
            return this.a.did();
        }
        try {
            return isnads.did();
        } catch (Throwable th) {
            if (n.b.b()) {
                th.printStackTrace();
            }
            return this.a.did();
        }
    }

    @Override // com.sntech.ads.ISNADS
    public double getAdEcpm(SNEvent.AdPlatform adPlatform, SNEvent.AdType adType, String str, double d2) {
        ISNADS isnads = this.b;
        if (isnads == null) {
            return this.a.getAdEcpm(adPlatform, adType, str, d2);
        }
        try {
            return isnads.getAdEcpm(adPlatform, adType, str, d2);
        } catch (Throwable th) {
            if (n.b.b()) {
                th.printStackTrace();
            }
            return this.a.getAdEcpm(adPlatform, adType, str, d2);
        }
    }

    @Override // com.sntech.ads.ISNADS
    public String getBannerPlacementId(int i2) {
        ISNADS isnads = this.b;
        if (isnads == null) {
            return this.a.getBannerPlacementId(i2);
        }
        try {
            return isnads.getBannerPlacementId(i2);
        } catch (Throwable th) {
            if (n.b.b()) {
                th.printStackTrace();
            }
            return this.a.getBannerPlacementId(i2);
        }
    }

    @Override // com.sntech.ads.ISNADS
    public String getInterstitialPlacementId(int i2) {
        ISNADS isnads = this.b;
        if (isnads == null) {
            return this.a.getInterstitialPlacementId(i2);
        }
        try {
            return isnads.getInterstitialPlacementId(i2);
        } catch (Throwable th) {
            if (n.b.b()) {
                th.printStackTrace();
            }
            return this.a.getInterstitialPlacementId(i2);
        }
    }

    @Override // com.sntech.ads.ISNADS
    public String getNativePlacementId(int i2) {
        ISNADS isnads = this.b;
        if (isnads == null) {
            return this.a.getNativePlacementId(i2);
        }
        try {
            return isnads.getNativePlacementId(i2);
        } catch (Throwable th) {
            if (n.b.b()) {
                th.printStackTrace();
            }
            return this.a.getNativePlacementId(i2);
        }
    }

    @Override // com.sntech.ads.ISNADS
    public List<ClassLoader> getPluginClassloaders() {
        ISNADS isnads = this.b;
        if (isnads == null) {
            return this.a.getPluginClassloaders();
        }
        try {
            return isnads.getPluginClassloaders();
        } catch (Throwable th) {
            if (n.b.b()) {
                th.printStackTrace();
            }
            return this.a.getPluginClassloaders();
        }
    }

    @Override // com.sntech.ads.ISNADS
    public String getRewardVideoPlacementId(int i2) {
        ISNADS isnads = this.b;
        if (isnads == null) {
            return this.a.getRewardVideoPlacementId(i2);
        }
        try {
            return isnads.getRewardVideoPlacementId(i2);
        } catch (Throwable th) {
            if (n.b.b()) {
                th.printStackTrace();
            }
            return this.a.getRewardVideoPlacementId(i2);
        }
    }

    @Override // com.sntech.ads.ISNADS
    public String getSplashPlacementId(int i2) {
        ISNADS isnads = this.b;
        if (isnads == null) {
            return this.a.getSplashPlacementId(i2);
        }
        try {
            return isnads.getSplashPlacementId(i2);
        } catch (Throwable th) {
            if (n.b.b()) {
                th.printStackTrace();
            }
            return this.a.getSplashPlacementId(i2);
        }
    }

    @Override // com.sntech.ads.ISNADS
    public int getVersion() {
        ISNADS isnads = this.b;
        if (isnads == null) {
            return this.a.getVersion();
        }
        try {
            return isnads.getVersion();
        } catch (Throwable th) {
            if (n.b.b()) {
                th.printStackTrace();
            }
            return this.a.getVersion();
        }
    }

    @Override // com.sntech.ads.ISNADS
    public void initSDK(String str, String str2) {
        ISNADS isnads = this.b;
        if (isnads == null) {
            this.a.initSDK(str, str2);
            return;
        }
        try {
            isnads.initSDK(str, str2);
        } catch (Throwable th) {
            if (n.b.b()) {
                th.printStackTrace();
            }
            this.a.initSDK(str, str2);
        }
    }

    @Override // com.sntech.ads.ISNADS
    public boolean isAdTypeAvailable(SNEvent.AdPlatform adPlatform, SNEvent.AdType adType) {
        ISNADS isnads = this.b;
        if (isnads == null) {
            return this.a.isAdTypeAvailable(adPlatform, adType);
        }
        try {
            return isnads.isAdTypeAvailable(adPlatform, adType);
        } catch (Throwable th) {
            if (n.b.b()) {
                th.printStackTrace();
            }
            return this.a.isAdTypeAvailable(adPlatform, adType);
        }
    }

    @Override // com.sntech.ads.ISNADS
    public void isRiskUser(RiskUserCallback riskUserCallback) {
        ISNADS isnads = this.b;
        if (isnads == null) {
            this.a.isRiskUser(riskUserCallback);
            return;
        }
        try {
            isnads.isRiskUser(riskUserCallback);
        } catch (Throwable th) {
            if (n.b.b()) {
                th.printStackTrace();
            }
            this.a.isRiskUser(riskUserCallback);
        }
    }

    @Override // com.sntech.ads.ISNADS
    public void onNewVersion(int i2) {
        ISNADS isnads = this.b;
        if (isnads == null) {
            this.a.onNewVersion(i2);
            return;
        }
        try {
            isnads.onNewVersion(i2);
        } catch (Throwable th) {
            if (n.b.b()) {
                th.printStackTrace();
            }
            this.a.onNewVersion(i2);
        }
    }

    @Override // com.sntech.ads.ISNADS
    public void onRequestPermissionResult(Activity activity, int i2, String[] strArr, int[] iArr) {
        ISNADS isnads = this.b;
        if (isnads == null) {
            this.a.onRequestPermissionResult(activity, i2, strArr, iArr);
            return;
        }
        try {
            isnads.onRequestPermissionResult(activity, i2, strArr, iArr);
        } catch (Throwable th) {
            if (n.b.b()) {
                th.printStackTrace();
            }
            this.a.onRequestPermissionResult(activity, i2, strArr, iArr);
        }
    }

    @Override // com.sntech.ads.ISNADS
    public void onTopOnAdShow(SNEvent.AdPlatform adPlatform, SNEvent.AdType adType, String str, String str2, double d2) {
        ISNADS isnads = this.b;
        if (isnads == null) {
            this.a.onTopOnAdShow(adPlatform, adType, str, str2, d2);
            return;
        }
        try {
            isnads.onTopOnAdShow(adPlatform, adType, str, str2, d2);
        } catch (Throwable th) {
            if (n.b.b()) {
                th.printStackTrace();
            }
            this.a.onTopOnAdShow(adPlatform, adType, str, str2, d2);
        }
    }

    @Override // com.sntech.ads.ISNADS
    public void onUserEvent(SNEvent.UserEvent userEvent) {
        ISNADS isnads = this.b;
        if (isnads == null) {
            this.a.onUserEvent(userEvent);
            return;
        }
        try {
            isnads.onUserEvent(userEvent);
        } catch (Throwable th) {
            if (n.b.b()) {
                th.printStackTrace();
            }
            this.a.onUserEvent(userEvent);
        }
    }

    @Override // com.sntech.ads.ISNADS
    public void onWithdraw(String str, float f2, SNEvent.WithdrawChannel withdrawChannel, String str2) {
        ISNADS isnads = this.b;
        if (isnads == null) {
            this.a.onWithdraw(str, f2, withdrawChannel, str2);
            return;
        }
        try {
            isnads.onWithdraw(str, f2, withdrawChannel, str2);
        } catch (Throwable th) {
            if (n.b.b()) {
                th.printStackTrace();
            }
            this.a.onWithdraw(str, f2, withdrawChannel, str2);
        }
    }

    @Override // com.sntech.ads.ISNADS
    public void requestPermissionsIfNeed(Activity activity, String... strArr) {
        ISNADS isnads = this.b;
        if (isnads == null) {
            this.a.requestPermissionsIfNeed(activity, strArr);
            return;
        }
        try {
            isnads.requestPermissionsIfNeed(activity, strArr);
        } catch (Throwable th) {
            if (n.b.b()) {
                th.printStackTrace();
            }
            this.a.requestPermissionsIfNeed(activity, strArr);
        }
    }

    @Override // com.sntech.ads.ISNADS
    public void setUserId(String str) {
        ISNADS isnads = this.b;
        if (isnads == null) {
            this.a.setUserId(str);
            return;
        }
        try {
            isnads.setUserId(str);
        } catch (Throwable th) {
            if (n.b.b()) {
                th.printStackTrace();
            }
            this.a.setUserId(str);
        }
    }

    @Override // com.sntech.ads.ISNADS
    public void setupPlugins() {
        ISNADS isnads = this.b;
        if (isnads == null) {
            this.a.setupPlugins();
            return;
        }
        try {
            isnads.setupPlugins();
        } catch (Throwable th) {
            if (n.b.b()) {
                th.printStackTrace();
            }
            this.a.setupPlugins();
        }
    }

    @Override // com.sntech.ads.ISNADS
    public void showA4InterstitialAd(Activity activity, String str, A4AdListener a4AdListener) {
        ISNADS isnads = this.b;
        if (isnads == null) {
            this.a.showA4InterstitialAd(activity, str, a4AdListener);
            return;
        }
        try {
            isnads.showA4InterstitialAd(activity, str, a4AdListener);
        } catch (Throwable th) {
            if (n.b.b()) {
                th.printStackTrace();
            }
            this.a.showA4InterstitialAd(activity, str, a4AdListener);
        }
    }

    @Override // com.sntech.ads.ISNADS
    public void showAd(View view, SNEvent.AdPlatform adPlatform, String str, double d2, String str2) {
        ISNADS isnads = this.b;
        if (isnads == null) {
            this.a.showAd(view, adPlatform, str, d2, str2);
            return;
        }
        try {
            isnads.showAd(view, adPlatform, str, d2, str2);
        } catch (Throwable th) {
            if (n.b.b()) {
                th.printStackTrace();
            }
            this.a.showAd(view, adPlatform, str, d2, str2);
        }
    }

    @Override // com.sntech.ads.ISNADS
    public String getBannerPlacementId(int i2, String str) {
        ISNADS isnads = this.b;
        if (isnads != null) {
            try {
                return isnads.getBannerPlacementId(i2, str);
            } catch (Throwable th) {
                if (n.b.b()) {
                    th.printStackTrace();
                }
                return this.a.getBannerPlacementId(i2, str);
            }
        }
        return this.a.getBannerPlacementId(i2, str);
    }

    @Override // com.sntech.ads.ISNADS
    public String getInterstitialPlacementId(int i2, String str) {
        ISNADS isnads = this.b;
        if (isnads != null) {
            try {
                return isnads.getInterstitialPlacementId(i2, str);
            } catch (Throwable th) {
                if (n.b.b()) {
                    th.printStackTrace();
                }
                return this.a.getInterstitialPlacementId(i2, str);
            }
        }
        return this.a.getInterstitialPlacementId(i2, str);
    }

    @Override // com.sntech.ads.ISNADS
    public String getNativePlacementId(int i2, String str) {
        ISNADS isnads = this.b;
        if (isnads != null) {
            try {
                return isnads.getNativePlacementId(i2, str);
            } catch (Throwable th) {
                if (n.b.b()) {
                    th.printStackTrace();
                }
                return this.a.getNativePlacementId(i2, str);
            }
        }
        return this.a.getNativePlacementId(i2, str);
    }

    @Override // com.sntech.ads.ISNADS
    public String getRewardVideoPlacementId(int i2, String str) {
        ISNADS isnads = this.b;
        if (isnads != null) {
            try {
                return isnads.getRewardVideoPlacementId(i2, str);
            } catch (Throwable th) {
                if (n.b.b()) {
                    th.printStackTrace();
                }
                return this.a.getRewardVideoPlacementId(i2, str);
            }
        }
        return this.a.getRewardVideoPlacementId(i2, str);
    }

    @Override // com.sntech.ads.ISNADS
    public String getSplashPlacementId(int i2, String str) {
        ISNADS isnads = this.b;
        if (isnads != null) {
            try {
                return isnads.getSplashPlacementId(i2, str);
            } catch (Throwable th) {
                if (n.b.b()) {
                    th.printStackTrace();
                }
                return this.a.getSplashPlacementId(i2, str);
            }
        }
        return this.a.getSplashPlacementId(i2, str);
    }
}
