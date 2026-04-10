package com.kwad.components.ad.reward.h;

import androidx.annotation.NonNull;

/* JADX INFO: loaded from: classes3.dex */
public final class g implements com.kwad.sdk.core.webview.b.a {
    private a xs;

    public interface a {
        void jk();
    }

    public g(a aVar) {
        this.xs = aVar;
    }

    @Override // com.kwad.sdk.core.webview.b.a
    public final void a(String str, @NonNull com.kwad.sdk.core.webview.b.c cVar) {
        a aVar = this.xs;
        if (aVar != null) {
            aVar.jk();
        }
    }

    @Override // com.kwad.sdk.core.webview.b.a
    @NonNull
    public final String getKey() {
        return "hasReward";
    }

    @Override // com.kwad.sdk.core.webview.b.a
    public final void onDestroy() {
        this.xs = null;
    }
}
