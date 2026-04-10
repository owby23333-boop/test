package com.kwad.sdk.core.a.kwai;

import com.bytedance.msdk.api.reward.RewardItem;
import com.kwad.sdk.core.report.q;
import com.kwad.sdk.core.scene.URLPackage;
import com.taobao.accs.common.Constants;
import org.android.agoo.common.AgooConstants;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public final class gi implements com.kwad.sdk.core.d<com.kwad.sdk.core.report.q> {
    private static void a(com.kwad.sdk.core.report.q qVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        qVar.timestamp = jSONObject.optLong("timestamp");
        qVar.sessionId = jSONObject.optString("sessionId");
        if (qVar.sessionId == JSONObject.NULL) {
            qVar.sessionId = "";
        }
        qVar.HG = jSONObject.optLong("seq");
        qVar.aii = jSONObject.optLong("listId");
        qVar.aij = jSONObject.optLong("actionType");
        qVar.To = jSONObject.optString("payload");
        if (qVar.To == JSONObject.NULL) {
            qVar.To = "";
        }
        qVar.llsid = jSONObject.optLong("llsid");
        qVar.aik = jSONObject.optJSONObject("extra");
        qVar.ail = jSONObject.optJSONObject("impAdExtra");
        qVar.posId = jSONObject.optLong("posId");
        qVar.contentType = jSONObject.optInt("contentType");
        qVar.realShowType = jSONObject.optInt("realShowType");
        qVar.photoId = jSONObject.optLong("photoId");
        qVar.position = jSONObject.optLong("position");
        qVar.aim = jSONObject.optLong("serverPosition");
        qVar.ain = jSONObject.optLong("photoDuration");
        qVar.aio = jSONObject.optLong("effectivePlayDuration");
        qVar.Vc = jSONObject.optLong("playDuration");
        qVar.blockDuration = jSONObject.optLong("blockDuration");
        qVar.aip = jSONObject.optLong("intervalDuration");
        qVar.aiq = jSONObject.optLong("allIntervalDuration");
        qVar.air = jSONObject.optLong("flowSdk");
        qVar.ais = jSONObject.optLong("blockTimes");
        qVar.contentSourceType = jSONObject.optInt("contentSourceType", new Integer("0").intValue());
        qVar.ait = jSONObject.optInt("adAggPageSource");
        qVar.entryPageSource = jSONObject.optString("entryPageSource");
        if (qVar.entryPageSource == JSONObject.NULL) {
            qVar.entryPageSource = "";
        }
        qVar.urlPackage = new URLPackage();
        qVar.urlPackage.parseJson(jSONObject.optJSONObject("urlPackage"));
        qVar.aiu = new URLPackage();
        qVar.aiu.parseJson(jSONObject.optJSONObject("referURLPackage"));
        qVar.OX = jSONObject.optLong(URLPackage.KEY_AUTHOR_ID);
        qVar.aiv = jSONObject.optString("photoSize");
        if (qVar.aiv == JSONObject.NULL) {
            qVar.aiv = "";
        }
        qVar.aiw = jSONObject.optJSONArray("appInstalled");
        qVar.aix = jSONObject.optJSONArray("appUninstalled");
        qVar.aiy = new q.a();
        qVar.aiy.parseJson(jSONObject.optJSONObject("clientExt"));
        qVar.aiz = jSONObject.optInt("playerType");
        qVar.aiA = jSONObject.optInt("uiType");
        qVar.aiB = jSONObject.optInt("isLeftSlipStatus", new Integer("0").intValue());
        qVar.Tp = jSONObject.optInt("refreshType");
        qVar.aiC = jSONObject.optInt("photoResponseType", new Integer("0").intValue());
        qVar.failUrl = jSONObject.optString("failUrl");
        if (qVar.failUrl == JSONObject.NULL) {
            qVar.failUrl = "";
        }
        qVar.errorMsg = jSONObject.optString(RewardItem.KEY_ERROR_MSG);
        if (qVar.errorMsg == JSONObject.NULL) {
            qVar.errorMsg = "";
        }
        qVar.errorCode = jSONObject.optInt("errorCode", new Integer("0").intValue());
        qVar.creativeId = jSONObject.optLong("creativeId");
        qVar.aiF = jSONObject.optString("cacheFailedReason");
        if (qVar.aiF == JSONObject.NULL) {
            qVar.aiF = "";
        }
        qVar.aiG = jSONObject.optJSONObject("appExt");
        qVar.aiH = jSONObject.optJSONArray("appRunningInfoList");
        qVar.downloadDuration = jSONObject.optLong("downloadDuration");
        qVar.pageType = jSONObject.optInt("pageType", new Integer("0").intValue());
        qVar.aiI = jSONObject.optInt("speedLimitStatus");
        qVar.aiJ = jSONObject.optInt("speedLimitThreshold");
        qVar.aiK = jSONObject.optInt("currentRealDownloadSpeed");
        qVar.aiM = jSONObject.optJSONArray("sdkPlatform");
        qVar.aiN = jSONObject.optBoolean("isKsUnion");
        qVar.aiO = jSONObject.optString("trackMethodName");
        if (qVar.aiO == JSONObject.NULL) {
            qVar.aiO = "";
        }
        qVar.aiP = jSONObject.optInt("viewModeType", new Integer("0").intValue());
        qVar.clickTime = jSONObject.optLong("clickTime");
        qVar.aiR = jSONObject.optLong("frameRenderTime");
        qVar.aiS = jSONObject.optInt("playerEnterAction");
        qVar.aiT = jSONObject.optString("requestUrl");
        if (qVar.aiT == JSONObject.NULL) {
            qVar.aiT = "";
        }
        qVar.aiU = jSONObject.optLong("requestTotalTime");
        qVar.aiV = jSONObject.optLong("requestResponseTime");
        qVar.aiW = jSONObject.optLong("requestParseDataTime");
        qVar.aiX = jSONObject.optLong("requestCallbackTime");
        qVar.aiY = jSONObject.optString("requestFailReason");
        if (qVar.aiY == JSONObject.NULL) {
            qVar.aiY = "";
        }
        qVar.NW = jSONObject.optString("pageName");
        if (qVar.NW == JSONObject.NULL) {
            qVar.NW = "";
        }
        qVar.Od = jSONObject.optLong("pageCreateTime");
        qVar.Oe = jSONObject.optLong("pageResumeTime");
        qVar.aiZ = jSONObject.optInt("trackUrlType");
        qVar.aja = jSONObject.optJSONArray("trackUrlList");
        qVar.Oc = jSONObject.optLong("pageLaunchTime");
        qVar.ajd = jSONObject.optJSONArray("appAuthorityInfoList");
        qVar.aje = jSONObject.optString("tkVersion");
        if (qVar.aje == JSONObject.NULL) {
            qVar.aje = "";
        }
        qVar.ajf = jSONObject.optString("jsVersion");
        if (qVar.ajf == JSONObject.NULL) {
            qVar.ajf = "";
        }
        qVar.ajg = jSONObject.optString("jsFileName");
        if (qVar.ajg == JSONObject.NULL) {
            qVar.ajg = "";
        }
        qVar.ajh = jSONObject.optString("jsErrorMsg");
        if (qVar.ajh == JSONObject.NULL) {
            qVar.ajh = "";
        }
        qVar.aji = jSONObject.optString("jsConfig");
        if (qVar.aji == JSONObject.NULL) {
            qVar.aji = "";
        }
        qVar.ajj = jSONObject.optInt("adBizType");
        qVar.ajk = jSONObject.optString("customKey");
        if (qVar.ajk == JSONObject.NULL) {
            qVar.ajk = "";
        }
        qVar.ajl = jSONObject.optString("customValue");
        if (qVar.ajl == JSONObject.NULL) {
            qVar.ajl = "";
        }
        qVar.trace = jSONObject.optString(AgooConstants.MESSAGE_TRACE);
        if (qVar.trace == JSONObject.NULL) {
            qVar.trace = "";
        }
        qVar.ajm = jSONObject.optInt("filterCode");
        qVar.ajn = jSONObject.optInt("sdkVersionCode");
        qVar.sdkVersion = jSONObject.optString(Constants.KEY_SDK_VERSION);
        if (qVar.sdkVersion == JSONObject.NULL) {
            qVar.sdkVersion = "";
        }
        qVar.SI = jSONObject.optString("sdkApiVersion");
        if (qVar.SI == JSONObject.NULL) {
            qVar.SI = "";
        }
        qVar.SK = jSONObject.optInt("sdkType");
        qVar.ajo = jSONObject.optLong("appUseDuration");
        qVar.ajp = jSONObject.optLong("appStartType");
        qVar.aes = jSONObject.optLong("sequenceNumber");
        qVar.HD = jSONObject.optString("appColdStart");
        if (qVar.HD == JSONObject.NULL) {
            qVar.HD = "";
        }
        qVar.HE = jSONObject.optString("appStart");
        if (qVar.HE == JSONObject.NULL) {
            qVar.HE = "";
        }
    }

    private static JSONObject b(com.kwad.sdk.core.report.q qVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        long j2 = qVar.timestamp;
        if (j2 != 0) {
            com.kwad.sdk.utils.s.putValue(jSONObject, "timestamp", j2);
        }
        String str = qVar.sessionId;
        if (str != null && !str.equals("")) {
            com.kwad.sdk.utils.s.putValue(jSONObject, "sessionId", qVar.sessionId);
        }
        long j3 = qVar.HG;
        if (j3 != 0) {
            com.kwad.sdk.utils.s.putValue(jSONObject, "seq", j3);
        }
        long j4 = qVar.aii;
        if (j4 != 0) {
            com.kwad.sdk.utils.s.putValue(jSONObject, "listId", j4);
        }
        long j5 = qVar.aij;
        if (j5 != 0) {
            com.kwad.sdk.utils.s.putValue(jSONObject, "actionType", j5);
        }
        String str2 = qVar.To;
        if (str2 != null && !str2.equals("")) {
            com.kwad.sdk.utils.s.putValue(jSONObject, "payload", qVar.To);
        }
        long j6 = qVar.llsid;
        if (j6 != 0) {
            com.kwad.sdk.utils.s.putValue(jSONObject, "llsid", j6);
        }
        com.kwad.sdk.utils.s.putValue(jSONObject, "extra", qVar.aik);
        com.kwad.sdk.utils.s.putValue(jSONObject, "impAdExtra", qVar.ail);
        long j7 = qVar.posId;
        if (j7 != 0) {
            com.kwad.sdk.utils.s.putValue(jSONObject, "posId", j7);
        }
        int i2 = qVar.contentType;
        if (i2 != 0) {
            com.kwad.sdk.utils.s.putValue(jSONObject, "contentType", i2);
        }
        int i3 = qVar.realShowType;
        if (i3 != 0) {
            com.kwad.sdk.utils.s.putValue(jSONObject, "realShowType", i3);
        }
        long j8 = qVar.photoId;
        if (j8 != 0) {
            com.kwad.sdk.utils.s.putValue(jSONObject, "photoId", j8);
        }
        long j9 = qVar.position;
        if (j9 != 0) {
            com.kwad.sdk.utils.s.putValue(jSONObject, "position", j9);
        }
        long j10 = qVar.aim;
        if (j10 != 0) {
            com.kwad.sdk.utils.s.putValue(jSONObject, "serverPosition", j10);
        }
        long j11 = qVar.ain;
        if (j11 != 0) {
            com.kwad.sdk.utils.s.putValue(jSONObject, "photoDuration", j11);
        }
        long j12 = qVar.aio;
        if (j12 != 0) {
            com.kwad.sdk.utils.s.putValue(jSONObject, "effectivePlayDuration", j12);
        }
        long j13 = qVar.Vc;
        if (j13 != 0) {
            com.kwad.sdk.utils.s.putValue(jSONObject, "playDuration", j13);
        }
        long j14 = qVar.blockDuration;
        if (j14 != 0) {
            com.kwad.sdk.utils.s.putValue(jSONObject, "blockDuration", j14);
        }
        long j15 = qVar.aip;
        if (j15 != 0) {
            com.kwad.sdk.utils.s.putValue(jSONObject, "intervalDuration", j15);
        }
        long j16 = qVar.aiq;
        if (j16 != 0) {
            com.kwad.sdk.utils.s.putValue(jSONObject, "allIntervalDuration", j16);
        }
        long j17 = qVar.air;
        if (j17 != 0) {
            com.kwad.sdk.utils.s.putValue(jSONObject, "flowSdk", j17);
        }
        long j18 = qVar.ais;
        if (j18 != 0) {
            com.kwad.sdk.utils.s.putValue(jSONObject, "blockTimes", j18);
        }
        com.kwad.sdk.utils.s.putValue(jSONObject, "contentSourceType", qVar.contentSourceType);
        int i4 = qVar.ait;
        if (i4 != 0) {
            com.kwad.sdk.utils.s.putValue(jSONObject, "adAggPageSource", i4);
        }
        String str3 = qVar.entryPageSource;
        if (str3 != null && !str3.equals("")) {
            com.kwad.sdk.utils.s.putValue(jSONObject, "entryPageSource", qVar.entryPageSource);
        }
        com.kwad.sdk.utils.s.a(jSONObject, "urlPackage", qVar.urlPackage);
        com.kwad.sdk.utils.s.a(jSONObject, "referURLPackage", qVar.aiu);
        long j19 = qVar.OX;
        if (j19 != 0) {
            com.kwad.sdk.utils.s.putValue(jSONObject, URLPackage.KEY_AUTHOR_ID, j19);
        }
        String str4 = qVar.aiv;
        if (str4 != null && !str4.equals("")) {
            com.kwad.sdk.utils.s.putValue(jSONObject, "photoSize", qVar.aiv);
        }
        com.kwad.sdk.utils.s.putValue(jSONObject, "appInstalled", qVar.aiw);
        com.kwad.sdk.utils.s.putValue(jSONObject, "appUninstalled", qVar.aix);
        com.kwad.sdk.utils.s.a(jSONObject, "clientExt", qVar.aiy);
        int i5 = qVar.aiz;
        if (i5 != 0) {
            com.kwad.sdk.utils.s.putValue(jSONObject, "playerType", i5);
        }
        int i6 = qVar.aiA;
        if (i6 != 0) {
            com.kwad.sdk.utils.s.putValue(jSONObject, "uiType", i6);
        }
        com.kwad.sdk.utils.s.putValue(jSONObject, "isLeftSlipStatus", qVar.aiB);
        int i7 = qVar.Tp;
        if (i7 != 0) {
            com.kwad.sdk.utils.s.putValue(jSONObject, "refreshType", i7);
        }
        com.kwad.sdk.utils.s.putValue(jSONObject, "photoResponseType", qVar.aiC);
        String str5 = qVar.failUrl;
        if (str5 != null && !str5.equals("")) {
            com.kwad.sdk.utils.s.putValue(jSONObject, "failUrl", qVar.failUrl);
        }
        String str6 = qVar.errorMsg;
        if (str6 != null && !str6.equals("")) {
            com.kwad.sdk.utils.s.putValue(jSONObject, RewardItem.KEY_ERROR_MSG, qVar.errorMsg);
        }
        com.kwad.sdk.utils.s.putValue(jSONObject, "errorCode", qVar.errorCode);
        long j20 = qVar.creativeId;
        if (j20 != 0) {
            com.kwad.sdk.utils.s.putValue(jSONObject, "creativeId", j20);
        }
        String str7 = qVar.aiF;
        if (str7 != null && !str7.equals("")) {
            com.kwad.sdk.utils.s.putValue(jSONObject, "cacheFailedReason", qVar.aiF);
        }
        com.kwad.sdk.utils.s.putValue(jSONObject, "appExt", qVar.aiG);
        com.kwad.sdk.utils.s.putValue(jSONObject, "appRunningInfoList", qVar.aiH);
        long j21 = qVar.downloadDuration;
        if (j21 != 0) {
            com.kwad.sdk.utils.s.putValue(jSONObject, "downloadDuration", j21);
        }
        com.kwad.sdk.utils.s.putValue(jSONObject, "pageType", qVar.pageType);
        int i8 = qVar.aiI;
        if (i8 != 0) {
            com.kwad.sdk.utils.s.putValue(jSONObject, "speedLimitStatus", i8);
        }
        int i9 = qVar.aiJ;
        if (i9 != 0) {
            com.kwad.sdk.utils.s.putValue(jSONObject, "speedLimitThreshold", i9);
        }
        int i10 = qVar.aiK;
        if (i10 != 0) {
            com.kwad.sdk.utils.s.putValue(jSONObject, "currentRealDownloadSpeed", i10);
        }
        com.kwad.sdk.utils.s.putValue(jSONObject, "sdkPlatform", qVar.aiM);
        boolean z2 = qVar.aiN;
        if (z2) {
            com.kwad.sdk.utils.s.putValue(jSONObject, "isKsUnion", z2);
        }
        String str8 = qVar.aiO;
        if (str8 != null && !str8.equals("")) {
            com.kwad.sdk.utils.s.putValue(jSONObject, "trackMethodName", qVar.aiO);
        }
        com.kwad.sdk.utils.s.putValue(jSONObject, "viewModeType", qVar.aiP);
        long j22 = qVar.clickTime;
        if (j22 != 0) {
            com.kwad.sdk.utils.s.putValue(jSONObject, "clickTime", j22);
        }
        long j23 = qVar.aiR;
        if (j23 != 0) {
            com.kwad.sdk.utils.s.putValue(jSONObject, "frameRenderTime", j23);
        }
        int i11 = qVar.aiS;
        if (i11 != 0) {
            com.kwad.sdk.utils.s.putValue(jSONObject, "playerEnterAction", i11);
        }
        String str9 = qVar.aiT;
        if (str9 != null && !str9.equals("")) {
            com.kwad.sdk.utils.s.putValue(jSONObject, "requestUrl", qVar.aiT);
        }
        long j24 = qVar.aiU;
        if (j24 != 0) {
            com.kwad.sdk.utils.s.putValue(jSONObject, "requestTotalTime", j24);
        }
        long j25 = qVar.aiV;
        if (j25 != 0) {
            com.kwad.sdk.utils.s.putValue(jSONObject, "requestResponseTime", j25);
        }
        long j26 = qVar.aiW;
        if (j26 != 0) {
            com.kwad.sdk.utils.s.putValue(jSONObject, "requestParseDataTime", j26);
        }
        long j27 = qVar.aiX;
        if (j27 != 0) {
            com.kwad.sdk.utils.s.putValue(jSONObject, "requestCallbackTime", j27);
        }
        String str10 = qVar.aiY;
        if (str10 != null && !str10.equals("")) {
            com.kwad.sdk.utils.s.putValue(jSONObject, "requestFailReason", qVar.aiY);
        }
        String str11 = qVar.NW;
        if (str11 != null && !str11.equals("")) {
            com.kwad.sdk.utils.s.putValue(jSONObject, "pageName", qVar.NW);
        }
        long j28 = qVar.Od;
        if (j28 != 0) {
            com.kwad.sdk.utils.s.putValue(jSONObject, "pageCreateTime", j28);
        }
        long j29 = qVar.Oe;
        if (j29 != 0) {
            com.kwad.sdk.utils.s.putValue(jSONObject, "pageResumeTime", j29);
        }
        int i12 = qVar.aiZ;
        if (i12 != 0) {
            com.kwad.sdk.utils.s.putValue(jSONObject, "trackUrlType", i12);
        }
        com.kwad.sdk.utils.s.putValue(jSONObject, "trackUrlList", qVar.aja);
        long j30 = qVar.Oc;
        if (j30 != 0) {
            com.kwad.sdk.utils.s.putValue(jSONObject, "pageLaunchTime", j30);
        }
        com.kwad.sdk.utils.s.putValue(jSONObject, "appAuthorityInfoList", qVar.ajd);
        String str12 = qVar.aje;
        if (str12 != null && !str12.equals("")) {
            com.kwad.sdk.utils.s.putValue(jSONObject, "tkVersion", qVar.aje);
        }
        String str13 = qVar.ajf;
        if (str13 != null && !str13.equals("")) {
            com.kwad.sdk.utils.s.putValue(jSONObject, "jsVersion", qVar.ajf);
        }
        String str14 = qVar.ajg;
        if (str14 != null && !str14.equals("")) {
            com.kwad.sdk.utils.s.putValue(jSONObject, "jsFileName", qVar.ajg);
        }
        String str15 = qVar.ajh;
        if (str15 != null && !str15.equals("")) {
            com.kwad.sdk.utils.s.putValue(jSONObject, "jsErrorMsg", qVar.ajh);
        }
        String str16 = qVar.aji;
        if (str16 != null && !str16.equals("")) {
            com.kwad.sdk.utils.s.putValue(jSONObject, "jsConfig", qVar.aji);
        }
        int i13 = qVar.ajj;
        if (i13 != 0) {
            com.kwad.sdk.utils.s.putValue(jSONObject, "adBizType", i13);
        }
        String str17 = qVar.ajk;
        if (str17 != null && !str17.equals("")) {
            com.kwad.sdk.utils.s.putValue(jSONObject, "customKey", qVar.ajk);
        }
        String str18 = qVar.ajl;
        if (str18 != null && !str18.equals("")) {
            com.kwad.sdk.utils.s.putValue(jSONObject, "customValue", qVar.ajl);
        }
        String str19 = qVar.trace;
        if (str19 != null && !str19.equals("")) {
            com.kwad.sdk.utils.s.putValue(jSONObject, AgooConstants.MESSAGE_TRACE, qVar.trace);
        }
        int i14 = qVar.ajm;
        if (i14 != 0) {
            com.kwad.sdk.utils.s.putValue(jSONObject, "filterCode", i14);
        }
        int i15 = qVar.ajn;
        if (i15 != 0) {
            com.kwad.sdk.utils.s.putValue(jSONObject, "sdkVersionCode", i15);
        }
        String str20 = qVar.sdkVersion;
        if (str20 != null && !str20.equals("")) {
            com.kwad.sdk.utils.s.putValue(jSONObject, Constants.KEY_SDK_VERSION, qVar.sdkVersion);
        }
        String str21 = qVar.SI;
        if (str21 != null && !str21.equals("")) {
            com.kwad.sdk.utils.s.putValue(jSONObject, "sdkApiVersion", qVar.SI);
        }
        int i16 = qVar.SK;
        if (i16 != 0) {
            com.kwad.sdk.utils.s.putValue(jSONObject, "sdkType", i16);
        }
        long j31 = qVar.ajo;
        if (j31 != 0) {
            com.kwad.sdk.utils.s.putValue(jSONObject, "appUseDuration", j31);
        }
        long j32 = qVar.ajp;
        if (j32 != 0) {
            com.kwad.sdk.utils.s.putValue(jSONObject, "appStartType", j32);
        }
        long j33 = qVar.aes;
        if (j33 != 0) {
            com.kwad.sdk.utils.s.putValue(jSONObject, "sequenceNumber", j33);
        }
        String str22 = qVar.HD;
        if (str22 != null && !str22.equals("")) {
            com.kwad.sdk.utils.s.putValue(jSONObject, "appColdStart", qVar.HD);
        }
        String str23 = qVar.HE;
        if (str23 != null && !str23.equals("")) {
            com.kwad.sdk.utils.s.putValue(jSONObject, "appStart", qVar.HE);
        }
        return jSONObject;
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        a((com.kwad.sdk.core.report.q) bVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        return b((com.kwad.sdk.core.report.q) bVar, jSONObject);
    }
}
