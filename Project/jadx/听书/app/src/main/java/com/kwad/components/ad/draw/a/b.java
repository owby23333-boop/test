package com.kwad.components.ad.draw.a;

import androidx.core.app.NotificationCompat;
import com.kwad.components.offline.api.core.api.ILoggerReporter;
import com.kwad.sdk.core.response.b.e;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.service.ServiceProvider;
import com.kwai.adclient.kscommerciallogger.model.BusinessType;

/* JADX INFO: loaded from: classes3.dex */
public final class b {
    public static void g(AdTemplate adTemplate) {
        AdInfo adInfoEl = e.el(adTemplate);
        a(d.aN().y(1).z(com.kwad.sdk.core.response.b.a.be(adInfoEl)).q(com.kwad.sdk.core.response.b.a.bb(adInfoEl)).setAdTemplate(adTemplate), false);
    }

    public static void a(AdTemplate adTemplate, long j) {
        AdInfo adInfoEl = e.el(adTemplate);
        a(d.aN().y(2).z(com.kwad.sdk.core.response.b.a.be(adInfoEl)).q(com.kwad.sdk.core.response.b.a.bb(adInfoEl)).h(j).setAdTemplate(adTemplate), false);
    }

    public static void a(AdTemplate adTemplate, long j, String str) {
        AdInfo adInfoEl = e.el(adTemplate);
        a(d.aN().y(3).z(com.kwad.sdk.core.response.b.a.be(adInfoEl)).q(com.kwad.sdk.core.response.b.a.bb(adInfoEl)).h(j).setAdTemplate(adTemplate).setErrorMsg(str), true);
    }

    private static void a(com.kwad.sdk.commercial.c.a aVar, boolean z) {
        try {
            com.kwad.sdk.commercial.b.d(com.kwad.sdk.commercial.c.DS().cF(z ? ILoggerReporter.Category.ERROR_LOG : ILoggerReporter.Category.APM_LOG).i(z ? 1.0d : 0.001d).b(BusinessType.AD_DRAW).O("ad_sdk_draw_material_load", NotificationCompat.CATEGORY_STATUS).z(aVar));
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }
}
