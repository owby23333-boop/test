package com.kwad.sdk.l.a;

import com.kwad.sdk.utils.aa;
import com.umeng.umcrash.UMCrash;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
public final class e extends com.kwad.sdk.core.response.a.a implements com.kwad.sdk.core.b {
    public int sensorType = -1;
    public List<Float> aWP = new ArrayList();
    public long timestamp = 0;

    @Override // com.kwad.sdk.core.response.a.a
    public final void afterToJson(JSONObject jSONObject) {
        super.afterToJson(jSONObject);
        aa.putValue(jSONObject, "values", this.aWP);
    }

    private void a(e eVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        eVar.sensorType = jSONObject.optInt("sensorType");
        eVar.timestamp = jSONObject.optLong(UMCrash.SP_KEY_TIMESTAMP);
        super.afterToJson(jSONObject);
    }

    private static JSONObject b(e eVar, JSONObject jSONObject) {
        aa.putValue(jSONObject, "sensorType", eVar.sensorType);
        aa.putValue(jSONObject, UMCrash.SP_KEY_TIMESTAMP, eVar.timestamp);
        return jSONObject;
    }

    @Override // com.kwad.sdk.core.response.a.a, com.kwad.sdk.core.b
    public final void parseJson(JSONObject jSONObject) {
        a(this, jSONObject);
        afterParseJson(jSONObject);
    }

    @Override // com.kwad.sdk.core.response.a.a, com.kwad.sdk.core.b
    public final JSONObject toJson() {
        JSONObject jSONObjectB = b(this, new JSONObject());
        afterToJson(jSONObjectB);
        return jSONObjectB;
    }
}
