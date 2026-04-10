package com.kwad.components.core.webview.tachikoma.b;

import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
public final class v implements com.kwad.sdk.core.webview.c.a {
    private a agI;

    public interface a {
        void b(com.kwad.components.core.webview.tachikoma.c.n nVar);
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final String getKey() {
        return "updateVideoMuteState";
    }

    public final void a(a aVar) {
        this.agI = aVar;
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final void a(String str, com.kwad.sdk.core.webview.c.c cVar) {
        if (this.agI != null) {
            com.kwad.components.core.webview.tachikoma.c.n nVar = new com.kwad.components.core.webview.tachikoma.c.n();
            try {
                nVar.parseJson(new JSONObject(str));
                this.agI.b(nVar);
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final void onDestroy() {
        this.agI = null;
    }
}
