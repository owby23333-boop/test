package com.anythink.network.gdt;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import com.anythink.core.api.ATAdConst;
import com.anythink.core.api.ATBaseAdAdapter;
import com.anythink.core.api.ATBidRequestInfoListener;
import com.anythink.core.api.ATBiddingListener;
import com.anythink.core.api.ATBiddingResult;
import com.anythink.core.api.ATInitMediation;
import com.anythink.core.api.BaseAd;
import com.anythink.core.api.MediationInitCallback;
import com.anythink.rewardvideo.unitgroup.api.CustomRewardVideoAdapter;
import com.anythink.rewardvideo.unitgroup.api.CustomRewardedVideoEventListener;
import com.qq.e.ads.cfg.VideoOption;
import com.qq.e.ads.interstitial2.ADRewardListener;
import com.qq.e.ads.interstitial2.UnifiedInterstitialAD;
import com.qq.e.ads.interstitial2.UnifiedInterstitialADListener;
import com.qq.e.ads.interstitial2.UnifiedInterstitialMediaListener;
import com.qq.e.ads.rewardvideo.RewardVideoAD;
import com.qq.e.ads.rewardvideo.RewardVideoADListener;
import com.qq.e.ads.rewardvideo.ServerSideVerificationOptions;
import com.qq.e.comm.compliance.DownloadConfirmCallBack;
import com.qq.e.comm.compliance.DownloadConfirmListener;
import com.qq.e.comm.util.AdError;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public class GDTATRewardedVideoAdapter extends CustomRewardVideoAdapter {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final String f12457f = "GDTATRewardedVideoAdapter";
    RewardVideoAD a;
    UnifiedInterstitialAD b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    String f12458c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    String f12459d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    String f12460e;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private Map<String, Object> f12462h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private boolean f12463i;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private int f12461g = 0;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private int f12464j = 1;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private boolean f12465k = false;

    /* JADX INFO: renamed from: com.anythink.network.gdt.GDTATRewardedVideoAdapter$3, reason: invalid class name */
    final class AnonymousClass3 implements UnifiedInterstitialADListener {
        AnonymousClass3() {
        }

        @Override // com.qq.e.ads.interstitial2.UnifiedInterstitialADListener
        public final void onADClicked() {
            if (((CustomRewardVideoAdapter) GDTATRewardedVideoAdapter.this).mImpressionListener != null) {
                ((CustomRewardVideoAdapter) GDTATRewardedVideoAdapter.this).mImpressionListener.onRewardedVideoAdPlayClicked();
            }
        }

        @Override // com.qq.e.ads.interstitial2.UnifiedInterstitialADListener
        public final void onADClosed() {
            GDTATInitManager.getInstance().b();
            if (((CustomRewardVideoAdapter) GDTATRewardedVideoAdapter.this).mImpressionListener != null) {
                ((CustomRewardVideoAdapter) GDTATRewardedVideoAdapter.this).mImpressionListener.onRewardedVideoAdClosed();
            }
        }

        @Override // com.qq.e.ads.interstitial2.UnifiedInterstitialADListener
        public final void onADExposure() {
            try {
                GDTATInitManager.getInstance().a(GDTATRewardedVideoAdapter.this.getTrackingInfo().l(), new WeakReference(GDTATRewardedVideoAdapter.this.b));
            } catch (Throwable unused) {
            }
            if (((CustomRewardVideoAdapter) GDTATRewardedVideoAdapter.this).mImpressionListener != null) {
                ((CustomRewardVideoAdapter) GDTATRewardedVideoAdapter.this).mImpressionListener.onRewardedVideoAdPlayStart();
            }
        }

        @Override // com.qq.e.ads.interstitial2.UnifiedInterstitialADListener
        public final void onADLeftApplication() {
        }

        @Override // com.qq.e.ads.interstitial2.UnifiedInterstitialADListener
        public final void onADOpened() {
        }

        @Override // com.qq.e.ads.interstitial2.UnifiedInterstitialADListener
        public final void onADReceive() {
            try {
                Map<String, Object> extraInfo = GDTATRewardedVideoAdapter.this.b.getExtraInfo();
                if (extraInfo != null) {
                    if (GDTATRewardedVideoAdapter.this.f12462h == null) {
                        GDTATRewardedVideoAdapter.this.f12462h = new HashMap();
                    }
                    GDTATRewardedVideoAdapter.this.f12462h.putAll(extraInfo);
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
            GDTATRewardedVideoAdapter gDTATRewardedVideoAdapter = GDTATRewardedVideoAdapter.this;
            if (gDTATRewardedVideoAdapter.b != null && gDTATRewardedVideoAdapter.f12463i) {
                GDTATRewardedVideoAdapter.this.b.setDownloadConfirmListener(new DownloadConfirmListener() { // from class: com.anythink.network.gdt.GDTATRewardedVideoAdapter.3.1
                    @Override // com.qq.e.comm.compliance.DownloadConfirmListener
                    public final void onDownloadConfirm(Activity activity, int i2, String str, DownloadConfirmCallBack downloadConfirmCallBack) {
                        if (((CustomRewardVideoAdapter) GDTATRewardedVideoAdapter.this).mImpressionListener != null) {
                            GDTDownloadFirmInfo gDTDownloadFirmInfo = new GDTDownloadFirmInfo();
                            gDTDownloadFirmInfo.appInfoUrl = str;
                            gDTDownloadFirmInfo.scenes = i2;
                            gDTDownloadFirmInfo.confirmCallBack = downloadConfirmCallBack;
                            ((CustomRewardVideoAdapter) GDTATRewardedVideoAdapter.this).mImpressionListener.onDownloadConfirm(activity, gDTDownloadFirmInfo);
                        }
                    }
                });
            }
            GDTATRewardedVideoAdapter.this.b.setRewardListener(new ADRewardListener() { // from class: com.anythink.network.gdt.GDTATRewardedVideoAdapter.3.2
                @Override // com.qq.e.comm.listeners.ADRewardListener
                public final void onReward(Map<String, Object> map) {
                    if (GDTATRewardedVideoAdapter.this.f12462h == null) {
                        GDTATRewardedVideoAdapter.this.f12462h = new HashMap();
                    }
                    GDTATRewardedVideoAdapter.this.f12462h.put("gdt_trans_id", map.get("transId"));
                    if (((CustomRewardVideoAdapter) GDTATRewardedVideoAdapter.this).mImpressionListener != null) {
                        ((CustomRewardVideoAdapter) GDTATRewardedVideoAdapter.this).mImpressionListener.onReward();
                    }
                }
            });
            if (((ATBaseAdAdapter) GDTATRewardedVideoAdapter.this).mLoadListener != null) {
                ((ATBaseAdAdapter) GDTATRewardedVideoAdapter.this).mLoadListener.onAdDataLoaded();
            }
        }

        @Override // com.qq.e.ads.interstitial2.UnifiedInterstitialADListener
        public final void onNoAD(AdError adError) {
            GDTATRewardedVideoAdapter.this.notifyATLoadFail(String.valueOf(adError.getErrorCode()), adError.getErrorMsg());
        }

        @Override // com.qq.e.ads.interstitial2.UnifiedInterstitialADListener
        public final void onRenderFail() {
            GDTATRewardedVideoAdapter.this.notifyATLoadFail("", "GDT: onRenderFail()");
        }

        @Override // com.qq.e.ads.interstitial2.UnifiedInterstitialADListener
        public final void onRenderSuccess() {
            if (!GDTATRewardedVideoAdapter.this.f12465k) {
                if (((ATBaseAdAdapter) GDTATRewardedVideoAdapter.this).mLoadListener != null) {
                    ((ATBaseAdAdapter) GDTATRewardedVideoAdapter.this).mLoadListener.onAdCacheLoaded(new BaseAd[0]);
                    return;
                }
                return;
            }
            GDTATRewardedVideoAdapter gDTATRewardedVideoAdapter = GDTATRewardedVideoAdapter.this;
            if (gDTATRewardedVideoAdapter.mBiddingListener != null) {
                UnifiedInterstitialAD unifiedInterstitialAD = gDTATRewardedVideoAdapter.b;
                if (unifiedInterstitialAD == null) {
                    gDTATRewardedVideoAdapter.notifyATLoadFail("", "GDT : UnifiedInterstitialAD had been destroyed.");
                    return;
                }
                double ecpm = unifiedInterstitialAD.getECPM();
                GDTATBiddingNotice gDTATBiddingNotice = new GDTATBiddingNotice(GDTATRewardedVideoAdapter.this.b);
                ATBiddingListener aTBiddingListener = GDTATRewardedVideoAdapter.this.mBiddingListener;
                StringBuilder sb = new StringBuilder();
                sb.append(System.currentTimeMillis());
                aTBiddingListener.onC2SBiddingResultWithCache(ATBiddingResult.success(ecpm, sb.toString(), gDTATBiddingNotice, ATAdConst.CURRENCY.RMB_CENT), null);
            }
        }

        @Override // com.qq.e.ads.interstitial2.UnifiedInterstitialADListener
        public final void onVideoCached() {
        }
    }

    /* JADX INFO: renamed from: com.anythink.network.gdt.GDTATRewardedVideoAdapter$4, reason: invalid class name */
    final class AnonymousClass4 implements UnifiedInterstitialMediaListener {
        AnonymousClass4() {
        }

        @Override // com.qq.e.ads.interstitial2.UnifiedInterstitialMediaListener
        public final void onVideoComplete() {
            if (((CustomRewardVideoAdapter) GDTATRewardedVideoAdapter.this).mImpressionListener != null) {
                ((CustomRewardVideoAdapter) GDTATRewardedVideoAdapter.this).mImpressionListener.onRewardedVideoAdPlayEnd();
            }
        }

        @Override // com.qq.e.ads.interstitial2.UnifiedInterstitialMediaListener
        public final void onVideoError(AdError adError) {
            if (((CustomRewardVideoAdapter) GDTATRewardedVideoAdapter.this).mImpressionListener != null) {
                CustomRewardedVideoEventListener customRewardedVideoEventListener = ((CustomRewardVideoAdapter) GDTATRewardedVideoAdapter.this).mImpressionListener;
                StringBuilder sb = new StringBuilder();
                sb.append(adError.getErrorCode());
                customRewardedVideoEventListener.onRewardedVideoAdPlayFailed(sb.toString(), adError.getErrorMsg());
            }
        }

        @Override // com.qq.e.ads.interstitial2.UnifiedInterstitialMediaListener
        public final void onVideoInit() {
        }

        @Override // com.qq.e.ads.interstitial2.UnifiedInterstitialMediaListener
        public final void onVideoLoading() {
        }

        @Override // com.qq.e.ads.interstitial2.UnifiedInterstitialMediaListener
        public final void onVideoPageClose() {
        }

        @Override // com.qq.e.ads.interstitial2.UnifiedInterstitialMediaListener
        public final void onVideoPageOpen() {
        }

        @Override // com.qq.e.ads.interstitial2.UnifiedInterstitialMediaListener
        public final void onVideoPause() {
        }

        @Override // com.qq.e.ads.interstitial2.UnifiedInterstitialMediaListener
        public final void onVideoReady(long j2) {
        }

        @Override // com.qq.e.ads.interstitial2.UnifiedInterstitialMediaListener
        public final void onVideoStart() {
        }
    }

    @Override // com.anythink.core.api.ATBaseAdAdapter
    public void destory() {
        if (this.a != null) {
            this.a = null;
        }
        if (this.b != null) {
            this.b = null;
        }
    }

    @Override // com.anythink.core.api.ATBaseAdAdapter
    public void getBidRequestInfo(Context context, Map<String, Object> map, Map<String, Object> map2, ATBidRequestInfoListener aTBidRequestInfoListener) {
        this.f12459d = ATInitMediation.getStringFromMap(map, "unit_id");
        GDTATInitManager.getInstance().a(context, map, map2, aTBidRequestInfoListener);
    }

    @Override // com.anythink.core.api.ATBaseAdAdapter
    public ATInitMediation getMediationInitManager() {
        return GDTATInitManager.getInstance();
    }

    @Override // com.anythink.core.api.ATBaseAdAdapter
    public Map<String, Object> getNetworkInfoMap() {
        return this.f12462h;
    }

    @Override // com.anythink.core.api.ATBaseAdAdapter
    public String getNetworkName() {
        return GDTATInitManager.getInstance().getNetworkName();
    }

    @Override // com.anythink.core.api.ATBaseAdAdapter
    public String getNetworkPlacementId() {
        return this.f12459d;
    }

    @Override // com.anythink.core.api.ATBaseAdAdapter
    public String getNetworkSDKVersion() {
        return GDTATInitManager.getInstance().getNetworkVersion();
    }

    @Override // com.anythink.core.api.ATBaseAdAdapter
    public boolean isAdReady() {
        RewardVideoAD rewardVideoAD = this.a;
        if (rewardVideoAD != null) {
            return rewardVideoAD.isValid();
        }
        UnifiedInterstitialAD unifiedInterstitialAD = this.b;
        if (unifiedInterstitialAD != null) {
            return unifiedInterstitialAD.isValid();
        }
        return false;
    }

    @Override // com.anythink.core.api.ATBaseAdAdapter
    public void loadCustomNetworkAd(final Context context, final Map<String, Object> map, Map<String, Object> map2) {
        this.f12458c = ATInitMediation.getStringFromMap(map, "app_id");
        this.f12459d = ATInitMediation.getStringFromMap(map, "unit_id");
        this.f12460e = ATInitMediation.getStringFromMap(map, "payload");
        this.f12461g = ATInitMediation.getIntFromMap(map, "video_muted", 0);
        this.f12464j = ATInitMediation.getIntFromMap(map, "unit_type", 1);
        this.f12463i = ATInitMediation.getBooleanFromMap(map2, ATAdConst.KEY.AD_CLICK_CONFIRM_STATUS, false);
        if (TextUtils.isEmpty(this.f12458c) || TextUtils.isEmpty(this.f12459d)) {
            notifyATLoadFail("", "GTD appid or unitId is empty.");
        } else {
            GDTATInitManager.getInstance().initSDK(context.getApplicationContext(), map, new MediationInitCallback() { // from class: com.anythink.network.gdt.GDTATRewardedVideoAdapter.1
                @Override // com.anythink.core.api.MediationInitCallback
                public final void onFail(String str) {
                    GDTATRewardedVideoAdapter.this.notifyATLoadFail("", str);
                }

                @Override // com.anythink.core.api.MediationInitCallback
                public final void onSuccess() {
                    GDTATRewardedVideoAdapter.a(GDTATRewardedVideoAdapter.this, context, map);
                }
            });
        }
    }

    public void setDismissType(int i2) {
        this.mDismissType = i2;
    }

    @Override // com.anythink.rewardvideo.unitgroup.api.CustomRewardVideoAdapter
    public void show(Activity activity) {
        if (this.a != null) {
            try {
                GDTATInitManager.getInstance().a(this.f12459d, this.a);
                if (activity != null) {
                    this.a.showAD(activity);
                } else {
                    this.a.showAD();
                }
            } catch (Throwable th) {
                GDTATInitManager.getInstance().a();
                th.printStackTrace();
            }
        }
        if (this.b != null) {
            try {
                GDTATInitManager.getInstance().a(this.f12459d, this.b);
                this.b.showFullScreenAD(activity);
            } catch (Throwable th2) {
                GDTATInitManager.getInstance().b();
                th2.printStackTrace();
            }
        }
    }

    @Override // com.anythink.core.api.ATBaseAdAdapter
    public boolean startBiddingRequest(Context context, Map<String, Object> map, Map<String, Object> map2, ATBiddingListener aTBiddingListener) {
        this.f12465k = true;
        loadCustomNetworkAd(context, map, map2);
        return true;
    }

    private void b(Context context, Map<String, Object> map) {
        AnonymousClass2 anonymousClass2 = new AnonymousClass2();
        if (TextUtils.isEmpty(this.f12460e) || this.f12465k) {
            this.a = new RewardVideoAD(context.getApplicationContext(), this.f12459d, anonymousClass2, this.f12461g != 1);
            RewardVideoAD rewardVideoAD = this.a;
            GDTATInitManager.getInstance();
            rewardVideoAD.setLoadAdParams(GDTATInitManager.a(map));
        } else {
            this.a = new RewardVideoAD(context.getApplicationContext(), this.f12459d, anonymousClass2, this.f12461g != 1, this.f12460e);
        }
        try {
            ServerSideVerificationOptions.Builder builder = new ServerSideVerificationOptions.Builder();
            builder.setUserId(this.mUserId);
            if (!TextUtils.isEmpty(this.mUserData) && this.mUserData.contains(ATAdConst.REWARD_EXTRA_REPLACE_HODLER_KEY.NETWORK_PLACEMENT_ID_HOLDER_NAME)) {
                this.mUserData = this.mUserData.replace(ATAdConst.REWARD_EXTRA_REPLACE_HODLER_KEY.NETWORK_PLACEMENT_ID_HOLDER_NAME, this.f12459d);
            }
            builder.setCustomData(this.mUserData);
            this.a.setServerSideVerificationOptions(builder.build());
        } catch (Throwable unused) {
        }
        this.a.loadAD();
    }

    private void c(Context context, Map<String, Object> map) {
        if (!(context instanceof Activity)) {
            notifyATLoadFail("", "GDT UnifiedInterstitial's context must be activity.");
            return;
        }
        AnonymousClass3 anonymousClass3 = new AnonymousClass3();
        if (TextUtils.isEmpty(this.f12460e) || this.f12465k) {
            this.b = new UnifiedInterstitialAD((Activity) context, this.f12459d, anonymousClass3);
            UnifiedInterstitialAD unifiedInterstitialAD = this.b;
            GDTATInitManager.getInstance();
            unifiedInterstitialAD.setLoadAdParams(GDTATInitManager.a(map));
        } else {
            this.b = new UnifiedInterstitialAD((Activity) context, this.f12459d, anonymousClass3, null, this.f12460e);
        }
        UnifiedInterstitialAD unifiedInterstitialAD2 = this.b;
        int i2 = map.containsKey("video_muted") ? Integer.parseInt(map.get("video_muted").toString()) : 0;
        int i3 = map.containsKey("video_autoplay") ? Integer.parseInt(map.get("video_autoplay").toString()) : 1;
        int i4 = map.containsKey("video_duration") ? Integer.parseInt(map.get("video_duration").toString()) : -1;
        if (unifiedInterstitialAD2 != null) {
            unifiedInterstitialAD2.setVideoOption(new VideoOption.Builder().setAutoPlayMuted(i2 == 1).setDetailPageMuted(i2 == 1).setAutoPlayPolicy(i3).build());
            if (i4 != -1) {
                unifiedInterstitialAD2.setMaxVideoDuration(i4);
            }
        }
        this.b.setMediaListener(new AnonymousClass4());
        this.b.loadFullScreenAD();
    }

    private void a(Map<String, Object> map, Map<String, Object> map2) {
        this.f12458c = ATInitMediation.getStringFromMap(map, "app_id");
        this.f12459d = ATInitMediation.getStringFromMap(map, "unit_id");
        this.f12460e = ATInitMediation.getStringFromMap(map, "payload");
        this.f12461g = ATInitMediation.getIntFromMap(map, "video_muted", 0);
        this.f12464j = ATInitMediation.getIntFromMap(map, "unit_type", 1);
        this.f12463i = ATInitMediation.getBooleanFromMap(map2, ATAdConst.KEY.AD_CLICK_CONFIRM_STATUS, false);
    }

    /* JADX INFO: renamed from: com.anythink.network.gdt.GDTATRewardedVideoAdapter$2, reason: invalid class name */
    final class AnonymousClass2 implements RewardVideoADListener {
        AnonymousClass2() {
        }

        @Override // com.qq.e.ads.rewardvideo.RewardVideoADListener
        public final void onADClick() {
            if (((CustomRewardVideoAdapter) GDTATRewardedVideoAdapter.this).mImpressionListener != null) {
                ((CustomRewardVideoAdapter) GDTATRewardedVideoAdapter.this).mImpressionListener.onRewardedVideoAdPlayClicked();
            }
        }

        @Override // com.qq.e.ads.rewardvideo.RewardVideoADListener
        public final void onADClose() {
            GDTATInitManager.getInstance().a();
            if (((CustomRewardVideoAdapter) GDTATRewardedVideoAdapter.this).mImpressionListener != null) {
                ((CustomRewardVideoAdapter) GDTATRewardedVideoAdapter.this).mImpressionListener.onRewardedVideoAdClosed();
            }
        }

        @Override // com.qq.e.ads.rewardvideo.RewardVideoADListener
        public final void onADExpose() {
            try {
                GDTATInitManager.getInstance().a(GDTATRewardedVideoAdapter.this.getTrackingInfo().l(), new WeakReference(GDTATRewardedVideoAdapter.this.a));
            } catch (Throwable unused) {
            }
            if (((CustomRewardVideoAdapter) GDTATRewardedVideoAdapter.this).mImpressionListener != null) {
                ((CustomRewardVideoAdapter) GDTATRewardedVideoAdapter.this).mImpressionListener.onRewardedVideoAdPlayStart();
            }
        }

        @Override // com.qq.e.ads.rewardvideo.RewardVideoADListener
        public final void onADLoad() {
            try {
                Map<String, Object> extraInfo = GDTATRewardedVideoAdapter.this.a.getExtraInfo();
                if (extraInfo != null) {
                    if (GDTATRewardedVideoAdapter.this.f12462h == null) {
                        GDTATRewardedVideoAdapter.this.f12462h = new HashMap();
                    }
                    GDTATRewardedVideoAdapter.this.f12462h.putAll(extraInfo);
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
            GDTATRewardedVideoAdapter gDTATRewardedVideoAdapter = GDTATRewardedVideoAdapter.this;
            if (gDTATRewardedVideoAdapter.a != null && gDTATRewardedVideoAdapter.f12463i) {
                GDTATRewardedVideoAdapter.this.a.setDownloadConfirmListener(new DownloadConfirmListener() { // from class: com.anythink.network.gdt.GDTATRewardedVideoAdapter.2.1
                    @Override // com.qq.e.comm.compliance.DownloadConfirmListener
                    public final void onDownloadConfirm(Activity activity, int i2, String str, DownloadConfirmCallBack downloadConfirmCallBack) {
                        if (((CustomRewardVideoAdapter) GDTATRewardedVideoAdapter.this).mImpressionListener != null) {
                            GDTDownloadFirmInfo gDTDownloadFirmInfo = new GDTDownloadFirmInfo();
                            gDTDownloadFirmInfo.appInfoUrl = str;
                            gDTDownloadFirmInfo.scenes = i2;
                            gDTDownloadFirmInfo.confirmCallBack = downloadConfirmCallBack;
                            ((CustomRewardVideoAdapter) GDTATRewardedVideoAdapter.this).mImpressionListener.onDownloadConfirm(activity, gDTDownloadFirmInfo);
                        }
                    }
                });
            }
            if (((ATBaseAdAdapter) GDTATRewardedVideoAdapter.this).mLoadListener != null) {
                ((ATBaseAdAdapter) GDTATRewardedVideoAdapter.this).mLoadListener.onAdDataLoaded();
            }
        }

        @Override // com.qq.e.ads.rewardvideo.RewardVideoADListener
        public final void onADShow() {
        }

        @Override // com.qq.e.ads.rewardvideo.RewardVideoADListener
        public final void onError(AdError adError) {
            GDTATRewardedVideoAdapter gDTATRewardedVideoAdapter = GDTATRewardedVideoAdapter.this;
            StringBuilder sb = new StringBuilder();
            sb.append(adError.getErrorCode());
            gDTATRewardedVideoAdapter.notifyATLoadFail(sb.toString(), adError.getErrorMsg());
        }

        @Override // com.qq.e.ads.rewardvideo.RewardVideoADListener
        public final void onReward(Map<String, Object> map) {
            if (GDTATRewardedVideoAdapter.this.f12462h == null) {
                GDTATRewardedVideoAdapter.this.f12462h = new HashMap();
            }
            GDTATRewardedVideoAdapter.this.f12462h.put("gdt_trans_id", map.get("transId"));
            if (((CustomRewardVideoAdapter) GDTATRewardedVideoAdapter.this).mImpressionListener != null) {
                ((CustomRewardVideoAdapter) GDTATRewardedVideoAdapter.this).mImpressionListener.onReward();
            }
        }

        @Override // com.qq.e.ads.rewardvideo.RewardVideoADListener
        public final void onVideoCached() {
            RewardVideoAD rewardVideoAD;
            if (!GDTATRewardedVideoAdapter.this.f12465k) {
                if (((ATBaseAdAdapter) GDTATRewardedVideoAdapter.this).mLoadListener != null) {
                    ((ATBaseAdAdapter) GDTATRewardedVideoAdapter.this).mLoadListener.onAdCacheLoaded(new BaseAd[0]);
                    return;
                }
                return;
            }
            GDTATRewardedVideoAdapter gDTATRewardedVideoAdapter = GDTATRewardedVideoAdapter.this;
            if (gDTATRewardedVideoAdapter.mBiddingListener == null || (rewardVideoAD = gDTATRewardedVideoAdapter.a) == null) {
                return;
            }
            double ecpm = rewardVideoAD.getECPM();
            GDTATBiddingNotice gDTATBiddingNotice = new GDTATBiddingNotice(GDTATRewardedVideoAdapter.this.a);
            ATBiddingListener aTBiddingListener = GDTATRewardedVideoAdapter.this.mBiddingListener;
            StringBuilder sb = new StringBuilder();
            sb.append(System.currentTimeMillis());
            aTBiddingListener.onC2SBiddingResultWithCache(ATBiddingResult.success(ecpm, sb.toString(), gDTATBiddingNotice, ATAdConst.CURRENCY.RMB_CENT), null);
        }

        @Override // com.qq.e.ads.rewardvideo.RewardVideoADListener
        public final void onVideoComplete() {
            if (((CustomRewardVideoAdapter) GDTATRewardedVideoAdapter.this).mImpressionListener != null) {
                ((CustomRewardVideoAdapter) GDTATRewardedVideoAdapter.this).mImpressionListener.onRewardedVideoAdPlayEnd();
            }
        }

        public final void onReward() {
            if (((CustomRewardVideoAdapter) GDTATRewardedVideoAdapter.this).mImpressionListener != null) {
                ((CustomRewardVideoAdapter) GDTATRewardedVideoAdapter.this).mImpressionListener.onReward();
            }
        }
    }

    private void a(Context context, Map<String, Object> map) {
        if (this.f12464j == 2) {
            if (!(context instanceof Activity)) {
                notifyATLoadFail("", "GDT UnifiedInterstitial's context must be activity.");
                return;
            }
            AnonymousClass3 anonymousClass3 = new AnonymousClass3();
            if (!TextUtils.isEmpty(this.f12460e) && !this.f12465k) {
                this.b = new UnifiedInterstitialAD((Activity) context, this.f12459d, anonymousClass3, null, this.f12460e);
            } else {
                this.b = new UnifiedInterstitialAD((Activity) context, this.f12459d, anonymousClass3);
                UnifiedInterstitialAD unifiedInterstitialAD = this.b;
                GDTATInitManager.getInstance();
                unifiedInterstitialAD.setLoadAdParams(GDTATInitManager.a(map));
            }
            UnifiedInterstitialAD unifiedInterstitialAD2 = this.b;
            int i2 = map.containsKey("video_muted") ? Integer.parseInt(map.get("video_muted").toString()) : 0;
            int i3 = map.containsKey("video_autoplay") ? Integer.parseInt(map.get("video_autoplay").toString()) : 1;
            int i4 = map.containsKey("video_duration") ? Integer.parseInt(map.get("video_duration").toString()) : -1;
            if (unifiedInterstitialAD2 != null) {
                unifiedInterstitialAD2.setVideoOption(new VideoOption.Builder().setAutoPlayMuted(i2 == 1).setDetailPageMuted(i2 == 1).setAutoPlayPolicy(i3).build());
                if (i4 != -1) {
                    unifiedInterstitialAD2.setMaxVideoDuration(i4);
                }
            }
            this.b.setMediaListener(new AnonymousClass4());
            this.b.loadFullScreenAD();
            return;
        }
        AnonymousClass2 anonymousClass2 = new AnonymousClass2();
        if (!TextUtils.isEmpty(this.f12460e) && !this.f12465k) {
            this.a = new RewardVideoAD(context.getApplicationContext(), this.f12459d, anonymousClass2, this.f12461g != 1, this.f12460e);
        } else {
            this.a = new RewardVideoAD(context.getApplicationContext(), this.f12459d, anonymousClass2, this.f12461g != 1);
            RewardVideoAD rewardVideoAD = this.a;
            GDTATInitManager.getInstance();
            rewardVideoAD.setLoadAdParams(GDTATInitManager.a(map));
        }
        try {
            ServerSideVerificationOptions.Builder builder = new ServerSideVerificationOptions.Builder();
            builder.setUserId(this.mUserId);
            if (!TextUtils.isEmpty(this.mUserData) && this.mUserData.contains(ATAdConst.REWARD_EXTRA_REPLACE_HODLER_KEY.NETWORK_PLACEMENT_ID_HOLDER_NAME)) {
                this.mUserData = this.mUserData.replace(ATAdConst.REWARD_EXTRA_REPLACE_HODLER_KEY.NETWORK_PLACEMENT_ID_HOLDER_NAME, this.f12459d);
            }
            builder.setCustomData(this.mUserData);
            this.a.setServerSideVerificationOptions(builder.build());
        } catch (Throwable unused) {
        }
        this.a.loadAD();
    }

    private static void a(UnifiedInterstitialAD unifiedInterstitialAD, Map<String, Object> map) {
        int i2 = map.containsKey("video_muted") ? Integer.parseInt(map.get("video_muted").toString()) : 0;
        int i3 = map.containsKey("video_autoplay") ? Integer.parseInt(map.get("video_autoplay").toString()) : 1;
        int i4 = map.containsKey("video_duration") ? Integer.parseInt(map.get("video_duration").toString()) : -1;
        if (unifiedInterstitialAD != null) {
            unifiedInterstitialAD.setVideoOption(new VideoOption.Builder().setAutoPlayMuted(i2 == 1).setDetailPageMuted(i2 == 1).setAutoPlayPolicy(i3).build());
            if (i4 != -1) {
                unifiedInterstitialAD.setMaxVideoDuration(i4);
            }
        }
    }

    static /* synthetic */ void a(GDTATRewardedVideoAdapter gDTATRewardedVideoAdapter, Context context, Map map) {
        if (gDTATRewardedVideoAdapter.f12464j == 2) {
            if (!(context instanceof Activity)) {
                gDTATRewardedVideoAdapter.notifyATLoadFail("", "GDT UnifiedInterstitial's context must be activity.");
                return;
            }
            AnonymousClass3 anonymousClass3 = gDTATRewardedVideoAdapter.new AnonymousClass3();
            if (!TextUtils.isEmpty(gDTATRewardedVideoAdapter.f12460e) && !gDTATRewardedVideoAdapter.f12465k) {
                gDTATRewardedVideoAdapter.b = new UnifiedInterstitialAD((Activity) context, gDTATRewardedVideoAdapter.f12459d, anonymousClass3, null, gDTATRewardedVideoAdapter.f12460e);
            } else {
                gDTATRewardedVideoAdapter.b = new UnifiedInterstitialAD((Activity) context, gDTATRewardedVideoAdapter.f12459d, anonymousClass3);
                UnifiedInterstitialAD unifiedInterstitialAD = gDTATRewardedVideoAdapter.b;
                GDTATInitManager.getInstance();
                unifiedInterstitialAD.setLoadAdParams(GDTATInitManager.a((Map<String, Object>) map));
            }
            UnifiedInterstitialAD unifiedInterstitialAD2 = gDTATRewardedVideoAdapter.b;
            int i2 = map.containsKey("video_muted") ? Integer.parseInt(map.get("video_muted").toString()) : 0;
            int i3 = map.containsKey("video_autoplay") ? Integer.parseInt(map.get("video_autoplay").toString()) : 1;
            int i4 = map.containsKey("video_duration") ? Integer.parseInt(map.get("video_duration").toString()) : -1;
            if (unifiedInterstitialAD2 != null) {
                unifiedInterstitialAD2.setVideoOption(new VideoOption.Builder().setAutoPlayMuted(i2 == 1).setDetailPageMuted(i2 == 1).setAutoPlayPolicy(i3).build());
                if (i4 != -1) {
                    unifiedInterstitialAD2.setMaxVideoDuration(i4);
                }
            }
            gDTATRewardedVideoAdapter.b.setMediaListener(gDTATRewardedVideoAdapter.new AnonymousClass4());
            gDTATRewardedVideoAdapter.b.loadFullScreenAD();
            return;
        }
        AnonymousClass2 anonymousClass2 = gDTATRewardedVideoAdapter.new AnonymousClass2();
        if (!TextUtils.isEmpty(gDTATRewardedVideoAdapter.f12460e) && !gDTATRewardedVideoAdapter.f12465k) {
            gDTATRewardedVideoAdapter.a = new RewardVideoAD(context.getApplicationContext(), gDTATRewardedVideoAdapter.f12459d, anonymousClass2, gDTATRewardedVideoAdapter.f12461g != 1, gDTATRewardedVideoAdapter.f12460e);
        } else {
            gDTATRewardedVideoAdapter.a = new RewardVideoAD(context.getApplicationContext(), gDTATRewardedVideoAdapter.f12459d, anonymousClass2, gDTATRewardedVideoAdapter.f12461g != 1);
            RewardVideoAD rewardVideoAD = gDTATRewardedVideoAdapter.a;
            GDTATInitManager.getInstance();
            rewardVideoAD.setLoadAdParams(GDTATInitManager.a((Map<String, Object>) map));
        }
        try {
            ServerSideVerificationOptions.Builder builder = new ServerSideVerificationOptions.Builder();
            builder.setUserId(gDTATRewardedVideoAdapter.mUserId);
            if (!TextUtils.isEmpty(gDTATRewardedVideoAdapter.mUserData) && gDTATRewardedVideoAdapter.mUserData.contains(ATAdConst.REWARD_EXTRA_REPLACE_HODLER_KEY.NETWORK_PLACEMENT_ID_HOLDER_NAME)) {
                gDTATRewardedVideoAdapter.mUserData = gDTATRewardedVideoAdapter.mUserData.replace(ATAdConst.REWARD_EXTRA_REPLACE_HODLER_KEY.NETWORK_PLACEMENT_ID_HOLDER_NAME, gDTATRewardedVideoAdapter.f12459d);
            }
            builder.setCustomData(gDTATRewardedVideoAdapter.mUserData);
            gDTATRewardedVideoAdapter.a.setServerSideVerificationOptions(builder.build());
        } catch (Throwable unused) {
        }
        gDTATRewardedVideoAdapter.a.loadAD();
    }
}
