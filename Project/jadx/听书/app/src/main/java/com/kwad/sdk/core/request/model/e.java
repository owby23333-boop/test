package com.kwad.sdk.core.request.model;

import com.kwad.sdk.core.network.k;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.utils.aa;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
public final class e implements com.kwad.sdk.core.b {
    private com.kwad.sdk.core.b aIE;

    @Override // com.kwad.sdk.core.b
    public final void parseJson(JSONObject jSONObject) {
    }

    public static e IO() {
        e eVar = new e();
        try {
            eVar.aIE = ((k) ServiceProvider.get(k.class)).Bf();
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
        return eVar;
    }

    @Override // com.kwad.sdk.core.b
    public final JSONObject toJson() {
        JSONObject jSONObject = new JSONObject();
        aa.a(jSONObject, "modeInfo", this.aIE);
        return jSONObject;
    }
}
