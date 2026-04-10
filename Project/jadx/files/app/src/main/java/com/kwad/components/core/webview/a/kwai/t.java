package com.kwad.components.core.webview.a.kwai;

import androidx.annotation.NonNull;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public final class t implements com.kwad.sdk.core.webview.b.a {
    private a UE;

    public interface a {
        void a(com.kwad.components.core.webview.a.a.s sVar);
    }

    public final void a(a aVar) {
        this.UE = aVar;
    }

    @Override // com.kwad.sdk.core.webview.b.a
    public final void a(String str, @NonNull com.kwad.sdk.core.webview.b.c cVar) {
        if (this.UE != null) {
            com.kwad.components.core.webview.a.a.s sVar = new com.kwad.components.core.webview.a.a.s();
            try {
                try {
                    sVar.parseJson(new JSONObject(str));
                } catch (JSONException e2) {
                    e2.printStackTrace();
                }
            } finally {
                this.UE.a(sVar);
            }
        }
    }

    @Override // com.kwad.sdk.core.webview.b.a
    @NonNull
    public final String getKey() {
        return "skipVideo";
    }

    @Override // com.kwad.sdk.core.webview.b.a
    public final void onDestroy() {
        this.UE = null;
    }
}
