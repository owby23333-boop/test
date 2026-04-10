package com.kwad.sdk.core.a.kwai;

import com.kwad.sdk.f.a;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public final class co implements com.kwad.sdk.core.d<a.C0453a> {
    private static void a(a.C0453a c0453a, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        c0453a.sdkVersion = jSONObject.optString("run_sdk_version");
        if (c0453a.sdkVersion == JSONObject.NULL) {
            c0453a.sdkVersion = "";
        }
        c0453a.aty = jSONObject.optLong("trigger_count", new Long("0").longValue());
        c0453a.atz = jSONObject.optLong("fail_count", new Long("0").longValue());
        c0453a.atA = jSONObject.optLong("real_fail_count", new Long("0").longValue());
        c0453a.atB = jSONObject.optString("business");
        if (c0453a.atB == JSONObject.NULL) {
            c0453a.atB = "";
        }
        c0453a.atC = jSONObject.optString("stage");
        if (c0453a.atC == JSONObject.NULL) {
            c0453a.atC = "";
        }
        c0453a.atD = jSONObject.optString("function");
        if (c0453a.atD == JSONObject.NULL) {
            c0453a.atD = "";
        }
    }

    private static JSONObject b(a.C0453a c0453a, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        String str = c0453a.sdkVersion;
        if (str != null && !str.equals("")) {
            com.kwad.sdk.utils.s.putValue(jSONObject, "run_sdk_version", c0453a.sdkVersion);
        }
        com.kwad.sdk.utils.s.putValue(jSONObject, "trigger_count", c0453a.aty);
        com.kwad.sdk.utils.s.putValue(jSONObject, "fail_count", c0453a.atz);
        com.kwad.sdk.utils.s.putValue(jSONObject, "real_fail_count", c0453a.atA);
        String str2 = c0453a.atB;
        if (str2 != null && !str2.equals("")) {
            com.kwad.sdk.utils.s.putValue(jSONObject, "business", c0453a.atB);
        }
        String str3 = c0453a.atC;
        if (str3 != null && !str3.equals("")) {
            com.kwad.sdk.utils.s.putValue(jSONObject, "stage", c0453a.atC);
        }
        String str4 = c0453a.atD;
        if (str4 != null && !str4.equals("")) {
            com.kwad.sdk.utils.s.putValue(jSONObject, "function", c0453a.atD);
        }
        return jSONObject;
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        a((a.C0453a) bVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        return b((a.C0453a) bVar, jSONObject);
    }
}
