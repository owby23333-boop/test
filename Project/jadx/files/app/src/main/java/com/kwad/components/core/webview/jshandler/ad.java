package com.kwad.components.core.webview.jshandler;

import androidx.annotation.NonNull;

/* JADX INFO: loaded from: classes3.dex */
public final class ad implements com.kwad.sdk.core.webview.b.a {
    private com.kwad.sdk.core.webview.b.c RZ;

    @Override // com.kwad.sdk.core.webview.b.a
    public final void a(String str, @NonNull com.kwad.sdk.core.webview.b.c cVar) {
        this.RZ = cVar;
    }

    @Override // com.kwad.sdk.core.webview.b.a
    @NonNull
    public final String getKey() {
        return "registerDeeplinkListener";
    }

    @Override // com.kwad.sdk.core.webview.b.a
    public final void onDestroy() {
        this.RZ = null;
    }

    public final void onFailed() {
        com.kwad.sdk.core.webview.b.c cVar = this.RZ;
        if (cVar != null) {
            cVar.onError(-1, "deep link error");
        }
    }

    public final void onSuccess() {
        com.kwad.sdk.core.webview.b.c cVar = this.RZ;
        if (cVar != null) {
            cVar.a(null);
        }
    }
}
