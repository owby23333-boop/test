package com.kwad.components.core.webview.tachikoma.b;

import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
public final class s implements com.kwad.sdk.core.webview.c.a {
    private a agF;

    public interface a {
        void a(com.kwad.components.core.webview.tachikoma.c.t tVar);
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final String getKey() {
        return "showToast";
    }

    public final void a(a aVar) {
        this.agF = aVar;
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final void a(String str, com.kwad.sdk.core.webview.c.c cVar) {
        if (this.agF != null) {
            com.kwad.components.core.webview.tachikoma.c.t tVar = new com.kwad.components.core.webview.tachikoma.c.t();
            try {
                tVar.parseJson(new JSONObject(str));
                this.agF.a(tVar);
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final void onDestroy() {
        this.agF = null;
    }
}
