package com.kwad.components.core.webview.jshandler;

/* JADX INFO: loaded from: classes4.dex */
public final class av implements com.kwad.sdk.core.webview.c.a {
    private com.kwad.sdk.core.webview.c.c ack;
    private b aec;

    public static final class a extends com.kwad.sdk.core.response.a.a implements com.kwad.sdk.core.b {
        public int status;
    }

    /* JADX INFO: loaded from: classes3.dex */
    public interface b {
        void rv();
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final String getKey() {
        return "registerBackClickListener";
    }

    public av(b bVar) {
        this.aec = bVar;
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final void a(String str, com.kwad.sdk.core.webview.c.c cVar) {
        this.ack = cVar;
        b bVar = this.aec;
        if (bVar != null) {
            bVar.rv();
        }
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final void onDestroy() {
        this.ack = null;
    }

    public final void uE() {
        if (this.ack != null) {
            a aVar = new a();
            aVar.status = 1;
            this.ack.a(aVar);
        }
    }
}
