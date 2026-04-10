package com.kwad.components.core.webview.a.kwai;

import androidx.annotation.NonNull;

/* JADX INFO: loaded from: classes3.dex */
public final class f implements com.kwad.sdk.core.webview.b.a {
    @Override // com.kwad.sdk.core.webview.b.a
    public final void a(String str, @NonNull com.kwad.sdk.core.webview.b.c cVar) {
        cVar.a(com.kwad.sdk.core.config.d.uG());
    }

    @Override // com.kwad.sdk.core.webview.b.a
    @NonNull
    public final String getKey() {
        return "getKsAdConfig";
    }

    @Override // com.kwad.sdk.core.webview.b.a
    public final void onDestroy() {
    }
}
