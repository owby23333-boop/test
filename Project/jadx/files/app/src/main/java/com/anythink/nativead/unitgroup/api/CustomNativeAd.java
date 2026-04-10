package com.anythink.nativead.unitgroup.api;

import android.graphics.Bitmap;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.anythink.core.api.ATAdAppInfo;
import com.anythink.core.api.ATCustomVideo;
import com.anythink.nativead.api.ATNativePrepareInfo;
import com.anythink.nativead.unitgroup.a;
import com.bytedance.msdk.adapter.pangle.PangleAdapterUtils;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public class CustomNativeAd extends a {
    public static String IS_AUTO_PLAY_KEY = "is_auto_play";
    static final double MAX_STAR_RATING = 5.0d;
    static final double MIN_STAR_RATING = 0.0d;
    private ATAdAppInfo adAppInfo;
    private View adLogoView;
    private String mAdChoiceIconUrl;
    private String mAdFrom;
    private String mAdvertiserName;
    private int mAppCommentNum;
    private View mAppDownloadButton;
    private double mAppPrice;
    private String mCallToAction;
    private String mClickDestinationUrl;
    private View.OnClickListener mCloseViewListener;
    private String mDomain;
    private String mIconImageUrl;
    private List<String> mImageUrlList;
    private int mMainImageHeight;
    private String mMainImageUrl;
    private int mMainImageWidth;
    private int mNativeExpressHeight;
    private int mNativeExpressWidth;
    private Map<String, Object> mNetworkInfoMap;
    private String mText;
    private String mTitle;
    private int mVideoHeight;
    private String mVideoUrl;
    private int mVideoWidth;
    private String mWarning;
    private String showId;
    private double videoDuration;
    private Double mStarRating = Double.valueOf(PangleAdapterUtils.CPM_DEFLAUT_VALUE);
    private int nInteractionType = 0;

    public class NativeAdConst {
        public static final String IMAGE_TYPE = "2";
        public static final String UNKNOWN_TYPE = "0";
        public static final String VIDEO_TYPE = "1";

        public NativeAdConst() {
        }
    }

    public class NativeType {
        public static final int FEED = 1;
        public static final int PATCH = 2;

        public NativeType() {
        }
    }

    @Override // com.anythink.nativead.unitgroup.a
    public final void bindDislikeListener(View.OnClickListener onClickListener) {
        View closeView;
        this.mCloseViewListener = onClickListener;
        ATNativePrepareInfo nativePrepareInfo = getNativePrepareInfo();
        if (nativePrepareInfo == null || (closeView = nativePrepareInfo.getCloseView()) == null) {
            return;
        }
        closeView.setOnClickListener(this.mCloseViewListener);
    }

    public final boolean checkHasCloseViewListener() {
        return this.mCloseViewListener != null;
    }

    @Override // com.anythink.nativead.unitgroup.a
    public void clear(View view) {
    }

    @Override // com.anythink.core.api.BaseAd
    public void destroy() {
        this.mCloseViewListener = null;
    }

    @Override // com.anythink.core.api.IATThirdPartyMaterial
    public ATAdAppInfo getAdAppInfo() {
        return this.adAppInfo;
    }

    @Override // com.anythink.core.api.IATThirdPartyMaterial
    public final String getAdChoiceIconUrl() {
        return this.mAdChoiceIconUrl;
    }

    @Override // com.anythink.core.api.IATThirdPartyMaterial
    public String getAdFrom() {
        return this.mAdFrom;
    }

    @Override // com.anythink.nativead.unitgroup.a, com.anythink.core.api.IATThirdPartyMaterial
    public View getAdIconView() {
        return null;
    }

    @Override // com.anythink.core.api.IATThirdPartyMaterial
    public Bitmap getAdLogo() {
        return null;
    }

    @Override // com.anythink.core.api.IATThirdPartyMaterial
    public final View getAdLogoView() {
        return this.adLogoView;
    }

    @Override // com.anythink.nativead.unitgroup.a, com.anythink.core.api.IATThirdPartyMaterial
    public View getAdMediaView(Object... objArr) {
        return null;
    }

    @Override // com.anythink.core.api.IATThirdPartyMaterial
    public String getAdvertiserName() {
        return this.mAdvertiserName;
    }

    @Override // com.anythink.core.api.IATThirdPartyMaterial
    public int getAppCommentNum() {
        return this.mAppCommentNum;
    }

    @Override // com.anythink.core.api.IATThirdPartyMaterial
    public View getAppDownloadButton() {
        return this.mAppDownloadButton;
    }

    @Override // com.anythink.core.api.IATThirdPartyMaterial
    public double getAppPrice() {
        return this.mAppPrice;
    }

    @Override // com.anythink.core.api.IATThirdPartyMaterial
    public String getCallToActionText() {
        return this.mCallToAction;
    }

    @Override // com.anythink.core.api.BaseAd
    public ViewGroup getCustomAdContainer() {
        return null;
    }

    @Override // com.anythink.core.api.IATThirdPartyMaterial
    public String getDescriptionText() {
        return this.mText;
    }

    @Override // com.anythink.core.api.IATThirdPartyMaterial
    public String getDomain() {
        return this.mDomain;
    }

    @Override // com.anythink.core.api.IATThirdPartyMaterial
    public String getIconImageUrl() {
        return this.mIconImageUrl;
    }

    @Override // com.anythink.core.api.IATThirdPartyMaterial
    public final List<String> getImageUrlList() {
        return this.mImageUrlList;
    }

    @Override // com.anythink.core.api.IATThirdPartyMaterial
    public int getMainImageHeight() {
        int i2 = this.mMainImageHeight;
        if (i2 > 0) {
            return i2;
        }
        return -1;
    }

    @Override // com.anythink.core.api.IATThirdPartyMaterial
    public String getMainImageUrl() {
        return this.mMainImageUrl;
    }

    @Override // com.anythink.core.api.IATThirdPartyMaterial
    public int getMainImageWidth() {
        int i2 = this.mMainImageWidth;
        if (i2 > 0) {
            return i2;
        }
        return -1;
    }

    @Override // com.anythink.core.api.IATThirdPartyMaterial
    public int getNativeAdInteractionType() {
        return this.nInteractionType;
    }

    @Override // com.anythink.core.api.IATThirdPartyMaterial
    public ATCustomVideo getNativeCustomVideo() {
        return null;
    }

    @Override // com.anythink.core.api.IATThirdPartyMaterial
    public int getNativeExpressHeight() {
        int i2 = this.mNativeExpressHeight;
        if (i2 > 0) {
            return i2;
        }
        return -1;
    }

    @Override // com.anythink.core.api.IATThirdPartyMaterial
    public int getNativeExpressWidth() {
        int i2 = this.mNativeExpressWidth;
        if (i2 > 0) {
            return i2;
        }
        return -1;
    }

    @Override // com.anythink.core.api.IATThirdPartyMaterial
    public int getNativeType() {
        return 1;
    }

    @Override // com.anythink.core.api.BaseAd, com.anythink.core.api.IATThirdPartyMaterial
    public final Map<String, Object> getNetworkInfoMap() {
        return this.mNetworkInfoMap;
    }

    public final String getShowId() {
        return this.showId;
    }

    @Override // com.anythink.core.api.IATThirdPartyMaterial
    public final Double getStarRating() {
        return this.mStarRating;
    }

    @Override // com.anythink.core.api.IATThirdPartyMaterial
    public String getTitle() {
        return this.mTitle;
    }

    @Override // com.anythink.core.api.IATThirdPartyMaterial
    public double getVideoDuration() {
        return this.videoDuration;
    }

    @Override // com.anythink.core.api.IATThirdPartyMaterial
    public int getVideoHeight() {
        int i2 = this.mVideoHeight;
        if (i2 > 0) {
            return i2;
        }
        return -1;
    }

    @Override // com.anythink.core.api.IATThirdPartyMaterial
    public double getVideoProgress() {
        return PangleAdapterUtils.CPM_DEFLAUT_VALUE;
    }

    @Override // com.anythink.core.api.IATThirdPartyMaterial
    public final String getVideoUrl() {
        return this.mVideoUrl;
    }

    @Override // com.anythink.core.api.IATThirdPartyMaterial
    public int getVideoWidth() {
        int i2 = this.mVideoWidth;
        if (i2 > 0) {
            return i2;
        }
        return -1;
    }

    @Override // com.anythink.core.api.IATThirdPartyMaterial
    public String getWarning() {
        return this.mWarning;
    }

    public void impressionTrack(View view) {
    }

    @Override // com.anythink.nativead.unitgroup.a
    public boolean isNativeExpress() {
        return false;
    }

    @Override // com.anythink.nativead.unitgroup.a
    public void onPause() {
    }

    @Override // com.anythink.nativead.unitgroup.a
    public void onResume() {
    }

    @Override // com.anythink.nativead.unitgroup.a
    public void pauseVideo() {
    }

    @Override // com.anythink.nativead.unitgroup.a
    public void prepare(View view, ATNativePrepareInfo aTNativePrepareInfo) {
    }

    public void registerDownloadConfirmListener() {
    }

    @Override // com.anythink.core.api.BaseAd
    public void registerListener(View view, List<View> list, FrameLayout.LayoutParams layoutParams) {
        ATNativePrepareInfo aTNativePrepareInfo = new ATNativePrepareInfo();
        aTNativePrepareInfo.setClickViewList(list);
        aTNativePrepareInfo.setChoiceViewLayoutParams(layoutParams);
        prepare(view, aTNativePrepareInfo);
    }

    @Override // com.anythink.nativead.unitgroup.a
    public void resumeVideo() {
    }

    public final void setAdAppInfo(ATAdAppInfo aTAdAppInfo) {
        this.adAppInfo = aTAdAppInfo;
    }

    public final void setAdChoiceIconUrl(String str) {
        this.mAdChoiceIconUrl = str;
    }

    public final void setAdFrom(String str) {
        this.mAdFrom = str;
    }

    public final void setAdLogoView(View view) {
        this.adLogoView = view;
    }

    public void setAdvertiserName(String str) {
        this.mAdvertiserName = str;
    }

    public void setAppCommentNum(int i2) {
        this.mAppCommentNum = i2;
    }

    public void setAppDownloadButton(View view) {
        this.mAppDownloadButton = view;
    }

    public void setAppPrice(double d2) {
        this.mAppPrice = d2;
    }

    public final void setCallToActionText(String str) {
        this.mCallToAction = str;
    }

    public final void setDescriptionText(String str) {
        this.mText = str;
    }

    public final void setDomain(String str) {
        this.mDomain = str;
    }

    public final void setIconImageUrl(String str) {
        this.mIconImageUrl = str;
    }

    public final void setImageUrlList(List<String> list) {
        this.mImageUrlList = list;
    }

    public void setMainImageHeight(int i2) {
        this.mMainImageHeight = i2;
    }

    public final void setMainImageUrl(String str) {
        this.mMainImageUrl = str;
    }

    public void setMainImageWidth(int i2) {
        this.mMainImageWidth = i2;
    }

    public void setNativeExpressHeight(int i2) {
        this.mNativeExpressHeight = i2;
    }

    public void setNativeExpressWidth(int i2) {
        this.mNativeExpressWidth = i2;
    }

    public final void setNativeInteractionType(int i2) {
        this.nInteractionType = i2;
    }

    @Override // com.anythink.core.api.BaseAd
    public final void setNetworkInfoMap(Map<String, Object> map) {
        this.mNetworkInfoMap = map;
    }

    public final void setShowId(String str) {
        this.showId = str;
    }

    public final void setStarRating(Double d2) {
        if (d2 == null) {
            this.mStarRating = null;
        } else {
            if (d2.doubleValue() < PangleAdapterUtils.CPM_DEFLAUT_VALUE || d2.doubleValue() > MAX_STAR_RATING) {
                return;
            }
            this.mStarRating = d2;
        }
    }

    public final void setTitle(String str) {
        this.mTitle = str;
    }

    public final void setVideoDuration(double d2) {
        this.videoDuration = d2;
    }

    public void setVideoHeight(int i2) {
        this.mVideoHeight = i2;
    }

    @Override // com.anythink.core.api.BaseAd
    public void setVideoMute(boolean z2) {
    }

    public final void setVideoUrl(String str) {
        this.mVideoUrl = str;
    }

    public void setVideoWidth(int i2) {
        this.mVideoWidth = i2;
    }

    public final void setWarning(String str) {
        this.mWarning = str;
    }

    public void unregeisterDownloadConfirmListener() {
    }
}
