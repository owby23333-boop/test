package com.anythink.network.baidu;

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
import com.anythink.nativead.unitgroup.api.CustomNativeAd;
import com.anythink.nativead.unitgroup.api.CustomNativeAdapter;
import com.anythink.network.baidu.BaiduATNativePortraitVideoAd;
import com.baidu.mobads.sdk.api.BaiduNativeManager;
import com.baidu.mobads.sdk.api.ExpressResponse;
import com.baidu.mobads.sdk.api.NativeResponse;
import com.baidu.mobads.sdk.api.RequestParameters;
import com.baidu.mobads.sdk.api.StyleParams;
import com.bytedance.msdk.adapter.pangle.PangleAdapterUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public class BaiduATAdapter extends CustomNativeAdapter {
    String a;
    String b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    String f12331c;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private BaiduNativeManager f12337i;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private double f12336h = PangleAdapterUtils.CPM_DEFLAUT_VALUE;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    StyleParams.Builder f12332d = new StyleParams.Builder();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    int f12333e = 0;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    boolean f12334f = false;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    boolean f12335g = true;

    /* JADX INFO: renamed from: com.anythink.network.baidu.BaiduATAdapter$2, reason: invalid class name */
    final class AnonymousClass2 implements BaiduATNativePortraitVideoAd.LoadCallbackListener {
        final /* synthetic */ Context a;

        AnonymousClass2(Context context) {
            this.a = context;
        }

        @Override // com.anythink.network.baidu.BaiduATNativePortraitVideoAd.LoadCallbackListener
        public final void onFail(String str, String str2) {
            BaiduATAdapter.this.notifyATLoadFail(str, str2);
        }

        @Override // com.anythink.network.baidu.BaiduATNativePortraitVideoAd.LoadCallbackListener
        public final void onSuccess(NativeResponse nativeResponse, CustomNativeAd customNativeAd) {
            ArrayList arrayList = new ArrayList();
            arrayList.add(nativeResponse);
            BaiduATAdapter.a(BaiduATAdapter.this, arrayList, this.a, customNativeAd);
        }
    }

    private class a implements BaiduNativeManager.ExpressAdListener {
        private final Context b;

        public a(Context context) {
            this.b = context;
        }

        @Override // com.baidu.mobads.sdk.api.BaiduNativeManager.ExpressAdListener
        public final void onLpClosed() {
        }

        @Override // com.baidu.mobads.sdk.api.BaiduNativeManager.ExpressAdListener
        public final void onNativeFail(int i2, String str) {
            BaiduATAdapter.this.notifyATLoadFail(String.valueOf(i2), str);
        }

        @Override // com.baidu.mobads.sdk.api.BaiduNativeManager.ExpressAdListener
        public final void onNativeLoad(List<ExpressResponse> list) {
            if (list == null || list.size() == 0) {
                BaiduATAdapter.this.notifyATLoadFail("", "Baidu ad return empty.");
                return;
            }
            if (!BaiduATAdapter.this.f12334f) {
                ArrayList arrayList = new ArrayList();
                Iterator<ExpressResponse> it = list.iterator();
                while (it.hasNext()) {
                    arrayList.add(new BaiduATNativeExpressFeedAd(this.b, it.next()));
                }
                CustomNativeAd[] customNativeAdArr = (CustomNativeAd[]) arrayList.toArray(new CustomNativeAd[arrayList.size()]);
                if (((ATBaseAdAdapter) BaiduATAdapter.this).mLoadListener != null) {
                    ((ATBaseAdAdapter) BaiduATAdapter.this).mLoadListener.onAdCacheLoaded(customNativeAdArr);
                    return;
                }
                return;
            }
            ExpressResponse expressResponse = list.get(0);
            BaiduATNativeExpressFeedAd baiduATNativeExpressFeedAd = new BaiduATNativeExpressFeedAd(this.b, expressResponse);
            BaiduATBiddingNotice baiduATBiddingNotice = new BaiduATBiddingNotice(expressResponse);
            double d2 = PangleAdapterUtils.CPM_DEFLAUT_VALUE;
            try {
                d2 = Double.parseDouble(expressResponse.getECPMLevel());
            } catch (Throwable unused) {
            }
            ATBiddingListener aTBiddingListener = BaiduATAdapter.this.mBiddingListener;
            if (aTBiddingListener != null) {
                StringBuilder sb = new StringBuilder();
                sb.append(expressResponse.hashCode());
                aTBiddingListener.onC2SBiddingResultWithCache(ATBiddingResult.success(d2, sb.toString(), baiduATBiddingNotice, ATAdConst.CURRENCY.RMB_CENT), baiduATNativeExpressFeedAd);
            }
        }

        @Override // com.baidu.mobads.sdk.api.BaiduNativeManager.ExpressAdListener
        public final void onNoAd(int i2, String str) {
            BaiduATAdapter.this.notifyATLoadFail(String.valueOf(i2), str);
        }

        @Override // com.baidu.mobads.sdk.api.BaiduNativeManager.ExpressAdListener
        public final void onVideoDownloadFailed() {
        }

        @Override // com.baidu.mobads.sdk.api.BaiduNativeManager.ExpressAdListener
        public final void onVideoDownloadSuccess() {
        }
    }

    private class b implements BaiduNativeManager.FeedAdListener {
        private final Context b;

        public b(Context context) {
            this.b = context;
        }

        @Override // com.baidu.mobads.sdk.api.BaiduNativeManager.FeedAdListener
        public final void onLpClosed() {
        }

        @Override // com.baidu.mobads.sdk.api.BaiduNativeManager.FeedAdListener
        public final void onNativeFail(int i2, String str) {
            BaiduATAdapter.this.notifyATLoadFail(String.valueOf(i2), str);
        }

        @Override // com.baidu.mobads.sdk.api.BaiduNativeManager.FeedAdListener
        public final void onNativeLoad(List<NativeResponse> list) {
            if (list == null || list.size() == 0) {
                BaiduATAdapter.this.notifyATLoadFail("", "callback onNativeLoad but no ad");
            } else {
                BaiduATAdapter.a(BaiduATAdapter.this, list, this.b, null);
            }
        }

        @Override // com.baidu.mobads.sdk.api.BaiduNativeManager.FeedAdListener
        public final void onNoAd(int i2, String str) {
            BaiduATAdapter.this.notifyATLoadFail(String.valueOf(i2), str);
        }

        @Override // com.baidu.mobads.sdk.api.BaiduNativeManager.FeedAdListener
        public final void onVideoDownloadFailed() {
        }

        @Override // com.baidu.mobads.sdk.api.BaiduNativeManager.FeedAdListener
        public final void onVideoDownloadSuccess() {
        }
    }

    @Override // com.anythink.core.api.ATBaseAdAdapter
    public void destory() {
    }

    @Override // com.anythink.core.api.ATBaseAdAdapter
    public String getNetworkName() {
        return BaiduATInitManager.getInstance().getNetworkName();
    }

    @Override // com.anythink.core.api.ATBaseAdAdapter
    public String getNetworkPlacementId() {
        return this.b;
    }

    @Override // com.anythink.core.api.ATBaseAdAdapter
    public String getNetworkSDKVersion() {
        return BaiduATInitManager.getInstance().getNetworkVersion();
    }

    @Override // com.anythink.core.api.ATBaseAdAdapter
    public void loadCustomNetworkAd(Context context, Map<String, Object> map, Map<String, Object> map2) {
        this.a = ATInitMediation.getStringFromMap(map, "app_id");
        this.b = ATInitMediation.getStringFromMap(map, "ad_place_id");
        this.f12331c = ATInitMediation.getStringFromMap(map, "payload");
        this.f12333e = ATInitMediation.getIntFromMap(map, "unit_type");
        this.f12336h = ATInitMediation.getDoubleFromMap(map, "bid_floor");
        try {
            if (map2.containsKey(BaiduATConst.STYLE_BUILDER)) {
                Object obj = map2.get(BaiduATConst.STYLE_BUILDER);
                if (obj instanceof StyleParams.Builder) {
                    this.f12332d = (StyleParams.Builder) obj;
                }
            }
            if (map.containsKey("cta_button")) {
                this.f12332d.setShowActionButton(ATInitMediation.getStringFromMap(map, "cta_button").equals("1"));
            }
            if (map.containsKey("button_type")) {
                this.f12332d.setRegionClick(ATInitMediation.getStringFromMap(map, "button_type").equals("2"));
            }
            if (map.containsKey("dl_type")) {
                this.f12332d.setShowDialogFrame(ATInitMediation.getStringFromMap(map, "dl_type").equals("2"));
            }
            boolean z2 = true;
            if (ATInitMediation.getIntFromMap(map, "video_autoplay", 1) != 1) {
                z2 = false;
            }
            this.f12335g = z2;
        } catch (Exception e2) {
            BaiduATInitManager.printLog("initRequestParams() >>> " + e2.getMessage());
        }
        if (TextUtils.isEmpty(this.a) || TextUtils.isEmpty(this.b)) {
            notifyATLoadFail("", "app_id or ad_place_id is empty.");
        } else {
            final Context applicationContext = context.getApplicationContext();
            BaiduATInitManager.getInstance().initSDK(applicationContext, map, new MediationInitCallback() { // from class: com.anythink.network.baidu.BaiduATAdapter.1
                @Override // com.anythink.core.api.MediationInitCallback
                public final void onFail(String str) {
                    BaiduATAdapter.this.notifyATLoadFail("", str);
                }

                @Override // com.anythink.core.api.MediationInitCallback
                public final void onSuccess() {
                    try {
                        BaiduATAdapter.a(BaiduATAdapter.this, applicationContext);
                    } catch (Throwable th) {
                        BaiduATAdapter.this.notifyATLoadFail("", "Baidu: init error, " + th.getMessage());
                    }
                }
            });
        }
    }

    @Override // com.anythink.core.api.ATBaseAdAdapter
    public boolean startBiddingRequest(Context context, Map<String, Object> map, Map<String, Object> map2, ATBiddingListener aTBiddingListener) {
        this.f12334f = true;
        loadCustomNetworkAd(context, map, map2);
        return true;
    }

    private void a(Map<String, Object> map, Map<String, Object> map2) {
        this.a = ATInitMediation.getStringFromMap(map, "app_id");
        this.b = ATInitMediation.getStringFromMap(map, "ad_place_id");
        this.f12331c = ATInitMediation.getStringFromMap(map, "payload");
        this.f12333e = ATInitMediation.getIntFromMap(map, "unit_type");
        this.f12336h = ATInitMediation.getDoubleFromMap(map, "bid_floor");
        try {
            if (map2.containsKey(BaiduATConst.STYLE_BUILDER)) {
                Object obj = map2.get(BaiduATConst.STYLE_BUILDER);
                if (obj instanceof StyleParams.Builder) {
                    this.f12332d = (StyleParams.Builder) obj;
                }
            }
            if (map.containsKey("cta_button")) {
                this.f12332d.setShowActionButton(ATInitMediation.getStringFromMap(map, "cta_button").equals("1"));
            }
            if (map.containsKey("button_type")) {
                this.f12332d.setRegionClick(ATInitMediation.getStringFromMap(map, "button_type").equals("2"));
            }
            if (map.containsKey("dl_type")) {
                this.f12332d.setShowDialogFrame(ATInitMediation.getStringFromMap(map, "dl_type").equals("2"));
            }
            boolean z2 = true;
            if (ATInitMediation.getIntFromMap(map, "video_autoplay", 1) != 1) {
                z2 = false;
            }
            this.f12335g = z2;
        } catch (Exception e2) {
            BaiduATInitManager.printLog("initRequestParams() >>> " + e2.getMessage());
        }
    }

    private void a(Context context) {
        this.f12337i = new BaiduNativeManager(context, this.b);
        RequestParameters requestParametersBuild = new RequestParameters.Builder().downloadAppConfirmPolicy(3).build();
        if (this.f12334f && this.f12336h > PangleAdapterUtils.CPM_DEFLAUT_VALUE) {
            if (ATSDK.isNetworkLogDebug()) {
                String str = "setBidFloor:" + ((int) this.f12336h);
            }
            this.f12337i.setBidFloor((int) this.f12336h);
        }
        int i2 = this.f12333e;
        if (i2 == 3) {
            new BaiduATNativePortraitVideoAd(context, this.f12337i, requestParametersBuild, this.f12335g).load(new AnonymousClass2(context));
        } else if (i2 == 2) {
            this.f12337i.loadExpressAd(requestParametersBuild, new a(context));
        } else {
            this.f12337i.loadFeedAd(requestParametersBuild, new b(context));
        }
    }

    private void a(List<NativeResponse> list, Context context, CustomNativeAd customNativeAd) {
        BaseAd baiduATNativeAd;
        ArrayList arrayList = new ArrayList();
        StyleParams styleParamsBuild = this.f12332d.build();
        if (this.f12334f) {
            NativeResponse nativeResponse = list.get(0);
            int i2 = this.f12333e;
            if (i2 != 3) {
                if (i2 == 1) {
                    customNativeAd = new BaiduATNativeExpressAd(context, nativeResponse, styleParamsBuild);
                } else {
                    customNativeAd = new BaiduATNativeAd(context, nativeResponse);
                }
            }
            BaiduATBiddingNotice baiduATBiddingNotice = new BaiduATBiddingNotice(nativeResponse);
            double d2 = PangleAdapterUtils.CPM_DEFLAUT_VALUE;
            try {
                d2 = Double.parseDouble(nativeResponse.getECPMLevel());
            } catch (Throwable th) {
                th.printStackTrace();
            }
            ATBiddingListener aTBiddingListener = this.mBiddingListener;
            if (aTBiddingListener != null) {
                StringBuilder sb = new StringBuilder();
                sb.append(nativeResponse.hashCode());
                aTBiddingListener.onC2SBiddingResultWithCache(ATBiddingResult.success(d2, sb.toString(), baiduATBiddingNotice, ATAdConst.CURRENCY.RMB_CENT), customNativeAd);
                return;
            }
            return;
        }
        if (this.f12333e == 3) {
            arrayList.add(customNativeAd);
        } else {
            for (NativeResponse nativeResponse2 : list) {
                if (this.f12333e == 1) {
                    baiduATNativeAd = new BaiduATNativeExpressAd(context, nativeResponse2, styleParamsBuild);
                } else {
                    baiduATNativeAd = new BaiduATNativeAd(context, nativeResponse2);
                }
                arrayList.add(baiduATNativeAd);
            }
        }
        CustomNativeAd[] customNativeAdArr = (CustomNativeAd[]) arrayList.toArray(new CustomNativeAd[arrayList.size()]);
        ATCustomLoadListener aTCustomLoadListener = this.mLoadListener;
        if (aTCustomLoadListener != null) {
            aTCustomLoadListener.onAdCacheLoaded(customNativeAdArr);
        }
    }

    static /* synthetic */ void a(BaiduATAdapter baiduATAdapter, Context context) {
        baiduATAdapter.f12337i = new BaiduNativeManager(context, baiduATAdapter.b);
        RequestParameters requestParametersBuild = new RequestParameters.Builder().downloadAppConfirmPolicy(3).build();
        if (baiduATAdapter.f12334f && baiduATAdapter.f12336h > PangleAdapterUtils.CPM_DEFLAUT_VALUE) {
            if (ATSDK.isNetworkLogDebug()) {
                String str = "setBidFloor:" + ((int) baiduATAdapter.f12336h);
            }
            baiduATAdapter.f12337i.setBidFloor((int) baiduATAdapter.f12336h);
        }
        int i2 = baiduATAdapter.f12333e;
        if (i2 == 3) {
            new BaiduATNativePortraitVideoAd(context, baiduATAdapter.f12337i, requestParametersBuild, baiduATAdapter.f12335g).load(baiduATAdapter.new AnonymousClass2(context));
        } else if (i2 == 2) {
            baiduATAdapter.f12337i.loadExpressAd(requestParametersBuild, baiduATAdapter.new a(context));
        } else {
            baiduATAdapter.f12337i.loadFeedAd(requestParametersBuild, baiduATAdapter.new b(context));
        }
    }

    static /* synthetic */ void a(BaiduATAdapter baiduATAdapter, List list, Context context, CustomNativeAd customNativeAd) {
        BaseAd baiduATNativeAd;
        ArrayList arrayList = new ArrayList();
        StyleParams styleParamsBuild = baiduATAdapter.f12332d.build();
        if (baiduATAdapter.f12334f) {
            NativeResponse nativeResponse = (NativeResponse) list.get(0);
            int i2 = baiduATAdapter.f12333e;
            if (i2 != 3) {
                if (i2 == 1) {
                    customNativeAd = new BaiduATNativeExpressAd(context, nativeResponse, styleParamsBuild);
                } else {
                    customNativeAd = new BaiduATNativeAd(context, nativeResponse);
                }
            }
            BaiduATBiddingNotice baiduATBiddingNotice = new BaiduATBiddingNotice(nativeResponse);
            double d2 = PangleAdapterUtils.CPM_DEFLAUT_VALUE;
            try {
                d2 = Double.parseDouble(nativeResponse.getECPMLevel());
            } catch (Throwable th) {
                th.printStackTrace();
            }
            ATBiddingListener aTBiddingListener = baiduATAdapter.mBiddingListener;
            if (aTBiddingListener != null) {
                StringBuilder sb = new StringBuilder();
                sb.append(nativeResponse.hashCode());
                aTBiddingListener.onC2SBiddingResultWithCache(ATBiddingResult.success(d2, sb.toString(), baiduATBiddingNotice, ATAdConst.CURRENCY.RMB_CENT), customNativeAd);
                return;
            }
            return;
        }
        if (baiduATAdapter.f12333e == 3) {
            arrayList.add(customNativeAd);
        } else {
            Iterator it = list.iterator();
            while (it.hasNext()) {
                NativeResponse nativeResponse2 = (NativeResponse) it.next();
                if (baiduATAdapter.f12333e == 1) {
                    baiduATNativeAd = new BaiduATNativeExpressAd(context, nativeResponse2, styleParamsBuild);
                } else {
                    baiduATNativeAd = new BaiduATNativeAd(context, nativeResponse2);
                }
                arrayList.add(baiduATNativeAd);
            }
        }
        CustomNativeAd[] customNativeAdArr = (CustomNativeAd[]) arrayList.toArray(new CustomNativeAd[arrayList.size()]);
        ATCustomLoadListener aTCustomLoadListener = baiduATAdapter.mLoadListener;
        if (aTCustomLoadListener != null) {
            aTCustomLoadListener.onAdCacheLoaded(customNativeAdArr);
        }
    }
}
