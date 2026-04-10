package bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do;

import android.app.Activity;
import android.content.Context;
import androidx.annotation.NonNull;
import bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_byte12b.m;
import bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_new1.d;
import bykvm_19do.bykvm_19do.bykvm_if122.bykvm_try19.r;
import bykvm_19do.bykvm_19do.bykvm_if122.bykvm_try19.u;
import com.bytedance.msdk.adapter.listener.ITTAdapterFullVideoAdListener;
import com.bytedance.msdk.adapter.listener.ITTAdapterInterstitialListener;
import com.bytedance.msdk.adapter.listener.ITTAdatperCallback;
import com.bytedance.msdk.adapter.util.Logger;
import com.bytedance.msdk.adapter.util.TTLogUtil;
import com.bytedance.msdk.adapter.util.ThreadHelper;
import com.bytedance.msdk.api.AdError;
import com.bytedance.msdk.api.AdSlot;
import com.bytedance.msdk.api.TTAdConstant;
import com.bytedance.msdk.api.reward.RewardItem;
import com.bytedance.msdk.api.v2.ad.interstitialFull.GMInterstitialFullAdListener;
import com.bytedance.msdk.api.v2.ad.interstitialFull.GMInterstitialFullAdLoadCallback;
import com.bytedance.msdk.api.v2.slot.GMAdSlotInterstitialFull;
import com.bytedance.msdk.base.TTBaseAd;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class b extends bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_new1.d {

    /* JADX INFO: renamed from: h0, reason: collision with root package name */
    private GMInterstitialFullAdLoadCallback f1359h0;

    /* JADX INFO: renamed from: i0, reason: collision with root package name */
    private GMInterstitialFullAdListener f1360i0;

    /* JADX INFO: renamed from: j0, reason: collision with root package name */
    ITTAdapterFullVideoAdListener f1361j0;

    /* JADX INFO: renamed from: k0, reason: collision with root package name */
    ITTAdapterInterstitialListener f1362k0;

    class a implements d.c {
        a() {
        }

        @Override // bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_new1.d.c
        public void a() {
            b.this.d(new AdError(AdError.ERROR_CODE_SHOW_FAIL_NO_AD, AdError.getMessage(AdError.ERROR_CODE_SHOW_FAIL_NO_AD)));
        }
    }

    /* JADX INFO: renamed from: bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.b$b, reason: collision with other inner class name */
    class RunnableC0037b implements Runnable {
        final /* synthetic */ AdError a;

        RunnableC0037b(AdError adError) {
            this.a = adError;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (b.this.f1360i0 != null) {
                b.this.f1360i0.onInterstitialFullShowFail(this.a);
            }
        }
    }

    class c implements ITTAdapterFullVideoAdListener {
        c() {
        }

        /* JADX WARN: Removed duplicated region for block: B:14:0x0062  */
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
                if (r0 == 0) goto L7e
                bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.b r0 = bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.b.this
                com.bytedance.msdk.base.TTBaseAd r0 = bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.b.q(r0)
                if (r0 == 0) goto L62
                bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.b r0 = bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.b.this
                com.bytedance.msdk.base.TTBaseAd r0 = bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.b.r(r0)
                java.lang.String r0 = r0.getAdNetWorkName()
                java.lang.String r2 = "pangle"
                boolean r0 = r2.equals(r0)
                if (r0 == 0) goto L62
                java.lang.Thread r0 = java.lang.Thread.currentThread()
                java.lang.StackTraceElement[] r0 = r0.getStackTrace()
                boolean r0 = bykvm_19do.bykvm_19do.bykvm_if122.bykvm_try19.r.a(r0)
                if (r0 != 0) goto L4f
                java.lang.Thread r0 = java.lang.Thread.currentThread()
                java.lang.StackTraceElement[] r0 = r0.getStackTrace()
                java.lang.String r6 = bykvm_19do.bykvm_19do.bykvm_if122.bykvm_try19.u.a(r0)
                bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.b r0 = bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.b.this
                com.bytedance.msdk.base.TTBaseAd r1 = bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.b.s(r0)
                bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.b r0 = bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.b.this
                com.bytedance.msdk.api.AdSlot r2 = bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.b.t(r0)
                r3 = 5
                r4 = 1
                r5 = 0
                bykvm_19do.bykvm_19do.bykvm_if122.bykvm_for12.h.a(r1, r2, r3, r4, r5, r6)
                goto Lc3
            L4f:
                boolean r0 = bykvm_19do.bykvm_19do.bykvm_if122.bykvm_try19.r.b()
                if (r0 == 0) goto L62
                java.lang.Thread r0 = java.lang.Thread.currentThread()
                java.lang.StackTraceElement[] r0 = r0.getStackTrace()
                java.lang.String r0 = bykvm_19do.bykvm_19do.bykvm_if122.bykvm_try19.u.a(r0)
                goto L63
            L62:
                r0 = r1
            L63:
                bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.b r2 = bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.b.this
                boolean r2 = r2.f0()
                if (r2 != 0) goto L7c
                bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.b r2 = bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.b.this
                com.bytedance.msdk.api.v2.ad.interstitialFull.GMInterstitialFullAdListener r2 = bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.b.a(r2)
                if (r2 == 0) goto L7c
                bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.b r2 = bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.b.this
                com.bytedance.msdk.api.v2.ad.interstitialFull.GMInterstitialFullAdListener r2 = bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.b.a(r2)
                r2.onInterstitialFullClick()
            L7c:
                r6 = r0
                goto L90
            L7e:
                bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.b r0 = bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.b.this
                com.bytedance.msdk.api.v2.ad.interstitialFull.GMInterstitialFullAdListener r0 = bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.b.a(r0)
                if (r0 == 0) goto L8f
                bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.b r0 = bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.b.this
                com.bytedance.msdk.api.v2.ad.interstitialFull.GMInterstitialFullAdListener r0 = bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.b.a(r0)
                r0.onInterstitialFullClick()
            L8f:
                r6 = r1
            L90:
                bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.b r0 = bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.b.this
                com.bytedance.msdk.base.TTBaseAd r0 = bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.b.u(r0)
                boolean r0 = bykvm_19do.bykvm_19do.bykvm_if122.bykvm_try19.u.a(r0)
                if (r0 == 0) goto La8
                java.lang.Thread r0 = java.lang.Thread.currentThread()
                java.lang.StackTraceElement[] r0 = r0.getStackTrace()
                java.lang.String r1 = bykvm_19do.bykvm_19do.bykvm_if122.bykvm_try19.u.b(r0)
            La8:
                r5 = r1
                bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.b r0 = bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.b.this
                com.bytedance.msdk.base.TTBaseAd r2 = bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.b.v(r0)
                bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.b r0 = bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.b.this
                com.bytedance.msdk.api.AdSlot r3 = bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.b.x(r0)
                r4 = 0
                bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.b r0 = bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.b.this
                com.bytedance.msdk.base.TTBaseAd r0 = bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.b.y(r0)
                boolean r7 = r0.isClickListenRepeatOnce()
                bykvm_19do.bykvm_19do.bykvm_if122.bykvm_for12.h.a(r2, r3, r4, r5, r6, r7)
            Lc3:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.b.c.onFullVideoAdClick():void");
        }

        @Override // com.bytedance.msdk.api.v2.ad.fullvideo.GMFullVideoAdListener
        public void onFullVideoAdClosed() {
            if (r.a()) {
                if (((bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_new1.e) b.this).N != null && "pangle".equals(((bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_new1.e) b.this).N.getAdNetWorkName())) {
                    if (!r.a(Thread.currentThread().getStackTrace())) {
                        bykvm_19do.bykvm_19do.bykvm_if122.bykvm_for12.h.a(((bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_new1.e) b.this).N, ((bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_new1.c) b.this).f1619h, 2, 1, 0, u.a(Thread.currentThread().getStackTrace()));
                        return;
                    }
                    bykvm_19do.bykvm_19do.bykvm_if122.bykvm_for12.h.a(((bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_new1.e) b.this).N, ((bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_new1.c) b.this).f1619h, 2, 0, 0, (String) null);
                }
                if (b.this.f0()) {
                    return;
                }
                b.this.h0();
                if (b.this.f1360i0 == null) {
                    return;
                }
            } else {
                b.this.h0();
                if (b.this.f1360i0 == null) {
                    return;
                }
            }
            b.this.f1360i0.onInterstitialFullClosed();
        }

        /* JADX WARN: Removed duplicated region for block: B:14:0x007a  */
        @Override // com.bytedance.msdk.api.v2.ad.fullvideo.GMFullVideoAdListener
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public void onFullVideoAdShow() {
            /*
                Method dump skipped, instruction units count: 370
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.b.c.onFullVideoAdShow():void");
        }

        @Override // com.bytedance.msdk.api.v2.ad.fullvideo.GMFullVideoAdListener
        public void onFullVideoAdShowFail(@NonNull AdError adError) {
            bykvm_19do.bykvm_19do.bykvm_if122.bykvm_for12.h.a(((bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_new1.e) b.this).N, ((bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_new1.c) b.this).f1619h, adError, 1, 0, u.a(((bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_new1.e) b.this).N) ? u.b(Thread.currentThread().getStackTrace()) : null);
            b.this.d(adError);
        }

        @Override // com.bytedance.msdk.api.v2.ad.fullvideo.GMFullVideoAdListener
        public void onRewardVerify(@NonNull RewardItem rewardItem) {
            if (b.this.f1360i0 != null) {
                b.this.f1360i0.onRewardVerify(j.a(rewardItem, ((bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_new1.e) b.this).N));
            }
        }

        @Override // com.bytedance.msdk.api.v2.ad.fullvideo.GMFullVideoAdListener
        public void onSkippedVideo() {
            if (r.a()) {
                if (((bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_new1.e) b.this).N != null && "pangle".equals(((bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_new1.e) b.this).N.getAdNetWorkName())) {
                    if (!r.a(Thread.currentThread().getStackTrace())) {
                        bykvm_19do.bykvm_19do.bykvm_if122.bykvm_for12.h.a(((bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_new1.e) b.this).N, ((bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_new1.c) b.this).f1619h, 3, 1, 0, u.a(Thread.currentThread().getStackTrace()));
                        return;
                    }
                    bykvm_19do.bykvm_19do.bykvm_if122.bykvm_for12.h.a(((bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_new1.e) b.this).N, ((bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_new1.c) b.this).f1619h, 3, 0, 0, (String) null);
                }
                if (b.this.f0()) {
                    return;
                }
                b.this.h0();
                if (b.this.f1360i0 == null) {
                    return;
                }
            } else {
                b.this.h0();
                if (b.this.f1360i0 == null) {
                    return;
                }
            }
            b.this.f1360i0.onSkippedVideo();
        }

        @Override // com.bytedance.msdk.api.v2.ad.fullvideo.GMFullVideoAdListener
        public void onVideoComplete() {
            if (r.a()) {
                if (((bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_new1.e) b.this).N != null && "pangle".equals(((bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_new1.e) b.this).N.getAdNetWorkName())) {
                    if (!r.a(Thread.currentThread().getStackTrace())) {
                        bykvm_19do.bykvm_19do.bykvm_if122.bykvm_for12.h.a(((bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_new1.e) b.this).N, ((bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_new1.c) b.this).f1619h, 1, 1, 0, u.a(Thread.currentThread().getStackTrace()));
                        return;
                    }
                    bykvm_19do.bykvm_19do.bykvm_if122.bykvm_for12.h.a(((bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_new1.e) b.this).N, ((bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_new1.c) b.this).f1619h, 1, 0, 0, (String) null);
                }
                if (b.this.f0()) {
                    return;
                }
                b.this.h0();
                if (b.this.f1360i0 == null) {
                    return;
                }
            } else {
                b.this.h0();
                if (b.this.f1360i0 == null) {
                    return;
                }
            }
            b.this.f1360i0.onVideoComplete();
        }

        @Override // com.bytedance.msdk.api.v2.ad.fullvideo.GMFullVideoAdListener
        public void onVideoError() {
            bykvm_19do.bykvm_19do.bykvm_if122.bykvm_for12.h.a(((bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_new1.e) b.this).N, ((bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_new1.c) b.this).f1619h, (AdError) null, 2, 0, u.a(((bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_new1.e) b.this).N) ? u.b(Thread.currentThread().getStackTrace()) : null);
            if (b.this.f1360i0 != null) {
                b.this.f1360i0.onVideoError();
            }
        }
    }

    class d implements ITTAdapterInterstitialListener {
        d() {
        }

        @Override // com.bytedance.msdk.api.v2.ad.interstitial.GMInterstitialAdListener
        public void onAdLeftApplication() {
            if (b.this.f1360i0 != null) {
                b.this.f1360i0.onAdLeftApplication();
            }
        }

        @Override // com.bytedance.msdk.api.v2.ad.interstitial.GMInterstitialAdListener
        public void onAdOpened() {
            if (b.this.f1360i0 != null) {
                b.this.f1360i0.onAdOpened();
            }
        }

        @Override // com.bytedance.msdk.api.v2.ad.interstitial.GMInterstitialAdListener
        public void onInterstitialAdClick() {
            if (b.this.f1360i0 != null) {
                b.this.f1360i0.onInterstitialFullClick();
            }
            bykvm_19do.bykvm_19do.bykvm_if122.bykvm_for12.h.a(((bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_new1.e) b.this).N, ((bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_new1.c) b.this).f1619h, 0, u.a(((bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_new1.e) b.this).N) ? u.b(Thread.currentThread().getStackTrace()) : null, ((bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_new1.e) b.this).N.isClickListenRepeatOnce());
        }

        @Override // com.bytedance.msdk.api.v2.ad.interstitial.GMInterstitialAdListener
        public void onInterstitialClosed() {
            b.this.h0();
            if (b.this.f1360i0 != null) {
                b.this.f1360i0.onInterstitialFullClosed();
            }
        }

        @Override // com.bytedance.msdk.api.v2.ad.interstitial.GMInterstitialAdListener
        public void onInterstitialShow() {
            if (b.this.f1360i0 != null) {
                b.this.f1360i0.onInterstitialFullShow();
            }
            m.b().a(((bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_new1.c) b.this).f1617f + "");
            if (((bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_new1.e) b.this).N != null) {
                Logger.d("TTMediationSDK", TTLogUtil.getTagThirdLevelByEvent(((bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_new1.c) b.this).f1617f, TTLogUtil.TAG_EVENT_SHOW_LISTEN) + "adSlotId：" + ((bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_new1.e) b.this).N.getAdNetworkSlotId() + "，广告类型：" + com.bytedance.msdk.base.a.a(((bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_new1.e) b.this).N.getAdNetworkPlatformId()));
                bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_byte12b.k.b().a(((bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_new1.c) b.this).f1617f, ((bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_new1.e) b.this).N.getAdNetworkSlotId());
            }
            b.this.e0();
            b bVar = b.this;
            bVar.d(((bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_new1.e) bVar).N);
            bykvm_19do.bykvm_19do.bykvm_if122.bykvm_for12.h.b(((bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_new1.e) b.this).N, ((bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_new1.c) b.this).f1619h, 0, u.a(((bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_new1.e) b.this).N) ? u.b(Thread.currentThread().getStackTrace()) : null, false);
            bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_new1.g.b(((bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_new1.c) b.this).f1617f, ((bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_new1.e) b.this).N);
        }

        @Override // com.bytedance.msdk.api.v2.ad.interstitial.GMInterstitialAdListener
        public void onInterstitialShowFail(@NonNull AdError adError) {
            bykvm_19do.bykvm_19do.bykvm_if122.bykvm_for12.h.a(((bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_new1.e) b.this).N, ((bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_new1.c) b.this).f1619h, adError, 1, 0, u.a(((bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_new1.e) b.this).N) ? u.b(Thread.currentThread().getStackTrace()) : null);
            b.this.d(adError);
        }
    }

    public b(Context context, String str) {
        super(context, str);
        this.f1361j0 = new c();
        this.f1362k0 = new d();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(AdError adError) {
        ThreadHelper.runOnUiThread(new RunnableC0037b(adError));
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_new1.e
    public void B() {
        super.B();
        this.f1360i0 = null;
        this.f1359h0 = null;
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_new1.e
    protected void O() {
        GMInterstitialFullAdLoadCallback gMInterstitialFullAdLoadCallback = this.f1359h0;
        if (gMInterstitialFullAdLoadCallback != null) {
            gMInterstitialFullAdLoadCallback.onInterstitialFullAdLoad();
        }
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_new1.e
    protected void P() {
        GMInterstitialFullAdLoadCallback gMInterstitialFullAdLoadCallback = this.f1359h0;
        if (gMInterstitialFullAdLoadCallback != null) {
            gMInterstitialFullAdLoadCallback.onInterstitialFullCached();
        }
    }

    public void a(Activity activity) {
        super.b(activity, null, new a());
    }

    public void a(AdSlot adSlot, GMAdSlotInterstitialFull gMAdSlotInterstitialFull, GMInterstitialFullAdLoadCallback gMInterstitialFullAdLoadCallback) {
        if (d0()) {
            this.f1619h = bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_case1.b.getShallowCopy(adSlot);
            AdSlot adSlot2 = this.f1619h;
            if (adSlot2 != null) {
                adSlot2.setAdType(10);
                this.f1619h.setAdCount(1);
            }
            this.f1359h0 = gMInterstitialFullAdLoadCallback;
            this.I = this.f1361j0;
            this.f1634w = gMAdSlotInterstitialFull;
            S();
        }
    }

    public void a(GMInterstitialFullAdListener gMInterstitialFullAdListener) {
        this.f1360i0 = gMInterstitialFullAdListener;
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_new1.d
    public void a(TTBaseAd tTBaseAd, Activity activity, Map<TTAdConstant.GroMoreExtraKey, Object> map) {
        ITTAdatperCallback iTTAdatperCallback;
        if (tTBaseAd != null) {
            if (tTBaseAd.getSubAdType() == 1) {
                iTTAdatperCallback = this.f1362k0;
            } else if (tTBaseAd.getSubAdType() == 2) {
                iTTAdatperCallback = this.f1361j0;
            }
            this.I = iTTAdatperCallback;
        }
        super.a(tTBaseAd, activity, map);
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_new1.e
    protected void b(AdError adError) {
        GMInterstitialFullAdLoadCallback gMInterstitialFullAdLoadCallback = this.f1359h0;
        if (gMInterstitialFullAdLoadCallback != null) {
            gMInterstitialFullAdLoadCallback.onInterstitialFullLoadFail(adError);
        }
    }
}
