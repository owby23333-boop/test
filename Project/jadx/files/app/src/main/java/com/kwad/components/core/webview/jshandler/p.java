package com.kwad.components.core.webview.jshandler;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.sdk.KsAdSDKImpl;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public final class p implements com.kwad.sdk.core.webview.b.a {
    private final com.kwad.sdk.core.webview.b Sk;

    public static final class a implements com.kwad.sdk.core.b {
        private int screenOrientation;

        @Override // com.kwad.sdk.core.b
        public final void parseJson(@Nullable JSONObject jSONObject) {
        }

        @Override // com.kwad.sdk.core.b
        public final JSONObject toJson() {
            JSONObject jSONObject = new JSONObject();
            com.kwad.sdk.utils.s.putValue(jSONObject, "screenOrientation", this.screenOrientation);
            return jSONObject;
        }
    }

    public p(com.kwad.sdk.core.webview.b bVar) {
        this.Sk = bVar;
    }

    @Override // com.kwad.sdk.core.webview.b.a
    public final void a(String str, @NonNull com.kwad.sdk.core.webview.b.c cVar) {
        if (this.Sk.zf()) {
            cVar.onError(-1, "native adTemplate is null");
            return;
        }
        a aVar = new a();
        aVar.screenOrientation = !com.kwad.sdk.utils.ah.cu(KsAdSDKImpl.get().getContext()) ? 1 : 0;
        cVar.a(aVar);
    }

    @Override // com.kwad.sdk.core.webview.b.a
    @NonNull
    public final String getKey() {
        return "getScreenOrientation";
    }

    @Override // com.kwad.sdk.core.webview.b.a
    public final void onDestroy() {
    }
}
