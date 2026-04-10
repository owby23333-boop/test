package com.kwad.sdk.g.kwai;

import androidx.annotation.Nullable;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.utils.aw;
import com.kwad.sdk.utils.s;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public final class f extends com.kwad.sdk.core.response.kwai.a implements com.kwad.sdk.core.b {
    public int axe = -1;
    public int axf = -1;

    public static synchronized f Cu() {
        if (!((com.kwad.sdk.service.kwai.f) ServiceProvider.get(com.kwad.sdk.service.kwai.f.class)).sM()) {
            return null;
        }
        return aw.Cu();
    }

    private void a(f fVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        fVar.axe = jSONObject.optInt("phoneCount", -1);
        fVar.axf = jSONObject.optInt("activePhoneCount", -1);
        super.afterToJson(jSONObject);
    }

    private static JSONObject b(f fVar, JSONObject jSONObject) {
        s.putValue(jSONObject, "phoneCount", fVar.axe);
        s.putValue(jSONObject, "activePhoneCount", fVar.axf);
        return jSONObject;
    }

    @Override // com.kwad.sdk.core.response.kwai.a, com.kwad.sdk.core.b
    public final void parseJson(@Nullable JSONObject jSONObject) {
        a(this, jSONObject);
        afterParseJson(jSONObject);
    }

    @Override // com.kwad.sdk.core.response.kwai.a, com.kwad.sdk.core.b
    public final JSONObject toJson() {
        JSONObject jSONObjectB = b(this, new JSONObject());
        afterToJson(jSONObjectB);
        return jSONObjectB;
    }
}
