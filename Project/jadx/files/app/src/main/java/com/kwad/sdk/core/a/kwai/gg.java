package com.kwad.sdk.core.a.kwai;

import com.bytedance.msdk.adapter.pangle.PangleAdapterUtils;
import com.kwad.sdk.ranger.c;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public final class gg implements com.kwad.sdk.core.d<com.kwad.sdk.ranger.c> {
    private static void a(com.kwad.sdk.ranger.c cVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        cVar.axk = jSONObject.optLong("funcSwitch");
        cVar.axl = new ArrayList();
        JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("urlList");
        if (jSONArrayOptJSONArray != null) {
            for (int i2 = 0; i2 < jSONArrayOptJSONArray.length(); i2++) {
                cVar.axl.add((String) jSONArrayOptJSONArray.opt(i2));
            }
        }
        cVar.axm = new ArrayList();
        JSONArray jSONArrayOptJSONArray2 = jSONObject.optJSONArray("actConfigList");
        if (jSONArrayOptJSONArray2 != null) {
            for (int i3 = 0; i3 < jSONArrayOptJSONArray2.length(); i3++) {
                c.a aVar = new c.a();
                aVar.parseJson(jSONArrayOptJSONArray2.optJSONObject(i3));
                cVar.axm.add(aVar);
            }
        }
        cVar.axn = jSONObject.optLong("byteCount");
        cVar.axo = jSONObject.optDouble("sampleRate");
    }

    private static JSONObject b(com.kwad.sdk.ranger.c cVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        long j2 = cVar.axk;
        if (j2 != 0) {
            com.kwad.sdk.utils.s.putValue(jSONObject, "funcSwitch", j2);
        }
        com.kwad.sdk.utils.s.putValue(jSONObject, "urlList", cVar.axl);
        com.kwad.sdk.utils.s.putValue(jSONObject, "actConfigList", cVar.axm);
        long j3 = cVar.axn;
        if (j3 != 0) {
            com.kwad.sdk.utils.s.putValue(jSONObject, "byteCount", j3);
        }
        double d2 = cVar.axo;
        if (d2 != PangleAdapterUtils.CPM_DEFLAUT_VALUE) {
            com.kwad.sdk.utils.s.putValue(jSONObject, "sampleRate", d2);
        }
        return jSONObject;
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        a((com.kwad.sdk.ranger.c) bVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        return b((com.kwad.sdk.ranger.c) bVar, jSONObject);
    }
}
