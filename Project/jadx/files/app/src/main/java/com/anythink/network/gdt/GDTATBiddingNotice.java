package com.anythink.network.gdt;

import com.anythink.core.api.ATAdConst;
import com.anythink.core.api.ATBiddingNotice;
import com.anythink.core.api.ATSDK;
import com.qq.e.ads.banner2.UnifiedBannerView;
import com.qq.e.ads.interstitial2.UnifiedInterstitialAD;
import com.qq.e.ads.rewardvideo.RewardVideoAD;
import com.qq.e.ads.splash.SplashAD;
import com.qq.e.comm.pi.IBidding;
import java.util.HashMap;

/* JADX INFO: loaded from: classes2.dex */
public class GDTATBiddingNotice implements ATBiddingNotice {
    Object a;

    protected GDTATBiddingNotice(Object obj) {
        this.a = obj;
    }

    @Override // com.anythink.core.api.ATBiddingNotice
    public ATAdConst.CURRENCY getNoticePriceCurrency() {
        return ATAdConst.CURRENCY.RMB_CENT;
    }

    @Override // com.anythink.core.api.ATBiddingNotice
    public void notifyBidDisplay(boolean z2, double d2) {
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0035  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0068  */
    @Override // com.anythink.core.api.ATBiddingNotice
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void notifyBidLoss(java.lang.String r8, double r9, java.util.Map<java.lang.String, java.lang.Object> r11) {
        /*
            Method dump skipped, instruction units count: 290
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.anythink.network.gdt.GDTATBiddingNotice.notifyBidLoss(java.lang.String, double, java.util.Map):void");
    }

    @Override // com.anythink.core.api.ATBiddingNotice
    public void notifyBidWin(double d2) {
        HashMap map = new HashMap(4);
        map.put(IBidding.HIGHEST_LOSS_PRICE, Integer.valueOf((int) d2));
        try {
            if (this.a instanceof RewardVideoAD) {
                RewardVideoAD rewardVideoAD = (RewardVideoAD) this.a;
                map.put(IBidding.EXPECT_COST_PRICE, Integer.valueOf(rewardVideoAD.getECPM()));
                if (ATSDK.isNetworkLogDebug()) {
                    StringBuilder sb = new StringBuilder();
                    sb.append(this.a != null ? this.a.toString() : "");
                    sb.append(": notifyBidWin: ");
                    sb.append(map.toString());
                    sb.toString();
                }
                rewardVideoAD.sendWinNotification(map);
                return;
            }
        } catch (Throwable unused) {
        }
        try {
            if (this.a instanceof UnifiedInterstitialAD) {
                UnifiedInterstitialAD unifiedInterstitialAD = (UnifiedInterstitialAD) this.a;
                map.put(IBidding.EXPECT_COST_PRICE, Integer.valueOf(unifiedInterstitialAD.getECPM()));
                if (ATSDK.isNetworkLogDebug()) {
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append(this.a != null ? this.a.toString() : "");
                    sb2.append(": notifyBidWin: ");
                    sb2.append(map.toString());
                    sb2.toString();
                }
                unifiedInterstitialAD.sendWinNotification(map);
                return;
            }
        } catch (Throwable unused2) {
        }
        try {
            if (this.a instanceof SplashAD) {
                SplashAD splashAD = (SplashAD) this.a;
                map.put(IBidding.EXPECT_COST_PRICE, Integer.valueOf(splashAD.getECPM()));
                if (ATSDK.isNetworkLogDebug()) {
                    StringBuilder sb3 = new StringBuilder();
                    sb3.append(this.a != null ? this.a.toString() : "");
                    sb3.append(": notifyBidWin: ");
                    sb3.append(map.toString());
                    sb3.toString();
                }
                splashAD.sendWinNotification(map);
                return;
            }
        } catch (Throwable unused3) {
        }
        try {
            if (this.a instanceof UnifiedBannerView) {
                UnifiedBannerView unifiedBannerView = (UnifiedBannerView) this.a;
                map.put(IBidding.EXPECT_COST_PRICE, Integer.valueOf(unifiedBannerView.getECPM()));
                if (ATSDK.isNetworkLogDebug()) {
                    StringBuilder sb4 = new StringBuilder();
                    sb4.append(this.a != null ? this.a.toString() : "");
                    sb4.append(": notifyBidWin: ");
                    sb4.append(map.toString());
                    sb4.toString();
                }
                unifiedBannerView.sendWinNotification(map);
                return;
            }
        } catch (Throwable unused4) {
        }
        if (this.a instanceof GDTATNativeExpressAd) {
            GDTATNativeExpressAd gDTATNativeExpressAd = (GDTATNativeExpressAd) this.a;
            map.put(IBidding.EXPECT_COST_PRICE, Integer.valueOf(gDTATNativeExpressAd.b.getECPM()));
            if (ATSDK.isNetworkLogDebug()) {
                StringBuilder sb5 = new StringBuilder();
                sb5.append(this.a != null ? this.a.toString() : "");
                sb5.append(": notifyBidWin: ");
                sb5.append(map.toString());
                sb5.toString();
            }
            gDTATNativeExpressAd.b.sendWinNotification(map);
            return;
        }
        if (this.a instanceof GDTATNativePatchAd) {
            GDTATNativePatchAd gDTATNativePatchAd = (GDTATNativePatchAd) this.a;
            map.put(IBidding.EXPECT_COST_PRICE, Integer.valueOf(gDTATNativePatchAd.f12446c.getECPM()));
            if (ATSDK.isNetworkLogDebug()) {
                StringBuilder sb6 = new StringBuilder();
                sb6.append(this.a != null ? this.a.toString() : "");
                sb6.append(": notifyBidWin: ");
                sb6.append(map.toString());
                sb6.toString();
            }
            gDTATNativePatchAd.f12446c.sendWinNotification(map);
            return;
        }
        if (this.a instanceof GDTATNativeAd) {
            GDTATNativeAd gDTATNativeAd = (GDTATNativeAd) this.a;
            map.put(IBidding.EXPECT_COST_PRICE, Integer.valueOf(gDTATNativeAd.f12446c.getECPM()));
            if (ATSDK.isNetworkLogDebug()) {
                StringBuilder sb7 = new StringBuilder();
                sb7.append(this.a != null ? this.a.toString() : "");
                sb7.append(": notifyBidWin: ");
                sb7.append(map.toString());
                sb7.toString();
            }
            gDTATNativeAd.f12446c.sendWinNotification(map);
            return;
        }
        this.a = null;
    }
}
