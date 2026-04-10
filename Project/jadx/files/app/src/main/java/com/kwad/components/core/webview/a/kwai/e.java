package com.kwad.components.core.webview.a.kwai;

import androidx.annotation.MainThread;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public final class e extends v {
    private final b Uv;

    static class a implements com.kwad.sdk.core.b {
        public int height;

        private a() {
        }

        /* synthetic */ a(byte b) {
            this();
        }

        @Override // com.kwad.sdk.core.b
        public final void parseJson(@Nullable JSONObject jSONObject) {
        }

        @Override // com.kwad.sdk.core.b
        public final JSONObject toJson() {
            JSONObject jSONObject = new JSONObject();
            com.kwad.sdk.utils.s.putValue(jSONObject, "height", this.height);
            return jSONObject;
        }
    }

    public interface b {
        @MainThread
        int jr();
    }

    public e(b bVar) {
        this.Uv = bVar;
    }

    @Override // com.kwad.components.core.webview.a.kwai.v, com.kwad.sdk.core.webview.b.a
    public final void a(String str, @NonNull com.kwad.sdk.core.webview.b.c cVar) {
        a aVar = new a((byte) 0);
        b bVar = this.Uv;
        if (bVar != null) {
            aVar.height = bVar.jr();
            cVar.a(aVar);
        }
    }

    @Override // com.kwad.sdk.core.webview.b.a
    @NonNull
    public final String getKey() {
        return "getBottomLimitHeight";
    }

    @Override // com.kwad.components.core.webview.a.kwai.v, com.kwad.sdk.core.webview.b.a
    public final void onDestroy() {
    }
}
