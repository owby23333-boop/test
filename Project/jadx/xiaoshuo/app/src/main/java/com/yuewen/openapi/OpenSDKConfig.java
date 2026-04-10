package com.yuewen.openapi;

import android.content.Context;
import android.content.SharedPreferences;

/* JADX INFO: loaded from: classes8.dex */
public class OpenSDKConfig {
    public static final String APP_FLAG = "app_flag";
    public static final String GUID = "guid";
    public static final String IMEI = "imei";
    public static final String LOCAL_SETTING = "LOCAL_SETTING";
    public static final String TOKEN = "token";

    public static void doCommit(SharedPreferences.Editor editor) {
        try {
            editor.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static String getLocalData(Context context, String str) {
        return context.getSharedPreferences(LOCAL_SETTING, 0).getString(str, "");
    }

    public static void setLocalData(Context context, String str, String str2) {
        doCommit(context.getSharedPreferences(LOCAL_SETTING, 0).edit().putString(str, str2));
    }
}
