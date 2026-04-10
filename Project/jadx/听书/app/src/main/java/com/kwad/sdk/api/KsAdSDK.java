package com.kwad.sdk.api;

import android.content.Context;
import android.os.SystemClock;
import android.util.Log;
import com.kwad.components.offline.api.BuildConfig;
import com.kwad.sdk.api.core.IKsAdSDK;
import com.kwad.sdk.api.core.KsAdSdkApi;
import com.kwad.sdk.api.loader.Loader;
import com.kwad.sdk.api.loader.Wrapper;
import com.kwad.sdk.api.loader.aa;
import com.kwad.sdk.api.loader.e;
import com.kwad.sdk.api.loader.q;
import com.kwad.sdk.api.loader.r;
import com.kwad.sdk.api.proxy.app.AdSdkFileProvider;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes4.dex */
@KsAdSdkApi
public class KsAdSDK {
    private static final int INIT_ERROR_IKSADSDK_NULL_CODE = -1;
    private static final String INIT_ERROR_IKSADSDK_NULL_MSG = "IKsAdSDK对象创建异常";
    private static Context mOriginalAppContext;
    private static String sAppTag;
    public static final AtomicBoolean sHasInit = new AtomicBoolean(false);
    private static final AtomicBoolean sHasRest = new AtomicBoolean(false);
    private static IKsAdSDK sSdk;

    @Retention(RetentionPolicy.SOURCE)
    public @interface KsThemeModeType {
        public static final int NIGHT = 1;
        public static final int NORMAL = 0;
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface SdkType {
        public static final int AD = 1;
        public static final int CAR = 5;
        public static final int CT = 2;
        public static final int CT_PURE = 4;
        public static final int EC = 3;
    }

    @KsAdSdkApi
    public static int getSDKType() {
        return 1;
    }

    @KsAdSdkApi
    public static String getSDKVersion() {
        return BuildConfig.VERSION_NAME;
    }

    @KsAdSdkApi
    public static String getSDKVersion(int i) {
        return i != 1 ? "" : BuildConfig.VERSION_NAME;
    }

    public static void setThemeMode(int i) {
        IKsAdSDK iKsAdSDK = sSdk;
        if (iKsAdSDK != null) {
            iKsAdSDK.setThemeMode(i);
        }
    }

    public static void setLoadingLottieAnimation(boolean z, int i) {
        IKsAdSDK iKsAdSDK = sSdk;
        if (iKsAdSDK != null) {
            iKsAdSDK.setLoadingLottieAnimation(z, i);
        }
    }

    public static void setLoadingLottieAnimationColor(boolean z, int i) {
        IKsAdSDK iKsAdSDK = sSdk;
        if (iKsAdSDK != null) {
            iKsAdSDK.setLoadingLottieAnimationColor(z, i);
        }
    }

    @KsAdSdkApi
    public static synchronized boolean init(Context context, SdkConfig sdkConfig) {
        long jElapsedRealtime;
        Context contextAV;
        Throwable th;
        try {
            jElapsedRealtime = SystemClock.elapsedRealtime();
        } catch (Throwable th2) {
            th2.printStackTrace();
        }
        if (context == null || sdkConfig == null) {
            throw new RuntimeException("init context or config is null");
        }
        mOriginalAppContext = context;
        try {
            contextAV = e.aV(context);
            if (contextAV == null) {
                throw new RuntimeException("init wrapperApp Exception");
            }
            try {
                q qVarDp = r.Dp();
                if (qVarDp != null) {
                    qVarDp.holdSdkConfig(sdkConfig);
                }
                IKsAdSDK iKsAdSDKInit = Loader.get().init(contextAV, KsAdSDK.class.getClassLoader());
                sSdk = iKsAdSDKInit;
                if (iKsAdSDKInit == null) {
                    notifyInitFail(sdkConfig, -1, INIT_ERROR_IKSADSDK_NULL_MSG);
                }
                sSdk.setApiVersion(BuildConfig.VERSION_NAME);
                sSdk.setApiVersionCode(BuildConfig.VERSION_CODE);
                sSdk.setLaunchTime(AdSdkFileProvider.sLaunchTime);
                Context contextWrapContextIfNeed = Wrapper.wrapContextIfNeed(contextAV);
                if (contextWrapContextIfNeed == null) {
                    throw new RuntimeException("init wrapContextIfNeed Exception");
                }
                try {
                    sSdk.setInitStartTime(jElapsedRealtime);
                } catch (Throwable th3) {
                    c.m(th3);
                }
                sSdk.init(contextWrapContextIfNeed, sdkConfig);
                sSdk.setAppTag(sAppTag);
                aa.a(contextAV, sSdk);
                com.kwad.sdk.api.loader.b.a(contextAV, sdkConfig);
                c.ow();
                sHasInit.set(sSdk != null);
                return sHasInit.get();
            } catch (Throwable th4) {
                th = th4;
            }
        } catch (Throwable th5) {
            contextAV = context;
            th = th5;
        }
        revertDynamic(th, contextAV, sdkConfig);
        return false;
    }

    @KsAdSdkApi
    public static synchronized void start() {
        try {
            sSdk.start();
        } catch (Throwable th) {
            c.m(th);
        }
    }

    public static boolean haseInit() {
        return sHasInit.get();
    }

    private static void revertDynamic(Throwable th, Context context, SdkConfig sdkConfig) {
        AtomicBoolean atomicBoolean = sHasRest;
        if (atomicBoolean.get()) {
            return;
        }
        atomicBoolean.set(true);
        aa.be(context);
        Loader.get().rest();
        Log.d("KSAdSDK", "init appId after reset:" + sdkConfig.appId);
        init(context, sdkConfig);
        c.m(th);
    }

    @KsAdSdkApi
    public static boolean isDebugLogEnable() {
        IKsAdSDK iKsAdSDK = sSdk;
        if (iKsAdSDK != null) {
            return iKsAdSDK.isDebugLogEnable();
        }
        return false;
    }

    @KsAdSdkApi
    public static String getAppId() {
        IKsAdSDK iKsAdSDK = sSdk;
        if (iKsAdSDK != null) {
            return iKsAdSDK.getAppId();
        }
        return null;
    }

    @KsAdSdkApi
    public static String getAppName() {
        IKsAdSDK iKsAdSDK = sSdk;
        if (iKsAdSDK != null) {
            return iKsAdSDK.getAppName();
        }
        return null;
    }

    @KsAdSdkApi
    public static Context getContext() {
        return mOriginalAppContext;
    }

    @KsAdSdkApi
    public static synchronized KsLoadManager getLoadManager() {
        if (sSdk != null && sHasInit.get()) {
            return sSdk.getAdManager();
        }
        Log.e("KsAdSDK", "please init sdk before getLoadManager");
        return new b();
    }

    @KsAdSdkApi
    public static void unInit() {
        IKsAdSDK iKsAdSDK = sSdk;
        if (iKsAdSDK != null) {
            iKsAdSDK.unInit();
        }
        sSdk = null;
    }

    @KsAdSdkApi
    public static void deleteCache() {
        IKsAdSDK iKsAdSDK = sSdk;
        if (iKsAdSDK != null) {
            iKsAdSDK.deleteCache();
        }
    }

    @KsAdSdkApi
    public static String getDid() {
        IKsAdSDK iKsAdSDK = sSdk;
        if (iKsAdSDK != null) {
            return iKsAdSDK.getDid();
        }
        return null;
    }

    @KsAdSdkApi
    public static void setAppTag(String str) {
        IKsAdSDK iKsAdSDK = sSdk;
        if (iKsAdSDK != null) {
            iKsAdSDK.setAppTag(str);
        } else {
            sAppTag = str;
        }
    }

    @KsAdSdkApi
    public static void resumeCurrentPlayer() {
        IKsAdSDK iKsAdSDK = sSdk;
        if (iKsAdSDK != null) {
            iKsAdSDK.resumeCurrentPlayer();
        }
    }

    @KsAdSdkApi
    public static void pauseCurrentPlayer() {
        IKsAdSDK iKsAdSDK = sSdk;
        if (iKsAdSDK != null) {
            iKsAdSDK.pauseCurrentPlayer();
        }
    }

    @KsAdSdkApi
    public static void setPersonalRecommend(boolean z) {
        IKsAdSDK iKsAdSDK = sSdk;
        if (iKsAdSDK != null) {
            iKsAdSDK.setPersonalRecommend(z);
        }
    }

    @KsAdSdkApi
    public static void setProgrammaticRecommend(boolean z) {
        IKsAdSDK iKsAdSDK = sSdk;
        if (iKsAdSDK != null) {
            iKsAdSDK.setProgrammaticRecommend(z);
        }
    }

    @KsAdSdkApi
    public static void setAdxEnable(boolean z) {
        IKsAdSDK iKsAdSDK = sSdk;
        if (iKsAdSDK != null) {
            iKsAdSDK.setAdxEnable(z);
        }
    }

    private static void notifyInitFail(SdkConfig sdkConfig, int i, String str) {
        if (sdkConfig != null) {
            try {
                KsInitCallback ksInitCallback = sdkConfig.ksInitCallback;
                if (ksInitCallback != null) {
                    ksInitCallback.onFail(i, str);
                }
            } catch (Throwable unused) {
            }
        }
    }
}
