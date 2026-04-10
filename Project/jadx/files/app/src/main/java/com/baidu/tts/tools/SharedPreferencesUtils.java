package com.baidu.tts.tools;

import android.content.Context;
import android.content.SharedPreferences;

/* JADX INFO: loaded from: classes2.dex */
public class SharedPreferencesUtils {
    public static String PREFERENCE_NAME = "AndroidTTS";

    private SharedPreferencesUtils() {
        throw new AssertionError();
    }

    public static boolean getBoolean(Context context, String str) {
        return getBoolean(context, str, false);
    }

    public static float getFloat(Context context, String str) {
        return getFloat(context, str, -1.0f);
    }

    public static int getInt(Context context, String str) {
        return getInt(context, str, -1);
    }

    public static long getLong(Context context, String str) {
        return getLong(context, str, -1L);
    }

    public static String getString(Context context, String str) {
        return getString(context, str, null);
    }

    public static boolean putBoolean(Context context, String str, boolean z2) {
        SharedPreferences.Editor editorEdit = context.getSharedPreferences(PREFERENCE_NAME, 0).edit();
        editorEdit.putBoolean(str, z2);
        return editorEdit.commit();
    }

    public static boolean putFloat(Context context, String str, float f2) {
        SharedPreferences.Editor editorEdit = context.getSharedPreferences(PREFERENCE_NAME, 0).edit();
        editorEdit.putFloat(str, f2);
        return editorEdit.commit();
    }

    public static boolean putInt(Context context, String str, int i2) {
        SharedPreferences.Editor editorEdit = context.getSharedPreferences(PREFERENCE_NAME, 0).edit();
        editorEdit.putInt(str, i2);
        return editorEdit.commit();
    }

    public static boolean putLong(Context context, String str, long j2) {
        SharedPreferences.Editor editorEdit = context.getSharedPreferences(PREFERENCE_NAME, 0).edit();
        editorEdit.putLong(str, j2);
        return editorEdit.commit();
    }

    public static boolean putString(Context context, String str, String str2) {
        SharedPreferences.Editor editorEdit = context.getSharedPreferences(PREFERENCE_NAME, 0).edit();
        editorEdit.putString(str, str2);
        return editorEdit.commit();
    }

    public static boolean getBoolean(Context context, String str, boolean z2) {
        return context.getSharedPreferences(PREFERENCE_NAME, 0).getBoolean(str, z2);
    }

    public static float getFloat(Context context, String str, float f2) {
        return context.getSharedPreferences(PREFERENCE_NAME, 0).getFloat(str, f2);
    }

    public static int getInt(Context context, String str, int i2) {
        return context.getSharedPreferences(PREFERENCE_NAME, 0).getInt(str, i2);
    }

    public static long getLong(Context context, String str, long j2) {
        return context.getSharedPreferences(PREFERENCE_NAME, 0).getLong(str, j2);
    }

    public static String getString(Context context, String str, String str2) {
        return context.getSharedPreferences(PREFERENCE_NAME, 0).getString(str, str2);
    }
}
