package com.kwad.sdk.core.b.a;

import com.kwad.sdk.j.a;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
public final class jn implements com.kwad.sdk.core.d<a.C0419a> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        a((a.C0419a) bVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        return b((a.C0419a) bVar, jSONObject);
    }

    private static void a(a.C0419a c0419a, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        c0419a.aTs = jSONObject.optInt("ds");
        c0419a.sdkVersion = jSONObject.optString("sv");
        if (JSONObject.NULL.toString().equals(c0419a.sdkVersion)) {
            c0419a.sdkVersion = "";
        }
        c0419a.aOu = jSONObject.optString("spv");
        if (JSONObject.NULL.toString().equals(c0419a.aOu)) {
            c0419a.aOu = "";
        }
    }

    private static JSONObject b(a.C0419a c0419a, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        if (c0419a.aTs != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "ds", c0419a.aTs);
        }
        if (c0419a.sdkVersion != null && !c0419a.sdkVersion.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "sv", c0419a.sdkVersion);
        }
        if (c0419a.aOu != null && !c0419a.aOu.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "spv", c0419a.aOu);
        }
        return jSONObject;
    }
}
