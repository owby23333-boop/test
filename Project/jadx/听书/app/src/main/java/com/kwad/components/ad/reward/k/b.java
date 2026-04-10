package com.kwad.components.ad.reward.k;

/* JADX INFO: loaded from: classes3.dex */
public class b implements com.kwad.sdk.core.webview.c.a {
    private a Aw;

    public interface a {
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final String getKey() {
        return "callButtonImpressionWhenFinish";
    }

    public void kh() {
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final void a(String str, com.kwad.sdk.core.webview.c.c cVar) {
        kh();
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final void onDestroy() {
        this.Aw = null;
    }
}
