package com.kwad.components.core.webview.jshandler;

/* JADX INFO: loaded from: classes4.dex */
public final class aw implements com.kwad.sdk.core.webview.c.a {
    private com.kwad.sdk.core.webview.c.c ack;

    @Override // com.kwad.sdk.core.webview.c.a
    public final String getKey() {
        return "registerDeeplinkListener";
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final void a(String str, com.kwad.sdk.core.webview.c.c cVar) {
        this.ack = cVar;
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final void onDestroy() {
        this.ack = null;
    }

    public final void onSuccess() {
        com.kwad.sdk.core.webview.c.c cVar = this.ack;
        if (cVar != null) {
            cVar.a(null);
        }
    }

    public final void onFailed() {
        com.kwad.sdk.core.webview.c.c cVar = this.ack;
        if (cVar != null) {
            cVar.onError(-1, "deep link error");
        }
    }
}
