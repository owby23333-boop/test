package com.kwad.sdk.core.b.a;

import com.kwad.sdk.o.l;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
public final class kp implements com.kwad.sdk.core.d<l.a.C0425a> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        a((l.a.C0425a) bVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        return b((l.a.C0425a) bVar, jSONObject);
    }

    private static void a(l.a.C0425a c0425a, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        c0425a.beg = jSONObject.optString("s_cn");
        if (JSONObject.NULL.toString().equals(c0425a.beg)) {
            c0425a.beg = "";
        }
        c0425a.beh = jSONObject.optString("s_mn");
        if (JSONObject.NULL.toString().equals(c0425a.beh)) {
            c0425a.beh = "";
        }
    }

    private static JSONObject b(l.a.C0425a c0425a, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        if (c0425a.beg != null && !c0425a.beg.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "s_cn", c0425a.beg);
        }
        if (c0425a.beh != null && !c0425a.beh.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "s_mn", c0425a.beh);
        }
        return jSONObject;
    }
}
