package com.kwad.components.core.webview.tachikoma;

/* JADX INFO: loaded from: classes4.dex */
public final class b implements com.kwad.sdk.core.webview.c.a {
    private a aeP;

    /* JADX INFO: loaded from: classes3.dex */
    public interface a {
        void eN();
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final String getKey() {
        return "cardImpression";
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final void onDestroy() {
    }

    public b(a aVar) {
        this.aeP = aVar;
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final void a(String str, com.kwad.sdk.core.webview.c.c cVar) {
        a aVar = this.aeP;
        if (aVar != null) {
            aVar.eN();
        }
    }
}
