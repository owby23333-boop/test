package com.kwad.sdk.core.request.model;

import androidx.annotation.Nullable;
import com.kwad.sdk.core.network.l;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.utils.s;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public final class e implements com.kwad.sdk.core.b {
    private com.kwad.sdk.core.b ald;

    public static e xG() {
        e eVar = new e();
        l lVar = (l) ServiceProvider.get(l.class);
        if (lVar != null) {
            eVar.ald = lVar.sI();
        }
        return eVar;
    }

    @Override // com.kwad.sdk.core.b
    public final void parseJson(@Nullable JSONObject jSONObject) {
    }

    @Override // com.kwad.sdk.core.b
    public final JSONObject toJson() {
        JSONObject jSONObject = new JSONObject();
        s.a(jSONObject, "modeInfo", this.ald);
        return jSONObject;
    }
}
