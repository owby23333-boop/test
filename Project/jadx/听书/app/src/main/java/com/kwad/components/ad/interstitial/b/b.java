package com.kwad.components.ad.interstitial.b;

import com.kwad.sdk.core.response.model.AdInfo;

/* JADX INFO: loaded from: classes3.dex */
public final class b {
    public static boolean dH() {
        return a.lS.getValue().booleanValue();
    }

    public static boolean dI() {
        return a.lM.getValue().intValue() == 1;
    }

    public static int dJ() {
        return a.lN.getValue().intValue();
    }

    public static boolean dK() {
        return a.lO.getValue().intValue() == 1;
    }

    public static boolean dL() {
        return a.lP.getValue().intValue() == 1;
    }

    public static int b(AdInfo adInfo) {
        int iL;
        int iIntValue = a.lQ.getValue().intValue();
        if (com.kwad.sdk.core.response.b.a.bc(adInfo)) {
            iL = com.kwad.sdk.core.response.b.a.L(adInfo);
            if (iIntValue != 0) {
                return Math.min(iIntValue, iL);
            }
        } else {
            iL = 60;
            if (iIntValue <= 60 && iIntValue > 0) {
                return iIntValue;
            }
        }
        return iL;
    }

    public static boolean dM() {
        return a.lR.getValue().intValue() == 1;
    }

    public static boolean dN() {
        return a.lT.getValue().intValue() == 1;
    }
}
