package com.kwad.sdk.core.webview.c;

/* JADX INFO: loaded from: classes4.dex */
public final class d implements a {
    @Override // com.kwad.sdk.core.webview.c.a
    public final String getKey() {
        return "";
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final void onDestroy() {
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final void a(String str, c cVar) {
        cVar.onError(-1, "DefaultHandler response data");
    }
}
