package com.kwad.components.core.webview.a.kwai;

import androidx.annotation.NonNull;

/* JADX INFO: loaded from: classes3.dex */
public final class m extends v {
    @Override // com.kwad.components.core.webview.a.kwai.v, com.kwad.sdk.core.webview.b.a
    public final void a(String str, @NonNull com.kwad.sdk.core.webview.b.c cVar) {
        super.a(str, cVar);
    }

    public final void aN(int i2) {
        com.kwad.components.core.webview.a.a.t tVar = new com.kwad.components.core.webview.a.a.t();
        tVar.nW = i2;
        super.b(tVar);
    }

    @Override // com.kwad.sdk.core.webview.b.a
    @NonNull
    public final String getKey() {
        return "registerSplashProgressListener";
    }
}
