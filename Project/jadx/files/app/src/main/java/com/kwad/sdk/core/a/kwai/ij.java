package com.kwad.sdk.core.a.kwai;

import anet.channel.strategy.dispatch.DispatchConstants;
import com.kwad.components.core.webview.jshandler.q;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public final class ij implements com.kwad.sdk.core.d<q.a> {
    private static void a(q.a aVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        aVar.type = jSONObject.optInt("type");
        aVar.appName = jSONObject.optString(DispatchConstants.APP_NAME);
        if (aVar.appName == JSONObject.NULL) {
            aVar.appName = "";
        }
        aVar.SZ = jSONObject.optString("pkgName");
        if (aVar.SZ == JSONObject.NULL) {
            aVar.SZ = "";
        }
        aVar.version = jSONObject.optString("version");
        if (aVar.version == JSONObject.NULL) {
            aVar.version = "";
        }
        aVar.versionCode = jSONObject.optInt("versionCode");
        aVar.Ta = jSONObject.optInt("appSize");
        aVar.Tb = jSONObject.optString("md5");
        if (aVar.Tb == JSONObject.NULL) {
            aVar.Tb = "";
        }
        aVar.url = jSONObject.optString("url");
        if (aVar.url == JSONObject.NULL) {
            aVar.url = "";
        }
        aVar.Tc = jSONObject.optString("appLink");
        if (aVar.Tc == JSONObject.NULL) {
            aVar.Tc = "";
        }
        aVar.icon = jSONObject.optString("icon");
        if (aVar.icon == JSONObject.NULL) {
            aVar.icon = "";
        }
        aVar.qM = jSONObject.optString("desc");
        if (aVar.qM == JSONObject.NULL) {
            aVar.qM = "";
        }
        aVar.appId = jSONObject.optString(com.anythink.expressad.videocommon.e.b.f12231u);
        if (aVar.appId == JSONObject.NULL) {
            aVar.appId = "";
        }
        aVar.Td = jSONObject.optString("marketUri");
        if (aVar.Td == JSONObject.NULL) {
            aVar.Td = "";
        }
        aVar.Te = jSONObject.optBoolean("disableLandingPageDeepLink");
        aVar.Tf = jSONObject.optBoolean("isLandscapeSupported");
        aVar.Tg = jSONObject.optBoolean("isFromLive");
    }

    private static JSONObject b(q.a aVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        int i2 = aVar.type;
        if (i2 != 0) {
            com.kwad.sdk.utils.s.putValue(jSONObject, "type", i2);
        }
        String str = aVar.appName;
        if (str != null && !str.equals("")) {
            com.kwad.sdk.utils.s.putValue(jSONObject, DispatchConstants.APP_NAME, aVar.appName);
        }
        String str2 = aVar.SZ;
        if (str2 != null && !str2.equals("")) {
            com.kwad.sdk.utils.s.putValue(jSONObject, "pkgName", aVar.SZ);
        }
        String str3 = aVar.version;
        if (str3 != null && !str3.equals("")) {
            com.kwad.sdk.utils.s.putValue(jSONObject, "version", aVar.version);
        }
        int i3 = aVar.versionCode;
        if (i3 != 0) {
            com.kwad.sdk.utils.s.putValue(jSONObject, "versionCode", i3);
        }
        int i4 = aVar.Ta;
        if (i4 != 0) {
            com.kwad.sdk.utils.s.putValue(jSONObject, "appSize", i4);
        }
        String str4 = aVar.Tb;
        if (str4 != null && !str4.equals("")) {
            com.kwad.sdk.utils.s.putValue(jSONObject, "md5", aVar.Tb);
        }
        String str5 = aVar.url;
        if (str5 != null && !str5.equals("")) {
            com.kwad.sdk.utils.s.putValue(jSONObject, "url", aVar.url);
        }
        String str6 = aVar.Tc;
        if (str6 != null && !str6.equals("")) {
            com.kwad.sdk.utils.s.putValue(jSONObject, "appLink", aVar.Tc);
        }
        String str7 = aVar.icon;
        if (str7 != null && !str7.equals("")) {
            com.kwad.sdk.utils.s.putValue(jSONObject, "icon", aVar.icon);
        }
        String str8 = aVar.qM;
        if (str8 != null && !str8.equals("")) {
            com.kwad.sdk.utils.s.putValue(jSONObject, "desc", aVar.qM);
        }
        String str9 = aVar.appId;
        if (str9 != null && !str9.equals("")) {
            com.kwad.sdk.utils.s.putValue(jSONObject, com.anythink.expressad.videocommon.e.b.f12231u, aVar.appId);
        }
        String str10 = aVar.Td;
        if (str10 != null && !str10.equals("")) {
            com.kwad.sdk.utils.s.putValue(jSONObject, "marketUri", aVar.Td);
        }
        boolean z2 = aVar.Te;
        if (z2) {
            com.kwad.sdk.utils.s.putValue(jSONObject, "disableLandingPageDeepLink", z2);
        }
        boolean z3 = aVar.Tf;
        if (z3) {
            com.kwad.sdk.utils.s.putValue(jSONObject, "isLandscapeSupported", z3);
        }
        boolean z4 = aVar.Tg;
        if (z4) {
            com.kwad.sdk.utils.s.putValue(jSONObject, "isFromLive", z4);
        }
        return jSONObject;
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        a((q.a) bVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        return b((q.a) bVar, jSONObject);
    }
}
