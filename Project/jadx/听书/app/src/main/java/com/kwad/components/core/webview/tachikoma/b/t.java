package com.kwad.components.core.webview.tachikoma.b;

import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
public final class t implements com.kwad.sdk.core.webview.c.a {
    private a agG;

    public interface a {
        void b(com.kwad.components.core.webview.tachikoma.c.u uVar);
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final String getKey() {
        return "skipVideo";
    }

    public final void a(a aVar) {
        this.agG = aVar;
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final void a(String str, com.kwad.sdk.core.webview.c.c cVar) {
        if (this.agG != null) {
            com.kwad.components.core.webview.tachikoma.c.u uVar = new com.kwad.components.core.webview.tachikoma.c.u();
            try {
                try {
                    uVar.parseJson(new JSONObject(str));
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            } finally {
                this.agG.b(uVar);
            }
        }
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final void onDestroy() {
        this.agG = null;
    }
}
