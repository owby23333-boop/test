package com.kwad.components.ad.splashscreen;

import android.text.TextUtils;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdMatrixInfo;
import com.kwad.sdk.core.response.model.AdTemplate;

/* JADX INFO: loaded from: classes3.dex */
public final class d {
    public static int BU;
    private String BV;
    private int BW = 2;
    private String title;

    private void X(String str) {
        this.BV = str;
    }

    private void Z(int i2) {
        this.BW = i2;
    }

    public static d a(AdTemplate adTemplate, AdInfo adInfo, com.kwad.components.core.d.b.c cVar, int i2) {
        String strA;
        d dVar = new d();
        BU = i2;
        if (adInfo != null && cVar != null) {
            if (i2 == 1) {
                dVar.setTitle(com.kwad.sdk.core.response.a.b.cK(adInfo));
            } else {
                if (i2 != 4) {
                    if (com.kwad.sdk.core.response.a.a.ay(adInfo)) {
                        strA = "或点击" + a(adTemplate, adInfo, cVar.nw());
                    } else {
                        String strKW = com.kwad.components.ad.splashscreen.a.b.kW();
                        if (TextUtils.isEmpty(strKW)) {
                            strKW = "点击跳转详情页或第三方应用";
                        }
                        strA = "或" + strKW;
                    }
                }
                dVar.X(strA);
            }
            strA = a(adInfo, cVar);
            dVar.X(strA);
        }
        dVar.Z(com.kwad.sdk.core.response.a.b.cS(adInfo));
        return dVar;
    }

    public static String a(AdInfo adInfo, int i2) {
        AdMatrixInfo.DownloadTexts downloadTextsB = b(adInfo, BU);
        return i2 != 8 ? i2 != 12 ? downloadTextsB.adActionDescription : downloadTextsB.openAppLabel : downloadTextsB.installAppLabel;
    }

    private static String a(AdInfo adInfo, com.kwad.components.core.d.b.c cVar) {
        if (!com.kwad.sdk.core.response.a.a.ay(adInfo)) {
            String strD = d(adInfo, BU);
            return TextUtils.isEmpty(strD) ? "点击跳转详情页或第三方应用" : strD;
        }
        int iNw = cVar.nw();
        AdMatrixInfo.DownloadTexts downloadTextsB = b(adInfo, BU);
        return iNw != 8 ? iNw != 12 ? downloadTextsB.adActionDescription : downloadTextsB.openAppLabel : downloadTextsB.installAppLabel;
    }

    public static String a(AdTemplate adTemplate, AdInfo adInfo, int i2) {
        return i2 != 8 ? i2 != 12 ? com.kwad.sdk.core.response.a.a.ax(adInfo) : com.kwad.sdk.core.response.a.a.U(adInfo) : com.kwad.sdk.core.response.a.a.aI(adTemplate);
    }

    private static AdMatrixInfo.DownloadTexts b(AdInfo adInfo, int i2) {
        if (i2 == 1) {
            return com.kwad.sdk.core.response.a.b.cI(adInfo) != null ? com.kwad.sdk.core.response.a.b.cI(adInfo) : new AdMatrixInfo.DownloadTexts();
        }
        if (i2 == 4 && com.kwad.sdk.core.response.a.b.cM(adInfo) != null) {
            return com.kwad.sdk.core.response.a.b.cM(adInfo);
        }
        return new AdMatrixInfo.DownloadTexts();
    }

    public static String c(AdInfo adInfo, int i2) {
        AdMatrixInfo.DownloadTexts downloadTextsCJ = com.kwad.sdk.core.response.a.b.cJ(adInfo) != null ? com.kwad.sdk.core.response.a.b.cJ(adInfo) : new AdMatrixInfo.DownloadTexts();
        return i2 != 8 ? i2 != 12 ? downloadTextsCJ.adActionDescription : downloadTextsCJ.openAppLabel : downloadTextsCJ.installAppLabel;
    }

    private static String d(AdInfo adInfo, int i2) {
        return i2 == 1 ? com.kwad.sdk.core.response.a.b.cL(adInfo) != null ? com.kwad.sdk.core.response.a.b.cL(adInfo) : "" : (i2 != 4 || com.kwad.sdk.core.response.a.b.cN(adInfo) == null) ? "" : com.kwad.sdk.core.response.a.b.cN(adInfo);
    }

    private void setTitle(String str) {
        this.title = str;
    }

    public final String getTitle() {
        return this.title;
    }

    public final String kI() {
        return this.BV;
    }

    public final int kJ() {
        return this.BW;
    }
}
