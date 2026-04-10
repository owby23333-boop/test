package com.kwad.sdk.core.request.model;

import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.utils.aa;
import com.kwad.sdk.utils.bd;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
public final class c implements com.kwad.sdk.core.b {
    private static c aIA;
    private double latitude;
    private double longitude;
    private int type;

    @Override // com.kwad.sdk.core.b
    public final void parseJson(JSONObject jSONObject) {
    }

    @Override // com.kwad.sdk.core.b
    public final JSONObject toJson() {
        JSONObject jSONObject = new JSONObject();
        aa.putValue(jSONObject, "latitude", this.latitude);
        aa.putValue(jSONObject, "longitude", this.longitude);
        aa.putValue(jSONObject, "type", this.type);
        return jSONObject;
    }

    public static c IL() {
        c cVar = aIA;
        if (cVar != null) {
            return cVar;
        }
        try {
            aIA = new c();
            com.kwad.sdk.utils.c.a aVarCL = bd.cL(((com.kwad.sdk.service.a.f) ServiceProvider.get(com.kwad.sdk.service.a.f.class)).getContext());
            if (aVarCL != null && aVarCL.bcT != null) {
                aIA.latitude = aVarCL.bcT.getLatitude();
                aIA.longitude = aVarCL.bcT.getLongitude();
                aIA.type = aVarCL.type;
            }
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
        return aIA;
    }
}
