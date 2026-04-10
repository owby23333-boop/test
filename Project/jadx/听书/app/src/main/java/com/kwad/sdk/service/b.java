package com.kwad.sdk.service;

import com.kwad.sdk.api.SdkConfig;

/* JADX INFO: loaded from: classes4.dex */
public final class b {
    private static SdkConfig mSdkConfig;

    public static void holderSdkConfig(SdkConfig sdkConfig) {
        mSdkConfig = sdkConfig;
    }

    public static SdkConfig getSDKConfig() {
        return mSdkConfig;
    }

    public static String getAppId() {
        return mSdkConfig.appId;
    }

    public static String getAppName() {
        return mSdkConfig.appName;
    }
}
