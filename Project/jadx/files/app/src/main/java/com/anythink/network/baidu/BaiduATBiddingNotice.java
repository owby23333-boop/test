package com.anythink.network.baidu;

import com.anythink.core.api.ATAdConst;
import com.anythink.core.api.ATBiddingNotice;
import com.anythink.core.api.ATSDK;
import com.baidu.mobads.sdk.api.ExpressInterstitialAd;
import com.baidu.mobads.sdk.api.ExpressResponse;
import com.baidu.mobads.sdk.api.FullScreenVideoAd;
import com.baidu.mobads.sdk.api.NativeResponse;
import com.baidu.mobads.sdk.api.RewardVideoAd;
import com.baidu.mobads.sdk.api.SplashAd;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public class BaiduATBiddingNotice implements ATBiddingNotice {
    Object a;

    protected BaiduATBiddingNotice(Object obj) {
        this.a = obj;
    }

    @Override // com.anythink.core.api.ATBiddingNotice
    public ATAdConst.CURRENCY getNoticePriceCurrency() {
        return ATAdConst.CURRENCY.RMB_CENT;
    }

    @Override // com.anythink.core.api.ATBiddingNotice
    public void notifyBidDisplay(boolean z2, double d2) {
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    @Override // com.anythink.core.api.ATBiddingNotice
    public synchronized void notifyBidLoss(String str, double d2, Map<String, Object> map) {
        byte b = -1;
        int iHashCode = str.hashCode();
        if (iHashCode != 50) {
            if (iHashCode != 53) {
                switch (iHashCode) {
                    case 48627:
                        if (str.equals(ATAdConst.BIDDING_TYPE.BIDDING_LOSS_WITH_LOW_PRICE_IN_HB)) {
                            b = 1;
                        }
                        break;
                    case 48628:
                        if (str.equals(ATAdConst.BIDDING_TYPE.BIDDING_LOSS_WITH_LOW_PRICE_IN_NORMAL)) {
                            b = 2;
                        }
                        break;
                }
            } else if (str.equals("5")) {
                b = 3;
            }
        } else if (str.equals("2")) {
            b = 0;
        }
        int i2 = 900;
        if (b == 0) {
            i2 = 100;
        } else if (b == 1 || b == 2) {
            i2 = 203;
        }
        if (ATSDK.isNetworkLogDebug()) {
            StringBuilder sb = new StringBuilder();
            sb.append(this.a != null ? this.a.toString() : "");
            sb.append(": notifyBidLoss lossCode:");
            sb.append(str);
            sb.append(",lossReaseon:");
            sb.append(i2);
            sb.toString();
        }
        try {
            if (this.a instanceof RewardVideoAd) {
                ((RewardVideoAd) this.a).biddingFail(String.valueOf(i2));
                return;
            }
        } catch (Throwable unused) {
        }
        try {
            if (this.a instanceof SplashAd) {
                ((SplashAd) this.a).biddingFail(String.valueOf(i2));
                return;
            }
        } catch (Throwable unused2) {
        }
        try {
            if (this.a instanceof NativeResponse) {
                ((NativeResponse) this.a).biddingFail(String.valueOf(i2));
                return;
            }
        } catch (Throwable unused3) {
        }
        try {
            if (this.a instanceof ExpressResponse) {
                ((ExpressResponse) this.a).biddingFail(String.valueOf(i2));
                return;
            }
        } catch (Throwable unused4) {
        }
        try {
            if (this.a instanceof ExpressInterstitialAd) {
                ((ExpressInterstitialAd) this.a).biddingFail(String.valueOf(i2));
                return;
            }
        } catch (Throwable unused5) {
        }
        try {
            if (this.a instanceof FullScreenVideoAd) {
                ((FullScreenVideoAd) this.a).biddingFail(String.valueOf(i2));
                return;
            }
        } catch (Throwable unused6) {
        }
        this.a = null;
    }

    @Override // com.anythink.core.api.ATBiddingNotice
    public synchronized void notifyBidWin(double d2) {
        if (ATSDK.isNetworkLogDebug()) {
            StringBuilder sb = new StringBuilder();
            sb.append(this.a != null ? this.a.toString() : "");
            sb.append(": notifyBidWin : second price:");
            sb.append(d2);
            sb.toString();
        }
        try {
            if (this.a instanceof RewardVideoAd) {
                ((RewardVideoAd) this.a).biddingSuccess(String.valueOf(d2));
                return;
            }
        } catch (Throwable unused) {
        }
        try {
            if (this.a instanceof SplashAd) {
                ((SplashAd) this.a).biddingSuccess(String.valueOf(d2));
                return;
            }
        } catch (Throwable unused2) {
        }
        try {
            if (this.a instanceof NativeResponse) {
                ((NativeResponse) this.a).biddingSuccess(String.valueOf(d2));
                return;
            }
        } catch (Throwable unused3) {
        }
        try {
            if (this.a instanceof ExpressResponse) {
                ((ExpressResponse) this.a).biddingSuccess(String.valueOf(d2));
                return;
            }
        } catch (Throwable unused4) {
        }
        try {
            if (this.a instanceof ExpressInterstitialAd) {
                ((ExpressInterstitialAd) this.a).biddingSuccess(String.valueOf(d2));
                return;
            }
        } catch (Throwable unused5) {
        }
        try {
            if (this.a instanceof FullScreenVideoAd) {
                ((FullScreenVideoAd) this.a).biddingSuccess(String.valueOf(d2));
                return;
            }
        } catch (Throwable unused6) {
        }
        this.a = null;
    }
}
