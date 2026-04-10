package com.kwad.sdk.core.webview.c;

import com.kwad.sdk.utils.aa;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
public final class e implements com.kwad.sdk.core.b {
    private final String aut;
    private final int result;

    @Override // com.kwad.sdk.core.b
    public final void parseJson(JSONObject jSONObject) {
    }

    public e(int i, String str) {
        this.result = i;
        this.aut = str;
    }

    @Override // com.kwad.sdk.core.b
    public final JSONObject toJson() {
        JSONObject jSONObject = new JSONObject();
        aa.putValue(jSONObject, "result", this.result);
        aa.putValue(jSONObject, "error_msg", this.aut);
        return jSONObject;
    }
}
