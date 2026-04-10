package com.kwad.components.ad.reward.h;

import androidx.annotation.NonNull;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public final class j implements com.kwad.sdk.core.webview.b.a {
    private a xt;

    public interface a {
        void d(com.kwad.components.core.webview.a.a.p pVar);
    }

    public final void a(a aVar) {
        this.xt = aVar;
    }

    @Override // com.kwad.sdk.core.webview.b.a
    public final void a(String str, @NonNull com.kwad.sdk.core.webview.b.c cVar) {
        if (this.xt != null) {
            com.kwad.components.core.webview.a.a.p pVar = new com.kwad.components.core.webview.a.a.p();
            try {
                pVar.parseJson(new JSONObject(str));
                this.xt.d(pVar);
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
        }
    }

    @Override // com.kwad.sdk.core.webview.b.a
    @NonNull
    public final String getKey() {
        return "showPlayEnd";
    }

    @Override // com.kwad.sdk.core.webview.b.a
    public final void onDestroy() {
        this.xt = null;
    }
}
