package com.kwad.sdk.crash.report.request;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.sdk.core.network.BaseResultData;
import com.kwad.sdk.core.network.g;
import com.kwad.sdk.core.network.m;
import com.kwad.sdk.core.network.p;
import com.kwad.sdk.crash.report.ReportEvent;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public final class b {

    public interface a {
        void onError(int i2, String str);

        void onSuccess();
    }

    public static void a(List<ReportEvent> list, @Nullable CountDownLatch countDownLatch) {
        a(list, countDownLatch, null);
    }

    public static void a(final List<ReportEvent> list, @Nullable final CountDownLatch countDownLatch, final a aVar) {
        com.kwad.sdk.core.d.b.d("ExceptionCollector", "CrashReportRequestManager request");
        if (list == null || list.size() <= 0) {
            return;
        }
        new m<com.kwad.sdk.crash.report.request.a, CrashReportResult>() { // from class: com.kwad.sdk.crash.report.request.b.1
            /* JADX INFO: Access modifiers changed from: private */
            @Override // com.kwad.sdk.core.network.a
            @NonNull
            /* JADX INFO: renamed from: Ao, reason: merged with bridge method [inline-methods] */
            public com.kwad.sdk.crash.report.request.a createRequest() {
                return new com.kwad.sdk.crash.report.request.a(list);
            }

            @NonNull
            private static CrashReportResult dB(String str) {
                JSONObject jSONObject = new JSONObject(str);
                CrashReportResult crashReportResult = new CrashReportResult();
                crashReportResult.parseJson(jSONObject);
                return crashReportResult;
            }

            @Override // com.kwad.sdk.core.network.m
            public final boolean enableMonitorReport() {
                return false;
            }

            @Override // com.kwad.sdk.core.network.m
            @NonNull
            public final /* synthetic */ BaseResultData parseData(String str) {
                return dB(str);
            }
        }.request(new p<com.kwad.sdk.crash.report.request.a, CrashReportResult>() { // from class: com.kwad.sdk.crash.report.request.b.2
            private void Ap() {
                a aVar2 = aVar;
                if (aVar2 != null) {
                    aVar2.onSuccess();
                }
            }

            private void k(int i2, String str) {
                CountDownLatch countDownLatch2 = countDownLatch;
                if (countDownLatch2 != null) {
                    countDownLatch2.countDown();
                }
                a aVar2 = aVar;
                if (aVar2 != null) {
                    aVar2.onError(i2, str);
                }
            }

            @Override // com.kwad.sdk.core.network.p, com.kwad.sdk.core.network.h
            public final /* synthetic */ void onError(@NonNull g gVar, int i2, String str) {
                k(i2, str);
            }

            @Override // com.kwad.sdk.core.network.p, com.kwad.sdk.core.network.h
            public final /* synthetic */ void onSuccess(@NonNull g gVar, @NonNull BaseResultData baseResultData) {
                Ap();
            }
        });
    }
}
