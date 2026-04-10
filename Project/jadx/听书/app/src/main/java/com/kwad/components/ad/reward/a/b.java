package com.kwad.components.ad.reward.a;

import com.kwad.sdk.core.response.model.AdInfo;

/* JADX INFO: loaded from: classes3.dex */
public final class b {
    public static int hz() {
        return a.tr.getValue().intValue();
    }

    public static String hA() {
        return a.tv.getValue();
    }

    public static int hB() {
        return a.ts.getValue().intValue();
    }

    public static boolean hC() {
        return a.tu.getValue().booleanValue();
    }

    public static int hD() {
        return a.tt.getValue().intValue();
    }

    private static boolean hE() {
        return a.tx.getValue().intValue() == 1;
    }

    public static boolean i(AdInfo adInfo) {
        return !j(adInfo) && com.kwad.sdk.core.response.b.a.cP(adInfo) && hE();
    }

    public static boolean j(AdInfo adInfo) {
        return com.kwad.sdk.core.response.b.a.cP(adInfo) && a.tz.getValue().intValue() == 1;
    }

    public static boolean k(AdInfo adInfo) {
        return i(adInfo);
    }

    public static float hF() {
        return a.tC.getValue().floatValue();
    }

    public static boolean hG() {
        return a.tC.getValue().floatValue() > 0.0f && a.tC.getValue().floatValue() < 1.0f;
    }

    public static boolean hH() {
        return a.tD.getValue().booleanValue();
    }

    public static long hI() {
        return a.tA.getValue().intValue();
    }

    public static int hJ() {
        return a.tB.getValue().intValue();
    }

    public static int hK() {
        return a.tE.getValue().intValue();
    }

    public static boolean hL() {
        return a.tF.getValue().booleanValue();
    }

    public static boolean hM() {
        return a.tG.getValue().intValue() == 1 || a.tG.getValue().intValue() == 3;
    }

    public static boolean hN() {
        return a.tH.getValue().booleanValue();
    }

    public static boolean hO() {
        return a.tI.getValue().booleanValue();
    }
}
