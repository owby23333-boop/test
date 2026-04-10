package com.anythink.network.ks;

import android.content.Context;
import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.anythink.core.api.ATAdConst;
import com.anythink.core.api.ATBaseAdAdapter;
import com.anythink.core.api.ATBidRequestInfoListener;
import com.anythink.core.api.ATBiddingListener;
import com.anythink.core.api.ATBiddingResult;
import com.anythink.core.api.ATInitMediation;
import com.anythink.core.api.MediationInitCallback;
import com.anythink.core.common.b.g;
import com.anythink.nativead.unitgroup.api.CustomNativeAd;
import com.anythink.nativead.unitgroup.api.CustomNativeAdapter;
import com.bytedance.msdk.adapter.pangle.PangleAdapterUtils;
import com.kwad.sdk.api.KsAdSDK;
import com.kwad.sdk.api.KsDrawAd;
import com.kwad.sdk.api.KsFeedAd;
import com.kwad.sdk.api.KsLoadManager;
import com.kwad.sdk.api.KsNativeAd;
import com.kwad.sdk.api.KsScene;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public class KSATAdapter extends CustomNativeAdapter {
    long a;
    String b = "0";

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    boolean f12480c = false;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    String f12481d = "0";

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    String f12482e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    Context f12483f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    boolean f12484g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    double f12485h;

    /* JADX INFO: renamed from: com.anythink.network.ks.KSATAdapter$2, reason: invalid class name */
    final class AnonymousClass2 implements KsLoadManager.DrawAdListener {
        final /* synthetic */ Context a;

        AnonymousClass2(Context context) {
            this.a = context;
        }

        @Override // com.kwad.sdk.api.KsLoadManager.DrawAdListener
        public final void onDrawAdLoad(@Nullable List<KsDrawAd> list) {
            if (list == null || list.size() == 0) {
                KSATAdapter.this.notifyATLoadFail("", "kuaishou no fill");
                return;
            }
            ArrayList arrayList = new ArrayList();
            Iterator<KsDrawAd> it = list.iterator();
            while (it.hasNext()) {
                arrayList.add(new KSATDrawAd(this.a, it.next()));
            }
            CustomNativeAd[] customNativeAdArr = (CustomNativeAd[]) arrayList.toArray(new CustomNativeAd[arrayList.size()]);
            KSATAdapter kSATAdapter = KSATAdapter.this;
            if (!kSATAdapter.f12484g) {
                if (((ATBaseAdAdapter) kSATAdapter).mLoadListener != null) {
                    ((ATBaseAdAdapter) KSATAdapter.this).mLoadListener.onAdCacheLoaded(customNativeAdArr);
                    return;
                }
                return;
            }
            KsDrawAd ksDrawAd = list.get(0);
            if (KSATAdapter.this.mBiddingListener != null) {
                double ecpm = PangleAdapterUtils.CPM_DEFLAUT_VALUE;
                try {
                    ecpm = ksDrawAd.getECPM();
                } catch (Throwable th) {
                    th.printStackTrace();
                }
                KSATBiddingNotice kSATBiddingNotice = new KSATBiddingNotice(ksDrawAd);
                ATBiddingListener aTBiddingListener = KSATAdapter.this.mBiddingListener;
                StringBuilder sb = new StringBuilder();
                sb.append(System.currentTimeMillis());
                aTBiddingListener.onC2SBiddingResultWithCache(ATBiddingResult.success(ecpm, sb.toString(), kSATBiddingNotice, ATAdConst.CURRENCY.RMB_CENT), customNativeAdArr[0]);
            }
        }

        @Override // com.kwad.sdk.api.KsLoadManager.DrawAdListener
        public final void onError(int i2, String str) {
            KSATAdapter.this.notifyATLoadFail(String.valueOf(i2), str);
        }
    }

    /* JADX INFO: renamed from: com.anythink.network.ks.KSATAdapter$3, reason: invalid class name */
    final class AnonymousClass3 implements KsLoadManager.FeedAdListener {
        final /* synthetic */ Context a;

        AnonymousClass3(Context context) {
            this.a = context;
        }

        @Override // com.kwad.sdk.api.KsLoadManager.FeedAdListener
        public final void onError(int i2, String str) {
            KSATAdapter.this.notifyATLoadFail(String.valueOf(i2), str);
        }

        @Override // com.kwad.sdk.api.KsLoadManager.FeedAdListener
        public final void onFeedAdLoad(@Nullable List<KsFeedAd> list) {
            if (list == null || list.size() == 0) {
                KSATAdapter.this.notifyATLoadFail("", "kuaishou no fill");
                return;
            }
            ArrayList arrayList = new ArrayList();
            Iterator<KsFeedAd> it = list.iterator();
            while (it.hasNext()) {
                arrayList.add(new KSATFeedAd(this.a, it.next(), KSATAdapter.this.f12480c));
            }
            CustomNativeAd[] customNativeAdArr = (CustomNativeAd[]) arrayList.toArray(new CustomNativeAd[arrayList.size()]);
            KSATAdapter kSATAdapter = KSATAdapter.this;
            if (!kSATAdapter.f12484g) {
                if (((ATBaseAdAdapter) kSATAdapter).mLoadListener != null) {
                    ((ATBaseAdAdapter) KSATAdapter.this).mLoadListener.onAdCacheLoaded(customNativeAdArr);
                    return;
                }
                return;
            }
            KsFeedAd ksFeedAd = list.get(0);
            if (KSATAdapter.this.mBiddingListener != null) {
                double ecpm = PangleAdapterUtils.CPM_DEFLAUT_VALUE;
                try {
                    ecpm = ksFeedAd.getECPM();
                } catch (Throwable th) {
                    th.printStackTrace();
                }
                KSATBiddingNotice kSATBiddingNotice = new KSATBiddingNotice(ksFeedAd);
                ATBiddingListener aTBiddingListener = KSATAdapter.this.mBiddingListener;
                StringBuilder sb = new StringBuilder();
                sb.append(System.currentTimeMillis());
                aTBiddingListener.onC2SBiddingResultWithCache(ATBiddingResult.success(ecpm, sb.toString(), kSATBiddingNotice, ATAdConst.CURRENCY.RMB_CENT), customNativeAdArr[0]);
            }
        }
    }

    /* JADX INFO: renamed from: com.anythink.network.ks.KSATAdapter$4, reason: invalid class name */
    final class AnonymousClass4 implements KsLoadManager.NativeAdListener {
        final /* synthetic */ Context a;

        AnonymousClass4(Context context) {
            this.a = context;
        }

        @Override // com.kwad.sdk.api.KsLoadManager.NativeAdListener
        public final void onError(int i2, String str) {
            KSATAdapter.this.notifyATLoadFail(String.valueOf(i2), str);
        }

        @Override // com.kwad.sdk.api.KsLoadManager.NativeAdListener
        public final void onNativeAdLoad(@Nullable List<KsNativeAd> list) {
            if (list == null || list.size() == 0) {
                KSATAdapter.this.notifyATLoadFail("", "kuaishou no fill");
                return;
            }
            ArrayList arrayList = new ArrayList();
            Iterator<KsNativeAd> it = list.iterator();
            while (it.hasNext()) {
                arrayList.add(new KSATNativeAd(this.a, it.next(), KSATAdapter.this.f12480c));
            }
            CustomNativeAd[] customNativeAdArr = (CustomNativeAd[]) arrayList.toArray(new CustomNativeAd[arrayList.size()]);
            KSATAdapter kSATAdapter = KSATAdapter.this;
            if (!kSATAdapter.f12484g) {
                if (((ATBaseAdAdapter) kSATAdapter).mLoadListener != null) {
                    ((ATBaseAdAdapter) KSATAdapter.this).mLoadListener.onAdCacheLoaded(customNativeAdArr);
                    return;
                }
                return;
            }
            KsNativeAd ksNativeAd = list.get(0);
            if (KSATAdapter.this.mBiddingListener != null) {
                double ecpm = PangleAdapterUtils.CPM_DEFLAUT_VALUE;
                try {
                    ecpm = ksNativeAd.getECPM();
                } catch (Throwable th) {
                    th.printStackTrace();
                }
                KSATBiddingNotice kSATBiddingNotice = new KSATBiddingNotice(ksNativeAd);
                ATBiddingListener aTBiddingListener = KSATAdapter.this.mBiddingListener;
                StringBuilder sb = new StringBuilder();
                sb.append(System.currentTimeMillis());
                aTBiddingListener.onC2SBiddingResultWithCache(ATBiddingResult.success(ecpm, sb.toString(), kSATBiddingNotice, ATAdConst.CURRENCY.RMB_CENT), customNativeAdArr[0]);
            }
        }
    }

    @Override // com.anythink.core.api.ATBaseAdAdapter
    public void destory() {
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
    public void loadCustomNetworkAd(Context context, Map<String, Object> map, final Map<String, Object> map2) {
        if (!a(map)) {
            notifyATLoadFail("", "kuaishou app_id or position_id is empty.");
        } else {
            this.f12483f = context.getApplicationContext();
            KSATInitManager.getInstance().initSDK(context, map, new MediationInitCallback() { // from class: com.anythink.network.ks.KSATAdapter.1
                @Override // com.anythink.core.api.MediationInitCallback
                public final void onFail(String str) {
                    KSATAdapter.this.notifyATLoadFail("", str);
                }

                @Override // com.anythink.core.api.MediationInitCallback
                public final void onSuccess() {
                    KSATAdapter kSATAdapter = KSATAdapter.this;
                    KSATAdapter.a(kSATAdapter, kSATAdapter.f12483f, map2, ((CustomNativeAdapter) kSATAdapter).mRequestNum);
                }
            });
        }
    }

    @Override // com.anythink.core.api.ATBaseAdAdapter
    public boolean startBiddingRequest(Context context, Map<String, Object> map, Map<String, Object> map2, ATBiddingListener aTBiddingListener) {
        this.f12484g = true;
        loadCustomNetworkAd(context, map, map2);
        return true;
    }

    private void a(Context context, Map<String, Object> map, int i2) {
        Object obj = map.containsKey(ATAdConst.KEY.AD_WIDTH) ? map.get(ATAdConst.KEY.AD_WIDTH) : null;
        Object obj2 = map.containsKey(ATAdConst.KEY.AD_HEIGHT) ? map.get(ATAdConst.KEY.AD_HEIGHT) : null;
        KsScene.Builder builderAdNum = new KsScene.Builder(this.a).adNum(this.f12484g ? 1 : Math.min(i2, 5));
        if (obj != null) {
            try {
                int i3 = (int) Double.parseDouble(obj.toString());
                if (i3 > 0) {
                    builderAdNum.width(i3);
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
        if (obj2 != null) {
            try {
                int i4 = (int) Double.parseDouble(obj2.toString());
                if (i4 > 0) {
                    builderAdNum.height(i4);
                }
            } catch (Throwable th2) {
                th2.printStackTrace();
            }
        }
        if (!TextUtils.isEmpty(this.f12482e)) {
            builderAdNum.setBidResponseV2(this.f12482e);
            builderAdNum.adNum(1);
        }
        KsScene ksSceneBuild = builderAdNum.build();
        if (TextUtils.equals("1", this.f12481d)) {
            KsAdSDK.getLoadManager().loadDrawAd(ksSceneBuild, new AnonymousClass2(context));
        } else if (TextUtils.equals("1", this.b)) {
            KsAdSDK.getLoadManager().loadConfigFeedAd(ksSceneBuild, new AnonymousClass3(context));
        } else {
            KsAdSDK.getLoadManager().loadNativeAd(ksSceneBuild, new AnonymousClass4(context));
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
        this.b = ATInitMediation.getStringFromMap(map, "layout_type", "0");
        if (map.containsKey("video_sound")) {
            this.f12480c = TextUtils.equals("1", ATInitMediation.getStringFromMap(map, "video_sound"));
        }
        this.f12481d = ATInitMediation.getStringFromMap(map, "unit_type", "0");
        this.f12485h = ATInitMediation.getDoubleFromMap(map, g.k.f6905o);
        if (!map.containsKey("payload")) {
            return true;
        }
        this.f12482e = KSATInitManager.getInstance().getPayloadInfo(ATInitMediation.getStringFromMap(map, "payload"), this.f12485h);
        return true;
    }

    static /* synthetic */ void a(KSATAdapter kSATAdapter, Context context, Map map, int i2) {
        Object obj = map.containsKey(ATAdConst.KEY.AD_WIDTH) ? map.get(ATAdConst.KEY.AD_WIDTH) : null;
        Object obj2 = map.containsKey(ATAdConst.KEY.AD_HEIGHT) ? map.get(ATAdConst.KEY.AD_HEIGHT) : null;
        KsScene.Builder builderAdNum = new KsScene.Builder(kSATAdapter.a).adNum(kSATAdapter.f12484g ? 1 : Math.min(i2, 5));
        if (obj != null) {
            try {
                int i3 = (int) Double.parseDouble(obj.toString());
                if (i3 > 0) {
                    builderAdNum.width(i3);
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
        if (obj2 != null) {
            try {
                int i4 = (int) Double.parseDouble(obj2.toString());
                if (i4 > 0) {
                    builderAdNum.height(i4);
                }
            } catch (Throwable th2) {
                th2.printStackTrace();
            }
        }
        if (!TextUtils.isEmpty(kSATAdapter.f12482e)) {
            builderAdNum.setBidResponseV2(kSATAdapter.f12482e);
            builderAdNum.adNum(1);
        }
        KsScene ksSceneBuild = builderAdNum.build();
        if (TextUtils.equals("1", kSATAdapter.f12481d)) {
            KsAdSDK.getLoadManager().loadDrawAd(ksSceneBuild, kSATAdapter.new AnonymousClass2(context));
        } else if (TextUtils.equals("1", kSATAdapter.b)) {
            KsAdSDK.getLoadManager().loadConfigFeedAd(ksSceneBuild, kSATAdapter.new AnonymousClass3(context));
        } else {
            KsAdSDK.getLoadManager().loadNativeAd(ksSceneBuild, kSATAdapter.new AnonymousClass4(context));
        }
    }
}
