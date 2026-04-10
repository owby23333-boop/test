package com.kwad.components.ad.reward.monitor;

import android.os.SystemClock;
import androidx.annotation.NonNull;
import com.kwad.sdk.core.report.KSLoggerReporter;
import com.kwad.sdk.core.response.a.d;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;

/* JADX INFO: loaded from: classes3.dex */
public final class a {
    public static void K(boolean z2) {
        KSLoggerReporter.h(new RewardWebViewInfo().setEvent("ad_show").setSceneId(z2 ? "ad_reward" : "ad_fullscreen").toJson());
    }

    public static void a(AdTemplate adTemplate, int i2, int i3, boolean z2) {
        AdInfo adInfoCb = d.cb(adTemplate);
        KSLoggerReporter.i(new RewardMonitorInfo(adTemplate.posId).setCreativeId(com.kwad.sdk.core.response.a.a.D(adInfoCb)).setRewardType(!z2 ? 1 : 0).setTaskType(i2).setTaskStep(i3).setVideoUrl(com.kwad.sdk.core.response.a.a.E(adInfoCb)).setVideoDuration(com.kwad.sdk.core.response.a.a.F(adInfoCb) * 1000).toJson());
    }

    public static void a(boolean z2, int i2, String str, long j2) {
        KSLoggerReporter.a(z2, new RewardMonitorInfo(j2).setLoadStatus(4).setErrorCode(i2).setErrorMsg(str).toJson(), com.kwai.adclient.logger.model.a.aCF);
    }

    public static void a(boolean z2, long j2) {
        KSLoggerReporter.a(z2, new RewardMonitorInfo(j2).setLoadStatus(1).toJson(), com.kwai.adclient.logger.model.a.aCJ);
    }

    public static void a(boolean z2, AdTemplate adTemplate) {
        AdInfo adInfoCb = d.cb(adTemplate);
        KSLoggerReporter.b(z2, new RewardMonitorInfo(adTemplate.posId).setPageStatus(3).setLoadType(adTemplate.isLoadFromCache() ? 2 : 1).setDownloadType(adTemplate.getDownloadType()).setDownloadSize(adTemplate.getDownloadSize()).setCreativeId(com.kwad.sdk.core.response.a.a.D(adInfoCb)).setVideoUrl(com.kwad.sdk.core.response.a.a.E(adInfoCb)).setVideoDuration(com.kwad.sdk.core.response.a.a.F(adInfoCb) * 1000).toJson());
    }

    public static void a(boolean z2, @NonNull AdTemplate adTemplate, int i2, long j2) {
        long loadDataTime = (j2 <= 0 || adTemplate.getLoadDataTime() <= 0) ? -1L : adTemplate.getLoadDataTime() - j2;
        if (a(loadDataTime)) {
            loadDataTime = -1;
        }
        AdInfo adInfoCb = d.cb(adTemplate);
        KSLoggerReporter.a(z2, new RewardMonitorInfo(adTemplate.posId).setLoadStatus(2).setLoadType(adTemplate.isLoadFromCache() ? 2 : 1).setAdCount(i2).setLoadDataDuration(loadDataTime).setCreativeId(com.kwad.sdk.core.response.a.a.D(adInfoCb)).setVideoUrl(com.kwad.sdk.core.response.a.a.E(adInfoCb)).setVideoDuration(com.kwad.sdk.core.response.a.a.F(adInfoCb) * 1000).toJson(), com.kwai.adclient.logger.model.a.aCJ);
    }

    public static void a(boolean z2, AdTemplate adTemplate, long j2) {
        if (adTemplate.getLoadDataTime() <= 0 || adTemplate.getDownloadFinishTime() <= 0) {
            return;
        }
        long loadDataTime = j2 - adTemplate.getLoadDataTime();
        long downloadFinishTime = j2 - adTemplate.getDownloadFinishTime();
        AdInfo adInfoCb = d.cb(adTemplate);
        KSLoggerReporter.b(z2, new RewardMonitorInfo(adTemplate.posId).setPageStatus(1).setLoadType(adTemplate.isLoadFromCache() ? 2 : 1).setDataLoadInterval(loadDataTime).setDataDownloadInterval(downloadFinishTime).setDownloadType(adTemplate.getDownloadType()).setDownloadSize(adTemplate.getDownloadSize()).setCreativeId(com.kwad.sdk.core.response.a.a.D(adInfoCb)).setVideoUrl(com.kwad.sdk.core.response.a.a.E(adInfoCb)).setVideoDuration(com.kwad.sdk.core.response.a.a.F(adInfoCb) * 1000).toJson());
    }

    public static void a(boolean z2, AdTemplate adTemplate, long j2, int i2, long j3) {
        AdInfo adInfoCb = d.cb(adTemplate);
        KSLoggerReporter.c(z2, new RewardMonitorInfo(adTemplate.posId).setLoadType(adTemplate.isLoadFromCache() ? 2 : 1).setCurrentDuration(j2).setErrorCode(i2).setErrorMsg(String.valueOf(j3)).setDownloadType(adTemplate.getDownloadType()).setDownloadSize(adTemplate.getDownloadSize()).setCreativeId(com.kwad.sdk.core.response.a.a.D(adInfoCb)).setVideoUrl(com.kwad.sdk.core.response.a.a.E(adInfoCb)).setVideoDuration(com.kwad.sdk.core.response.a.a.F(adInfoCb) * 1000).toJson());
    }

    public static void a(boolean z2, AdTemplate adTemplate, String str) {
        AdInfo adInfoCb = d.cb(adTemplate);
        KSLoggerReporter.a(z2, new RewardMonitorInfo(adTemplate.posId).setLoadType(adTemplate.isLoadFromCache() ? 2 : 1).setDownloadType(adTemplate.getDownloadType()).setDownloadSize(adTemplate.getDownloadSize()).setCreativeId(com.kwad.sdk.core.response.a.a.D(adInfoCb)).setVideoUrl(com.kwad.sdk.core.response.a.a.E(adInfoCb)).setVideoDuration(com.kwad.sdk.core.response.a.a.F(adInfoCb) * 1000).setErrorMsg(str).toJson());
    }

    public static void a(boolean z2, String str) {
        KSLoggerReporter.h(new RewardWebViewInfo().setPageType(str).setEvent("webview_init").setSceneId(z2 ? "ad_reward" : "ad_fullscreen").toJson());
    }

    public static void a(boolean z2, String str, String str2) {
        KSLoggerReporter.h(new RewardWebViewInfo().setPageType(str).setEvent("webview_load_url").setSceneId(z2 ? "ad_reward" : "ad_fullscreen").setUrl(str2).toJson());
    }

    public static void a(boolean z2, String str, String str2, long j2) {
        KSLoggerReporter.h(new RewardWebViewInfo().setPageType(str).setEvent("webview_load_finish").setSceneId(z2 ? "ad_reward" : "ad_fullscreen").setDurationMs(j2).setUrl(str2).toJson());
    }

    public static void a(boolean z2, String str, String str2, long j2, int i2) {
        KSLoggerReporter.h(new RewardWebViewInfo().setPageType(str).setEvent("webview_timeout").setSceneId(z2 ? "ad_reward" : "ad_fullscreen").setDurationMs(j2).setTimeType(i2).setUrl(str2).toJson());
    }

    private static boolean a(long... jArr) {
        for (long j2 : jArr) {
            if (j2 >= 60000) {
                return true;
            }
        }
        return false;
    }

    public static void b(boolean z2, AdTemplate adTemplate, int i2, long j2) {
        adTemplate.setDownloadFinishTime(SystemClock.elapsedRealtime());
        AdInfo adInfoCb = d.cb(adTemplate);
        long loadDataTime = adTemplate.getLoadDataTime() - j2;
        long downloadFinishTime = adTemplate.getDownloadFinishTime() - adTemplate.getLoadDataTime();
        long downloadFinishTime2 = adTemplate.getDownloadFinishTime() - j2;
        if (a(loadDataTime, downloadFinishTime, downloadFinishTime2)) {
            loadDataTime = -1;
            downloadFinishTime = -1;
            downloadFinishTime2 = -1;
        }
        KSLoggerReporter.a(z2, new RewardMonitorInfo(adTemplate.posId).setLoadStatus(3).setLoadType(adTemplate.isLoadFromCache() ? 2 : 1).setAdCount(i2).setLoadDataDuration(loadDataTime).setDownloadDuration(downloadFinishTime).setTotalDuration(downloadFinishTime2).setDownloadType(adTemplate.getDownloadType()).setDownloadSize(adTemplate.getDownloadSize()).setCreativeId(com.kwad.sdk.core.response.a.a.D(adInfoCb)).setVideoUrl(com.kwad.sdk.core.response.a.a.E(adInfoCb)).setVideoDuration(com.kwad.sdk.core.response.a.a.F(adInfoCb) * 1000).toJson(), com.kwai.adclient.logger.model.a.aCJ);
    }

    public static void b(boolean z2, AdTemplate adTemplate, long j2) {
        if (j2 == 0 || adTemplate.getLoadDataTime() <= 0 || adTemplate.getDownloadFinishTime() <= 0) {
            return;
        }
        long j3 = -1;
        if (!j(j2)) {
            long jElapsedRealtime = SystemClock.elapsedRealtime() - j2;
            if (!a(jElapsedRealtime)) {
                j3 = jElapsedRealtime;
            }
        }
        AdInfo adInfoCb = d.cb(adTemplate);
        KSLoggerReporter.b(z2, new RewardMonitorInfo(adTemplate.posId).setPageStatus(2).setLoadType(adTemplate.isLoadFromCache() ? 2 : 1).setRenderDuration(j3).setDownloadType(adTemplate.getDownloadType()).setDownloadSize(adTemplate.getDownloadSize()).setCreativeId(com.kwad.sdk.core.response.a.a.D(adInfoCb)).setVideoUrl(com.kwad.sdk.core.response.a.a.E(adInfoCb)).setVideoDuration(com.kwad.sdk.core.response.a.a.F(adInfoCb) * 1000).toJson());
    }

    private static boolean j(long j2) {
        return j2 == -1;
    }
}
