package com.kwad.components.ad.interstitial.report.realtime;

import com.kwad.components.ad.interstitial.report.realtime.model.InterstitialRealTimeInfo;
import com.kwad.components.offline.api.core.api.ILoggerReporter;
import com.kwad.sdk.commercial.b;
import com.kwad.sdk.commercial.c;
import com.kwad.sdk.core.network.e;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.service.ServiceProvider;
import com.kwai.adclient.kscommerciallogger.model.BusinessType;

/* JADX INFO: loaded from: classes3.dex */
public final class a {
    /* synthetic */ a(byte b) {
        this();
    }

    /* JADX INFO: renamed from: com.kwad.components.ad.interstitial.report.realtime.a$a, reason: collision with other inner class name */
    static class C0286a {
        private static final a nQ = new a(0);
    }

    private a() {
    }

    public static a eW() {
        return C0286a.nQ;
    }

    public static void a(e eVar) {
        try {
            InterstitialRealTimeInfo interstitialRealTimeInfo = new InterstitialRealTimeInfo();
            interstitialRealTimeInfo.setErrorCode(eVar.errorCode);
            b.d(c.DS().cF(ILoggerReporter.Category.ERROR_LOG).i(1.0d).O("ad_sdk_interstitial_data_result_monitor", "error_code").b(BusinessType.AD_INTERSTITIAL).z(interstitialRealTimeInfo).a(com.kwai.adclient.kscommerciallogger.model.a.bez));
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }

    public static void F(AdTemplate adTemplate) {
        try {
            InterstitialRealTimeInfo interstitialRealTimeInfo = new InterstitialRealTimeInfo();
            interstitialRealTimeInfo.setRenderType(com.kwad.sdk.core.response.b.e.el(adTemplate).adMatrixInfo.adDataV2.interstitialCardInfo.renderType);
            interstitialRealTimeInfo.setAdTemplate(adTemplate);
            b.d(c.DS().cF(ILoggerReporter.Category.ERROR_LOG).i(1.0d).O("ad_sdk_interstitial_data_check_monitor", "monitor_index").b(BusinessType.AD_INTERSTITIAL).z(interstitialRealTimeInfo).a(com.kwai.adclient.kscommerciallogger.model.a.bez));
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }

    public static void a(String str, AdTemplate adTemplate) {
        try {
            InterstitialRealTimeInfo interstitialRealTimeInfo = new InterstitialRealTimeInfo();
            interstitialRealTimeInfo.setAdTemplate(adTemplate);
            interstitialRealTimeInfo.setErrorMsg(str);
            b.d(c.DS().cF(ILoggerReporter.Category.ERROR_LOG).i(1.0d).O("ad_sdk_interstitial_render_result_monitor", "monitor_index").b(BusinessType.AD_INTERSTITIAL).z(interstitialRealTimeInfo).a(com.kwai.adclient.kscommerciallogger.model.a.bez));
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }

    public static void G(AdTemplate adTemplate) {
        try {
            InterstitialRealTimeInfo interstitialRealTimeInfo = new InterstitialRealTimeInfo();
            interstitialRealTimeInfo.setAdTemplate(adTemplate);
            b.d(c.DS().cF(ILoggerReporter.Category.ERROR_LOG).i(1.0d).O("ad_sdk_interstitial_service_call_monitor", "monitor_index").b(BusinessType.AD_INTERSTITIAL).z(interstitialRealTimeInfo).a(com.kwai.adclient.kscommerciallogger.model.a.bez));
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }

    public static void b(String str, AdTemplate adTemplate) {
        try {
            AdInfo adInfoEl = com.kwad.sdk.core.response.b.e.el(adTemplate);
            InterstitialRealTimeInfo interstitialRealTimeInfo = new InterstitialRealTimeInfo();
            interstitialRealTimeInfo.setAdTemplate(adTemplate);
            interstitialRealTimeInfo.setErrorMsg(str);
            interstitialRealTimeInfo.setMaterialUrl(com.kwad.sdk.core.response.b.a.K(adInfoEl));
            b.d(c.DS().cF(ILoggerReporter.Category.ERROR_LOG).i(1.0d).O("ad_sdk_interstitial_resource_monitor", "monitor_index").b(BusinessType.AD_INTERSTITIAL).z(interstitialRealTimeInfo).a(com.kwai.adclient.kscommerciallogger.model.a.bez));
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }
}
