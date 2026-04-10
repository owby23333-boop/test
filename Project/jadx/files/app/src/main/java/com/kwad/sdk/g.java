package com.kwad.sdk;

import android.os.SystemClock;
import android.util.Log;
import com.kwad.sdk.utils.x;

/* JADX INFO: loaded from: classes3.dex */
public final class g {
    private static boolean Yo;
    private static long Yp;

    public static void a(Throwable th, String str) {
        f.a(com.kwai.adclient.logger.model.a.aCP, str);
        com.kwad.components.core.c.a.b(th);
        com.kwad.sdk.core.d.b.d("SDKRevertHelper", "onInitError revert");
    }

    public static void d(Throwable th) {
        a(th, Log.getStackTraceString(th));
    }

    public static void te() {
        if (Yo) {
            return;
        }
        Yo = true;
        Yp = SystemClock.elapsedRealtime();
    }

    public static void tf() {
        if (SystemClock.elapsedRealtime() - Yp < 10000) {
            com.kwad.sdk.core.d.b.d("SDKRevertHelper", "onException revert");
            tg();
        }
    }

    private static void tg() {
        x.c(KsAdSDKImpl.get().getContext(), "kssdk_api_pref", "curversion", "");
    }
}
