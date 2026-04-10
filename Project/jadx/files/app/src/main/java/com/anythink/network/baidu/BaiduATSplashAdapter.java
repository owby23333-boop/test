package com.anythink.network.baidu;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import android.view.ViewGroup;
import com.anythink.core.api.ATAdConst;
import com.anythink.core.api.ATBaseAdAdapter;
import com.anythink.core.api.ATBiddingListener;
import com.anythink.core.api.ATBiddingResult;
import com.anythink.core.api.ATCustomLoadListener;
import com.anythink.core.api.ATInitMediation;
import com.anythink.core.api.ATSDK;
import com.anythink.core.api.BaseAd;
import com.anythink.core.api.ErrorCode;
import com.anythink.core.api.MediationInitCallback;
import com.anythink.splashad.unitgroup.api.CustomSplashAdapter;
import com.anythink.splashad.unitgroup.api.CustomSplashEventListener;
import com.baidu.mobads.sdk.api.RequestParameters;
import com.baidu.mobads.sdk.api.SplashAd;
import com.baidu.mobads.sdk.api.SplashInteractionListener;
import com.bytedance.msdk.adapter.pangle.PangleAdapterUtils;
import com.umeng.message.common.inter.ITagManager;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public class BaiduATSplashAdapter extends CustomSplashAdapter {
    SplashAd b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    String f12376c;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final String f12380g = BaiduATSplashAdapter.class.getSimpleName();
    String a = "";

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private double f12381h = PangleAdapterUtils.CPM_DEFLAUT_VALUE;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    boolean f12377d = false;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    boolean f12378e = false;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    boolean f12379f = false;

    /* JADX INFO: renamed from: com.anythink.network.baidu.BaiduATSplashAdapter$1, reason: invalid class name */
    final class AnonymousClass1 implements SplashInteractionListener {
        AnonymousClass1() {
        }

        @Override // com.baidu.mobads.sdk.api.SplashAdListener
        public final void onADLoaded() {
        }

        @Override // com.baidu.mobads.sdk.api.SplashInteractionListener
        public final void onAdCacheFailed() {
            BaiduATSplashAdapter baiduATSplashAdapter = BaiduATSplashAdapter.this;
            if (baiduATSplashAdapter.f12378e) {
                return;
            }
            baiduATSplashAdapter.notifyATLoadFail("", "onAdCacheFailed");
        }

        @Override // com.baidu.mobads.sdk.api.SplashInteractionListener
        public final void onAdCacheSuccess() {
            BaiduATSplashAdapter baiduATSplashAdapter = BaiduATSplashAdapter.this;
            baiduATSplashAdapter.f12378e = true;
            BaiduATSplashAdapter.l(baiduATSplashAdapter);
        }

        @Override // com.baidu.mobads.sdk.api.SplashInteractionListener
        public final void onAdClick() {
            if (((CustomSplashAdapter) BaiduATSplashAdapter.this).mImpressionListener != null) {
                ((CustomSplashAdapter) BaiduATSplashAdapter.this).mImpressionListener.onSplashAdClicked();
            }
        }

        @Override // com.baidu.mobads.sdk.api.SplashInteractionListener
        public final void onAdDismissed() {
            if (((CustomSplashAdapter) BaiduATSplashAdapter.this).mImpressionListener != null) {
                ((CustomSplashAdapter) BaiduATSplashAdapter.this).mImpressionListener.onSplashAdDismiss();
            }
        }

        @Override // com.baidu.mobads.sdk.api.SplashAdListener
        public final void onAdFailed(String str) {
            BaiduATSplashAdapter baiduATSplashAdapter = BaiduATSplashAdapter.this;
            if (!baiduATSplashAdapter.f12378e) {
                baiduATSplashAdapter.notifyATLoadFail("", str);
                return;
            }
            String unused = baiduATSplashAdapter.f12380g;
            "onAdFailed: ".concat(String.valueOf(str));
            BaiduATSplashAdapter.d(BaiduATSplashAdapter.this);
            if (((CustomSplashAdapter) BaiduATSplashAdapter.this).mImpressionListener != null) {
                ((CustomSplashAdapter) BaiduATSplashAdapter.this).mImpressionListener.onSplashAdShowFail(ErrorCode.getErrorCode(ErrorCode.adShowError, "", str));
                ((CustomSplashAdapter) BaiduATSplashAdapter.this).mImpressionListener.onSplashAdDismiss();
            }
        }

        @Override // com.baidu.mobads.sdk.api.SplashInteractionListener
        public final void onAdPresent() {
            if (((CustomSplashAdapter) BaiduATSplashAdapter.this).mImpressionListener != null) {
                ((CustomSplashAdapter) BaiduATSplashAdapter.this).mImpressionListener.onSplashAdShow();
            }
        }

        @Override // com.baidu.mobads.sdk.api.SplashInteractionListener
        public final void onLpClosed() {
        }
    }

    static /* synthetic */ int d(BaiduATSplashAdapter baiduATSplashAdapter) {
        baiduATSplashAdapter.mDismissType = 99;
        return 99;
    }

    static /* synthetic */ void l(BaiduATSplashAdapter baiduATSplashAdapter) {
        if (!baiduATSplashAdapter.f12379f) {
            ATCustomLoadListener aTCustomLoadListener = baiduATSplashAdapter.mLoadListener;
            if (aTCustomLoadListener != null) {
                aTCustomLoadListener.onAdCacheLoaded(new BaseAd[0]);
                return;
            }
            return;
        }
        if (baiduATSplashAdapter.mBiddingListener != null) {
            SplashAd splashAd = baiduATSplashAdapter.b;
            if (splashAd == null) {
                baiduATSplashAdapter.notifyATLoadFail("", "Baidu: SplashAd had been destroyed.");
                return;
            }
            String eCPMLevel = splashAd.getECPMLevel();
            if (TextUtils.isEmpty(eCPMLevel)) {
                eCPMLevel = "0";
            }
            double d2 = PangleAdapterUtils.CPM_DEFLAUT_VALUE;
            try {
                d2 = Double.parseDouble(eCPMLevel);
            } catch (Throwable th) {
                th.printStackTrace();
            }
            BaiduATBiddingNotice baiduATBiddingNotice = new BaiduATBiddingNotice(baiduATSplashAdapter.b);
            ATBiddingListener aTBiddingListener = baiduATSplashAdapter.mBiddingListener;
            StringBuilder sb = new StringBuilder();
            sb.append(System.currentTimeMillis());
            aTBiddingListener.onC2SBiddingResultWithCache(ATBiddingResult.success(d2, sb.toString(), baiduATBiddingNotice, ATAdConst.CURRENCY.RMB_CENT), null);
        }
    }

    @Override // com.anythink.core.api.ATBaseAdAdapter
    public void destory() {
        SplashAd splashAd = this.b;
        if (splashAd != null) {
            splashAd.destroy();
        }
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
    public boolean isAdReady() {
        SplashAd splashAd = this.b;
        if (splashAd != null) {
            return splashAd.isReady();
        }
        return false;
    }

    @Override // com.anythink.core.api.ATBaseAdAdapter
    public void loadCustomNetworkAd(final Context context, final Map<String, Object> map, final Map<String, Object> map2) {
        this.f12378e = false;
        this.f12376c = ATInitMediation.getStringFromMap(map, "app_id");
        this.a = ATInitMediation.getStringFromMap(map, "ad_place_id");
        this.f12381h = ATInitMediation.getDoubleFromMap(map, "bid_floor");
        this.f12377d = ATInitMediation.getBooleanFromMap(map, ATAdConst.KEY.AD_CLICK_CONFIRM_STATUS);
        if (TextUtils.isEmpty(this.f12376c) || TextUtils.isEmpty(this.a)) {
            notifyATLoadFail("", " app_id ,ad_place_id is empty.");
        } else {
            final Context applicationContext = context.getApplicationContext();
            BaiduATInitManager.getInstance().initSDK(applicationContext, map, new MediationInitCallback() { // from class: com.anythink.network.baidu.BaiduATSplashAdapter.2
                @Override // com.anythink.core.api.MediationInitCallback
                public final void onFail(String str) {
                    if (((ATBaseAdAdapter) BaiduATSplashAdapter.this).mLoadListener != null) {
                        ((ATBaseAdAdapter) BaiduATSplashAdapter.this).mLoadListener.onAdLoadError("", str);
                    }
                }

                @Override // com.anythink.core.api.MediationInitCallback
                public final void onSuccess() {
                    if (BaiduATSplashAdapter.this.getMixedFormatAdType() == 0) {
                        BaiduATSplashAdapter.this.thirdPartyLoad(new BaiduATAdapter(), context, map, map2);
                    } else {
                        BaiduATSplashAdapter baiduATSplashAdapter = BaiduATSplashAdapter.this;
                        BaiduATSplashAdapter.a(baiduATSplashAdapter, applicationContext, baiduATSplashAdapter.f12377d);
                    }
                }
            });
        }
    }

    public void setDismissType(int i2) {
        this.mDismissType = i2;
    }

    @Override // com.anythink.splashad.unitgroup.api.CustomSplashAdapter
    public void show(Activity activity, ViewGroup viewGroup) {
        SplashAd splashAd = this.b;
        if (splashAd != null) {
            splashAd.show(viewGroup);
            return;
        }
        this.mDismissType = 99;
        CustomSplashEventListener customSplashEventListener = this.mImpressionListener;
        if (customSplashEventListener != null) {
            customSplashEventListener.onSplashAdShowFail(ErrorCode.getErrorCode(ErrorCode.adShowError, "", "Baidu Splash show fail: mSplashAd = null"));
            this.mImpressionListener.onSplashAdDismiss();
        }
    }

    @Override // com.anythink.core.api.ATBaseAdAdapter
    public boolean startBiddingRequest(Context context, Map<String, Object> map, Map<String, Object> map2, ATBiddingListener aTBiddingListener) {
        this.f12379f = true;
        if (getMixedFormatAdType() == 0) {
            return false;
        }
        loadCustomNetworkAd(context, map, map2);
        return true;
    }

    private void a(Context context, boolean z2) {
        RequestParameters.Builder builder = new RequestParameters.Builder();
        builder.addExtra("timeout", String.valueOf(this.mFetchAdTimeout));
        builder.addExtra(SplashAd.KEY_DISPLAY_DOWNLOADINFO, ITagManager.STATUS_TRUE);
        builder.addExtra(SplashAd.KEY_POPDIALOG_DOWNLOAD, String.valueOf(z2));
        this.b = new SplashAd(context.getApplicationContext(), this.a, builder.build(), new AnonymousClass1());
        if (this.f12379f && this.f12381h > PangleAdapterUtils.CPM_DEFLAUT_VALUE) {
            if (ATSDK.isNetworkLogDebug()) {
                String str = "setBidFloor:" + ((int) this.f12381h);
            }
            this.b.setBidFloor((int) this.f12381h);
        }
        this.b.load();
    }

    private void a() {
        if (this.f12379f) {
            if (this.mBiddingListener != null) {
                SplashAd splashAd = this.b;
                if (splashAd != null) {
                    String eCPMLevel = splashAd.getECPMLevel();
                    if (TextUtils.isEmpty(eCPMLevel)) {
                        eCPMLevel = "0";
                    }
                    double d2 = PangleAdapterUtils.CPM_DEFLAUT_VALUE;
                    try {
                        d2 = Double.parseDouble(eCPMLevel);
                    } catch (Throwable th) {
                        th.printStackTrace();
                    }
                    BaiduATBiddingNotice baiduATBiddingNotice = new BaiduATBiddingNotice(this.b);
                    ATBiddingListener aTBiddingListener = this.mBiddingListener;
                    StringBuilder sb = new StringBuilder();
                    sb.append(System.currentTimeMillis());
                    aTBiddingListener.onC2SBiddingResultWithCache(ATBiddingResult.success(d2, sb.toString(), baiduATBiddingNotice, ATAdConst.CURRENCY.RMB_CENT), null);
                    return;
                }
                notifyATLoadFail("", "Baidu: SplashAd had been destroyed.");
                return;
            }
            return;
        }
        ATCustomLoadListener aTCustomLoadListener = this.mLoadListener;
        if (aTCustomLoadListener != null) {
            aTCustomLoadListener.onAdCacheLoaded(new BaseAd[0]);
        }
    }

    private void a(Map<String, Object> map) {
        this.f12376c = ATInitMediation.getStringFromMap(map, "app_id");
        this.a = ATInitMediation.getStringFromMap(map, "ad_place_id");
        this.f12381h = ATInitMediation.getDoubleFromMap(map, "bid_floor");
        this.f12377d = ATInitMediation.getBooleanFromMap(map, ATAdConst.KEY.AD_CLICK_CONFIRM_STATUS);
    }

    static /* synthetic */ void a(BaiduATSplashAdapter baiduATSplashAdapter, Context context, boolean z2) {
        RequestParameters.Builder builder = new RequestParameters.Builder();
        builder.addExtra("timeout", String.valueOf(baiduATSplashAdapter.mFetchAdTimeout));
        builder.addExtra(SplashAd.KEY_DISPLAY_DOWNLOADINFO, ITagManager.STATUS_TRUE);
        builder.addExtra(SplashAd.KEY_POPDIALOG_DOWNLOAD, String.valueOf(z2));
        baiduATSplashAdapter.b = new SplashAd(context.getApplicationContext(), baiduATSplashAdapter.a, builder.build(), baiduATSplashAdapter.new AnonymousClass1());
        if (baiduATSplashAdapter.f12379f && baiduATSplashAdapter.f12381h > PangleAdapterUtils.CPM_DEFLAUT_VALUE) {
            if (ATSDK.isNetworkLogDebug()) {
                String str = "setBidFloor:" + ((int) baiduATSplashAdapter.f12381h);
            }
            baiduATSplashAdapter.b.setBidFloor((int) baiduATSplashAdapter.f12381h);
        }
        baiduATSplashAdapter.b.load();
    }
}
