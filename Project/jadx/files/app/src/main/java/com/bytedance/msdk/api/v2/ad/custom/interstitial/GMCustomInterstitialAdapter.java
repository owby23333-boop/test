package com.bytedance.msdk.api.v2.ad.custom.interstitial;

import android.content.Context;
import com.bytedance.msdk.adapter.TTAbsAdLoaderAdapter;
import com.bytedance.msdk.adapter.pangle.PangleAdapterUtils;
import com.bytedance.msdk.adapter.util.Logger;
import com.bytedance.msdk.api.AdError;
import com.bytedance.msdk.api.v2.ad.custom.GMCustomAdError;
import com.bytedance.msdk.api.v2.ad.custom.base.GMCustomBaseAdapter;
import com.bytedance.msdk.api.v2.ad.custom.base.GMCustomVideoAdapter;
import com.bytedance.msdk.api.v2.ad.custom.bean.GMCustomServiceConfig;
import com.bytedance.msdk.api.v2.ad.interstitial.GMInterstitialAdListener;
import com.bytedance.msdk.api.v2.slot.GMAdSlotBase;
import com.bytedance.msdk.api.v2.slot.GMAdSlotInterstitial;
import com.bytedance.msdk.api.v2.slot.GMAdSlotInterstitialFull;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public abstract class GMCustomInterstitialAdapter extends GMCustomVideoAdapter implements IGMCustomInterstitialEvent {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private volatile boolean f14268h = false;

    @Override // com.bytedance.msdk.api.v2.ad.custom.interstitial.IGMCustomInterstitialEvent
    public final void callInterstitialAdClick() {
        if (this.f14268h && this.f14243d != null) {
            checkLoadSuccess(new GMCustomBaseAdapter.CheckCallback() { // from class: com.bytedance.msdk.api.v2.ad.custom.interstitial.GMCustomInterstitialAdapter.2
                @Override // com.bytedance.msdk.api.v2.ad.custom.base.GMCustomBaseAdapter.CheckCallback
                public void callback() {
                    GMCustomInterstitialAdapter.this.checkClick(new GMCustomBaseAdapter.CheckCallback() { // from class: com.bytedance.msdk.api.v2.ad.custom.interstitial.GMCustomInterstitialAdapter.2.1
                        @Override // com.bytedance.msdk.api.v2.ad.custom.base.GMCustomBaseAdapter.CheckCallback
                        public void callback() {
                            GMInterstitialAdListener gMInterstitialAdListener = (GMInterstitialAdListener) ((GMCustomBaseAdapter) GMCustomInterstitialAdapter.this).f14243d.getTTAdapterCallback();
                            if (gMInterstitialAdListener != null) {
                                gMInterstitialAdListener.onInterstitialAdClick();
                            }
                        }
                    });
                }
            });
        }
    }

    @Override // com.bytedance.msdk.api.v2.ad.custom.interstitial.IGMCustomInterstitialEvent
    public final void callInterstitialAdLeftApplication() {
        if (this.f14243d != null) {
            checkLoadSuccess(new GMCustomBaseAdapter.CheckCallback() { // from class: com.bytedance.msdk.api.v2.ad.custom.interstitial.GMCustomInterstitialAdapter.5
                @Override // com.bytedance.msdk.api.v2.ad.custom.base.GMCustomBaseAdapter.CheckCallback
                public void callback() {
                    GMInterstitialAdListener gMInterstitialAdListener = (GMInterstitialAdListener) ((GMCustomBaseAdapter) GMCustomInterstitialAdapter.this).f14243d.getTTAdapterCallback();
                    if (gMInterstitialAdListener != null) {
                        gMInterstitialAdListener.onAdLeftApplication();
                    }
                }
            });
        }
    }

    @Override // com.bytedance.msdk.api.v2.ad.custom.interstitial.IGMCustomInterstitialEvent
    public final void callInterstitialAdOpened() {
        if (this.f14243d != null) {
            checkLoadSuccess(new GMCustomBaseAdapter.CheckCallback() { // from class: com.bytedance.msdk.api.v2.ad.custom.interstitial.GMCustomInterstitialAdapter.4
                @Override // com.bytedance.msdk.api.v2.ad.custom.base.GMCustomBaseAdapter.CheckCallback
                public void callback() {
                    GMInterstitialAdListener gMInterstitialAdListener = (GMInterstitialAdListener) ((GMCustomBaseAdapter) GMCustomInterstitialAdapter.this).f14243d.getTTAdapterCallback();
                    if (gMInterstitialAdListener != null) {
                        gMInterstitialAdListener.onAdOpened();
                    }
                }
            });
        }
    }

    @Override // com.bytedance.msdk.api.v2.ad.custom.interstitial.IGMCustomInterstitialEvent
    public final void callInterstitialClosed() {
        if (this.f14268h && this.f14243d != null) {
            checkLoadSuccess(new GMCustomBaseAdapter.CheckCallback() { // from class: com.bytedance.msdk.api.v2.ad.custom.interstitial.GMCustomInterstitialAdapter.3
                @Override // com.bytedance.msdk.api.v2.ad.custom.base.GMCustomBaseAdapter.CheckCallback
                public void callback() {
                    GMInterstitialAdListener gMInterstitialAdListener = (GMInterstitialAdListener) ((GMCustomBaseAdapter) GMCustomInterstitialAdapter.this).f14243d.getTTAdapterCallback();
                    if (gMInterstitialAdListener != null) {
                        gMInterstitialAdListener.onInterstitialClosed();
                    }
                }
            });
        }
    }

    @Override // com.bytedance.msdk.api.v2.ad.custom.interstitial.IGMCustomInterstitialEvent
    public final void callInterstitialShow() {
        if (this.f14243d != null) {
            checkLoadSuccess(new GMCustomBaseAdapter.CheckCallback() { // from class: com.bytedance.msdk.api.v2.ad.custom.interstitial.GMCustomInterstitialAdapter.1
                @Override // com.bytedance.msdk.api.v2.ad.custom.base.GMCustomBaseAdapter.CheckCallback
                public void callback() {
                    GMCustomInterstitialAdapter.this.checkShow(new GMCustomBaseAdapter.CheckCallback() { // from class: com.bytedance.msdk.api.v2.ad.custom.interstitial.GMCustomInterstitialAdapter.1.1
                        @Override // com.bytedance.msdk.api.v2.ad.custom.base.GMCustomBaseAdapter.CheckCallback
                        public void callback() {
                            GMInterstitialAdListener gMInterstitialAdListener = (GMInterstitialAdListener) ((GMCustomBaseAdapter) GMCustomInterstitialAdapter.this).f14243d.getTTAdapterCallback();
                            if (gMInterstitialAdListener != null) {
                                GMCustomInterstitialAdapter.this.f14268h = true;
                                gMInterstitialAdListener.onInterstitialShow();
                            }
                        }
                    });
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
            tTAbsAdLoaderAdapter.notifyAdFailed(new AdError(AdError.ERROR_CODE_CUSTOM_INTERSTITIAL_LOAD_ERROR, AdError.getMessage(AdError.ERROR_CODE_CUSTOM_INTERSTITIAL_LOAD_ERROR), gMCustomAdError == null ? -1 : gMCustomAdError.getCode(), gMCustomAdError == null ? "" : gMCustomAdError.getMessage()));
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
        this.f14243d = new GMCustomInterstitialAd();
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

    public abstract void load(Context context, GMAdSlotInterstitial gMAdSlotInterstitial, GMCustomServiceConfig gMCustomServiceConfig);

    @Override // com.bytedance.msdk.api.v2.ad.custom.base.GMCustomBaseAdapter
    public void loadCustom(Context context, GMAdSlotBase gMAdSlotBase, GMCustomServiceConfig gMCustomServiceConfig) {
        GMAdSlotInterstitial gMAdSlotInterstitial;
        if (gMAdSlotBase instanceof GMAdSlotInterstitialFull) {
            gMAdSlotInterstitial = ((GMAdSlotInterstitialFull) gMAdSlotBase).getGMAdSlotInterstitial();
        } else {
            if (!(gMAdSlotBase instanceof GMAdSlotInterstitial)) {
                callLoadFail(new GMCustomAdError(-99999, "ClassCastException：load ad fail adSlot is not GMAdSlotInterstitialFull or GMAdSlotInterstitial"));
                return;
            }
            gMAdSlotInterstitial = (GMAdSlotInterstitial) gMAdSlotBase;
        }
        load(context, gMAdSlotInterstitial, gMCustomServiceConfig);
    }

    public final void setMediaExtraInfo(Map<String, Object> map) {
        if (map != null) {
            this.f14246g = new HashMap();
            this.f14246g.putAll(map);
        }
    }
}
