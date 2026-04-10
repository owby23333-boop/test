package com.kwad.sdk.core.webview.b;

import androidx.annotation.Nullable;
import com.kwad.sdk.utils.s;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public final class f implements com.kwad.sdk.core.b {
    public final com.kwad.sdk.core.b apB;
    public final int result = 1;

    public f(com.kwad.sdk.core.b bVar) {
        this.apB = bVar;
    }

    @Override // com.kwad.sdk.core.b
    public final void parseJson(@Nullable JSONObject jSONObject) {
    }

    @Override // com.kwad.sdk.core.b
    public final JSONObject toJson() {
        JSONObject jSONObject = new JSONObject();
        s.putValue(jSONObject, "result", this.result);
        s.a(jSONObject, "data", this.apB);
        return jSONObject;
    }
}
