package com.kwad.sdk.core.adlog.b;

import androidx.core.app.NotificationCompat;
import com.kwad.components.offline.api.core.api.ILoggerReporter;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.service.ServiceProvider;

/* JADX INFO: loaded from: classes4.dex */
public final class a {
    private static void a(com.kwad.sdk.core.adlog.a.a aVar, com.kwad.sdk.core.adlog.a.c cVar, b bVar) {
        a(aVar, cVar, false, bVar);
    }

    private static void a(com.kwad.sdk.core.adlog.a.a aVar, com.kwad.sdk.core.adlog.a.c cVar, boolean z, b bVar) {
        AdTemplate adTemplate = aVar.axr.adTemplate;
        bVar.cM(aVar.axr.awx).cN(aVar.retryCount).cO(aVar.axt).m612do(aVar.axu).cP(cVar.axC).bp(cVar.axD).setAdTemplate(adTemplate);
        com.kwad.sdk.commercial.b.d(com.kwad.sdk.commercial.c.DS().cF(ILoggerReporter.Category.APM_LOG).i(z ? 1.0d : 0.1d).b(com.kwad.sdk.commercial.d.be(adTemplate)).O("ad_sdk_adlog_retry", NotificationCompat.CATEGORY_STATUS).z(bVar));
    }

    public static void a(com.kwad.sdk.core.adlog.a.a aVar, com.kwad.sdk.core.adlog.a.c cVar, int i) {
        try {
            a(aVar, cVar, b.EI().cL(1).cQ(i));
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }

    public static void b(com.kwad.sdk.core.adlog.a.a aVar, com.kwad.sdk.core.adlog.a.c cVar, int i) {
        try {
            a(aVar, cVar, b.EI().cL(2).cQ(i));
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }

    public static void c(com.kwad.sdk.core.adlog.a.a aVar, com.kwad.sdk.core.adlog.a.c cVar, int i) {
        try {
            a(aVar, cVar, true, b.EI().cL(3).cQ(i));
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }

    public static void d(com.kwad.sdk.core.adlog.a.a aVar, com.kwad.sdk.core.adlog.a.c cVar, int i) {
        try {
            a(aVar, cVar, b.EI().cL(4).cQ(i));
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }

    public static void a(com.kwad.sdk.core.adlog.a.a aVar, com.kwad.sdk.core.adlog.a.c cVar, int i, long j) {
        try {
            a(aVar, cVar, b.EI().cL(5).cQ(i).at(j));
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }

    public static void b(com.kwad.sdk.core.adlog.a.a aVar, com.kwad.sdk.core.adlog.a.c cVar, int i, long j) {
        try {
            a(aVar, cVar, true, b.EI().cL(6).cQ(i).at(j));
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }

    public static void e(com.kwad.sdk.core.adlog.a.a aVar, com.kwad.sdk.core.adlog.a.c cVar, int i) {
        try {
            a(aVar, cVar, true, b.EI().cL(7).cQ(i));
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }
}
