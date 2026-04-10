package com.kwad.components.ad.reward.k;

/* JADX INFO: loaded from: classes3.dex */
public final class g implements com.kwad.sdk.core.webview.c.a {
    private int AE;

    @Override // com.kwad.sdk.core.webview.c.a
    public final String getKey() {
        return "getCloseDelaySeconds";
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final void onDestroy() {
    }

    public g(int i) {
        this.AE = i;
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final void a(String str, com.kwad.sdk.core.webview.c.c cVar) {
        com.kwad.components.core.webview.tachikoma.c.f fVar = new com.kwad.components.core.webview.tachikoma.c.f();
        fVar.agX = this.AE;
        cVar.a(fVar);
    }
}
