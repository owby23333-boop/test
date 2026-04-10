package com.kwad.sdk.core.b.a;

import org.json.JSONObject;

/* JADX INFO: renamed from: com.kwad.sdk.core.b.a.if, reason: invalid class name */
/* JADX INFO: loaded from: classes4.dex */
public final class Cif implements com.kwad.sdk.core.d<com.kwad.sdk.core.config.d> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        a((com.kwad.sdk.core.config.d) bVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        return b((com.kwad.sdk.core.config.d) bVar, jSONObject);
    }

    private static void a(com.kwad.sdk.core.config.d dVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        dVar.aCc = jSONObject.optInt("enableDialog", new Integer("0").intValue());
        dVar.aCd = jSONObject.optInt("delayTime", new Integer("800").intValue());
        dVar.aCe = jSONObject.optInt("showTimesPerDay", new Integer("3").intValue());
        dVar.aCf = jSONObject.optInt("maxShowTimes", new Integer("100000").intValue());
    }

    private static JSONObject b(com.kwad.sdk.core.config.d dVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        com.kwad.sdk.utils.aa.putValue(jSONObject, "enableDialog", dVar.aCc);
        com.kwad.sdk.utils.aa.putValue(jSONObject, "delayTime", dVar.aCd);
        com.kwad.sdk.utils.aa.putValue(jSONObject, "showTimesPerDay", dVar.aCe);
        com.kwad.sdk.utils.aa.putValue(jSONObject, "maxShowTimes", dVar.aCf);
        return jSONObject;
    }
}
