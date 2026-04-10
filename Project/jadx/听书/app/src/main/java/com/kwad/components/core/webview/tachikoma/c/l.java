package com.kwad.components.core.webview.tachikoma.c;

import com.kwad.sdk.utils.aa;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
public final class l extends com.kwad.sdk.core.response.a.a {
    public int ahc;
    public int ahd = -1;
    public int ahe;

    @Override // com.kwad.sdk.core.response.a.a, com.kwad.sdk.core.b
    public final JSONObject toJson() {
        JSONObject jSONObject = new JSONObject();
        aa.putValue(jSONObject, "insertScreenAdShowStrategy", this.ahc);
        aa.putValue(jSONObject, "isAutoShow", this.ahe);
        int i = this.ahd;
        if (i != -1) {
            aa.putValue(jSONObject, "triggerType", i);
        }
        return jSONObject;
    }
}
