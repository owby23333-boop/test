package com.anythink.network.ks;

import android.text.TextUtils;
import com.anythink.core.api.ATAdConst;
import com.anythink.core.api.ATBiddingNotice;
import com.anythink.core.api.ATSDK;
import com.kwad.sdk.api.KsDrawAd;
import com.kwad.sdk.api.KsFeedAd;
import com.kwad.sdk.api.KsFullScreenVideoAd;
import com.kwad.sdk.api.KsInterstitialAd;
import com.kwad.sdk.api.KsNativeAd;
import com.kwad.sdk.api.KsRewardVideoAd;
import com.kwad.sdk.api.KsSplashScreenAd;
import com.kwad.sdk.api.model.AdExposureFailedReason;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public class KSATBiddingNotice implements ATBiddingNotice {
    Object a;

    protected KSATBiddingNotice(Object obj) {
        this.a = obj;
    }

    @Override // com.anythink.core.api.ATBiddingNotice
    public ATAdConst.CURRENCY getNoticePriceCurrency() {
        return ATAdConst.CURRENCY.RMB_CENT;
    }

    @Override // com.anythink.core.api.ATBiddingNotice
    public void notifyBidDisplay(boolean z2, double d2) {
    }

    @Override // com.anythink.core.api.ATBiddingNotice
    public synchronized void notifyBidLoss(String str, double d2, Map<String, Object> map) {
        if (ATSDK.isNetworkLogDebug()) {
            StringBuilder sb = new StringBuilder();
            sb.append(this.a != null ? this.a.getClass().getSimpleName() : "");
            sb.append(": notifyBidLoss lossCode:");
            sb.append(str);
            sb.append(",winPrice:");
            sb.append(d2);
            sb.toString();
        }
        AdExposureFailedReason adExposureFailedReason = new AdExposureFailedReason();
        adExposureFailedReason.winEcpm = (int) d2;
        int i2 = TextUtils.equals(str, "5") ? 3 : 4;
        try {
            if (this.a instanceof KsRewardVideoAd) {
                ((KsRewardVideoAd) this.a).reportAdExposureFailed(i2, adExposureFailedReason);
                return;
            }
        } catch (Throwable unused) {
        }
        try {
            if (this.a instanceof KsInterstitialAd) {
                ((KsInterstitialAd) this.a).reportAdExposureFailed(i2, adExposureFailedReason);
                return;
            }
        } catch (Throwable unused2) {
        }
        try {
            if (this.a instanceof KsFullScreenVideoAd) {
                ((KsFullScreenVideoAd) this.a).reportAdExposureFailed(i2, adExposureFailedReason);
                return;
            }
        } catch (Throwable unused3) {
        }
        try {
            if (this.a instanceof KsDrawAd) {
                ((KsDrawAd) this.a).reportAdExposureFailed(i2, adExposureFailedReason);
                return;
            }
        } catch (Throwable unused4) {
        }
        try {
            if (this.a instanceof KsFeedAd) {
                ((KsFeedAd) this.a).reportAdExposureFailed(i2, adExposureFailedReason);
                return;
            }
        } catch (Throwable unused5) {
        }
        try {
            if (this.a instanceof KsNativeAd) {
                ((KsNativeAd) this.a).reportAdExposureFailed(i2, adExposureFailedReason);
                return;
            }
        } catch (Throwable unused6) {
        }
        this.a = null;
    }

    @Override // com.anythink.core.api.ATBiddingNotice
    public synchronized void notifyBidWin(double d2) {
        double d3 = d2 * 100.0d;
        if (ATSDK.isNetworkLogDebug()) {
            StringBuilder sb = new StringBuilder();
            sb.append(this.a != null ? this.a.getClass().getSimpleName() : "");
            sb.append(": notifyBidWin : second price:");
            sb.append(d3);
            sb.toString();
        }
        try {
            if (this.a instanceof KsRewardVideoAd) {
                if (ATSDK.isNetworkLogDebug()) {
                    String str = "Origin price:" + ((KsRewardVideoAd) this.a).getECPM();
                }
                ((KsRewardVideoAd) this.a).setBidEcpm((int) d3);
                return;
            }
        } catch (Throwable unused) {
        }
        try {
            if (this.a instanceof KsInterstitialAd) {
                if (ATSDK.isNetworkLogDebug()) {
                    String str2 = "Origin price:" + ((KsInterstitialAd) this.a).getECPM();
                }
                ((KsInterstitialAd) this.a).setBidEcpm((int) d3);
                return;
            }
        } catch (Throwable unused2) {
        }
        try {
            if (this.a instanceof KsFullScreenVideoAd) {
                if (ATSDK.isNetworkLogDebug()) {
                    String str3 = "Origin price:" + ((KsFullScreenVideoAd) this.a).getECPM();
                }
                ((KsFullScreenVideoAd) this.a).setBidEcpm((int) d3);
                return;
            }
        } catch (Throwable unused3) {
        }
        try {
            if (this.a instanceof KsDrawAd) {
                if (ATSDK.isNetworkLogDebug()) {
                    String str4 = "Origin price:" + ((KsDrawAd) this.a).getECPM();
                }
                ((KsDrawAd) this.a).setBidEcpm((int) d3);
                return;
            }
        } catch (Throwable unused4) {
        }
        try {
            if (this.a instanceof KsFeedAd) {
                if (ATSDK.isNetworkLogDebug()) {
                    String str5 = "Origin price:" + ((KsFeedAd) this.a).getECPM();
                }
                ((KsFeedAd) this.a).setBidEcpm((int) d3);
                return;
            }
        } catch (Throwable unused5) {
        }
        try {
            if (this.a instanceof KsNativeAd) {
                if (ATSDK.isNetworkLogDebug()) {
                    String str6 = "Origin price:" + ((KsNativeAd) this.a).getECPM();
                }
                ((KsNativeAd) this.a).setBidEcpm((int) d3);
                return;
            }
        } catch (Throwable unused6) {
        }
        try {
            if (this.a instanceof KsSplashScreenAd) {
                if (ATSDK.isNetworkLogDebug()) {
                    String str7 = "Origin price:" + ((KsSplashScreenAd) this.a).getECPM();
                }
                ((KsSplashScreenAd) this.a).setBidEcpm((int) d3);
                return;
            }
        } catch (Throwable unused7) {
        }
        this.a = null;
    }
}
