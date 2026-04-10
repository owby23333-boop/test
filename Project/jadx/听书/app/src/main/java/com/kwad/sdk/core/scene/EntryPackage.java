package com.kwad.sdk.core.scene;

import com.kwad.sdk.utils.aa;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
public class EntryPackage extends URLPackage {
    private static final long serialVersionUID = 8251709184937662571L;
    public String entryId;
    public String entryPageSource;

    public EntryPackage() {
        this.entryPageSource = "unknown";
    }

    public EntryPackage(String str, int i) {
        super(str, i);
        this.entryPageSource = "unknown";
    }

    @Override // com.kwad.sdk.core.response.a.a, com.kwad.sdk.core.b
    public void parseJson(JSONObject jSONObject) {
        super.parseJson(jSONObject);
        if (jSONObject == null) {
            return;
        }
        this.entryPageSource = jSONObject.optString("entryPageSource");
        this.entryId = jSONObject.optString("entryId");
    }

    @Override // com.kwad.sdk.core.response.a.a, com.kwad.sdk.core.b
    public JSONObject toJson() {
        JSONObject json = super.toJson();
        aa.putValue(json, "entryPageSource", this.entryPageSource);
        aa.putValue(json, "entryId", this.entryId);
        return json;
    }
}
