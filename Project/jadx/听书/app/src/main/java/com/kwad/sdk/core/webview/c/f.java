package com.kwad.sdk.core.webview.c;

import com.kwad.sdk.utils.aa;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
public final class f implements com.kwad.sdk.core.b {
    public final com.kwad.sdk.core.b aNH;
    public final int result = 1;

    @Override // com.kwad.sdk.core.b
    public final void parseJson(JSONObject jSONObject) {
    }

    public f(com.kwad.sdk.core.b bVar) {
        this.aNH = bVar;
    }

    @Override // com.kwad.sdk.core.b
    public final JSONObject toJson() {
        JSONObject jSONObject = new JSONObject();
        aa.putValue(jSONObject, "result", this.result);
        aa.a(jSONObject, "data", this.aNH);
        return jSONObject;
    }
}
