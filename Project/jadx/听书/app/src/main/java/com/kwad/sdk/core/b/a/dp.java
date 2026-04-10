package com.kwad.sdk.core.b.a;

import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
public final class dp implements com.kwad.sdk.core.d<com.kwad.sdk.core.request.model.b> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        a((com.kwad.sdk.core.request.model.b) bVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        return b((com.kwad.sdk.core.request.model.b) bVar, jSONObject);
    }

    private static void a(com.kwad.sdk.core.request.model.b bVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        bVar.aCk = jSONObject.optString("imei");
        if (JSONObject.NULL.toString().equals(bVar.aCk)) {
            bVar.aCk = "";
        }
        bVar.aId = jSONObject.optString("imei1");
        if (JSONObject.NULL.toString().equals(bVar.aId)) {
            bVar.aId = "";
        }
        bVar.aIe = jSONObject.optString("imei2");
        if (JSONObject.NULL.toString().equals(bVar.aIe)) {
            bVar.aIe = "";
        }
        bVar.aIf = jSONObject.optString("meid");
        if (JSONObject.NULL.toString().equals(bVar.aIf)) {
            bVar.aIf = "";
        }
        bVar.aCl = jSONObject.optString("oaid");
        if (JSONObject.NULL.toString().equals(bVar.aCl)) {
            bVar.aCl = "";
        }
        bVar.aIg = jSONObject.optString("appMkt");
        if (JSONObject.NULL.toString().equals(bVar.aIg)) {
            bVar.aIg = "";
        }
        bVar.aIh = jSONObject.optString("appMktParam");
        if (JSONObject.NULL.toString().equals(bVar.aIh)) {
            bVar.aIh = "";
        }
        bVar.LP = jSONObject.optString("romName");
        if (JSONObject.NULL.toString().equals(bVar.LP)) {
            bVar.LP = "";
        }
        bVar.adi = jSONObject.optInt("osType");
        bVar.adk = jSONObject.optInt("osApi");
        bVar.LO = jSONObject.optString("osVersion");
        if (JSONObject.NULL.toString().equals(bVar.LO)) {
            bVar.LO = "";
        }
        bVar.adl = jSONObject.optString("language");
        if (JSONObject.NULL.toString().equals(bVar.adl)) {
            bVar.adl = "";
        }
        bVar.Qw = jSONObject.optInt("screenWidth");
        bVar.Qv = jSONObject.optInt("screenHeight");
        bVar.aIi = jSONObject.optInt("deviceWidth");
        bVar.aIj = jSONObject.optInt("deviceHeight");
        bVar.aIk = jSONObject.optString("androidId");
        if (JSONObject.NULL.toString().equals(bVar.aIk)) {
            bVar.aIk = "";
        }
        bVar.LQ = jSONObject.optString("deviceId");
        if (JSONObject.NULL.toString().equals(bVar.LQ)) {
            bVar.LQ = "";
        }
        bVar.aIl = jSONObject.optString("deviceVendor");
        if (JSONObject.NULL.toString().equals(bVar.aIl)) {
            bVar.aIl = "";
        }
        bVar.aIm = jSONObject.optInt("platform");
        bVar.LM = jSONObject.optString("deviceModel");
        if (JSONObject.NULL.toString().equals(bVar.LM)) {
            bVar.LM = "";
        }
        bVar.LN = jSONObject.optString("deviceBrand");
        if (JSONObject.NULL.toString().equals(bVar.LN)) {
            bVar.LN = "";
        }
        bVar.aIn = jSONObject.optString("deviceSig");
        if (JSONObject.NULL.toString().equals(bVar.aIn)) {
            bVar.aIn = "";
        }
        bVar.aIo = jSONObject.optString("eGid");
        if (JSONObject.NULL.toString().equals(bVar.aIo)) {
            bVar.aIo = "";
        }
        bVar.aIp = jSONObject.optJSONArray("appPackageName");
        bVar.aIq = jSONObject.optString("uaidToken");
        if (JSONObject.NULL.toString().equals(bVar.aIq)) {
            bVar.aIq = "";
        }
        bVar.uaid = jSONObject.optString("uaid");
        if (JSONObject.NULL.toString().equals(bVar.uaid)) {
            bVar.uaid = "";
        }
        bVar.aIr = jSONObject.optString("arch");
        if (JSONObject.NULL.toString().equals(bVar.aIr)) {
            bVar.aIr = "";
        }
        bVar.aIs = jSONObject.optInt("screenDirection");
        bVar.aIt = jSONObject.optString("kwaiVersionName");
        if (JSONObject.NULL.toString().equals(bVar.aIt)) {
            bVar.aIt = "";
        }
        bVar.aIu = jSONObject.optString("kwaiNebulaVersionName");
        if (JSONObject.NULL.toString().equals(bVar.aIu)) {
            bVar.aIu = "";
        }
        bVar.aIv = jSONObject.optString("wechatVersionName");
        if (JSONObject.NULL.toString().equals(bVar.aIv)) {
            bVar.aIv = "";
        }
        bVar.aIw = jSONObject.optLong("sourceFlag");
        bVar.aIx = jSONObject.optString("systemBootTime");
        if (JSONObject.NULL.toString().equals(bVar.aIx)) {
            bVar.aIx = "";
        }
        bVar.aIy = jSONObject.optString("systemUpdateTime");
        if (JSONObject.NULL.toString().equals(bVar.aIy)) {
            bVar.aIy = "";
        }
        bVar.aIz = jSONObject.optInt("probeBatch");
    }

    private static JSONObject b(com.kwad.sdk.core.request.model.b bVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        if (bVar.aCk != null && !bVar.aCk.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "imei", bVar.aCk);
        }
        if (bVar.aId != null && !bVar.aId.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "imei1", bVar.aId);
        }
        if (bVar.aIe != null && !bVar.aIe.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "imei2", bVar.aIe);
        }
        if (bVar.aIf != null && !bVar.aIf.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "meid", bVar.aIf);
        }
        if (bVar.aCl != null && !bVar.aCl.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "oaid", bVar.aCl);
        }
        if (bVar.aIg != null && !bVar.aIg.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "appMkt", bVar.aIg);
        }
        if (bVar.aIh != null && !bVar.aIh.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "appMktParam", bVar.aIh);
        }
        if (bVar.LP != null && !bVar.LP.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "romName", bVar.LP);
        }
        if (bVar.adi != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "osType", bVar.adi);
        }
        if (bVar.adk != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "osApi", bVar.adk);
        }
        if (bVar.LO != null && !bVar.LO.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "osVersion", bVar.LO);
        }
        if (bVar.adl != null && !bVar.adl.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "language", bVar.adl);
        }
        if (bVar.Qw != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "screenWidth", bVar.Qw);
        }
        if (bVar.Qv != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "screenHeight", bVar.Qv);
        }
        if (bVar.aIi != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "deviceWidth", bVar.aIi);
        }
        if (bVar.aIj != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "deviceHeight", bVar.aIj);
        }
        if (bVar.aIk != null && !bVar.aIk.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "androidId", bVar.aIk);
        }
        if (bVar.LQ != null && !bVar.LQ.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "deviceId", bVar.LQ);
        }
        if (bVar.aIl != null && !bVar.aIl.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "deviceVendor", bVar.aIl);
        }
        if (bVar.aIm != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "platform", bVar.aIm);
        }
        if (bVar.LM != null && !bVar.LM.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "deviceModel", bVar.LM);
        }
        if (bVar.LN != null && !bVar.LN.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "deviceBrand", bVar.LN);
        }
        if (bVar.aIn != null && !bVar.aIn.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "deviceSig", bVar.aIn);
        }
        if (bVar.aIo != null && !bVar.aIo.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "eGid", bVar.aIo);
        }
        com.kwad.sdk.utils.aa.putValue(jSONObject, "appPackageName", bVar.aIp);
        if (bVar.aIq != null && !bVar.aIq.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "uaidToken", bVar.aIq);
        }
        if (bVar.uaid != null && !bVar.uaid.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "uaid", bVar.uaid);
        }
        if (bVar.aIr != null && !bVar.aIr.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "arch", bVar.aIr);
        }
        if (bVar.aIs != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "screenDirection", bVar.aIs);
        }
        if (bVar.aIt != null && !bVar.aIt.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "kwaiVersionName", bVar.aIt);
        }
        if (bVar.aIu != null && !bVar.aIu.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "kwaiNebulaVersionName", bVar.aIu);
        }
        if (bVar.aIv != null && !bVar.aIv.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "wechatVersionName", bVar.aIv);
        }
        if (bVar.aIw != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "sourceFlag", bVar.aIw);
        }
        if (bVar.aIx != null && !bVar.aIx.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "systemBootTime", bVar.aIx);
        }
        if (bVar.aIy != null && !bVar.aIy.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "systemUpdateTime", bVar.aIy);
        }
        if (bVar.aIz != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "probeBatch", bVar.aIz);
        }
        return jSONObject;
    }
}
