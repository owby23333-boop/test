package com.kwad.components.core.webview.jshandler;

import com.kwad.sdk.utils.bw;

/* JADX INFO: loaded from: classes4.dex */
public final class bh implements com.kwad.sdk.core.webview.c.a {
    private a aex;

    public interface a {
        void ut();
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final String getKey() {
        return "showDownloadTips";
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final void onDestroy() {
    }

    public bh(a aVar) {
        this.aex = aVar;
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final void a(String str, com.kwad.sdk.core.webview.c.c cVar) {
        uL();
    }

    private void uL() {
        if (com.kwad.components.core.e.c.b.oW()) {
            return;
        }
        bw.runOnUiThread(new com.kwad.sdk.utils.bg() { // from class: com.kwad.components.core.webview.jshandler.bh.1
            @Override // com.kwad.sdk.utils.bg
            public final void doTask() {
                if (bh.this.aex != null) {
                    bh.this.aex.ut();
                }
            }
        });
    }
}
