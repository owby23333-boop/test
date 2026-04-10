package com.kwad.sdk.core.a.kwai;

import com.bytedance.msdk.adapter.pangle.PangleAdapterUtils;
import com.bytedance.msdk.api.reward.RewardItem;
import com.kwad.sdk.core.report.y;
import com.qq.e.comm.pi.IBidding;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public final class bi implements com.kwad.sdk.core.d<y.b> {
    private static void a(y.b bVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        bVar.ajH = jSONObject.optInt("photoPlaySecond");
        bVar.ajI = jSONObject.optInt("awardReceiveStage");
        bVar.jS = jSONObject.optInt("itemClickType");
        bVar.ajJ = jSONObject.optInt("itemCloseType");
        bVar.ajK = jSONObject.optInt("elementType");
        bVar.ajL = jSONObject.optString("adRenderArea");
        if (bVar.ajL == JSONObject.NULL) {
            bVar.ajL = "";
        }
        bVar.ajM = jSONObject.optLong(IBidding.HIGHEST_LOSS_PRICE);
        bVar.ajN = jSONObject.optInt("impFailReason");
        bVar.ajO = jSONObject.optLong("winEcpm");
        bVar.adnType = jSONObject.optInt("adnType");
        bVar.adnName = jSONObject.optString(RewardItem.KEY_ADN_NAME);
        if (bVar.adnName == JSONObject.NULL) {
            bVar.adnName = "";
        }
        bVar.ajP = jSONObject.optInt("retainCodeType");
        bVar.ajQ = jSONObject.optInt("photoSizeStyle");
        bVar.To = jSONObject.optString("payload");
        if (bVar.To == JSONObject.NULL) {
            bVar.To = "";
        }
        bVar.ajR = jSONObject.optInt("deeplinkType");
        bVar.ajS = jSONObject.optString("deeplinkAppName");
        if (bVar.ajS == JSONObject.NULL) {
            bVar.ajS = "";
        }
        bVar.ajT = jSONObject.optInt("deeplinkFailedReason");
        bVar.downloadSource = jSONObject.optInt("downloadSource");
        bVar.ajU = jSONObject.optInt("isPackageChanged");
        bVar.ajV = jSONObject.optString("installedFrom");
        if (bVar.ajV == JSONObject.NULL) {
            bVar.ajV = "";
        }
        bVar.ajW = jSONObject.optString("downloadFailedReason");
        if (bVar.ajW == JSONObject.NULL) {
            bVar.ajW = "";
        }
        bVar.ajX = jSONObject.optInt("isChangedEndcard");
        bVar.ait = jSONObject.optInt("adAggPageSource");
        bVar.ajY = jSONObject.optString("serverPackageName");
        if (bVar.ajY == JSONObject.NULL) {
            bVar.ajY = "";
        }
        bVar.ajZ = jSONObject.optString("installedPackageName");
        if (bVar.ajZ == JSONObject.NULL) {
            bVar.ajZ = "";
        }
        bVar.aka = jSONObject.optInt("closeButtonImpressionTime");
        bVar.akb = jSONObject.optInt("closeButtonClickTime");
        bVar.akc = jSONObject.optLong("landingPageLoadedDuration");
        bVar.Jz = jSONObject.optLong("leaveTime");
        bVar.akd = jSONObject.optLong("adItemClickBackDuration");
        bVar.ake = jSONObject.optInt("appStorePageType");
        bVar.akf = jSONObject.optInt("installStatus");
        bVar.oz = jSONObject.optInt("downloadStatus");
        bVar.akg = jSONObject.optInt("downloadCardType");
        bVar.akh = new y.a();
        bVar.akh.parseJson(jSONObject.optJSONObject("clientExtData"));
        bVar.aki = jSONObject.optInt("landingPageType");
        bVar.vy = jSONObject.optLong("playedDuration");
        bVar.akj = jSONObject.optInt("playedRate");
        bVar.akk = jSONObject.optInt("adOrder");
        bVar.akl = jSONObject.optInt("adInterstitialSource");
        bVar.jV = jSONObject.optDouble("splashShakeAcceleration");
        bVar.akm = jSONObject.optInt("universeSecondAd");
        bVar.akn = jSONObject.optString("splashInteractionRotateAngle");
        if (bVar.akn == JSONObject.NULL) {
            bVar.akn = "";
        }
        bVar.ako = jSONObject.optInt("downloadInstallType");
        bVar.akp = jSONObject.optInt("businessSceneType");
        bVar.adxResult = jSONObject.optInt("adxResult");
        bVar.akq = jSONObject.optInt("fingerSwipeType");
        bVar.akr = jSONObject.optInt("fingerSwipeDistance");
        bVar.aks = jSONObject.optInt("triggerType");
        bVar.akt = jSONObject.optInt("cardCloseType");
        bVar.aku = jSONObject.optString("clientPkFailAdInfo");
        if (bVar.aku == JSONObject.NULL) {
            bVar.aku = "";
        }
    }

    private static JSONObject b(y.b bVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        int i2 = bVar.ajH;
        if (i2 != 0) {
            com.kwad.sdk.utils.s.putValue(jSONObject, "photoPlaySecond", i2);
        }
        int i3 = bVar.ajI;
        if (i3 != 0) {
            com.kwad.sdk.utils.s.putValue(jSONObject, "awardReceiveStage", i3);
        }
        int i4 = bVar.jS;
        if (i4 != 0) {
            com.kwad.sdk.utils.s.putValue(jSONObject, "itemClickType", i4);
        }
        int i5 = bVar.ajJ;
        if (i5 != 0) {
            com.kwad.sdk.utils.s.putValue(jSONObject, "itemCloseType", i5);
        }
        int i6 = bVar.ajK;
        if (i6 != 0) {
            com.kwad.sdk.utils.s.putValue(jSONObject, "elementType", i6);
        }
        String str = bVar.ajL;
        if (str != null && !str.equals("")) {
            com.kwad.sdk.utils.s.putValue(jSONObject, "adRenderArea", bVar.ajL);
        }
        long j2 = bVar.ajM;
        if (j2 != 0) {
            com.kwad.sdk.utils.s.putValue(jSONObject, IBidding.HIGHEST_LOSS_PRICE, j2);
        }
        int i7 = bVar.ajN;
        if (i7 != 0) {
            com.kwad.sdk.utils.s.putValue(jSONObject, "impFailReason", i7);
        }
        long j3 = bVar.ajO;
        if (j3 != 0) {
            com.kwad.sdk.utils.s.putValue(jSONObject, "winEcpm", j3);
        }
        int i8 = bVar.adnType;
        if (i8 != 0) {
            com.kwad.sdk.utils.s.putValue(jSONObject, "adnType", i8);
        }
        String str2 = bVar.adnName;
        if (str2 != null && !str2.equals("")) {
            com.kwad.sdk.utils.s.putValue(jSONObject, RewardItem.KEY_ADN_NAME, bVar.adnName);
        }
        int i9 = bVar.ajP;
        if (i9 != 0) {
            com.kwad.sdk.utils.s.putValue(jSONObject, "retainCodeType", i9);
        }
        int i10 = bVar.ajQ;
        if (i10 != 0) {
            com.kwad.sdk.utils.s.putValue(jSONObject, "photoSizeStyle", i10);
        }
        String str3 = bVar.To;
        if (str3 != null && !str3.equals("")) {
            com.kwad.sdk.utils.s.putValue(jSONObject, "payload", bVar.To);
        }
        int i11 = bVar.ajR;
        if (i11 != 0) {
            com.kwad.sdk.utils.s.putValue(jSONObject, "deeplinkType", i11);
        }
        String str4 = bVar.ajS;
        if (str4 != null && !str4.equals("")) {
            com.kwad.sdk.utils.s.putValue(jSONObject, "deeplinkAppName", bVar.ajS);
        }
        int i12 = bVar.ajT;
        if (i12 != 0) {
            com.kwad.sdk.utils.s.putValue(jSONObject, "deeplinkFailedReason", i12);
        }
        int i13 = bVar.downloadSource;
        if (i13 != 0) {
            com.kwad.sdk.utils.s.putValue(jSONObject, "downloadSource", i13);
        }
        int i14 = bVar.ajU;
        if (i14 != 0) {
            com.kwad.sdk.utils.s.putValue(jSONObject, "isPackageChanged", i14);
        }
        String str5 = bVar.ajV;
        if (str5 != null && !str5.equals("")) {
            com.kwad.sdk.utils.s.putValue(jSONObject, "installedFrom", bVar.ajV);
        }
        String str6 = bVar.ajW;
        if (str6 != null && !str6.equals("")) {
            com.kwad.sdk.utils.s.putValue(jSONObject, "downloadFailedReason", bVar.ajW);
        }
        int i15 = bVar.ajX;
        if (i15 != 0) {
            com.kwad.sdk.utils.s.putValue(jSONObject, "isChangedEndcard", i15);
        }
        int i16 = bVar.ait;
        if (i16 != 0) {
            com.kwad.sdk.utils.s.putValue(jSONObject, "adAggPageSource", i16);
        }
        String str7 = bVar.ajY;
        if (str7 != null && !str7.equals("")) {
            com.kwad.sdk.utils.s.putValue(jSONObject, "serverPackageName", bVar.ajY);
        }
        String str8 = bVar.ajZ;
        if (str8 != null && !str8.equals("")) {
            com.kwad.sdk.utils.s.putValue(jSONObject, "installedPackageName", bVar.ajZ);
        }
        int i17 = bVar.aka;
        if (i17 != 0) {
            com.kwad.sdk.utils.s.putValue(jSONObject, "closeButtonImpressionTime", i17);
        }
        int i18 = bVar.akb;
        if (i18 != 0) {
            com.kwad.sdk.utils.s.putValue(jSONObject, "closeButtonClickTime", i18);
        }
        long j4 = bVar.akc;
        if (j4 != 0) {
            com.kwad.sdk.utils.s.putValue(jSONObject, "landingPageLoadedDuration", j4);
        }
        long j5 = bVar.Jz;
        if (j5 != 0) {
            com.kwad.sdk.utils.s.putValue(jSONObject, "leaveTime", j5);
        }
        long j6 = bVar.akd;
        if (j6 != 0) {
            com.kwad.sdk.utils.s.putValue(jSONObject, "adItemClickBackDuration", j6);
        }
        int i19 = bVar.ake;
        if (i19 != 0) {
            com.kwad.sdk.utils.s.putValue(jSONObject, "appStorePageType", i19);
        }
        int i20 = bVar.akf;
        if (i20 != 0) {
            com.kwad.sdk.utils.s.putValue(jSONObject, "installStatus", i20);
        }
        int i21 = bVar.oz;
        if (i21 != 0) {
            com.kwad.sdk.utils.s.putValue(jSONObject, "downloadStatus", i21);
        }
        int i22 = bVar.akg;
        if (i22 != 0) {
            com.kwad.sdk.utils.s.putValue(jSONObject, "downloadCardType", i22);
        }
        com.kwad.sdk.utils.s.a(jSONObject, "clientExtData", bVar.akh);
        int i23 = bVar.aki;
        if (i23 != 0) {
            com.kwad.sdk.utils.s.putValue(jSONObject, "landingPageType", i23);
        }
        long j7 = bVar.vy;
        if (j7 != 0) {
            com.kwad.sdk.utils.s.putValue(jSONObject, "playedDuration", j7);
        }
        int i24 = bVar.akj;
        if (i24 != 0) {
            com.kwad.sdk.utils.s.putValue(jSONObject, "playedRate", i24);
        }
        int i25 = bVar.akk;
        if (i25 != 0) {
            com.kwad.sdk.utils.s.putValue(jSONObject, "adOrder", i25);
        }
        int i26 = bVar.akl;
        if (i26 != 0) {
            com.kwad.sdk.utils.s.putValue(jSONObject, "adInterstitialSource", i26);
        }
        double d2 = bVar.jV;
        if (d2 != PangleAdapterUtils.CPM_DEFLAUT_VALUE) {
            com.kwad.sdk.utils.s.putValue(jSONObject, "splashShakeAcceleration", d2);
        }
        int i27 = bVar.akm;
        if (i27 != 0) {
            com.kwad.sdk.utils.s.putValue(jSONObject, "universeSecondAd", i27);
        }
        String str9 = bVar.akn;
        if (str9 != null && !str9.equals("")) {
            com.kwad.sdk.utils.s.putValue(jSONObject, "splashInteractionRotateAngle", bVar.akn);
        }
        int i28 = bVar.ako;
        if (i28 != 0) {
            com.kwad.sdk.utils.s.putValue(jSONObject, "downloadInstallType", i28);
        }
        int i29 = bVar.akp;
        if (i29 != 0) {
            com.kwad.sdk.utils.s.putValue(jSONObject, "businessSceneType", i29);
        }
        int i30 = bVar.adxResult;
        if (i30 != 0) {
            com.kwad.sdk.utils.s.putValue(jSONObject, "adxResult", i30);
        }
        int i31 = bVar.akq;
        if (i31 != 0) {
            com.kwad.sdk.utils.s.putValue(jSONObject, "fingerSwipeType", i31);
        }
        int i32 = bVar.akr;
        if (i32 != 0) {
            com.kwad.sdk.utils.s.putValue(jSONObject, "fingerSwipeDistance", i32);
        }
        int i33 = bVar.aks;
        if (i33 != 0) {
            com.kwad.sdk.utils.s.putValue(jSONObject, "triggerType", i33);
        }
        int i34 = bVar.akt;
        if (i34 != 0) {
            com.kwad.sdk.utils.s.putValue(jSONObject, "cardCloseType", i34);
        }
        String str10 = bVar.aku;
        if (str10 != null && !str10.equals("")) {
            com.kwad.sdk.utils.s.putValue(jSONObject, "clientPkFailAdInfo", bVar.aku);
        }
        return jSONObject;
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        a((y.b) bVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        return b((y.b) bVar, jSONObject);
    }
}
