package com.kwad.components.core.webview.a.kwai;

import androidx.annotation.NonNull;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public final class s implements com.kwad.sdk.core.webview.b.a {
    private a UD;

    public interface a {
        void a(com.kwad.components.core.webview.a.a.r rVar);
    }

    public final void a(a aVar) {
        this.UD = aVar;
    }

    @Override // com.kwad.sdk.core.webview.b.a
    public final void a(String str, @NonNull com.kwad.sdk.core.webview.b.c cVar) {
        if (this.UD != null) {
            com.kwad.components.core.webview.a.a.r rVar = new com.kwad.components.core.webview.a.a.r();
            try {
                rVar.parseJson(new JSONObject(str));
                this.UD.a(rVar);
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
        }
    }

    @Override // com.kwad.sdk.core.webview.b.a
    @NonNull
    public final String getKey() {
        return "showToast";
    }

    @Override // com.kwad.sdk.core.webview.b.a
    public final void onDestroy() {
        this.UD = null;
    }
}
