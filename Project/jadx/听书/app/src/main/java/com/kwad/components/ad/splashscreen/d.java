package com.kwad.components.ad.splashscreen;

import android.text.TextUtils;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;

/* JADX INFO: loaded from: classes3.dex */
public final class d {
    public static int Fi;
    private String Fj;
    private int Fk = 2;

    public static d a(AdTemplate adTemplate, AdInfo adInfo, com.kwad.components.core.e.d.c cVar, int i) {
        d dVar = new d();
        Fi = i;
        if (adInfo != null && cVar != null) {
            if (i == 1 || i == 4) {
                dVar.Z(a(adTemplate, adInfo, cVar));
            } else if (i == 10) {
                if (com.kwad.sdk.core.response.b.a.aF(adInfo)) {
                    int iPB = cVar.pB();
                    if (iPB == 2) {
                        dVar.Z(a(adTemplate, adInfo, iPB, 0));
                    } else {
                        dVar.Z("扭动或点击" + a(adTemplate, adInfo, iPB, 0));
                    }
                } else {
                    try {
                        String strDH = com.kwad.sdk.core.response.b.b.dH(adInfo);
                        if (!TextUtils.isEmpty(strDH)) {
                            dVar.Z("扭动或点击" + strDH);
                        } else {
                            dVar.Z("或点击跳转详情页或第三方应用");
                        }
                    } catch (Exception unused) {
                        dVar.Z("或点击跳转详情页或第三方应用");
                    }
                }
            } else if (com.kwad.sdk.core.response.b.a.aF(adInfo)) {
                dVar.Z("或点击" + a(adTemplate, adInfo, cVar.pB(), 0));
            } else {
                String strA = com.kwad.sdk.core.config.e.a(com.kwad.components.ad.splashscreen.b.a.FO);
                if (TextUtils.isEmpty(strA)) {
                    strA = "点击跳转详情页或第三方应用";
                }
                dVar.Z("或" + strA);
            }
        }
        dVar.aj(com.kwad.sdk.core.response.b.b.dK(adInfo));
        return dVar;
    }

    public static String a(AdTemplate adTemplate, AdInfo adInfo, int i, int i2) {
        String strAE = com.kwad.sdk.core.response.b.a.aE(adInfo);
        if (i == 2) {
            return i2 + "%";
        }
        if (i == 4) {
            return "继续下载";
        }
        if (i != 8) {
            return i != 12 ? strAE : com.kwad.sdk.core.response.b.a.ac(adInfo);
        }
        return com.kwad.sdk.core.response.b.a.cl(adTemplate);
    }

    private static String a(AdInfo adInfo, int i) {
        return i == 1 ? com.kwad.sdk.core.response.b.b.dH(adInfo) != null ? com.kwad.sdk.core.response.b.b.dH(adInfo) : "" : (i != 4 || com.kwad.sdk.core.response.b.b.dI(adInfo) == null) ? "" : com.kwad.sdk.core.response.b.b.dI(adInfo);
    }

    private static String a(AdTemplate adTemplate, AdInfo adInfo, com.kwad.components.core.e.d.c cVar) {
        if (com.kwad.sdk.core.response.b.a.aF(adInfo)) {
            return a(adTemplate, adInfo, cVar.pB(), 0);
        }
        String strA = a(adInfo, Fi);
        return TextUtils.isEmpty(strA) ? "点击跳转详情页或第三方应用" : strA;
    }

    public final String lA() {
        return this.Fj;
    }

    private void Z(String str) {
        this.Fj = str;
    }

    public final int lB() {
        return this.Fk;
    }

    private void aj(int i) {
        this.Fk = i;
    }
}
