package com.kwad.sdk.commercial.g;

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
        com.kwad.sdk.commercial.b.d(c.DS().cF(ILoggerReporter.Category.APM_LOG).i(z ? 0.1d : 0.01d).b(d.be(adTemplate)).O("ad_sdk_landing_page_performance", NotificationCompat.CATEGORY_STATUS).z(aVar));
    }

    public static void j(AdTemplate adTemplate, int i, String str) {
        try {
            a(adTemplate, b.DZ().cD(1).cR(str).cE(i));
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }

    public static void a(AdTemplate adTemplate, int i, String str, String str2) {
        try {
            a(adTemplate, true, b.DZ().cD(3).cR(str).cE(i).setErrorCode(100009).setErrorMsg(str2));
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }

    public static void k(AdTemplate adTemplate, int i, String str) {
        try {
            a(adTemplate, b.DZ().cD(2).cR(str).cE(i));
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }

    public static void l(AdTemplate adTemplate, int i, String str) {
        try {
            a(adTemplate, b.DZ().cD(4).cR(str).cE(i));
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }

    public static void m(AdTemplate adTemplate, int i, String str) {
        try {
            a(adTemplate, b.DZ().cD(5).cR(str).cE(i));
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }

    public static void a(AdTemplate adTemplate, int i, String str, int i2, String str2) {
        try {
            a(adTemplate, true, b.DZ().cD(6).cR(str).cE(i).setErrorCode(i2).setErrorMsg(str2));
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }
}
