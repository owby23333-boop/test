package com.kwad.sdk.core.a.kwai;

import com.kwad.sdk.crash.model.message.AnrReason;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public final class ao implements com.kwad.sdk.core.d<AnrReason> {
    private static void a(AnrReason anrReason, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        anrReason.mTag = jSONObject.optString("mTag");
        if (anrReason.mTag == JSONObject.NULL) {
            anrReason.mTag = "";
        }
        anrReason.mShortMsg = jSONObject.optString("mShortMsg");
        if (anrReason.mShortMsg == JSONObject.NULL) {
            anrReason.mShortMsg = "";
        }
        anrReason.mLongMsg = jSONObject.optString("mLongMsg");
        if (anrReason.mLongMsg == JSONObject.NULL) {
            anrReason.mLongMsg = "";
        }
    }

    private static JSONObject b(AnrReason anrReason, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        String str = anrReason.mTag;
        if (str != null && !str.equals("")) {
            com.kwad.sdk.utils.s.putValue(jSONObject, "mTag", anrReason.mTag);
        }
        String str2 = anrReason.mShortMsg;
        if (str2 != null && !str2.equals("")) {
            com.kwad.sdk.utils.s.putValue(jSONObject, "mShortMsg", anrReason.mShortMsg);
        }
        String str3 = anrReason.mLongMsg;
        if (str3 != null && !str3.equals("")) {
            com.kwad.sdk.utils.s.putValue(jSONObject, "mLongMsg", anrReason.mLongMsg);
        }
        return jSONObject;
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        a((AnrReason) bVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        return b((AnrReason) bVar, jSONObject);
    }
}
