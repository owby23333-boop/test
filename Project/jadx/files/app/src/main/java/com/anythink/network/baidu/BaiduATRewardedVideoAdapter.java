package com.anythink.network.baidu;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import com.anythink.core.api.ATAdConst;
import com.anythink.core.api.ATBaseAdAdapter;
import com.anythink.core.api.ATBiddingListener;
import com.anythink.core.api.ATBiddingResult;
import com.anythink.core.api.ATCustomLoadListener;
import com.anythink.core.api.ATInitMediation;
import com.anythink.core.api.ATSDK;
import com.anythink.core.api.BaseAd;
import com.anythink.core.api.MediationInitCallback;
import com.anythink.rewardvideo.unitgroup.api.CustomRewardVideoAdapter;
import com.baidu.mobads.sdk.api.RewardVideoAd;
import com.bytedance.msdk.adapter.pangle.PangleAdapterUtils;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public class BaiduATRewardedVideoAdapter extends CustomRewardVideoAdapter {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final String f12372c = "BaiduATRewardedVideoAdapter";
    RewardVideoAd a;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private String f12373d = "";

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private String f12374e = "";

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private double f12375f = PangleAdapterUtils.CPM_DEFLAUT_VALUE;
    boolean b = false;

    /* JADX INFO: renamed from: com.anythink.network.baidu.BaiduATRewardedVideoAdapter$1, reason: invalid class name */
    final class AnonymousClass1 implements RewardVideoAd.RewardVideoAdListener {
        AnonymousClass1() {
        }

        @Override // com.baidu.mobads.sdk.api.RewardVideoAd.RewardVideoAdListener, com.baidu.mobads.sdk.api.ScreenVideoAdListener
        public final void onAdClick() {
            if (((CustomRewardVideoAdapter) BaiduATRewardedVideoAdapter.this).mImpressionListener != null) {
                ((CustomRewardVideoAdapter) BaiduATRewardedVideoAdapter.this).mImpressionListener.onRewardedVideoAdPlayClicked();
            }
        }

        @Override // com.baidu.mobads.sdk.api.RewardVideoAd.RewardVideoAdListener, com.baidu.mobads.sdk.api.ScreenVideoAdListener
        public final void onAdClose(float f2) {
            if (((CustomRewardVideoAdapter) BaiduATRewardedVideoAdapter.this).mImpressionListener != null) {
                ((CustomRewardVideoAdapter) BaiduATRewardedVideoAdapter.this).mImpressionListener.onRewardedVideoAdClosed();
            }
        }

        @Override // com.baidu.mobads.sdk.api.RewardVideoAd.RewardVideoAdListener, com.baidu.mobads.sdk.api.ScreenVideoAdListener
        public final void onAdFailed(String str) {
            BaiduATRewardedVideoAdapter.this.notifyATLoadFail("", str);
        }

        @Override // com.baidu.mobads.sdk.api.RewardVideoAd.RewardVideoAdListener, com.baidu.mobads.sdk.api.ScreenVideoAdListener
        public final void onAdLoaded() {
            if (((ATBaseAdAdapter) BaiduATRewardedVideoAdapter.this).mLoadListener != null) {
                ((ATBaseAdAdapter) BaiduATRewardedVideoAdapter.this).mLoadListener.onAdDataLoaded();
            }
        }

        @Override // com.baidu.mobads.sdk.api.RewardVideoAd.RewardVideoAdListener, com.baidu.mobads.sdk.api.ScreenVideoAdListener
        public final void onAdShow() {
            if (((CustomRewardVideoAdapter) BaiduATRewardedVideoAdapter.this).mImpressionListener != null) {
                ((CustomRewardVideoAdapter) BaiduATRewardedVideoAdapter.this).mImpressionListener.onRewardedVideoAdPlayStart();
            }
        }

        @Override // com.baidu.mobads.sdk.api.RewardVideoAd.RewardVideoAdListener, com.baidu.mobads.sdk.api.ScreenVideoAdListener
        public final void onAdSkip(float f2) {
            BaiduATRewardedVideoAdapter.j(BaiduATRewardedVideoAdapter.this);
        }

        @Override // com.baidu.mobads.sdk.api.RewardVideoAd.RewardVideoAdListener
        public final void onRewardVerify(boolean z2) {
            if (((CustomRewardVideoAdapter) BaiduATRewardedVideoAdapter.this).mImpressionListener == null || !z2) {
                return;
            }
            ((CustomRewardVideoAdapter) BaiduATRewardedVideoAdapter.this).mImpressionListener.onReward();
        }

        @Override // com.baidu.mobads.sdk.api.RewardVideoAd.RewardVideoAdListener, com.baidu.mobads.sdk.api.ScreenVideoAdListener
        public final void onVideoDownloadFailed() {
            BaiduATRewardedVideoAdapter.this.notifyATLoadFail("", "BaiduRewardedVideo: onVideoDownloadFailed");
        }

        @Override // com.baidu.mobads.sdk.api.RewardVideoAd.RewardVideoAdListener, com.baidu.mobads.sdk.api.ScreenVideoAdListener
        public final void onVideoDownloadSuccess() {
            BaiduATRewardedVideoAdapter.g(BaiduATRewardedVideoAdapter.this);
        }

        @Override // com.baidu.mobads.sdk.api.RewardVideoAd.RewardVideoAdListener, com.baidu.mobads.sdk.api.ScreenVideoAdListener
        public final void playCompletion() {
            if (((CustomRewardVideoAdapter) BaiduATRewardedVideoAdapter.this).mImpressionListener != null) {
                ((CustomRewardVideoAdapter) BaiduATRewardedVideoAdapter.this).mImpressionListener.onRewardedVideoAdPlayEnd();
            }
        }
    }

    static /* synthetic */ void g(BaiduATRewardedVideoAdapter baiduATRewardedVideoAdapter) {
        if (!baiduATRewardedVideoAdapter.b) {
            ATCustomLoadListener aTCustomLoadListener = baiduATRewardedVideoAdapter.mLoadListener;
            if (aTCustomLoadListener != null) {
                aTCustomLoadListener.onAdCacheLoaded(new BaseAd[0]);
                return;
            }
            return;
        }
        if (baiduATRewardedVideoAdapter.mBiddingListener != null) {
            RewardVideoAd rewardVideoAd = baiduATRewardedVideoAdapter.a;
            if (rewardVideoAd == null) {
                baiduATRewardedVideoAdapter.notifyATLoadFail("", "Baidu: RewardVideoAd had been destroyed.");
                return;
            }
            String eCPMLevel = rewardVideoAd.getECPMLevel();
            if (TextUtils.isEmpty(eCPMLevel)) {
                eCPMLevel = "0";
            }
            double d2 = PangleAdapterUtils.CPM_DEFLAUT_VALUE;
            try {
                d2 = Double.parseDouble(eCPMLevel);
            } catch (Throwable th) {
                th.printStackTrace();
            }
            BaiduATBiddingNotice baiduATBiddingNotice = new BaiduATBiddingNotice(baiduATRewardedVideoAdapter.a);
            ATBiddingListener aTBiddingListener = baiduATRewardedVideoAdapter.mBiddingListener;
            StringBuilder sb = new StringBuilder();
            sb.append(System.currentTimeMillis());
            aTBiddingListener.onC2SBiddingResultWithCache(ATBiddingResult.success(d2, sb.toString(), baiduATBiddingNotice, ATAdConst.CURRENCY.RMB_CENT), null);
        }
    }

    static /* synthetic */ int j(BaiduATRewardedVideoAdapter baiduATRewardedVideoAdapter) {
        baiduATRewardedVideoAdapter.mDismissType = 2;
        return 2;
    }

    @Override // com.anythink.core.api.ATBaseAdAdapter
    public void destory() {
        this.a = null;
    }

    @Override // com.anythink.core.api.ATBaseAdAdapter
    public String getNetworkName() {
        return BaiduATInitManager.getInstance().getNetworkName();
    }

    @Override // com.anythink.core.api.ATBaseAdAdapter
    public String getNetworkPlacementId() {
        return this.f12373d;
    }

    @Override // com.anythink.core.api.ATBaseAdAdapter
    public String getNetworkSDKVersion() {
        return BaiduATInitManager.getInstance().getNetworkVersion();
    }

    @Override // com.anythink.core.api.ATBaseAdAdapter
    public boolean isAdReady() {
        RewardVideoAd rewardVideoAd = this.a;
        if (rewardVideoAd != null) {
            return rewardVideoAd.isReady();
        }
        return false;
    }

    @Override // com.anythink.core.api.ATBaseAdAdapter
    public void loadCustomNetworkAd(Context context, Map<String, Object> map, Map<String, Object> map2) {
        this.f12374e = ATInitMediation.getStringFromMap(map, "app_id");
        this.f12373d = ATInitMediation.getStringFromMap(map, "ad_place_id");
        this.f12375f = ATInitMediation.getDoubleFromMap(map, "bid_floor");
        if (TextUtils.isEmpty(this.f12374e) || TextUtils.isEmpty(this.f12373d)) {
            notifyATLoadFail("", " app_id ,ad_place_id is empty.");
        } else {
            final Context applicationContext = context.getApplicationContext();
            BaiduATInitManager.getInstance().initSDK(applicationContext, map, new MediationInitCallback() { // from class: com.anythink.network.baidu.BaiduATRewardedVideoAdapter.2
                @Override // com.anythink.core.api.MediationInitCallback
                public final void onFail(String str) {
                    if (((ATBaseAdAdapter) BaiduATRewardedVideoAdapter.this).mLoadListener != null) {
                        ((ATBaseAdAdapter) BaiduATRewardedVideoAdapter.this).mLoadListener.onAdLoadError("", str);
                    }
                }

                @Override // com.anythink.core.api.MediationInitCallback
                public final void onSuccess() {
                    try {
                        BaiduATRewardedVideoAdapter.a(BaiduATRewardedVideoAdapter.this, applicationContext);
                    } catch (Throwable th) {
                        th.printStackTrace();
                        if (((ATBaseAdAdapter) BaiduATRewardedVideoAdapter.this).mLoadListener != null) {
                            ((ATBaseAdAdapter) BaiduATRewardedVideoAdapter.this).mLoadListener.onAdLoadError("", "Baidu: init error, " + th.getMessage());
                        }
                    }
                }
            });
        }
    }

    public void setDismissType(int i2) {
        this.mDismissType = i2;
    }

    @Override // com.anythink.rewardvideo.unitgroup.api.CustomRewardVideoAdapter
    public void show(Activity activity) {
        try {
            this.a.show();
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    @Override // com.anythink.core.api.ATBaseAdAdapter
    public boolean startBiddingRequest(Context context, Map<String, Object> map, Map<String, Object> map2, ATBiddingListener aTBiddingListener) {
        this.b = true;
        loadCustomNetworkAd(context, map, map2);
        return true;
    }

    private void a(Context context) {
        this.a = new RewardVideoAd(context.getApplicationContext(), this.f12373d, new AnonymousClass1());
        if (this.b && this.f12375f > PangleAdapterUtils.CPM_DEFLAUT_VALUE) {
            if (ATSDK.isNetworkLogDebug()) {
                String str = "setBidFloor:" + ((int) this.f12375f);
            }
            this.a.setBidFloor((int) this.f12375f);
        }
        if (!TextUtils.isEmpty(this.mUserId)) {
            this.a.setUserId(this.mUserId);
        }
        if (!TextUtils.isEmpty(this.mUserData)) {
            if (this.mUserData.contains(ATAdConst.REWARD_EXTRA_REPLACE_HODLER_KEY.NETWORK_PLACEMENT_ID_HOLDER_NAME)) {
                this.mUserData = this.mUserData.replace(ATAdConst.REWARD_EXTRA_REPLACE_HODLER_KEY.NETWORK_PLACEMENT_ID_HOLDER_NAME, this.f12373d);
            }
            this.a.setExtraInfo(this.mUserData);
        }
        this.a.load();
    }

    private void a() {
        if (this.b) {
            if (this.mBiddingListener != null) {
                RewardVideoAd rewardVideoAd = this.a;
                if (rewardVideoAd != null) {
                    String eCPMLevel = rewardVideoAd.getECPMLevel();
                    if (TextUtils.isEmpty(eCPMLevel)) {
                        eCPMLevel = "0";
                    }
                    double d2 = PangleAdapterUtils.CPM_DEFLAUT_VALUE;
                    try {
                        d2 = Double.parseDouble(eCPMLevel);
                    } catch (Throwable th) {
                        th.printStackTrace();
                    }
                    BaiduATBiddingNotice baiduATBiddingNotice = new BaiduATBiddingNotice(this.a);
                    ATBiddingListener aTBiddingListener = this.mBiddingListener;
                    StringBuilder sb = new StringBuilder();
                    sb.append(System.currentTimeMillis());
                    aTBiddingListener.onC2SBiddingResultWithCache(ATBiddingResult.success(d2, sb.toString(), baiduATBiddingNotice, ATAdConst.CURRENCY.RMB_CENT), null);
                    return;
                }
                notifyATLoadFail("", "Baidu: RewardVideoAd had been destroyed.");
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
        this.f12374e = ATInitMediation.getStringFromMap(map, "app_id");
        this.f12373d = ATInitMediation.getStringFromMap(map, "ad_place_id");
        this.f12375f = ATInitMediation.getDoubleFromMap(map, "bid_floor");
    }

    static /* synthetic */ void a(BaiduATRewardedVideoAdapter baiduATRewardedVideoAdapter, Context context) {
        baiduATRewardedVideoAdapter.a = new RewardVideoAd(context.getApplicationContext(), baiduATRewardedVideoAdapter.f12373d, baiduATRewardedVideoAdapter.new AnonymousClass1());
        if (baiduATRewardedVideoAdapter.b && baiduATRewardedVideoAdapter.f12375f > PangleAdapterUtils.CPM_DEFLAUT_VALUE) {
            if (ATSDK.isNetworkLogDebug()) {
                String str = "setBidFloor:" + ((int) baiduATRewardedVideoAdapter.f12375f);
            }
            baiduATRewardedVideoAdapter.a.setBidFloor((int) baiduATRewardedVideoAdapter.f12375f);
        }
        if (!TextUtils.isEmpty(baiduATRewardedVideoAdapter.mUserId)) {
            baiduATRewardedVideoAdapter.a.setUserId(baiduATRewardedVideoAdapter.mUserId);
        }
        if (!TextUtils.isEmpty(baiduATRewardedVideoAdapter.mUserData)) {
            if (baiduATRewardedVideoAdapter.mUserData.contains(ATAdConst.REWARD_EXTRA_REPLACE_HODLER_KEY.NETWORK_PLACEMENT_ID_HOLDER_NAME)) {
                baiduATRewardedVideoAdapter.mUserData = baiduATRewardedVideoAdapter.mUserData.replace(ATAdConst.REWARD_EXTRA_REPLACE_HODLER_KEY.NETWORK_PLACEMENT_ID_HOLDER_NAME, baiduATRewardedVideoAdapter.f12373d);
            }
            baiduATRewardedVideoAdapter.a.setExtraInfo(baiduATRewardedVideoAdapter.mUserData);
        }
        baiduATRewardedVideoAdapter.a.load();
    }
}
