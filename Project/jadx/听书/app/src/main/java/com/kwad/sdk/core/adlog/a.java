package com.kwad.sdk.core.adlog;

import android.content.Context;
import android.text.TextUtils;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import com.kwad.sdk.core.response.b.e;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.track.AdTrackLog;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.service.a.h;
import com.kwad.sdk.utils.aa;
import com.kwad.sdk.utils.aj;
import com.kwad.sdk.utils.bp;
import com.qq.e.comm.pi.IBidding;
import java.util.Iterator;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
public final class a extends com.kwad.sdk.core.network.b {
    int awS;
    private final com.kwad.sdk.core.adlog.c.a awT;
    private final AdTemplate mAdTemplate;

    @Override // com.kwad.sdk.core.network.b
    public final void buildBaseBody() {
    }

    @Override // com.kwad.sdk.core.network.b
    public final void buildBaseHeader() {
    }

    public a(com.kwad.sdk.core.adlog.c.a aVar) {
        this.awT = aVar;
        this.mAdTemplate = aVar.adTemplate;
        this.awS = aVar.awx;
    }

    @Override // com.kwad.sdk.core.network.b, com.kwad.sdk.core.network.f
    public final JSONObject getBody() {
        return this.mBodyParams;
    }

    @Override // com.kwad.sdk.core.network.b, com.kwad.sdk.core.network.f
    public final String getUrl() {
        String strReplaceFirst;
        String strReplaceFirst2;
        Context context = ServiceProvider.getContext();
        AdInfo adInfoEl = e.el(this.mAdTemplate);
        int i = this.awS;
        if (i == 1) {
            String str = adInfoEl.adBaseInfo.showUrl;
            if (this.mAdTemplate.mBidEcpm == 0 && ((h) ServiceProvider.get(h.class)).BE()) {
                strReplaceFirst2 = str.replaceFirst("__PR__", String.valueOf(com.kwad.sdk.core.response.b.a.aR(e.el(this.mAdTemplate))));
            } else {
                strReplaceFirst2 = str.replaceFirst("__PR__", String.valueOf(this.mAdTemplate.mBidEcpm));
            }
            strReplaceFirst = strReplaceFirst2.replaceFirst("__TYPE__", String.valueOf(this.mAdTemplate.mVideoPlayerStatus.mVideoPlayerType)).replaceFirst("__BEHAVIOR__", String.valueOf(this.mAdTemplate.mVideoPlayerStatus.mVideoPlayerBehavior));
            a(strReplaceFirst, this.awT);
            a(strReplaceFirst, this.mAdTemplate, this.awT);
        } else if (i == 2) {
            strReplaceFirst = aj.ao(context, aj.a(adInfoEl.adBaseInfo.clickUrl, this.awT.mK)).replaceFirst("__PR__", String.valueOf(this.mAdTemplate.mBidEcpm)).replaceFirst("__TYPE__", String.valueOf(this.mAdTemplate.mVideoPlayerStatus.mVideoPlayerType)).replaceFirst("__BEHAVIOR__", String.valueOf(this.mAdTemplate.mVideoPlayerStatus.mVideoPlayerBehavior));
            b(strReplaceFirst, this.awT);
            a(strReplaceFirst, this.mAdTemplate, this.awT);
        } else {
            strReplaceFirst = adInfoEl.adBaseInfo.convUrl.replaceFirst("__ACTION__", String.valueOf(this.awS)).replaceFirst("__PR__", String.valueOf(this.mAdTemplate.mBidEcpm)).replaceFirst("__TYPE__", String.valueOf(this.mAdTemplate.mVideoPlayerStatus.mVideoPlayerType)).replaceFirst("__BEHAVIOR__", String.valueOf(this.mAdTemplate.mVideoPlayerStatus.mVideoPlayerBehavior));
            c(strReplaceFirst, this.awT);
        }
        Ew();
        return strReplaceFirst;
    }

    private void a(String str, com.kwad.sdk.core.adlog.c.a aVar) {
        if (aVar == null || TextUtils.isEmpty(str)) {
            return;
        }
        if (aVar.ayp >= 0) {
            putBody("adOrder", aVar.ayp);
        }
        if (aVar.Pi >= 0) {
            putBody("adInterstitialSource", aVar.Pi);
        }
        if (!TextUtils.isEmpty(aVar.axN)) {
            putBody("adRenderArea", aVar.axN);
        }
        putBody("adxResult", aVar.adxResult);
        if (aVar.ayt != 0) {
            putBody("fingerSwipeType", aVar.ayt);
        }
        if (aVar.ayu != 0) {
            putBody("fingerSwipeDistance", aVar.ayu);
        }
        if (aVar.aym != -1) {
            putBody("installStatus", aVar.aym);
        }
        if (aVar.Pk != null) {
            putBody("clientExtData", aVar.Pk.toJson().toString());
        }
        if (aVar.ayx != null) {
            putBody("clientPkFailAdInfo", aVar.ayx);
        }
        if (aVar.Pm != -1) {
            putBody("triggerType", aVar.Pm);
        }
        if (aVar.Pl != 0) {
            putBody("photoSizeStyle", aVar.Pl);
        }
    }

    private void a(String str, AdTemplate adTemplate, com.kwad.sdk.core.adlog.c.a aVar) {
        if (TextUtils.isEmpty(str) || adTemplate == null) {
            return;
        }
        if (adTemplate.mInitVoiceStatus != 0) {
            putBody("initVoiceStatus", adTemplate.mInitVoiceStatus);
        }
        if (this.mAdTemplate.mBidEcpm == 0) {
            putBody("ecpmType", 2);
        } else {
            putBody("ecpmType", 1);
        }
        if (aVar == null) {
            return;
        }
        if (aVar.aye != 0) {
            putBody("adAggPageSource", aVar.aye);
        }
        if (TextUtils.isEmpty(aVar.Pj)) {
            return;
        }
        putBody("payload", aVar.Pj);
    }

    private void b(String str, com.kwad.sdk.core.adlog.c.a aVar) {
        if (aVar == null || TextUtils.isEmpty(str)) {
            return;
        }
        if (aVar.mI != 0) {
            putBody("itemClickType", aVar.mI);
        }
        if (!TextUtils.isEmpty(aVar.Pj)) {
            putBody("payload", aVar.Pj);
        }
        if (aVar.aye != 0) {
            putBody("adAggPageSource", aVar.aye);
        }
        if (aVar.ayp >= 0) {
            putBody("adOrder", aVar.ayp);
        }
        if (aVar.Pi >= 0) {
            putBody("adInterstitialSource", aVar.Pi);
        }
        if (aVar.Pm != -1) {
            putBody("triggerType", aVar.Pm);
        }
        if (aVar.ayw != 0) {
            putBody("cardCloseType", aVar.ayw);
        }
        putBody("adxResult", aVar.adxResult);
        if (aVar.mL > 0.0d) {
            putBody("splashShakeAcceleration", aVar.mL);
        }
        if (!TextUtils.isEmpty(aVar.ayq)) {
            putBody("splashInteractionRotateAngle", aVar.ayq);
        }
        if (aVar.ayt != 0) {
            putBody("fingerSwipeType", aVar.ayt);
        }
        if (aVar.ayu != 0) {
            putBody("fingerSwipeDistance", aVar.ayu);
        }
        if (aVar.yU > 0) {
            putBody("playedDuration", aVar.yU);
        }
        if (aVar.ayo > 0) {
            putBody("playedRate", aVar.ayo);
        }
        if (aVar.ayx != null) {
            putBody("clientPkFailAdInfo", aVar.ayx);
        }
        if (aVar.axW != -1) {
            putBody("retainCodeType", aVar.axW);
        }
        if (aVar.Pk != null) {
            putBody("clientExtData", aVar.Pk.toJson().toString());
        }
        if (aVar.ayv != 0) {
            putBody("finger_swiper_angle", aVar.ayv);
        }
        if (aVar.Pl != 0) {
            putBody("photoSizeStyle", aVar.Pl);
        }
    }

    private void c(String str, com.kwad.sdk.core.adlog.c.a aVar) {
        if (aVar == null || TextUtils.isEmpty(str)) {
            return;
        }
        if (aVar.axL != 0) {
            putBody("itemCloseType", aVar.axL);
        }
        if (aVar.axJ > 0) {
            putBody("photoPlaySecond", aVar.axJ);
        }
        if (aVar.axK != 0) {
            putBody("awardReceiveStage", aVar.axK);
        }
        if (aVar.axM != 0) {
            putBody("elementType", aVar.axM);
        }
        if (!TextUtils.isEmpty(aVar.Pj)) {
            putBody("payload", aVar.Pj);
        }
        if (aVar.Pk != null) {
            putBody("clientExtData", aVar.Pk.toJson().toString());
        }
        if (aVar.axX > 0) {
            putBody("deeplinkType", aVar.axX);
        }
        if (!TextUtils.isEmpty(aVar.axY)) {
            putBody("deeplinkAppName", aVar.axY);
        }
        if (aVar.axZ != 0) {
            putBody("deeplinkFailedReason", aVar.axZ);
        }
        if (aVar.downloadSource > 0) {
            putBody("downloadSource", aVar.downloadSource);
        }
        if (aVar.ayw != 0) {
            putBody("cardCloseType", aVar.ayw);
        }
        if (aVar.aya > 0) {
            putBody("isPackageChanged", aVar.aya);
        }
        putBody("installedFrom", aVar.ayb);
        putBody("isChangedEndcard", aVar.ayd);
        if (aVar.aye != 0) {
            putBody("adAggPageSource", aVar.aye);
        }
        if (aVar.ayc != null) {
            putBody("downloadFailedReason", aVar.ayc);
        }
        if (!bp.isNullString(aVar.ayg)) {
            putBody("installedPackageName", aVar.ayg);
        }
        if (!bp.isNullString(aVar.ayf)) {
            putBody("serverPackageName", aVar.ayf);
        }
        if (aVar.ayi > 0) {
            putBody("closeButtonClickTime", aVar.ayi);
        }
        if (aVar.ayh > 0) {
            putBody("closeButtonImpressionTime", aVar.ayh);
        }
        if (aVar.downloadStatus >= 0) {
            putBody("downloadStatus", aVar.downloadStatus);
        }
        if (aVar.ayj > 0) {
            putBody("landingPageLoadedDuration", aVar.ayj);
        }
        if (aVar.PL > 0) {
            putBody("leaveTime", aVar.PL);
        }
        if (aVar.ayk > 0) {
            putBody("adItemClickBackDuration", aVar.ayk);
        }
        if (aVar.axW != -1) {
            putBody("retainCodeType", aVar.axW);
        }
        if (aVar.axO > -1) {
            putBody(IBidding.HIGHEST_LOSS_PRICE, aVar.axO);
        }
        if (aVar.axP >= 0 || aVar.axP == -9999) {
            putBody("impFailReason", aVar.axP);
        }
        if (aVar.axQ > -1 || aVar.axQ == -9999) {
            putBody("winEcpm", aVar.axQ);
        }
        if (aVar.adnType > 0 || aVar.adnType == -9999) {
            putBody("adnType", aVar.adnType);
        }
        if (!TextUtils.isEmpty(aVar.adnName)) {
            putBody(MediationConstant.KEY_ADN_NAME, aVar.adnName);
        }
        if (!TextUtils.isEmpty(aVar.axR)) {
            putBody("adnAdvertiser", aVar.axR);
        }
        if (!TextUtils.isEmpty(aVar.axS)) {
            putBody("adnTitle", aVar.axS);
        }
        if (!TextUtils.isEmpty(aVar.axT)) {
            putBody("adnRequestId", aVar.axT);
        }
        putBody("adnShowType", aVar.axU);
        putBody("adnClickType", aVar.axV);
        putBody("adnMaterialType", aVar.adnMaterialType);
        if (!TextUtils.isEmpty(aVar.adnMaterialUrl)) {
            putBody("adnMaterialUrl", aVar.adnMaterialUrl);
        }
        putBody("downloadCardType", aVar.ayn);
        putBody("landingPageType", aVar.To);
        if (aVar.Pi >= 0) {
            putBody("adInterstitialSource", aVar.Pi);
        }
        if (aVar.ayr > 0) {
            putBody("downloadInstallType", aVar.ayr);
        }
        if (aVar.ayt != 0) {
            putBody("fingerSwipeType", aVar.ayt);
        }
        if (aVar.ayu != 0) {
            putBody("fingerSwipeDistance", aVar.ayu);
        }
        if (aVar.ays > 0) {
            putBody("businessSceneType", aVar.ays);
        }
        if (aVar.yU > 0) {
            putBody("playedDuration", aVar.yU);
        }
        if (aVar.ayo > 0) {
            putBody("playedRate", aVar.ayo);
        }
        if (aVar.ayl != -1) {
            putBody("appStorePageType", aVar.ayl);
        }
        if (aVar.Pm != -1) {
            putBody("triggerType", aVar.Pm);
        }
        if (aVar.Pl != 0) {
            putBody("photoSizeStyle", aVar.Pl);
        }
    }

    private void Ew() {
        JSONObject jSONObject = this.awT.axI;
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        aa.putValue(jSONObject, "clientTimestamp", System.currentTimeMillis());
        putBody("extData", jSONObject.toString());
    }

    /* JADX INFO: renamed from: com.kwad.sdk.core.adlog.a$a, reason: collision with other inner class name */
    public static class C0392a extends com.kwad.sdk.core.response.a.a {
        public int awU;
        public String awV;
        public String awW;
        public String awY;
        public int awZ;
        public int axa;
        public int axb;
        public int axc;
        public int axd;
        public boolean axe;
        public String axf;
        public JSONObject axg;
        public int axi;
        public int axj;
        public AdTrackLog axk;
        public String templateId;
        public int awX = -1;
        public long duration = -1;
        public int showLiveStatus = -1;
        public int axh = 0;
        public int showLiveStyle = -1;

        @Override // com.kwad.sdk.core.response.a.a
        public void afterToJson(JSONObject jSONObject) {
            super.afterToJson(jSONObject);
            int i = this.awX;
            if (i != -1) {
                aa.putValue(jSONObject, "shield_reason", i);
            }
            long j = this.duration;
            if (j != -1) {
                aa.putValue(jSONObject, "duration", j);
            }
            int i2 = this.showLiveStatus;
            if (i2 != -1) {
                aa.putValue(jSONObject, "show_live_status", i2);
            }
            int i3 = this.showLiveStyle;
            if (i3 != -1) {
                aa.putValue(jSONObject, "show_live_style", i3);
            }
            AdTrackLog adTrackLog = this.axk;
            if (adTrackLog != null) {
                aa.putValue(jSONObject, "ad_track_log", adTrackLog.toJson().toString());
            }
            JSONObject jSONObject2 = this.axg;
            if (jSONObject2 != null) {
                try {
                    Iterator<String> itKeys = jSONObject2.keys();
                    while (itKeys.hasNext()) {
                        String next = itKeys.next();
                        jSONObject.putOpt(next, this.axg.get(next));
                    }
                } catch (Throwable unused) {
                }
            }
        }

        public final AdTrackLog a(AdTemplate adTemplate, String str, String str2, com.kwad.sdk.g.a<AdTrackLog> aVar) {
            h hVar;
            if (adTemplate == null || (hVar = (h) ServiceProvider.get(h.class)) == null || !hVar.BP()) {
                return null;
            }
            AdTrackLog adTrackLog = new AdTrackLog(str, str2);
            this.axk = adTrackLog;
            adTrackLog.bindABParams(adTemplate);
            if (aVar != null) {
                aVar.accept(this.axk);
            }
            return this.axk;
        }
    }
}
