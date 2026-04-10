package com.kwad.components.core.webview.jshandler;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public final class ae implements com.kwad.sdk.core.webview.b.a {
    private com.kwad.sdk.core.webview.b.c RZ;

    public static final class a implements com.kwad.sdk.core.b {
        private String TO;

        @Override // com.kwad.sdk.core.b
        public final void parseJson(@Nullable JSONObject jSONObject) {
        }

        @Override // com.kwad.sdk.core.b
        public final JSONObject toJson() {
            JSONObject jSONObject = new JSONObject();
            com.kwad.sdk.utils.s.putValue(jSONObject, "lifeStatus", this.TO);
            return jSONObject;
        }
    }

    private void aG(String str) {
        if (this.RZ != null) {
            a aVar = new a();
            aVar.TO = str;
            this.RZ.a(aVar);
        }
    }

    @Override // com.kwad.sdk.core.webview.b.a
    public final void a(String str, @NonNull com.kwad.sdk.core.webview.b.c cVar) {
        this.RZ = cVar;
    }

    @Override // com.kwad.sdk.core.webview.b.a
    @NonNull
    public final String getKey() {
        return "registerLifecycleListener";
    }

    @Override // com.kwad.sdk.core.webview.b.a
    public final void onDestroy() {
        this.RZ = null;
    }

    public final void rr() {
        aG("showStart");
    }

    public final void rs() {
        aG("showEnd");
    }

    public final void rt() {
        aG("hideStart");
    }

    public final void ru() {
        aG("hideEnd");
    }

    public final void rv() {
        aG("pageVisiable");
    }

    public final void rw() {
        aG("pageInvisiable");
    }
}
