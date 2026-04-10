package com.anythink.network.ks;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.Nullable;
import com.anythink.core.api.ATAdConst;
import com.anythink.core.api.ATBaseAdAdapter;
import com.anythink.core.api.ATBidRequestInfoListener;
import com.anythink.core.api.ATBiddingListener;
import com.anythink.core.api.ATBiddingResult;
import com.anythink.core.api.ATInitMediation;
import com.anythink.core.api.BaseAd;
import com.anythink.core.api.ErrorCode;
import com.anythink.core.api.MediationInitCallback;
import com.anythink.core.common.b.g;
import com.anythink.splashad.unitgroup.api.CustomSplashAdapter;
import com.anythink.splashad.unitgroup.api.CustomSplashEventListener;
import com.bytedance.msdk.adapter.pangle.PangleAdapterUtils;
import com.kwad.sdk.api.KsAdSDK;
import com.kwad.sdk.api.KsLoadManager;
import com.kwad.sdk.api.KsScene;
import com.kwad.sdk.api.KsSplashScreenAd;
import java.lang.ref.WeakReference;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public class KSATSplashAdapter extends CustomSplashAdapter {
    long a;
    KsSplashScreenAd b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    View f12521c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    boolean f12522d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    Context f12523e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    String f12524f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    double f12525g;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final String f12527i = KSATSplashAdapter.class.getSimpleName();

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private boolean f12528j = false;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    boolean f12526h = false;

    /* JADX INFO: renamed from: com.anythink.network.ks.KSATSplashAdapter$2, reason: invalid class name */
    final class AnonymousClass2 implements KsLoadManager.SplashScreenAdListener {
        AnonymousClass2() {
        }

        @Override // com.kwad.sdk.api.KsLoadManager.SplashScreenAdListener
        public final void onError(int i2, String str) {
            KSATSplashAdapter.this.notifyATLoadFail(String.valueOf(i2), str);
        }

        @Override // com.kwad.sdk.api.KsLoadManager.SplashScreenAdListener
        public final void onRequestResult(int i2) {
        }

        @Override // com.kwad.sdk.api.KsLoadManager.SplashScreenAdListener
        public final void onSplashScreenAdLoad(@Nullable KsSplashScreenAd ksSplashScreenAd) {
            KSATSplashAdapter kSATSplashAdapter = KSATSplashAdapter.this;
            kSATSplashAdapter.b = ksSplashScreenAd;
            if (!kSATSplashAdapter.f12526h) {
                if (((ATBaseAdAdapter) kSATSplashAdapter).mLoadListener != null) {
                    ((ATBaseAdAdapter) KSATSplashAdapter.this).mLoadListener.onAdCacheLoaded(new BaseAd[0]);
                }
            } else if (kSATSplashAdapter.mBiddingListener != null) {
                double ecpm = PangleAdapterUtils.CPM_DEFLAUT_VALUE;
                try {
                    ecpm = ksSplashScreenAd.getECPM();
                } catch (Throwable th) {
                    th.printStackTrace();
                }
                KSATBiddingNotice kSATBiddingNotice = new KSATBiddingNotice(ksSplashScreenAd);
                ATBiddingListener aTBiddingListener = KSATSplashAdapter.this.mBiddingListener;
                StringBuilder sb = new StringBuilder();
                sb.append(System.currentTimeMillis());
                aTBiddingListener.onC2SBiddingResultWithCache(ATBiddingResult.success(ecpm, sb.toString(), kSATBiddingNotice, ATAdConst.CURRENCY.RMB_CENT), null);
            }
        }
    }

    private void a() {
        AnonymousClass2 anonymousClass2 = new AnonymousClass2();
        KsScene.Builder builderAdNum = new KsScene.Builder(this.a).adNum(1);
        if (!TextUtils.isEmpty(this.f12524f)) {
            builderAdNum.setBidResponseV2(this.f12524f);
        }
        KsAdSDK.getLoadManager().loadSplashScreenAd(builderAdNum.build(), anonymousClass2);
    }

    static /* synthetic */ int g(KSATSplashAdapter kSATSplashAdapter) {
        kSATSplashAdapter.mDismissType = 99;
        return 99;
    }

    static /* synthetic */ int k(KSATSplashAdapter kSATSplashAdapter) {
        kSATSplashAdapter.mDismissType = 3;
        return 3;
    }

    static /* synthetic */ int p(KSATSplashAdapter kSATSplashAdapter) {
        kSATSplashAdapter.mDismissType = 2;
        return 2;
    }

    @Override // com.anythink.core.api.ATBaseAdAdapter
    public void destory() {
        this.b = null;
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
        KsSplashScreenAd ksSplashScreenAd = this.b;
        return ksSplashScreenAd != null && ksSplashScreenAd.isAdEnable();
    }

    @Override // com.anythink.core.api.ATBaseAdAdapter
    public void loadCustomNetworkAd(Context context, final Map<String, Object> map, final Map<String, Object> map2) {
        if (!a(map)) {
            notifyATLoadFail("", "kuaishou app_id or position_id is empty.");
        } else {
            this.f12523e = context.getApplicationContext();
            KSATInitManager.getInstance().initSDK(this.f12523e, map, new MediationInitCallback() { // from class: com.anythink.network.ks.KSATSplashAdapter.1
                @Override // com.anythink.core.api.MediationInitCallback
                public final void onFail(String str) {
                    KSATSplashAdapter.this.notifyATLoadFail("", str);
                }

                @Override // com.anythink.core.api.MediationInitCallback
                public final void onSuccess() {
                    if (KSATSplashAdapter.this.getMixedFormatAdType() != 0) {
                        KSATSplashAdapter.a(KSATSplashAdapter.this);
                        return;
                    }
                    if (!map.containsKey("video_sound")) {
                        map.put("video_sound", 0);
                    }
                    KSATSplashAdapter.this.thirdPartyLoad(new KSATAdapter(), KSATSplashAdapter.this.f12523e, map, map2);
                }
            });
        }
    }

    @Override // com.anythink.splashad.unitgroup.api.CustomSplashAdapter
    public void show(Activity activity, ViewGroup viewGroup) {
        KsSplashScreenAd ksSplashScreenAd = this.b;
        if (ksSplashScreenAd != null) {
            try {
                View view = ksSplashScreenAd.getView(viewGroup.getContext().getApplicationContext(), new KsSplashScreenAd.SplashScreenAdInteractionListener() { // from class: com.anythink.network.ks.KSATSplashAdapter.3
                    @Override // com.kwad.sdk.api.KsSplashScreenAd.SplashScreenAdInteractionListener
                    public final void onAdClicked() {
                        if (((CustomSplashAdapter) KSATSplashAdapter.this).mImpressionListener != null) {
                            ((CustomSplashAdapter) KSATSplashAdapter.this).mImpressionListener.onSplashAdClicked();
                        }
                    }

                    @Override // com.kwad.sdk.api.KsSplashScreenAd.SplashScreenAdInteractionListener
                    public final void onAdShowEnd() {
                        KSATSplashAdapter.k(KSATSplashAdapter.this);
                        KSATSplashAdapter kSATSplashAdapter = KSATSplashAdapter.this;
                        if (kSATSplashAdapter.f12522d || ((CustomSplashAdapter) kSATSplashAdapter).mImpressionListener == null) {
                            return;
                        }
                        KSATSplashAdapter kSATSplashAdapter2 = KSATSplashAdapter.this;
                        kSATSplashAdapter2.f12522d = true;
                        ((CustomSplashAdapter) kSATSplashAdapter2).mImpressionListener.onSplashAdDismiss();
                    }

                    @Override // com.kwad.sdk.api.KsSplashScreenAd.SplashScreenAdInteractionListener
                    public final void onAdShowError(int i2, String str) {
                        String unused = KSATSplashAdapter.this.f12527i;
                        String str2 = "onAdShowError: " + i2 + ", " + str;
                        KSATSplashAdapter.g(KSATSplashAdapter.this);
                        KSATSplashAdapter kSATSplashAdapter = KSATSplashAdapter.this;
                        if (kSATSplashAdapter.f12522d || ((CustomSplashAdapter) kSATSplashAdapter).mImpressionListener == null) {
                            return;
                        }
                        KSATSplashAdapter kSATSplashAdapter2 = KSATSplashAdapter.this;
                        kSATSplashAdapter2.f12522d = true;
                        ((CustomSplashAdapter) kSATSplashAdapter2).mImpressionListener.onSplashAdShowFail(ErrorCode.getErrorCode(ErrorCode.adShowError, String.valueOf(i2), str));
                        ((CustomSplashAdapter) KSATSplashAdapter.this).mImpressionListener.onSplashAdDismiss();
                    }

                    @Override // com.kwad.sdk.api.KsSplashScreenAd.SplashScreenAdInteractionListener
                    public final void onAdShowStart() {
                        try {
                            KSATInitManager.getInstance().a(KSATSplashAdapter.this.getTrackingInfo().l(), new WeakReference(KSATSplashAdapter.this.b));
                        } catch (Throwable unused) {
                        }
                        if (((CustomSplashAdapter) KSATSplashAdapter.this).mImpressionListener != null) {
                            ((CustomSplashAdapter) KSATSplashAdapter.this).mImpressionListener.onSplashAdShow();
                        }
                    }

                    @Override // com.kwad.sdk.api.KsSplashScreenAd.SplashScreenAdInteractionListener
                    public final void onDownloadTipsDialogCancel() {
                    }

                    @Override // com.kwad.sdk.api.KsSplashScreenAd.SplashScreenAdInteractionListener
                    public final void onDownloadTipsDialogDismiss() {
                    }

                    @Override // com.kwad.sdk.api.KsSplashScreenAd.SplashScreenAdInteractionListener
                    public final void onDownloadTipsDialogShow() {
                    }

                    @Override // com.kwad.sdk.api.KsSplashScreenAd.SplashScreenAdInteractionListener
                    public final void onSkippedAd() {
                        KSATSplashAdapter.p(KSATSplashAdapter.this);
                        KSATSplashAdapter kSATSplashAdapter = KSATSplashAdapter.this;
                        if (kSATSplashAdapter.f12522d || ((CustomSplashAdapter) kSATSplashAdapter).mImpressionListener == null) {
                            return;
                        }
                        KSATSplashAdapter kSATSplashAdapter2 = KSATSplashAdapter.this;
                        kSATSplashAdapter2.f12522d = true;
                        ((CustomSplashAdapter) kSATSplashAdapter2).mImpressionListener.onSplashAdDismiss();
                    }
                });
                if (!this.f12528j) {
                    viewGroup.addView(view, new ViewGroup.LayoutParams(-1, -1));
                } else {
                    this.f12521c = view;
                    viewGroup.addView(this.f12521c, new ViewGroup.LayoutParams(-1, -1));
                }
            } catch (Throwable th) {
                th.getMessage();
                th.printStackTrace();
            }
        }
    }

    @Override // com.anythink.core.api.ATBaseAdAdapter
    public boolean startBiddingRequest(Context context, Map<String, Object> map, Map<String, Object> map2, ATBiddingListener aTBiddingListener) {
        this.f12526h = true;
        if (getMixedFormatAdType() == 0) {
            return false;
        }
        loadCustomNetworkAd(context, map, map2);
        return true;
    }

    private void b() {
        CustomSplashEventListener customSplashEventListener = this.mImpressionListener;
        if (customSplashEventListener != null) {
            customSplashEventListener.onSplashAdClicked();
        }
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
        if (map.containsKey("zoomoutad_sw")) {
            this.f12528j = TextUtils.equals("2", ATInitMediation.getStringFromMap(map, "zoomoutad_sw"));
        }
        if (map.containsKey(g.k.f6905o)) {
            this.f12525g = ATInitMediation.getDoubleFromMap(map, g.k.f6905o);
        }
        if (!map.containsKey("payload")) {
            return true;
        }
        this.f12524f = KSATInitManager.getInstance().getPayloadInfo(ATInitMediation.getStringFromMap(map, "payload"), this.f12525g);
        return true;
    }

    static /* synthetic */ void a(KSATSplashAdapter kSATSplashAdapter) {
        AnonymousClass2 anonymousClass2 = kSATSplashAdapter.new AnonymousClass2();
        KsScene.Builder builderAdNum = new KsScene.Builder(kSATSplashAdapter.a).adNum(1);
        if (!TextUtils.isEmpty(kSATSplashAdapter.f12524f)) {
            builderAdNum.setBidResponseV2(kSATSplashAdapter.f12524f);
        }
        KsAdSDK.getLoadManager().loadSplashScreenAd(builderAdNum.build(), anonymousClass2);
    }
}
