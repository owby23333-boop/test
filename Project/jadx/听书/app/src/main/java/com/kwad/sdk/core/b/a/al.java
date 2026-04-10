package com.kwad.sdk.core.b.a;

import com.kwad.components.core.webview.jshandler.a;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
public final class al implements com.kwad.sdk.core.d<a.C0354a> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        a((a.C0354a) bVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        return b((a.C0354a) bVar, jSONObject);
    }

    private static void a(a.C0354a c0354a, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        c0354a.NN = jSONObject.optString("creativeId");
        if (JSONObject.NULL.toString().equals(c0354a.NN)) {
            c0354a.NN = "";
        }
        c0354a.acf = jSONObject.optString("targetMethod");
        if (JSONObject.NULL.toString().equals(c0354a.acf)) {
            c0354a.acf = "";
        }
        c0354a.acg = jSONObject.optString("methodParams");
        if (JSONObject.NULL.toString().equals(c0354a.acg)) {
            c0354a.acg = "";
        }
    }

    private static JSONObject b(a.C0354a c0354a, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        if (c0354a.NN != null && !c0354a.NN.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "creativeId", c0354a.NN);
        }
        if (c0354a.acf != null && !c0354a.acf.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "targetMethod", c0354a.acf);
        }
        if (c0354a.acg != null && !c0354a.acg.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "methodParams", c0354a.acg);
        }
        return jSONObject;
    }
}
