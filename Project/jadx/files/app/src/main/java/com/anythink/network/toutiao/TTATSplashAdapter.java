package com.anythink.network.toutiao;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import com.anythink.china.api.CustomAdapterDownloadListener;
import com.anythink.core.api.ATAdConst;
import com.anythink.core.api.ATBaseAdAdapter;
import com.anythink.core.api.ATBiddingListener;
import com.anythink.core.api.ATInitMediation;
import com.anythink.core.api.BaseAd;
import com.anythink.core.api.MediationInitCallback;
import com.anythink.splashad.api.ATSplashEyeAdListener;
import com.anythink.splashad.api.IATSplashEyeAd;
import com.anythink.splashad.unitgroup.api.CustomSplashAdapter;
import com.anythink.splashad.unitgroup.api.CustomSplashEventListener;
import com.bytedance.sdk.openadsdk.AdSlot;
import com.bytedance.sdk.openadsdk.CSJAdError;
import com.bytedance.sdk.openadsdk.CSJSplashAd;
import com.bytedance.sdk.openadsdk.TTAdManager;
import com.bytedance.sdk.openadsdk.TTAdNative;
import com.bytedance.sdk.openadsdk.TTAdSdk;
import com.bytedance.sdk.openadsdk.TTAppDownloadListener;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public class TTATSplashAdapter extends CustomSplashAdapter implements CSJSplashAd.SplashAdListener {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    CSJSplashAd f12702d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    boolean f12703e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    TTATSplashEyeAd f12704f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    View f12705g;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private Map<String, Object> f12711m;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private final String f12709k = TTATSplashAdapter.class.getSimpleName();
    String a = "";
    String b = "";

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    String f12701c = "";

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private boolean f12710l = false;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    String f12706h = "";

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    boolean f12707i = false;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private boolean f12712n = false;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    TTAppDownloadListener f12708j = new TTAppDownloadListener() { // from class: com.anythink.network.toutiao.TTATSplashAdapter.4
        @Override // com.bytedance.sdk.openadsdk.TTAppDownloadListener
        public final void onDownloadActive(long j2, long j3, String str, String str2) {
            if (TTATSplashAdapter.this.f12712n) {
                if (((ATBaseAdAdapter) TTATSplashAdapter.this).mDownloadListener == null || !(((ATBaseAdAdapter) TTATSplashAdapter.this).mDownloadListener instanceof CustomAdapterDownloadListener)) {
                    return;
                }
                ((CustomAdapterDownloadListener) ((ATBaseAdAdapter) TTATSplashAdapter.this).mDownloadListener).onDownloadUpdate(j2, j3, str, str2);
                return;
            }
            TTATSplashAdapter.h(TTATSplashAdapter.this);
            if (((ATBaseAdAdapter) TTATSplashAdapter.this).mDownloadListener == null || !(((ATBaseAdAdapter) TTATSplashAdapter.this).mDownloadListener instanceof CustomAdapterDownloadListener)) {
                return;
            }
            ((CustomAdapterDownloadListener) ((ATBaseAdAdapter) TTATSplashAdapter.this).mDownloadListener).onDownloadStart(j2, j3, str, str2);
        }

        @Override // com.bytedance.sdk.openadsdk.TTAppDownloadListener
        public final void onDownloadFailed(long j2, long j3, String str, String str2) {
            if (((ATBaseAdAdapter) TTATSplashAdapter.this).mDownloadListener == null || !(((ATBaseAdAdapter) TTATSplashAdapter.this).mDownloadListener instanceof CustomAdapterDownloadListener)) {
                return;
            }
            ((CustomAdapterDownloadListener) ((ATBaseAdAdapter) TTATSplashAdapter.this).mDownloadListener).onDownloadFail(j2, j3, str, str2);
        }

        @Override // com.bytedance.sdk.openadsdk.TTAppDownloadListener
        public final void onDownloadFinished(long j2, String str, String str2) {
            if (((ATBaseAdAdapter) TTATSplashAdapter.this).mDownloadListener == null || !(((ATBaseAdAdapter) TTATSplashAdapter.this).mDownloadListener instanceof CustomAdapterDownloadListener)) {
                return;
            }
            ((CustomAdapterDownloadListener) ((ATBaseAdAdapter) TTATSplashAdapter.this).mDownloadListener).onDownloadFinish(j2, str, str2);
        }

        @Override // com.bytedance.sdk.openadsdk.TTAppDownloadListener
        public final void onDownloadPaused(long j2, long j3, String str, String str2) {
            if (((ATBaseAdAdapter) TTATSplashAdapter.this).mDownloadListener == null || !(((ATBaseAdAdapter) TTATSplashAdapter.this).mDownloadListener instanceof CustomAdapterDownloadListener)) {
                return;
            }
            ((CustomAdapterDownloadListener) ((ATBaseAdAdapter) TTATSplashAdapter.this).mDownloadListener).onDownloadPause(j2, j3, str, str2);
        }

        @Override // com.bytedance.sdk.openadsdk.TTAppDownloadListener
        public final void onIdle() {
        }

        @Override // com.bytedance.sdk.openadsdk.TTAppDownloadListener
        public final void onInstalled(String str, String str2) {
            if (((ATBaseAdAdapter) TTATSplashAdapter.this).mDownloadListener == null || !(((ATBaseAdAdapter) TTATSplashAdapter.this).mDownloadListener instanceof CustomAdapterDownloadListener)) {
                return;
            }
            ((CustomAdapterDownloadListener) ((ATBaseAdAdapter) TTATSplashAdapter.this).mDownloadListener).onInstalled(str, str2);
        }
    };

    /* JADX INFO: renamed from: com.anythink.network.toutiao.TTATSplashAdapter$2, reason: invalid class name */
    final class AnonymousClass2 implements Runnable {
        final /* synthetic */ AdSlot.Builder a;
        final /* synthetic */ TTAdNative b;

        AnonymousClass2(AdSlot.Builder builder, TTAdNative tTAdNative) {
            this.a = builder;
            this.b = tTAdNative;
        }

        @Override // java.lang.Runnable
        public final void run() {
            try {
                this.b.loadSplashAd(this.a.build(), new TTAdNative.CSJSplashAdListener() { // from class: com.anythink.network.toutiao.TTATSplashAdapter.2.1
                    @Override // com.bytedance.sdk.openadsdk.TTAdNative.CSJSplashAdListener
                    public final void onSplashLoadFail(CSJAdError cSJAdError) {
                        TTATSplashAdapter tTATSplashAdapter = TTATSplashAdapter.this;
                        StringBuilder sb = new StringBuilder();
                        sb.append(cSJAdError.getCode());
                        tTATSplashAdapter.notifyATLoadFail(sb.toString(), cSJAdError.getMsg());
                    }

                    @Override // com.bytedance.sdk.openadsdk.TTAdNative.CSJSplashAdListener
                    public final void onSplashLoadSuccess() {
                    }

                    @Override // com.bytedance.sdk.openadsdk.TTAdNative.CSJSplashAdListener
                    public final void onSplashRenderFail(CSJSplashAd cSJSplashAd, CSJAdError cSJAdError) {
                        TTATSplashAdapter tTATSplashAdapter = TTATSplashAdapter.this;
                        StringBuilder sb = new StringBuilder();
                        sb.append(cSJAdError.getCode());
                        tTATSplashAdapter.notifyATLoadFail(sb.toString(), cSJAdError.getMsg());
                    }

                    @Override // com.bytedance.sdk.openadsdk.TTAdNative.CSJSplashAdListener
                    public final void onSplashRenderSuccess(CSJSplashAd cSJSplashAd) {
                        TTATSplashAdapter tTATSplashAdapter = TTATSplashAdapter.this;
                        tTATSplashAdapter.f12702d = cSJSplashAd;
                        try {
                            Map<String, Object> mediaExtraInfo = tTATSplashAdapter.f12702d.getMediaExtraInfo();
                            if (mediaExtraInfo != null) {
                                if (TTATSplashAdapter.this.f12711m == null) {
                                    TTATSplashAdapter.this.f12711m = new HashMap(3);
                                }
                                TTATSplashAdapter.this.f12711m.putAll(mediaExtraInfo);
                            }
                        } catch (Throwable th) {
                            th.printStackTrace();
                        }
                        TTATSplashAdapter tTATSplashAdapter2 = TTATSplashAdapter.this;
                        if (tTATSplashAdapter2.f12707i) {
                            try {
                                TTATInitManager.getInstance().a(TTATSplashAdapter.this.f12711m, TTATSplashAdapter.this.f12702d, TTATSplashAdapter.this.mBiddingListener);
                            } catch (Throwable unused) {
                            }
                        } else if (((ATBaseAdAdapter) tTATSplashAdapter2).mLoadListener != null) {
                            ((ATBaseAdAdapter) TTATSplashAdapter.this).mLoadListener.onAdCacheLoaded(new BaseAd[0]);
                        }
                    }
                }, ((CustomSplashAdapter) TTATSplashAdapter.this).mFetchAdTimeout);
            } catch (Exception e2) {
                TTATSplashAdapter.this.notifyATLoadFail("", e2.getMessage());
            }
        }
    }

    /* JADX INFO: renamed from: com.anythink.network.toutiao.TTATSplashAdapter$3, reason: invalid class name */
    final class AnonymousClass3 implements CSJSplashAd.SplashClickEyeListener {
        AnonymousClass3() {
        }

        @Override // com.bytedance.sdk.openadsdk.CSJSplashAd.SplashClickEyeListener
        public final void onSplashClickEyeClick() {
            if (((CustomSplashAdapter) TTATSplashAdapter.this).mImpressionListener != null) {
                ((CustomSplashAdapter) TTATSplashAdapter.this).mImpressionListener.onSplashAdClicked();
            }
        }

        @Override // com.bytedance.sdk.openadsdk.CSJSplashAd.SplashClickEyeListener
        public final void onSplashClickEyeClose() {
            TTATSplashEyeAd tTATSplashEyeAd;
            ATSplashEyeAdListener splashEyeAdListener;
            TTATSplashAdapter tTATSplashAdapter = TTATSplashAdapter.this;
            if (!tTATSplashAdapter.f12703e || (tTATSplashEyeAd = tTATSplashAdapter.f12704f) == null || (splashEyeAdListener = tTATSplashEyeAd.getSplashEyeAdListener()) == null) {
                return;
            }
            splashEyeAdListener.onAdDismiss(true, "");
        }

        @Override // com.bytedance.sdk.openadsdk.CSJSplashAd.SplashClickEyeListener
        public final void onSplashClickEyeReadyToShow(CSJSplashAd cSJSplashAd) {
            TTATSplashAdapter tTATSplashAdapter = TTATSplashAdapter.this;
            tTATSplashAdapter.f12703e = true;
            tTATSplashAdapter.f12704f = new TTATSplashEyeAd(tTATSplashAdapter, tTATSplashAdapter.f12702d);
            TTATSplashAdapter tTATSplashAdapter2 = TTATSplashAdapter.this;
            tTATSplashAdapter2.f12704f.setSplashView(tTATSplashAdapter2.f12705g);
        }
    }

    static /* synthetic */ boolean h(TTATSplashAdapter tTATSplashAdapter) {
        tTATSplashAdapter.f12712n = true;
        return true;
    }

    @Override // com.anythink.core.api.ATBaseAdAdapter
    public void destory() {
    }

    @Override // com.anythink.core.api.ATBaseAdAdapter
    public Map<String, Object> getNetworkInfoMap() {
        return this.f12711m;
    }

    @Override // com.anythink.core.api.ATBaseAdAdapter
    public String getNetworkName() {
        return TTATInitManager.getInstance().getNetworkName();
    }

    @Override // com.anythink.core.api.ATBaseAdAdapter
    public String getNetworkPlacementId() {
        return this.b;
    }

    @Override // com.anythink.core.api.ATBaseAdAdapter
    public String getNetworkSDKVersion() {
        return TTATInitManager.getInstance().getNetworkVersion();
    }

    @Override // com.anythink.splashad.unitgroup.api.CustomSplashAdapter
    public IATSplashEyeAd getSplashEyeAd() {
        return this.f12704f;
    }

    @Override // com.anythink.core.api.ATBaseAdAdapter
    public boolean isAdReady() {
        return this.f12702d != null;
    }

    @Override // com.anythink.splashad.unitgroup.api.CustomSplashAdapter
    public boolean isSupportCustomSkipView() {
        return true;
    }

    @Override // com.anythink.core.api.ATBaseAdAdapter
    public void loadCustomNetworkAd(final Context context, final Map<String, Object> map, final Map<String, Object> map2) {
        boolean z2;
        String stringFromMap = ATInitMediation.getStringFromMap(map, "app_id");
        this.b = ATInitMediation.getStringFromMap(map, "slot_id");
        if (TextUtils.isEmpty(stringFromMap) || TextUtils.isEmpty(this.b)) {
            z2 = false;
        } else {
            this.f12706h = ATInitMediation.getStringFromMap(map, "payload");
            this.f12701c = ATInitMediation.getStringFromMap(map, "personalized_template", "0");
            z2 = true;
        }
        if (z2) {
            TTATInitManager.getInstance().initSDK(context, map, new MediationInitCallback() { // from class: com.anythink.network.toutiao.TTATSplashAdapter.1
                @Override // com.anythink.core.api.MediationInitCallback
                public final void onFail(String str) {
                    TTATSplashAdapter.this.notifyATLoadFail("", str);
                }

                @Override // com.anythink.core.api.MediationInitCallback
                public final void onSuccess() {
                    try {
                        if (TTATSplashAdapter.this.getMixedFormatAdType() == 0) {
                            TTATSplashAdapter.this.thirdPartyLoad(new TTATAdapter(), context, map, map2);
                        } else {
                            TTATSplashAdapter.a(TTATSplashAdapter.this, context, map, map2);
                        }
                    } catch (Throwable th) {
                        TTATSplashAdapter.this.notifyATLoadFail("", th.getMessage());
                    }
                }
            });
        } else {
            notifyATLoadFail("", "app_id or slot_id is empty!");
        }
    }

    @Override // com.bytedance.sdk.openadsdk.CSJSplashAd.SplashAdListener
    public void onSplashAdClick(CSJSplashAd cSJSplashAd) {
        CustomSplashEventListener customSplashEventListener = this.mImpressionListener;
        if (customSplashEventListener != null) {
            customSplashEventListener.onSplashAdClicked();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.CSJSplashAd.SplashAdListener
    public void onSplashAdClose(CSJSplashAd cSJSplashAd, int i2) {
        if (i2 == 1) {
            this.mDismissType = 2;
            if (this.f12710l && cSJSplashAd != null) {
                cSJSplashAd.startClickEye();
            }
        } else if (i2 == 2) {
            this.mDismissType = 3;
        } else if (i2 == 3) {
            this.mDismissType = 4;
        }
        CustomSplashEventListener customSplashEventListener = this.mImpressionListener;
        if (customSplashEventListener != null) {
            customSplashEventListener.onSplashAdDismiss();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.CSJSplashAd.SplashAdListener
    public void onSplashAdShow(CSJSplashAd cSJSplashAd) {
        try {
            TTATInitManager.getInstance().a(getTrackingInfo().l(), new WeakReference(this.f12702d));
        } catch (Throwable unused) {
        }
        CustomSplashEventListener customSplashEventListener = this.mImpressionListener;
        if (customSplashEventListener != null) {
            customSplashEventListener.onSplashAdShow();
        }
    }

    @Override // com.anythink.splashad.unitgroup.api.CustomSplashAdapter
    public void show(Activity activity, ViewGroup viewGroup) {
        if (this.f12702d != null) {
            if (isCustomSkipView()) {
                this.f12702d.hideSkipButton();
            }
            this.f12702d.setDownloadListener(this.f12708j);
            if (this.f12710l) {
                this.f12702d.setSplashClickEyeListener(new AnonymousClass3());
            }
            this.f12702d.setSplashAdListener(this);
            View splashView = this.f12702d.getSplashView();
            if (splashView != null) {
                if (!this.f12710l) {
                    viewGroup.addView(splashView, new ViewGroup.LayoutParams(-1, -1));
                } else {
                    this.f12705g = splashView;
                    viewGroup.addView(this.f12705g, new ViewGroup.LayoutParams(-1, -1));
                }
            }
        }
    }

    @Override // com.anythink.core.api.ATBaseAdAdapter
    public boolean startBiddingRequest(Context context, Map<String, Object> map, Map<String, Object> map2, ATBiddingListener aTBiddingListener) {
        this.f12707i = true;
        if (getMixedFormatAdType() == 0) {
            return false;
        }
        loadCustomNetworkAd(context, map, map2);
        return true;
    }

    @Override // com.anythink.splashad.unitgroup.api.CustomSplashAdapter
    public void startSplashCustomSkipViewClickEye() {
        CSJSplashAd cSJSplashAd = this.f12702d;
        if (cSJSplashAd != null) {
            cSJSplashAd.startClickEye();
        }
    }

    private void a(Context context, Map<String, Object> map, Map<String, Object> map2) {
        TTAdManager adManager = TTAdSdk.getAdManager();
        Context applicationContext = context.getApplicationContext();
        TTAdNative tTAdNativeCreateAdNative = adManager.createAdNative(applicationContext);
        TTATCustomAdSlotBuilder tTATCustomAdSlotBuilder = new TTATCustomAdSlotBuilder(this.b, map, map2);
        int i2 = 0;
        try {
        } catch (Throwable th) {
            th.printStackTrace();
        }
        int i3 = map2.containsKey(ATAdConst.KEY.AD_WIDTH) ? Integer.parseInt(map2.get(ATAdConst.KEY.AD_WIDTH).toString()) : 0;
        try {
            if (map2.containsKey(ATAdConst.KEY.AD_HEIGHT)) {
                i2 = Integer.parseInt(map2.get(ATAdConst.KEY.AD_HEIGHT).toString());
            }
        } catch (Throwable th2) {
            th2.printStackTrace();
        }
        if (i3 <= 0) {
            i3 = applicationContext.getResources().getDisplayMetrics().widthPixels;
        }
        if (i2 <= 0) {
            i2 = applicationContext.getResources().getDisplayMetrics().heightPixels;
        }
        tTATCustomAdSlotBuilder.setImageAcceptedSize(i3, i2);
        tTATCustomAdSlotBuilder.setExpressViewAcceptedSize(a(applicationContext, i3), a(applicationContext, i2));
        try {
            if (map.containsKey("zoomoutad_sw")) {
                this.f12710l = TextUtils.equals("2", map.get("zoomoutad_sw").toString());
            }
        } catch (Exception unused) {
        }
        try {
            if (map.containsKey("button_type")) {
                map.get("button_type");
            }
        } catch (Exception unused2) {
        }
        postOnMainThread(new AnonymousClass2(tTATCustomAdSlotBuilder, tTAdNativeCreateAdNative));
    }

    private void a() {
        if (this.f12710l) {
            this.f12702d.setSplashClickEyeListener(new AnonymousClass3());
        }
    }

    private static int a(Context context, float f2) {
        float f3 = context.getResources().getDisplayMetrics().density;
        if (f3 <= 0.0f) {
            f3 = 1.0f;
        }
        return (int) ((f2 / f3) + 0.5f);
    }

    private boolean a(Map<String, Object> map) {
        String stringFromMap = ATInitMediation.getStringFromMap(map, "app_id");
        this.b = ATInitMediation.getStringFromMap(map, "slot_id");
        if (TextUtils.isEmpty(stringFromMap) || TextUtils.isEmpty(this.b)) {
            return false;
        }
        this.f12706h = ATInitMediation.getStringFromMap(map, "payload");
        this.f12701c = ATInitMediation.getStringFromMap(map, "personalized_template", "0");
        return true;
    }

    static /* synthetic */ void a(TTATSplashAdapter tTATSplashAdapter, Context context, Map map, Map map2) {
        TTAdManager adManager = TTAdSdk.getAdManager();
        Context applicationContext = context.getApplicationContext();
        TTAdNative tTAdNativeCreateAdNative = adManager.createAdNative(applicationContext);
        TTATCustomAdSlotBuilder tTATCustomAdSlotBuilder = new TTATCustomAdSlotBuilder(tTATSplashAdapter.b, map, map2);
        int i2 = 0;
        try {
        } catch (Throwable th) {
            th.printStackTrace();
        }
        int i3 = map2.containsKey(ATAdConst.KEY.AD_WIDTH) ? Integer.parseInt(map2.get(ATAdConst.KEY.AD_WIDTH).toString()) : 0;
        try {
            if (map2.containsKey(ATAdConst.KEY.AD_HEIGHT)) {
                i2 = Integer.parseInt(map2.get(ATAdConst.KEY.AD_HEIGHT).toString());
            }
        } catch (Throwable th2) {
            th2.printStackTrace();
        }
        if (i3 <= 0) {
            i3 = applicationContext.getResources().getDisplayMetrics().widthPixels;
        }
        if (i2 <= 0) {
            i2 = applicationContext.getResources().getDisplayMetrics().heightPixels;
        }
        tTATCustomAdSlotBuilder.setImageAcceptedSize(i3, i2);
        tTATCustomAdSlotBuilder.setExpressViewAcceptedSize(a(applicationContext, i3), a(applicationContext, i2));
        try {
            if (map.containsKey("zoomoutad_sw")) {
                tTATSplashAdapter.f12710l = TextUtils.equals("2", map.get("zoomoutad_sw").toString());
            }
        } catch (Exception unused) {
        }
        try {
            if (map.containsKey("button_type")) {
                map.get("button_type");
            }
        } catch (Exception unused2) {
        }
        tTATSplashAdapter.postOnMainThread(tTATSplashAdapter.new AnonymousClass2(tTATCustomAdSlotBuilder, tTAdNativeCreateAdNative));
    }
}
