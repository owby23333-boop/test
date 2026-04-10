package com.kwad.components.core.webview.jshandler;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.app.NotificationCompat;
import com.kwad.sdk.api.KsAppDownloadListener;
import com.ss.android.socialbase.downloader.constants.DBDefinition;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public final class ah implements com.kwad.sdk.core.webview.b.a {

    @Nullable
    private KsAppDownloadListener RS;

    @Nullable
    private com.kwad.sdk.core.webview.b.c RZ;

    @Nullable
    private KsAppDownloadListener TV;
    private final com.kwad.components.core.d.b.c mApkDownloadHelper;
    private final com.kwad.sdk.core.webview.b mJsBridgeContext;

    public static final class a implements com.kwad.sdk.core.b {
        public float TX;
        public long creativeId;
        public int status;
        public long totalBytes;

        @Override // com.kwad.sdk.core.b
        public final void parseJson(@Nullable JSONObject jSONObject) {
        }

        @Override // com.kwad.sdk.core.b
        public final JSONObject toJson() {
            JSONObject jSONObject = new JSONObject();
            com.kwad.sdk.utils.s.putValue(jSONObject, NotificationCompat.CATEGORY_PROGRESS, this.TX);
            com.kwad.sdk.utils.s.putValue(jSONObject, "status", this.status);
            com.kwad.sdk.utils.s.putValue(jSONObject, DBDefinition.TOTAL_BYTES, this.totalBytes);
            com.kwad.sdk.utils.s.putValue(jSONObject, "creativeId", this.creativeId);
            return jSONObject;
        }
    }

    public ah(com.kwad.sdk.core.webview.b bVar, @Nullable com.kwad.components.core.d.b.c cVar) {
        this.mJsBridgeContext = bVar;
        this.mApkDownloadHelper = cVar;
    }

    public ah(com.kwad.sdk.core.webview.b bVar, @Nullable com.kwad.components.core.d.b.c cVar, @Nullable KsAppDownloadListener ksAppDownloadListener) {
        this.mJsBridgeContext = bVar;
        this.mApkDownloadHelper = cVar;
        this.TV = ksAppDownloadListener;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i2, float f2) {
        if (this.RZ != null) {
            a aVar = new a();
            aVar.TX = f2;
            aVar.status = i2;
            aVar.totalBytes = com.kwad.sdk.core.response.a.d.cb(this.mJsBridgeContext.getAdTemplate()).totalBytes;
            this.RZ.a(aVar);
        }
    }

    private KsAppDownloadListener rm() {
        return new com.kwad.sdk.core.download.kwai.a() { // from class: com.kwad.components.core.webview.jshandler.ah.1
            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public final void onDownloadFailed() {
                ah.this.a(1, 0.0f);
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public final void onDownloadFinished() {
                ah.this.a(5, 1.0f);
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public final void onIdle() {
                ah.this.a(1, 0.0f);
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public final void onInstalled() {
                ah.this.a(6, 1.0f);
                if (ah.this.TV != null) {
                    ah.this.TV.onInstalled();
                }
            }

            @Override // com.kwad.sdk.core.download.kwai.a
            public final void onPaused(int i2) {
                ah.this.a(3, (i2 * 1.0f) / 100.0f);
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public final void onProgressUpdate(int i2) {
                ah.this.a(2, (i2 * 1.0f) / 100.0f);
            }
        };
    }

    @Override // com.kwad.sdk.core.webview.b.a
    public final void a(String str, @NonNull com.kwad.sdk.core.webview.b.c cVar) {
        if (this.mJsBridgeContext.zf()) {
            cVar.onError(-1, "native photo is null");
            return;
        }
        this.RZ = cVar;
        com.kwad.components.core.d.b.c cVar2 = this.mApkDownloadHelper;
        if (cVar2 != null) {
            KsAppDownloadListener ksAppDownloadListener = this.RS;
            if (ksAppDownloadListener != null) {
                cVar2.d(ksAppDownloadListener);
            } else {
                this.RS = rm();
                this.mApkDownloadHelper.b(this.RS);
            }
        }
    }

    @Override // com.kwad.sdk.core.webview.b.a
    @NonNull
    public final String getKey() {
        return "registerProgressListener";
    }

    @Override // com.kwad.sdk.core.webview.b.a
    public final void onDestroy() {
        KsAppDownloadListener ksAppDownloadListener;
        this.RZ = null;
        com.kwad.components.core.d.b.c cVar = this.mApkDownloadHelper;
        if (cVar == null || (ksAppDownloadListener = this.RS) == null) {
            return;
        }
        cVar.c(ksAppDownloadListener);
        this.RS = null;
    }
}
