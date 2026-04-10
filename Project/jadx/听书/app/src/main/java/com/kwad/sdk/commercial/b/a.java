package com.kwad.sdk.commercial.b;

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
        com.kwad.sdk.commercial.b.d(c.DS().cF(ILoggerReporter.Category.APM_LOG).i(z ? 0.1d : 0.01d).b(d.be(adTemplate)).O("ad_sdk_appstore_performance", NotificationCompat.CATEGORY_STATUS).z(aVar));
    }

    public static void a(AdTemplate adTemplate, String str, int i, int i2) {
        try {
            a(adTemplate, "", str, i, i2, "marketUrl is empty");
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }

    public static void a(AdTemplate adTemplate, String str, String str2, int i, int i2) {
        try {
            a(adTemplate, b.DU().cy(1).cH(str).cI(str2).cA(i).cz(i2));
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }

    public static void b(AdTemplate adTemplate, String str, String str2, int i, int i2) {
        try {
            a(adTemplate, b.DU().cy(2).cH(str).cI(str2).cA(i).cz(i2));
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }

    public static void a(AdTemplate adTemplate, String str, String str2, int i, int i2, String str3) {
        try {
            a(adTemplate, true, b.DU().cy(4).cH(str).cI(str2).cA(i).cz(i2).setErrorCode(100006).setErrorMsg(str3));
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }
}
