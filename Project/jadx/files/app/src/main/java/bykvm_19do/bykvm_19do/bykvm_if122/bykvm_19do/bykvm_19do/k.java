package bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.VisibleForTesting;
import bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_byte12b.l;
import bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_byte12b.m;
import bykvm_19do.bykvm_19do.bykvm_if122.bykvm_try19.p;
import bykvm_19do.bykvm_19do.bykvm_if122.bykvm_try19.u;
import com.bytedance.msdk.adapter.listener.ITTAdapterSplashAdListener;
import com.bytedance.msdk.adapter.listener.ITTAdatperCallback;
import com.bytedance.msdk.adapter.util.Logger;
import com.bytedance.msdk.adapter.util.TTLogUtil;
import com.bytedance.msdk.adapter.util.ThreadHelper;
import com.bytedance.msdk.api.AdError;
import com.bytedance.msdk.api.AdSlot;
import com.bytedance.msdk.api.TTRequestExtraParams;
import com.bytedance.msdk.api.v2.GMNetworkRequestInfo;
import com.bytedance.msdk.api.v2.ad.splash.GMSplashAdListener;
import com.bytedance.msdk.api.v2.ad.splash.GMSplashAdLoadCallback;
import com.bytedance.msdk.api.v2.ad.splash.GMSplashCardListener;
import com.bytedance.msdk.api.v2.ad.splash.GMSplashMinWindowListener;
import com.bytedance.msdk.api.v2.slot.GMAdSlotSplash;
import com.bytedance.msdk.base.TTBaseAd;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class k extends e implements ITTAdapterSplashAdListener {

    /* JADX INFO: renamed from: g0, reason: collision with root package name */
    private GMSplashAdLoadCallback f1394g0;

    /* JADX INFO: renamed from: h0, reason: collision with root package name */
    private GMSplashAdListener f1395h0;

    /* JADX INFO: renamed from: i0, reason: collision with root package name */
    private GMSplashMinWindowListener f1396i0;

    /* JADX INFO: renamed from: j0, reason: collision with root package name */
    private GMSplashCardListener f1397j0;

    class a implements Runnable {
        final /* synthetic */ AdError a;

        a(AdError adError) {
            this.a = adError;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (k.this.f1395h0 != null) {
                k.this.f1395h0.onAdShowFail(this.a);
            }
        }
    }

    public k(Activity activity, View view, String str) {
        super(activity, str);
    }

    public k(Activity activity, String str) {
        super(activity, str);
    }

    private void a(TTBaseAd tTBaseAd, ViewGroup viewGroup) {
        this.N = tTBaseAd;
        this.N.setHasShown(true);
        this.N.setTTAdatperCallback(this.I);
        if (this.N.canAdReuse() && bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_for12.bykvm_19do.a.a().c(this.f1617f, this.N.getAdNetworkSlotId(), e())) {
            TTBaseAd tTBaseAd2 = this.N;
            a(tTBaseAd2, tTBaseAd2.getAdNetworkSlotId());
        }
        Logger.d("TTMediationSDK", TTLogUtil.getTagThirdLevelByEvent(this.f1617f, TTLogUtil.TAG_EVENT_SHOW) + "展示的广告类型：" + com.bytedance.msdk.base.a.a(this.N.getAdNetworkPlatformId()) + ",slotId：" + this.N.getAdNetworkSlotId() + ",slotType:" + this.N.getAdNetworkSlotType());
        m mVarB = m.b();
        StringBuilder sb = new StringBuilder();
        sb.append(this.f1617f);
        sb.append("");
        mVarB.j(sb.toString());
        l.b().e(this.f1617f, this.N.getAdNetworkSlotId());
        this.N.showSplashAd(viewGroup);
    }

    private void d(AdError adError) {
        ThreadHelper.runOnUiThread(new a(adError));
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_new1.e
    public void B() {
        super.B();
        this.f1395h0 = null;
        this.f1394g0 = null;
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_new1.e
    protected void O() {
        GMSplashAdLoadCallback gMSplashAdLoadCallback = this.f1394g0;
        if (gMSplashAdLoadCallback != null) {
            gMSplashAdLoadCallback.onSplashAdLoadSuccess();
        }
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_new1.e
    protected void P() {
    }

    public void a(AdSlot adSlot, GMAdSlotSplash gMAdSlotSplash, GMNetworkRequestInfo gMNetworkRequestInfo, GMSplashAdLoadCallback gMSplashAdLoadCallback) {
        a(adSlot, gMAdSlotSplash, gMNetworkRequestInfo, gMSplashAdLoadCallback, -1);
    }

    public void a(AdSlot adSlot, GMAdSlotSplash gMAdSlotSplash, GMNetworkRequestInfo gMNetworkRequestInfo, GMSplashAdLoadCallback gMSplashAdLoadCallback, int i2) {
        if (adSlot != null && adSlot.isV2Request()) {
            bykvm_19do.bykvm_19do.bykvm_if122.bykvm_for12.h.a("mediation_v2_splash");
        }
        if (d0()) {
            this.f1619h = bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_case1.b.getShallowCopy(adSlot);
            AdSlot adSlot2 = this.f1619h;
            if (adSlot2 != null) {
                adSlot2.setAdType(3);
                this.f1619h.setAdCount(1);
            }
            this.S = gMNetworkRequestInfo;
            this.f1394g0 = gMSplashAdLoadCallback;
            if (i2 != -1) {
                this.f1629r.put(TTRequestExtraParams.PARAM_AD_LOAD_TIMEOUT, Integer.valueOf(i2));
            }
            this.I = this;
            this.f1634w = gMAdSlotSplash;
            S();
        }
    }

    public void a(GMSplashAdListener gMSplashAdListener) {
        this.f1395h0 = gMSplashAdListener;
    }

    public void a(GMSplashCardListener gMSplashCardListener) {
        this.f1397j0 = gMSplashCardListener;
    }

    public void a(GMSplashMinWindowListener gMSplashMinWindowListener) {
        this.f1396i0 = gMSplashMinWindowListener;
    }

    public boolean a(Rect rect, ITTAdatperCallback iTTAdatperCallback) {
        TTBaseAd tTBaseAd = this.N;
        if (tTBaseAd == null || tTBaseAd.getAdNetworkPlatformId() != 7) {
            return false;
        }
        this.N.showMinWindow(rect, iTTAdatperCallback);
        return true;
    }

    /* JADX WARN: Removed duplicated region for block: B:60:0x0131  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x014d  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x0168  */
    /* JADX WARN: Removed duplicated region for block: B:98:0x014b A[EDGE_INSN: B:98:0x014b->B:67:0x014b BREAK  A[LOOP:1: B:58:0x012b->B:102:0x012b], SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void b(android.view.ViewGroup r11) {
        /*
            Method dump skipped, instruction units count: 393
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.k.b(android.view.ViewGroup):void");
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_new1.e
    protected void b(AdError adError) {
        GMSplashAdLoadCallback gMSplashAdLoadCallback = this.f1394g0;
        if (gMSplashAdLoadCallback != null) {
            gMSplashAdLoadCallback.onSplashAdLoadFail(adError);
        }
    }

    protected void e0() {
        if (this.N.canAdReuse() && bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_for12.bykvm_19do.a.a().c(this.f1617f, this.N.getAdNetworkSlotId(), e())) {
            bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_for12.bykvm_19do.a.a().a(this.N.getAdNetworkSlotId(), this.f1619h, this.f1629r, true, this.S, this.f1633v, this.H, this.f1634w);
        }
    }

    public int[] f0() {
        TTBaseAd tTBaseAd = this.N;
        if (tTBaseAd == null) {
            return null;
        }
        tTBaseAd.getMinWindowSize();
        return null;
    }

    public Bitmap g0() {
        TTBaseAd tTBaseAd = this.N;
        if (tTBaseAd == null) {
            return null;
        }
        tTBaseAd.getSplashBitMap();
        return null;
    }

    @Override // com.bytedance.msdk.adapter.listener.ITTAdapterSplashAdListener
    public Activity getActivity() {
        GMSplashCardListener gMSplashCardListener = this.f1397j0;
        if (gMSplashCardListener != null) {
            return gMSplashCardListener.getActivity();
        }
        return null;
    }

    @VisibleForTesting
    public int h0() {
        return ((Integer) this.f1629r.get(TTRequestExtraParams.PARAM_AD_LOAD_TIMEOUT)).intValue();
    }

    public boolean i0() {
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

    public void j0() {
        TTBaseAd tTBaseAd = this.N;
        if (tTBaseAd != null) {
            tTBaseAd.splashMinWindowAnimationFinish();
        }
    }

    public void k(int i2) {
        this.f1629r.put(TTRequestExtraParams.PARAM_AD_LOAD_TIMEOUT, Integer.valueOf(i2));
    }

    @Override // com.bytedance.msdk.api.v2.ad.splash.GMSplashAdListener
    public void onAdClicked() {
        GMSplashAdListener gMSplashAdListener = this.f1395h0;
        if (gMSplashAdListener != null) {
            gMSplashAdListener.onAdClicked();
        }
        String strB = u.a(this.N) ? u.b(Thread.currentThread().getStackTrace()) : null;
        TTBaseAd tTBaseAd = this.N;
        bykvm_19do.bykvm_19do.bykvm_if122.bykvm_for12.h.a(tTBaseAd, this.f1619h, 0, strB, tTBaseAd.isClickListenRepeatOnce());
    }

    @Override // com.bytedance.msdk.api.v2.ad.splash.GMSplashAdListener
    public void onAdDismiss() {
        GMSplashAdListener gMSplashAdListener = this.f1395h0;
        if (gMSplashAdListener != null) {
            gMSplashAdListener.onAdDismiss();
        }
        bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_for12.bykvm_if122.b.d().a(this.H, this.f1617f, e());
    }

    @Override // com.bytedance.msdk.api.v2.ad.splash.GMSplashAdListener
    public void onAdShow() {
        GMSplashAdListener gMSplashAdListener = this.f1395h0;
        if (gMSplashAdListener != null) {
            gMSplashAdListener.onAdShow();
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

    @Override // com.bytedance.msdk.api.v2.ad.splash.GMSplashAdListener
    public void onAdShowFail(AdError adError) {
        bykvm_19do.bykvm_19do.bykvm_if122.bykvm_for12.h.a(this.N, this.f1619h, adError, 1, 0, u.a(this.N) ? u.b(Thread.currentThread().getStackTrace()) : null);
        d(adError);
    }

    @Override // com.bytedance.msdk.api.v2.ad.splash.GMSplashAdListener
    public void onAdSkip() {
        GMSplashAdListener gMSplashAdListener = this.f1395h0;
        if (gMSplashAdListener != null) {
            gMSplashAdListener.onAdSkip();
        }
        bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_for12.bykvm_if122.b.d().a(this.H, this.f1617f, e());
    }

    @Override // com.bytedance.msdk.adapter.listener.ITTAdapterSplashAdListener
    public void onMinWindowPlayFinish() {
        GMSplashMinWindowListener gMSplashMinWindowListener = this.f1396i0;
        if (gMSplashMinWindowListener != null) {
            gMSplashMinWindowListener.onMinWindowPlayFinish();
        }
    }

    @Override // com.bytedance.msdk.adapter.listener.ITTAdapterSplashAdListener
    public void onMinWindowStart() {
        GMSplashMinWindowListener gMSplashMinWindowListener = this.f1396i0;
        if (gMSplashMinWindowListener != null) {
            gMSplashMinWindowListener.onMinWindowStart();
        }
    }

    @Override // com.bytedance.msdk.adapter.listener.ITTAdapterSplashAdListener
    public void onSplashCardClick() {
        GMSplashCardListener gMSplashCardListener = this.f1397j0;
        if (gMSplashCardListener != null) {
            gMSplashCardListener.onSplashCardClick();
        }
    }

    @Override // com.bytedance.msdk.adapter.listener.ITTAdapterSplashAdListener
    public void onSplashClickEyeClick() {
        GMSplashCardListener gMSplashCardListener = this.f1397j0;
        if (gMSplashCardListener != null) {
            gMSplashCardListener.onSplashClickEyeClick();
        }
    }

    @Override // com.bytedance.msdk.adapter.listener.ITTAdapterSplashAdListener
    public void onSplashClickEyeClose() {
        GMSplashCardListener gMSplashCardListener = this.f1397j0;
        if (gMSplashCardListener != null) {
            gMSplashCardListener.onSplashClickEyeClose();
        }
    }

    @Override // com.bytedance.msdk.adapter.listener.ITTAdapterSplashAdListener
    public void onSplashEyeReady() {
        GMSplashCardListener gMSplashCardListener = this.f1397j0;
        if (gMSplashCardListener != null) {
            gMSplashCardListener.onSplashEyeReady();
        }
    }

    @Override // com.bytedance.msdk.adapter.listener.ITTAdapterSplashAdListener
    public void setSupportSplashClickEye(boolean z2) {
        GMSplashCardListener gMSplashCardListener = this.f1397j0;
        if (gMSplashCardListener != null) {
            gMSplashCardListener.setSupportSplashClickEye(z2);
        }
    }
}
