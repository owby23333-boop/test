package com.anythink.network.baidu;

import android.content.Context;
import android.view.View;
import com.anythink.nativead.api.ATNativePrepareInfo;
import com.anythink.nativead.unitgroup.api.CustomNativeAd;
import com.baidu.mobads.sdk.api.BaiduNativeManager;
import com.baidu.mobads.sdk.api.FeedPortraitVideoView;
import com.baidu.mobads.sdk.api.IFeedPortraitListener;
import com.baidu.mobads.sdk.api.NativeResponse;
import com.baidu.mobads.sdk.api.RequestParameters;
import com.bytedance.msdk.adapter.pangle.PangleAdapterUtils;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class BaiduATNativePortraitVideoAd extends BaiduATNativeAd {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    BaiduNativeManager f12367e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    RequestParameters f12368f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    boolean f12369g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private FeedPortraitVideoView f12370h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private Context f12371i;

    protected interface LoadCallbackListener {
        void onFail(String str, String str2);

        void onSuccess(NativeResponse nativeResponse, CustomNativeAd customNativeAd);
    }

    public BaiduATNativePortraitVideoAd(Context context, BaiduNativeManager baiduNativeManager, RequestParameters requestParameters, boolean z2) {
        this.f12371i = context;
        this.f12367e = baiduNativeManager;
        this.f12368f = requestParameters;
        this.f12369g = z2;
    }

    @Override // com.anythink.network.baidu.BaiduATNativeAd, com.anythink.nativead.unitgroup.api.CustomNativeAd, com.anythink.core.api.BaseAd
    public void destroy() {
        super.destroy();
        FeedPortraitVideoView feedPortraitVideoView = this.f12370h;
        if (feedPortraitVideoView != null) {
            feedPortraitVideoView.stop();
            this.f12370h = null;
        }
    }

    @Override // com.anythink.network.baidu.BaiduATNativeAd, com.anythink.nativead.unitgroup.api.CustomNativeAd, com.anythink.nativead.unitgroup.a, com.anythink.core.api.IATThirdPartyMaterial
    public View getAdMediaView(Object... objArr) {
        if (this.a == null) {
            return null;
        }
        if (this.f12370h == null) {
            this.f12370h = new FeedPortraitVideoView(this.b);
            this.f12370h.setAdData(this.a);
            this.f12370h.setVideoMute(this.f12360d);
            this.f12370h.setFeedPortraitListener(new IFeedPortraitListener() { // from class: com.anythink.network.baidu.BaiduATNativePortraitVideoAd.2
                @Override // com.baidu.mobads.sdk.api.IFeedPortraitListener
                public final void pauseBtnClick() {
                }

                @Override // com.baidu.mobads.sdk.api.IFeedPortraitListener
                public final void playCompletion() {
                    BaiduATNativePortraitVideoAd.this.notifyAdVideoEnd();
                }

                @Override // com.baidu.mobads.sdk.api.IFeedPortraitListener
                public final void playError() {
                    BaiduATNativePortraitVideoAd.this.notifyAdVideoVideoPlayFail("", "BaiduATNativePortraitVideoAd video play error");
                }

                @Override // com.baidu.mobads.sdk.api.IFeedPortraitListener
                public final void playPause() {
                }

                @Override // com.baidu.mobads.sdk.api.IFeedPortraitListener
                public final void playRenderingStart() {
                    BaiduATNativePortraitVideoAd.this.notifyAdVideoStart();
                }

                @Override // com.baidu.mobads.sdk.api.IFeedPortraitListener
                public final void playResume() {
                }
            });
        }
        return this.f12370h;
    }

    @Override // com.anythink.nativead.unitgroup.api.CustomNativeAd, com.anythink.core.api.IATThirdPartyMaterial
    public double getVideoProgress() {
        FeedPortraitVideoView feedPortraitVideoView = this.f12370h;
        if (feedPortraitVideoView == null) {
            return PangleAdapterUtils.CPM_DEFLAUT_VALUE;
        }
        double currentPosition = feedPortraitVideoView.getCurrentPosition();
        Double.isNaN(currentPosition);
        return currentPosition / 1000.0d;
    }

    public void load(final LoadCallbackListener loadCallbackListener) {
        this.f12367e.loadPortraitVideoAd(this.f12368f, new BaiduNativeManager.PortraitVideoAdListener() { // from class: com.anythink.network.baidu.BaiduATNativePortraitVideoAd.1
            @Override // com.baidu.mobads.sdk.api.BaiduNativeManager.PortraitVideoAdListener
            public final void onAdClick() {
                BaiduATNativePortraitVideoAd.this.notifyAdClicked();
            }

            @Override // com.baidu.mobads.sdk.api.BaiduNativeManager.FeedAdListener
            public final void onLpClosed() {
            }

            @Override // com.baidu.mobads.sdk.api.BaiduNativeManager.FeedAdListener
            public final void onNativeFail(int i2, String str) {
                loadCallbackListener.onFail(String.valueOf(i2), str);
            }

            @Override // com.baidu.mobads.sdk.api.BaiduNativeManager.FeedAdListener
            public final void onNativeLoad(List<NativeResponse> list) {
                if (list == null || list.size() <= 0) {
                    loadCallbackListener.onFail("", "callback onNativeLoad but no ad");
                    return;
                }
                NativeResponse nativeResponse = list.get(0);
                BaiduATNativePortraitVideoAd baiduATNativePortraitVideoAd = BaiduATNativePortraitVideoAd.this;
                baiduATNativePortraitVideoAd.a(baiduATNativePortraitVideoAd.f12371i, nativeResponse);
                loadCallbackListener.onSuccess(nativeResponse, BaiduATNativePortraitVideoAd.this);
            }

            @Override // com.baidu.mobads.sdk.api.BaiduNativeManager.FeedAdListener
            public final void onNoAd(int i2, String str) {
                loadCallbackListener.onFail(String.valueOf(i2), str);
            }

            @Override // com.baidu.mobads.sdk.api.BaiduNativeManager.FeedAdListener
            public final void onVideoDownloadFailed() {
            }

            @Override // com.baidu.mobads.sdk.api.BaiduNativeManager.FeedAdListener
            public final void onVideoDownloadSuccess() {
            }
        });
    }

    @Override // com.anythink.nativead.unitgroup.api.CustomNativeAd, com.anythink.nativead.unitgroup.a
    public void pauseVideo() {
        super.pauseVideo();
        FeedPortraitVideoView feedPortraitVideoView = this.f12370h;
        if (feedPortraitVideoView != null) {
            feedPortraitVideoView.pause();
        }
    }

    @Override // com.anythink.network.baidu.BaiduATNativeAd, com.anythink.nativead.unitgroup.api.CustomNativeAd, com.anythink.nativead.unitgroup.a
    public void prepare(View view, ATNativePrepareInfo aTNativePrepareInfo) {
        FeedPortraitVideoView feedPortraitVideoView;
        super.prepare(view, aTNativePrepareInfo);
        if (!this.f12369g || (feedPortraitVideoView = this.f12370h) == null) {
            return;
        }
        feedPortraitVideoView.play();
    }

    @Override // com.anythink.nativead.unitgroup.api.CustomNativeAd, com.anythink.nativead.unitgroup.a
    public void resumeVideo() {
        super.resumeVideo();
        FeedPortraitVideoView feedPortraitVideoView = this.f12370h;
        if (feedPortraitVideoView != null) {
            feedPortraitVideoView.resume();
        }
    }

    @Override // com.anythink.network.baidu.BaiduATNativeAd, com.anythink.nativead.unitgroup.api.CustomNativeAd, com.anythink.core.api.BaseAd
    public void setVideoMute(boolean z2) {
        super.setVideoMute(z2);
        FeedPortraitVideoView feedPortraitVideoView = this.f12370h;
        if (feedPortraitVideoView != null) {
            feedPortraitVideoView.setVideoMute(z2);
        }
    }
}
