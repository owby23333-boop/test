package com.kwad.components.core.webview.tachikoma.b;

/* JADX INFO: loaded from: classes4.dex */
public final class g implements com.kwad.sdk.core.webview.c.a {
    private com.kwad.components.core.webview.tachikoma.c.l agw;

    @Override // com.kwad.sdk.core.webview.c.a
    public final String getKey() {
        return "getKsAdExtraData";
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final void onDestroy() {
    }

    public g(com.kwad.components.core.webview.tachikoma.c.l lVar) {
        this.agw = lVar;
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final void a(String str, com.kwad.sdk.core.webview.c.c cVar) {
        com.kwad.components.core.webview.tachikoma.c.l lVar = this.agw;
        if (lVar != null) {
            cVar.a(lVar);
        }
    }
}
