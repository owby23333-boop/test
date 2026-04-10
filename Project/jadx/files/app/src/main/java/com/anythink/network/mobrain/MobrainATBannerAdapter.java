package com.anythink.network.mobrain;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.ItemTouchHelper;
import com.anythink.banner.unitgroup.api.CustomBannerAdapter;
import com.anythink.core.api.ATAdConst;
import com.anythink.core.api.ATBaseAdAdapter;
import com.anythink.core.api.ATCustomLoadListener;
import com.anythink.core.api.BaseAd;
import com.anythink.core.api.MediationInitCallback;
import com.bytedance.msdk.api.AdError;
import com.bytedance.msdk.api.v2.ad.banner.GMBannerAd;
import com.bytedance.msdk.api.v2.ad.banner.GMBannerAdListener;
import com.bytedance.msdk.api.v2.ad.banner.GMBannerAdLoadCallback;
import com.bytedance.msdk.api.v2.slot.GMAdSlotBanner;
import com.tencent.smtt.sdk.TbsListener;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public class MobrainATBannerAdapter extends CustomBannerAdapter {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final String f12535c = "MobrainATBannerAdapter";
    GMBannerAdLoadCallback a = new GMBannerAdLoadCallback() { // from class: com.anythink.network.mobrain.MobrainATBannerAdapter.2
        @Override // com.bytedance.msdk.api.v2.ad.banner.GMBannerAdLoadCallback
        public final void onAdFailedToLoad(AdError adError) {
            if (((ATBaseAdAdapter) MobrainATBannerAdapter.this).mLoadListener != null) {
                ((ATBaseAdAdapter) MobrainATBannerAdapter.this).mLoadListener.onAdLoadError(String.valueOf(adError.code), "Gromore: " + adError.toString());
            }
        }

        @Override // com.bytedance.msdk.api.v2.ad.banner.GMBannerAdLoadCallback
        public final void onAdLoaded() {
            MobrainATBannerAdapter mobrainATBannerAdapter = MobrainATBannerAdapter.this;
            mobrainATBannerAdapter.f12538f = mobrainATBannerAdapter.f12536d.getBannerView();
            MobrainATBannerAdapter.this.f12536d.setAdBannerListener(MobrainATBannerAdapter.this.b);
            if (((ATBaseAdAdapter) MobrainATBannerAdapter.this).mLoadListener != null) {
                ((ATBaseAdAdapter) MobrainATBannerAdapter.this).mLoadListener.onAdCacheLoaded(new BaseAd[0]);
            }
        }
    };
    GMBannerAdListener b = new GMBannerAdListener() { // from class: com.anythink.network.mobrain.MobrainATBannerAdapter.3
        @Override // com.bytedance.msdk.api.v2.ad.banner.GMBannerAdListener
        public final void onAdClicked() {
            if (((CustomBannerAdapter) MobrainATBannerAdapter.this).mImpressionEventListener != null) {
                ((CustomBannerAdapter) MobrainATBannerAdapter.this).mImpressionEventListener.onBannerAdClicked();
            }
        }

        @Override // com.bytedance.msdk.api.v2.ad.banner.GMBannerAdListener
        public final void onAdClosed() {
            if (((CustomBannerAdapter) MobrainATBannerAdapter.this).mImpressionEventListener != null) {
                ((CustomBannerAdapter) MobrainATBannerAdapter.this).mImpressionEventListener.onBannerAdClose();
            }
        }

        @Override // com.bytedance.msdk.api.v2.ad.banner.GMBannerAdListener
        public final void onAdLeftApplication() {
        }

        @Override // com.bytedance.msdk.api.v2.ad.banner.GMBannerAdListener
        public final void onAdOpened() {
        }

        @Override // com.bytedance.msdk.api.v2.ad.banner.GMBannerAdListener
        public final void onAdShow() {
            MobrainATBannerAdapter mobrainATBannerAdapter = MobrainATBannerAdapter.this;
            mobrainATBannerAdapter.f12540h = MobrainATConst.a(mobrainATBannerAdapter.f12536d);
            if (((CustomBannerAdapter) MobrainATBannerAdapter.this).mImpressionEventListener != null) {
                ((CustomBannerAdapter) MobrainATBannerAdapter.this).mImpressionEventListener.onBannerAdShow();
            }
        }

        @Override // com.bytedance.msdk.api.v2.ad.banner.GMBannerAdListener
        public final void onAdShowFail(AdError adError) {
            String unused = MobrainATBannerAdapter.f12535c;
            String str = "onAdShowFail: Gromore: " + adError.toString();
        }
    };

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private GMBannerAd f12536d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private String f12537e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private View f12538f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private MobrainConfig f12539g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private Map<String, Object> f12540h;

    @Override // com.anythink.core.api.ATBaseAdAdapter
    public void destory() {
        if (this.f12536d != null) {
            View view = this.f12538f;
            if (view != null && view.getParent() != null) {
                ((ViewGroup) this.f12538f.getParent()).removeView(this.f12538f);
            }
            this.f12536d = null;
        }
    }

    @Override // com.anythink.banner.unitgroup.api.CustomBannerAdapter
    public View getBannerView() {
        return this.f12538f;
    }

    @Override // com.anythink.core.api.ATBaseAdAdapter
    public Map<String, Object> getNetworkInfoMap() {
        return this.f12540h;
    }

    @Override // com.anythink.core.api.ATBaseAdAdapter
    public String getNetworkName() {
        return MobrainATInitManager.getInstance().getNetworkName();
    }

    @Override // com.anythink.core.api.ATBaseAdAdapter
    public String getNetworkPlacementId() {
        return this.f12537e;
    }

    @Override // com.anythink.core.api.ATBaseAdAdapter
    public String getNetworkSDKVersion() {
        return MobrainATInitManager.getInstance().getNetworkVersion();
    }

    @Override // com.anythink.core.api.ATBaseAdAdapter
    public void loadCustomNetworkAd(final Context context, Map<String, Object> map, Map<String, Object> map2) {
        String str = (String) map.get("slot_id");
        if (TextUtils.isEmpty(str)) {
            ATCustomLoadListener aTCustomLoadListener = this.mLoadListener;
            if (aTCustomLoadListener != null) {
                aTCustomLoadListener.onAdLoadError("", "Gromore: pl_id is empty!");
                return;
            }
            return;
        }
        if (!(context instanceof Activity)) {
            ATCustomLoadListener aTCustomLoadListener2 = this.mLoadListener;
            if (aTCustomLoadListener2 != null) {
                aTCustomLoadListener2.onAdLoadError("", "Gromore: Context must be Activity!");
                return;
            }
            return;
        }
        this.f12537e = str;
        this.f12539g = new MobrainConfig(context, 1);
        this.f12539g.a(map);
        MobrainConfig mobrainConfig = this.f12539g;
        String string = map2.get(ATAdConst.KEY.AD_WIDTH) != null ? map2.get(ATAdConst.KEY.AD_WIDTH).toString() : "";
        String string2 = map2.get(ATAdConst.KEY.AD_HEIGHT) != null ? map2.get(ATAdConst.KEY.AD_HEIGHT).toString() : "";
        int i2 = !TextUtils.isEmpty(string) ? Integer.parseInt(string) : 0;
        int i3 = !TextUtils.isEmpty(string2) ? Integer.parseInt(string2) : 0;
        if (i2 == 0 || i3 == 0) {
            switch (mobrainConfig.mSize) {
                case 1:
                    mobrainConfig.mHeight = (mobrainConfig.mWidth * 50) / TbsListener.ErrorCode.ERROR_SDKENGINE_INIT_THROWABLE;
                    break;
                case 2:
                    mobrainConfig.mHeight = (mobrainConfig.mWidth * 100) / TbsListener.ErrorCode.ERROR_SDKENGINE_INIT_THROWABLE;
                    break;
                case 3:
                    mobrainConfig.mHeight = (mobrainConfig.mWidth * ItemTouchHelper.Callback.DEFAULT_SWIPE_ANIMATION_DURATION) / TbsListener.ErrorCode.ERROR_SDKENGINE_INIT_THROWABLE;
                    break;
                case 4:
                    mobrainConfig.mHeight = (mobrainConfig.mWidth * 60) / 428;
                    break;
                case 5:
                    mobrainConfig.mHeight = (mobrainConfig.mWidth * 90) / 728;
                    break;
                case 6:
                    mobrainConfig.mHeight = 0;
                    break;
            }
        } else {
            mobrainConfig.mSize = 6;
            mobrainConfig.mWidth = i2;
            mobrainConfig.mHeight = i3;
        }
        try {
            if (map2.containsKey(ATAdConst.KEY.AD_SOUND)) {
                mobrainConfig.f12575f = Integer.parseInt(map2.get(ATAdConst.KEY.AD_SOUND).toString());
            }
        } catch (Throwable unused) {
        }
        MobrainATInitManager.getInstance().initSDK(context, map, new MediationInitCallback() { // from class: com.anythink.network.mobrain.MobrainATBannerAdapter.1
            @Override // com.anythink.core.api.MediationInitCallback
            public final void onFail(String str2) {
                if (((ATBaseAdAdapter) MobrainATBannerAdapter.this).mLoadListener != null) {
                    ((ATBaseAdAdapter) MobrainATBannerAdapter.this).mLoadListener.onAdLoadError("", "Gromore: ".concat(String.valueOf(str2)));
                }
            }

            @Override // com.anythink.core.api.MediationInitCallback
            public final void onSuccess() {
                MobrainATBannerAdapter.a(MobrainATBannerAdapter.this, (Activity) context);
            }
        });
    }

    private void a(Activity activity) {
        this.f12538f = null;
        this.f12536d = new GMBannerAd(activity, this.f12537e);
        GMAdSlotBanner.Builder imageAdSize = new GMAdSlotBanner.Builder().setBannerSize(this.f12539g.mSize).setMuted(this.f12539g.f12575f == 0).setAllowShowCloseBtn(this.f12539g.mShowCloseButton).setImageAdSize(a(activity, this.f12539g.mWidth), a(activity, this.f12539g.mHeight));
        int i2 = this.f12539g.mDownloadType;
        if (i2 != -1) {
            imageAdSize.setDownloadType(i2);
        }
        imageAdSize.setMuted(this.f12539g.f12575f == 0);
        this.f12536d.loadAd(imageAdSize.build(), this.a);
    }

    private static int a(Context context, float f2) {
        float f3 = context.getResources().getDisplayMetrics().density;
        if (f3 <= 0.0f) {
            f3 = 1.0f;
        }
        return (int) ((f2 / f3) + 0.5f);
    }

    static /* synthetic */ void a(MobrainATBannerAdapter mobrainATBannerAdapter, Activity activity) {
        mobrainATBannerAdapter.f12538f = null;
        mobrainATBannerAdapter.f12536d = new GMBannerAd(activity, mobrainATBannerAdapter.f12537e);
        GMAdSlotBanner.Builder imageAdSize = new GMAdSlotBanner.Builder().setBannerSize(mobrainATBannerAdapter.f12539g.mSize).setMuted(mobrainATBannerAdapter.f12539g.f12575f == 0).setAllowShowCloseBtn(mobrainATBannerAdapter.f12539g.mShowCloseButton).setImageAdSize(a(activity, mobrainATBannerAdapter.f12539g.mWidth), a(activity, mobrainATBannerAdapter.f12539g.mHeight));
        int i2 = mobrainATBannerAdapter.f12539g.mDownloadType;
        if (i2 != -1) {
            imageAdSize.setDownloadType(i2);
        }
        imageAdSize.setMuted(mobrainATBannerAdapter.f12539g.f12575f == 0);
        mobrainATBannerAdapter.f12536d.loadAd(imageAdSize.build(), mobrainATBannerAdapter.a);
    }
}
