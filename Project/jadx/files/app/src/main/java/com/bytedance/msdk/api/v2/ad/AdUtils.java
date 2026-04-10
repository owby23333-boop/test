package com.bytedance.msdk.api.v2.ad;

import bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_case1.j;
import com.bytedance.msdk.api.AdSlot;
import com.bytedance.msdk.api.BaiduExtraOptions;
import com.bytedance.msdk.api.GDTExtraOption;
import com.bytedance.msdk.api.TTVideoOption;
import com.bytedance.msdk.api.v2.slot.GMAdSlotBanner;
import com.bytedance.msdk.api.v2.slot.GMAdSlotBase;
import com.bytedance.msdk.api.v2.slot.GMAdSlotDraw;
import com.bytedance.msdk.api.v2.slot.GMAdSlotFullVideo;
import com.bytedance.msdk.api.v2.slot.GMAdSlotInterstitial;
import com.bytedance.msdk.api.v2.slot.GMAdSlotInterstitialFull;
import com.bytedance.msdk.api.v2.slot.GMAdSlotNative;
import com.bytedance.msdk.api.v2.slot.GMAdSlotRewardVideo;
import com.bytedance.msdk.api.v2.slot.GMAdSlotSplash;
import com.bytedance.msdk.api.v2.slot.paltform.GMAdSlotGDTOption;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public class AdUtils {
    private static AdSlot.Builder a(GMAdSlotBase gMAdSlotBase) {
        if (gMAdSlotBase == null) {
            return null;
        }
        AdSlot.Builder builder = new AdSlot.Builder();
        builder.setBidNotify(gMAdSlotBase.isBidNotify());
        builder.setTestSlotId(gMAdSlotBase.getTestSlotId());
        builder.setTTVideoOption(gMAdSlotBase.createTTVideoOption(gMAdSlotBase instanceof GMAdSlotSplash ? ((GMAdSlotSplash) gMAdSlotBase).isSplashPreLoad() : false));
        builder.setTTRequestExtraParams(gMAdSlotBase.getTTRequestExtraParams());
        builder.setDownloadType(gMAdSlotBase.getDownloadType());
        builder.setV2Request(true);
        return builder;
    }

    public static AdSlot convertGMAdSlotBase2AdSlot(GMAdSlotBase gMAdSlotBase) {
        AdSlot adSlotBuild;
        int i2;
        AdSlot.Builder builderA = a(gMAdSlotBase);
        if (gMAdSlotBase instanceof GMAdSlotRewardVideo) {
            GMAdSlotRewardVideo gMAdSlotRewardVideo = (GMAdSlotRewardVideo) gMAdSlotBase;
            builderA.setRewardName(gMAdSlotRewardVideo.getRewardName());
            builderA.setRewardAmount(gMAdSlotRewardVideo.getRewardAmount());
            builderA.setCustomData(gMAdSlotRewardVideo.getCustomData());
            builderA.setUserID(gMAdSlotRewardVideo.getUserID());
            builderA.setOrientation(gMAdSlotRewardVideo.getOrientation());
            adSlotBuild = builderA.build();
            i2 = 7;
        } else if (gMAdSlotBase instanceof GMAdSlotFullVideo) {
            GMAdSlotFullVideo gMAdSlotFullVideo = (GMAdSlotFullVideo) gMAdSlotBase;
            builderA.setUserID(gMAdSlotFullVideo.getUserID());
            builderA.setOrientation(gMAdSlotFullVideo.getOrientation());
            builderA.setRewardName(gMAdSlotFullVideo.getRewardName());
            builderA.setRewardAmount(gMAdSlotFullVideo.getRewardAmount());
            builderA.setCustomData(gMAdSlotFullVideo.getCustomData());
            adSlotBuild = builderA.build();
            i2 = 8;
        } else {
            if (!(gMAdSlotBase instanceof GMAdSlotInterstitialFull)) {
                if (gMAdSlotBase instanceof GMAdSlotSplash) {
                    GMAdSlotSplash gMAdSlotSplash = (GMAdSlotSplash) gMAdSlotBase;
                    builderA.setImageAdSize(gMAdSlotSplash.getWidth(), gMAdSlotSplash.getHeight());
                    builderA.setUserID(gMAdSlotSplash.getUserID());
                    builderA.setSplashButtonType(gMAdSlotSplash.getSplashButtonType());
                    builderA.setForceLoadBottom(gMAdSlotSplash.isForceLoadBottom());
                    builderA.setSplashShakeButton(gMAdSlotSplash.getSplashShakeButton());
                    adSlotBuild = builderA.build();
                    adSlotBuild.setAdType(3);
                } else {
                    if (gMAdSlotBase instanceof GMAdSlotNative) {
                        GMAdSlotNative gMAdSlotNative = (GMAdSlotNative) gMAdSlotBase;
                        builderA.setImageAdSize(gMAdSlotNative.getWidth(), gMAdSlotNative.getHeight());
                        builderA.setAdCount(gMAdSlotNative.getAdCount());
                        builderA.setAdStyleType(gMAdSlotNative.getAdStyleType());
                        builderA.setAdmobNativeAdOptions(gMAdSlotNative.getAdmobNativeAdOptions());
                        builderA.setUserID(gMAdSlotNative.getUserID());
                        GMAdSlotGDTOption gMAdSlotGDTOption = gMAdSlotNative.getGMAdSlotGDTOption();
                        if (gMAdSlotGDTOption != null) {
                            builderA.setGdtNativeAdLogoParams(gMAdSlotGDTOption.getNativeAdLogoParams());
                        }
                        adSlotBuild = builderA.build();
                        adSlotBuild.setAdType(5);
                        if (adSlotBuild.getAdCount() <= 3) {
                            if (adSlotBuild.getAdCount() >= 1) {
                                return adSlotBuild;
                            }
                        }
                        adSlotBuild.setAdCount(3);
                        return adSlotBuild;
                    }
                    if (gMAdSlotBase instanceof GMAdSlotDraw) {
                        GMAdSlotDraw gMAdSlotDraw = (GMAdSlotDraw) gMAdSlotBase;
                        builderA.setImageAdSize(gMAdSlotDraw.getWidth(), gMAdSlotDraw.getHeight());
                        builderA.setAdCount(gMAdSlotDraw.getAdCount());
                        adSlotBuild = builderA.build();
                        adSlotBuild.setAdType(9);
                        if (adSlotBuild.getAdCount() <= 3) {
                            if (adSlotBuild.getAdCount() >= 1) {
                                return adSlotBuild;
                            }
                        }
                        adSlotBuild.setAdCount(3);
                        return adSlotBuild;
                    }
                    if (gMAdSlotBase instanceof GMAdSlotBanner) {
                        GMAdSlotBanner gMAdSlotBanner = (GMAdSlotBanner) gMAdSlotBase;
                        builderA.setImageAdSize(gMAdSlotBanner.getWidth(), gMAdSlotBanner.getHeight());
                        builderA.setBannerSize(gMAdSlotBanner.getBannerSize());
                        adSlotBuild = builderA.build();
                        adSlotBuild.setAdType(1);
                    } else {
                        if (!(gMAdSlotBase instanceof GMAdSlotInterstitial)) {
                            return builderA.build();
                        }
                        GMAdSlotInterstitial gMAdSlotInterstitial = (GMAdSlotInterstitial) gMAdSlotBase;
                        builderA.setImageAdSize(gMAdSlotInterstitial.getWidth(), gMAdSlotInterstitial.getHeight());
                        adSlotBuild = builderA.build();
                        i2 = 2;
                    }
                }
                adSlotBuild.setAdCount(1);
                return adSlotBuild;
            }
            GMAdSlotInterstitialFull gMAdSlotInterstitialFull = (GMAdSlotInterstitialFull) gMAdSlotBase;
            builderA.setImageAdSize(gMAdSlotInterstitialFull.getWidth(), gMAdSlotInterstitialFull.getHeight());
            builderA.setUserID(gMAdSlotInterstitialFull.getUserID());
            builderA.setOrientation(gMAdSlotInterstitialFull.getOrientation());
            builderA.setRewardName(gMAdSlotInterstitialFull.getRewardName());
            builderA.setRewardAmount(gMAdSlotInterstitialFull.getRewardAmount());
            builderA.setCustomData(gMAdSlotInterstitialFull.getCustomData());
            adSlotBuild = builderA.build();
            i2 = 10;
        }
        adSlotBuild.setAdType(i2);
        adSlotBuild.setAdCount(1);
        return adSlotBuild;
    }

    public static GMAdSlotBase covertAdSlot2GMAdSlotBase(AdSlot adSlot) {
        int adType = adSlot.getAdType();
        if (adType == 1) {
            return getAdSlotBanner(adSlot);
        }
        if (adType == 2) {
            return getAdSlotInterstitial(adSlot);
        }
        if (adType == 3) {
            return getAdSlotSplash(adSlot);
        }
        if (adType == 5) {
            return getAdSlotNative(adSlot);
        }
        if (adType == 10) {
            return getAdSlotInterstitialFull(adSlot);
        }
        if (adType == 7) {
            return getAdSlotRewardVideo(adSlot);
        }
        if (adType != 8) {
            return null;
        }
        return getAdSlotFullVideo(adSlot);
    }

    public static GMAdSlotBanner getAdSlotBanner(AdSlot adSlot) {
        if (adSlot == null) {
            return null;
        }
        GMAdSlotBanner.Builder downloadType = new GMAdSlotBanner.Builder().setBidNotify(adSlot.isBidNotify()).setTestSlotId(adSlot.getTestSlotId()).setDownloadType(adSlot.getDownloadType());
        for (Map.Entry<String, Object> entry : adSlot.getReuestParam().getExtraObject().entrySet()) {
            downloadType.setExtraObject(entry.getKey(), entry.getValue());
        }
        TTVideoOption tTVideoOption = adSlot.getTTVideoOption();
        if (tTVideoOption != null) {
            downloadType.setMuted(tTVideoOption.isMuted());
            downloadType.setVolume(tTVideoOption.getAdmobAppVolume());
            downloadType.setUseSurfaceView(tTVideoOption.useSurfaceView());
            GDTExtraOption gDTExtraOption = tTVideoOption.getGDTExtraOption();
            if (gDTExtraOption != null) {
                downloadType.setGMAdSlotGDTOption(gDTExtraOption.getGMGDTExtraOption().build());
            }
            BaiduExtraOptions baiduExtraOption = tTVideoOption.getBaiduExtraOption();
            if (baiduExtraOption != null) {
                downloadType.setGMAdSlotBaiduOption(baiduExtraOption.getGMBaiduExtra());
            }
        }
        downloadType.setImageAdSize(adSlot.getImgAcceptedWidth(), adSlot.getImgAcceptedHeight());
        downloadType.setBannerSize(adSlot.getBannerSize());
        downloadType.setUserID(adSlot.getUserID());
        return downloadType.build();
    }

    public static GMAdSlotFullVideo getAdSlotFullVideo(AdSlot adSlot) {
        if (adSlot == null) {
            return null;
        }
        GMAdSlotFullVideo.Builder downloadType = new GMAdSlotFullVideo.Builder().setBidNotify(adSlot.isBidNotify()).setTestSlotId(adSlot.getTestSlotId()).setDownloadType(adSlot.getDownloadType());
        for (Map.Entry<String, Object> entry : adSlot.getReuestParam().getExtraObject().entrySet()) {
            downloadType.setExtraObject(entry.getKey(), entry.getValue());
        }
        TTVideoOption tTVideoOption = adSlot.getTTVideoOption();
        if (tTVideoOption != null) {
            downloadType.setMuted(tTVideoOption.isMuted());
            downloadType.setVolume(tTVideoOption.getAdmobAppVolume());
            downloadType.setUseSurfaceView(tTVideoOption.useSurfaceView());
            GDTExtraOption gDTExtraOption = tTVideoOption.getGDTExtraOption();
            if (gDTExtraOption != null) {
                downloadType.setGMAdSlotGDTOption(gDTExtraOption.getGMGDTExtraOption().build());
            }
            BaiduExtraOptions baiduExtraOption = tTVideoOption.getBaiduExtraOption();
            if (baiduExtraOption != null) {
                downloadType.setGMAdSlotBaiduOption(baiduExtraOption.getGMBaiduExtra());
            }
        }
        if (adSlot.getOrientation() == 2) {
            downloadType.setOrientation(2);
        } else {
            downloadType.setOrientation(1);
        }
        downloadType.setUserID(adSlot.getUserID());
        downloadType.setCustomData(adSlot.getCustomData());
        downloadType.setRewardAmount(adSlot.getRewardAmount());
        downloadType.setRewardName(adSlot.getRewardName());
        return downloadType.build();
    }

    public static GMAdSlotInterstitial getAdSlotInterstitial(AdSlot adSlot) {
        if (adSlot == null) {
            return null;
        }
        GMAdSlotInterstitial.Builder downloadType = new GMAdSlotInterstitial.Builder().setBidNotify(adSlot.isBidNotify()).setTestSlotId(adSlot.getTestSlotId()).setDownloadType(adSlot.getDownloadType());
        for (Map.Entry<String, Object> entry : adSlot.getReuestParam().getExtraObject().entrySet()) {
            downloadType.setExtraObject(entry.getKey(), entry.getValue());
        }
        TTVideoOption tTVideoOption = adSlot.getTTVideoOption();
        if (tTVideoOption != null) {
            downloadType.setMuted(tTVideoOption.isMuted());
            downloadType.setVolume(tTVideoOption.getAdmobAppVolume());
            downloadType.setUseSurfaceView(tTVideoOption.useSurfaceView());
            GDTExtraOption gDTExtraOption = tTVideoOption.getGDTExtraOption();
            if (gDTExtraOption != null) {
                downloadType.setGMAdSlotGDTOption(gDTExtraOption.getGMGDTExtraOption().build());
            }
            BaiduExtraOptions baiduExtraOption = tTVideoOption.getBaiduExtraOption();
            if (baiduExtraOption != null) {
                downloadType.setGMAdSlotBaiduOption(baiduExtraOption.getGMBaiduExtra());
            }
        }
        downloadType.setImageAdSize(adSlot.getImgAcceptedWidth(), adSlot.getImgAcceptedHeight());
        return downloadType.build();
    }

    public static GMAdSlotInterstitialFull getAdSlotInterstitialFull(AdSlot adSlot) {
        if (adSlot == null) {
            return null;
        }
        GMAdSlotInterstitialFull.Builder downloadType = new GMAdSlotInterstitialFull.Builder().setBidNotify(adSlot.isBidNotify()).setTestSlotId(adSlot.getTestSlotId()).setDownloadType(adSlot.getDownloadType());
        for (Map.Entry<String, Object> entry : adSlot.getReuestParam().getExtraObject().entrySet()) {
            downloadType.setExtraObject(entry.getKey(), entry.getValue());
        }
        TTVideoOption tTVideoOption = adSlot.getTTVideoOption();
        if (tTVideoOption != null) {
            downloadType.setMuted(tTVideoOption.isMuted());
            downloadType.setVolume(tTVideoOption.getAdmobAppVolume());
            downloadType.setUseSurfaceView(tTVideoOption.useSurfaceView());
            GDTExtraOption gDTExtraOption = tTVideoOption.getGDTExtraOption();
            if (gDTExtraOption != null) {
                downloadType.setGMAdSlotGDTOption(gDTExtraOption.getGMGDTExtraOption().build());
            }
            BaiduExtraOptions baiduExtraOption = tTVideoOption.getBaiduExtraOption();
            if (baiduExtraOption != null) {
                downloadType.setGMAdSlotBaiduOption(baiduExtraOption.getGMBaiduExtra());
            }
        }
        if (adSlot.getOrientation() == 2) {
            downloadType.setOrientation(2);
        } else {
            downloadType.setOrientation(1);
        }
        downloadType.setImageAdSize(adSlot.getImgAcceptedWidth(), adSlot.getImgAcceptedHeight());
        downloadType.setUserID(adSlot.getUserID());
        downloadType.setCustomData(adSlot.getCustomData());
        downloadType.setRewardAmount(adSlot.getRewardAmount());
        downloadType.setRewardName(adSlot.getRewardName());
        return downloadType.build();
    }

    public static GMAdSlotNative getAdSlotNative(AdSlot adSlot) {
        if (adSlot == null) {
            return null;
        }
        GMAdSlotNative.Builder downloadType = new GMAdSlotNative.Builder().setBidNotify(adSlot.isBidNotify()).setTestSlotId(adSlot.getTestSlotId()).setDownloadType(adSlot.getDownloadType());
        for (Map.Entry<String, Object> entry : adSlot.getReuestParam().getExtraObject().entrySet()) {
            downloadType.setExtraObject(entry.getKey(), entry.getValue());
        }
        TTVideoOption tTVideoOption = adSlot.getTTVideoOption();
        if (tTVideoOption != null) {
            downloadType.setMuted(tTVideoOption.isMuted());
            downloadType.setVolume(tTVideoOption.getAdmobAppVolume());
            downloadType.setUseSurfaceView(tTVideoOption.useSurfaceView());
            GDTExtraOption gDTExtraOption = tTVideoOption.getGDTExtraOption();
            if (gDTExtraOption != null) {
                GMAdSlotGDTOption.Builder gMGDTExtraOption = gDTExtraOption.getGMGDTExtraOption();
                gMGDTExtraOption.setNativeAdLogoParams(adSlot.getGdtNativeAdLogoParams());
                downloadType.setGMAdSlotGDTOption(gMGDTExtraOption.build());
            }
            BaiduExtraOptions baiduExtraOption = tTVideoOption.getBaiduExtraOption();
            if (baiduExtraOption != null) {
                downloadType.setGMAdSlotBaiduOption(baiduExtraOption.getGMBaiduExtra());
            }
        }
        downloadType.setImageAdSize(adSlot.getImgAcceptedWidth(), adSlot.getImgAcceptedHeight());
        downloadType.setAdCount(adSlot.getAdCount());
        downloadType.setAdStyleType(adSlot.getAdStyleType());
        downloadType.setAdmobNativeAdOptions(adSlot.getAdmobNativeAdOptions());
        downloadType.setUserID(adSlot.getUserID());
        return downloadType.build();
    }

    public static GMAdSlotNative getAdSlotNative(AdSlot adSlot, j jVar) {
        if (adSlot == null) {
            return null;
        }
        GMAdSlotNative.Builder downloadType = new GMAdSlotNative.Builder().setBidNotify(adSlot.isBidNotify()).setTestSlotId(adSlot.getTestSlotId()).setDownloadType(adSlot.getDownloadType());
        for (Map.Entry<String, Object> entry : adSlot.getReuestParam().getExtraObject().entrySet()) {
            downloadType.setExtraObject(entry.getKey(), entry.getValue());
        }
        TTVideoOption tTVideoOption = adSlot.getTTVideoOption();
        if (tTVideoOption != null) {
            downloadType.setMuted(tTVideoOption.isMuted());
            downloadType.setVolume(tTVideoOption.getAdmobAppVolume());
            downloadType.setUseSurfaceView(tTVideoOption.useSurfaceView());
            GDTExtraOption gDTExtraOption = tTVideoOption.getGDTExtraOption();
            if (gDTExtraOption != null) {
                GMAdSlotGDTOption.Builder gMGDTExtraOption = gDTExtraOption.getGMGDTExtraOption();
                gMGDTExtraOption.setNativeAdLogoParams(adSlot.getGdtNativeAdLogoParams());
                downloadType.setGMAdSlotGDTOption(gMGDTExtraOption.build());
            }
            BaiduExtraOptions baiduExtraOption = tTVideoOption.getBaiduExtraOption();
            if (baiduExtraOption != null) {
                downloadType.setGMAdSlotBaiduOption(baiduExtraOption.getGMBaiduExtra());
            }
        }
        downloadType.setImageAdSize(adSlot.getImgAcceptedWidth(), adSlot.getImgAcceptedHeight());
        downloadType.setAdCount(adSlot.getAdCount());
        downloadType.setAdStyleType(adSlot.getAdStyleType());
        downloadType.setAdmobNativeAdOptions(adSlot.getAdmobNativeAdOptions());
        downloadType.setUserID(adSlot.getUserID());
        downloadType.setAdStyleType(jVar.s() == 3 ? 1 : 2);
        return downloadType.build();
    }

    public static GMAdSlotRewardVideo getAdSlotRewardVideo(AdSlot adSlot) {
        if (adSlot == null) {
            return null;
        }
        GMAdSlotRewardVideo.Builder downloadType = new GMAdSlotRewardVideo.Builder().setBidNotify(adSlot.isBidNotify()).setTestSlotId(adSlot.getTestSlotId()).setDownloadType(adSlot.getDownloadType());
        for (Map.Entry<String, Object> entry : adSlot.getReuestParam().getExtraObject().entrySet()) {
            downloadType.setExtraObject(entry.getKey(), entry.getValue());
        }
        TTVideoOption tTVideoOption = adSlot.getTTVideoOption();
        if (tTVideoOption != null) {
            downloadType.setMuted(tTVideoOption.isMuted());
            downloadType.setVolume(tTVideoOption.getAdmobAppVolume());
            downloadType.setUseSurfaceView(tTVideoOption.useSurfaceView());
            GDTExtraOption gDTExtraOption = tTVideoOption.getGDTExtraOption();
            if (gDTExtraOption != null) {
                downloadType.setGMAdSlotGDTOption(gDTExtraOption.getGMGDTExtraOption().build());
            }
            BaiduExtraOptions baiduExtraOption = tTVideoOption.getBaiduExtraOption();
            if (baiduExtraOption != null) {
                downloadType.setGMAdSlotBaiduOption(baiduExtraOption.getGMBaiduExtra());
            }
        }
        if (adSlot.getOrientation() == 2) {
            downloadType.setOrientation(2);
        } else {
            downloadType.setOrientation(1);
        }
        downloadType.setUserID(adSlot.getUserID());
        downloadType.setCustomData(adSlot.getCustomData());
        downloadType.setRewardAmount(adSlot.getRewardAmount());
        downloadType.setRewardName(adSlot.getRewardName());
        return downloadType.build();
    }

    public static GMAdSlotSplash getAdSlotSplash(AdSlot adSlot) {
        if (adSlot == null) {
            return null;
        }
        GMAdSlotSplash.Builder forceLoadBottom = new GMAdSlotSplash.Builder().setSplashButtonType(adSlot.getSplashButtonType()).setImageAdSize(adSlot.getImgAcceptedWidth(), adSlot.getImgAcceptedHeight()).setUserID(adSlot.getUserID()).setBidNotify(adSlot.isBidNotify()).setTestSlotId(adSlot.getTestSlotId()).setDownloadType(adSlot.getDownloadType()).setSplashShakeButton(adSlot.getSplashShakeButton()).setForceLoadBottom(adSlot.isForceLoadBottom());
        for (Map.Entry<String, Object> entry : adSlot.getReuestParam().getExtraObject().entrySet()) {
            forceLoadBottom.setExtraObject(entry.getKey(), entry.getValue());
        }
        TTVideoOption tTVideoOption = adSlot.getTTVideoOption();
        if (tTVideoOption != null) {
            forceLoadBottom.setMuted(tTVideoOption.isMuted());
            forceLoadBottom.setVolume(tTVideoOption.getAdmobAppVolume());
            forceLoadBottom.setUseSurfaceView(tTVideoOption.useSurfaceView());
            GDTExtraOption gDTExtraOption = tTVideoOption.getGDTExtraOption();
            if (gDTExtraOption != null) {
                forceLoadBottom.setGMAdSlotGDTOption(gDTExtraOption.getGMGDTExtraOption().build());
                forceLoadBottom.setSplashPreLoad(gDTExtraOption.isSplashPreLoad());
            }
            BaiduExtraOptions baiduExtraOption = tTVideoOption.getBaiduExtraOption();
            if (baiduExtraOption != null) {
                forceLoadBottom.setGMAdSlotBaiduOption(baiduExtraOption.getGMBaiduExtra());
            }
        }
        return forceLoadBottom.build();
    }
}
