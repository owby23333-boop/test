package com.kwad.components.core.webview.a.kwai;

import androidx.annotation.NonNull;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public class j implements com.kwad.sdk.core.webview.b.a {
    public void a(com.kwad.components.core.webview.a.a.l lVar) {
    }

    @Override // com.kwad.sdk.core.webview.b.a
    public final void a(String str, @NonNull com.kwad.sdk.core.webview.b.c cVar) {
        com.kwad.components.core.webview.a.a.l lVar = new com.kwad.components.core.webview.a.a.l();
        try {
            lVar.parseJson(new JSONObject(str));
            a(lVar);
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
    }

    @Override // com.kwad.sdk.core.webview.b.a
    @NonNull
    public final String getKey() {
        return "openURL";
    }

    @Override // com.kwad.sdk.core.webview.b.a
    public final void onDestroy() {
    }
}
