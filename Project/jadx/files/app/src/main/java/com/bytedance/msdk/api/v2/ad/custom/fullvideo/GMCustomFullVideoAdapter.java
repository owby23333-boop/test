package com.bytedance.msdk.api.v2.ad.custom.fullvideo;

import android.content.Context;
import com.bytedance.msdk.adapter.TTAbsAdLoaderAdapter;
import com.bytedance.msdk.adapter.pangle.PangleAdapterUtils;
import com.bytedance.msdk.adapter.util.Logger;
import com.bytedance.msdk.api.AdError;
import com.bytedance.msdk.api.reward.RewardItem;
import com.bytedance.msdk.api.v2.ad.custom.GMCustomAdError;
import com.bytedance.msdk.api.v2.ad.custom.base.GMCustomAd;
import com.bytedance.msdk.api.v2.ad.custom.base.GMCustomBaseAdapter;
import com.bytedance.msdk.api.v2.ad.custom.base.GMCustomVideoAdapter;
import com.bytedance.msdk.api.v2.ad.custom.bean.GMCustomServiceConfig;
import com.bytedance.msdk.api.v2.ad.fullvideo.GMFullVideoAdListener;
import com.bytedance.msdk.api.v2.slot.GMAdSlotBase;
import com.bytedance.msdk.api.v2.slot.GMAdSlotFullVideo;
import com.bytedance.msdk.api.v2.slot.GMAdSlotInterstitialFull;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public abstract class GMCustomFullVideoAdapter extends GMCustomVideoAdapter implements IGMCustomFullVideoEvent {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private volatile boolean f14267h = false;

    public final void callAdVideoCache() {
        GMCustomAd gMCustomAd;
        TTAbsAdLoaderAdapter tTAbsAdLoaderAdapter = this.f14242c;
        if (tTAbsAdLoaderAdapter == null || (gMCustomAd = this.f14243d) == null) {
            return;
        }
        tTAbsAdLoaderAdapter.notifyAdVideoCache(gMCustomAd, (AdError) null);
    }

    @Override // com.bytedance.msdk.api.v2.ad.custom.fullvideo.IGMCustomFullVideoEvent
    public final void callFullVideoAdClick() {
        if (this.f14267h && this.f14243d != null) {
            checkLoadSuccess(new GMCustomBaseAdapter.CheckCallback() { // from class: com.bytedance.msdk.api.v2.ad.custom.fullvideo.GMCustomFullVideoAdapter.2
                @Override // com.bytedance.msdk.api.v2.ad.custom.base.GMCustomBaseAdapter.CheckCallback
                public void callback() {
                    GMCustomFullVideoAdapter.this.checkClick(new GMCustomBaseAdapter.CheckCallback() { // from class: com.bytedance.msdk.api.v2.ad.custom.fullvideo.GMCustomFullVideoAdapter.2.1
                        @Override // com.bytedance.msdk.api.v2.ad.custom.base.GMCustomBaseAdapter.CheckCallback
                        public void callback() {
                            GMFullVideoAdListener gMFullVideoAdListener = (GMFullVideoAdListener) ((GMCustomBaseAdapter) GMCustomFullVideoAdapter.this).f14243d.getTTAdapterCallback();
                            if (gMFullVideoAdListener != null) {
                                gMFullVideoAdListener.onFullVideoAdClick();
                            }
                        }
                    });
                }
            });
        }
    }

    @Override // com.bytedance.msdk.api.v2.ad.custom.fullvideo.IGMCustomFullVideoEvent
    public final void callFullVideoAdClosed() {
        if (this.f14267h && this.f14243d != null) {
            checkLoadSuccess(new GMCustomBaseAdapter.CheckCallback() { // from class: com.bytedance.msdk.api.v2.ad.custom.fullvideo.GMCustomFullVideoAdapter.3
                @Override // com.bytedance.msdk.api.v2.ad.custom.base.GMCustomBaseAdapter.CheckCallback
                public void callback() {
                    GMFullVideoAdListener gMFullVideoAdListener = (GMFullVideoAdListener) ((GMCustomBaseAdapter) GMCustomFullVideoAdapter.this).f14243d.getTTAdapterCallback();
                    if (gMFullVideoAdListener != null) {
                        gMFullVideoAdListener.onFullVideoAdClosed();
                    }
                }
            });
        }
    }

    @Override // com.bytedance.msdk.api.v2.ad.custom.fullvideo.IGMCustomFullVideoEvent
    public final void callFullVideoAdShow() {
        if (this.f14243d != null) {
            checkLoadSuccess(new GMCustomBaseAdapter.CheckCallback() { // from class: com.bytedance.msdk.api.v2.ad.custom.fullvideo.GMCustomFullVideoAdapter.1
                @Override // com.bytedance.msdk.api.v2.ad.custom.base.GMCustomBaseAdapter.CheckCallback
                public void callback() {
                    GMCustomFullVideoAdapter.this.checkShow(new GMCustomBaseAdapter.CheckCallback() { // from class: com.bytedance.msdk.api.v2.ad.custom.fullvideo.GMCustomFullVideoAdapter.1.1
                        @Override // com.bytedance.msdk.api.v2.ad.custom.base.GMCustomBaseAdapter.CheckCallback
                        public void callback() {
                            GMFullVideoAdListener gMFullVideoAdListener = (GMFullVideoAdListener) ((GMCustomBaseAdapter) GMCustomFullVideoAdapter.this).f14243d.getTTAdapterCallback();
                            if (gMFullVideoAdListener != null) {
                                GMCustomFullVideoAdapter.this.f14267h = true;
                                gMFullVideoAdListener.onFullVideoAdShow();
                            }
                        }
                    });
                }
            });
        }
    }

    @Override // com.bytedance.msdk.api.v2.ad.custom.fullvideo.IGMCustomFullVideoEvent
    public final void callFullVideoComplete() {
        if (this.f14267h && this.f14243d != null) {
            checkLoadSuccess(new GMCustomBaseAdapter.CheckCallback() { // from class: com.bytedance.msdk.api.v2.ad.custom.fullvideo.GMCustomFullVideoAdapter.4
                @Override // com.bytedance.msdk.api.v2.ad.custom.base.GMCustomBaseAdapter.CheckCallback
                public void callback() {
                    GMFullVideoAdListener gMFullVideoAdListener = (GMFullVideoAdListener) ((GMCustomBaseAdapter) GMCustomFullVideoAdapter.this).f14243d.getTTAdapterCallback();
                    if (gMFullVideoAdListener != null) {
                        gMFullVideoAdListener.onVideoComplete();
                    }
                }
            });
        }
    }

    @Override // com.bytedance.msdk.api.v2.ad.custom.fullvideo.IGMCustomFullVideoEvent
    public final void callFullVideoError() {
        if (this.f14243d != null) {
            checkLoadSuccess(new GMCustomBaseAdapter.CheckCallback() { // from class: com.bytedance.msdk.api.v2.ad.custom.fullvideo.GMCustomFullVideoAdapter.5
                @Override // com.bytedance.msdk.api.v2.ad.custom.base.GMCustomBaseAdapter.CheckCallback
                public void callback() {
                    GMFullVideoAdListener gMFullVideoAdListener = (GMFullVideoAdListener) ((GMCustomBaseAdapter) GMCustomFullVideoAdapter.this).f14243d.getTTAdapterCallback();
                    if (gMFullVideoAdListener != null) {
                        gMFullVideoAdListener.onVideoError();
                    }
                }
            });
        }
    }

    @Override // com.bytedance.msdk.api.v2.ad.custom.fullvideo.IGMCustomFullVideoEvent
    public final void callFullVideoRewardVerify(final RewardItem rewardItem) {
        if (!this.f14267h || rewardItem == null || this.f14243d == null) {
            return;
        }
        checkLoadSuccess(new GMCustomBaseAdapter.CheckCallback() { // from class: com.bytedance.msdk.api.v2.ad.custom.fullvideo.GMCustomFullVideoAdapter.7
            @Override // com.bytedance.msdk.api.v2.ad.custom.base.GMCustomBaseAdapter.CheckCallback
            public void callback() {
                GMFullVideoAdListener gMFullVideoAdListener = (GMFullVideoAdListener) ((GMCustomBaseAdapter) GMCustomFullVideoAdapter.this).f14243d.getTTAdapterCallback();
                if (gMFullVideoAdListener != null) {
                    gMFullVideoAdListener.onRewardVerify(rewardItem);
                }
            }
        });
    }

    @Override // com.bytedance.msdk.api.v2.ad.custom.fullvideo.IGMCustomFullVideoEvent
    public final void callFullVideoSkippedVideo() {
        if (this.f14267h && this.f14243d != null) {
            checkLoadSuccess(new GMCustomBaseAdapter.CheckCallback() { // from class: com.bytedance.msdk.api.v2.ad.custom.fullvideo.GMCustomFullVideoAdapter.6
                @Override // com.bytedance.msdk.api.v2.ad.custom.base.GMCustomBaseAdapter.CheckCallback
                public void callback() {
                    GMFullVideoAdListener gMFullVideoAdListener = (GMFullVideoAdListener) ((GMCustomBaseAdapter) GMCustomFullVideoAdapter.this).f14243d.getTTAdapterCallback();
                    if (gMFullVideoAdListener != null) {
                        gMFullVideoAdListener.onSkippedVideo();
                    }
                }
            });
        }
    }

    @Override // com.bytedance.msdk.api.v2.ad.custom.base.IGMCustomLoadAdCall
    public final void callLoadFail(GMCustomAdError gMCustomAdError) {
        if (isCallLoadFailCall()) {
            Logger.e("TTMediationSDK", "自定义Adapter 加载成功或者失败回调只能调用一次");
            return;
        }
        TTAbsAdLoaderAdapter tTAbsAdLoaderAdapter = this.f14242c;
        if (tTAbsAdLoaderAdapter != null) {
            tTAbsAdLoaderAdapter.notifyAdFailed(new AdError(AdError.ERROR_CODE_CUSTOM_FULL_VIDEO_LOAD_ERROR, AdError.getMessage(AdError.ERROR_CODE_CUSTOM_FULL_VIDEO_SHOW_ERROR), gMCustomAdError == null ? -1 : gMCustomAdError.getCode(), gMCustomAdError == null ? "" : gMCustomAdError.getMessage()));
        }
    }

    @Override // com.bytedance.msdk.api.v2.ad.custom.base.IGMCustomLoadAdCall
    public final void callLoadSuccess() {
        callLoadSuccess(PangleAdapterUtils.CPM_DEFLAUT_VALUE, null);
    }

    @Override // com.bytedance.msdk.api.v2.ad.custom.base.IGMCustomLoadAdCall
    public final void callLoadSuccess(double d2) {
        callLoadSuccess(d2, null);
    }

    @Override // com.bytedance.msdk.api.v2.ad.custom.base.IGMCustomLoadAdCall
    public void callLoadSuccess(double d2, Map<String, Object> map) {
        if (isCallLoadSuccessCall()) {
            Logger.e("TTMediationSDK", "自定义Adapter 加载成功或者失败回调只能调用一次");
            return;
        }
        Logger.e("TTMediationSDK", "自定义Adapter callLoadSuccess");
        this.f14243d = new GMCustomFullVideoAd();
        this.f14243d.setMediaExtraInfo(this.f14246g);
        this.f14243d.setAdType(this.b.t());
        if (d2 > PangleAdapterUtils.CPM_DEFLAUT_VALUE && getBiddingType() == 1) {
            this.f14243d.setCpm(d2);
        }
        this.f14243d.putExtraMsg(map);
        this.f14243d.setGMCustomBaseAdapter(this);
        TTAbsAdLoaderAdapter tTAbsAdLoaderAdapter = this.f14242c;
        if (tTAbsAdLoaderAdapter != null) {
            tTAbsAdLoaderAdapter.notifyAdLoaded(this.f14243d);
        }
    }

    @Override // com.bytedance.msdk.api.v2.ad.custom.base.IGMCustomLoadAdCall
    public void callLoadSuccess(Map<String, Object> map) {
        callLoadSuccess(PangleAdapterUtils.CPM_DEFLAUT_VALUE, map);
    }

    public abstract void load(Context context, GMAdSlotFullVideo gMAdSlotFullVideo, GMCustomServiceConfig gMCustomServiceConfig);

    @Override // com.bytedance.msdk.api.v2.ad.custom.base.GMCustomBaseAdapter
    public void loadCustom(Context context, GMAdSlotBase gMAdSlotBase, GMCustomServiceConfig gMCustomServiceConfig) {
        GMAdSlotFullVideo gMAdSlotFullVideo;
        if (gMAdSlotBase instanceof GMAdSlotInterstitialFull) {
            gMAdSlotFullVideo = ((GMAdSlotInterstitialFull) gMAdSlotBase).getGMAdSlotFullVideo();
        } else {
            if (!(gMAdSlotBase instanceof GMAdSlotFullVideo)) {
                callLoadFail(new GMCustomAdError(-99999, "ClassCastException：load ad fail adSlot is not GMAdSlotInterstitialFull or GMAdSlotFullVideo"));
                return;
            }
            gMAdSlotFullVideo = (GMAdSlotFullVideo) gMAdSlotBase;
        }
        load(context, gMAdSlotFullVideo, gMCustomServiceConfig);
    }

    public final void setMediaExtraInfo(Map<String, Object> map) {
        if (map != null) {
            this.f14246g = new HashMap();
            this.f14246g.putAll(map);
        }
    }
}
