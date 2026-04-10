package com.kwad.sdk.core.a.kwai;

import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public final class u implements com.kwad.sdk.core.d<com.kwad.sdk.internal.api.a> {
    private static void a(com.kwad.sdk.internal.api.a aVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        aVar.aaB = jSONObject.optInt("thirdAge");
        aVar.aaC = jSONObject.optInt("thirdGender");
        aVar.aaD = jSONObject.optString("thirdInterest");
        if (aVar.aaD == JSONObject.NULL) {
            aVar.aaD = "";
        }
        aVar.aaE = jSONObject.optString("prevTitle");
        if (aVar.aaE == JSONObject.NULL) {
            aVar.aaE = "";
        }
        aVar.aaF = jSONObject.optString("postTitle");
        if (aVar.aaF == JSONObject.NULL) {
            aVar.aaF = "";
        }
        aVar.aaG = jSONObject.optString("historyTitle");
        if (aVar.aaG == JSONObject.NULL) {
            aVar.aaG = "";
        }
        aVar.aaH = jSONObject.optString("channel");
        if (aVar.aaH == JSONObject.NULL) {
            aVar.aaH = "";
        }
        aVar.aaI = jSONObject.optLong("cpmBidFloor");
    }

    private static JSONObject b(com.kwad.sdk.internal.api.a aVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        int i2 = aVar.aaB;
        if (i2 != 0) {
            com.kwad.sdk.utils.s.putValue(jSONObject, "thirdAge", i2);
        }
        int i3 = aVar.aaC;
        if (i3 != 0) {
            com.kwad.sdk.utils.s.putValue(jSONObject, "thirdGender", i3);
        }
        String str = aVar.aaD;
        if (str != null && !str.equals("")) {
            com.kwad.sdk.utils.s.putValue(jSONObject, "thirdInterest", aVar.aaD);
        }
        String str2 = aVar.aaE;
        if (str2 != null && !str2.equals("")) {
            com.kwad.sdk.utils.s.putValue(jSONObject, "prevTitle", aVar.aaE);
        }
        String str3 = aVar.aaF;
        if (str3 != null && !str3.equals("")) {
            com.kwad.sdk.utils.s.putValue(jSONObject, "postTitle", aVar.aaF);
        }
        String str4 = aVar.aaG;
        if (str4 != null && !str4.equals("")) {
            com.kwad.sdk.utils.s.putValue(jSONObject, "historyTitle", aVar.aaG);
        }
        String str5 = aVar.aaH;
        if (str5 != null && !str5.equals("")) {
            com.kwad.sdk.utils.s.putValue(jSONObject, "channel", aVar.aaH);
        }
        long j2 = aVar.aaI;
        if (j2 != 0) {
            com.kwad.sdk.utils.s.putValue(jSONObject, "cpmBidFloor", j2);
        }
        return jSONObject;
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        a((com.kwad.sdk.internal.api.a) bVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        return b((com.kwad.sdk.internal.api.a) bVar, jSONObject);
    }
}
