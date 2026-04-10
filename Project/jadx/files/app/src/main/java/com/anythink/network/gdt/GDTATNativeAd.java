package com.anythink.network.gdt;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.anythink.nativead.api.ATNativePrepareExInfo;
import com.anythink.nativead.api.ATNativePrepareInfo;
import com.anythink.nativead.unitgroup.api.CustomNativeAd;
import com.qq.e.ads.cfg.VideoOption;
import com.qq.e.ads.nativ.MediaView;
import com.qq.e.ads.nativ.NativeADEventListenerWithClickInfo;
import com.qq.e.ads.nativ.NativeADMediaListener;
import com.qq.e.ads.nativ.NativeUnifiedADAppMiitInfo;
import com.qq.e.ads.nativ.NativeUnifiedADData;
import com.qq.e.ads.nativ.widget.NativeAdContainer;
import com.qq.e.comm.compliance.DownloadConfirmCallBack;
import com.qq.e.comm.compliance.DownloadConfirmListener;
import com.qq.e.comm.util.AdError;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class GDTATNativeAd extends CustomNativeAd {

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private static final String f12445l = "GDTATNativeAd";
    WeakReference<Context> a;
    Context b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    NativeUnifiedADData f12446c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    int f12447d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    int f12448e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    int f12449f;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    View f12451h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    MediaView f12452i;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    NativeAdContainer f12454k;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    int f12450g = 0;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    boolean f12453j = false;

    /* JADX INFO: renamed from: com.anythink.network.gdt.GDTATNativeAd$2, reason: invalid class name */
    final class AnonymousClass2 extends NativeADEventListenerWithClickInfo {
        final /* synthetic */ NativeUnifiedADData a;

        AnonymousClass2(NativeUnifiedADData nativeUnifiedADData) {
            this.a = nativeUnifiedADData;
        }

        @Override // com.qq.e.ads.nativ.NativeADEventListenerWithClickInfo
        public final void onADClicked(View view) {
            GDTATNativeAd.this.f12451h = view;
            "onADClicked....".concat(String.valueOf(view));
            GDTATNativeAd.this.notifyAdClicked();
        }

        @Override // com.qq.e.ads.nativ.NativeADEventListener
        public final void onADError(AdError adError) {
        }

        @Override // com.qq.e.ads.nativ.NativeADEventListener
        public final void onADExposed() {
            GDTATInitManager.getInstance().a(GDTATNativeAd.this.getShowId(), new WeakReference(this.a));
            GDTATNativeAd.this.notifyAdImpression();
        }

        @Override // com.qq.e.ads.nativ.NativeADEventListener
        public final void onADStatusChanged() {
        }
    }

    protected GDTATNativeAd(Context context, NativeUnifiedADData nativeUnifiedADData, int i2, int i3, int i4) {
        String strValueOf;
        this.b = context.getApplicationContext();
        this.a = new WeakReference<>(context);
        this.f12447d = i2;
        this.f12448e = i3;
        this.f12449f = i4;
        this.f12446c = nativeUnifiedADData;
        NativeUnifiedADData nativeUnifiedADData2 = this.f12446c;
        setTitle(nativeUnifiedADData2.getTitle());
        setDescriptionText(nativeUnifiedADData2.getDesc());
        setIconImageUrl(nativeUnifiedADData2.getIconUrl());
        setStarRating(Double.valueOf(nativeUnifiedADData2.getAppScore()));
        setAppPrice(nativeUnifiedADData2.getAppPrice());
        setCallToActionText(getCallToAction(nativeUnifiedADData2));
        setMainImageUrl(nativeUnifiedADData2.getImgUrl());
        setMainImageWidth(nativeUnifiedADData2.getPictureWidth());
        setMainImageHeight(nativeUnifiedADData2.getPictureHeight());
        setImageUrlList(nativeUnifiedADData2.getImgList());
        double videoDuration = nativeUnifiedADData2.getVideoDuration();
        Double.isNaN(videoDuration);
        setVideoDuration(videoDuration / 1000.0d);
        setNativeInteractionType(nativeUnifiedADData2.isAppAd() ? 1 : 0);
        NativeUnifiedADAppMiitInfo appMiitInfo = nativeUnifiedADData2.getAppMiitInfo();
        if (nativeUnifiedADData2.isAppAd() && appMiitInfo != null) {
            try {
                strValueOf = String.valueOf(nativeUnifiedADData2.getDownloadCount());
            } catch (Exception unused) {
                strValueOf = "";
            }
            setAdAppInfo(new GDTATDownloadAppInfo(appMiitInfo, strValueOf));
        }
        if (nativeUnifiedADData2.getAdPatternType() == 2) {
            this.mAdSourceType = "1";
        } else {
            this.mAdSourceType = "2";
        }
        nativeUnifiedADData2.setNativeAdEventListener(new AnonymousClass2(nativeUnifiedADData2));
        setNetworkInfoMap(nativeUnifiedADData2.getExtraInfo());
    }

    private void a(NativeUnifiedADData nativeUnifiedADData) {
        String strValueOf;
        setTitle(nativeUnifiedADData.getTitle());
        setDescriptionText(nativeUnifiedADData.getDesc());
        setIconImageUrl(nativeUnifiedADData.getIconUrl());
        setStarRating(Double.valueOf(nativeUnifiedADData.getAppScore()));
        setAppPrice(nativeUnifiedADData.getAppPrice());
        setCallToActionText(getCallToAction(nativeUnifiedADData));
        setMainImageUrl(nativeUnifiedADData.getImgUrl());
        setMainImageWidth(nativeUnifiedADData.getPictureWidth());
        setMainImageHeight(nativeUnifiedADData.getPictureHeight());
        setImageUrlList(nativeUnifiedADData.getImgList());
        double videoDuration = nativeUnifiedADData.getVideoDuration();
        Double.isNaN(videoDuration);
        setVideoDuration(videoDuration / 1000.0d);
        setNativeInteractionType(nativeUnifiedADData.isAppAd() ? 1 : 0);
        NativeUnifiedADAppMiitInfo appMiitInfo = nativeUnifiedADData.getAppMiitInfo();
        if (nativeUnifiedADData.isAppAd() && appMiitInfo != null) {
            try {
                strValueOf = String.valueOf(nativeUnifiedADData.getDownloadCount());
            } catch (Exception unused) {
                strValueOf = "";
            }
            setAdAppInfo(new GDTATDownloadAppInfo(appMiitInfo, strValueOf));
        }
        if (nativeUnifiedADData.getAdPatternType() == 2) {
            this.mAdSourceType = "1";
        } else {
            this.mAdSourceType = "2";
        }
        nativeUnifiedADData.setNativeAdEventListener(new AnonymousClass2(nativeUnifiedADData));
        setNetworkInfoMap(nativeUnifiedADData.getExtraInfo());
    }

    @Override // com.anythink.nativead.unitgroup.api.CustomNativeAd, com.anythink.nativead.unitgroup.a
    public void clear(View view) {
        a(view);
    }

    @Override // com.anythink.nativead.unitgroup.api.CustomNativeAd, com.anythink.core.api.BaseAd
    public void destroy() {
        super.destroy();
        NativeUnifiedADData nativeUnifiedADData = this.f12446c;
        if (nativeUnifiedADData != null) {
            nativeUnifiedADData.setNativeAdEventListener(null);
            this.f12446c.destroy();
            this.f12446c = null;
        }
        this.f12452i = null;
        this.b = null;
        WeakReference<Context> weakReference = this.a;
        if (weakReference != null) {
            weakReference.clear();
            this.a = null;
        }
        NativeAdContainer nativeAdContainer = this.f12454k;
        if (nativeAdContainer != null) {
            nativeAdContainer.removeAllViews();
            this.f12454k = null;
        }
    }

    @Override // com.anythink.nativead.unitgroup.api.CustomNativeAd, com.anythink.nativead.unitgroup.a, com.anythink.core.api.IATThirdPartyMaterial
    public View getAdMediaView(Object... objArr) {
        NativeUnifiedADData nativeUnifiedADData = this.f12446c;
        if (nativeUnifiedADData == null) {
            return super.getAdMediaView(objArr);
        }
        if (nativeUnifiedADData.getAdPatternType() != 2) {
            return super.getAdMediaView(objArr);
        }
        if (this.f12452i == null) {
            this.f12452i = new MediaView(this.b);
            this.f12452i.setBackgroundColor(-16777216);
            ViewGroup.LayoutParams layoutParams = this.f12452i.getLayoutParams();
            if (layoutParams == null) {
                layoutParams = new ViewGroup.LayoutParams(-1, -2);
            }
            this.f12452i.setLayoutParams(layoutParams);
        }
        return this.f12452i;
    }

    public String getCallToAction(NativeUnifiedADData nativeUnifiedADData) {
        if (!TextUtils.isEmpty(nativeUnifiedADData.getCTAText())) {
            return nativeUnifiedADData.getCTAText();
        }
        boolean zIsAppAd = nativeUnifiedADData.isAppAd();
        int appStatus = nativeUnifiedADData.getAppStatus();
        return !zIsAppAd ? "浏览" : appStatus != 0 ? appStatus != 1 ? appStatus != 2 ? appStatus != 4 ? appStatus != 8 ? appStatus != 16 ? "浏览" : "下载" : "安装" : "下载" : "更新" : "启动" : "下载";
    }

    @Override // com.anythink.nativead.unitgroup.api.CustomNativeAd, com.anythink.core.api.BaseAd
    public ViewGroup getCustomAdContainer() {
        if (this.f12446c != null) {
            this.f12454k = new NativeAdContainer(this.b);
        }
        return this.f12454k;
    }

    @Override // com.anythink.nativead.unitgroup.api.CustomNativeAd, com.anythink.core.api.IATThirdPartyMaterial
    public double getVideoProgress() {
        NativeUnifiedADData nativeUnifiedADData = this.f12446c;
        if (nativeUnifiedADData == null) {
            return super.getVideoProgress();
        }
        double videoCurrentPosition = nativeUnifiedADData.getVideoCurrentPosition();
        Double.isNaN(videoCurrentPosition);
        return videoCurrentPosition / 1000.0d;
    }

    @Override // com.anythink.nativead.unitgroup.api.CustomNativeAd, com.anythink.nativead.unitgroup.a
    public boolean isNativeExpress() {
        return false;
    }

    @Override // com.anythink.nativead.unitgroup.api.CustomNativeAd, com.anythink.nativead.unitgroup.a
    public void onResume() {
        NativeUnifiedADData nativeUnifiedADData = this.f12446c;
        if (nativeUnifiedADData != null) {
            nativeUnifiedADData.resume();
        }
    }

    @Override // com.anythink.nativead.unitgroup.api.CustomNativeAd, com.anythink.nativead.unitgroup.a
    public void pauseVideo() {
        NativeUnifiedADData nativeUnifiedADData = this.f12446c;
        if (nativeUnifiedADData != null) {
            nativeUnifiedADData.pauseVideo();
        }
    }

    @Override // com.anythink.nativead.unitgroup.api.CustomNativeAd, com.anythink.nativead.unitgroup.a
    public void prepare(View view, ATNativePrepareInfo aTNativePrepareInfo) {
        List<View> creativeClickViewList;
        if (this.f12446c == null || this.f12454k == null) {
            return;
        }
        List<View> clickViewList = aTNativePrepareInfo.getClickViewList();
        if (clickViewList == null || clickViewList.size() == 0) {
            clickViewList = new ArrayList<>();
            a(view, clickViewList);
        }
        List<View> list = clickViewList;
        FrameLayout.LayoutParams choiceViewLayoutParams = aTNativePrepareInfo.getChoiceViewLayoutParams();
        ArrayList arrayList = new ArrayList();
        if ((aTNativePrepareInfo instanceof ATNativePrepareExInfo) && (creativeClickViewList = ((ATNativePrepareExInfo) aTNativePrepareInfo).getCreativeClickViewList()) != null) {
            arrayList.addAll(creativeClickViewList);
        }
        this.f12446c.bindAdToView(view.getContext(), this.f12454k, choiceViewLayoutParams, list, arrayList);
        try {
            if (this.f12452i == null) {
                return;
            }
            this.f12446c.bindMediaView(this.f12452i, new VideoOption.Builder().setAutoPlayMuted(this.f12447d == 1).setDetailPageMuted(this.f12447d == 1).setAutoPlayPolicy(this.f12448e).build(), new NativeADMediaListener() { // from class: com.anythink.network.gdt.GDTATNativeAd.3
                @Override // com.qq.e.ads.nativ.NativeADMediaListener
                public final void onVideoClicked() {
                }

                @Override // com.qq.e.ads.nativ.NativeADMediaListener
                public final void onVideoCompleted() {
                    GDTATNativeAd.this.notifyAdVideoEnd();
                }

                @Override // com.qq.e.ads.nativ.NativeADMediaListener
                public final void onVideoError(AdError adError) {
                    GDTATNativeAd gDTATNativeAd = GDTATNativeAd.this;
                    StringBuilder sb = new StringBuilder();
                    sb.append(adError.getErrorCode());
                    gDTATNativeAd.notifyAdVideoVideoPlayFail(sb.toString(), adError.getErrorMsg());
                }

                @Override // com.qq.e.ads.nativ.NativeADMediaListener
                public final void onVideoInit() {
                }

                @Override // com.qq.e.ads.nativ.NativeADMediaListener
                public final void onVideoLoaded(int i2) {
                }

                @Override // com.qq.e.ads.nativ.NativeADMediaListener
                public final void onVideoLoading() {
                }

                @Override // com.qq.e.ads.nativ.NativeADMediaListener
                public final void onVideoPause() {
                }

                @Override // com.qq.e.ads.nativ.NativeADMediaListener
                public final void onVideoReady() {
                }

                @Override // com.qq.e.ads.nativ.NativeADMediaListener
                public final void onVideoResume() {
                }

                @Override // com.qq.e.ads.nativ.NativeADMediaListener
                public final void onVideoStart() {
                    GDTATNativeAd.this.notifyAdVideoStart();
                }

                @Override // com.qq.e.ads.nativ.NativeADMediaListener
                public final void onVideoStop() {
                }
            });
            if (this.f12450g > 0) {
                this.f12446c.setVideoMute(this.f12450g == 1);
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    @Override // com.anythink.nativead.unitgroup.api.CustomNativeAd
    public void registerDownloadConfirmListener() {
        this.f12446c.setDownloadConfirmListener(new DownloadConfirmListener() { // from class: com.anythink.network.gdt.GDTATNativeAd.1
            @Override // com.qq.e.comm.compliance.DownloadConfirmListener
            public final void onDownloadConfirm(Activity activity, int i2, String str, DownloadConfirmCallBack downloadConfirmCallBack) {
                GDTATNativeAd gDTATNativeAd = GDTATNativeAd.this;
                View view = gDTATNativeAd.f12451h;
                gDTATNativeAd.f12451h = null;
                GDTDownloadFirmInfo gDTDownloadFirmInfo = new GDTDownloadFirmInfo();
                gDTDownloadFirmInfo.appInfoUrl = str;
                gDTDownloadFirmInfo.scenes = i2;
                gDTDownloadFirmInfo.confirmCallBack = downloadConfirmCallBack;
                GDTATNativeAd.this.notifyDownloadConfirm(activity, view, gDTDownloadFirmInfo);
            }
        });
    }

    @Override // com.anythink.nativead.unitgroup.api.CustomNativeAd, com.anythink.nativead.unitgroup.a
    public void resumeVideo() {
        NativeUnifiedADData nativeUnifiedADData = this.f12446c;
        if (nativeUnifiedADData != null) {
            nativeUnifiedADData.resumeVideo();
        }
    }

    @Override // com.anythink.nativead.unitgroup.api.CustomNativeAd, com.anythink.core.api.BaseAd
    public void setVideoMute(boolean z2) {
        this.f12450g = z2 ? 1 : 2;
        NativeUnifiedADData nativeUnifiedADData = this.f12446c;
        if (nativeUnifiedADData != null) {
            nativeUnifiedADData.setVideoMute(z2);
        }
    }

    private void a(View view, List<View> list) {
        if ((view instanceof ViewGroup) && view != this.f12452i) {
            ViewGroup viewGroup = (ViewGroup) view;
            for (int i2 = 0; i2 < viewGroup.getChildCount(); i2++) {
                a(viewGroup.getChildAt(i2), list);
            }
            return;
        }
        list.add(view);
    }

    private void a(View view) {
        if (view == null) {
            return;
        }
        if ((view instanceof ViewGroup) && view != this.f12452i) {
            ViewGroup viewGroup = (ViewGroup) view;
            for (int i2 = 0; i2 < viewGroup.getChildCount(); i2++) {
                a(viewGroup.getChildAt(i2));
            }
            return;
        }
        view.setOnClickListener(null);
        view.setClickable(false);
    }
}
