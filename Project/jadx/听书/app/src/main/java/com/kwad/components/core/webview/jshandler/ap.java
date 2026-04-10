package com.kwad.components.core.webview.jshandler;

import com.kwad.sdk.api.KsAppDownloadListener;
import com.kwad.sdk.core.response.model.AdTemplate;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
public final class ap implements com.kwad.sdk.core.webview.c.a {
    private final com.kwad.sdk.core.webview.b eQ;

    public static final class a extends com.kwad.sdk.core.response.a.a {
        public String adM;
    }

    public static final class b extends com.kwad.sdk.core.response.a.a {
        public double adT;
        public double adU;
        public long soFarBytes;
        public int status;
        public long totalBytes;
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final String getKey() {
        return "registerProgressListener";
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final void a(String str, com.kwad.sdk.core.webview.c.c cVar) {
        a aVar = new a();
        AdTemplate adTemplate = new AdTemplate();
        try {
            aVar.parseJson(new JSONObject(str));
            adTemplate.parseJson(new JSONObject(aVar.adM));
        } catch (Exception e) {
            com.kwad.sdk.core.d.c.printStackTraceOnly(e);
            adTemplate = null;
        }
        if (adTemplate == null || !com.kwad.sdk.core.response.b.e.ed(adTemplate) || this.eQ.aMO == null) {
            return;
        }
        com.kwad.components.core.e.d.c cVar2 = new com.kwad.components.core.e.d.c(adTemplate);
        String strPC = cVar2.pC();
        cVar2.b(aX(strPC));
        this.eQ.aMO.a(strPC, cVar2);
        this.eQ.aMO.b(strPC, cVar);
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final void onDestroy() {
        if (this.eQ.aMO != null) {
            this.eQ.aMO.release();
        }
    }

    private KsAppDownloadListener aX(String str) {
        return new com.kwad.sdk.core.download.a.a(str) { // from class: com.kwad.components.core.webview.jshandler.ap.1
            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public final void onIdle() {
                if (ap.this.eQ.aMO != null) {
                    ap.this.a(1, 0.0f, ap.this.eQ.aMO.ha(pC()));
                }
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public final void onProgressUpdate(int i) {
                if (ap.this.eQ.aMO != null) {
                    ap.this.a(2, (i * 1.0f) / 100.0f, ap.this.eQ.aMO.ha(pC()));
                }
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public final void onDownloadFinished() {
                if (ap.this.eQ.aMO != null) {
                    ap.this.a(5, 1.0f, ap.this.eQ.aMO.ha(pC()));
                }
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public final void onDownloadFailed() {
                if (ap.this.eQ.aMO != null) {
                    ap.this.a(1, 0.0f, ap.this.eQ.aMO.ha(pC()));
                }
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public final void onInstalled() {
                if (ap.this.eQ.aMO != null) {
                    ap.this.a(6, 1.0f, ap.this.eQ.aMO.ha(pC()));
                }
            }

            @Override // com.kwad.sdk.core.download.a.a
            public final void onPaused(int i) {
                if (ap.this.eQ.aMO != null) {
                    ap.this.a(3, (i * 1.0f) / 100.0f, ap.this.eQ.aMO.ha(pC()));
                }
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, float f, com.kwad.sdk.core.webview.c.c cVar) {
        if (cVar != null) {
            b bVar = new b();
            bVar.adT = f;
            bVar.status = i;
            bVar.totalBytes = com.kwad.sdk.core.response.b.e.el(this.eQ.getAdTemplate()).totalBytes;
            bVar.soFarBytes = com.kwad.sdk.core.response.b.e.el(this.eQ.getAdTemplate()).soFarBytes;
            if (bVar.totalBytes > 0) {
                bVar.adU = (bVar.soFarBytes * 1.0d) / bVar.totalBytes;
            } else {
                bVar.adU = 0.0d;
            }
            cVar.a(bVar);
        }
    }
}
