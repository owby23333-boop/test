package com.kwad.components.ad.reward.h;

import androidx.annotation.NonNull;

/* JADX INFO: loaded from: classes3.dex */
public final class d implements com.kwad.sdk.core.webview.b.a {
    private a xp;

    public interface a {
        void jk();
    }

    public final void a(a aVar) {
        this.xp = aVar;
    }

    @Override // com.kwad.sdk.core.webview.b.a
    public final void a(String str, @NonNull com.kwad.sdk.core.webview.b.c cVar) {
        a aVar = this.xp;
        if (aVar != null) {
            aVar.jk();
        }
    }

    @Override // com.kwad.sdk.core.webview.b.a
    @NonNull
    public final String getKey() {
        return "clickGift";
    }

    @Override // com.kwad.sdk.core.webview.b.a
    public final void onDestroy() {
        this.xp = null;
    }
}
