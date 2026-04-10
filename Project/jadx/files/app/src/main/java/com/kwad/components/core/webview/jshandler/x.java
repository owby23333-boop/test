package com.kwad.components.core.webview.jshandler;

import androidx.annotation.NonNull;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public final class x implements com.kwad.sdk.core.webview.b.a {
    private a TF;

    public interface a {
        void a(com.kwad.components.core.webview.kwai.b bVar);
    }

    public x(a aVar) {
        this.TF = aVar;
    }

    @Override // com.kwad.sdk.core.webview.b.a
    public final void a(String str, @NonNull com.kwad.sdk.core.webview.b.c cVar) {
        com.kwad.components.core.webview.kwai.b bVar = new com.kwad.components.core.webview.kwai.b();
        try {
            bVar.parseJson(new JSONObject(str));
            if (this.TF != null) {
                this.TF.a(bVar);
            }
        } catch (Exception e2) {
            cVar.onError(-1, "");
            com.kwad.sdk.core.d.b.printStackTrace(e2);
        }
    }

    @Override // com.kwad.sdk.core.webview.b.a
    @NonNull
    public final String getKey() {
        return "openNewPage";
    }

    @Override // com.kwad.sdk.core.webview.b.a
    public final void onDestroy() {
        this.TF = null;
    }
}
