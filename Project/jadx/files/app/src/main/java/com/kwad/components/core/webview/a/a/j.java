package com.kwad.components.core.webview.a.a;

import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public final class j extends com.kwad.sdk.core.response.kwai.a {
    public int UT;
    public int UU = -1;
    public int UV;

    @Override // com.kwad.sdk.core.response.kwai.a, com.kwad.sdk.core.b
    public final JSONObject toJson() {
        JSONObject jSONObject = new JSONObject();
        com.kwad.sdk.utils.s.putValue(jSONObject, "insertScreenAdShowStrategy", this.UT);
        com.kwad.sdk.utils.s.putValue(jSONObject, "isAutoShow", this.UV);
        int i2 = this.UU;
        if (i2 != -1) {
            com.kwad.sdk.utils.s.putValue(jSONObject, "triggerType", i2);
        }
        return jSONObject;
    }
}
