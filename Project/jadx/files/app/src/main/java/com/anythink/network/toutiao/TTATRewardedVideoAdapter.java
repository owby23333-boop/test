package com.anythink.network.toutiao;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import com.anythink.china.api.CustomAdapterDownloadListener;
import com.anythink.core.api.ATBaseAdAdapter;
import com.anythink.core.api.ATBiddingListener;
import com.anythink.core.api.ATInitMediation;
import com.anythink.core.api.BaseAd;
import com.anythink.core.api.MediationInitCallback;
import com.anythink.rewardvideo.unitgroup.api.CustomRewardVideoAdapter;
import com.bytedance.sdk.openadsdk.TTAdNative;
import com.bytedance.sdk.openadsdk.TTAppDownloadListener;
import com.bytedance.sdk.openadsdk.TTRewardVideoAd;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public class TTATRewardedVideoAdapter extends CustomRewardVideoAdapter {
    boolean b;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private TTRewardVideoAd f12694i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private Map<String, Object> f12695j;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final String f12693h = TTATRewardedVideoAdapter.class.getSimpleName();
    String a = "";

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    String f12688c = "";

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    boolean f12689d = false;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    TTAdNative.RewardVideoAdListener f12690e = new TTAdNative.RewardVideoAdListener() { // from class: com.anythink.network.toutiao.TTATRewardedVideoAdapter.1
        @Override // com.bytedance.sdk.openadsdk.TTAdNative.RewardVideoAdListener, com.bytedance.sdk.openadsdk.common.CommonListener
        public final void onError(int i2, String str) {
            TTATRewardedVideoAdapter.this.notifyATLoadFail(String.valueOf(i2), str);
        }

        @Override // com.bytedance.sdk.openadsdk.TTAdNative.RewardVideoAdListener
        public final void onRewardVideoAdLoad(TTRewardVideoAd tTRewardVideoAd) {
            try {
                if (((ATBaseAdAdapter) TTATRewardedVideoAdapter.this).mLoadListener != null) {
                    ((ATBaseAdAdapter) TTATRewardedVideoAdapter.this).mLoadListener.onAdDataLoaded();
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }

        @Override // com.bytedance.sdk.openadsdk.TTAdNative.RewardVideoAdListener
        public final void onRewardVideoCached() {
        }

        @Override // com.bytedance.sdk.openadsdk.TTAdNative.RewardVideoAdListener
        public final void onRewardVideoCached(TTRewardVideoAd tTRewardVideoAd) {
            TTATRewardedVideoAdapter.this.f12694i = tTRewardVideoAd;
            try {
                Map<String, Object> mediaExtraInfo = TTATRewardedVideoAdapter.this.f12694i.getMediaExtraInfo();
                if (mediaExtraInfo != null) {
                    if (TTATRewardedVideoAdapter.this.f12695j == null) {
                        TTATRewardedVideoAdapter.this.f12695j = new HashMap(3);
                    }
                    TTATRewardedVideoAdapter.this.f12695j.putAll(mediaExtraInfo);
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
            TTATRewardedVideoAdapter tTATRewardedVideoAdapter = TTATRewardedVideoAdapter.this;
            if (tTATRewardedVideoAdapter.f12689d) {
                try {
                    TTATInitManager.getInstance().a(TTATRewardedVideoAdapter.this.f12695j, TTATRewardedVideoAdapter.this.f12694i, TTATRewardedVideoAdapter.this.mBiddingListener);
                    return;
                } catch (Throwable unused) {
                    return;
                }
            }
            try {
                if (((ATBaseAdAdapter) tTATRewardedVideoAdapter).mLoadListener != null) {
                    ((ATBaseAdAdapter) TTATRewardedVideoAdapter.this).mLoadListener.onAdCacheLoaded(new BaseAd[0]);
                }
            } catch (Throwable th2) {
                th2.printStackTrace();
            }
        }
    };

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    TTRewardVideoAd.RewardAdInteractionListener f12691f = new TTRewardVideoAd.RewardAdInteractionListener() { // from class: com.anythink.network.toutiao.TTATRewardedVideoAdapter.2
        @Override // com.bytedance.sdk.openadsdk.TTRewardVideoAd.RewardAdInteractionListener
        public final void onAdClose() {
            if (((CustomRewardVideoAdapter) TTATRewardedVideoAdapter.this).mImpressionListener != null) {
                ((CustomRewardVideoAdapter) TTATRewardedVideoAdapter.this).mImpressionListener.onRewardedVideoAdClosed();
            }
        }

        @Override // com.bytedance.sdk.openadsdk.TTRewardVideoAd.RewardAdInteractionListener
        public final void onAdShow() {
            try {
                TTATInitManager.getInstance().a(TTATRewardedVideoAdapter.this.getTrackingInfo().l(), new WeakReference(TTATRewardedVideoAdapter.this.f12694i));
            } catch (Exception unused) {
            }
            if (((CustomRewardVideoAdapter) TTATRewardedVideoAdapter.this).mImpressionListener != null) {
                ((CustomRewardVideoAdapter) TTATRewardedVideoAdapter.this).mImpressionListener.onRewardedVideoAdPlayStart();
            }
        }

        @Override // com.bytedance.sdk.openadsdk.TTRewardVideoAd.RewardAdInteractionListener
        public final void onAdVideoBarClick() {
            if (((CustomRewardVideoAdapter) TTATRewardedVideoAdapter.this).mImpressionListener != null) {
                ((CustomRewardVideoAdapter) TTATRewardedVideoAdapter.this).mImpressionListener.onRewardedVideoAdPlayClicked();
            }
        }

        @Override // com.bytedance.sdk.openadsdk.TTRewardVideoAd.RewardAdInteractionListener
        public final void onRewardArrived(boolean z2, int i2, Bundle bundle) {
            String unused = TTATRewardedVideoAdapter.this.f12693h;
            "onRewardArrived(), rewardVerify: ".concat(String.valueOf(z2));
            if (z2) {
                TTATRewardedVideoAdapter tTATRewardedVideoAdapter = TTATRewardedVideoAdapter.this;
                if (tTATRewardedVideoAdapter.b || ((CustomRewardVideoAdapter) tTATRewardedVideoAdapter).mImpressionListener == null) {
                    return;
                }
                TTATRewardedVideoAdapter tTATRewardedVideoAdapter2 = TTATRewardedVideoAdapter.this;
                tTATRewardedVideoAdapter2.b = true;
                ((CustomRewardVideoAdapter) tTATRewardedVideoAdapter2).mImpressionListener.onReward();
            }
        }

        @Override // com.bytedance.sdk.openadsdk.TTRewardVideoAd.RewardAdInteractionListener
        public final void onRewardVerify(boolean z2, int i2, String str, int i3, String str2) {
        }

        @Override // com.bytedance.sdk.openadsdk.TTRewardVideoAd.RewardAdInteractionListener
        public final void onSkippedVideo() {
            TTATRewardedVideoAdapter.o(TTATRewardedVideoAdapter.this);
        }

        @Override // com.bytedance.sdk.openadsdk.TTRewardVideoAd.RewardAdInteractionListener
        public final void onVideoComplete() {
            if (((CustomRewardVideoAdapter) TTATRewardedVideoAdapter.this).mImpressionListener != null) {
                ((CustomRewardVideoAdapter) TTATRewardedVideoAdapter.this).mImpressionListener.onRewardedVideoAdPlayEnd();
            }
        }

        @Override // com.bytedance.sdk.openadsdk.TTRewardVideoAd.RewardAdInteractionListener
        public final void onVideoError() {
            if (((CustomRewardVideoAdapter) TTATRewardedVideoAdapter.this).mImpressionListener != null) {
                ((CustomRewardVideoAdapter) TTATRewardedVideoAdapter.this).mImpressionListener.onRewardedVideoAdPlayFailed("", "Callback VideoError");
            }
        }
    };

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private boolean f12696k = false;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    TTAppDownloadListener f12692g = new TTAppDownloadListener() { // from class: com.anythink.network.toutiao.TTATRewardedVideoAdapter.6
        @Override // com.bytedance.sdk.openadsdk.TTAppDownloadListener
        public final void onDownloadActive(long j2, long j3, String str, String str2) {
            if (TTATRewardedVideoAdapter.this.f12696k) {
                if (((ATBaseAdAdapter) TTATRewardedVideoAdapter.this).mDownloadListener == null || !(((ATBaseAdAdapter) TTATRewardedVideoAdapter.this).mDownloadListener instanceof CustomAdapterDownloadListener)) {
                    return;
                }
                ((CustomAdapterDownloadListener) ((ATBaseAdAdapter) TTATRewardedVideoAdapter.this).mDownloadListener).onDownloadUpdate(j2, j3, str, str2);
                return;
            }
            TTATRewardedVideoAdapter.M(TTATRewardedVideoAdapter.this);
            if (((ATBaseAdAdapter) TTATRewardedVideoAdapter.this).mDownloadListener == null || !(((ATBaseAdAdapter) TTATRewardedVideoAdapter.this).mDownloadListener instanceof CustomAdapterDownloadListener)) {
                return;
            }
            ((CustomAdapterDownloadListener) ((ATBaseAdAdapter) TTATRewardedVideoAdapter.this).mDownloadListener).onDownloadStart(j2, j3, str, str2);
        }

        @Override // com.bytedance.sdk.openadsdk.TTAppDownloadListener
        public final void onDownloadFailed(long j2, long j3, String str, String str2) {
            if (((ATBaseAdAdapter) TTATRewardedVideoAdapter.this).mDownloadListener == null || !(((ATBaseAdAdapter) TTATRewardedVideoAdapter.this).mDownloadListener instanceof CustomAdapterDownloadListener)) {
                return;
            }
            ((CustomAdapterDownloadListener) ((ATBaseAdAdapter) TTATRewardedVideoAdapter.this).mDownloadListener).onDownloadFail(j2, j3, str, str2);
        }

        @Override // com.bytedance.sdk.openadsdk.TTAppDownloadListener
        public final void onDownloadFinished(long j2, String str, String str2) {
            if (((ATBaseAdAdapter) TTATRewardedVideoAdapter.this).mDownloadListener == null || !(((ATBaseAdAdapter) TTATRewardedVideoAdapter.this).mDownloadListener instanceof CustomAdapterDownloadListener)) {
                return;
            }
            ((CustomAdapterDownloadListener) ((ATBaseAdAdapter) TTATRewardedVideoAdapter.this).mDownloadListener).onDownloadFinish(j2, str, str2);
        }

        @Override // com.bytedance.sdk.openadsdk.TTAppDownloadListener
        public final void onDownloadPaused(long j2, long j3, String str, String str2) {
            if (((ATBaseAdAdapter) TTATRewardedVideoAdapter.this).mDownloadListener == null || !(((ATBaseAdAdapter) TTATRewardedVideoAdapter.this).mDownloadListener instanceof CustomAdapterDownloadListener)) {
                return;
            }
            ((CustomAdapterDownloadListener) ((ATBaseAdAdapter) TTATRewardedVideoAdapter.this).mDownloadListener).onDownloadPause(j2, j3, str, str2);
        }

        @Override // com.bytedance.sdk.openadsdk.TTAppDownloadListener
        public final void onIdle() {
        }

        @Override // com.bytedance.sdk.openadsdk.TTAppDownloadListener
        public final void onInstalled(String str, String str2) {
            if (((ATBaseAdAdapter) TTATRewardedVideoAdapter.this).mDownloadListener == null || !(((ATBaseAdAdapter) TTATRewardedVideoAdapter.this).mDownloadListener instanceof CustomAdapterDownloadListener)) {
                return;
            }
            ((CustomAdapterDownloadListener) ((ATBaseAdAdapter) TTATRewardedVideoAdapter.this).mDownloadListener).onInstalled(str, str2);
        }
    };

    /* JADX INFO: renamed from: com.anythink.network.toutiao.TTATRewardedVideoAdapter$3, reason: invalid class name */
    final class AnonymousClass3 implements Runnable {
        final /* synthetic */ Context a;
        final /* synthetic */ Map b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ Map f12697c;

        AnonymousClass3(Context context, Map map, Map map2) {
            this.a = context;
            this.b = map;
            this.f12697c = map2;
        }

        /* JADX WARN: Removed duplicated region for block: B:25:0x00a0  */
        /* JADX WARN: Removed duplicated region for block: B:28:0x00b5  */
        /*  JADX ERROR: JadxRuntimeException in pass: RegionMakerVisitor
            jadx.core.utils.exceptions.JadxRuntimeException: Can't find top splitter block for handler:B:22:0x0093
            	at jadx.core.utils.BlockUtils.getTopSplitterForHandler(BlockUtils.java:1182)
            	at jadx.core.dex.visitors.regions.maker.ExcHandlersRegionMaker.collectHandlerRegions(ExcHandlersRegionMaker.java:53)
            	at jadx.core.dex.visitors.regions.maker.ExcHandlersRegionMaker.process(ExcHandlersRegionMaker.java:38)
            	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:27)
            */
        @Override // java.lang.Runnable
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final void run() {
            /*
                Method dump skipped, instruction units count: 236
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: com.anythink.network.toutiao.TTATRewardedVideoAdapter.AnonymousClass3.run():void");
        }
    }

    static /* synthetic */ int K(TTATRewardedVideoAdapter tTATRewardedVideoAdapter) {
        tTATRewardedVideoAdapter.mDismissType = 2;
        return 2;
    }

    static /* synthetic */ boolean M(TTATRewardedVideoAdapter tTATRewardedVideoAdapter) {
        tTATRewardedVideoAdapter.f12696k = true;
        return true;
    }

    static /* synthetic */ int o(TTATRewardedVideoAdapter tTATRewardedVideoAdapter) {
        tTATRewardedVideoAdapter.mDismissType = 2;
        return 2;
    }

    @Override // com.anythink.core.api.ATBaseAdAdapter
    public void destory() {
        TTRewardVideoAd tTRewardVideoAd = this.f12694i;
        if (tTRewardVideoAd != null) {
            tTRewardVideoAd.setRewardAdInteractionListener(null);
            this.f12694i.setRewardPlayAgainInteractionListener(null);
            this.f12694i = null;
        }
        this.f12690e = null;
        this.f12691f = null;
    }

    @Override // com.anythink.core.api.ATBaseAdAdapter
    public Map<String, Object> getNetworkInfoMap() {
        return this.f12695j;
    }

    @Override // com.anythink.core.api.ATBaseAdAdapter
    public String getNetworkName() {
        return TTATInitManager.getInstance().getNetworkName();
    }

    @Override // com.anythink.core.api.ATBaseAdAdapter
    public String getNetworkPlacementId() {
        return this.a;
    }

    @Override // com.anythink.core.api.ATBaseAdAdapter
    public String getNetworkSDKVersion() {
        return TTATInitManager.getInstance().getNetworkVersion();
    }

    @Override // com.anythink.core.api.ATBaseAdAdapter
    public boolean isAdReady() {
        return this.f12694i != null;
    }

    @Override // com.anythink.core.api.ATBaseAdAdapter
    public void loadCustomNetworkAd(final Context context, final Map<String, Object> map, final Map<String, Object> map2) {
        boolean z2;
        String stringFromMap = ATInitMediation.getStringFromMap(map, "app_id");
        this.a = ATInitMediation.getStringFromMap(map, "slot_id");
        if (TextUtils.isEmpty(stringFromMap) || TextUtils.isEmpty(this.a)) {
            z2 = false;
        } else {
            this.f12688c = ATInitMediation.getStringFromMap(map, "payload");
            z2 = true;
        }
        if (z2) {
            TTATInitManager.getInstance().initSDK(context, map, new MediationInitCallback() { // from class: com.anythink.network.toutiao.TTATRewardedVideoAdapter.5
                @Override // com.anythink.core.api.MediationInitCallback
                public final void onFail(String str) {
                    TTATRewardedVideoAdapter.this.notifyATLoadFail("", str);
                }

                @Override // com.anythink.core.api.MediationInitCallback
                public final void onSuccess() {
                    try {
                        TTATRewardedVideoAdapter.a(TTATRewardedVideoAdapter.this, context, map, map2);
                    } catch (Throwable th) {
                        TTATRewardedVideoAdapter.this.notifyATLoadFail("", th.getMessage());
                    }
                }
            });
        } else {
            notifyATLoadFail("", "app_id or slot_id is empty!");
        }
    }

    @Override // com.anythink.rewardvideo.unitgroup.api.CustomRewardVideoAdapter
    public void show(Activity activity) {
        TTRewardVideoAd tTRewardVideoAd;
        if (activity == null || (tTRewardVideoAd = this.f12694i) == null) {
            return;
        }
        tTRewardVideoAd.setRewardAdInteractionListener(this.f12691f);
        this.f12694i.setDownloadListener(this.f12692g);
        this.f12694i.setRewardPlayAgainInteractionListener(new TTRewardVideoAd.RewardAdInteractionListener() { // from class: com.anythink.network.toutiao.TTATRewardedVideoAdapter.4
            @Override // com.bytedance.sdk.openadsdk.TTRewardVideoAd.RewardAdInteractionListener
            public final void onAdClose() {
            }

            @Override // com.bytedance.sdk.openadsdk.TTRewardVideoAd.RewardAdInteractionListener
            public final void onAdShow() {
                TTATRewardedVideoAdapter tTATRewardedVideoAdapter = TTATRewardedVideoAdapter.this;
                tTATRewardedVideoAdapter.b = false;
                try {
                    Map<String, Object> mediaExtraInfo = tTATRewardedVideoAdapter.f12694i.getMediaExtraInfo();
                    if (mediaExtraInfo != null) {
                        if (TTATRewardedVideoAdapter.this.f12695j == null) {
                            TTATRewardedVideoAdapter.this.f12695j = new HashMap(3);
                        }
                        TTATRewardedVideoAdapter.this.f12695j.clear();
                        TTATRewardedVideoAdapter.this.f12695j.putAll(mediaExtraInfo);
                    }
                } catch (Throwable th) {
                    th.printStackTrace();
                }
                if (((CustomRewardVideoAdapter) TTATRewardedVideoAdapter.this).mImpressionListener != null) {
                    ((CustomRewardVideoAdapter) TTATRewardedVideoAdapter.this).mImpressionListener.onRewardedVideoAdAgainPlayStart();
                }
            }

            @Override // com.bytedance.sdk.openadsdk.TTRewardVideoAd.RewardAdInteractionListener
            public final void onAdVideoBarClick() {
                if (((CustomRewardVideoAdapter) TTATRewardedVideoAdapter.this).mImpressionListener != null) {
                    ((CustomRewardVideoAdapter) TTATRewardedVideoAdapter.this).mImpressionListener.onRewardedVideoAdAgainPlayClicked();
                }
            }

            @Override // com.bytedance.sdk.openadsdk.TTRewardVideoAd.RewardAdInteractionListener
            public final void onRewardArrived(boolean z2, int i2, Bundle bundle) {
                String unused = TTATRewardedVideoAdapter.this.f12693h;
                "Again AD, onRewardArrived(), rewardVerify: ".concat(String.valueOf(z2));
                if (z2) {
                    TTATRewardedVideoAdapter tTATRewardedVideoAdapter = TTATRewardedVideoAdapter.this;
                    if (tTATRewardedVideoAdapter.b || ((CustomRewardVideoAdapter) tTATRewardedVideoAdapter).mImpressionListener == null) {
                        return;
                    }
                    TTATRewardedVideoAdapter tTATRewardedVideoAdapter2 = TTATRewardedVideoAdapter.this;
                    tTATRewardedVideoAdapter2.b = true;
                    ((CustomRewardVideoAdapter) tTATRewardedVideoAdapter2).mImpressionListener.onAgainReward();
                }
            }

            @Override // com.bytedance.sdk.openadsdk.TTRewardVideoAd.RewardAdInteractionListener
            public final void onRewardVerify(boolean z2, int i2, String str, int i3, String str2) {
            }

            @Override // com.bytedance.sdk.openadsdk.TTRewardVideoAd.RewardAdInteractionListener
            public final void onSkippedVideo() {
                TTATRewardedVideoAdapter.K(TTATRewardedVideoAdapter.this);
            }

            @Override // com.bytedance.sdk.openadsdk.TTRewardVideoAd.RewardAdInteractionListener
            public final void onVideoComplete() {
                if (((CustomRewardVideoAdapter) TTATRewardedVideoAdapter.this).mImpressionListener != null) {
                    ((CustomRewardVideoAdapter) TTATRewardedVideoAdapter.this).mImpressionListener.onRewardedVideoAdAgainPlayEnd();
                }
            }

            @Override // com.bytedance.sdk.openadsdk.TTRewardVideoAd.RewardAdInteractionListener
            public final void onVideoError() {
                if (((CustomRewardVideoAdapter) TTATRewardedVideoAdapter.this).mImpressionListener != null) {
                    ((CustomRewardVideoAdapter) TTATRewardedVideoAdapter.this).mImpressionListener.onRewardedVideoAdAgainPlayFailed("", "Again AD, Callback VideoError");
                }
            }
        });
        this.f12694i.showRewardVideoAd(activity);
    }

    @Override // com.anythink.core.api.ATBaseAdAdapter
    public boolean startBiddingRequest(Context context, Map<String, Object> map, Map<String, Object> map2, ATBiddingListener aTBiddingListener) {
        this.f12689d = true;
        loadCustomNetworkAd(context, map, map2);
        return true;
    }

    private static int b(Context context, float f2) {
        float f3 = context.getResources().getDisplayMetrics().density;
        if (f3 <= 0.0f) {
            f3 = 1.0f;
        }
        return (int) ((f2 / f3) + 0.5f);
    }

    private void a(Context context, Map<String, Object> map, Map<String, Object> map2) {
        runOnNetworkRequestThread(new AnonymousClass3(context.getApplicationContext(), map, map2));
    }

    private boolean a(Map<String, Object> map) {
        String stringFromMap = ATInitMediation.getStringFromMap(map, "app_id");
        this.a = ATInitMediation.getStringFromMap(map, "slot_id");
        if (TextUtils.isEmpty(stringFromMap) || TextUtils.isEmpty(this.a)) {
            return false;
        }
        this.f12688c = ATInitMediation.getStringFromMap(map, "payload");
        return true;
    }

    static /* synthetic */ int a(Context context, float f2) {
        float f3 = context.getResources().getDisplayMetrics().density;
        if (f3 <= 0.0f) {
            f3 = 1.0f;
        }
        return (int) ((f2 / f3) + 0.5f);
    }

    static /* synthetic */ void a(TTATRewardedVideoAdapter tTATRewardedVideoAdapter, Context context, Map map, Map map2) {
        tTATRewardedVideoAdapter.runOnNetworkRequestThread(tTATRewardedVideoAdapter.new AnonymousClass3(context.getApplicationContext(), map, map2));
    }
}
