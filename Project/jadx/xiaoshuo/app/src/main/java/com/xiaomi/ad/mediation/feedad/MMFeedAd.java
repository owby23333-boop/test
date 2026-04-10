package com.xiaomi.ad.mediation.feedad;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.xiaomi.ad.mediation.MMAdError;
import com.xiaomi.ad.mediation.MMAdImage;
import com.xiaomi.ad.mediation.MMAdSdk;
import com.xiaomi.ad.mediation.MMFilterable;
import com.xiaomi.ad.mediation.internal.loader.AdInternalConfig;
import com.xiaomi.ad.p;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes5.dex */
public abstract class MMFeedAd extends p implements MMFilterable {
    public static final String AD_CONTAINER_TAG = "ad_container_tag";
    public FeedAdAppDownLoadListener mFeedAdAppDownLoadListener;
    public FeedAdInteractionListener mInteractionListener;

    public interface FeedAdAppDownLoadListener {
        void onDownLoadFinished(MMFeedAd mMFeedAd);

        void onDownLoadProgress(MMFeedAd mMFeedAd, int i);

        void onDownloadFailed(MMFeedAd mMFeedAd);

        void onDownloadPause(MMFeedAd mMFeedAd);

        void onIdle(MMFeedAd mMFeedAd);

        void onInstalled(MMFeedAd mMFeedAd);
    }

    public interface FeedAdInteractionListener {
        void onAdClicked(MMFeedAd mMFeedAd);

        void onAdError(MMFeedAd mMFeedAd, MMAdError mMAdError);

        void onAdShown(MMFeedAd mMFeedAd);
    }

    public interface FeedAdVideoListener {
        void onProgressUpdate(long j, long j2);

        void onVideoCompleted();

        void onVideoError(MMAdError mMAdError);

        void onVideoLoaded(int i);

        void onVideoPause();

        void onVideoResume();

        void onVideoStart();
    }

    public MMFeedAd(Context context, AdInternalConfig adInternalConfig) {
        super(context, adInternalConfig);
    }

    public void destroy() {
        setDestroyed(true);
        removeDownloadMonitorHandler();
    }

    public abstract Bitmap getAdLogo();

    @Override // com.xiaomi.ad.p
    public String getAdType() {
        return MMAdSdk.AD_TYPE_FEED;
    }

    public abstract String getAppName();

    public abstract String getAppVersion();

    public abstract String getBrand();

    public abstract String getCTAText();

    public String getCoupon() {
        return "";
    }

    public abstract String getDescription();

    public abstract String getDeveloperName();

    public abstract String getFunctionDescUrl();

    public abstract MMAdImage getIcon();

    public abstract List<MMAdImage> getImageList();

    public abstract int getInteractionType();

    public String getLiveRoom() {
        return "";
    }

    public abstract String getPackageName();

    public abstract int getPatternType();

    public abstract String getPermissionUrl();

    public abstract Map<String, String> getPermissionsMap();

    public abstract String getPrivacyUrl();

    public String getProduct() {
        return "";
    }

    public abstract String getTitle();

    public abstract String getVideoCoverImage();

    public abstract long getVideoDuration();

    public String getVideoUrl() {
        return "";
    }

    public abstract View getVideoView(Context context);

    public boolean isLiveAd() {
        return false;
    }

    @Override // com.xiaomi.ad.mediation.MMFilterable
    public boolean matched(String str) {
        String title = getTitle();
        String description = getDescription();
        return (title != null && title.contains(str)) || (description != null && description.contains(str));
    }

    public void notifyAdClicked() {
        FeedAdInteractionListener feedAdInteractionListener = this.mInteractionListener;
        if (feedAdInteractionListener != null) {
            feedAdInteractionListener.onAdClicked(this);
        }
    }

    public void notifyAdError(MMAdError mMAdError) {
        FeedAdInteractionListener feedAdInteractionListener = this.mInteractionListener;
        if (feedAdInteractionListener != null) {
            feedAdInteractionListener.onAdError(this, mMAdError);
        }
    }

    public void notifyAdShown() {
        FeedAdInteractionListener feedAdInteractionListener = this.mInteractionListener;
        if (feedAdInteractionListener != null) {
            feedAdInteractionListener.onAdShown(this);
        }
    }

    public void notifyAppIdle() {
        FeedAdAppDownLoadListener feedAdAppDownLoadListener = this.mFeedAdAppDownLoadListener;
        if (feedAdAppDownLoadListener != null) {
            feedAdAppDownLoadListener.onIdle(this);
        }
    }

    public void notifyDownloadFailed() {
        FeedAdAppDownLoadListener feedAdAppDownLoadListener = this.mFeedAdAppDownLoadListener;
        if (feedAdAppDownLoadListener != null) {
            feedAdAppDownLoadListener.onDownloadFailed(this);
        }
    }

    public void notifyDownloadFinished() {
        FeedAdAppDownLoadListener feedAdAppDownLoadListener = this.mFeedAdAppDownLoadListener;
        if (feedAdAppDownLoadListener != null) {
            feedAdAppDownLoadListener.onDownLoadFinished(this);
        }
    }

    public void notifyDownloadPause() {
        FeedAdAppDownLoadListener feedAdAppDownLoadListener = this.mFeedAdAppDownLoadListener;
        if (feedAdAppDownLoadListener != null) {
            feedAdAppDownLoadListener.onDownloadPause(this);
        }
    }

    public void notifyDownloadProgress(int i) {
        FeedAdAppDownLoadListener feedAdAppDownLoadListener = this.mFeedAdAppDownLoadListener;
        if (feedAdAppDownLoadListener != null) {
            feedAdAppDownLoadListener.onDownLoadProgress(this, i);
        }
    }

    public void notifyInstalled() {
        FeedAdAppDownLoadListener feedAdAppDownLoadListener = this.mFeedAdAppDownLoadListener;
        if (feedAdAppDownLoadListener != null) {
            feedAdAppDownLoadListener.onInstalled(this);
        }
    }

    public void registerView(Context context, ViewGroup viewGroup, View view, List<View> list, List<View> list2, FrameLayout.LayoutParams layoutParams, FeedAdInteractionListener feedAdInteractionListener, FeedAdVideoListener feedAdVideoListener) {
        this.mInteractionListener = feedAdInteractionListener;
        ViewGroup viewGroup2 = (ViewGroup) viewGroup.findViewWithTag("ad_container_tag");
        if (viewGroup2 != null) {
            ViewGroup.LayoutParams layoutParams2 = viewGroup2.getLayoutParams();
            viewGroup2.removeView(view);
            viewGroup.removeView(viewGroup2);
            viewGroup.addView(view, layoutParams2);
        }
    }

    public void reportVideoAutoStart() {
    }

    public void reportVideoBreak(long j) {
    }

    public void reportVideoContinue(long j) {
    }

    public void reportVideoError(long j, int i, int i2) {
    }

    public void reportVideoFinish() {
    }

    public void reportVideoPause(long j) {
    }

    public void reportVideoStart() {
    }

    public void reportVideoStartError(int i, int i2) {
    }

    public abstract void resume();

    public void setDownLoadListener(FeedAdAppDownLoadListener feedAdAppDownLoadListener) {
        this.mFeedAdAppDownLoadListener = feedAdAppDownLoadListener;
    }
}
