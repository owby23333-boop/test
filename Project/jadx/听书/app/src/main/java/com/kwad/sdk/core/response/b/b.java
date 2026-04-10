package com.kwad.sdk.core.response.b;

import android.text.TextUtils;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdMatrixInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.response.model.FeedSlideConf;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.utils.aq;
import com.kwad.sdk.utils.bp;
import java.util.List;
import java.util.Random;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
public final class b {
    private static Random aIN = new Random();

    public static AdMatrixInfo cp(AdTemplate adTemplate) {
        if (e.ed(adTemplate)) {
            return e.el(adTemplate).adMatrixInfo;
        }
        return new AdMatrixInfo();
    }

    public static List<AdMatrixInfo.MatrixTemplate> cq(AdTemplate adTemplate) {
        return cp(adTemplate).styles.templateList;
    }

    public static AdMatrixInfo.AdDataV2 cr(AdTemplate adTemplate) {
        return e.el(adTemplate).adMatrixInfo.adDataV2;
    }

    public static AdMatrixInfo.MatrixTemplate k(AdTemplate adTemplate, String str) {
        for (AdMatrixInfo.MatrixTemplate matrixTemplate : cp(adTemplate).styles.templateList) {
            if (bp.isEquals(str, matrixTemplate.templateId)) {
                return matrixTemplate;
            }
        }
        return null;
    }

    private static AdMatrixInfo.TemplateData l(AdTemplate adTemplate, String str) {
        for (AdMatrixInfo.TemplateData templateData : cp(adTemplate).adDataV2.templateDataList) {
            if (bp.isEquals(str, templateData.templateId)) {
                return templateData;
            }
        }
        return null;
    }

    private static long m(AdTemplate adTemplate, String str) {
        AdMatrixInfo.TemplateData templateDataL = l(adTemplate, str);
        if (templateDataL != null) {
            return templateDataL.templateDelayTime;
        }
        return 0L;
    }

    public static FeedSlideConf cs(AdTemplate adTemplate) {
        JSONArray jSONArrayOptJSONArray;
        AdMatrixInfo.TemplateData templateDataL = l(adTemplate, cP(adTemplate).templateId);
        try {
            JSONObject jSONObjectOptJSONObject = new JSONObject(templateDataL != null ? templateDataL.data : "").optJSONObject("slideInfo");
            if (jSONObjectOptJSONObject != null && (jSONArrayOptJSONArray = jSONObjectOptJSONObject.optJSONArray("angle")) != null && jSONArrayOptJSONArray.length() > 1) {
                FeedSlideConf feedSlideConf = new FeedSlideConf();
                feedSlideConf.minRange = ((Integer) jSONArrayOptJSONArray.get(0)).intValue();
                feedSlideConf.maxRange = ((Integer) jSONArrayOptJSONArray.get(1)).intValue();
                return feedSlideConf;
            }
        } catch (Throwable unused) {
        }
        return null;
    }

    public static AdMatrixInfo.InterstitialCardInfo ct(AdTemplate adTemplate) {
        return cp(adTemplate).adDataV2.interstitialCardInfo;
    }

    public static String cu(AdTemplate adTemplate) {
        AdMatrixInfo.MatrixTemplate matrixTemplateK = k(adTemplate, cp(adTemplate).adDataV2.splashActionBarInfo.templateId);
        return matrixTemplateK != null ? matrixTemplateK.templateUrl : "";
    }

    private static AdMatrixInfo.ActionBarInfoNew cv(AdTemplate adTemplate) {
        return cp(adTemplate).adDataV2.actionBarInfo;
    }

    public static String cw(AdTemplate adTemplate) {
        AdInfo adInfoEl = e.el(adTemplate);
        boolean z = e.eF(adTemplate) || e.ef(adTemplate) == 2;
        if (a.cR(adInfoEl)) {
            return "";
        }
        if (z && a.co(adTemplate)) {
            AdMatrixInfo.MatrixTemplate matrixTemplateK = k(adTemplate, dt(adTemplate).templateId);
            return matrixTemplateK != null ? matrixTemplateK.templateUrl : "";
        }
        AdMatrixInfo.MatrixTemplate matrixTemplateK2 = k(adTemplate, cv(adTemplate).templateId);
        return matrixTemplateK2 != null ? matrixTemplateK2.templateUrl : "";
    }

    public static boolean ey(String str) {
        try {
            return ((com.kwad.sdk.service.a.h) ServiceProvider.get(com.kwad.sdk.service.a.h.class)).cg(str);
        } catch (Exception unused) {
            return false;
        }
    }

    public static long cx(AdTemplate adTemplate) {
        return cv(adTemplate).maxTimeOut;
    }

    public static boolean cy(AdTemplate adTemplate) {
        return !TextUtils.isEmpty(cw(adTemplate));
    }

    private static AdMatrixInfo.AggregationCardInfo cz(AdTemplate adTemplate) {
        return cp(adTemplate).adDataV2.aggregationCardInfo;
    }

    public static String cA(AdTemplate adTemplate) {
        AdMatrixInfo.MatrixTemplate matrixTemplateK = k(adTemplate, cz(adTemplate).templateId);
        return matrixTemplateK != null ? matrixTemplateK.templateUrl : "";
    }

    public static long cB(AdTemplate adTemplate) {
        return m(adTemplate, cz(adTemplate).templateId);
    }

    public static long cC(AdTemplate adTemplate) {
        return ((long) cz(adTemplate).changeTime) * 1000;
    }

    public static int cD(AdTemplate adTemplate) {
        return cz(adTemplate).maxTimesPerDay;
    }

    public static long cE(AdTemplate adTemplate) {
        return cz(adTemplate).intervalTime;
    }

    public static boolean cF(AdTemplate adTemplate) {
        AdInfo adInfoEl = e.el(adTemplate);
        return !a.aF(adInfoEl) && a.at(adInfoEl);
    }

    public static boolean cG(AdTemplate adTemplate) {
        if (!TextUtils.isEmpty(cA(adTemplate)) && cB(adTemplate) > 0) {
            return aq.isOrientationPortrait();
        }
        return false;
    }

    private static AdMatrixInfo.BaseMatrixTemplate cH(AdTemplate adTemplate) {
        return cp(adTemplate).adDataV2.halfCardInfo;
    }

    public static String cI(AdTemplate adTemplate) {
        AdMatrixInfo.MatrixTemplate matrixTemplateK = k(adTemplate, cH(adTemplate).templateId);
        return matrixTemplateK != null ? matrixTemplateK.templateUrl : "";
    }

    private static AdMatrixInfo.EndCardInfo cJ(AdTemplate adTemplate) {
        return cp(adTemplate).adDataV2.endCardInfo;
    }

    public static String cK(AdTemplate adTemplate) {
        AdMatrixInfo.MatrixTemplate matrixTemplateK = k(adTemplate, cJ(adTemplate).templateId);
        return matrixTemplateK != null ? matrixTemplateK.templateUrl : "";
    }

    public static boolean cL(AdTemplate adTemplate) {
        return !TextUtils.isEmpty(cK(adTemplate));
    }

    private static String cM(AdTemplate adTemplate) {
        AdMatrixInfo.MatrixTemplate matrixTemplateK = k(adTemplate, e.el(adTemplate).adMatrixInfo.adDataV2.activityMiddlePageInfo.templateId);
        return matrixTemplateK != null ? matrixTemplateK.templateUrl : "";
    }

    public static String cN(AdTemplate adTemplate) {
        if (cO(adTemplate)) {
            return cM(adTemplate);
        }
        return a.aS(e.el(adTemplate));
    }

    private static boolean cO(AdTemplate adTemplate) {
        return (adTemplate.mIsForceJumpLandingPage || a.cm(adTemplate) || !dD(e.el(adTemplate))) ? false : true;
    }

    private static AdMatrixInfo.FeedInfo cP(AdTemplate adTemplate) {
        if (cR(adTemplate)) {
            return cp(adTemplate).adDataV2.adUnionFeedLiveTemplateInfo;
        }
        return cp(adTemplate).adDataV2.feedInfo;
    }

    private static AdMatrixInfo.NativeMatrixAdInfo cQ(AdTemplate adTemplate) {
        return cp(adTemplate).adDataV2.nativeAdInfo;
    }

    private static boolean cR(AdTemplate adTemplate) {
        return a.cR(e.el(adTemplate));
    }

    private static AdMatrixInfo.FeedInfo cS(AdTemplate adTemplate) {
        return cp(adTemplate).adDataV2.adUnionFeedLiveMediaInfo;
    }

    public static String cT(AdTemplate adTemplate) {
        AdMatrixInfo.MatrixTemplate matrixTemplateK = k(adTemplate, cP(adTemplate).templateId);
        return matrixTemplateK != null ? matrixTemplateK.templateUrl : "";
    }

    private static AdMatrixInfo.FeedTKInfo cU(AdTemplate adTemplate) {
        return cp(adTemplate).adDataV2.feedTKCardInfo;
    }

    public static String cV(AdTemplate adTemplate) {
        AdMatrixInfo.MatrixTemplate matrixTemplateK = k(adTemplate, cS(adTemplate).templateId);
        return matrixTemplateK != null ? matrixTemplateK.templateUrl : "";
    }

    public static boolean cW(AdTemplate adTemplate) {
        return cP(adTemplate).interactionInfo.interactiveStyle == 2;
    }

    public static boolean cX(AdTemplate adTemplate) {
        return cP(adTemplate).interactionInfo.shakeInfo.clickDisabled;
    }

    public static int cY(AdTemplate adTemplate) {
        AdMatrixInfo.AdInteractionInfo adInteractionInfo = cP(adTemplate).interactionInfo;
        if (adInteractionInfo == null || adInteractionInfo.shakeInfo == null) {
            return 0;
        }
        return adInteractionInfo.shakeInfo.acceleration;
    }

    public static boolean cZ(AdTemplate adTemplate) {
        AdMatrixInfo.AdInteractionInfo adInteractionInfo = cQ(adTemplate).interactionInfo;
        if (adInteractionInfo == null || adInteractionInfo.shakeInfo == null) {
            return false;
        }
        return adInteractionInfo.shakeInfo.enable;
    }

    public static int da(AdTemplate adTemplate) {
        AdMatrixInfo.AdInteractionInfo adInteractionInfo = cQ(adTemplate).interactionInfo;
        if (adInteractionInfo == null || adInteractionInfo.shakeInfo == null) {
            return 0;
        }
        return adInteractionInfo.shakeInfo.acceleration;
    }

    public static double db(AdTemplate adTemplate) {
        return e.el(adTemplate).adStyleInfo.feedAdInfo.heightRatio;
    }

    public static boolean dy(AdInfo adInfo) {
        return !TextUtils.isEmpty(adInfo.adMatrixInfo.adDataV2.splashEndCardTKInfo.templateId);
    }

    public static boolean dz(AdInfo adInfo) {
        return adInfo.adMatrixInfo.adDataV2.splashEndCardTKInfo.endCardFullScreenClick;
    }

    public static boolean dA(AdInfo adInfo) {
        return !TextUtils.isEmpty(adInfo.adMatrixInfo.adDataV2.topFloorTKInfo.templateId);
    }

    public static boolean dB(AdInfo adInfo) {
        return !TextUtils.isEmpty(adInfo.adMatrixInfo.adDataV2.splashPlayCardTKInfo.templateId);
    }

    public static boolean dC(AdInfo adInfo) {
        if (dD(adInfo)) {
            return adInfo.adMatrixInfo.adDataV2.activityMiddlePageInfo.showHeaderBar;
        }
        return true;
    }

    public static boolean dD(AdInfo adInfo) {
        return !TextUtils.isEmpty(adInfo.adMatrixInfo.adDataV2.activityMiddlePageInfo.templateId);
    }

    public static String dE(AdInfo adInfo) {
        return adInfo.adMatrixInfo.adDataV2.splashInfo.interactionInfo.rotateInfo.title;
    }

    public static String dF(AdInfo adInfo) {
        try {
            return adInfo.adMatrixInfo.adDataV2.splashInfo.interactionInfo.shakeInfo.subtitle;
        } catch (Exception unused) {
            return "摇一摇";
        }
    }

    public static long dG(AdInfo adInfo) {
        return adInfo.adMatrixInfo.adDataV2.splashInfo.interactionInfo.tkDefaultTimeout;
    }

    public static String dH(AdInfo adInfo) {
        return adInfo.adMatrixInfo.adDataV2.splashInfo.interactionInfo.rotateInfo.subTitle;
    }

    public static String dI(AdInfo adInfo) {
        return adInfo.adMatrixInfo.adDataV2.splashInfo.interactionInfo.splashActionBarInfo.title;
    }

    public static boolean dc(AdTemplate adTemplate) {
        return !TextUtils.isEmpty(cT(adTemplate));
    }

    public static boolean dd(AdTemplate adTemplate) {
        return !TextUtils.isEmpty(cU(adTemplate).templateId);
    }

    public static boolean de(AdTemplate adTemplate) {
        return !TextUtils.isEmpty(dV(adTemplate));
    }

    public static String df(AdTemplate adTemplate) {
        AdMatrixInfo.FeedTKInfo feedTKInfoCU = cU(adTemplate);
        return TextUtils.isEmpty(feedTKInfoCU.templateId) ? "ksad-feed-card" : feedTKInfoCU.templateId;
    }

    public static boolean dg(AdTemplate adTemplate) {
        return !TextUtils.isEmpty(cV(adTemplate));
    }

    public static boolean dJ(AdInfo adInfo) {
        return adInfo.adMatrixInfo.adDataV2.interstitialCardInfo.interactionInfo.interactiveStyle == 2;
    }

    public static float dh(AdTemplate adTemplate) {
        int i;
        try {
            i = e.el(adTemplate).adMatrixInfo.adDataV2.interstitialCardInfo.interactionInfo.shakeInfo.acceleration;
        } catch (Exception e) {
            com.kwad.sdk.core.d.c.printStackTraceOnly(e);
            i = 7;
        }
        if (i > 0) {
            return i;
        }
        return 7.0f;
    }

    public static boolean di(AdTemplate adTemplate) {
        try {
            return e.el(adTemplate).adMatrixInfo.adDataV2.interstitialCardInfo.renderType == 1;
        } catch (Exception e) {
            com.kwad.sdk.core.d.c.printStackTraceOnly(e);
            return false;
        }
    }

    public static float dj(AdTemplate adTemplate) {
        int i;
        try {
            i = e.el(adTemplate).adMatrixInfo.adDataV2.splashInfo.interactionInfo.shakeInfo.acceleration;
        } catch (Exception e) {
            com.kwad.sdk.core.d.c.printStackTraceOnly(e);
            i = 7;
        }
        return i;
    }

    public static AdMatrixInfo.RotateInfo dk(AdTemplate adTemplate) {
        try {
            return e.el(adTemplate).adMatrixInfo.adDataV2.splashInfo.interactionInfo.rotateInfo;
        } catch (Exception e) {
            com.kwad.sdk.core.d.c.printStackTraceOnly(e);
            return null;
        }
    }

    public static AdMatrixInfo.RotateInfo dl(AdTemplate adTemplate) {
        try {
            AdMatrixInfo.AdInteractionInfo adInteractionInfo = cP(adTemplate).interactionInfo;
            if (adInteractionInfo != null) {
                return adInteractionInfo.rotateInfo;
            }
            return null;
        } catch (Exception e) {
            com.kwad.sdk.core.d.c.printStackTraceOnly(e);
            return null;
        }
    }

    public static AdMatrixInfo.RotateInfo dm(AdTemplate adTemplate) {
        try {
            AdMatrixInfo.AdInteractionInfo adInteractionInfo = cQ(adTemplate).interactionInfo;
            if (adInteractionInfo != null) {
                return adInteractionInfo.rotateInfo;
            }
            return null;
        } catch (Exception e) {
            com.kwad.sdk.core.d.c.printStackTraceOnly(e);
            return null;
        }
    }

    public static int dK(AdInfo adInfo) {
        try {
            int i = adInfo.adMatrixInfo.adDataV2.splashInfo.interactionInfo.shakeInfo.componentIndex;
            if (i != 2) {
                return 1;
            }
            return i;
        } catch (Exception e) {
            com.kwad.sdk.core.d.c.printStackTraceOnly(e);
            return 1;
        }
    }

    public static boolean dL(AdInfo adInfo) {
        return adInfo.adMatrixInfo.adDataV2.splashInfo.interactionInfo.isMediaDisable && adInfo.adMatrixInfo.adDataV2.splashInfo.interactionInfo.interactiveStyle == 4;
    }

    public static boolean dM(AdInfo adInfo) {
        return adInfo.adMatrixInfo.adDataV2.splashInfo.interactionInfo.interactiveStyle == 2;
    }

    public static int dN(AdInfo adInfo) {
        return adInfo.adMatrixInfo.adDataV2.splashInfo.interactionInfo.interactiveStyle;
    }

    public static int dO(AdInfo adInfo) {
        return adInfo.adMatrixInfo.adDataV2.splashInfo.interactionInfo.interactivityDefaultStyle;
    }

    public static boolean dP(AdInfo adInfo) {
        return adInfo.adMatrixInfo.adDataV2.splashInfo.interactionInfo.interactivityDefaultStyle == 2;
    }

    public static boolean dQ(AdInfo adInfo) {
        return adInfo.adMatrixInfo.adDataV2.splashInfo.interactionInfo.interactiveStyle == 1;
    }

    public static boolean dR(AdInfo adInfo) {
        return adInfo.adMatrixInfo.adDataV2.splashInfo.interactionInfo.interactivityDefaultStyle == 1;
    }

    public static boolean dS(AdInfo adInfo) {
        return adInfo.adMatrixInfo.adDataV2.splashInfo.interactionInfo.interactiveStyle == 3;
    }

    public static boolean dT(AdInfo adInfo) {
        return adInfo.adMatrixInfo.adDataV2.splashInfo.interactionInfo.interactiveStyle == 10;
    }

    public static boolean dU(AdInfo adInfo) {
        return adInfo.adMatrixInfo.adDataV2.splashInfo.interactionInfo.interactivityDefaultStyle == 3;
    }

    public static boolean dV(AdInfo adInfo) {
        return adInfo.adMatrixInfo.adDataV2.splashInfo.interactionInfo.interactivityDefaultStyle == 10;
    }

    public static boolean dW(AdInfo adInfo) {
        return adInfo.adMatrixInfo.adDataV2.splashInfo.interactionInfo.interactivityDefaultStyle == 9;
    }

    public static boolean dX(AdInfo adInfo) {
        return adInfo.adMatrixInfo.adDataV2.splashInfo.interactionInfo.interactivityDefaultStyle == 12;
    }

    public static boolean dY(AdInfo adInfo) {
        try {
            if (adInfo.adMatrixInfo.adDataV2.splashInfo.interactionInfo.interactiveStyle != 4) {
                return adInfo.adMatrixInfo.adDataV2.splashInfo.interactionInfo.interactiveStyle == 9;
            }
            return true;
        } catch (Exception unused) {
            return false;
        }
    }

    public static boolean dZ(AdInfo adInfo) {
        return adInfo.adMatrixInfo.adDataV2.splashInfo.interactionInfo.interactiveStyle == 4;
    }

    public static boolean ea(AdInfo adInfo) {
        return !adInfo.adMatrixInfo.adDataV2.splashInfo.interactionInfo.shakeInfo.clickDisabled;
    }

    public static long eb(AdInfo adInfo) {
        try {
            long j = adInfo.adMatrixInfo.adDataV2.splashInfo.interactionInfo.switchDefaultTime;
            if (j <= 0) {
                return 1500L;
            }
            return j;
        } catch (Exception unused) {
            return 1500L;
        }
    }

    public static boolean ec(AdInfo adInfo) {
        return !adInfo.adMatrixInfo.adDataV2.neoVideoInfo.interactionInfo.shakeInfo.clickDisabled;
    }

    public static boolean g(AdInfo adInfo) {
        return (!adInfo.adRewardInfo.recommendAggregateSwitch || a.cX(adInfo) || a.bK(adInfo)) ? false : true;
    }

    private static AdMatrixInfo.BaseMatrixTemplate dn(AdTemplate adTemplate) {
        return cp(adTemplate).adDataV2.complianceCardInfo;
    }

    /* JADX INFO: renamed from: do, reason: not valid java name */
    public static String m615do(AdTemplate adTemplate) {
        AdMatrixInfo.MatrixTemplate matrixTemplateK = k(adTemplate, dn(adTemplate).templateId);
        return matrixTemplateK != null ? matrixTemplateK.templateUrl : "";
    }

    public static boolean dp(AdTemplate adTemplate) {
        return !TextUtils.isEmpty(m615do(adTemplate));
    }

    private static AdMatrixInfo.BaseMatrixTemplate dq(AdTemplate adTemplate) {
        return cp(adTemplate).adDataV2.downloadConfirmCardInfo;
    }

    public static String dr(AdTemplate adTemplate) {
        AdMatrixInfo.MatrixTemplate matrixTemplateK = k(adTemplate, dq(adTemplate).templateId);
        return matrixTemplateK != null ? matrixTemplateK.templateUrl : "";
    }

    public static boolean ds(AdTemplate adTemplate) {
        return !TextUtils.isEmpty(dr(adTemplate));
    }

    public static AdMatrixInfo.MerchantLiveReservationInfo dt(AdTemplate adTemplate) {
        return cp(adTemplate).adDataV2.merchantLiveReservationInfo;
    }

    public static AdMatrixInfo.FullScreenInfo du(AdTemplate adTemplate) {
        return cp(adTemplate).adDataV2.fullScreenInfo;
    }

    public static AdMatrixInfo.SplashPlayCardTKInfo dv(AdTemplate adTemplate) {
        return cp(adTemplate).adDataV2.splashPlayCardTKInfo;
    }

    public static long dw(AdTemplate adTemplate) {
        return cp(adTemplate).adDataV2.splashPlayCardTKInfo.tkTimeout;
    }

    public static int dx(AdTemplate adTemplate) {
        return cp(adTemplate).adDataV2.splashPlayCardTKInfo.renderType;
    }

    public static AdMatrixInfo.AdBannerTKInfo dy(AdTemplate adTemplate) {
        return cp(adTemplate).adDataV2.bannerTKInfo;
    }

    public static boolean dz(AdTemplate adTemplate) {
        AdInfo adInfoEl = e.el(adTemplate);
        if (g(adInfoEl) || e.ex(adTemplate)) {
            return false;
        }
        return !(cv(adTemplate).cardType == 4) && e.el(adTemplate).adStyleInfo2.playDetailInfo.detailCommonInfo.rewardInteractionType <= 0 && adInfoEl.adMatrixInfo.adDataV2.fullScreenInfo.interactionInfo.interactiveStyle == 2;
    }

    public static boolean dA(AdTemplate adTemplate) {
        AdInfo adInfoEl = e.el(adTemplate);
        if (g(adInfoEl) || e.ex(adTemplate)) {
            return false;
        }
        return ((cv(adTemplate).cardType == 4) || e.el(adTemplate).adStyleInfo2.playDetailInfo.detailWebCardInfo.cardType == 4 || adInfoEl.adMatrixInfo.adDataV2.neoVideoInfo.interactionInfo.interactiveStyle != 2) ? false : true;
    }

    public static float ed(AdInfo adInfo) {
        int i;
        try {
            i = adInfo.adMatrixInfo.adDataV2.fullScreenInfo.interactionInfo.shakeInfo.acceleration;
        } catch (Exception e) {
            com.kwad.sdk.core.d.c.printStackTraceOnly(e);
            i = 7;
        }
        return i;
    }

    public static float ee(AdInfo adInfo) {
        int i;
        try {
            i = adInfo.adMatrixInfo.adDataV2.neoVideoInfo.interactionInfo.shakeInfo.acceleration;
        } catch (Exception e) {
            com.kwad.sdk.core.d.c.printStackTraceOnly(e);
            i = 7;
        }
        return i;
    }

    public static String ef(AdInfo adInfo) {
        return adInfo.adMatrixInfo.adDataV2.fullScreenInfo.interactionInfo.shakeInfo.title;
    }

    public static String eg(AdInfo adInfo) {
        return adInfo.adMatrixInfo.adDataV2.neoVideoInfo.interactionInfo.shakeInfo.title;
    }

    public static String eh(AdInfo adInfo) {
        return adInfo.adMatrixInfo.adDataV2.fullScreenInfo.interactionInfo.shakeInfo.subtitle;
    }

    public static String ei(AdInfo adInfo) {
        return adInfo.adMatrixInfo.adDataV2.neoVideoInfo.interactionInfo.shakeInfo.subtitle;
    }

    public static AdMatrixInfo.DownloadTexts ej(AdInfo adInfo) {
        return adInfo.adMatrixInfo.adDataV2.fullScreenInfo.interactionInfo.splashActionBarInfo.downloadTexts;
    }

    public static AdMatrixInfo.DownloadTexts ek(AdInfo adInfo) {
        return adInfo.adMatrixInfo.adDataV2.neoVideoInfo.interactionInfo.splashActionBarInfo.downloadTexts;
    }

    public static boolean el(AdInfo adInfo) {
        for (AdMatrixInfo.MatrixTag matrixTag : adInfo.adMatrixInfo.tag) {
            if ("playEndClose".equals(matrixTag.type)) {
                return matrixTag.isHide;
            }
        }
        return false;
    }

    public static boolean em(AdInfo adInfo) {
        return adInfo.adMatrixInfo.adDataV2.neoTKInfo.renderType == 1;
    }

    public static int a(boolean z, AdInfo adInfo) {
        if (z) {
            return adInfo.adMatrixInfo.adDataV2.neoTKInfo.renderType;
        }
        return adInfo.adMatrixInfo.adDataV2.fullScreenInfo.renderType;
    }

    public static boolean en(AdInfo adInfo) {
        return (a.bK(adInfo) || TextUtils.isEmpty(adInfo.adMatrixInfo.adDataV2.preLandingPageTKInfo.templateId)) ? false : true;
    }

    public static int eo(AdInfo adInfo) {
        return adInfo.adMatrixInfo.adDataV2.preLandingPageTKInfo.preLandingPageShowType;
    }

    public static String ep(AdInfo adInfo) {
        return adInfo.adMatrixInfo.adDataV2.videoLiveTKInfo.templateId;
    }

    public static AdMatrixInfo.PreLandingPageTKInfo dB(AdTemplate adTemplate) {
        return e.el(adTemplate).adMatrixInfo.adDataV2.preLandingPageTKInfo;
    }

    public static boolean dC(AdTemplate adTemplate) {
        return cr(adTemplate).installedActivateInfo.cardSwitch;
    }

    public static long dD(AdTemplate adTemplate) {
        long j = cr(adTemplate).installedActivateInfo.showTime;
        if (j > 0) {
            return j;
        }
        return 0L;
    }

    public static boolean eq(AdInfo adInfo) {
        return a.bd(adInfo) && !TextUtils.isEmpty(adInfo.adMatrixInfo.adDataV2.videoImageTKInfo.templateId);
    }

    public static String dE(AdTemplate adTemplate) {
        return cr(adTemplate).topFloorTKInfo.templateId;
    }

    public static String dF(AdTemplate adTemplate) {
        return cr(adTemplate).neoTKInfo.templateId;
    }

    public static String dG(AdTemplate adTemplate) {
        return cr(adTemplate).videoLiveTKInfo.templateId;
    }

    public static String dH(AdTemplate adTemplate) {
        return cr(adTemplate).videoImageTKInfo.templateId;
    }

    public static String dI(AdTemplate adTemplate) {
        return cr(adTemplate).fullScreenInfo.templateId;
    }

    public static String dJ(AdTemplate adTemplate) {
        return cr(adTemplate).rewardVideoTaskInfo.templateId;
    }

    public static String dK(AdTemplate adTemplate) {
        return cr(adTemplate).splashPlayCardTKInfo.templateId;
    }

    public static String dL(AdTemplate adTemplate) {
        return cr(adTemplate).splashEndCardTKInfo.templateId;
    }

    public static String dM(AdTemplate adTemplate) {
        return cr(adTemplate).bannerTKInfo.templateId;
    }

    public static String dN(AdTemplate adTemplate) {
        return cr(adTemplate).interstitialCardInfo.templateId;
    }

    public static String dO(AdTemplate adTemplate) {
        return cr(adTemplate).confirmTKInfo.templateId;
    }

    public static String dP(AdTemplate adTemplate) {
        return cr(adTemplate).activityTKInfo.templateId;
    }

    public static String dQ(AdTemplate adTemplate) {
        return cr(adTemplate).rewardWebTaskCloseInfo.templateId;
    }

    public static String dR(AdTemplate adTemplate) {
        return cr(adTemplate).rewardVideoInteractInfo.templateId;
    }

    public static String dS(AdTemplate adTemplate) {
        return cr(adTemplate).pushTKInfo.templateId;
    }

    public static String dT(AdTemplate adTemplate) {
        return cr(adTemplate).preLandingPageTKInfo.templateId;
    }

    public static String dU(AdTemplate adTemplate) {
        return cr(adTemplate).feedTKCardInfo.templateId;
    }

    public static String dV(AdTemplate adTemplate) {
        return cr(adTemplate).drawTKCardInfo.templateId;
    }
}
