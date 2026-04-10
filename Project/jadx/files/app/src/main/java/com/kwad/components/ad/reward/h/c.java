package com.kwad.components.ad.reward.h;

import androidx.annotation.NonNull;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public final class c implements com.kwad.sdk.core.webview.b.a {
    private a xo;

    public interface a {
        void a(com.kwad.components.core.webview.a.a.o oVar);
    }

    public final void a(a aVar) {
        this.xo = aVar;
    }

    @Override // com.kwad.sdk.core.webview.b.a
    public final void a(String str, @NonNull com.kwad.sdk.core.webview.b.c cVar) {
        com.kwad.components.core.webview.a.a.o oVar = new com.kwad.components.core.webview.a.a.o();
        try {
            oVar.parseJson(new JSONObject(str));
            if (this.xo != null) {
                this.xo.a(oVar);
            }
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
    }

    @Override // com.kwad.sdk.core.webview.b.a
    @NonNull
    public final String getKey() {
        return "clickCall";
    }

    @Override // com.kwad.sdk.core.webview.b.a
    public final void onDestroy() {
        this.xo = null;
    }
}
