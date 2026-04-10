package com.kwad.components.core.webview.jshandler;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public final class l implements com.kwad.sdk.core.webview.b.a {
    protected b SB;
    protected final com.kwad.sdk.core.webview.b Sk;

    public static class a implements com.kwad.sdk.core.b {
        public int height;
        public int width;

        @Override // com.kwad.sdk.core.b
        public final void parseJson(@Nullable JSONObject jSONObject) {
        }

        @Override // com.kwad.sdk.core.b
        public final JSONObject toJson() {
            JSONObject jSONObject = new JSONObject();
            com.kwad.sdk.utils.s.putValue(jSONObject, "width", this.width);
            com.kwad.sdk.utils.s.putValue(jSONObject, "height", this.height);
            return jSONObject;
        }
    }

    public interface b {
        void a(a aVar);
    }

    public l(com.kwad.sdk.core.webview.b bVar) {
        this.Sk = bVar;
    }

    public final void a(b bVar) {
        this.SB = bVar;
    }

    @Override // com.kwad.sdk.core.webview.b.a
    public final void a(String str, @NonNull com.kwad.sdk.core.webview.b.c cVar) {
        a aVar = new a();
        b bVar = this.SB;
        if (bVar != null) {
            bVar.a(aVar);
        } else {
            aVar.width = this.Sk.LI.getWidth();
            aVar.height = this.Sk.LI.getHeight();
        }
        cVar.a(aVar);
    }

    @Override // com.kwad.sdk.core.webview.b.a
    @NonNull
    public final String getKey() {
        return "getContainerLimit";
    }

    @Override // com.kwad.sdk.core.webview.b.a
    public final void onDestroy() {
    }
}
