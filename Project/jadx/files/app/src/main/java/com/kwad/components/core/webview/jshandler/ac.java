package com.kwad.components.core.webview.jshandler;

import androidx.annotation.NonNull;

/* JADX INFO: loaded from: classes3.dex */
public final class ac implements com.kwad.sdk.core.webview.b.a {
    private com.kwad.sdk.core.webview.b.c RZ;
    private c TN;

    public static final class a extends com.kwad.sdk.core.response.kwai.a implements com.kwad.sdk.core.b {
        public int status;
    }

    public interface b {
        void oO();
    }

    public interface c {
        void oS();
    }

    public ac(c cVar) {
        this.TN = cVar;
    }

    @Override // com.kwad.sdk.core.webview.b.a
    public final void a(String str, @NonNull com.kwad.sdk.core.webview.b.c cVar) {
        this.RZ = cVar;
        c cVar2 = this.TN;
        if (cVar2 != null) {
            cVar2.oS();
        }
    }

    @Override // com.kwad.sdk.core.webview.b.a
    @NonNull
    public final String getKey() {
        return "registerBackClickListener";
    }

    @Override // com.kwad.sdk.core.webview.b.a
    public final void onDestroy() {
        this.RZ = null;
    }

    public final void rq() {
        if (this.RZ != null) {
            a aVar = new a();
            aVar.status = 1;
            this.RZ.a(aVar);
        }
    }
}
