package com.kwad.components.ad.interstitial.report;

import androidx.core.app.NotificationCompat;
import com.kwad.components.offline.api.core.api.ILoggerReporter;
import com.kwad.sdk.core.response.b.e;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.service.ServiceProvider;
import com.kwai.adclient.kscommerciallogger.model.BusinessType;

/* JADX INFO: loaded from: classes3.dex */
public final class b {

    static class a {
        private static final b nN = new b();
    }

    public static b eQ() {
        return a.nN;
    }

    private static void a(boolean z, com.kwad.sdk.commercial.c.a aVar) {
        try {
            com.kwad.sdk.commercial.b.d(com.kwad.sdk.commercial.c.DS().cF(ILoggerReporter.Category.APM_LOG).i(z ? 1.0d : 0.01d).O("ad_sdk_interstitial_download_error", NotificationCompat.CATEGORY_STATUS).b(BusinessType.AD_INTERSTITIAL).z(aVar).a(com.kwai.adclient.kscommerciallogger.model.b.beS));
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }

    public final void x(AdTemplate adTemplate) {
        a(false, new InterstitialReportInfo().setDownloadType(adTemplate.getDownloadType()).setStatus(1).setAdTemplate(adTemplate));
    }

    public final void b(AdTemplate adTemplate, String str) {
        AdInfo adInfoEl = e.el(adTemplate);
        a(true, new InterstitialReportInfo().setCreativeId(com.kwad.sdk.core.response.b.a.J(adInfoEl)).setVideoUrl(com.kwad.sdk.core.response.b.a.K(adInfoEl)).setDownloadSize(adTemplate.getDownloadSize()).setDownloadType(adTemplate.getDownloadType()).setVideoDuration(com.kwad.sdk.core.response.b.a.L(adInfoEl) * 1000).setStatus(2).setErrorMsg(str).setAdTemplate(adTemplate));
    }
}
