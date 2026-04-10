package com.kwad.sdk.core.a.kwai;

import com.kwad.sdk.f.b;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public final class gu implements com.kwad.sdk.core.d<b.a> {
    private static void a(b.a aVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        aVar.atE = jSONObject.optInt("ds");
        aVar.sdkVersion = jSONObject.optString(com.anythink.expressad.foundation.g.a.Z);
        if (aVar.sdkVersion == JSONObject.NULL) {
            aVar.sdkVersion = "";
        }
        aVar.atF = jSONObject.optString("spv");
        if (aVar.atF == JSONObject.NULL) {
            aVar.atF = "";
        }
    }

    private static JSONObject b(b.a aVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        int i2 = aVar.atE;
        if (i2 != 0) {
            com.kwad.sdk.utils.s.putValue(jSONObject, "ds", i2);
        }
        String str = aVar.sdkVersion;
        if (str != null && !str.equals("")) {
            com.kwad.sdk.utils.s.putValue(jSONObject, com.anythink.expressad.foundation.g.a.Z, aVar.sdkVersion);
        }
        String str2 = aVar.atF;
        if (str2 != null && !str2.equals("")) {
            com.kwad.sdk.utils.s.putValue(jSONObject, "spv", aVar.atF);
        }
        return jSONObject;
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        a((b.a) bVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        return b((b.a) bVar, jSONObject);
    }
}
