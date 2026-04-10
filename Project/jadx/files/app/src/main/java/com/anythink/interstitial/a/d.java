package com.anythink.interstitial.a;

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
import com.anythink.interstitial.api.ATInterstitialExListener;
import com.anythink.interstitial.api.ATInterstitialListener;
import com.anythink.interstitial.unitgroup.api.CustomInterstitialAdapter;
import com.anythink.interstitial.unitgroup.api.CustomInterstitialEventListener;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public final class d implements CustomInterstitialEventListener {
    ATInterstitialListener a;
    CustomInterstitialAdapter b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    long f12312c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    long f12313d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    int f12314e = 0;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    boolean f12315f = true;

    public d(CustomInterstitialAdapter customInterstitialAdapter, ATInterstitialListener aTInterstitialListener) {
        this.a = aTInterstitialListener;
        this.b = customInterstitialAdapter;
    }

    private static void a(String str) {
        com.anythink.core.common.e.d dVarD;
        if (TextUtils.isEmpty(str) || (dVarD = v.a().d(str)) == null) {
            return;
        }
        v.a().e(str);
        a.a(n.a().g(), str).d(v.a().a(str, dVarD.a()));
    }

    @Override // com.anythink.interstitial.unitgroup.api.CustomInterstitialEventListener
    public final void onDeeplinkCallback(boolean z2) {
        ATInterstitialListener aTInterstitialListener = this.a;
        if (aTInterstitialListener == null || !(aTInterstitialListener instanceof ATInterstitialExListener)) {
            return;
        }
        ((ATInterstitialExListener) aTInterstitialListener).onDeeplinkCallback(j.a(this.b), z2);
    }

    @Override // com.anythink.interstitial.unitgroup.api.CustomInterstitialEventListener
    public final void onDownloadConfirm(Context context, ATNetworkConfirmInfo aTNetworkConfirmInfo) {
        ATInterstitialListener aTInterstitialListener = this.a;
        if (aTInterstitialListener == null || !(aTInterstitialListener instanceof ATInterstitialExListener)) {
            return;
        }
        ((ATInterstitialExListener) aTInterstitialListener).onDownloadConfirm(context, j.a(this.b), aTNetworkConfirmInfo);
    }

    @Override // com.anythink.interstitial.unitgroup.api.CustomInterstitialEventListener
    public final void onInterstitialAdClicked() {
        CustomInterstitialAdapter customInterstitialAdapter = this.b;
        if (customInterstitialAdapter != null) {
            com.anythink.core.common.e.e trackingInfo = customInterstitialAdapter.getTrackingInfo();
            g.a(trackingInfo, g.i.f6858d, g.i.f6860f, "");
            com.anythink.core.common.j.a.a(n.a().g()).a(6, trackingInfo);
        }
        ATInterstitialListener aTInterstitialListener = this.a;
        if (aTInterstitialListener != null) {
            aTInterstitialListener.onInterstitialAdClicked(j.a(this.b));
        }
    }

    @Override // com.anythink.interstitial.unitgroup.api.CustomInterstitialEventListener
    public final void onInterstitialAdClose() {
        CustomInterstitialAdapter customInterstitialAdapter = this.b;
        if (customInterstitialAdapter != null) {
            com.anythink.core.common.e.e trackingInfo = customInterstitialAdapter.getTrackingInfo();
            int dismissType = this.f12314e;
            if (dismissType == 0) {
                dismissType = this.b.getDismissType();
            }
            if (dismissType == 0) {
                dismissType = 1;
            }
            trackingInfo.y(dismissType);
            com.anythink.core.common.k.g.a(trackingInfo, g.i.f6859e, g.i.f6860f, "");
            long j2 = this.f12312c;
            if (j2 != 0) {
                com.anythink.core.common.j.c.a(trackingInfo, false, j2, System.currentTimeMillis(), SystemClock.elapsedRealtime() - this.f12313d);
            }
            com.anythink.core.common.j.c.a(trackingInfo, false);
            try {
                this.b.clearImpressionListener();
                this.b.destory();
            } catch (Throwable unused) {
            }
            ATInterstitialListener aTInterstitialListener = this.a;
            if (aTInterstitialListener != null) {
                aTInterstitialListener.onInterstitialAdClose(j.a(trackingInfo, this.b));
            }
            if (trackingInfo != null) {
                a(trackingInfo.W());
            }
        }
    }

    @Override // com.anythink.interstitial.unitgroup.api.CustomInterstitialEventListener
    public final void onInterstitialAdShow() {
        this.f12312c = System.currentTimeMillis();
        this.f12313d = SystemClock.elapsedRealtime();
        j jVarA = j.a(this.b);
        CustomInterstitialAdapter customInterstitialAdapter = this.b;
        if (customInterstitialAdapter != null) {
            com.anythink.core.common.e.e trackingInfo = customInterstitialAdapter.getTrackingInfo();
            String ilrd = this.b.getILRD();
            if (!TextUtils.isEmpty(ilrd)) {
                trackingInfo.a(ilrd);
            }
            String strW = "";
            com.anythink.core.common.k.g.a(trackingInfo, g.i.f6857c, g.i.f6860f, "");
            com.anythink.core.common.j.a.a(n.a().g()).a(4, trackingInfo, this.b.getUnitGroupInfo());
            if (trackingInfo != null) {
                strW = trackingInfo.W();
                v.a().a(strW, jVarA);
            }
            if (!TextUtils.isEmpty(strW)) {
                a aVarA = a.a(n.a().E(), strW);
                if (aVarA.a((ATAdStatusInfo) null)) {
                    aVarA.a(n.a().E(), 6, (com.anythink.core.common.b.a) null, (com.anythink.core.common.b.b) null, (Map<String, Object>) null);
                }
            }
        }
        ATInterstitialListener aTInterstitialListener = this.a;
        if (aTInterstitialListener != null) {
            aTInterstitialListener.onInterstitialAdShow(jVarA);
        }
    }

    @Override // com.anythink.interstitial.unitgroup.api.CustomInterstitialEventListener
    public final void onInterstitialAdVideoEnd() {
        CustomInterstitialAdapter customInterstitialAdapter = this.b;
        if (customInterstitialAdapter != null) {
            if (customInterstitialAdapter.getDismissType() == 0) {
                this.f12314e = 3;
            }
            com.anythink.core.common.j.a.a(n.a().g()).a(9, this.b.getTrackingInfo());
            ATInterstitialListener aTInterstitialListener = this.a;
            if (aTInterstitialListener != null) {
                aTInterstitialListener.onInterstitialAdVideoEnd(j.a(this.b));
            }
        }
    }

    @Override // com.anythink.interstitial.unitgroup.api.CustomInterstitialEventListener
    public final void onInterstitialAdVideoError(String str, String str2) {
        String strW;
        this.f12314e = 99;
        AdError errorCode = ErrorCode.getErrorCode(ErrorCode.adShowError, str, str2);
        CustomInterstitialAdapter customInterstitialAdapter = this.b;
        if (customInterstitialAdapter != null) {
            com.anythink.core.common.e.e trackingInfo = customInterstitialAdapter.getTrackingInfo();
            if (trackingInfo.H() == 66) {
                this.f12315f = false;
            }
            com.anythink.core.common.j.c.a(trackingInfo, errorCode, this.b.getNetworkInfoMap());
            if (trackingInfo != null) {
                strW = trackingInfo.W();
                a(trackingInfo.W());
            } else {
                strW = "";
            }
            if (!TextUtils.isEmpty(strW)) {
                a aVarA = a.a(n.a().E(), strW);
                if (aVarA.a((ATAdStatusInfo) null)) {
                    aVarA.a(n.a().E(), 7, (com.anythink.core.common.b.a) null, (com.anythink.core.common.b.b) null, (Map<String, Object>) null);
                }
            }
        }
        ATInterstitialListener aTInterstitialListener = this.a;
        if (aTInterstitialListener != null) {
            aTInterstitialListener.onInterstitialAdVideoError(errorCode);
        }
    }

    @Override // com.anythink.interstitial.unitgroup.api.CustomInterstitialEventListener
    public final void onInterstitialAdVideoStart() {
        CustomInterstitialAdapter customInterstitialAdapter = this.b;
        if (customInterstitialAdapter != null) {
            com.anythink.core.common.e.e trackingInfo = customInterstitialAdapter.getTrackingInfo();
            if (this.f12315f) {
                com.anythink.core.common.j.a.a(n.a().g()).a(8, trackingInfo);
                ATInterstitialListener aTInterstitialListener = this.a;
                if (aTInterstitialListener != null) {
                    aTInterstitialListener.onInterstitialAdVideoStart(j.a(this.b));
                }
            }
        }
    }
}
