package com.kwad.components.ad.interstitial.kwai;

import com.kwad.sdk.core.response.model.AdInfo;

/* JADX INFO: loaded from: classes2.dex */
public final class b {
    public static int b(AdInfo adInfo) {
        int iIntValue = a.ja.getValue().intValue();
        if (com.kwad.sdk.core.response.a.a.aV(adInfo)) {
            int iF = com.kwad.sdk.core.response.a.a.F(adInfo);
            return iIntValue == 0 ? iF : Math.min(iIntValue, iF);
        }
        if (iIntValue > 60 || iIntValue <= 0) {
            return 60;
        }
        return iIntValue;
    }

    public static boolean c(AdInfo adInfo) {
        return com.kwad.sdk.core.response.a.a.cm(adInfo) && a.jd.getValue().intValue() == 1;
    }

    public static boolean cH() {
        return a.jc.getValue().booleanValue();
    }

    public static boolean cI() {
        return a.iW.getValue().intValue() == 1;
    }

    public static int cJ() {
        return a.iX.getValue().intValue();
    }

    public static boolean cK() {
        return a.iY.getValue().intValue() == 1;
    }

    public static boolean cL() {
        return a.iZ.getValue().intValue() == 1;
    }

    public static int cM() {
        return a.je.getValue().intValue();
    }

    public static boolean cN() {
        return a.jb.getValue().intValue() == 1;
    }
}
