package com.kwad.components.core.webview.jshandler;

/* JADX INFO: loaded from: classes4.dex */
public final class g implements com.kwad.sdk.core.webview.c.a {
    private com.kwad.sdk.core.webview.c.c ack;
    private int oS;
    private int oT;

    public static class a extends com.kwad.sdk.core.response.a.a {
        public int showLiveStatus;
        public int showLiveStyle;
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final String getKey() {
        return "getLiveInfo";
    }

    public g(int i, int i2) {
        this.oS = i;
        this.oT = i2;
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final void a(String str, com.kwad.sdk.core.webview.c.c cVar) {
        this.ack = cVar;
        r(this.oS, this.oT);
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final void onDestroy() {
        this.ack = null;
    }

    private void r(int i, int i2) {
        if (this.ack == null) {
            return;
        }
        a aVar = new a();
        aVar.showLiveStatus = i;
        aVar.showLiveStyle = i2;
        this.ack.a(aVar);
    }
}
