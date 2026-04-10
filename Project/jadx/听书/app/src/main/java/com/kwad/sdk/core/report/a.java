package com.kwad.sdk.core.report;

import com.kwad.sdk.utils.aa;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
public class a extends com.kwad.sdk.core.response.a.a {
    public String aGf;

    @Override // com.kwad.sdk.core.response.a.a
    public void afterParseJson(JSONObject jSONObject) {
        super.afterParseJson(jSONObject);
        if (jSONObject != null) {
            this.aGf = jSONObject.optString("adTrackLog");
        }
    }

    @Override // com.kwad.sdk.core.response.a.a
    public void afterToJson(JSONObject jSONObject) {
        super.afterToJson(jSONObject);
        aa.putValue(jSONObject, "adTrackLog", this.aGf);
    }
}
