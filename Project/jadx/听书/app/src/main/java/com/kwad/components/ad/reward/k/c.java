package com.kwad.components.ad.reward.k;

/* JADX INFO: loaded from: classes3.dex */
public class c implements com.kwad.sdk.core.webview.c.a {
    private a Ax;

    public interface a {
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final String getKey() {
        return "callButtonImpressionWhenPlay";
    }

    public void kh() {
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final void a(String str, com.kwad.sdk.core.webview.c.c cVar) {
        kh();
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final void onDestroy() {
        this.Ax = null;
    }
}
