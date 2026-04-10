package com.xiaomi.ad.mediation.internal.loader;

import android.app.Activity;
import android.view.ViewGroup;
import com.xiaomi.ad.mediation.MMAdConfig;

/* JADX INFO: loaded from: classes5.dex */
public class AdInternalConfig extends MMAdConfig {
    public String adPositionId;
    public String dcid;
    public String extraParameters;
    public boolean isExpress;
    public String tagId;
    public long timeout;
    public String triggerId;

    public AdInternalConfig(MMAdConfig mMAdConfig) {
        this.adCount = mMAdConfig.adCount;
        this.imageWidth = mMAdConfig.imageWidth;
        this.imageHeight = mMAdConfig.imageHeight;
        this.viewWidth = mMAdConfig.viewWidth;
        this.viewHeight = mMAdConfig.viewHeight;
        this.videoOrientation = mMAdConfig.videoOrientation;
        this.supportDeeplink = mMAdConfig.supportDeeplink;
        this.videoAutoPlayPolicy = mMAdConfig.videoAutoPlayPolicy;
        this.videoADContainerRender = mMAdConfig.videoADContainerRender;
        this.videoAutoPlayMuted = mMAdConfig.videoAutoPlayMuted;
        this.videoNeedCoverImage = mMAdConfig.videoNeedCoverImage;
        this.videoNeedProgressBar = mMAdConfig.videoNeedProgressBar;
        this.videoEnableDetailPage = mMAdConfig.videoEnableDetailPage;
        this.videoEnableUserControl = mMAdConfig.videoEnableUserControl;
        this.videoEnableLoop = mMAdConfig.videoEnableLoop;
        this.nativeAdType = mMAdConfig.nativeAdType;
        this.splashAdTimeOut = mMAdConfig.splashAdTimeOut;
        this.sloganColor = mMAdConfig.sloganColor;
        this.channelId = mMAdConfig.channelId;
        this.preRoll = mMAdConfig.preRoll;
        this.interstitialType = mMAdConfig.interstitialType;
        Activity splashActivity = mMAdConfig.getSplashActivity();
        if (splashActivity != null) {
            setSplashActivity(splashActivity);
        }
        ViewGroup splashContainer = mMAdConfig.getSplashContainer();
        if (splashContainer != null) {
            setSplashContainer(splashContainer);
        }
        Activity insertActivity = mMAdConfig.getInsertActivity();
        if (insertActivity != null) {
            setInsertActivity(insertActivity);
        }
        ViewGroup bannerContainer = mMAdConfig.getBannerContainer();
        if (bannerContainer != null) {
            setBannerContainer(bannerContainer);
        }
        Activity bannerActivity = mMAdConfig.getBannerActivity();
        if (bannerActivity != null) {
            setBannerActivity(bannerActivity);
        }
        Activity rewardVideoActivity = mMAdConfig.getRewardVideoActivity();
        if (rewardVideoActivity != null) {
            setRewardVideoActivity(rewardVideoActivity);
        }
        ViewGroup templateContainer = mMAdConfig.getTemplateContainer();
        if (templateContainer != null) {
            setTemplateContainer(templateContainer);
        }
        Activity feedActivity = mMAdConfig.getFeedActivity();
        if (feedActivity != null) {
            setFeedActivity(feedActivity);
        }
    }
}
