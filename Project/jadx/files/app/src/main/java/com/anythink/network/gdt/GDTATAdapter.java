package com.anythink.network.gdt;

import android.content.Context;
import android.text.TextUtils;
import com.anythink.core.api.ATAdConst;
import com.anythink.core.api.ATBaseAdAdapter;
import com.anythink.core.api.ATBidRequestInfoListener;
import com.anythink.core.api.ATBiddingListener;
import com.anythink.core.api.ATBiddingResult;
import com.anythink.core.api.ATInitMediation;
import com.anythink.core.api.MediationInitCallback;
import com.anythink.nativead.unitgroup.api.CustomNativeAd;
import com.anythink.nativead.unitgroup.api.CustomNativeAdapter;
import com.qq.e.ads.nativ.NativeADUnifiedListener;
import com.qq.e.ads.nativ.NativeUnifiedAD;
import com.qq.e.ads.nativ.NativeUnifiedADData;
import com.qq.e.comm.util.AdError;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public class GDTATAdapter extends CustomNativeAdapter {
    String a;
    String b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    int f12410c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    String f12411d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    int f12412e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    int f12413f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    int f12414g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    int f12415h;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private int f12417j = -1;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private int f12418k = -2;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    boolean f12416i = false;

    /* JADX INFO: renamed from: com.anythink.network.gdt.GDTATAdapter$1, reason: invalid class name */
    final class AnonymousClass1 implements a {
        AnonymousClass1() {
        }

        @Override // com.anythink.network.gdt.a
        public final void notifyError(String str, String str2) {
            GDTATAdapter.this.notifyATLoadFail(str, str2);
        }

        @Override // com.anythink.network.gdt.a
        public final void notifyLoaded(CustomNativeAd... customNativeAdArr) {
            GDTATAdapter gDTATAdapter = GDTATAdapter.this;
            if (!gDTATAdapter.f12416i || !(customNativeAdArr[0] instanceof GDTATNativeExpressAd)) {
                if (((ATBaseAdAdapter) GDTATAdapter.this).mLoadListener != null) {
                    ((ATBaseAdAdapter) GDTATAdapter.this).mLoadListener.onAdCacheLoaded(customNativeAdArr);
                    return;
                }
                return;
            }
            GDTATNativeExpressAd gDTATNativeExpressAd = (GDTATNativeExpressAd) customNativeAdArr[0];
            if (gDTATAdapter.mBiddingListener != null) {
                double ecpm = gDTATNativeExpressAd.b.getECPM();
                GDTATBiddingNotice gDTATBiddingNotice = new GDTATBiddingNotice(gDTATNativeExpressAd);
                ATBiddingListener aTBiddingListener = GDTATAdapter.this.mBiddingListener;
                StringBuilder sb = new StringBuilder();
                sb.append(System.currentTimeMillis());
                aTBiddingListener.onC2SBiddingResultWithCache(ATBiddingResult.success(ecpm, sb.toString(), gDTATBiddingNotice, ATAdConst.CURRENCY.RMB_CENT), gDTATNativeExpressAd);
            }
        }
    }

    /* JADX INFO: renamed from: com.anythink.network.gdt.GDTATAdapter$2, reason: invalid class name */
    final class AnonymousClass2 implements NativeADUnifiedListener {
        final /* synthetic */ Context a;

        AnonymousClass2(Context context) {
            this.a = context;
        }

        @Override // com.qq.e.ads.nativ.NativeADUnifiedListener
        public final void onADLoaded(List<NativeUnifiedADData> list) {
            ArrayList arrayList = new ArrayList();
            if (list == null || list.size() <= 0) {
                GDTATAdapter.this.notifyATLoadFail("", "Ad list is empty");
                return;
            }
            GDTATNativePatchAd gDTATNativePatchAd = null;
            GDTATNativeAd gDTATNativeAd = null;
            for (NativeUnifiedADData nativeUnifiedADData : list) {
                GDTATAdapter gDTATAdapter = GDTATAdapter.this;
                if (gDTATAdapter.f12412e == 4) {
                    gDTATNativePatchAd = new GDTATNativePatchAd(this.a, nativeUnifiedADData, gDTATAdapter.f12413f, gDTATAdapter.f12414g, gDTATAdapter.f12415h);
                    arrayList.add(gDTATNativePatchAd);
                } else {
                    gDTATNativeAd = new GDTATNativeAd(this.a, nativeUnifiedADData, gDTATAdapter.f12413f, gDTATAdapter.f12414g, gDTATAdapter.f12415h);
                    arrayList.add(gDTATNativeAd);
                }
            }
            CustomNativeAd[] customNativeAdArr = (CustomNativeAd[]) arrayList.toArray(new CustomNativeAd[arrayList.size()]);
            GDTATAdapter gDTATAdapter2 = GDTATAdapter.this;
            if (!gDTATAdapter2.f12416i) {
                if (((ATBaseAdAdapter) gDTATAdapter2).mLoadListener != null) {
                    ((ATBaseAdAdapter) GDTATAdapter.this).mLoadListener.onAdCacheLoaded(customNativeAdArr);
                    return;
                }
                return;
            }
            if (gDTATAdapter2.mBiddingListener != null) {
                if (gDTATAdapter2.f12412e == 4 && gDTATNativePatchAd != null) {
                    double ecpm = gDTATNativePatchAd.f12446c.getECPM();
                    GDTATBiddingNotice gDTATBiddingNotice = new GDTATBiddingNotice(gDTATNativePatchAd);
                    ATBiddingListener aTBiddingListener = GDTATAdapter.this.mBiddingListener;
                    StringBuilder sb = new StringBuilder();
                    sb.append(System.currentTimeMillis());
                    aTBiddingListener.onC2SBiddingResultWithCache(ATBiddingResult.success(ecpm, sb.toString(), gDTATBiddingNotice, ATAdConst.CURRENCY.RMB_CENT), gDTATNativePatchAd);
                    return;
                }
                if (gDTATNativeAd != null) {
                    double ecpm2 = gDTATNativeAd.f12446c.getECPM();
                    GDTATBiddingNotice gDTATBiddingNotice2 = new GDTATBiddingNotice(gDTATNativeAd);
                    ATBiddingListener aTBiddingListener2 = GDTATAdapter.this.mBiddingListener;
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append(System.currentTimeMillis());
                    aTBiddingListener2.onC2SBiddingResultWithCache(ATBiddingResult.success(ecpm2, sb2.toString(), gDTATBiddingNotice2, ATAdConst.CURRENCY.RMB_CENT), gDTATNativeAd);
                }
            }
        }

        @Override // com.qq.e.ads.NativeAbstractAD.BasicADListener
        public final void onNoAD(AdError adError) {
            GDTATAdapter gDTATAdapter = GDTATAdapter.this;
            StringBuilder sb = new StringBuilder();
            sb.append(adError.getErrorCode());
            gDTATAdapter.notifyATLoadFail(sb.toString(), adError.getErrorMsg());
        }
    }

    @Override // com.anythink.core.api.ATBaseAdAdapter
    public void destory() {
    }

    @Override // com.anythink.core.api.ATBaseAdAdapter
    public void getBidRequestInfo(Context context, Map<String, Object> map, Map<String, Object> map2, ATBidRequestInfoListener aTBidRequestInfoListener) {
        this.b = ATInitMediation.getStringFromMap(map, "unit_id");
        GDTATInitManager.getInstance().a(context, map, map2, aTBidRequestInfoListener);
    }

    @Override // com.anythink.core.api.ATBaseAdAdapter
    public ATInitMediation getMediationInitManager() {
        return GDTATInitManager.getInstance();
    }

    @Override // com.anythink.core.api.ATBaseAdAdapter
    public String getNetworkName() {
        return GDTATInitManager.getInstance().getNetworkName();
    }

    @Override // com.anythink.core.api.ATBaseAdAdapter
    public String getNetworkPlacementId() {
        return this.b;
    }

    @Override // com.anythink.core.api.ATBaseAdAdapter
    public String getNetworkSDKVersion() {
        return GDTATInitManager.getInstance().getNetworkVersion();
    }

    @Override // com.anythink.core.api.ATBaseAdAdapter
    public void loadCustomNetworkAd(final Context context, final Map<String, Object> map, Map<String, Object> map2) {
        this.a = ATInitMediation.getStringFromMap(map, "app_id");
        this.b = ATInitMediation.getStringFromMap(map, "unit_id");
        this.f12412e = ATInitMediation.getIntFromMap(map, "unit_type");
        this.f12411d = ATInitMediation.getStringFromMap(map, "payload");
        this.f12410c = this.f12416i ? 1 : this.mRequestNum;
        try {
            this.f12417j = ATInitMediation.getIntFromMap(map2, ATAdConst.KEY.AD_WIDTH, -1);
            if (map2.containsKey(GDTATConst.AD_HEIGHT)) {
                this.f12418k = ATInitMediation.getIntFromMap(map2, GDTATConst.AD_HEIGHT, -2);
            } else if (map2.containsKey(ATAdConst.KEY.AD_HEIGHT)) {
                this.f12418k = ATInitMediation.getIntFromMap(map2, ATAdConst.KEY.AD_HEIGHT, -2);
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        int intFromMap = ATInitMediation.getIntFromMap(map, "video_muted", 0);
        int intFromMap2 = ATInitMediation.getIntFromMap(map, "video_autoplay", 1);
        int intFromMap3 = ATInitMediation.getIntFromMap(map, "video_duration", -1);
        this.f12413f = intFromMap;
        this.f12414g = intFromMap2;
        this.f12415h = intFromMap3;
        if (TextUtils.isEmpty(this.a) || TextUtils.isEmpty(this.b)) {
            notifyATLoadFail("", "GTD appid or unitId is empty.");
        } else {
            GDTATInitManager.getInstance().initSDK(context, map, new MediationInitCallback() { // from class: com.anythink.network.gdt.GDTATAdapter.3
                @Override // com.anythink.core.api.MediationInitCallback
                public final void onFail(String str) {
                    GDTATAdapter.this.notifyATLoadFail("", str);
                }

                @Override // com.anythink.core.api.MediationInitCallback
                public final void onSuccess() {
                    GDTATAdapter.a(GDTATAdapter.this, context, map);
                }
            });
        }
    }

    @Override // com.anythink.core.api.ATBaseAdAdapter
    public boolean startBiddingRequest(Context context, Map<String, Object> map, Map<String, Object> map2, ATBiddingListener aTBiddingListener) {
        this.f12416i = true;
        loadCustomNetworkAd(context, map, map2);
        return true;
    }

    private void a(Context context, Map<String, Object> map) {
        try {
            int i2 = this.f12412e;
            if (i2 != 2 && i2 != 4) {
                AnonymousClass1 anonymousClass1 = new AnonymousClass1();
                if (this.f12412e == 3) {
                    GDTATNativeExpressPatchAd gDTATNativeExpressPatchAd = new GDTATNativeExpressPatchAd(context, this.b, this.f12417j, this.f12418k, this.f12413f, this.f12414g, this.f12415h, this.f12411d);
                    GDTATInitManager.getInstance();
                    gDTATNativeExpressPatchAd.a(anonymousClass1, GDTATInitManager.a(map));
                    return;
                } else {
                    GDTATNativeExpressAd gDTATNativeExpressAd = new GDTATNativeExpressAd(context, this.b, this.f12417j, this.f12418k, this.f12413f, this.f12414g, this.f12415h, this.f12411d);
                    GDTATInitManager.getInstance();
                    gDTATNativeExpressAd.a(anonymousClass1, GDTATInitManager.a(map));
                    return;
                }
            }
            Context applicationContext = context.getApplicationContext();
            AnonymousClass2 anonymousClass2 = new AnonymousClass2(applicationContext);
            NativeUnifiedAD nativeUnifiedAD = TextUtils.isEmpty(this.f12411d) ? new NativeUnifiedAD(applicationContext, this.b, anonymousClass2) : new NativeUnifiedAD(applicationContext, this.b, anonymousClass2, this.f12411d);
            if (this.f12415h != -1) {
                nativeUnifiedAD.setMaxVideoDuration(this.f12415h);
            }
            if (!TextUtils.isEmpty(this.f12411d)) {
                nativeUnifiedAD.loadData(this.f12410c);
                return;
            }
            int i3 = this.f12410c;
            GDTATInitManager.getInstance();
            nativeUnifiedAD.loadData(i3, GDTATInitManager.a(map));
        } catch (Throwable th) {
            notifyATLoadFail("", th.getMessage());
        }
    }

    private void b(Context context, Map<String, Object> map) {
        AnonymousClass2 anonymousClass2 = new AnonymousClass2(context);
        NativeUnifiedAD nativeUnifiedAD = TextUtils.isEmpty(this.f12411d) ? new NativeUnifiedAD(context, this.b, anonymousClass2) : new NativeUnifiedAD(context, this.b, anonymousClass2, this.f12411d);
        int i2 = this.f12415h;
        if (i2 != -1) {
            nativeUnifiedAD.setMaxVideoDuration(i2);
        }
        if (!TextUtils.isEmpty(this.f12411d)) {
            nativeUnifiedAD.loadData(this.f12410c);
            return;
        }
        int i3 = this.f12410c;
        GDTATInitManager.getInstance();
        nativeUnifiedAD.loadData(i3, GDTATInitManager.a(map));
    }

    private void a(Map<String, Object> map, Map<String, Object> map2) {
        this.a = ATInitMediation.getStringFromMap(map, "app_id");
        this.b = ATInitMediation.getStringFromMap(map, "unit_id");
        this.f12412e = ATInitMediation.getIntFromMap(map, "unit_type");
        this.f12411d = ATInitMediation.getStringFromMap(map, "payload");
        this.f12410c = this.f12416i ? 1 : this.mRequestNum;
        try {
            this.f12417j = ATInitMediation.getIntFromMap(map2, ATAdConst.KEY.AD_WIDTH, -1);
            if (map2.containsKey(GDTATConst.AD_HEIGHT)) {
                this.f12418k = ATInitMediation.getIntFromMap(map2, GDTATConst.AD_HEIGHT, -2);
            } else if (map2.containsKey(ATAdConst.KEY.AD_HEIGHT)) {
                this.f12418k = ATInitMediation.getIntFromMap(map2, ATAdConst.KEY.AD_HEIGHT, -2);
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        int intFromMap = ATInitMediation.getIntFromMap(map, "video_muted", 0);
        int intFromMap2 = ATInitMediation.getIntFromMap(map, "video_autoplay", 1);
        int intFromMap3 = ATInitMediation.getIntFromMap(map, "video_duration", -1);
        this.f12413f = intFromMap;
        this.f12414g = intFromMap2;
        this.f12415h = intFromMap3;
    }

    static /* synthetic */ void a(GDTATAdapter gDTATAdapter, Context context, Map map) {
        NativeUnifiedAD nativeUnifiedAD;
        try {
            int i2 = gDTATAdapter.f12412e;
            if (i2 != 2 && i2 != 4) {
                AnonymousClass1 anonymousClass1 = gDTATAdapter.new AnonymousClass1();
                if (gDTATAdapter.f12412e == 3) {
                    GDTATNativeExpressPatchAd gDTATNativeExpressPatchAd = new GDTATNativeExpressPatchAd(context, gDTATAdapter.b, gDTATAdapter.f12417j, gDTATAdapter.f12418k, gDTATAdapter.f12413f, gDTATAdapter.f12414g, gDTATAdapter.f12415h, gDTATAdapter.f12411d);
                    GDTATInitManager.getInstance();
                    gDTATNativeExpressPatchAd.a(anonymousClass1, GDTATInitManager.a((Map<String, Object>) map));
                    return;
                } else {
                    GDTATNativeExpressAd gDTATNativeExpressAd = new GDTATNativeExpressAd(context, gDTATAdapter.b, gDTATAdapter.f12417j, gDTATAdapter.f12418k, gDTATAdapter.f12413f, gDTATAdapter.f12414g, gDTATAdapter.f12415h, gDTATAdapter.f12411d);
                    GDTATInitManager.getInstance();
                    gDTATNativeExpressAd.a(anonymousClass1, GDTATInitManager.a((Map<String, Object>) map));
                    return;
                }
            }
            Context applicationContext = context.getApplicationContext();
            AnonymousClass2 anonymousClass2 = gDTATAdapter.new AnonymousClass2(applicationContext);
            if (TextUtils.isEmpty(gDTATAdapter.f12411d)) {
                nativeUnifiedAD = new NativeUnifiedAD(applicationContext, gDTATAdapter.b, anonymousClass2);
            } else {
                nativeUnifiedAD = new NativeUnifiedAD(applicationContext, gDTATAdapter.b, anonymousClass2, gDTATAdapter.f12411d);
            }
            if (gDTATAdapter.f12415h != -1) {
                nativeUnifiedAD.setMaxVideoDuration(gDTATAdapter.f12415h);
            }
            if (TextUtils.isEmpty(gDTATAdapter.f12411d)) {
                int i3 = gDTATAdapter.f12410c;
                GDTATInitManager.getInstance();
                nativeUnifiedAD.loadData(i3, GDTATInitManager.a((Map<String, Object>) map));
                return;
            }
            nativeUnifiedAD.loadData(gDTATAdapter.f12410c);
        } catch (Throwable th) {
            gDTATAdapter.notifyATLoadFail("", th.getMessage());
        }
    }
}
