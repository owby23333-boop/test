package com.kwad.sdk.core.response.b;

import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import com.kwad.sdk.api.model.KSAdInfoData;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdMatrixInfo;
import com.kwad.sdk.core.response.model.AdProductInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.utils.aj;
import com.kwad.sdk.utils.ap;
import com.kwad.sdk.utils.aq;
import com.kwad.sdk.utils.bp;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
public final class a {
    public static String IQ() {
        return "继续下载";
    }

    public static long J(AdInfo adInfo) {
        return adInfo.adBaseInfo.creativeId;
    }

    public static String K(AdInfo adInfo) {
        return aV(adInfo).materialUrl;
    }

    public static int L(AdInfo adInfo) {
        if (be(adInfo) == 2) {
            return aU(adInfo).videoDuration;
        }
        return aV(adInfo).videoDuration;
    }

    public static long M(AdInfo adInfo) {
        int i;
        if (be(adInfo) == 2) {
            i = aU(adInfo).videoDuration;
        } else {
            i = aV(adInfo).videoDuration;
        }
        return ((long) i) * 1000;
    }

    public static AdInfo.AdMaterialInfo.MaterialFeature N(AdInfo adInfo) {
        List<AdInfo.AdMaterialInfo.MaterialFeature> list = adInfo.adMaterialInfo.materialFeatureList;
        if (ap.T(list)) {
            return list.get(0);
        }
        return new AdInfo.AdMaterialInfo.MaterialFeature();
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x0043  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.String O(com.kwad.sdk.core.response.model.AdInfo r6) {
        /*
            int r0 = be(r6)
            r1 = 3
            r2 = 1
            if (r0 == r2) goto L35
            r3 = 2
            if (r0 == r3) goto L12
            if (r0 == r1) goto L12
            r2 = 8
            if (r0 == r2) goto L58
            goto L7b
        L12:
            com.kwad.sdk.core.response.model.AdInfo$AdMaterialInfo r0 = r6.adMaterialInfo
            java.util.List<com.kwad.sdk.core.response.model.AdInfo$AdMaterialInfo$MaterialFeature> r0 = r0.materialFeatureList
            java.util.Iterator r0 = r0.iterator()
        L1a:
            boolean r4 = r0.hasNext()
            if (r4 == 0) goto L35
            java.lang.Object r4 = r0.next()
            com.kwad.sdk.core.response.model.AdInfo$AdMaterialInfo$MaterialFeature r4 = (com.kwad.sdk.core.response.model.AdInfo.AdMaterialInfo.MaterialFeature) r4
            int r5 = r4.featureType
            if (r5 != r3) goto L1a
            java.lang.String r5 = r4.firstFrame
            boolean r5 = android.text.TextUtils.isEmpty(r5)
            if (r5 != 0) goto L1a
            java.lang.String r6 = r4.firstFrame
            return r6
        L35:
            com.kwad.sdk.core.response.model.AdInfo$AdMaterialInfo r0 = r6.adMaterialInfo
            java.util.List<com.kwad.sdk.core.response.model.AdInfo$AdMaterialInfo$MaterialFeature> r0 = r0.materialFeatureList
            java.util.Iterator r0 = r0.iterator()
        L3d:
            boolean r3 = r0.hasNext()
            if (r3 == 0) goto L58
            java.lang.Object r3 = r0.next()
            com.kwad.sdk.core.response.model.AdInfo$AdMaterialInfo$MaterialFeature r3 = (com.kwad.sdk.core.response.model.AdInfo.AdMaterialInfo.MaterialFeature) r3
            int r4 = r3.featureType
            if (r4 != r2) goto L3d
            java.lang.String r4 = r3.firstFrame
            boolean r4 = android.text.TextUtils.isEmpty(r4)
            if (r4 != 0) goto L3d
            java.lang.String r6 = r3.firstFrame
            return r6
        L58:
            com.kwad.sdk.core.response.model.AdInfo$AdMaterialInfo r6 = r6.adMaterialInfo
            java.util.List<com.kwad.sdk.core.response.model.AdInfo$AdMaterialInfo$MaterialFeature> r6 = r6.materialFeatureList
            java.util.Iterator r6 = r6.iterator()
        L60:
            boolean r0 = r6.hasNext()
            if (r0 == 0) goto L7b
            java.lang.Object r0 = r6.next()
            com.kwad.sdk.core.response.model.AdInfo$AdMaterialInfo$MaterialFeature r0 = (com.kwad.sdk.core.response.model.AdInfo.AdMaterialInfo.MaterialFeature) r0
            int r2 = r0.featureType
            if (r2 != r1) goto L60
            java.lang.String r2 = r0.firstFrame
            boolean r2 = android.text.TextUtils.isEmpty(r2)
            if (r2 != 0) goto L60
            java.lang.String r6 = r0.firstFrame
            return r6
        L7b:
            java.lang.String r6 = ""
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.kwad.sdk.core.response.b.a.O(com.kwad.sdk.core.response.model.AdInfo):java.lang.String");
    }

    public static boolean P(AdInfo adInfo) {
        return adInfo.adConversionInfo.supportThirdDownload == 1;
    }

    public static int Q(AdInfo adInfo) {
        return aV(adInfo).videoWidth;
    }

    public static int R(AdInfo adInfo) {
        return aV(adInfo).videoHeight;
    }

    public static boolean a(AdInfo.SmallAppJumpInfo smallAppJumpInfo) {
        return (smallAppJumpInfo == null || TextUtils.isEmpty(smallAppJumpInfo.mediaSmallAppId) || TextUtils.isEmpty(smallAppJumpInfo.originId) || TextUtils.isEmpty(smallAppJumpInfo.smallAppJumpUrl)) ? false : true;
    }

    public static boolean S(AdInfo adInfo) {
        return adInfo.adConversionInfo.webUriSourceType == 2;
    }

    public static boolean T(AdInfo adInfo) {
        return adInfo.adConversionInfo.appSecondConfirmationSwitch;
    }

    public static List<Integer> U(AdInfo adInfo) {
        return adInfo.adMatrixInfo.adDataV2.dynamicAdStyleInfo.slideInfo.angle;
    }

    public static boolean V(AdInfo adInfo) {
        return adInfo.adConversionInfo.h5SecondConfirmationSwitch;
    }

    public static boolean W(AdInfo adInfo) {
        AdInfo.AdMaterialInfo.MaterialFeature materialFeatureAV = aV(adInfo);
        return materialFeatureAV.videoWidth <= materialFeatureAV.videoHeight;
    }

    /* JADX WARN: Removed duplicated region for block: B:26:0x004f  */
    @java.lang.Deprecated
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.String X(com.kwad.sdk.core.response.model.AdInfo r6) {
        /*
            int r0 = be(r6)
            r1 = 3
            r2 = 1
            if (r0 == r2) goto L41
            r3 = 2
            if (r0 == r3) goto L13
            if (r0 == r1) goto L13
            r2 = 8
            if (r0 == r2) goto L64
            goto L87
        L13:
            com.kwad.sdk.core.response.model.AdInfo$AdMaterialInfo r0 = r6.adMaterialInfo
            java.util.List<com.kwad.sdk.core.response.model.AdInfo$AdMaterialInfo$MaterialFeature> r0 = r0.materialFeatureList
            java.util.Iterator r0 = r0.iterator()
        L1b:
            boolean r4 = r0.hasNext()
            if (r4 == 0) goto L41
            java.lang.Object r4 = r0.next()
            com.kwad.sdk.core.response.model.AdInfo$AdMaterialInfo$MaterialFeature r4 = (com.kwad.sdk.core.response.model.AdInfo.AdMaterialInfo.MaterialFeature) r4
            int r5 = r4.featureType
            if (r5 != r3) goto L1b
            java.lang.String r5 = r4.materialUrl
            boolean r5 = android.text.TextUtils.isEmpty(r5)
            if (r5 != 0) goto L36
            java.lang.String r6 = r4.materialUrl
            return r6
        L36:
            java.lang.String r5 = r4.coverUrl
            boolean r5 = android.text.TextUtils.isEmpty(r5)
            if (r5 != 0) goto L1b
            java.lang.String r6 = r4.coverUrl
            return r6
        L41:
            com.kwad.sdk.core.response.model.AdInfo$AdMaterialInfo r0 = r6.adMaterialInfo
            java.util.List<com.kwad.sdk.core.response.model.AdInfo$AdMaterialInfo$MaterialFeature> r0 = r0.materialFeatureList
            java.util.Iterator r0 = r0.iterator()
        L49:
            boolean r3 = r0.hasNext()
            if (r3 == 0) goto L64
            java.lang.Object r3 = r0.next()
            com.kwad.sdk.core.response.model.AdInfo$AdMaterialInfo$MaterialFeature r3 = (com.kwad.sdk.core.response.model.AdInfo.AdMaterialInfo.MaterialFeature) r3
            int r4 = r3.featureType
            if (r4 != r2) goto L49
            java.lang.String r4 = r3.coverUrl
            boolean r4 = android.text.TextUtils.isEmpty(r4)
            if (r4 != 0) goto L49
            java.lang.String r6 = r3.coverUrl
            return r6
        L64:
            com.kwad.sdk.core.response.model.AdInfo$AdMaterialInfo r6 = r6.adMaterialInfo
            java.util.List<com.kwad.sdk.core.response.model.AdInfo$AdMaterialInfo$MaterialFeature> r6 = r6.materialFeatureList
            java.util.Iterator r6 = r6.iterator()
        L6c:
            boolean r0 = r6.hasNext()
            if (r0 == 0) goto L87
            java.lang.Object r0 = r6.next()
            com.kwad.sdk.core.response.model.AdInfo$AdMaterialInfo$MaterialFeature r0 = (com.kwad.sdk.core.response.model.AdInfo.AdMaterialInfo.MaterialFeature) r0
            int r2 = r0.featureType
            if (r2 != r1) goto L6c
            java.lang.String r2 = r0.coverUrl
            boolean r2 = android.text.TextUtils.isEmpty(r2)
            if (r2 != 0) goto L6c
            java.lang.String r6 = r0.coverUrl
            return r6
        L87:
            java.lang.String r6 = ""
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.kwad.sdk.core.response.b.a.X(com.kwad.sdk.core.response.model.AdInfo):java.lang.String");
    }

    public static String Y(AdInfo adInfo) {
        int iBe = be(adInfo);
        if (iBe != 1) {
            if (iBe != 2 && iBe != 3) {
                return "";
            }
            for (AdInfo.AdMaterialInfo.MaterialFeature materialFeature : adInfo.adMaterialInfo.materialFeatureList) {
                if (materialFeature.featureType == 2 && !TextUtils.isEmpty(materialFeature.blurBackgroundUrl)) {
                    return materialFeature.blurBackgroundUrl;
                }
            }
        }
        return aX(adInfo).blurBackgroundUrl;
    }

    private static int Z(AdInfo adInfo) {
        return aV(adInfo).width;
    }

    private static int aa(AdInfo adInfo) {
        return aV(adInfo).height;
    }

    public static long ab(AdInfo adInfo) {
        return aV(adInfo).photoId;
    }

    public static String t(int i, String str) {
        if (str == null) {
            str = "下载中  %s%%";
        }
        return String.format(str, Integer.valueOf(i));
    }

    @Deprecated
    public static String dF(int i) {
        return t(i, "下载中  %s%%");
    }

    public static String dG(int i) {
        return "继续下载 " + i + "%";
    }

    public static String cl(AdTemplate adTemplate) {
        if (adTemplate != null && adTemplate.mAdScene != null && adTemplate.mAdScene.getAdStyle() == 2 && !cQ(e.el(adTemplate)) && !cR(e.el(adTemplate))) {
            return "安装获取奖励";
        }
        if (adTemplate == null) {
            return "立即安装";
        }
        AdInfo adInfoEl = e.el(adTemplate);
        return TextUtils.isEmpty(adInfoEl.adBaseInfo.installAppLabel) ? "立即安装" : adInfoEl.adBaseInfo.installAppLabel;
    }

    public static boolean cm(AdTemplate adTemplate) {
        return e.el(adTemplate).adBaseInfo.apiExpParam.aggregateMiddlePageShowPathSwitch;
    }

    public static String cn(AdTemplate adTemplate) {
        return e.el(adTemplate).adMatrixInfo.adDataV2.rewardWebTaskCloseInfo.templateId;
    }

    public static String ac(AdInfo adInfo) {
        return (adInfo == null || TextUtils.isEmpty(adInfo.adBaseInfo.openAppLabel)) ? "立即打开" : adInfo.adBaseInfo.openAppLabel;
    }

    public static long ad(AdInfo adInfo) {
        return adInfo.adRewardInfo.rewardTime;
    }

    public static int ae(AdInfo adInfo) {
        return adInfo.adRewardInfo.skipShowTime;
    }

    public static long af(AdInfo adInfo) {
        return ((long) adInfo.adRewardInfo.skipShowTime) * 1000;
    }

    public static long ag(AdInfo adInfo) {
        return ((long) adInfo.adRewardInfo.rewardTime) * 1000;
    }

    private static int ah(AdInfo adInfo) {
        if (adInfo.adStyleConfInfo != null) {
            return adInfo.adStyleConfInfo.rewardSkipConfirmSwitch;
        }
        com.kwad.sdk.core.d.c.w("AdInfoHelper", "adInfo.adStyleConfInfo is null");
        return 1;
    }

    public static boolean ai(AdInfo adInfo) {
        if (adInfo.adStyleConfInfo.nativeAdInfo != null && adInfo.adStyleConfInfo.nativeAdInfo.shakeInfo != null) {
            return adInfo.adStyleConfInfo.nativeAdInfo.shakeInfo.enableShake;
        }
        com.kwad.sdk.core.d.c.w("AdInfoHelper", "adInfo.adStyleConfInfo.nativeAdInfo is null");
        return false;
    }

    public static int aj(AdInfo adInfo) {
        if (adInfo.adStyleConfInfo.nativeAdInfo != null) {
            return adInfo.adStyleConfInfo.nativeAdInfo.shakeInfo.acceleration;
        }
        com.kwad.sdk.core.d.c.w("AdInfoHelper", "adInfo.adStyleConfInfo.nativeAdInfo is null");
        return 2;
    }

    public static boolean ak(AdInfo adInfo) {
        return ah(adInfo) != 0;
    }

    public static long al(AdInfo adInfo) {
        if (adInfo.adStyleConfInfo != null) {
            return ((long) adInfo.adStyleConfInfo.fullScreenSkipShowTime) * 1000;
        }
        com.kwad.sdk.core.d.c.w("AdInfoHelper", "adInfo.adStyleConfInfo is null");
        return 5000L;
    }

    public static long am(AdInfo adInfo) {
        if (adInfo.adStyleConfInfo != null) {
            return adInfo.adStyleConfInfo.closeDelaySeconds * 1000;
        }
        com.kwad.sdk.core.d.c.w("AdInfoHelper", "adInfo.adStyleConfInfo is null");
        return 0L;
    }

    public static int an(AdInfo adInfo) {
        return adInfo.adStyleConfInfo.adShowVideoH5Info.showPageType;
    }

    public static boolean ao(AdInfo adInfo) {
        return adInfo.adStyleConfInfo.adShowVideoH5Info.videoAutoLoopAtH5;
    }

    public static boolean ap(AdInfo adInfo) {
        return adInfo.adStyleConfInfo.adShowVideoH5Info.videoMutedAtH5;
    }

    public static boolean aq(AdInfo adInfo) {
        return adInfo.adStyleConfInfo.adShowVideoH5Info.videoClickAtH5;
    }

    public static long ar(AdInfo adInfo) {
        if (adInfo.adStyleConfInfo != null) {
            return adInfo.adStyleConfInfo.playableCloseSeconds * 1000;
        }
        com.kwad.sdk.core.d.c.w("AdInfoHelper", "adInfo.adStyleConfInfo is null");
        return 0L;
    }

    public static boolean as(AdInfo adInfo) {
        return !aF(adInfo) && at(adInfo);
    }

    public static boolean at(AdInfo adInfo) {
        if (adInfo.adRewardInfo.showLandingPage == 1) {
            return ((aO(adInfo) && aN(adInfo) == 1) || cX(adInfo)) ? false : true;
        }
        return false;
    }

    public static String au(AdInfo adInfo) {
        return adInfo.adBaseInfo.adDescription;
    }

    public static String av(AdInfo adInfo) {
        return adInfo.adBaseInfo.appName;
    }

    private static String aw(AdInfo adInfo) {
        return adInfo.adBaseInfo.realAppName;
    }

    public static String ax(AdInfo adInfo) {
        return adInfo.adBaseInfo.productName;
    }

    public static String ay(AdInfo adInfo) {
        if (adInfo == null || adInfo.adBaseInfo == null) {
            return null;
        }
        return adInfo.adBaseInfo.appPackageName;
    }

    public static String az(AdInfo adInfo) {
        return adInfo.adBaseInfo.appDownloadCountDesc;
    }

    public static float aA(AdInfo adInfo) {
        if (adInfo.adBaseInfo.appScore <= 0) {
            return 0.0f;
        }
        return adInfo.adBaseInfo.appScore / 10.0f;
    }

    public static boolean aB(AdInfo adInfo) {
        return adInfo.adBaseInfo.enableClientProofreadTime;
    }

    public static float aC(AdInfo adInfo) {
        float f = adInfo.adBaseInfo.appScore;
        if (f < 30.0f) {
            return 3.0f;
        }
        if (f < 35.0f) {
            return 3.5f;
        }
        if (f < 40.0f) {
            return 4.0f;
        }
        return f < 45.0f ? 4.5f : 5.0f;
    }

    public static String aD(AdInfo adInfo) {
        return bp.isNullString(adInfo.adBaseInfo.adSourceDescription) ? "广告" : adInfo.adBaseInfo.adSourceDescription;
    }

    public static String aE(AdInfo adInfo) {
        if (adInfo == null) {
            return "立即下载";
        }
        String str = adInfo.adBaseInfo.adActionDescription;
        if (TextUtils.isEmpty(str)) {
            return aF(adInfo) ? "立即下载" : "查看详情";
        }
        return str;
    }

    public static boolean aF(AdInfo adInfo) {
        return aQ(adInfo) == 1;
    }

    public static boolean aG(AdInfo adInfo) {
        return adInfo.adStyleConfInfo.rewardVideoInteractSwitch && !TextUtils.isEmpty(adInfo.adMatrixInfo.adDataV2.rewardVideoInteractInfo.templateId);
    }

    public static int aH(AdInfo adInfo) {
        return adInfo.adMatrixInfo.adDataV2.rewardVideoInteractInfo.intervalShow;
    }

    public static int aI(AdInfo adInfo) {
        return adInfo.adMatrixInfo.adDataV2.rewardVideoInteractInfo.dayMaxLimit;
    }

    public static int aJ(AdInfo adInfo) {
        return adInfo.adMatrixInfo.adDataV2.rewardVideoInteractInfo.showTime;
    }

    public static int aK(AdInfo adInfo) {
        return adInfo.adMatrixInfo.adDataV2.rewardVideoInteractInfo.rewardTime;
    }

    public static int aL(AdInfo adInfo) {
        return adInfo.adMatrixInfo.adDataV2.rewardVideoTaskInfo.showTime;
    }

    public static int aM(AdInfo adInfo) {
        return adInfo.adMatrixInfo.adDataV2.rewardVideoTaskInfo.thresholdTime;
    }

    public static int aN(AdInfo adInfo) {
        return adInfo.adMatrixInfo.adDataV2.rewardVideoTaskInfo.taskType;
    }

    public static boolean aO(AdInfo adInfo) {
        return !TextUtils.isEmpty(adInfo.adMatrixInfo.adDataV2.rewardVideoTaskInfo.templateId);
    }

    public static boolean aP(AdInfo adInfo) {
        return adInfo.downloadSafeInfo.complianceInfo != null && aF(adInfo) && adInfo.downloadSafeInfo.complianceInfo.titleBarTextSwitch == 1;
    }

    public static int aQ(AdInfo adInfo) {
        int i = adInfo.adBaseInfo.adOperationType;
        int i2 = 1;
        if (i != 1) {
            i2 = 2;
            if (i != 2) {
                return 0;
            }
        }
        return i2;
    }

    public static int aR(AdInfo adInfo) {
        return adInfo.adBaseInfo.ecpm;
    }

    public static String aS(AdInfo adInfo) {
        com.kwad.sdk.service.a.f fVar = (com.kwad.sdk.service.a.f) ServiceProvider.get(com.kwad.sdk.service.a.f.class);
        return TextUtils.isEmpty(adInfo.adConversionInfo.h5Url) ? "" : aj.c(fVar == null ? null : fVar.getContext(), adInfo.adConversionInfo.h5Url, aB(adInfo));
    }

    public static int aT(AdInfo adInfo) {
        return adInfo.adConversionInfo.h5Type;
    }

    public static AdInfo.AdMaterialInfo.MaterialFeature aU(AdInfo adInfo) {
        for (AdInfo.AdMaterialInfo.MaterialFeature materialFeature : adInfo.adMaterialInfo.materialFeatureList) {
            if (materialFeature != null && materialFeature.featureType == 2 && !TextUtils.isEmpty(materialFeature.materialUrl)) {
                return materialFeature;
            }
        }
        com.kwad.sdk.core.d.c.w("AdInfoHelper", "getImageMaterialFeature in null");
        return new AdInfo.AdMaterialInfo.MaterialFeature();
    }

    public static AdInfo.AdMaterialInfo.MaterialFeature aV(AdInfo adInfo) {
        for (AdInfo.AdMaterialInfo.MaterialFeature materialFeature : adInfo.adMaterialInfo.materialFeatureList) {
            if (materialFeature != null && materialFeature.featureType == 1 && !TextUtils.isEmpty(materialFeature.materialUrl)) {
                return materialFeature;
            }
        }
        com.kwad.sdk.core.d.c.w("AdInfoHelper", "getVideoMaterialFeature in null");
        return new AdInfo.AdMaterialInfo.MaterialFeature();
    }

    public static boolean aW(AdInfo adInfo) {
        AdInfo.AdMaterialInfo.MaterialFeature materialFeatureAU;
        if (bc(adInfo)) {
            materialFeatureAU = aV(adInfo);
        } else {
            materialFeatureAU = aU(adInfo);
        }
        return materialFeatureAU.height > materialFeatureAU.width;
    }

    public static AdInfo.AdMaterialInfo.MaterialFeature aX(AdInfo adInfo) {
        List<AdInfo.AdMaterialInfo.MaterialFeature> list = adInfo.adMaterialInfo.materialFeatureList;
        AdInfo.AdMaterialInfo.MaterialFeature materialFeature = list.size() > 0 ? list.get(0) : null;
        return materialFeature == null ? new AdInfo.AdMaterialInfo.MaterialFeature() : materialFeature;
    }

    public static boolean aY(AdInfo adInfo) {
        AdInfo.AdMaterialInfo.MaterialFeature materialFeatureAV = aV(adInfo);
        return materialFeatureAV.height > materialFeatureAV.width;
    }

    public static String aZ(AdInfo adInfo) {
        return adInfo.adPreloadInfo.preloadId;
    }

    public static List<String> ba(AdInfo adInfo) {
        ArrayList arrayList = new ArrayList();
        int iBe = be(adInfo);
        if (iBe != 2 && iBe != 3) {
            return arrayList;
        }
        for (AdInfo.AdMaterialInfo.MaterialFeature materialFeature : adInfo.adMaterialInfo.materialFeatureList) {
            if (materialFeature.featureType == 2 && !TextUtils.isEmpty(materialFeature.materialUrl)) {
                arrayList.add(materialFeature.materialUrl);
            }
        }
        return arrayList;
    }

    public static String bb(AdInfo adInfo) {
        if (bc(adInfo)) {
            return K(adInfo);
        }
        List<String> listBa = ba(adInfo);
        return listBa.size() > 0 ? listBa.get(0) : "";
    }

    public static boolean bc(AdInfo adInfo) {
        return be(adInfo) == 1;
    }

    public static boolean bd(AdInfo adInfo) {
        return aU(adInfo).featureType == 2;
    }

    public static int be(AdInfo adInfo) {
        int i = adInfo.adMaterialInfo.materialType;
        int i2 = 1;
        if (i != 1) {
            i2 = 2;
            if (i != 2) {
                if (i != 5) {
                    return i != 8 ? 0 : 8;
                }
                return 3;
            }
        }
        return i2;
    }

    public static int bf(AdInfo adInfo) {
        return adInfo.adMatrixInfo.adDataV2.actionBarInfo.cardType;
    }

    public static int bg(AdInfo adInfo) {
        if (adInfo.adDrawInfo == null || adInfo.adDrawInfo.liveTypeInfo == null) {
            return 7;
        }
        return adInfo.adDrawInfo.liveTypeInfo.actionbarCardType;
    }

    public static String bh(AdInfo adInfo) {
        return adInfo.adBaseInfo.liveStreamId;
    }

    public static boolean bi(AdInfo adInfo) {
        return adInfo.adMaterialInfo.materialType == 1;
    }

    public static boolean bj(AdInfo adInfo) {
        return adInfo.adConversionInfo.needDeeplinkReplaceAdapta;
    }

    public static boolean bk(AdInfo adInfo) {
        return adInfo.adConversionInfo.interceptH5JumpAppMkt;
    }

    public static int bl(AdInfo adInfo) {
        return adInfo.adConversionInfo.interceptH5JumpTimeOut;
    }

    public static boolean bm(AdInfo adInfo) {
        return adInfo.adConversionInfo.isSupportKeepPlaying;
    }

    public static long bn(AdInfo adInfo) {
        return adInfo.adConversionInfo.keepPlayingBackOffTime;
    }

    public static boolean bo(AdInfo adInfo) {
        return new JSONObject(adInfo.adBaseInfo.videoPlayedNSConfig).length() != 0;
    }

    public static List<Integer> bp(AdInfo adInfo) {
        String str = adInfo.adBaseInfo.videoPlayedNS;
        ArrayList arrayList = new ArrayList();
        if (!TextUtils.isEmpty(str)) {
            try {
                for (String str2 : str.split(",")) {
                    int i = Integer.parseInt(str2);
                    if (i > 0) {
                        arrayList.add(Integer.valueOf(i));
                    }
                }
            } catch (Exception e) {
                com.kwad.sdk.core.d.c.printStackTrace(e);
            }
        }
        if (arrayList.isEmpty()) {
            arrayList.add(3);
        }
        return arrayList;
    }

    public static boolean b(AdInfo adInfo, boolean z) {
        return ((z && aF(adInfo)) || adInfo.adBaseInfo.mABParams.showVideoAtH5 == 0 || bp.isNullString(aS(adInfo))) ? false : true;
    }

    private static int[] bq(AdInfo adInfo) {
        int[] iArr = {3, 3, 3};
        String str = adInfo.adBaseInfo.mABParams.drawActionBarTimes;
        if (TextUtils.isEmpty(str)) {
            return iArr;
        }
        try {
            String[] strArrSplit = str.split(",");
            if (strArrSplit.length < 3) {
                return iArr;
            }
            iArr[0] = Integer.parseInt(strArrSplit[0]);
            iArr[1] = Integer.parseInt(strArrSplit[1]);
            iArr[2] = Integer.parseInt(strArrSplit[2]);
        } catch (Exception e) {
            com.kwad.sdk.core.d.c.printStackTrace(e);
        }
        return iArr;
    }

    public static int br(AdInfo adInfo) {
        int i = bq(adInfo)[0];
        if (i > 0) {
            return i;
        }
        return 3;
    }

    public static int bs(AdInfo adInfo) {
        int i = bq(adInfo)[1];
        if (i <= 0) {
            i = 3;
        }
        return i + br(adInfo);
    }

    public static int bt(AdInfo adInfo) {
        int i = bq(adInfo)[2];
        if (i <= 0) {
            i = 3;
        }
        return i + bs(adInfo);
    }

    public static com.kwad.sdk.core.response.model.b bu(AdInfo adInfo) {
        boolean z;
        String strO = O(adInfo);
        int iQ = Q(adInfo);
        int iR = R(adInfo);
        if (bp.isNullString(strO) || bp.hp(strO) || iQ == 0 || iR == 0) {
            strO = X(adInfo);
            iQ = Z(adInfo);
            iR = aa(adInfo);
            z = true;
        } else {
            z = false;
        }
        boolean z2 = z;
        String str = strO;
        com.kwad.sdk.core.d.c.d("AdInfoHelper", "frameUrl=" + str + " useCover=" + z2 + " isAd=true");
        return new com.kwad.sdk.core.response.model.b(str, iQ, iR, true, z2);
    }

    public static String bv(AdInfo adInfo) {
        String str = adInfo.downloadSafeInfo.webPageTipbarText;
        return !TextUtils.isEmpty(str) ? str : "您访问的网站由第三方提供";
    }

    public static boolean bw(AdInfo adInfo) {
        return adInfo.downloadSafeInfo.secWindowPopSwitch;
    }

    public static boolean bx(AdInfo adInfo) {
        return adInfo.downloadSafeInfo.secWindowPopNoWifiSwitch;
    }

    public static int by(AdInfo adInfo) {
        if (aF(adInfo)) {
            if (adInfo.downloadSafeInfo.complianceInfo == null) {
                return -1;
            }
            return adInfo.downloadSafeInfo.complianceInfo.materialJumpType;
        }
        if (adInfo.unDownloadConf.unDownloadRegionConf == null) {
            return -1;
        }
        return adInfo.unDownloadConf.unDownloadRegionConf.materialJumpType;
    }

    public static boolean bz(AdInfo adInfo) {
        return adInfo.downloadSafeInfo.webPageTipbarSwitch;
    }

    public static int bA(AdInfo adInfo) {
        if (adInfo == null) {
            return 0;
        }
        int i = adInfo.status;
        if (i == 0) {
            return 1;
        }
        if (1 == i || 2 == i || 3 == i || 4 == i) {
            return 2;
        }
        return 8 == i ? 3 : 0;
    }

    public static int bB(AdInfo adInfo) {
        return adInfo.status;
    }

    public static String bC(AdInfo adInfo) {
        if (adInfo != null) {
            return adInfo.adBaseInfo.corporationName;
        }
        return null;
    }

    public static String bD(AdInfo adInfo) {
        if (adInfo != null) {
            return adInfo.downloadSafeInfo.permissionInfo;
        }
        return null;
    }

    public static String bE(AdInfo adInfo) {
        if (adInfo != null) {
            return adInfo.downloadSafeInfo.appPermissionInfoUrl;
        }
        return null;
    }

    public static String bF(AdInfo adInfo) {
        if (adInfo != null) {
            return adInfo.downloadSafeInfo.introductionInfo;
        }
        return null;
    }

    public static String bG(AdInfo adInfo) {
        if (adInfo != null) {
            return adInfo.downloadSafeInfo.introductionInfoUrl;
        }
        return null;
    }

    public static String bH(AdInfo adInfo) {
        if (adInfo != null) {
            return adInfo.downloadSafeInfo.appPrivacyUrl;
        }
        return null;
    }

    public static String bI(AdInfo adInfo) {
        if (adInfo != null) {
            return adInfo.adBaseInfo.appVersion;
        }
        return null;
    }

    public static long bJ(AdInfo adInfo) {
        if (adInfo != null) {
            return adInfo.adBaseInfo.packageSize;
        }
        return 0L;
    }

    public static boolean bK(AdInfo adInfo) {
        if (adInfo != null && adInfo.adConversionInfo != null) {
            boolean z = (adInfo.adConversionInfo.playableUrl == null || adInfo.adConversionInfo.playableStyleInfo == null || TextUtils.isEmpty(adInfo.adConversionInfo.playableUrl.trim())) ? false : true;
            if (bN(adInfo) && z) {
                return true;
            }
        }
        return false;
    }

    public static long bL(AdInfo adInfo) {
        if (adInfo == null || adInfo.adConversionInfo == null) {
            return 0L;
        }
        return adInfo.adConversionInfo.h5DeeplinkLimitedTimeMs;
    }

    public static long bM(AdInfo adInfo) {
        if (adInfo == null || adInfo.adConversionInfo == null) {
            return 0L;
        }
        return adInfo.adConversionInfo.playableDeeplinkLimitedTimeMs;
    }

    public static boolean bN(AdInfo adInfo) {
        if (aq.isOrientationPortrait()) {
            return bP(adInfo);
        }
        return bO(adInfo);
    }

    private static boolean bO(AdInfo adInfo) {
        if (adInfo == null || adInfo.adConversionInfo == null || adInfo.adConversionInfo.playableStyleInfo == null) {
            return false;
        }
        int i = adInfo.adConversionInfo.playableStyleInfo.playableOrientation;
        return i == 0 || i == 2;
    }

    private static boolean bP(AdInfo adInfo) {
        if (adInfo == null || adInfo.adConversionInfo == null || adInfo.adConversionInfo.playableStyleInfo == null) {
            return false;
        }
        int i = adInfo.adConversionInfo.playableStyleInfo.playableOrientation;
        return i == 0 || i == 1;
    }

    public static String bQ(AdInfo adInfo) {
        if (adInfo == null || adInfo.adConversionInfo == null) {
            return null;
        }
        return adInfo.adConversionInfo.playableUrl;
    }

    public static String bR(AdInfo adInfo) {
        if (adInfo == null || adInfo.adConversionInfo == null) {
            return null;
        }
        return adInfo.adConversionInfo.callbackUrl;
    }

    public static String bS(AdInfo adInfo) {
        if (adInfo == null || adInfo.adConversionInfo == null) {
            return null;
        }
        return adInfo.adConversionInfo.callbackUrlInfo;
    }

    public static String bT(AdInfo adInfo) {
        if (adInfo == null || adInfo.serverExt == null) {
            return null;
        }
        return adInfo.serverExt;
    }

    public static String bU(AdInfo adInfo) {
        if (adInfo == null || adInfo.adConversionInfo == null) {
            return null;
        }
        return adInfo.adConversionInfo.adExt;
    }

    public static boolean bV(AdInfo adInfo) {
        return adInfo.fullScreenVideoInfo.fullScreenEndCardSwitch;
    }

    public static boolean bW(AdInfo adInfo) {
        return adInfo.adRewardInfo.rewardVideoEndCardSwitch;
    }

    public static boolean bX(AdInfo adInfo) {
        return (adInfo == null || adInfo.adBannerInfo == null || adInfo.adBannerInfo.videoSoundType != 2) ? false : true;
    }

    public static boolean bY(AdInfo adInfo) {
        if (adInfo == null || adInfo.adBannerInfo == null) {
            return false;
        }
        return adInfo.adBannerInfo.videoAutoPlayType == 1 || adInfo.adBannerInfo.videoAutoPlayType == 0;
    }

    public static boolean bZ(AdInfo adInfo) {
        return (adInfo == null || adInfo.adBannerInfo == null || adInfo.adBannerInfo.videoAutoPlayType != 2) ? false : true;
    }

    public static boolean ca(AdInfo adInfo) {
        return (adInfo == null || adInfo.adFeedInfo == null || adInfo.adFeedInfo.videoSoundType != 2) ? false : true;
    }

    public static boolean cb(AdInfo adInfo) {
        return (adInfo == null || adInfo.adDrawInfo == null || adInfo.adDrawInfo.videoSoundType != 1) ? false : true;
    }

    public static boolean cc(AdInfo adInfo) {
        if (adInfo == null || adInfo.adFeedInfo == null) {
            return false;
        }
        return adInfo.adFeedInfo.videoAutoPlayType == 1 || adInfo.adFeedInfo.videoAutoPlayType == 0;
    }

    public static boolean cd(AdInfo adInfo) {
        return (adInfo == null || adInfo.adFeedInfo == null || adInfo.adFeedInfo.videoAutoPlayType != 2) ? false : true;
    }

    public static boolean ce(AdInfo adInfo) {
        return (adInfo == null || adInfo.adFeedInfo == null || adInfo.adFeedInfo.videoAutoPlayType != 3) ? false : true;
    }

    public static boolean cf(AdInfo adInfo) {
        com.kwad.sdk.service.a.h hVar = (com.kwad.sdk.service.a.h) ServiceProvider.get(com.kwad.sdk.service.a.h.class);
        return (hVar == null || !hVar.BR()) && !TextUtils.isEmpty(aS(adInfo)) && adInfo.adStyleInfo.adBrowseInfo.enableAdBrowse == 1;
    }

    public static String cg(AdInfo adInfo) {
        String str = adInfo.adStyleInfo.adBrowseInfo.rewardDescription;
        return TextUtils.isEmpty(str) ? "浏览页面" : str;
    }

    public static int ch(AdInfo adInfo) {
        if (adInfo == null) {
            return 0;
        }
        return adInfo.adStyleConfInfo.actionBarType;
    }

    public static int ci(AdInfo adInfo) {
        if (adInfo == null) {
            return 0;
        }
        return adInfo.adStyleConfInfo.endCardType;
    }

    public static int cj(AdInfo adInfo) {
        if (adInfo == null) {
            return 0;
        }
        return adInfo.adStyleConfInfo.confirmCardType;
    }

    public static boolean ck(AdInfo adInfo) {
        if (adInfo == null || adInfo.adBaseInfo == null || adInfo.adBaseInfo.apiExpParam == null) {
            return false;
        }
        return adInfo.adBaseInfo.apiExpParam.deeplinkOptimizeSwitch;
    }

    public static String cl(AdInfo adInfo) {
        String strAx;
        if (aF(adInfo)) {
            strAx = av(adInfo);
        } else {
            strAx = ax(adInfo);
        }
        if (TextUtils.isEmpty(strAx)) {
            strAx = adInfo.advertiserInfo.rawUserName;
        }
        return TextUtils.isEmpty(strAx) ? "可爱的广告君" : strAx;
    }

    public static String cm(AdInfo adInfo) {
        String strAw = aw(adInfo);
        return TextUtils.isEmpty(strAw) ? "可爱的广告君" : strAw;
    }

    public static String cn(AdInfo adInfo) {
        return adInfo.advertiserInfo.rawUserName;
    }

    public static String co(AdInfo adInfo) {
        String str = adInfo.adBaseInfo.appIconUrl;
        return (TextUtils.isEmpty(str) || !aF(adInfo)) ? adInfo.advertiserInfo.portraitUrl : str;
    }

    public static long cp(AdInfo adInfo) {
        return adInfo.advertiserInfo.userId;
    }

    public static String cq(AdInfo adInfo) {
        return bp.isNullString(adInfo.adConversionInfo.liveServiceToken) ? "" : adInfo.adConversionInfo.liveServiceToken;
    }

    public static long cr(AdInfo adInfo) {
        return adInfo.adConversionInfo.liveVisitorId;
    }

    public static String cs(AdInfo adInfo) {
        return (adInfo == null || adInfo.adSplashInfo == null || adInfo.adSplashInfo.skipTips == null || TextUtils.isEmpty(adInfo.adSplashInfo.skipTips)) ? "跳过" : adInfo.adSplashInfo.skipTips;
    }

    public static AdInfo.CutRuleInfo ct(AdInfo adInfo) {
        return adInfo.adSplashInfo.cutRuleInfo;
    }

    public static int cu(AdInfo adInfo) {
        return adInfo.adMatrixInfo.adDataV2.splashEndCardTKInfo.endCardShowSecond;
    }

    public static boolean cv(AdInfo adInfo) {
        return adInfo.adMatrixInfo.adDataV2.splashEndCardTKInfo.endCardShowCountDown;
    }

    public static int cw(AdInfo adInfo) {
        return adInfo.adInsertScreenInfo.retainWindowBasedAdShowCount;
    }

    public static int cx(AdInfo adInfo) {
        return adInfo.adInsertScreenInfo.retainWindowDailyShowCount;
    }

    public static int cy(AdInfo adInfo) {
        return adInfo.adInsertScreenInfo.retainWindowStyle;
    }

    public static String cz(AdInfo adInfo) {
        return adInfo.adInsertScreenInfo.retainWindowText;
    }

    public static int cA(AdInfo adInfo) {
        return adInfo.adInsertScreenInfo.cycleAggregateStyle;
    }

    public static boolean cB(AdInfo adInfo) {
        return adInfo.adSplashInfo.skipType == 2 || adInfo.adSplashInfo.skipType == 3;
    }

    public static boolean cC(AdInfo adInfo) {
        if (cD(adInfo)) {
            return adInfo.adSplashInfo.skipType == 0 || adInfo.adSplashInfo.skipType == 2;
        }
        return false;
    }

    public static boolean cD(AdInfo adInfo) {
        return adInfo.adSplashInfo.skipSecond >= 0;
    }

    public static boolean cE(AdInfo adInfo) {
        return (adInfo == null || adInfo.adSplashInfo == null || adInfo.adSplashInfo.countdownShow != 1) ? false : true;
    }

    public static boolean cF(AdInfo adInfo) {
        return adInfo.adSplashInfo.impressionStatisticalChangeSwitch;
    }

    public static int cG(AdInfo adInfo) {
        double d = adInfo.adSplashInfo.impressionLimitSize;
        if (d <= 0.0d || d > 1.0d) {
            d = 0.699999988079071d;
        }
        return ((int) d) * 100;
    }

    public static boolean cH(AdInfo adInfo) {
        if (adInfo == null || adInfo.downloadSafeInfo == null) {
            return false;
        }
        return adInfo.downloadSafeInfo.downloadPauseEnable;
    }

    public static String cI(AdInfo adInfo) {
        return adInfo.adBaseInfo.sdkExtraData;
    }

    @Deprecated
    public static boolean cJ(AdInfo adInfo) {
        return adInfo.adStyleConfInfo.innerAdType == 3;
    }

    public static boolean cK(AdInfo adInfo) {
        return adInfo.advertiserInfo.followed;
    }

    @Deprecated
    public static boolean cL(AdInfo adInfo) {
        return adInfo.adStyleConfInfo.innerAdType == 1;
    }

    public static String cM(AdInfo adInfo) {
        int i = adInfo.advertiserInfo.fansCount;
        if (i >= 200 && i < 10000) {
            return String.valueOf(i);
        }
        if (i < 10000) {
            return null;
        }
        return new DecimalFormat("0.0").format(((double) i) / 10000.0d) + "w";
    }

    public static SpannableString b(AdInfo adInfo, int i) {
        String str;
        int iIndexOf;
        String strCM = cM(adInfo);
        if (strCM == null || (iIndexOf = (str = String.format("已有%s粉丝关注了TA", strCM)).indexOf(strCM)) < 0) {
            return null;
        }
        SpannableString spannableString = new SpannableString(str);
        spannableString.setSpan(new ForegroundColorSpan(i), iIndexOf, strCM.length() + iIndexOf, 18);
        return spannableString;
    }

    public static String cN(AdInfo adInfo) {
        return adInfo.advertiserInfo.brief;
    }

    public static String cO(AdInfo adInfo) {
        return adInfo.advertiserInfo.portraitUrl;
    }

    @Deprecated
    public static boolean cP(AdInfo adInfo) {
        return adInfo.adStyleConfInfo.innerAdType == 4 || adInfo.adStyleConfInfo.innerAdType == 5;
    }

    @Deprecated
    public static boolean cQ(AdInfo adInfo) {
        return adInfo.adStyleConfInfo.innerAdType == 7;
    }

    public static boolean cR(AdInfo adInfo) {
        return adInfo.adBaseInfo.universeLiveType == 1 && cp(adInfo) != 0;
    }

    public static boolean cS(AdInfo adInfo) {
        return cR(adInfo) || cQ(adInfo);
    }

    public static String cT(AdInfo adInfo) {
        com.kwad.sdk.service.a.f fVar = (com.kwad.sdk.service.a.f) ServiceProvider.get(com.kwad.sdk.service.a.f.class);
        return aj.c(fVar == null ? null : fVar.getContext(), adInfo.adConversionInfo.deeplinkUrl, aB(adInfo));
    }

    public static String cU(AdInfo adInfo) {
        return adInfo.adConversionInfo.appDownloadUrl;
    }

    public static AdProductInfo cV(AdInfo adInfo) {
        return adInfo.adProductInfo;
    }

    public static String cW(AdInfo adInfo) {
        return adInfo.adConversionInfo.marketUrl;
    }

    @Deprecated
    public static boolean co(AdTemplate adTemplate) {
        AdInfo adInfoEl = e.el(adTemplate);
        AdMatrixInfo.MerchantLiveReservationInfo merchantLiveReservationInfoDt = b.dt(adTemplate);
        return (merchantLiveReservationInfoDt != null && !merchantLiveReservationInfoDt.isEmpty()) && adInfoEl.adStyleConfInfo.innerAdType == 2;
    }

    public static boolean cX(AdInfo adInfo) {
        if (aF(adInfo)) {
            return false;
        }
        return adInfo.adBaseInfo.extraClickReward;
    }

    public static boolean cY(AdInfo adInfo) {
        return cX(adInfo) && ag(adInfo) < M(adInfo);
    }

    public static boolean cZ(AdInfo adInfo) {
        if (!TextUtils.isEmpty(adInfo.adMatrixInfo.adDataV2.pushTKInfo.templateId)) {
            return true;
        }
        com.kwad.sdk.core.d.c.d("AdInfoHelper", "isPushAdEnable pushTK TemplateId is empty");
        return false;
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static boolean da(com.kwad.sdk.core.response.model.AdInfo r9) {
        /*
            com.kwad.sdk.core.response.model.AdInfo$AdStyleConfInfo r0 = r9.adStyleConfInfo
            boolean r0 = r0.adPushSwitch
            r1 = 0
            if (r0 != 0) goto L8
            return r1
        L8:
            long r2 = com.kwad.sdk.utils.ag.QF()
            r4 = 0
            int r0 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            r6 = 1
            if (r0 > 0) goto L15
        L13:
            r1 = r6
            goto L2d
        L15:
            com.kwad.sdk.core.response.model.AdInfo$AdStyleConfInfo r9 = r9.adStyleConfInfo
            int r9 = r9.adPushIntervalTime
            long r7 = (long) r9
            int r9 = (r7 > r4 ? 1 : (r7 == r4 ? 0 : -1))
            if (r9 > 0) goto L20
            r7 = 900(0x384, double:4.447E-321)
        L20:
            r4 = 1000(0x3e8, double:4.94E-321)
            long r7 = r7 * r4
            long r4 = java.lang.System.currentTimeMillis()
            long r4 = r4 - r2
            int r9 = (r4 > r7 ? 1 : (r4 == r7 ? 0 : -1))
            if (r9 <= 0) goto L2d
            goto L13
        L2d:
            java.lang.StringBuilder r9 = new java.lang.StringBuilder
            java.lang.String r0 = "isPushAdEnable intervalEnable: "
            r9.<init>(r0)
            java.lang.StringBuilder r9 = r9.append(r1)
            java.lang.String r9 = r9.toString()
            java.lang.String r0 = "AdInfoHelper"
            com.kwad.sdk.core.d.c.d(r0, r9)
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.kwad.sdk.core.response.b.a.da(com.kwad.sdk.core.response.model.AdInfo):boolean");
    }

    public static int db(AdInfo adInfo) {
        return adInfo.adStyleConfInfo.adPushShowAfterTime * 1000;
    }

    public static boolean dc(AdInfo adInfo) {
        return (!cR(adInfo) || TextUtils.isEmpty(b.ep(adInfo)) || dd(adInfo)) ? false : true;
    }

    private static boolean dd(AdInfo adInfo) {
        return adInfo.adStyleConfInfo.useNativeForOuterLiveAd;
    }

    public static long de(AdInfo adInfo) {
        return adInfo.adRewardInfo.callBackStrategyInfo.callBackAdvanceMs;
    }

    public static boolean df(AdInfo adInfo) {
        return adInfo.adRewardInfo.callBackStrategyInfo.serverCheckSwitch;
    }

    public static boolean dg(AdInfo adInfo) {
        return adInfo.adRewardInfo.callBackStrategyInfo.rewardAdvanceSwitch;
    }

    public static boolean dh(AdInfo adInfo) {
        return adInfo.adRewardInfo.rewardFraudVerifyInfo.fraudVerifySwitch;
    }

    public static long di(AdInfo adInfo) {
        return adInfo.adRewardInfo.rewardFraudVerifyInfo.fraudVerifyAdvanceMs;
    }

    public static KSAdInfoData dj(AdInfo adInfo) {
        KSAdInfoData interactionType = KSAdInfoData.obtain().setAdDescription(au(adInfo)).setProductName(ax(adInfo)).setAdSource(aD(adInfo)).setVideoUrl(K(adInfo)).setMaterialType(be(adInfo)).setAppIconUrl(co(adInfo)).setAppName(av(adInfo)).setImageList(dk(adInfo)).setVideoCoverImageUrl(dl(adInfo)).setInteractionType(aQ(adInfo));
        try {
            interactionType.setCreativeId(J(adInfo));
        } catch (Throwable unused) {
        }
        return interactionType;
    }

    private static List<String> dk(AdInfo adInfo) {
        ArrayList arrayList = new ArrayList();
        int iBe = be(adInfo);
        if (iBe == 2 || iBe == 3) {
            for (AdInfo.AdMaterialInfo.MaterialFeature materialFeature : adInfo.adMaterialInfo.materialFeatureList) {
                if (materialFeature.featureType == 2 && !TextUtils.isEmpty(materialFeature.materialUrl)) {
                    arrayList.add(materialFeature.materialUrl);
                }
            }
        }
        return arrayList;
    }

    private static String dl(AdInfo adInfo) {
        AdInfo.AdMaterialInfo.MaterialFeature materialFeatureAV = aV(adInfo);
        if (TextUtils.isEmpty(materialFeatureAV.coverUrl)) {
            return null;
        }
        return materialFeatureAV.coverUrl;
    }

    public static String H(AdInfo adInfo) {
        return adInfo.downloadFilePath;
    }

    public static String dm(AdInfo adInfo) {
        return adInfo.adConversionInfo.smallAppJumpInfo.mediaSmallAppId;
    }

    public static boolean dn(AdInfo adInfo) {
        int i = adInfo.adMaterialInfo.derivativeMaterialType;
        return i == 6 || i == 2;
    }

    /* JADX INFO: renamed from: do, reason: not valid java name */
    public static int m614do(AdInfo adInfo) {
        if (adInfo == null) {
            return 0;
        }
        return adInfo.adBaseInfo.campaignType;
    }

    public static int dp(AdInfo adInfo) {
        if (adInfo == null) {
            return 0;
        }
        return adInfo.ocpcActionType;
    }

    public static int dq(AdInfo adInfo) {
        if (adInfo == null) {
            return 0;
        }
        return adInfo.adBaseInfo.industryFirstLevelId;
    }

    public static int dr(AdInfo adInfo) {
        if (adInfo == null) {
            return 0;
        }
        return adInfo.adConversionInfo.webUriSourceType;
    }

    public static int ds(AdInfo adInfo) {
        return adInfo.adBannerInfo.videoAutoPlayType;
    }

    public static boolean dt(AdInfo adInfo) {
        return adInfo.adBannerInfo.isSupportCarousel;
    }

    public static boolean du(AdInfo adInfo) {
        try {
            if (adInfo.adMatrixInfo.adDataV2.styleComponentInfo != null) {
                return adInfo.adMatrixInfo.adDataV2.styleComponentInfo.styleComponentFlag;
            }
        } catch (Throwable unused) {
        }
        return false;
    }

    public static String dv(AdInfo adInfo) {
        try {
            if (adInfo.adMatrixInfo.adDataV2.styleComponentInfo != null) {
                return AdMatrixInfo.ComponentParam.obtain().setPageId(Long.valueOf(adInfo.adMatrixInfo.adDataV2.styleComponentInfo.playCardInfo != null ? adInfo.adMatrixInfo.adDataV2.styleComponentInfo.playCardInfo.pageId : 0L)).setEndCardPageId(Long.valueOf(adInfo.adMatrixInfo.adDataV2.styleComponentInfo.endCardInfo != null ? adInfo.adMatrixInfo.adDataV2.styleComponentInfo.endCardInfo.pageId : 0L)).toJson().toString();
            }
        } catch (Throwable unused) {
        }
        return "";
    }

    public static boolean dw(AdInfo adInfo) {
        return adInfo.ksUaPattern;
    }

    public static boolean dx(AdInfo adInfo) {
        return adInfo.unionMark;
    }
}
