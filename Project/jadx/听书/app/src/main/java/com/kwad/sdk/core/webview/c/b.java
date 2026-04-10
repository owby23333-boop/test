package com.kwad.sdk.core.webview.c;

import com.kwad.sdk.utils.aa;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
public final class b implements com.kwad.sdk.core.b {
    public String aNF;
    public String aNG;
    public String data;

    @Override // com.kwad.sdk.core.b
    public final void parseJson(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        this.aNF = jSONObject.optString("action");
        this.data = jSONObject.optString("data");
        this.aNG = jSONObject.optString("callback");
    }

    @Override // com.kwad.sdk.core.b
    public final JSONObject toJson() {
        JSONObject jSONObject = new JSONObject();
        aa.putValue(jSONObject, "action", this.aNF);
        aa.putValue(jSONObject, "data", this.data);
        aa.putValue(jSONObject, "callback", this.aNG);
        return jSONObject;
    }
}
