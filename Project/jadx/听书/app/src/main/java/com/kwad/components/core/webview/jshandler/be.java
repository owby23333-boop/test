package com.kwad.components.core.webview.jshandler;

/* JADX INFO: loaded from: classes4.dex */
public final class be implements com.kwad.sdk.core.webview.c.a {
    private com.kwad.sdk.core.webview.c.c ack;
    private a aes = new a();

    public static final class a extends com.kwad.sdk.core.response.a.a implements com.kwad.sdk.core.b {
        public int status;
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final String getKey() {
        return "registerVideoListener";
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final void a(String str, com.kwad.sdk.core.webview.c.c cVar) {
        this.ack = cVar;
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final void onDestroy() {
        this.ack = null;
    }

    public final void bg(int i) {
        if (this.ack != null) {
            this.aes.status = i;
            this.ack.a(this.aes);
        }
    }
}
