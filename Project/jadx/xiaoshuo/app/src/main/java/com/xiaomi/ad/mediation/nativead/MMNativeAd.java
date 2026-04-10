package com.xiaomi.ad.mediation.nativead;

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
public abstract class MMNativeAd extends p implements MMFilterable {
    public static final String AD_CONTAINER_TAG = "ad_container_tag";
    public NativeAdInteractionListener mInteractionListener;

    public interface NativeAdInteractionListener {
        void onAdClicked(MMNativeAd mMNativeAd);

        void onAdError(MMNativeAd mMNativeAd, MMAdError mMAdError);

        void onAdShown(MMNativeAd mMNativeAd);
    }

    public interface NativeAdVideoListener {
        void onVideoClicked();

        void onVideoCompleted();

        void onVideoError(MMAdError mMAdError);

        void onVideoInit();

        void onVideoLoaded(int i);

        void onVideoLoading();

        void onVideoPause();

        void onVideoReady();

        void onVideoResume();

        void onVideoStart();

        void onVideoStop();
    }

    public MMNativeAd(Context context, AdInternalConfig adInternalConfig) {
        super(context, adInternalConfig);
    }

    public abstract void destroy();

    public abstract Bitmap getAdLogo();

    @Override // com.xiaomi.ad.p
    public String getAdType() {
        return MMAdSdk.AD_TYPE_NATIVE;
    }

    public abstract String getAppName();

    public abstract String getAppVersion();

    public abstract String getCTAText();

    public abstract String getDescription();

    public abstract String getDeveloperName();

    public abstract String getFunctionDescUrl();

    public abstract MMAdImage getIcon();

    public abstract List<MMAdImage> getImageList();

    public abstract int getInteractionType();

    public abstract int getPatternType();

    public abstract String getPermissionUrl();

    public abstract Map<String, String> getPermissionsMap();

    public abstract String getPrivacyUrl();

    public abstract String getTitle();

    public abstract String getVideoCoverImage();

    public abstract View getVideoView(Context context);

    @Override // com.xiaomi.ad.mediation.MMFilterable
    public boolean matched(String str) {
        String title = getTitle();
        String description = getDescription();
        return (title != null && title.contains(str)) || (description != null && description.contains(str));
    }

    public void notifyAdClicked() {
        NativeAdInteractionListener nativeAdInteractionListener = this.mInteractionListener;
        if (nativeAdInteractionListener != null) {
            nativeAdInteractionListener.onAdClicked(this);
        }
    }

    public void notifyAdError(MMAdError mMAdError) {
        NativeAdInteractionListener nativeAdInteractionListener = this.mInteractionListener;
        if (nativeAdInteractionListener != null) {
            nativeAdInteractionListener.onAdError(this, mMAdError);
        }
    }

    public void notifyAdShown() {
        NativeAdInteractionListener nativeAdInteractionListener = this.mInteractionListener;
        if (nativeAdInteractionListener != null) {
            nativeAdInteractionListener.onAdShown(this);
        }
    }

    public void registerView(Context context, ViewGroup viewGroup, View view, List<View> list, List<View> list2, FrameLayout.LayoutParams layoutParams, NativeAdInteractionListener nativeAdInteractionListener, NativeAdVideoListener nativeAdVideoListener) {
        this.mInteractionListener = nativeAdInteractionListener;
        ViewGroup viewGroup2 = (ViewGroup) viewGroup.findViewWithTag("ad_container_tag");
        if (viewGroup2 != null) {
            ViewGroup.LayoutParams layoutParams2 = viewGroup2.getLayoutParams();
            viewGroup2.removeView(view);
            viewGroup.removeView(viewGroup2);
            viewGroup.addView(view, layoutParams2);
        }
    }
}
