package com.kwad.sdk.core.webview.b;

import androidx.annotation.NonNull;

/* JADX INFO: loaded from: classes3.dex */
public final class d implements a {
    @Override // com.kwad.sdk.core.webview.b.a
    public final void a(String str, @NonNull c cVar) {
        cVar.onError(-1, "DefaultHandler response data");
    }

    @Override // com.kwad.sdk.core.webview.b.a
    @NonNull
    public final String getKey() {
        return "";
    }

    @Override // com.kwad.sdk.core.webview.b.a
    public final void onDestroy() {
    }
}
