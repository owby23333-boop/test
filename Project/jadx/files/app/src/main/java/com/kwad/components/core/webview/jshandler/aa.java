package com.kwad.components.core.webview.jshandler;

import androidx.annotation.NonNull;

/* JADX INFO: loaded from: classes3.dex */
public final class aa implements com.kwad.sdk.core.webview.b.a {
    private com.kwad.sdk.core.webview.b.c RZ;
    private a TI = new a();

    public class a extends com.kwad.sdk.core.response.kwai.a implements com.kwad.sdk.core.b {
        public int id;
        public int status;

        public a() {
        }
    }

    private void o(int i2, int i3) {
        com.kwad.sdk.core.webview.b.c cVar = this.RZ;
        if (cVar != null) {
            a aVar = this.TI;
            aVar.id = i2;
            aVar.status = 2;
            cVar.a(aVar);
        }
    }

    @Override // com.kwad.sdk.core.webview.b.a
    public final void a(String str, @NonNull com.kwad.sdk.core.webview.b.c cVar) {
        this.RZ = cVar;
    }

    public final void aL(int i2) {
        o(1, 2);
    }

    @Override // com.kwad.sdk.core.webview.b.a
    @NonNull
    public final String getKey() {
        return "registerAnimationListener";
    }

    @Override // com.kwad.sdk.core.webview.b.a
    public final void onDestroy() {
        this.RZ = null;
    }
}
