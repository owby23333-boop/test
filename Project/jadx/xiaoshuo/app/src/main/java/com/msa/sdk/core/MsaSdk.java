package com.msa.sdk.core;

import android.content.Context;
import android.util.Log;
import com.msa.sdk.core.feedback.DislikeManagerV2;
import com.msa.sdk.core.landingPage.LandingPageProxy;

/* JADX INFO: loaded from: classes3.dex */
public class MsaSdk {
    private static boolean debug = false;
    private static boolean staging = false;

    public static void initDislikeManager(Context context) {
        DislikeManagerV2.getInstance(context);
    }

    public static void initLandingPageProxy(Context context) {
        LandingPageProxy.initRemoteProxy(context);
    }

    @Deprecated
    public static void initMiuiHomeDownloadActivateManager(Context context) {
        Log.e("MSA-SDK", "该功能已经废弃，MSA已经不支持静默下载");
    }

    @Deprecated
    public static void initRemoteUnifiedAdService(Context context) {
        Log.e("MSA-SDK", "该功能已经废弃，MSA已经不支持");
    }

    public static boolean isDebug() {
        return debug;
    }

    public static boolean isStaging() {
        return staging;
    }

    public static void setDebug(boolean z) {
        debug = z;
    }

    public static void setStaging(boolean z) {
        staging = z;
    }
}
