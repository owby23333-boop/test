package com.kwad.components.ad.splashscreen.monitor;

import com.kwad.sdk.core.report.KSLoggerReporter;

/* JADX INFO: loaded from: classes3.dex */
public final class a {
    public static void Y(String str) {
        KSLoggerReporter.h(new SplashWebMonitorInfo().setEvent("webview_load_url").setSceneId("ad_splash").setUrl(str).toJson());
    }

    public static void a(String str, long j2, int i2, String str2) {
        KSLoggerReporter.h(new SplashWebMonitorInfo().setEvent("webview_timeout").setSceneId("ad_splash").setDurationMs(j2).setTimeType(i2).setUrl(str).setErrorMsg(str2).toJson());
    }

    public static void d(String str, long j2) {
        KSLoggerReporter.h(new SplashWebMonitorInfo().setEvent("webview_load_finish").setSceneId("ad_splash").setDurationMs(j2).setUrl(str).toJson());
    }

    public static void kY() {
        KSLoggerReporter.h(new SplashWebMonitorInfo().setEvent("ad_show").setSceneId("ad_splash").toJson());
    }

    public static void kZ() {
        KSLoggerReporter.h(new SplashWebMonitorInfo().setEvent("webview_init").setSceneId("ad_splash").toJson());
    }
}
