package com.anythink.network.gdt;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.widget.FrameLayout;
import com.anythink.banner.unitgroup.api.CustomBannerAdapter;
import com.anythink.core.api.ATAdConst;
import com.anythink.core.api.ATBaseAdAdapter;
import com.anythink.core.api.ATBidRequestInfoListener;
import com.anythink.core.api.ATBiddingListener;
import com.anythink.core.api.ATBiddingResult;
import com.anythink.core.api.ATInitMediation;
import com.anythink.core.api.BaseAd;
import com.anythink.core.api.MediationInitCallback;
import com.qq.e.ads.banner2.UnifiedBannerADListener;
import com.qq.e.ads.banner2.UnifiedBannerView;
import com.qq.e.comm.compliance.DownloadConfirmCallBack;
import com.qq.e.comm.compliance.DownloadConfirmListener;
import com.qq.e.comm.util.AdError;
import java.lang.ref.WeakReference;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public class GDTATBannerAdapter extends CustomBannerAdapter {
    String a;
    String b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    String f12420c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    UnifiedBannerView f12421d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    int f12423f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    boolean f12424g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    boolean f12425h;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final String f12427j = GDTATBannerAdapter.class.getSimpleName();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    int f12422e = 0;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    DownloadConfirmListener f12426i = new DownloadConfirmListener() { // from class: com.anythink.network.gdt.GDTATBannerAdapter.1
        @Override // com.qq.e.comm.compliance.DownloadConfirmListener
        public final void onDownloadConfirm(Activity activity, int i2, String str, DownloadConfirmCallBack downloadConfirmCallBack) {
            if (((CustomBannerAdapter) GDTATBannerAdapter.this).mImpressionEventListener != null) {
                GDTDownloadFirmInfo gDTDownloadFirmInfo = new GDTDownloadFirmInfo();
                gDTDownloadFirmInfo.appInfoUrl = str;
                gDTDownloadFirmInfo.scenes = i2;
                gDTDownloadFirmInfo.confirmCallBack = downloadConfirmCallBack;
                ((CustomBannerAdapter) GDTATBannerAdapter.this).mImpressionEventListener.onDownloadConfirm(activity, gDTDownloadFirmInfo);
            }
        }
    };

    /* JADX INFO: renamed from: com.anythink.network.gdt.GDTATBannerAdapter$2, reason: invalid class name */
    final class AnonymousClass2 implements UnifiedBannerADListener {
        AnonymousClass2() {
        }

        @Override // com.qq.e.ads.banner2.UnifiedBannerADListener
        public final void onADClicked() {
            if (((CustomBannerAdapter) GDTATBannerAdapter.this).mImpressionEventListener != null) {
                ((CustomBannerAdapter) GDTATBannerAdapter.this).mImpressionEventListener.onBannerAdClicked();
            }
        }

        @Override // com.qq.e.ads.banner2.UnifiedBannerADListener
        public final void onADClosed() {
            if (((CustomBannerAdapter) GDTATBannerAdapter.this).mImpressionEventListener != null) {
                ((CustomBannerAdapter) GDTATBannerAdapter.this).mImpressionEventListener.onBannerAdClose();
            }
        }

        @Override // com.qq.e.ads.banner2.UnifiedBannerADListener
        public final void onADExposure() {
            try {
                GDTATInitManager.getInstance().a(GDTATBannerAdapter.this.getTrackingInfo().l(), new WeakReference(GDTATBannerAdapter.this.f12421d));
            } catch (Throwable unused) {
            }
            if (((CustomBannerAdapter) GDTATBannerAdapter.this).mImpressionEventListener != null) {
                ((CustomBannerAdapter) GDTATBannerAdapter.this).mImpressionEventListener.onBannerAdShow();
            }
        }

        @Override // com.qq.e.ads.banner2.UnifiedBannerADListener
        public final void onADLeftApplication() {
        }

        @Override // com.qq.e.ads.banner2.UnifiedBannerADListener
        public final void onADReceive() {
            UnifiedBannerView unifiedBannerView;
            GDTATBannerAdapter gDTATBannerAdapter = GDTATBannerAdapter.this;
            if (gDTATBannerAdapter.f12424g && (unifiedBannerView = gDTATBannerAdapter.f12421d) != null) {
                unifiedBannerView.setDownloadConfirmListener(gDTATBannerAdapter.f12426i);
            }
            GDTATBannerAdapter gDTATBannerAdapter2 = GDTATBannerAdapter.this;
            if (!gDTATBannerAdapter2.f12425h) {
                if (((ATBaseAdAdapter) gDTATBannerAdapter2).mLoadListener != null) {
                    ((ATBaseAdAdapter) GDTATBannerAdapter.this).mLoadListener.onAdCacheLoaded(new BaseAd[0]);
                }
            } else if (gDTATBannerAdapter2.mBiddingListener != null) {
                UnifiedBannerView unifiedBannerView2 = gDTATBannerAdapter2.f12421d;
                if (unifiedBannerView2 == null) {
                    gDTATBannerAdapter2.notifyATLoadFail("", "GDT: Offer had been destroy.");
                    return;
                }
                double ecpm = unifiedBannerView2.getECPM();
                GDTATBiddingNotice gDTATBiddingNotice = new GDTATBiddingNotice(GDTATBannerAdapter.this.f12421d);
                ATBiddingListener aTBiddingListener = GDTATBannerAdapter.this.mBiddingListener;
                StringBuilder sb = new StringBuilder();
                sb.append(System.currentTimeMillis());
                aTBiddingListener.onC2SBiddingResultWithCache(ATBiddingResult.success(ecpm, sb.toString(), gDTATBiddingNotice, ATAdConst.CURRENCY.RMB_CENT), null);
            }
        }

        @Override // com.qq.e.ads.banner2.UnifiedBannerADListener
        public final void onNoAD(AdError adError) {
            GDTATBannerAdapter gDTATBannerAdapter = GDTATBannerAdapter.this;
            gDTATBannerAdapter.f12421d = null;
            gDTATBannerAdapter.notifyATLoadFail(String.valueOf(adError.getErrorCode()), adError.getErrorMsg());
        }
    }

    @Override // com.anythink.core.api.ATBaseAdAdapter
    public void destory() {
        UnifiedBannerView unifiedBannerView = this.f12421d;
        if (unifiedBannerView != null) {
            if (unifiedBannerView instanceof UnifiedBannerView) {
                unifiedBannerView.destroy();
            }
            this.f12421d = null;
        }
    }

    @Override // com.anythink.banner.unitgroup.api.CustomBannerAdapter
    public View getBannerView() {
        return this.f12421d;
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
        this.f12422e = ATInitMediation.getIntFromMap(map, "unit_version");
        this.f12420c = ATInitMediation.getStringFromMap(map, "payload");
        this.f12424g = ATInitMediation.getBooleanFromMap(map2, ATAdConst.KEY.AD_CLICK_CONFIRM_STATUS, false);
        this.f12423f = 0;
        try {
            if (map.containsKey("nw_rft")) {
                this.f12423f = ATInitMediation.getIntFromMap(map, "nw_rft");
                this.f12423f = (int) (this.f12423f / 1000.0f);
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
        if (TextUtils.isEmpty(this.a) || TextUtils.isEmpty(this.b)) {
            notifyATLoadFail("", "GTD appid or unitId is empty.");
        } else if (context instanceof Activity) {
            runOnNetworkRequestThread(new Runnable() { // from class: com.anythink.network.gdt.GDTATBannerAdapter.3
                @Override // java.lang.Runnable
                public final void run() {
                    GDTATInitManager.getInstance().initSDK(context, map, new MediationInitCallback() { // from class: com.anythink.network.gdt.GDTATBannerAdapter.3.1
                        @Override // com.anythink.core.api.MediationInitCallback
                        public final void onFail(String str) {
                            GDTATBannerAdapter.this.notifyATLoadFail("", str);
                        }

                        @Override // com.anythink.core.api.MediationInitCallback
                        public final void onSuccess() {
                            AnonymousClass3 anonymousClass3 = AnonymousClass3.this;
                            GDTATBannerAdapter.a(GDTATBannerAdapter.this, (Activity) context, map);
                        }
                    });
                }
            });
        } else {
            notifyATLoadFail("", "Context must be activity.");
        }
    }

    @Override // com.anythink.core.api.ATBaseAdAdapter
    public boolean startBiddingRequest(Context context, Map<String, Object> map, Map<String, Object> map2, ATBiddingListener aTBiddingListener) {
        this.f12425h = true;
        loadCustomNetworkAd(context, map, map2);
        return true;
    }

    private void a(Activity activity, Map<String, Object> map) {
        UnifiedBannerView unifiedBannerView;
        AnonymousClass2 anonymousClass2 = new AnonymousClass2();
        if (TextUtils.isEmpty(this.f12420c) || this.f12425h) {
            UnifiedBannerView unifiedBannerView2 = new UnifiedBannerView(activity, this.b, anonymousClass2);
            GDTATInitManager.getInstance();
            unifiedBannerView2.setLoadAdParams(GDTATInitManager.a(map));
            unifiedBannerView = unifiedBannerView2;
        } else {
            unifiedBannerView = new UnifiedBannerView(activity, this.b, anonymousClass2, null, this.f12420c);
        }
        int i2 = this.f12423f;
        if (i2 > 0) {
            unifiedBannerView.setRefresh(i2);
        } else {
            unifiedBannerView.setRefresh(0);
        }
        this.f12421d = unifiedBannerView;
        if (this.f12421d.getLayoutParams() == null) {
            this.f12421d.setLayoutParams(new FrameLayout.LayoutParams(-1, -2));
        }
        unifiedBannerView.loadAD();
    }

    private void a(Map<String, Object> map, Map<String, Object> map2) {
        this.a = ATInitMediation.getStringFromMap(map, "app_id");
        this.b = ATInitMediation.getStringFromMap(map, "unit_id");
        this.f12422e = ATInitMediation.getIntFromMap(map, "unit_version");
        this.f12420c = ATInitMediation.getStringFromMap(map, "payload");
        this.f12424g = ATInitMediation.getBooleanFromMap(map2, ATAdConst.KEY.AD_CLICK_CONFIRM_STATUS, false);
        this.f12423f = 0;
        try {
            if (map.containsKey("nw_rft")) {
                this.f12423f = ATInitMediation.getIntFromMap(map, "nw_rft");
                this.f12423f = (int) (this.f12423f / 1000.0f);
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    static /* synthetic */ void a(GDTATBannerAdapter gDTATBannerAdapter, Activity activity, Map map) {
        UnifiedBannerView unifiedBannerView;
        AnonymousClass2 anonymousClass2 = gDTATBannerAdapter.new AnonymousClass2();
        if (!TextUtils.isEmpty(gDTATBannerAdapter.f12420c) && !gDTATBannerAdapter.f12425h) {
            unifiedBannerView = new UnifiedBannerView(activity, gDTATBannerAdapter.b, anonymousClass2, null, gDTATBannerAdapter.f12420c);
        } else {
            UnifiedBannerView unifiedBannerView2 = new UnifiedBannerView(activity, gDTATBannerAdapter.b, anonymousClass2);
            GDTATInitManager.getInstance();
            unifiedBannerView2.setLoadAdParams(GDTATInitManager.a((Map<String, Object>) map));
            unifiedBannerView = unifiedBannerView2;
        }
        int i2 = gDTATBannerAdapter.f12423f;
        if (i2 > 0) {
            unifiedBannerView.setRefresh(i2);
        } else {
            unifiedBannerView.setRefresh(0);
        }
        gDTATBannerAdapter.f12421d = unifiedBannerView;
        if (gDTATBannerAdapter.f12421d.getLayoutParams() == null) {
            gDTATBannerAdapter.f12421d.setLayoutParams(new FrameLayout.LayoutParams(-1, -2));
        }
        unifiedBannerView.loadAD();
    }
}
