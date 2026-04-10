package com.kwad.components.core.webview.a.kwai;

import androidx.annotation.NonNull;

/* JADX INFO: loaded from: classes3.dex */
public class o extends v {
    private a UC;

    public interface a {
        boolean isMuted();
    }

    public final void a(a aVar) {
        this.UC = aVar;
    }

    @Override // com.kwad.components.core.webview.a.kwai.v, com.kwad.sdk.core.webview.b.a
    public void a(String str, @NonNull com.kwad.sdk.core.webview.b.c cVar) {
        super.a(str, cVar);
        if (this.UC != null) {
            com.kwad.components.core.webview.a.a.k kVar = new com.kwad.components.core.webview.a.a.k();
            kVar.UW = this.UC.isMuted();
            cVar.a(kVar);
        }
    }

    public final void b(com.kwad.components.core.webview.a.a.k kVar) {
        super.b((com.kwad.sdk.core.b) kVar);
    }

    @Override // com.kwad.sdk.core.webview.b.a
    @NonNull
    public final String getKey() {
        return "registerMuteStateListener";
    }
}
