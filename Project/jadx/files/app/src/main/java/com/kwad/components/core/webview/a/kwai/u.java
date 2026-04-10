package com.kwad.components.core.webview.a.kwai;

import androidx.annotation.NonNull;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public final class u implements com.kwad.sdk.core.webview.b.a {
    private a UF;

    public interface a {
        void a(com.kwad.components.core.webview.a.a.k kVar);
    }

    public final void a(a aVar) {
        this.UF = aVar;
    }

    @Override // com.kwad.sdk.core.webview.b.a
    public final void a(String str, @NonNull com.kwad.sdk.core.webview.b.c cVar) {
        if (this.UF != null) {
            com.kwad.components.core.webview.a.a.k kVar = new com.kwad.components.core.webview.a.a.k();
            try {
                kVar.parseJson(new JSONObject(str));
                this.UF.a(kVar);
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
        }
    }

    @Override // com.kwad.sdk.core.webview.b.a
    @NonNull
    public final String getKey() {
        return "updateVideoMuteState";
    }

    @Override // com.kwad.sdk.core.webview.b.a
    public final void onDestroy() {
        this.UF = null;
    }
}
