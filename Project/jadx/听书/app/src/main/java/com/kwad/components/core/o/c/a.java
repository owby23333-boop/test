package com.kwad.components.core.o.c;

import com.kwad.components.offline.api.core.api.ILoggerReporter;
import com.kwad.sdk.service.ServiceProvider;

/* JADX INFO: loaded from: classes3.dex */
public final class a {
    private static void a(b bVar) {
        a(bVar, false);
    }

    private static void a(b bVar, boolean z) {
        com.kwad.sdk.commercial.b.d(com.kwad.sdk.commercial.c.DS().cF(z ? ILoggerReporter.Category.ERROR_LOG : ILoggerReporter.Category.APM_LOG).i(z ? 1.0d : 0.01d).O("ad_sdk_offline_component_monitor", "load_status").z(bVar).a(com.kwai.adclient.kscommerciallogger.model.a.bez));
    }

    public static void c(String str, long j) {
        try {
            a(new b().at(str).G(j).F(1L));
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }

    public static void a(String str, long j, int i, String str2, String str3) {
        try {
            a(new b().at(str).G(j).setErrorCode(i).av(str3).au(str2).F(7L), true);
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }

    public static void b(String str, long j, int i) {
        try {
            a(new b().at(str).G(j).aL(i).F(2L));
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }

    public static void a(String str, long j, String str2) {
        try {
            a(new b().at(str).av(str2).G(j).F(5L));
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }

    public static void b(String str, long j, String str2) {
        try {
            a(new b().at(str).G(j).av(str2).F(3L));
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }

    public static void c(String str, long j, String str2) {
        try {
            a(new b().at(str).G(j).av(str2).F(4L));
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }

    public static void d(String str, long j) {
        try {
            a(new b().at(str).G(j).F(6L));
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }

    public static void c(String str, long j, int i) {
        try {
            a(new b().at(str).F(8L).aL(i).G(j));
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }
}
