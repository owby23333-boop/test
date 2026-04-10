package com.kwad.sdk.core.b.a;

import com.kwad.components.core.webview.jshandler.ah;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
public final class is implements com.kwad.sdk.core.d<ah.a> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        a((ah.a) bVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        return b((ah.a) bVar, jSONObject);
    }

    private static void a(ah.a aVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        aVar.SDKVersion = jSONObject.optString("SDKVersion");
        if (JSONObject.NULL.toString().equals(aVar.SDKVersion)) {
            aVar.SDKVersion = "";
        }
        aVar.SDKVersionCode = jSONObject.optInt("SDKVersionCode");
        aVar.sdkApiVersion = jSONObject.optString("sdkApiVersion");
        if (JSONObject.NULL.toString().equals(aVar.sdkApiVersion)) {
            aVar.sdkApiVersion = "";
        }
        aVar.sdkApiVersionCode = jSONObject.optInt("sdkApiVersionCode");
        aVar.sdkType = jSONObject.optInt("sdkType");
        aVar.appVersion = jSONObject.optString("appVersion");
        if (JSONObject.NULL.toString().equals(aVar.appVersion)) {
            aVar.appVersion = "";
        }
        aVar.appName = jSONObject.optString("appName");
        if (JSONObject.NULL.toString().equals(aVar.appName)) {
            aVar.appName = "";
        }
        aVar.appId = jSONObject.optString("appId");
        if (JSONObject.NULL.toString().equals(aVar.appId)) {
            aVar.appId = "";
        }
        aVar.adg = jSONObject.optString("networkType");
        if (JSONObject.NULL.toString().equals(aVar.adg)) {
            aVar.adg = "";
        }
        aVar.adh = jSONObject.optString("manufacturer");
        if (JSONObject.NULL.toString().equals(aVar.adh)) {
            aVar.adh = "";
        }
        aVar.model = jSONObject.optString("model");
        if (JSONObject.NULL.toString().equals(aVar.model)) {
            aVar.model = "";
        }
        aVar.LN = jSONObject.optString("deviceBrand");
        if (JSONObject.NULL.toString().equals(aVar.LN)) {
            aVar.LN = "";
        }
        aVar.adi = jSONObject.optInt("osType");
        aVar.adj = jSONObject.optString("systemVersion");
        if (JSONObject.NULL.toString().equals(aVar.adj)) {
            aVar.adj = "";
        }
        aVar.adk = jSONObject.optInt("osApi");
        aVar.adl = jSONObject.optString("language");
        if (JSONObject.NULL.toString().equals(aVar.adl)) {
            aVar.adl = "";
        }
        aVar.adm = jSONObject.optString("locale");
        if (JSONObject.NULL.toString().equals(aVar.adm)) {
            aVar.adm = "";
        }
        aVar.Qw = jSONObject.optInt("screenWidth");
        aVar.Qv = jSONObject.optInt("screenHeight");
        aVar.adn = jSONObject.optInt("statusBarHeight");
        aVar.ado = jSONObject.optInt("titleBarHeight");
    }

    private static JSONObject b(ah.a aVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        if (aVar.SDKVersion != null && !aVar.SDKVersion.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "SDKVersion", aVar.SDKVersion);
        }
        if (aVar.SDKVersionCode != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "SDKVersionCode", aVar.SDKVersionCode);
        }
        if (aVar.sdkApiVersion != null && !aVar.sdkApiVersion.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "sdkApiVersion", aVar.sdkApiVersion);
        }
        if (aVar.sdkApiVersionCode != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "sdkApiVersionCode", aVar.sdkApiVersionCode);
        }
        if (aVar.sdkType != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "sdkType", aVar.sdkType);
        }
        if (aVar.appVersion != null && !aVar.appVersion.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "appVersion", aVar.appVersion);
        }
        if (aVar.appName != null && !aVar.appName.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "appName", aVar.appName);
        }
        if (aVar.appId != null && !aVar.appId.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "appId", aVar.appId);
        }
        if (aVar.adg != null && !aVar.adg.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "networkType", aVar.adg);
        }
        if (aVar.adh != null && !aVar.adh.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "manufacturer", aVar.adh);
        }
        if (aVar.model != null && !aVar.model.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "model", aVar.model);
        }
        if (aVar.LN != null && !aVar.LN.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "deviceBrand", aVar.LN);
        }
        if (aVar.adi != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "osType", aVar.adi);
        }
        if (aVar.adj != null && !aVar.adj.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "systemVersion", aVar.adj);
        }
        if (aVar.adk != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "osApi", aVar.adk);
        }
        if (aVar.adl != null && !aVar.adl.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "language", aVar.adl);
        }
        if (aVar.adm != null && !aVar.adm.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "locale", aVar.adm);
        }
        if (aVar.Qw != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "screenWidth", aVar.Qw);
        }
        if (aVar.Qv != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "screenHeight", aVar.Qv);
        }
        if (aVar.adn != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "statusBarHeight", aVar.adn);
        }
        if (aVar.ado != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "titleBarHeight", aVar.ado);
        }
        return jSONObject;
    }
}
