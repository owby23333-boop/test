package com.xiaomi.ad.mediation.drawad;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.view.View;
import android.view.ViewGroup;
import com.xiaomi.ad.mediation.MMAdSdk;
import com.xiaomi.ad.mediation.MMFilterable;
import com.xiaomi.ad.mediation.internal.loader.AdInternalConfig;
import com.xiaomi.ad.p;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes5.dex */
public abstract class MMDrawAd extends p implements MMFilterable {
    public DrawAdActionListener mDrawAdActionListener;
    public DrawAdListener mDrawAdListener;

    public interface DrawAdActionListener {
        void onAdRegisterCreativeViewClick();

        void onAdShow();

        void onRegisterViewClick();
    }

    public interface DrawAdDownLoadListener {
        void onDownLoadFinished(MMDrawAd mMDrawAd);

        void onDownLoadProgress(MMDrawAd mMDrawAd, int i);

        void onDownloadFailed(MMDrawAd mMDrawAd);

        void onIdle(MMDrawAd mMDrawAd);

        void onInstalled(MMDrawAd mMDrawAd);
    }

    public interface DrawAdListener {
        void onAdClick();

        void onClickRetry();
    }

    public interface DrawVideoAdListener {
        void onProgressUpdate(long j, long j2);

        void onVideoAdComplete();

        void onVideoAdContinuePlay();

        void onVideoAdPaused();

        void onVideoAdStartPlay();

        void onVideoError(int i, int i2);

        void onVideoLoad();
    }

    public MMDrawAd(Context context, AdInternalConfig adInternalConfig) {
        super(context, adInternalConfig);
    }

    public void destroy() {
        setDestroyed(true);
        removeDownloadMonitorHandler();
    }

    public abstract Bitmap getAdLogo();

    @Override // com.xiaomi.ad.p
    public String getAdType() {
        return MMAdSdk.AD_TYPE_DRAW;
    }

    public abstract View getAdView(DrawAdListener drawAdListener);

    public abstract String getAppName();

    public abstract String getAppVersion();

    public abstract String getBrand();

    public abstract String getButtonText();

    public abstract String getDescription();

    public abstract String getDeveloperName();

    public abstract String getFunctionDescUrl();

    public abstract String getIconUrl();

    public abstract int getInteractionType();

    public abstract String getPermissionUrl();

    public abstract Map<String, String> getPermissionsMap();

    public abstract String getPrivacyUrl();

    public abstract String getTitle();

    public abstract String getVideoCoverImage();

    @Override // com.xiaomi.ad.mediation.MMFilterable
    public boolean matched(String str) {
        return true;
    }

    public void notifyAdClickRetry() {
        DrawAdListener drawAdListener = this.mDrawAdListener;
        if (drawAdListener != null) {
            drawAdListener.onClickRetry();
        }
    }

    public void notifyAdRegisterCreativeViewClicked() {
        DrawAdActionListener drawAdActionListener = this.mDrawAdActionListener;
        if (drawAdActionListener != null) {
            drawAdActionListener.onAdRegisterCreativeViewClick();
        }
    }

    public void notifyAdRegisterViewClicked() {
        DrawAdActionListener drawAdActionListener = this.mDrawAdActionListener;
        if (drawAdActionListener != null) {
            drawAdActionListener.onRegisterViewClick();
        }
    }

    public void notifyAdSelfViewClick() {
        DrawAdListener drawAdListener = this.mDrawAdListener;
        if (drawAdListener != null) {
            drawAdListener.onAdClick();
        }
    }

    public void notifyAdShow() {
        DrawAdActionListener drawAdActionListener = this.mDrawAdActionListener;
        if (drawAdActionListener != null) {
            drawAdActionListener.onAdShow();
        }
    }

    public abstract void registerViewForInteraction(ViewGroup viewGroup, DrawAdActionListener drawAdActionListener, List<View> list, List<View> list2);

    public abstract void setActivityForDownloadApp(Activity activity);

    public abstract void setCanInterruptVideoPlay(boolean z);

    public abstract void setDownLoadListener(DrawAdDownLoadListener drawAdDownLoadListener);

    public abstract void setPauseIcon(Bitmap bitmap, int i);

    public abstract void setVideoAdListener(DrawVideoAdListener drawVideoAdListener);
}
