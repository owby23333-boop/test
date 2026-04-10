package bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do;

import android.app.Activity;
import android.content.Context;
import bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_byte12b.m;
import bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_new1.d;
import bykvm_19do.bykvm_19do.bykvm_if122.bykvm_try19.u;
import com.bytedance.msdk.adapter.listener.ITTAdapterInterstitialListener;
import com.bytedance.msdk.adapter.util.Logger;
import com.bytedance.msdk.adapter.util.TTLogUtil;
import com.bytedance.msdk.adapter.util.ThreadHelper;
import com.bytedance.msdk.api.AdError;
import com.bytedance.msdk.api.AdSlot;
import com.bytedance.msdk.api.v2.ad.interstitial.GMInterstitialAdListener;
import com.bytedance.msdk.api.v2.ad.interstitial.GMInterstitialAdLoadCallback;
import com.bytedance.msdk.api.v2.slot.GMAdSlotInterstitial;
import com.bytedance.msdk.base.TTBaseAd;

/* JADX INFO: loaded from: classes.dex */
public class c extends bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_new1.d implements ITTAdapterInterstitialListener {

    /* JADX INFO: renamed from: h0, reason: collision with root package name */
    private GMInterstitialAdLoadCallback f1363h0;

    /* JADX INFO: renamed from: i0, reason: collision with root package name */
    private GMInterstitialAdListener f1364i0;

    class a implements d.c {
        a() {
        }

        @Override // bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_new1.d.c
        public void a() {
            c.this.d(new AdError(AdError.ERROR_CODE_SHOW_FAIL_NO_AD, AdError.getMessage(AdError.ERROR_CODE_SHOW_FAIL_NO_AD)));
        }
    }

    class b implements Runnable {
        final /* synthetic */ AdError a;

        b(AdError adError) {
            this.a = adError;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (c.this.f1364i0 != null) {
                c.this.f1364i0.onInterstitialShowFail(this.a);
            }
        }
    }

    public c(Context context, String str) {
        super(context, str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(AdError adError) {
        ThreadHelper.runOnUiThread(new b(adError));
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_new1.e
    public void B() {
        super.B();
        this.f1364i0 = null;
        this.f1363h0 = null;
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_new1.e
    protected void O() {
        GMInterstitialAdLoadCallback gMInterstitialAdLoadCallback = this.f1363h0;
        if (gMInterstitialAdLoadCallback != null) {
            gMInterstitialAdLoadCallback.onInterstitialLoad();
        }
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_new1.e
    protected void P() {
    }

    public void a(Activity activity) {
        a(activity, new a());
    }

    public void a(AdSlot adSlot, GMAdSlotInterstitial gMAdSlotInterstitial, GMInterstitialAdLoadCallback gMInterstitialAdLoadCallback) {
        if (adSlot != null && adSlot.isV2Request()) {
            bykvm_19do.bykvm_19do.bykvm_if122.bykvm_for12.h.a("mediation_v2_interstitial");
        }
        if (d0()) {
            this.f1619h = bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_case1.b.getShallowCopy(adSlot);
            AdSlot adSlot2 = this.f1619h;
            if (adSlot2 != null) {
                adSlot2.setAdType(2);
                this.f1619h.setAdCount(1);
            }
            this.f1363h0 = gMInterstitialAdLoadCallback;
            this.I = this;
            this.f1634w = gMAdSlotInterstitial;
            S();
        }
    }

    public void a(GMInterstitialAdListener gMInterstitialAdListener) {
        this.f1364i0 = gMInterstitialAdListener;
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_new1.e
    protected void b(AdError adError) {
        GMInterstitialAdLoadCallback gMInterstitialAdLoadCallback = this.f1363h0;
        if (gMInterstitialAdLoadCallback != null) {
            gMInterstitialAdLoadCallback.onInterstitialLoadFail(adError);
        }
    }

    @Override // com.bytedance.msdk.api.v2.ad.interstitial.GMInterstitialAdListener
    public void onAdLeftApplication() {
        GMInterstitialAdListener gMInterstitialAdListener = this.f1364i0;
        if (gMInterstitialAdListener != null) {
            gMInterstitialAdListener.onAdLeftApplication();
        }
    }

    @Override // com.bytedance.msdk.api.v2.ad.interstitial.GMInterstitialAdListener
    public void onAdOpened() {
        GMInterstitialAdListener gMInterstitialAdListener = this.f1364i0;
        if (gMInterstitialAdListener != null) {
            gMInterstitialAdListener.onAdOpened();
        }
    }

    @Override // com.bytedance.msdk.api.v2.ad.interstitial.GMInterstitialAdListener
    public void onInterstitialAdClick() {
        GMInterstitialAdListener gMInterstitialAdListener = this.f1364i0;
        if (gMInterstitialAdListener != null) {
            gMInterstitialAdListener.onInterstitialAdClick();
        }
        String strB = u.a(this.N) ? u.b(Thread.currentThread().getStackTrace()) : null;
        TTBaseAd tTBaseAd = this.N;
        bykvm_19do.bykvm_19do.bykvm_if122.bykvm_for12.h.a(tTBaseAd, this.f1619h, 0, strB, tTBaseAd.isClickListenRepeatOnce());
    }

    @Override // com.bytedance.msdk.api.v2.ad.interstitial.GMInterstitialAdListener
    public void onInterstitialClosed() {
        GMInterstitialAdListener gMInterstitialAdListener = this.f1364i0;
        if (gMInterstitialAdListener != null) {
            gMInterstitialAdListener.onInterstitialClosed();
        }
    }

    @Override // com.bytedance.msdk.api.v2.ad.interstitial.GMInterstitialAdListener
    public void onInterstitialShow() {
        GMInterstitialAdListener gMInterstitialAdListener = this.f1364i0;
        if (gMInterstitialAdListener != null) {
            gMInterstitialAdListener.onInterstitialShow();
        }
        m.b().a(this.f1617f + "");
        if (this.N != null) {
            Logger.d("TTMediationSDK", TTLogUtil.getTagThirdLevelByEvent(this.f1617f, TTLogUtil.TAG_EVENT_SHOW_LISTEN) + "adSlotId：" + this.N.getAdNetworkSlotId() + "，广告类型：" + com.bytedance.msdk.base.a.a(this.N.getAdNetworkPlatformId()));
            bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_byte12b.k.b().a(this.f1617f, this.N.getAdNetworkSlotId());
        }
        e0();
        bykvm_19do.bykvm_19do.bykvm_if122.bykvm_for12.h.b(this.N, this.f1619h, 0, u.a(this.N) ? u.b(Thread.currentThread().getStackTrace()) : null, false);
        bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_long108.b.c().b(this.N.getAdType(), this.N.getCpm());
        bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_new1.g.b(this.f1617f, this.N);
    }

    @Override // com.bytedance.msdk.api.v2.ad.interstitial.GMInterstitialAdListener
    public void onInterstitialShowFail(AdError adError) {
        bykvm_19do.bykvm_19do.bykvm_if122.bykvm_for12.h.a(this.N, this.f1619h, adError, 1, 0, u.a(this.N) ? u.b(Thread.currentThread().getStackTrace()) : null);
        d(adError);
    }
}
