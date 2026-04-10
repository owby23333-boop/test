package com.kwad.components.ad.splashscreen.c;

import android.os.Bundle;
import android.view.ViewGroup;
import com.kwad.components.core.c.f;
import com.kwad.components.core.proxy.h;
import com.kwad.sdk.api.KsSplashScreenAd;
import com.kwad.sdk.core.response.b.c;
import com.kwad.sdk.core.response.model.AdResultData;
import com.kwad.sdk.core.response.model.AdTemplate;

/* JADX INFO: loaded from: classes3.dex */
public final class b extends h {
    private KsSplashScreenAd.SplashScreenAdInteractionListener Fe;
    private com.kwad.sdk.core.j.b dn;
    private AdResultData mAdResultData;
    private AdTemplate mAdTemplate;

    public static b b(AdResultData adResultData, com.kwad.sdk.core.j.b bVar, KsSplashScreenAd.SplashScreenAdInteractionListener splashScreenAdInteractionListener) {
        Bundle bundle = new Bundle();
        bundle.putInt("ad_result_cache_idx", f.ol().l(adResultData));
        b bVar2 = new b();
        bVar2.setArguments(bundle);
        bVar2.a(bVar);
        bVar2.setSplashScreenAdListener(splashScreenAdInteractionListener);
        return bVar2;
    }

    private void setSplashScreenAdListener(KsSplashScreenAd.SplashScreenAdInteractionListener splashScreenAdInteractionListener) {
        this.Fe = splashScreenAdInteractionListener;
    }

    private void a(com.kwad.sdk.core.j.b bVar) {
        this.dn = bVar;
    }

    private void initData() {
        int i = getArguments().getInt("ad_result_cache_idx");
        if (i > 0) {
            AdResultData adResultDataD = f.ol().d(i, true);
            this.mAdResultData = adResultDataD;
            this.mAdTemplate = c.r(adResultDataD);
        }
    }

    @Override // com.kwad.components.core.proxy.h
    public final ViewGroup nj() {
        initData();
        if (this.mAdTemplate == null) {
            com.kwad.components.ad.splashscreen.monitor.b.lZ();
            com.kwad.components.ad.splashscreen.monitor.b.a((AdTemplate) null, "adTemplate null", false);
            KsSplashScreenAd.SplashScreenAdInteractionListener splashScreenAdInteractionListener = this.Fe;
            if (splashScreenAdInteractionListener != null) {
                splashScreenAdInteractionListener.onAdShowError(0, "data parse error");
            }
            return null;
        }
        return com.kwad.components.ad.splashscreen.c.a(this.mContext, this.mAdResultData, false, this.dn, this.Fe);
    }
}
