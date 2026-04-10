package com.kwad.components.core.webview.jshandler;

import androidx.annotation.NonNull;
import com.kwad.sdk.api.KsAppDownloadListener;
import com.kwad.sdk.core.response.model.AdTemplate;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public final class w implements com.kwad.sdk.core.webview.b.a {
    private final com.kwad.sdk.core.webview.b mJsBridgeContext;

    public static final class a extends com.kwad.sdk.core.response.kwai.a {
        public String Tx;
    }

    public static final class b extends com.kwad.sdk.core.response.kwai.a {
        public double TE;
        public int status;
        public long totalBytes;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i2, float f2, com.kwad.sdk.core.webview.b.c cVar) {
        if (cVar != null) {
            b bVar = new b();
            bVar.TE = f2;
            bVar.status = i2;
            bVar.totalBytes = com.kwad.sdk.core.response.a.d.cb(this.mJsBridgeContext.getAdTemplate()).totalBytes;
            cVar.a(bVar);
        }
    }

    private KsAppDownloadListener aF(String str) {
        return new com.kwad.sdk.core.download.kwai.a(str) { // from class: com.kwad.components.core.webview.jshandler.w.1
            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public final void onDownloadFailed() {
                if (w.this.mJsBridgeContext.aoN != null) {
                    w.this.a(1, 0.0f, w.this.mJsBridgeContext.aoN.eo(nx()));
                }
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public final void onDownloadFinished() {
                if (w.this.mJsBridgeContext.aoN != null) {
                    w.this.a(5, 1.0f, w.this.mJsBridgeContext.aoN.eo(nx()));
                }
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public final void onIdle() {
                if (w.this.mJsBridgeContext.aoN != null) {
                    w.this.a(1, 0.0f, w.this.mJsBridgeContext.aoN.eo(nx()));
                }
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public final void onInstalled() {
                if (w.this.mJsBridgeContext.aoN != null) {
                    w.this.a(6, 1.0f, w.this.mJsBridgeContext.aoN.eo(nx()));
                }
            }

            @Override // com.kwad.sdk.core.download.kwai.a
            public final void onPaused(int i2) {
                if (w.this.mJsBridgeContext.aoN != null) {
                    w.this.a(3, (i2 * 1.0f) / 100.0f, w.this.mJsBridgeContext.aoN.eo(nx()));
                }
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public final void onProgressUpdate(int i2) {
                if (w.this.mJsBridgeContext.aoN != null) {
                    w.this.a(2, (i2 * 1.0f) / 100.0f, w.this.mJsBridgeContext.aoN.eo(nx()));
                }
            }
        };
    }

    @Override // com.kwad.sdk.core.webview.b.a
    public final void a(String str, @NonNull com.kwad.sdk.core.webview.b.c cVar) {
        a aVar = new a();
        AdTemplate adTemplate = new AdTemplate();
        try {
            aVar.parseJson(new JSONObject(str));
            adTemplate.parseJson(new JSONObject(aVar.Tx));
        } catch (Exception e2) {
            adTemplate = null;
            com.kwad.sdk.core.d.b.printStackTraceOnly(e2);
        }
        if (adTemplate == null || !com.kwad.sdk.core.response.a.d.bT(adTemplate) || this.mJsBridgeContext.aoN == null) {
            return;
        }
        com.kwad.components.core.d.b.c cVar2 = new com.kwad.components.core.d.b.c(adTemplate);
        String strNx = cVar2.nx();
        cVar2.b(aF(strNx));
        this.mJsBridgeContext.aoN.a(strNx, cVar2);
        this.mJsBridgeContext.aoN.b(strNx, cVar);
    }

    @Override // com.kwad.sdk.core.webview.b.a
    @NonNull
    public final String getKey() {
        return "registerProgressListener";
    }

    @Override // com.kwad.sdk.core.webview.b.a
    public final void onDestroy() {
        com.kwad.sdk.utils.ae aeVar = this.mJsBridgeContext.aoN;
        if (aeVar != null) {
            aeVar.release();
        }
    }
}
