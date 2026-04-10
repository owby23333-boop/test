package com.kwad.sdk.l.a;

import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.service.a.h;
import com.kwad.sdk.utils.aa;
import com.kwad.sdk.utils.bh;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
public final class f extends com.kwad.sdk.core.response.a.a implements com.kwad.sdk.core.b {
    public int aWQ = -1;
    public int aWR = -1;

    public static synchronized f OP() {
        if (!((h) ServiceProvider.get(h.class)).Bv()) {
            return null;
        }
        return bh.OP();
    }

    private void a(f fVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        fVar.aWQ = jSONObject.optInt("phoneCount", -1);
        fVar.aWR = jSONObject.optInt("activePhoneCount", -1);
        super.afterToJson(jSONObject);
    }

    private static JSONObject b(f fVar, JSONObject jSONObject) {
        aa.putValue(jSONObject, "phoneCount", fVar.aWQ);
        aa.putValue(jSONObject, "activePhoneCount", fVar.aWR);
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
