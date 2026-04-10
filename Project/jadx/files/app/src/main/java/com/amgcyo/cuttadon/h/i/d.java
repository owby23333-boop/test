package com.amgcyo.cuttadon.h.i;

import android.app.Activity;
import com.amgcyo.cuttadon.api.entity.adbean.NormalAdParams;
import com.amgcyo.cuttadon.f.o;
import com.amgcyo.cuttadon.sdk.utils.AdFrameLayout;
import com.anythink.core.api.ATAdConst;
import com.anythink.core.api.ATAdInfo;
import com.anythink.core.api.AdError;
import com.anythink.nativead.api.ATNative;
import com.anythink.nativead.api.ATNativeAdView;
import com.anythink.nativead.api.ATNativeDislikeListener;
import com.anythink.nativead.api.ATNativeEventListener;
import com.anythink.nativead.api.ATNativeNetworkListener;
import com.anythink.nativead.api.ATNativePrepareInfo;
import com.anythink.nativead.api.NativeAd;
import com.anythink.network.gdt.GDTATConst;
import com.anythink.network.toutiao.TTATConst;
import com.sntech.ads.api.event.SNEvent;
import java.util.HashMap;

/* JADX INFO: compiled from: ToponFeedManager.java */
/* JADX INFO: loaded from: classes.dex */
public class d extends com.amgcyo.cuttadon.h.d.a {
    private Activity b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private ATNative f3990c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private NativeAd f3991d;

    /* JADX INFO: compiled from: ToponFeedManager.java */
    class a implements ATNativeNetworkListener {
        final /* synthetic */ AdFrameLayout a;
        final /* synthetic */ NormalAdParams b;

        /* JADX INFO: renamed from: com.amgcyo.cuttadon.h.i.d$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: ToponFeedManager.java */
        class C0103a implements ATNativeEventListener {
            C0103a(a aVar) {
            }

            @Override // com.anythink.nativead.api.ATNativeEventListener
            public void onAdClicked(ATNativeAdView aTNativeAdView, ATAdInfo aTAdInfo) {
                String str = "living native ad onAdClicked:\n" + aTAdInfo.toString();
                com.amgcyo.cuttadon.h.j.a.c(aTAdInfo);
            }

            @Override // com.anythink.nativead.api.ATNativeEventListener
            public void onAdImpressed(ATNativeAdView aTNativeAdView, ATAdInfo aTAdInfo) {
                String str = "living native ad onAdImpressed:\n" + aTAdInfo.toString();
                com.amgcyo.cuttadon.h.j.a.d(aTAdInfo);
                com.amgcyo.cuttadon.h.j.a.a(SNEvent.AdType.EXPRESS_FEED, aTAdInfo);
            }

            @Override // com.anythink.nativead.api.ATNativeEventListener
            public void onAdVideoEnd(ATNativeAdView aTNativeAdView) {
            }

            @Override // com.anythink.nativead.api.ATNativeEventListener
            public void onAdVideoProgress(ATNativeAdView aTNativeAdView, int i2) {
                String str = "living native ad onAdVideoProgress:" + i2;
            }

            @Override // com.anythink.nativead.api.ATNativeEventListener
            public void onAdVideoStart(ATNativeAdView aTNativeAdView) {
            }
        }

        /* JADX INFO: compiled from: ToponFeedManager.java */
        class b extends ATNativeDislikeListener {
            b() {
            }

            @Override // com.anythink.nativead.api.ATNativeDislikeListener
            public void onAdCloseButtonClick(ATNativeAdView aTNativeAdView, ATAdInfo aTAdInfo) {
                if (a.this.a.getChildCount() > 0) {
                    a.this.a.removeAllViews();
                }
                com.amgcyo.cuttadon.h.a.c.a(((com.amgcyo.cuttadon.h.d.a) d.this).a, 0L);
            }
        }

        a(AdFrameLayout adFrameLayout, NormalAdParams normalAdParams) {
            this.a = adFrameLayout;
            this.b = normalAdParams;
        }

        @Override // com.anythink.nativead.api.ATNativeNetworkListener
        public void onNativeAdLoadFail(AdError adError) {
            String str = "living onNativeAdLoadFail:" + adError.getFullErrorInfo();
            AdFrameLayout adFrameLayout = this.a;
            if (adFrameLayout != null) {
                adFrameLayout.a(adError.getFullErrorInfo(), 0);
            }
            o.g("living 信息流广告加载失败：" + adError.getFullErrorInfo());
        }

        @Override // com.anythink.nativead.api.ATNativeNetworkListener
        public void onNativeAdLoaded() {
            NativeAd nativeAd;
            AdFrameLayout adFrameLayout;
            boolean zIsReady = d.this.f3990c.checkAdStatus().isReady();
            String str = "living onNativeAdLoaded isReady: " + zIsReady;
            if (!zIsReady || (nativeAd = d.this.f3990c.getNativeAd()) == null) {
                return;
            }
            if (d.this.f3991d != null) {
                d.this.f3991d.destory();
            }
            d.this.f3991d = nativeAd;
            d.this.f3991d.setNativeEventListener(new C0103a(this));
            ATNativePrepareInfo aTNativePrepareInfo = new ATNativePrepareInfo();
            boolean zIsNativeExpress = d.this.f3991d.isNativeExpress();
            String str2 = "living 是否为模板渲染类型的广告:" + zIsNativeExpress;
            if (!zIsNativeExpress || (adFrameLayout = this.a) == null) {
                return;
            }
            adFrameLayout.removeAllViews();
            if (this.a.getVisibility() == 8) {
                this.a.setVisibility(0);
            }
            ATNativeAdView aTNativeAdView = new ATNativeAdView(this.a.getContext());
            this.a.addView(aTNativeAdView);
            nativeAd.renderAdContainer(aTNativeAdView, null);
            d.this.f3991d.prepare(aTNativeAdView, aTNativePrepareInfo);
            d.this.f3991d.onResume();
            ((com.amgcyo.cuttadon.h.d.a) d.this).a = this.b.getStochasticKey();
            d.this.f3991d.setDislikeCallbackListener(new b());
            com.amgcyo.cuttadon.h.a.c.c(((com.amgcyo.cuttadon.h.d.a) d.this).a);
            com.amgcyo.cuttadon.h.i.g.b.a().a(d.this.b, this.b);
        }
    }

    d(Activity activity) {
        this.b = activity;
    }

    void a(NormalAdParams normalAdParams, AdFrameLayout adFrameLayout) {
        String adUnitId = normalAdParams.getAdUnitId();
        int adWidth = normalAdParams.getAdWidth();
        int adHeight = normalAdParams.getAdHeight();
        String str = "living loadFeedAd adWidthPx: " + adWidth + " adHeightPx: " + adHeight;
        this.f3990c = new ATNative(this.b, adUnitId, new a(adFrameLayout, normalAdParams));
        HashMap map = new HashMap();
        map.put(ATAdConst.KEY.AD_WIDTH, Integer.valueOf(adWidth));
        map.put(ATAdConst.KEY.AD_HEIGHT, Integer.valueOf(adHeight));
        map.put(TTATConst.NATIVE_AD_IMAGE_HEIGHT, 0);
        map.put(GDTATConst.AD_HEIGHT, -2);
        this.f3990c.setLocalExtra(map);
        this.f3990c.setAdSourceStatusListener(new com.amgcyo.cuttadon.h.i.a("信息流", "ToponFeedManager"));
        this.f3990c.makeAdRequest();
    }
}
