package com.miui.privacypolicy;

import android.content.Context;
import android.content.SharedPreferences;

/* JADX INFO: loaded from: classes17.dex */
public class SharePreferenceUtils {
    private static SharedPreferences mInstance;

    private SharePreferenceUtils() {
    }

    public static void clear(Context context) {
        SharedPreferences.Editor editorEdit = getInstance(context).edit();
        editorEdit.clear();
        editorEdit.commit();
    }

    public static boolean getBoolean(Context context, String str, boolean z) {
        return getInstance(context).getBoolean(str, z);
    }

    private static SharedPreferences getInstance(Context context) {
        if (mInstance == null) {
            mInstance = context.getSharedPreferences("privacy_sdk", 0);
        }
        return mInstance;
    }

    public static int getInt(Context context, String str, int i) {
        return getInstance(context).getInt(str, i);
    }

    public static long getLong(Context context, String str, long j) {
        return getInstance(context).getLong(str, j);
    }

    public static String getString(Context context, String str) {
        return getInstance(context).getString(str, "");
    }

    public static void putBoolean(Context context, String str, boolean z) {
        SharedPreferences.Editor editorEdit = getInstance(context).edit();
        editorEdit.putBoolean(str, z);
        editorEdit.commit();
    }

    public static void putInt(Context context, String str, int i) {
        SharedPreferences.Editor editorEdit = getInstance(context).edit();
        editorEdit.putInt(str, i);
        editorEdit.commit();
    }

    public static void putLong(Context context, String str, long j) {
        SharedPreferences.Editor editorEdit = getInstance(context).edit();
        editorEdit.putLong(str, j);
        editorEdit.commit();
    }

    public static void putString(Context context, String str, String str2) {
        SharedPreferences.Editor editorEdit = getInstance(context).edit();
        editorEdit.putString(str, str2);
        editorEdit.commit();
    }

    public static String getString(Context context, String str, String str2) {
        return getInstance(context).getString(str, str2);
    }
}
