package com.kwad.sdk.core.a.kwai;

import com.taobao.accs.common.Constants;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public final class ch implements com.kwad.sdk.core.d<com.kwad.sdk.core.request.model.b> {
    private static void a(com.kwad.sdk.core.request.model.b bVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        bVar.adB = jSONObject.optString("imei");
        if (bVar.adB == JSONObject.NULL) {
            bVar.adB = "";
        }
        bVar.akz = jSONObject.optString("imei1");
        if (bVar.akz == JSONObject.NULL) {
            bVar.akz = "";
        }
        bVar.akA = jSONObject.optString("imei2");
        if (bVar.akA == JSONObject.NULL) {
            bVar.akA = "";
        }
        bVar.akB = jSONObject.optString("meid");
        if (bVar.akB == JSONObject.NULL) {
            bVar.akB = "";
        }
        bVar.adC = jSONObject.optString("oaid");
        if (bVar.adC == JSONObject.NULL) {
            bVar.adC = "";
        }
        bVar.akC = jSONObject.optString("appMkt");
        if (bVar.akC == JSONObject.NULL) {
            bVar.akC = "";
        }
        bVar.akD = jSONObject.optString("appMktParam");
        if (bVar.akD == JSONObject.NULL) {
            bVar.akD = "";
        }
        bVar.OH = jSONObject.optString("romName");
        if (bVar.OH == JSONObject.NULL) {
            bVar.OH = "";
        }
        bVar.SO = jSONObject.optInt(Constants.KEY_OS_TYPE);
        bVar.SQ = jSONObject.optInt("osApi");
        bVar.akE = jSONObject.optString("osVersion");
        if (bVar.akE == JSONObject.NULL) {
            bVar.akE = "";
        }
        bVar.SR = jSONObject.optString("language");
        if (bVar.SR == JSONObject.NULL) {
            bVar.SR = "";
        }
        bVar.ST = jSONObject.optInt("screenWidth");
        bVar.SU = jSONObject.optInt("screenHeight");
        bVar.akF = jSONObject.optInt("deviceWidth");
        bVar.akG = jSONObject.optInt("deviceHeight");
        bVar.akH = jSONObject.optString("androidId");
        if (bVar.akH == JSONObject.NULL) {
            bVar.akH = "";
        }
        bVar.akI = jSONObject.optString("deviceId");
        if (bVar.akI == JSONObject.NULL) {
            bVar.akI = "";
        }
        bVar.akJ = jSONObject.optString("deviceVendor");
        if (bVar.akJ == JSONObject.NULL) {
            bVar.akJ = "";
        }
        bVar.akK = jSONObject.optInt("platform");
        bVar.akL = jSONObject.optString("deviceModel");
        if (bVar.akL == JSONObject.NULL) {
            bVar.akL = "";
        }
        bVar.SN = jSONObject.optString("deviceBrand");
        if (bVar.SN == JSONObject.NULL) {
            bVar.SN = "";
        }
        bVar.akM = jSONObject.optString("deviceSig");
        if (bVar.akM == JSONObject.NULL) {
            bVar.akM = "";
        }
        bVar.akN = jSONObject.optString("eGid");
        if (bVar.akN == JSONObject.NULL) {
            bVar.akN = "";
        }
        bVar.akO = jSONObject.optJSONArray("appPackageName");
        bVar.akP = jSONObject.optString("arch");
        if (bVar.akP == JSONObject.NULL) {
            bVar.akP = "";
        }
        bVar.akQ = jSONObject.optInt("screenDirection");
        bVar.akR = jSONObject.optString("kwaiVersionName");
        if (bVar.akR == JSONObject.NULL) {
            bVar.akR = "";
        }
        bVar.akS = jSONObject.optString("kwaiNebulaVersionName");
        if (bVar.akS == JSONObject.NULL) {
            bVar.akS = "";
        }
        bVar.akT = jSONObject.optString("wechatVersionName");
        if (bVar.akT == JSONObject.NULL) {
            bVar.akT = "";
        }
        bVar.akU = jSONObject.optLong("sourceFlag");
        bVar.akV = jSONObject.optString("systemBootTime");
        if (bVar.akV == JSONObject.NULL) {
            bVar.akV = "";
        }
        bVar.akW = jSONObject.optString("systemUpdateTime");
        if (bVar.akW == JSONObject.NULL) {
            bVar.akW = "";
        }
    }

    private static JSONObject b(com.kwad.sdk.core.request.model.b bVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        String str = bVar.adB;
        if (str != null && !str.equals("")) {
            com.kwad.sdk.utils.s.putValue(jSONObject, "imei", bVar.adB);
        }
        String str2 = bVar.akz;
        if (str2 != null && !str2.equals("")) {
            com.kwad.sdk.utils.s.putValue(jSONObject, "imei1", bVar.akz);
        }
        String str3 = bVar.akA;
        if (str3 != null && !str3.equals("")) {
            com.kwad.sdk.utils.s.putValue(jSONObject, "imei2", bVar.akA);
        }
        String str4 = bVar.akB;
        if (str4 != null && !str4.equals("")) {
            com.kwad.sdk.utils.s.putValue(jSONObject, "meid", bVar.akB);
        }
        String str5 = bVar.adC;
        if (str5 != null && !str5.equals("")) {
            com.kwad.sdk.utils.s.putValue(jSONObject, "oaid", bVar.adC);
        }
        String str6 = bVar.akC;
        if (str6 != null && !str6.equals("")) {
            com.kwad.sdk.utils.s.putValue(jSONObject, "appMkt", bVar.akC);
        }
        String str7 = bVar.akD;
        if (str7 != null && !str7.equals("")) {
            com.kwad.sdk.utils.s.putValue(jSONObject, "appMktParam", bVar.akD);
        }
        String str8 = bVar.OH;
        if (str8 != null && !str8.equals("")) {
            com.kwad.sdk.utils.s.putValue(jSONObject, "romName", bVar.OH);
        }
        int i2 = bVar.SO;
        if (i2 != 0) {
            com.kwad.sdk.utils.s.putValue(jSONObject, Constants.KEY_OS_TYPE, i2);
        }
        int i3 = bVar.SQ;
        if (i3 != 0) {
            com.kwad.sdk.utils.s.putValue(jSONObject, "osApi", i3);
        }
        String str9 = bVar.akE;
        if (str9 != null && !str9.equals("")) {
            com.kwad.sdk.utils.s.putValue(jSONObject, "osVersion", bVar.akE);
        }
        String str10 = bVar.SR;
        if (str10 != null && !str10.equals("")) {
            com.kwad.sdk.utils.s.putValue(jSONObject, "language", bVar.SR);
        }
        int i4 = bVar.ST;
        if (i4 != 0) {
            com.kwad.sdk.utils.s.putValue(jSONObject, "screenWidth", i4);
        }
        int i5 = bVar.SU;
        if (i5 != 0) {
            com.kwad.sdk.utils.s.putValue(jSONObject, "screenHeight", i5);
        }
        int i6 = bVar.akF;
        if (i6 != 0) {
            com.kwad.sdk.utils.s.putValue(jSONObject, "deviceWidth", i6);
        }
        int i7 = bVar.akG;
        if (i7 != 0) {
            com.kwad.sdk.utils.s.putValue(jSONObject, "deviceHeight", i7);
        }
        String str11 = bVar.akH;
        if (str11 != null && !str11.equals("")) {
            com.kwad.sdk.utils.s.putValue(jSONObject, "androidId", bVar.akH);
        }
        String str12 = bVar.akI;
        if (str12 != null && !str12.equals("")) {
            com.kwad.sdk.utils.s.putValue(jSONObject, "deviceId", bVar.akI);
        }
        String str13 = bVar.akJ;
        if (str13 != null && !str13.equals("")) {
            com.kwad.sdk.utils.s.putValue(jSONObject, "deviceVendor", bVar.akJ);
        }
        int i8 = bVar.akK;
        if (i8 != 0) {
            com.kwad.sdk.utils.s.putValue(jSONObject, "platform", i8);
        }
        String str14 = bVar.akL;
        if (str14 != null && !str14.equals("")) {
            com.kwad.sdk.utils.s.putValue(jSONObject, "deviceModel", bVar.akL);
        }
        String str15 = bVar.SN;
        if (str15 != null && !str15.equals("")) {
            com.kwad.sdk.utils.s.putValue(jSONObject, "deviceBrand", bVar.SN);
        }
        String str16 = bVar.akM;
        if (str16 != null && !str16.equals("")) {
            com.kwad.sdk.utils.s.putValue(jSONObject, "deviceSig", bVar.akM);
        }
        String str17 = bVar.akN;
        if (str17 != null && !str17.equals("")) {
            com.kwad.sdk.utils.s.putValue(jSONObject, "eGid", bVar.akN);
        }
        com.kwad.sdk.utils.s.putValue(jSONObject, "appPackageName", bVar.akO);
        String str18 = bVar.akP;
        if (str18 != null && !str18.equals("")) {
            com.kwad.sdk.utils.s.putValue(jSONObject, "arch", bVar.akP);
        }
        int i9 = bVar.akQ;
        if (i9 != 0) {
            com.kwad.sdk.utils.s.putValue(jSONObject, "screenDirection", i9);
        }
        String str19 = bVar.akR;
        if (str19 != null && !str19.equals("")) {
            com.kwad.sdk.utils.s.putValue(jSONObject, "kwaiVersionName", bVar.akR);
        }
        String str20 = bVar.akS;
        if (str20 != null && !str20.equals("")) {
            com.kwad.sdk.utils.s.putValue(jSONObject, "kwaiNebulaVersionName", bVar.akS);
        }
        String str21 = bVar.akT;
        if (str21 != null && !str21.equals("")) {
            com.kwad.sdk.utils.s.putValue(jSONObject, "wechatVersionName", bVar.akT);
        }
        long j2 = bVar.akU;
        if (j2 != 0) {
            com.kwad.sdk.utils.s.putValue(jSONObject, "sourceFlag", j2);
        }
        String str22 = bVar.akV;
        if (str22 != null && !str22.equals("")) {
            com.kwad.sdk.utils.s.putValue(jSONObject, "systemBootTime", bVar.akV);
        }
        String str23 = bVar.akW;
        if (str23 != null && !str23.equals("")) {
            com.kwad.sdk.utils.s.putValue(jSONObject, "systemUpdateTime", bVar.akW);
        }
        return jSONObject;
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        a((com.kwad.sdk.core.request.model.b) bVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        return b((com.kwad.sdk.core.request.model.b) bVar, jSONObject);
    }
}
