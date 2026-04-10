package com.anythink.network.gdt;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.anythink.core.api.ATAdConst;
import com.anythink.core.api.ATBidRequestInfoListener;
import com.anythink.core.api.ATBiddingListener;
import com.anythink.core.api.ATBiddingResult;
import com.anythink.core.api.ATCustomLoadListener;
import com.anythink.core.api.ATInitMediation;
import com.anythink.core.api.BaseAd;
import com.anythink.core.api.ErrorCode;
import com.anythink.core.api.MediationInitCallback;
import com.anythink.splashad.api.ATSplashEyeAdListener;
import com.anythink.splashad.api.IATSplashEyeAd;
import com.anythink.splashad.unitgroup.api.CustomSplashAdapter;
import com.anythink.splashad.unitgroup.api.CustomSplashEventListener;
import com.qq.e.ads.splash.SplashAD;
import com.qq.e.ads.splash.SplashADZoomOutListener;
import com.qq.e.comm.compliance.DownloadConfirmCallBack;
import com.qq.e.comm.compliance.DownloadConfirmListener;
import com.qq.e.comm.util.AdError;
import java.lang.ref.WeakReference;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public class GDTATSplashAdapter extends CustomSplashAdapter implements SplashADZoomOutListener {
    boolean b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    GDTATSplashEyeAd f12467c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    ViewGroup f12468d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    String f12469e;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private String f12471g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private String f12472h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private boolean f12473i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private SplashAD f12474j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private boolean f12475k;
    final String a = GDTATSplashAdapter.class.getSimpleName();

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private boolean f12476l = false;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    boolean f12470f = false;

    @Override // com.anythink.core.api.ATBaseAdAdapter
    public void destory() {
        this.f12474j = null;
    }

    @Override // com.anythink.core.api.ATBaseAdAdapter
    public void getBidRequestInfo(Context context, Map<String, Object> map, Map<String, Object> map2, ATBidRequestInfoListener aTBidRequestInfoListener) {
        this.f12472h = ATInitMediation.getStringFromMap(map, "unit_id");
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
        return this.f12472h;
    }

    @Override // com.anythink.core.api.ATBaseAdAdapter
    public String getNetworkSDKVersion() {
        return GDTATInitManager.getInstance().getNetworkVersion();
    }

    @Override // com.anythink.splashad.unitgroup.api.CustomSplashAdapter
    public IATSplashEyeAd getSplashEyeAd() {
        return this.f12467c;
    }

    @Override // com.anythink.core.api.ATBaseAdAdapter
    public boolean isAdReady() {
        return this.f12473i;
    }

    @Override // com.qq.e.ads.splash.SplashADZoomOutListener
    public boolean isSupportZoomOut() {
        return this.f12476l;
    }

    @Override // com.anythink.core.api.ATBaseAdAdapter
    public void loadCustomNetworkAd(final Context context, final Map<String, Object> map, final Map<String, Object> map2) {
        this.f12471g = ATInitMediation.getStringFromMap(map, "app_id");
        this.f12472h = ATInitMediation.getStringFromMap(map, "unit_id");
        this.f12469e = ATInitMediation.getStringFromMap(map, "payload");
        this.f12473i = false;
        this.f12475k = ATInitMediation.getBooleanFromMap(map2, ATAdConst.KEY.AD_CLICK_CONFIRM_STATUS, false);
        if (map.containsKey("zoomoutad_sw")) {
            this.f12476l = TextUtils.equals("2", ATInitMediation.getStringFromMap(map, "zoomoutad_sw"));
        }
        if (TextUtils.isEmpty(this.f12471g) || TextUtils.isEmpty(this.f12472h)) {
            notifyATLoadFail("", "GTD appid or unitId is empty.");
        } else {
            final Context applicationContext = context.getApplicationContext();
            GDTATInitManager.getInstance().initSDK(context, map, new MediationInitCallback() { // from class: com.anythink.network.gdt.GDTATSplashAdapter.1
                @Override // com.anythink.core.api.MediationInitCallback
                public final void onFail(String str) {
                    GDTATSplashAdapter.this.notifyATLoadFail("", str);
                }

                @Override // com.anythink.core.api.MediationInitCallback
                public final void onSuccess() {
                    if (GDTATSplashAdapter.this.getMixedFormatAdType() != 0) {
                        GDTATSplashAdapter.a(GDTATSplashAdapter.this, applicationContext, map);
                        return;
                    }
                    if (!map.containsKey("video_muted")) {
                        map.put("video_muted", "1");
                    }
                    GDTATSplashAdapter.this.thirdPartyLoad(new GDTATAdapter(), context, map, map2);
                }
            });
        }
    }

    @Override // com.qq.e.ads.splash.SplashADListener
    public void onADClicked() {
        CustomSplashEventListener customSplashEventListener = this.mImpressionListener;
        if (customSplashEventListener != null) {
            customSplashEventListener.onSplashAdClicked();
        }
    }

    @Override // com.qq.e.ads.splash.SplashADListener
    public void onADDismissed() {
        ATSplashEyeAdListener splashEyeAdListener;
        if (!this.f12476l || !this.b) {
            CustomSplashEventListener customSplashEventListener = this.mImpressionListener;
            if (customSplashEventListener != null) {
                customSplashEventListener.onSplashAdDismiss();
                return;
            }
            return;
        }
        GDTATSplashEyeAd gDTATSplashEyeAd = this.f12467c;
        if (gDTATSplashEyeAd == null || (splashEyeAdListener = gDTATSplashEyeAd.getSplashEyeAdListener()) == null) {
            return;
        }
        splashEyeAdListener.onAdDismiss(true, "");
    }

    @Override // com.qq.e.ads.splash.SplashADListener
    public void onADExposure() {
        try {
            GDTATInitManager.getInstance().a(getTrackingInfo().l(), new WeakReference(this.f12474j));
        } catch (Throwable unused) {
        }
        CustomSplashEventListener customSplashEventListener = this.mImpressionListener;
        if (customSplashEventListener != null) {
            customSplashEventListener.onSplashAdShow();
        }
    }

    @Override // com.qq.e.ads.splash.SplashADListener
    public void onADLoaded(long j2) {
        this.f12473i = true;
        SplashAD splashAD = this.f12474j;
        if (splashAD != null && this.f12475k) {
            splashAD.setDownloadConfirmListener(new DownloadConfirmListener() { // from class: com.anythink.network.gdt.GDTATSplashAdapter.2
                @Override // com.qq.e.comm.compliance.DownloadConfirmListener
                public final void onDownloadConfirm(Activity activity, int i2, String str, DownloadConfirmCallBack downloadConfirmCallBack) {
                    if (((CustomSplashAdapter) GDTATSplashAdapter.this).mImpressionListener != null) {
                        GDTDownloadFirmInfo gDTDownloadFirmInfo = new GDTDownloadFirmInfo();
                        gDTDownloadFirmInfo.appInfoUrl = str;
                        gDTDownloadFirmInfo.scenes = i2;
                        gDTDownloadFirmInfo.confirmCallBack = downloadConfirmCallBack;
                        ((CustomSplashAdapter) GDTATSplashAdapter.this).mImpressionListener.onDownloadConfirm(activity, gDTDownloadFirmInfo);
                    }
                }
            });
        }
        if (!this.f12470f) {
            ATCustomLoadListener aTCustomLoadListener = this.mLoadListener;
            if (aTCustomLoadListener != null) {
                aTCustomLoadListener.onAdCacheLoaded(new BaseAd[0]);
                return;
            }
            return;
        }
        if (this.mBiddingListener != null) {
            SplashAD splashAD2 = this.f12474j;
            if (splashAD2 == null) {
                notifyATLoadFail("", "GDT: SplashAD had been destroy.");
                return;
            }
            double ecpm = splashAD2.getECPM();
            GDTATBiddingNotice gDTATBiddingNotice = new GDTATBiddingNotice(this.f12474j);
            ATBiddingListener aTBiddingListener = this.mBiddingListener;
            StringBuilder sb = new StringBuilder();
            sb.append(System.currentTimeMillis());
            aTBiddingListener.onC2SBiddingResultWithCache(ATBiddingResult.success(ecpm, sb.toString(), gDTATBiddingNotice, ATAdConst.CURRENCY.RMB_CENT), null);
        }
    }

    @Override // com.qq.e.ads.splash.SplashADListener
    public void onADPresent() {
    }

    @Override // com.qq.e.ads.splash.SplashADListener
    public void onADTick(long j2) {
    }

    @Override // com.qq.e.ads.splash.SplashADListener
    public void onNoAD(AdError adError) {
        StringBuilder sb = new StringBuilder();
        sb.append(adError.getErrorCode());
        notifyATLoadFail(sb.toString(), adError.getErrorMsg());
        if (this.mImpressionListener != null) {
            String str = "GDT Splash show fail:[errorCode:" + adError.getErrorCode() + ",errorMsg:" + adError.getErrorMsg() + "]";
            this.mDismissType = 99;
            CustomSplashEventListener customSplashEventListener = this.mImpressionListener;
            StringBuilder sb2 = new StringBuilder();
            sb2.append(adError.getErrorCode());
            customSplashEventListener.onSplashAdShowFail(ErrorCode.getErrorCode(ErrorCode.adShowError, sb2.toString(), adError.getErrorMsg()));
            this.mImpressionListener.onSplashAdDismiss();
        }
    }

    @Override // com.qq.e.ads.splash.SplashADZoomOutListener
    public void onZoomOut() {
        this.b = true;
        if (this.f12476l) {
            this.f12467c = new GDTATSplashEyeAd(this, this.f12474j);
            this.f12467c.setSplashView(this.f12468d);
            CustomSplashEventListener customSplashEventListener = this.mImpressionListener;
            if (customSplashEventListener != null) {
                customSplashEventListener.onSplashAdDismiss();
            }
        }
    }

    @Override // com.qq.e.ads.splash.SplashADZoomOutListener
    public void onZoomOutPlayFinish() {
    }

    @Override // com.anythink.splashad.unitgroup.api.CustomSplashAdapter
    public void show(Activity activity, ViewGroup viewGroup) {
        SplashAD splashAD;
        if (!this.f12473i || (splashAD = this.f12474j) == null) {
            return;
        }
        if (!this.f12476l) {
            splashAD.showAd(viewGroup);
            return;
        }
        this.f12468d = new FrameLayout(viewGroup.getContext());
        viewGroup.addView(this.f12468d, new ViewGroup.LayoutParams(-1, -1));
        this.f12474j.showAd(this.f12468d);
    }

    @Override // com.anythink.core.api.ATBaseAdAdapter
    public boolean startBiddingRequest(Context context, Map<String, Object> map, Map<String, Object> map2, ATBiddingListener aTBiddingListener) {
        this.f12470f = true;
        if (getMixedFormatAdType() == 0) {
            return false;
        }
        loadCustomNetworkAd(context, map, map2);
        return true;
    }

    private void a(Context context, Map<String, Object> map) {
        if (TextUtils.isEmpty(this.f12469e) || this.f12470f) {
            this.f12474j = new SplashAD(context, this.f12472h, this, this.mFetchAdTimeout);
            SplashAD splashAD = this.f12474j;
            GDTATInitManager.getInstance();
            splashAD.setLoadAdParams(GDTATInitManager.a(map));
        } else {
            this.f12474j = new SplashAD(context, this.f12472h, this, this.mFetchAdTimeout, this.f12469e);
        }
        this.f12474j.fetchAdOnly();
    }

    private void a(Map<String, Object> map, Map<String, Object> map2) {
        this.f12471g = ATInitMediation.getStringFromMap(map, "app_id");
        this.f12472h = ATInitMediation.getStringFromMap(map, "unit_id");
        this.f12469e = ATInitMediation.getStringFromMap(map, "payload");
        this.f12473i = false;
        this.f12475k = ATInitMediation.getBooleanFromMap(map2, ATAdConst.KEY.AD_CLICK_CONFIRM_STATUS, false);
        if (map.containsKey("zoomoutad_sw")) {
            this.f12476l = TextUtils.equals("2", ATInitMediation.getStringFromMap(map, "zoomoutad_sw"));
        }
    }

    static /* synthetic */ void a(GDTATSplashAdapter gDTATSplashAdapter, Context context, Map map) {
        if (!TextUtils.isEmpty(gDTATSplashAdapter.f12469e) && !gDTATSplashAdapter.f12470f) {
            gDTATSplashAdapter.f12474j = new SplashAD(context, gDTATSplashAdapter.f12472h, gDTATSplashAdapter, gDTATSplashAdapter.mFetchAdTimeout, gDTATSplashAdapter.f12469e);
        } else {
            gDTATSplashAdapter.f12474j = new SplashAD(context, gDTATSplashAdapter.f12472h, gDTATSplashAdapter, gDTATSplashAdapter.mFetchAdTimeout);
            SplashAD splashAD = gDTATSplashAdapter.f12474j;
            GDTATInitManager.getInstance();
            splashAD.setLoadAdParams(GDTATInitManager.a((Map<String, Object>) map));
        }
        gDTATSplashAdapter.f12474j.fetchAdOnly();
    }
}
