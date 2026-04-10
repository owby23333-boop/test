package com.kwad.sdk;

import android.content.Context;
import android.os.SystemClock;
import android.util.Log;
import com.bykv.vk.component.ttvideo.ILivePlayer;
import com.kwad.sdk.api.KsAdSDK;
import com.kwad.sdk.api.SdkConfig;
import com.kwad.sdk.service.ServiceProvider;

/* JADX INFO: loaded from: classes4.dex */
public final class n {
    private static boolean asQ;
    private static long asy;

    public static void CO() {
        if (asQ) {
            return;
        }
        asQ = true;
        asy = SystemClock.elapsedRealtime();
    }

    public static void l(Throwable th) {
        a(th, Log.getStackTraceString(th));
    }

    public static void a(Throwable th, String str) {
        try {
            m.a(com.kwai.adclient.kscommerciallogger.model.a.beF, str);
            com.kwad.components.core.d.a.reportSdkCaughtException(th);
        } catch (Throwable unused) {
        }
        aR(ServiceProvider.Pp());
        com.kwad.sdk.core.d.c.d("SDKRevertHelper", "onInitError revert");
    }

    public static void aQ(Context context) {
        long jElapsedRealtime = SystemClock.elapsedRealtime() - asy;
        com.kwad.sdk.core.d.c.d("SDKRevertHelper", "onException revert time: " + jElapsedRealtime);
        if (jElapsedRealtime < ILivePlayer.RETRY_TIME_INTERVAL_DEFAULT) {
            aR(context);
        }
    }

    private static void aR(Context context) {
        try {
            context.getSharedPreferences("kssdk_api_pref", 0).edit().putString("curversion", "").putBoolean("initFail", true).apply();
        } catch (Throwable th) {
            com.kwad.sdk.core.d.c.printStackTraceOnly(th);
        }
    }

    public static void aS(Context context) {
        try {
            context.getSharedPreferences("kssdk_api_pref", 0).edit().putBoolean("initFail", false).apply();
        } catch (Throwable th) {
            com.kwad.sdk.core.d.c.printStackTraceOnly(th);
        }
    }

    public static boolean aT(Context context) {
        try {
            return context.getSharedPreferences("kssdk_api_pref", 0).getBoolean("initFail", false);
        } catch (Throwable th) {
            com.kwad.sdk.core.d.c.printStackTraceOnly(th);
            return false;
        }
    }

    private static String b(Context context, String str, String str2) {
        try {
            return context.getSharedPreferences("kssdk_api_pref", 0).getString(str, str2);
        } catch (Throwable th) {
            com.kwad.sdk.core.d.c.printStackTraceOnly(th);
            return str2;
        }
    }

    public static void checkInitSDK(Context context) {
        try {
            if (l.Cf().Bn()) {
                return;
            }
            KsAdSDK.init(context, aU(context));
        } catch (Throwable th) {
            com.kwad.components.core.d.a.reportSdkCaughtException(th);
        }
    }

    private static SdkConfig aU(Context context) {
        SdkConfig sdkConfigCreate;
        try {
            sdkConfigCreate = SdkConfig.create(b(context, "sdkconfig", ""));
        } catch (Throwable th) {
            com.kwad.sdk.core.d.c.printStackTraceOnly(th);
            sdkConfigCreate = null;
        }
        return sdkConfigCreate == null ? new SdkConfig.Builder().build() : sdkConfigCreate;
    }
}
