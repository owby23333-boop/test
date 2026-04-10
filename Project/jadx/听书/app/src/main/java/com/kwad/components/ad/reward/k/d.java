package com.kwad.components.ad.reward.k;

import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public final class d implements com.kwad.sdk.core.webview.c.a {
    private a Ay;

    public interface a {
        void a(com.kwad.components.core.webview.tachikoma.c.q qVar);
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final String getKey() {
        return "clickCall";
    }

    public final void a(a aVar) {
        this.Ay = aVar;
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final void a(String str, com.kwad.sdk.core.webview.c.c cVar) {
        com.kwad.components.core.webview.tachikoma.c.q qVar = new com.kwad.components.core.webview.tachikoma.c.q();
        try {
            qVar.parseJson(new JSONObject(str));
            a aVar = this.Ay;
            if (aVar != null) {
                aVar.a(qVar);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final void onDestroy() {
        this.Ay = null;
    }
}
