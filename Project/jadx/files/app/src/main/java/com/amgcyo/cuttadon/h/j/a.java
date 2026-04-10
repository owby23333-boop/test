package com.amgcyo.cuttadon.h.j;

import com.amgcyo.cuttadon.utils.otherutils.g;
import com.anythink.core.api.ATAdInfo;
import com.sntech.ads.SNAdSdk;
import com.sntech.ads.api.event.SNEvent;

/* JADX INFO: compiled from: X1OptimizationUtil.java */
/* JADX INFO: loaded from: classes.dex */
public class a {
    public static void a(SNEvent.AdType adType, ATAdInfo aTAdInfo) {
        if (!a() || aTAdInfo == null) {
            return;
        }
        SNEvent.AdPlatform adPlatformB = b(aTAdInfo);
        String str = "保价广告广告平台:" + adPlatformB;
        SNAdSdk.getMediationManager().onAdShow(adPlatformB, adType, a(aTAdInfo), aTAdInfo.getEcpm());
    }

    private static SNEvent.AdPlatform b(ATAdInfo aTAdInfo) {
        return SNEvent.getTopOnRealAdPlatform(aTAdInfo);
    }

    public static void c(ATAdInfo aTAdInfo) {
        if (!a() || aTAdInfo == null) {
            return;
        }
        SNEvent.AdPlatform adPlatformB = b(aTAdInfo);
        String str = "广告平台:" + adPlatformB;
        SNAdSdk.getEventManager().onAdClick(adPlatformB, a(aTAdInfo));
    }

    public static void d(ATAdInfo aTAdInfo) {
        if (aTAdInfo == null || !a()) {
            return;
        }
        SNEvent.AdPlatform adPlatformB = b(aTAdInfo);
        double ecpm = aTAdInfo.getEcpm();
        String str = "广告平台: " + adPlatformB.name() + " ecpm: " + ecpm;
        SNAdSdk.getEventManager().onAdShow(adPlatformB, a(aTAdInfo), ecpm, aTAdInfo.getShowId());
    }

    public static void a(SNEvent.UserEvent userEvent) {
        if (!a() || userEvent == null) {
            return;
        }
        SNAdSdk.getEventManager().onUserEvent(userEvent);
    }

    private static String a(ATAdInfo aTAdInfo) {
        String topOnRealAdId = SNEvent.getTopOnRealAdId(aTAdInfo);
        String str = "onRealAdId:" + topOnRealAdId;
        return topOnRealAdId;
    }

    public static boolean a() {
        boolean zD0 = g.d0();
        String str = "x1OpenStatus:" + zD0;
        return zD0;
    }
}
