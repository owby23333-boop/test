package com.kwad.components.ad.interstitial;

import com.kwad.sdk.api.KsInterstitialAd;
import com.kwad.sdk.core.response.model.AdResultData;

/* JADX INFO: loaded from: classes3.dex */
public final class e {
    public static KsInterstitialAd f(AdResultData adResultData) {
        int iED = com.kwad.sdk.core.response.b.e.eD(com.kwad.sdk.core.response.b.c.r(adResultData));
        if (iED == 1) {
            return new com.kwad.components.ad.interstitial.e.a(true, adResultData);
        }
        if (iED == 2) {
            return new com.kwad.components.ad.interstitial.e.a(false, adResultData);
        }
        return new b(adResultData);
    }
}
