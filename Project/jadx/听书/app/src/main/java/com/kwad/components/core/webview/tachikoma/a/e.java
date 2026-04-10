package com.kwad.components.core.webview.tachikoma.a;

import com.kwad.components.core.webview.jshandler.bc;
import com.kwad.sdk.api.KsAppDownloadListener;
import com.kwad.sdk.components.o;

/* JADX INFO: loaded from: classes4.dex */
public final class e {
    private KsAppDownloadListener abU;
    private KsAppDownloadListener aen;
    private o afJ;
    private com.kwad.sdk.core.webview.b eQ;
    private com.kwad.components.core.e.d.c mApkDownloadHelper;

    public e(com.kwad.components.core.e.d.c cVar, com.kwad.sdk.core.webview.b bVar, o oVar) {
        this.eQ = bVar;
        this.mApkDownloadHelper = cVar;
        this.afJ = oVar;
        if (cVar != null) {
            KsAppDownloadListener ksAppDownloadListener = this.abU;
            if (ksAppDownloadListener == null) {
                KsAppDownloadListener ksAppDownloadListenerUz = uz();
                this.abU = ksAppDownloadListenerUz;
                this.mApkDownloadHelper.b(ksAppDownloadListenerUz);
                return;
            }
            cVar.d(ksAppDownloadListener);
        }
    }

    private KsAppDownloadListener uz() {
        return new com.kwad.sdk.core.download.a.a() { // from class: com.kwad.components.core.webview.tachikoma.a.e.1
            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public final void onIdle() {
                e.this.a(1, 0.0f);
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public final void onProgressUpdate(int i) {
                e.this.a(2, (i * 1.0f) / 100.0f);
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public final void onDownloadFinished() {
                e.this.a(5, 1.0f);
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public final void onDownloadFailed() {
                e.this.a(1, 0.0f);
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public final void onInstalled() {
                e.this.a(6, 1.0f);
                if (e.this.aen != null) {
                    e.this.aen.onInstalled();
                }
            }

            @Override // com.kwad.sdk.core.download.a.a
            public final void onPaused(int i) {
                e.this.a(3, (i * 1.0f) / 100.0f);
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, float f) {
        bc.a aVar = new bc.a();
        aVar.aep = f;
        aVar.status = i;
        aVar.totalBytes = com.kwad.sdk.core.response.b.e.el(this.eQ.getAdTemplate()).totalBytes;
        aVar.soFarBytes = com.kwad.sdk.core.response.b.e.el(this.eQ.getAdTemplate()).soFarBytes;
        if (aVar.totalBytes > 0) {
            aVar.aeq = (aVar.soFarBytes * 1.0f) / aVar.totalBytes;
        } else {
            aVar.aeq = 0.0f;
        }
        this.afJ.setDownloadProgress(aVar.toJson().toString());
    }
}
