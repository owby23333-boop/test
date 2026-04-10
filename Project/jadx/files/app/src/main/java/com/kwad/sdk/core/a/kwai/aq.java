package com.kwad.sdk.core.a.kwai;

import anet.channel.strategy.dispatch.DispatchConstants;
import com.kwad.components.core.webview.jshandler.ab;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public final class aq implements com.kwad.sdk.core.d<ab.b> {
    private static void a(ab.b bVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        bVar.appName = jSONObject.optString(DispatchConstants.APP_NAME);
        if (bVar.appName == JSONObject.NULL) {
            bVar.appName = "";
        }
        bVar.SZ = jSONObject.optString("pkgName");
        if (bVar.SZ == JSONObject.NULL) {
            bVar.SZ = "";
        }
        bVar.version = jSONObject.optString("version");
        if (bVar.version == JSONObject.NULL) {
            bVar.version = "";
        }
        bVar.versionCode = jSONObject.optInt("versionCode");
        bVar.TM = jSONObject.optLong("appSize");
        bVar.Tb = jSONObject.optString("md5");
        if (bVar.Tb == JSONObject.NULL) {
            bVar.Tb = "";
        }
        bVar.url = jSONObject.optString("url");
        if (bVar.url == JSONObject.NULL) {
            bVar.url = "";
        }
        bVar.icon = jSONObject.optString("icon");
        if (bVar.icon == JSONObject.NULL) {
            bVar.icon = "";
        }
        bVar.qM = jSONObject.optString("desc");
        if (bVar.qM == JSONObject.NULL) {
            bVar.qM = "";
        }
    }

    private static JSONObject b(ab.b bVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        String str = bVar.appName;
        if (str != null && !str.equals("")) {
            com.kwad.sdk.utils.s.putValue(jSONObject, DispatchConstants.APP_NAME, bVar.appName);
        }
        String str2 = bVar.SZ;
        if (str2 != null && !str2.equals("")) {
            com.kwad.sdk.utils.s.putValue(jSONObject, "pkgName", bVar.SZ);
        }
        String str3 = bVar.version;
        if (str3 != null && !str3.equals("")) {
            com.kwad.sdk.utils.s.putValue(jSONObject, "version", bVar.version);
        }
        int i2 = bVar.versionCode;
        if (i2 != 0) {
            com.kwad.sdk.utils.s.putValue(jSONObject, "versionCode", i2);
        }
        long j2 = bVar.TM;
        if (j2 != 0) {
            com.kwad.sdk.utils.s.putValue(jSONObject, "appSize", j2);
        }
        String str4 = bVar.Tb;
        if (str4 != null && !str4.equals("")) {
            com.kwad.sdk.utils.s.putValue(jSONObject, "md5", bVar.Tb);
        }
        String str5 = bVar.url;
        if (str5 != null && !str5.equals("")) {
            com.kwad.sdk.utils.s.putValue(jSONObject, "url", bVar.url);
        }
        String str6 = bVar.icon;
        if (str6 != null && !str6.equals("")) {
            com.kwad.sdk.utils.s.putValue(jSONObject, "icon", bVar.icon);
        }
        String str7 = bVar.qM;
        if (str7 != null && !str7.equals("")) {
            com.kwad.sdk.utils.s.putValue(jSONObject, "desc", bVar.qM);
        }
        return jSONObject;
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        a((ab.b) bVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        return b((ab.b) bVar, jSONObject);
    }
}
