package com.bytedance.msdk.api.v2.ad.custom.splash;

import android.content.Context;
import android.view.ViewGroup;
import com.bytedance.msdk.adapter.TTAbsAdLoaderAdapter;
import com.bytedance.msdk.adapter.pangle.PangleAdapterUtils;
import com.bytedance.msdk.adapter.util.Logger;
import com.bytedance.msdk.api.AdError;
import com.bytedance.msdk.api.v2.ad.custom.GMCustomAdError;
import com.bytedance.msdk.api.v2.ad.custom.base.GMCustomBaseAdapter;
import com.bytedance.msdk.api.v2.ad.custom.base.IGMCustomLoadAdCall;
import com.bytedance.msdk.api.v2.ad.custom.bean.GMCustomServiceConfig;
import com.bytedance.msdk.api.v2.ad.splash.GMSplashAdListener;
import com.bytedance.msdk.api.v2.slot.GMAdSlotBase;
import com.bytedance.msdk.api.v2.slot.GMAdSlotSplash;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public abstract class GMCustomSplashAdapter extends GMCustomBaseAdapter implements IGMCustomSplashEvent, IGMCustomLoadAdCall {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private volatile boolean f14294h = false;

    @Override // com.bytedance.msdk.api.v2.ad.custom.base.IGMCustomLoadAdCall
    public final void callLoadFail(GMCustomAdError gMCustomAdError) {
        if (isCallLoadFailCall()) {
            Logger.e("TTMediationSDK", "自定义Adapter 加载成功或者失败回调只能调用一次");
            return;
        }
        TTAbsAdLoaderAdapter tTAbsAdLoaderAdapter = this.f14242c;
        if (tTAbsAdLoaderAdapter != null) {
            tTAbsAdLoaderAdapter.notifyAdFailed(new AdError(AdError.ERROR_CODE_CUSTOM_SPLASH_LOAD_ERROR, AdError.getMessage(AdError.ERROR_CODE_CUSTOM_SPLASH_LOAD_ERROR), gMCustomAdError == null ? -1 : gMCustomAdError.getCode(), gMCustomAdError == null ? "" : gMCustomAdError.getMessage()));
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
        this.f14243d = new GMCustomSplashAd();
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

    @Override // com.bytedance.msdk.api.v2.ad.custom.splash.IGMCustomSplashEvent
    public final void callSplashAdClicked() {
        if (this.f14294h && this.f14243d != null) {
            checkLoadSuccess(new GMCustomBaseAdapter.CheckCallback() { // from class: com.bytedance.msdk.api.v2.ad.custom.splash.GMCustomSplashAdapter.1
                @Override // com.bytedance.msdk.api.v2.ad.custom.base.GMCustomBaseAdapter.CheckCallback
                public void callback() {
                    GMCustomSplashAdapter.this.checkClick(new GMCustomBaseAdapter.CheckCallback() { // from class: com.bytedance.msdk.api.v2.ad.custom.splash.GMCustomSplashAdapter.1.1
                        @Override // com.bytedance.msdk.api.v2.ad.custom.base.GMCustomBaseAdapter.CheckCallback
                        public void callback() {
                            GMSplashAdListener gMSplashAdListener = (GMSplashAdListener) ((GMCustomBaseAdapter) GMCustomSplashAdapter.this).f14243d.getTTAdapterCallback();
                            if (gMSplashAdListener != null) {
                                gMSplashAdListener.onAdClicked();
                            }
                        }
                    });
                }
            });
        }
    }

    @Override // com.bytedance.msdk.api.v2.ad.custom.splash.IGMCustomSplashEvent
    public final void callSplashAdDismiss() {
        if (this.f14294h && this.f14243d != null) {
            checkLoadSuccess(new GMCustomBaseAdapter.CheckCallback() { // from class: com.bytedance.msdk.api.v2.ad.custom.splash.GMCustomSplashAdapter.4
                @Override // com.bytedance.msdk.api.v2.ad.custom.base.GMCustomBaseAdapter.CheckCallback
                public void callback() {
                    GMSplashAdListener gMSplashAdListener = (GMSplashAdListener) ((GMCustomBaseAdapter) GMCustomSplashAdapter.this).f14243d.getTTAdapterCallback();
                    if (gMSplashAdListener != null) {
                        gMSplashAdListener.onAdDismiss();
                    }
                }
            });
        }
    }

    @Override // com.bytedance.msdk.api.v2.ad.custom.splash.IGMCustomSplashEvent
    public final void callSplashAdShow() {
        if (this.f14243d != null) {
            checkLoadSuccess(new GMCustomBaseAdapter.CheckCallback() { // from class: com.bytedance.msdk.api.v2.ad.custom.splash.GMCustomSplashAdapter.2
                @Override // com.bytedance.msdk.api.v2.ad.custom.base.GMCustomBaseAdapter.CheckCallback
                public void callback() {
                    GMCustomSplashAdapter.this.checkShow(new GMCustomBaseAdapter.CheckCallback() { // from class: com.bytedance.msdk.api.v2.ad.custom.splash.GMCustomSplashAdapter.2.1
                        @Override // com.bytedance.msdk.api.v2.ad.custom.base.GMCustomBaseAdapter.CheckCallback
                        public void callback() {
                            GMSplashAdListener gMSplashAdListener = (GMSplashAdListener) ((GMCustomBaseAdapter) GMCustomSplashAdapter.this).f14243d.getTTAdapterCallback();
                            if (gMSplashAdListener != null) {
                                GMCustomSplashAdapter.this.f14294h = true;
                                gMSplashAdListener.onAdShow();
                            }
                        }
                    });
                }
            });
        }
    }

    @Override // com.bytedance.msdk.api.v2.ad.custom.splash.IGMCustomSplashEvent
    public final void callSplashAdSkip() {
        if (this.f14294h && this.f14243d != null) {
            checkLoadSuccess(new GMCustomBaseAdapter.CheckCallback() { // from class: com.bytedance.msdk.api.v2.ad.custom.splash.GMCustomSplashAdapter.3
                @Override // com.bytedance.msdk.api.v2.ad.custom.base.GMCustomBaseAdapter.CheckCallback
                public void callback() {
                    GMSplashAdListener gMSplashAdListener = (GMSplashAdListener) ((GMCustomBaseAdapter) GMCustomSplashAdapter.this).f14243d.getTTAdapterCallback();
                    if (gMSplashAdListener != null) {
                        gMSplashAdListener.onAdSkip();
                    }
                }
            });
        }
    }

    public abstract void load(Context context, GMAdSlotSplash gMAdSlotSplash, GMCustomServiceConfig gMCustomServiceConfig);

    @Override // com.bytedance.msdk.api.v2.ad.custom.base.GMCustomBaseAdapter
    public void loadCustom(Context context, GMAdSlotBase gMAdSlotBase, GMCustomServiceConfig gMCustomServiceConfig) {
        if (gMAdSlotBase instanceof GMAdSlotSplash) {
            load(context, (GMAdSlotSplash) gMAdSlotBase, gMCustomServiceConfig);
        } else {
            callLoadFail(new GMCustomAdError(-99999, "ClassCastException：load ad fail adSlot is not GMAdSlotSplash"));
        }
    }

    public final void setMediaExtraInfo(Map<String, Object> map) {
        if (map != null) {
            this.f14246g = new HashMap();
            this.f14246g.putAll(map);
        }
    }

    public abstract void showAd(ViewGroup viewGroup);

    public final void showAdInner(ViewGroup viewGroup) {
        try {
            this.a = true;
            showAd(viewGroup);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }
}
