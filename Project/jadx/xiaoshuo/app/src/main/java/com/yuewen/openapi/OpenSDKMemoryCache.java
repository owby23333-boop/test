package com.yuewen.openapi;

import android.content.Context;
import android.text.TextUtils;

/* JADX INFO: loaded from: classes8.dex */
public class OpenSDKMemoryCache {
    public static final int PLATFORM = 2;
    public static final int VERSION = 1;
    public static String appFlag = null;
    public static Context context = null;
    public static String guid = null;
    public static String imei = "";
    public static String openId;
    public static String token;

    public static String getAppFlag() {
        Context context2;
        return (!TextUtils.isEmpty(appFlag) || (context2 = context) == null) ? appFlag : OpenSDKConfig.getLocalData(context2, OpenSDKConfig.APP_FLAG);
    }

    public static Context getContext() {
        return context;
    }

    public static String getGuid() {
        Context context2;
        return (!TextUtils.isEmpty(guid) || (context2 = context) == null) ? guid : OpenSDKConfig.getLocalData(context2, "guid");
    }

    public static String getImei() {
        Context context2;
        return (!TextUtils.isEmpty(imei) || (context2 = context) == null) ? imei : OpenSDKConfig.getLocalData(context2, "imei");
    }

    public static String getOpenId() {
        return openId;
    }

    public static String getToken() {
        Context context2;
        return (!TextUtils.isEmpty(token) || (context2 = context) == null) ? token : OpenSDKConfig.getLocalData(context2, "token");
    }

    public static void setAppFlag(String str) {
        appFlag = str;
        if (context == null || TextUtils.isEmpty(str)) {
            return;
        }
        OpenSDKConfig.setLocalData(context, OpenSDKConfig.APP_FLAG, str);
    }

    public static void setContext(Context context2) {
        context = context2;
    }

    public static void setGuid(String str) {
        guid = str;
        if (context == null || TextUtils.isEmpty(str)) {
            return;
        }
        OpenSDKConfig.setLocalData(context, "guid", str);
    }

    public static void setImei(String str) {
        imei = str;
        if (context == null || TextUtils.isEmpty(str)) {
            return;
        }
        OpenSDKConfig.setLocalData(context, "imei", str);
    }

    public static void setOpenId(String str) {
        openId = str;
    }

    public static void setToken(String str) {
        token = str;
        if (context == null || TextUtils.isEmpty(str)) {
            return;
        }
        OpenSDKConfig.setLocalData(context, "token", str);
    }
}
