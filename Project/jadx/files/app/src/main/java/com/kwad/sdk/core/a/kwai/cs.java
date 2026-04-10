package com.kwad.sdk.core.a.kwai;

import com.kwad.sdk.core.report.a;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public final class cs implements com.kwad.sdk.core.d<a.C0443a> {
    private static void a(a.C0443a c0443a, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        c0443a.code = jSONObject.optInt("code");
        c0443a.msg = jSONObject.optString("msg");
        if (c0443a.msg == JSONObject.NULL) {
            c0443a.msg = "";
        }
    }

    private static JSONObject b(a.C0443a c0443a, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        int i2 = c0443a.code;
        if (i2 != 0) {
            com.kwad.sdk.utils.s.putValue(jSONObject, "code", i2);
        }
        String str = c0443a.msg;
        if (str != null && !str.equals("")) {
            com.kwad.sdk.utils.s.putValue(jSONObject, "msg", c0443a.msg);
        }
        return jSONObject;
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        a((a.C0443a) bVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        return b((a.C0443a) bVar, jSONObject);
    }
}
