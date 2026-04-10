package com.anythink.splashad.a;

import android.content.Context;
import android.text.TextUtils;
import android.view.ViewGroup;
import com.anythink.core.api.ATNetworkConfirmInfo;
import com.anythink.core.api.AdError;
import com.anythink.core.common.b.g;
import com.anythink.core.common.b.j;
import com.anythink.core.common.b.n;
import com.anythink.core.common.k.a.f;
import com.anythink.core.common.k.u;
import com.anythink.core.common.v;
import com.anythink.splashad.api.ATSplashAdExtraInfo;
import com.anythink.splashad.api.ATSplashSkipAdListener;
import com.anythink.splashad.api.ATSplashSkipInfo;
import com.anythink.splashad.api.IATSplashEyeAd;
import com.anythink.splashad.unitgroup.api.CustomSplashAdapter;
import com.anythink.splashad.unitgroup.api.CustomSplashEventListener;
import java.util.Timer;
import java.util.TimerTask;

/* JADX INFO: loaded from: classes2.dex */
public final class f implements CustomSplashEventListener {
    CustomSplashAdapter a;
    a b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    long f12764c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private Timer f12765d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private boolean f12766e = false;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private int f12767f = 0;

    /* JADX INFO: renamed from: com.anythink.splashad.a.f$1, reason: invalid class name */
    final class AnonymousClass1 extends TimerTask {
        final /* synthetic */ ViewGroup a;
        final /* synthetic */ f.b b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ ATSplashSkipAdListener f12768c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ long f12769d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        final /* synthetic */ long f12770e;

        AnonymousClass1(ViewGroup viewGroup, f.b bVar, ATSplashSkipAdListener aTSplashSkipAdListener, long j2, long j3) {
            this.a = viewGroup;
            this.b = bVar;
            this.f12768c = aTSplashSkipAdListener;
            this.f12769d = j2;
            this.f12770e = j3;
        }

        @Override // java.util.TimerTask, java.lang.Runnable
        public final void run() {
            ViewGroup viewGroup = this.a;
            if (viewGroup == null || u.a(viewGroup, this.b)) {
                n.a().a(new Runnable() { // from class: com.anythink.splashad.a.f.1.1
                    @Override // java.lang.Runnable
                    public final void run() {
                        AnonymousClass1 anonymousClass1 = AnonymousClass1.this;
                        f fVar = f.this;
                        long j2 = fVar.f12764c;
                        if (j2 <= 0) {
                            fVar.a(3);
                            f.this.onSplashAdDismiss();
                        } else {
                            ATSplashSkipAdListener aTSplashSkipAdListener = anonymousClass1.f12768c;
                            if (aTSplashSkipAdListener != null) {
                                aTSplashSkipAdListener.onAdTick(anonymousClass1.f12769d, j2);
                            }
                        }
                        AnonymousClass1 anonymousClass12 = AnonymousClass1.this;
                        f.this.f12764c -= anonymousClass12.f12770e;
                    }
                });
            }
        }
    }

    /* JADX INFO: renamed from: com.anythink.splashad.a.f$2, reason: invalid class name */
    final class AnonymousClass2 implements Runnable {
        final /* synthetic */ ATSplashSkipAdListener a;
        final /* synthetic */ long b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ long f12772c;

        AnonymousClass2(ATSplashSkipAdListener aTSplashSkipAdListener, long j2, long j3) {
            this.a = aTSplashSkipAdListener;
            this.b = j2;
            this.f12772c = j3;
        }

        @Override // java.lang.Runnable
        public final void run() {
            ATSplashSkipAdListener aTSplashSkipAdListener = this.a;
            if (aTSplashSkipAdListener != null) {
                aTSplashSkipAdListener.onAdTick(this.b, f.this.f12764c);
                f.this.f12764c -= this.f12772c;
            }
        }
    }

    public f(CustomSplashAdapter customSplashAdapter, a aVar) {
        this.a = customSplashAdapter;
        this.b = aVar;
    }

    private void a(ATSplashSkipInfo aTSplashSkipInfo) {
        if (this.f12765d == null) {
            long callbackInterval = aTSplashSkipInfo.getCallbackInterval();
            long countDownDuration = aTSplashSkipInfo.getCountDownDuration();
            ViewGroup container = aTSplashSkipInfo.getContainer();
            f.b bVar = new f.b();
            ATSplashSkipAdListener aTSplashSkipAdListener = aTSplashSkipInfo.getATSplashSkipAdListener();
            this.f12764c = countDownDuration;
            this.f12765d = new Timer();
            this.f12765d.schedule(new AnonymousClass1(container, bVar, aTSplashSkipAdListener, countDownDuration, callbackInterval), callbackInterval, callbackInterval);
            n.a().a(new AnonymousClass2(aTSplashSkipAdListener, countDownDuration, callbackInterval));
        }
    }

    @Override // com.anythink.splashad.unitgroup.api.CustomSplashEventListener
    public final void onDeeplinkCallback(boolean z2) {
        a aVar = this.b;
        if (aVar != null) {
            aVar.onDeeplinkCallback(j.a(this.a), z2);
        }
    }

    @Override // com.anythink.splashad.unitgroup.api.CustomSplashEventListener
    public final void onDownloadConfirm(Context context, ATNetworkConfirmInfo aTNetworkConfirmInfo) {
        a aVar = this.b;
        if (aVar != null) {
            aVar.onDownloadConfirm(context, j.a(this.a), aTNetworkConfirmInfo);
        }
    }

    @Override // com.anythink.splashad.unitgroup.api.CustomSplashEventListener
    public final void onSplashAdClicked() {
        CustomSplashAdapter customSplashAdapter = this.a;
        if (customSplashAdapter != null) {
            com.anythink.core.common.e.e trackingInfo = customSplashAdapter.getTrackingInfo();
            com.anythink.core.common.j.a.a(n.a().g()).a(6, trackingInfo);
            com.anythink.core.common.k.g.a(trackingInfo, g.i.f6858d, g.i.f6860f, "");
        }
        a aVar = this.b;
        if (aVar != null) {
            aVar.onAdClick(j.a(this.a));
        }
    }

    @Override // com.anythink.splashad.unitgroup.api.CustomSplashEventListener
    public final void onSplashAdDismiss() {
        com.anythink.core.common.e.d dVarD;
        Timer timer = this.f12765d;
        if (timer != null) {
            timer.cancel();
        }
        CustomSplashAdapter customSplashAdapter = this.a;
        if (customSplashAdapter != null) {
            com.anythink.core.common.e.e trackingInfo = customSplashAdapter.getTrackingInfo();
            int dismissType = this.f12767f;
            if (dismissType != 0) {
                trackingInfo.y(dismissType);
            } else {
                dismissType = this.a.getDismissType();
                if (dismissType == 0) {
                    dismissType = 1;
                }
                trackingInfo.y(dismissType);
            }
            com.anythink.core.common.j.c.a(trackingInfo, false);
            ATSplashSkipInfo splashSkipInfo = this.a.getSplashSkipInfo();
            if (splashSkipInfo != null && splashSkipInfo.canUseCustomSkipView()) {
                this.a.startSplashCustomSkipViewClickEye();
                Timer timer2 = this.f12765d;
                if (timer2 != null) {
                    timer2.cancel();
                    this.f12765d = null;
                }
                splashSkipInfo.destroy();
                this.a.setSplashSkipInfo(null);
            }
            com.anythink.core.common.k.g.a(trackingInfo, g.i.f6859e, g.i.f6860f, "");
            String strW = trackingInfo.W();
            if (!TextUtils.isEmpty(strW) && (dVarD = v.a().d(strW)) != null) {
                v.a().e(strW);
                c.a(n.a().g(), strW).d(v.a().a(strW, dVarD.a()));
            }
            CustomSplashAdapter customSplashAdapter2 = this.a;
            IATSplashEyeAd splashEyeAd = customSplashAdapter2 instanceof CustomSplashAdapter ? customSplashAdapter2.getSplashEyeAd() : null;
            a aVar = this.b;
            if (aVar != null && !this.f12766e) {
                this.f12766e = true;
                aVar.onCallbackAdDismiss(j.a(trackingInfo, this.a), new ATSplashAdExtraInfo(dismissType, splashEyeAd));
            }
            if (splashEyeAd == null) {
                CustomSplashAdapter customSplashAdapter3 = this.a;
                if (customSplashAdapter3 != null) {
                    customSplashAdapter3.cleanImpressionListener();
                }
                CustomSplashAdapter customSplashAdapter4 = this.a;
                if (customSplashAdapter4 != null) {
                    customSplashAdapter4.destory();
                }
            }
        }
    }

    @Override // com.anythink.splashad.unitgroup.api.CustomSplashEventListener
    public final void onSplashAdShow() {
        j jVarA = j.a(this.a);
        CustomSplashAdapter customSplashAdapter = this.a;
        if (customSplashAdapter != null) {
            com.anythink.core.common.e.e trackingInfo = customSplashAdapter.getTrackingInfo();
            com.anythink.core.common.j.a.a(n.a().g()).a(4, trackingInfo, this.a.getUnitGroupInfo());
            com.anythink.core.common.k.g.a(trackingInfo, g.i.f6857c, g.i.f6860f, "");
            ATSplashSkipInfo splashSkipInfo = this.a.getSplashSkipInfo();
            if (splashSkipInfo != null && splashSkipInfo.canUseCustomSkipView() && this.a.isSupportCustomSkipView() && this.f12765d == null) {
                long callbackInterval = splashSkipInfo.getCallbackInterval();
                long countDownDuration = splashSkipInfo.getCountDownDuration();
                ViewGroup container = splashSkipInfo.getContainer();
                f.b bVar = new f.b();
                ATSplashSkipAdListener aTSplashSkipAdListener = splashSkipInfo.getATSplashSkipAdListener();
                this.f12764c = countDownDuration;
                this.f12765d = new Timer();
                this.f12765d.schedule(new AnonymousClass1(container, bVar, aTSplashSkipAdListener, countDownDuration, callbackInterval), callbackInterval, callbackInterval);
                n.a().a(new AnonymousClass2(aTSplashSkipAdListener, countDownDuration, callbackInterval));
            }
            if (trackingInfo != null) {
                v.a().a(trackingInfo.W(), jVarA);
            }
        }
        a aVar = this.b;
        if (aVar != null) {
            aVar.onAdShow(jVarA);
        }
    }

    @Override // com.anythink.splashad.unitgroup.api.CustomSplashEventListener
    public final void onSplashAdShowFail(AdError adError) {
        CustomSplashAdapter customSplashAdapter = this.a;
        if (customSplashAdapter != null) {
            com.anythink.core.common.j.c.a(customSplashAdapter.getTrackingInfo(), adError, this.a.getNetworkInfoMap());
        }
    }

    private void a() {
        Timer timer = this.f12765d;
        if (timer != null) {
            timer.cancel();
            this.f12765d = null;
        }
    }

    final void a(int i2) {
        this.f12767f = i2;
    }

    private static void a(String str) {
        com.anythink.core.common.e.d dVarD;
        if (TextUtils.isEmpty(str) || (dVarD = v.a().d(str)) == null) {
            return;
        }
        v.a().e(str);
        c.a(n.a().g(), str).d(v.a().a(str, dVarD.a()));
    }
}
