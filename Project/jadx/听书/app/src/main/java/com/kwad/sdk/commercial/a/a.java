package com.kwad.sdk.commercial.a;

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
        try {
            com.kwad.sdk.commercial.b.d(c.DS().cF(z ? ILoggerReporter.Category.ERROR_LOG : ILoggerReporter.Category.APM_LOG).i(z ? 1.0d : 0.1d).b(d.be(adTemplate)).O("ad_sdk_download_performance", NotificationCompat.CATEGORY_STATUS).z(aVar));
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }

    public static void x(AdTemplate adTemplate) {
        a(adTemplate, b.DT().cv(1).setAdTemplate(adTemplate));
    }

    public static void k(AdTemplate adTemplate, long j) {
        a(adTemplate, b.DT().cv(2).ar(j).setAdTemplate(adTemplate));
    }

    public static void bg(AdTemplate adTemplate) {
        a(adTemplate, b.DT().cv(3).setAdTemplate(adTemplate));
    }

    public static void bh(AdTemplate adTemplate) {
        a(adTemplate, b.DT().cv(4).setAdTemplate(adTemplate));
    }

    public static void bi(AdTemplate adTemplate) {
        a(adTemplate, b.DT().cv(5).setAdTemplate(adTemplate));
    }

    public static void h(AdTemplate adTemplate, int i, String str) {
        a(adTemplate, true, b.DT().cv(6).setAdTemplate(adTemplate).setErrorCode(i).setErrorMsg(str));
    }

    public static void bj(AdTemplate adTemplate) {
        h(adTemplate, 100002, "");
    }

    public static void bk(AdTemplate adTemplate) {
        a(adTemplate, b.DT().cv(7).cw(adTemplate.mInstallApkFormUser ? 1 : 2).setAdTemplate(adTemplate));
    }

    public static void bl(AdTemplate adTemplate) {
        int i = 1;
        b bVarCw = b.DT().cv(8).cw(adTemplate.mInstallApkFormUser ? 1 : 2);
        if (!adTemplate.mInstallApkFromSDK) {
            i = adTemplate.mClickOpenAppStore ? 2 : 0;
        }
        a(adTemplate, bVarCw.cx(i).setAdTemplate(adTemplate));
    }

    public static void bm(AdTemplate adTemplate) {
        int i;
        b bVarCv = b.DT().cv(10);
        if (adTemplate.mInstallApkFromSDK) {
            i = 1;
        } else {
            i = adTemplate.mClickOpenAppStore ? 2 : 0;
        }
        a(adTemplate, bVarCv.cx(i).setAdTemplate(adTemplate));
    }

    public static void i(AdTemplate adTemplate, int i, String str) {
        a(adTemplate, true, b.DT().cv(9).cw(adTemplate.mInstallApkFormUser ? 1 : 2).setAdTemplate(adTemplate).setErrorCode(100003).setErrorMsg(str));
    }
}
