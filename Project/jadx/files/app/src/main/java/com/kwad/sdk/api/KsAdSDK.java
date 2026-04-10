package com.kwad.sdk.api;

import android.content.Context;
import androidx.annotation.ColorInt;
import androidx.annotation.Keep;
import androidx.annotation.Nullable;
import androidx.annotation.RawRes;
import com.anythink.core.common.c.d;
import com.kwad.sdk.api.core.IKsAdSDK;
import com.kwad.sdk.api.core.KsAdSdkApi;
import com.kwad.sdk.api.loader.Loader;
import com.kwad.sdk.api.loader.Wrapper;
import com.kwad.sdk.api.loader.t;
import com.kwad.sdk.api.loader.u;
import com.kwad.sdk.api.proxy.app.AdSdkFileProvider;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes.dex */
@KsAdSdkApi
@Keep
public class KsAdSDK {
    private static Context mOriginalAppContext;
    private static String sAppTag;
    public static final AtomicBoolean sHasInit = new AtomicBoolean(false);
    private static final AtomicBoolean sHasRest = new AtomicBoolean(false);

    @Keep
    private static IKsAdSDK sSdk;

    @Keep
    @Retention(RetentionPolicy.SOURCE)
    public @interface KsThemeModeType {
        public static final int NIGHT = 1;
        public static final int NORMAL = 0;
    }

    @Keep
    @Retention(RetentionPolicy.SOURCE)
    public @interface SdkType {
        public static final int AD = 1;
        public static final int CAR = 5;
        public static final int CT = 2;
        public static final int CT_PURE = 4;
        public static final int EC = 3;
    }

    @KsAdSdkApi
    @Keep
    public static void deleteCache() {
        IKsAdSDK iKsAdSDK = sSdk;
        if (iKsAdSDK != null) {
            iKsAdSDK.deleteCache();
        }
    }

    @KsAdSdkApi
    @Keep
    public static String getAppId() {
        IKsAdSDK iKsAdSDK = sSdk;
        if (iKsAdSDK != null) {
            return iKsAdSDK.getAppId();
        }
        return null;
    }

    @KsAdSdkApi
    @Keep
    public static String getAppName() {
        IKsAdSDK iKsAdSDK = sSdk;
        if (iKsAdSDK != null) {
            return iKsAdSDK.getAppName();
        }
        return null;
    }

    @Nullable
    @KsAdSdkApi
    @Keep
    public static Context getContext() {
        return mOriginalAppContext;
    }

    @KsAdSdkApi
    @Keep
    public static String getDid() {
        IKsAdSDK iKsAdSDK = sSdk;
        if (iKsAdSDK != null) {
            return iKsAdSDK.getDid();
        }
        return null;
    }

    @Nullable
    @KsAdSdkApi
    @Keep
    public static synchronized KsLoadManager getLoadManager() {
        if (sSdk == null || !sHasInit.get()) {
            return new b();
        }
        return sSdk.getAdManager();
    }

    @KsAdSdkApi
    @Keep
    public static int getSDKType() {
        return 1;
    }

    @KsAdSdkApi
    @Keep
    public static String getSDKVersion() {
        return "3.3.38";
    }

    @KsAdSdkApi
    @Keep
    public static String getSDKVersion(int i2) {
        if (i2 == 1) {
            return "3.3.38";
        }
        if (i2 == 2 || i2 == 3 || i2 != 4) {
        }
        return "";
    }

    @KsAdSdkApi
    @Keep
    public static synchronized boolean init(Context context, final SdkConfig sdkConfig) {
        try {
            if (context == null || sdkConfig == null) {
                if (sdkConfig != null && sdkConfig.ksInitCallback != null) {
                    sdkConfig.ksInitCallback.onFail(0, "context or config is null");
                }
                return false;
            }
            mOriginalAppContext = context;
            try {
                final Context contextAw = com.kwad.sdk.api.loader.c.aw(context);
                if (contextAw == null) {
                    revertDynamic(new RuntimeException("wrappApp Exception"), context, sdkConfig);
                    return false;
                }
                try {
                    sSdk = Loader.get().init(contextAw);
                    sSdk.setApiVersion("3.3.38");
                    sSdk.setApiVersionCode(3033800);
                    sSdk.setAppTag(sAppTag);
                    sSdk.setLaunchTime(AdSdkFileProvider.sLaunchTime);
                    try {
                        Context contextWrapContextIfNeed = Wrapper.wrapContextIfNeed(contextAw);
                        if (contextWrapContextIfNeed == null) {
                            revertDynamic(new RuntimeException("wrapContextIfNeed Exception"), contextAw, sdkConfig);
                            return false;
                        }
                        sSdk.init(contextWrapContextIfNeed, sdkConfig);
                        u.a(contextAw, sSdk);
                        sHasInit.set(true);
                        com.kwad.sdk.api.kwai.a.submit(new Runnable() { // from class: com.kwad.sdk.api.KsAdSDK.1
                            @Override // java.lang.Runnable
                            public final void run() {
                                t.d(contextAw, d.a.a, sdkConfig.toJson());
                            }
                        });
                    } catch (Throwable th) {
                        revertDynamic(th, contextAw, sdkConfig);
                        return false;
                    }
                } catch (Throwable th2) {
                    th = th2;
                    context = contextAw;
                    revertDynamic(th, context, sdkConfig);
                    return false;
                }
            } catch (Throwable th3) {
                th = th3;
            }
        } catch (Throwable unused) {
        }
        return sHasInit.get();
    }

    @KsAdSdkApi
    @Keep
    public static boolean isDebugLogEnable() {
        IKsAdSDK iKsAdSDK = sSdk;
        if (iKsAdSDK != null) {
            return iKsAdSDK.isDebugLogEnable();
        }
        return false;
    }

    @KsAdSdkApi
    @Keep
    public static void pauseCurrentPlayer() {
        IKsAdSDK iKsAdSDK = sSdk;
        if (iKsAdSDK != null) {
            iKsAdSDK.pauseCurrentPlayer();
        }
    }

    public static void re(Object obj) {
        IKsAdSDK iKsAdSDK = sSdk;
        if (iKsAdSDK != null) {
            iKsAdSDK.re(obj);
        }
    }

    @KsAdSdkApi
    @Keep
    public static void resumeCurrentPlayer() {
        IKsAdSDK iKsAdSDK = sSdk;
        if (iKsAdSDK != null) {
            iKsAdSDK.resumeCurrentPlayer();
        }
    }

    private static void revertDynamic(Throwable th, Context context, SdkConfig sdkConfig) {
        if (sHasRest.get()) {
            return;
        }
        sHasRest.set(true);
        u.aE(context);
        Loader.get().rest();
        String str = "init appId after reset:" + sdkConfig.appId;
        init(context, sdkConfig);
        if (sSdk == null || !sHasInit.get()) {
            return;
        }
        sSdk.re(th);
    }

    @KsAdSdkApi
    @Keep
    public static void setAdxEnable(boolean z2) {
        IKsAdSDK iKsAdSDK = sSdk;
        if (iKsAdSDK != null) {
            iKsAdSDK.setAdxEnable(z2);
        }
    }

    @KsAdSdkApi
    @Keep
    public static void setAppTag(String str) {
        IKsAdSDK iKsAdSDK = sSdk;
        if (iKsAdSDK != null) {
            iKsAdSDK.setAppTag(str);
        } else {
            sAppTag = str;
        }
    }

    public static void setLoadingLottieAnimation(boolean z2, @RawRes int i2) {
        IKsAdSDK iKsAdSDK = sSdk;
        if (iKsAdSDK != null) {
            iKsAdSDK.setLoadingLottieAnimation(z2, i2);
        }
    }

    public static void setLoadingLottieAnimationColor(boolean z2, @ColorInt int i2) {
        IKsAdSDK iKsAdSDK = sSdk;
        if (iKsAdSDK != null) {
            iKsAdSDK.setLoadingLottieAnimationColor(z2, i2);
        }
    }

    @KsAdSdkApi
    @Keep
    public static void setPersonalRecommend(boolean z2) {
        IKsAdSDK iKsAdSDK = sSdk;
        if (iKsAdSDK != null) {
            iKsAdSDK.setPersonalRecommend(z2);
        }
    }

    @KsAdSdkApi
    @Keep
    public static void setProgrammaticRecommend(boolean z2) {
        IKsAdSDK iKsAdSDK = sSdk;
        if (iKsAdSDK != null) {
            iKsAdSDK.setProgrammaticRecommend(z2);
        }
    }

    public static void setThemeMode(int i2) {
        IKsAdSDK iKsAdSDK = sSdk;
        if (iKsAdSDK != null) {
            iKsAdSDK.setThemeMode(i2);
        }
    }

    @KsAdSdkApi
    @Keep
    public static void unInit() {
        IKsAdSDK iKsAdSDK = sSdk;
        if (iKsAdSDK != null) {
            iKsAdSDK.unInit();
        }
        sSdk = null;
    }
}
