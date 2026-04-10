package com.kwad.components.core.webview.a.kwai;

import androidx.annotation.NonNull;

/* JADX INFO: loaded from: classes3.dex */
public final class h extends v {
    private a Ux;

    public interface a {
        void a(h hVar);
    }

    public static class b extends com.kwad.sdk.core.response.kwai.a {
        public int Uy;
    }

    public final void a(a aVar) {
        this.Ux = aVar;
    }

    @Override // com.kwad.components.core.webview.a.kwai.v, com.kwad.sdk.core.webview.b.a
    public final void a(String str, @NonNull com.kwad.sdk.core.webview.b.c cVar) {
        super.a(str, cVar);
        a aVar = this.Ux;
        if (aVar != null) {
            aVar.a(this);
        }
    }

    public final void aL(boolean z2) {
        int i2 = z2 ? 1 : 2;
        b bVar = new b();
        bVar.Uy = i2;
        b(bVar);
    }

    @Override // com.kwad.sdk.core.webview.b.a
    @NonNull
    public final String getKey() {
        return "getPlayEndType";
    }

    @Override // com.kwad.components.core.webview.a.kwai.v, com.kwad.sdk.core.webview.b.a
    public final void onDestroy() {
        super.onDestroy();
        this.Ux = null;
    }
}
