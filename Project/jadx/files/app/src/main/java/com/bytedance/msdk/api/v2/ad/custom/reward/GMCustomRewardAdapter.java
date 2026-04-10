package com.bytedance.msdk.api.v2.ad.custom.reward;

import android.app.Activity;
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
import com.bytedance.msdk.api.v2.ad.reward.GMRewardedAdListener;
import com.bytedance.msdk.api.v2.slot.GMAdSlotBase;
import com.bytedance.msdk.api.v2.slot.GMAdSlotRewardVideo;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public abstract class GMCustomRewardAdapter extends GMCustomVideoAdapter implements IGMCustomRewardEvent {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private volatile boolean f14293h = false;

    public final void callAdVideoCache() {
        GMCustomAd gMCustomAd;
        TTAbsAdLoaderAdapter tTAbsAdLoaderAdapter = this.f14242c;
        if (tTAbsAdLoaderAdapter == null || (gMCustomAd = this.f14243d) == null) {
            return;
        }
        tTAbsAdLoaderAdapter.notifyAdVideoCache(gMCustomAd, (AdError) null);
    }

    @Override // com.bytedance.msdk.api.v2.ad.custom.base.IGMCustomLoadAdCall
    public final void callLoadFail(GMCustomAdError gMCustomAdError) {
        if (isCallLoadFailCall()) {
            Logger.e("TTMediationSDK", "自定义Adapter 加载成功或者失败回调只能调用一次");
            return;
        }
        TTAbsAdLoaderAdapter tTAbsAdLoaderAdapter = this.f14242c;
        if (tTAbsAdLoaderAdapter != null) {
            tTAbsAdLoaderAdapter.notifyAdFailed(new AdError(AdError.ERROR_CODE_CUSTOM_REWARD_LOAD_ERROR, AdError.getMessage(AdError.ERROR_CODE_CUSTOM_REWARD_LOAD_ERROR), gMCustomAdError == null ? -1 : gMCustomAdError.getCode(), gMCustomAdError == null ? "" : gMCustomAdError.getMessage()));
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
        this.f14243d = new GMCustomRewardAd();
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

    @Override // com.bytedance.msdk.api.v2.ad.custom.reward.IGMCustomRewardEvent
    public final void callRewardClick() {
        if (this.f14293h && this.f14243d != null) {
            checkLoadSuccess(new GMCustomBaseAdapter.CheckCallback() { // from class: com.bytedance.msdk.api.v2.ad.custom.reward.GMCustomRewardAdapter.2
                @Override // com.bytedance.msdk.api.v2.ad.custom.base.GMCustomBaseAdapter.CheckCallback
                public void callback() {
                    GMCustomRewardAdapter.this.checkClick(new GMCustomBaseAdapter.CheckCallback() { // from class: com.bytedance.msdk.api.v2.ad.custom.reward.GMCustomRewardAdapter.2.1
                        @Override // com.bytedance.msdk.api.v2.ad.custom.base.GMCustomBaseAdapter.CheckCallback
                        public void callback() {
                            GMRewardedAdListener gMRewardedAdListener = (GMRewardedAdListener) ((GMCustomBaseAdapter) GMCustomRewardAdapter.this).f14243d.getTTAdapterCallback();
                            if (gMRewardedAdListener != null) {
                                gMRewardedAdListener.onRewardClick();
                            }
                        }
                    });
                }
            });
        }
    }

    @Override // com.bytedance.msdk.api.v2.ad.custom.reward.IGMCustomRewardEvent
    public final void callRewardSkippedVideo() {
        if (this.f14293h && this.f14243d != null) {
            checkLoadSuccess(new GMCustomBaseAdapter.CheckCallback() { // from class: com.bytedance.msdk.api.v2.ad.custom.reward.GMCustomRewardAdapter.7
                @Override // com.bytedance.msdk.api.v2.ad.custom.base.GMCustomBaseAdapter.CheckCallback
                public void callback() {
                    GMRewardedAdListener gMRewardedAdListener = (GMRewardedAdListener) ((GMCustomBaseAdapter) GMCustomRewardAdapter.this).f14243d.getTTAdapterCallback();
                    if (gMRewardedAdListener != null) {
                        gMRewardedAdListener.onSkippedVideo();
                    }
                }
            });
        }
    }

    @Override // com.bytedance.msdk.api.v2.ad.custom.reward.IGMCustomRewardEvent
    public final void callRewardVerify(final RewardItem rewardItem) {
        if (this.f14293h && this.f14243d != null) {
            checkLoadSuccess(new GMCustomBaseAdapter.CheckCallback() { // from class: com.bytedance.msdk.api.v2.ad.custom.reward.GMCustomRewardAdapter.6
                @Override // com.bytedance.msdk.api.v2.ad.custom.base.GMCustomBaseAdapter.CheckCallback
                public void callback() {
                    GMRewardedAdListener gMRewardedAdListener = (GMRewardedAdListener) ((GMCustomBaseAdapter) GMCustomRewardAdapter.this).f14243d.getTTAdapterCallback();
                    if (gMRewardedAdListener != null) {
                        gMRewardedAdListener.onRewardVerify(rewardItem);
                    }
                }
            });
        }
    }

    @Override // com.bytedance.msdk.api.v2.ad.custom.reward.IGMCustomRewardEvent
    public final void callRewardVideoComplete() {
        if (this.f14293h && this.f14243d != null) {
            checkLoadSuccess(new GMCustomBaseAdapter.CheckCallback() { // from class: com.bytedance.msdk.api.v2.ad.custom.reward.GMCustomRewardAdapter.4
                @Override // com.bytedance.msdk.api.v2.ad.custom.base.GMCustomBaseAdapter.CheckCallback
                public void callback() {
                    GMRewardedAdListener gMRewardedAdListener = (GMRewardedAdListener) ((GMCustomBaseAdapter) GMCustomRewardAdapter.this).f14243d.getTTAdapterCallback();
                    if (gMRewardedAdListener != null) {
                        gMRewardedAdListener.onVideoComplete();
                    }
                }
            });
        }
    }

    @Override // com.bytedance.msdk.api.v2.ad.custom.reward.IGMCustomRewardEvent
    public final void callRewardVideoError() {
        if (this.f14243d != null) {
            checkLoadSuccess(new GMCustomBaseAdapter.CheckCallback() { // from class: com.bytedance.msdk.api.v2.ad.custom.reward.GMCustomRewardAdapter.5
                @Override // com.bytedance.msdk.api.v2.ad.custom.base.GMCustomBaseAdapter.CheckCallback
                public void callback() {
                    GMRewardedAdListener gMRewardedAdListener = (GMRewardedAdListener) ((GMCustomBaseAdapter) GMCustomRewardAdapter.this).f14243d.getTTAdapterCallback();
                    if (gMRewardedAdListener != null) {
                        gMRewardedAdListener.onVideoError();
                    }
                }
            });
        }
    }

    @Override // com.bytedance.msdk.api.v2.ad.custom.reward.IGMCustomRewardEvent
    public final void callRewardedAdClosed() {
        if (this.f14293h && this.f14243d != null) {
            checkLoadSuccess(new GMCustomBaseAdapter.CheckCallback() { // from class: com.bytedance.msdk.api.v2.ad.custom.reward.GMCustomRewardAdapter.3
                @Override // com.bytedance.msdk.api.v2.ad.custom.base.GMCustomBaseAdapter.CheckCallback
                public void callback() {
                    GMRewardedAdListener gMRewardedAdListener = (GMRewardedAdListener) ((GMCustomBaseAdapter) GMCustomRewardAdapter.this).f14243d.getTTAdapterCallback();
                    if (gMRewardedAdListener != null) {
                        gMRewardedAdListener.onRewardedAdClosed();
                    }
                }
            });
        }
    }

    @Override // com.bytedance.msdk.api.v2.ad.custom.reward.IGMCustomRewardEvent
    public final void callRewardedAdShow() {
        if (this.f14243d != null) {
            checkLoadSuccess(new GMCustomBaseAdapter.CheckCallback() { // from class: com.bytedance.msdk.api.v2.ad.custom.reward.GMCustomRewardAdapter.1
                @Override // com.bytedance.msdk.api.v2.ad.custom.base.GMCustomBaseAdapter.CheckCallback
                public void callback() {
                    GMCustomRewardAdapter.this.checkShow(new GMCustomBaseAdapter.CheckCallback() { // from class: com.bytedance.msdk.api.v2.ad.custom.reward.GMCustomRewardAdapter.1.1
                        @Override // com.bytedance.msdk.api.v2.ad.custom.base.GMCustomBaseAdapter.CheckCallback
                        public void callback() {
                            GMRewardedAdListener gMRewardedAdListener = (GMRewardedAdListener) ((GMCustomBaseAdapter) GMCustomRewardAdapter.this).f14243d.getTTAdapterCallback();
                            if (gMRewardedAdListener != null) {
                                GMCustomRewardAdapter.this.f14293h = true;
                                gMRewardedAdListener.onRewardedAdShow();
                            }
                        }
                    });
                }
            });
        }
    }

    public abstract void load(Context context, GMAdSlotRewardVideo gMAdSlotRewardVideo, GMCustomServiceConfig gMCustomServiceConfig);

    @Override // com.bytedance.msdk.api.v2.ad.custom.base.GMCustomBaseAdapter
    public void loadCustom(Context context, GMAdSlotBase gMAdSlotBase, GMCustomServiceConfig gMCustomServiceConfig) {
        if (gMAdSlotBase instanceof GMAdSlotRewardVideo) {
            load(context, (GMAdSlotRewardVideo) gMAdSlotBase, gMCustomServiceConfig);
        } else {
            callLoadFail(new GMCustomAdError(-99999, "ClassCastException：load ad fail adSlot is not GMAdSlotRewardVideo"));
        }
    }

    public final void setMediaExtraInfo(Map<String, Object> map) {
        if (map != null) {
            this.f14246g = new HashMap();
            this.f14246g.putAll(map);
        }
    }

    @Override // com.bytedance.msdk.api.v2.ad.custom.base.GMCustomVideoAdapter
    public abstract void showAd(Activity activity);
}
