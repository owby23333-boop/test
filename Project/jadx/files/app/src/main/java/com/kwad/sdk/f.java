package com.kwad.sdk;

import com.kwad.components.offline.api.core.api.ILoggerReporter;
import com.kwad.sdk.commercial.model.SDKInitMsg;
import com.kwad.sdk.core.report.KSLoggerReporter;
import com.kwad.sdk.utils.av;

/* JADX INFO: loaded from: classes3.dex */
public final class f {
    private static int Yk;

    public static void E(long j2) {
        final long jCurrentTimeMillis = j2 > 0 ? System.currentTimeMillis() - j2 : -1L;
        Yk++;
        com.kwad.sdk.utils.g.execute(new av() { // from class: com.kwad.sdk.f.1
            @Override // com.kwad.sdk.utils.av
            public final void doTask() {
                KSLoggerReporter.a(ILoggerReporter.Category.APM_LOG, com.kwai.adclient.logger.model.a.aCH, new SDKInitMsg().setLaunchIntervalTime(jCurrentTimeMillis).setInitCount(f.Yk).setInitStatus(0).toJson());
            }
        });
    }

    public static void F(final long j2) {
        if (j2 > 10000) {
            j2 = -1;
        }
        com.kwad.sdk.utils.g.execute(new av() { // from class: com.kwad.sdk.f.2
            @Override // com.kwad.sdk.utils.av
            public final void doTask() {
                KSLoggerReporter.a(ILoggerReporter.Category.APM_LOG, com.kwai.adclient.logger.model.a.aCH, new SDKInitMsg().setTotalDurationTime(j2).setInitCount(f.Yk).setInitStatus(1).toJson());
            }
        });
    }

    public static void a(final com.kwai.adclient.logger.model.d dVar, final String str) {
        com.kwad.sdk.utils.g.execute(new av() { // from class: com.kwad.sdk.f.3
            @Override // com.kwad.sdk.utils.av
            public final void doTask() {
                KSLoggerReporter.a(ILoggerReporter.Category.ERROR_LOG, dVar, new SDKInitMsg().setInitCount(f.Yk).setErrorReason(str).setInitStatus(2).toJson());
            }
        });
    }
}
