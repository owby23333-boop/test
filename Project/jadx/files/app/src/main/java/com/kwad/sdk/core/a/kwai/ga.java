package com.kwad.sdk.core.a.kwai;

import anet.channel.strategy.dispatch.DispatchConstants;
import com.kwad.components.core.webview.jshandler.o;
import com.taobao.accs.common.Constants;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public final class ga implements com.kwad.sdk.core.d<o.a> {
    private static void a(o.a aVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        aVar.SG = jSONObject.optString("SDKVersion");
        if (aVar.SG == JSONObject.NULL) {
            aVar.SG = "";
        }
        aVar.SH = jSONObject.optInt("SDKVersionCode");
        aVar.SI = jSONObject.optString("sdkApiVersion");
        if (aVar.SI == JSONObject.NULL) {
            aVar.SI = "";
        }
        aVar.SJ = jSONObject.optInt("sdkApiVersionCode");
        aVar.SK = jSONObject.optInt("sdkType");
        aVar.appVersion = jSONObject.optString("appVersion");
        if (aVar.appVersion == JSONObject.NULL) {
            aVar.appVersion = "";
        }
        aVar.appName = jSONObject.optString(DispatchConstants.APP_NAME);
        if (aVar.appName == JSONObject.NULL) {
            aVar.appName = "";
        }
        aVar.appId = jSONObject.optString(com.anythink.expressad.videocommon.e.b.f12231u);
        if (aVar.appId == JSONObject.NULL) {
            aVar.appId = "";
        }
        aVar.SL = jSONObject.optString("networkType");
        if (aVar.SL == JSONObject.NULL) {
            aVar.SL = "";
        }
        aVar.SM = jSONObject.optString("manufacturer");
        if (aVar.SM == JSONObject.NULL) {
            aVar.SM = "";
        }
        aVar.model = jSONObject.optString("model");
        if (aVar.model == JSONObject.NULL) {
            aVar.model = "";
        }
        aVar.SN = jSONObject.optString("deviceBrand");
        if (aVar.SN == JSONObject.NULL) {
            aVar.SN = "";
        }
        aVar.SO = jSONObject.optInt(Constants.KEY_OS_TYPE);
        aVar.SP = jSONObject.optString("systemVersion");
        if (aVar.SP == JSONObject.NULL) {
            aVar.SP = "";
        }
        aVar.SQ = jSONObject.optInt("osApi");
        aVar.SR = jSONObject.optString("language");
        if (aVar.SR == JSONObject.NULL) {
            aVar.SR = "";
        }
        aVar.SS = jSONObject.optString("locale");
        if (aVar.SS == JSONObject.NULL) {
            aVar.SS = "";
        }
        aVar.ST = jSONObject.optInt("screenWidth");
        aVar.SU = jSONObject.optInt("screenHeight");
        aVar.SV = jSONObject.optInt("statusBarHeight");
        aVar.SW = jSONObject.optInt("titleBarHeight");
    }

    private static JSONObject b(o.a aVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        String str = aVar.SG;
        if (str != null && !str.equals("")) {
            com.kwad.sdk.utils.s.putValue(jSONObject, "SDKVersion", aVar.SG);
        }
        int i2 = aVar.SH;
        if (i2 != 0) {
            com.kwad.sdk.utils.s.putValue(jSONObject, "SDKVersionCode", i2);
        }
        String str2 = aVar.SI;
        if (str2 != null && !str2.equals("")) {
            com.kwad.sdk.utils.s.putValue(jSONObject, "sdkApiVersion", aVar.SI);
        }
        int i3 = aVar.SJ;
        if (i3 != 0) {
            com.kwad.sdk.utils.s.putValue(jSONObject, "sdkApiVersionCode", i3);
        }
        int i4 = aVar.SK;
        if (i4 != 0) {
            com.kwad.sdk.utils.s.putValue(jSONObject, "sdkType", i4);
        }
        String str3 = aVar.appVersion;
        if (str3 != null && !str3.equals("")) {
            com.kwad.sdk.utils.s.putValue(jSONObject, "appVersion", aVar.appVersion);
        }
        String str4 = aVar.appName;
        if (str4 != null && !str4.equals("")) {
            com.kwad.sdk.utils.s.putValue(jSONObject, DispatchConstants.APP_NAME, aVar.appName);
        }
        String str5 = aVar.appId;
        if (str5 != null && !str5.equals("")) {
            com.kwad.sdk.utils.s.putValue(jSONObject, com.anythink.expressad.videocommon.e.b.f12231u, aVar.appId);
        }
        String str6 = aVar.SL;
        if (str6 != null && !str6.equals("")) {
            com.kwad.sdk.utils.s.putValue(jSONObject, "networkType", aVar.SL);
        }
        String str7 = aVar.SM;
        if (str7 != null && !str7.equals("")) {
            com.kwad.sdk.utils.s.putValue(jSONObject, "manufacturer", aVar.SM);
        }
        String str8 = aVar.model;
        if (str8 != null && !str8.equals("")) {
            com.kwad.sdk.utils.s.putValue(jSONObject, "model", aVar.model);
        }
        String str9 = aVar.SN;
        if (str9 != null && !str9.equals("")) {
            com.kwad.sdk.utils.s.putValue(jSONObject, "deviceBrand", aVar.SN);
        }
        int i5 = aVar.SO;
        if (i5 != 0) {
            com.kwad.sdk.utils.s.putValue(jSONObject, Constants.KEY_OS_TYPE, i5);
        }
        String str10 = aVar.SP;
        if (str10 != null && !str10.equals("")) {
            com.kwad.sdk.utils.s.putValue(jSONObject, "systemVersion", aVar.SP);
        }
        int i6 = aVar.SQ;
        if (i6 != 0) {
            com.kwad.sdk.utils.s.putValue(jSONObject, "osApi", i6);
        }
        String str11 = aVar.SR;
        if (str11 != null && !str11.equals("")) {
            com.kwad.sdk.utils.s.putValue(jSONObject, "language", aVar.SR);
        }
        String str12 = aVar.SS;
        if (str12 != null && !str12.equals("")) {
            com.kwad.sdk.utils.s.putValue(jSONObject, "locale", aVar.SS);
        }
        int i7 = aVar.ST;
        if (i7 != 0) {
            com.kwad.sdk.utils.s.putValue(jSONObject, "screenWidth", i7);
        }
        int i8 = aVar.SU;
        if (i8 != 0) {
            com.kwad.sdk.utils.s.putValue(jSONObject, "screenHeight", i8);
        }
        int i9 = aVar.SV;
        if (i9 != 0) {
            com.kwad.sdk.utils.s.putValue(jSONObject, "statusBarHeight", i9);
        }
        int i10 = aVar.SW;
        if (i10 != 0) {
            com.kwad.sdk.utils.s.putValue(jSONObject, "titleBarHeight", i10);
        }
        return jSONObject;
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        a((o.a) bVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        return b((o.a) bVar, jSONObject);
    }
}
