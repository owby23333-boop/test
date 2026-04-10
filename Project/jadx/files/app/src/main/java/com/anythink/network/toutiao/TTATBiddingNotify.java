package com.anythink.network.toutiao;

import com.anythink.core.api.ATAdConst;
import com.anythink.core.api.ATBiddingNotice;
import com.anythink.core.api.ATSDK;
import com.bytedance.sdk.openadsdk.TTClientBidding;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public class TTATBiddingNotify implements ATBiddingNotice {
    TTClientBidding a;

    protected TTATBiddingNotify(TTClientBidding tTClientBidding) {
        this.a = tTClientBidding;
    }

    @Override // com.anythink.core.api.ATBiddingNotice
    public ATAdConst.CURRENCY getNoticePriceCurrency() {
        return ATAdConst.CURRENCY.RMB_CENT;
    }

    @Override // com.anythink.core.api.ATBiddingNotice
    public void notifyBidDisplay(boolean z2, double d2) {
        if (ATSDK.isNetworkLogDebug()) {
            String str = "notifyBidDisplay :  price:" + d2 + ",isWinner:" + z2;
        }
        try {
            this.a.setPrice(Double.valueOf(d2));
        } catch (Throwable unused) {
        }
        this.a = null;
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    @Override // com.anythink.core.api.ATBiddingNotice
    public void notifyBidLoss(String str, double d2, Map<String, Object> map) {
        if (ATSDK.isNetworkLogDebug()) {
            String str2 = "notifyBidLoss :  price:" + d2 + ",lossCode:" + str;
        }
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
        String str3 = "201";
        if (b == 0) {
            str3 = "2";
        } else if (b == 1 || b == 2) {
            str3 = ATAdConst.BIDDING_TYPE.BIDDING_LOSS_WITH_LOW_PRICE_IN_HB;
        }
        try {
            this.a.loss(Double.valueOf(d2), str3, null);
        } catch (Throwable unused) {
        }
        this.a = null;
    }

    @Override // com.anythink.core.api.ATBiddingNotice
    public void notifyBidWin(double d2) {
        if (ATSDK.isNetworkLogDebug()) {
            "notifyBidWin : second price:".concat(String.valueOf(d2));
        }
        try {
            this.a.win(Double.valueOf(d2));
        } catch (Throwable unused) {
        }
    }
}
