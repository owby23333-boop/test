package com.kwad.components.ad.reward.h;

import androidx.annotation.NonNull;

/* JADX INFO: loaded from: classes3.dex */
public final class f implements com.kwad.sdk.core.webview.b.a {
    private int xr;

    public f(int i2) {
        this.xr = i2;
    }

    @Override // com.kwad.sdk.core.webview.b.a
    public final void a(String str, @NonNull com.kwad.sdk.core.webview.b.c cVar) {
        com.kwad.components.core.webview.a.a.f fVar = new com.kwad.components.core.webview.a.a.f();
        fVar.UR = this.xr;
        cVar.a(fVar);
    }

    @Override // com.kwad.sdk.core.webview.b.a
    @NonNull
    public final String getKey() {
        return "getCloseDelaySeconds";
    }

    @Override // com.kwad.sdk.core.webview.b.a
    public final void onDestroy() {
    }
}
