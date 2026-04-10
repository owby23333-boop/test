package com.kwad.sdk.core.response.a;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdMatrixInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.response.model.FeedSlideConf;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.utils.ah;
import com.kwad.sdk.utils.ba;
import java.util.List;
import java.util.Random;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public final class b {
    private static Random alm = new Random();

    @NonNull
    public static AdMatrixInfo aK(@NonNull AdTemplate adTemplate) {
        return d.bT(adTemplate) ? d.cb(adTemplate).adMatrixInfo : new AdMatrixInfo();
    }

    public static FeedSlideConf aL(@NonNull AdTemplate adTemplate) {
        JSONArray jSONArrayOptJSONArray;
        AdMatrixInfo.TemplateData templateDataD = d(adTemplate, bi(adTemplate).templateId);
        try {
            JSONObject jSONObjectOptJSONObject = new JSONObject(templateDataD != null ? templateDataD.data : "").optJSONObject("slideInfo");
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

    public static boolean aM(@NonNull AdTemplate adTemplate) {
        return f(adTemplate, aN(adTemplate).templateId);
    }

    @NonNull
    private static AdMatrixInfo.InterstitialCardInfo aN(@NonNull AdTemplate adTemplate) {
        return aK(adTemplate).adDataV2.interstitialCardInfo;
    }

    @Nullable
    public static String aO(@NonNull AdTemplate adTemplate) {
        AdMatrixInfo.MatrixTemplate matrixTemplateB = b(adTemplate, aK(adTemplate).adDataV2.splashActionBarInfo.templateId);
        return matrixTemplateB != null ? matrixTemplateB.templateUrl : "";
    }

    @NonNull
    private static AdMatrixInfo.ActionBarInfoNew aP(@NonNull AdTemplate adTemplate) {
        return aK(adTemplate).adDataV2.actionBarInfo;
    }

    @Nullable
    public static String aQ(@NonNull AdTemplate adTemplate) {
        AdInfo adInfoCb = d.cb(adTemplate);
        int iBV = d.bV(adTemplate);
        boolean z2 = iBV == 3 || iBV == 2;
        if (a.co(adInfoCb)) {
            return "";
        }
        if (z2 && a.ci(adInfoCb)) {
            return cB(adInfoCb);
        }
        if (z2 && a.aJ(adTemplate)) {
            AdMatrixInfo.MatrixTemplate matrixTemplateB = b(adTemplate, bJ(adTemplate).templateId);
            return matrixTemplateB != null ? matrixTemplateB.templateUrl : "";
        }
        AdMatrixInfo.MatrixTemplate matrixTemplateB2 = b(adTemplate, aP(adTemplate).templateId);
        return matrixTemplateB2 != null ? matrixTemplateB2.templateUrl : "";
    }

    public static long aR(@NonNull AdTemplate adTemplate) {
        return aP(adTemplate).maxTimeOut;
    }

    public static boolean aS(@NonNull AdTemplate adTemplate) {
        return !TextUtils.isEmpty(aQ(adTemplate));
    }

    @NonNull
    private static AdMatrixInfo.AggregationCardInfo aT(@NonNull AdTemplate adTemplate) {
        return aK(adTemplate).adDataV2.aggregationCardInfo;
    }

    @Nullable
    public static String aU(@NonNull AdTemplate adTemplate) {
        AdMatrixInfo.MatrixTemplate matrixTemplateB = b(adTemplate, aT(adTemplate).templateId);
        return matrixTemplateB != null ? matrixTemplateB.templateUrl : "";
    }

    public static long aV(@NonNull AdTemplate adTemplate) {
        return e(adTemplate, aT(adTemplate).templateId);
    }

    public static long aW(@NonNull AdTemplate adTemplate) {
        return ((long) aT(adTemplate).changeTime) * 1000;
    }

    public static int aX(@NonNull AdTemplate adTemplate) {
        return aT(adTemplate).maxTimesPerDay;
    }

    public static long aY(@NonNull AdTemplate adTemplate) {
        return aT(adTemplate).intervalTime;
    }

    public static boolean aZ(@NonNull AdTemplate adTemplate) {
        AdInfo adInfoCb = d.cb(adTemplate);
        return !a.ay(adInfoCb) && a.al(adInfoCb);
    }

    private static boolean an(@NonNull AdInfo adInfo) {
        return adInfo.adBaseInfo.taskType == 4;
    }

    @Nullable
    private static AdMatrixInfo.MatrixTemplate b(@NonNull AdTemplate adTemplate, String str) {
        for (AdMatrixInfo.MatrixTemplate matrixTemplate : aK(adTemplate).styles.templateList) {
            if (ba.isEquals(str, matrixTemplate.templateId)) {
                return matrixTemplate;
            }
        }
        return null;
    }

    @NonNull
    private static AdMatrixInfo.BaseMatrixTemplate bA(@NonNull AdTemplate adTemplate) {
        return aK(adTemplate).adDataV2.complianceCardInfo;
    }

    @Nullable
    public static String bB(@NonNull AdTemplate adTemplate) {
        AdMatrixInfo.MatrixTemplate matrixTemplateB = b(adTemplate, bA(adTemplate).templateId);
        return matrixTemplateB != null ? matrixTemplateB.templateUrl : "";
    }

    public static boolean bC(@NonNull AdTemplate adTemplate) {
        return !TextUtils.isEmpty(bB(adTemplate));
    }

    @NonNull
    private static AdMatrixInfo.BaseMatrixTemplate bD(@NonNull AdTemplate adTemplate) {
        return aK(adTemplate).adDataV2.downloadConfirmCardInfo;
    }

    @Nullable
    public static String bE(@NonNull AdTemplate adTemplate) {
        AdMatrixInfo.MatrixTemplate matrixTemplateB = b(adTemplate, bD(adTemplate).templateId);
        return matrixTemplateB != null ? matrixTemplateB.templateUrl : "";
    }

    public static boolean bF(@NonNull AdTemplate adTemplate) {
        return !TextUtils.isEmpty(bE(adTemplate));
    }

    public static boolean bG(@NonNull AdTemplate adTemplate) {
        List<AdInfo> list = adTemplate.adInfoList;
        if (list != null && list.size() != 0) {
            AdInfo adInfo = adTemplate.adInfoList.get(0);
            if (!a.cu(adInfo) && !a.bu(adInfo) && adInfo.adBaseInfo.taskType == 4) {
                return true;
            }
        }
        return false;
    }

    @NonNull
    private static AdMatrixInfo.BaseMatrixTemplate bH(@NonNull AdTemplate adTemplate) {
        return aK(adTemplate).adDataV2.rewardWatchOnceInfo;
    }

    @Nullable
    public static String bI(@NonNull AdTemplate adTemplate) {
        AdMatrixInfo.MatrixTemplate matrixTemplateB = b(adTemplate, bH(adTemplate).templateId);
        if (matrixTemplateB != null) {
            return matrixTemplateB.templateUrl;
        }
        return null;
    }

    public static AdMatrixInfo.MerchantLiveReservationInfo bJ(@NonNull AdTemplate adTemplate) {
        return aK(adTemplate).adDataV2.merchantLiveReservationInfo;
    }

    public static AdMatrixInfo.FullScreenInfo bK(@NonNull AdTemplate adTemplate) {
        return aK(adTemplate).adDataV2.fullScreenInfo;
    }

    public static boolean bL(AdTemplate adTemplate) {
        AdInfo adInfoCb = d.cb(adTemplate);
        if (h(adInfoCb) || d.cn(adTemplate)) {
            return false;
        }
        return !(aP(adTemplate).cardType == 4) && d.cb(adTemplate).adStyleInfo2.playDetailInfo.detailCommonInfo.rewardInteractionType <= 0 && adInfoCb.adMatrixInfo.adDataV2.fullScreenInfo.interactionInfo.interactiveStyle == 2;
    }

    public static boolean bM(AdTemplate adTemplate) {
        AdInfo adInfoCb = d.cb(adTemplate);
        if (h(adInfoCb) || d.cn(adTemplate)) {
            return false;
        }
        return ((aP(adTemplate).cardType == 4) || d.cb(adTemplate).adStyleInfo2.playDetailInfo.detailWebCardInfo.cardType == 4 || adInfoCb.adMatrixInfo.adDataV2.neoVideoInfo.interactionInfo.interactiveStyle != 2) ? false : true;
    }

    public static boolean ba(@NonNull AdTemplate adTemplate) {
        if (!TextUtils.isEmpty(aU(adTemplate)) && aV(adTemplate) > 0) {
            return ah.DI();
        }
        return false;
    }

    @NonNull
    private static AdMatrixInfo.BaseMatrixTemplate bb(@NonNull AdTemplate adTemplate) {
        return aK(adTemplate).adDataV2.halfCardInfo;
    }

    @Nullable
    public static String bc(@NonNull AdTemplate adTemplate) {
        AdMatrixInfo.MatrixTemplate matrixTemplateB = b(adTemplate, bb(adTemplate).templateId);
        return matrixTemplateB != null ? matrixTemplateB.templateUrl : "";
    }

    @NonNull
    private static AdMatrixInfo.EndCardInfo bd(@NonNull AdTemplate adTemplate) {
        return aK(adTemplate).adDataV2.endCardInfo;
    }

    @Nullable
    public static String be(@NonNull AdTemplate adTemplate) {
        AdMatrixInfo.MatrixTemplate matrixTemplateB = b(adTemplate, bd(adTemplate).templateId);
        return matrixTemplateB != null ? matrixTemplateB.templateUrl : "";
    }

    public static boolean bf(@NonNull AdTemplate adTemplate) {
        return !TextUtils.isEmpty(be(adTemplate));
    }

    @Nullable
    private static String bg(@NonNull AdTemplate adTemplate) {
        AdMatrixInfo.MatrixTemplate matrixTemplateB = b(adTemplate, d.cb(adTemplate).adMatrixInfo.adDataV2.activityMiddlePageInfo.templateId);
        return matrixTemplateB != null ? matrixTemplateB.templateUrl : "";
    }

    public static String bh(@NonNull AdTemplate adTemplate) {
        return (adTemplate.mIsForceJumpLandingPage || !cH(d.cb(adTemplate))) ? a.aL(d.cb(adTemplate)) : bg(adTemplate);
    }

    @NonNull
    private static AdMatrixInfo.FeedInfo bi(@NonNull AdTemplate adTemplate) {
        boolean zBj = bj(adTemplate);
        AdMatrixInfo.AdDataV2 adDataV2 = aK(adTemplate).adDataV2;
        return zBj ? adDataV2.adUnionFeedLiveTemplateInfo : adDataV2.feedInfo;
    }

    private static boolean bj(@NonNull AdTemplate adTemplate) {
        return a.co(d.cb(adTemplate));
    }

    @NonNull
    private static AdMatrixInfo.FeedInfo bk(@NonNull AdTemplate adTemplate) {
        return aK(adTemplate).adDataV2.adUnionFeedLiveMediaInfo;
    }

    @Nullable
    public static String bl(@NonNull AdTemplate adTemplate) {
        AdMatrixInfo.MatrixTemplate matrixTemplateB = b(adTemplate, bi(adTemplate).templateId);
        return matrixTemplateB != null ? matrixTemplateB.templateUrl : "";
    }

    @Nullable
    public static String bm(@NonNull AdTemplate adTemplate) {
        AdMatrixInfo.MatrixTemplate matrixTemplateB = b(adTemplate, bk(adTemplate).templateId);
        return matrixTemplateB != null ? matrixTemplateB.templateUrl : "";
    }

    @Nullable
    public static boolean bn(@NonNull AdTemplate adTemplate) {
        return bi(adTemplate).interactionInfo.interactiveStyle == 2;
    }

    @Nullable
    public static boolean bo(@NonNull AdTemplate adTemplate) {
        return bi(adTemplate).interactionInfo.shakeInfo.clickDisabled;
    }

    @Nullable
    public static int bp(@NonNull AdTemplate adTemplate) {
        AdMatrixInfo.ShakeInfo shakeInfo;
        AdMatrixInfo.AdInteractionInfo adInteractionInfo = bi(adTemplate).interactionInfo;
        if (adInteractionInfo == null || (shakeInfo = adInteractionInfo.shakeInfo) == null) {
            return 0;
        }
        return shakeInfo.acceleration;
    }

    public static double bq(@NonNull AdTemplate adTemplate) {
        return d.cb(adTemplate).adStyleInfo.feedAdInfo.heightRatio;
    }

    public static boolean br(@NonNull AdTemplate adTemplate) {
        return !TextUtils.isEmpty(bl(adTemplate));
    }

    public static boolean bs(@NonNull AdTemplate adTemplate) {
        return !TextUtils.isEmpty(bm(adTemplate));
    }

    @NonNull
    private static AdMatrixInfo.InterstitialCardInfo bt(@NonNull AdTemplate adTemplate) {
        return aK(adTemplate).adDataV2.interstitialCardInfo;
    }

    public static float bu(@NonNull AdTemplate adTemplate) {
        int i2;
        try {
            i2 = d.cb(adTemplate).adMatrixInfo.adDataV2.interstitialCardInfo.interactionInfo.shakeInfo.acceleration;
        } catch (Exception e2) {
            com.kwad.sdk.core.d.b.printStackTraceOnly(e2);
            i2 = 7;
        }
        if (i2 > 0) {
            return i2;
        }
        return 7.0f;
    }

    public static boolean bv(@NonNull AdTemplate adTemplate) {
        try {
            return d.cb(adTemplate).adMatrixInfo.adDataV2.interstitialCardInfo.renderType == 1;
        } catch (Exception e2) {
            com.kwad.sdk.core.d.b.printStackTraceOnly(e2);
            return false;
        }
    }

    public static int bw(@NonNull AdTemplate adTemplate) {
        return d.cb(adTemplate).adMatrixInfo.adDataV2.interstitialCardInfo.renderType;
    }

    @Nullable
    public static String bx(@NonNull AdTemplate adTemplate) {
        AdMatrixInfo.MatrixTemplate matrixTemplateB = b(adTemplate, bt(adTemplate).templateId);
        return matrixTemplateB != null ? matrixTemplateB.templateUrl : "";
    }

    public static float by(@NonNull AdTemplate adTemplate) {
        int i2;
        try {
            i2 = d.cb(adTemplate).adMatrixInfo.adDataV2.splashInfo.interactionInfo.shakeInfo.acceleration;
        } catch (Exception e2) {
            com.kwad.sdk.core.d.b.printStackTraceOnly(e2);
            i2 = 7;
        }
        return i2;
    }

    public static AdMatrixInfo.RotateInfo bz(@NonNull AdTemplate adTemplate) {
        try {
            return d.cb(adTemplate).adMatrixInfo.adDataV2.splashInfo.interactionInfo.rotateInfo;
        } catch (Exception e2) {
            com.kwad.sdk.core.d.b.printStackTraceOnly(e2);
            return null;
        }
    }

    @Nullable
    public static AdMatrixInfo.MatrixTemplate c(@NonNull AdTemplate adTemplate, String str) {
        return b(adTemplate, str);
    }

    @Nullable
    @Deprecated
    private static String cB(AdInfo adInfo) {
        if (adInfo == null) {
            return null;
        }
        String str = adInfo.adStyleInfo.playDetailInfo.detailWebCardInfo.cardUrl;
        try {
        } catch (Exception e2) {
            com.kwad.sdk.core.d.b.printStackTraceOnly(e2);
        }
        if (((com.kwad.sdk.service.kwai.f) ServiceProvider.get(com.kwad.sdk.service.kwai.f.class)).aO(str)) {
            return str;
        }
        return null;
    }

    public static boolean cC(@NonNull AdInfo adInfo) {
        return !TextUtils.isEmpty(adInfo.adMatrixInfo.adDataV2.splashEndCardTKInfo.templateId);
    }

    public static boolean cD(@NonNull AdInfo adInfo) {
        return adInfo.adMatrixInfo.adDataV2.splashEndCardTKInfo.endCardFullScreenClick;
    }

    public static boolean cE(@NonNull AdInfo adInfo) {
        return !TextUtils.isEmpty(adInfo.adMatrixInfo.adDataV2.topFloorTKInfo.templateId);
    }

    public static boolean cF(@NonNull AdInfo adInfo) {
        return !TextUtils.isEmpty(adInfo.adMatrixInfo.adDataV2.splashPlayCardTKInfo.templateId);
    }

    public static boolean cG(@NonNull AdInfo adInfo) {
        if (cH(adInfo)) {
            return adInfo.adMatrixInfo.adDataV2.activityMiddlePageInfo.showHeaderBar;
        }
        return true;
    }

    public static boolean cH(@NonNull AdInfo adInfo) {
        return !TextUtils.isEmpty(adInfo.adMatrixInfo.adDataV2.activityMiddlePageInfo.templateId);
    }

    public static AdMatrixInfo.DownloadTexts cI(@NonNull AdInfo adInfo) {
        return adInfo.adMatrixInfo.adDataV2.splashInfo.interactionInfo.rotateInfo.downloadTexts;
    }

    public static AdMatrixInfo.DownloadTexts cJ(@NonNull AdInfo adInfo) {
        return adInfo.adMatrixInfo.adDataV2.splashInfo.interactionInfo.slideInfo.downloadTexts;
    }

    public static String cK(@NonNull AdInfo adInfo) {
        return adInfo.adMatrixInfo.adDataV2.splashInfo.interactionInfo.rotateInfo.title;
    }

    public static String cL(@NonNull AdInfo adInfo) {
        return adInfo.adMatrixInfo.adDataV2.splashInfo.interactionInfo.rotateInfo.subTitle;
    }

    public static AdMatrixInfo.DownloadTexts cM(@NonNull AdInfo adInfo) {
        return adInfo.adMatrixInfo.adDataV2.splashInfo.interactionInfo.splashActionBarInfo.downloadTexts;
    }

    public static String cN(@NonNull AdInfo adInfo) {
        return adInfo.adMatrixInfo.adDataV2.splashInfo.interactionInfo.splashActionBarInfo.title;
    }

    public static boolean cO(@NonNull AdInfo adInfo) {
        return adInfo.adMatrixInfo.adDataV2.interstitialCardInfo.interactionInfo.interactiveStyle == 2;
    }

    public static String cP(@NonNull AdInfo adInfo) {
        return adInfo.adMatrixInfo.adDataV2.interstitialCardInfo.cycleAggregateInfo.cutIconUrl;
    }

    public static String cQ(@NonNull AdInfo adInfo) {
        return adInfo.adMatrixInfo.adDataV2.interstitialCardInfo.cycleAggregateInfo.refreshIconUrl;
    }

    public static String cR(@NonNull AdInfo adInfo) {
        return adInfo.adMatrixInfo.adDataV2.interstitialCardInfo.cycleAggregateInfo.convertIconUrl;
    }

    public static int cS(@NonNull AdInfo adInfo) {
        try {
            int i2 = adInfo.adMatrixInfo.adDataV2.splashInfo.interactionInfo.shakeInfo.componentIndex;
            if (i2 != 2) {
                return 1;
            }
            return i2;
        } catch (Exception e2) {
            com.kwad.sdk.core.d.b.printStackTraceOnly(e2);
            return 1;
        }
    }

    public static boolean cT(@NonNull AdInfo adInfo) {
        AdMatrixInfo.AdInteractionInfo adInteractionInfo = adInfo.adMatrixInfo.adDataV2.splashInfo.interactionInfo;
        return adInteractionInfo.isMediaDisable && adInteractionInfo.interactiveStyle == 4;
    }

    public static boolean cU(@NonNull AdInfo adInfo) {
        return adInfo.adMatrixInfo.adDataV2.splashInfo.interactionInfo.interactiveStyle == 2;
    }

    public static boolean cV(@NonNull AdInfo adInfo) {
        return adInfo.adMatrixInfo.adDataV2.splashInfo.interactionInfo.interactivityDefaultStyle == 2;
    }

    public static boolean cW(@NonNull AdInfo adInfo) {
        return adInfo.adMatrixInfo.adDataV2.splashInfo.interactionInfo.interactiveStyle == 1;
    }

    public static boolean cX(@NonNull AdInfo adInfo) {
        return adInfo.adMatrixInfo.adDataV2.splashInfo.interactionInfo.interactivityDefaultStyle == 1;
    }

    public static boolean cY(@NonNull AdInfo adInfo) {
        return adInfo.adMatrixInfo.adDataV2.splashInfo.interactionInfo.interactiveStyle == 3;
    }

    public static boolean cZ(@NonNull AdInfo adInfo) {
        return adInfo.adMatrixInfo.adDataV2.splashInfo.interactionInfo.interactivityDefaultStyle == 3;
    }

    public static boolean cp(String str) {
        try {
            return ((com.kwad.sdk.service.kwai.f) ServiceProvider.get(com.kwad.sdk.service.kwai.f.class)).aO(str);
        } catch (Exception unused) {
            return false;
        }
    }

    @Nullable
    private static AdMatrixInfo.TemplateData d(@NonNull AdTemplate adTemplate, String str) {
        for (AdMatrixInfo.TemplateData templateData : aK(adTemplate).adDataV2.templateDataList) {
            if (ba.isEquals(str, templateData.templateId)) {
                return templateData;
            }
        }
        return null;
    }

    public static boolean da(@NonNull AdInfo adInfo) {
        return adInfo.adMatrixInfo.adDataV2.splashInfo.interactionInfo.interactiveStyle != 0;
    }

    public static boolean db(@NonNull AdInfo adInfo) {
        return adInfo.adMatrixInfo.adDataV2.splashInfo.interactionInfo.interactiveStyle == 4;
    }

    public static boolean dc(@NonNull AdInfo adInfo) {
        return !adInfo.adMatrixInfo.adDataV2.splashInfo.interactionInfo.shakeInfo.clickDisabled;
    }

    public static long dd(@NonNull AdInfo adInfo) {
        try {
            long j2 = adInfo.adMatrixInfo.adDataV2.splashInfo.interactionInfo.switchDefaultTime;
            if (j2 <= 0) {
                return 1500L;
            }
            return j2;
        } catch (Exception unused) {
            return 1500L;
        }
    }

    public static boolean de(@NonNull AdInfo adInfo) {
        return !adInfo.adMatrixInfo.adDataV2.neoVideoInfo.interactionInfo.shakeInfo.clickDisabled;
    }

    public static float df(@NonNull AdInfo adInfo) {
        int i2;
        try {
            i2 = adInfo.adMatrixInfo.adDataV2.fullScreenInfo.interactionInfo.shakeInfo.acceleration;
        } catch (Exception e2) {
            com.kwad.sdk.core.d.b.printStackTraceOnly(e2);
            i2 = 7;
        }
        return i2;
    }

    public static float dg(@NonNull AdInfo adInfo) {
        int i2;
        try {
            i2 = adInfo.adMatrixInfo.adDataV2.neoVideoInfo.interactionInfo.shakeInfo.acceleration;
        } catch (Exception e2) {
            com.kwad.sdk.core.d.b.printStackTraceOnly(e2);
            i2 = 7;
        }
        return i2;
    }

    public static String dh(@NonNull AdInfo adInfo) {
        return adInfo.adMatrixInfo.adDataV2.fullScreenInfo.interactionInfo.shakeInfo.title;
    }

    public static String di(@NonNull AdInfo adInfo) {
        return adInfo.adMatrixInfo.adDataV2.neoVideoInfo.interactionInfo.shakeInfo.title;
    }

    public static String dj(@NonNull AdInfo adInfo) {
        return adInfo.adMatrixInfo.adDataV2.fullScreenInfo.interactionInfo.shakeInfo.subtitle;
    }

    public static String dk(@NonNull AdInfo adInfo) {
        return adInfo.adMatrixInfo.adDataV2.neoVideoInfo.interactionInfo.shakeInfo.subtitle;
    }

    public static AdMatrixInfo.DownloadTexts dl(@NonNull AdInfo adInfo) {
        return adInfo.adMatrixInfo.adDataV2.fullScreenInfo.interactionInfo.splashActionBarInfo.downloadTexts;
    }

    public static AdMatrixInfo.DownloadTexts dm(@NonNull AdInfo adInfo) {
        return adInfo.adMatrixInfo.adDataV2.neoVideoInfo.interactionInfo.splashActionBarInfo.downloadTexts;
    }

    public static boolean dn(@NonNull AdInfo adInfo) {
        for (AdMatrixInfo.MatrixTag matrixTag : adInfo.adMatrixInfo.tag) {
            if ("playEndClose".equals(matrixTag.type)) {
                return matrixTag.isHide;
            }
        }
        return false;
    }

    /* JADX INFO: renamed from: do, reason: not valid java name */
    public static boolean m70do(@NonNull AdInfo adInfo) {
        return adInfo.adMatrixInfo.adDataV2.neoTKInfo.renderType == 1;
    }

    private static long e(@NonNull AdTemplate adTemplate, String str) {
        AdMatrixInfo.TemplateData templateDataD = d(adTemplate, str);
        if (templateDataD != null) {
            return templateDataD.templateDelayTime;
        }
        return 0L;
    }

    private static boolean f(@NonNull AdTemplate adTemplate, String str) {
        AdMatrixInfo.TemplateData templateDataD = d(adTemplate, str);
        try {
            JSONObject jSONObjectOptJSONObject = new JSONObject(templateDataD != null ? templateDataD.data : "").optJSONObject("autoCallAppInfo");
            if (jSONObjectOptJSONObject != null) {
                return !TextUtils.isEmpty(jSONObjectOptJSONObject.optString("adTitle"));
            }
            return false;
        } catch (Throwable unused) {
            return false;
        }
    }

    public static boolean h(@NonNull AdInfo adInfo) {
        return (!adInfo.adRewardInfo.recommendAggregateSwitch || an(adInfo) || a.cu(adInfo) || a.bu(adInfo)) ? false : true;
    }
}
