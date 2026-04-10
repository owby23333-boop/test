package com.anythink.rewardvideo.a;

import android.content.Context;
import android.os.SystemClock;
import android.text.TextUtils;
import com.anythink.core.api.ATAdStatusInfo;
import com.anythink.core.api.ATNetworkConfirmInfo;
import com.anythink.core.api.AdError;
import com.anythink.core.api.ErrorCode;
import com.anythink.core.common.b.g;
import com.anythink.core.common.b.j;
import com.anythink.core.common.b.n;
import com.anythink.core.common.k.g;
import com.anythink.core.common.v;
import com.anythink.rewardvideo.api.ATRewardVideoExListener;
import com.anythink.rewardvideo.api.ATRewardVideoListener;
import com.anythink.rewardvideo.unitgroup.api.CustomRewardVideoAdapter;
import com.anythink.rewardvideo.unitgroup.api.CustomRewardedVideoEventListener;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public final class e implements CustomRewardedVideoEventListener {
    long b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    boolean f12730c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    com.anythink.core.common.e.e f12731d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    boolean f12732e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    long f12733f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    long f12734g;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private ATRewardVideoListener f12737j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private CustomRewardVideoAdapter f12738k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private com.anythink.core.common.f.c f12739l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private long f12740m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private long f12741n;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    int f12735h = 0;
    long a = 0;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    boolean f12736i = true;

    public e(CustomRewardVideoAdapter customRewardVideoAdapter, com.anythink.core.common.f.c cVar, ATRewardVideoListener aTRewardVideoListener) {
        this.f12737j = aTRewardVideoListener;
        this.f12738k = customRewardVideoAdapter;
        this.f12739l = cVar;
    }

    private static void b(com.anythink.core.common.e.e eVar) {
        com.anythink.core.common.j.a.a(n.a().g()).a(9, eVar);
    }

    private static void c(com.anythink.core.common.e.e eVar) {
        com.anythink.core.common.j.a.a(n.a().g()).a(6, eVar);
        g.a(eVar, g.i.f6858d, g.i.f6860f, "");
    }

    private void d(com.anythink.core.common.e.e eVar) {
        com.anythink.core.common.j.a.a(n.a().g()).a(13, eVar, this.f12738k.getUnitGroupInfo());
        a(eVar);
    }

    @Override // com.anythink.rewardvideo.unitgroup.api.CustomRewardedVideoEventListener
    public final void onAgainReward() {
        com.anythink.core.common.f.c cVar;
        com.anythink.core.common.e.e eVarA = a();
        if (!this.f12732e && (cVar = this.f12739l) != null) {
            cVar.a(this.f12733f, this.f12734g, this.f12738k, eVarA);
        }
        this.f12732e = true;
        ATRewardVideoListener aTRewardVideoListener = this.f12737j;
        if (aTRewardVideoListener == null || !(aTRewardVideoListener instanceof ATRewardVideoExListener)) {
            return;
        }
        ((ATRewardVideoExListener) aTRewardVideoListener).onAgainReward(j.a(eVarA, this.f12738k));
    }

    @Override // com.anythink.rewardvideo.unitgroup.api.CustomRewardedVideoEventListener
    public final void onDeeplinkCallback(boolean z2) {
        ATRewardVideoListener aTRewardVideoListener = this.f12737j;
        if (aTRewardVideoListener == null || !(aTRewardVideoListener instanceof ATRewardVideoExListener)) {
            return;
        }
        ((ATRewardVideoExListener) aTRewardVideoListener).onDeeplinkCallback(j.a(this.f12738k), z2);
    }

    @Override // com.anythink.rewardvideo.unitgroup.api.CustomRewardedVideoEventListener
    public final void onDownloadConfirm(Context context, ATNetworkConfirmInfo aTNetworkConfirmInfo) {
        ATRewardVideoListener aTRewardVideoListener = this.f12737j;
        if (aTRewardVideoListener == null || !(aTRewardVideoListener instanceof ATRewardVideoExListener)) {
            return;
        }
        ((ATRewardVideoExListener) aTRewardVideoListener).onDownloadConfirm(context, j.a(this.f12738k), aTNetworkConfirmInfo);
    }

    @Override // com.anythink.rewardvideo.unitgroup.api.CustomRewardedVideoEventListener
    public final void onReward() {
        com.anythink.core.common.f.c cVar;
        if (!this.f12730c && (cVar = this.f12739l) != null) {
            long j2 = this.f12740m;
            long j3 = this.f12741n;
            CustomRewardVideoAdapter customRewardVideoAdapter = this.f12738k;
            cVar.a(j2, j3, customRewardVideoAdapter, customRewardVideoAdapter.getTrackingInfo());
        }
        this.f12730c = true;
        ATRewardVideoListener aTRewardVideoListener = this.f12737j;
        if (aTRewardVideoListener != null) {
            aTRewardVideoListener.onReward(j.a(this.f12738k));
        }
    }

    @Override // com.anythink.rewardvideo.unitgroup.api.CustomRewardedVideoEventListener
    public final void onRewardedVideoAdAgainPlayClicked() {
        com.anythink.core.common.e.e eVarA = a();
        if (this.f12738k != null && eVarA != null) {
            c(eVarA);
        }
        ATRewardVideoListener aTRewardVideoListener = this.f12737j;
        if (aTRewardVideoListener == null || !(aTRewardVideoListener instanceof ATRewardVideoExListener)) {
            return;
        }
        ((ATRewardVideoExListener) aTRewardVideoListener).onRewardedVideoAdAgainPlayClicked(j.a(eVarA, this.f12738k));
    }

    @Override // com.anythink.rewardvideo.unitgroup.api.CustomRewardedVideoEventListener
    public final void onRewardedVideoAdAgainPlayEnd() {
        if (this.f12734g == 0) {
            this.f12734g = SystemClock.elapsedRealtime();
        }
        com.anythink.core.common.e.e eVarA = a();
        if (this.f12738k != null && eVarA != null) {
            b(eVarA);
        }
        ATRewardVideoListener aTRewardVideoListener = this.f12737j;
        if (aTRewardVideoListener == null || !(aTRewardVideoListener instanceof ATRewardVideoExListener)) {
            return;
        }
        ((ATRewardVideoExListener) aTRewardVideoListener).onRewardedVideoAdAgainPlayEnd(j.a(eVarA, this.f12738k));
    }

    @Override // com.anythink.rewardvideo.unitgroup.api.CustomRewardedVideoEventListener
    public final void onRewardedVideoAdAgainPlayFailed(String str, String str2) {
        this.f12735h = 99;
        AdError errorCode = ErrorCode.getErrorCode(ErrorCode.adShowError, str, str2);
        com.anythink.core.common.e.e eVarA = a();
        if (this.f12738k != null && eVarA != null) {
            a(errorCode, eVarA);
        }
        ATRewardVideoListener aTRewardVideoListener = this.f12737j;
        if (aTRewardVideoListener == null || !(aTRewardVideoListener instanceof ATRewardVideoExListener)) {
            return;
        }
        ((ATRewardVideoExListener) aTRewardVideoListener).onRewardedVideoAdAgainPlayFailed(errorCode, j.a(eVarA, this.f12738k));
    }

    @Override // com.anythink.rewardvideo.unitgroup.api.CustomRewardedVideoEventListener
    public final void onRewardedVideoAdAgainPlayStart() {
        this.f12735h = 0;
        if (this.f12733f == 0) {
            this.f12733f = SystemClock.elapsedRealtime();
        }
        this.f12734g = 0L;
        com.anythink.core.common.e.e eVarA = a();
        if (this.f12738k != null && eVarA != null) {
            com.anythink.core.common.j.a.a(n.a().g()).a(13, eVarA, this.f12738k.getUnitGroupInfo());
            a(eVarA);
        }
        ATRewardVideoListener aTRewardVideoListener = this.f12737j;
        if (aTRewardVideoListener == null || !(aTRewardVideoListener instanceof ATRewardVideoExListener)) {
            return;
        }
        ((ATRewardVideoExListener) aTRewardVideoListener).onRewardedVideoAdAgainPlayStart(j.a(eVarA, this.f12738k));
    }

    @Override // com.anythink.rewardvideo.unitgroup.api.CustomRewardedVideoEventListener
    public final void onRewardedVideoAdClosed() {
        CustomRewardVideoAdapter customRewardVideoAdapter = this.f12738k;
        if (customRewardVideoAdapter != null) {
            com.anythink.core.common.e.e trackingInfo = customRewardVideoAdapter.getTrackingInfo();
            int dismissType = this.f12735h;
            if (dismissType == 0) {
                dismissType = this.f12738k.getDismissType();
            }
            if (dismissType == 0) {
                dismissType = 1;
            }
            trackingInfo.y(dismissType);
            com.anythink.core.common.k.g.a(trackingInfo, g.i.f6859e, g.i.f6860f, "");
            long j2 = this.a;
            if (j2 != 0) {
                com.anythink.core.common.j.c.a(trackingInfo, this.f12730c, j2, System.currentTimeMillis(), SystemClock.elapsedRealtime() - this.b);
            }
            com.anythink.core.common.j.c.a(trackingInfo, this.f12730c);
            if (this.f12730c) {
                try {
                    this.f12738k.clearImpressionListener();
                    this.f12738k.destory();
                } catch (Throwable unused) {
                }
            } else {
                n.a().a(new Runnable() { // from class: com.anythink.rewardvideo.a.e.1
                    @Override // java.lang.Runnable
                    public final void run() {
                        try {
                            e.this.f12738k.clearImpressionListener();
                            e.this.f12738k.destory();
                        } catch (Throwable unused2) {
                        }
                    }
                }, 5000L);
            }
            if (trackingInfo != null) {
                a(trackingInfo.W());
            }
            ATRewardVideoListener aTRewardVideoListener = this.f12737j;
            if (aTRewardVideoListener != null) {
                aTRewardVideoListener.onRewardedVideoAdClosed(j.a(trackingInfo, this.f12738k));
            }
        }
    }

    @Override // com.anythink.rewardvideo.unitgroup.api.CustomRewardedVideoEventListener
    public final void onRewardedVideoAdPlayClicked() {
        CustomRewardVideoAdapter customRewardVideoAdapter = this.f12738k;
        if (customRewardVideoAdapter != null) {
            c(customRewardVideoAdapter.getTrackingInfo());
        }
        ATRewardVideoListener aTRewardVideoListener = this.f12737j;
        if (aTRewardVideoListener != null) {
            aTRewardVideoListener.onRewardedVideoAdPlayClicked(j.a(this.f12738k));
        }
    }

    @Override // com.anythink.rewardvideo.unitgroup.api.CustomRewardedVideoEventListener
    public final void onRewardedVideoAdPlayEnd() {
        if (this.f12741n == 0) {
            this.f12741n = SystemClock.elapsedRealtime();
        }
        CustomRewardVideoAdapter customRewardVideoAdapter = this.f12738k;
        if (customRewardVideoAdapter != null) {
            if (customRewardVideoAdapter.getDismissType() == 0) {
                this.f12735h = 3;
            }
            b(this.f12738k.getTrackingInfo());
        }
        ATRewardVideoListener aTRewardVideoListener = this.f12737j;
        if (aTRewardVideoListener != null) {
            aTRewardVideoListener.onRewardedVideoAdPlayEnd(j.a(this.f12738k));
        }
    }

    @Override // com.anythink.rewardvideo.unitgroup.api.CustomRewardedVideoEventListener
    public final void onRewardedVideoAdPlayFailed(String str, String str2) {
        this.f12735h = 99;
        AdError errorCode = ErrorCode.getErrorCode(ErrorCode.adShowError, str, str2);
        CustomRewardVideoAdapter customRewardVideoAdapter = this.f12738k;
        if (customRewardVideoAdapter != null) {
            com.anythink.core.common.e.e trackingInfo = customRewardVideoAdapter.getTrackingInfo();
            if (trackingInfo.H() == 66) {
                this.f12736i = false;
            }
            String strW = trackingInfo.W();
            a(errorCode, trackingInfo);
            if (trackingInfo != null) {
                a(trackingInfo.W());
            }
            if (!TextUtils.isEmpty(strW)) {
                a aVarA = a.a(n.a().E(), strW);
                if (aVarA.a((ATAdStatusInfo) null)) {
                    aVarA.a(n.a().E(), 7, (com.anythink.core.common.b.a) null, (com.anythink.core.common.b.b) null, (Map<String, Object>) null);
                }
            }
        }
        ATRewardVideoListener aTRewardVideoListener = this.f12737j;
        if (aTRewardVideoListener != null) {
            aTRewardVideoListener.onRewardedVideoAdPlayFailed(errorCode, j.a(this.f12738k));
        }
    }

    @Override // com.anythink.rewardvideo.unitgroup.api.CustomRewardedVideoEventListener
    public final void onRewardedVideoAdPlayStart() {
        ATRewardVideoListener aTRewardVideoListener;
        String strW;
        this.a = System.currentTimeMillis();
        this.b = SystemClock.elapsedRealtime();
        if (this.f12740m == 0) {
            this.f12740m = this.b;
        }
        j jVarA = j.a(this.f12738k);
        CustomRewardVideoAdapter customRewardVideoAdapter = this.f12738k;
        if (customRewardVideoAdapter != null) {
            com.anythink.core.common.e.e trackingInfo = customRewardVideoAdapter.getTrackingInfo();
            a(trackingInfo);
            if (trackingInfo != null) {
                strW = trackingInfo.W();
                v.a().a(strW, jVarA);
            } else {
                strW = "";
            }
            if (!TextUtils.isEmpty(strW)) {
                a aVarA = a.a(n.a().E(), strW);
                if (aVarA.a((ATAdStatusInfo) null)) {
                    aVarA.a(n.a().E(), 6, (com.anythink.core.common.b.a) null, (com.anythink.core.common.b.b) null, (Map<String, Object>) null);
                }
            }
        }
        if (!this.f12736i || (aTRewardVideoListener = this.f12737j) == null) {
            return;
        }
        aTRewardVideoListener.onRewardedVideoAdPlayStart(jVarA);
    }

    private com.anythink.core.common.e.e a() {
        CustomRewardVideoAdapter customRewardVideoAdapter;
        if (this.f12731d == null && (customRewardVideoAdapter = this.f12738k) != null) {
            this.f12731d = customRewardVideoAdapter.getTrackingInfo().N();
            com.anythink.core.common.e.e eVar = this.f12731d;
            eVar.f7243q = 6;
            this.f12731d.h(com.anythink.core.common.k.g.b(eVar.X(), this.f12731d.x(), System.currentTimeMillis()));
        }
        return this.f12731d;
    }

    private void a(com.anythink.core.common.e.e eVar) {
        String ilrd = this.f12738k.getILRD();
        if (!TextUtils.isEmpty(ilrd)) {
            eVar.a(ilrd);
        }
        if (this.f12736i) {
            com.anythink.core.common.j.a.a(n.a().g()).a(8, eVar);
        }
        com.anythink.core.common.j.a.a(n.a().g()).a(4, eVar, this.f12738k.getUnitGroupInfo());
        com.anythink.core.common.k.g.a(eVar, g.i.f6857c, g.i.f6860f, "");
    }

    private void a(AdError adError, com.anythink.core.common.e.e eVar) {
        com.anythink.core.common.k.g.a(eVar, g.i.f6857c, g.i.f6861g, adError.printStackTrace());
        CustomRewardVideoAdapter customRewardVideoAdapter = this.f12738k;
        com.anythink.core.common.j.c.a(eVar, adError, customRewardVideoAdapter != null ? customRewardVideoAdapter.getNetworkInfoMap() : null);
    }

    private static void a(String str) {
        com.anythink.core.common.e.d dVarD;
        if (TextUtils.isEmpty(str) || (dVarD = v.a().d(str)) == null) {
            return;
        }
        v.a().e(str);
        a.a(n.a().g(), str).d(v.a().a(str, dVarD.a()));
    }
}
