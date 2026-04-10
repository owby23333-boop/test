package com.kwad.components.ad.reward.k;

import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public final class k implements com.kwad.sdk.core.webview.c.a {
    private a AG;

    public interface a {
        void d(com.kwad.components.core.webview.tachikoma.c.r rVar);
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final String getKey() {
        return "showPlayEnd";
    }

    public final void a(a aVar) {
        this.AG = aVar;
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final void a(String str, com.kwad.sdk.core.webview.c.c cVar) {
        if (this.AG != null) {
            com.kwad.components.core.webview.tachikoma.c.r rVar = new com.kwad.components.core.webview.tachikoma.c.r();
            try {
                rVar.parseJson(new JSONObject(str));
                this.AG.d(rVar);
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final void onDestroy() {
        this.AG = null;
    }
}
