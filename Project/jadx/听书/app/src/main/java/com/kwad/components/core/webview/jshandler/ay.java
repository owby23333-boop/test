package com.kwad.components.core.webview.jshandler;

/* JADX INFO: loaded from: classes4.dex */
public final class ay implements com.kwad.sdk.core.webview.c.a {
    private com.kwad.sdk.core.webview.c.c ack;

    public static final class a extends com.kwad.sdk.core.response.a.a implements com.kwad.sdk.core.b {
        public String aeg;
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final String getKey() {
        return "registerFocusListener";
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final void a(String str, com.kwad.sdk.core.webview.c.c cVar) {
        this.ack = cVar;
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final void onDestroy() {
        this.ack = null;
    }

    public final void aX(boolean z) {
        if (z) {
            aY("windowFocusGet");
        } else {
            aY("windowFocusLost");
        }
    }

    private void aY(String str) {
        if (this.ack != null) {
            a aVar = new a();
            aVar.aeg = str;
            this.ack.a(aVar);
        }
    }
}
