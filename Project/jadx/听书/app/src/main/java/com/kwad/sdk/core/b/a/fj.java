package com.kwad.sdk.core.b.a;

import com.kwad.sdk.core.webview.d.a;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
public final class fj implements com.kwad.sdk.core.d<a.C0411a> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        a((a.C0411a) bVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        return b((a.C0411a) bVar, jSONObject);
    }

    private static void a(a.C0411a c0411a, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        c0411a.SDKVersion = jSONObject.optString("SDKVersion");
        if (JSONObject.NULL.toString().equals(c0411a.SDKVersion)) {
            c0411a.SDKVersion = "";
        }
        c0411a.SDKVersionCode = jSONObject.optInt("SDKVersionCode");
        c0411a.aHz = jSONObject.optString("tkVersion");
        if (JSONObject.NULL.toString().equals(c0411a.aHz)) {
            c0411a.aHz = "";
        }
        c0411a.sdkApiVersion = jSONObject.optString("sdkApiVersion");
        if (JSONObject.NULL.toString().equals(c0411a.sdkApiVersion)) {
            c0411a.sdkApiVersion = "";
        }
        c0411a.sdkApiVersionCode = jSONObject.optInt("sdkApiVersionCode");
        c0411a.sdkType = jSONObject.optInt("sdkType");
        c0411a.appVersion = jSONObject.optString("appVersion");
        if (JSONObject.NULL.toString().equals(c0411a.appVersion)) {
            c0411a.appVersion = "";
        }
        c0411a.appName = jSONObject.optString("appName");
        if (JSONObject.NULL.toString().equals(c0411a.appName)) {
            c0411a.appName = "";
        }
        c0411a.appId = jSONObject.optString("appId");
        if (JSONObject.NULL.toString().equals(c0411a.appId)) {
            c0411a.appId = "";
        }
        c0411a.aNI = jSONObject.optString("globalId");
        if (JSONObject.NULL.toString().equals(c0411a.aNI)) {
            c0411a.aNI = "";
        }
        c0411a.aIo = jSONObject.optString("eGid");
        if (JSONObject.NULL.toString().equals(c0411a.aIo)) {
            c0411a.aIo = "";
        }
        c0411a.aIn = jSONObject.optString("deviceSig");
        if (JSONObject.NULL.toString().equals(c0411a.aIn)) {
            c0411a.aIn = "";
        }
        c0411a.adg = jSONObject.optString("networkType");
        if (JSONObject.NULL.toString().equals(c0411a.adg)) {
            c0411a.adg = "";
        }
        c0411a.adh = jSONObject.optString("manufacturer");
        if (JSONObject.NULL.toString().equals(c0411a.adh)) {
            c0411a.adh = "";
        }
        c0411a.model = jSONObject.optString("model");
        if (JSONObject.NULL.toString().equals(c0411a.model)) {
            c0411a.model = "";
        }
        c0411a.LN = jSONObject.optString("deviceBrand");
        if (JSONObject.NULL.toString().equals(c0411a.LN)) {
            c0411a.LN = "";
        }
        c0411a.adi = jSONObject.optInt("osType");
        c0411a.adj = jSONObject.optString("systemVersion");
        if (JSONObject.NULL.toString().equals(c0411a.adj)) {
            c0411a.adj = "";
        }
        c0411a.adk = jSONObject.optInt("osApi");
        c0411a.adl = jSONObject.optString("language");
        if (JSONObject.NULL.toString().equals(c0411a.adl)) {
            c0411a.adl = "";
        }
        c0411a.adm = jSONObject.optString("locale");
        if (JSONObject.NULL.toString().equals(c0411a.adm)) {
            c0411a.adm = "";
        }
        c0411a.aNJ = jSONObject.optString("uuid");
        if (JSONObject.NULL.toString().equals(c0411a.aNJ)) {
            c0411a.aNJ = "";
        }
        c0411a.aNK = jSONObject.optBoolean("isDynamic");
        c0411a.Qw = jSONObject.optInt("screenWidth");
        c0411a.Qv = jSONObject.optInt("screenHeight");
        c0411a.aCk = jSONObject.optString("imei");
        if (JSONObject.NULL.toString().equals(c0411a.aCk)) {
            c0411a.aCk = "";
        }
        c0411a.aCl = jSONObject.optString("oaid");
        if (JSONObject.NULL.toString().equals(c0411a.aCl)) {
            c0411a.aCl = "";
        }
        c0411a.aIk = jSONObject.optString("androidId");
        if (JSONObject.NULL.toString().equals(c0411a.aIk)) {
            c0411a.aIk = "";
        }
        c0411a.aIB = jSONObject.optString("mac");
        if (JSONObject.NULL.toString().equals(c0411a.aIB)) {
            c0411a.aIB = "";
        }
        c0411a.adn = jSONObject.optInt("statusBarHeight");
        c0411a.ado = jSONObject.optInt("titleBarHeight");
        c0411a.aNL = jSONObject.optString("bridgeVersion");
        if (JSONObject.NULL.toString().equals(c0411a.aNL)) {
            c0411a.aNL = "";
        }
    }

    private static JSONObject b(a.C0411a c0411a, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        if (c0411a.SDKVersion != null && !c0411a.SDKVersion.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "SDKVersion", c0411a.SDKVersion);
        }
        if (c0411a.SDKVersionCode != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "SDKVersionCode", c0411a.SDKVersionCode);
        }
        if (c0411a.aHz != null && !c0411a.aHz.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "tkVersion", c0411a.aHz);
        }
        if (c0411a.sdkApiVersion != null && !c0411a.sdkApiVersion.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "sdkApiVersion", c0411a.sdkApiVersion);
        }
        if (c0411a.sdkApiVersionCode != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "sdkApiVersionCode", c0411a.sdkApiVersionCode);
        }
        if (c0411a.sdkType != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "sdkType", c0411a.sdkType);
        }
        if (c0411a.appVersion != null && !c0411a.appVersion.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "appVersion", c0411a.appVersion);
        }
        if (c0411a.appName != null && !c0411a.appName.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "appName", c0411a.appName);
        }
        if (c0411a.appId != null && !c0411a.appId.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "appId", c0411a.appId);
        }
        if (c0411a.aNI != null && !c0411a.aNI.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "globalId", c0411a.aNI);
        }
        if (c0411a.aIo != null && !c0411a.aIo.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "eGid", c0411a.aIo);
        }
        if (c0411a.aIn != null && !c0411a.aIn.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "deviceSig", c0411a.aIn);
        }
        if (c0411a.adg != null && !c0411a.adg.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "networkType", c0411a.adg);
        }
        if (c0411a.adh != null && !c0411a.adh.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "manufacturer", c0411a.adh);
        }
        if (c0411a.model != null && !c0411a.model.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "model", c0411a.model);
        }
        if (c0411a.LN != null && !c0411a.LN.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "deviceBrand", c0411a.LN);
        }
        if (c0411a.adi != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "osType", c0411a.adi);
        }
        if (c0411a.adj != null && !c0411a.adj.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "systemVersion", c0411a.adj);
        }
        if (c0411a.adk != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "osApi", c0411a.adk);
        }
        if (c0411a.adl != null && !c0411a.adl.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "language", c0411a.adl);
        }
        if (c0411a.adm != null && !c0411a.adm.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "locale", c0411a.adm);
        }
        if (c0411a.aNJ != null && !c0411a.aNJ.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "uuid", c0411a.aNJ);
        }
        if (c0411a.aNK) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "isDynamic", c0411a.aNK);
        }
        if (c0411a.Qw != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "screenWidth", c0411a.Qw);
        }
        if (c0411a.Qv != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "screenHeight", c0411a.Qv);
        }
        if (c0411a.aCk != null && !c0411a.aCk.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "imei", c0411a.aCk);
        }
        if (c0411a.aCl != null && !c0411a.aCl.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "oaid", c0411a.aCl);
        }
        if (c0411a.aIk != null && !c0411a.aIk.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "androidId", c0411a.aIk);
        }
        if (c0411a.aIB != null && !c0411a.aIB.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "mac", c0411a.aIB);
        }
        if (c0411a.adn != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "statusBarHeight", c0411a.adn);
        }
        if (c0411a.ado != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "titleBarHeight", c0411a.ado);
        }
        if (c0411a.aNL != null && !c0411a.aNL.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "bridgeVersion", c0411a.aNL);
        }
        return jSONObject;
    }
}
