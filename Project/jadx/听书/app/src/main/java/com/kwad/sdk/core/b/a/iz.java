package com.kwad.sdk.core.b.a;

import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import com.kwad.sdk.core.report.n;
import com.kwad.sdk.core.scene.URLPackage;
import com.umeng.umcrash.UMCrash;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
public final class iz implements com.kwad.sdk.core.d<com.kwad.sdk.core.report.n> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        a((com.kwad.sdk.core.report.n) bVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        return b((com.kwad.sdk.core.report.n) bVar, jSONObject);
    }

    private static void a(com.kwad.sdk.core.report.n nVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        nVar.timestamp = jSONObject.optLong(UMCrash.SP_KEY_TIMESTAMP);
        nVar.sessionId = jSONObject.optString("sessionId");
        if (JSONObject.NULL.toString().equals(nVar.sessionId)) {
            nVar.sessionId = "";
        }
        nVar.Nh = jSONObject.optLong("seq");
        nVar.aGE = jSONObject.optLong("listId");
        nVar.actionType = jSONObject.optLong("actionType");
        nVar.Pj = jSONObject.optString("payload");
        if (JSONObject.NULL.toString().equals(nVar.Pj)) {
            nVar.Pj = "";
        }
        nVar.llsid = jSONObject.optLong("llsid");
        nVar.aGF = jSONObject.optJSONObject("extra");
        nVar.aGG = jSONObject.optJSONObject("impAdExtra");
        nVar.posId = jSONObject.optLong("posId");
        nVar.contentType = jSONObject.optInt("contentType");
        nVar.realShowType = jSONObject.optInt("realShowType");
        nVar.photoId = jSONObject.optLong("photoId");
        nVar.position = jSONObject.optLong("position");
        nVar.aGH = jSONObject.optLong("serverPosition");
        nVar.aGI = jSONObject.optLong("photoDuration");
        nVar.aGJ = jSONObject.optLong("effectivePlayDuration");
        nVar.aci = jSONObject.optLong("playDuration");
        nVar.blockDuration = jSONObject.optLong("blockDuration");
        nVar.aGK = jSONObject.optLong("intervalDuration");
        nVar.aGL = jSONObject.optLong("allIntervalDuration");
        nVar.aGM = jSONObject.optLong("flowSdk");
        nVar.aGN = jSONObject.optLong("blockTimes");
        nVar.contentSourceType = jSONObject.optInt("contentSourceType", new Integer("0").intValue());
        nVar.aye = jSONObject.optInt("adAggPageSource");
        nVar.entryPageSource = jSONObject.optString("entryPageSource");
        if (JSONObject.NULL.toString().equals(nVar.entryPageSource)) {
            nVar.entryPageSource = "";
        }
        nVar.urlPackage = new URLPackage();
        nVar.urlPackage.parseJson(jSONObject.optJSONObject("urlPackage"));
        nVar.aGO = new URLPackage();
        nVar.aGO.parseJson(jSONObject.optJSONObject("referURLPackage"));
        nVar.XI = jSONObject.optLong(URLPackage.KEY_AUTHOR_ID);
        nVar.aGP = jSONObject.optString("photoSize");
        if (JSONObject.NULL.toString().equals(nVar.aGP)) {
            nVar.aGP = "";
        }
        nVar.aGQ = jSONObject.optJSONArray("appInstalled");
        nVar.aGR = jSONObject.optJSONArray("appUninstalled");
        nVar.aGS = new n.a();
        nVar.aGS.parseJson(jSONObject.optJSONObject("clientExt"));
        nVar.aGT = jSONObject.optInt("playerType");
        nVar.aGU = jSONObject.optInt("uiType");
        nVar.aGV = jSONObject.optInt("isLeftSlipStatus", new Integer("0").intValue());
        nVar.adE = jSONObject.optInt("refreshType");
        nVar.aGW = jSONObject.optInt("photoResponseType", new Integer("0").intValue());
        nVar.aGX = jSONObject.optString("failUrl");
        if (JSONObject.NULL.toString().equals(nVar.aGX)) {
            nVar.aGX = "";
        }
        nVar.errorMsg = jSONObject.optString(MediationConstant.KEY_ERROR_MSG);
        if (JSONObject.NULL.toString().equals(nVar.errorMsg)) {
            nVar.errorMsg = "";
        }
        nVar.errorCode = jSONObject.optInt(MediationConstant.KEY_ERROR_CODE, new Integer("0").intValue());
        nVar.creativeId = jSONObject.optLong("creativeId");
        nVar.aHa = jSONObject.optString("cacheFailedReason");
        if (JSONObject.NULL.toString().equals(nVar.aHa)) {
            nVar.aHa = "";
        }
        nVar.aHb = jSONObject.optJSONObject("appExt");
        nVar.aHc = jSONObject.optJSONArray("appRunningInfoList");
        nVar.downloadDuration = jSONObject.optLong("downloadDuration");
        nVar.pageType = jSONObject.optInt("pageType", new Integer("0").intValue());
        nVar.aHd = jSONObject.optInt("speedLimitStatus");
        nVar.aHe = jSONObject.optInt("speedLimitThreshold");
        nVar.aHf = jSONObject.optInt("currentRealDownloadSpeed");
        nVar.aHh = jSONObject.optJSONArray("sdkPlatform");
        nVar.aHi = jSONObject.optBoolean("isKsUnion");
        nVar.aHj = jSONObject.optString("trackMethodName");
        if (JSONObject.NULL.toString().equals(nVar.aHj)) {
            nVar.aHj = "";
        }
        nVar.aHk = jSONObject.optInt("viewModeType", new Integer("0").intValue());
        nVar.clickTime = jSONObject.optLong("clickTime");
        nVar.aHm = jSONObject.optLong("frameRenderTime");
        nVar.aHn = jSONObject.optInt("playerEnterAction");
        nVar.aHo = jSONObject.optString("requestUrl");
        if (JSONObject.NULL.toString().equals(nVar.aHo)) {
            nVar.aHo = "";
        }
        nVar.aHp = jSONObject.optLong("requestTotalTime");
        nVar.aHq = jSONObject.optLong("requestResponseTime");
        nVar.aHr = jSONObject.optLong("requestParseDataTime");
        nVar.aHs = jSONObject.optLong("requestCallbackTime");
        nVar.aHt = jSONObject.optString("requestFailReason");
        if (JSONObject.NULL.toString().equals(nVar.aHt)) {
            nVar.aHt = "";
        }
        nVar.WH = jSONObject.optString("pageName");
        if (JSONObject.NULL.toString().equals(nVar.WH)) {
            nVar.WH = "";
        }
        nVar.WP = jSONObject.optLong("pageCreateTime");
        nVar.WQ = jSONObject.optLong("pageResumeTime");
        nVar.aHu = jSONObject.optInt("trackUrlType");
        nVar.aHv = jSONObject.optJSONArray("trackUrlList");
        nVar.WO = jSONObject.optLong("pageLaunchTime");
        nVar.aHy = jSONObject.optJSONArray("appAuthorityInfoList");
        nVar.aHz = jSONObject.optString("tkVersion");
        if (JSONObject.NULL.toString().equals(nVar.aHz)) {
            nVar.aHz = "";
        }
        nVar.aHA = jSONObject.optString("jsVersion");
        if (JSONObject.NULL.toString().equals(nVar.aHA)) {
            nVar.aHA = "";
        }
        nVar.aHB = jSONObject.optString("jsFileName");
        if (JSONObject.NULL.toString().equals(nVar.aHB)) {
            nVar.aHB = "";
        }
        nVar.aHC = jSONObject.optString("jsErrorMsg");
        if (JSONObject.NULL.toString().equals(nVar.aHC)) {
            nVar.aHC = "";
        }
        nVar.aHD = jSONObject.optString("jsConfig");
        if (JSONObject.NULL.toString().equals(nVar.aHD)) {
            nVar.aHD = "";
        }
        nVar.aHE = jSONObject.optInt("adBizType");
        nVar.aHF = jSONObject.optString("customKey");
        if (JSONObject.NULL.toString().equals(nVar.aHF)) {
            nVar.aHF = "";
        }
        nVar.aHG = jSONObject.optString("customValue");
        if (JSONObject.NULL.toString().equals(nVar.aHG)) {
            nVar.aHG = "";
        }
        nVar.trace = jSONObject.optString("trace");
        if (JSONObject.NULL.toString().equals(nVar.trace)) {
            nVar.trace = "";
        }
        nVar.aHH = jSONObject.optInt("filterCode");
        nVar.aHI = jSONObject.optInt("sdkVersionCode");
        nVar.sdkVersion = jSONObject.optString("sdkVersion");
        if (JSONObject.NULL.toString().equals(nVar.sdkVersion)) {
            nVar.sdkVersion = "";
        }
        nVar.aHJ = jSONObject.optString("adSdkVersion");
        if (JSONObject.NULL.toString().equals(nVar.aHJ)) {
            nVar.aHJ = "";
        }
        nVar.sdkApiVersion = jSONObject.optString("sdkApiVersion");
        if (JSONObject.NULL.toString().equals(nVar.sdkApiVersion)) {
            nVar.sdkApiVersion = "";
        }
        nVar.sdkType = jSONObject.optInt("sdkType");
        nVar.aHK = jSONObject.optLong("appUseDuration");
        nVar.aHL = jSONObject.optLong("appStartType");
        nVar.aDb = jSONObject.optLong("sequenceNumber");
        nVar.Ne = jSONObject.optString("appColdStart");
        if (JSONObject.NULL.toString().equals(nVar.Ne)) {
            nVar.Ne = "";
        }
        nVar.Nf = jSONObject.optString("appStart");
        if (JSONObject.NULL.toString().equals(nVar.Nf)) {
            nVar.Nf = "";
        }
    }

    private static JSONObject b(com.kwad.sdk.core.report.n nVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        if (nVar.timestamp != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, UMCrash.SP_KEY_TIMESTAMP, nVar.timestamp);
        }
        if (nVar.sessionId != null && !nVar.sessionId.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "sessionId", nVar.sessionId);
        }
        if (nVar.Nh != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "seq", nVar.Nh);
        }
        if (nVar.aGE != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "listId", nVar.aGE);
        }
        if (nVar.actionType != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "actionType", nVar.actionType);
        }
        if (nVar.Pj != null && !nVar.Pj.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "payload", nVar.Pj);
        }
        if (nVar.llsid != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "llsid", nVar.llsid);
        }
        com.kwad.sdk.utils.aa.putValue(jSONObject, "extra", nVar.aGF);
        com.kwad.sdk.utils.aa.putValue(jSONObject, "impAdExtra", nVar.aGG);
        if (nVar.posId != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "posId", nVar.posId);
        }
        if (nVar.contentType != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "contentType", nVar.contentType);
        }
        if (nVar.realShowType != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "realShowType", nVar.realShowType);
        }
        if (nVar.photoId != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "photoId", nVar.photoId);
        }
        if (nVar.position != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "position", nVar.position);
        }
        if (nVar.aGH != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "serverPosition", nVar.aGH);
        }
        if (nVar.aGI != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "photoDuration", nVar.aGI);
        }
        if (nVar.aGJ != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "effectivePlayDuration", nVar.aGJ);
        }
        if (nVar.aci != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "playDuration", nVar.aci);
        }
        if (nVar.blockDuration != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "blockDuration", nVar.blockDuration);
        }
        if (nVar.aGK != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "intervalDuration", nVar.aGK);
        }
        if (nVar.aGL != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "allIntervalDuration", nVar.aGL);
        }
        if (nVar.aGM != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "flowSdk", nVar.aGM);
        }
        if (nVar.aGN != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "blockTimes", nVar.aGN);
        }
        com.kwad.sdk.utils.aa.putValue(jSONObject, "contentSourceType", nVar.contentSourceType);
        if (nVar.aye != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "adAggPageSource", nVar.aye);
        }
        if (nVar.entryPageSource != null && !nVar.entryPageSource.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "entryPageSource", nVar.entryPageSource);
        }
        com.kwad.sdk.utils.aa.a(jSONObject, "urlPackage", nVar.urlPackage);
        com.kwad.sdk.utils.aa.a(jSONObject, "referURLPackage", nVar.aGO);
        if (nVar.XI != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, URLPackage.KEY_AUTHOR_ID, nVar.XI);
        }
        if (nVar.aGP != null && !nVar.aGP.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "photoSize", nVar.aGP);
        }
        com.kwad.sdk.utils.aa.putValue(jSONObject, "appInstalled", nVar.aGQ);
        com.kwad.sdk.utils.aa.putValue(jSONObject, "appUninstalled", nVar.aGR);
        com.kwad.sdk.utils.aa.a(jSONObject, "clientExt", nVar.aGS);
        if (nVar.aGT != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "playerType", nVar.aGT);
        }
        if (nVar.aGU != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "uiType", nVar.aGU);
        }
        com.kwad.sdk.utils.aa.putValue(jSONObject, "isLeftSlipStatus", nVar.aGV);
        if (nVar.adE != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "refreshType", nVar.adE);
        }
        com.kwad.sdk.utils.aa.putValue(jSONObject, "photoResponseType", nVar.aGW);
        if (nVar.aGX != null && !nVar.aGX.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "failUrl", nVar.aGX);
        }
        if (nVar.errorMsg != null && !nVar.errorMsg.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, MediationConstant.KEY_ERROR_MSG, nVar.errorMsg);
        }
        com.kwad.sdk.utils.aa.putValue(jSONObject, MediationConstant.KEY_ERROR_CODE, nVar.errorCode);
        if (nVar.creativeId != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "creativeId", nVar.creativeId);
        }
        if (nVar.aHa != null && !nVar.aHa.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "cacheFailedReason", nVar.aHa);
        }
        com.kwad.sdk.utils.aa.putValue(jSONObject, "appExt", nVar.aHb);
        com.kwad.sdk.utils.aa.putValue(jSONObject, "appRunningInfoList", nVar.aHc);
        if (nVar.downloadDuration != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "downloadDuration", nVar.downloadDuration);
        }
        com.kwad.sdk.utils.aa.putValue(jSONObject, "pageType", nVar.pageType);
        if (nVar.aHd != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "speedLimitStatus", nVar.aHd);
        }
        if (nVar.aHe != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "speedLimitThreshold", nVar.aHe);
        }
        if (nVar.aHf != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "currentRealDownloadSpeed", nVar.aHf);
        }
        com.kwad.sdk.utils.aa.putValue(jSONObject, "sdkPlatform", nVar.aHh);
        if (nVar.aHi) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "isKsUnion", nVar.aHi);
        }
        if (nVar.aHj != null && !nVar.aHj.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "trackMethodName", nVar.aHj);
        }
        com.kwad.sdk.utils.aa.putValue(jSONObject, "viewModeType", nVar.aHk);
        if (nVar.clickTime != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "clickTime", nVar.clickTime);
        }
        if (nVar.aHm != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "frameRenderTime", nVar.aHm);
        }
        if (nVar.aHn != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "playerEnterAction", nVar.aHn);
        }
        if (nVar.aHo != null && !nVar.aHo.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "requestUrl", nVar.aHo);
        }
        if (nVar.aHp != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "requestTotalTime", nVar.aHp);
        }
        if (nVar.aHq != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "requestResponseTime", nVar.aHq);
        }
        if (nVar.aHr != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "requestParseDataTime", nVar.aHr);
        }
        if (nVar.aHs != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "requestCallbackTime", nVar.aHs);
        }
        if (nVar.aHt != null && !nVar.aHt.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "requestFailReason", nVar.aHt);
        }
        if (nVar.WH != null && !nVar.WH.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "pageName", nVar.WH);
        }
        if (nVar.WP != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "pageCreateTime", nVar.WP);
        }
        if (nVar.WQ != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "pageResumeTime", nVar.WQ);
        }
        if (nVar.aHu != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "trackUrlType", nVar.aHu);
        }
        com.kwad.sdk.utils.aa.putValue(jSONObject, "trackUrlList", nVar.aHv);
        if (nVar.WO != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "pageLaunchTime", nVar.WO);
        }
        com.kwad.sdk.utils.aa.putValue(jSONObject, "appAuthorityInfoList", nVar.aHy);
        if (nVar.aHz != null && !nVar.aHz.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "tkVersion", nVar.aHz);
        }
        if (nVar.aHA != null && !nVar.aHA.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "jsVersion", nVar.aHA);
        }
        if (nVar.aHB != null && !nVar.aHB.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "jsFileName", nVar.aHB);
        }
        if (nVar.aHC != null && !nVar.aHC.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "jsErrorMsg", nVar.aHC);
        }
        if (nVar.aHD != null && !nVar.aHD.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "jsConfig", nVar.aHD);
        }
        if (nVar.aHE != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "adBizType", nVar.aHE);
        }
        if (nVar.aHF != null && !nVar.aHF.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "customKey", nVar.aHF);
        }
        if (nVar.aHG != null && !nVar.aHG.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "customValue", nVar.aHG);
        }
        if (nVar.trace != null && !nVar.trace.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "trace", nVar.trace);
        }
        if (nVar.aHH != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "filterCode", nVar.aHH);
        }
        if (nVar.aHI != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "sdkVersionCode", nVar.aHI);
        }
        if (nVar.sdkVersion != null && !nVar.sdkVersion.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "sdkVersion", nVar.sdkVersion);
        }
        if (nVar.aHJ != null && !nVar.aHJ.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "adSdkVersion", nVar.aHJ);
        }
        if (nVar.sdkApiVersion != null && !nVar.sdkApiVersion.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "sdkApiVersion", nVar.sdkApiVersion);
        }
        if (nVar.sdkType != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "sdkType", nVar.sdkType);
        }
        if (nVar.aHK != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "appUseDuration", nVar.aHK);
        }
        if (nVar.aHL != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "appStartType", nVar.aHL);
        }
        if (nVar.aDb != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "sequenceNumber", nVar.aDb);
        }
        if (nVar.Ne != null && !nVar.Ne.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "appColdStart", nVar.Ne);
        }
        if (nVar.Nf != null && !nVar.Nf.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "appStart", nVar.Nf);
        }
        return jSONObject;
    }
}
