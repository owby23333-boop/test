package com.anythink.network.ks;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.anythink.core.api.ATAdConst;
import com.anythink.core.api.ATBaseAdAdapter;
import com.anythink.core.api.ATBidRequestInfoListener;
import com.anythink.core.api.ATBiddingListener;
import com.anythink.core.api.ATBiddingResult;
import com.anythink.core.api.ATInitMediation;
import com.anythink.core.api.BaseAd;
import com.anythink.core.api.MediationInitCallback;
import com.anythink.core.common.b.g;
import com.anythink.rewardvideo.unitgroup.api.CustomRewardVideoAdapter;
import com.bytedance.msdk.adapter.pangle.PangleAdapterUtils;
import com.kwad.sdk.api.KsAdSDK;
import com.kwad.sdk.api.KsLoadManager;
import com.kwad.sdk.api.KsRewardVideoAd;
import com.kwad.sdk.api.KsScene;
import com.kwad.sdk.api.KsVideoPlayConfig;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public class KSATRewardedVideoAdapter extends CustomRewardVideoAdapter {
    long a;
    int b;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    boolean f12515d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    String f12516e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    double f12517f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    KsRewardVideoAd f12518g;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    boolean f12514c = false;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    boolean f12519h = false;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    boolean f12520i = false;

    /* JADX INFO: renamed from: com.anythink.network.ks.KSATRewardedVideoAdapter$4, reason: invalid class name */
    final class AnonymousClass4 implements KsLoadManager.RewardVideoAdListener {
        AnonymousClass4() {
        }

        @Override // com.kwad.sdk.api.KsLoadManager.RewardVideoAdListener
        public final void onError(int i2, String str) {
            KSATRewardedVideoAdapter.this.notifyATLoadFail(String.valueOf(i2), str);
        }

        @Override // com.kwad.sdk.api.KsLoadManager.RewardVideoAdListener
        public final void onRewardVideoAdLoad(@Nullable List<KsRewardVideoAd> list) {
            KSATRewardedVideoAdapter.this.f12518g = (list == null || list.size() <= 0) ? null : list.get(0);
            KSATRewardedVideoAdapter kSATRewardedVideoAdapter = KSATRewardedVideoAdapter.this;
            KsRewardVideoAd ksRewardVideoAd = kSATRewardedVideoAdapter.f12518g;
            if (ksRewardVideoAd == null) {
                kSATRewardedVideoAdapter.notifyATLoadFail("", "KuaiShou: List<KsRewardVideoAd> is empty");
                return;
            }
            if (!kSATRewardedVideoAdapter.f12519h) {
                if (((ATBaseAdAdapter) kSATRewardedVideoAdapter).mLoadListener != null) {
                    ((ATBaseAdAdapter) KSATRewardedVideoAdapter.this).mLoadListener.onAdCacheLoaded(new BaseAd[0]);
                }
            } else if (kSATRewardedVideoAdapter.mBiddingListener != null) {
                double ecpm = PangleAdapterUtils.CPM_DEFLAUT_VALUE;
                try {
                    ecpm = ksRewardVideoAd.getECPM();
                } catch (Throwable th) {
                    th.printStackTrace();
                }
                KSATBiddingNotice kSATBiddingNotice = new KSATBiddingNotice(KSATRewardedVideoAdapter.this.f12518g);
                ATBiddingListener aTBiddingListener = KSATRewardedVideoAdapter.this.mBiddingListener;
                StringBuilder sb = new StringBuilder();
                sb.append(System.currentTimeMillis());
                aTBiddingListener.onC2SBiddingResultWithCache(ATBiddingResult.success(ecpm, sb.toString(), kSATBiddingNotice, ATAdConst.CURRENCY.RMB_CENT), null);
            }
        }

        @Override // com.kwad.sdk.api.KsLoadManager.RewardVideoAdListener
        public final void onRewardVideoResult(@Nullable List<KsRewardVideoAd> list) {
            if (((ATBaseAdAdapter) KSATRewardedVideoAdapter.this).mLoadListener != null) {
                ((ATBaseAdAdapter) KSATRewardedVideoAdapter.this).mLoadListener.onAdDataLoaded();
            }
        }
    }

    static /* synthetic */ void A(KSATRewardedVideoAdapter kSATRewardedVideoAdapter) {
        HashMap map = new HashMap();
        map.put("thirdUserId", kSATRewardedVideoAdapter.mUserId);
        if (!TextUtils.isEmpty(kSATRewardedVideoAdapter.mUserData) && kSATRewardedVideoAdapter.mUserData.contains(ATAdConst.REWARD_EXTRA_REPLACE_HODLER_KEY.NETWORK_PLACEMENT_ID_HOLDER_NAME)) {
            String str = kSATRewardedVideoAdapter.mUserData;
            StringBuilder sb = new StringBuilder();
            sb.append(kSATRewardedVideoAdapter.a);
            kSATRewardedVideoAdapter.mUserData = str.replace(ATAdConst.REWARD_EXTRA_REPLACE_HODLER_KEY.NETWORK_PLACEMENT_ID_HOLDER_NAME, sb.toString());
        }
        map.put("extraData", kSATRewardedVideoAdapter.mUserData);
        KsScene.Builder builderRewardCallbackExtraData = new KsScene.Builder(kSATRewardedVideoAdapter.a).adNum(1).screenOrientation(kSATRewardedVideoAdapter.b == 2 ? 2 : 1).rewardCallbackExtraData(map);
        if (!TextUtils.isEmpty(kSATRewardedVideoAdapter.f12516e)) {
            builderRewardCallbackExtraData.setBidResponseV2(kSATRewardedVideoAdapter.f12516e);
        }
        KsAdSDK.getLoadManager().loadRewardVideoAd(builderRewardCallbackExtraData.build(), kSATRewardedVideoAdapter.new AnonymousClass4());
    }

    static /* synthetic */ int i(KSATRewardedVideoAdapter kSATRewardedVideoAdapter) {
        kSATRewardedVideoAdapter.mDismissType = 2;
        return 2;
    }

    static /* synthetic */ int v(KSATRewardedVideoAdapter kSATRewardedVideoAdapter) {
        kSATRewardedVideoAdapter.mDismissType = 2;
        return 2;
    }

    @Override // com.anythink.core.api.ATBaseAdAdapter
    public void destory() {
        KsRewardVideoAd ksRewardVideoAd = this.f12518g;
        if (ksRewardVideoAd != null) {
            ksRewardVideoAd.setRewardAdInteractionListener(null);
            this.f12518g.setRewardPlayAgainInteractionListener(null);
            this.f12518g = null;
        }
    }

    @Override // com.anythink.core.api.ATBaseAdAdapter
    public void getBidRequestInfo(Context context, Map<String, Object> map, Map<String, Object> map2, ATBidRequestInfoListener aTBidRequestInfoListener) {
        this.a = ATInitMediation.getLongFromMap(map, "position_id");
        KSATInitManager.getInstance().a(context, map, map2, aTBidRequestInfoListener);
    }

    @Override // com.anythink.core.api.ATBaseAdAdapter
    public String getNetworkName() {
        return KSATInitManager.getInstance().getNetworkName();
    }

    @Override // com.anythink.core.api.ATBaseAdAdapter
    public String getNetworkPlacementId() {
        try {
            return String.valueOf(this.a);
        } catch (Exception e2) {
            e2.printStackTrace();
            return "";
        }
    }

    @Override // com.anythink.core.api.ATBaseAdAdapter
    public String getNetworkSDKVersion() {
        return KSATInitManager.getInstance().getNetworkVersion();
    }

    @Override // com.anythink.core.api.ATBaseAdAdapter
    public boolean isAdReady() {
        KsRewardVideoAd ksRewardVideoAd = this.f12518g;
        return ksRewardVideoAd != null && ksRewardVideoAd.isAdEnable();
    }

    @Override // com.anythink.core.api.ATBaseAdAdapter
    public void loadCustomNetworkAd(Context context, Map<String, Object> map, Map<String, Object> map2) {
        if (a(map, map2)) {
            KSATInitManager.getInstance().initSDK(context.getApplicationContext(), map, new MediationInitCallback() { // from class: com.anythink.network.ks.KSATRewardedVideoAdapter.3
                @Override // com.anythink.core.api.MediationInitCallback
                public final void onFail(String str) {
                    KSATRewardedVideoAdapter.this.notifyATLoadFail("", str);
                }

                @Override // com.anythink.core.api.MediationInitCallback
                public final void onSuccess() {
                    KSATRewardedVideoAdapter.A(KSATRewardedVideoAdapter.this);
                }
            });
        } else {
            notifyATLoadFail("", "kuaishou app_id or position_id is empty.");
        }
    }

    @Override // com.anythink.rewardvideo.unitgroup.api.CustomRewardVideoAdapter
    public void show(Activity activity) {
        KsRewardVideoAd ksRewardVideoAd = this.f12518g;
        if (ksRewardVideoAd == null || activity == null) {
            return;
        }
        try {
            ksRewardVideoAd.setRewardAdInteractionListener(new KsRewardVideoAd.RewardAdInteractionListener() { // from class: com.anythink.network.ks.KSATRewardedVideoAdapter.1
                @Override // com.kwad.sdk.api.KsRewardVideoAd.RewardAdInteractionListener
                public final void onAdClicked() {
                    if (((CustomRewardVideoAdapter) KSATRewardedVideoAdapter.this).mImpressionListener != null) {
                        ((CustomRewardVideoAdapter) KSATRewardedVideoAdapter.this).mImpressionListener.onRewardedVideoAdPlayClicked();
                    }
                }

                @Override // com.kwad.sdk.api.KsRewardVideoAd.RewardAdInteractionListener
                public final void onExtraRewardVerify(int i2) {
                }

                @Override // com.kwad.sdk.api.KsRewardVideoAd.RewardAdInteractionListener
                public final void onPageDismiss() {
                    KSATRewardedVideoAdapter kSATRewardedVideoAdapter = KSATRewardedVideoAdapter.this;
                    if (kSATRewardedVideoAdapter.f12520i) {
                        return;
                    }
                    kSATRewardedVideoAdapter.f12520i = true;
                    if (((CustomRewardVideoAdapter) kSATRewardedVideoAdapter).mImpressionListener != null) {
                        ((CustomRewardVideoAdapter) KSATRewardedVideoAdapter.this).mImpressionListener.onRewardedVideoAdClosed();
                    }
                }

                @Override // com.kwad.sdk.api.KsRewardVideoAd.RewardAdInteractionListener
                public final void onRewardStepVerify(int i2, int i3) {
                }

                @Override // com.kwad.sdk.api.KsRewardVideoAd.RewardAdInteractionListener
                public final void onRewardVerify() {
                    if (((CustomRewardVideoAdapter) KSATRewardedVideoAdapter.this).mImpressionListener != null) {
                        ((CustomRewardVideoAdapter) KSATRewardedVideoAdapter.this).mImpressionListener.onReward();
                    }
                }

                @Override // com.kwad.sdk.api.KsRewardVideoAd.RewardAdInteractionListener
                public final void onVideoPlayEnd() {
                    if (((CustomRewardVideoAdapter) KSATRewardedVideoAdapter.this).mImpressionListener != null) {
                        ((CustomRewardVideoAdapter) KSATRewardedVideoAdapter.this).mImpressionListener.onRewardedVideoAdPlayEnd();
                    }
                }

                @Override // com.kwad.sdk.api.KsRewardVideoAd.RewardAdInteractionListener
                public final void onVideoPlayError(int i2, int i3) {
                    if (((CustomRewardVideoAdapter) KSATRewardedVideoAdapter.this).mImpressionListener != null) {
                        ((CustomRewardVideoAdapter) KSATRewardedVideoAdapter.this).mImpressionListener.onRewardedVideoAdPlayFailed(String.valueOf(i2), "");
                    }
                }

                @Override // com.kwad.sdk.api.KsRewardVideoAd.RewardAdInteractionListener
                public final void onVideoPlayStart() {
                    try {
                        KSATInitManager.getInstance().a(KSATRewardedVideoAdapter.this.getTrackingInfo().l(), new WeakReference(KSATRewardedVideoAdapter.this.f12518g));
                    } catch (Throwable unused) {
                    }
                    if (((CustomRewardVideoAdapter) KSATRewardedVideoAdapter.this).mImpressionListener != null) {
                        ((CustomRewardVideoAdapter) KSATRewardedVideoAdapter.this).mImpressionListener.onRewardedVideoAdPlayStart();
                    }
                }

                @Override // com.kwad.sdk.api.KsRewardVideoAd.RewardAdInteractionListener
                public final void onVideoSkipToEnd(long j2) {
                    KSATRewardedVideoAdapter.i(KSATRewardedVideoAdapter.this);
                }
            });
            this.f12518g.setRewardPlayAgainInteractionListener(new KsRewardVideoAd.RewardAdInteractionListener() { // from class: com.anythink.network.ks.KSATRewardedVideoAdapter.2
                @Override // com.kwad.sdk.api.KsRewardVideoAd.RewardAdInteractionListener
                public final void onAdClicked() {
                    if (((CustomRewardVideoAdapter) KSATRewardedVideoAdapter.this).mImpressionListener != null) {
                        ((CustomRewardVideoAdapter) KSATRewardedVideoAdapter.this).mImpressionListener.onRewardedVideoAdAgainPlayClicked();
                    }
                }

                @Override // com.kwad.sdk.api.KsRewardVideoAd.RewardAdInteractionListener
                public final void onExtraRewardVerify(int i2) {
                }

                @Override // com.kwad.sdk.api.KsRewardVideoAd.RewardAdInteractionListener
                public final void onPageDismiss() {
                    KSATRewardedVideoAdapter kSATRewardedVideoAdapter = KSATRewardedVideoAdapter.this;
                    if (kSATRewardedVideoAdapter.f12520i) {
                        return;
                    }
                    kSATRewardedVideoAdapter.f12520i = true;
                    if (((CustomRewardVideoAdapter) kSATRewardedVideoAdapter).mImpressionListener != null) {
                        ((CustomRewardVideoAdapter) KSATRewardedVideoAdapter.this).mImpressionListener.onRewardedVideoAdClosed();
                    }
                }

                @Override // com.kwad.sdk.api.KsRewardVideoAd.RewardAdInteractionListener
                public final void onRewardStepVerify(int i2, int i3) {
                }

                @Override // com.kwad.sdk.api.KsRewardVideoAd.RewardAdInteractionListener
                public final void onRewardVerify() {
                    if (((CustomRewardVideoAdapter) KSATRewardedVideoAdapter.this).mImpressionListener != null) {
                        ((CustomRewardVideoAdapter) KSATRewardedVideoAdapter.this).mImpressionListener.onAgainReward();
                    }
                }

                @Override // com.kwad.sdk.api.KsRewardVideoAd.RewardAdInteractionListener
                public final void onVideoPlayEnd() {
                    if (((CustomRewardVideoAdapter) KSATRewardedVideoAdapter.this).mImpressionListener != null) {
                        ((CustomRewardVideoAdapter) KSATRewardedVideoAdapter.this).mImpressionListener.onRewardedVideoAdAgainPlayEnd();
                    }
                }

                @Override // com.kwad.sdk.api.KsRewardVideoAd.RewardAdInteractionListener
                public final void onVideoPlayError(int i2, int i3) {
                    if (((CustomRewardVideoAdapter) KSATRewardedVideoAdapter.this).mImpressionListener != null) {
                        ((CustomRewardVideoAdapter) KSATRewardedVideoAdapter.this).mImpressionListener.onRewardedVideoAdAgainPlayFailed(String.valueOf(i2), "Again AD, Callback VideoError");
                    }
                }

                @Override // com.kwad.sdk.api.KsRewardVideoAd.RewardAdInteractionListener
                public final void onVideoPlayStart() {
                    if (((CustomRewardVideoAdapter) KSATRewardedVideoAdapter.this).mImpressionListener != null) {
                        ((CustomRewardVideoAdapter) KSATRewardedVideoAdapter.this).mImpressionListener.onRewardedVideoAdAgainPlayStart();
                    }
                }

                @Override // com.kwad.sdk.api.KsRewardVideoAd.RewardAdInteractionListener
                public final void onVideoSkipToEnd(long j2) {
                    KSATRewardedVideoAdapter.v(KSATRewardedVideoAdapter.this);
                }
            });
            KsVideoPlayConfig ksVideoPlayConfigBuild = new KsVideoPlayConfig.Builder().showLandscape(this.b == 2).skipThirtySecond(this.f12514c).videoSoundEnable(this.f12515d).build();
            this.f12520i = false;
            this.f12518g.showRewardVideoAd(activity, ksVideoPlayConfigBuild);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    @Override // com.anythink.core.api.ATBaseAdAdapter
    public boolean startBiddingRequest(Context context, Map<String, Object> map, Map<String, Object> map2, ATBiddingListener aTBiddingListener) {
        this.f12519h = true;
        loadCustomNetworkAd(context, map, map2);
        return true;
    }

    private void a() {
        HashMap map = new HashMap();
        map.put("thirdUserId", this.mUserId);
        if (!TextUtils.isEmpty(this.mUserData) && this.mUserData.contains(ATAdConst.REWARD_EXTRA_REPLACE_HODLER_KEY.NETWORK_PLACEMENT_ID_HOLDER_NAME)) {
            String str = this.mUserData;
            StringBuilder sb = new StringBuilder();
            sb.append(this.a);
            this.mUserData = str.replace(ATAdConst.REWARD_EXTRA_REPLACE_HODLER_KEY.NETWORK_PLACEMENT_ID_HOLDER_NAME, sb.toString());
        }
        map.put("extraData", this.mUserData);
        KsScene.Builder builderRewardCallbackExtraData = new KsScene.Builder(this.a).adNum(1).screenOrientation(this.b == 2 ? 2 : 1).rewardCallbackExtraData(map);
        if (!TextUtils.isEmpty(this.f12516e)) {
            builderRewardCallbackExtraData.setBidResponseV2(this.f12516e);
        }
        KsAdSDK.getLoadManager().loadRewardVideoAd(builderRewardCallbackExtraData.build(), new AnonymousClass4());
    }

    private boolean a(Map<String, Object> map, Map<String, Object> map2) {
        String stringFromMap = ATInitMediation.getStringFromMap(map, "app_id");
        String stringFromMap2 = ATInitMediation.getStringFromMap(map, "position_id");
        if (TextUtils.isEmpty(stringFromMap) || TextUtils.isEmpty(stringFromMap2)) {
            return false;
        }
        try {
            this.a = Long.parseLong(stringFromMap2);
        } catch (NumberFormatException unused) {
        }
        if (map.containsKey("orientation")) {
            this.b = ATInitMediation.getIntFromMap(map, "orientation");
        }
        this.f12515d = true;
        if (map.containsKey("video_muted")) {
            this.f12515d = TextUtils.equals("0", ATInitMediation.getStringFromMap(map, "video_muted"));
        }
        if (map2.containsKey(KSATConst.REWARDEDVIDEO_SKIP_AFTER_THIRTY_SECOND)) {
            this.f12514c = ATInitMediation.getBooleanFromMap(map2, KSATConst.REWARDEDVIDEO_SKIP_AFTER_THIRTY_SECOND);
        }
        if (map.containsKey(g.k.f6905o)) {
            this.f12517f = ATInitMediation.getDoubleFromMap(map, g.k.f6905o);
        }
        if (map.containsKey("payload")) {
            this.f12516e = KSATInitManager.getInstance().getPayloadInfo(ATInitMediation.getStringFromMap(map, "payload"), this.f12517f);
        }
        return true;
    }
}
