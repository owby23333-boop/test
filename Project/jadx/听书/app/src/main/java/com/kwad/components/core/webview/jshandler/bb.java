package com.kwad.components.core.webview.jshandler;

import com.kwad.sdk.utils.bw;

/* JADX INFO: loaded from: classes4.dex */
public final class bb implements com.kwad.sdk.core.webview.c.a {
    private final a ael;

    /* JADX INFO: loaded from: classes3.dex */
    public interface a {
        void cL();
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final String getKey() {
        return "registerMotionListener";
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final void onDestroy() {
    }

    public bb(a aVar) {
        this.ael = aVar;
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final void a(String str, final com.kwad.sdk.core.webview.c.c cVar) {
        bw.runOnUiThread(new com.kwad.sdk.utils.bg() { // from class: com.kwad.components.core.webview.jshandler.bb.1
            @Override // com.kwad.sdk.utils.bg
            public final void doTask() {
                if (bb.this.ael != null) {
                    bb.this.ael.cL();
                }
                cVar.a(null);
            }
        });
    }
}
