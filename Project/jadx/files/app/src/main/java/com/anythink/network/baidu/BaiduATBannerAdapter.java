package com.anythink.network.baidu;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.anythink.banner.unitgroup.api.CustomBannerAdapter;
import com.anythink.core.api.ATBaseAdAdapter;
import com.anythink.core.api.ATCustomLoadListener;
import com.anythink.core.api.ATInitMediation;
import com.anythink.core.api.BaseAd;
import com.anythink.core.api.MediationInitCallback;
import com.baidu.mobads.sdk.api.AdView;
import com.baidu.mobads.sdk.api.AdViewListener;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class BaiduATBannerAdapter extends CustomBannerAdapter {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final String f12338d = "BaiduATBannerAdapter";
    String a;
    AdView b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    FrameLayout f12339c;

    /* JADX INFO: renamed from: com.anythink.network.baidu.BaiduATBannerAdapter$1, reason: invalid class name */
    final class AnonymousClass1 implements AdViewListener {
        AnonymousClass1() {
        }

        @Override // com.baidu.mobads.sdk.api.AdViewListener
        public final void onAdClick(JSONObject jSONObject) {
            if (((CustomBannerAdapter) BaiduATBannerAdapter.this).mImpressionEventListener != null) {
                ((CustomBannerAdapter) BaiduATBannerAdapter.this).mImpressionEventListener.onBannerAdClicked();
            }
        }

        @Override // com.baidu.mobads.sdk.api.AdViewListener
        public final void onAdClose(JSONObject jSONObject) {
            if (((CustomBannerAdapter) BaiduATBannerAdapter.this).mImpressionEventListener != null) {
                ((CustomBannerAdapter) BaiduATBannerAdapter.this).mImpressionEventListener.onBannerAdClose();
            }
        }

        @Override // com.baidu.mobads.sdk.api.AdViewListener
        public final void onAdFailed(String str) {
            if (((ATBaseAdAdapter) BaiduATBannerAdapter.this).mLoadListener != null) {
                ((ATBaseAdAdapter) BaiduATBannerAdapter.this).mLoadListener.onAdLoadError("", str);
            }
        }

        @Override // com.baidu.mobads.sdk.api.AdViewListener
        public final void onAdReady(AdView adView) {
        }

        @Override // com.baidu.mobads.sdk.api.AdViewListener
        public final void onAdShow(JSONObject jSONObject) {
            if (((ATBaseAdAdapter) BaiduATBannerAdapter.this).mLoadListener != null) {
                ((ATBaseAdAdapter) BaiduATBannerAdapter.this).mLoadListener.onAdCacheLoaded(new BaseAd[0]);
            }
        }

        @Override // com.baidu.mobads.sdk.api.AdViewListener
        public final void onAdSwitch() {
        }
    }

    /* JADX INFO: renamed from: com.anythink.network.baidu.BaiduATBannerAdapter$2, reason: invalid class name */
    final class AnonymousClass2 implements Runnable {
        final /* synthetic */ Context a;

        AnonymousClass2(Context context) {
            this.a = context;
        }

        @Override // java.lang.Runnable
        public final void run() {
            BaiduATBannerAdapter.this.f12339c = new FrameLayout(this.a);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
            BaiduATBannerAdapter baiduATBannerAdapter = BaiduATBannerAdapter.this;
            baiduATBannerAdapter.f12339c.addView(baiduATBannerAdapter.b, layoutParams);
            BaiduATBannerAdapter.this.f12339c.setVisibility(4);
            final ViewGroup viewGroup = (ViewGroup) ((Activity) this.a).getWindow().getDecorView();
            viewGroup.addView(BaiduATBannerAdapter.this.f12339c);
            BaiduATBannerAdapter.this.postOnMainThreadDelayed(new Runnable() { // from class: com.anythink.network.baidu.BaiduATBannerAdapter.2.1
                @Override // java.lang.Runnable
                public final void run() {
                    viewGroup.removeView(BaiduATBannerAdapter.this.f12339c);
                }
            }, 100L);
        }
    }

    @Override // com.anythink.core.api.ATBaseAdAdapter
    public void destory() {
        AdView adView = this.b;
        if (adView != null) {
            adView.setListener(null);
            this.b.destroy();
            this.b = null;
        }
    }

    @Override // com.anythink.banner.unitgroup.api.CustomBannerAdapter
    public View getBannerView() {
        return this.b;
    }

    @Override // com.anythink.core.api.ATBaseAdAdapter
    public String getNetworkName() {
        return BaiduATInitManager.getInstance().getNetworkName();
    }

    @Override // com.anythink.core.api.ATBaseAdAdapter
    public String getNetworkPlacementId() {
        return this.a;
    }

    @Override // com.anythink.core.api.ATBaseAdAdapter
    public String getNetworkSDKVersion() {
        return BaiduATInitManager.getInstance().getNetworkVersion();
    }

    @Override // com.anythink.core.api.ATBaseAdAdapter
    public void loadCustomNetworkAd(final Context context, Map<String, Object> map, Map<String, Object> map2) {
        String stringFromMap = ATInitMediation.getStringFromMap(map, "app_id");
        this.a = ATInitMediation.getStringFromMap(map, "ad_place_id");
        if (TextUtils.isEmpty(stringFromMap) || TextUtils.isEmpty(this.a)) {
            ATCustomLoadListener aTCustomLoadListener = this.mLoadListener;
            if (aTCustomLoadListener != null) {
                aTCustomLoadListener.onAdLoadError("", "app_id or ad_place_id is empty.");
                return;
            }
            return;
        }
        if (context instanceof Activity) {
            BaiduATInitManager.getInstance().initSDK(context, map, new MediationInitCallback() { // from class: com.anythink.network.baidu.BaiduATBannerAdapter.3
                @Override // com.anythink.core.api.MediationInitCallback
                public final void onFail(String str) {
                    if (((ATBaseAdAdapter) BaiduATBannerAdapter.this).mLoadListener != null) {
                        ((ATBaseAdAdapter) BaiduATBannerAdapter.this).mLoadListener.onAdLoadError("", str);
                    }
                }

                @Override // com.anythink.core.api.MediationInitCallback
                public final void onSuccess() {
                    try {
                        BaiduATBannerAdapter.a(BaiduATBannerAdapter.this, context);
                    } catch (Throwable th) {
                        th.printStackTrace();
                        if (((ATBaseAdAdapter) BaiduATBannerAdapter.this).mLoadListener != null) {
                            ((ATBaseAdAdapter) BaiduATBannerAdapter.this).mLoadListener.onAdLoadError("", "Baidu: init error, " + th.getMessage());
                        }
                    }
                }
            });
            return;
        }
        ATCustomLoadListener aTCustomLoadListener2 = this.mLoadListener;
        if (aTCustomLoadListener2 != null) {
            aTCustomLoadListener2.onAdLoadError("", "Baidu Banner's context must be activity.");
        }
    }

    @Override // com.anythink.core.api.ATBaseAdAdapter
    public boolean supportImpressionCallback() {
        return false;
    }

    private void a(Context context) {
        this.b = new AdView(context, this.a);
        this.b.setListener(new AnonymousClass1());
        postOnMainThread(new AnonymousClass2(context));
    }

    private void a() {
        AdView adView = this.b;
        if (adView != null && (adView.getParent() instanceof ViewGroup)) {
            ((ViewGroup) this.b.getParent()).removeView(this.b);
        }
        FrameLayout frameLayout = this.f12339c;
        if (frameLayout == null || !(frameLayout.getParent() instanceof ViewGroup)) {
            return;
        }
        ((ViewGroup) this.f12339c.getParent()).removeView(this.f12339c);
    }

    static /* synthetic */ void a(BaiduATBannerAdapter baiduATBannerAdapter, Context context) {
        baiduATBannerAdapter.b = new AdView(context, baiduATBannerAdapter.a);
        baiduATBannerAdapter.b.setListener(baiduATBannerAdapter.new AnonymousClass1());
        baiduATBannerAdapter.postOnMainThread(baiduATBannerAdapter.new AnonymousClass2(context));
    }
}
