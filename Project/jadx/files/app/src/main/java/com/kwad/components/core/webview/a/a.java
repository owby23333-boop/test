package com.kwad.components.core.webview.a;

import androidx.annotation.NonNull;

/* JADX INFO: loaded from: classes3.dex */
public final class a implements com.kwad.sdk.core.webview.b.a {
    private InterfaceC0411a Um;

    /* JADX INFO: renamed from: com.kwad.components.core.webview.a.a$a, reason: collision with other inner class name */
    public interface InterfaceC0411a {
        void es();
    }

    public a(InterfaceC0411a interfaceC0411a) {
        this.Um = interfaceC0411a;
    }

    @Override // com.kwad.sdk.core.webview.b.a
    public final void a(String str, @NonNull com.kwad.sdk.core.webview.b.c cVar) {
        InterfaceC0411a interfaceC0411a = this.Um;
        if (interfaceC0411a != null) {
            interfaceC0411a.es();
        }
    }

    @Override // com.kwad.sdk.core.webview.b.a
    @NonNull
    public final String getKey() {
        return "cardImpression";
    }

    @Override // com.kwad.sdk.core.webview.b.a
    public final void onDestroy() {
    }
}
