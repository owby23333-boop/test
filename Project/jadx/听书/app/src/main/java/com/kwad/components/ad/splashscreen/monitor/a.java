package com.kwad.components.ad.splashscreen.monitor;

import com.kwad.components.offline.api.core.api.ILoggerReporter;
import com.kwad.sdk.core.response.b.e;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.l;
import com.kwai.adclient.kscommerciallogger.model.BusinessType;

/* JADX INFO: loaded from: classes3.dex */
public final class a {

    /* JADX INFO: renamed from: com.kwad.components.ad.splashscreen.monitor.a$a, reason: collision with other inner class name */
    static class C0309a {
        private static final a FS = new a();
    }

    public static a lX() {
        return C0309a.FS;
    }

    private static void d(com.kwad.sdk.commercial.c.a aVar) {
        if (l.Cf().Bn()) {
            com.kwad.sdk.commercial.b.d(com.kwad.sdk.commercial.c.DS().cF(ILoggerReporter.Category.APM_LOG).i(0.01d).O("ad_sdk_splash_callback", "callback_type").b(BusinessType.AD_SPLASH).z(aVar).a(com.kwai.adclient.kscommerciallogger.model.a.bez));
        }
    }

    private static void e(com.kwad.sdk.commercial.c.a aVar) {
        if (l.Cf().Bn()) {
            com.kwad.sdk.commercial.b.d(com.kwad.sdk.commercial.c.DS().cF(ILoggerReporter.Category.APM_LOG).i(0.01d).O("ad_sdk_splash_action", "action_type").b(BusinessType.AD_SPLASH).z(aVar).a(com.kwai.adclient.kscommerciallogger.model.a.bez));
        }
    }

    private static SplashMonitorInfo ad(AdTemplate adTemplate) {
        AdInfo adInfoEl = e.el(adTemplate);
        return new SplashMonitorInfo().setPreloadId(com.kwad.sdk.core.response.b.a.aZ(adInfoEl)).setCreativeId(com.kwad.sdk.core.response.b.a.J(adInfoEl)).setMaterialType(com.kwad.sdk.core.response.b.a.bc(adInfoEl) ? 1 : 2).setAdTemplate(adTemplate);
    }

    public final void v(AdTemplate adTemplate) {
        d(ad(adTemplate).setCallbackType(1));
    }

    public final void ae(AdTemplate adTemplate) {
        d(ad(adTemplate).setCallbackType(2));
    }

    public final void w(AdTemplate adTemplate) {
        d(ad(adTemplate).setCallbackType(3));
    }

    public final void t(long j) {
        d(new SplashMonitorInfo().setCallbackType(4).setPosId(j));
    }

    public final void af(AdTemplate adTemplate) {
        d(ad(adTemplate).setCallbackType(5));
    }

    public final void ag(AdTemplate adTemplate) {
        e(ad(adTemplate).setActionType(1));
    }

    public final void ah(AdTemplate adTemplate) {
        e(ad(adTemplate).setActionType(2));
    }
}
