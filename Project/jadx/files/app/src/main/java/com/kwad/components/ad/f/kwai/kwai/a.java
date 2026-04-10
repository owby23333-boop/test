package com.kwad.components.ad.f.kwai.kwai;

import androidx.annotation.NonNull;
import com.kwad.sdk.core.webview.b.c;

/* JADX INFO: loaded from: classes2.dex */
public final class a implements com.kwad.sdk.core.webview.b.a {
    private c nK;

    @Override // com.kwad.sdk.core.webview.b.a
    public final void a(String str, @NonNull c cVar) {
        this.nK = cVar;
    }

    public final void fb() {
        c cVar = this.nK;
        if (cVar != null) {
            cVar.a(null);
        }
    }

    @Override // com.kwad.sdk.core.webview.b.a
    @NonNull
    public final String getKey() {
        return "registerPlayStateResetListener";
    }

    @Override // com.kwad.sdk.core.webview.b.a
    public final void onDestroy() {
        this.nK = null;
    }
}
