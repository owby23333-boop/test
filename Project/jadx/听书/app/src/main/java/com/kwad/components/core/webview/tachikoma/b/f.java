package com.kwad.components.core.webview.tachikoma.b;

/* JADX INFO: loaded from: classes4.dex */
public final class f implements com.kwad.sdk.core.webview.c.a {
    @Override // com.kwad.sdk.core.webview.c.a
    public final String getKey() {
        return "getKsAdConfig";
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final void onDestroy() {
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final void a(String str, com.kwad.sdk.core.webview.c.c cVar) {
        cVar.a(com.kwad.sdk.core.config.e.Fw());
    }
}
