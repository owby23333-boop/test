package com.kwad.components.core.webview.jshandler;

/* JADX INFO: loaded from: classes4.dex */
public final class at implements com.kwad.sdk.core.webview.c.a {
    private com.kwad.sdk.core.webview.c.c ack;
    private a adY = new a();

    @Override // com.kwad.sdk.core.webview.c.a
    public final String getKey() {
        return "registerAnimationListener";
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final void a(String str, com.kwad.sdk.core.webview.c.c cVar) {
        this.ack = cVar;
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final void onDestroy() {
        this.ack = null;
    }

    public final void bf(int i) {
        s(1, 2);
    }

    private void s(int i, int i2) {
        if (this.ack != null) {
            this.adY.id = i;
            this.adY.status = 2;
            this.ack.a(this.adY);
        }
    }

    public class a extends com.kwad.sdk.core.response.a.a implements com.kwad.sdk.core.b {
        public int id;
        public int status;

        public a() {
        }
    }
}
