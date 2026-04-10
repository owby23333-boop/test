package com.kwad.components.ad.reward.k;

/* JADX INFO: loaded from: classes3.dex */
public final class e implements com.kwad.sdk.core.webview.c.a {
    private a Az;

    public interface a {
        void kg();
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final String getKey() {
        return "clickGift";
    }

    public final void a(a aVar) {
        this.Az = aVar;
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final void a(String str, com.kwad.sdk.core.webview.c.c cVar) {
        a aVar = this.Az;
        if (aVar != null) {
            aVar.kg();
        }
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final void onDestroy() {
        this.Az = null;
    }
}
