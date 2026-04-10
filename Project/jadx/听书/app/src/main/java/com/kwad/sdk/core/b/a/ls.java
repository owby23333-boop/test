package com.kwad.sdk.core.b.a;

import com.kwad.components.core.webview.jshandler.aj;
import com.kwad.components.offline.api.tk.model.report.TKDownloadReason;
import com.xuexiang.xupdate.proxy.impl.DefaultUpdateParser;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
public final class ls implements com.kwad.sdk.core.d<aj.a> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        a((aj.a) bVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        return b((aj.a) bVar, jSONObject);
    }

    private static void a(aj.a aVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        aVar.type = jSONObject.optInt("type");
        aVar.appName = jSONObject.optString("appName");
        if (JSONObject.NULL.toString().equals(aVar.appName)) {
            aVar.appName = "";
        }
        aVar.pkgName = jSONObject.optString("pkgName");
        if (JSONObject.NULL.toString().equals(aVar.pkgName)) {
            aVar.pkgName = "";
        }
        aVar.version = jSONObject.optString("version");
        if (JSONObject.NULL.toString().equals(aVar.version)) {
            aVar.version = "";
        }
        aVar.versionCode = jSONObject.optInt(DefaultUpdateParser.APIKeyLower.VERSION_CODE);
        aVar.adr = jSONObject.optInt("appSize");
        aVar.md5 = jSONObject.optString(TKDownloadReason.KSAD_TK_MD5);
        if (JSONObject.NULL.toString().equals(aVar.md5)) {
            aVar.md5 = "";
        }
        aVar.url = jSONObject.optString("url");
        if (JSONObject.NULL.toString().equals(aVar.url)) {
            aVar.url = "";
        }
        aVar.ads = jSONObject.optString("appLink");
        if (JSONObject.NULL.toString().equals(aVar.ads)) {
            aVar.ads = "";
        }
        aVar.icon = jSONObject.optString("icon");
        if (JSONObject.NULL.toString().equals(aVar.icon)) {
            aVar.icon = "";
        }
        aVar.sX = jSONObject.optString("desc");
        if (JSONObject.NULL.toString().equals(aVar.sX)) {
            aVar.sX = "";
        }
        aVar.appId = jSONObject.optString("appId");
        if (JSONObject.NULL.toString().equals(aVar.appId)) {
            aVar.appId = "";
        }
        aVar.adt = jSONObject.optString("marketUri");
        if (JSONObject.NULL.toString().equals(aVar.adt)) {
            aVar.adt = "";
        }
        aVar.adu = jSONObject.optBoolean("disableLandingPageDeepLink");
        aVar.adv = jSONObject.optBoolean("isLandscapeSupported");
        aVar.adw = jSONObject.optBoolean("isFromLive");
    }

    private static JSONObject b(aj.a aVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        if (aVar.type != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "type", aVar.type);
        }
        if (aVar.appName != null && !aVar.appName.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "appName", aVar.appName);
        }
        if (aVar.pkgName != null && !aVar.pkgName.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "pkgName", aVar.pkgName);
        }
        if (aVar.version != null && !aVar.version.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "version", aVar.version);
        }
        if (aVar.versionCode != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, DefaultUpdateParser.APIKeyLower.VERSION_CODE, aVar.versionCode);
        }
        if (aVar.adr != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "appSize", aVar.adr);
        }
        if (aVar.md5 != null && !aVar.md5.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, TKDownloadReason.KSAD_TK_MD5, aVar.md5);
        }
        if (aVar.url != null && !aVar.url.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "url", aVar.url);
        }
        if (aVar.ads != null && !aVar.ads.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "appLink", aVar.ads);
        }
        if (aVar.icon != null && !aVar.icon.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "icon", aVar.icon);
        }
        if (aVar.sX != null && !aVar.sX.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "desc", aVar.sX);
        }
        if (aVar.appId != null && !aVar.appId.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "appId", aVar.appId);
        }
        if (aVar.adt != null && !aVar.adt.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "marketUri", aVar.adt);
        }
        if (aVar.adu) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "disableLandingPageDeepLink", aVar.adu);
        }
        if (aVar.adv) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "isLandscapeSupported", aVar.adv);
        }
        if (aVar.adw) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "isFromLive", aVar.adw);
        }
        return jSONObject;
    }
}
