package com.kwad.components.ad.interstitial.report;

import androidx.core.app.NotificationCompat;
import com.kwad.components.offline.api.core.api.ILoggerReporter;
import com.kwad.sdk.core.response.b.e;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.service.ServiceProvider;
import com.kwai.adclient.kscommerciallogger.model.BusinessType;

/* JADX INFO: loaded from: classes3.dex */
public final class d {

    static class a {
        private static final d nP = new d();
    }

    public static d eU() {
        return a.nP;
    }

    private static void a(boolean z, com.kwad.sdk.commercial.c.a aVar) {
        try {
            com.kwad.sdk.commercial.b.d(com.kwad.sdk.commercial.c.DS().cF(ILoggerReporter.Category.APM_LOG).i(z ? 1.0d : 0.01d).O("ad_sdk_interstitial_play", NotificationCompat.CATEGORY_STATUS).b(BusinessType.AD_INTERSTITIAL).z(aVar).a(com.kwai.adclient.kscommerciallogger.model.a.bez));
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }

    public final void E(AdTemplate adTemplate) {
        a(false, new InterstitialReportInfo(adTemplate).setStatus(1).setAdTemplate(adTemplate));
    }

    public final void b(AdTemplate adTemplate, long j) {
        AdInfo adInfoEl = e.el(adTemplate);
        a(false, new InterstitialReportInfo(adTemplate).setStatus(3).setCreativeId(e.ev(adTemplate)).setVideoUrl(com.kwad.sdk.core.response.b.a.K(adInfoEl)).setVideoDuration(((long) com.kwad.sdk.core.response.b.a.L(adInfoEl)) * 1000).setPlayStartedDuration(j).setAdTemplate(adTemplate));
    }

    public final void b(AdTemplate adTemplate, int i, String str) {
        AdInfo adInfoEl = e.el(adTemplate);
        a(true, new InterstitialReportInfo(adTemplate).setCreativeId(com.kwad.sdk.core.response.b.a.J(adInfoEl)).setVideoUrl(com.kwad.sdk.core.response.b.a.K(adInfoEl)).setDownloadType(adTemplate.getDownloadType()).setDownloadSize(adTemplate.getDownloadSize()).setVideoDuration(com.kwad.sdk.core.response.b.a.L(adInfoEl) * 1000).setStatus(2).setErrorMsg(str).setErrorCode(i).setAdTemplate(adTemplate));
    }
}
