package com.kwad.sdk.core.b.a;

import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import com.kwad.sdk.core.adlog.a;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.qq.e.comm.pi.IBidding;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
public final class ah implements com.kwad.sdk.core.d<com.kwad.sdk.core.adlog.c.a> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        a((com.kwad.sdk.core.adlog.c.a) bVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        return b((com.kwad.sdk.core.adlog.c.a) bVar, jSONObject);
    }

    private static void a(com.kwad.sdk.core.adlog.c.a aVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        aVar.adTemplate = new AdTemplate();
        aVar.adTemplate.parseJson(jSONObject.optJSONObject("adTemplate"));
        aVar.axI = jSONObject.optJSONObject("extData");
        aVar.awx = jSONObject.optInt("adActionType");
        aVar.axJ = jSONObject.optInt("photoPlaySecond");
        aVar.axK = jSONObject.optInt("awardReceiveStage");
        aVar.mI = jSONObject.optInt("itemClickType");
        aVar.axL = jSONObject.optInt("itemCloseType");
        aVar.axM = jSONObject.optInt("elementType");
        aVar.axN = jSONObject.optString("adRenderArea");
        if (JSONObject.NULL.toString().equals(aVar.axN)) {
            aVar.axN = "";
        }
        aVar.axO = jSONObject.optLong(IBidding.HIGHEST_LOSS_PRICE);
        aVar.axP = jSONObject.optInt("impFailReason");
        aVar.axQ = jSONObject.optLong("winEcpm");
        aVar.adnType = jSONObject.optInt("adnType");
        aVar.adnName = jSONObject.optString(MediationConstant.KEY_ADN_NAME);
        if (JSONObject.NULL.toString().equals(aVar.adnName)) {
            aVar.adnName = "";
        }
        aVar.axR = jSONObject.optString("adnAdvertiser");
        if (JSONObject.NULL.toString().equals(aVar.axR)) {
            aVar.axR = "";
        }
        aVar.axS = jSONObject.optString("adnTitle");
        if (JSONObject.NULL.toString().equals(aVar.axS)) {
            aVar.axS = "";
        }
        aVar.axT = jSONObject.optString("adnRequestId");
        if (JSONObject.NULL.toString().equals(aVar.axT)) {
            aVar.axT = "";
        }
        aVar.axU = jSONObject.optInt("adnShowType");
        aVar.axV = jSONObject.optInt("adnClickType");
        aVar.adnMaterialType = jSONObject.optInt("adnMaterialType");
        aVar.adnMaterialUrl = jSONObject.optString("adnMaterialUrl");
        if (JSONObject.NULL.toString().equals(aVar.adnMaterialUrl)) {
            aVar.adnMaterialUrl = "";
        }
        aVar.axW = jSONObject.optInt("retainCodeType");
        aVar.Pl = jSONObject.optInt("photoSizeStyle");
        aVar.Pj = jSONObject.optString("payload");
        if (JSONObject.NULL.toString().equals(aVar.Pj)) {
            aVar.Pj = "";
        }
        aVar.axX = jSONObject.optInt("deeplinkType");
        aVar.axY = jSONObject.optString("deeplinkAppName");
        if (JSONObject.NULL.toString().equals(aVar.axY)) {
            aVar.axY = "";
        }
        aVar.axZ = jSONObject.optInt("deeplinkFailedReason");
        aVar.downloadSource = jSONObject.optInt("downloadSource");
        aVar.aya = jSONObject.optInt("isPackageChanged");
        aVar.ayb = jSONObject.optString("installedFrom");
        if (JSONObject.NULL.toString().equals(aVar.ayb)) {
            aVar.ayb = "";
        }
        aVar.ayc = jSONObject.optString("downloadFailedReason");
        if (JSONObject.NULL.toString().equals(aVar.ayc)) {
            aVar.ayc = "";
        }
        aVar.ayd = jSONObject.optInt("isChangedEndcard");
        aVar.aye = jSONObject.optInt("adAggPageSource");
        aVar.ayf = jSONObject.optString("serverPackageName");
        if (JSONObject.NULL.toString().equals(aVar.ayf)) {
            aVar.ayf = "";
        }
        aVar.ayg = jSONObject.optString("installedPackageName");
        if (JSONObject.NULL.toString().equals(aVar.ayg)) {
            aVar.ayg = "";
        }
        aVar.ayh = jSONObject.optInt("closeButtonImpressionTime");
        aVar.ayi = jSONObject.optInt("closeButtonClickTime");
        aVar.ayj = jSONObject.optLong("landingPageLoadedDuration");
        aVar.PL = jSONObject.optLong("leaveTime");
        aVar.ayk = jSONObject.optLong("adItemClickBackDuration");
        aVar.ayl = jSONObject.optInt("appStorePageType");
        aVar.aym = jSONObject.optInt("installStatus");
        aVar.downloadStatus = jSONObject.optInt("downloadStatus");
        aVar.ayn = jSONObject.optInt("downloadCardType");
        aVar.Pk = new a.C0392a();
        aVar.Pk.parseJson(jSONObject.optJSONObject("clientExtData"));
        aVar.To = jSONObject.optInt("landingPageType");
        aVar.yU = jSONObject.optLong("playedDuration");
        aVar.ayo = jSONObject.optInt("playedRate");
        aVar.ayp = jSONObject.optInt("adOrder");
        aVar.Pi = jSONObject.optInt("adInterstitialSource");
        aVar.mL = jSONObject.optDouble("splashShakeAcceleration");
        aVar.ayq = jSONObject.optString("splashInteractionRotateAngle");
        if (JSONObject.NULL.toString().equals(aVar.ayq)) {
            aVar.ayq = "";
        }
        aVar.ayr = jSONObject.optInt("downloadInstallType");
        aVar.ays = jSONObject.optInt("businessSceneType");
        aVar.adxResult = jSONObject.optInt("adxResult");
        aVar.ayt = jSONObject.optInt("fingerSwipeType");
        aVar.ayu = jSONObject.optInt("fingerSwipeDistance");
        aVar.ayv = jSONObject.optInt("finger_swipe_angle");
        aVar.Pm = jSONObject.optInt("triggerType");
        aVar.ayw = jSONObject.optInt("cardCloseType");
        aVar.ayx = jSONObject.optString("clientPkFailAdInfo");
        if (JSONObject.NULL.toString().equals(aVar.ayx)) {
            aVar.ayx = "";
        }
    }

    private static JSONObject b(com.kwad.sdk.core.adlog.c.a aVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        com.kwad.sdk.utils.aa.a(jSONObject, "adTemplate", aVar.adTemplate);
        com.kwad.sdk.utils.aa.putValue(jSONObject, "extData", aVar.axI);
        if (aVar.awx != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "adActionType", aVar.awx);
        }
        if (aVar.axJ != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "photoPlaySecond", aVar.axJ);
        }
        if (aVar.axK != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "awardReceiveStage", aVar.axK);
        }
        if (aVar.mI != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "itemClickType", aVar.mI);
        }
        if (aVar.axL != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "itemCloseType", aVar.axL);
        }
        if (aVar.axM != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "elementType", aVar.axM);
        }
        if (aVar.axN != null && !aVar.axN.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "adRenderArea", aVar.axN);
        }
        if (aVar.axO != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, IBidding.HIGHEST_LOSS_PRICE, aVar.axO);
        }
        if (aVar.axP != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "impFailReason", aVar.axP);
        }
        if (aVar.axQ != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "winEcpm", aVar.axQ);
        }
        if (aVar.adnType != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "adnType", aVar.adnType);
        }
        if (aVar.adnName != null && !aVar.adnName.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, MediationConstant.KEY_ADN_NAME, aVar.adnName);
        }
        if (aVar.axR != null && !aVar.axR.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "adnAdvertiser", aVar.axR);
        }
        if (aVar.axS != null && !aVar.axS.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "adnTitle", aVar.axS);
        }
        if (aVar.axT != null && !aVar.axT.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "adnRequestId", aVar.axT);
        }
        if (aVar.axU != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "adnShowType", aVar.axU);
        }
        if (aVar.axV != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "adnClickType", aVar.axV);
        }
        if (aVar.adnMaterialType != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "adnMaterialType", aVar.adnMaterialType);
        }
        if (aVar.adnMaterialUrl != null && !aVar.adnMaterialUrl.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "adnMaterialUrl", aVar.adnMaterialUrl);
        }
        if (aVar.axW != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "retainCodeType", aVar.axW);
        }
        if (aVar.Pl != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "photoSizeStyle", aVar.Pl);
        }
        if (aVar.Pj != null && !aVar.Pj.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "payload", aVar.Pj);
        }
        if (aVar.axX != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "deeplinkType", aVar.axX);
        }
        if (aVar.axY != null && !aVar.axY.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "deeplinkAppName", aVar.axY);
        }
        if (aVar.axZ != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "deeplinkFailedReason", aVar.axZ);
        }
        if (aVar.downloadSource != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "downloadSource", aVar.downloadSource);
        }
        if (aVar.aya != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "isPackageChanged", aVar.aya);
        }
        if (aVar.ayb != null && !aVar.ayb.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "installedFrom", aVar.ayb);
        }
        if (aVar.ayc != null && !aVar.ayc.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "downloadFailedReason", aVar.ayc);
        }
        if (aVar.ayd != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "isChangedEndcard", aVar.ayd);
        }
        if (aVar.aye != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "adAggPageSource", aVar.aye);
        }
        if (aVar.ayf != null && !aVar.ayf.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "serverPackageName", aVar.ayf);
        }
        if (aVar.ayg != null && !aVar.ayg.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "installedPackageName", aVar.ayg);
        }
        if (aVar.ayh != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "closeButtonImpressionTime", aVar.ayh);
        }
        if (aVar.ayi != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "closeButtonClickTime", aVar.ayi);
        }
        if (aVar.ayj != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "landingPageLoadedDuration", aVar.ayj);
        }
        if (aVar.PL != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "leaveTime", aVar.PL);
        }
        if (aVar.ayk != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "adItemClickBackDuration", aVar.ayk);
        }
        if (aVar.ayl != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "appStorePageType", aVar.ayl);
        }
        if (aVar.aym != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "installStatus", aVar.aym);
        }
        if (aVar.downloadStatus != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "downloadStatus", aVar.downloadStatus);
        }
        if (aVar.ayn != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "downloadCardType", aVar.ayn);
        }
        com.kwad.sdk.utils.aa.a(jSONObject, "clientExtData", aVar.Pk);
        if (aVar.To != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "landingPageType", aVar.To);
        }
        if (aVar.yU != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "playedDuration", aVar.yU);
        }
        if (aVar.ayo != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "playedRate", aVar.ayo);
        }
        if (aVar.ayp != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "adOrder", aVar.ayp);
        }
        if (aVar.Pi != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "adInterstitialSource", aVar.Pi);
        }
        if (aVar.mL != 0.0d) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "splashShakeAcceleration", aVar.mL);
        }
        if (aVar.ayq != null && !aVar.ayq.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "splashInteractionRotateAngle", aVar.ayq);
        }
        if (aVar.ayr != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "downloadInstallType", aVar.ayr);
        }
        if (aVar.ays != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "businessSceneType", aVar.ays);
        }
        if (aVar.adxResult != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "adxResult", aVar.adxResult);
        }
        if (aVar.ayt != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "fingerSwipeType", aVar.ayt);
        }
        if (aVar.ayu != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "fingerSwipeDistance", aVar.ayu);
        }
        if (aVar.ayv != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "finger_swipe_angle", aVar.ayv);
        }
        if (aVar.Pm != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "triggerType", aVar.Pm);
        }
        if (aVar.ayw != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "cardCloseType", aVar.ayw);
        }
        if (aVar.ayx != null && !aVar.ayx.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "clientPkFailAdInfo", aVar.ayx);
        }
        return jSONObject;
    }
}
