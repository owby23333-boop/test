package com.anythink.network.toutiao;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import com.anythink.china.api.CustomAdapterDownloadListener;
import com.anythink.core.api.ATAdConst;
import com.anythink.core.api.ATBaseAdAdapter;
import com.anythink.core.api.ATBiddingListener;
import com.anythink.core.api.ATInitMediation;
import com.anythink.core.api.BaseAd;
import com.anythink.core.api.MediationInitCallback;
import com.anythink.interstitial.unitgroup.api.CustomInterstitialAdapter;
import com.bytedance.sdk.openadsdk.TTAdNative;
import com.bytedance.sdk.openadsdk.TTAdSdk;
import com.bytedance.sdk.openadsdk.TTAppDownloadListener;
import com.bytedance.sdk.openadsdk.TTFullScreenVideoAd;
import com.bytedance.sdk.openadsdk.TTInteractionAd;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public class TTATInterstitialAdapter extends CustomInterstitialAdapter {

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private TTInteractionAd f12666k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private TTFullScreenVideoAd f12667l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private Map<String, Object> f12668m;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final String f12665j = TTATInterstitialAdapter.class.getSimpleName();
    String a = "";
    int b = 1;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    String f12658c = "";

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    boolean f12659d = false;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    TTAdNative.InteractionAdListener f12660e = new TTAdNative.InteractionAdListener() { // from class: com.anythink.network.toutiao.TTATInterstitialAdapter.1
        @Override // com.bytedance.sdk.openadsdk.TTAdNative.InteractionAdListener, com.bytedance.sdk.openadsdk.common.CommonListener
        public final void onError(int i2, String str) {
            TTATInterstitialAdapter.this.notifyATLoadFail(String.valueOf(i2), str);
        }

        @Override // com.bytedance.sdk.openadsdk.TTAdNative.InteractionAdListener
        public final void onInteractionAdLoad(TTInteractionAd tTInteractionAd) {
            TTATInterstitialAdapter.this.f12666k = tTInteractionAd;
            try {
                Map<String, Object> mediaExtraInfo = TTATInterstitialAdapter.this.f12666k.getMediaExtraInfo();
                if (mediaExtraInfo != null) {
                    if (TTATInterstitialAdapter.this.f12668m == null) {
                        TTATInterstitialAdapter.this.f12668m = new HashMap(3);
                    }
                    TTATInterstitialAdapter.this.f12668m.putAll(mediaExtraInfo);
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
            TTATInterstitialAdapter tTATInterstitialAdapter = TTATInterstitialAdapter.this;
            if (tTATInterstitialAdapter.f12659d) {
                try {
                    TTATInitManager.getInstance().a(TTATInterstitialAdapter.this.f12668m, TTATInterstitialAdapter.this.f12666k, TTATInterstitialAdapter.this.mBiddingListener);
                    return;
                } catch (Throwable unused) {
                    return;
                }
            }
            try {
                if (((ATBaseAdAdapter) tTATInterstitialAdapter).mLoadListener != null) {
                    ((ATBaseAdAdapter) TTATInterstitialAdapter.this).mLoadListener.onAdCacheLoaded(new BaseAd[0]);
                }
            } catch (Throwable th2) {
                th2.printStackTrace();
            }
        }
    };

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    TTInteractionAd.AdInteractionListener f12661f = new TTInteractionAd.AdInteractionListener() { // from class: com.anythink.network.toutiao.TTATInterstitialAdapter.2
        @Override // com.bytedance.sdk.openadsdk.TTInteractionAd.AdInteractionListener
        public final void onAdClicked() {
            if (((CustomInterstitialAdapter) TTATInterstitialAdapter.this).mImpressListener != null) {
                ((CustomInterstitialAdapter) TTATInterstitialAdapter.this).mImpressListener.onInterstitialAdClicked();
            }
        }

        @Override // com.bytedance.sdk.openadsdk.TTInteractionAd.AdInteractionListener
        public final void onAdDismiss() {
            if (((CustomInterstitialAdapter) TTATInterstitialAdapter.this).mImpressListener != null) {
                ((CustomInterstitialAdapter) TTATInterstitialAdapter.this).mImpressListener.onInterstitialAdClose();
            }
        }

        @Override // com.bytedance.sdk.openadsdk.TTInteractionAd.AdInteractionListener
        public final void onAdShow() {
            try {
                TTATInitManager.getInstance().a(TTATInterstitialAdapter.this.getTrackingInfo().l(), new WeakReference(TTATInterstitialAdapter.this.f12666k));
            } catch (Throwable unused) {
            }
            if (((CustomInterstitialAdapter) TTATInterstitialAdapter.this).mImpressListener != null) {
                ((CustomInterstitialAdapter) TTATInterstitialAdapter.this).mImpressListener.onInterstitialAdShow();
            }
        }
    };

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    TTAdNative.FullScreenVideoAdListener f12662g = new TTAdNative.FullScreenVideoAdListener() { // from class: com.anythink.network.toutiao.TTATInterstitialAdapter.3
        @Override // com.bytedance.sdk.openadsdk.TTAdNative.FullScreenVideoAdListener, com.bytedance.sdk.openadsdk.common.CommonListener
        public final void onError(int i2, String str) {
            TTATInterstitialAdapter.this.notifyATLoadFail(String.valueOf(i2), str);
        }

        @Override // com.bytedance.sdk.openadsdk.TTAdNative.FullScreenVideoAdListener
        public final void onFullScreenVideoAdLoad(TTFullScreenVideoAd tTFullScreenVideoAd) {
            try {
                if (((ATBaseAdAdapter) TTATInterstitialAdapter.this).mLoadListener != null) {
                    ((ATBaseAdAdapter) TTATInterstitialAdapter.this).mLoadListener.onAdDataLoaded();
                }
            } catch (Throwable unused) {
            }
        }

        @Override // com.bytedance.sdk.openadsdk.TTAdNative.FullScreenVideoAdListener
        public final void onFullScreenVideoCached() {
        }

        @Override // com.bytedance.sdk.openadsdk.TTAdNative.FullScreenVideoAdListener
        public final void onFullScreenVideoCached(TTFullScreenVideoAd tTFullScreenVideoAd) {
            TTATInterstitialAdapter.this.f12667l = tTFullScreenVideoAd;
            try {
                Map<String, Object> mediaExtraInfo = TTATInterstitialAdapter.this.f12667l.getMediaExtraInfo();
                if (mediaExtraInfo != null) {
                    if (TTATInterstitialAdapter.this.f12668m == null) {
                        TTATInterstitialAdapter.this.f12668m = new HashMap(3);
                    }
                    TTATInterstitialAdapter.this.f12668m.putAll(mediaExtraInfo);
                }
            } catch (Throwable unused) {
            }
            TTATInterstitialAdapter tTATInterstitialAdapter = TTATInterstitialAdapter.this;
            if (tTATInterstitialAdapter.f12659d) {
                try {
                    TTATInitManager.getInstance().a(TTATInterstitialAdapter.this.f12668m, TTATInterstitialAdapter.this.f12667l, TTATInterstitialAdapter.this.mBiddingListener);
                } catch (Throwable unused2) {
                }
            } else {
                try {
                    if (((ATBaseAdAdapter) tTATInterstitialAdapter).mLoadListener != null) {
                        ((ATBaseAdAdapter) TTATInterstitialAdapter.this).mLoadListener.onAdCacheLoaded(new BaseAd[0]);
                    }
                } catch (Throwable unused3) {
                }
            }
        }
    };

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    TTFullScreenVideoAd.FullScreenVideoAdInteractionListener f12663h = new TTFullScreenVideoAd.FullScreenVideoAdInteractionListener() { // from class: com.anythink.network.toutiao.TTATInterstitialAdapter.4
        @Override // com.bytedance.sdk.openadsdk.TTFullScreenVideoAd.FullScreenVideoAdInteractionListener
        public final void onAdClose() {
            if (((CustomInterstitialAdapter) TTATInterstitialAdapter.this).mImpressListener != null) {
                ((CustomInterstitialAdapter) TTATInterstitialAdapter.this).mImpressListener.onInterstitialAdClose();
            }
        }

        @Override // com.bytedance.sdk.openadsdk.TTFullScreenVideoAd.FullScreenVideoAdInteractionListener
        public final void onAdShow() {
            try {
                TTATInitManager.getInstance().a(TTATInterstitialAdapter.this.getTrackingInfo().l(), new WeakReference(TTATInterstitialAdapter.this.f12667l));
            } catch (Exception unused) {
            }
            if (((CustomInterstitialAdapter) TTATInterstitialAdapter.this).mImpressListener != null) {
                ((CustomInterstitialAdapter) TTATInterstitialAdapter.this).mImpressListener.onInterstitialAdShow();
                ((CustomInterstitialAdapter) TTATInterstitialAdapter.this).mImpressListener.onInterstitialAdVideoStart();
            }
        }

        @Override // com.bytedance.sdk.openadsdk.TTFullScreenVideoAd.FullScreenVideoAdInteractionListener
        public final void onAdVideoBarClick() {
            if (((CustomInterstitialAdapter) TTATInterstitialAdapter.this).mImpressListener != null) {
                ((CustomInterstitialAdapter) TTATInterstitialAdapter.this).mImpressListener.onInterstitialAdClicked();
            }
        }

        @Override // com.bytedance.sdk.openadsdk.TTFullScreenVideoAd.FullScreenVideoAdInteractionListener
        public final void onSkippedVideo() {
            TTATInterstitialAdapter.y(TTATInterstitialAdapter.this);
        }

        @Override // com.bytedance.sdk.openadsdk.TTFullScreenVideoAd.FullScreenVideoAdInteractionListener
        public final void onVideoComplete() {
            if (((CustomInterstitialAdapter) TTATInterstitialAdapter.this).mImpressListener != null) {
                ((CustomInterstitialAdapter) TTATInterstitialAdapter.this).mImpressListener.onInterstitialAdVideoEnd();
            }
        }
    };

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private boolean f12669n = false;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    TTAppDownloadListener f12664i = new TTAppDownloadListener() { // from class: com.anythink.network.toutiao.TTATInterstitialAdapter.7
        @Override // com.bytedance.sdk.openadsdk.TTAppDownloadListener
        public final void onDownloadActive(long j2, long j3, String str, String str2) {
            if (TTATInterstitialAdapter.this.f12669n) {
                if (((ATBaseAdAdapter) TTATInterstitialAdapter.this).mDownloadListener == null || !(((ATBaseAdAdapter) TTATInterstitialAdapter.this).mDownloadListener instanceof CustomAdapterDownloadListener)) {
                    return;
                }
                ((CustomAdapterDownloadListener) ((ATBaseAdAdapter) TTATInterstitialAdapter.this).mDownloadListener).onDownloadUpdate(j2, j3, str, str2);
                return;
            }
            TTATInterstitialAdapter.A(TTATInterstitialAdapter.this);
            if (((ATBaseAdAdapter) TTATInterstitialAdapter.this).mDownloadListener == null || !(((ATBaseAdAdapter) TTATInterstitialAdapter.this).mDownloadListener instanceof CustomAdapterDownloadListener)) {
                return;
            }
            ((CustomAdapterDownloadListener) ((ATBaseAdAdapter) TTATInterstitialAdapter.this).mDownloadListener).onDownloadStart(j2, j3, str, str2);
        }

        @Override // com.bytedance.sdk.openadsdk.TTAppDownloadListener
        public final void onDownloadFailed(long j2, long j3, String str, String str2) {
            if (((ATBaseAdAdapter) TTATInterstitialAdapter.this).mDownloadListener == null || !(((ATBaseAdAdapter) TTATInterstitialAdapter.this).mDownloadListener instanceof CustomAdapterDownloadListener)) {
                return;
            }
            ((CustomAdapterDownloadListener) ((ATBaseAdAdapter) TTATInterstitialAdapter.this).mDownloadListener).onDownloadFail(j2, j3, str, str2);
        }

        @Override // com.bytedance.sdk.openadsdk.TTAppDownloadListener
        public final void onDownloadFinished(long j2, String str, String str2) {
            if (((ATBaseAdAdapter) TTATInterstitialAdapter.this).mDownloadListener == null || !(((ATBaseAdAdapter) TTATInterstitialAdapter.this).mDownloadListener instanceof CustomAdapterDownloadListener)) {
                return;
            }
            ((CustomAdapterDownloadListener) ((ATBaseAdAdapter) TTATInterstitialAdapter.this).mDownloadListener).onDownloadFinish(j2, str, str2);
        }

        @Override // com.bytedance.sdk.openadsdk.TTAppDownloadListener
        public final void onDownloadPaused(long j2, long j3, String str, String str2) {
            if (((ATBaseAdAdapter) TTATInterstitialAdapter.this).mDownloadListener == null || !(((ATBaseAdAdapter) TTATInterstitialAdapter.this).mDownloadListener instanceof CustomAdapterDownloadListener)) {
                return;
            }
            ((CustomAdapterDownloadListener) ((ATBaseAdAdapter) TTATInterstitialAdapter.this).mDownloadListener).onDownloadPause(j2, j3, str, str2);
        }

        @Override // com.bytedance.sdk.openadsdk.TTAppDownloadListener
        public final void onIdle() {
        }

        @Override // com.bytedance.sdk.openadsdk.TTAppDownloadListener
        public final void onInstalled(String str, String str2) {
            if (((ATBaseAdAdapter) TTATInterstitialAdapter.this).mDownloadListener == null || !(((ATBaseAdAdapter) TTATInterstitialAdapter.this).mDownloadListener instanceof CustomAdapterDownloadListener)) {
                return;
            }
            ((CustomAdapterDownloadListener) ((ATBaseAdAdapter) TTATInterstitialAdapter.this).mDownloadListener).onInstalled(str, str2);
        }
    };

    /* JADX INFO: renamed from: com.anythink.network.toutiao.TTATInterstitialAdapter$5, reason: invalid class name */
    final class AnonymousClass5 implements Runnable {
        final /* synthetic */ Context a;
        final /* synthetic */ Map b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ Map f12670c;

        AnonymousClass5(Context context, Map map, Map map2) {
            this.a = context;
            this.b = map;
            this.f12670c = map2;
        }

        @Override // java.lang.Runnable
        public final void run() {
            TTAdNative tTAdNativeCreateAdNative = TTAdSdk.getAdManager().createAdNative(this.a);
            TTATCustomAdSlotBuilder tTATCustomAdSlotBuilder = new TTATCustomAdSlotBuilder(TTATInterstitialAdapter.this.a, this.b, this.f12670c);
            tTATCustomAdSlotBuilder.setAdCount(1);
            tTATCustomAdSlotBuilder.setOrientation(TTATInterstitialAdapter.this.b);
            tTAdNativeCreateAdNative.loadFullScreenVideoAd(tTATCustomAdSlotBuilder.build(), TTATInterstitialAdapter.this.f12662g);
        }
    }

    static /* synthetic */ boolean A(TTATInterstitialAdapter tTATInterstitialAdapter) {
        tTATInterstitialAdapter.f12669n = true;
        return true;
    }

    static /* synthetic */ int y(TTATInterstitialAdapter tTATInterstitialAdapter) {
        tTATInterstitialAdapter.mDismissType = 2;
        return 2;
    }

    @Override // com.anythink.core.api.ATBaseAdAdapter
    public void destory() {
        TTFullScreenVideoAd tTFullScreenVideoAd = this.f12667l;
        if (tTFullScreenVideoAd != null) {
            tTFullScreenVideoAd.setFullScreenVideoAdInteractionListener(null);
            this.f12667l = null;
        }
        TTInteractionAd tTInteractionAd = this.f12666k;
        if (tTInteractionAd != null) {
            tTInteractionAd.setAdInteractionListener(null);
            this.f12666k.setDownloadListener(null);
            this.f12666k = null;
        }
        this.f12661f = null;
        this.f12660e = null;
        this.f12663h = null;
        this.f12662g = null;
    }

    @Override // com.anythink.core.api.ATBaseAdAdapter
    public Map<String, Object> getNetworkInfoMap() {
        return this.f12668m;
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
        return (this.f12666k == null && this.f12667l == null) ? false : true;
    }

    @Override // com.anythink.core.api.ATBaseAdAdapter
    public void loadCustomNetworkAd(final Context context, final Map<String, Object> map, final Map<String, Object> map2) {
        if (a(map, map2)) {
            TTATInitManager.getInstance().initSDK(context, map, new MediationInitCallback() { // from class: com.anythink.network.toutiao.TTATInterstitialAdapter.6
                @Override // com.anythink.core.api.MediationInitCallback
                public final void onFail(String str) {
                    TTATInterstitialAdapter.this.notifyATLoadFail("", str);
                }

                @Override // com.anythink.core.api.MediationInitCallback
                public final void onSuccess() {
                    try {
                        TTATInterstitialAdapter.a(TTATInterstitialAdapter.this, context, map, map2);
                    } catch (Throwable th) {
                        TTATInterstitialAdapter.this.notifyATLoadFail("", th.getMessage());
                    }
                }
            });
        } else {
            notifyATLoadFail("", "app_id or slot_id is empty!");
        }
    }

    @Override // com.anythink.interstitial.unitgroup.api.CustomInterstitialAdapter
    public void show(Activity activity) {
        try {
            if (this.f12666k != null && activity != null) {
                this.f12666k.setAdInteractionListener(this.f12661f);
                this.f12666k.setDownloadListener(this.f12664i);
                this.f12666k.showInteractionAd(activity);
            }
            if (this.f12667l == null || activity == null) {
                return;
            }
            this.f12667l.setFullScreenVideoAdInteractionListener(this.f12663h);
            this.f12667l.setDownloadListener(this.f12664i);
            this.f12667l.showFullScreenVideoAd(activity);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    @Override // com.anythink.core.api.ATBaseAdAdapter
    public boolean startBiddingRequest(Context context, Map<String, Object> map, Map<String, Object> map2, ATBiddingListener aTBiddingListener) {
        this.f12659d = true;
        loadCustomNetworkAd(context, map, map2);
        return true;
    }

    private void a(Context context, Map<String, Object> map, Map<String, Object> map2) {
        runOnNetworkRequestThread(new AnonymousClass5(context.getApplicationContext(), map, map2));
    }

    private boolean a(Map<String, Object> map, Map<String, Object> map2) {
        String stringFromMap = ATInitMediation.getStringFromMap(map, "app_id");
        this.a = ATInitMediation.getStringFromMap(map, "slot_id");
        if (TextUtils.isEmpty(stringFromMap) || TextUtils.isEmpty(this.a)) {
            return false;
        }
        try {
            int intFromMap = ATInitMediation.getIntFromMap(map2, ATAdConst.KEY.AD_ORIENTATION, 1);
            if (intFromMap == 1) {
                this.b = 1;
            } else if (intFromMap == 2) {
                this.b = 2;
            }
        } catch (Exception unused) {
        }
        this.f12658c = ATInitMediation.getStringFromMap(map, "payload");
        return true;
    }

    static /* synthetic */ void a(TTATInterstitialAdapter tTATInterstitialAdapter, Context context, Map map, Map map2) {
        tTATInterstitialAdapter.runOnNetworkRequestThread(tTATInterstitialAdapter.new AnonymousClass5(context.getApplicationContext(), map, map2));
    }
}
