package com.kwad.components.ad.interstitial.monitor;

import android.os.SystemClock;
import androidx.annotation.NonNull;
import com.kwad.sdk.KsAdSDKImpl;
import com.kwad.sdk.core.report.KSLoggerReporter;
import com.kwad.sdk.core.response.a.d;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;

/* JADX INFO: loaded from: classes2.dex */
public final class b {

    static class a {
        private static final b jk = new b(0);
    }

    private b() {
        init();
    }

    /* synthetic */ b(byte b) {
        this();
    }

    public static void a(int i2, String str, long j2) {
        KSLoggerReporter.q(new InterstitialMonitorInfo(j2).setStatus(5).setErrorCode(i2).setErrorMsg(str).toJson());
    }

    public static void a(@NonNull AdTemplate adTemplate, int i2, String str) {
        AdInfo adInfoCb = d.cb(adTemplate);
        KSLoggerReporter.u(new InterstitialMonitorInfo(adTemplate.posId).setCreativeId(com.kwad.sdk.core.response.a.a.D(adInfoCb)).setVideoUrl(com.kwad.sdk.core.response.a.a.E(adInfoCb)).setDownloadType(adTemplate.getDownloadType()).setDownloadSize(adTemplate.getDownloadSize()).setVideoDuration(com.kwad.sdk.core.response.a.a.F(adInfoCb) * 1000).setStatus(2).setErrorMsg(str).setErrorCode(i2).toJson());
    }

    public static void a(@NonNull AdTemplate adTemplate, long j2, boolean z2) {
        if (j2 <= 0) {
            return;
        }
        adTemplate.loadDataTime = SystemClock.elapsedRealtime() - j2;
        long j3 = adTemplate.loadDataTime;
        if (j3 <= 0 || j3 >= 60000) {
            return;
        }
        KSLoggerReporter.q(new InterstitialMonitorInfo(adTemplate.posId).setStatus(2).setType(z2 ? 2 : 1).setLoadDataTime(adTemplate.loadDataTime).setExpectedRenderType(com.kwad.sdk.core.response.a.b.bw(adTemplate)).toJson());
    }

    public static void a(@NonNull AdTemplate adTemplate, String str) {
        AdInfo adInfoCb = d.cb(adTemplate);
        KSLoggerReporter.s(new InterstitialMonitorInfo(adTemplate.posId).setCreativeId(com.kwad.sdk.core.response.a.a.D(adInfoCb)).setVideoUrl(com.kwad.sdk.core.response.a.a.E(adInfoCb)).setDownloadSize(adTemplate.getDownloadSize()).setDownloadType(adTemplate.getDownloadType()).setVideoDuration(com.kwad.sdk.core.response.a.a.F(adInfoCb) * 1000).setStatus(2).setErrorMsg(str).toJson());
    }

    public static void b(@NonNull AdTemplate adTemplate, int i2) {
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        long j2 = adTemplate.adShowStartTimeStamp;
        long j3 = jElapsedRealtime - j2;
        if (j2 > 0) {
            long j4 = adTemplate.loadDataTime;
            if (j4 <= 0 || j4 >= 60000 || j3 <= 0 || j3 >= 5000) {
                return;
            }
            KSLoggerReporter.q(new InterstitialMonitorInfo(adTemplate.posId).setStatus(4).setType(adTemplate.notNetworkRequest ? 2 : 1).setMaterialType(com.kwad.sdk.core.response.a.a.aX(d.cb(adTemplate))).setRenderDuration(j3).setRenderType(i2).setExpectedRenderType(com.kwad.sdk.core.response.a.b.bw(adTemplate)).toJson());
        }
    }

    public static void b(@NonNull AdTemplate adTemplate, long j2, boolean z2) {
        if (j2 > 0 && com.kwad.sdk.core.response.a.a.ba(d.cb(adTemplate))) {
            adTemplate.downloadDuration = SystemClock.elapsedRealtime() - j2;
            long j3 = adTemplate.downloadDuration;
            if (j3 <= 0 || j3 >= 60000) {
                return;
            }
            adTemplate.notNetworkRequest = z2;
            KSLoggerReporter.q(new InterstitialMonitorInfo(adTemplate.posId).setStatus(3).setType(adTemplate.notNetworkRequest ? 2 : 1).setDownloadDuration(adTemplate.downloadDuration).setDownloadSize(adTemplate.getDownloadSize()).setDownloadType(adTemplate.getDownloadType()).toJson());
        }
    }

    public static b cR() {
        return a.jk;
    }

    public static void g(long j2) {
        KSLoggerReporter.q(new InterstitialMonitorInfo(j2).setStatus(1).toJson());
    }

    public static void g(@NonNull AdTemplate adTemplate) {
        KSLoggerReporter.r(new InterstitialMonitorInfo(adTemplate.posId).setDownloadType(adTemplate.getDownloadType()).setStatus(1).toJson());
    }

    public static void h(long j2) {
        KSLoggerReporter.q(new InterstitialMonitorInfo(j2).setStatus(6).toJson());
    }

    public static void h(@NonNull AdTemplate adTemplate) {
        KSLoggerReporter.t(new InterstitialMonitorInfo(adTemplate.posId).setDownloadType(adTemplate.getDownloadType()).setStatus(1).toJson());
    }

    private static void init() {
        KsAdSDKImpl.get().getContext();
    }
}
