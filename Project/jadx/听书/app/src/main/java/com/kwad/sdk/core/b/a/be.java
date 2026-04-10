package com.kwad.sdk.core.b.a;

import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
public final class be implements com.kwad.sdk.core.d<com.kwad.sdk.n.b.a.a> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        a((com.kwad.sdk.n.b.a.a) bVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        return b((com.kwad.sdk.n.b.a.a) bVar, jSONObject);
    }

    private static void a(com.kwad.sdk.n.b.a.a aVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        aVar.aXH = jSONObject.optInt("aggregation_sdk_type");
        aVar.aXI = jSONObject.optString("aggregation_version");
        if (JSONObject.NULL.toString().equals(aVar.aXI)) {
            aVar.aXI = "";
        }
        aVar.aXJ = jSONObject.optInt("crash_times");
        aVar.aXK = jSONObject.optInt("call_ks_union_times");
        aVar.aXL = jSONObject.optLong("ks_launch_delay");
        aVar.aXM = jSONObject.optLong("aggregation_launch_delay");
    }

    private static JSONObject b(com.kwad.sdk.n.b.a.a aVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        if (aVar.aXH != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "aggregation_sdk_type", aVar.aXH);
        }
        if (aVar.aXI != null && !aVar.aXI.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "aggregation_version", aVar.aXI);
        }
        if (aVar.aXJ != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "crash_times", aVar.aXJ);
        }
        if (aVar.aXK != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "call_ks_union_times", aVar.aXK);
        }
        if (aVar.aXL != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "ks_launch_delay", aVar.aXL);
        }
        if (aVar.aXM != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "aggregation_launch_delay", aVar.aXM);
        }
        return jSONObject;
    }
}
