package com.kwad.components.core.webview.tachikoma.b;

/* JADX INFO: loaded from: classes4.dex */
public final class o extends w {
    private a agE;

    /* JADX INFO: loaded from: classes3.dex */
    public interface a {
        boolean isMuted();
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final String getKey() {
        return "registerMuteStateListener";
    }

    public final void a(a aVar) {
        this.agE = aVar;
    }

    public final void c(com.kwad.components.core.webview.tachikoma.c.n nVar) {
        super.b(nVar);
    }

    @Override // com.kwad.components.core.webview.tachikoma.b.w, com.kwad.sdk.core.webview.c.a
    public final void a(String str, com.kwad.sdk.core.webview.c.c cVar) {
        super.a(str, cVar);
        if (this.agE != null) {
            com.kwad.components.core.webview.tachikoma.c.n nVar = new com.kwad.components.core.webview.tachikoma.c.n();
            nVar.ahg = this.agE.isMuted();
            cVar.a(nVar);
        }
    }
}
