package com.xiaomi.ad.mediation;

import android.app.Activity;
import android.view.ViewGroup;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: classes5.dex */
public class MMAdConfig {
    public static final int TYPE_BANNER = 1;
    public static final int TYPE_INTERACTION_AD = 2;
    public static final int VIDEO_CONTAINER_RENDER_DEV = 2;
    public static final int VIDEO_CONTAINER_RENDER_SDK = 1;
    public static final int VIDEO_OPTION_AUTO_PLAY = 0;
    public static final int VIDEO_OPTION_AUTO_PLAY_NEVER = 2;
    public static final int VIDEO_OPTION_AUTO_PLAY_WIFI = 1;
    public String channelId;
    public int imageHeight;
    public int imageWidth;
    public String interstitialType;
    public WeakReference<Activity> mBannerActivity;
    public WeakReference<ViewGroup> mBannerAdContainer;
    public WeakReference<Activity> mFeedActivity;
    public WeakReference<Activity> mInsertActivity;
    public WeakReference<Activity> mRewardVideoActivity;
    public WeakReference<Activity> mSplashActivity;
    public WeakReference<ViewGroup> mSplashAdContainer;
    public WeakReference<ViewGroup> mTemplateContainer;
    public int rewardCount;
    public String rewardName;
    public int sloganColor;
    public String userId;
    public int viewHeight;
    public int viewWidth;
    public int videoAutoPlayPolicy = 1;
    public boolean videoAutoPlayMuted = true;
    public boolean videoNeedCoverImage = true;
    public boolean videoNeedProgressBar = true;
    public boolean videoEnableDetailPage = true;
    public boolean videoEnableUserControl = false;
    public boolean videoEnableLoop = false;
    public int videoADContainerRender = 1;
    public int nativeAdType = 1;
    public int splashAdTimeOut = 3000;
    public boolean preRoll = false;
    public int adCount = 1;
    public Orientation videoOrientation = Orientation.ORIENTATION_HORIZONTAL;
    public boolean supportDeeplink = false;

    public enum Orientation {
        ORIENTATION_HORIZONTAL,
        ORIENTATION_VERTICAL
    }

    public Activity getBannerActivity() {
        WeakReference<Activity> weakReference = this.mBannerActivity;
        if (weakReference != null) {
            return weakReference.get();
        }
        return null;
    }

    public ViewGroup getBannerContainer() {
        WeakReference<ViewGroup> weakReference = this.mBannerAdContainer;
        if (weakReference != null) {
            return weakReference.get();
        }
        return null;
    }

    public Activity getFeedActivity() {
        WeakReference<Activity> weakReference = this.mFeedActivity;
        if (weakReference != null) {
            return weakReference.get();
        }
        return null;
    }

    public Activity getInsertActivity() {
        WeakReference<Activity> weakReference = this.mInsertActivity;
        if (weakReference != null) {
            return weakReference.get();
        }
        return null;
    }

    public Activity getRewardVideoActivity() {
        WeakReference<Activity> weakReference = this.mRewardVideoActivity;
        if (weakReference != null) {
            return weakReference.get();
        }
        return null;
    }

    public Activity getSplashActivity() {
        WeakReference<Activity> weakReference = this.mSplashActivity;
        if (weakReference != null) {
            return weakReference.get();
        }
        return null;
    }

    public ViewGroup getSplashContainer() {
        WeakReference<ViewGroup> weakReference = this.mSplashAdContainer;
        if (weakReference != null) {
            return weakReference.get();
        }
        return null;
    }

    public ViewGroup getTemplateContainer() {
        WeakReference<ViewGroup> weakReference = this.mTemplateContainer;
        if (weakReference != null) {
            return weakReference.get();
        }
        return null;
    }

    public void setBannerActivity(Activity activity) {
        this.mBannerActivity = new WeakReference<>(activity);
    }

    public void setBannerContainer(ViewGroup viewGroup) {
        this.mBannerAdContainer = new WeakReference<>(viewGroup);
    }

    public void setFeedActivity(Activity activity) {
        this.mFeedActivity = new WeakReference<>(activity);
    }

    public void setInsertActivity(Activity activity) {
        this.mInsertActivity = new WeakReference<>(activity);
    }

    public void setRewardVideoActivity(Activity activity) {
        this.mRewardVideoActivity = new WeakReference<>(activity);
    }

    public void setSplashActivity(Activity activity) {
        this.mSplashActivity = new WeakReference<>(activity);
    }

    public void setSplashContainer(ViewGroup viewGroup) {
        this.mSplashAdContainer = new WeakReference<>(viewGroup);
    }

    public void setTemplateContainer(ViewGroup viewGroup) {
        this.mTemplateContainer = new WeakReference<>(viewGroup);
    }
}
