package com.kwad.sdk.commercial.d;

import com.kwad.components.offline.api.core.api.ILoggerReporter;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.service.ServiceProvider;

/* JADX INFO: loaded from: classes4.dex */
public final class c {
    private static void a(AdTemplate adTemplate, com.kwad.sdk.commercial.c.a aVar) {
        aVar.setAdTemplate(adTemplate);
        com.kwad.sdk.commercial.b.d(com.kwad.sdk.commercial.c.DS().cF(ILoggerReporter.Category.APM_LOG).i(0.001d).b(com.kwad.sdk.commercial.d.be(adTemplate)).O("ad_convert_method_call", "method_name").z(aVar));
    }

    public static void bK(AdTemplate adTemplate) {
        try {
            a(adTemplate, b.DV().cJ("callShow"));
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }

    public static void bL(AdTemplate adTemplate) {
        try {
            a(adTemplate, b.DV().cJ("adShowSuccess"));
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }
}
