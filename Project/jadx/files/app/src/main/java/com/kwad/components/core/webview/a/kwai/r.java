package com.kwad.components.core.webview.a.kwai;

import androidx.annotation.NonNull;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public class r implements com.kwad.sdk.core.webview.b.a {
    public void a(com.kwad.components.core.webview.a.a.q qVar) {
    }

    @Override // com.kwad.sdk.core.webview.b.a
    public final void a(String str, @NonNull com.kwad.sdk.core.webview.b.c cVar) {
        com.kwad.components.core.webview.a.a.q qVar = new com.kwad.components.core.webview.a.a.q();
        try {
            qVar.parseJson(new JSONObject(str));
            a(qVar);
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
    }

    @Override // com.kwad.sdk.core.webview.b.a
    @NonNull
    public final String getKey() {
        return "showTKDialog";
    }

    @Override // com.kwad.sdk.core.webview.b.a
    public final void onDestroy() {
    }
}
