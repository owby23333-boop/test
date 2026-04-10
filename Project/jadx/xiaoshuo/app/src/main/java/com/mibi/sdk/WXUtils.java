package com.mibi.sdk;

import android.content.Context;
import android.content.SharedPreferences;

/* JADX INFO: loaded from: classes.dex */
public class WXUtils {
    private static final String SHARED_PREFERENCE_NAME = "mibi_wxpay_shared_preference";

    public static void clearWXData(Context context) {
        context.getSharedPreferences(SHARED_PREFERENCE_NAME, 0).edit().clear().apply();
    }

    public static String getString(Context context, String str) {
        return context.getSharedPreferences(SHARED_PREFERENCE_NAME, 0).getString(str, "");
    }

    public static void putString(Context context, String str, String str2) {
        SharedPreferences.Editor editorEdit = context.getSharedPreferences(SHARED_PREFERENCE_NAME, 0).edit();
        editorEdit.putString(str, str2);
        editorEdit.apply();
    }

    public static void removeString(Context context, String str) {
        SharedPreferences.Editor editorEdit = context.getSharedPreferences(SHARED_PREFERENCE_NAME, 0).edit();
        editorEdit.remove(str);
        editorEdit.apply();
    }
}
