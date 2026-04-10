package com.xiaomi.ad.mediation;

import android.content.Context;
import com.xiaomi.ad.common.util.ChannelUtil;
import com.xiaomi.ad.common.util.MLog;
import com.xiaomi.ad.mediation.internal.config.IMediationConfigInitListener;
import com.xiaomi.ad.x;

/* JADX INFO: loaded from: classes5.dex */
public class MMAdSdk {
    public static final String AD_TYPE_BANNER = "AD_TYPE_BANNER";
    public static final String AD_TYPE_DRAW = "AD_TYPE_DRAW";
    public static final String AD_TYPE_DRAW_EXPRESS = "AD_TYPE_DRAW_EXPRESS";
    public static final String AD_TYPE_FEED = "AD_TYPE_FEED";
    public static final String AD_TYPE_FULLSCREEN_INTERSTITIAL = "AD_TYPE_FULL_SCREEN_INTERSTITIAL";
    public static final String AD_TYPE_INTERSTITIAL = "AD_TYPE_INTERSTITIAL";
    public static final String AD_TYPE_NATIVE = "AD_TYPE_NATIVE";
    public static final String AD_TYPE_REWARD_VIDEO = "AD_TYPE_REWARD_VIDEO";
    public static final String AD_TYPE_SPLASH = "AD_TYPE_SPLASH";
    public static final String AD_TYPE_TEMPLATE = "AD_TYPE_TEMPLATE";
    public static final int VERSION_CODE = 187;
    public static final String VERSION_NAME = "1.8.7";
    public static MMAdSdkConfig sAdConfig;

    public static MMAdSdkConfig getAdConfig() {
        return sAdConfig;
    }

    public static void init(Context context, MMAdSdkConfig mMAdSdkConfig) {
        sAdConfig = mMAdSdkConfig;
        if (mMAdSdkConfig.isDebug) {
            MLog.setDebugOn();
        } else {
            MLog.setDebugOff();
        }
        ChannelUtil.updateChannel(context, mMAdSdkConfig.getChannelId());
        x.a(context);
    }

    public static void registerAdapter(String str, String str2, String str3, Class<? extends MMAdBaseAdapter> cls) {
        MMAdAdapterFactory.getInstance().registerAdapterClass(str, str2, str3, cls);
    }

    public static void setAdConfig(MMAdSdkConfig mMAdSdkConfig) {
        sAdConfig = mMAdSdkConfig;
    }

    public static void setDebugLog(boolean z) {
        MMAdSdkConfig mMAdSdkConfig = sAdConfig;
        if (mMAdSdkConfig != null) {
            mMAdSdkConfig.isDebug = z;
        }
        if (z) {
            MLog.setDebugOn();
        } else {
            MLog.setDebugOff();
        }
    }

    public static void setStaging(boolean z) {
        MMAdSdkConfig mMAdSdkConfig = sAdConfig;
        if (mMAdSdkConfig != null) {
            mMAdSdkConfig.isStaging = z;
        }
        if (x.f() != null) {
            x.f().d();
            x.f().c();
        }
    }

    public static void init(Context context, MMAdSdkConfig mMAdSdkConfig, String str, IMediationConfigInitListener iMediationConfigInitListener) {
        sAdConfig = mMAdSdkConfig;
        if (mMAdSdkConfig.isDebug) {
            MLog.setDebugOn();
        } else {
            MLog.setDebugOff();
        }
        x.a(context, str, iMediationConfigInitListener);
    }
}
