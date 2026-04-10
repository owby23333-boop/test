package com.kwad.components.core.o.c;

import com.kwad.components.offline.api.core.api.ILoggerReporter;
import com.kwad.sdk.service.ServiceProvider;

/* JADX INFO: loaded from: classes3.dex */
public final class c {
    private static void a(d dVar, boolean z) {
        com.kwad.sdk.commercial.b.d(com.kwad.sdk.commercial.c.DS().cF(z ? ILoggerReporter.Category.ERROR_LOG : ILoggerReporter.Category.APM_LOG).i(z ? 1.0d : 0.01d).O("ad_sdk_offline_component_update", "load_status").z(dVar).a(com.kwai.adclient.kscommerciallogger.model.a.bez));
    }

    public static void d(String str, long j, String str2) {
        try {
            a(new d().aw(str).ay(str2).I(j).H(1L), false);
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }

    public static void b(String str, long j, int i, String str2, String str3) {
        try {
            a(new d().aw(str).I(j).setErrorCode(i).ay(str2).ax(str3).H(2L), true);
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }

    public static void a(String str, long j, long j2, String str2) {
        try {
            a(new d().aw(str).I(j).J(j2).ay(str2).H(3L), false);
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }
}
