package com.kwad.sdk.crash.report.upload;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.sdk.core.network.BaseResultData;
import com.kwad.sdk.core.network.m;
import com.kwad.sdk.crash.utils.g;
import com.kwad.sdk.utils.at;
import com.kwad.sdk.utils.p;
import java.io.File;
import java.util.HashMap;
import java.util.concurrent.CountDownLatch;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public final class d {
    public static void a(@NonNull final File file, boolean z2, @Nullable final CountDownLatch countDownLatch) {
        com.kwad.sdk.core.d.b.d("ExceptionCollector", "upload()" + Thread.currentThread());
        final f fVar = new f();
        fVar.asr = at.getDeviceId();
        HashMap map = new HashMap();
        map.put("mLogUUID", g.dE(file.getName()));
        fVar.ast = new JSONObject(map).toString();
        fVar.asu = p.getExtension(file.getName());
        fVar.asw = file;
        final boolean z3 = true;
        new m<c, GetUploadTokenResult>() { // from class: com.kwad.sdk.crash.report.upload.d.1
            /* JADX INFO: Access modifiers changed from: private */
            @Override // com.kwad.sdk.core.network.a
            @NonNull
            /* JADX INFO: renamed from: As, reason: merged with bridge method [inline-methods] */
            public c createRequest() {
                return new c(at.getDeviceId(), fVar.asp, "zip");
            }

            @NonNull
            private static GetUploadTokenResult dD(String str) {
                JSONObject jSONObject = new JSONObject(str);
                GetUploadTokenResult getUploadTokenResult = new GetUploadTokenResult();
                getUploadTokenResult.parseJson(jSONObject);
                return getUploadTokenResult;
            }

            @Override // com.kwad.sdk.core.network.m
            public final boolean isPostByJson() {
                return false;
            }

            @Override // com.kwad.sdk.core.network.m
            @NonNull
            public final /* synthetic */ BaseResultData parseData(String str) {
                return dD(str);
            }
        }.request(new com.kwad.sdk.core.network.p<c, GetUploadTokenResult>() { // from class: com.kwad.sdk.crash.report.upload.d.2
            private static void a(@NonNull c cVar, int i2, String str) {
                com.kwad.sdk.core.d.b.d("ExceptionCollector", "onError errorCode=" + i2 + "errorMsg=" + str + "url=" + cVar.getUrl());
            }

            /* JADX INFO: Access modifiers changed from: private */
            @Override // com.kwad.sdk.core.network.p, com.kwad.sdk.core.network.h
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public void onSuccess(@NonNull c cVar, @NonNull GetUploadTokenResult getUploadTokenResult) throws Throwable {
                com.kwad.sdk.core.d.b.d("ExceptionCollector", "onSuccess url=" + cVar.getUrl() + " ---{" + getUploadTokenResult.uploadToken);
                if (getUploadTokenResult.isResultOk()) {
                    f fVar2 = fVar;
                    fVar2.asv = getUploadTokenResult.uploadToken;
                    b.a(file, fVar2, new a() { // from class: com.kwad.sdk.crash.report.upload.d.2.1
                        @Override // com.kwad.sdk.crash.report.upload.a
                        public final void Aq() {
                            CountDownLatch countDownLatch2 = countDownLatch;
                            if (countDownLatch2 != null) {
                                countDownLatch2.countDown();
                            }
                        }

                        @Override // com.kwad.sdk.crash.report.upload.a
                        public final void Ar() {
                            com.kwad.sdk.core.d.b.d("ExceptionCollector", "uploadLogFile onSuccess " + Thread.currentThread() + " delete file:" + file.getPath());
                            CountDownLatch countDownLatch2 = countDownLatch;
                            if (countDownLatch2 != null) {
                                countDownLatch2.countDown();
                            }
                            AnonymousClass2 anonymousClass2 = AnonymousClass2.this;
                            if (z3) {
                                p.delete(file.getPath());
                            }
                        }
                    });
                }
            }

            @Override // com.kwad.sdk.core.network.p, com.kwad.sdk.core.network.h
            public final /* synthetic */ void onError(@NonNull com.kwad.sdk.core.network.g gVar, int i2, String str) {
                a((c) gVar, i2, str);
            }
        });
    }
}
