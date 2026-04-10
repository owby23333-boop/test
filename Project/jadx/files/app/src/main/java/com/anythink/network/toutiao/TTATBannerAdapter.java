package com.anythink.network.toutiao;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import com.anythink.banner.unitgroup.api.CustomBannerAdapter;
import com.anythink.china.api.CustomAdapterDownloadListener;
import com.anythink.core.api.ATBaseAdAdapter;
import com.anythink.core.api.ATBiddingListener;
import com.anythink.core.api.ATInitMediation;
import com.anythink.core.api.BaseAd;
import com.anythink.core.api.MediationInitCallback;
import com.bytedance.sdk.openadsdk.TTAdDislike;
import com.bytedance.sdk.openadsdk.TTAdNative;
import com.bytedance.sdk.openadsdk.TTAppDownloadListener;
import com.bytedance.sdk.openadsdk.TTNativeExpressAd;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public class TTATBannerAdapter extends CustomBannerAdapter {
    Context b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    View f12626c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    int f12627d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    int f12628e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    int f12629f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    String f12630g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    boolean f12631h;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private TTNativeExpressAd f12637n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private Map<String, Object> f12638o;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private final String f12636m = TTATBannerAdapter.class.getSimpleName();
    String a = "";

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    boolean f12632i = false;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    TTAdNative.NativeExpressAdListener f12633j = new TTAdNative.NativeExpressAdListener() { // from class: com.anythink.network.toutiao.TTATBannerAdapter.1
        @Override // com.bytedance.sdk.openadsdk.TTAdNative.NativeExpressAdListener, com.bytedance.sdk.openadsdk.common.CommonListener
        public final void onError(int i2, String str) {
            TTATBannerAdapter.this.notifyATLoadFail(String.valueOf(i2), str);
        }

        @Override // com.bytedance.sdk.openadsdk.TTAdNative.NativeExpressAdListener
        public final void onNativeExpressAdLoad(List<TTNativeExpressAd> list) {
            if (list == null || list.size() <= 0) {
                TTATBannerAdapter.this.notifyATLoadFail("", "Return Ad list is empty.");
                return;
            }
            TTATBannerAdapter.this.f12637n = list.get(0);
            TTATBannerAdapter tTATBannerAdapter = TTATBannerAdapter.this;
            if (tTATBannerAdapter.f12629f > 0) {
                tTATBannerAdapter.f12637n.setSlideIntervalTime(TTATBannerAdapter.this.f12629f);
            } else {
                tTATBannerAdapter.f12637n.setSlideIntervalTime(0);
            }
            TTATBannerAdapter.b(TTATBannerAdapter.this);
            TTATBannerAdapter.this.f12637n.render();
        }
    };

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    TTNativeExpressAd.ExpressAdInteractionListener f12634k = new TTNativeExpressAd.ExpressAdInteractionListener() { // from class: com.anythink.network.toutiao.TTATBannerAdapter.2
        @Override // com.bytedance.sdk.openadsdk.TTNativeExpressAd.ExpressAdInteractionListener
        public final void onAdClicked(View view, int i2) {
            if (((CustomBannerAdapter) TTATBannerAdapter.this).mImpressionEventListener != null) {
                ((CustomBannerAdapter) TTATBannerAdapter.this).mImpressionEventListener.onBannerAdClicked();
            }
        }

        @Override // com.bytedance.sdk.openadsdk.TTNativeExpressAd.ExpressAdInteractionListener
        public final void onAdShow(View view, int i2) {
            try {
                ViewParent parent = TTATBannerAdapter.this.f12626c.getParent();
                while (!(parent instanceof ViewGroup) && parent != null) {
                    parent = parent.getParent();
                }
                if (parent != null) {
                    Context context = ((ViewGroup) parent).getContext();
                    if (context instanceof Activity) {
                        TTATBannerAdapter.a(TTATBannerAdapter.this, (Activity) context, TTATBannerAdapter.this.f12637n);
                    } else {
                        String unused = TTATBannerAdapter.this.f12636m;
                    }
                } else if (TTATBannerAdapter.this.b instanceof Activity) {
                    TTATBannerAdapter.a(TTATBannerAdapter.this, (Activity) TTATBannerAdapter.this.b, TTATBannerAdapter.this.f12637n);
                } else {
                    String unused2 = TTATBannerAdapter.this.f12636m;
                }
            } catch (Throwable th) {
                String unused3 = TTATBannerAdapter.this.f12636m;
                String str = "bindDislike fail：" + th.getMessage();
            }
            try {
                TTATInitManager.getInstance().a(TTATBannerAdapter.this.getTrackingInfo().l(), new WeakReference(TTATBannerAdapter.this.f12637n));
            } catch (Throwable unused4) {
            }
            if (((CustomBannerAdapter) TTATBannerAdapter.this).mImpressionEventListener != null) {
                TTATBannerAdapter tTATBannerAdapter = TTATBannerAdapter.this;
                if (tTATBannerAdapter.f12631h) {
                    return;
                }
                ((CustomBannerAdapter) tTATBannerAdapter).mImpressionEventListener.onBannerAdShow();
                TTATBannerAdapter.this.f12631h = true;
            }
        }

        @Override // com.bytedance.sdk.openadsdk.TTNativeExpressAd.ExpressAdInteractionListener
        public final void onRenderFail(View view, String str, int i2) {
            TTATBannerAdapter.this.notifyATLoadFail(String.valueOf(i2), str);
        }

        @Override // com.bytedance.sdk.openadsdk.TTNativeExpressAd.ExpressAdInteractionListener
        public final void onRenderSuccess(View view, float f2, float f3) {
            TTATBannerAdapter tTATBannerAdapter = TTATBannerAdapter.this;
            tTATBannerAdapter.f12626c = view;
            try {
                Map<String, Object> mediaExtraInfo = tTATBannerAdapter.f12637n.getMediaExtraInfo();
                if (mediaExtraInfo != null) {
                    if (TTATBannerAdapter.this.f12638o == null) {
                        TTATBannerAdapter.this.f12638o = new HashMap(3);
                    }
                    TTATBannerAdapter.this.f12638o.putAll(mediaExtraInfo);
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
            TTATBannerAdapter tTATBannerAdapter2 = TTATBannerAdapter.this;
            tTATBannerAdapter2.f12631h = false;
            if (tTATBannerAdapter2.f12632i) {
                try {
                    TTATInitManager.getInstance().a(TTATBannerAdapter.this.f12638o, TTATBannerAdapter.this.f12637n, TTATBannerAdapter.this.mBiddingListener);
                } catch (Throwable unused) {
                }
            } else if (((ATBaseAdAdapter) tTATBannerAdapter2).mLoadListener != null) {
                ((ATBaseAdAdapter) TTATBannerAdapter.this).mLoadListener.onAdCacheLoaded(new BaseAd[0]);
            }
        }
    };

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private boolean f12639p = false;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    TTAppDownloadListener f12635l = new TTAppDownloadListener() { // from class: com.anythink.network.toutiao.TTATBannerAdapter.6
        @Override // com.bytedance.sdk.openadsdk.TTAppDownloadListener
        public final void onDownloadActive(long j2, long j3, String str, String str2) {
            if (TTATBannerAdapter.this.f12639p) {
                if (((ATBaseAdAdapter) TTATBannerAdapter.this).mDownloadListener == null || !(((ATBaseAdAdapter) TTATBannerAdapter.this).mDownloadListener instanceof CustomAdapterDownloadListener)) {
                    return;
                }
                ((CustomAdapterDownloadListener) ((ATBaseAdAdapter) TTATBannerAdapter.this).mDownloadListener).onDownloadUpdate(j2, j3, str, str2);
                return;
            }
            TTATBannerAdapter.p(TTATBannerAdapter.this);
            if (((ATBaseAdAdapter) TTATBannerAdapter.this).mDownloadListener == null || !(((ATBaseAdAdapter) TTATBannerAdapter.this).mDownloadListener instanceof CustomAdapterDownloadListener)) {
                return;
            }
            ((CustomAdapterDownloadListener) ((ATBaseAdAdapter) TTATBannerAdapter.this).mDownloadListener).onDownloadStart(j2, j3, str, str2);
        }

        @Override // com.bytedance.sdk.openadsdk.TTAppDownloadListener
        public final void onDownloadFailed(long j2, long j3, String str, String str2) {
            if (((ATBaseAdAdapter) TTATBannerAdapter.this).mDownloadListener == null || !(((ATBaseAdAdapter) TTATBannerAdapter.this).mDownloadListener instanceof CustomAdapterDownloadListener)) {
                return;
            }
            ((CustomAdapterDownloadListener) ((ATBaseAdAdapter) TTATBannerAdapter.this).mDownloadListener).onDownloadFail(j2, j3, str, str2);
        }

        @Override // com.bytedance.sdk.openadsdk.TTAppDownloadListener
        public final void onDownloadFinished(long j2, String str, String str2) {
            if (((ATBaseAdAdapter) TTATBannerAdapter.this).mDownloadListener == null || !(((ATBaseAdAdapter) TTATBannerAdapter.this).mDownloadListener instanceof CustomAdapterDownloadListener)) {
                return;
            }
            ((CustomAdapterDownloadListener) ((ATBaseAdAdapter) TTATBannerAdapter.this).mDownloadListener).onDownloadFinish(j2, str, str2);
        }

        @Override // com.bytedance.sdk.openadsdk.TTAppDownloadListener
        public final void onDownloadPaused(long j2, long j3, String str, String str2) {
            if (((ATBaseAdAdapter) TTATBannerAdapter.this).mDownloadListener == null || !(((ATBaseAdAdapter) TTATBannerAdapter.this).mDownloadListener instanceof CustomAdapterDownloadListener)) {
                return;
            }
            ((CustomAdapterDownloadListener) ((ATBaseAdAdapter) TTATBannerAdapter.this).mDownloadListener).onDownloadPause(j2, j3, str, str2);
        }

        @Override // com.bytedance.sdk.openadsdk.TTAppDownloadListener
        public final void onIdle() {
        }

        @Override // com.bytedance.sdk.openadsdk.TTAppDownloadListener
        public final void onInstalled(String str, String str2) {
            if (((ATBaseAdAdapter) TTATBannerAdapter.this).mDownloadListener == null || !(((ATBaseAdAdapter) TTATBannerAdapter.this).mDownloadListener instanceof CustomAdapterDownloadListener)) {
                return;
            }
            ((CustomAdapterDownloadListener) ((ATBaseAdAdapter) TTATBannerAdapter.this).mDownloadListener).onInstalled(str, str2);
        }
    };

    /* JADX INFO: renamed from: com.anythink.network.toutiao.TTATBannerAdapter$3, reason: invalid class name */
    final class AnonymousClass3 implements Runnable {
        final /* synthetic */ Map a;
        final /* synthetic */ Map b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ Context f12640c;

        AnonymousClass3(Map map, Map map2, Context context) {
            this.a = map;
            this.b = map2;
            this.f12640c = context;
        }

        /* JADX WARN: Removed duplicated region for block: B:40:0x00b2  */
        /* JADX WARN: Removed duplicated region for block: B:5:0x0027  */
        @Override // java.lang.Runnable
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final void run() {
            /*
                Method dump skipped, instruction units count: 290
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: com.anythink.network.toutiao.TTATBannerAdapter.AnonymousClass3.run():void");
        }
    }

    static /* synthetic */ void b(TTATBannerAdapter tTATBannerAdapter) {
        TTNativeExpressAd tTNativeExpressAd = tTATBannerAdapter.f12637n;
        if (tTNativeExpressAd != null) {
            tTNativeExpressAd.setExpressInteractionListener(tTATBannerAdapter.f12634k);
            tTATBannerAdapter.f12637n.setDownloadListener(tTATBannerAdapter.f12635l);
        }
    }

    static /* synthetic */ boolean p(TTATBannerAdapter tTATBannerAdapter) {
        tTATBannerAdapter.f12639p = true;
        return true;
    }

    @Override // com.anythink.core.api.ATBaseAdAdapter
    public void destory() {
        this.f12626c = null;
        TTNativeExpressAd tTNativeExpressAd = this.f12637n;
        if (tTNativeExpressAd != null) {
            tTNativeExpressAd.setExpressInteractionListener((TTNativeExpressAd.AdInteractionListener) null);
            this.f12637n.destroy();
            this.f12637n = null;
        }
        this.f12634k = null;
        this.f12633j = null;
        this.b = null;
    }

    @Override // com.anythink.banner.unitgroup.api.CustomBannerAdapter
    public View getBannerView() {
        return this.f12626c;
    }

    @Override // com.anythink.core.api.ATBaseAdAdapter
    public Map<String, Object> getNetworkInfoMap() {
        return this.f12638o;
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
    public void loadCustomNetworkAd(final Context context, final Map<String, Object> map, final Map<String, Object> map2) {
        String stringFromMap = ATInitMediation.getStringFromMap(map, "app_id");
        this.a = ATInitMediation.getStringFromMap(map, "slot_id");
        boolean z2 = false;
        if (!TextUtils.isEmpty(stringFromMap) && !TextUtils.isEmpty(this.a)) {
            this.f12629f = ATInitMediation.getIntFromMap(map, "nw_rft", 0);
            this.f12630g = ATInitMediation.getStringFromMap(map, "payload");
            z2 = true;
        }
        if (!z2) {
            notifyATLoadFail("", "app_id or slot_id is empty!");
        } else if (!(context instanceof Activity)) {
            notifyATLoadFail("", "Context must be activity.");
        } else {
            this.b = context;
            TTATInitManager.getInstance().initSDK(context, map, new MediationInitCallback() { // from class: com.anythink.network.toutiao.TTATBannerAdapter.5
                @Override // com.anythink.core.api.MediationInitCallback
                public final void onFail(String str) {
                    TTATBannerAdapter.this.notifyATLoadFail("", str);
                }

                @Override // com.anythink.core.api.MediationInitCallback
                public final void onSuccess() {
                    try {
                        TTATBannerAdapter.a(TTATBannerAdapter.this, context, map, map2);
                    } catch (Throwable th) {
                        TTATBannerAdapter.this.notifyATLoadFail("", th.getMessage());
                    }
                }
            });
        }
    }

    @Override // com.anythink.core.api.ATBaseAdAdapter
    public boolean startBiddingRequest(Context context, Map<String, Object> map, Map<String, Object> map2, ATBiddingListener aTBiddingListener) {
        this.f12632i = true;
        loadCustomNetworkAd(context, map, map2);
        return true;
    }

    /* JADX INFO: renamed from: com.anythink.network.toutiao.TTATBannerAdapter$4, reason: invalid class name */
    final class AnonymousClass4 implements TTAdDislike.DislikeInteractionCallback {
        AnonymousClass4() {
        }

        @Override // com.bytedance.sdk.openadsdk.TTAdDislike.DislikeInteractionCallback
        public final void onCancel() {
        }

        @Deprecated
        public final void onRefuse() {
        }

        @Override // com.bytedance.sdk.openadsdk.TTAdDislike.DislikeInteractionCallback
        public final void onSelected(int i2, String str, boolean z2) {
            if (((CustomBannerAdapter) TTATBannerAdapter.this).mImpressionEventListener != null) {
                ((CustomBannerAdapter) TTATBannerAdapter.this).mImpressionEventListener.onBannerAdClose();
            }
        }

        @Override // com.bytedance.sdk.openadsdk.TTAdDislike.DislikeInteractionCallback
        public final void onShow() {
        }

        @Deprecated
        public final void onSelected(int i2, String str) {
            if (((CustomBannerAdapter) TTATBannerAdapter.this).mImpressionEventListener != null) {
                ((CustomBannerAdapter) TTATBannerAdapter.this).mImpressionEventListener.onBannerAdClose();
            }
        }
    }

    private void a(Context context, Map<String, Object> map, Map<String, Object> map2) {
        runOnNetworkRequestThread(new AnonymousClass3(map, map2, context.getApplicationContext()));
    }

    private void a(Activity activity, TTNativeExpressAd tTNativeExpressAd) {
        tTNativeExpressAd.setDislikeCallback(activity, new AnonymousClass4());
    }

    private void a() {
        TTNativeExpressAd tTNativeExpressAd = this.f12637n;
        if (tTNativeExpressAd != null) {
            tTNativeExpressAd.setExpressInteractionListener(this.f12634k);
            this.f12637n.setDownloadListener(this.f12635l);
        }
    }

    private boolean a(Map<String, Object> map) {
        String stringFromMap = ATInitMediation.getStringFromMap(map, "app_id");
        this.a = ATInitMediation.getStringFromMap(map, "slot_id");
        if (TextUtils.isEmpty(stringFromMap) || TextUtils.isEmpty(this.a)) {
            return false;
        }
        this.f12629f = ATInitMediation.getIntFromMap(map, "nw_rft", 0);
        this.f12630g = ATInitMediation.getStringFromMap(map, "payload");
        return true;
    }

    static /* synthetic */ void a(TTATBannerAdapter tTATBannerAdapter, Activity activity, TTNativeExpressAd tTNativeExpressAd) {
        tTNativeExpressAd.setDislikeCallback(activity, tTATBannerAdapter.new AnonymousClass4());
    }

    static /* synthetic */ void a(TTATBannerAdapter tTATBannerAdapter, Context context, Map map, Map map2) {
        tTATBannerAdapter.runOnNetworkRequestThread(tTATBannerAdapter.new AnonymousClass3(map, map2, context.getApplicationContext()));
    }
}
