package com.anythink.network.mobrain;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.anythink.core.api.ATBaseAdAdapter;
import com.anythink.core.api.ATCustomLoadListener;
import com.anythink.core.api.BaseAd;
import com.anythink.core.api.ErrorCode;
import com.anythink.core.api.MediationInitCallback;
import com.anythink.network.mobrain.MobrainConfig;
import com.anythink.splashad.api.ATSplashEyeAdListener;
import com.anythink.splashad.api.IATSplashEyeAd;
import com.anythink.splashad.unitgroup.api.CustomSplashAdapter;
import com.anythink.splashad.unitgroup.api.CustomSplashEventListener;
import com.bytedance.msdk.adapter.pangle.PangleNetworkRequestInfo;
import com.bytedance.msdk.api.AdError;
import com.bytedance.msdk.api.v2.ad.splash.GMSplashAd;
import com.bytedance.msdk.api.v2.ad.splash.GMSplashAdListener;
import com.bytedance.msdk.api.v2.ad.splash.GMSplashAdLoadCallback;
import com.bytedance.msdk.api.v2.ad.splash.GMSplashMinWindowListener;
import com.bytedance.msdk.api.v2.slot.GMAdSlotSplash;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class MobrainATSplashAdapter extends CustomSplashAdapter {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final String f12565e = "MobrainATSplashAdapter";
    boolean a;
    MobrainATSplashEyeAd b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    ViewGroup f12566c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    GMSplashAdListener f12567d = new GMSplashAdListener() { // from class: com.anythink.network.mobrain.MobrainATSplashAdapter.4
        @Override // com.bytedance.msdk.api.v2.ad.splash.GMSplashAdListener
        public final void onAdClicked() {
            if (((CustomSplashAdapter) MobrainATSplashAdapter.this).mImpressionListener != null) {
                ((CustomSplashAdapter) MobrainATSplashAdapter.this).mImpressionListener.onSplashAdClicked();
            }
        }

        @Override // com.bytedance.msdk.api.v2.ad.splash.GMSplashAdListener
        public final void onAdDismiss() {
            MobrainATSplashAdapter.u(MobrainATSplashAdapter.this);
            if (((CustomSplashAdapter) MobrainATSplashAdapter.this).mImpressionListener != null) {
                ((CustomSplashAdapter) MobrainATSplashAdapter.this).mImpressionListener.onSplashAdDismiss();
            }
        }

        @Override // com.bytedance.msdk.api.v2.ad.splash.GMSplashAdListener
        public final void onAdShow() {
            MobrainATSplashAdapter mobrainATSplashAdapter = MobrainATSplashAdapter.this;
            mobrainATSplashAdapter.f12571i = MobrainATConst.a(mobrainATSplashAdapter.f12568f);
            if (((CustomSplashAdapter) MobrainATSplashAdapter.this).mImpressionListener != null) {
                ((CustomSplashAdapter) MobrainATSplashAdapter.this).mImpressionListener.onSplashAdShow();
            }
        }

        @Override // com.bytedance.msdk.api.v2.ad.splash.GMSplashAdListener
        public final void onAdShowFail(AdError adError) {
            String unused = MobrainATSplashAdapter.f12565e;
            String str = "onAdShowFail: Gromore: " + adError.toString();
            MobrainATSplashAdapter.n(MobrainATSplashAdapter.this);
            if (((CustomSplashAdapter) MobrainATSplashAdapter.this).mImpressionListener != null) {
                CustomSplashEventListener customSplashEventListener = ((CustomSplashAdapter) MobrainATSplashAdapter.this).mImpressionListener;
                StringBuilder sb = new StringBuilder();
                sb.append(adError.code);
                customSplashEventListener.onSplashAdShowFail(ErrorCode.getErrorCode(ErrorCode.adShowError, sb.toString(), adError.toString()));
                ((CustomSplashAdapter) MobrainATSplashAdapter.this).mImpressionListener.onSplashAdDismiss();
            }
        }

        @Override // com.bytedance.msdk.api.v2.ad.splash.GMSplashAdListener
        public final void onAdSkip() {
            MobrainATSplashAdapter.r(MobrainATSplashAdapter.this);
            if (((CustomSplashAdapter) MobrainATSplashAdapter.this).mImpressionListener != null) {
                ((CustomSplashAdapter) MobrainATSplashAdapter.this).mImpressionListener.onSplashAdDismiss();
            }
        }
    };

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private GMSplashAd f12568f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private String f12569g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private MobrainConfig f12570h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private Map<String, Object> f12571i;

    /* JADX INFO: renamed from: com.anythink.network.mobrain.MobrainATSplashAdapter$1, reason: invalid class name */
    final class AnonymousClass1 implements GMSplashMinWindowListener {
        AnonymousClass1() {
        }

        @Override // com.bytedance.msdk.api.v2.ad.splash.GMSplashMinWindowListener
        public final void onMinWindowPlayFinish() {
            MobrainATSplashEyeAd mobrainATSplashEyeAd;
            ATSplashEyeAdListener splashEyeAdListener;
            MobrainATSplashAdapter mobrainATSplashAdapter = MobrainATSplashAdapter.this;
            if (!mobrainATSplashAdapter.a || (mobrainATSplashEyeAd = mobrainATSplashAdapter.b) == null || (splashEyeAdListener = mobrainATSplashEyeAd.getSplashEyeAdListener()) == null) {
                return;
            }
            splashEyeAdListener.onAdDismiss(true, "");
        }

        @Override // com.bytedance.msdk.api.v2.ad.splash.GMSplashMinWindowListener
        public final void onMinWindowStart() {
            MobrainATSplashAdapter mobrainATSplashAdapter = MobrainATSplashAdapter.this;
            mobrainATSplashAdapter.a = true;
            mobrainATSplashAdapter.b = new MobrainATSplashEyeAd(mobrainATSplashAdapter, mobrainATSplashAdapter.f12568f);
            MobrainATSplashAdapter mobrainATSplashAdapter2 = MobrainATSplashAdapter.this;
            mobrainATSplashAdapter2.b.setSplashView(mobrainATSplashAdapter2.f12566c);
        }
    }

    /* JADX INFO: renamed from: com.anythink.network.mobrain.MobrainATSplashAdapter$2, reason: invalid class name */
    final class AnonymousClass2 implements GMSplashAdLoadCallback {
        AnonymousClass2() {
        }

        @Override // com.bytedance.msdk.api.v2.ad.splash.GMSplashAdLoadCallback
        public final void onAdLoadTimeout() {
            if (((ATBaseAdAdapter) MobrainATSplashAdapter.this).mLoadListener != null) {
                ((ATBaseAdAdapter) MobrainATSplashAdapter.this).mLoadListener.onAdLoadError("", "Gromore: onAdLoadTimeout()");
            }
        }

        @Override // com.bytedance.msdk.api.v2.ad.splash.GMSplashAdLoadCallback
        public final void onSplashAdLoadFail(AdError adError) {
            if (((ATBaseAdAdapter) MobrainATSplashAdapter.this).mLoadListener != null) {
                ((ATBaseAdAdapter) MobrainATSplashAdapter.this).mLoadListener.onAdLoadError(String.valueOf(adError.code), "Gromore: " + adError.toString());
            }
        }

        @Override // com.bytedance.msdk.api.v2.ad.splash.GMSplashAdLoadCallback
        public final void onSplashAdLoadSuccess() {
            if (((ATBaseAdAdapter) MobrainATSplashAdapter.this).mLoadListener != null) {
                ((ATBaseAdAdapter) MobrainATSplashAdapter.this).mLoadListener.onAdCacheLoaded(new BaseAd[0]);
            }
        }
    }

    static /* synthetic */ int n(MobrainATSplashAdapter mobrainATSplashAdapter) {
        mobrainATSplashAdapter.mDismissType = 99;
        return 99;
    }

    static /* synthetic */ int r(MobrainATSplashAdapter mobrainATSplashAdapter) {
        mobrainATSplashAdapter.mDismissType = 2;
        return 2;
    }

    static /* synthetic */ int u(MobrainATSplashAdapter mobrainATSplashAdapter) {
        mobrainATSplashAdapter.mDismissType = 3;
        return 3;
    }

    @Override // com.anythink.core.api.ATBaseAdAdapter
    public void destory() {
        GMSplashAd gMSplashAd = this.f12568f;
        if (gMSplashAd != null) {
            gMSplashAd.destroy();
            this.f12568f = null;
        }
    }

    @Override // com.anythink.core.api.ATBaseAdAdapter
    public Map<String, Object> getNetworkInfoMap() {
        return this.f12571i;
    }

    @Override // com.anythink.core.api.ATBaseAdAdapter
    public String getNetworkName() {
        return MobrainATInitManager.getInstance().getNetworkName();
    }

    @Override // com.anythink.core.api.ATBaseAdAdapter
    public String getNetworkPlacementId() {
        return this.f12569g;
    }

    @Override // com.anythink.core.api.ATBaseAdAdapter
    public String getNetworkSDKVersion() {
        return MobrainATInitManager.getInstance().getNetworkVersion();
    }

    @Override // com.anythink.splashad.unitgroup.api.CustomSplashAdapter
    public IATSplashEyeAd getSplashEyeAd() {
        return this.b;
    }

    @Override // com.anythink.core.api.ATBaseAdAdapter
    public boolean isAdReady() {
        GMSplashAd gMSplashAd = this.f12568f;
        return gMSplashAd != null && gMSplashAd.isReady();
    }

    @Override // com.anythink.core.api.ATBaseAdAdapter
    public void loadCustomNetworkAd(final Context context, Map<String, Object> map, Map<String, Object> map2) {
        if (!(context instanceof Activity)) {
            ATCustomLoadListener aTCustomLoadListener = this.mLoadListener;
            if (aTCustomLoadListener != null) {
                aTCustomLoadListener.onAdLoadError("", "Gromore: context must be activity");
                return;
            }
            return;
        }
        String str = (String) map.get("slot_id");
        if (TextUtils.isEmpty(str)) {
            ATCustomLoadListener aTCustomLoadListener2 = this.mLoadListener;
            if (aTCustomLoadListener2 != null) {
                aTCustomLoadListener2.onAdLoadError("", "Gromore: pl_id is empty!");
                return;
            }
            return;
        }
        this.f12569g = str;
        this.f12570h = new MobrainConfig(context, 1);
        this.f12570h.a(map);
        this.f12570h.b(map2);
        MobrainConfig mobrainConfig = this.f12570h;
        if (map.containsKey("default_info")) {
            try {
                JSONObject jSONObject = new JSONObject(map.get("default_info").toString());
                try {
                    mobrainConfig.a = Integer.parseInt(jSONObject.optString(MobrainConfig.KEY.MOBRAIN_SPLASH_NETWORK_FIRM_ID));
                } catch (Throwable unused) {
                }
                try {
                    mobrainConfig.b = jSONObject.optString(MobrainConfig.KEY.MORBAIN_DEFAULT_APP_ID);
                } catch (Throwable unused2) {
                }
                mobrainConfig.f12573d = jSONObject.optString(MobrainConfig.KEY.MORBAIN_DEFAULT_PLACEMENT_ID);
            } catch (Throwable unused3) {
            }
        }
        this.f12570h.f12574e = this.mFetchAdTimeout;
        MobrainATInitManager.getInstance().initSDK(context, map, new MediationInitCallback() { // from class: com.anythink.network.mobrain.MobrainATSplashAdapter.3
            @Override // com.anythink.core.api.MediationInitCallback
            public final void onFail(String str2) {
                if (((ATBaseAdAdapter) MobrainATSplashAdapter.this).mLoadListener != null) {
                    ((ATBaseAdAdapter) MobrainATSplashAdapter.this).mLoadListener.onAdLoadError("", "Gromore: ".concat(String.valueOf(str2)));
                }
            }

            @Override // com.anythink.core.api.MediationInitCallback
            public final void onSuccess() {
                MobrainATSplashAdapter.a(MobrainATSplashAdapter.this, (Activity) context);
            }
        });
    }

    @Override // com.anythink.splashad.unitgroup.api.CustomSplashAdapter
    public void show(Activity activity, ViewGroup viewGroup) {
        if (!isAdReady() || this.f12568f == null) {
            return;
        }
        this.f12566c = new FrameLayout(viewGroup.getContext());
        viewGroup.addView(this.f12566c, new ViewGroup.LayoutParams(-1, -1));
        this.f12568f.setAdSplashListener(this.f12567d);
        this.f12568f.showAd(this.f12566c);
    }

    private void a(Activity activity) {
        this.f12568f = new GMSplashAd(activity, this.f12569g);
        this.f12568f.setMinWindowListener(new AnonymousClass1());
        GMAdSlotSplash.Builder timeOut = new GMAdSlotSplash.Builder().setMuted(this.f12570h.f12575f == 0).setTimeOut((int) this.f12570h.f12574e);
        MobrainConfig mobrainConfig = this.f12570h;
        GMAdSlotSplash.Builder imageAdSize = timeOut.setImageAdSize(mobrainConfig.mWidth, mobrainConfig.mHeight);
        int i2 = this.f12570h.mSplashButtonType;
        if (i2 != -1) {
            imageAdSize.setSplashButtonType(i2);
        }
        int i3 = this.f12570h.mDownloadType;
        if (i3 != -1) {
            imageAdSize.setDownloadType(i3);
        }
        GMAdSlotSplash gMAdSlotSplashBuild = imageAdSize.build();
        PangleNetworkRequestInfo pangleNetworkRequestInfo = null;
        MobrainConfig mobrainConfig2 = this.f12570h;
        if (mobrainConfig2.a == 15 && !TextUtils.isEmpty(mobrainConfig2.b) && !TextUtils.isEmpty(this.f12570h.f12573d)) {
            MobrainConfig mobrainConfig3 = this.f12570h;
            pangleNetworkRequestInfo = new PangleNetworkRequestInfo(mobrainConfig3.b, mobrainConfig3.f12573d);
        }
        this.f12568f.loadAd(gMAdSlotSplashBuild, pangleNetworkRequestInfo, new AnonymousClass2());
    }

    static /* synthetic */ void a(MobrainATSplashAdapter mobrainATSplashAdapter, Activity activity) {
        mobrainATSplashAdapter.f12568f = new GMSplashAd(activity, mobrainATSplashAdapter.f12569g);
        mobrainATSplashAdapter.f12568f.setMinWindowListener(mobrainATSplashAdapter.new AnonymousClass1());
        GMAdSlotSplash.Builder timeOut = new GMAdSlotSplash.Builder().setMuted(mobrainATSplashAdapter.f12570h.f12575f == 0).setTimeOut((int) mobrainATSplashAdapter.f12570h.f12574e);
        MobrainConfig mobrainConfig = mobrainATSplashAdapter.f12570h;
        GMAdSlotSplash.Builder imageAdSize = timeOut.setImageAdSize(mobrainConfig.mWidth, mobrainConfig.mHeight);
        int i2 = mobrainATSplashAdapter.f12570h.mSplashButtonType;
        if (i2 != -1) {
            imageAdSize.setSplashButtonType(i2);
        }
        int i3 = mobrainATSplashAdapter.f12570h.mDownloadType;
        if (i3 != -1) {
            imageAdSize.setDownloadType(i3);
        }
        GMAdSlotSplash gMAdSlotSplashBuild = imageAdSize.build();
        PangleNetworkRequestInfo pangleNetworkRequestInfo = null;
        MobrainConfig mobrainConfig2 = mobrainATSplashAdapter.f12570h;
        if (mobrainConfig2.a == 15 && !TextUtils.isEmpty(mobrainConfig2.b) && !TextUtils.isEmpty(mobrainATSplashAdapter.f12570h.f12573d)) {
            MobrainConfig mobrainConfig3 = mobrainATSplashAdapter.f12570h;
            pangleNetworkRequestInfo = new PangleNetworkRequestInfo(mobrainConfig3.b, mobrainConfig3.f12573d);
        }
        mobrainATSplashAdapter.f12568f.loadAd(gMAdSlotSplashBuild, pangleNetworkRequestInfo, mobrainATSplashAdapter.new AnonymousClass2());
    }
}
