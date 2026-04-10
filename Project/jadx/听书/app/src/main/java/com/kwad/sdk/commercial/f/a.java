package com.kwad.sdk.commercial.f;

import androidx.core.app.NotificationCompat;
import com.kwad.components.offline.api.core.api.ILoggerReporter;
import com.kwad.sdk.commercial.c;
import com.kwad.sdk.commercial.d;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.service.ServiceProvider;

/* JADX INFO: loaded from: classes4.dex */
public final class a {
    private static void a(AdTemplate adTemplate, com.kwad.sdk.commercial.c.a aVar) {
        a(adTemplate, false, aVar);
    }

    private static void a(AdTemplate adTemplate, boolean z, com.kwad.sdk.commercial.c.a aVar) {
        aVar.setAdTemplate(adTemplate);
        com.kwad.sdk.commercial.b.d(c.DS().cF(ILoggerReporter.Category.APM_LOG).i(z ? 0.1d : 0.01d).b(d.be(adTemplate)).O("ad_sdk_deeplink_performance", NotificationCompat.CATEGORY_STATUS).z(aVar));
    }

    public static void f(AdTemplate adTemplate, String str) {
        try {
            a(adTemplate, b.DY().cC(1).cQ(str));
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }

    public static void g(AdTemplate adTemplate, String str) {
        try {
            a(adTemplate, b.DY().cC(2).cQ(str));
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }

    public static void h(AdTemplate adTemplate, String str) {
        try {
            a(adTemplate, b.DY().cC(3).cQ(str));
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }

    public static void i(AdTemplate adTemplate, String str) {
        try {
            a(adTemplate, b.DY().cC(4).cQ(str));
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }

    public static void j(AdTemplate adTemplate, String str) {
        try {
            a(adTemplate, b.DY().cC(5).cQ(str));
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }

    public static void d(AdTemplate adTemplate, String str, String str2) {
        try {
            a(adTemplate, true, b.DY().cC(6).cQ(str).setErrorCode(100007).setErrorMsg(str2));
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }
}
