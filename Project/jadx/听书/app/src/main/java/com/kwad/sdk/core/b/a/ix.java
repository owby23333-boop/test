package com.kwad.sdk.core.b.a;

import com.kwad.sdk.n.d;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
public final class ix implements com.kwad.sdk.core.d<com.kwad.sdk.n.d> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        a((com.kwad.sdk.n.d) bVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        return b((com.kwad.sdk.n.d) bVar, jSONObject);
    }

    private static void a(com.kwad.sdk.n.d dVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        dVar.funcSwitch = jSONObject.optLong("funcSwitch");
        dVar.aXc = new ArrayList();
        JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("urlList");
        if (jSONArrayOptJSONArray != null) {
            for (int i = 0; i < jSONArrayOptJSONArray.length(); i++) {
                dVar.aXc.add((String) jSONArrayOptJSONArray.opt(i));
            }
        }
        dVar.aXd = new ArrayList();
        JSONArray jSONArrayOptJSONArray2 = jSONObject.optJSONArray("actConfigList");
        if (jSONArrayOptJSONArray2 != null) {
            for (int i2 = 0; i2 < jSONArrayOptJSONArray2.length(); i2++) {
                d.a aVar = new d.a();
                aVar.parseJson(jSONArrayOptJSONArray2.optJSONObject(i2));
                dVar.aXd.add(aVar);
            }
        }
        dVar.byteCount = jSONObject.optLong("byteCount");
        dVar.sampleRate = jSONObject.optDouble("sampleRate");
        dVar.aXe = new ArrayList();
        JSONArray jSONArrayOptJSONArray3 = jSONObject.optJSONArray("anchorNodeList");
        if (jSONArrayOptJSONArray3 != null) {
            for (int i3 = 0; i3 < jSONArrayOptJSONArray3.length(); i3++) {
                com.kwad.sdk.n.a.b bVar = new com.kwad.sdk.n.a.b();
                bVar.parseJson(jSONArrayOptJSONArray3.optJSONObject(i3));
                dVar.aXe.add(bVar);
            }
        }
        dVar.aWU = new ArrayList();
        JSONArray jSONArrayOptJSONArray4 = jSONObject.optJSONArray("aggregationCheckConfigList");
        if (jSONArrayOptJSONArray4 != null) {
            for (int i4 = 0; i4 < jSONArrayOptJSONArray4.length(); i4++) {
                com.kwad.sdk.n.a.a aVar2 = new com.kwad.sdk.n.a.a();
                aVar2.parseJson(jSONArrayOptJSONArray4.optJSONObject(i4));
                dVar.aWU.add(aVar2);
            }
        }
    }

    private static JSONObject b(com.kwad.sdk.n.d dVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        if (dVar.funcSwitch != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "funcSwitch", dVar.funcSwitch);
        }
        com.kwad.sdk.utils.aa.putValue(jSONObject, "urlList", dVar.aXc);
        com.kwad.sdk.utils.aa.putValue(jSONObject, "actConfigList", dVar.aXd);
        if (dVar.byteCount != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "byteCount", dVar.byteCount);
        }
        if (dVar.sampleRate != 0.0d) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "sampleRate", dVar.sampleRate);
        }
        com.kwad.sdk.utils.aa.putValue(jSONObject, "anchorNodeList", dVar.aXe);
        com.kwad.sdk.utils.aa.putValue(jSONObject, "aggregationCheckConfigList", dVar.aWU);
        return jSONObject;
    }
}
