package com.anythink.network.toutiao;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.view.View;
import android.view.ViewGroup;
import com.anythink.china.api.CustomAdapterDownloadListener;
import com.anythink.core.api.ATCustomVideo;
import com.anythink.nativead.api.ATNativePrepareInfo;
import com.anythink.nativead.unitgroup.api.CustomNativeAd;
import com.bytedance.msdk.adapter.pangle.PangleAdapterUtils;
import com.bytedance.sdk.openadsdk.ComplianceInfo;
import com.bytedance.sdk.openadsdk.TTAdDislike;
import com.bytedance.sdk.openadsdk.TTAppDownloadListener;
import com.bytedance.sdk.openadsdk.TTDrawFeedAd;
import com.bytedance.sdk.openadsdk.TTFeedAd;
import com.bytedance.sdk.openadsdk.TTImage;
import com.bytedance.sdk.openadsdk.TTNativeAd;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class TTATNativeAd extends CustomNativeAd {
    TTNativeAd a;
    Context b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    String f12674c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    boolean f12675d = false;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    TTATCustomVideo f12676e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    double f12677f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    View f12678g;

    /* JADX INFO: renamed from: com.anythink.network.toutiao.TTATNativeAd$3, reason: invalid class name */
    final class AnonymousClass3 implements View.OnClickListener {
        final /* synthetic */ Activity a;

        AnonymousClass3(Activity activity) {
            this.a = activity;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            TTNativeAd tTNativeAd = TTATNativeAd.this.a;
            if (tTNativeAd == null) {
                return;
            }
            TTAdDislike dislikeDialog = tTNativeAd.getDislikeDialog(this.a);
            dislikeDialog.setDislikeInteractionCallback(new TTAdDislike.DislikeInteractionCallback() { // from class: com.anythink.network.toutiao.TTATNativeAd.3.1
                @Override // com.bytedance.sdk.openadsdk.TTAdDislike.DislikeInteractionCallback
                public final void onCancel() {
                }

                @Deprecated
                public final void onRefuse() {
                }

                @Override // com.bytedance.sdk.openadsdk.TTAdDislike.DislikeInteractionCallback
                public final void onSelected(int i2, String str, boolean z2) {
                    TTATNativeAd.this.notifyAdDislikeClick();
                }

                @Override // com.bytedance.sdk.openadsdk.TTAdDislike.DislikeInteractionCallback
                public final void onShow() {
                }

                @Deprecated
                public final void onSelected(int i2, String str) {
                    TTATNativeAd.this.notifyAdDislikeClick();
                }
            });
            if (dislikeDialog.isShow()) {
                return;
            }
            dislikeDialog.showDislikeDialog();
        }
    }

    private class a implements TTNativeAd.AdInteractionListener {
        private a() {
        }

        @Override // com.bytedance.sdk.openadsdk.TTNativeAd.AdInteractionListener
        public final void onAdClicked(View view, TTNativeAd tTNativeAd) {
            TTATNativeAd.this.notifyAdClicked();
        }

        @Override // com.bytedance.sdk.openadsdk.TTNativeAd.AdInteractionListener
        public final void onAdCreativeClick(View view, TTNativeAd tTNativeAd) {
            TTATNativeAd.this.notifyAdClicked();
        }

        @Override // com.bytedance.sdk.openadsdk.TTNativeAd.AdInteractionListener
        public final void onAdShow(TTNativeAd tTNativeAd) {
            TTATInitManager.getInstance().a(TTATNativeAd.this.getShowId(), new WeakReference(tTNativeAd));
            TTATNativeAd.this.notifyAdImpression();
        }

        /* synthetic */ a(TTATNativeAd tTATNativeAd, byte b) {
            this();
        }
    }

    public TTATNativeAd(Context context, String str, TTNativeAd tTNativeAd, boolean z2, Bitmap bitmap, int i2) {
        this.b = context.getApplicationContext();
        this.f12674c = str;
        this.a = tTNativeAd;
        setNetworkInfoMap(this.a.getMediaExtraInfo());
        setAdData(z2, bitmap, i2);
    }

    @Override // com.anythink.nativead.unitgroup.api.CustomNativeAd, com.anythink.nativead.unitgroup.a
    public void clear(View view) {
        a(view);
    }

    @Override // com.anythink.nativead.unitgroup.api.CustomNativeAd, com.anythink.core.api.BaseAd
    public void destroy() {
        try {
            if (this.a != null) {
                this.a.setActivityForDownloadApp(null);
            }
        } catch (Exception unused) {
        }
        this.b = null;
        this.a = null;
    }

    @Override // com.anythink.nativead.unitgroup.api.CustomNativeAd, com.anythink.core.api.IATThirdPartyMaterial
    public Bitmap getAdLogo() {
        try {
            if (this.a != null) {
                return this.a.getAdLogo();
            }
            return null;
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }

    @Override // com.anythink.nativead.unitgroup.api.CustomNativeAd, com.anythink.nativead.unitgroup.a, com.anythink.core.api.IATThirdPartyMaterial
    public View getAdMediaView(Object... objArr) {
        if (this.f12678g == null) {
            this.f12678g = this.a.getAdView();
        }
        return this.f12678g;
    }

    @Override // com.anythink.nativead.unitgroup.api.CustomNativeAd, com.anythink.core.api.IATThirdPartyMaterial
    public ATCustomVideo getNativeCustomVideo() {
        return this.f12676e;
    }

    @Override // com.anythink.nativead.unitgroup.api.CustomNativeAd, com.anythink.core.api.IATThirdPartyMaterial
    public double getVideoProgress() {
        return this.f12677f;
    }

    @Override // com.anythink.nativead.unitgroup.api.CustomNativeAd, com.anythink.nativead.unitgroup.a
    public void prepare(View view, ATNativePrepareInfo aTNativePrepareInfo) {
        List<View> clickViewList = aTNativePrepareInfo.getClickViewList();
        if (clickViewList == null || clickViewList.size() == 0) {
            clickViewList = new ArrayList<>();
            a(clickViewList, view);
        }
        a aVar = new a(this, (byte) 0);
        if (clickViewList.size() > 0) {
            this.a.registerViewForInteraction((ViewGroup) view, clickViewList, clickViewList, aVar);
        } else {
            this.a.registerViewForInteraction((ViewGroup) view, view, aVar);
        }
        if (view.getContext() instanceof Activity) {
            this.a.setActivityForDownloadApp((Activity) view.getContext());
            bindDislikeListener(new AnonymousClass3((Activity) view.getContext()));
        }
    }

    public void setAdData(boolean z2, Bitmap bitmap, int i2) {
        setTitle(this.a.getTitle());
        setDescriptionText(this.a.getDescription());
        setAdFrom(this.a.getSource());
        setStarRating(Double.valueOf(this.a.getAppScore()));
        setAppCommentNum(this.a.getAppCommentNum());
        TTImage icon = this.a.getIcon();
        if (icon != null) {
            setIconImageUrl(icon.getImageUrl());
        }
        List<TTImage> imageList = this.a.getImageList();
        ArrayList arrayList = new ArrayList();
        if (imageList != null && imageList.size() > 0) {
            for (int i3 = 0; i3 < imageList.size(); i3++) {
                TTImage tTImage = imageList.get(i3);
                if (tTImage != null) {
                    arrayList.add(tTImage.getImageUrl());
                    if (i3 == 0) {
                        setMainImageUrl(tTImage.getImageUrl());
                        setMainImageWidth(tTImage.getWidth());
                        setMainImageHeight(tTImage.getHeight());
                    }
                }
            }
        }
        setImageUrlList(arrayList);
        setCallToActionText(this.a.getButtonText());
        TTNativeAd tTNativeAd = this.a;
        if (tTNativeAd instanceof TTDrawFeedAd) {
            TTFeedAd.CustomizeVideo customVideo = ((TTDrawFeedAd) tTNativeAd).getCustomVideo();
            if (customVideo != null) {
                setVideoUrl(customVideo.getVideoUrl());
                this.f12676e = new TTATCustomVideo(customVideo);
            }
            ((TTDrawFeedAd) this.a).setCanInterruptVideoPlay(z2);
            if (bitmap != null && i2 > 0) {
                ((TTDrawFeedAd) this.a).setPauseIcon(bitmap, i2);
            }
        }
        ComplianceInfo complianceInfo = this.a.getComplianceInfo();
        if (complianceInfo != null) {
            setAdAppInfo(new TTATDownloadAppInfo(complianceInfo, this.a.getAppSize()));
        }
        int i4 = this.a.getInteractionType() == 4 ? 1 : 0;
        if (this.a.getInteractionType() == 3) {
            i4 = 3;
        }
        if (this.a.getInteractionType() == 2) {
            i4 = 2;
        }
        setNativeInteractionType(i4);
        TTNativeAd tTNativeAd2 = this.a;
        if (tTNativeAd2 instanceof TTFeedAd) {
            TTFeedAd.CustomizeVideo customVideo2 = ((TTFeedAd) tTNativeAd2).getCustomVideo();
            if (customVideo2 != null) {
                setVideoUrl(customVideo2.getVideoUrl());
                this.f12676e = new TTATCustomVideo(customVideo2);
            }
            setVideoDuration(((TTFeedAd) this.a).getVideoDuration());
            ((TTFeedAd) this.a).setVideoAdListener(new TTFeedAd.VideoAdListener() { // from class: com.anythink.network.toutiao.TTATNativeAd.1
                @Override // com.bytedance.sdk.openadsdk.TTFeedAd.VideoAdListener
                public final void onProgressUpdate(long j2, long j3) {
                    if (TTATNativeAd.this.getVideoDuration() == PangleAdapterUtils.CPM_DEFLAUT_VALUE) {
                        TTATNativeAd tTATNativeAd = TTATNativeAd.this;
                        double d2 = j3;
                        Double.isNaN(d2);
                        tTATNativeAd.setVideoDuration(d2 / 1000.0d);
                    }
                    TTATNativeAd tTATNativeAd2 = TTATNativeAd.this;
                    double d3 = j2;
                    Double.isNaN(d3);
                    tTATNativeAd2.f12677f = d3 / 1000.0d;
                    tTATNativeAd2.notifyAdVideoPlayProgress((int) tTATNativeAd2.f12677f);
                }

                @Override // com.bytedance.sdk.openadsdk.TTFeedAd.VideoAdListener
                public final void onVideoAdComplete(TTFeedAd tTFeedAd) {
                    TTATNativeAd.this.notifyAdVideoEnd();
                }

                @Override // com.bytedance.sdk.openadsdk.TTFeedAd.VideoAdListener
                public final void onVideoAdContinuePlay(TTFeedAd tTFeedAd) {
                }

                @Override // com.bytedance.sdk.openadsdk.TTFeedAd.VideoAdListener
                public final void onVideoAdPaused(TTFeedAd tTFeedAd) {
                }

                @Override // com.bytedance.sdk.openadsdk.TTFeedAd.VideoAdListener
                public final void onVideoAdStartPlay(TTFeedAd tTFeedAd) {
                    TTATNativeAd.this.notifyAdVideoStart();
                }

                @Override // com.bytedance.sdk.openadsdk.TTFeedAd.VideoAdListener
                public final void onVideoError(int i5, int i6) {
                    TTATNativeAd.this.notifyAdVideoVideoPlayFail(String.valueOf(i5), String.valueOf(i6));
                }

                @Override // com.bytedance.sdk.openadsdk.TTFeedAd.VideoAdListener
                public final void onVideoLoad(TTFeedAd tTFeedAd) {
                }
            });
        }
        this.a.setDownloadListener(new TTAppDownloadListener() { // from class: com.anythink.network.toutiao.TTATNativeAd.2
            @Override // com.bytedance.sdk.openadsdk.TTAppDownloadListener
            public final void onDownloadActive(long j2, long j3, String str, String str2) {
                TTATNativeAd tTATNativeAd = TTATNativeAd.this;
                if (tTATNativeAd.f12675d) {
                    if (((com.anythink.nativead.unitgroup.a) tTATNativeAd).mDownloadListener == null || !(((com.anythink.nativead.unitgroup.a) TTATNativeAd.this).mDownloadListener instanceof CustomAdapterDownloadListener)) {
                        return;
                    }
                    ((CustomAdapterDownloadListener) ((com.anythink.nativead.unitgroup.a) TTATNativeAd.this).mDownloadListener).onDownloadUpdate(j2, j3, str, str2);
                    return;
                }
                tTATNativeAd.f12675d = true;
                if (((com.anythink.nativead.unitgroup.a) tTATNativeAd).mDownloadListener == null || !(((com.anythink.nativead.unitgroup.a) TTATNativeAd.this).mDownloadListener instanceof CustomAdapterDownloadListener)) {
                    return;
                }
                ((CustomAdapterDownloadListener) ((com.anythink.nativead.unitgroup.a) TTATNativeAd.this).mDownloadListener).onDownloadStart(j2, j3, str, str2);
            }

            @Override // com.bytedance.sdk.openadsdk.TTAppDownloadListener
            public final void onDownloadFailed(long j2, long j3, String str, String str2) {
                if (((com.anythink.nativead.unitgroup.a) TTATNativeAd.this).mDownloadListener == null || !(((com.anythink.nativead.unitgroup.a) TTATNativeAd.this).mDownloadListener instanceof CustomAdapterDownloadListener)) {
                    return;
                }
                ((CustomAdapterDownloadListener) ((com.anythink.nativead.unitgroup.a) TTATNativeAd.this).mDownloadListener).onDownloadFail(j2, j3, str, str2);
            }

            @Override // com.bytedance.sdk.openadsdk.TTAppDownloadListener
            public final void onDownloadFinished(long j2, String str, String str2) {
                if (((com.anythink.nativead.unitgroup.a) TTATNativeAd.this).mDownloadListener == null || !(((com.anythink.nativead.unitgroup.a) TTATNativeAd.this).mDownloadListener instanceof CustomAdapterDownloadListener)) {
                    return;
                }
                ((CustomAdapterDownloadListener) ((com.anythink.nativead.unitgroup.a) TTATNativeAd.this).mDownloadListener).onDownloadFinish(j2, str, str2);
            }

            @Override // com.bytedance.sdk.openadsdk.TTAppDownloadListener
            public final void onDownloadPaused(long j2, long j3, String str, String str2) {
                if (((com.anythink.nativead.unitgroup.a) TTATNativeAd.this).mDownloadListener == null || !(((com.anythink.nativead.unitgroup.a) TTATNativeAd.this).mDownloadListener instanceof CustomAdapterDownloadListener)) {
                    return;
                }
                ((CustomAdapterDownloadListener) ((com.anythink.nativead.unitgroup.a) TTATNativeAd.this).mDownloadListener).onDownloadPause(j2, j3, str, str2);
            }

            @Override // com.bytedance.sdk.openadsdk.TTAppDownloadListener
            public final void onIdle() {
            }

            @Override // com.bytedance.sdk.openadsdk.TTAppDownloadListener
            public final void onInstalled(String str, String str2) {
                if (((com.anythink.nativead.unitgroup.a) TTATNativeAd.this).mDownloadListener == null || !(((com.anythink.nativead.unitgroup.a) TTATNativeAd.this).mDownloadListener instanceof CustomAdapterDownloadListener)) {
                    return;
                }
                ((CustomAdapterDownloadListener) ((com.anythink.nativead.unitgroup.a) TTATNativeAd.this).mDownloadListener).onInstalled(str, str2);
            }
        });
        int imageMode = this.a.getImageMode();
        if (imageMode != 2 && imageMode != 3 && imageMode != 4) {
            if (imageMode == 5 || imageMode == 15) {
                this.mAdSourceType = "1";
                return;
            } else if (imageMode != 16) {
                return;
            }
        }
        this.mAdSourceType = "2";
    }

    private void a(List<View> list, View view) {
        if (!(view instanceof ViewGroup) || view == this.a.getAdView()) {
            if (view != this.a.getAdView()) {
                list.add(view);
            }
        } else {
            ViewGroup viewGroup = (ViewGroup) view;
            for (int i2 = 0; i2 < viewGroup.getChildCount(); i2++) {
                a(list, viewGroup.getChildAt(i2));
            }
        }
    }

    private void a(Activity activity) {
        bindDislikeListener(new AnonymousClass3(activity));
    }

    private void a(View view) {
        if (view == null) {
            return;
        }
        if (view instanceof ViewGroup) {
            TTNativeAd tTNativeAd = this.a;
            if (tTNativeAd == null || view != tTNativeAd.getAdView()) {
                ViewGroup viewGroup = (ViewGroup) view;
                for (int i2 = 0; i2 < viewGroup.getChildCount(); i2++) {
                    a(viewGroup.getChildAt(i2));
                }
                return;
            }
            return;
        }
        view.setOnClickListener(null);
        view.setClickable(false);
    }
}
