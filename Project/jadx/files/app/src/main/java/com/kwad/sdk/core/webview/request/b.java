package com.kwad.sdk.core.webview.request;

import android.os.Handler;
import android.os.Looper;
import androidx.annotation.MainThread;
import androidx.annotation.NonNull;
import com.kwad.sdk.core.network.BaseResultData;
import com.kwad.sdk.core.network.g;
import com.kwad.sdk.core.network.m;
import com.kwad.sdk.core.network.p;
import com.kwad.sdk.core.webview.c.b;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public final class b {
    private static final Handler mHandler = new Handler(Looper.getMainLooper());

    public interface a {
        @MainThread
        void a(@NonNull WebCardGetDataResponse webCardGetDataResponse);

        @MainThread
        void onError(int i2, String str);
    }

    public final void a(final b.a aVar, @NonNull final a aVar2) {
        new m<com.kwad.sdk.core.webview.request.a, WebCardGetDataResponse>() { // from class: com.kwad.sdk.core.webview.request.b.1
            @NonNull
            private static WebCardGetDataResponse cX(String str) {
                JSONObject jSONObject = new JSONObject(str);
                WebCardGetDataResponse webCardGetDataResponse = new WebCardGetDataResponse();
                webCardGetDataResponse.parseJson(jSONObject);
                return webCardGetDataResponse;
            }

            /* JADX INFO: Access modifiers changed from: private */
            @Override // com.kwad.sdk.core.network.a
            @NonNull
            /* JADX INFO: renamed from: zs, reason: merged with bridge method [inline-methods] */
            public com.kwad.sdk.core.webview.request.a createRequest() {
                b.a aVar3 = aVar;
                return new com.kwad.sdk.core.webview.request.a(aVar3.url, aVar3.method, aVar3.params) { // from class: com.kwad.sdk.core.webview.request.b.1.1
                    @Override // com.kwad.sdk.core.webview.request.a, com.kwad.sdk.core.network.b, com.kwad.sdk.core.network.g
                    public final String getUrl() {
                        return aVar.url;
                    }
                };
            }

            @Override // com.kwad.sdk.core.network.m
            @NonNull
            public final /* synthetic */ BaseResultData parseData(String str) {
                return cX(str);
            }
        }.request(new p<com.kwad.sdk.core.webview.request.a, WebCardGetDataResponse>() { // from class: com.kwad.sdk.core.webview.request.b.2
            /* JADX INFO: Access modifiers changed from: private */
            @Override // com.kwad.sdk.core.network.p, com.kwad.sdk.core.network.h
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public void onStartRequest(@NonNull com.kwad.sdk.core.webview.request.a aVar3) {
                super.onStartRequest(aVar3);
                com.kwad.sdk.core.d.b.d("WebCardGetDataRequestManager", "onStartRequest");
                b.mHandler.post(new Runnable() { // from class: com.kwad.sdk.core.webview.request.b.2.1
                    @Override // java.lang.Runnable
                    public final void run() {
                    }
                });
            }

            private void b(@NonNull final WebCardGetDataResponse webCardGetDataResponse) {
                com.kwad.sdk.core.d.b.d("WebCardGetDataRequestManager", "onSuccess");
                b.mHandler.post(new Runnable() { // from class: com.kwad.sdk.core.webview.request.b.2.2
                    @Override // java.lang.Runnable
                    public final void run() {
                        aVar2.a(webCardGetDataResponse);
                    }
                });
            }

            private void j(final int i2, final String str) {
                com.kwad.sdk.core.d.b.d("WebCardGetDataRequestManager", "onError errorCode=" + i2 + " errorMsg=" + str);
                b.mHandler.post(new Runnable() { // from class: com.kwad.sdk.core.webview.request.b.2.3
                    @Override // java.lang.Runnable
                    public final void run() {
                        com.kwad.sdk.core.d.b.d("WebCardGetDataRequestManager", "load onError:" + String.format("code:%s__msg:%s", Integer.valueOf(i2), str));
                        aVar2.onError(i2, str);
                    }
                });
            }

            @Override // com.kwad.sdk.core.network.p, com.kwad.sdk.core.network.h
            public final /* synthetic */ void onError(@NonNull g gVar, int i2, String str) {
                j(i2, str);
            }

            @Override // com.kwad.sdk.core.network.p, com.kwad.sdk.core.network.h
            public final /* synthetic */ void onSuccess(@NonNull g gVar, @NonNull BaseResultData baseResultData) {
                b((WebCardGetDataResponse) baseResultData);
            }
        });
    }
}
