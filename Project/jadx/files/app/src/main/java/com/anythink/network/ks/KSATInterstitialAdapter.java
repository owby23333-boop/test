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
import com.anythink.interstitial.unitgroup.api.CustomInterstitialAdapter;
import com.bytedance.msdk.adapter.pangle.PangleAdapterUtils;
import com.kwad.sdk.api.KsAdSDK;
import com.kwad.sdk.api.KsFullScreenVideoAd;
import com.kwad.sdk.api.KsInterstitialAd;
import com.kwad.sdk.api.KsLoadManager;
import com.kwad.sdk.api.KsScene;
import com.kwad.sdk.api.KsVideoPlayConfig;
import java.lang.ref.WeakReference;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public class KSATInterstitialAdapter extends CustomInterstitialAdapter {
    long a;
    int b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    boolean f12501c;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    String f12503e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    KsFullScreenVideoAd f12504f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    KsInterstitialAd f12505g;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    double f12507i;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    int f12502d = 1;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    boolean f12506h = false;

    /* JADX INFO: renamed from: com.anythink.network.ks.KSATInterstitialAdapter$2, reason: invalid class name */
    final class AnonymousClass2 implements KsLoadManager.InterstitialAdListener {
        AnonymousClass2() {
        }

        @Override // com.kwad.sdk.api.KsLoadManager.InterstitialAdListener
        public final void onError(int i2, String str) {
            KSATInterstitialAdapter.this.notifyATLoadFail(String.valueOf(i2), str);
        }

        @Override // com.kwad.sdk.api.KsLoadManager.InterstitialAdListener
        public final void onInterstitialAdLoad(@Nullable List<KsInterstitialAd> list) {
            KSATInterstitialAdapter.this.f12505g = (list == null || list.size() <= 0) ? null : list.get(0);
            KSATInterstitialAdapter kSATInterstitialAdapter = KSATInterstitialAdapter.this;
            KsInterstitialAd ksInterstitialAd = kSATInterstitialAdapter.f12505g;
            if (ksInterstitialAd == null) {
                kSATInterstitialAdapter.notifyATLoadFail("", "KuaiShou: List<KsInterstitialAd> is empty.");
                return;
            }
            if (!kSATInterstitialAdapter.f12506h) {
                if (((ATBaseAdAdapter) kSATInterstitialAdapter).mLoadListener != null) {
                    ((ATBaseAdAdapter) KSATInterstitialAdapter.this).mLoadListener.onAdCacheLoaded(new BaseAd[0]);
                }
            } else {
                if (kSATInterstitialAdapter.mBiddingListener == null) {
                    kSATInterstitialAdapter.notifyATLoadFail("", "KuaiShou: KsInterstitialAd had been destroyed.");
                    return;
                }
                double ecpm = PangleAdapterUtils.CPM_DEFLAUT_VALUE;
                try {
                    ecpm = ksInterstitialAd.getECPM();
                } catch (Throwable th) {
                    th.printStackTrace();
                }
                KSATBiddingNotice kSATBiddingNotice = new KSATBiddingNotice(KSATInterstitialAdapter.this.f12505g);
                ATBiddingListener aTBiddingListener = KSATInterstitialAdapter.this.mBiddingListener;
                StringBuilder sb = new StringBuilder();
                sb.append(System.currentTimeMillis());
                aTBiddingListener.onC2SBiddingResultWithCache(ATBiddingResult.success(ecpm, sb.toString(), kSATBiddingNotice, ATAdConst.CURRENCY.RMB_CENT), null);
            }
        }

        @Override // com.kwad.sdk.api.KsLoadManager.InterstitialAdListener
        public final void onRequestResult(int i2) {
            if (((ATBaseAdAdapter) KSATInterstitialAdapter.this).mLoadListener != null) {
                ((ATBaseAdAdapter) KSATInterstitialAdapter.this).mLoadListener.onAdDataLoaded();
            }
        }
    }

    /* JADX INFO: renamed from: com.anythink.network.ks.KSATInterstitialAdapter$3, reason: invalid class name */
    final class AnonymousClass3 implements KsLoadManager.FullScreenVideoAdListener {
        AnonymousClass3() {
        }

        @Override // com.kwad.sdk.api.KsLoadManager.FullScreenVideoAdListener
        public final void onError(int i2, String str) {
            KSATInterstitialAdapter.this.notifyATLoadFail(String.valueOf(i2), str);
        }

        @Override // com.kwad.sdk.api.KsLoadManager.FullScreenVideoAdListener
        public final void onFullScreenVideoAdLoad(@Nullable List<KsFullScreenVideoAd> list) {
            KSATInterstitialAdapter.this.f12504f = (list == null || list.size() <= 0) ? null : list.get(0);
            KSATInterstitialAdapter kSATInterstitialAdapter = KSATInterstitialAdapter.this;
            KsFullScreenVideoAd ksFullScreenVideoAd = kSATInterstitialAdapter.f12504f;
            if (ksFullScreenVideoAd == null) {
                kSATInterstitialAdapter.notifyATLoadFail("", "KuaiShou: List<KsFullScreenVideoAd> is empty.");
                return;
            }
            if (!kSATInterstitialAdapter.f12506h) {
                if (((ATBaseAdAdapter) kSATInterstitialAdapter).mLoadListener != null) {
                    ((ATBaseAdAdapter) KSATInterstitialAdapter.this).mLoadListener.onAdCacheLoaded(new BaseAd[0]);
                }
            } else {
                if (kSATInterstitialAdapter.mBiddingListener == null) {
                    kSATInterstitialAdapter.notifyATLoadFail("", "KuaiShou: KsFullScreenVideoAd had been destroyed.");
                    return;
                }
                double ecpm = PangleAdapterUtils.CPM_DEFLAUT_VALUE;
                try {
                    ecpm = ksFullScreenVideoAd.getECPM();
                } catch (Throwable th) {
                    th.printStackTrace();
                }
                KSATBiddingNotice kSATBiddingNotice = new KSATBiddingNotice(KSATInterstitialAdapter.this.f12504f);
                ATBiddingListener aTBiddingListener = KSATInterstitialAdapter.this.mBiddingListener;
                StringBuilder sb = new StringBuilder();
                sb.append(System.currentTimeMillis());
                aTBiddingListener.onC2SBiddingResultWithCache(ATBiddingResult.success(ecpm, sb.toString(), kSATBiddingNotice, ATAdConst.CURRENCY.RMB_CENT), null);
            }
        }

        @Override // com.kwad.sdk.api.KsLoadManager.FullScreenVideoAdListener
        public final void onFullScreenVideoResult(@Nullable List<KsFullScreenVideoAd> list) {
            if (((ATBaseAdAdapter) KSATInterstitialAdapter.this).mLoadListener != null) {
                ((ATBaseAdAdapter) KSATInterstitialAdapter.this).mLoadListener.onAdDataLoaded();
            }
        }
    }

    static /* synthetic */ int H(KSATInterstitialAdapter kSATInterstitialAdapter) {
        kSATInterstitialAdapter.mDismissType = 2;
        return 2;
    }

    private void a() {
        KsScene.Builder builderScreenOrientation = new KsScene.Builder(this.a).adNum(1).screenOrientation(this.b == 2 ? 2 : 1);
        if (!TextUtils.isEmpty(this.f12503e)) {
            builderScreenOrientation.setBidResponseV2(this.f12503e);
        }
        KsScene ksSceneBuild = builderScreenOrientation.build();
        if (this.f12502d == 0) {
            KsAdSDK.getLoadManager().loadInterstitialAd(ksSceneBuild, new AnonymousClass2());
        } else {
            KsAdSDK.getLoadManager().loadFullScreenVideoAd(ksSceneBuild, new AnonymousClass3());
        }
    }

    static /* synthetic */ int u(KSATInterstitialAdapter kSATInterstitialAdapter) {
        kSATInterstitialAdapter.mDismissType = 2;
        return 2;
    }

    @Override // com.anythink.core.api.ATBaseAdAdapter
    public void destory() {
        KsFullScreenVideoAd ksFullScreenVideoAd = this.f12504f;
        if (ksFullScreenVideoAd != null) {
            ksFullScreenVideoAd.setFullScreenVideoAdInteractionListener(null);
            this.f12504f = null;
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
        if (this.f12502d == 0) {
            return this.f12505g != null;
        }
        KsFullScreenVideoAd ksFullScreenVideoAd = this.f12504f;
        return ksFullScreenVideoAd != null && ksFullScreenVideoAd.isAdEnable();
    }

    @Override // com.anythink.core.api.ATBaseAdAdapter
    public void loadCustomNetworkAd(Context context, Map<String, Object> map, Map<String, Object> map2) {
        if (a(map)) {
            KSATInitManager.getInstance().initSDK(context, map, new MediationInitCallback() { // from class: com.anythink.network.ks.KSATInterstitialAdapter.1
                @Override // com.anythink.core.api.MediationInitCallback
                public final void onFail(String str) {
                    KSATInterstitialAdapter.this.notifyATLoadFail("", str);
                }

                @Override // com.anythink.core.api.MediationInitCallback
                public final void onSuccess() {
                    KSATInterstitialAdapter.a(KSATInterstitialAdapter.this);
                }
            });
        } else {
            notifyATLoadFail("", "kuaishou app_id or position_id is empty.");
        }
    }

    @Override // com.anythink.interstitial.unitgroup.api.CustomInterstitialAdapter
    public void show(Activity activity) {
        KsVideoPlayConfig ksVideoPlayConfigBuild = new KsVideoPlayConfig.Builder().showLandscape(this.b == 2).skipThirtySecond(false).videoSoundEnable(this.f12501c).build();
        KsFullScreenVideoAd ksFullScreenVideoAd = this.f12504f;
        if (ksFullScreenVideoAd != null && activity != null) {
            ksFullScreenVideoAd.setFullScreenVideoAdInteractionListener(new KsFullScreenVideoAd.FullScreenVideoAdInteractionListener() { // from class: com.anythink.network.ks.KSATInterstitialAdapter.4
                @Override // com.kwad.sdk.api.KsFullScreenVideoAd.FullScreenVideoAdInteractionListener
                public final void onAdClicked() {
                    if (((CustomInterstitialAdapter) KSATInterstitialAdapter.this).mImpressListener != null) {
                        ((CustomInterstitialAdapter) KSATInterstitialAdapter.this).mImpressListener.onInterstitialAdClicked();
                    }
                }

                @Override // com.kwad.sdk.api.KsFullScreenVideoAd.FullScreenVideoAdInteractionListener
                public final void onPageDismiss() {
                    if (((CustomInterstitialAdapter) KSATInterstitialAdapter.this).mImpressListener != null) {
                        ((CustomInterstitialAdapter) KSATInterstitialAdapter.this).mImpressListener.onInterstitialAdClose();
                    }
                }

                @Override // com.kwad.sdk.api.KsFullScreenVideoAd.FullScreenVideoAdInteractionListener
                public final void onSkippedVideo() {
                    KSATInterstitialAdapter.u(KSATInterstitialAdapter.this);
                }

                @Override // com.kwad.sdk.api.KsFullScreenVideoAd.FullScreenVideoAdInteractionListener
                public final void onVideoPlayEnd() {
                    if (((CustomInterstitialAdapter) KSATInterstitialAdapter.this).mImpressListener != null) {
                        ((CustomInterstitialAdapter) KSATInterstitialAdapter.this).mImpressListener.onInterstitialAdVideoEnd();
                    }
                }

                @Override // com.kwad.sdk.api.KsFullScreenVideoAd.FullScreenVideoAdInteractionListener
                public final void onVideoPlayError(int i2, int i3) {
                    if (((CustomInterstitialAdapter) KSATInterstitialAdapter.this).mImpressListener != null) {
                        ((CustomInterstitialAdapter) KSATInterstitialAdapter.this).mImpressListener.onInterstitialAdVideoError(String.valueOf(i2), "");
                    }
                }

                @Override // com.kwad.sdk.api.KsFullScreenVideoAd.FullScreenVideoAdInteractionListener
                public final void onVideoPlayStart() {
                    try {
                        KSATInitManager.getInstance().a(KSATInterstitialAdapter.this.getTrackingInfo().l(), new WeakReference(KSATInterstitialAdapter.this.f12504f));
                    } catch (Throwable unused) {
                    }
                    if (((CustomInterstitialAdapter) KSATInterstitialAdapter.this).mImpressListener != null) {
                        ((CustomInterstitialAdapter) KSATInterstitialAdapter.this).mImpressListener.onInterstitialAdShow();
                        ((CustomInterstitialAdapter) KSATInterstitialAdapter.this).mImpressListener.onInterstitialAdVideoStart();
                    }
                }
            });
            this.f12504f.showFullScreenVideoAd(activity, ksVideoPlayConfigBuild);
        }
        KsInterstitialAd ksInterstitialAd = this.f12505g;
        if (ksInterstitialAd == null || activity == null) {
            return;
        }
        ksInterstitialAd.setAdInteractionListener(new KsInterstitialAd.AdInteractionListener() { // from class: com.anythink.network.ks.KSATInterstitialAdapter.5
            @Override // com.kwad.sdk.api.KsInterstitialAd.AdInteractionListener
            public final void onAdClicked() {
                if (((CustomInterstitialAdapter) KSATInterstitialAdapter.this).mImpressListener != null) {
                    ((CustomInterstitialAdapter) KSATInterstitialAdapter.this).mImpressListener.onInterstitialAdClicked();
                }
            }

            @Override // com.kwad.sdk.api.KsInterstitialAd.AdInteractionListener
            public final void onAdClosed() {
            }

            @Override // com.kwad.sdk.api.KsInterstitialAd.AdInteractionListener
            public final void onAdShow() {
                try {
                    KSATInitManager.getInstance().a(KSATInterstitialAdapter.this.getTrackingInfo().l(), new WeakReference(KSATInterstitialAdapter.this.f12505g));
                } catch (Throwable unused) {
                }
                if (((CustomInterstitialAdapter) KSATInterstitialAdapter.this).mImpressListener != null) {
                    ((CustomInterstitialAdapter) KSATInterstitialAdapter.this).mImpressListener.onInterstitialAdShow();
                }
            }

            @Override // com.kwad.sdk.api.KsInterstitialAd.AdInteractionListener
            public final void onPageDismiss() {
                if (((CustomInterstitialAdapter) KSATInterstitialAdapter.this).mImpressListener != null) {
                    ((CustomInterstitialAdapter) KSATInterstitialAdapter.this).mImpressListener.onInterstitialAdClose();
                }
            }

            @Override // com.kwad.sdk.api.KsInterstitialAd.AdInteractionListener
            public final void onSkippedAd() {
                KSATInterstitialAdapter.H(KSATInterstitialAdapter.this);
            }

            @Override // com.kwad.sdk.api.KsInterstitialAd.AdInteractionListener
            public final void onVideoPlayEnd() {
                if (((CustomInterstitialAdapter) KSATInterstitialAdapter.this).mImpressListener != null) {
                    ((CustomInterstitialAdapter) KSATInterstitialAdapter.this).mImpressListener.onInterstitialAdVideoEnd();
                }
            }

            @Override // com.kwad.sdk.api.KsInterstitialAd.AdInteractionListener
            public final void onVideoPlayError(int i2, int i3) {
                if (((CustomInterstitialAdapter) KSATInterstitialAdapter.this).mImpressListener != null) {
                    ((CustomInterstitialAdapter) KSATInterstitialAdapter.this).mImpressListener.onInterstitialAdVideoError(String.valueOf(i2), String.valueOf(i3));
                }
            }

            @Override // com.kwad.sdk.api.KsInterstitialAd.AdInteractionListener
            public final void onVideoPlayStart() {
                if (((CustomInterstitialAdapter) KSATInterstitialAdapter.this).mImpressListener != null) {
                    ((CustomInterstitialAdapter) KSATInterstitialAdapter.this).mImpressListener.onInterstitialAdVideoStart();
                }
            }
        });
        this.f12505g.showInterstitialAd(activity, ksVideoPlayConfigBuild);
    }

    @Override // com.anythink.core.api.ATBaseAdAdapter
    public boolean startBiddingRequest(Context context, Map<String, Object> map, Map<String, Object> map2, ATBiddingListener aTBiddingListener) {
        this.f12506h = true;
        loadCustomNetworkAd(context, map, map2);
        return true;
    }

    private boolean a(Map<String, Object> map) {
        String stringFromMap = ATInitMediation.getStringFromMap(map, "app_id");
        String stringFromMap2 = ATInitMediation.getStringFromMap(map, "position_id");
        if (TextUtils.isEmpty(stringFromMap) || TextUtils.isEmpty(stringFromMap2)) {
            return false;
        }
        try {
            this.a = Long.parseLong(stringFromMap2);
        } catch (NumberFormatException unused) {
        }
        this.f12501c = true;
        if (map.containsKey("video_muted")) {
            this.f12501c = TextUtils.equals("0", ATInitMediation.getStringFromMap(map, "video_muted"));
        }
        if (map.containsKey("orientation")) {
            this.b = ATInitMediation.getIntFromMap(map, "orientation");
        }
        if (map.containsKey("is_video")) {
            this.f12502d = ATInitMediation.getIntFromMap(map, "is_video", 1);
        }
        if (map.containsKey(g.k.f6905o)) {
            this.f12507i = ATInitMediation.getDoubleFromMap(map, g.k.f6905o);
        }
        if (map.containsKey("payload")) {
            this.f12503e = KSATInitManager.getInstance().getPayloadInfo(ATInitMediation.getStringFromMap(map, "payload"), this.f12507i);
        }
        return true;
    }

    static /* synthetic */ void a(KSATInterstitialAdapter kSATInterstitialAdapter) {
        KsScene.Builder builderScreenOrientation = new KsScene.Builder(kSATInterstitialAdapter.a).adNum(1).screenOrientation(kSATInterstitialAdapter.b == 2 ? 2 : 1);
        if (!TextUtils.isEmpty(kSATInterstitialAdapter.f12503e)) {
            builderScreenOrientation.setBidResponseV2(kSATInterstitialAdapter.f12503e);
        }
        KsScene ksSceneBuild = builderScreenOrientation.build();
        if (kSATInterstitialAdapter.f12502d == 0) {
            KsAdSDK.getLoadManager().loadInterstitialAd(ksSceneBuild, kSATInterstitialAdapter.new AnonymousClass2());
        } else {
            KsAdSDK.getLoadManager().loadFullScreenVideoAd(ksSceneBuild, kSATInterstitialAdapter.new AnonymousClass3());
        }
    }
}
