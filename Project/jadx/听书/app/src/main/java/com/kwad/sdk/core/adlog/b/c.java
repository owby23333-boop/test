package com.kwad.sdk.core.adlog.b;

import androidx.core.app.NotificationCompat;
import com.kwad.components.offline.api.core.api.ILoggerReporter;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.service.ServiceProvider;

/* JADX INFO: loaded from: classes4.dex */
public final class c {
    private static void a(AdTemplate adTemplate, com.kwad.sdk.core.adlog.a.a aVar, d dVar) {
        a(adTemplate, aVar, false, dVar);
    }

    private static void a(AdTemplate adTemplate, com.kwad.sdk.core.adlog.a.a aVar, boolean z, d dVar) {
        if (aVar != null) {
            dVar.cT(1).cU(aVar.retryCount);
        }
        com.kwad.sdk.commercial.b.d(com.kwad.sdk.commercial.c.DS().cF(z ? ILoggerReporter.Category.ERROR_LOG : ILoggerReporter.Category.APM_LOG).i(z ? 0.01d : 1.0E-4d).j(z ? 1.0d : 0.01d).b(com.kwad.sdk.commercial.d.be(adTemplate)).O("ad_sdk_adlog_performance", NotificationCompat.CATEGORY_STATUS).z(dVar));
    }

    public static void a(AdTemplate adTemplate, int i, com.kwad.sdk.core.adlog.a.a aVar) {
        try {
            a(adTemplate, aVar, d.EJ().cR(1).cS(i).setAdTemplate(adTemplate));
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }

    public static void b(AdTemplate adTemplate, int i, com.kwad.sdk.core.adlog.a.a aVar) {
        try {
            a(adTemplate, aVar, d.EJ().cR(2).cS(i).setAdTemplate(adTemplate));
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }

    public static void a(AdTemplate adTemplate, int i, String str, int i2, String str2, com.kwad.sdk.core.adlog.a.a aVar) {
        try {
            a(adTemplate, aVar, d.EJ().cR(5).cS(i).dp(str).setErrorCode(100004).setErrorMsg(str2).setAdTemplate(adTemplate));
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }

    public static void b(AdTemplate adTemplate, int i, String str, int i2, String str2, com.kwad.sdk.core.adlog.a.a aVar) {
        try {
            a(adTemplate, aVar, true, d.EJ().cR(5).cS(i).dp(str).setErrorCode(i2).setErrorMsg(str2).setAdTemplate(adTemplate));
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }

    public static void c(AdTemplate adTemplate, int i, String str, int i2, String str2, com.kwad.sdk.core.adlog.a.a aVar) {
        try {
            a(adTemplate, aVar, true, d.EJ().cR(4).cS(i).dp(str).setErrorCode(i2).setErrorMsg(str2).setAdTemplate(adTemplate));
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }

    public static void d(AdTemplate adTemplate, int i, String str, int i2, String str2, com.kwad.sdk.core.adlog.a.a aVar) {
        try {
            a(adTemplate, aVar, true, d.EJ().cR(3).cS(i).dp(str).setErrorCode(i2).setErrorMsg(str2).setAdTemplate(adTemplate));
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }
}
