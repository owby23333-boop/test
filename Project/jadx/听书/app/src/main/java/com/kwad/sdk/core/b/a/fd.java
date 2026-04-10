package com.kwad.sdk.core.b.a;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.kwad.components.core.webview.jshandler.j;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
public final class fd implements com.kwad.sdk.core.d<j.a> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        a((j.a) bVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        return b((j.a) bVar, jSONObject);
    }

    private static void a(j.a aVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        aVar.acp = jSONObject.optString(TypedValues.Attributes.S_TARGET);
        if (JSONObject.NULL.toString().equals(aVar.acp)) {
            aVar.acp = "";
        }
    }

    private static JSONObject b(j.a aVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        if (aVar.acp != null && !aVar.acp.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, TypedValues.Attributes.S_TARGET, aVar.acp);
        }
        return jSONObject;
    }
}
