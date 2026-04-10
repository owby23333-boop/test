package com.anythink.network.baidu;

import android.app.Activity;
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
import com.anythink.interstitial.unitgroup.api.CustomInterstitialAdapter;
import com.baidu.mobads.sdk.api.ExpressInterstitialAd;
import com.baidu.mobads.sdk.api.ExpressInterstitialListener;
import com.baidu.mobads.sdk.api.FullScreenVideoAd;
import com.baidu.mobads.sdk.api.InterstitialAd;
import com.baidu.mobads.sdk.api.InterstitialAdListener;
import com.bytedance.msdk.adapter.pangle.PangleAdapterUtils;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public class BaiduATInterstitialAdapter extends CustomInterstitialAdapter {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static final String f12348g = "BaiduATInterstitialAdapter";
    InterstitialAd a;
    FullScreenVideoAd b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    ExpressInterstitialAd f12349c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    FullScreenVideoAd.FullScreenVideoAdListener f12350d;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private String f12353h = "";

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private String f12354i = "";

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private String f12355j = "";

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private String f12356k = "";

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private double f12357l = PangleAdapterUtils.CPM_DEFLAUT_VALUE;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    boolean f12351e = false;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    boolean f12352f = false;

    /* JADX INFO: renamed from: com.anythink.network.baidu.BaiduATInterstitialAdapter$1, reason: invalid class name */
    final class AnonymousClass1 implements FullScreenVideoAd.FullScreenVideoAdListener {
        AnonymousClass1() {
        }

        @Override // com.baidu.mobads.sdk.api.FullScreenVideoAd.FullScreenVideoAdListener, com.baidu.mobads.sdk.api.ScreenVideoAdListener
        public final void onAdClick() {
            if (((CustomInterstitialAdapter) BaiduATInterstitialAdapter.this).mImpressListener != null) {
                ((CustomInterstitialAdapter) BaiduATInterstitialAdapter.this).mImpressListener.onInterstitialAdClicked();
            }
        }

        @Override // com.baidu.mobads.sdk.api.FullScreenVideoAd.FullScreenVideoAdListener, com.baidu.mobads.sdk.api.ScreenVideoAdListener
        public final void onAdClose(float f2) {
            if (((CustomInterstitialAdapter) BaiduATInterstitialAdapter.this).mImpressListener != null) {
                ((CustomInterstitialAdapter) BaiduATInterstitialAdapter.this).mImpressListener.onInterstitialAdClose();
            }
        }

        @Override // com.baidu.mobads.sdk.api.FullScreenVideoAd.FullScreenVideoAdListener, com.baidu.mobads.sdk.api.ScreenVideoAdListener
        public final void onAdFailed(String str) {
            BaiduATInterstitialAdapter.this.notifyATLoadFail("", "Baidu: ".concat(String.valueOf(str)));
        }

        @Override // com.baidu.mobads.sdk.api.ScreenVideoAdListener
        public final void onAdLoaded() {
            if (((ATBaseAdAdapter) BaiduATInterstitialAdapter.this).mLoadListener != null) {
                ((ATBaseAdAdapter) BaiduATInterstitialAdapter.this).mLoadListener.onAdDataLoaded();
            }
        }

        @Override // com.baidu.mobads.sdk.api.FullScreenVideoAd.FullScreenVideoAdListener, com.baidu.mobads.sdk.api.ScreenVideoAdListener
        public final void onAdShow() {
            if (((CustomInterstitialAdapter) BaiduATInterstitialAdapter.this).mImpressListener != null) {
                ((CustomInterstitialAdapter) BaiduATInterstitialAdapter.this).mImpressListener.onInterstitialAdShow();
                ((CustomInterstitialAdapter) BaiduATInterstitialAdapter.this).mImpressListener.onInterstitialAdVideoStart();
            }
        }

        @Override // com.baidu.mobads.sdk.api.FullScreenVideoAd.FullScreenVideoAdListener, com.baidu.mobads.sdk.api.ScreenVideoAdListener
        public final void onAdSkip(float f2) {
            BaiduATInterstitialAdapter.k(BaiduATInterstitialAdapter.this);
        }

        @Override // com.baidu.mobads.sdk.api.FullScreenVideoAd.FullScreenVideoAdListener, com.baidu.mobads.sdk.api.ScreenVideoAdListener
        public final void onVideoDownloadFailed() {
            BaiduATInterstitialAdapter.this.notifyATLoadFail("", "Baidu: onVideoDownloadFailed");
        }

        @Override // com.baidu.mobads.sdk.api.FullScreenVideoAd.FullScreenVideoAdListener, com.baidu.mobads.sdk.api.ScreenVideoAdListener
        public final void onVideoDownloadSuccess() {
            BaiduATInterstitialAdapter.h(BaiduATInterstitialAdapter.this);
        }

        @Override // com.baidu.mobads.sdk.api.FullScreenVideoAd.FullScreenVideoAdListener, com.baidu.mobads.sdk.api.ScreenVideoAdListener
        public final void playCompletion() {
            if (((CustomInterstitialAdapter) BaiduATInterstitialAdapter.this).mImpressListener != null) {
                ((CustomInterstitialAdapter) BaiduATInterstitialAdapter.this).mImpressListener.onInterstitialAdVideoEnd();
            }
        }
    }

    /* JADX INFO: renamed from: com.anythink.network.baidu.BaiduATInterstitialAdapter$2, reason: invalid class name */
    final class AnonymousClass2 implements InterstitialAdListener {
        AnonymousClass2() {
        }

        @Override // com.baidu.mobads.sdk.api.InterstitialAdListener
        public final void onAdClick(InterstitialAd interstitialAd) {
            if (((CustomInterstitialAdapter) BaiduATInterstitialAdapter.this).mImpressListener != null) {
                ((CustomInterstitialAdapter) BaiduATInterstitialAdapter.this).mImpressListener.onInterstitialAdClicked();
            }
        }

        @Override // com.baidu.mobads.sdk.api.InterstitialAdListener
        public final void onAdDismissed() {
            if (((CustomInterstitialAdapter) BaiduATInterstitialAdapter.this).mImpressListener != null) {
                ((CustomInterstitialAdapter) BaiduATInterstitialAdapter.this).mImpressListener.onInterstitialAdClose();
            }
        }

        @Override // com.baidu.mobads.sdk.api.InterstitialAdListener
        public final void onAdFailed(String str) {
            if (((ATBaseAdAdapter) BaiduATInterstitialAdapter.this).mLoadListener != null) {
                ((ATBaseAdAdapter) BaiduATInterstitialAdapter.this).mLoadListener.onAdLoadError("", str);
            }
        }

        @Override // com.baidu.mobads.sdk.api.InterstitialAdListener
        public final void onAdPresent() {
            if (((CustomInterstitialAdapter) BaiduATInterstitialAdapter.this).mImpressListener != null) {
                ((CustomInterstitialAdapter) BaiduATInterstitialAdapter.this).mImpressListener.onInterstitialAdShow();
            }
        }

        @Override // com.baidu.mobads.sdk.api.InterstitialAdListener
        public final void onAdReady() {
            if (((ATBaseAdAdapter) BaiduATInterstitialAdapter.this).mLoadListener != null) {
                ((ATBaseAdAdapter) BaiduATInterstitialAdapter.this).mLoadListener.onAdCacheLoaded(new BaseAd[0]);
            }
        }
    }

    /* JADX INFO: renamed from: com.anythink.network.baidu.BaiduATInterstitialAdapter$3, reason: invalid class name */
    final class AnonymousClass3 implements ExpressInterstitialListener {
        AnonymousClass3() {
        }

        @Override // com.baidu.mobads.sdk.api.ExpressInterstitialListener
        public final void onADExposed() {
            if (((CustomInterstitialAdapter) BaiduATInterstitialAdapter.this).mImpressListener != null) {
                ((CustomInterstitialAdapter) BaiduATInterstitialAdapter.this).mImpressListener.onInterstitialAdShow();
            }
        }

        @Override // com.baidu.mobads.sdk.api.ExpressInterstitialListener
        public final void onADExposureFailed() {
            if (((CustomInterstitialAdapter) BaiduATInterstitialAdapter.this).mImpressListener != null) {
                ((CustomInterstitialAdapter) BaiduATInterstitialAdapter.this).mImpressListener.onInterstitialAdVideoError("", "Baidu: onADExposureFailed()");
            }
        }

        @Override // com.baidu.mobads.sdk.api.ExpressInterstitialListener
        public final void onADLoaded() {
            if (((ATBaseAdAdapter) BaiduATInterstitialAdapter.this).mLoadListener != null) {
                ((ATBaseAdAdapter) BaiduATInterstitialAdapter.this).mLoadListener.onAdDataLoaded();
            }
        }

        @Override // com.baidu.mobads.sdk.api.ExpressInterstitialListener
        public final void onAdCacheFailed() {
            BaiduATInterstitialAdapter.this.notifyATLoadFail("", "Baidu: onAdCacheFailed");
        }

        @Override // com.baidu.mobads.sdk.api.ExpressInterstitialListener
        public final void onAdCacheSuccess() {
            BaiduATInterstitialAdapter.H(BaiduATInterstitialAdapter.this);
        }

        @Override // com.baidu.mobads.sdk.api.ExpressInterstitialListener
        public final void onAdClick() {
            if (((CustomInterstitialAdapter) BaiduATInterstitialAdapter.this).mImpressListener != null) {
                ((CustomInterstitialAdapter) BaiduATInterstitialAdapter.this).mImpressListener.onInterstitialAdClicked();
            }
        }

        @Override // com.baidu.mobads.sdk.api.ExpressInterstitialListener
        public final void onAdClose() {
            if (((CustomInterstitialAdapter) BaiduATInterstitialAdapter.this).mImpressListener != null) {
                ((CustomInterstitialAdapter) BaiduATInterstitialAdapter.this).mImpressListener.onInterstitialAdClose();
            }
        }

        @Override // com.baidu.mobads.sdk.api.ExpressInterstitialListener
        public final void onAdFailed(int i2, String str) {
            BaiduATInterstitialAdapter.this.notifyATLoadFail(String.valueOf(i2), str);
        }

        @Override // com.baidu.mobads.sdk.api.ExpressInterstitialListener
        public final void onLpClosed() {
        }

        @Override // com.baidu.mobads.sdk.api.ExpressInterstitialListener
        public final void onNoAd(int i2, String str) {
            BaiduATInterstitialAdapter.this.notifyATLoadFail(String.valueOf(i2), "onNoAd:".concat(String.valueOf(str)));
        }

        @Override // com.baidu.mobads.sdk.api.ExpressInterstitialListener
        public final void onVideoDownloadFailed() {
        }

        @Override // com.baidu.mobads.sdk.api.ExpressInterstitialListener
        public final void onVideoDownloadSuccess() {
        }
    }

    /* JADX INFO: renamed from: com.anythink.network.baidu.BaiduATInterstitialAdapter$4, reason: invalid class name */
    final class AnonymousClass4 implements ExpressInterstitialAd.InterAdDownloadWindowListener {
        AnonymousClass4() {
        }

        @Override // com.baidu.mobads.sdk.api.ExpressInterstitialAd.InterAdDownloadWindowListener
        public final void adDownloadWindowClose() {
        }

        @Override // com.baidu.mobads.sdk.api.ExpressInterstitialAd.InterAdDownloadWindowListener
        public final void adDownloadWindowShow() {
        }

        @Override // com.baidu.mobads.sdk.api.ExpressInterstitialAd.InterAdDownloadWindowListener
        public final void onADPermissionClose() {
        }

        @Override // com.baidu.mobads.sdk.api.ExpressInterstitialAd.InterAdDownloadWindowListener
        public final void onADPermissionShow() {
        }

        @Override // com.baidu.mobads.sdk.api.ExpressInterstitialAd.InterAdDownloadWindowListener
        public final void onADPrivacyClick() {
        }

        @Override // com.baidu.mobads.sdk.api.ExpressInterstitialAd.InterAdDownloadWindowListener
        public final void onADPrivacyClose() {
        }
    }

    static /* synthetic */ void H(BaiduATInterstitialAdapter baiduATInterstitialAdapter) {
        if (!baiduATInterstitialAdapter.f12352f) {
            ATCustomLoadListener aTCustomLoadListener = baiduATInterstitialAdapter.mLoadListener;
            if (aTCustomLoadListener != null) {
                aTCustomLoadListener.onAdCacheLoaded(new BaseAd[0]);
                return;
            }
            return;
        }
        if (baiduATInterstitialAdapter.mBiddingListener != null) {
            ExpressInterstitialAd expressInterstitialAd = baiduATInterstitialAdapter.f12349c;
            if (expressInterstitialAd == null) {
                baiduATInterstitialAdapter.notifyATLoadFail("", "Baidu: ExpressInterstitialAd had been destroyed.");
                return;
            }
            String eCPMLevel = expressInterstitialAd.getECPMLevel();
            if (TextUtils.isEmpty(eCPMLevel)) {
                eCPMLevel = "0";
            }
            double d2 = PangleAdapterUtils.CPM_DEFLAUT_VALUE;
            try {
                d2 = Double.parseDouble(eCPMLevel);
            } catch (Throwable th) {
                th.printStackTrace();
            }
            BaiduATBiddingNotice baiduATBiddingNotice = new BaiduATBiddingNotice(baiduATInterstitialAdapter.f12349c);
            ATBiddingListener aTBiddingListener = baiduATInterstitialAdapter.mBiddingListener;
            StringBuilder sb = new StringBuilder();
            sb.append(System.currentTimeMillis());
            aTBiddingListener.onC2SBiddingResultWithCache(ATBiddingResult.success(d2, sb.toString(), baiduATBiddingNotice, ATAdConst.CURRENCY.RMB_CENT), null);
        }
    }

    static /* synthetic */ void h(BaiduATInterstitialAdapter baiduATInterstitialAdapter) {
        if (!baiduATInterstitialAdapter.f12352f) {
            ATCustomLoadListener aTCustomLoadListener = baiduATInterstitialAdapter.mLoadListener;
            if (aTCustomLoadListener != null) {
                aTCustomLoadListener.onAdCacheLoaded(new BaseAd[0]);
                return;
            }
            return;
        }
        if (baiduATInterstitialAdapter.mBiddingListener != null) {
            FullScreenVideoAd fullScreenVideoAd = baiduATInterstitialAdapter.b;
            if (fullScreenVideoAd == null) {
                baiduATInterstitialAdapter.notifyATLoadFail("", "Baidu: FullScreenVideoAd had been destroyed.");
                return;
            }
            String eCPMLevel = fullScreenVideoAd.getECPMLevel();
            if (TextUtils.isEmpty(eCPMLevel)) {
                eCPMLevel = "0";
            }
            double d2 = PangleAdapterUtils.CPM_DEFLAUT_VALUE;
            try {
                d2 = Double.parseDouble(eCPMLevel);
            } catch (Throwable th) {
                th.printStackTrace();
            }
            BaiduATBiddingNotice baiduATBiddingNotice = new BaiduATBiddingNotice(baiduATInterstitialAdapter.b);
            ATBiddingListener aTBiddingListener = baiduATInterstitialAdapter.mBiddingListener;
            StringBuilder sb = new StringBuilder();
            sb.append(System.currentTimeMillis());
            aTBiddingListener.onC2SBiddingResultWithCache(ATBiddingResult.success(d2, sb.toString(), baiduATBiddingNotice, ATAdConst.CURRENCY.RMB_CENT), null);
        }
    }

    static /* synthetic */ int k(BaiduATInterstitialAdapter baiduATInterstitialAdapter) {
        baiduATInterstitialAdapter.mDismissType = 2;
        return 2;
    }

    @Override // com.anythink.core.api.ATBaseAdAdapter
    public void destory() {
        if (this.b != null) {
            this.b = null;
            this.f12350d = null;
        }
        InterstitialAd interstitialAd = this.a;
        if (interstitialAd != null) {
            interstitialAd.destroy();
            this.a = null;
        }
        ExpressInterstitialAd expressInterstitialAd = this.f12349c;
        if (expressInterstitialAd != null) {
            expressInterstitialAd.destroy();
            this.f12349c = null;
        }
    }

    @Override // com.anythink.core.api.ATBaseAdAdapter
    public String getNetworkName() {
        return BaiduATInitManager.getInstance().getNetworkName();
    }

    @Override // com.anythink.core.api.ATBaseAdAdapter
    public String getNetworkPlacementId() {
        return this.f12354i;
    }

    @Override // com.anythink.core.api.ATBaseAdAdapter
    public String getNetworkSDKVersion() {
        return BaiduATInitManager.getInstance().getNetworkVersion();
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x0025  */
    @Override // com.anythink.core.api.ATBaseAdAdapter
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean isAdReady() {
        /*
            r5 = this;
            java.lang.String r0 = r5.f12356k
            int r1 = r0.hashCode()
            r2 = 49
            r3 = 0
            r4 = 1
            if (r1 == r2) goto L1b
            r2 = 50
            if (r1 == r2) goto L11
            goto L25
        L11:
            java.lang.String r1 = "2"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L25
            r0 = 1
            goto L26
        L1b:
            java.lang.String r1 = "1"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L25
            r0 = 0
            goto L26
        L25:
            r0 = -1
        L26:
            if (r0 == 0) goto L3c
            if (r0 == r4) goto L33
            com.baidu.mobads.sdk.api.InterstitialAd r0 = r5.a
            if (r0 == 0) goto L45
            boolean r0 = r0.isAdReady()
            return r0
        L33:
            com.baidu.mobads.sdk.api.ExpressInterstitialAd r0 = r5.f12349c
            if (r0 == 0) goto L45
            boolean r0 = r0.isReady()
            return r0
        L3c:
            com.baidu.mobads.sdk.api.FullScreenVideoAd r0 = r5.b
            if (r0 == 0) goto L45
            boolean r0 = r0.isReady()
            return r0
        L45:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.anythink.network.baidu.BaiduATInterstitialAdapter.isAdReady():boolean");
    }

    @Override // com.anythink.core.api.ATBaseAdAdapter
    public void loadCustomNetworkAd(final Context context, Map<String, Object> map, Map<String, Object> map2) {
        this.f12353h = ATInitMediation.getStringFromMap(map, "app_id");
        this.f12354i = ATInitMediation.getStringFromMap(map, "ad_place_id");
        this.f12356k = ATInitMediation.getStringFromMap(map, "unit_type");
        try {
            if (map.containsKey("bid_floor")) {
                this.f12357l = Double.parseDouble(map.get("bid_floor").toString());
            }
        } catch (Throwable unused) {
        }
        if (map2 != null) {
            try {
                if (map2.containsKey(ATAdConst.KEY.AD_CLICK_CONFIRM_STATUS)) {
                    this.f12351e = Boolean.parseBoolean(map2.get(ATAdConst.KEY.AD_CLICK_CONFIRM_STATUS).toString());
                }
            } catch (Exception unused2) {
            }
        }
        this.f12355j = ATInitMediation.getStringFromMap(map, "payload");
        if (TextUtils.isEmpty(this.f12353h) || TextUtils.isEmpty(this.f12354i)) {
            notifyATLoadFail("", " app_id ,ad_place_id is empty.");
            return;
        }
        if ((TextUtils.isEmpty(this.f12356k) || this.f12356k.equals("0")) && !(context instanceof Activity)) {
            notifyATLoadFail("", "Baidu InterstitialAd context must be activity.");
        } else {
            BaiduATInitManager.getInstance().initSDK(context.getApplicationContext(), map, TextUtils.equals("0", this.f12356k), new MediationInitCallback() { // from class: com.anythink.network.baidu.BaiduATInterstitialAdapter.5
                @Override // com.anythink.core.api.MediationInitCallback
                public final void onFail(String str) {
                    if (((ATBaseAdAdapter) BaiduATInterstitialAdapter.this).mLoadListener != null) {
                        ((ATBaseAdAdapter) BaiduATInterstitialAdapter.this).mLoadListener.onAdLoadError("", str);
                    }
                }

                @Override // com.anythink.core.api.MediationInitCallback
                public final void onSuccess() {
                    try {
                        BaiduATInterstitialAdapter.a(BaiduATInterstitialAdapter.this, context);
                    } catch (Throwable th) {
                        th.printStackTrace();
                        if (((ATBaseAdAdapter) BaiduATInterstitialAdapter.this).mLoadListener != null) {
                            ((ATBaseAdAdapter) BaiduATInterstitialAdapter.this).mLoadListener.onAdLoadError("", "Baidu: init error, " + th.getMessage());
                        }
                    }
                }
            });
        }
    }

    public void setDismissType(int i2) {
        this.mDismissType = i2;
    }

    @Override // com.anythink.interstitial.unitgroup.api.CustomInterstitialAdapter
    public void show(Activity activity) {
        try {
            String str = this.f12356k;
            byte b = -1;
            int iHashCode = str.hashCode();
            if (iHashCode != 49) {
                if (iHashCode == 50 && str.equals("2")) {
                    b = 1;
                }
            } else if (str.equals("1")) {
                b = 0;
            }
            if (b == 0) {
                if (this.b != null) {
                    this.b.show();
                }
            } else if (b != 1) {
                if (this.a != null) {
                    this.a.showAd();
                }
            } else if (this.f12349c != null) {
                this.f12349c.show(activity);
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    @Override // com.anythink.core.api.ATBaseAdAdapter
    public boolean startBiddingRequest(Context context, Map<String, Object> map, Map<String, Object> map2, ATBiddingListener aTBiddingListener) {
        this.f12352f = true;
        loadCustomNetworkAd(context, map, map2);
        return true;
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x0025  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void a(android.content.Context r8) {
        /*
            Method dump skipped, instruction units count: 235
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.anythink.network.baidu.BaiduATInterstitialAdapter.a(android.content.Context):void");
    }

    private void b(Context context) {
        this.f12350d = new AnonymousClass1();
        this.b = new FullScreenVideoAd(context, this.f12354i, this.f12350d, false);
        if (this.f12352f && this.f12357l > PangleAdapterUtils.CPM_DEFLAUT_VALUE) {
            if (ATSDK.isNetworkLogDebug()) {
                String str = "setBidFloor:" + ((int) this.f12357l);
            }
            this.b.setBidFloor((int) this.f12357l);
        }
        this.b.load();
    }

    private void c(Context context) {
        if (this.f12352f) {
            notifyATLoadFail("", "Baidu C2S Interstitial only support ExpressInterstitialAd and FullScreenVideoAd");
            return;
        }
        this.a = new InterstitialAd(context, this.f12354i);
        this.a.setListener(new AnonymousClass2());
        this.a.loadAd();
    }

    private void d(Context context) {
        this.f12349c = new ExpressInterstitialAd(context, this.f12354i);
        if (this.f12352f && this.f12357l > PangleAdapterUtils.CPM_DEFLAUT_VALUE) {
            if (ATSDK.isNetworkLogDebug()) {
                String str = "setBidFloor:" + ((int) (this.f12357l * 100.0d));
            }
            this.f12349c.setBidFloor((int) (this.f12357l * 100.0d));
        }
        this.f12349c.setLoadListener(new AnonymousClass3());
        this.f12349c.setDownloadListener(new AnonymousClass4());
        this.f12349c.setDialogFrame(this.f12351e);
        this.f12349c.load();
    }

    private void b() {
        if (this.f12352f) {
            if (this.mBiddingListener != null) {
                ExpressInterstitialAd expressInterstitialAd = this.f12349c;
                if (expressInterstitialAd != null) {
                    String eCPMLevel = expressInterstitialAd.getECPMLevel();
                    if (TextUtils.isEmpty(eCPMLevel)) {
                        eCPMLevel = "0";
                    }
                    double d2 = PangleAdapterUtils.CPM_DEFLAUT_VALUE;
                    try {
                        d2 = Double.parseDouble(eCPMLevel);
                    } catch (Throwable th) {
                        th.printStackTrace();
                    }
                    BaiduATBiddingNotice baiduATBiddingNotice = new BaiduATBiddingNotice(this.f12349c);
                    ATBiddingListener aTBiddingListener = this.mBiddingListener;
                    StringBuilder sb = new StringBuilder();
                    sb.append(System.currentTimeMillis());
                    aTBiddingListener.onC2SBiddingResultWithCache(ATBiddingResult.success(d2, sb.toString(), baiduATBiddingNotice, ATAdConst.CURRENCY.RMB_CENT), null);
                    return;
                }
                notifyATLoadFail("", "Baidu: ExpressInterstitialAd had been destroyed.");
                return;
            }
            return;
        }
        ATCustomLoadListener aTCustomLoadListener = this.mLoadListener;
        if (aTCustomLoadListener != null) {
            aTCustomLoadListener.onAdCacheLoaded(new BaseAd[0]);
        }
    }

    private void a() {
        if (this.f12352f) {
            if (this.mBiddingListener != null) {
                FullScreenVideoAd fullScreenVideoAd = this.b;
                if (fullScreenVideoAd != null) {
                    String eCPMLevel = fullScreenVideoAd.getECPMLevel();
                    if (TextUtils.isEmpty(eCPMLevel)) {
                        eCPMLevel = "0";
                    }
                    double d2 = PangleAdapterUtils.CPM_DEFLAUT_VALUE;
                    try {
                        d2 = Double.parseDouble(eCPMLevel);
                    } catch (Throwable th) {
                        th.printStackTrace();
                    }
                    BaiduATBiddingNotice baiduATBiddingNotice = new BaiduATBiddingNotice(this.b);
                    ATBiddingListener aTBiddingListener = this.mBiddingListener;
                    StringBuilder sb = new StringBuilder();
                    sb.append(System.currentTimeMillis());
                    aTBiddingListener.onC2SBiddingResultWithCache(ATBiddingResult.success(d2, sb.toString(), baiduATBiddingNotice, ATAdConst.CURRENCY.RMB_CENT), null);
                    return;
                }
                notifyATLoadFail("", "Baidu: FullScreenVideoAd had been destroyed.");
                return;
            }
            return;
        }
        ATCustomLoadListener aTCustomLoadListener = this.mLoadListener;
        if (aTCustomLoadListener != null) {
            aTCustomLoadListener.onAdCacheLoaded(new BaseAd[0]);
        }
    }

    private void a(Map<String, Object> map, Map<String, Object> map2) {
        this.f12353h = ATInitMediation.getStringFromMap(map, "app_id");
        this.f12354i = ATInitMediation.getStringFromMap(map, "ad_place_id");
        this.f12356k = ATInitMediation.getStringFromMap(map, "unit_type");
        try {
            if (map.containsKey("bid_floor")) {
                this.f12357l = Double.parseDouble(map.get("bid_floor").toString());
            }
        } catch (Throwable unused) {
        }
        if (map2 != null) {
            try {
                if (map2.containsKey(ATAdConst.KEY.AD_CLICK_CONFIRM_STATUS)) {
                    this.f12351e = Boolean.parseBoolean(map2.get(ATAdConst.KEY.AD_CLICK_CONFIRM_STATUS).toString());
                }
            } catch (Exception unused2) {
            }
        }
        this.f12355j = ATInitMediation.getStringFromMap(map, "payload");
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x0025  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    static /* synthetic */ void a(com.anythink.network.baidu.BaiduATInterstitialAdapter r7, android.content.Context r8) {
        /*
            Method dump skipped, instruction units count: 235
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.anythink.network.baidu.BaiduATInterstitialAdapter.a(com.anythink.network.baidu.BaiduATInterstitialAdapter, android.content.Context):void");
    }
}
