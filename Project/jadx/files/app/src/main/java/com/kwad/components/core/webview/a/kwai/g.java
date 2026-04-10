package com.kwad.components.core.webview.a.kwai;

import androidx.annotation.NonNull;

/* JADX INFO: loaded from: classes3.dex */
public final class g implements com.kwad.sdk.core.webview.b.a {
    private com.kwad.components.core.webview.a.a.j Uw;

    public g(com.kwad.components.core.webview.a.a.j jVar) {
        this.Uw = jVar;
    }

    @Override // com.kwad.sdk.core.webview.b.a
    public final void a(String str, @NonNull com.kwad.sdk.core.webview.b.c cVar) {
        com.kwad.components.core.webview.a.a.j jVar = this.Uw;
        if (jVar != null) {
            cVar.a(jVar);
        }
    }

    @Override // com.kwad.sdk.core.webview.b.a
    @NonNull
    public final String getKey() {
        return "getKsAdExtraData";
    }

    @Override // com.kwad.sdk.core.webview.b.a
    public final void onDestroy() {
    }
}
