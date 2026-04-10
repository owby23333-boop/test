package com.anythink.network.gdt;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import com.anythink.core.api.ATAdConst;
import com.anythink.core.api.ATBaseAdAdapter;
import com.anythink.core.api.ATBidRequestInfoListener;
import com.anythink.core.api.ATBiddingListener;
import com.anythink.core.api.ATBiddingResult;
import com.anythink.core.api.ATInitMediation;
import com.anythink.core.api.BaseAd;
import com.anythink.core.api.MediationInitCallback;
import com.anythink.interstitial.unitgroup.api.CustomInterstitialAdapter;
import com.anythink.interstitial.unitgroup.api.CustomInterstitialEventListener;
import com.qq.e.ads.cfg.VideoOption;
import com.qq.e.ads.interstitial2.UnifiedInterstitialAD;
import com.qq.e.ads.interstitial2.UnifiedInterstitialADListener;
import com.qq.e.ads.interstitial2.UnifiedInterstitialMediaListener;
import com.qq.e.comm.compliance.DownloadConfirmCallBack;
import com.qq.e.comm.compliance.DownloadConfirmListener;
import com.qq.e.comm.util.AdError;
import java.lang.ref.WeakReference;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public class GDTATInterstitialAdapter extends CustomInterstitialAdapter implements UnifiedInterstitialMediaListener {
    public static String TAG = "GDTATInterstitialAdapter";
    UnifiedInterstitialAD a;
    String b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    String f12437c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    String f12438d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    int f12439e = 0;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    String f12440f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    boolean f12441g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    boolean f12442h;

    /* JADX INFO: renamed from: com.anythink.network.gdt.GDTATInterstitialAdapter$1, reason: invalid class name */
    final class AnonymousClass1 implements UnifiedInterstitialADListener {
        AnonymousClass1() {
        }

        @Override // com.qq.e.ads.interstitial2.UnifiedInterstitialADListener
        public final void onADClicked() {
            if (((CustomInterstitialAdapter) GDTATInterstitialAdapter.this).mImpressListener != null) {
                ((CustomInterstitialAdapter) GDTATInterstitialAdapter.this).mImpressListener.onInterstitialAdClicked();
            }
        }

        @Override // com.qq.e.ads.interstitial2.UnifiedInterstitialADListener
        public final void onADClosed() {
            GDTATInitManager.getInstance().b();
            if (((CustomInterstitialAdapter) GDTATInterstitialAdapter.this).mImpressListener != null) {
                ((CustomInterstitialAdapter) GDTATInterstitialAdapter.this).mImpressListener.onInterstitialAdClose();
            }
            UnifiedInterstitialAD unifiedInterstitialAD = GDTATInterstitialAdapter.this.a;
            if (unifiedInterstitialAD != null) {
                unifiedInterstitialAD.destroy();
            }
        }

        @Override // com.qq.e.ads.interstitial2.UnifiedInterstitialADListener
        public final void onADExposure() {
            try {
                GDTATInitManager.getInstance().a(GDTATInterstitialAdapter.this.getTrackingInfo().l(), new WeakReference(GDTATInterstitialAdapter.this.a));
            } catch (Throwable unused) {
            }
            if (((CustomInterstitialAdapter) GDTATInterstitialAdapter.this).mImpressListener != null) {
                ((CustomInterstitialAdapter) GDTATInterstitialAdapter.this).mImpressListener.onInterstitialAdShow();
            }
        }

        @Override // com.qq.e.ads.interstitial2.UnifiedInterstitialADListener
        public final void onADLeftApplication() {
        }

        @Override // com.qq.e.ads.interstitial2.UnifiedInterstitialADListener
        public final void onADOpened() {
        }

        @Override // com.qq.e.ads.interstitial2.UnifiedInterstitialADListener
        public final void onADReceive() {
            GDTATInterstitialAdapter gDTATInterstitialAdapter = GDTATInterstitialAdapter.this;
            UnifiedInterstitialAD unifiedInterstitialAD = gDTATInterstitialAdapter.a;
            if (unifiedInterstitialAD != null && gDTATInterstitialAdapter.f12441g) {
                unifiedInterstitialAD.setDownloadConfirmListener(new DownloadConfirmListener() { // from class: com.anythink.network.gdt.GDTATInterstitialAdapter.1.1
                    @Override // com.qq.e.comm.compliance.DownloadConfirmListener
                    public final void onDownloadConfirm(Activity activity, int i2, String str, DownloadConfirmCallBack downloadConfirmCallBack) {
                        if (((CustomInterstitialAdapter) GDTATInterstitialAdapter.this).mImpressListener != null) {
                            GDTDownloadFirmInfo gDTDownloadFirmInfo = new GDTDownloadFirmInfo();
                            gDTDownloadFirmInfo.appInfoUrl = str;
                            gDTDownloadFirmInfo.scenes = i2;
                            gDTDownloadFirmInfo.confirmCallBack = downloadConfirmCallBack;
                            ((CustomInterstitialAdapter) GDTATInterstitialAdapter.this).mImpressListener.onDownloadConfirm(activity, gDTDownloadFirmInfo);
                        }
                    }
                });
            }
            GDTATInterstitialAdapter gDTATInterstitialAdapter2 = GDTATInterstitialAdapter.this;
            if (!gDTATInterstitialAdapter2.f12442h) {
                if (((ATBaseAdAdapter) gDTATInterstitialAdapter2).mLoadListener != null) {
                    ((ATBaseAdAdapter) GDTATInterstitialAdapter.this).mLoadListener.onAdDataLoaded();
                }
            } else if (gDTATInterstitialAdapter2.mBiddingListener != null) {
                double ecpm = gDTATInterstitialAdapter2.a.getECPM();
                GDTATBiddingNotice gDTATBiddingNotice = new GDTATBiddingNotice(GDTATInterstitialAdapter.this.a);
                ATBiddingListener aTBiddingListener = GDTATInterstitialAdapter.this.mBiddingListener;
                StringBuilder sb = new StringBuilder();
                sb.append(System.currentTimeMillis());
                aTBiddingListener.onC2SBiddingResultWithCache(ATBiddingResult.success(ecpm, sb.toString(), gDTATBiddingNotice, ATAdConst.CURRENCY.RMB_CENT), null);
            }
        }

        @Override // com.qq.e.ads.interstitial2.UnifiedInterstitialADListener
        public final void onNoAD(AdError adError) {
            GDTATInterstitialAdapter.this.notifyATLoadFail(String.valueOf(adError.getErrorCode()), adError.getErrorMsg());
        }

        @Override // com.qq.e.ads.interstitial2.UnifiedInterstitialADListener
        public final void onRenderFail() {
            GDTATInterstitialAdapter.this.notifyATLoadFail("", "GDT: onRenderFail()");
        }

        @Override // com.qq.e.ads.interstitial2.UnifiedInterstitialADListener
        public final void onRenderSuccess() {
            if (((ATBaseAdAdapter) GDTATInterstitialAdapter.this).mLoadListener != null) {
                ((ATBaseAdAdapter) GDTATInterstitialAdapter.this).mLoadListener.onAdCacheLoaded(new BaseAd[0]);
            }
        }

        @Override // com.qq.e.ads.interstitial2.UnifiedInterstitialADListener
        public final void onVideoCached() {
        }
    }

    @Override // com.anythink.core.api.ATBaseAdAdapter
    public void destory() {
        UnifiedInterstitialAD unifiedInterstitialAD = this.a;
        if (unifiedInterstitialAD != null) {
            unifiedInterstitialAD.setMediaListener(null);
            this.a.destroy();
            this.a = null;
        }
    }

    @Override // com.anythink.core.api.ATBaseAdAdapter
    public void getBidRequestInfo(Context context, Map<String, Object> map, Map<String, Object> map2, ATBidRequestInfoListener aTBidRequestInfoListener) {
        this.f12437c = ATInitMediation.getStringFromMap(map, "unit_id");
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
        return this.f12437c;
    }

    @Override // com.anythink.core.api.ATBaseAdAdapter
    public String getNetworkSDKVersion() {
        return GDTATInitManager.getInstance().getNetworkVersion();
    }

    @Override // com.anythink.core.api.ATBaseAdAdapter
    public boolean isAdReady() {
        UnifiedInterstitialAD unifiedInterstitialAD = this.a;
        if (unifiedInterstitialAD != null) {
            return unifiedInterstitialAD.isValid();
        }
        return false;
    }

    @Override // com.anythink.core.api.ATBaseAdAdapter
    public void loadCustomNetworkAd(final Context context, final Map<String, Object> map, final Map<String, Object> map2) {
        this.b = ATInitMediation.getStringFromMap(map, "app_id");
        this.f12437c = ATInitMediation.getStringFromMap(map, "unit_id");
        this.f12439e = ATInitMediation.getIntFromMap(map, "unit_version");
        this.f12438d = ATInitMediation.getStringFromMap(map, "payload");
        if (TextUtils.isEmpty(this.b) || TextUtils.isEmpty(this.f12437c)) {
            notifyATLoadFail("", "GDT appid or unitId is empty.");
        } else {
            GDTATInitManager.getInstance().initSDK(context, map, new MediationInitCallback() { // from class: com.anythink.network.gdt.GDTATInterstitialAdapter.2
                @Override // com.anythink.core.api.MediationInitCallback
                public final void onFail(String str) {
                    GDTATInterstitialAdapter.this.notifyATLoadFail("", str);
                }

                @Override // com.anythink.core.api.MediationInitCallback
                public final void onSuccess() {
                    if (GDTATInterstitialAdapter.this.getMixedFormatAdType() == 0) {
                        GDTATInterstitialAdapter.this.thirdPartyLoad(new GDTATAdapter(), context, map, map2);
                    } else {
                        GDTATInterstitialAdapter.a(GDTATInterstitialAdapter.this, context, map, map2);
                    }
                }
            });
        }
    }

    @Override // com.qq.e.ads.interstitial2.UnifiedInterstitialMediaListener
    public void onVideoComplete() {
        CustomInterstitialEventListener customInterstitialEventListener = this.mImpressListener;
        if (customInterstitialEventListener != null) {
            customInterstitialEventListener.onInterstitialAdVideoEnd();
        }
    }

    @Override // com.qq.e.ads.interstitial2.UnifiedInterstitialMediaListener
    public void onVideoError(AdError adError) {
        GDTATInitManager.getInstance().b();
        CustomInterstitialEventListener customInterstitialEventListener = this.mImpressListener;
        if (customInterstitialEventListener != null) {
            StringBuilder sb = new StringBuilder();
            sb.append(adError.getErrorCode());
            customInterstitialEventListener.onInterstitialAdVideoError(sb.toString(), adError.getErrorMsg());
        }
    }

    @Override // com.qq.e.ads.interstitial2.UnifiedInterstitialMediaListener
    public void onVideoInit() {
    }

    @Override // com.qq.e.ads.interstitial2.UnifiedInterstitialMediaListener
    public void onVideoLoading() {
    }

    @Override // com.qq.e.ads.interstitial2.UnifiedInterstitialMediaListener
    public void onVideoPageClose() {
    }

    @Override // com.qq.e.ads.interstitial2.UnifiedInterstitialMediaListener
    public void onVideoPageOpen() {
    }

    @Override // com.qq.e.ads.interstitial2.UnifiedInterstitialMediaListener
    public void onVideoPause() {
    }

    @Override // com.qq.e.ads.interstitial2.UnifiedInterstitialMediaListener
    public void onVideoReady(long j2) {
    }

    @Override // com.qq.e.ads.interstitial2.UnifiedInterstitialMediaListener
    public void onVideoStart() {
        CustomInterstitialEventListener customInterstitialEventListener = this.mImpressListener;
        if (customInterstitialEventListener != null) {
            customInterstitialEventListener.onInterstitialAdVideoStart();
        }
    }

    @Override // com.anythink.interstitial.unitgroup.api.CustomInterstitialAdapter
    public void show(Activity activity) {
        UnifiedInterstitialAD unifiedInterstitialAD = this.a;
        if (unifiedInterstitialAD != null) {
            unifiedInterstitialAD.setMediaListener(this);
            if (TextUtils.equals("1", this.f12440f)) {
                if (activity != null) {
                    GDTATInitManager.getInstance().a(this.f12437c, this.a);
                    this.a.showFullScreenAD(activity);
                    return;
                }
                return;
            }
            GDTATInitManager.getInstance().a(this.f12437c, this.a);
            if (activity != null) {
                this.a.show(activity);
            } else {
                this.a.show();
            }
        }
    }

    @Override // com.anythink.core.api.ATBaseAdAdapter
    public boolean startBiddingRequest(Context context, Map<String, Object> map, Map<String, Object> map2, ATBiddingListener aTBiddingListener) {
        this.f12442h = true;
        loadCustomNetworkAd(context, map, map2);
        return true;
    }

    private void a(Context context, Map<String, Object> map, Map<String, Object> map2) {
        this.f12440f = ATInitMediation.getStringFromMap(map, "is_fullscreen", "0");
        this.f12441g = ATInitMediation.getBooleanFromMap(map2, ATAdConst.KEY.AD_CLICK_CONFIRM_STATUS, false);
        if (!(context instanceof Activity)) {
            notifyATLoadFail("", "GDT UnifiedInterstitial's context must be activity.");
            return;
        }
        AnonymousClass1 anonymousClass1 = new AnonymousClass1();
        if (TextUtils.isEmpty(this.f12438d) || this.f12442h) {
            this.a = new UnifiedInterstitialAD((Activity) context, this.f12437c, anonymousClass1);
            UnifiedInterstitialAD unifiedInterstitialAD = this.a;
            GDTATInitManager.getInstance();
            unifiedInterstitialAD.setLoadAdParams(GDTATInitManager.a(map));
        } else {
            this.a = new UnifiedInterstitialAD((Activity) context, this.f12437c, anonymousClass1, null, this.f12438d);
        }
        int intFromMap = ATInitMediation.getIntFromMap(map, "video_muted", 0);
        int intFromMap2 = ATInitMediation.getIntFromMap(map, "video_autoplay", 1);
        int intFromMap3 = ATInitMediation.getIntFromMap(map, "video_duration", -1);
        if (this.a != null) {
            this.a.setVideoOption(new VideoOption.Builder().setAutoPlayMuted(intFromMap == 1).setDetailPageMuted(intFromMap == 1).setAutoPlayPolicy(intFromMap2).build());
            if (intFromMap3 != -1) {
                this.a.setMaxVideoDuration(intFromMap3);
            }
        }
        if (TextUtils.equals("1", this.f12440f)) {
            this.a.loadFullScreenAD();
        } else {
            this.a.loadAD();
        }
    }

    private void b(Map<String, Object> map) {
        int intFromMap = ATInitMediation.getIntFromMap(map, "video_muted", 0);
        int intFromMap2 = ATInitMediation.getIntFromMap(map, "video_autoplay", 1);
        int intFromMap3 = ATInitMediation.getIntFromMap(map, "video_duration", -1);
        if (this.a != null) {
            this.a.setVideoOption(new VideoOption.Builder().setAutoPlayMuted(intFromMap == 1).setDetailPageMuted(intFromMap == 1).setAutoPlayPolicy(intFromMap2).build());
            if (intFromMap3 != -1) {
                this.a.setMaxVideoDuration(intFromMap3);
            }
        }
    }

    private void a(Context context, Map<String, Object> map) {
        if (!(context instanceof Activity)) {
            notifyATLoadFail("", "GDT UnifiedInterstitial's context must be activity.");
            return;
        }
        AnonymousClass1 anonymousClass1 = new AnonymousClass1();
        if (!TextUtils.isEmpty(this.f12438d) && !this.f12442h) {
            this.a = new UnifiedInterstitialAD((Activity) context, this.f12437c, anonymousClass1, null, this.f12438d);
        } else {
            this.a = new UnifiedInterstitialAD((Activity) context, this.f12437c, anonymousClass1);
            UnifiedInterstitialAD unifiedInterstitialAD = this.a;
            GDTATInitManager.getInstance();
            unifiedInterstitialAD.setLoadAdParams(GDTATInitManager.a(map));
        }
        int intFromMap = ATInitMediation.getIntFromMap(map, "video_muted", 0);
        int intFromMap2 = ATInitMediation.getIntFromMap(map, "video_autoplay", 1);
        int intFromMap3 = ATInitMediation.getIntFromMap(map, "video_duration", -1);
        if (this.a != null) {
            this.a.setVideoOption(new VideoOption.Builder().setAutoPlayMuted(intFromMap == 1).setDetailPageMuted(intFromMap == 1).setAutoPlayPolicy(intFromMap2).build());
            if (intFromMap3 != -1) {
                this.a.setMaxVideoDuration(intFromMap3);
            }
        }
        if (TextUtils.equals("1", this.f12440f)) {
            this.a.loadFullScreenAD();
        } else {
            this.a.loadAD();
        }
    }

    private void a(Map<String, Object> map) {
        this.b = ATInitMediation.getStringFromMap(map, "app_id");
        this.f12437c = ATInitMediation.getStringFromMap(map, "unit_id");
        this.f12439e = ATInitMediation.getIntFromMap(map, "unit_version");
        this.f12438d = ATInitMediation.getStringFromMap(map, "payload");
    }

    static /* synthetic */ void a(GDTATInterstitialAdapter gDTATInterstitialAdapter, Context context, Map map, Map map2) {
        gDTATInterstitialAdapter.f12440f = ATInitMediation.getStringFromMap(map, "is_fullscreen", "0");
        gDTATInterstitialAdapter.f12441g = ATInitMediation.getBooleanFromMap(map2, ATAdConst.KEY.AD_CLICK_CONFIRM_STATUS, false);
        if (!(context instanceof Activity)) {
            gDTATInterstitialAdapter.notifyATLoadFail("", "GDT UnifiedInterstitial's context must be activity.");
            return;
        }
        AnonymousClass1 anonymousClass1 = gDTATInterstitialAdapter.new AnonymousClass1();
        if (!TextUtils.isEmpty(gDTATInterstitialAdapter.f12438d) && !gDTATInterstitialAdapter.f12442h) {
            gDTATInterstitialAdapter.a = new UnifiedInterstitialAD((Activity) context, gDTATInterstitialAdapter.f12437c, anonymousClass1, null, gDTATInterstitialAdapter.f12438d);
        } else {
            gDTATInterstitialAdapter.a = new UnifiedInterstitialAD((Activity) context, gDTATInterstitialAdapter.f12437c, anonymousClass1);
            UnifiedInterstitialAD unifiedInterstitialAD = gDTATInterstitialAdapter.a;
            GDTATInitManager.getInstance();
            unifiedInterstitialAD.setLoadAdParams(GDTATInitManager.a((Map<String, Object>) map));
        }
        int intFromMap = ATInitMediation.getIntFromMap(map, "video_muted", 0);
        int intFromMap2 = ATInitMediation.getIntFromMap(map, "video_autoplay", 1);
        int intFromMap3 = ATInitMediation.getIntFromMap(map, "video_duration", -1);
        if (gDTATInterstitialAdapter.a != null) {
            gDTATInterstitialAdapter.a.setVideoOption(new VideoOption.Builder().setAutoPlayMuted(intFromMap == 1).setDetailPageMuted(intFromMap == 1).setAutoPlayPolicy(intFromMap2).build());
            if (intFromMap3 != -1) {
                gDTATInterstitialAdapter.a.setMaxVideoDuration(intFromMap3);
            }
        }
        if (TextUtils.equals("1", gDTATInterstitialAdapter.f12440f)) {
            gDTATInterstitialAdapter.a.loadFullScreenAD();
        } else {
            gDTATInterstitialAdapter.a.loadAD();
        }
    }
}
