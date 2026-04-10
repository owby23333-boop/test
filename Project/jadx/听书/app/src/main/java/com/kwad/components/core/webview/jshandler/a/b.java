package com.kwad.components.core.webview.jshandler.a;

import com.kwad.sdk.utils.bw;

/* JADX INFO: loaded from: classes4.dex */
public final class b implements com.kwad.sdk.core.webview.c.a {
    private c abQ;

    @Override // com.kwad.sdk.core.webview.c.a
    public final String getKey() {
        return "exitWebView";
    }

    public b(c cVar) {
        this.abQ = cVar;
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final void a(String str, com.kwad.sdk.core.webview.c.c cVar) {
        bw.runOnUiThread(new Runnable() { // from class: com.kwad.components.core.webview.jshandler.a.b.1
            @Override // java.lang.Runnable
            public final void run() {
                if (b.this.abQ != null) {
                    b.this.abQ.rq();
                }
            }
        });
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final void onDestroy() {
        this.abQ = null;
    }
}
