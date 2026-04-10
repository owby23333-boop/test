package com.dangdang.zframework.utils;

/* JADX INFO: loaded from: classes10.dex */
public class DangdangConfig {
    public static final String CHANNEL_ID = "30000";
    public static final String DEVICE_ID = "ANDROID_ID";
    public static final String DEVICE_TYPE = "YC_Android";
    public static final String FROM_PLATFORM = "103";
    public static final String PLATFORM_SOURCE = "DDXS-P";
    public static final String UPDATEVERSION_TYPE_SOFTWARE = "1";

    public static String getRemainders() {
        return "?refresh=" + CommonUtil.getRandomInt(1, 10000);
    }
}
