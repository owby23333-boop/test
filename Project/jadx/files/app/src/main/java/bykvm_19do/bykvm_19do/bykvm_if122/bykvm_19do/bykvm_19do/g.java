package bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do;

import android.app.Activity;
import android.content.Context;
import androidx.annotation.MainThread;
import androidx.annotation.NonNull;
import bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_new1.d;
import bykvm_19do.bykvm_19do.bykvm_if122.bykvm_try19.r;
import bykvm_19do.bykvm_19do.bykvm_if122.bykvm_try19.u;
import com.bytedance.msdk.adapter.listener.ITTAdapterFullVideoAdListener;
import com.bytedance.msdk.adapter.util.Logger;
import com.bytedance.msdk.adapter.util.ThreadHelper;
import com.bytedance.msdk.api.AdError;
import com.bytedance.msdk.api.AdSlot;
import com.bytedance.msdk.api.TTAdConstant;
import com.bytedance.msdk.api.TTVideoOptionUtil;
import com.bytedance.msdk.api.reward.RewardItem;
import com.bytedance.msdk.api.v2.ad.fullvideo.GMFullVideoAdListener;
import com.bytedance.msdk.api.v2.ad.fullvideo.GMFullVideoAdLoadCallback;
import com.bytedance.msdk.api.v2.slot.GMAdSlotFullVideo;
import com.bytedance.msdk.base.TTBaseAd;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class g extends bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_new1.d implements ITTAdapterFullVideoAdListener {

    /* JADX INFO: renamed from: h0, reason: collision with root package name */
    private GMFullVideoAdLoadCallback f1371h0;

    /* JADX INFO: renamed from: i0, reason: collision with root package name */
    private GMFullVideoAdListener f1372i0;

    class a implements d.c {
        a() {
        }

        @Override // bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_new1.d.c
        public void a() {
            g.this.d(new AdError(AdError.ERROR_CODE_SHOW_FAIL_NO_AD, AdError.getMessage(AdError.ERROR_CODE_SHOW_FAIL_NO_AD)));
        }
    }

    class b implements Runnable {
        final /* synthetic */ AdError a;

        b(AdError adError) {
            this.a = adError;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (g.this.f1372i0 != null) {
                g.this.f1372i0.onFullVideoAdShowFail(this.a);
            }
        }
    }

    public g(Context context, String str) {
        super(context, str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(AdError adError) {
        ThreadHelper.runOnUiThread(new b(adError));
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_new1.e
    public void B() {
        super.B();
        this.f1372i0 = null;
        this.f1371h0 = null;
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_new1.e
    protected void O() {
        GMFullVideoAdLoadCallback gMFullVideoAdLoadCallback = this.f1371h0;
        if (gMFullVideoAdLoadCallback != null) {
            gMFullVideoAdLoadCallback.onFullVideoAdLoad();
        }
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_new1.e
    protected void P() {
        GMFullVideoAdLoadCallback gMFullVideoAdLoadCallback = this.f1371h0;
        if (gMFullVideoAdLoadCallback != null) {
            gMFullVideoAdLoadCallback.onFullVideoCached();
        }
    }

    @MainThread
    public void a(Activity activity, Map<TTAdConstant.GroMoreExtraKey, Object> map) {
        super.a(activity, map, new a());
        if (this.f1372i0 == null) {
            Logger.d("TTMediationSDK", "注意：未设置GMFullVideoAdListener，将收不到广告播放/点击/关闭等回调信息");
        }
    }

    public void a(AdSlot adSlot, GMAdSlotFullVideo gMAdSlotFullVideo, @NonNull GMFullVideoAdLoadCallback gMFullVideoAdLoadCallback) {
        if (adSlot != null && adSlot.isV2Request()) {
            bykvm_19do.bykvm_19do.bykvm_if122.bykvm_for12.h.a("mediation_v2_full_video");
        }
        if (d0()) {
            this.f1371h0 = gMFullVideoAdLoadCallback;
            this.f1619h = bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_case1.b.getShallowCopy(adSlot);
            AdSlot adSlot2 = this.f1619h;
            if (adSlot2 != null) {
                adSlot2.setAdType(8);
                this.f1619h.setAdCount(1);
                TTVideoOptionUtil.setFullTTVideoOptionIfNeed(this.f1619h);
            }
            this.I = this;
            this.f1634w = gMAdSlotFullVideo;
            S();
        }
    }

    public void a(GMFullVideoAdListener gMFullVideoAdListener) {
        this.f1372i0 = gMFullVideoAdListener;
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_new1.e
    protected void b(AdError adError) {
        GMFullVideoAdLoadCallback gMFullVideoAdLoadCallback = this.f1371h0;
        if (gMFullVideoAdLoadCallback != null) {
            gMFullVideoAdLoadCallback.onFullVideoLoadFail(adError);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x004f  */
    @Override // com.bytedance.msdk.api.v2.ad.fullvideo.GMFullVideoAdListener
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void onFullVideoAdClick() {
        /*
            r8 = this;
            boolean r0 = bykvm_19do.bykvm_19do.bykvm_if122.bykvm_try19.r.a()
            r1 = 0
            if (r0 == 0) goto L5f
            com.bytedance.msdk.base.TTBaseAd r0 = r8.N
            if (r0 == 0) goto L4f
            java.lang.String r0 = r0.getAdNetWorkName()
            java.lang.String r2 = "pangle"
            boolean r0 = r2.equals(r0)
            if (r0 == 0) goto L4f
            java.lang.Thread r0 = java.lang.Thread.currentThread()
            java.lang.StackTraceElement[] r0 = r0.getStackTrace()
            boolean r0 = bykvm_19do.bykvm_19do.bykvm_if122.bykvm_try19.r.a(r0)
            if (r0 != 0) goto L3c
            java.lang.Thread r0 = java.lang.Thread.currentThread()
            java.lang.StackTraceElement[] r0 = r0.getStackTrace()
            java.lang.String r6 = bykvm_19do.bykvm_19do.bykvm_if122.bykvm_try19.u.a(r0)
            com.bytedance.msdk.base.TTBaseAd r1 = r8.N
            com.bytedance.msdk.api.AdSlot r2 = r8.f1619h
            r3 = 5
            r4 = 1
            r5 = 0
            bykvm_19do.bykvm_19do.bykvm_if122.bykvm_for12.h.a(r1, r2, r3, r4, r5, r6)
            goto L88
        L3c:
            boolean r0 = bykvm_19do.bykvm_19do.bykvm_if122.bykvm_try19.r.b()
            if (r0 == 0) goto L4f
            java.lang.Thread r0 = java.lang.Thread.currentThread()
            java.lang.StackTraceElement[] r0 = r0.getStackTrace()
            java.lang.String r0 = bykvm_19do.bykvm_19do.bykvm_if122.bykvm_try19.u.a(r0)
            goto L50
        L4f:
            r0 = r1
        L50:
            boolean r2 = r8.f0()
            if (r2 != 0) goto L5d
            com.bytedance.msdk.api.v2.ad.fullvideo.GMFullVideoAdListener r2 = r8.f1372i0
            if (r2 == 0) goto L5d
            r2.onFullVideoAdClick()
        L5d:
            r6 = r0
            goto L67
        L5f:
            com.bytedance.msdk.api.v2.ad.fullvideo.GMFullVideoAdListener r0 = r8.f1372i0
            if (r0 == 0) goto L66
            r0.onFullVideoAdClick()
        L66:
            r6 = r1
        L67:
            com.bytedance.msdk.base.TTBaseAd r0 = r8.N
            boolean r0 = bykvm_19do.bykvm_19do.bykvm_if122.bykvm_try19.u.a(r0)
            if (r0 == 0) goto L7b
            java.lang.Thread r0 = java.lang.Thread.currentThread()
            java.lang.StackTraceElement[] r0 = r0.getStackTrace()
            java.lang.String r1 = bykvm_19do.bykvm_19do.bykvm_if122.bykvm_try19.u.b(r0)
        L7b:
            r5 = r1
            com.bytedance.msdk.base.TTBaseAd r2 = r8.N
            com.bytedance.msdk.api.AdSlot r3 = r8.f1619h
            r4 = 0
            boolean r7 = r2.isClickListenRepeatOnce()
            bykvm_19do.bykvm_19do.bykvm_if122.bykvm_for12.h.a(r2, r3, r4, r5, r6, r7)
        L88:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.g.onFullVideoAdClick():void");
    }

    @Override // com.bytedance.msdk.api.v2.ad.fullvideo.GMFullVideoAdListener
    public void onFullVideoAdClosed() {
        GMFullVideoAdListener gMFullVideoAdListener;
        if (r.a()) {
            TTBaseAd tTBaseAd = this.N;
            if (tTBaseAd != null && "pangle".equals(tTBaseAd.getAdNetWorkName())) {
                if (!r.a(Thread.currentThread().getStackTrace())) {
                    bykvm_19do.bykvm_19do.bykvm_if122.bykvm_for12.h.a(this.N, this.f1619h, 2, 1, 0, u.a(Thread.currentThread().getStackTrace()));
                    return;
                }
                bykvm_19do.bykvm_19do.bykvm_if122.bykvm_for12.h.a(this.N, this.f1619h, 2, 0, 0, (String) null);
            }
            if (f0()) {
                return;
            }
            h0();
            gMFullVideoAdListener = this.f1372i0;
            if (gMFullVideoAdListener == null) {
                return;
            }
        } else {
            h0();
            gMFullVideoAdListener = this.f1372i0;
            if (gMFullVideoAdListener == null) {
                return;
            }
        }
        gMFullVideoAdListener.onFullVideoAdClosed();
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x0064  */
    @Override // com.bytedance.msdk.api.v2.ad.fullvideo.GMFullVideoAdListener
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void onFullVideoAdShow() {
        /*
            Method dump skipped, instruction units count: 276
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.g.onFullVideoAdShow():void");
    }

    @Override // com.bytedance.msdk.api.v2.ad.fullvideo.GMFullVideoAdListener
    public void onFullVideoAdShowFail(AdError adError) {
        bykvm_19do.bykvm_19do.bykvm_if122.bykvm_for12.h.a(this.N, this.f1619h, adError, 1, 0, u.a(this.N) ? u.b(Thread.currentThread().getStackTrace()) : null);
        d(adError);
    }

    @Override // com.bytedance.msdk.api.v2.ad.fullvideo.GMFullVideoAdListener
    public void onRewardVerify(@NonNull RewardItem rewardItem) {
        GMFullVideoAdListener gMFullVideoAdListener = this.f1372i0;
        if (gMFullVideoAdListener != null) {
            gMFullVideoAdListener.onRewardVerify(j.a(rewardItem, this.N));
        }
    }

    @Override // com.bytedance.msdk.api.v2.ad.fullvideo.GMFullVideoAdListener
    public void onSkippedVideo() {
        GMFullVideoAdListener gMFullVideoAdListener;
        if (r.a()) {
            TTBaseAd tTBaseAd = this.N;
            if (tTBaseAd != null && "pangle".equals(tTBaseAd.getAdNetWorkName())) {
                if (!r.a(Thread.currentThread().getStackTrace())) {
                    bykvm_19do.bykvm_19do.bykvm_if122.bykvm_for12.h.a(this.N, this.f1619h, 3, 1, 0, u.a(Thread.currentThread().getStackTrace()));
                    return;
                }
                bykvm_19do.bykvm_19do.bykvm_if122.bykvm_for12.h.a(this.N, this.f1619h, 3, 0, 0, (String) null);
            }
            if (f0()) {
                return;
            }
            h0();
            gMFullVideoAdListener = this.f1372i0;
            if (gMFullVideoAdListener == null) {
                return;
            }
        } else {
            h0();
            gMFullVideoAdListener = this.f1372i0;
            if (gMFullVideoAdListener == null) {
                return;
            }
        }
        gMFullVideoAdListener.onSkippedVideo();
    }

    @Override // com.bytedance.msdk.api.v2.ad.fullvideo.GMFullVideoAdListener
    public void onVideoComplete() {
        GMFullVideoAdListener gMFullVideoAdListener;
        if (r.a()) {
            TTBaseAd tTBaseAd = this.N;
            if (tTBaseAd != null && "pangle".equals(tTBaseAd.getAdNetWorkName())) {
                if (!r.a(Thread.currentThread().getStackTrace())) {
                    bykvm_19do.bykvm_19do.bykvm_if122.bykvm_for12.h.a(this.N, this.f1619h, 1, 1, 0, u.a(Thread.currentThread().getStackTrace()));
                    return;
                }
                bykvm_19do.bykvm_19do.bykvm_if122.bykvm_for12.h.a(this.N, this.f1619h, 1, 0, 0, (String) null);
            }
            if (f0()) {
                return;
            }
            h0();
            gMFullVideoAdListener = this.f1372i0;
            if (gMFullVideoAdListener == null) {
                return;
            }
        } else {
            h0();
            gMFullVideoAdListener = this.f1372i0;
            if (gMFullVideoAdListener == null) {
                return;
            }
        }
        gMFullVideoAdListener.onVideoComplete();
    }

    @Override // com.bytedance.msdk.api.v2.ad.fullvideo.GMFullVideoAdListener
    public void onVideoError() {
        bykvm_19do.bykvm_19do.bykvm_if122.bykvm_for12.h.a(this.N, this.f1619h, (AdError) null, 2, 0, u.a(this.N) ? u.b(Thread.currentThread().getStackTrace()) : null);
        GMFullVideoAdListener gMFullVideoAdListener = this.f1372i0;
        if (gMFullVideoAdListener != null) {
            gMFullVideoAdListener.onVideoError();
        }
    }
}
