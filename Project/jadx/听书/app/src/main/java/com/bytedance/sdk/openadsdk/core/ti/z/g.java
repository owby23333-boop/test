package com.bytedance.sdk.openadsdk.core.ti.z;

import com.bytedance.sdk.openadsdk.mediation.MediationConstant;

/* JADX INFO: loaded from: classes2.dex */
public class g {
    private static Boolean z;

    private static boolean z() {
        if (z == null) {
            try {
                Class.forName("com.bytedance.sdk.openadsdk.mediation.MediationConstant$BiddingLossReason");
                z = Boolean.TRUE;
            } catch (Throwable unused) {
                z = Boolean.FALSE;
            }
        }
        return z.booleanValue();
    }

    public static Object z(int i) {
        if (!z()) {
            return Integer.valueOf(i);
        }
        try {
            if (i == 1) {
                return MediationConstant.BiddingLossReason.LOW_PRICE;
            }
            if (i == 2) {
                return MediationConstant.BiddingLossReason.TIME_OUT;
            }
            if (i == 3) {
                return MediationConstant.BiddingLossReason.NO_AD;
            }
            if (i == 4) {
                return MediationConstant.BiddingLossReason.AD_DATA_ERROR;
            }
            if (i != 10001) {
                return null;
            }
            return MediationConstant.BiddingLossReason.OTHER;
        } catch (Throwable unused) {
            return null;
        }
    }
}
