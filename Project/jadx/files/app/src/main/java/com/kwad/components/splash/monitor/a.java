package com.kwad.components.splash.monitor;

import android.os.SystemClock;
import androidx.annotation.NonNull;
import com.kwad.components.core.response.model.AdResultData;
import com.kwad.sdk.core.report.KSLoggerReporter;
import com.kwad.sdk.core.response.a.d;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public class a {
    private static volatile a XU;

    public static void A(long j2) {
        KSLoggerReporter.j(new SplashMonitorInfo(j2).setStatus(1).toJson());
    }

    public static void B(long j2) {
        KSLoggerReporter.k(new SplashMonitorInfo(j2).setStatus(1).toJson());
    }

    public static void V(@NonNull AdTemplate adTemplate) {
        KSLoggerReporter.j(new SplashMonitorInfo(adTemplate.posId).setType(adTemplate.notNetworkRequest ? 2 : 1).setStatus(2).setLoadDataTime(adTemplate.loadDataTime).setPreloadId(com.kwad.sdk.core.response.a.a.aT(d.cb(adTemplate))).toJson());
    }

    public static void W(@NonNull AdTemplate adTemplate) {
        KSLoggerReporter.n(new SplashMonitorInfo(adTemplate.posId).setStatus(1).setType(com.kwad.sdk.core.response.a.a.aW(d.cb(adTemplate)) ? 2 : 1).toJson());
    }

    public static void X(@NonNull AdTemplate adTemplate) {
        AdInfo adInfoCb = d.cb(adTemplate);
        KSLoggerReporter.n(new SplashMonitorInfo(adTemplate.posId).setStatus(4).setCreativeId(com.kwad.sdk.core.response.a.a.D(adInfoCb)).setType(com.kwad.sdk.core.response.a.a.aW(adInfoCb) ? 2 : 1).toJson());
    }

    public static void a(@NonNull AdInfo adInfo, int i2, String str, long j2) {
        KSLoggerReporter.l(new SplashMonitorInfo(j2).setStatus(2).setPreloadId(com.kwad.sdk.core.response.a.a.aT(adInfo)).setCreativeId(com.kwad.sdk.core.response.a.a.D(adInfo)).setFailUrl(com.kwad.sdk.core.response.a.a.aV(adInfo) ? com.kwad.sdk.core.response.a.a.E(adInfo) : com.kwad.sdk.core.response.a.a.aN(adInfo).materialUrl).setErrorCode(i2).setErrorMsg(str).setMaterialType(com.kwad.sdk.core.response.a.a.aV(adInfo) ? 1 : 2).setType(1).toJson());
    }

    public static void a(@NonNull AdInfo adInfo, long j2, int i2, long j3) {
        File fileAN = com.kwad.sdk.core.diskcache.a.a.vE().aN(com.kwad.sdk.core.response.a.a.aV(adInfo) ? com.kwad.sdk.core.response.a.a.E(adInfo) : com.kwad.sdk.core.response.a.a.aN(adInfo).materialUrl);
        KSLoggerReporter.l(new SplashMonitorInfo(j3).setStatus(1).setPreloadId(com.kwad.sdk.core.response.a.a.aT(adInfo)).setCostTime(j2).setCacheValidTime(((long) adInfo.adPreloadInfo.validityPeriod) * 1000).setSize((fileAN == null || !fileAN.exists()) ? 0L : fileAN.length()).setMaterialType(com.kwad.sdk.core.response.a.a.aV(adInfo) ? 1 : 2).setType(i2).setCreativeId(com.kwad.sdk.core.response.a.a.D(adInfo)).toJson());
    }

    public static void a(String str, boolean z2, int i2, String str2, long j2) {
        KSLoggerReporter.j(new SplashMonitorInfo(j2).setStatus(4).setType(z2 ? 2 : 1).setErrorCode(i2).setPreloadId(str).setErrorMsg(str2).toJson());
    }

    public static void a(@NonNull List<AdTemplate> list, long j2, long j3) {
        ArrayList arrayList = new ArrayList();
        Iterator<AdTemplate> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(com.kwad.sdk.core.response.a.a.aT(d.cb(it.next())));
        }
        KSLoggerReporter.k(new SplashMonitorInfo(j3).setStatus(2).setIds(arrayList).setLoadDataTime(j2).setCount(list.size()).toJson());
    }

    public static void b(int i2, String str, long j2) {
        KSLoggerReporter.k(new SplashMonitorInfo(j2).setStatus(3).setErrorCode(i2).setErrorMsg(str).toJson());
    }

    public static void b(@NonNull AdTemplate adTemplate, int i2, long j2) {
        long jElapsedRealtime = SystemClock.elapsedRealtime() - j2;
        KSLoggerReporter.j(new SplashMonitorInfo(adTemplate.posId).setType(adTemplate.notNetworkRequest ? 2 : 1).setStatus(3).setLoadDataTime(adTemplate.loadDataTime).setCheckStatus(i2).setCheckDataTime(jElapsedRealtime).setLoadAndCheckDataTime(adTemplate.loadDataTime + jElapsedRealtime).setPreloadId(com.kwad.sdk.core.response.a.a.aT(d.cb(adTemplate))).toJson());
    }

    public static void c(@NonNull AdTemplate adTemplate, int i2, long j2) {
        long jElapsedRealtime = SystemClock.elapsedRealtime() - j2;
        KSLoggerReporter.j(new SplashMonitorInfo(adTemplate.posId).setType(adTemplate.notNetworkRequest ? 2 : 1).setStatus(5).setCheckStatus(i2).setLoadDataTime(adTemplate.loadDataTime).setCheckDataTime(jElapsedRealtime).setLoadAndCheckDataTime(adTemplate.loadDataTime + jElapsedRealtime).setPreloadId(com.kwad.sdk.core.response.a.a.aT(d.cb(adTemplate))).toJson());
    }

    public static void d(@NonNull AdTemplate adTemplate, int i2, String str) {
        AdInfo adInfoCb = d.cb(adTemplate);
        boolean zAW = com.kwad.sdk.core.response.a.a.aW(adInfoCb);
        KSLoggerReporter.n(new SplashMonitorInfo(adTemplate.posId).setStatus(3).setCreativeId(com.kwad.sdk.core.response.a.a.D(adInfoCb)).setPreloadId(com.kwad.sdk.core.response.a.a.aT(adInfoCb)).setType(zAW ? 2 : 1).setFailUrl(zAW ? com.kwad.sdk.core.response.a.a.aN(adInfoCb).materialUrl : com.kwad.sdk.core.response.a.a.E(adInfoCb)).setErrorCode(i2).setErrorMsg(str).toJson());
    }

    public static void g(@NonNull AdTemplate adTemplate, long j2) {
        AdInfo adInfoCb = d.cb(adTemplate);
        KSLoggerReporter.n(new SplashMonitorInfo(adTemplate.posId).setStatus(5).setType(com.kwad.sdk.core.response.a.a.aW(adInfoCb) ? 2 : 1).setCostTime(j2).setCreativeId(com.kwad.sdk.core.response.a.a.D(adInfoCb)).setPreloadId(com.kwad.sdk.core.response.a.a.aT(adInfoCb)).toJson());
    }

    public static void h(@NonNull AdResultData adResultData) {
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        for (AdTemplate adTemplate : adResultData.getAdTemplateList()) {
            arrayList.add(String.valueOf(com.kwad.sdk.core.response.a.a.D(d.cb(adTemplate))));
            arrayList2.add(com.kwad.sdk.core.response.a.a.aT(d.cb(adTemplate)));
        }
        KSLoggerReporter.m(new SplashMonitorInfo(adResultData.getPosId()).setTotalCount(adResultData.getAdTemplateList().size()).setCreativeIds(arrayList).setPreloadIds(arrayList2).toJson());
    }

    public static void h(@NonNull AdTemplate adTemplate, long j2) {
        AdInfo adInfoCb = d.cb(adTemplate);
        KSLoggerReporter.n(new SplashMonitorInfo(adTemplate.posId).setStatus(2).setType(com.kwad.sdk.core.response.a.a.aW(adInfoCb) ? 2 : 1).setCostTime(j2).setCreativeId(com.kwad.sdk.core.response.a.a.D(adInfoCb)).setPreloadId(com.kwad.sdk.core.response.a.a.aT(adInfoCb)).toJson());
    }

    public static void i(@NonNull AdTemplate adTemplate, long j2) {
        if (j2 <= 0) {
            return;
        }
        long jElapsedRealtime = SystemClock.elapsedRealtime() - j2;
        AdInfo adInfoCb = d.cb(adTemplate);
        KSLoggerReporter.n(new SplashMonitorInfo(adTemplate.posId).setStatus(6).setCreativeId(com.kwad.sdk.core.response.a.a.D(adInfoCb)).setLoadDataTime(jElapsedRealtime).setType(com.kwad.sdk.core.response.a.a.aW(adInfoCb) ? 2 : 1).toJson());
    }

    public static a sp() {
        if (XU == null) {
            synchronized (a.class) {
                if (XU == null) {
                    XU = new a();
                }
            }
        }
        return XU;
    }
}
