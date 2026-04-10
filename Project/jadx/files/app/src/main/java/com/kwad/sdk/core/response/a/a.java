package com.kwad.sdk.core.response.a;

import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import androidx.annotation.ColorInt;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.mobads.sdk.api.IAdInterListener;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdMatrixInfo;
import com.kwad.sdk.core.response.model.AdProductInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.internal.api.SceneImpl;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.utils.ab;
import com.kwad.sdk.utils.ah;
import com.kwad.sdk.utils.ba;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public final class a {
    public static long D(@NonNull AdInfo adInfo) {
        return adInfo.adBaseInfo.creativeId;
    }

    public static String E(@NonNull AdInfo adInfo) {
        return aO(adInfo).materialUrl;
    }

    public static int F(@NonNull AdInfo adInfo) {
        return aO(adInfo).videoDuration;
    }

    public static long G(@NonNull AdInfo adInfo) {
        return ((long) F(adInfo)) * 1000;
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x0043  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.String H(@androidx.annotation.NonNull com.kwad.sdk.core.response.model.AdInfo r6) {
        /*
            int r0 = aX(r6)
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
        throw new UnsupportedOperationException("Method not decompiled: com.kwad.sdk.core.response.a.a.H(com.kwad.sdk.core.response.model.AdInfo):java.lang.String");
    }

    public static boolean I(@NonNull AdInfo adInfo) {
        return adInfo.adConversionInfo.supportThirdDownload == 1;
    }

    public static int J(@NonNull AdInfo adInfo) {
        return aO(adInfo).videoWidth;
    }

    public static int K(@NonNull AdInfo adInfo) {
        return aO(adInfo).videoHeight;
    }

    public static boolean L(@NonNull AdInfo adInfo) {
        AdInfo.SmallAppJumpInfo smallAppJumpInfo = adInfo.adConversionInfo.smallAppJumpInfo;
        return smallAppJumpInfo == null || TextUtils.isEmpty(smallAppJumpInfo.mediaSmallAppId);
    }

    public static boolean M(@NonNull AdInfo adInfo) {
        return adInfo.adConversionInfo.webUriSourceType == 2;
    }

    public static boolean N(@NonNull AdInfo adInfo) {
        AdInfo.AdMaterialInfo.MaterialFeature materialFeatureAO = aO(adInfo);
        return materialFeatureAO.videoWidth <= materialFeatureAO.videoHeight;
    }

    public static String O(@NonNull AdInfo adInfo) {
        int iAX = aX(adInfo);
        String str = "";
        if (iAX == 1) {
            for (AdInfo.AdMaterialInfo.MaterialFeature materialFeature : adInfo.adMaterialInfo.materialFeatureList) {
                if (materialFeature.featureType == 1) {
                    str = materialFeature.coverUrl;
                    if (TextUtils.isEmpty(str)) {
                        str = materialFeature.firstFrame;
                    }
                    if (!TextUtils.isEmpty(str)) {
                        break;
                    }
                }
            }
        } else if (iAX == 2 || iAX == 3) {
            for (AdInfo.AdMaterialInfo.MaterialFeature materialFeature2 : adInfo.adMaterialInfo.materialFeatureList) {
                if (materialFeature2.featureType == 2) {
                    str = materialFeature2.coverUrl;
                    if (TextUtils.isEmpty(str)) {
                        str = materialFeature2.materialUrl;
                    }
                    if (!TextUtils.isEmpty(str)) {
                        break;
                    }
                }
            }
        }
        return str;
    }

    /* JADX WARN: Removed duplicated region for block: B:26:0x004f  */
    @java.lang.Deprecated
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.String P(@androidx.annotation.NonNull com.kwad.sdk.core.response.model.AdInfo r6) {
        /*
            int r0 = aX(r6)
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
        throw new UnsupportedOperationException("Method not decompiled: com.kwad.sdk.core.response.a.a.P(com.kwad.sdk.core.response.model.AdInfo):java.lang.String");
    }

    public static String Q(@NonNull AdInfo adInfo) {
        int iAX = aX(adInfo);
        if (iAX != 1) {
            if (iAX != 2 && iAX != 3) {
                return "";
            }
            for (AdInfo.AdMaterialInfo.MaterialFeature materialFeature : adInfo.adMaterialInfo.materialFeatureList) {
                if (materialFeature.featureType == 2 && !TextUtils.isEmpty(materialFeature.blurBackgroundUrl)) {
                    return materialFeature.blurBackgroundUrl;
                }
            }
        }
        return aR(adInfo).blurBackgroundUrl;
    }

    private static int R(@NonNull AdInfo adInfo) {
        return aO(adInfo).width;
    }

    private static int S(@NonNull AdInfo adInfo) {
        return aO(adInfo).height;
    }

    public static long T(@NonNull AdInfo adInfo) {
        return aO(adInfo).photoId;
    }

    public static String U(@Nullable AdInfo adInfo) {
        return (adInfo == null || TextUtils.isEmpty(adInfo.adBaseInfo.openAppLabel)) ? "立即打开" : adInfo.adBaseInfo.openAppLabel;
    }

    public static long V(@NonNull AdInfo adInfo) {
        return adInfo.adRewardInfo.rewardTime;
    }

    public static int W(@NonNull AdInfo adInfo) {
        return adInfo.adRewardInfo.skipShowTime;
    }

    public static long X(@NonNull AdInfo adInfo) {
        return ((long) adInfo.adRewardInfo.skipShowTime) * 1000;
    }

    public static long Y(@NonNull AdInfo adInfo) {
        return ((long) adInfo.adRewardInfo.rewardTime) * 1000;
    }

    private static int Z(@NonNull AdInfo adInfo) {
        AdInfo.AdStyleConfInfo adStyleConfInfo = adInfo.adStyleConfInfo;
        if (adStyleConfInfo != null) {
            return adStyleConfInfo.rewardSkipConfirmSwitch;
        }
        com.kwad.sdk.core.d.b.w("AdInfoHelper", "adInfo.adStyleConfInfo is null");
        return 1;
    }

    public static int aA(@NonNull AdInfo adInfo) {
        return adInfo.adMatrixInfo.adDataV2.rewardVideoInteractInfo.intervalShow;
    }

    public static int aB(@NonNull AdInfo adInfo) {
        return adInfo.adMatrixInfo.adDataV2.rewardVideoInteractInfo.dayMaxLimit;
    }

    public static int aC(@NonNull AdInfo adInfo) {
        return adInfo.adMatrixInfo.adDataV2.rewardVideoInteractInfo.showTime;
    }

    public static int aD(@NonNull AdInfo adInfo) {
        return adInfo.adMatrixInfo.adDataV2.rewardVideoInteractInfo.rewardTime;
    }

    public static int aE(@NonNull AdInfo adInfo) {
        return adInfo.adMatrixInfo.adDataV2.rewardVideoTaskInfo.showTime;
    }

    public static int aF(@NonNull AdInfo adInfo) {
        return adInfo.adMatrixInfo.adDataV2.rewardVideoTaskInfo.thresholdTime;
    }

    public static int aG(@NonNull AdInfo adInfo) {
        return adInfo.adMatrixInfo.adDataV2.rewardVideoTaskInfo.taskType;
    }

    public static boolean aH(@NonNull AdInfo adInfo) {
        return !TextUtils.isEmpty(adInfo.adMatrixInfo.adDataV2.rewardVideoTaskInfo.templateId);
    }

    public static String aI(AdTemplate adTemplate) {
        SceneImpl sceneImpl;
        if (adTemplate != null && (sceneImpl = adTemplate.mAdScene) != null && sceneImpl.getAdStyle() == 2 && !cn(d.cb(adTemplate)) && !co(d.cb(adTemplate))) {
            return "安装获取奖励";
        }
        if (adTemplate == null) {
            return "立即安装";
        }
        AdInfo adInfoCb = d.cb(adTemplate);
        return TextUtils.isEmpty(adInfoCb.adBaseInfo.installAppLabel) ? "立即安装" : adInfoCb.adBaseInfo.installAppLabel;
    }

    public static boolean aI(@NonNull AdInfo adInfo) {
        return adInfo.downloadSafeInfo.complianceInfo != null && ay(adInfo) && adInfo.downloadSafeInfo.complianceInfo.titleBarTextSwitch == 1;
    }

    public static int aJ(@NonNull AdInfo adInfo) {
        int i2 = adInfo.adBaseInfo.adOperationType;
        int i3 = 1;
        if (i2 != 1) {
            i3 = 2;
            if (i2 != 2) {
                return 0;
            }
        }
        return i3;
    }

    public static boolean aJ(@NonNull AdTemplate adTemplate) {
        AdInfo adInfoCb = d.cb(adTemplate);
        AdMatrixInfo.MerchantLiveReservationInfo merchantLiveReservationInfoBJ = b.bJ(adTemplate);
        return (merchantLiveReservationInfoBJ != null && !merchantLiveReservationInfoBJ.isEmpty()) && adInfoCb.adBaseInfo.campaignType == 13 && adInfoCb.ocpcActionType == 2;
    }

    public static int aK(@NonNull AdInfo adInfo) {
        return adInfo.adBaseInfo.ecpm;
    }

    public static String aL(@NonNull AdInfo adInfo) {
        com.kwad.sdk.service.kwai.e eVar = (com.kwad.sdk.service.kwai.e) ServiceProvider.get(com.kwad.sdk.service.kwai.e.class);
        return ab.c(eVar == null ? null : eVar.getContext(), adInfo.adConversionInfo.h5Url, au(adInfo));
    }

    public static int aM(@NonNull AdInfo adInfo) {
        return adInfo.adConversionInfo.h5Type;
    }

    @NonNull
    public static AdInfo.AdMaterialInfo.MaterialFeature aN(@NonNull AdInfo adInfo) {
        for (AdInfo.AdMaterialInfo.MaterialFeature materialFeature : adInfo.adMaterialInfo.materialFeatureList) {
            if (materialFeature != null && materialFeature.featureType == 2 && !TextUtils.isEmpty(materialFeature.materialUrl)) {
                return materialFeature;
            }
        }
        com.kwad.sdk.core.d.b.w("AdInfoHelper", "getImageMaterialFeature in null");
        return new AdInfo.AdMaterialInfo.MaterialFeature();
    }

    @NonNull
    public static AdInfo.AdMaterialInfo.MaterialFeature aO(@NonNull AdInfo adInfo) {
        for (AdInfo.AdMaterialInfo.MaterialFeature materialFeature : adInfo.adMaterialInfo.materialFeatureList) {
            if (materialFeature != null && materialFeature.featureType == 1 && !TextUtils.isEmpty(materialFeature.materialUrl)) {
                return materialFeature;
            }
        }
        com.kwad.sdk.core.d.b.w("AdInfoHelper", "getVideoMaterialFeature in null");
        return new AdInfo.AdMaterialInfo.MaterialFeature();
    }

    public static boolean aP(AdInfo adInfo) {
        AdInfo.AdMaterialInfo.MaterialFeature materialFeatureAO = aV(adInfo) ? aO(adInfo) : aN(adInfo);
        return materialFeatureAO.height > materialFeatureAO.width;
    }

    public static float aQ(AdInfo adInfo) {
        AdInfo.AdMaterialInfo.MaterialFeature materialFeatureAO = aV(adInfo) ? aO(adInfo) : aN(adInfo);
        if (materialFeatureAO == null || materialFeatureAO.width == 0) {
            return -1.0f;
        }
        com.kwad.sdk.core.d.b.d("AdInfoHelper", "getMaterialRatio: height: " + materialFeatureAO.height + ", width: " + materialFeatureAO.width);
        return materialFeatureAO.height / materialFeatureAO.width;
    }

    @NonNull
    private static AdInfo.AdMaterialInfo.MaterialFeature aR(@NonNull AdInfo adInfo) {
        List<AdInfo.AdMaterialInfo.MaterialFeature> list = adInfo.adMaterialInfo.materialFeatureList;
        AdInfo.AdMaterialInfo.MaterialFeature materialFeature = list.size() > 0 ? list.get(0) : null;
        return materialFeature == null ? new AdInfo.AdMaterialInfo.MaterialFeature() : materialFeature;
    }

    public static boolean aS(AdInfo adInfo) {
        AdInfo.AdMaterialInfo.MaterialFeature materialFeatureAO = aO(adInfo);
        return materialFeatureAO.height > materialFeatureAO.width;
    }

    public static String aT(AdInfo adInfo) {
        return adInfo.adPreloadInfo.preloadId;
    }

    @NonNull
    public static List<String> aU(@NonNull AdInfo adInfo) {
        ArrayList arrayList = new ArrayList();
        int iAX = aX(adInfo);
        if (iAX != 2 && iAX != 3) {
            return arrayList;
        }
        for (AdInfo.AdMaterialInfo.MaterialFeature materialFeature : adInfo.adMaterialInfo.materialFeatureList) {
            if (materialFeature.featureType == 2 && !TextUtils.isEmpty(materialFeature.materialUrl)) {
                arrayList.add(materialFeature.materialUrl);
            }
        }
        return arrayList;
    }

    public static boolean aV(@NonNull AdInfo adInfo) {
        return aX(adInfo) == 1;
    }

    public static boolean aW(@NonNull AdInfo adInfo) {
        return aN(adInfo).featureType == 2;
    }

    public static int aX(AdInfo adInfo) {
        int i2 = adInfo.adMaterialInfo.materialType;
        int i3 = 1;
        if (i2 != 1) {
            i3 = 2;
            if (i2 != 2) {
                if (i2 != 5) {
                    return i2 != 8 ? 0 : 8;
                }
                return 3;
            }
        }
        return i3;
    }

    public static int aY(AdInfo adInfo) {
        return adInfo.adMatrixInfo.adDataV2.actionBarInfo.cardType;
    }

    public static String aZ(AdInfo adInfo) {
        return adInfo.adBaseInfo.liveStreamId;
    }

    public static boolean aa(@NonNull AdInfo adInfo) {
        AdInfo.NativeAdShakeInfo nativeAdShakeInfo;
        AdInfo.NativeAdInfo nativeAdInfo = adInfo.adStyleConfInfo.nativeAdInfo;
        if (nativeAdInfo != null && (nativeAdShakeInfo = nativeAdInfo.shakeInfo) != null) {
            return nativeAdShakeInfo.enableShake;
        }
        com.kwad.sdk.core.d.b.w("AdInfoHelper", "adInfo.adStyleConfInfo.nativeAdInfo is null");
        return false;
    }

    public static int ab(@NonNull AdInfo adInfo) {
        AdInfo.NativeAdInfo nativeAdInfo = adInfo.adStyleConfInfo.nativeAdInfo;
        if (nativeAdInfo != null) {
            return nativeAdInfo.shakeInfo.acceleration;
        }
        com.kwad.sdk.core.d.b.w("AdInfoHelper", "adInfo.adStyleConfInfo.nativeAdInfo is null");
        return 2;
    }

    public static boolean ac(@NonNull AdInfo adInfo) {
        return Z(adInfo) != 0;
    }

    public static long ad(@NonNull AdInfo adInfo) {
        AdInfo.AdStyleConfInfo adStyleConfInfo = adInfo.adStyleConfInfo;
        if (adStyleConfInfo != null) {
            return ((long) adStyleConfInfo.fullScreenSkipShowTime) * 1000;
        }
        com.kwad.sdk.core.d.b.w("AdInfoHelper", "adInfo.adStyleConfInfo is null");
        return 5000L;
    }

    public static long ae(@NonNull AdInfo adInfo) {
        AdInfo.AdStyleConfInfo adStyleConfInfo = adInfo.adStyleConfInfo;
        if (adStyleConfInfo != null) {
            return adStyleConfInfo.closeDelaySeconds * 1000;
        }
        com.kwad.sdk.core.d.b.w("AdInfoHelper", "adInfo.adStyleConfInfo is null");
        return 0L;
    }

    public static int af(@NonNull AdInfo adInfo) {
        return adInfo.adStyleConfInfo.adShowVideoH5Info.showPageType;
    }

    public static boolean ag(@NonNull AdInfo adInfo) {
        return adInfo.adStyleConfInfo.adShowVideoH5Info.videoAutoLoopAtH5;
    }

    public static boolean ah(@NonNull AdInfo adInfo) {
        return adInfo.adStyleConfInfo.adShowVideoH5Info.videoMutedAtH5;
    }

    public static boolean ai(@NonNull AdInfo adInfo) {
        return adInfo.adStyleConfInfo.adShowVideoH5Info.videoClickAtH5;
    }

    public static long aj(@NonNull AdInfo adInfo) {
        AdInfo.AdStyleConfInfo adStyleConfInfo = adInfo.adStyleConfInfo;
        if (adStyleConfInfo != null) {
            return adStyleConfInfo.playableCloseSeconds * 1000;
        }
        com.kwad.sdk.core.d.b.w("AdInfoHelper", "adInfo.adStyleConfInfo is null");
        return 0L;
    }

    public static boolean ak(@NonNull AdInfo adInfo) {
        return !ay(adInfo) && al(adInfo);
    }

    public static boolean al(@NonNull AdInfo adInfo) {
        if (adInfo.adRewardInfo.showLandingPage == 1) {
            return ((aH(adInfo) && aG(adInfo) == 1) || an(adInfo) || cu(adInfo)) ? false : true;
        }
        return false;
    }

    public static boolean am(@NonNull AdInfo adInfo) {
        return (!(adInfo.fullScreenVideoInfo.showLandingPage == 1) || !(ba.isNullString(aL(adInfo)) ^ true) || ay(adInfo) || (ba.isNullString(cq(adInfo)) ^ true) || bu(adInfo)) ? false : true;
    }

    private static boolean an(@NonNull AdInfo adInfo) {
        return adInfo.adBaseInfo.taskType == 4;
    }

    public static String ao(@NonNull AdInfo adInfo) {
        return adInfo.adBaseInfo.adDescription;
    }

    public static String ap(@NonNull AdInfo adInfo) {
        return adInfo.adBaseInfo.appName;
    }

    public static String aq(@NonNull AdInfo adInfo) {
        return adInfo.adBaseInfo.productName;
    }

    public static String ar(AdInfo adInfo) {
        AdInfo.AdBaseInfo adBaseInfo;
        if (adInfo == null || (adBaseInfo = adInfo.adBaseInfo) == null) {
            return null;
        }
        return adBaseInfo.appPackageName;
    }

    public static String as(@NonNull AdInfo adInfo) {
        return adInfo.adBaseInfo.appDownloadCountDesc;
    }

    public static float at(@NonNull AdInfo adInfo) {
        int i2 = adInfo.adBaseInfo.appScore;
        if (i2 <= 0) {
            return 0.0f;
        }
        return i2 / 10.0f;
    }

    public static boolean au(@NonNull AdInfo adInfo) {
        return adInfo.adBaseInfo.enableClientProofreadTime;
    }

    public static float av(@NonNull AdInfo adInfo) {
        float f2 = adInfo.adBaseInfo.appScore;
        if (f2 < 30.0f) {
            return 3.0f;
        }
        if (f2 < 35.0f) {
            return 3.5f;
        }
        if (f2 < 40.0f) {
            return 4.0f;
        }
        return f2 < 45.0f ? 4.5f : 5.0f;
    }

    public static String aw(AdInfo adInfo) {
        return ba.isNullString(adInfo.adBaseInfo.adSourceDescription) ? "广告" : adInfo.adBaseInfo.adSourceDescription;
    }

    public static String ax(@Nullable AdInfo adInfo) {
        if (adInfo == null) {
            return "立即下载";
        }
        String str = adInfo.adBaseInfo.adActionDescription;
        if (TextUtils.isEmpty(str)) {
            return ay(adInfo) ? "立即下载" : "查看详情";
        }
        return str;
    }

    public static boolean ay(@NonNull AdInfo adInfo) {
        return aJ(adInfo) == 1;
    }

    public static boolean az(@NonNull AdInfo adInfo) {
        return adInfo.adStyleConfInfo.rewardVideoInteractSwitch && !TextUtils.isEmpty(adInfo.adMatrixInfo.adDataV2.rewardVideoInteractInfo.templateId);
    }

    public static boolean b(@NonNull AdInfo adInfo, boolean z2) {
        return ((z2 && ay(adInfo)) || adInfo.adBaseInfo.mABParams.showVideoAtH5 == 0 || ba.isNullString(aL(adInfo))) ? false : true;
    }

    @Nullable
    public static String bA(AdInfo adInfo) {
        AdInfo.AdConversionInfo adConversionInfo;
        if (adInfo == null || (adConversionInfo = adInfo.adConversionInfo) == null) {
            return null;
        }
        return adConversionInfo.playableUrl;
    }

    @Nullable
    public static String bB(AdInfo adInfo) {
        AdInfo.AdConversionInfo adConversionInfo;
        if (adInfo == null || (adConversionInfo = adInfo.adConversionInfo) == null) {
            return null;
        }
        return adConversionInfo.callbackUrl;
    }

    @Nullable
    public static String bC(AdInfo adInfo) {
        AdInfo.AdConversionInfo adConversionInfo;
        if (adInfo == null || (adConversionInfo = adInfo.adConversionInfo) == null) {
            return null;
        }
        return adConversionInfo.callbackUrlInfo;
    }

    public static boolean bD(AdInfo adInfo) {
        return adInfo.fullScreenVideoInfo.fullScreenEndCardSwitch;
    }

    public static boolean bE(AdInfo adInfo) {
        return adInfo.adRewardInfo.rewardVideoEndCardSwitch;
    }

    public static boolean bF(AdInfo adInfo) {
        AdInfo.AdFeedInfo adFeedInfo;
        return (adInfo == null || (adFeedInfo = adInfo.adFeedInfo) == null || adFeedInfo.videoSoundType != 2) ? false : true;
    }

    public static boolean bG(AdInfo adInfo) {
        AdInfo.AdFeedInfo adFeedInfo;
        if (adInfo == null || (adFeedInfo = adInfo.adFeedInfo) == null) {
            return false;
        }
        int i2 = adFeedInfo.videoAutoPlayType;
        return i2 == 1 || i2 == 0;
    }

    public static boolean bH(AdInfo adInfo) {
        AdInfo.AdFeedInfo adFeedInfo;
        return (adInfo == null || (adFeedInfo = adInfo.adFeedInfo) == null || adFeedInfo.videoAutoPlayType != 2) ? false : true;
    }

    public static boolean bI(AdInfo adInfo) {
        return (TextUtils.isEmpty(aL(adInfo)) || ay(adInfo) || adInfo.adStyleInfo.adBrowseInfo.enableAdBrowse != 1) ? false : true;
    }

    @NonNull
    public static String bJ(@NonNull AdInfo adInfo) {
        String strAp = ay(adInfo) ? ap(adInfo) : aq(adInfo);
        if (TextUtils.isEmpty(strAp)) {
            strAp = adInfo.advertiserInfo.rawUserName;
        }
        return TextUtils.isEmpty(strAp) ? "可爱的广告君" : strAp;
    }

    @NonNull
    public static String bK(@NonNull AdInfo adInfo) {
        return adInfo.advertiserInfo.rawUserName;
    }

    public static String bL(@NonNull AdInfo adInfo) {
        String str = adInfo.adBaseInfo.appIconUrl;
        return (TextUtils.isEmpty(str) || !ay(adInfo)) ? adInfo.advertiserInfo.portraitUrl : str;
    }

    public static long bM(@NonNull AdInfo adInfo) {
        return adInfo.advertiserInfo.userId;
    }

    @NonNull
    public static String bN(AdInfo adInfo) {
        AdInfo.AdSplashInfo adSplashInfo;
        String str;
        return (adInfo == null || (adSplashInfo = adInfo.adSplashInfo) == null || (str = adSplashInfo.skipTips) == null || TextUtils.isEmpty(str)) ? "跳过" : adInfo.adSplashInfo.skipTips;
    }

    public static int bO(AdInfo adInfo) {
        return adInfo.adMatrixInfo.adDataV2.splashEndCardTKInfo.endCardShowSecond;
    }

    public static boolean bP(AdInfo adInfo) {
        return adInfo.adMatrixInfo.adDataV2.splashEndCardTKInfo.endCardShowCountDown;
    }

    public static int bQ(@NonNull AdInfo adInfo) {
        return adInfo.adInsertScreenInfo.retainWindowBasedAdShowCount;
    }

    public static int bR(@NonNull AdInfo adInfo) {
        return adInfo.adInsertScreenInfo.retainWindowDailyShowCount;
    }

    public static int bS(@NonNull AdInfo adInfo) {
        return adInfo.adInsertScreenInfo.retainWindowStyle;
    }

    public static int bT(@NonNull AdInfo adInfo) {
        return adInfo.adInsertScreenInfo.guideShowStyle;
    }

    public static int bU(@NonNull AdInfo adInfo) {
        return adInfo.adInsertScreenInfo.guideShowTime;
    }

    public static String bV(@NonNull AdInfo adInfo) {
        return adInfo.adInsertScreenInfo.retainWindowText;
    }

    public static boolean bW(@NonNull AdInfo adInfo) {
        return adInfo.adInsertScreenInfo.cycleAggregateSwitch;
    }

    public static int bX(@NonNull AdInfo adInfo) {
        return adInfo.adInsertScreenInfo.cycleAggregateStyle;
    }

    public static int bY(@NonNull AdInfo adInfo) {
        return adInfo.adInsertScreenInfo.cycleAggregateInterval;
    }

    public static int bZ(@NonNull AdInfo adInfo) {
        return adInfo.adInsertScreenInfo.cycleAggregateDailyShowCount;
    }

    public static boolean ba(AdInfo adInfo) {
        return adInfo.adMaterialInfo.materialType == 1;
    }

    public static boolean bb(AdInfo adInfo) {
        return adInfo.adConversionInfo.needDeeplinkReplaceAdapta;
    }

    @Nullable
    public static List<Integer> bc(@NonNull AdInfo adInfo) {
        String str = adInfo.adBaseInfo.videoPlayedNS;
        ArrayList arrayList = new ArrayList();
        if (!TextUtils.isEmpty(str)) {
            try {
                for (String str2 : str.split(",")) {
                    int i2 = Integer.parseInt(str2);
                    if (i2 > 0) {
                        arrayList.add(Integer.valueOf(i2));
                    }
                }
            } catch (Exception e2) {
                com.kwad.sdk.core.d.b.printStackTrace(e2);
            }
        }
        if (arrayList.isEmpty()) {
            arrayList.add(3);
        }
        return arrayList;
    }

    @NonNull
    private static int[] bd(@NonNull AdInfo adInfo) {
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
        } catch (Exception e2) {
            com.kwad.sdk.core.d.b.printStackTrace(e2);
        }
        return iArr;
    }

    public static int be(@NonNull AdInfo adInfo) {
        int[] iArrBd = bd(adInfo);
        if (iArrBd[0] > 0) {
            return iArrBd[0];
        }
        return 3;
    }

    public static int bf(@NonNull AdInfo adInfo) {
        int[] iArrBd = bd(adInfo);
        return (iArrBd[1] > 0 ? iArrBd[1] : 3) + be(adInfo);
    }

    public static int bg(@NonNull AdInfo adInfo) {
        int[] iArrBd = bd(adInfo);
        return (iArrBd[2] > 0 ? iArrBd[2] : 3) + bf(adInfo);
    }

    @NonNull
    public static com.kwad.sdk.core.response.model.b bh(@NonNull AdInfo adInfo) {
        String strP;
        int iR;
        int iS;
        boolean z2;
        String strH = H(adInfo);
        int iJ = J(adInfo);
        int iK = K(adInfo);
        if (ba.isNullString(strH) || ba.ey(strH) || iJ == 0 || iK == 0) {
            strP = P(adInfo);
            iR = R(adInfo);
            iS = S(adInfo);
            z2 = true;
        } else {
            strP = strH;
            iR = iJ;
            iS = iK;
            z2 = false;
        }
        com.kwad.sdk.core.d.b.d("AdInfoHelper", "frameUrl=" + strP + " useCover=" + z2 + " isAd=true");
        return new com.kwad.sdk.core.response.model.b(strP, iR, iS, true, z2);
    }

    public static String bi(AdInfo adInfo) {
        String str = adInfo.downloadSafeInfo.webPageTipbarText;
        return !TextUtils.isEmpty(str) ? str : "您访问的网站由第三方提供";
    }

    public static boolean bj(AdInfo adInfo) {
        return adInfo.downloadSafeInfo.secWindowPopSwitch;
    }

    public static boolean bk(AdInfo adInfo) {
        return adInfo.downloadSafeInfo.secWindowPopNoWifiSwitch;
    }

    public static int bl(AdInfo adInfo) {
        AdInfo.ComplianceInfo complianceInfo = adInfo.downloadSafeInfo.complianceInfo;
        if (complianceInfo == null) {
            return -1;
        }
        return complianceInfo.materialJumpType;
    }

    public static boolean bm(AdInfo adInfo) {
        return adInfo.downloadSafeInfo.webPageTipbarSwitch;
    }

    public static int bn(AdInfo adInfo) {
        if (adInfo == null) {
            return 0;
        }
        int i2 = adInfo.status;
        if (i2 == 0) {
            return 1;
        }
        if (1 == i2 || 2 == i2 || 3 == i2 || 4 == i2) {
            return 2;
        }
        return 8 == i2 ? 3 : 0;
    }

    @Nullable
    public static String bo(AdInfo adInfo) {
        if (adInfo != null) {
            return adInfo.adBaseInfo.corporationName;
        }
        return null;
    }

    @Nullable
    public static String bp(AdInfo adInfo) {
        if (adInfo != null) {
            return adInfo.downloadSafeInfo.permissionInfo;
        }
        return null;
    }

    @Nullable
    public static String bq(AdInfo adInfo) {
        if (adInfo != null) {
            return adInfo.downloadSafeInfo.appPermissionInfoUrl;
        }
        return null;
    }

    @Nullable
    public static String br(AdInfo adInfo) {
        if (adInfo != null) {
            return adInfo.downloadSafeInfo.appPrivacyUrl;
        }
        return null;
    }

    @Nullable
    public static String bs(AdInfo adInfo) {
        if (adInfo != null) {
            return adInfo.adBaseInfo.appVersion;
        }
        return null;
    }

    public static long bt(AdInfo adInfo) {
        if (adInfo != null) {
            return adInfo.adBaseInfo.packageSize;
        }
        return 0L;
    }

    @Deprecated
    public static String bu(int i2) {
        return i(i2, "下载中  %s%%");
    }

    public static boolean bu(AdInfo adInfo) {
        if (adInfo == null || adInfo.adConversionInfo == null || cx(adInfo)) {
            return false;
        }
        AdInfo.AdConversionInfo adConversionInfo = adInfo.adConversionInfo;
        String str = adConversionInfo.playableUrl;
        return bx(adInfo) && (str != null && adConversionInfo.playableStyleInfo != null && !TextUtils.isEmpty(str.trim()));
    }

    public static long bv(AdInfo adInfo) {
        AdInfo.AdConversionInfo adConversionInfo;
        if (adInfo == null || (adConversionInfo = adInfo.adConversionInfo) == null) {
            return 0L;
        }
        return adConversionInfo.h5DeeplinkLimitedTimeMs;
    }

    public static String bv(int i2) {
        return "继续下载 " + i2 + "%";
    }

    public static long bw(AdInfo adInfo) {
        AdInfo.AdConversionInfo adConversionInfo;
        if (adInfo == null || (adConversionInfo = adInfo.adConversionInfo) == null) {
            return 0L;
        }
        return adConversionInfo.playableDeeplinkLimitedTimeMs;
    }

    public static boolean bx(AdInfo adInfo) {
        return ah.DI() ? bz(adInfo) : by(adInfo);
    }

    private static boolean by(AdInfo adInfo) {
        AdInfo.AdConversionInfo adConversionInfo;
        AdInfo.PlayableStyleInfo playableStyleInfo;
        if (adInfo == null || (adConversionInfo = adInfo.adConversionInfo) == null || (playableStyleInfo = adConversionInfo.playableStyleInfo) == null) {
            return false;
        }
        int i2 = playableStyleInfo.playableOrientation;
        return i2 == 0 || i2 == 2;
    }

    private static boolean bz(AdInfo adInfo) {
        AdInfo.AdConversionInfo adConversionInfo;
        AdInfo.PlayableStyleInfo playableStyleInfo;
        if (adInfo == null || (adConversionInfo = adInfo.adConversionInfo) == null || (playableStyleInfo = adConversionInfo.playableStyleInfo) == null) {
            return false;
        }
        int i2 = playableStyleInfo.playableOrientation;
        return i2 == 0 || i2 == 1;
    }

    public static boolean cA(@NonNull AdInfo adInfo) {
        return adInfo.adStyleConfInfo.useNativeForOuterLiveAd;
    }

    public static boolean ca(@NonNull AdInfo adInfo) {
        int i2 = adInfo.adSplashInfo.skipType;
        return i2 == 2 || i2 == 3;
    }

    public static boolean cb(@Nullable AdInfo adInfo) {
        if (!cc(adInfo)) {
            return false;
        }
        int i2 = adInfo.adSplashInfo.skipType;
        return i2 == 0 || i2 == 2;
    }

    public static boolean cc(@Nullable AdInfo adInfo) {
        return adInfo.adSplashInfo.skipSecond >= 0;
    }

    public static boolean cd(AdInfo adInfo) {
        AdInfo.AdSplashInfo adSplashInfo;
        return (adInfo == null || (adSplashInfo = adInfo.adSplashInfo) == null || adSplashInfo.countdownShow != 1) ? false : true;
    }

    public static boolean ce(AdInfo adInfo) {
        AdInfo.DownloadSafeInfo downloadSafeInfo;
        if (adInfo == null || (downloadSafeInfo = adInfo.downloadSafeInfo) == null) {
            return false;
        }
        return downloadSafeInfo.downloadPauseEnable;
    }

    public static String cf(@NonNull AdInfo adInfo) {
        return adInfo.adBaseInfo.sdkExtraData;
    }

    public static boolean cg(@NonNull AdInfo adInfo) {
        return adInfo.ocpcActionType == 72 && adInfo.adBaseInfo.campaignType == 13;
    }

    public static boolean ch(@NonNull AdInfo adInfo) {
        return adInfo.advertiserInfo.followed;
    }

    public static boolean ci(@NonNull AdInfo adInfo) {
        if (adInfo.adBaseInfo.industryFirstLevelId != 1022) {
            return false;
        }
        int i2 = adInfo.ocpcActionType;
        return i2 == 192 || i2 == 53;
    }

    @Nullable
    public static String cj(@NonNull AdInfo adInfo) {
        int i2 = adInfo.advertiserInfo.fansCount;
        if (i2 >= 200 && i2 < 10000) {
            return String.valueOf(i2);
        }
        if (i2 < 10000) {
            return null;
        }
        double d2 = i2;
        Double.isNaN(d2);
        return new DecimalFormat("0.0").format(d2 / 10000.0d) + IAdInterListener.AdReqParam.WIDTH;
    }

    public static String ck(@NonNull AdInfo adInfo) {
        return adInfo.advertiserInfo.brief;
    }

    public static String cl(@NonNull AdInfo adInfo) {
        return adInfo.advertiserInfo.portraitUrl;
    }

    public static boolean cm(@NonNull AdInfo adInfo) {
        if (ci(adInfo)) {
            return false;
        }
        int i2 = adInfo.ocpcActionType;
        return (i2 == 395 || i2 == 192) && adInfo.adBaseInfo.campaignType == 13;
    }

    public static boolean cn(@NonNull AdInfo adInfo) {
        AdInfo.AdBaseInfo adBaseInfo = adInfo.adBaseInfo;
        return adBaseInfo.itemType == 1 && adBaseInfo.campaignType == 14;
    }

    public static boolean co(@NonNull AdInfo adInfo) {
        return adInfo.adBaseInfo.universeLiveType == 1 && bM(adInfo) != 0;
    }

    public static boolean cp(@NonNull AdInfo adInfo) {
        AdInfo.AdBaseInfo adBaseInfo = adInfo.adBaseInfo;
        return adBaseInfo.itemType == 2 && adBaseInfo.campaignType == 14;
    }

    public static String cq(@NonNull AdInfo adInfo) {
        com.kwad.sdk.service.kwai.e eVar = (com.kwad.sdk.service.kwai.e) ServiceProvider.get(com.kwad.sdk.service.kwai.e.class);
        return ab.c(eVar == null ? null : eVar.getContext(), adInfo.adConversionInfo.deeplinkUrl, au(adInfo));
    }

    public static AdProductInfo cr(AdInfo adInfo) {
        return adInfo.adProductInfo;
    }

    public static String cs(@NonNull AdInfo adInfo) {
        return adInfo.adConversionInfo.marketUrl;
    }

    public static boolean ct(@NonNull AdInfo adInfo) {
        return adInfo.adStyleConfInfo.rewardReflowSwitch;
    }

    public static boolean cu(@NonNull AdInfo adInfo) {
        if (ay(adInfo)) {
            return false;
        }
        return adInfo.adBaseInfo.extraClickReward;
    }

    public static boolean cv(@NonNull AdInfo adInfo) {
        return cu(adInfo) && Y(adInfo) < G(adInfo);
    }

    public static boolean cw(@NonNull AdInfo adInfo) {
        if (!TextUtils.isEmpty(adInfo.adMatrixInfo.adDataV2.pushTKInfo.templateId)) {
            return true;
        }
        com.kwad.sdk.core.d.b.d("AdInfoHelper", "isPushAdEnable pushTK TemplateId is empty");
        return false;
    }

    /* JADX WARN: Removed duplicated region for block: B:4:0x000c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static boolean cx(@androidx.annotation.NonNull com.kwad.sdk.core.response.model.AdInfo r9) {
        /*
            long r0 = com.kwad.sdk.utils.x.Du()
            r2 = 0
            r3 = 0
            r5 = 1
            int r6 = (r0 > r3 ? 1 : (r0 == r3 ? 0 : -1))
            if (r6 > 0) goto Le
        Lc:
            r0 = 1
            goto L28
        Le:
            com.kwad.sdk.core.response.model.AdInfo$AdStyleConfInfo r6 = r9.adStyleConfInfo
            int r6 = r6.adPushIntervalTime
            long r6 = (long) r6
            int r8 = (r6 > r3 ? 1 : (r6 == r3 ? 0 : -1))
            if (r8 > 0) goto L19
            r6 = 900(0x384, double:4.447E-321)
        L19:
            r3 = 1000(0x3e8, double:4.94E-321)
            long r6 = r6 * r3
            long r3 = java.lang.System.currentTimeMillis()
            long r3 = r3 - r0
            int r0 = (r3 > r6 ? 1 : (r3 == r6 ? 0 : -1))
            if (r0 <= 0) goto L27
            goto Lc
        L27:
            r0 = 0
        L28:
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            java.lang.String r3 = "isPushAdEnable intervalEnable: "
            r1.<init>(r3)
            r1.append(r0)
            java.lang.String r1 = r1.toString()
            java.lang.String r3 = "AdInfoHelper"
            com.kwad.sdk.core.d.b.d(r3, r1)
            if (r0 == 0) goto L44
            com.kwad.sdk.core.response.model.AdInfo$AdStyleConfInfo r9 = r9.adStyleConfInfo
            boolean r9 = r9.adPushSwitch
            if (r9 == 0) goto L44
            return r5
        L44:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.kwad.sdk.core.response.a.a.cx(com.kwad.sdk.core.response.model.AdInfo):boolean");
    }

    public static int cy(@NonNull AdInfo adInfo) {
        return adInfo.adStyleConfInfo.adPushShowAfterTime * 1000;
    }

    public static boolean cz(@NonNull AdInfo adInfo) {
        return adInfo.adStyleConfInfo.adPushSwitch && ay(adInfo) && adInfo.adMatrixInfo.adDataV2.pushTKInfo.showMidPage;
    }

    @Nullable
    public static SpannableString e(AdInfo adInfo, @ColorInt int i2) {
        String str;
        int iIndexOf;
        String strCj = cj(adInfo);
        if (strCj == null || (iIndexOf = (str = String.format("已有%s粉丝关注了TA", strCj)).indexOf(strCj)) < 0) {
            return null;
        }
        SpannableString spannableString = new SpannableString(str);
        spannableString.setSpan(new ForegroundColorSpan(i2), iIndexOf, strCj.length() + iIndexOf, 18);
        return spannableString;
    }

    public static String i(int i2, String str) {
        if (str == null) {
            str = "下载中  %s%%";
        }
        return String.format(str, Integer.valueOf(i2));
    }

    public static String xI() {
        return "继续下载";
    }
}
