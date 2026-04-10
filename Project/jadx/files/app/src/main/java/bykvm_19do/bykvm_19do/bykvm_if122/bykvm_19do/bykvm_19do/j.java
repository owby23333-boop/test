package bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do;

import android.app.Activity;
import android.content.Context;
import androidx.annotation.MainThread;
import androidx.annotation.NonNull;
import bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.a;
import bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_new1.d;
import bykvm_19do.bykvm_19do.bykvm_if122.bykvm_try19.p;
import bykvm_19do.bykvm_19do.bykvm_if122.bykvm_try19.r;
import bykvm_19do.bykvm_19do.bykvm_if122.bykvm_try19.u;
import com.bytedance.msdk.adapter.listener.ITTAdapterRewardedAdListener;
import com.bytedance.msdk.adapter.util.Logger;
import com.bytedance.msdk.adapter.util.ThreadHelper;
import com.bytedance.msdk.api.AdError;
import com.bytedance.msdk.api.AdSlot;
import com.bytedance.msdk.api.GMAdEcpmInfo;
import com.bytedance.msdk.api.TTAdConstant;
import com.bytedance.msdk.api.TTVideoOptionUtil;
import com.bytedance.msdk.api.reward.RewardItem;
import com.bytedance.msdk.api.v2.ad.reward.GMRewardedAdListener;
import com.bytedance.msdk.api.v2.ad.reward.GMRewardedAdLoadCallback;
import com.bytedance.msdk.api.v2.slot.GMAdSlotRewardVideo;
import com.bytedance.msdk.base.TTBaseAd;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class j extends bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_new1.d implements ITTAdapterRewardedAdListener {

    /* JADX INFO: renamed from: h0, reason: collision with root package name */
    private GMRewardedAdLoadCallback f1388h0;

    /* JADX INFO: renamed from: i0, reason: collision with root package name */
    private GMRewardedAdListener f1389i0;

    /* JADX INFO: renamed from: j0, reason: collision with root package name */
    private GMRewardedAdListener f1390j0;

    /* JADX INFO: renamed from: k0, reason: collision with root package name */
    private final bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.a f1391k0;

    /* JADX INFO: renamed from: l0, reason: collision with root package name */
    private final bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.a f1392l0;

    /* JADX INFO: renamed from: m0, reason: collision with root package name */
    GMRewardedAdListener f1393m0;

    class a implements GMRewardedAdListener {

        /* JADX INFO: renamed from: bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.j$a$a, reason: collision with other inner class name */
        class C0039a implements a.i {

            /* JADX INFO: renamed from: bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.j$a$a$a, reason: collision with other inner class name */
            class RunnableC0040a implements Runnable {
                final /* synthetic */ RewardItem a;

                RunnableC0040a(RewardItem rewardItem) {
                    this.a = rewardItem;
                }

                @Override // java.lang.Runnable
                public void run() {
                    if (j.this.f1390j0 != null) {
                        j.this.f1390j0.onRewardVerify(this.a);
                        j.this.a(this.a, 1);
                    }
                }
            }

            C0039a() {
            }

            @Override // bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.a.i
            public void onRewardVerify(RewardItem rewardItem) {
                ThreadHelper.runOnUiThread(new RunnableC0040a(rewardItem));
            }
        }

        a() {
        }

        /* JADX WARN: Removed duplicated region for block: B:14:0x0062  */
        @Override // com.bytedance.msdk.api.v2.ad.reward.GMRewardedAdListener
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public void onRewardClick() {
            /*
                r8 = this;
                boolean r0 = bykvm_19do.bykvm_19do.bykvm_if122.bykvm_try19.r.a()
                r1 = 0
                if (r0 == 0) goto L7e
                bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.j r0 = bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.j.this
                com.bytedance.msdk.base.TTBaseAd r0 = bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.j.q(r0)
                if (r0 == 0) goto L62
                bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.j r0 = bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.j.this
                com.bytedance.msdk.base.TTBaseAd r0 = bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.j.r(r0)
                java.lang.String r0 = r0.getAdNetWorkName()
                java.lang.String r2 = "pangle"
                boolean r0 = r2.equals(r0)
                if (r0 == 0) goto L62
                java.lang.Thread r0 = java.lang.Thread.currentThread()
                java.lang.StackTraceElement[] r0 = r0.getStackTrace()
                boolean r0 = bykvm_19do.bykvm_19do.bykvm_if122.bykvm_try19.r.b(r0)
                if (r0 != 0) goto L4f
                java.lang.Thread r0 = java.lang.Thread.currentThread()
                java.lang.StackTraceElement[] r0 = r0.getStackTrace()
                java.lang.String r6 = bykvm_19do.bykvm_19do.bykvm_if122.bykvm_try19.u.a(r0)
                bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.j r0 = bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.j.this
                com.bytedance.msdk.base.TTBaseAd r1 = bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.j.s(r0)
                bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.j r0 = bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.j.this
                com.bytedance.msdk.api.AdSlot r2 = bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.j.t(r0)
                r3 = 5
                r4 = 1
                r5 = 1
                bykvm_19do.bykvm_19do.bykvm_if122.bykvm_for12.h.a(r1, r2, r3, r4, r5, r6)
                goto Lc3
            L4f:
                boolean r0 = bykvm_19do.bykvm_19do.bykvm_if122.bykvm_try19.r.d()
                if (r0 == 0) goto L62
                java.lang.Thread r0 = java.lang.Thread.currentThread()
                java.lang.StackTraceElement[] r0 = r0.getStackTrace()
                java.lang.String r0 = bykvm_19do.bykvm_19do.bykvm_if122.bykvm_try19.u.a(r0)
                goto L63
            L62:
                r0 = r1
            L63:
                bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.j r2 = bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.j.this
                boolean r2 = r2.f0()
                if (r2 != 0) goto L7c
                bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.j r2 = bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.j.this
                com.bytedance.msdk.api.v2.ad.reward.GMRewardedAdListener r2 = bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.j.S(r2)
                if (r2 == 0) goto L7c
                bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.j r2 = bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.j.this
                com.bytedance.msdk.api.v2.ad.reward.GMRewardedAdListener r2 = bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.j.S(r2)
                r2.onRewardClick()
            L7c:
                r6 = r0
                goto L90
            L7e:
                bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.j r0 = bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.j.this
                com.bytedance.msdk.api.v2.ad.reward.GMRewardedAdListener r0 = bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.j.S(r0)
                if (r0 == 0) goto L8f
                bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.j r0 = bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.j.this
                com.bytedance.msdk.api.v2.ad.reward.GMRewardedAdListener r0 = bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.j.S(r0)
                r0.onRewardClick()
            L8f:
                r6 = r1
            L90:
                bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.j r0 = bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.j.this
                com.bytedance.msdk.base.TTBaseAd r0 = bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.j.u(r0)
                boolean r0 = bykvm_19do.bykvm_19do.bykvm_if122.bykvm_try19.u.a(r0)
                if (r0 == 0) goto La8
                java.lang.Thread r0 = java.lang.Thread.currentThread()
                java.lang.StackTraceElement[] r0 = r0.getStackTrace()
                java.lang.String r1 = bykvm_19do.bykvm_19do.bykvm_if122.bykvm_try19.u.b(r0)
            La8:
                r5 = r1
                bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.j r0 = bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.j.this
                com.bytedance.msdk.base.TTBaseAd r2 = bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.j.v(r0)
                bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.j r0 = bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.j.this
                com.bytedance.msdk.api.AdSlot r3 = bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.j.w(r0)
                r4 = 1
                bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.j r0 = bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.j.this
                com.bytedance.msdk.base.TTBaseAd r0 = bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.j.y(r0)
                boolean r7 = r0.isClickListenRepeatPlayAgainOnce()
                bykvm_19do.bykvm_19do.bykvm_if122.bykvm_for12.h.a(r2, r3, r4, r5, r6, r7)
            Lc3:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.j.a.onRewardClick():void");
        }

        @Override // com.bytedance.msdk.api.v2.ad.reward.GMRewardedAdListener
        public void onRewardVerify(@NonNull RewardItem rewardItem) {
            GMRewardedAdListener gMRewardedAdListener;
            TTBaseAd tTBaseAd;
            if (!r.a()) {
                if (!j.this.f1392l0.b()) {
                    if (j.this.f1390j0 != null) {
                        gMRewardedAdListener = j.this.f1390j0;
                        tTBaseAd = ((bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_new1.e) j.this).N;
                        gMRewardedAdListener.onRewardVerify(j.a(rewardItem, tTBaseAd));
                        j.this.a((RewardItem) null, 1);
                        return;
                    }
                    return;
                }
                j.this.f1392l0.d();
            }
            if (((bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_new1.e) j.this).N != null && "pangle".equals(((bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_new1.e) j.this).N.getAdNetWorkName())) {
                if (!r.b(Thread.currentThread().getStackTrace())) {
                    bykvm_19do.bykvm_19do.bykvm_if122.bykvm_for12.h.a(((bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_new1.e) j.this).N, ((bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_new1.c) j.this).f1619h, 4, 1, 1, u.a(Thread.currentThread().getStackTrace()));
                    return;
                }
                bykvm_19do.bykvm_19do.bykvm_if122.bykvm_for12.h.a(((bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_new1.e) j.this).N, ((bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_new1.c) j.this).f1619h, 4, 0, 1, r.f() ? u.a(Thread.currentThread().getStackTrace()) : null);
            }
            if (j.this.f0()) {
                return;
            }
            if (!j.this.f1392l0.b()) {
                if (j.this.f1390j0 != null) {
                    gMRewardedAdListener = j.this.f1390j0;
                    tTBaseAd = ((bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_new1.e) j.this).N;
                    gMRewardedAdListener.onRewardVerify(j.a(rewardItem, tTBaseAd));
                    j.this.a((RewardItem) null, 1);
                    return;
                }
                return;
            }
            j.this.f1392l0.d();
        }

        @Override // com.bytedance.msdk.api.v2.ad.reward.GMRewardedAdListener
        public void onRewardedAdClosed() {
            if (r.a()) {
                if (((bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_new1.e) j.this).N != null && "pangle".equals(((bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_new1.e) j.this).N.getAdNetWorkName())) {
                    if (!r.b(Thread.currentThread().getStackTrace())) {
                        bykvm_19do.bykvm_19do.bykvm_if122.bykvm_for12.h.a(((bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_new1.e) j.this).N, ((bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_new1.c) j.this).f1619h, 2, 1, 1, u.a(Thread.currentThread().getStackTrace()));
                        return;
                    }
                    bykvm_19do.bykvm_19do.bykvm_if122.bykvm_for12.h.a(((bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_new1.e) j.this).N, ((bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_new1.c) j.this).f1619h, 2, 0, 1, (String) null);
                }
                if (j.this.f0() || j.this.f1390j0 == null) {
                    return;
                }
            } else if (j.this.f1390j0 == null) {
                return;
            }
            j.this.f1390j0.onRewardedAdClosed();
        }

        /* JADX WARN: Removed duplicated region for block: B:14:0x007a  */
        @Override // com.bytedance.msdk.api.v2.ad.reward.GMRewardedAdListener
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public void onRewardedAdShow() {
            /*
                Method dump skipped, instruction units count: 361
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.j.a.onRewardedAdShow():void");
        }

        @Override // com.bytedance.msdk.api.v2.ad.reward.GMRewardedAdListener
        public void onRewardedAdShowFail(@NonNull AdError adError) {
            bykvm_19do.bykvm_19do.bykvm_if122.bykvm_for12.h.a(((bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_new1.e) j.this).N, ((bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_new1.c) j.this).f1619h, adError, 1, 1, u.a(((bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_new1.e) j.this).N) ? u.b(Thread.currentThread().getStackTrace()) : null);
            j.this.e(adError);
        }

        @Override // com.bytedance.msdk.api.v2.ad.reward.GMRewardedAdListener
        public void onSkippedVideo() {
            if (j.this.f1392l0.b()) {
                j.this.f1392l0.c();
            }
            if (r.a()) {
                if (((bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_new1.e) j.this).N != null && "pangle".equals(((bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_new1.e) j.this).N.getAdNetWorkName())) {
                    if (!r.b(Thread.currentThread().getStackTrace())) {
                        bykvm_19do.bykvm_19do.bykvm_if122.bykvm_for12.h.a(((bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_new1.e) j.this).N, ((bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_new1.c) j.this).f1619h, 3, 1, 1, u.a(Thread.currentThread().getStackTrace()));
                        return;
                    }
                    bykvm_19do.bykvm_19do.bykvm_if122.bykvm_for12.h.a(((bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_new1.e) j.this).N, ((bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_new1.c) j.this).f1619h, 3, 0, 1, (String) null);
                }
                if (j.this.f0() || j.this.f1390j0 == null) {
                    return;
                }
            } else if (j.this.f1390j0 == null) {
                return;
            }
            j.this.f1390j0.onSkippedVideo();
        }

        @Override // com.bytedance.msdk.api.v2.ad.reward.GMRewardedAdListener
        public void onVideoComplete() {
            if (j.this.f1392l0.b()) {
                j.this.f1392l0.e();
            }
            if (r.a()) {
                if (((bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_new1.e) j.this).N != null && "pangle".equals(((bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_new1.e) j.this).N.getAdNetWorkName())) {
                    if (!r.b(Thread.currentThread().getStackTrace())) {
                        bykvm_19do.bykvm_19do.bykvm_if122.bykvm_for12.h.a(((bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_new1.e) j.this).N, ((bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_new1.c) j.this).f1619h, 1, 1, 1, u.a(Thread.currentThread().getStackTrace()));
                        return;
                    }
                    bykvm_19do.bykvm_19do.bykvm_if122.bykvm_for12.h.a(((bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_new1.e) j.this).N, ((bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_new1.c) j.this).f1619h, 1, 0, 1, (String) null);
                }
                if (j.this.f0() || j.this.f1390j0 == null) {
                    return;
                }
            } else if (j.this.f1390j0 == null) {
                return;
            }
            j.this.f1390j0.onVideoComplete();
        }

        @Override // com.bytedance.msdk.api.v2.ad.reward.GMRewardedAdListener
        public void onVideoError() {
            bykvm_19do.bykvm_19do.bykvm_if122.bykvm_for12.h.a(((bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_new1.e) j.this).N, ((bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_new1.c) j.this).f1619h, (AdError) null, 2, 1, u.a(((bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_new1.e) j.this).N) ? u.b(Thread.currentThread().getStackTrace()) : null);
            if (j.this.f1390j0 != null) {
                j.this.f1390j0.onVideoError();
            }
        }
    }

    class b implements d.c {
        b() {
        }

        @Override // bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_new1.d.c
        public void a() {
            j.this.d(new AdError(AdError.ERROR_CODE_SHOW_FAIL_NO_AD, AdError.getMessage(AdError.ERROR_CODE_SHOW_FAIL_NO_AD)));
        }
    }

    class c implements a.i {

        class a implements Runnable {
            final /* synthetic */ RewardItem a;

            a(RewardItem rewardItem) {
                this.a = rewardItem;
            }

            @Override // java.lang.Runnable
            public void run() {
                if (j.this.f1389i0 != null) {
                    j.this.f1389i0.onRewardVerify(this.a);
                    j.this.a(this.a, 0);
                }
            }
        }

        c() {
        }

        @Override // bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.a.i
        public void onRewardVerify(RewardItem rewardItem) {
            ThreadHelper.runOnUiThread(new a(rewardItem));
        }
    }

    class d implements Runnable {
        final /* synthetic */ AdError a;

        d(AdError adError) {
            this.a = adError;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (j.this.f1389i0 != null) {
                j.this.f1389i0.onRewardedAdShowFail(this.a);
            }
        }
    }

    class e implements Runnable {
        final /* synthetic */ AdError a;

        e(AdError adError) {
            this.a = adError;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (j.this.f1390j0 != null) {
                j.this.f1390j0.onRewardedAdShowFail(this.a);
            }
        }
    }

    static final class f implements RewardItem {
        final /* synthetic */ RewardItem a;
        final /* synthetic */ TTBaseAd b;

        f(RewardItem rewardItem, TTBaseAd tTBaseAd) {
            this.a = rewardItem;
            this.b = tTBaseAd;
        }

        @Override // com.bytedance.msdk.api.reward.RewardItem
        public float getAmount() {
            return this.a.getAmount();
        }

        @Override // com.bytedance.msdk.api.reward.RewardItem
        public Map<String, Object> getCustomData() {
            Map<String, Object> customData = this.a.getCustomData();
            if (customData == null) {
                customData = new HashMap<>();
            }
            GMAdEcpmInfo gMAdEcpmInfoA = p.a(this.b, true);
            customData.put(RewardItem.KEY_ADN_NAME, gMAdEcpmInfoA != null ? gMAdEcpmInfoA.getAdnName() : "");
            customData.put("ecpm", gMAdEcpmInfoA != null ? gMAdEcpmInfoA.getPreEcpm() : "");
            return customData;
        }

        @Override // com.bytedance.msdk.api.reward.RewardItem
        public String getRewardName() {
            return this.a.getRewardName();
        }

        @Override // com.bytedance.msdk.api.reward.RewardItem
        public boolean rewardVerify() {
            return this.a.rewardVerify();
        }
    }

    public j(Context context, String str) {
        super(context, str);
        this.f1391k0 = new bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.a(this.f1617f);
        this.f1392l0 = new bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.a(this.f1617f);
        this.f1393m0 = new a();
    }

    public static RewardItem a(RewardItem rewardItem, TTBaseAd tTBaseAd) {
        if (rewardItem == null) {
            return null;
        }
        return new f(rewardItem, tTBaseAd);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(RewardItem rewardItem, int i2) {
        String str;
        int i3;
        int i4;
        Map<String, Object> customData;
        String strB = u.a(this.N) ? u.b(Thread.currentThread().getStackTrace()) : null;
        if (rewardItem == null || (customData = rewardItem.getCustomData()) == null) {
            str = "";
            i3 = 0;
            i4 = 0;
        } else {
            Integer num = (Integer) customData.get("reason");
            int iIntValue = num != null ? num.intValue() : 0;
            Integer num2 = (Integer) customData.get("errorCode");
            int iIntValue2 = num2 != null ? num2.intValue() : 0;
            str = (String) customData.get(RewardItem.KEY_ERROR_MSG);
            i4 = iIntValue2;
            i3 = iIntValue;
        }
        bykvm_19do.bykvm_19do.bykvm_if122.bykvm_for12.h.a(this.N, this.f1619h, i2, strB, i3, i4, str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(AdError adError) {
        ThreadHelper.runOnUiThread(new d(adError));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(AdError adError) {
        ThreadHelper.runOnUiThread(new e(adError));
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_new1.e
    public void B() {
        super.B();
        this.f1391k0.a();
        this.f1392l0.a();
        this.f1388h0 = null;
        this.f1389i0 = null;
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_new1.e
    protected void O() {
        GMRewardedAdLoadCallback gMRewardedAdLoadCallback = this.f1388h0;
        if (gMRewardedAdLoadCallback != null) {
            gMRewardedAdLoadCallback.onRewardVideoAdLoad();
        }
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_new1.e
    protected void P() {
        GMRewardedAdLoadCallback gMRewardedAdLoadCallback = this.f1388h0;
        if (gMRewardedAdLoadCallback != null) {
            gMRewardedAdLoadCallback.onRewardVideoCached();
        }
    }

    @MainThread
    public void a(Activity activity, Map<TTAdConstant.GroMoreExtraKey, Object> map) {
        super.a(activity, map, new b());
        if (this.f1389i0 == null) {
            Logger.d("TTMediationSDK", "注意：未设置GMRewardedAdListener，将收不到广告播放/点击/关闭等回调信息");
        }
    }

    public void a(AdSlot adSlot, GMAdSlotRewardVideo gMAdSlotRewardVideo, @NonNull GMRewardedAdLoadCallback gMRewardedAdLoadCallback) {
        if (adSlot != null && adSlot.isV2Request()) {
            bykvm_19do.bykvm_19do.bykvm_if122.bykvm_for12.h.a("mediation_v2_reward");
        }
        if (d0()) {
            this.f1388h0 = gMRewardedAdLoadCallback;
            this.f1619h = bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_case1.b.getShallowCopy(adSlot);
            AdSlot adSlot2 = this.f1619h;
            if (adSlot2 != null) {
                adSlot2.setAdType(7);
                this.f1619h.setAdCount(1);
                TTVideoOptionUtil.setRewardTTVideoOptionIfNeed(this.f1619h);
            }
            this.I = this;
            this.J = this.f1393m0;
            this.f1634w = gMAdSlotRewardVideo;
            S();
        }
    }

    public void a(GMRewardedAdListener gMRewardedAdListener) {
        this.f1389i0 = gMRewardedAdListener;
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_new1.e
    protected void b(AdError adError) {
        GMRewardedAdLoadCallback gMRewardedAdLoadCallback = this.f1388h0;
        if (gMRewardedAdLoadCallback != null) {
            gMRewardedAdLoadCallback.onRewardVideoLoadFail(adError);
        }
    }

    public void b(GMRewardedAdListener gMRewardedAdListener) {
        this.f1390j0 = gMRewardedAdListener;
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x004f  */
    @Override // com.bytedance.msdk.api.v2.ad.reward.GMRewardedAdListener
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void onRewardClick() {
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
            boolean r0 = bykvm_19do.bykvm_19do.bykvm_if122.bykvm_try19.r.b(r0)
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
            boolean r0 = bykvm_19do.bykvm_19do.bykvm_if122.bykvm_try19.r.d()
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
            com.bytedance.msdk.api.v2.ad.reward.GMRewardedAdListener r2 = r8.f1389i0
            if (r2 == 0) goto L5d
            r2.onRewardClick()
        L5d:
            r6 = r0
            goto L67
        L5f:
            com.bytedance.msdk.api.v2.ad.reward.GMRewardedAdListener r0 = r8.f1389i0
            if (r0 == 0) goto L66
            r0.onRewardClick()
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
        throw new UnsupportedOperationException("Method not decompiled: bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.j.onRewardClick():void");
    }

    @Override // com.bytedance.msdk.api.v2.ad.reward.GMRewardedAdListener
    public void onRewardVerify(RewardItem rewardItem) {
        GMRewardedAdListener gMRewardedAdListener;
        if (!r.a()) {
            if (!this.f1391k0.b()) {
                gMRewardedAdListener = this.f1389i0;
                if (gMRewardedAdListener == null) {
                    return;
                }
                gMRewardedAdListener.onRewardVerify(a(rewardItem, this.N));
                a((RewardItem) null, 0);
                return;
            }
            this.f1391k0.d();
        }
        TTBaseAd tTBaseAd = this.N;
        if (tTBaseAd != null && "pangle".equals(tTBaseAd.getAdNetWorkName())) {
            if (!r.b(Thread.currentThread().getStackTrace())) {
                bykvm_19do.bykvm_19do.bykvm_if122.bykvm_for12.h.a(this.N, this.f1619h, 4, 1, 0, u.a(Thread.currentThread().getStackTrace()));
                return;
            }
            bykvm_19do.bykvm_19do.bykvm_if122.bykvm_for12.h.a(this.N, this.f1619h, 4, 0, 0, r.f() ? u.a(Thread.currentThread().getStackTrace()) : null);
        }
        if (f0()) {
            return;
        }
        if (!this.f1391k0.b()) {
            gMRewardedAdListener = this.f1389i0;
            if (gMRewardedAdListener == null) {
                return;
            }
            gMRewardedAdListener.onRewardVerify(a(rewardItem, this.N));
            a((RewardItem) null, 0);
            return;
        }
        this.f1391k0.d();
    }

    @Override // com.bytedance.msdk.api.v2.ad.reward.GMRewardedAdListener
    public void onRewardedAdClosed() {
        GMRewardedAdListener gMRewardedAdListener;
        if (r.a()) {
            TTBaseAd tTBaseAd = this.N;
            if (tTBaseAd != null && "pangle".equals(tTBaseAd.getAdNetWorkName())) {
                if (!r.b(Thread.currentThread().getStackTrace())) {
                    bykvm_19do.bykvm_19do.bykvm_if122.bykvm_for12.h.a(this.N, this.f1619h, 2, 1, 0, u.a(Thread.currentThread().getStackTrace()));
                    return;
                }
                bykvm_19do.bykvm_19do.bykvm_if122.bykvm_for12.h.a(this.N, this.f1619h, 2, 0, 0, (String) null);
            }
            if (f0()) {
                return;
            }
            h0();
            gMRewardedAdListener = this.f1389i0;
            if (gMRewardedAdListener == null) {
                return;
            }
        } else {
            h0();
            gMRewardedAdListener = this.f1389i0;
            if (gMRewardedAdListener == null) {
                return;
            }
        }
        gMRewardedAdListener.onRewardedAdClosed();
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x0064  */
    @Override // com.bytedance.msdk.api.v2.ad.reward.GMRewardedAdListener
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void onRewardedAdShow() {
        /*
            Method dump skipped, instruction units count: 303
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.j.onRewardedAdShow():void");
    }

    @Override // com.bytedance.msdk.api.v2.ad.reward.GMRewardedAdListener
    public void onRewardedAdShowFail(AdError adError) {
        bykvm_19do.bykvm_19do.bykvm_if122.bykvm_for12.h.a(this.N, this.f1619h, adError, 1, 0, u.a(this.N) ? u.b(Thread.currentThread().getStackTrace()) : null);
        d(adError);
    }

    @Override // com.bytedance.msdk.api.v2.ad.reward.GMRewardedAdListener
    public void onSkippedVideo() {
        GMRewardedAdListener gMRewardedAdListener;
        if (r.a()) {
            TTBaseAd tTBaseAd = this.N;
            if (tTBaseAd != null && "pangle".equals(tTBaseAd.getAdNetWorkName())) {
                if (!r.b(Thread.currentThread().getStackTrace())) {
                    bykvm_19do.bykvm_19do.bykvm_if122.bykvm_for12.h.a(this.N, this.f1619h, 3, 1, 0, u.a(Thread.currentThread().getStackTrace()));
                    return;
                }
                bykvm_19do.bykvm_19do.bykvm_if122.bykvm_for12.h.a(this.N, this.f1619h, 3, 0, 0, (String) null);
            }
            if (f0()) {
                return;
            }
            h0();
            if (this.f1391k0.b()) {
                this.f1391k0.c();
            }
            gMRewardedAdListener = this.f1389i0;
            if (gMRewardedAdListener == null) {
                return;
            }
        } else {
            h0();
            if (this.f1391k0.b()) {
                this.f1391k0.c();
            }
            gMRewardedAdListener = this.f1389i0;
            if (gMRewardedAdListener == null) {
                return;
            }
        }
        gMRewardedAdListener.onSkippedVideo();
    }

    @Override // com.bytedance.msdk.api.v2.ad.reward.GMRewardedAdListener
    public void onVideoComplete() {
        GMRewardedAdListener gMRewardedAdListener;
        if (this.f1391k0.b()) {
            this.f1391k0.e();
        }
        if (r.a()) {
            TTBaseAd tTBaseAd = this.N;
            if (tTBaseAd != null && "pangle".equals(tTBaseAd.getAdNetWorkName())) {
                if (!r.b(Thread.currentThread().getStackTrace())) {
                    bykvm_19do.bykvm_19do.bykvm_if122.bykvm_for12.h.a(this.N, this.f1619h, 1, 1, 0, u.a(Thread.currentThread().getStackTrace()));
                    return;
                }
                bykvm_19do.bykvm_19do.bykvm_if122.bykvm_for12.h.a(this.N, this.f1619h, 1, 0, 0, (String) null);
            }
            if (f0()) {
                return;
            }
            h0();
            gMRewardedAdListener = this.f1389i0;
            if (gMRewardedAdListener == null) {
                return;
            }
        } else {
            h0();
            gMRewardedAdListener = this.f1389i0;
            if (gMRewardedAdListener == null) {
                return;
            }
        }
        gMRewardedAdListener.onVideoComplete();
    }

    @Override // com.bytedance.msdk.api.v2.ad.reward.GMRewardedAdListener
    public void onVideoError() {
        bykvm_19do.bykvm_19do.bykvm_if122.bykvm_for12.h.a(this.N, this.f1619h, (AdError) null, 2, 0, u.a(this.N) ? u.b(Thread.currentThread().getStackTrace()) : null);
        GMRewardedAdListener gMRewardedAdListener = this.f1389i0;
        if (gMRewardedAdListener != null) {
            gMRewardedAdListener.onVideoError();
        }
    }
}
