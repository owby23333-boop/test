package com.kwad.sdk.core.a.kwai;

import anet.channel.strategy.dispatch.DispatchConstants;
import com.kwad.sdk.core.webview.c.a;
import com.taobao.accs.common.Constants;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public final class dr implements com.kwad.sdk.core.d<a.C0448a> {
    private static void a(a.C0448a c0448a, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        c0448a.SG = jSONObject.optString("SDKVersion");
        if (c0448a.SG == JSONObject.NULL) {
            c0448a.SG = "";
        }
        c0448a.SH = jSONObject.optInt("SDKVersionCode");
        c0448a.aje = jSONObject.optString("tkVersion");
        if (c0448a.aje == JSONObject.NULL) {
            c0448a.aje = "";
        }
        c0448a.SI = jSONObject.optString("sdkApiVersion");
        if (c0448a.SI == JSONObject.NULL) {
            c0448a.SI = "";
        }
        c0448a.SJ = jSONObject.optInt("sdkApiVersionCode");
        c0448a.SK = jSONObject.optInt("sdkType");
        c0448a.appVersion = jSONObject.optString("appVersion");
        if (c0448a.appVersion == JSONObject.NULL) {
            c0448a.appVersion = "";
        }
        c0448a.appName = jSONObject.optString(DispatchConstants.APP_NAME);
        if (c0448a.appName == JSONObject.NULL) {
            c0448a.appName = "";
        }
        c0448a.appId = jSONObject.optString(com.anythink.expressad.videocommon.e.b.f12231u);
        if (c0448a.appId == JSONObject.NULL) {
            c0448a.appId = "";
        }
        c0448a.apC = jSONObject.optString("globalId");
        if (c0448a.apC == JSONObject.NULL) {
            c0448a.apC = "";
        }
        c0448a.akN = jSONObject.optString("eGid");
        if (c0448a.akN == JSONObject.NULL) {
            c0448a.akN = "";
        }
        c0448a.akM = jSONObject.optString("deviceSig");
        if (c0448a.akM == JSONObject.NULL) {
            c0448a.akM = "";
        }
        c0448a.SL = jSONObject.optString("networkType");
        if (c0448a.SL == JSONObject.NULL) {
            c0448a.SL = "";
        }
        c0448a.SM = jSONObject.optString("manufacturer");
        if (c0448a.SM == JSONObject.NULL) {
            c0448a.SM = "";
        }
        c0448a.model = jSONObject.optString("model");
        if (c0448a.model == JSONObject.NULL) {
            c0448a.model = "";
        }
        c0448a.SN = jSONObject.optString("deviceBrand");
        if (c0448a.SN == JSONObject.NULL) {
            c0448a.SN = "";
        }
        c0448a.SO = jSONObject.optInt(Constants.KEY_OS_TYPE);
        c0448a.SP = jSONObject.optString("systemVersion");
        if (c0448a.SP == JSONObject.NULL) {
            c0448a.SP = "";
        }
        c0448a.SQ = jSONObject.optInt("osApi");
        c0448a.SR = jSONObject.optString("language");
        if (c0448a.SR == JSONObject.NULL) {
            c0448a.SR = "";
        }
        c0448a.SS = jSONObject.optString("locale");
        if (c0448a.SS == JSONObject.NULL) {
            c0448a.SS = "";
        }
        c0448a.apD = jSONObject.optString("uuid");
        if (c0448a.apD == JSONObject.NULL) {
            c0448a.apD = "";
        }
        c0448a.apE = jSONObject.optBoolean("isDynamic");
        c0448a.ST = jSONObject.optInt("screenWidth");
        c0448a.SU = jSONObject.optInt("screenHeight");
        c0448a.adB = jSONObject.optString("imei");
        if (c0448a.adB == JSONObject.NULL) {
            c0448a.adB = "";
        }
        c0448a.adC = jSONObject.optString("oaid");
        if (c0448a.adC == JSONObject.NULL) {
            c0448a.adC = "";
        }
        c0448a.akH = jSONObject.optString("androidId");
        if (c0448a.akH == JSONObject.NULL) {
            c0448a.akH = "";
        }
        c0448a.ala = jSONObject.optString("mac");
        if (c0448a.ala == JSONObject.NULL) {
            c0448a.ala = "";
        }
        c0448a.SV = jSONObject.optInt("statusBarHeight");
        c0448a.SW = jSONObject.optInt("titleBarHeight");
        c0448a.apF = jSONObject.optString("bridgeVersion");
        if (c0448a.apF == JSONObject.NULL) {
            c0448a.apF = "";
        }
    }

    private static JSONObject b(a.C0448a c0448a, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        String str = c0448a.SG;
        if (str != null && !str.equals("")) {
            com.kwad.sdk.utils.s.putValue(jSONObject, "SDKVersion", c0448a.SG);
        }
        int i2 = c0448a.SH;
        if (i2 != 0) {
            com.kwad.sdk.utils.s.putValue(jSONObject, "SDKVersionCode", i2);
        }
        String str2 = c0448a.aje;
        if (str2 != null && !str2.equals("")) {
            com.kwad.sdk.utils.s.putValue(jSONObject, "tkVersion", c0448a.aje);
        }
        String str3 = c0448a.SI;
        if (str3 != null && !str3.equals("")) {
            com.kwad.sdk.utils.s.putValue(jSONObject, "sdkApiVersion", c0448a.SI);
        }
        int i3 = c0448a.SJ;
        if (i3 != 0) {
            com.kwad.sdk.utils.s.putValue(jSONObject, "sdkApiVersionCode", i3);
        }
        int i4 = c0448a.SK;
        if (i4 != 0) {
            com.kwad.sdk.utils.s.putValue(jSONObject, "sdkType", i4);
        }
        String str4 = c0448a.appVersion;
        if (str4 != null && !str4.equals("")) {
            com.kwad.sdk.utils.s.putValue(jSONObject, "appVersion", c0448a.appVersion);
        }
        String str5 = c0448a.appName;
        if (str5 != null && !str5.equals("")) {
            com.kwad.sdk.utils.s.putValue(jSONObject, DispatchConstants.APP_NAME, c0448a.appName);
        }
        String str6 = c0448a.appId;
        if (str6 != null && !str6.equals("")) {
            com.kwad.sdk.utils.s.putValue(jSONObject, com.anythink.expressad.videocommon.e.b.f12231u, c0448a.appId);
        }
        String str7 = c0448a.apC;
        if (str7 != null && !str7.equals("")) {
            com.kwad.sdk.utils.s.putValue(jSONObject, "globalId", c0448a.apC);
        }
        String str8 = c0448a.akN;
        if (str8 != null && !str8.equals("")) {
            com.kwad.sdk.utils.s.putValue(jSONObject, "eGid", c0448a.akN);
        }
        String str9 = c0448a.akM;
        if (str9 != null && !str9.equals("")) {
            com.kwad.sdk.utils.s.putValue(jSONObject, "deviceSig", c0448a.akM);
        }
        String str10 = c0448a.SL;
        if (str10 != null && !str10.equals("")) {
            com.kwad.sdk.utils.s.putValue(jSONObject, "networkType", c0448a.SL);
        }
        String str11 = c0448a.SM;
        if (str11 != null && !str11.equals("")) {
            com.kwad.sdk.utils.s.putValue(jSONObject, "manufacturer", c0448a.SM);
        }
        String str12 = c0448a.model;
        if (str12 != null && !str12.equals("")) {
            com.kwad.sdk.utils.s.putValue(jSONObject, "model", c0448a.model);
        }
        String str13 = c0448a.SN;
        if (str13 != null && !str13.equals("")) {
            com.kwad.sdk.utils.s.putValue(jSONObject, "deviceBrand", c0448a.SN);
        }
        int i5 = c0448a.SO;
        if (i5 != 0) {
            com.kwad.sdk.utils.s.putValue(jSONObject, Constants.KEY_OS_TYPE, i5);
        }
        String str14 = c0448a.SP;
        if (str14 != null && !str14.equals("")) {
            com.kwad.sdk.utils.s.putValue(jSONObject, "systemVersion", c0448a.SP);
        }
        int i6 = c0448a.SQ;
        if (i6 != 0) {
            com.kwad.sdk.utils.s.putValue(jSONObject, "osApi", i6);
        }
        String str15 = c0448a.SR;
        if (str15 != null && !str15.equals("")) {
            com.kwad.sdk.utils.s.putValue(jSONObject, "language", c0448a.SR);
        }
        String str16 = c0448a.SS;
        if (str16 != null && !str16.equals("")) {
            com.kwad.sdk.utils.s.putValue(jSONObject, "locale", c0448a.SS);
        }
        String str17 = c0448a.apD;
        if (str17 != null && !str17.equals("")) {
            com.kwad.sdk.utils.s.putValue(jSONObject, "uuid", c0448a.apD);
        }
        boolean z2 = c0448a.apE;
        if (z2) {
            com.kwad.sdk.utils.s.putValue(jSONObject, "isDynamic", z2);
        }
        int i7 = c0448a.ST;
        if (i7 != 0) {
            com.kwad.sdk.utils.s.putValue(jSONObject, "screenWidth", i7);
        }
        int i8 = c0448a.SU;
        if (i8 != 0) {
            com.kwad.sdk.utils.s.putValue(jSONObject, "screenHeight", i8);
        }
        String str18 = c0448a.adB;
        if (str18 != null && !str18.equals("")) {
            com.kwad.sdk.utils.s.putValue(jSONObject, "imei", c0448a.adB);
        }
        String str19 = c0448a.adC;
        if (str19 != null && !str19.equals("")) {
            com.kwad.sdk.utils.s.putValue(jSONObject, "oaid", c0448a.adC);
        }
        String str20 = c0448a.akH;
        if (str20 != null && !str20.equals("")) {
            com.kwad.sdk.utils.s.putValue(jSONObject, "androidId", c0448a.akH);
        }
        String str21 = c0448a.ala;
        if (str21 != null && !str21.equals("")) {
            com.kwad.sdk.utils.s.putValue(jSONObject, "mac", c0448a.ala);
        }
        int i9 = c0448a.SV;
        if (i9 != 0) {
            com.kwad.sdk.utils.s.putValue(jSONObject, "statusBarHeight", i9);
        }
        int i10 = c0448a.SW;
        if (i10 != 0) {
            com.kwad.sdk.utils.s.putValue(jSONObject, "titleBarHeight", i10);
        }
        String str22 = c0448a.apF;
        if (str22 != null && !str22.equals("")) {
            com.kwad.sdk.utils.s.putValue(jSONObject, "bridgeVersion", c0448a.apF);
        }
        return jSONObject;
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        a((a.C0448a) bVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        return b((a.C0448a) bVar, jSONObject);
    }
}
