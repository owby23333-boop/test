package com.kwad.sdk.g.kwai;

import androidx.annotation.Nullable;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.utils.aw;
import com.kwad.sdk.utils.s;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public final class b extends com.kwad.sdk.core.response.kwai.a implements com.kwad.sdk.core.b {
    public int awT;
    public int awU;
    public int awV;

    public b(int i2, int i3, int i4) {
        this.awT = i2;
        this.awU = i3;
        this.awV = i4;
    }

    public static synchronized b Ct() {
        if (!((com.kwad.sdk.service.kwai.f) ServiceProvider.get(com.kwad.sdk.service.kwai.f.class)).sO()) {
            return null;
        }
        return aw.Ct();
    }

    private static void a(b bVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        bVar.awT = jSONObject.optInt("cellId", -1);
        bVar.awU = jSONObject.optInt("lac", -1);
        bVar.awV = jSONObject.optInt("bsss", -1);
    }

    private static JSONObject b(b bVar, JSONObject jSONObject) {
        s.putValue(jSONObject, "cellId", bVar.awT);
        s.putValue(jSONObject, "lac", bVar.awU);
        s.putValue(jSONObject, "bsss", bVar.awV);
        return jSONObject;
    }

    @Override // com.kwad.sdk.core.response.kwai.a, com.kwad.sdk.core.b
    public final void parseJson(@Nullable JSONObject jSONObject) {
        a(this, jSONObject);
        super.afterParseJson(jSONObject);
    }

    @Override // com.kwad.sdk.core.response.kwai.a, com.kwad.sdk.core.b
    public final JSONObject toJson() {
        return b(this, new JSONObject());
    }
}
