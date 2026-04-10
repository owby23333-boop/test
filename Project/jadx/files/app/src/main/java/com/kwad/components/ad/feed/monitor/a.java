package com.kwad.components.ad.feed.monitor;

import com.kwad.components.offline.api.core.api.ILoggerReporter;
import com.kwad.sdk.core.report.KSLoggerReporter;
import com.kwad.sdk.core.report.o;
import com.kwad.sdk.core.response.a.d;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwai.adclient.logger.model.BusinessType;
import com.kwai.adclient.logger.model.SubBusinessType;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public final class a {
    public static void a(int i2, long j2) {
        c(new FeedPageInfo().setStatus(6).setAdNum(i2).setLoadDataDuration(j2).toJson());
    }

    public static void a(AdTemplate adTemplate, int i2) {
        c(new FeedPageInfo().setStatus(7).setType(adTemplate.type).setMaterialType(com.kwad.sdk.core.response.a.a.aX(d.cb(adTemplate))).setRenderType(i2).setExpectedRenderType(2).toJson());
    }

    public static void a(AdTemplate adTemplate, int i2, int i3, String str, String str2, long j2) {
        if (i3 == 1 && adTemplate.mHasReportVideoLoad) {
            return;
        }
        if (i3 == 1) {
            adTemplate.mHasReportVideoLoad = true;
        }
        a(new FeedPageInfo().setStatus(3).setType(adTemplate.type).setLoadStatus(i2).setResourceLoadDuration(j2).setMaterialType(i3).setMaterialUrl(str).setErrorMsg(str2).toJson(), i2 == 2);
    }

    public static void a(AdTemplate adTemplate, int i2, long j2) {
        c(new FeedPageInfo().setStatus(8).setType(adTemplate.type).setMaterialType(com.kwad.sdk.core.response.a.a.aX(d.cb(adTemplate))).setRenderType(i2).setConvertDuration(j2).toJson());
    }

    public static void a(AdTemplate adTemplate, int i2, long j2, String str) {
        AdInfo adInfoCb = d.cb(adTemplate);
        a(new FeedPageInfo().setStatus(5).setType(adTemplate.type).setMaterialType(com.kwad.sdk.core.response.a.a.aX(adInfoCb)).setRenderType(i2).setExpectedRenderType(2).setErrorMsg(str).setRenderDuration(j2).setExtMsg(adInfoCb.adStyleInfo.feedAdInfo.toString()).toJson(), i2 != 2);
    }

    public static void a(String str, long j2, int i2) {
        KSLoggerReporter.h(new FeedWebViewInfo().setEvent("webview_timeout").setSceneId("ad_feed").setTimeType(i2).setDurationMs(j2).setUrl(str).toJson());
    }

    private static void a(JSONObject jSONObject, boolean z2) {
        KSLoggerReporter.a(new o.a().cl(z2 ? ILoggerReporter.Category.ERROR_LOG : ILoggerReporter.Category.APM_LOG).a(BusinessType.AD_FEED).a(SubBusinessType.OTHER).a(com.kwai.adclient.logger.model.a.aCJ).cm("ad_sdk_feed_load").z(jSONObject).xm());
    }

    public static void bg() {
        KSLoggerReporter.h(new FeedWebViewInfo().setEvent("ad_show").setSceneId("ad_feed").toJson());
    }

    public static void bh() {
        KSLoggerReporter.h(new FeedWebViewInfo().setEvent("webview_init").setSceneId("ad_feed").toJson());
    }

    public static void c(String str, long j2) {
        KSLoggerReporter.h(new FeedWebViewInfo().setEvent("webview_load_finish").setSceneId("ad_feed").setDurationMs(j2).setUrl(str).toJson());
    }

    private static void c(JSONObject jSONObject) {
        a(jSONObject, false);
    }

    public static void d(int i2, String str) {
        a(new FeedPageInfo().setStatus(9).setErrorCode(i2).setErrorMsg(str).toJson(), true);
    }

    public static void s(String str) {
        KSLoggerReporter.h(new FeedWebViewInfo().setEvent("webview_load_url").setSceneId("ad_feed").setUrl(str).toJson());
    }

    public static void w(int i2) {
        c(new FeedPageInfo().setStatus(1).setAdNum(i2).toJson());
    }

    public static void x(int i2) {
        c(new FeedPageInfo().setStatus(2).setAdNum(i2).toJson());
    }
}
