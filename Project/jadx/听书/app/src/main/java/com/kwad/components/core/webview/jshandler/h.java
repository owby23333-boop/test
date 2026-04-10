package com.kwad.components.core.webview.jshandler;

/* JADX INFO: loaded from: classes4.dex */
public final class h implements com.kwad.sdk.core.webview.c.a {
    private int Gm;
    private com.kwad.sdk.core.webview.c.c ack;

    public static class a extends com.kwad.sdk.core.response.a.a {
        public int loadType;
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final String getKey() {
        return "getLoadInfo";
    }

    public h(int i) {
        this.Gm = i;
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final void a(String str, com.kwad.sdk.core.webview.c.c cVar) {
        this.ack = cVar;
        be(this.Gm);
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final void onDestroy() {
        this.ack = null;
    }

    private void be(int i) {
        if (this.ack == null) {
            return;
        }
        a aVar = new a();
        aVar.loadType = i;
        this.ack.a(aVar);
    }
}
