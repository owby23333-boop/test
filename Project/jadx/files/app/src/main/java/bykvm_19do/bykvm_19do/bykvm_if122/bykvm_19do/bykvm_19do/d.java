package bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_byte12b.l;
import bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_byte12b.m;
import bykvm_19do.bykvm_19do.bykvm_if122.bykvm_try19.p;
import bykvm_19do.bykvm_19do.bykvm_if122.bykvm_try19.u;
import com.bytedance.msdk.adapter.listener.ITTAdapterBannerAdListener;
import com.bytedance.msdk.adapter.util.Logger;
import com.bytedance.msdk.adapter.util.TTLogUtil;
import com.bytedance.msdk.adapter.util.ThreadHelper;
import com.bytedance.msdk.api.AdError;
import com.bytedance.msdk.api.AdSlot;
import com.bytedance.msdk.api.GMAdEcpmInfo;
import com.bytedance.msdk.api.TTRequestExtraParams;
import com.bytedance.msdk.api.v2.GMAdDislike;
import com.bytedance.msdk.api.v2.GMDislikeCallback;
import com.bytedance.msdk.api.v2.ad.banner.GMBannerAdListener;
import com.bytedance.msdk.api.v2.ad.banner.GMBannerAdLoadCallback;
import com.bytedance.msdk.api.v2.ad.banner.GMNativeAdInfo;
import com.bytedance.msdk.api.v2.ad.banner.GMNativeToBannerListener;
import com.bytedance.msdk.api.v2.ad.nativeAd.GMNativeAdAppInfo;
import com.bytedance.msdk.api.v2.ad.nativeAd.GMViewBinder;
import com.bytedance.msdk.api.v2.slot.GMAdSlotBase;
import com.bytedance.msdk.base.TTBaseAd;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class d extends e implements ITTAdapterBannerAdListener {

    /* JADX INFO: renamed from: g0, reason: collision with root package name */
    private GMBannerAdListener f1365g0;

    /* JADX INFO: renamed from: h0, reason: collision with root package name */
    private GMBannerAdLoadCallback f1366h0;

    /* JADX INFO: renamed from: i0, reason: collision with root package name */
    private boolean f1367i0;

    /* JADX INFO: renamed from: j0, reason: collision with root package name */
    private GMNativeToBannerListener f1368j0;

    class a implements GMDislikeCallback {
        final /* synthetic */ View a;

        a(d dVar, View view) {
            this.a = view;
        }

        @Override // com.bytedance.msdk.api.v2.GMDislikeCallback
        public void onCancel() {
        }

        @Override // com.bytedance.msdk.api.v2.GMDislikeCallback
        public void onRefuse() {
        }

        @Override // com.bytedance.msdk.api.v2.GMDislikeCallback
        public void onSelected(int i2, String str) {
            View view = this.a;
            if (view != null) {
                View view2 = (View) view.getParent();
                if (view2 instanceof ViewGroup) {
                    ((ViewGroup) view2).removeViewInLayout(this.a);
                }
            }
        }

        @Override // com.bytedance.msdk.api.v2.GMDislikeCallback
        public void onShow() {
        }
    }

    class b implements Runnable {
        final /* synthetic */ AdError a;

        b(AdError adError) {
            this.a = adError;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (d.this.f1365g0 != null) {
                d.this.f1365g0.onAdShowFail(this.a);
            }
        }
    }

    class c implements GMNativeAdInfo {
        final /* synthetic */ TTBaseAd a;

        c(d dVar, TTBaseAd tTBaseAd) {
            this.a = tTBaseAd;
        }

        @Override // com.bytedance.msdk.api.v2.ad.banner.GMNativeAdInfo
        @Nullable
        public String getActionText() {
            return this.a.getActionText();
        }

        @Override // com.bytedance.msdk.api.v2.ad.banner.GMNativeAdInfo
        public int getAdImageMode() {
            return this.a.getImageMode();
        }

        @Override // com.bytedance.msdk.api.v2.ad.banner.GMNativeAdInfo
        @Nullable
        public String getDescription() {
            return this.a.getAdDescription();
        }

        @Override // com.bytedance.msdk.api.v2.ad.banner.GMNativeAdInfo
        @Nullable
        public GMAdDislike getDislikeDialog(Activity activity) {
            return getDislikeDialog(activity, null);
        }

        @Override // com.bytedance.msdk.api.v2.ad.banner.GMNativeAdInfo
        @Nullable
        public GMAdDislike getDislikeDialog(Activity activity, Map<String, Object> map) {
            return this.a.getDislikeDialog(activity, map);
        }

        @Override // com.bytedance.msdk.api.v2.ad.banner.GMNativeAdInfo
        @Nullable
        public String getIconUrl() {
            return this.a.getIconUrl();
        }

        @Override // com.bytedance.msdk.api.v2.ad.banner.GMNativeAdInfo
        @Nullable
        public List<String> getImageList() {
            return this.a.getImages();
        }

        @Override // com.bytedance.msdk.api.v2.ad.banner.GMNativeAdInfo
        @Nullable
        public String getImageUrl() {
            return this.a.getImageUrl();
        }

        @Override // com.bytedance.msdk.api.v2.ad.banner.GMNativeAdInfo
        public int getInteractionType() {
            return this.a.getInteractionType();
        }

        @Override // com.bytedance.msdk.api.v2.ad.banner.GMNativeAdInfo
        public GMNativeAdAppInfo getNativeAdAppInfo() {
            if (!this.a.hasAppInfo()) {
                return null;
            }
            GMNativeAdAppInfo gMNativeAdAppInfo = new GMNativeAdAppInfo();
            gMNativeAdAppInfo.setAppName(this.a.getAppName());
            gMNativeAdAppInfo.setAuthorName(this.a.getAuthorName());
            gMNativeAdAppInfo.setPackageSizeBytes(this.a.getPackageSizeBytes());
            gMNativeAdAppInfo.setPermissionsUrl(this.a.getPermissionsUrl());
            gMNativeAdAppInfo.setPrivacyAgreement(this.a.getPrivacyAgreement());
            gMNativeAdAppInfo.setVersionName(this.a.getVersionName());
            gMNativeAdAppInfo.setPermissionsMap(this.a.getPermissionsMap());
            gMNativeAdAppInfo.setAppInfoExtra(this.a.getAppInfoExtra());
            return gMNativeAdAppInfo;
        }

        @Override // com.bytedance.msdk.api.v2.ad.banner.GMNativeAdInfo
        @Nullable
        public String getSource() {
            return this.a.getSource();
        }

        @Override // com.bytedance.msdk.api.v2.ad.banner.GMNativeAdInfo
        public double getStarRating() {
            return this.a.getStarRating();
        }

        @Override // com.bytedance.msdk.api.v2.ad.banner.GMNativeAdInfo
        @Nullable
        public String getTitle() {
            return this.a.getAdTitle();
        }

        @Override // com.bytedance.msdk.api.v2.ad.banner.GMNativeAdInfo
        public boolean hasDislike() {
            return this.a.hasDislike();
        }

        @Override // com.bytedance.msdk.api.v2.ad.banner.GMNativeAdInfo
        public void registerView(@NonNull Activity activity, @NonNull ViewGroup viewGroup, @NonNull List<View> list, @Nullable List<View> list2, GMViewBinder gMViewBinder) {
            this.a.registerViewForInteraction(activity, viewGroup, list, list2, null, gMViewBinder);
        }
    }

    public d(Context context, String str) {
        super(context, str);
        this.f1367i0 = false;
    }

    private void b(boolean z2) {
        TTBaseAd tTBaseAd = this.N;
        if (tTBaseAd != null && tTBaseAd.canAdReuse() && bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_for12.bykvm_19do.a.a().c(this.f1617f, this.N.getAdNetworkSlotId(), e())) {
            bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_for12.bykvm_19do.a.a().a(this.N.getAdNetworkSlotId(), this.f1619h, this.f1629r, z2, this.S, this.f1633v, this.H, this.f1634w);
        }
    }

    private GMNativeAdInfo d(TTBaseAd tTBaseAd) {
        return new c(this, tTBaseAd);
    }

    private void d(AdError adError) {
        ThreadHelper.runOnUiThread(new b(adError));
    }

    private View e(TTBaseAd tTBaseAd) {
        this.N = tTBaseAd;
        this.N.setHasShown(true);
        this.N.setTTAdatperCallback(this.I);
        if (this.N.canAdReuse() && bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_for12.bykvm_19do.a.a().c(this.f1617f, this.N.getAdNetworkSlotId(), e())) {
            TTBaseAd tTBaseAd2 = this.N;
            a(tTBaseAd2, tTBaseAd2.getAdNetworkSlotId());
        }
        b(false);
        Logger.d("TTMediationSDK", TTLogUtil.getTagThirdLevelByEvent(this.f1617f, TTLogUtil.TAG_EVENT_SHOW) + "展示的广告类型：" + com.bytedance.msdk.base.a.a(this.N.getAdNetworkPlatformId()) + ",slotId：" + this.N.getAdNetworkSlotId() + ",slotType:" + this.N.getAdNetworkSlotType());
        View adView = this.N.getAdView();
        if (!this.N.isCustomAd() && this.N.getSubAdType() == 4 && this.N.getOriginType() == 2 && !this.N.isExpressAd()) {
            GMNativeToBannerListener gMNativeToBannerListener = this.f1368j0;
            if (gMNativeToBannerListener != null) {
                try {
                    adView = gMNativeToBannerListener.getGMBannerViewFromNativeAd(d(this.N));
                    if (adView == null) {
                        Logger.d("TTMediationSDK", "--==-- banner混出自渲染信息流，getGMBannerViewFromNativeAd()返回null，将无法展示该广告");
                    }
                } catch (Throwable th) {
                    Logger.d("TTMediationSDK", "--==-- banner混出自渲染信息流，getGMBannerViewFromNativeAd()发生异常，将无法展示该广告，信息如下：");
                    th.printStackTrace();
                }
            } else {
                Logger.d("TTMediationSDK", "--==-- banner混出自渲染信息流，但未提供GMNativeToBannerListener，将无法展示该广告");
            }
        }
        if (this.N.hasDislike()) {
            this.N.setDislikeCallback((Activity) this.H, new a(this, adView));
        }
        return adView;
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_new1.e
    public void B() {
        super.B();
        this.f1365g0 = null;
        this.f1366h0 = null;
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_new1.e
    public String H() {
        if (this.f1367i0) {
            return super.H();
        }
        return null;
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_new1.e
    public GMAdEcpmInfo J() {
        if (this.f1367i0) {
            return super.J();
        }
        return null;
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_new1.e
    protected void O() {
        GMBannerAdLoadCallback gMBannerAdLoadCallback = this.f1366h0;
        if (gMBannerAdLoadCallback != null) {
            gMBannerAdLoadCallback.onAdLoaded();
        }
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_new1.e
    protected void P() {
    }

    public void a(AdSlot adSlot, GMAdSlotBase gMAdSlotBase, GMBannerAdLoadCallback gMBannerAdLoadCallback) {
        if (adSlot != null && adSlot.isV2Request()) {
            bykvm_19do.bykvm_19do.bykvm_if122.bykvm_for12.h.a("mediation_v2_banner");
        }
        if (d0()) {
            this.f1619h = bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_case1.b.getShallowCopy(adSlot);
            AdSlot adSlot2 = this.f1619h;
            if (adSlot2 != null) {
                adSlot2.setAdType(1);
                this.f1619h.setAdCount(1);
            }
            this.f1366h0 = gMBannerAdLoadCallback;
            this.I = this;
            this.f1634w = gMAdSlotBase;
            S();
        }
    }

    public void a(GMBannerAdListener gMBannerAdListener) {
        this.f1365g0 = gMBannerAdListener;
    }

    public void a(GMNativeToBannerListener gMNativeToBannerListener) {
        this.f1368j0 = gMNativeToBannerListener;
    }

    public void a(boolean z2) {
        this.f1629r.put(TTRequestExtraParams.PARAM_BANNER_ALLOW_SHOW_CLOSE_BTN, Boolean.valueOf(z2));
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_new1.e
    protected void b(AdError adError) {
        GMBannerAdLoadCallback gMBannerAdLoadCallback = this.f1366h0;
        if (gMBannerAdLoadCallback != null) {
            gMBannerAdLoadCallback.onAdFailedToLoad(adError);
        }
    }

    /*  JADX ERROR: UnsupportedOperationException in pass: RegionMakerVisitor
        java.lang.UnsupportedOperationException
        	at java.base/java.util.Collections$UnmodifiableCollection.add(Unknown Source)
        	at jadx.core.dex.visitors.regions.maker.SwitchRegionMaker$1.leaveRegion(SwitchRegionMaker.java:390)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:70)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.lambda$traverseInternal$0(DepthRegionTraversal.java:68)
        	at java.base/java.util.ArrayList.forEach(Unknown Source)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:68)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverse(DepthRegionTraversal.java:23)
        	at jadx.core.dex.visitors.regions.maker.SwitchRegionMaker.insertBreaksForCase(SwitchRegionMaker.java:370)
        	at jadx.core.dex.visitors.regions.maker.SwitchRegionMaker.insertBreaks(SwitchRegionMaker.java:85)
        	at jadx.core.dex.visitors.regions.PostProcessRegions.leaveRegion(PostProcessRegions.java:33)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:70)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.lambda$traverseInternal$0(DepthRegionTraversal.java:68)
        	at java.base/java.util.ArrayList.forEach(Unknown Source)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:68)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.lambda$traverseInternal$0(DepthRegionTraversal.java:68)
        	at java.base/java.util.ArrayList.forEach(Unknown Source)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:68)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.lambda$traverseInternal$0(DepthRegionTraversal.java:68)
        	at java.base/java.util.ArrayList.forEach(Unknown Source)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:68)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.lambda$traverseInternal$0(DepthRegionTraversal.java:68)
        	at java.base/java.util.ArrayList.forEach(Unknown Source)
        	at java.base/java.util.Collections$UnmodifiableCollection.forEach(Unknown Source)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:68)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.lambda$traverseInternal$0(DepthRegionTraversal.java:68)
        	at java.base/java.util.ArrayList.forEach(Unknown Source)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:68)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.lambda$traverseInternal$0(DepthRegionTraversal.java:68)
        	at java.base/java.util.ArrayList.forEach(Unknown Source)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:68)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.lambda$traverseInternal$0(DepthRegionTraversal.java:68)
        	at java.base/java.util.ArrayList.forEach(Unknown Source)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:68)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverse(DepthRegionTraversal.java:19)
        	at jadx.core.dex.visitors.regions.PostProcessRegions.process(PostProcessRegions.java:23)
        	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:31)
        */
    public android.view.View e0() {
        /*
            Method dump skipped, instruction units count: 570
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.d.e0():android.view.View");
    }

    @VisibleForTesting
    public boolean f0() {
        return ((Boolean) this.f1629r.get(TTRequestExtraParams.PARAM_BANNER_ALLOW_SHOW_CLOSE_BTN)).booleanValue();
    }

    public boolean g0() {
        List<bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_case1.j> listK;
        try {
            listK = K();
        } catch (Throwable th) {
            th.printStackTrace();
            listK = null;
        }
        bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_case1.c cVar = this.f1615d;
        return p.a(this.f1628q, this.f1627p, this.f1626o, this.f1619h, this.L, this.b, l(), e(), listK, cVar != null ? cVar.C() : null);
    }

    public void h0() {
        TTBaseAd tTBaseAd = this.N;
        if (tTBaseAd != null) {
            tTBaseAd.onPause();
        }
    }

    public void i0() {
        TTBaseAd tTBaseAd = this.N;
        if (tTBaseAd != null) {
            tTBaseAd.onResume();
        }
    }

    @Override // com.bytedance.msdk.api.v2.ad.banner.GMBannerAdListener
    public void onAdClicked() {
        GMBannerAdListener gMBannerAdListener = this.f1365g0;
        if (gMBannerAdListener != null) {
            gMBannerAdListener.onAdClicked();
        }
        String strB = u.a(this.N) ? u.b(Thread.currentThread().getStackTrace()) : null;
        TTBaseAd tTBaseAd = this.N;
        bykvm_19do.bykvm_19do.bykvm_if122.bykvm_for12.h.a(tTBaseAd, this.f1619h, 0, strB, tTBaseAd.isClickListenRepeatOnce());
    }

    @Override // com.bytedance.msdk.api.v2.ad.banner.GMBannerAdListener
    public void onAdClosed() {
        GMBannerAdListener gMBannerAdListener = this.f1365g0;
        if (gMBannerAdListener != null) {
            gMBannerAdListener.onAdClosed();
        }
    }

    @Override // com.bytedance.msdk.api.v2.ad.banner.GMBannerAdListener
    public void onAdLeftApplication() {
        GMBannerAdListener gMBannerAdListener = this.f1365g0;
        if (gMBannerAdListener != null) {
            gMBannerAdListener.onAdLeftApplication();
        }
    }

    @Override // com.bytedance.msdk.api.v2.ad.banner.GMBannerAdListener
    public void onAdOpened() {
        GMBannerAdListener gMBannerAdListener = this.f1365g0;
        if (gMBannerAdListener != null) {
            gMBannerAdListener.onAdOpened();
        }
    }

    @Override // com.bytedance.msdk.api.v2.ad.banner.GMBannerAdListener
    public void onAdShow() {
        this.f1367i0 = true;
        if (this.f1365g0 != null) {
            m.b().a(this.f1617f + "");
            m.b().j(this.f1617f + "");
            this.f1365g0.onAdShow();
        }
        if (this.N != null) {
            Logger.d("TTMediationSDK", TTLogUtil.getTagThirdLevelByEvent(this.f1617f, TTLogUtil.TAG_EVENT_SHOW_LISTEN) + "adSlotId：" + this.N.getAdNetworkSlotId() + "，广告类型：" + com.bytedance.msdk.base.a.a(this.N.getAdNetworkPlatformId()));
            bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_byte12b.k.b().a(this.f1617f, this.N.getAdNetworkSlotId());
            l.b().e(this.f1617f, this.N.getAdNetworkSlotId());
        }
        b(true);
        bykvm_19do.bykvm_19do.bykvm_if122.bykvm_for12.h.b(this.N, this.f1619h, 0, u.a(this.N) ? u.b(Thread.currentThread().getStackTrace()) : null, false);
        bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_long108.b.c().b(this.N.getAdType(), this.N.getCpm());
        bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_new1.g.b(this.f1617f, this.N);
    }

    @Override // com.bytedance.msdk.api.v2.ad.banner.GMBannerAdListener
    public void onAdShowFail(AdError adError) {
        bykvm_19do.bykvm_19do.bykvm_if122.bykvm_for12.h.a(this.N, this.f1619h, adError, 1, 0, u.a(this.N) ? u.b(Thread.currentThread().getStackTrace()) : null);
        d(adError);
    }
}
